/*
 * Copyright 2019 Google LLC
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
package com.google.photos.library.v1.internal.stub;

import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListMediaItemsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.ListSharedAlbumsPagedResponse;
import static com.google.photos.library.v1.internal.InternalPhotosLibraryClient.SearchMediaItemsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
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
import com.google.photos.types.proto.Album;
import com.google.photos.types.proto.MediaItem;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Photos Library API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcPhotosLibraryStub extends PhotosLibraryStub {

  private static final MethodDescriptor<CreateAlbumRequest, Album> createAlbumMethodDescriptor =
      MethodDescriptor.<CreateAlbumRequest, Album>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.photos.library.v1.PhotosLibrary/CreateAlbum")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAlbumRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Album.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsMethodDescriptor =
          MethodDescriptor.<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/BatchCreateMediaItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateMediaItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateMediaItemsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumMethodDescriptor =
          MethodDescriptor
              .<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/BatchAddMediaItemsToAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchAddMediaItemsToAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchAddMediaItemsToAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsMethodDescriptor =
          MethodDescriptor.<SearchMediaItemsRequest, SearchMediaItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/SearchMediaItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchMediaItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchMediaItemsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListMediaItemsRequest, ListMediaItemsResponse>
      listMediaItemsMethodDescriptor =
          MethodDescriptor.<ListMediaItemsRequest, ListMediaItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/ListMediaItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMediaItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMediaItemsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetMediaItemRequest, MediaItem>
      getMediaItemMethodDescriptor =
          MethodDescriptor.<GetMediaItemRequest, MediaItem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/GetMediaItem")
              .setRequestMarshaller(ProtoUtils.marshaller(GetMediaItemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MediaItem.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsMethodDescriptor =
          MethodDescriptor.<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/BatchGetMediaItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetMediaItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetMediaItemsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListAlbumsRequest, ListAlbumsResponse>
      listAlbumsMethodDescriptor =
          MethodDescriptor.<ListAlbumsRequest, ListAlbumsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/ListAlbums")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAlbumsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAlbumsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetAlbumRequest, Album> getAlbumMethodDescriptor =
      MethodDescriptor.<GetAlbumRequest, Album>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.photos.library.v1.PhotosLibrary/GetAlbum")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAlbumRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Album.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetSharedAlbumRequest, Album>
      getSharedAlbumMethodDescriptor =
          MethodDescriptor.<GetSharedAlbumRequest, Album>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/GetSharedAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSharedAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Album.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumMethodDescriptor =
          MethodDescriptor.<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/AddEnrichmentToAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddEnrichmentToAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddEnrichmentToAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumMethodDescriptor =
          MethodDescriptor.<JoinSharedAlbumRequest, JoinSharedAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/JoinSharedAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(JoinSharedAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(JoinSharedAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumMethodDescriptor =
          MethodDescriptor.<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/LeaveSharedAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LeaveSharedAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LeaveSharedAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ShareAlbumRequest, ShareAlbumResponse>
      shareAlbumMethodDescriptor =
          MethodDescriptor.<ShareAlbumRequest, ShareAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/ShareAlbum")
              .setRequestMarshaller(ProtoUtils.marshaller(ShareAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ShareAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsMethodDescriptor =
          MethodDescriptor.<ListSharedAlbumsRequest, ListSharedAlbumsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/ListSharedAlbums")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSharedAlbumsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSharedAlbumsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UnshareAlbumRequest, UnshareAlbumResponse>
      unshareAlbumMethodDescriptor =
          MethodDescriptor.<UnshareAlbumRequest, UnshareAlbumResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.photos.library.v1.PhotosLibrary/UnshareAlbum")
              .setRequestMarshaller(ProtoUtils.marshaller(UnshareAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UnshareAlbumResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumMethodDescriptor =
          MethodDescriptor
              .<BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.photos.library.v1.PhotosLibrary/BatchRemoveMediaItemsFromAlbum")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRemoveMediaItemsFromAlbumRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchRemoveMediaItemsFromAlbumResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<CreateAlbumRequest, Album> createAlbumCallable;
  private final UnaryCallable<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsCallable;
  private final UnaryCallable<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumCallable;
  private final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsCallable;
  private final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsPagedResponse>
      searchMediaItemsPagedCallable;
  private final UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse> listMediaItemsCallable;
  private final UnaryCallable<ListMediaItemsRequest, ListMediaItemsPagedResponse>
      listMediaItemsPagedCallable;
  private final UnaryCallable<GetMediaItemRequest, MediaItem> getMediaItemCallable;
  private final UnaryCallable<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsCallable;
  private final UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> listAlbumsCallable;
  private final UnaryCallable<ListAlbumsRequest, ListAlbumsPagedResponse> listAlbumsPagedCallable;
  private final UnaryCallable<GetAlbumRequest, Album> getAlbumCallable;
  private final UnaryCallable<GetSharedAlbumRequest, Album> getSharedAlbumCallable;
  private final UnaryCallable<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumCallable;
  private final UnaryCallable<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumCallable;
  private final UnaryCallable<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumCallable;
  private final UnaryCallable<ShareAlbumRequest, ShareAlbumResponse> shareAlbumCallable;
  private final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsCallable;
  private final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsPagedResponse>
      listSharedAlbumsPagedCallable;
  private final UnaryCallable<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumCallable;
  private final UnaryCallable<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPhotosLibraryStub create(PhotosLibraryStubSettings settings)
      throws IOException {
    return new GrpcPhotosLibraryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPhotosLibraryStub create(ClientContext clientContext) throws IOException {
    return new GrpcPhotosLibraryStub(PhotosLibraryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPhotosLibraryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPhotosLibraryStub(
        PhotosLibraryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPhotosLibraryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPhotosLibraryStub(PhotosLibraryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPhotosLibraryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPhotosLibraryStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPhotosLibraryStub(
      PhotosLibraryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<CreateAlbumRequest, Album> createAlbumTransportSettings =
        GrpcCallSettings.<CreateAlbumRequest, Album>newBuilder()
            .setMethodDescriptor(createAlbumMethodDescriptor)
            .build();
    GrpcCallSettings<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
        batchCreateMediaItemsTransportSettings =
            GrpcCallSettings
                .<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>newBuilder()
                .setMethodDescriptor(batchCreateMediaItemsMethodDescriptor)
                .build();
    GrpcCallSettings<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
        batchAddMediaItemsToAlbumTransportSettings =
            GrpcCallSettings
                .<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>newBuilder()
                .setMethodDescriptor(batchAddMediaItemsToAlbumMethodDescriptor)
                .build();
    GrpcCallSettings<SearchMediaItemsRequest, SearchMediaItemsResponse>
        searchMediaItemsTransportSettings =
            GrpcCallSettings.<SearchMediaItemsRequest, SearchMediaItemsResponse>newBuilder()
                .setMethodDescriptor(searchMediaItemsMethodDescriptor)
                .build();
    GrpcCallSettings<ListMediaItemsRequest, ListMediaItemsResponse>
        listMediaItemsTransportSettings =
            GrpcCallSettings.<ListMediaItemsRequest, ListMediaItemsResponse>newBuilder()
                .setMethodDescriptor(listMediaItemsMethodDescriptor)
                .build();
    GrpcCallSettings<GetMediaItemRequest, MediaItem> getMediaItemTransportSettings =
        GrpcCallSettings.<GetMediaItemRequest, MediaItem>newBuilder()
            .setMethodDescriptor(getMediaItemMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMediaItemRequest>() {
                  @Override
                  public Map<String, String> extract(GetMediaItemRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("media_item_id", String.valueOf(request.getMediaItemId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
        batchGetMediaItemsTransportSettings =
            GrpcCallSettings.<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>newBuilder()
                .setMethodDescriptor(batchGetMediaItemsMethodDescriptor)
                .build();
    GrpcCallSettings<ListAlbumsRequest, ListAlbumsResponse> listAlbumsTransportSettings =
        GrpcCallSettings.<ListAlbumsRequest, ListAlbumsResponse>newBuilder()
            .setMethodDescriptor(listAlbumsMethodDescriptor)
            .build();
    GrpcCallSettings<GetAlbumRequest, Album> getAlbumTransportSettings =
        GrpcCallSettings.<GetAlbumRequest, Album>newBuilder()
            .setMethodDescriptor(getAlbumMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetAlbumRequest>() {
                  @Override
                  public Map<String, String> extract(GetAlbumRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("album_id", String.valueOf(request.getAlbumId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetSharedAlbumRequest, Album> getSharedAlbumTransportSettings =
        GrpcCallSettings.<GetSharedAlbumRequest, Album>newBuilder()
            .setMethodDescriptor(getSharedAlbumMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetSharedAlbumRequest>() {
                  @Override
                  public Map<String, String> extract(GetSharedAlbumRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("share_token", String.valueOf(request.getShareToken()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
        addEnrichmentToAlbumTransportSettings =
            GrpcCallSettings.<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>newBuilder()
                .setMethodDescriptor(addEnrichmentToAlbumMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AddEnrichmentToAlbumRequest>() {
                      @Override
                      public Map<String, String> extract(AddEnrichmentToAlbumRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("album_id", String.valueOf(request.getAlbumId()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
        joinSharedAlbumTransportSettings =
            GrpcCallSettings.<JoinSharedAlbumRequest, JoinSharedAlbumResponse>newBuilder()
                .setMethodDescriptor(joinSharedAlbumMethodDescriptor)
                .build();
    GrpcCallSettings<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
        leaveSharedAlbumTransportSettings =
            GrpcCallSettings.<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>newBuilder()
                .setMethodDescriptor(leaveSharedAlbumMethodDescriptor)
                .build();
    GrpcCallSettings<ShareAlbumRequest, ShareAlbumResponse> shareAlbumTransportSettings =
        GrpcCallSettings.<ShareAlbumRequest, ShareAlbumResponse>newBuilder()
            .setMethodDescriptor(shareAlbumMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ShareAlbumRequest>() {
                  @Override
                  public Map<String, String> extract(ShareAlbumRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("album_id", String.valueOf(request.getAlbumId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
        listSharedAlbumsTransportSettings =
            GrpcCallSettings.<ListSharedAlbumsRequest, ListSharedAlbumsResponse>newBuilder()
                .setMethodDescriptor(listSharedAlbumsMethodDescriptor)
                .build();
    GrpcCallSettings<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumTransportSettings =
        GrpcCallSettings.<UnshareAlbumRequest, UnshareAlbumResponse>newBuilder()
            .setMethodDescriptor(unshareAlbumMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UnshareAlbumRequest>() {
                  @Override
                  public Map<String, String> extract(UnshareAlbumRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("album_id", String.valueOf(request.getAlbumId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
        batchRemoveMediaItemsFromAlbumTransportSettings =
            GrpcCallSettings
                .<BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
                    newBuilder()
                .setMethodDescriptor(batchRemoveMediaItemsFromAlbumMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchRemoveMediaItemsFromAlbumRequest>() {
                      @Override
                      public Map<String, String> extract(
                          BatchRemoveMediaItemsFromAlbumRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("album_id", String.valueOf(request.getAlbumId()));
                        return params.build();
                      }
                    })
                .build();

    this.createAlbumCallable =
        callableFactory.createUnaryCallable(
            createAlbumTransportSettings, settings.createAlbumSettings(), clientContext);
    this.batchCreateMediaItemsCallable =
        callableFactory.createUnaryCallable(
            batchCreateMediaItemsTransportSettings,
            settings.batchCreateMediaItemsSettings(),
            clientContext);
    this.batchAddMediaItemsToAlbumCallable =
        callableFactory.createUnaryCallable(
            batchAddMediaItemsToAlbumTransportSettings,
            settings.batchAddMediaItemsToAlbumSettings(),
            clientContext);
    this.searchMediaItemsCallable =
        callableFactory.createUnaryCallable(
            searchMediaItemsTransportSettings, settings.searchMediaItemsSettings(), clientContext);
    this.searchMediaItemsPagedCallable =
        callableFactory.createPagedCallable(
            searchMediaItemsTransportSettings, settings.searchMediaItemsSettings(), clientContext);
    this.listMediaItemsCallable =
        callableFactory.createUnaryCallable(
            listMediaItemsTransportSettings, settings.listMediaItemsSettings(), clientContext);
    this.listMediaItemsPagedCallable =
        callableFactory.createPagedCallable(
            listMediaItemsTransportSettings, settings.listMediaItemsSettings(), clientContext);
    this.getMediaItemCallable =
        callableFactory.createUnaryCallable(
            getMediaItemTransportSettings, settings.getMediaItemSettings(), clientContext);
    this.batchGetMediaItemsCallable =
        callableFactory.createUnaryCallable(
            batchGetMediaItemsTransportSettings,
            settings.batchGetMediaItemsSettings(),
            clientContext);
    this.listAlbumsCallable =
        callableFactory.createUnaryCallable(
            listAlbumsTransportSettings, settings.listAlbumsSettings(), clientContext);
    this.listAlbumsPagedCallable =
        callableFactory.createPagedCallable(
            listAlbumsTransportSettings, settings.listAlbumsSettings(), clientContext);
    this.getAlbumCallable =
        callableFactory.createUnaryCallable(
            getAlbumTransportSettings, settings.getAlbumSettings(), clientContext);
    this.getSharedAlbumCallable =
        callableFactory.createUnaryCallable(
            getSharedAlbumTransportSettings, settings.getSharedAlbumSettings(), clientContext);
    this.addEnrichmentToAlbumCallable =
        callableFactory.createUnaryCallable(
            addEnrichmentToAlbumTransportSettings,
            settings.addEnrichmentToAlbumSettings(),
            clientContext);
    this.joinSharedAlbumCallable =
        callableFactory.createUnaryCallable(
            joinSharedAlbumTransportSettings, settings.joinSharedAlbumSettings(), clientContext);
    this.leaveSharedAlbumCallable =
        callableFactory.createUnaryCallable(
            leaveSharedAlbumTransportSettings, settings.leaveSharedAlbumSettings(), clientContext);
    this.shareAlbumCallable =
        callableFactory.createUnaryCallable(
            shareAlbumTransportSettings, settings.shareAlbumSettings(), clientContext);
    this.listSharedAlbumsCallable =
        callableFactory.createUnaryCallable(
            listSharedAlbumsTransportSettings, settings.listSharedAlbumsSettings(), clientContext);
    this.listSharedAlbumsPagedCallable =
        callableFactory.createPagedCallable(
            listSharedAlbumsTransportSettings, settings.listSharedAlbumsSettings(), clientContext);
    this.unshareAlbumCallable =
        callableFactory.createUnaryCallable(
            unshareAlbumTransportSettings, settings.unshareAlbumSettings(), clientContext);
    this.batchRemoveMediaItemsFromAlbumCallable =
        callableFactory.createUnaryCallable(
            batchRemoveMediaItemsFromAlbumTransportSettings,
            settings.batchRemoveMediaItemsFromAlbumSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<CreateAlbumRequest, Album> createAlbumCallable() {
    return createAlbumCallable;
  }

  public UnaryCallable<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsCallable() {
    return batchCreateMediaItemsCallable;
  }

  public UnaryCallable<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumCallable() {
    return batchAddMediaItemsToAlbumCallable;
  }

  public UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsPagedResponse>
      searchMediaItemsPagedCallable() {
    return searchMediaItemsPagedCallable;
  }

  public UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsCallable() {
    return searchMediaItemsCallable;
  }

  public UnaryCallable<ListMediaItemsRequest, ListMediaItemsPagedResponse>
      listMediaItemsPagedCallable() {
    return listMediaItemsPagedCallable;
  }

  public UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse> listMediaItemsCallable() {
    return listMediaItemsCallable;
  }

  public UnaryCallable<GetMediaItemRequest, MediaItem> getMediaItemCallable() {
    return getMediaItemCallable;
  }

  public UnaryCallable<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsCallable() {
    return batchGetMediaItemsCallable;
  }

  public UnaryCallable<ListAlbumsRequest, ListAlbumsPagedResponse> listAlbumsPagedCallable() {
    return listAlbumsPagedCallable;
  }

  public UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> listAlbumsCallable() {
    return listAlbumsCallable;
  }

  public UnaryCallable<GetAlbumRequest, Album> getAlbumCallable() {
    return getAlbumCallable;
  }

  public UnaryCallable<GetSharedAlbumRequest, Album> getSharedAlbumCallable() {
    return getSharedAlbumCallable;
  }

  public UnaryCallable<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumCallable() {
    return addEnrichmentToAlbumCallable;
  }

  public UnaryCallable<JoinSharedAlbumRequest, JoinSharedAlbumResponse> joinSharedAlbumCallable() {
    return joinSharedAlbumCallable;
  }

  public UnaryCallable<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumCallable() {
    return leaveSharedAlbumCallable;
  }

  public UnaryCallable<ShareAlbumRequest, ShareAlbumResponse> shareAlbumCallable() {
    return shareAlbumCallable;
  }

  public UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsPagedResponse>
      listSharedAlbumsPagedCallable() {
    return listSharedAlbumsPagedCallable;
  }

  public UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsCallable() {
    return listSharedAlbumsCallable;
  }

  public UnaryCallable<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumCallable() {
    return unshareAlbumCallable;
  }

  public UnaryCallable<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumCallable() {
    return batchRemoveMediaItemsFromAlbumCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
}
