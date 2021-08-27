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

package com.google.photos.library.v1.internal.stub;

import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListMediaItemsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListSharedAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.SearchMediaItemsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PhotosLibraryStub}.
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
 * PhotosLibraryStubSettings.Builder internalPhotosLibrarySettingsBuilder =
 *     PhotosLibraryStubSettings.newBuilder();
 * internalPhotosLibrarySettingsBuilder
 *     .createAlbumSettings()
 *     .setRetrySettings(
 *         internalPhotosLibrarySettingsBuilder
 *             .createAlbumSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PhotosLibraryStubSettings internalPhotosLibrarySettings =
 *     internalPhotosLibrarySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PhotosLibraryStubSettings extends StubSettings<PhotosLibraryStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/photoslibrary")
          .add("https://www.googleapis.com/auth/photoslibrary.appendonly")
          .add("https://www.googleapis.com/auth/photoslibrary.edit.appcreateddata")
          .add("https://www.googleapis.com/auth/photoslibrary.readonly")
          .add("https://www.googleapis.com/auth/photoslibrary.readonly.appcreateddata")
          .add("https://www.googleapis.com/auth/photoslibrary.sharing")
          .build();

  private final UnaryCallSettings<CreateAlbumRequest, Album> createAlbumSettings;
  private final UnaryCallSettings<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsSettings;
  private final UnaryCallSettings<
          BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumSettings;
  private final PagedCallSettings<
          SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
      searchMediaItemsSettings;
  private final PagedCallSettings<
          ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
      listMediaItemsSettings;
  private final UnaryCallSettings<GetMediaItemRequest, MediaItem> getMediaItemSettings;
  private final UnaryCallSettings<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsSettings;
  private final PagedCallSettings<ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
      listAlbumsSettings;
  private final UnaryCallSettings<GetAlbumRequest, Album> getAlbumSettings;
  private final UnaryCallSettings<GetSharedAlbumRequest, Album> getSharedAlbumSettings;
  private final UnaryCallSettings<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumSettings;
  private final UnaryCallSettings<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumSettings;
  private final UnaryCallSettings<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumSettings;
  private final UnaryCallSettings<ShareAlbumRequest, ShareAlbumResponse> shareAlbumSettings;
  private final PagedCallSettings<
          ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
      listSharedAlbumsSettings;
  private final UnaryCallSettings<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumSettings;
  private final UnaryCallSettings<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumSettings;
  private final UnaryCallSettings<UpdateAlbumRequest, Album> updateAlbumSettings;
  private final UnaryCallSettings<UpdateMediaItemRequest, MediaItem> updateMediaItemSettings;

  private static final PagedListDescriptor<
          SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem>
      SEARCH_MEDIA_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchMediaItemsRequest injectToken(
                SearchMediaItemsRequest payload, String token) {
              return SearchMediaItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchMediaItemsRequest injectPageSize(
                SearchMediaItemsRequest payload, int pageSize) {
              return SearchMediaItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchMediaItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchMediaItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MediaItem> extractResources(SearchMediaItemsResponse payload) {
              return payload.getMediaItemsList() == null
                  ? ImmutableList.<MediaItem>of()
                  : payload.getMediaItemsList();
            }
          };

  private static final PagedListDescriptor<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem>
      LIST_MEDIA_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMediaItemsRequest injectToken(ListMediaItemsRequest payload, String token) {
              return ListMediaItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMediaItemsRequest injectPageSize(
                ListMediaItemsRequest payload, int pageSize) {
              return ListMediaItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMediaItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMediaItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MediaItem> extractResources(ListMediaItemsResponse payload) {
              return payload.getMediaItemsList() == null
                  ? ImmutableList.<MediaItem>of()
                  : payload.getMediaItemsList();
            }
          };

  private static final PagedListDescriptor<ListAlbumsRequest, ListAlbumsResponse, Album>
      LIST_ALBUMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAlbumsRequest, ListAlbumsResponse, Album>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAlbumsRequest injectToken(ListAlbumsRequest payload, String token) {
              return ListAlbumsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAlbumsRequest injectPageSize(ListAlbumsRequest payload, int pageSize) {
              return ListAlbumsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAlbumsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAlbumsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Album> extractResources(ListAlbumsResponse payload) {
              return payload.getAlbumsList() == null
                  ? ImmutableList.<Album>of()
                  : payload.getAlbumsList();
            }
          };

  private static final PagedListDescriptor<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album>
      LIST_SHARED_ALBUMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSharedAlbumsRequest injectToken(
                ListSharedAlbumsRequest payload, String token) {
              return ListSharedAlbumsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSharedAlbumsRequest injectPageSize(
                ListSharedAlbumsRequest payload, int pageSize) {
              return ListSharedAlbumsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSharedAlbumsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSharedAlbumsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Album> extractResources(ListSharedAlbumsResponse payload) {
              return payload.getSharedAlbumsList() == null
                  ? ImmutableList.<Album>of()
                  : payload.getSharedAlbumsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
      SEARCH_MEDIA_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>() {
            @Override
            public ApiFuture<SearchMediaItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse> callable,
                SearchMediaItemsRequest request,
                ApiCallContext context,
                ApiFuture<SearchMediaItemsResponse> futureResponse) {
              PageContext<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_MEDIA_ITEMS_PAGE_STR_DESC, request, context);
              return SearchMediaItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
      LIST_MEDIA_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>() {
            @Override
            public ApiFuture<ListMediaItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse> callable,
                ListMediaItemsRequest request,
                ApiCallContext context,
                ApiFuture<ListMediaItemsResponse> futureResponse) {
              PageContext<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem> pageContext =
                  PageContext.create(callable, LIST_MEDIA_ITEMS_PAGE_STR_DESC, request, context);
              return ListMediaItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
      LIST_ALBUMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>() {
            @Override
            public ApiFuture<ListAlbumsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> callable,
                ListAlbumsRequest request,
                ApiCallContext context,
                ApiFuture<ListAlbumsResponse> futureResponse) {
              PageContext<ListAlbumsRequest, ListAlbumsResponse, Album> pageContext =
                  PageContext.create(callable, LIST_ALBUMS_PAGE_STR_DESC, request, context);
              return ListAlbumsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
      LIST_SHARED_ALBUMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>() {
            @Override
            public ApiFuture<ListSharedAlbumsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse> callable,
                ListSharedAlbumsRequest request,
                ApiCallContext context,
                ApiFuture<ListSharedAlbumsResponse> futureResponse) {
              PageContext<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album> pageContext =
                  PageContext.create(callable, LIST_SHARED_ALBUMS_PAGE_STR_DESC, request, context);
              return ListSharedAlbumsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createAlbum. */
  public UnaryCallSettings<CreateAlbumRequest, Album> createAlbumSettings() {
    return createAlbumSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateMediaItems. */
  public UnaryCallSettings<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsSettings() {
    return batchCreateMediaItemsSettings;
  }

  /** Returns the object with the settings used for calls to batchAddMediaItemsToAlbum. */
  public UnaryCallSettings<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumSettings() {
    return batchAddMediaItemsToAlbumSettings;
  }

  /** Returns the object with the settings used for calls to searchMediaItems. */
  public PagedCallSettings<
          SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
      searchMediaItemsSettings() {
    return searchMediaItemsSettings;
  }

  /** Returns the object with the settings used for calls to listMediaItems. */
  public PagedCallSettings<
          ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
      listMediaItemsSettings() {
    return listMediaItemsSettings;
  }

  /** Returns the object with the settings used for calls to getMediaItem. */
  public UnaryCallSettings<GetMediaItemRequest, MediaItem> getMediaItemSettings() {
    return getMediaItemSettings;
  }

  /** Returns the object with the settings used for calls to batchGetMediaItems. */
  public UnaryCallSettings<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsSettings() {
    return batchGetMediaItemsSettings;
  }

  /** Returns the object with the settings used for calls to listAlbums. */
  public PagedCallSettings<ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
      listAlbumsSettings() {
    return listAlbumsSettings;
  }

  /** Returns the object with the settings used for calls to getAlbum. */
  public UnaryCallSettings<GetAlbumRequest, Album> getAlbumSettings() {
    return getAlbumSettings;
  }

  /** Returns the object with the settings used for calls to getSharedAlbum. */
  public UnaryCallSettings<GetSharedAlbumRequest, Album> getSharedAlbumSettings() {
    return getSharedAlbumSettings;
  }

  /** Returns the object with the settings used for calls to addEnrichmentToAlbum. */
  public UnaryCallSettings<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumSettings() {
    return addEnrichmentToAlbumSettings;
  }

  /** Returns the object with the settings used for calls to joinSharedAlbum. */
  public UnaryCallSettings<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumSettings() {
    return joinSharedAlbumSettings;
  }

  /** Returns the object with the settings used for calls to leaveSharedAlbum. */
  public UnaryCallSettings<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumSettings() {
    return leaveSharedAlbumSettings;
  }

  /** Returns the object with the settings used for calls to shareAlbum. */
  public UnaryCallSettings<ShareAlbumRequest, ShareAlbumResponse> shareAlbumSettings() {
    return shareAlbumSettings;
  }

  /** Returns the object with the settings used for calls to listSharedAlbums. */
  public PagedCallSettings<
          ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
      listSharedAlbumsSettings() {
    return listSharedAlbumsSettings;
  }

  /** Returns the object with the settings used for calls to unshareAlbum. */
  public UnaryCallSettings<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumSettings() {
    return unshareAlbumSettings;
  }

  /** Returns the object with the settings used for calls to batchRemoveMediaItemsFromAlbum. */
  public UnaryCallSettings<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumSettings() {
    return batchRemoveMediaItemsFromAlbumSettings;
  }

  /** Returns the object with the settings used for calls to updateAlbum. */
  public UnaryCallSettings<UpdateAlbumRequest, Album> updateAlbumSettings() {
    return updateAlbumSettings;
  }

  /** Returns the object with the settings used for calls to updateMediaItem. */
  public UnaryCallSettings<UpdateMediaItemRequest, MediaItem> updateMediaItemSettings() {
    return updateMediaItemSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PhotosLibraryStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPhotosLibraryStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "photoslibrary.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "photoslibrary.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PhotosLibraryStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected PhotosLibraryStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createAlbumSettings = settingsBuilder.createAlbumSettings().build();
    batchCreateMediaItemsSettings = settingsBuilder.batchCreateMediaItemsSettings().build();
    batchAddMediaItemsToAlbumSettings = settingsBuilder.batchAddMediaItemsToAlbumSettings().build();
    searchMediaItemsSettings = settingsBuilder.searchMediaItemsSettings().build();
    listMediaItemsSettings = settingsBuilder.listMediaItemsSettings().build();
    getMediaItemSettings = settingsBuilder.getMediaItemSettings().build();
    batchGetMediaItemsSettings = settingsBuilder.batchGetMediaItemsSettings().build();
    listAlbumsSettings = settingsBuilder.listAlbumsSettings().build();
    getAlbumSettings = settingsBuilder.getAlbumSettings().build();
    getSharedAlbumSettings = settingsBuilder.getSharedAlbumSettings().build();
    addEnrichmentToAlbumSettings = settingsBuilder.addEnrichmentToAlbumSettings().build();
    joinSharedAlbumSettings = settingsBuilder.joinSharedAlbumSettings().build();
    leaveSharedAlbumSettings = settingsBuilder.leaveSharedAlbumSettings().build();
    shareAlbumSettings = settingsBuilder.shareAlbumSettings().build();
    listSharedAlbumsSettings = settingsBuilder.listSharedAlbumsSettings().build();
    unshareAlbumSettings = settingsBuilder.unshareAlbumSettings().build();
    batchRemoveMediaItemsFromAlbumSettings =
        settingsBuilder.batchRemoveMediaItemsFromAlbumSettings().build();
    updateAlbumSettings = settingsBuilder.updateAlbumSettings().build();
    updateMediaItemSettings = settingsBuilder.updateMediaItemSettings().build();
  }

  /** Builder for PhotosLibraryStubSettings. */
  public static class Builder extends StubSettings.Builder<PhotosLibraryStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateAlbumRequest, Album> createAlbumSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
        batchCreateMediaItemsSettings;
    private final UnaryCallSettings.Builder<
            BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
        batchAddMediaItemsToAlbumSettings;
    private final PagedCallSettings.Builder<
            SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
        searchMediaItemsSettings;
    private final PagedCallSettings.Builder<
            ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
        listMediaItemsSettings;
    private final UnaryCallSettings.Builder<GetMediaItemRequest, MediaItem> getMediaItemSettings;
    private final UnaryCallSettings.Builder<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
        batchGetMediaItemsSettings;
    private final PagedCallSettings.Builder<
            ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
        listAlbumsSettings;
    private final UnaryCallSettings.Builder<GetAlbumRequest, Album> getAlbumSettings;
    private final UnaryCallSettings.Builder<GetSharedAlbumRequest, Album> getSharedAlbumSettings;
    private final UnaryCallSettings.Builder<
            AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
        addEnrichmentToAlbumSettings;
    private final UnaryCallSettings.Builder<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
        joinSharedAlbumSettings;
    private final UnaryCallSettings.Builder<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
        leaveSharedAlbumSettings;
    private final UnaryCallSettings.Builder<ShareAlbumRequest, ShareAlbumResponse>
        shareAlbumSettings;
    private final PagedCallSettings.Builder<
            ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
        listSharedAlbumsSettings;
    private final UnaryCallSettings.Builder<UnshareAlbumRequest, UnshareAlbumResponse>
        unshareAlbumSettings;
    private final UnaryCallSettings.Builder<
            BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
        batchRemoveMediaItemsFromAlbumSettings;
    private final UnaryCallSettings.Builder<UpdateAlbumRequest, Album> updateAlbumSettings;
    private final UnaryCallSettings.Builder<UpdateMediaItemRequest, MediaItem>
        updateMediaItemSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateMediaItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchAddMediaItemsToAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchMediaItemsSettings = PagedCallSettings.newBuilder(SEARCH_MEDIA_ITEMS_PAGE_STR_FACT);
      listMediaItemsSettings = PagedCallSettings.newBuilder(LIST_MEDIA_ITEMS_PAGE_STR_FACT);
      getMediaItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchGetMediaItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAlbumsSettings = PagedCallSettings.newBuilder(LIST_ALBUMS_PAGE_STR_FACT);
      getAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSharedAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addEnrichmentToAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      joinSharedAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      leaveSharedAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      shareAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSharedAlbumsSettings = PagedCallSettings.newBuilder(LIST_SHARED_ALBUMS_PAGE_STR_FACT);
      unshareAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRemoveMediaItemsFromAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAlbumSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMediaItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAlbumSettings,
              batchCreateMediaItemsSettings,
              batchAddMediaItemsToAlbumSettings,
              searchMediaItemsSettings,
              listMediaItemsSettings,
              getMediaItemSettings,
              batchGetMediaItemsSettings,
              listAlbumsSettings,
              getAlbumSettings,
              getSharedAlbumSettings,
              addEnrichmentToAlbumSettings,
              joinSharedAlbumSettings,
              leaveSharedAlbumSettings,
              shareAlbumSettings,
              listSharedAlbumsSettings,
              unshareAlbumSettings,
              batchRemoveMediaItemsFromAlbumSettings,
              updateAlbumSettings,
              updateMediaItemSettings);
      initDefaults(this);
    }

    protected Builder(PhotosLibraryStubSettings settings) {
      super(settings);

      createAlbumSettings = settings.createAlbumSettings.toBuilder();
      batchCreateMediaItemsSettings = settings.batchCreateMediaItemsSettings.toBuilder();
      batchAddMediaItemsToAlbumSettings = settings.batchAddMediaItemsToAlbumSettings.toBuilder();
      searchMediaItemsSettings = settings.searchMediaItemsSettings.toBuilder();
      listMediaItemsSettings = settings.listMediaItemsSettings.toBuilder();
      getMediaItemSettings = settings.getMediaItemSettings.toBuilder();
      batchGetMediaItemsSettings = settings.batchGetMediaItemsSettings.toBuilder();
      listAlbumsSettings = settings.listAlbumsSettings.toBuilder();
      getAlbumSettings = settings.getAlbumSettings.toBuilder();
      getSharedAlbumSettings = settings.getSharedAlbumSettings.toBuilder();
      addEnrichmentToAlbumSettings = settings.addEnrichmentToAlbumSettings.toBuilder();
      joinSharedAlbumSettings = settings.joinSharedAlbumSettings.toBuilder();
      leaveSharedAlbumSettings = settings.leaveSharedAlbumSettings.toBuilder();
      shareAlbumSettings = settings.shareAlbumSettings.toBuilder();
      listSharedAlbumsSettings = settings.listSharedAlbumsSettings.toBuilder();
      unshareAlbumSettings = settings.unshareAlbumSettings.toBuilder();
      batchRemoveMediaItemsFromAlbumSettings =
          settings.batchRemoveMediaItemsFromAlbumSettings.toBuilder();
      updateAlbumSettings = settings.updateAlbumSettings.toBuilder();
      updateMediaItemSettings = settings.updateMediaItemSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createAlbumSettings,
              batchCreateMediaItemsSettings,
              batchAddMediaItemsToAlbumSettings,
              searchMediaItemsSettings,
              listMediaItemsSettings,
              getMediaItemSettings,
              batchGetMediaItemsSettings,
              listAlbumsSettings,
              getAlbumSettings,
              getSharedAlbumSettings,
              addEnrichmentToAlbumSettings,
              joinSharedAlbumSettings,
              leaveSharedAlbumSettings,
              shareAlbumSettings,
              listSharedAlbumsSettings,
              unshareAlbumSettings,
              batchRemoveMediaItemsFromAlbumSettings,
              updateAlbumSettings,
              updateMediaItemSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchCreateMediaItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchAddMediaItemsToAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .searchMediaItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listMediaItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getMediaItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .batchGetMediaItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listAlbumsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getSharedAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .addEnrichmentToAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .joinSharedAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .leaveSharedAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .shareAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSharedAlbumsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .unshareAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchRemoveMediaItemsFromAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAlbumSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateMediaItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createAlbum. */
    public UnaryCallSettings.Builder<CreateAlbumRequest, Album> createAlbumSettings() {
      return createAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateMediaItems. */
    public UnaryCallSettings.Builder<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
        batchCreateMediaItemsSettings() {
      return batchCreateMediaItemsSettings;
    }

    /** Returns the builder for the settings used for calls to batchAddMediaItemsToAlbum. */
    public UnaryCallSettings.Builder<
            BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
        batchAddMediaItemsToAlbumSettings() {
      return batchAddMediaItemsToAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to searchMediaItems. */
    public PagedCallSettings.Builder<
            SearchMediaItemsRequest, SearchMediaItemsResponse, SearchMediaItemsPagedResponse>
        searchMediaItemsSettings() {
      return searchMediaItemsSettings;
    }

    /** Returns the builder for the settings used for calls to listMediaItems. */
    public PagedCallSettings.Builder<
            ListMediaItemsRequest, ListMediaItemsResponse, ListMediaItemsPagedResponse>
        listMediaItemsSettings() {
      return listMediaItemsSettings;
    }

    /** Returns the builder for the settings used for calls to getMediaItem. */
    public UnaryCallSettings.Builder<GetMediaItemRequest, MediaItem> getMediaItemSettings() {
      return getMediaItemSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetMediaItems. */
    public UnaryCallSettings.Builder<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
        batchGetMediaItemsSettings() {
      return batchGetMediaItemsSettings;
    }

    /** Returns the builder for the settings used for calls to listAlbums. */
    public PagedCallSettings.Builder<ListAlbumsRequest, ListAlbumsResponse, ListAlbumsPagedResponse>
        listAlbumsSettings() {
      return listAlbumsSettings;
    }

    /** Returns the builder for the settings used for calls to getAlbum. */
    public UnaryCallSettings.Builder<GetAlbumRequest, Album> getAlbumSettings() {
      return getAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to getSharedAlbum. */
    public UnaryCallSettings.Builder<GetSharedAlbumRequest, Album> getSharedAlbumSettings() {
      return getSharedAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to addEnrichmentToAlbum. */
    public UnaryCallSettings.Builder<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
        addEnrichmentToAlbumSettings() {
      return addEnrichmentToAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to joinSharedAlbum. */
    public UnaryCallSettings.Builder<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
        joinSharedAlbumSettings() {
      return joinSharedAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to leaveSharedAlbum. */
    public UnaryCallSettings.Builder<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
        leaveSharedAlbumSettings() {
      return leaveSharedAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to shareAlbum. */
    public UnaryCallSettings.Builder<ShareAlbumRequest, ShareAlbumResponse> shareAlbumSettings() {
      return shareAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to listSharedAlbums. */
    public PagedCallSettings.Builder<
            ListSharedAlbumsRequest, ListSharedAlbumsResponse, ListSharedAlbumsPagedResponse>
        listSharedAlbumsSettings() {
      return listSharedAlbumsSettings;
    }

    /** Returns the builder for the settings used for calls to unshareAlbum. */
    public UnaryCallSettings.Builder<UnshareAlbumRequest, UnshareAlbumResponse>
        unshareAlbumSettings() {
      return unshareAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to batchRemoveMediaItemsFromAlbum. */
    public UnaryCallSettings.Builder<
            BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
        batchRemoveMediaItemsFromAlbumSettings() {
      return batchRemoveMediaItemsFromAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to updateAlbum. */
    public UnaryCallSettings.Builder<UpdateAlbumRequest, Album> updateAlbumSettings() {
      return updateAlbumSettings;
    }

    /** Returns the builder for the settings used for calls to updateMediaItem. */
    public UnaryCallSettings.Builder<UpdateMediaItemRequest, MediaItem> updateMediaItemSettings() {
      return updateMediaItemSettings;
    }

    @Override
    public PhotosLibraryStubSettings build() throws IOException {
      return new PhotosLibraryStubSettings(this);
    }
  }
}
