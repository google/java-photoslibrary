/*
 * Copyright 2020 Google LLC
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
import com.google.photos.library.v1.proto.NewEnrichmentItem;
import com.google.photos.library.v1.proto.NewMediaItem;
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
import com.google.photos.types.proto.SharedAlbumOptions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class InternalPhotosLibraryClientTest {
  private static MockPhotosLibrary mockPhotosLibrary;
  private static MockServiceHelper serviceHelper;
  private InternalPhotosLibraryClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockPhotosLibrary = new MockPhotosLibrary();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockPhotosLibrary));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void createAlbumTest() {
    String id = "id3355";
    String title = "title110371416";
    String productUrl = "productUrl-1491291617";
    boolean isWriteable = true;
    long mediaItemsCount = 927196149L;
    String coverPhotoBaseUrl = "coverPhotoBaseUrl145443830";
    String coverPhotoMediaItemId = "coverPhotoMediaItemId840621207";
    Album expectedResponse =
        Album.newBuilder()
            .setId(id)
            .setTitle(title)
            .setProductUrl(productUrl)
            .setIsWriteable(isWriteable)
            .setMediaItemsCount(mediaItemsCount)
            .setCoverPhotoBaseUrl(coverPhotoBaseUrl)
            .setCoverPhotoMediaItemId(coverPhotoMediaItemId)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();

    Album actualResponse = client.createAlbum(album);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAlbumRequest actualRequest = (CreateAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();

      client.createAlbum(album);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateMediaItemsTest() {
    BatchCreateMediaItemsResponse expectedResponse =
        BatchCreateMediaItemsResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";
    List<NewMediaItem> newMediaItems = new ArrayList<>();
    AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

    BatchCreateMediaItemsResponse actualResponse =
        client.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateMediaItemsRequest actualRequest =
        (BatchCreateMediaItemsRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(newMediaItems, actualRequest.getNewMediaItemsList());
    Assert.assertEquals(albumPosition, actualRequest.getAlbumPosition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";
      List<NewMediaItem> newMediaItems = new ArrayList<>();
      AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

      client.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchAddMediaItemsToAlbumTest() {
    BatchAddMediaItemsToAlbumResponse expectedResponse =
        BatchAddMediaItemsToAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";
    List<String> mediaItemIds = new ArrayList<>();

    BatchAddMediaItemsToAlbumResponse actualResponse =
        client.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchAddMediaItemsToAlbumRequest actualRequest =
        (BatchAddMediaItemsToAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchAddMediaItemsToAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";
      List<String> mediaItemIds = new ArrayList<>();

      client.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchMediaItemsTest() {
    String nextPageToken = "";
    MediaItem mediaItemsElement = MediaItem.newBuilder().build();
    List<MediaItem> mediaItems = Arrays.asList(mediaItemsElement);
    SearchMediaItemsResponse expectedResponse =
        SearchMediaItemsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllMediaItems(mediaItems)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";

    SearchMediaItemsPagedResponse pagedListResponse = client.searchMediaItems(albumId);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = (SearchMediaItemsRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";

      client.searchMediaItems(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void searchMediaItemsTest2() {
    String nextPageToken = "";
    MediaItem mediaItemsElement = MediaItem.newBuilder().build();
    List<MediaItem> mediaItems = Arrays.asList(mediaItemsElement);
    SearchMediaItemsResponse expectedResponse =
        SearchMediaItemsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllMediaItems(mediaItems)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";

    SearchMediaItemsPagedResponse pagedListResponse = client.searchMediaItems(albumId);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = (SearchMediaItemsRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchMediaItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";

      client.searchMediaItems(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listMediaItemsTest() {
    String nextPageToken = "";
    MediaItem mediaItemsElement = MediaItem.newBuilder().build();
    List<MediaItem> mediaItems = Arrays.asList(mediaItemsElement);
    ListMediaItemsResponse expectedResponse =
        ListMediaItemsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllMediaItems(mediaItems)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    ListMediaItemsRequest request = ListMediaItemsRequest.newBuilder().build();

    ListMediaItemsPagedResponse pagedListResponse = client.listMediaItems(request);

    List<MediaItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMediaItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMediaItemsRequest actualRequest = (ListMediaItemsRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      ListMediaItemsRequest request = ListMediaItemsRequest.newBuilder().build();

      client.listMediaItems(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getMediaItemTest() {
    String id = "id3355";
    String description = "description-1724546052";
    String productUrl = "productUrl-1491291617";
    String baseUrl = "baseUrl-1721160959";
    String mimeType = "mimeType-196041627";
    String filename = "filename-734768633";
    MediaItem expectedResponse =
        MediaItem.newBuilder()
            .setId(id)
            .setDescription(description)
            .setProductUrl(productUrl)
            .setBaseUrl(baseUrl)
            .setMimeType(mimeType)
            .setFilename(filename)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String mediaItemId = "mediaItemId720743532";

    MediaItem actualResponse = client.getMediaItem(mediaItemId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMediaItemRequest actualRequest = (GetMediaItemRequest) actualRequests.get(0);

    Assert.assertEquals(mediaItemId, actualRequest.getMediaItemId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getMediaItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String mediaItemId = "mediaItemId720743532";

      client.getMediaItem(mediaItemId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetMediaItemsTest() {
    BatchGetMediaItemsResponse expectedResponse = BatchGetMediaItemsResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    List<String> mediaItemIds = new ArrayList<>();

    BatchGetMediaItemsResponse actualResponse = client.batchGetMediaItems(mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchGetMediaItemsRequest actualRequest = (BatchGetMediaItemsRequest) actualRequests.get(0);

    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchGetMediaItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      List<String> mediaItemIds = new ArrayList<>();

      client.batchGetMediaItems(mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listAlbumsTest() {
    String nextPageToken = "";
    Album albumsElement = Album.newBuilder().build();
    List<Album> albums = Arrays.asList(albumsElement);
    ListAlbumsResponse expectedResponse =
        ListAlbumsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllAlbums(albums)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    boolean excludeNonAppCreatedData = true;

    ListAlbumsPagedResponse pagedListResponse = client.listAlbums(excludeNonAppCreatedData);

    List<Album> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAlbumsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAlbumsRequest actualRequest = (ListAlbumsRequest) actualRequests.get(0);

    Assert.assertEquals(excludeNonAppCreatedData, actualRequest.getExcludeNonAppCreatedData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listAlbumsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      boolean excludeNonAppCreatedData = true;

      client.listAlbums(excludeNonAppCreatedData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getAlbumTest() {
    String id = "id3355";
    String title = "title110371416";
    String productUrl = "productUrl-1491291617";
    boolean isWriteable = true;
    long mediaItemsCount = 927196149L;
    String coverPhotoBaseUrl = "coverPhotoBaseUrl145443830";
    String coverPhotoMediaItemId = "coverPhotoMediaItemId840621207";
    Album expectedResponse =
        Album.newBuilder()
            .setId(id)
            .setTitle(title)
            .setProductUrl(productUrl)
            .setIsWriteable(isWriteable)
            .setMediaItemsCount(mediaItemsCount)
            .setCoverPhotoBaseUrl(coverPhotoBaseUrl)
            .setCoverPhotoMediaItemId(coverPhotoMediaItemId)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";

    Album actualResponse = client.getAlbum(albumId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAlbumRequest actualRequest = (GetAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";

      client.getAlbum(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getSharedAlbumTest() {
    String id = "id3355";
    String title = "title110371416";
    String productUrl = "productUrl-1491291617";
    boolean isWriteable = true;
    long mediaItemsCount = 927196149L;
    String coverPhotoBaseUrl = "coverPhotoBaseUrl145443830";
    String coverPhotoMediaItemId = "coverPhotoMediaItemId840621207";
    Album expectedResponse =
        Album.newBuilder()
            .setId(id)
            .setTitle(title)
            .setProductUrl(productUrl)
            .setIsWriteable(isWriteable)
            .setMediaItemsCount(mediaItemsCount)
            .setCoverPhotoBaseUrl(coverPhotoBaseUrl)
            .setCoverPhotoMediaItemId(coverPhotoMediaItemId)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken407816601";

    Album actualResponse = client.getSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSharedAlbumRequest actualRequest = (GetSharedAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken407816601";

      client.getSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void addEnrichmentToAlbumTest() {
    AddEnrichmentToAlbumResponse expectedResponse =
        AddEnrichmentToAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";
    NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
    AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

    AddEnrichmentToAlbumResponse actualResponse =
        client.addEnrichmentToAlbum(albumId, newEnrichmentItem, albumPosition);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddEnrichmentToAlbumRequest actualRequest = (AddEnrichmentToAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(newEnrichmentItem, actualRequest.getNewEnrichmentItem());
    Assert.assertEquals(albumPosition, actualRequest.getAlbumPosition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void addEnrichmentToAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";
      NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
      AlbumPosition albumPosition = AlbumPosition.newBuilder().build();

      client.addEnrichmentToAlbum(albumId, newEnrichmentItem, albumPosition);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void joinSharedAlbumTest() {
    JoinSharedAlbumResponse expectedResponse = JoinSharedAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken407816601";

    JoinSharedAlbumResponse actualResponse = client.joinSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    JoinSharedAlbumRequest actualRequest = (JoinSharedAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void joinSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken407816601";

      client.joinSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void leaveSharedAlbumTest() {
    LeaveSharedAlbumResponse expectedResponse = LeaveSharedAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String shareToken = "shareToken407816601";

    LeaveSharedAlbumResponse actualResponse = client.leaveSharedAlbum(shareToken);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LeaveSharedAlbumRequest actualRequest = (LeaveSharedAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(shareToken, actualRequest.getShareToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void leaveSharedAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String shareToken = "shareToken407816601";

      client.leaveSharedAlbum(shareToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void shareAlbumTest() {
    ShareAlbumResponse expectedResponse = ShareAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";
    SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();

    ShareAlbumResponse actualResponse = client.shareAlbum(albumId, sharedAlbumOptions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ShareAlbumRequest actualRequest = (ShareAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(sharedAlbumOptions, actualRequest.getSharedAlbumOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void shareAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";
      SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();

      client.shareAlbum(albumId, sharedAlbumOptions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listSharedAlbumsTest() {
    String nextPageToken = "";
    Album sharedAlbumsElement = Album.newBuilder().build();
    List<Album> sharedAlbums = Arrays.asList(sharedAlbumsElement);
    ListSharedAlbumsResponse expectedResponse =
        ListSharedAlbumsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllSharedAlbums(sharedAlbums)
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
    ListSharedAlbumsRequest actualRequest = (ListSharedAlbumsRequest) actualRequests.get(0);

    Assert.assertEquals(excludeNonAppCreatedData, actualRequest.getExcludeNonAppCreatedData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listSharedAlbumsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      boolean excludeNonAppCreatedData = true;

      client.listSharedAlbums(excludeNonAppCreatedData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void unshareAlbumTest() {
    UnshareAlbumResponse expectedResponse = UnshareAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";

    UnshareAlbumResponse actualResponse = client.unshareAlbum(albumId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnshareAlbumRequest actualRequest = (UnshareAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void unshareAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";

      client.unshareAlbum(albumId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchRemoveMediaItemsFromAlbumTest() {
    BatchRemoveMediaItemsFromAlbumResponse expectedResponse =
        BatchRemoveMediaItemsFromAlbumResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);

    String albumId = "albumId1532078315";
    List<String> mediaItemIds = new ArrayList<>();

    BatchRemoveMediaItemsFromAlbumResponse actualResponse =
        client.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchRemoveMediaItemsFromAlbumRequest actualRequest =
        (BatchRemoveMediaItemsFromAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(albumId, actualRequest.getAlbumId());
    Assert.assertEquals(mediaItemIds, actualRequest.getMediaItemIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchRemoveMediaItemsFromAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      String albumId = "albumId1532078315";
      List<String> mediaItemIds = new ArrayList<>();

      client.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlbumTest() {
    String id = "id3355";
    String title = "title110371416";
    String productUrl = "productUrl-1491291617";
    boolean isWriteable = true;
    long mediaItemsCount = 927196149L;
    String coverPhotoBaseUrl = "coverPhotoBaseUrl145443830";
    String coverPhotoMediaItemId = "coverPhotoMediaItemId840621207";
    Album expectedResponse =
        Album.newBuilder()
            .setId(id)
            .setTitle(title)
            .setProductUrl(productUrl)
            .setIsWriteable(isWriteable)
            .setMediaItemsCount(mediaItemsCount)
            .setCoverPhotoBaseUrl(coverPhotoBaseUrl)
            .setCoverPhotoMediaItemId(coverPhotoMediaItemId)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();

    Album actualResponse = client.updateAlbum(album);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlbumRequest actualRequest = (UpdateAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlbumExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();

      client.updateAlbum(album);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlbumTest2() {
    String id = "id3355";
    String title = "title110371416";
    String productUrl = "productUrl-1491291617";
    boolean isWriteable = true;
    long mediaItemsCount = 927196149L;
    String coverPhotoBaseUrl = "coverPhotoBaseUrl145443830";
    String coverPhotoMediaItemId = "coverPhotoMediaItemId840621207";
    Album expectedResponse =
        Album.newBuilder()
            .setId(id)
            .setTitle(title)
            .setProductUrl(productUrl)
            .setIsWriteable(isWriteable)
            .setMediaItemsCount(mediaItemsCount)
            .setCoverPhotoBaseUrl(coverPhotoBaseUrl)
            .setCoverPhotoMediaItemId(coverPhotoMediaItemId)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    Album album = Album.newBuilder().build();

    Album actualResponse = client.updateAlbum(album);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAlbumRequest actualRequest = (UpdateAlbumRequest) actualRequests.get(0);

    Assert.assertEquals(album, actualRequest.getAlbum());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateAlbumExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      Album album = Album.newBuilder().build();

      client.updateAlbum(album);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateMediaItemTest() {
    String id = "id3355";
    String description = "description-1724546052";
    String productUrl = "productUrl-1491291617";
    String baseUrl = "baseUrl-1721160959";
    String mimeType = "mimeType-196041627";
    String filename = "filename-734768633";
    MediaItem expectedResponse =
        MediaItem.newBuilder()
            .setId(id)
            .setDescription(description)
            .setProductUrl(productUrl)
            .setBaseUrl(baseUrl)
            .setMimeType(mimeType)
            .setFilename(filename)
            .build();
    mockPhotosLibrary.addResponse(expectedResponse);

    MediaItem mediaItem = MediaItem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MediaItem actualResponse = client.updateMediaItem(mediaItem, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMediaItemRequest actualRequest = (UpdateMediaItemRequest) actualRequests.get(0);

    Assert.assertEquals(mediaItem, actualRequest.getMediaItem());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateMediaItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockPhotosLibrary.addException(exception);

    try {
      MediaItem mediaItem = MediaItem.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateMediaItem(mediaItem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
