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
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import com.google.rpc.Status;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.util.concurrent.Callable;

/**
 * Uploads media bytes to Google Photos using the Google Photos Library API client.
 *
 * <p>This task calls {@link PhotosLibraryClient#uploadMediaItem(UploadMediaItemRequest)} to upload
 * a {@link File}.
 *
 * <p>Results are returned as an instance of {@link ByteUploadResult}, containing a {@link Status}
 * indicating success or failure of the upload.
 */
public class ByteUploadTask implements Callable<ByteUploadTask.ByteUploadResult> {

  /**
   * Chunk size for upload requests. You may wish to adjust the default value used by the client
   * library if you are working on a stable or fast connection and or if you are uploading large
   * files. The chunk size here is used as a guide by the library, it is automatically adjusted to
   * be a multiple on the required chunk size (as required by the Library API) when set in the
   * {@link UploadMediaItemRequest}.
   */
  private static final int CHUNK_SIZE = 1024 * 1024 * 30; // 30 MB

  /** API client to use for the upload. */
  private final PhotosLibraryClient photosLibraryClient;

  private final File fileToUpload;

  /**
   * Callable that uploads a {@link File} to Google Photos using the {@link PhotosLibraryClient}.
   *
   * @param client API client to use for the upload.
   * @param fileToUpload The file to upload.
   */
  public ByteUploadTask(PhotosLibraryClient client, File fileToUpload) {
    this.photosLibraryClient = client;
    this.fileToUpload = fileToUpload;
  }

  /**
   * Returns the file that is being uploaded.
   *
   * @return File being uploaded.
   */
  public File getFileToUpload() {
    return fileToUpload;
  }

  /**
   * Uploads the media.
   *
   * <p>Returns a {@link ByteUploadResult} that indicates success or failure.
   *
   * @return Result of the API call to upload media bytes.
   */
  @Override
  public ByteUploadResult call() {
    // Get the mimetype of the file
    final String mimeType = URLConnection.guessContentTypeFromName(fileToUpload.getName());

    // Automatically close the file after upload
    try (RandomAccessFile raf = new RandomAccessFile(fileToUpload, "r")) {
      /*
       * Create a new upload request consisting of a reference to the file, its media type
       * (e.g. "image/png") and a preferred chunk size.
       * The client library will attempt to split up the file into chunks of this size and upload
       * them one at a time. Set this to a value that makes sense for your implementation, based on
       * your environment. For example, raise the chunk size for stable, faster connections where
       * large files are uploaded. Lower this value for slower, unstable connections. If a chunk
       * fails to upload it is automatically retried.
       */
      UploadMediaItemRequest uploadRequest =
          UploadMediaItemRequest.newBuilder()
              .setDataFile(raf)
              .setMimeType(mimeType)
              .setChunkSize(CHUNK_SIZE)
              .build();

      // Upload the bytes and capture the response from the API.
      UploadMediaItemResponse uploadResponse = photosLibraryClient.uploadMediaItem(uploadRequest);

      if (uploadResponse.getUploadToken().isPresent() && uploadResponse.getError().isEmpty()) {
        // The upload was successful, because an upload token is present and there was no error.
        final String uploadToken = uploadResponse.getUploadToken().get();
        return ByteUploadResult.createSuccessResult(fileToUpload, uploadToken);
      }

      if (uploadResponse.getError().isPresent()) {
        // If the response contains an error, return its cause.
        Throwable cause = uploadResponse.getError().get().getCause();
        return ByteUploadResult.createFailureResultWithThrowable(fileToUpload, cause);
      }

      // No error returned, but the upload did not complete and no upload token was returned.
      // Return an unknown error.
      return ByteUploadResult.createFailureResultWithThrowable(
          fileToUpload, new Exception("Unknown error."));

    } catch (Exception exception) {
      // The upload could not be completed.
      return ByteUploadResult.createFailureResultWithThrowable(fileToUpload, exception);
    }
  }

  /** Result of a {@link ByteUploadTask}. */
  public static class ByteUploadResult {

    /** File this result is for. */
    public final File file;
    /** Upload token returned from the API, or empty if not set. */
    public final String uploadToken;
    /** Error that occurred during upload. */
    public final Throwable error;

    private ByteUploadResult(File file, Throwable error, String uploadToken) {
      this.file = file;
      this.uploadToken = uploadToken;
      this.error = error;
    }
    /**
     * Whether the upload was successful. A successful upload result contains an upload token and no
     * error.
     *
     * @return True if this is a successful upload result.
     */
    public boolean isOk() {
      return !uploadToken.isEmpty() && error == null;
    }
    /**
     * Result of a {@link ByteUploadTask} that contains a file and upload token as returned from the
     * API call.
     *
     * @param file File that was uploaded.
     * @param uploadToken Upload token as returned from the API.
     */
    public static ByteUploadResult createSuccessResult(File file, String uploadToken) {
      return new ByteUploadResult(file, null, uploadToken);
    }

    /**
     * Result of a {@link ByteUploadTask} that contains a file and a throwable that occurred during
     * upload.
     *
     * @param file File that was uploaded.
     * @param error Error that occurred during upload.
     */
    public static ByteUploadResult createFailureResultWithThrowable(File file, Throwable error) {
      return new ByteUploadResult(file, error, "");
    }
  }
}
