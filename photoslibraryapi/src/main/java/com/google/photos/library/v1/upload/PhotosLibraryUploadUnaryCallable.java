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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class PhotosLibraryUploadUnaryCallable
    extends UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> {

  private final ClientContext clientContext;
  private final PhotosLibrarySettings photosLibrarySettings;

  PhotosLibraryUploadUnaryCallable(
      ClientContext clientContext, PhotosLibrarySettings photosLibrarySettings) {
    this.clientContext = clientContext;
    this.photosLibrarySettings = photosLibrarySettings;
  }

  @Override
  public ApiFuture<UploadMediaItemResponse> futureCall(
      UploadMediaItemRequest request, ApiCallContext unusedContext) {
    PhotosLibraryUploadCallable uploadCallable =
        new PhotosLibraryUploadCallable(request, clientContext, photosLibrarySettings);
    // Catches exception thrown while uploading, transforms it into a response
    // and adds a resumeUrl if exists.
    return ApiFutures.catching(
        PhotosLibraryUploadApiFuture.create(uploadCallable, clientContext),
        Throwable.class,
        new PhotosLibraryUploadExceptionMappingFn(uploadCallable.getAtomicResumeUrl()));
  }

  private static final class PhotosLibraryUploadApiFuture
      implements ApiFuture<UploadMediaItemResponse> {

    private final ListenableFutureTask<UploadMediaItemResponse> futureTask;

    private PhotosLibraryUploadApiFuture(ListenableFutureTask<UploadMediaItemResponse> futureTask) {
      this.futureTask = futureTask;
    }

    public static final PhotosLibraryUploadApiFuture create(
        PhotosLibraryUploadCallable uploadCallable, ClientContext clientContext) {
      PhotosLibraryUploadApiFuture future =
          new PhotosLibraryUploadApiFuture(ListenableFutureTask.create(uploadCallable));
      clientContext.getExecutor().execute(future.futureTask);
      return future;
    }

    @Override
    public void addListener(Runnable listener, Executor executor) {
      futureTask.addListener(listener, executor);
    }

    @Override
    public boolean cancel(boolean b) {
      return futureTask.cancel(b);
    }

    @Override
    public boolean isCancelled() {
      return futureTask.isCancelled();
    }

    @Override
    public boolean isDone() {
      return futureTask.isDone();
    }

    @Override
    public UploadMediaItemResponse get() throws InterruptedException, ExecutionException {
      return futureTask.get();
    }

    @Override
    public UploadMediaItemResponse get(long l, TimeUnit timeUnit)
        throws InterruptedException, ExecutionException, TimeoutException {
      return futureTask.get(l, timeUnit);
    }
  }
}
