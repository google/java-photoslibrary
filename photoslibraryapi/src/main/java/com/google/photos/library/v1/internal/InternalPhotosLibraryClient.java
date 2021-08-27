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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.photos.library.v1.internal.stub.PhotosLibraryStub;
import com.google.photos.library.v1.internal.stub.PhotosLibraryStubSettings;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service which allows developers to perform the following actions on behalf
 * of the user: - upload media items directly to their Google Photos library - create albums - add
 * media items (including album enrichments) to albums - list and download content from their Google
 * Photos library - filter results by media type, date range or content category - create, join, and
 * access shared albums
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create()) {
 *   Album album = Album.newBuilder().build();
 *   Album response = internalPhotosLibraryClient.createAlbum(album);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the InternalPhotosLibraryClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of InternalPhotosLibrarySettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * InternalPhotosLibrarySettings internalPhotosLibrarySettings =
 *     InternalPhotosLibrarySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create(internalPhotosLibrarySettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * InternalPhotosLibrarySettings internalPhotosLibrarySettings =
 *     InternalPhotosLibrarySettings.newBuilder().setEndpoint(myEndpoint).build();
 * InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create(internalPhotosLibrarySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class InternalPhotosLibraryClient implements BackgroundResource {
  private final InternalPhotosLibrarySettings settings;
  private final PhotosLibraryStub stub;

  /** Constructs an instance of InternalPhotosLibraryClient with default settings. */
  public static final InternalPhotosLibraryClient create() throws IOException {
    return create(InternalPhotosLibrarySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InternalPhotosLibraryClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InternalPhotosLibraryClient create(InternalPhotosLibrarySettings settings)
      throws IOException {
    return new InternalPhotosLibraryClient(settings);
  }

  /**
   * Constructs an instance of InternalPhotosLibraryClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(InternalPhotosLibrarySettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InternalPhotosLibraryClient create(PhotosLibraryStub stub) {
    return new InternalPhotosLibraryClient(stub);
  }

  /**
   * Constructs an instance of InternalPhotosLibraryClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InternalPhotosLibraryClient(InternalPhotosLibrarySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PhotosLibraryStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InternalPhotosLibraryClient(PhotosLibraryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InternalPhotosLibrarySettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PhotosLibraryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   Album response = internalPhotosLibraryClient.createAlbum(album);
   * }
   * }</pre>
   *
   * @param album Required. The album to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album createAlbum(Album album) {
    CreateAlbumRequest request = CreateAlbumRequest.newBuilder().setAlbum(album).build();
    return createAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   CreateAlbumRequest request =
   *       CreateAlbumRequest.newBuilder().setAlbum(Album.newBuilder().build()).build();
   *   Album response = internalPhotosLibraryClient.createAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album createAlbum(CreateAlbumRequest request) {
    return createAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   CreateAlbumRequest request =
   *       CreateAlbumRequest.newBuilder().setAlbum(Album.newBuilder().build()).build();
   *   ApiFuture<Album> future =
   *       internalPhotosLibraryClient.createAlbumCallable().futureCall(request);
   *   // Do something.
   *   Album response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAlbumRequest, Album> createAlbumCallable() {
    return stub.createAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. Each album can contain up to 20,000 media items. By default,
   * the media item will be added to the end of the library or album.
   *
   * <p>If an album `id` and position are both defined, the media item is added to the album at the
   * specified position.
   *
   * <p>If the call contains multiple media items, they're added at the specified position. If you
   * are creating a media item in a shared album where you are not the owner, you are not allowed to
   * position the media item. Doing so will result in a `BAD REQUEST` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   List<NewMediaItem> newMediaItems = new ArrayList<>();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   BatchCreateMediaItemsResponse response =
   *       internalPhotosLibraryClient.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
   * }
   * }</pre>
   *
   * @param albumId Identifier of the album where the media items are added. The media items are
   *     also added to the user's library. This is an optional field.
   * @param newMediaItems Required. List of media items to be created.
   * @param albumPosition Position in the album where the media items are added. If not specified,
   *     the media items are added to the end of the album (as per the default value, that is,
   *     `LAST_IN_ALBUM`). The request fails if this field is set and the `albumId` is not
   *     specified. The request will also fail if you set the field and are not the owner of the
   *     shared album.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMediaItemsResponse batchCreateMediaItems(
      String albumId, List<NewMediaItem> newMediaItems, AlbumPosition albumPosition) {
    BatchCreateMediaItemsRequest request =
        BatchCreateMediaItemsRequest.newBuilder()
            .setAlbumId(albumId)
            .addAllNewMediaItems(newMediaItems)
            .setAlbumPosition(albumPosition)
            .build();
    return batchCreateMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. Each album can contain up to 20,000 media items. By default,
   * the media item will be added to the end of the library or album.
   *
   * <p>If an album `id` and position are both defined, the media item is added to the album at the
   * specified position.
   *
   * <p>If the call contains multiple media items, they're added at the specified position. If you
   * are creating a media item in a shared album where you are not the owner, you are not allowed to
   * position the media item. Doing so will result in a `BAD REQUEST` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchCreateMediaItemsRequest request =
   *       BatchCreateMediaItemsRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .addAllNewMediaItems(new ArrayList<NewMediaItem>())
   *           .setAlbumPosition(AlbumPosition.newBuilder().build())
   *           .build();
   *   BatchCreateMediaItemsResponse response =
   *       internalPhotosLibraryClient.batchCreateMediaItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMediaItemsResponse batchCreateMediaItems(
      BatchCreateMediaItemsRequest request) {
    return batchCreateMediaItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. Each album can contain up to 20,000 media items. By default,
   * the media item will be added to the end of the library or album.
   *
   * <p>If an album `id` and position are both defined, the media item is added to the album at the
   * specified position.
   *
   * <p>If the call contains multiple media items, they're added at the specified position. If you
   * are creating a media item in a shared album where you are not the owner, you are not allowed to
   * position the media item. Doing so will result in a `BAD REQUEST` error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchCreateMediaItemsRequest request =
   *       BatchCreateMediaItemsRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .addAllNewMediaItems(new ArrayList<NewMediaItem>())
   *           .setAlbumPosition(AlbumPosition.newBuilder().build())
   *           .build();
   *   ApiFuture<BatchCreateMediaItemsResponse> future =
   *       internalPhotosLibraryClient.batchCreateMediaItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateMediaItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsCallable() {
    return stub.batchCreateMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more media items in a user's Google Photos library to an album. The media items and
   * albums must have been created by the developer via the API.
   *
   * <p>Media items are added to the end of the album. If multiple media items are given, they are
   * added in the order specified in this call.
   *
   * <p>Each album can contain up to 20,000 media items.
   *
   * <p>Only media items that are in the user's library can be added to an album. For albums that
   * are shared, the album must either be owned by the user or the user must have joined the album
   * as a collaborator.
   *
   * <p>Partial success is not supported. The entire request will fail if an invalid media item or
   * album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   List<String> mediaItemIds = new ArrayList<>();
   *   BatchAddMediaItemsToAlbumResponse response =
   *       internalPhotosLibraryClient.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the [Album][google.photos.types.Album] that the media
   *     items are added to.
   * @param mediaItemIds Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   *     be added. The maximum number of media items that can be added in one call is 50.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAddMediaItemsToAlbumResponse batchAddMediaItemsToAlbum(
      String albumId, List<String> mediaItemIds) {
    BatchAddMediaItemsToAlbumRequest request =
        BatchAddMediaItemsToAlbumRequest.newBuilder()
            .setAlbumId(albumId)
            .addAllMediaItemIds(mediaItemIds)
            .build();
    return batchAddMediaItemsToAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more media items in a user's Google Photos library to an album. The media items and
   * albums must have been created by the developer via the API.
   *
   * <p>Media items are added to the end of the album. If multiple media items are given, they are
   * added in the order specified in this call.
   *
   * <p>Each album can contain up to 20,000 media items.
   *
   * <p>Only media items that are in the user's library can be added to an album. For albums that
   * are shared, the album must either be owned by the user or the user must have joined the album
   * as a collaborator.
   *
   * <p>Partial success is not supported. The entire request will fail if an invalid media item or
   * album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchAddMediaItemsToAlbumRequest request =
   *       BatchAddMediaItemsToAlbumRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .setAlbumId("albumId-920410134")
   *           .build();
   *   BatchAddMediaItemsToAlbumResponse response =
   *       internalPhotosLibraryClient.batchAddMediaItemsToAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAddMediaItemsToAlbumResponse batchAddMediaItemsToAlbum(
      BatchAddMediaItemsToAlbumRequest request) {
    return batchAddMediaItemsToAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds one or more media items in a user's Google Photos library to an album. The media items and
   * albums must have been created by the developer via the API.
   *
   * <p>Media items are added to the end of the album. If multiple media items are given, they are
   * added in the order specified in this call.
   *
   * <p>Each album can contain up to 20,000 media items.
   *
   * <p>Only media items that are in the user's library can be added to an album. For albums that
   * are shared, the album must either be owned by the user or the user must have joined the album
   * as a collaborator.
   *
   * <p>Partial success is not supported. The entire request will fail if an invalid media item or
   * album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchAddMediaItemsToAlbumRequest request =
   *       BatchAddMediaItemsToAlbumRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .setAlbumId("albumId-920410134")
   *           .build();
   *   ApiFuture<BatchAddMediaItemsToAlbumResponse> future =
   *       internalPhotosLibraryClient.batchAddMediaItemsToAlbumCallable().futureCall(request);
   *   // Do something.
   *   BatchAddMediaItemsToAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumCallable() {
    return stub.batchAddMediaItemsToAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   Filters filters = Filters.newBuilder().build();
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(filters).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param filters Filters to apply to the request. Can't be set in conjunction with an `albumId`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(Filters filters) {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setFilters(filters).build();
    return searchMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(albumId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param albumId Identifier of an album. If populated, lists all media items in specified album.
   *     Can't set in conjunction with any filters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(String albumId) {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setAlbumId(albumId).build();
    return searchMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   Filters filters = Filters.newBuilder().build();
   *   String orderBy = "orderBy-1207110587";
   *   for (MediaItem element :
   *       internalPhotosLibraryClient.searchMediaItems(filters, orderBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param filters Filters to apply to the request. Can't be set in conjunction with an `albumId`.
   * @param orderBy An optional field to specify the sort order of the search results. The `orderBy`
   *     field only works when a [dateFilter][google.photos.library.v1.DateFilter] is used. When
   *     this field is not specified, results are displayed newest first, oldest last by their
   *     [creationTime][google.photos.types.MediaMetadata.creation_time]. Providing
   *     `MediaMetadata.creation_time` displays search results in the opposite order, oldest first
   *     then newest last. To display results newest first then oldest last, include the `desc`
   *     argument as follows: `MediaMetadata.creation_time desc`.
   *     <p>The only additional filters that can be used with this parameter are
   *     [includeArchivedMedia][google.photos.library.v1.Filters.include_archived_media] and
   *     [excludeNonAppCreatedData][google.photos.library.v1.Filters.exclude_non_app_created_data].
   *     No other filters are supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(Filters filters, String orderBy) {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setFilters(filters).setOrderBy(orderBy).build();
    return searchMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request =
   *       SearchMediaItemsRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilters(Filters.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(SearchMediaItemsRequest request) {
    return searchMediaItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request =
   *       SearchMediaItemsRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilters(Filters.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MediaItem> future =
   *       internalPhotosLibraryClient.searchMediaItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MediaItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsPagedResponse>
      searchMediaItemsPagedCallable() {
    return stub.searchMediaItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request =
   *       SearchMediaItemsRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilters(Filters.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     SearchMediaItemsResponse response =
   *         internalPhotosLibraryClient.searchMediaItemsCallable().call(request);
   *     for (MediaItem element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsCallable() {
    return stub.searchMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request =
   *       ListMediaItemsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MediaItem element : internalPhotosLibraryClient.listMediaItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMediaItemsPagedResponse listMediaItems(ListMediaItemsRequest request) {
    return listMediaItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request =
   *       ListMediaItemsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MediaItem> future =
   *       internalPhotosLibraryClient.listMediaItemsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MediaItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMediaItemsRequest, ListMediaItemsPagedResponse>
      listMediaItemsPagedCallable() {
    return stub.listMediaItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request =
   *       ListMediaItemsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMediaItemsResponse response =
   *         internalPhotosLibraryClient.listMediaItemsCallable().call(request);
   *     for (MediaItem element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse>
      listMediaItemsCallable() {
    return stub.listMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String mediaItemId = "mediaItemId-623842158";
   *   MediaItem response = internalPhotosLibraryClient.getMediaItem(mediaItemId);
   * }
   * }</pre>
   *
   * @param mediaItemId Required. Identifier of the media item to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem getMediaItem(String mediaItemId) {
    GetMediaItemRequest request =
        GetMediaItemRequest.newBuilder().setMediaItemId(mediaItemId).build();
    return getMediaItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetMediaItemRequest request =
   *       GetMediaItemRequest.newBuilder().setMediaItemId("mediaItemId-623842158").build();
   *   MediaItem response = internalPhotosLibraryClient.getMediaItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem getMediaItem(GetMediaItemRequest request) {
    return getMediaItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetMediaItemRequest request =
   *       GetMediaItemRequest.newBuilder().setMediaItemId("mediaItemId-623842158").build();
   *   ApiFuture<MediaItem> future =
   *       internalPhotosLibraryClient.getMediaItemCallable().futureCall(request);
   *   // Do something.
   *   MediaItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMediaItemRequest, MediaItem> getMediaItemCallable() {
    return stub.getMediaItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   List<String> mediaItemIds = new ArrayList<>();
   *   BatchGetMediaItemsResponse response =
   *       internalPhotosLibraryClient.batchGetMediaItems(mediaItemIds);
   * }
   * }</pre>
   *
   * @param mediaItemIds Required. Identifiers of the media items to be requested. Must not contain
   *     repeated identifiers and cannot be empty. The maximum number of media items that can be
   *     retrieved in one call is 50.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetMediaItemsResponse batchGetMediaItems(List<String> mediaItemIds) {
    BatchGetMediaItemsRequest request =
        BatchGetMediaItemsRequest.newBuilder().addAllMediaItemIds(mediaItemIds).build();
    return batchGetMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchGetMediaItemsRequest request =
   *       BatchGetMediaItemsRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .build();
   *   BatchGetMediaItemsResponse response = internalPhotosLibraryClient.batchGetMediaItems(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetMediaItemsResponse batchGetMediaItems(BatchGetMediaItemsRequest request) {
    return batchGetMediaItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchGetMediaItemsRequest request =
   *       BatchGetMediaItemsRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchGetMediaItemsResponse> future =
   *       internalPhotosLibraryClient.batchGetMediaItemsCallable().futureCall(request);
   *   // Do something.
   *   BatchGetMediaItemsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsCallable() {
    return stub.batchGetMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   boolean excludeNonAppCreatedData = true;
   *   for (Album element :
   *       internalPhotosLibraryClient.listAlbums(excludeNonAppCreatedData).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param excludeNonAppCreatedData If set, the results exclude media items that were not created
   *     by this app. Defaults to false (all albums are returned). This field is ignored if the
   *     photoslibrary.readonly.appcreateddata scope is used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAlbumsPagedResponse listAlbums(boolean excludeNonAppCreatedData) {
    ListAlbumsRequest request =
        ListAlbumsRequest.newBuilder()
            .setExcludeNonAppCreatedData(excludeNonAppCreatedData)
            .build();
    return listAlbums(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request =
   *       ListAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   for (Album element : internalPhotosLibraryClient.listAlbums(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAlbumsPagedResponse listAlbums(ListAlbumsRequest request) {
    return listAlbumsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request =
   *       ListAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   ApiFuture<Album> future =
   *       internalPhotosLibraryClient.listAlbumsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Album element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAlbumsRequest, ListAlbumsPagedResponse> listAlbumsPagedCallable() {
    return stub.listAlbumsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request =
   *       ListAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   while (true) {
   *     ListAlbumsResponse response =
   *         internalPhotosLibraryClient.listAlbumsCallable().call(request);
   *     for (Album element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> listAlbumsCallable() {
    return stub.listAlbumsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   Album response = internalPhotosLibraryClient.getAlbum(albumId);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the album to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getAlbum(String albumId) {
    GetAlbumRequest request = GetAlbumRequest.newBuilder().setAlbumId(albumId).build();
    return getAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetAlbumRequest request =
   *       GetAlbumRequest.newBuilder().setAlbumId("albumId-920410134").build();
   *   Album response = internalPhotosLibraryClient.getAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getAlbum(GetAlbumRequest request) {
    return getAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetAlbumRequest request =
   *       GetAlbumRequest.newBuilder().setAlbumId("albumId-920410134").build();
   *   ApiFuture<Album> future = internalPhotosLibraryClient.getAlbumCallable().futureCall(request);
   *   // Do something.
   *   Album response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAlbumRequest, Album> getAlbumCallable() {
    return stub.getAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String shareToken = "shareToken-1798271654";
   *   Album response = internalPhotosLibraryClient.getSharedAlbum(shareToken);
   * }
   * }</pre>
   *
   * @param shareToken Required. Share token of the album to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getSharedAlbum(String shareToken) {
    GetSharedAlbumRequest request =
        GetSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return getSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetSharedAlbumRequest request =
   *       GetSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   Album response = internalPhotosLibraryClient.getSharedAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getSharedAlbum(GetSharedAlbumRequest request) {
    return getSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   GetSharedAlbumRequest request =
   *       GetSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   ApiFuture<Album> future =
   *       internalPhotosLibraryClient.getSharedAlbumCallable().futureCall(request);
   *   // Do something.
   *   Album response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSharedAlbumRequest, Album> getSharedAlbumCallable() {
    return stub.getSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   AddEnrichmentToAlbumResponse response =
   *       internalPhotosLibraryClient.addEnrichmentToAlbum(
   *           albumId, newEnrichmentItem, albumPosition);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the album where the enrichment is to be added.
   * @param newEnrichmentItem Required. The enrichment to be added.
   * @param albumPosition Required. The position in the album where the enrichment is to be
   *     inserted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddEnrichmentToAlbumResponse addEnrichmentToAlbum(
      String albumId, NewEnrichmentItem newEnrichmentItem, AlbumPosition albumPosition) {
    AddEnrichmentToAlbumRequest request =
        AddEnrichmentToAlbumRequest.newBuilder()
            .setAlbumId(albumId)
            .setNewEnrichmentItem(newEnrichmentItem)
            .setAlbumPosition(albumPosition)
            .build();
    return addEnrichmentToAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   AddEnrichmentToAlbumRequest request =
   *       AddEnrichmentToAlbumRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setNewEnrichmentItem(NewEnrichmentItem.newBuilder().build())
   *           .setAlbumPosition(AlbumPosition.newBuilder().build())
   *           .build();
   *   AddEnrichmentToAlbumResponse response =
   *       internalPhotosLibraryClient.addEnrichmentToAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddEnrichmentToAlbumResponse addEnrichmentToAlbum(
      AddEnrichmentToAlbumRequest request) {
    return addEnrichmentToAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   AddEnrichmentToAlbumRequest request =
   *       AddEnrichmentToAlbumRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setNewEnrichmentItem(NewEnrichmentItem.newBuilder().build())
   *           .setAlbumPosition(AlbumPosition.newBuilder().build())
   *           .build();
   *   ApiFuture<AddEnrichmentToAlbumResponse> future =
   *       internalPhotosLibraryClient.addEnrichmentToAlbumCallable().futureCall(request);
   *   // Do something.
   *   AddEnrichmentToAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumCallable() {
    return stub.addEnrichmentToAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String shareToken = "shareToken-1798271654";
   *   JoinSharedAlbumResponse response = internalPhotosLibraryClient.joinSharedAlbum(shareToken);
   * }
   * }</pre>
   *
   * @param shareToken Required. Token to join the shared album on behalf of the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JoinSharedAlbumResponse joinSharedAlbum(String shareToken) {
    JoinSharedAlbumRequest request =
        JoinSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return joinSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   JoinSharedAlbumRequest request =
   *       JoinSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   JoinSharedAlbumResponse response = internalPhotosLibraryClient.joinSharedAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JoinSharedAlbumResponse joinSharedAlbum(JoinSharedAlbumRequest request) {
    return joinSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   JoinSharedAlbumRequest request =
   *       JoinSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   ApiFuture<JoinSharedAlbumResponse> future =
   *       internalPhotosLibraryClient.joinSharedAlbumCallable().futureCall(request);
   *   // Do something.
   *   JoinSharedAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumCallable() {
    return stub.joinSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String shareToken = "shareToken-1798271654";
   *   LeaveSharedAlbumResponse response = internalPhotosLibraryClient.leaveSharedAlbum(shareToken);
   * }
   * }</pre>
   *
   * @param shareToken Required. Token to leave the shared album on behalf of the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LeaveSharedAlbumResponse leaveSharedAlbum(String shareToken) {
    LeaveSharedAlbumRequest request =
        LeaveSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return leaveSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   LeaveSharedAlbumRequest request =
   *       LeaveSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   LeaveSharedAlbumResponse response = internalPhotosLibraryClient.leaveSharedAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LeaveSharedAlbumResponse leaveSharedAlbum(LeaveSharedAlbumRequest request) {
    return leaveSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   LeaveSharedAlbumRequest request =
   *       LeaveSharedAlbumRequest.newBuilder().setShareToken("shareToken-1798271654").build();
   *   ApiFuture<LeaveSharedAlbumResponse> future =
   *       internalPhotosLibraryClient.leaveSharedAlbumCallable().futureCall(request);
   *   // Do something.
   *   LeaveSharedAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumCallable() {
    return stub.leaveSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();
   *   ShareAlbumResponse response =
   *       internalPhotosLibraryClient.shareAlbum(albumId, sharedAlbumOptions);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the album to be shared. This `albumId` must belong to an
   *     album created by the developer.
   * @param sharedAlbumOptions Options to be set when converting the album to a shared album.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShareAlbumResponse shareAlbum(
      String albumId, SharedAlbumOptions sharedAlbumOptions) {
    ShareAlbumRequest request =
        ShareAlbumRequest.newBuilder()
            .setAlbumId(albumId)
            .setSharedAlbumOptions(sharedAlbumOptions)
            .build();
    return shareAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ShareAlbumRequest request =
   *       ShareAlbumRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setSharedAlbumOptions(SharedAlbumOptions.newBuilder().build())
   *           .build();
   *   ShareAlbumResponse response = internalPhotosLibraryClient.shareAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShareAlbumResponse shareAlbum(ShareAlbumRequest request) {
    return shareAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ShareAlbumRequest request =
   *       ShareAlbumRequest.newBuilder()
   *           .setAlbumId("albumId-920410134")
   *           .setSharedAlbumOptions(SharedAlbumOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<ShareAlbumResponse> future =
   *       internalPhotosLibraryClient.shareAlbumCallable().futureCall(request);
   *   // Do something.
   *   ShareAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ShareAlbumRequest, ShareAlbumResponse> shareAlbumCallable() {
    return stub.shareAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   boolean excludeNonAppCreatedData = true;
   *   for (Album element :
   *       internalPhotosLibraryClient.listSharedAlbums(excludeNonAppCreatedData).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param excludeNonAppCreatedData If set, the results exclude media items that were not created
   *     by this app. Defaults to false (all albums are returned). This field is ignored if the
   *     photoslibrary.readonly.appcreateddata scope is used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedAlbumsPagedResponse listSharedAlbums(boolean excludeNonAppCreatedData) {
    ListSharedAlbumsRequest request =
        ListSharedAlbumsRequest.newBuilder()
            .setExcludeNonAppCreatedData(excludeNonAppCreatedData)
            .build();
    return listSharedAlbums(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request =
   *       ListSharedAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   for (Album element : internalPhotosLibraryClient.listSharedAlbums(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedAlbumsPagedResponse listSharedAlbums(ListSharedAlbumsRequest request) {
    return listSharedAlbumsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request =
   *       ListSharedAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   ApiFuture<Album> future =
   *       internalPhotosLibraryClient.listSharedAlbumsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Album element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsPagedResponse>
      listSharedAlbumsPagedCallable() {
    return stub.listSharedAlbumsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request =
   *       ListSharedAlbumsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setExcludeNonAppCreatedData(true)
   *           .build();
   *   while (true) {
   *     ListSharedAlbumsResponse response =
   *         internalPhotosLibraryClient.listSharedAlbumsCallable().call(request);
   *     for (Album element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsCallable() {
    return stub.listSharedAlbumsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   UnshareAlbumResponse response = internalPhotosLibraryClient.unshareAlbum(albumId);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the album to be unshared. This album id must belong to
   *     an album created by the developer.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnshareAlbumResponse unshareAlbum(String albumId) {
    UnshareAlbumRequest request = UnshareAlbumRequest.newBuilder().setAlbumId(albumId).build();
    return unshareAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UnshareAlbumRequest request =
   *       UnshareAlbumRequest.newBuilder().setAlbumId("albumId-920410134").build();
   *   UnshareAlbumResponse response = internalPhotosLibraryClient.unshareAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnshareAlbumResponse unshareAlbum(UnshareAlbumRequest request) {
    return unshareAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UnshareAlbumRequest request =
   *       UnshareAlbumRequest.newBuilder().setAlbumId("albumId-920410134").build();
   *   ApiFuture<UnshareAlbumResponse> future =
   *       internalPhotosLibraryClient.unshareAlbumCallable().futureCall(request);
   *   // Do something.
   *   UnshareAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumCallable() {
    return stub.unshareAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes one or more media items from a specified album. The media items and the album must have
   * been created by the developer via the API.
   *
   * <p>For albums that are shared, this action is only supported for media items that were added to
   * the album by this user, or for all media items if the album was created by this user.
   *
   * <p>Partial success is not supported. The entire request will fail and no action will be
   * performed on the album if an invalid media item or album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   String albumId = "albumId-920410134";
   *   List<String> mediaItemIds = new ArrayList<>();
   *   BatchRemoveMediaItemsFromAlbumResponse response =
   *       internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
   * }
   * }</pre>
   *
   * @param albumId Required. Identifier of the [Album][google.photos.types.Album] that the media
   *     items are to be removed from.
   * @param mediaItemIds Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   *     be removed.
   *     <p>Must not contain repeated identifiers and cannot be empty. The maximum number of media
   *     items that can be removed in one call is 50.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRemoveMediaItemsFromAlbumResponse batchRemoveMediaItemsFromAlbum(
      String albumId, List<String> mediaItemIds) {
    BatchRemoveMediaItemsFromAlbumRequest request =
        BatchRemoveMediaItemsFromAlbumRequest.newBuilder()
            .setAlbumId(albumId)
            .addAllMediaItemIds(mediaItemIds)
            .build();
    return batchRemoveMediaItemsFromAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes one or more media items from a specified album. The media items and the album must have
   * been created by the developer via the API.
   *
   * <p>For albums that are shared, this action is only supported for media items that were added to
   * the album by this user, or for all media items if the album was created by this user.
   *
   * <p>Partial success is not supported. The entire request will fail and no action will be
   * performed on the album if an invalid media item or album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchRemoveMediaItemsFromAlbumRequest request =
   *       BatchRemoveMediaItemsFromAlbumRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .setAlbumId("albumId-920410134")
   *           .build();
   *   BatchRemoveMediaItemsFromAlbumResponse response =
   *       internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRemoveMediaItemsFromAlbumResponse batchRemoveMediaItemsFromAlbum(
      BatchRemoveMediaItemsFromAlbumRequest request) {
    return batchRemoveMediaItemsFromAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Removes one or more media items from a specified album. The media items and the album must have
   * been created by the developer via the API.
   *
   * <p>For albums that are shared, this action is only supported for media items that were added to
   * the album by this user, or for all media items if the album was created by this user.
   *
   * <p>Partial success is not supported. The entire request will fail and no action will be
   * performed on the album if an invalid media item or album is specified.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   BatchRemoveMediaItemsFromAlbumRequest request =
   *       BatchRemoveMediaItemsFromAlbumRequest.newBuilder()
   *           .addAllMediaItemIds(new ArrayList<String>())
   *           .setAlbumId("albumId-920410134")
   *           .build();
   *   ApiFuture<BatchRemoveMediaItemsFromAlbumResponse> future =
   *       internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbumCallable().futureCall(request);
   *   // Do something.
   *   BatchRemoveMediaItemsFromAlbumResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumCallable() {
    return stub.batchRemoveMediaItemsFromAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the album with the specified `id`. Only the `id`, `title` and
   * `cover_photo_media_item_id` fields of the album are read. The album must have been created by
   * the developer via the API and must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   Album response = internalPhotosLibraryClient.updateAlbum(album);
   * }
   * }</pre>
   *
   * @param album Required. The [Album][google.photos.types.Album] to update.
   *     <p>The album?s `id` field is used to identify the album to be updated. The album?s `title`
   *     field is used to set the new album title. The album?s `cover_photo_media_item_id` field is
   *     used to set the new album cover photo.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album updateAlbum(Album album) {
    UpdateAlbumRequest request = UpdateAlbumRequest.newBuilder().setAlbum(album).build();
    return updateAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the album with the specified `id`. Only the `id`, `title` and
   * `cover_photo_media_item_id` fields of the album are read. The album must have been created by
   * the developer via the API and must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Album response = internalPhotosLibraryClient.updateAlbum(album, updateMask);
   * }
   * }</pre>
   *
   * @param album Required. The [Album][google.photos.types.Album] to update.
   *     <p>The album?s `id` field is used to identify the album to be updated. The album?s `title`
   *     field is used to set the new album title. The album?s `cover_photo_media_item_id` field is
   *     used to set the new album cover photo.
   * @param updateMask Required. Indicate what fields in the provided album to update. The only
   *     valid values are `title` and `cover_photo_media_item_id`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album updateAlbum(Album album, FieldMask updateMask) {
    UpdateAlbumRequest request =
        UpdateAlbumRequest.newBuilder().setAlbum(album).setUpdateMask(updateMask).build();
    return updateAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the album with the specified `id`. Only the `id`, `title` and
   * `cover_photo_media_item_id` fields of the album are read. The album must have been created by
   * the developer via the API and must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UpdateAlbumRequest request =
   *       UpdateAlbumRequest.newBuilder()
   *           .setAlbum(Album.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Album response = internalPhotosLibraryClient.updateAlbum(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album updateAlbum(UpdateAlbumRequest request) {
    return updateAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the album with the specified `id`. Only the `id`, `title` and
   * `cover_photo_media_item_id` fields of the album are read. The album must have been created by
   * the developer via the API and must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UpdateAlbumRequest request =
   *       UpdateAlbumRequest.newBuilder()
   *           .setAlbum(Album.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Album> future =
   *       internalPhotosLibraryClient.updateAlbumCallable().futureCall(request);
   *   // Do something.
   *   Album response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAlbumRequest, Album> updateAlbumCallable() {
    return stub.updateAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the media item with the specified `id`. Only the `id` and `description` fields of the
   * media item are read. The media item must have been created by the developer via the API and
   * must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   MediaItem mediaItem = MediaItem.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   MediaItem response = internalPhotosLibraryClient.updateMediaItem(mediaItem, updateMask);
   * }
   * }</pre>
   *
   * @param mediaItem Required. The [MediaItem][google.photos.types.MediaItem] to update.
   *     <p>The media item's `id` field is used to identify the media item to be updated. The media
   *     item's `description` field is used to set the new media item description.
   * @param updateMask Required. Indicate what fields in the provided media item to update. The only
   *     valid value is `description`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem updateMediaItem(MediaItem mediaItem, FieldMask updateMask) {
    UpdateMediaItemRequest request =
        UpdateMediaItemRequest.newBuilder()
            .setMediaItem(mediaItem)
            .setUpdateMask(updateMask)
            .build();
    return updateMediaItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the media item with the specified `id`. Only the `id` and `description` fields of the
   * media item are read. The media item must have been created by the developer via the API and
   * must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UpdateMediaItemRequest request =
   *       UpdateMediaItemRequest.newBuilder()
   *           .setMediaItem(MediaItem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   MediaItem response = internalPhotosLibraryClient.updateMediaItem(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem updateMediaItem(UpdateMediaItemRequest request) {
    return updateMediaItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the media item with the specified `id`. Only the `id` and `description` fields of the
   * media item are read. The media item must have been created by the developer via the API and
   * must be owned by the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
   *     InternalPhotosLibraryClient.create()) {
   *   UpdateMediaItemRequest request =
   *       UpdateMediaItemRequest.newBuilder()
   *           .setMediaItem(MediaItem.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<MediaItem> future =
   *       internalPhotosLibraryClient.updateMediaItemCallable().futureCall(request);
   *   // Do something.
   *   MediaItem response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMediaItemRequest, MediaItem> updateMediaItemCallable() {
    return stub.updateMediaItemCallable();
  }

  @Override
  public void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class SearchMediaItemsPagedResponse
      extends AbstractPagedListResponse<
          SearchMediaItemsRequest,
          SearchMediaItemsResponse,
          MediaItem,
          SearchMediaItemsPage,
          SearchMediaItemsFixedSizeCollection> {

    public static ApiFuture<SearchMediaItemsPagedResponse> createAsync(
        PageContext<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem> context,
        ApiFuture<SearchMediaItemsResponse> futureResponse) {
      ApiFuture<SearchMediaItemsPage> futurePage =
          SearchMediaItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchMediaItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchMediaItemsPagedResponse(SearchMediaItemsPage page) {
      super(page, SearchMediaItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchMediaItemsPage
      extends AbstractPage<
          SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem, SearchMediaItemsPage> {

    private SearchMediaItemsPage(
        PageContext<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem> context,
        SearchMediaItemsResponse response) {
      super(context, response);
    }

    private static SearchMediaItemsPage createEmptyPage() {
      return new SearchMediaItemsPage(null, null);
    }

    @Override
    protected SearchMediaItemsPage createPage(
        PageContext<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem> context,
        SearchMediaItemsResponse response) {
      return new SearchMediaItemsPage(context, response);
    }

    @Override
    public ApiFuture<SearchMediaItemsPage> createPageAsync(
        PageContext<SearchMediaItemsRequest, SearchMediaItemsResponse, MediaItem> context,
        ApiFuture<SearchMediaItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchMediaItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchMediaItemsRequest,
          SearchMediaItemsResponse,
          MediaItem,
          SearchMediaItemsPage,
          SearchMediaItemsFixedSizeCollection> {

    private SearchMediaItemsFixedSizeCollection(
        List<SearchMediaItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchMediaItemsFixedSizeCollection createEmptyCollection() {
      return new SearchMediaItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchMediaItemsFixedSizeCollection createCollection(
        List<SearchMediaItemsPage> pages, int collectionSize) {
      return new SearchMediaItemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMediaItemsPagedResponse
      extends AbstractPagedListResponse<
          ListMediaItemsRequest,
          ListMediaItemsResponse,
          MediaItem,
          ListMediaItemsPage,
          ListMediaItemsFixedSizeCollection> {

    public static ApiFuture<ListMediaItemsPagedResponse> createAsync(
        PageContext<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem> context,
        ApiFuture<ListMediaItemsResponse> futureResponse) {
      ApiFuture<ListMediaItemsPage> futurePage =
          ListMediaItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMediaItemsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMediaItemsPagedResponse(ListMediaItemsPage page) {
      super(page, ListMediaItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMediaItemsPage
      extends AbstractPage<
          ListMediaItemsRequest, ListMediaItemsResponse, MediaItem, ListMediaItemsPage> {

    private ListMediaItemsPage(
        PageContext<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem> context,
        ListMediaItemsResponse response) {
      super(context, response);
    }

    private static ListMediaItemsPage createEmptyPage() {
      return new ListMediaItemsPage(null, null);
    }

    @Override
    protected ListMediaItemsPage createPage(
        PageContext<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem> context,
        ListMediaItemsResponse response) {
      return new ListMediaItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListMediaItemsPage> createPageAsync(
        PageContext<ListMediaItemsRequest, ListMediaItemsResponse, MediaItem> context,
        ApiFuture<ListMediaItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMediaItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMediaItemsRequest,
          ListMediaItemsResponse,
          MediaItem,
          ListMediaItemsPage,
          ListMediaItemsFixedSizeCollection> {

    private ListMediaItemsFixedSizeCollection(List<ListMediaItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMediaItemsFixedSizeCollection createEmptyCollection() {
      return new ListMediaItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMediaItemsFixedSizeCollection createCollection(
        List<ListMediaItemsPage> pages, int collectionSize) {
      return new ListMediaItemsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAlbumsPagedResponse
      extends AbstractPagedListResponse<
          ListAlbumsRequest,
          ListAlbumsResponse,
          Album,
          ListAlbumsPage,
          ListAlbumsFixedSizeCollection> {

    public static ApiFuture<ListAlbumsPagedResponse> createAsync(
        PageContext<ListAlbumsRequest, ListAlbumsResponse, Album> context,
        ApiFuture<ListAlbumsResponse> futureResponse) {
      ApiFuture<ListAlbumsPage> futurePage =
          ListAlbumsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAlbumsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAlbumsPagedResponse(ListAlbumsPage page) {
      super(page, ListAlbumsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAlbumsPage
      extends AbstractPage<ListAlbumsRequest, ListAlbumsResponse, Album, ListAlbumsPage> {

    private ListAlbumsPage(
        PageContext<ListAlbumsRequest, ListAlbumsResponse, Album> context,
        ListAlbumsResponse response) {
      super(context, response);
    }

    private static ListAlbumsPage createEmptyPage() {
      return new ListAlbumsPage(null, null);
    }

    @Override
    protected ListAlbumsPage createPage(
        PageContext<ListAlbumsRequest, ListAlbumsResponse, Album> context,
        ListAlbumsResponse response) {
      return new ListAlbumsPage(context, response);
    }

    @Override
    public ApiFuture<ListAlbumsPage> createPageAsync(
        PageContext<ListAlbumsRequest, ListAlbumsResponse, Album> context,
        ApiFuture<ListAlbumsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAlbumsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAlbumsRequest,
          ListAlbumsResponse,
          Album,
          ListAlbumsPage,
          ListAlbumsFixedSizeCollection> {

    private ListAlbumsFixedSizeCollection(List<ListAlbumsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAlbumsFixedSizeCollection createEmptyCollection() {
      return new ListAlbumsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAlbumsFixedSizeCollection createCollection(
        List<ListAlbumsPage> pages, int collectionSize) {
      return new ListAlbumsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSharedAlbumsPagedResponse
      extends AbstractPagedListResponse<
          ListSharedAlbumsRequest,
          ListSharedAlbumsResponse,
          Album,
          ListSharedAlbumsPage,
          ListSharedAlbumsFixedSizeCollection> {

    public static ApiFuture<ListSharedAlbumsPagedResponse> createAsync(
        PageContext<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album> context,
        ApiFuture<ListSharedAlbumsResponse> futureResponse) {
      ApiFuture<ListSharedAlbumsPage> futurePage =
          ListSharedAlbumsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSharedAlbumsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSharedAlbumsPagedResponse(ListSharedAlbumsPage page) {
      super(page, ListSharedAlbumsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSharedAlbumsPage
      extends AbstractPage<
          ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album, ListSharedAlbumsPage> {

    private ListSharedAlbumsPage(
        PageContext<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album> context,
        ListSharedAlbumsResponse response) {
      super(context, response);
    }

    private static ListSharedAlbumsPage createEmptyPage() {
      return new ListSharedAlbumsPage(null, null);
    }

    @Override
    protected ListSharedAlbumsPage createPage(
        PageContext<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album> context,
        ListSharedAlbumsResponse response) {
      return new ListSharedAlbumsPage(context, response);
    }

    @Override
    public ApiFuture<ListSharedAlbumsPage> createPageAsync(
        PageContext<ListSharedAlbumsRequest, ListSharedAlbumsResponse, Album> context,
        ApiFuture<ListSharedAlbumsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSharedAlbumsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSharedAlbumsRequest,
          ListSharedAlbumsResponse,
          Album,
          ListSharedAlbumsPage,
          ListSharedAlbumsFixedSizeCollection> {

    private ListSharedAlbumsFixedSizeCollection(
        List<ListSharedAlbumsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSharedAlbumsFixedSizeCollection createEmptyCollection() {
      return new ListSharedAlbumsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSharedAlbumsFixedSizeCollection createCollection(
        List<ListSharedAlbumsPage> pages, int collectionSize) {
      return new ListSharedAlbumsFixedSizeCollection(pages, collectionSize);
    }
  }
}
