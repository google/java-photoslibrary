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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse;
import com.google.photos.library.v1.proto.AlbumPosition;
import com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest;
import com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.BatchGetMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchGetMediaItemsResponse;
import com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest;
import com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse;
import com.google.photos.library.v1.proto.CreateAlbumRequest;
import com.google.photos.library.v1.proto.EnrichmentItem;
import com.google.photos.library.v1.proto.Filters;
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
import com.google.photos.library.v1.proto.MediaItemResult;
import com.google.photos.library.v1.proto.NewEnrichmentItem;
import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.proto.NewMediaItemResult;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import com.google.photos.library.v1.proto.ShareAlbumRequest;
import com.google.photos.library.v1.proto.ShareAlbumResponse;
import com.google.photos.library.v1.proto.UnshareAlbumRequest;
import com.google.photos.library.v1.proto.UnshareAlbumResponse;
import com.google.photos.library.v1.proto.UpdateAlbumRequest;
import com.google.photos.library.v1.proto.UpdateMediaItemRequest;
import com.google.photos.types.proto.Album;
import com.google.photos.types.proto.ContributorInfo;
import com.google.photos.types.proto.MediaItem;
import com.google.photos.types.proto.MediaMetadata;
import com.google.photos.types.proto.ShareInfo;
import com.google.photos.types.proto.SharedAlbumOptions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class InternalPhotosLibraryClientTest {
  private static MockPhotosLibrary mockPhotosLibrary;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private InternalPhotosLibraryClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPhotosLibrary = new MockPhotosLibrary();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPhotosLibrary));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    InternalPhotosLibrarySettings settings =
        InternalPhotosLibrarySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = InternalPhotosLibraryClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createAlbumTest() throws Exception {
    Album expectedResponse =
        Album.newBuilder()
            .setId("id3355")
            .setTitle("title110371416")
            .setProductUrl("productUrl1752999424")
            .setIsWriteable(true)
            .setShareInfo(ShareInfo.newBuilder().build())
            .setMediaItemsCount(927196149)
            .setCoverPhotoBaseUrl("coverPhotoBaseUrl389723043")
            .setCoverPhotoMediaItemId("coverPhotoMediaItemId697445591")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();

    Album actualResponse = client.createAlbum(album);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlbumRequest actualRequest = ((CreateAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();
      client.createAlbum(album);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateMediaItemsTest() throws Exception {
    BatchCreateMediaItemsResponse expectedResponse =
        BatchCreateMediaItemsResponse.newBuilder()
            .addAllNewMediaItemResults(new ArrayList<NewMediaItemResult>())
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";
    List<NewMediaItem> newMediaItems = new ArrayList<>();
    AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

    BatchCreateMediaItemsResponse actualResponse =
        client.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateMediaItemsRequest actualRequest =
        ((BatchCreateMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(newMediaItems, actualRequest.getNewMediaItemsList());
    Assert.assertEquals(albumPosition, actualRequest.getAlbumPosition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      List<NewMediaItem> newMediaItems = new ArrayList<>();
      AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
      client.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchAddMediaItemsToAlbumTest() throws Exception {
    BatchAddMediaItemsToAlbumResponse expectedResponse =
        BatchAddMediaItemsToAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";
    List<String> mediaItemIds = new ArrayList<>();

    BatchAddMediaItemsToAlbumResponse actualResponse =
        client.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchAddMediaItemsToAlbumRequest actualRequest =
        ((BatchAddMediaItemsToAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchAddMediaItemsToAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      List<String> mediaItemIds = new ArrayList<>();
      client.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMediaItemsTest() throws Exception {
    MediaItem responsesElement = MediaItem.newBuilder().build();
    SearchMediaItemsResponse expectedResponse =
        SearchMediaItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMediaItems(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Filters filters = Filters.newBuilder().build();

    SearchMediaItemsPagedResponse pagedListResponse = client.searchMediaItems(filters);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = ((SearchMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(filters, actualRequest.getFilters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Filters filters = Filters.newBuilder().build();
      client.searchMediaItems(filters);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMediaItemsTest2() throws Exception {
    MediaItem responsesElement = MediaItem.newBuilder().build();
    SearchMediaItemsResponse expectedResponse =
        SearchMediaItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMediaItems(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";

    SearchMediaItemsPagedResponse pagedListResponse = client.searchMediaItems(albumId);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = ((SearchMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMediaItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      client.searchMediaItems(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchMediaItemsTest3() throws Exception {
    MediaItem responsesElement = MediaItem.newBuilder().build();
    SearchMediaItemsResponse expectedResponse =
        SearchMediaItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMediaItems(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Filters filters = Filters.newBuilder().build();
    String orderBy = "orderBy-1207110587";

    SearchMediaItemsPagedResponse pagedListResponse = client.searchMediaItems(filters, orderBy);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = ((SearchMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(filters, actualRequest.getFilters());
    Assert.assertEquals(orderBy, actualRequest.getOrderBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchMediaItemsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Filters filters = Filters.newBuilder().build();
      String orderBy = "orderBy-1207110587";
      client.searchMediaItems(filters, orderBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMediaItemsTest() throws Exception {
    MediaItem responsesElement = MediaItem.newBuilder().build();
    ListMediaItemsResponse expectedResponse =
        ListMediaItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMediaItems(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    ListMediaItemsRequest request =
        ListMediaItemsRequest.newBuilder()
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListMediaItemsPagedResponse pagedListResponse = client.listMediaItems(request);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMediaItemsRequest actualRequest = ((ListMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      ListMediaItemsRequest request =
          ListMediaItemsRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listMediaItems(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMediaItemTest() throws Exception {
    MediaItem expectedResponse =
        MediaItem.newBuilder()
            .setId("id3355")
            .setDescription("description-1724546052")
            .setProductUrl("productUrl1752999424")
            .setBaseUrl("baseUrl-332625698")
            .setMimeType("mimeType-1392120434")
            .setMediaMetadata(MediaMetadata.newBuilder().build())
            .setContributorInfo(ContributorInfo.newBuilder().build())
            .setFilename("filename-734768633")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String mediaItemId = "mediaItemId-623842158";

    MediaItem actualResponse = client.getMediaItem(mediaItemId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMediaItemRequest actualRequest = ((GetMediaItemRequest) actualRequests.get(0));

    Assert.assertEquals(mediaItemId, actualRequest.getMediaItemId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMediaItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String mediaItemId = "mediaItemId-623842158";
      client.getMediaItem(mediaItemId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchGetMediaItemsTest() throws Exception {
    BatchGetMediaItemsResponse expectedResponse =
        BatchGetMediaItemsResponse.newBuilder()
            .addAllMediaItemResults(new ArrayList<MediaItemResult>())
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    List<String> mediaItemIds = new ArrayList<>();

    BatchGetMediaItemsResponse actualResponse = client.batchGetMediaItems(mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetMediaItemsRequest actualRequest = ((BatchGetMediaItemsRequest) actualRequests.get(0));

    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchGetMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      List<String> mediaItemIds = new ArrayList<>();
      client.batchGetMediaItems(mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAlbumsTest() throws Exception {
    Album responsesElement = Album.newBuilder().build();
    ListAlbumsResponse expectedResponse =
        ListAlbumsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAlbums(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    boolean excludeNonAppCreatedData = true;

    ListAlbumsPagedResponse pagedListResponse = client.listAlbums(excludeNonAppCreatedData);

    List<Album> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlbumsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlbumsRequest actualRequest = ((ListAlbumsRequest) actualRequests.get(0));

    Assert.assertEquals(excludeNonAppCreatedData, actualRequest.getExcludeNonAppCreatedData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAlbumsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      boolean excludeNonAppCreatedData = true;
      client.listAlbums(excludeNonAppCreatedData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAlbumTest() throws Exception {
    Album expectedResponse =
        Album.newBuilder()
            .setId("id3355")
            .setTitle("title110371416")
            .setProductUrl("productUrl1752999424")
            .setIsWriteable(true)
            .setShareInfo(ShareInfo.newBuilder().build())
            .setMediaItemsCount(927196149)
            .setCoverPhotoBaseUrl("coverPhotoBaseUrl389723043")
            .setCoverPhotoMediaItemId("coverPhotoMediaItemId697445591")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";

    Album actualResponse = client.getAlbum(albumId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlbumRequest actualRequest = ((GetAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      client.getAlbum(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSharedAlbumTest() throws Exception {
    Album expectedResponse =
        Album.newBuilder()
            .setId("id3355")
            .setTitle("title110371416")
            .setProductUrl("productUrl1752999424")
            .setIsWriteable(true)
            .setShareInfo(ShareInfo.newBuilder().build())
            .setMediaItemsCount(927196149)
            .setCoverPhotoBaseUrl("coverPhotoBaseUrl389723043")
            .setCoverPhotoMediaItemId("coverPhotoMediaItemId697445591")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken-1798271654";

    Album actualResponse = client.getSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSharedAlbumRequest actualRequest = ((GetSharedAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken-1798271654";
      client.getSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addEnrichmentToAlbumTest() throws Exception {
    AddEnrichmentToAlbumResponse expectedResponse =
        AddEnrichmentToAlbumResponse.newBuilder()
            .setEnrichmentItem(EnrichmentItem.newBuilder().build())
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";
    NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
    AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

    AddEnrichmentToAlbumResponse actualResponse =
        client.addEnrichmentToAlbum(albumId, newEnrichmentItem, albumPosition);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddEnrichmentToAlbumRequest actualRequest =
        ((AddEnrichmentToAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(newEnrichmentItem, actualRequest.getNewEnrichmentItem());
    Assert.assertEquals(albumPosition, actualRequest.getAlbumPosition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addEnrichmentToAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
      AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
      client.addEnrichmentToAlbum(albumId, newEnrichmentItem, albumPosition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void joinSharedAlbumTest() throws Exception {
    JoinSharedAlbumResponse expectedResponse =
        JoinSharedAlbumResponse.newBuilder().setAlbum(Album.newBuilder().build()).build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken-1798271654";

    JoinSharedAlbumResponse actualResponse = client.joinSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    JoinSharedAlbumRequest actualRequest = ((JoinSharedAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void joinSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken-1798271654";
      client.joinSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void leaveSharedAlbumTest() throws Exception {
    LeaveSharedAlbumResponse expectedResponse = LeaveSharedAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken-1798271654";

    LeaveSharedAlbumResponse actualResponse = client.leaveSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LeaveSharedAlbumRequest actualRequest = ((LeaveSharedAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void leaveSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken-1798271654";
      client.leaveSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void shareAlbumTest() throws Exception {
    ShareAlbumResponse expectedResponse =
        ShareAlbumResponse.newBuilder().setShareInfo(ShareInfo.newBuilder().build()).build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";
    SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();

    ShareAlbumResponse actualResponse = client.shareAlbum(albumId, sharedAlbumOptions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShareAlbumRequest actualRequest = ((ShareAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(sharedAlbumOptions, actualRequest.getSharedAlbumOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void shareAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();
      client.shareAlbum(albumId, sharedAlbumOptions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSharedAlbumsTest() throws Exception {
    Album responsesElement = Album.newBuilder().build();
    ListSharedAlbumsResponse expectedResponse =
        ListSharedAlbumsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSharedAlbums(Arrays.asList(responsesElement))
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    boolean excludeNonAppCreatedData = true;

    ListSharedAlbumsPagedResponse pagedListResponse =
        client.listSharedAlbums(excludeNonAppCreatedData);

    List<Album> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSharedAlbumsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSharedAlbumsRequest actualRequest = ((ListSharedAlbumsRequest) actualRequests.get(0));

    Assert.assertEquals(excludeNonAppCreatedData, actualRequest.getExcludeNonAppCreatedData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSharedAlbumsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      boolean excludeNonAppCreatedData = true;
      client.listSharedAlbums(excludeNonAppCreatedData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unshareAlbumTest() throws Exception {
    UnshareAlbumResponse expectedResponse = UnshareAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";

    UnshareAlbumResponse actualResponse = client.unshareAlbum(albumId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnshareAlbumRequest actualRequest = ((UnshareAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unshareAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      client.unshareAlbum(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchRemoveMediaItemsFromAlbumTest() throws Exception {
    BatchRemoveMediaItemsFromAlbumResponse expectedResponse =
        BatchRemoveMediaItemsFromAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId-920410134";
    List<String> mediaItemIds = new ArrayList<>();

    BatchRemoveMediaItemsFromAlbumResponse actualResponse =
        client.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRemoveMediaItemsFromAlbumRequest actualRequest =
        ((BatchRemoveMediaItemsFromAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchRemoveMediaItemsFromAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId-920410134";
      List<String> mediaItemIds = new ArrayList<>();
      client.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAlbumTest() throws Exception {
    Album expectedResponse =
        Album.newBuilder()
            .setId("id3355")
            .setTitle("title110371416")
            .setProductUrl("productUrl1752999424")
            .setIsWriteable(true)
            .setShareInfo(ShareInfo.newBuilder().build())
            .setMediaItemsCount(927196149)
            .setCoverPhotoBaseUrl("coverPhotoBaseUrl389723043")
            .setCoverPhotoMediaItemId("coverPhotoMediaItemId697445591")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();

    Album actualResponse = client.updateAlbum(album);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlbumRequest actualRequest = ((UpdateAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();
      client.updateAlbum(album);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAlbumTest2() throws Exception {
    Album expectedResponse =
        Album.newBuilder()
            .setId("id3355")
            .setTitle("title110371416")
            .setProductUrl("productUrl1752999424")
            .setIsWriteable(true)
            .setShareInfo(ShareInfo.newBuilder().build())
            .setMediaItemsCount(927196149)
            .setCoverPhotoBaseUrl("coverPhotoBaseUrl389723043")
            .setCoverPhotoMediaItemId("coverPhotoMediaItemId697445591")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Album actualResponse = client.updateAlbum(album, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlbumRequest actualRequest = ((UpdateAlbumRequest) actualRequests.get(0));

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAlbumExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAlbum(album, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMediaItemTest() throws Exception {
    MediaItem expectedResponse =
        MediaItem.newBuilder()
            .setId("id3355")
            .setDescription("description-1724546052")
            .setProductUrl("productUrl1752999424")
            .setBaseUrl("baseUrl-332625698")
            .setMimeType("mimeType-1392120434")
            .setMediaMetadata(MediaMetadata.newBuilder().build())
            .setContributorInfo(ContributorInfo.newBuilder().build())
            .setFilename("filename-734768633")
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    MediaItem mediaItem = MediaItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MediaItem actualResponse = client.updateMediaItem(mediaItem, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMediaItemRequest actualRequest = ((UpdateMediaItemRequest) actualRequests.get(0));

    Assert.assertEquals(mediaItem, actualRequest.getMediaItem());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMediaItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      MediaItem mediaItem = MediaItem.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMediaItem(mediaItem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
