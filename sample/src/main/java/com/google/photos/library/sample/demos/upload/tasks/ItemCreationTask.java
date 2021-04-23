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

package com.google.photos.library.sample.demos.upload.tasks;

import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.proto.NewMediaItemResult;
import com.google.photos.library.v1.util.NewMediaItemFactory;
import com.google.photos.types.proto.MediaItem;
import com.google.rpc.Code;
import com.google.rpc.Status;
import java.util.*;
import java.util.concurrent.Callable;
import javax.annotation.Nonnull;

/**
 * Creates media items in the user's Google Photos library.
 *
 * <p>This task calls {@link PhotosLibraryClient#batchCreateMediaItems(List)} to create media items
 * in the user's library. <b>IMPORTANT:</b> This task should never be called in parallel for the
 * same user to avoid concurrency issues. Only call this task serially (one after another) for the
 * same user. It may be called in parallel for different users. Results are returned as a {@link
 * Map} that matches upload tokens (given as the input) to an instance of {@link
 * ItemCreationResult}, which contains a {@link MediaItem} if the item was successfully created.
 */
public class ItemCreationTask
    implements Callable<Map<String, ItemCreationTask.ItemCreationResult>> {

  /** Items to be created. */
  private final List<ByteUploadTask.ByteUploadResult> itemsToCreate;

  /** API client to use for media creation. */
  private final PhotosLibraryClient photosLibraryClient;

  /** Items to create in this call to batchCreate. */
  private final List<NewMediaItem> newItems = new LinkedList<>();

  /**
   * An {@link ItemCreationTask} calls {@link PhotosLibraryClient#batchCreateMediaItems(List)} with
   * a list of {@link NewMediaItem}s. Each {@link NewMediaItem} requires an upload token, file name
   * and description which is read from the {@link
   * com.google.photos.library.sample.demos.upload.tasks.ByteUploadTask}. The description is set to
   * the current date and time.
   *
   * @param photosLibraryClient API client for media creation.
   * @param itemsToCreate The successful byte uploads to be created as media items.
   */
  public ItemCreationTask(
      PhotosLibraryClient photosLibraryClient,
      List<ByteUploadTask.ByteUploadResult> itemsToCreate) {
    this.itemsToCreate = itemsToCreate;
    this.photosLibraryClient = photosLibraryClient;
  }

  /**
   * Creates media items.
   *
   * <p>Calls mediaItems.batchCreate from the Library API. This creates media items for the upload
   * results. Returns a list of all Files that could not be created. If the entire API call failed,
   * all items are returned as failed.
   *
   * <p>Returns a {@link Map} that maps the upload token (as included in the {@link
   * com.google.photos.library.sample.demos.upload.tasks.ByteUploadTask}) to a result. This mapping
   * is needed as the API call to {@link PhotosLibraryClient#batchCreateMediaItems(List)} may have
   * been partially successful, so the caller must verify each media item individually.
   *
   * @return Status for each item created.
   */
  public Map<String, ItemCreationResult> call() {
    System.out.println("Calling API to create items: " + itemsToCreate.size());

    // Keep track of the result for each media item creation. Some items could fail to be created
    // during a call, while others may be successful.
    Map<String, ItemCreationResult> results = new HashMap<>(itemsToCreate.size());

    if (itemsToCreate.isEmpty()) {
      // No items to create.
      throw new IllegalArgumentException("No items to create.");
    }

    // For each UploadResult, create a NewMediaItem with the following components:
    // - uploadToken obtained from the byte upload request
    // - filename that will be shown to the user in Google Photos
    // - description that will be shown to the user in Google Photos
    for (ByteUploadTask.ByteUploadResult byteUploadResult : itemsToCreate) {
      NewMediaItem newMediaItem =
          NewMediaItemFactory.createNewMediaItem(
              byteUploadResult.uploadToken,
              /* fileName= */ byteUploadResult.file.getName(),
              /* description=*/ "Created at " + new Date());
      newItems.add(newMediaItem);
    }

    try {
      System.out.println("Calling batchCreate for new items: " + newItems.size());

      // Call the API to create media items.
      BatchCreateMediaItemsResponse response = photosLibraryClient.batchCreateMediaItems(newItems);

      // Confirm that all items where created successfully. Some items may have failed.
      for (NewMediaItemResult itemsResponse : response.getNewMediaItemResultsList()) {
        Status status = itemsResponse.getStatus();
        if (status.getCode() == Code.OK_VALUE) {
          // The item was successfully created in the user's library.
          MediaItem createdItem = itemsResponse.getMediaItem();
          System.out.println("Item created: " + createdItem.getFilename());
          results.put(
              itemsResponse.getUploadToken(),
              ItemCreationResult.createSuccessResult(
                  itemsResponse.getUploadToken(), status, itemsResponse.getMediaItem()));
        } else {
          // The item could not be created.
          System.err.println("Item not created. " + status.getMessage());

          // Keep track of the failed item and its status.
          results.put(
              itemsResponse.getUploadToken(),
              ItemCreationResult.createFailureResultWithStatus(
                  itemsResponse.getUploadToken(), status));
        }
      }

      // Confirm that a status was returned for all upload tokens, otherwise mark the missing ones
      // as failed.
      if (response.getNewMediaItemResultsCount() != itemsToCreate.size()) {
        for (ByteUploadTask.ByteUploadResult upload : itemsToCreate) {
          if (!results.containsKey(upload.uploadToken)) {
            // The item is missing. Create a com.google.grpc.Status with a generic exception.

            results.put(
                upload.uploadToken,
                ItemCreationResult.createFailureResultWithThrowable(
                    upload.uploadToken, new Exception("Upload token was not returned.")));
          }
        }
      }

    } catch (Exception exception) {
      // An error occurred while creating the media items and the entire request failed.
      // The client library would have already attempted to retry the request based on the retry
      // configuration. At this point, the request may not be automatically retryable and should be
      // handled by the application.
      // If this exception is of type APIException You can verify this by checking the status, its
      // code and whether it is retryable. See the documentation for Status for details.
      System.out.println("API error while calling createMediaItems. " + exception.getMessage());
      exception.printStackTrace();
      // Mark all items that were in this request as failed.
      for (ByteUploadTask.ByteUploadResult byteUploadResult : itemsToCreate) {
        results.put(
            byteUploadResult.uploadToken,
            ItemCreationResult.createFailureResultWithThrowable(
                byteUploadResult.uploadToken, exception));
      }
    }

    return results;
  }

  /**
   * Result of an {@link ItemCreationTask}. Successful results include a {@link MediaItem} and an OK
   * {@link Status}. Failed results either include a {@link Throwable} or a {@link Status} with a
   * failed code.
   */
  public static class ItemCreationResult {
    /** Upload token this result is for. */
    public final String uploadToken;
    /** {@link MediaItem} if returned from the API call. */
    public final Optional<MediaItem> mediaItem;
    /** {@link Throwable} that describes a failure if it occurred. May be null if not set. */
    public final Optional<Throwable> error;
    /**
     * {@link Status} that describes success or failure if it was returned from the API call. May be
     * null if not set.
     */
    public final Optional<Status> status;

    /**
     * Result of a call to create an item, consists of an upload token and optionally an error,
     * status and the media item that was created.
     *
     * @param uploadToken Upload token for this result.
     * @param error Optional error as a {@link Throwable}.
     * @param status Optional status as returned from the API.
     * @param mediaItem Optional media item as returned from the API.
     */
    private ItemCreationResult(
        String uploadToken, Throwable error, Status status, MediaItem mediaItem) {
      this.uploadToken = uploadToken;
      this.mediaItem = Optional.ofNullable(mediaItem);
      this.error = Optional.ofNullable(error);
      this.status = Optional.ofNullable(status);
    }

    /**
     * Task was successful if there is a media item, a successful status and no error.
     *
     * @return True if the task was successful
     */
    public boolean isOk() {
      return mediaItem.isPresent()
          && !error.isPresent()
          && status.isPresent()
          && status.get().getCode() == Code.OK_VALUE;
    }

    @Override
    public String toString() {
      return String.format(
          "ItemCreationResult{uploadToken=%s, mediaItem=%s, error=%s, status=%s}",
          uploadToken, mediaItem, error, status);
    }

    /**
     * Successful result of an item creation call to the API. Includes the status and the media item
     * as returned from the API.
     *
     * @param uploadToken Upload token for this result.
     * @param status Status as returned from the API.
     * @param mediaItem Media item as returned from the API.
     */
    public static ItemCreationResult createSuccessResult(
        String uploadToken, @Nonnull Status status, MediaItem mediaItem) {
      return new ItemCreationResult(uploadToken, null, status, mediaItem);
    }

    /**
     * Failed result of an item creation call to the API. Includes the {@link Throwable} that was
     * thrown during the API call.
     *
     * @param uploadToken Upload token for this result.
     * @param error {@link Throwable} that occurred during the call to the API.
     */
    public static ItemCreationResult createFailureResultWithThrowable(
        String uploadToken, Throwable error) {
      return new ItemCreationResult(uploadToken, error, null, null);
    }

    /**
     * Failed result of an item creation call to the API. Includes the {@link Status} field as
     * returned by the API.
     *
     * @param uploadToken Upload token for this result.
     * @param status Status as returned from the API.
     */
    public static ItemCreationResult createFailureResultWithStatus(
        String uploadToken, Status status) {
      return new ItemCreationResult(uploadToken, null, status, null);
    }
  }
}
