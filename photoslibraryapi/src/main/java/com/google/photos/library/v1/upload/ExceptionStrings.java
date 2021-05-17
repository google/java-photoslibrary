/*
 * Copyright 2018 Google LLC
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

final class ExceptionStrings {

  static final String INVALID_UPLOAD_RESULT =
      "The upload was completed but failed to finalize or get the result.";
  static final String INVALID_UPLOAD_STATUS = "Invalid upload status received.";
  static final String NOT_INITIALIZED = "The upload could not be initialized.";
  static final String UNKNOWN_ERROR = "The upload encountered an unknown error.";
  static final String UPLOAD_THREAD_INTERRUPTED = "Upload thread was interrupted.";
  static final String UPLOAD_URL_REJECTED =
      "The upload url is either finalized or rejected by the server.";
  static final String UPLOAD_TIMED_OUT = "The upload has timed out.";
  static final String INVALID_PROGRESS = "The upload progress could not be verified.";
}
