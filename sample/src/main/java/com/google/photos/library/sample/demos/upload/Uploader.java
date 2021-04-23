/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.photos.library.sample.demos.upload;

import com.google.photos.library.sample.demos.upload.tasks.ByteUploadTask;
import com.google.photos.library.sample.demos.upload.tasks.ItemCreationTask;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.types.proto.MediaItem;
import java.io.File;
import java.util.*;
import java.util.concurrent.*;

/**
 * Uploads files to the Google Photos Library API.
 *
 * <p>Given a set of {@link File}s, this class handles byte upload and media item creation using a
 * {@link PhotosLibraryClient}. The bytes of the media files are uploaded in parallel, using the
 * {@link #numByteUploadThreads}. Once the {@link #numCreationBatchSize} of successful byte uploads
 * has been reached, {@link PhotosLibraryClient#batchCreateMediaItems(List)} is used to create the
 * media. Note that this call is NOT made in parallel, as only one call to create media items should
 * be made at the same time for a user.
 */
public class Uploader implements AutoCloseable {

  /** Number of parallel threads to use when uploading image bytes. */
  private final int numByteUploadThreads;

  /**
   * Number of media items to include in a call to `mediaItems.batchCreate`. This must be not be
   * greater than 50. See
   * https://developers.google.com/photos/library/guides/upload-media#creating-media-item
   */
  private final int numCreationBatchSize;

  /** Number of parallel threads to use when uploading image bytes. */
  public static final int NUM_BYTE_UPLOAD_THREAD_DEFAULT = 6;

  /**
   * Number of media items to include in a call to `mediaItems.batchCreate`. This must be not be
   * greater than 50. See
   * https://developers.google.com/photos/library/guides/upload-media#creating-media-item
   */
  public static final int NUM_BATCH_SIZE_DEFAULT = 50;

  /** The API client used to make calls to the Google Photos Library API. */
  private final PhotosLibraryClient client;

  /** Executor that facilitates handling of the upload threads. */
  private final ExecutorService uploadExecutor;
  /** Service that manages the queue for upload tasks. */
  private final CompletionService<ByteUploadTask.ByteUploadResult> uploadService;

  /** Successful byte uploads, indexed by their upload token. */
  private HashMap<String, ByteUploadTask.ByteUploadResult> successfulUploads;

  /** Queue of successful uploads to be created next. */
  private final List<ByteUploadTask.ByteUploadResult> creationQueue;

  /** Failed byte uploads. */
  private final HashMap<File, ByteUploadTask.ByteUploadResult> failedUploads = new HashMap<>();

  /** Results of creating media items, indexed by the upload token for each item. */
  private HashMap<String, ItemCreationTask.ItemCreationResult> itemCreationResults;

  /**
   * Uploader that uploads media using the configured parallel byte upload thrads and batch size.
   *
   * @param client The Google Photos Library API client library client.
   * @param numByteUploadThreads The number of parallel byte upload threads to use.
   * @param numCreationBatchSize The number of media items to include in a call to
   *     'mediaItems.batchCreate'. Can be at most 50.
   */
  public Uploader(PhotosLibraryClient client, int numByteUploadThreads, int numCreationBatchSize) {
    this.client = client;
    this.numByteUploadThreads = numByteUploadThreads;
    this.numCreationBatchSize = numCreationBatchSize;
    this.creationQueue = new ArrayList<>(numCreationBatchSize);

    // Set up the threading and executors for byte uploads.
    // Using a fixed number of threads to upload bytes in parallel. Note that this should be
    // adjusted for your own
    // circumstances.
    uploadExecutor = Executors.newFixedThreadPool(this.numByteUploadThreads);
    uploadService = new ExecutorCompletionService<>(uploadExecutor);
  }

  /**
   * Uploader that uploads media using the default options for the number of byte upload threads and
   * batch size. Note that this object must be closed after completion of all calls.
   *
   * @param client The Google Photos Library API client library client.
   * @see #NUM_BYTE_UPLOAD_THREAD_DEFAULT
   * @see #NUM_BATCH_SIZE_DEFAULT
   */
  public Uploader(PhotosLibraryClient client) {
    this(client, NUM_BYTE_UPLOAD_THREAD_DEFAULT, NUM_BATCH_SIZE_DEFAULT);
  }

  /** Shut down the executors and its threads. */
  @Override
  public void close() {
    // Shutdown the executors
    if (uploadExecutor != null) {
      uploadExecutor.shutdown();
    }
  }

  /**
   * Upload files to Google Photos using the Google Photos Library API.
   *
   * <p>Uses {@link ByteUploadTask} (which uses {@link
   * PhotosLibraryClient#uploadMediaItem(UploadMediaItemRequest)}) to upload the bytes of the given
   * files. Then, it uses {@link ItemCreationTask} to create the media items (which uses {@link
   * PhotosLibraryClient#batchCreateMediaItems(List)}).
   *
   * @param files Files to upload.
   */
  public void uploadFiles(File[] files) throws InterruptedException, ExecutionException {
    if (client == null) {
      System.err.println("Client was not initialized.");
      return;
    }

    successfulUploads = new HashMap<>(files.length);
    itemCreationResults = new HashMap<>(files.length);

    // Schedule and start the uploading of files. This method schedules their execution in the
    // uploadService using the number of threads configured.
    scheduleUploadFileBytes(files);

    System.out.println("All byte uploads tasks have been scheduled.");

    /*
    Loop and wait for tasks to complete on the uploadService, one at a time.
    Once enough uploads have completed, ie. the number of upload tokens matches the configured item
    creation batch size, call the Library API to create the media items.

    Note that calls to create media items are *NOT* done in parallel!
    Creation of media items *MUST* only be done sequentially for each user!

    You should never call `mediaItems.batchCreate` in parallel for the same user, always wait
    until the previous call to create media items for a user has completed before making the next
    call. (It can be called in parallel for different users.)
     */
    for (int finishedResults = 0; finishedResults < files.length; finishedResults++) {
      // Wait until a task is completed and get its result.
      Future<ByteUploadTask.ByteUploadResult> futureResult = uploadService.take();
      ByteUploadTask.ByteUploadResult byteResult = futureResult.get();

      if (byteResult.isOk()) {
        // The bytes were successfully uploaded and an upload token is available.
        successfulUploads.put(byteResult.uploadToken, byteResult);

        // Add it to the queue for the next call to create media items.
        creationQueue.add(byteResult);

      } else {
        // The byte upload failed, collect its result and deal with the error later.
        failedUploads.put(byteResult.file, byteResult);
      }

      // If enough tasks have completed so that a batch is full (or this was the final upload),
      // submit the upload tokens to create media items.
      if (creationQueue.size() >= numCreationBatchSize
          || successfulUploads.size() + failedUploads.size() >= files.length) {

        System.out.println("Starting batch creation call.");

        createMediaItems();
      }
    }

    System.out.println("Execution complete.");
  }

  /**
   * Use an {@link ItemCreationTask} to call the Library API to creat media items from the internal
   * queue.
   */
  private void createMediaItems() {
    if (creationQueue.isEmpty()) {
      // No items in the queue to be created. All byte uploads may have failed.
      System.err.println("No items to create.");
      return;
    }
    // Empty the queue and get the items to be created.
    List<ByteUploadTask.ByteUploadResult> itemsToCreate = new ArrayList<>(creationQueue);
    creationQueue.clear();

    // Make the API call to `mediaItems.batchCreate`. This method returns the status of each
    // item.
    // Important: Note how this call is made sequentially, blocking further execution until it
    // completes.
    // Execution of this task is not scheduled in a separate thread, instead it is done here
    // on the main thread blocking further execution until it completes.

    Map<String, ItemCreationTask.ItemCreationResult> creationResult =
        new ItemCreationTask(client, itemsToCreate).call();

    // Store all results for later processing.
    itemCreationResults.putAll(creationResult);
  }

  /**
   * Use a {@link ByteUploadTask} to call the Library API to upload media items. All API calls are
   * scheduled here using the {@link #uploadService}.
   *
   * @param files Files to upload.
   * @see CompletionService#submit(Callable)
   */
  private void scheduleUploadFileBytes(File[] files) {
    // Queue all files for upload. The ByteUploadTask uploads the bytes of the file to the Library
    // API.
    // Note that the ExecutorService handles execution of threads, here they are queued up for
    // processing.
    // These tasks are executed in parallel, based on the thread pool configured above.
    // The Library API supports parallel byte uploads for the same user.
    for (File f : files) {
      System.out.println("Scheduling byte upload for: " + f.getName());
      // Initialise a new upload tasks and schedule it for execution.
      ByteUploadTask task = new ByteUploadTask(client, f);
      uploadService.submit(task);
    }
  }

  /**
   * Prints the status of the Uploader, including all failed and successful uploads and media item
   * creations.
   */
  public void printState() {
    // Print the failed byte uploads
    System.out.println("The following " + failedUploads.size() + " files could not be uploaded:");
    for (ByteUploadTask.ByteUploadResult uploadResult : failedUploads.values()) {
      // Print the error that lead to this failure.
      //  If it was an ApiException there may be some additional details that could be examined
      // before retrying it as
      //  needed. Here it is just printed out.
      print(uploadResult.file, uploadResult.error.toString());
    }

    // Print the successful media item creations and extract ones that failed.
    System.out.println("The following items were successfully created:");
    // Check the status of each item creation, keep track of all failed creations for retry.
    List<ItemCreationTask.ItemCreationResult> failedCreations = new LinkedList<>();
    for (Map.Entry<String, ItemCreationTask.ItemCreationResult> entry :
        itemCreationResults.entrySet()) {
      ItemCreationTask.ItemCreationResult value = entry.getValue();
      if (value.isOk()) {
        // The item was successfully created. Print out its details.
        MediaItem item = value.mediaItem.get();
        print(entry.getKey(), item.getProductUrl());
      } else {
        // The item could not be created. Keep track of it.
        failedCreations.add(value);
      }
    }

    // Print the failed media item creations. If possible, print some additional details if the API
    // returned an error.
    System.out.println("The following " + failedCreations.size() + " files could not be created:");
    for (ItemCreationTask.ItemCreationResult result : failedCreations) {
      // The file was successfully uploaded in the first step. Look up its File definition by the
      // upload token
      File file = successfulUploads.get(result.uploadToken).file;

      if (result.status.isPresent()) {
        // The API returned a status that contains some information about the error.
        // Here it is just printed out.
        print(file, result.status.get().toString());
      } else {
        // Print details about the Throwable that caused this error. If it was an ApiException there
        // may be some additional details that could be examined before retrying it as needed.
        // Here it is just printed out.
        print(file, result.error.toString());
      }
    }
  }

  /**
   * Print a message to {@link System#out}, prefixed by the file name.
   *
   * @param file Name of this file is used as a prefix for the message.
   * @param message Message to print out.
   */
  private static void print(File file, String message) {
    print(file.getName(), message);
  }

  /**
   * Print a message to {@link System#out}, prefixed by a string.
   *
   * @param prefix Prefix printed before the message.
   * @param message Message to print out.
   */
  private static void print(String prefix, String message) {
    System.out.println("\t" + prefix + ": " + message);
  }
}
