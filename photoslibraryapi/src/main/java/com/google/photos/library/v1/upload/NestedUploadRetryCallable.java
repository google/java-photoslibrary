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

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;

/**
 * Manages retries and calls to a Callable that uploads bytes.
 *
 * <p>Each individual call to {@link #futureCall(UploadMediaItemRequest, ApiCallContext)} is wrapped
 * in a {@link UploadRetryCallable} that handles retries and resumes of in-progress upload requests.
 *
 * <p>Package-private for internal use.
 */
final class NestedUploadRetryCallable
    extends UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> {
  private final UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> uploadCallable;
  private final ClientContext clientContext;
  private final UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> settings;

  /**
   * Callable that wraps the given callable in an {@link UploadRetryCallable} and calls it when
   * called.
   *
   * @param uploadCallable A callable (e.g. {@link PhotosLibraryUploadCallable}) that uploads bytes
   *     to the Photos Library API.
   * @param settings Settings for the upload call, in particular its retry configuration.
   * @param clientContext Context for calls.
   */
  public NestedUploadRetryCallable(
      UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> uploadCallable,
      UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> settings,
      ClientContext clientContext) {
    this.uploadCallable = uploadCallable;
    this.clientContext = clientContext;
    this.settings = settings;
  }

  /**
   * Calls the wrapped callable asynchronously.
   *
   * <p>Calls are retried per the retry configuration configured in the {@link UnaryCallSettings}
   * given when this object was created. Retries are handled through {@link UploadRetryCallable}.
   */
  @Override
  public ApiFuture<UploadMediaItemResponse> futureCall(
      UploadMediaItemRequest request, ApiCallContext context) {

    // Pass the callable through a callable that maps errors to
    // APIExceptions and updates any requests if they can be resumed.
    UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> callable =
        new UploadRetryCallable(uploadCallable, clientContext);

    callable = Callables.retrying(callable, settings, clientContext);
    callable = callable.withDefaultCallContext(clientContext.getDefaultCallContext());

    return callable.futureCall(request, context);
  }
}
