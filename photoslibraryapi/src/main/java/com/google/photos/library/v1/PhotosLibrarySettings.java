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

package com.google.photos.library.v1;

import com.google.api.core.ApiClock;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.WatchdogProvider;
import com.google.common.collect.ImmutableSet;
import com.google.photos.library.v1.internal.InternalPhotosLibrarySettings;
import com.google.photos.library.v1.internal.stub.PhotosLibraryStubSettings;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import java.io.IOException;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Settings for a {@link PhotosLibraryClient} for interacting with the Google Photos Library API.
 *
 * Use the {@link Builder} to create an instance of this class. You can configure the retry
 * configuration for media upload requests using {@link UnaryCallSettings} through the
 * {@link Builder#uploadMediaItemSettingsBuilder}.
 *
 * Note that this class is a wrapper of {@link InternalPhotosLibrarySettings} which should not be
 * used directly. Instead, use this class and the {@link PhotosLibraryClient}.
 */
public final class PhotosLibrarySettings extends InternalPhotosLibrarySettings {
  /** The default endpoint of the upload service. */
  private static final String DEFAULT_UPLOAD_ENDPOINT =
      "https://photoslibrary.googleapis.com/v1/uploads";

  private final UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse>
      uploadMediaItemSettings;

  protected PhotosLibrarySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
    uploadMediaItemSettings = settingsBuilder.uploadMediaItemSettingsBuilder().build();
  }

  /** Returns the object with the settings used for calls to uploadMediaItem. */
  public UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse>
      uploadMediaItemSettings() {
    return uploadMediaItemSettings;
  }

  /** Returns the upload endpoint used for calls to uploadMediaItem. */
  public static String getUploadEndpoint() {
    return DEFAULT_UPLOAD_ENDPOINT;
  }

  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Builder class for {@link PhotosLibrarySettings}. */
  public static final class Builder extends InternalPhotosLibrarySettings.Builder {

    /** RPC statuses for which upload requests should be retried. */
    private static final ImmutableSet<StatusCode.Code> UPLOAD_RETRYABLE_CODE_DEFINITIONS =
        ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE);

    private final UnaryCallSettings.Builder<UploadMediaItemRequest, UploadMediaItemResponse>
        uploadMediaItemSettingsBuilder = getUploadSettingsDefaults();

    private Builder(PhotosLibraryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    @Override
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      super.setHeaderProvider(headerProvider);
      return this;
    }

    @Override
    protected Builder setInternalHeaderProvider(HeaderProvider internalHeaderProvider) {
      super.setInternalHeaderProvider(internalHeaderProvider);
      return this;
    }

    @Override
    public Builder setTransportChannelProvider(TransportChannelProvider transportChannelProvider) {
      super.setTransportChannelProvider(transportChannelProvider);
      return this;
    }

    @Override
    public Builder setClock(ApiClock clock) {
      super.setClock(clock);
      return this;
    }

    @Override
    public Builder setEndpoint(String endpoint) {
      super.setEndpoint(endpoint);
      return this;
    }

    @Override
    public Builder setWatchdogProvider(@Nullable WatchdogProvider watchdogProvider) {
      super.setWatchdogProvider(watchdogProvider);
      return this;
    }

    @Override
    public Builder setWatchdogCheckInterval(@Nullable Duration checkInterval) {
      super.setWatchdogCheckInterval(checkInterval);
      return this;
    }

    @Override
    public PhotosLibrarySettings build() throws IOException {
      return new PhotosLibrarySettings(this);
    }

    /** Returns the builder for the settings used for calls to uploadMediaItem. */
    public UnaryCallSettings.Builder<UploadMediaItemRequest, UploadMediaItemResponse>
        uploadMediaItemSettingsBuilder() {
      return uploadMediaItemSettingsBuilder;
    }

    public static Builder createDefault() {
      return new Builder(PhotosLibraryStubSettings.newBuilder());
    }

    private static UnaryCallSettings.Builder<UploadMediaItemRequest, UploadMediaItemResponse>
        getUploadSettingsDefaults() {
      return UnaryCallSettings
          .<UploadMediaItemRequest, UploadMediaItemResponse>newUnaryCallSettingsBuilder()
          .setRetryableCodes(UPLOAD_RETRYABLE_CODE_DEFINITIONS)
          .setRetrySettings(getUploadRetryDefaults());
    }

    private static RetrySettings getUploadRetryDefaults() {
      return RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofSeconds(1))
          .setRetryDelayMultiplier(1.3)
          .setMaxAttempts(5)
          .setMaxRetryDelay(Duration.ofSeconds(10))
          .setTotalTimeout(Duration.ofMinutes(15))
          .build();
    }
  }
}
