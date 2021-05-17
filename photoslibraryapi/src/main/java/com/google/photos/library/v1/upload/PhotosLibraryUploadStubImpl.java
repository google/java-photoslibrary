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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/** Implementation for {@link PhotosLibraryUploadStub}. */
public final class PhotosLibraryUploadStubImpl extends PhotosLibraryUploadStub {

  private final BackgroundResource backgroundResources;
  private final UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> callable;

  private PhotosLibraryUploadStubImpl(PhotosLibrarySettings librarySettings) throws IOException {
    ClientContext clientContext = ClientContext.create(librarySettings);
    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());

    UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> settings =
        librarySettings.uploadMediaItemSettings();

    UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> uploadCallable =
        new PhotosLibraryUploadUnaryCallable(clientContext, settings, settings.getRetryableCodes());

    callable = new NestedUploadRetryCallable(uploadCallable, settings, clientContext);
  }

  public static PhotosLibraryUploadStub createStub(PhotosLibrarySettings settings)
      throws IOException {
    return new PhotosLibraryUploadStubImpl(settings);
  }

  @Override
  public UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> uploadMediaItemCallable() {
    return callable;
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }

  @Override
  public void close() throws Exception {
    backgroundResources.close();
  }
}
