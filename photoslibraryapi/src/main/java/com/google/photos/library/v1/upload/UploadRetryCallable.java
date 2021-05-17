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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;

/**
 * Wraps a {@link UnaryCallable} that uploads data using {@link UploadMediaItemRequest} and {@link
 * UploadMediaItemResponse}. If the wrapped callable fails with an {@link UploadApiException} that
 * contains a resume URL, the URL is stored. If a {@link UploadMediaItemRequest} is made again, the
 * stored URL is injected into the request before it is passed to the callable.
 *
 * <p>An instance of this class can only be used for the same UploadMediaItemRequest. It should
 * never be called for different UploadMediaItemRequests.
 *
 * <p>Package-private for internal use.
 */
final class UploadRetryCallable
    extends UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> {
  private final UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> callable;
  private final ClientContext clientContext;
  private String resumeUrl = null;

  private UploadMediaItemRequest initialRequest = null;

  /**
   * Callable that calls the given callable when it is called.
   *
   * @param callable A callable (e.g. {@link PhotosLibraryUploadCallable}) that uploads bytes to the
   *     Photos Library API.
   * @param clientContext Context for calls.
   */
  public UploadRetryCallable(
      UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> callable,
      ClientContext clientContext) {
    this.callable = callable;
    this.clientContext = clientContext;
  }

  /**
   * Calls the wrapped callable asynchronously.
   *
   * <p>If it was called previously (and a previous execution threw an {@link UploadApiException}
   * that contained a resume URL), then the upload URL specified in the {@link
   * UploadMediaItemRequest} is overridden.
   *
   * @param request Upload request for byte uploads.
   * @param context Context for the API call.
   * @return Future that contains the result of this call.
   */
  @Override
  public ApiFuture<UploadMediaItemResponse> futureCall(
      UploadMediaItemRequest request, ApiCallContext context) {
    if (initialRequest == null) {
      initialRequest = request;
    }

    if (!initialRequest.equals(request)) {
      throw new IllegalArgumentException("Cannot retry different UploadRequests.");
    }

    if (resumeUrl != null) {
      // This call has been made previously, set the resume URL if captured previously.
      request =
          UploadMediaItemRequest.newBuilder().mergeFrom(request).setUploadUrl(resumeUrl).build();
    }

    // Intercept all UploadApiExceptions that are thrown and capture its resume URL.
    return ApiFutures.catching(
        callable.futureCall(request, context),
        UploadApiException.class,
        new UploadRequestFailureInterceptor(),
        clientContext.getExecutor());
  }

  /** Interceptor that for {@link UploadApiException}s that extracts its resume URL. */
  private class UploadRequestFailureInterceptor
      implements ApiFunction<UploadApiException, UploadMediaItemResponse> {

    @Override
    public UploadMediaItemResponse apply(UploadApiException input) {
      resumeUrl = input.getResumeUrl();
      throw input;
    }
  }
}
