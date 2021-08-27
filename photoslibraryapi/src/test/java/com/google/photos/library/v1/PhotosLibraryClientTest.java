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

package com.google.photos.library.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.photos.library.v1.internal.MockPhotosLibrary;
import com.google.photos.library.v1.proto.Filters;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import com.google.photos.library.v1.util.OrderBy;
import com.google.protobuf.AbstractMessage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhotosLibraryClientTest {
  private static MockPhotosLibrary mockPhotosLibrary;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PhotosLibraryClient client;

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
    PhotosLibrarySettings settings =
        PhotosLibrarySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PhotosLibraryClient.initialize(settings);
  }

  /**
   * Test that the orderBy parameter is generated and used correctly.
   *
   * @throws Exception
   */
  @Test
  public void searchWithOrderTest() throws Exception {
    Filters filter = Filters.newBuilder().build();

    SearchMediaItemsResponse expectedResponse = SearchMediaItemsResponse.newBuilder().build();
    mockPhotosLibrary.addResponse(expectedResponse);
    OrderBy order = OrderBy.MEDIAMETADATA_CREATION_TIME_DESC;
    client.searchMediaItems(filter, order);

    List<AbstractMessage> actualRequests = mockPhotosLibrary.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchMediaItemsRequest actualRequest = (SearchMediaItemsRequest) actualRequests.get(0);

    Assert.assertEquals("MediaMetadata.creation_time desc", actualRequest.getOrderBy());
  }
}
