/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.photos.library.v1.internal;

import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListMediaItemsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListSharedAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.SearchMediaItemsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.photos.library.v1.internal.stub.PhotosLibraryStubSettings;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse;
import com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest;
import com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.BatchGetMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchGetMediaItemsResponse;
import com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest;
import com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse;
import com.google.photos.library.v1.proto.CreateAlbumRequest;
import com.google.photos.library.v1.proto.GetAlbumRequest;
import com.google.photos.library.v1.proto.GetMediaItemRequest;
import com.google.photos.library.v1.proto.GetSharedAlbumRequest;
import com.google.photos.library.v1.proto.JoinSharedAlbumRequest;
import com.google.photos.library.v1.proto.JoinSharedAlbumResponse;
import com.google.photos.library.v1.proto.LeaveSharedAlbumRequest;
import com.google.photos.library.v1.proto.LeaveSharedAlbumResponse;
import com.google.photos.library.v1.proto.ListAlbumsRequest;
import com.google.photos.library.v1.proto.ListAlbumsResponse;
import com.google.photos.library.v1.proto.ListMediaItemsRequest;
import com.google.photos.library.v1.proto.ListMediaItemsResponse;
import com.google.photos.library.v1.proto.ListSharedAlbumsRequest;
import com.google.photos.library.v1.proto.ListSharedAlbumsResponse;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import com.google.photos.library.v1.proto.ShareAlbumRequest;
import com.google.photos.library.v1.proto.ShareAlbumResponse;
import com.google.photos.library.v1.proto.UnshareAlbumRequest;
import com.google.photos.library.v1.proto.UnshareAlbumResponse;
import com.google.photos.library.v1.proto.UpdateAlbumRequest;
import com.google.photos.library.v1.proto.UpdateMediaItemRequest;
import com.google.photos.types.proto.Album;
import com.google.photos.types.proto.MediaItem;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InternalPhotosLibraryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (photoslibrary.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAlbum to 30 seconds:
 *
 * <pre>{@code
 * InternalPhotosLibrarySettings.Builder internalPhotosLibrarySettingsBuilder =
 *     InternalPhotosLibrarySettings.newBuilder();
 * internalPhotosLibrarySettingsBuilder
 *     .createAlbumSettings()
 *     .setRetrySettings(
 *         internalPhotosLibrarySettingsBuilder
 *             .createAlbumSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InternalPhotosLibrarySettings internalPhotosLibrarySettings =
 *     internalPhotosLibrarySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InternalPhotosLibrarySettings extends ClientSettings<InternalPhotosLibrarySettings> {

  /** Returns the object with the settings used for calls to createAlbum. */
  public UnaryCallSettings<CreateAlbumRequest, Album> createAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).createAlbumSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateMediaItems. */
  public UnaryCallSettings<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).batchCreateMediaItemsSettings();
  }

  /** Returns the object with the settings used for calls to batchAddMediaItemsToAlbum. */
  public UnaryCallSettings<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).batchAddMediaItemsToAlbumSettings();
  }

  /** Returns the object with the settings used for calls to searchMediaItems. */
  public PagedCallSettings<
          SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
      searchMediaItemsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).searchMediaItemsSettings();
  }

  /** Returns the object with the settings used for calls to listMediaItems. */
  public PagedCallSettings<
          ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
      listMediaItemsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).listMediaItemsSettings();
  }

  /** Returns the object with the settings used for calls to getMediaItem. */
  public UnaryCallSettings<GetMediaItemRequest, MediaItem> getMediaItemSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).getMediaItemSettings();
  }

  /** Returns the object with the settings used for calls to batchGetMediaItems. */
  public UnaryCallSettings<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).batchGetMediaItemsSettings();
  }

  /** Returns the object with the settings used for calls to listAlbums. */
  public PagedCallSettings<ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
      listAlbumsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).listAlbumsSettings();
  }

  /** Returns the object with the settings used for calls to getAlbum. */
  public UnaryCallSettings<GetAlbumRequest, Album> getAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).getAlbumSettings();
  }

  /** Returns the object with the settings used for calls to getSharedAlbum. */
  public UnaryCallSettings<GetSharedAlbumRequest, Album> getSharedAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).getSharedAlbumSettings();
  }

  /** Returns the object with the settings used for calls to addEnrichmentToAlbum. */
  public UnaryCallSettings<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).addEnrichmentToAlbumSettings();
  }

  /** Returns the object with the settings used for calls to joinSharedAlbum. */
  public UnaryCallSettings<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).joinSharedAlbumSettings();
  }

  /** Returns the object with the settings used for calls to leaveSharedAlbum. */
  public UnaryCallSettings<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).leaveSharedAlbumSettings();
  }

  /** Returns the object with the settings used for calls to shareAlbum. */
  public UnaryCallSettings<ShareAlbumRequest, ShareAlbumResponse> shareAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).shareAlbumSettings();
  }

  /** Returns the object with the settings used for calls to listSharedAlbums. */
  public PagedCallSettings<
          ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
      listSharedAlbumsSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).listSharedAlbumsSettings();
  }

  /** Returns the object with the settings used for calls to unshareAlbum. */
  public UnaryCallSettings<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).unshareAlbumSettings();
  }

  /** Returns the object with the settings used for calls to batchRemoveMediaItemsFromAlbum. */
  public UnaryCallSettings<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).batchRemoveMediaItemsFromAlbumSettings();
  }

  /** Returns the object with the settings used for calls to updateAlbum. */
  public UnaryCallSettings<UpdateAlbumRequest, Album> updateAlbumSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).updateAlbumSettings();
  }

  /** Returns the object with the settings used for calls to updateMediaItem. */
  public UnaryCallSettings<UpdateMediaItemRequest, MediaItem> updateMediaItemSettings() {
    return ((PhotosLibraryStubSettings) getStubSettings()).updateMediaItemSettings();
  }

  public static final InternalPhotosLibrarySettings create(PhotosLibraryStubSettings stub)
      throws IOException {
    return new InternalPhotosLibrarySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PhotosLibraryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PhotosLibraryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PhotosLibraryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PhotosLibraryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PhotosLibraryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PhotosLibraryStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PhotosLibraryStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected InternalPhotosLibrarySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InternalPhotosLibrarySettings. */
  public static class Builder
      extends ClientSettings.Builder<InternalPhotosLibrarySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PhotosLibraryStubSettings.newBuilder(clientContext));
    }

    protected Builder(InternalPhotosLibrarySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PhotosLibraryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PhotosLibraryStubSettings.newBuilder());
    }

    public PhotosLibraryStubSettings.Builder getStubSettingsBuilder() {
      return ((PhotosLibraryStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createAlbum. */
    public UnaryCallSettings.Builder<CreateAlbumRequest, Album> createAlbumSettings() {
      return getStubSettingsBuilder().createAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateMediaItems. */
    public UnaryCallSettings.Builder<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
        batchCreateMediaItemsSettings() {
      return getStubSettingsBuilder().batchCreateMediaItemsSettings();
    }

    /** Returns the builder for the settings used for calls to batchAddMediaItemsToAlbum. */
    public UnaryCallSettings.Builder<
            BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
        batchAddMediaItemsToAlbumSettings() {
      return getStubSettingsBuilder().batchAddMediaItemsToAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to searchMediaItems. */
    public PagedCallSettings.Builder<
            SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
        searchMediaItemsSettings() {
      return getStubSettingsBuilder().searchMediaItemsSettings();
    }

    /** Returns the builder for the settings used for calls to listMediaItems. */
    public PagedCallSettings.Builder<
            ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
        listMediaItemsSettings() {
      return getStubSettingsBuilder().listMediaItemsSettings();
    }

    /** Returns the builder for the settings used for calls to getMediaItem. */
    public UnaryCallSettings.Builder<GetMediaItemRequest, MediaItem> getMediaItemSettings() {
      return getStubSettingsBuilder().getMediaItemSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetMediaItems. */
    public UnaryCallSettings.Builder<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
        batchGetMediaItemsSettings() {
      return getStubSettingsBuilder().batchGetMediaItemsSettings();
    }

    /** Returns the builder for the settings used for calls to listAlbums. */
    public PagedCallSettings.Builder<ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
        listAlbumsSettings() {
      return getStubSettingsBuilder().listAlbumsSettings();
    }

    /** Returns the builder for the settings used for calls to getAlbum. */
    public UnaryCallSettings.Builder<GetAlbumRequest, Album> getAlbumSettings() {
      return getStubSettingsBuilder().getAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to getSharedAlbum. */
    public UnaryCallSettings.Builder<GetSharedAlbumRequest, Album> getSharedAlbumSettings() {
      return getStubSettingsBuilder().getSharedAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to addEnrichmentToAlbum. */
    public UnaryCallSettings.Builder<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
        addEnrichmentToAlbumSettings() {
      return getStubSettingsBuilder().addEnrichmentToAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to joinSharedAlbum. */
    public UnaryCallSettings.Builder<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
        joinSharedAlbumSettings() {
      return getStubSettingsBuilder().joinSharedAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to leaveSharedAlbum. */
    public UnaryCallSettings.Builder<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
        leaveSharedAlbumSettings() {
      return getStubSettingsBuilder().leaveSharedAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to shareAlbum. */
    public UnaryCallSettings.Builder<ShareAlbumRequest, ShareAlbumResponse> shareAlbumSettings() {
      return getStubSettingsBuilder().shareAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to listSharedAlbums. */
    public PagedCallSettings.Builder<
            ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
        listSharedAlbumsSettings() {
      return getStubSettingsBuilder().listSharedAlbumsSettings();
    }

    /** Returns the builder for the settings used for calls to unshareAlbum. */
    public UnaryCallSettings.Builder<UnshareAlbumRequest, UnshareAlbumResponse>
        unshareAlbumSettings() {
      return getStubSettingsBuilder().unshareAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to batchRemoveMediaItemsFromAlbum. */
    public UnaryCallSettings.Builder<
            BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
        batchRemoveMediaItemsFromAlbumSettings() {
      return getStubSettingsBuilder().batchRemoveMediaItemsFromAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to updateAlbum. */
    public UnaryCallSettings.Builder<UpdateAlbumRequest, Album> updateAlbumSettings() {
      return getStubSettingsBuilder().updateAlbumSettings();
    }

    /** Returns the builder for the settings used for calls to updateMediaItem. */
    public UnaryCallSettings.Builder<UpdateMediaItemRequest, MediaItem> updateMediaItemSettings() {
      return getStubSettingsBuilder().updateMediaItemSettings();
    }

    @Override
    public InternalPhotosLibrarySettings build() throws IOException {
      return new InternalPhotosLibrarySettings(this);
    }
  }
}
