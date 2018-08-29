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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.Status.Code;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.apache.http.client.HttpResponseException;

final class PhotosLibraryUploadExceptionMappingFn
    implements ApiFunction<Throwable, UploadMediaItemResponse> {

  private final AtomicReference<String> atomicResumeUrl;

  PhotosLibraryUploadExceptionMappingFn(AtomicReference<String> atomicResumeUrl) {
    this.atomicResumeUrl = atomicResumeUrl;
  }

  @Nullable
  @Override
  public UploadMediaItemResponse apply(@Nullable Throwable input) {
    Optional<String> resumeUrl = Optional.ofNullable(atomicResumeUrl.get());
    return UploadMediaItemResponse.newBuilder()
        .setError(
            UploadMediaItemResponse.Error.newBuilder()
                .setResumeUrl(resumeUrl)
                .setCause(
                    new ApiException(
                        input, getStatusCode(input), resumeUrl.isPresent() /* retryable */))
                .build())
        .build();
  }

  private static StatusCode getStatusCode(@Nullable Throwable input) {
    if (input == null) {
      return GrpcStatusCode.of(Code.UNKNOWN);
    } else if (input instanceof HttpResponseException) {
      HttpResponseException httpResponseException = (HttpResponseException) input;
      return httpCodeToStatusCode(httpResponseException.getStatusCode());
    } else {
      return GrpcStatusCode.of(Code.INVALID_ARGUMENT);
    }
  }

  private static StatusCode httpCodeToStatusCode(int httpCode) {
    switch (httpCode) {
      case 200:
        return GrpcStatusCode.of(Code.OK);
      case 409:
        return GrpcStatusCode.of(Code.ABORTED);
      case 503:
        return GrpcStatusCode.of(Code.UNAVAILABLE);
      case 400:
        return GrpcStatusCode.of(Code.INVALID_ARGUMENT);
      case 412:
        return GrpcStatusCode.of(Code.FAILED_PRECONDITION);
      case 413:
        return GrpcStatusCode.of(Code.OUT_OF_RANGE);
      case 500:
        return GrpcStatusCode.of(Code.INTERNAL);
      default:
        return GrpcStatusCode.of(Code.UNKNOWN);
    }
  }
}
