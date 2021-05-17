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
import com.google.common.collect.ImmutableSet;
import io.grpc.Status.Code;
import io.grpc.internal.GrpcUtil;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.apache.http.client.HttpResponseException;

/** Maps a {@link Throwable} to an {@link UploadApiException} or an {@link ApiException}. */
final class PhotosLibraryUploadExceptionMappingFn
    implements ApiFunction<Throwable, UploadMediaItemResponse> {

  private final AtomicReference<String> atomicResumeUrl;
  private final ImmutableSet<StatusCode.Code> retryableCodes;

  PhotosLibraryUploadExceptionMappingFn(
      Set<StatusCode.Code> retryCodes, AtomicReference<String> atomicResumeUrl) {
    this.atomicResumeUrl = atomicResumeUrl;
    this.retryableCodes = ImmutableSet.copyOf(retryCodes);
  }

  @Nullable
  @Override
  public UploadMediaItemResponse apply(@Nullable Throwable input) {
    Optional<String> resumeUrl = Optional.ofNullable(atomicResumeUrl.get());
    StatusCode statusCode = getStatusCode(input);

    boolean canRetry = retryableCodes.contains(statusCode.getCode());

    if (resumeUrl.isPresent()) {
      throw new UploadApiException(input, statusCode, canRetry, resumeUrl.get());
    } else {
      throw new ApiException(input, statusCode, canRetry);
    }
  }

  public static StatusCode getStatusCode(@Nullable Throwable input) {
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
        // Include a specific mapping for some codes that have special meaning for the upload
        // endpoint, otherwise fall back to the default HTTP/GRPC code mapping.
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
      case 429:
        return GrpcStatusCode.of(Code.RESOURCE_EXHAUSTED);
      default:
        return GrpcStatusCode.of(GrpcUtil.httpStatusToGrpcStatus(httpCode).getCode());
    }
  }
}
