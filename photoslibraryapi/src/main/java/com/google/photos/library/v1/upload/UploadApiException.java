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

package com.google.photos.library.v1.upload;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;

/**
 * Exception that occurred during byte uploads. Includes a URL to resume this upload.
 *
 * <p>This type of {@link ApiException} contains an optional resume URL from which an in-progress
 * upload can be resumed.
 *
 * @see PhotosLibraryUploadCallable
 */
public class UploadApiException extends ApiException {

  /** Resume URL from which an in-progress upload can be resumed. */
  private final String resumeUrl;

  /**
   * Exception that occurred during an upload that includes a URL to resume the upload.
   *
   * @param cause The cause of this exception.
   * @param statusCode StatusCode that describes the underlying error.
   * @param retryable Whether the request can be retried.
   * @param resumeUrl The URL to use to resume the failed upload.
   */
  public UploadApiException(
      Throwable cause, StatusCode statusCode, boolean retryable, String resumeUrl) {
    super(cause, statusCode, retryable);
    this.resumeUrl = resumeUrl;
  }

  /**
   * Exception that occurred during an upload that includes a resume URL to resume the upload.
   *
   * @param message The detail message that describes this error.
   * @param cause The cause of this exception.
   * @param statusCode StatusCode that describes the underlying error.
   * @param retryable Whether the request can be retried.
   * @param resumeUrl The URL to use to resume the failed upload.
   */
  public UploadApiException(
      String message, Throwable cause, StatusCode statusCode, boolean retryable, String resumeUrl) {
    super(message, cause, statusCode, retryable);
    this.resumeUrl = resumeUrl;
  }

  /**
   * The resume URL from which the in-progress upload can be resumed.
   *
   * <p>This URL can be set for an {@link UploadMediaItemRequest} in {@link
   * UploadMediaItemRequest.Builder#setUploadUrl(String)}.
   */
  public String getResumeUrl() {
    return resumeUrl;
  }
}
