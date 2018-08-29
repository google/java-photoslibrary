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

import com.google.api.gax.rpc.ApiException;
import java.util.Optional;

/** Represents an upload response. */
public final class UploadMediaItemResponse {
  /** Represents an error while uploading the media item. */
  public static final class Error {
    private final Optional<String> resumeUrl;
    private final ApiException cause;

    private Error(Optional<String> resumeUrl, ApiException cause) {
      this.resumeUrl = resumeUrl;
      this.cause = cause;
    }

    /** Url to retry the upload. */
    public Optional<String> getResumeUrl() {
      return resumeUrl;
    }

    /** Cause of the error. */
    public Throwable getCause() {
      return cause;
    }

    public static final Builder newBuilder() {
      return new Builder();
    }

    /** Builder for {@link Error}. */
    public static final class Builder {
      private Optional<String> resumeUrl;
      private ApiException cause;

      private Builder() {
        resumeUrl = Optional.empty();
      }

      public Builder setResumeUrl(Optional<String> resumeUrl) {
        this.resumeUrl = resumeUrl;
        return this;
      }

      public Builder setCause(ApiException cause) {
        this.cause = cause;
        return this;
      }

      public Error build() {
        return new Error(resumeUrl, cause);
      }
    }
  }

  private final Optional<String> uploadToken;
  private final Optional<Error> error;

  private UploadMediaItemResponse(Optional<String> uploadToken, Optional<Error> error) {
    this.uploadToken = uploadToken;
    this.error = error;
  }

  /** Upload token in case of success. */
  public Optional<String> getUploadToken() {
    return uploadToken;
  }

  /** Error in case of failure. */
  public Optional<Error> getError() {
    return error;
  }

  public static final Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@link UploadMediaItemResponse}. */
  public static final class Builder {

    private Optional<String> uploadToken;
    private Optional<Error> error;

    private Builder() {}

    public Builder setUploadToken(String uploadToken) {
      this.uploadToken = Optional.of(uploadToken);
      this.error = Optional.empty();
      return this;
    }

    public Builder setError(Error error) {
      this.error = Optional.of(error);
      this.uploadToken = Optional.empty();
      return this;
    }

    public UploadMediaItemResponse build() {
      return new UploadMediaItemResponse(uploadToken, error);
    }
  }
}
