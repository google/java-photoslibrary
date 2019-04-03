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
package com.google.photos.library.v1.internal;

import com.google.api.core.ApiFunction;
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
import com.google.photos.types.proto.Album;
import com.google.photos.types.proto.MediaItem;
import com.google.photos.types.proto.SharedAlbumOptions;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
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
 * <pre>
 * <code>
 * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
 *   Album album = Album.newBuilder().build();
 *   Album response = internalPhotosLibraryClient.createAlbum(album);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the internalPhotosLibraryClient object to clean up
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
 * <pre>
 * <code>
 * InternalPhotosLibrarySettings internalPhotosLibrarySettings =
 *     InternalPhotosLibrarySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create(internalPhotosLibrarySettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InternalPhotosLibrarySettings internalPhotosLibrarySettings =
 *     InternalPhotosLibrarySettings.newBuilder().setEndpoint(myEndpoint).build();
 * InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create(internalPhotosLibrarySettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * This is for advanced usage - prefer to use InternalPhotosLibrarySettings}.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   Album response = internalPhotosLibraryClient.createAlbum(album);
   * }
   * </code></pre>
   *
   * @param album The album to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album createAlbum(Album album) {

    CreateAlbumRequest request = CreateAlbumRequest.newBuilder().setAlbum(album).build();
    return createAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   CreateAlbumRequest request = CreateAlbumRequest.newBuilder()
   *     .setAlbum(album)
   *     .build();
   *   Album response = internalPhotosLibraryClient.createAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album createAlbum(CreateAlbumRequest request) {
    return createAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an album in a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   Album album = Album.newBuilder().build();
   *   CreateAlbumRequest request = CreateAlbumRequest.newBuilder()
   *     .setAlbum(album)
   *     .build();
   *   ApiFuture&lt;Album&gt; future = internalPhotosLibraryClient.createAlbumCallable().futureCall(request);
   *   // Do something
   *   Album response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateAlbumRequest, Album> createAlbumCallable() {
    return stub.createAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. By default, the media item will be added to the end of the
   * library or album.
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
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;NewMediaItem&gt; newMediaItems = new ArrayList&lt;&gt;();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   BatchCreateMediaItemsResponse response = internalPhotosLibraryClient.batchCreateMediaItems(albumId, newMediaItems, albumPosition);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the album where the media items are added. The media items are
   *     also added to the user's library. This is an optional field.
   * @param newMediaItems List of media items to be created.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. By default, the media item will be added to the end of the
   * library or album.
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
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   List&lt;NewMediaItem&gt; newMediaItems = new ArrayList&lt;&gt;();
   *   BatchCreateMediaItemsRequest request = BatchCreateMediaItemsRequest.newBuilder()
   *     .addAllNewMediaItems(newMediaItems)
   *     .build();
   *   BatchCreateMediaItemsResponse response = internalPhotosLibraryClient.batchCreateMediaItems(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateMediaItemsResponse batchCreateMediaItems(
      BatchCreateMediaItemsRequest request) {
    return batchCreateMediaItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>This is the second step for creating a media item. For details regarding Step 1, uploading
   * the raw bytes to a Google Server, see &lt;a
   * href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
   *
   * <p>This call adds the media item to the library. If an album `id` is specified, the call adds
   * the media item to the album too. By default, the media item will be added to the end of the
   * library or album.
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
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   List&lt;NewMediaItem&gt; newMediaItems = new ArrayList&lt;&gt;();
   *   BatchCreateMediaItemsRequest request = BatchCreateMediaItemsRequest.newBuilder()
   *     .addAllNewMediaItems(newMediaItems)
   *     .build();
   *   ApiFuture&lt;BatchCreateMediaItemsResponse&gt; future = internalPhotosLibraryClient.batchCreateMediaItemsCallable().futureCall(request);
   *   // Do something
   *   BatchCreateMediaItemsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsCallable() {
    return stub.batchCreateMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more existing media items in a user's Google Photos library to an existing album.
   *
   * <p>This call adds the existing media items to an album, identified by its identifier. The media
   * items to be added must be owned by the user, and created by the developer, on behalf of whom
   * the API is acting. In case of adding media items to a shared album, the user must either be an
   * owner of the album or a collaborator who has already joined.
   *
   * <p>The maximum size of the batch is 50. The API does not support partial success, i.e. the
   * entire request fails if an invalid media item or album is specified.
   *
   * <p>The new items are added to the end of the album, in the order in which they are specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchAddMediaItemsToAlbumResponse response = internalPhotosLibraryClient.batchAddMediaItemsToAlbum(albumId, mediaItemIds);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the [Album][google.photos.types.Album] that the
   *     [MediaItem][google.photos.types.MediaItem](s) are added to.
   * @param mediaItemIds Identifier of the [MediaItem][google.photos.types.MediaItem](s) to be
   *     added.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more existing media items in a user's Google Photos library to an existing album.
   *
   * <p>This call adds the existing media items to an album, identified by its identifier. The media
   * items to be added must be owned by the user, and created by the developer, on behalf of whom
   * the API is acting. In case of adding media items to a shared album, the user must either be an
   * owner of the album or a collaborator who has already joined.
   *
   * <p>The maximum size of the batch is 50. The API does not support partial success, i.e. the
   * entire request fails if an invalid media item or album is specified.
   *
   * <p>The new items are added to the end of the album, in the order in which they are specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchAddMediaItemsToAlbumRequest request = BatchAddMediaItemsToAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   BatchAddMediaItemsToAlbumResponse response = internalPhotosLibraryClient.batchAddMediaItemsToAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchAddMediaItemsToAlbumResponse batchAddMediaItemsToAlbum(
      BatchAddMediaItemsToAlbumRequest request) {
    return batchAddMediaItemsToAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds one or more existing media items in a user's Google Photos library to an existing album.
   *
   * <p>This call adds the existing media items to an album, identified by its identifier. The media
   * items to be added must be owned by the user, and created by the developer, on behalf of whom
   * the API is acting. In case of adding media items to a shared album, the user must either be an
   * owner of the album or a collaborator who has already joined.
   *
   * <p>The maximum size of the batch is 50. The API does not support partial success, i.e. the
   * entire request fails if an invalid media item or album is specified.
   *
   * <p>The new items are added to the end of the album, in the order in which they are specified in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchAddMediaItemsToAlbumRequest request = BatchAddMediaItemsToAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   ApiFuture&lt;BatchAddMediaItemsToAlbumResponse&gt; future = internalPhotosLibraryClient.batchAddMediaItemsToAlbumCallable().futureCall(request);
   *   // Do something
   *   BatchAddMediaItemsToAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumCallable() {
    return stub.batchAddMediaItemsToAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(albumId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   Filters filters = Filters.newBuilder().build();
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(filters).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param filters Filters to apply to the request. Can't be set in conjunction with an `albumId`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(Filters filters) {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setFilters(filters).build();
    return searchMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request = SearchMediaItemsRequest.newBuilder().build();
   *   for (MediaItem element : internalPhotosLibraryClient.searchMediaItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(SearchMediaItemsRequest request) {
    return searchMediaItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request = SearchMediaItemsRequest.newBuilder().build();
   *   ApiFuture&lt;SearchMediaItemsPagedResponse&gt; future = internalPhotosLibraryClient.searchMediaItemsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MediaItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsPagedResponse>
      searchMediaItemsPagedCallable() {
    return stub.searchMediaItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches for media items in a user's Google Photos library. If no filters are set, then all
   * media items in the user's library are returned. If an album is set, all media items in the
   * specified album are returned. If filters are specified, media items that match the filters from
   * the user's library are listed. If you set both the album and the filters, the request results
   * in an error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   SearchMediaItemsRequest request = SearchMediaItemsRequest.newBuilder().build();
   *   while (true) {
   *     SearchMediaItemsResponse response = internalPhotosLibraryClient.searchMediaItemsCallable().call(request);
   *     for (MediaItem element : response.getMediaItemsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsCallable() {
    return stub.searchMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request = ListMediaItemsRequest.newBuilder().build();
   *   for (MediaItem element : internalPhotosLibraryClient.listMediaItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMediaItemsPagedResponse listMediaItems(ListMediaItemsRequest request) {
    return listMediaItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request = ListMediaItemsRequest.newBuilder().build();
   *   ApiFuture&lt;ListMediaItemsPagedResponse&gt; future = internalPhotosLibraryClient.listMediaItemsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MediaItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListMediaItemsRequest, ListMediaItemsPagedResponse>
      listMediaItemsPagedCallable() {
    return stub.listMediaItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * List all media items from a user's Google Photos library.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListMediaItemsRequest request = ListMediaItemsRequest.newBuilder().build();
   *   while (true) {
   *     ListMediaItemsResponse response = internalPhotosLibraryClient.listMediaItemsCallable().call(request);
   *     for (MediaItem element : response.getMediaItemsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse>
      listMediaItemsCallable() {
    return stub.listMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String mediaItemId = "";
   *   MediaItem response = internalPhotosLibraryClient.getMediaItem(mediaItemId);
   * }
   * </code></pre>
   *
   * @param mediaItemId Identifier of the media item to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem getMediaItem(String mediaItemId) {

    GetMediaItemRequest request =
        GetMediaItemRequest.newBuilder().setMediaItemId(mediaItemId).build();
    return getMediaItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String mediaItemId = "";
   *   GetMediaItemRequest request = GetMediaItemRequest.newBuilder()
   *     .setMediaItemId(mediaItemId)
   *     .build();
   *   MediaItem response = internalPhotosLibraryClient.getMediaItem(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MediaItem getMediaItem(GetMediaItemRequest request) {
    return getMediaItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the media item for the specified media item identifier.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String mediaItemId = "";
   *   GetMediaItemRequest request = GetMediaItemRequest.newBuilder()
   *     .setMediaItemId(mediaItemId)
   *     .build();
   *   ApiFuture&lt;MediaItem&gt; future = internalPhotosLibraryClient.getMediaItemCallable().futureCall(request);
   *   // Do something
   *   MediaItem response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetMediaItemRequest, MediaItem> getMediaItemCallable() {
    return stub.getMediaItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchGetMediaItemsResponse response = internalPhotosLibraryClient.batchGetMediaItems(mediaItemIds);
   * }
   * </code></pre>
   *
   * @param mediaItemIds Identifiers of the media items to be requested. Must not contain repeated
   *     identifiers and cannot be empty. The maximum number of media items that can be retrieved in
   *     one call is 50.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetMediaItemsResponse batchGetMediaItems(List<String> mediaItemIds) {

    BatchGetMediaItemsRequest request =
        BatchGetMediaItemsRequest.newBuilder().addAllMediaItemIds(mediaItemIds).build();
    return batchGetMediaItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchGetMediaItemsRequest request = BatchGetMediaItemsRequest.newBuilder()
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   BatchGetMediaItemsResponse response = internalPhotosLibraryClient.batchGetMediaItems(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetMediaItemsResponse batchGetMediaItems(BatchGetMediaItemsRequest request) {
    return batchGetMediaItemsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of media items for the specified media item identifiers. Items are returned in
   * the same order as the supplied identifiers.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchGetMediaItemsRequest request = BatchGetMediaItemsRequest.newBuilder()
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   ApiFuture&lt;BatchGetMediaItemsResponse&gt; future = internalPhotosLibraryClient.batchGetMediaItemsCallable().futureCall(request);
   *   // Do something
   *   BatchGetMediaItemsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsCallable() {
    return stub.batchGetMediaItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   boolean excludeNonAppCreatedData = false;
   *   for (Album element : internalPhotosLibraryClient.listAlbums(excludeNonAppCreatedData).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request = ListAlbumsRequest.newBuilder().build();
   *   for (Album element : internalPhotosLibraryClient.listAlbums(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAlbumsPagedResponse listAlbums(ListAlbumsRequest request) {
    return listAlbumsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request = ListAlbumsRequest.newBuilder().build();
   *   ApiFuture&lt;ListAlbumsPagedResponse&gt; future = internalPhotosLibraryClient.listAlbumsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Album element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListAlbumsRequest, ListAlbumsPagedResponse> listAlbumsPagedCallable() {
    return stub.listAlbumsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListAlbumsRequest request = ListAlbumsRequest.newBuilder().build();
   *   while (true) {
   *     ListAlbumsResponse response = internalPhotosLibraryClient.listAlbumsCallable().call(request);
   *     for (Album element : response.getAlbumsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> listAlbumsCallable() {
    return stub.listAlbumsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   Album response = internalPhotosLibraryClient.getAlbum(albumId);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the album to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getAlbum(String albumId) {

    GetAlbumRequest request = GetAlbumRequest.newBuilder().setAlbumId(albumId).build();
    return getAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   GetAlbumRequest request = GetAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   Album response = internalPhotosLibraryClient.getAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getAlbum(GetAlbumRequest request) {
    return getAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `albumId`. The `albumId` must be the ID of an album
   * owned by the user or a shared album that the user has joined.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   GetAlbumRequest request = GetAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   ApiFuture&lt;Album&gt; future = internalPhotosLibraryClient.getAlbumCallable().futureCall(request);
   *   // Do something
   *   Album response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAlbumRequest, Album> getAlbumCallable() {
    return stub.getAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   Album response = internalPhotosLibraryClient.getSharedAlbum(shareToken);
   * }
   * </code></pre>
   *
   * @param shareToken Share token of the album to be requested.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getSharedAlbum(String shareToken) {

    GetSharedAlbumRequest request =
        GetSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return getSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   GetSharedAlbumRequest request = GetSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   Album response = internalPhotosLibraryClient.getSharedAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album getSharedAlbum(GetSharedAlbumRequest request) {
    return getSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the album based on the specified `shareToken`.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   GetSharedAlbumRequest request = GetSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   ApiFuture&lt;Album&gt; future = internalPhotosLibraryClient.getSharedAlbumCallable().futureCall(request);
   *   // Do something
   *   Album response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetSharedAlbumRequest, Album> getSharedAlbumCallable() {
    return stub.getSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   AddEnrichmentToAlbumResponse response = internalPhotosLibraryClient.addEnrichmentToAlbum(albumId, newEnrichmentItem, albumPosition);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the album where the enrichment is to be added.
   * @param newEnrichmentItem The enrichment to be added.
   * @param albumPosition The position in the album where the enrichment is to be inserted.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   AddEnrichmentToAlbumRequest request = AddEnrichmentToAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .setNewEnrichmentItem(newEnrichmentItem)
   *     .setAlbumPosition(albumPosition)
   *     .build();
   *   AddEnrichmentToAlbumResponse response = internalPhotosLibraryClient.addEnrichmentToAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddEnrichmentToAlbumResponse addEnrichmentToAlbum(
      AddEnrichmentToAlbumRequest request) {
    return addEnrichmentToAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Adds an enrichment at a specified position in a defined album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   NewEnrichmentItem newEnrichmentItem = NewEnrichmentItem.newBuilder().build();
   *   AlbumPosition albumPosition = AlbumPosition.newBuilder().build();
   *   AddEnrichmentToAlbumRequest request = AddEnrichmentToAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .setNewEnrichmentItem(newEnrichmentItem)
   *     .setAlbumPosition(albumPosition)
   *     .build();
   *   ApiFuture&lt;AddEnrichmentToAlbumResponse&gt; future = internalPhotosLibraryClient.addEnrichmentToAlbumCallable().futureCall(request);
   *   // Do something
   *   AddEnrichmentToAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumCallable() {
    return stub.addEnrichmentToAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   JoinSharedAlbumResponse response = internalPhotosLibraryClient.joinSharedAlbum(shareToken);
   * }
   * </code></pre>
   *
   * @param shareToken Token to join the shared album on behalf of the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JoinSharedAlbumResponse joinSharedAlbum(String shareToken) {

    JoinSharedAlbumRequest request =
        JoinSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return joinSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   JoinSharedAlbumRequest request = JoinSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   JoinSharedAlbumResponse response = internalPhotosLibraryClient.joinSharedAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final JoinSharedAlbumResponse joinSharedAlbum(JoinSharedAlbumRequest request) {
    return joinSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Joins a shared album on behalf of the Google Photos user.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   JoinSharedAlbumRequest request = JoinSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   ApiFuture&lt;JoinSharedAlbumResponse&gt; future = internalPhotosLibraryClient.joinSharedAlbumCallable().futureCall(request);
   *   // Do something
   *   JoinSharedAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<JoinSharedAlbumRequest, JoinSharedAlbumResponse>
      joinSharedAlbumCallable() {
    return stub.joinSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   LeaveSharedAlbumResponse response = internalPhotosLibraryClient.leaveSharedAlbum(shareToken);
   * }
   * </code></pre>
   *
   * @param shareToken Token to leave the shared album on behalf of the user.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LeaveSharedAlbumResponse leaveSharedAlbum(String shareToken) {

    LeaveSharedAlbumRequest request =
        LeaveSharedAlbumRequest.newBuilder().setShareToken(shareToken).build();
    return leaveSharedAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   LeaveSharedAlbumRequest request = LeaveSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   LeaveSharedAlbumResponse response = internalPhotosLibraryClient.leaveSharedAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LeaveSharedAlbumResponse leaveSharedAlbum(LeaveSharedAlbumRequest request) {
    return leaveSharedAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Leaves a previously-joined shared album on behalf of the Google Photos user. The user must not
   * own this album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String shareToken = "";
   *   LeaveSharedAlbumRequest request = LeaveSharedAlbumRequest.newBuilder()
   *     .setShareToken(shareToken)
   *     .build();
   *   ApiFuture&lt;LeaveSharedAlbumResponse&gt; future = internalPhotosLibraryClient.leaveSharedAlbumCallable().futureCall(request);
   *   // Do something
   *   LeaveSharedAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumCallable() {
    return stub.leaveSharedAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   SharedAlbumOptions sharedAlbumOptions = SharedAlbumOptions.newBuilder().build();
   *   ShareAlbumResponse response = internalPhotosLibraryClient.shareAlbum(albumId, sharedAlbumOptions);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the album to be shared. This `albumId` must belong to an album
   *     created by the developer.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   ShareAlbumRequest request = ShareAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   ShareAlbumResponse response = internalPhotosLibraryClient.shareAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ShareAlbumResponse shareAlbum(ShareAlbumRequest request) {
    return shareAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks an album as shared and accessible to other users. This action can only be performed on
   * albums which were created by the developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   ShareAlbumRequest request = ShareAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   ApiFuture&lt;ShareAlbumResponse&gt; future = internalPhotosLibraryClient.shareAlbumCallable().futureCall(request);
   *   // Do something
   *   ShareAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ShareAlbumRequest, ShareAlbumResponse> shareAlbumCallable() {
    return stub.shareAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   boolean excludeNonAppCreatedData = false;
   *   for (Album element : internalPhotosLibraryClient.listSharedAlbums(excludeNonAppCreatedData).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request = ListSharedAlbumsRequest.newBuilder().build();
   *   for (Album element : internalPhotosLibraryClient.listSharedAlbums(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSharedAlbumsPagedResponse listSharedAlbums(ListSharedAlbumsRequest request) {
    return listSharedAlbumsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request = ListSharedAlbumsRequest.newBuilder().build();
   *   ApiFuture&lt;ListSharedAlbumsPagedResponse&gt; future = internalPhotosLibraryClient.listSharedAlbumsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Album element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsPagedResponse>
      listSharedAlbumsPagedCallable() {
    return stub.listSharedAlbumsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   ListSharedAlbumsRequest request = ListSharedAlbumsRequest.newBuilder().build();
   *   while (true) {
   *     ListSharedAlbumsResponse response = internalPhotosLibraryClient.listSharedAlbumsCallable().call(request);
   *     for (Album element : response.getSharedAlbumsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsCallable() {
    return stub.listSharedAlbumsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   UnshareAlbumResponse response = internalPhotosLibraryClient.unshareAlbum(albumId);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the album to be unshared. This album id must belong to an album
   *     created by the developer.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnshareAlbumResponse unshareAlbum(String albumId) {

    UnshareAlbumRequest request = UnshareAlbumRequest.newBuilder().setAlbumId(albumId).build();
    return unshareAlbum(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   UnshareAlbumRequest request = UnshareAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   UnshareAlbumResponse response = internalPhotosLibraryClient.unshareAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnshareAlbumResponse unshareAlbum(UnshareAlbumRequest request) {
    return unshareAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Marks a previously shared album as private. This means that the album is no longer shared and
   * all the non-owners will lose access to the album. All non-owner content will be removed from
   * the album. If a non-owner has previously added the album to their library, they will retain all
   * photos in their library. This action can only be performed on albums which were created by the
   * developer via the API.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   UnshareAlbumRequest request = UnshareAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .build();
   *   ApiFuture&lt;UnshareAlbumResponse&gt; future = internalPhotosLibraryClient.unshareAlbumCallable().futureCall(request);
   *   // Do something
   *   UnshareAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumCallable() {
    return stub.unshareAlbumCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more media items from a specified album. The media items and the album must be
   * created by the developer via the API.
   *
   * <p>Invalid media item or album identifiers will result in the failure of this request and no
   * action will be performed on the album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchRemoveMediaItemsFromAlbumResponse response = internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbum(albumId, mediaItemIds);
   * }
   * </code></pre>
   *
   * @param albumId Identifier of the [Album][google.photos.library.v1.Album] that the media items
   *     are to be removed from.
   * @param mediaItemIds Identifiers of the [MediaItem][google.photos.library.v1.MediaItem] to be
   *     removed.
   *     <p>Must not contain repeated identifiers and cannot be empty. A maximum of 50 media items
   *     can be included per request.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more media items from a specified album. The media items and the album must be
   * created by the developer via the API.
   *
   * <p>Invalid media item or album identifiers will result in the failure of this request and no
   * action will be performed on the album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchRemoveMediaItemsFromAlbumRequest request = BatchRemoveMediaItemsFromAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   BatchRemoveMediaItemsFromAlbumResponse response = internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbum(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRemoveMediaItemsFromAlbumResponse batchRemoveMediaItemsFromAlbum(
      BatchRemoveMediaItemsFromAlbumRequest request) {
    return batchRemoveMediaItemsFromAlbumCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Removes one or more media items from a specified album. The media items and the album must be
   * created by the developer via the API.
   *
   * <p>Invalid media item or album identifiers will result in the failure of this request and no
   * action will be performed on the album.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InternalPhotosLibraryClient internalPhotosLibraryClient = InternalPhotosLibraryClient.create()) {
   *   String albumId = "";
   *   List&lt;String&gt; mediaItemIds = new ArrayList&lt;&gt;();
   *   BatchRemoveMediaItemsFromAlbumRequest request = BatchRemoveMediaItemsFromAlbumRequest.newBuilder()
   *     .setAlbumId(albumId)
   *     .addAllMediaItemIds(mediaItemIds)
   *     .build();
   *   ApiFuture&lt;BatchRemoveMediaItemsFromAlbumResponse&gt; future = internalPhotosLibraryClient.batchRemoveMediaItemsFromAlbumCallable().futureCall(request);
   *   // Do something
   *   BatchRemoveMediaItemsFromAlbumResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumCallable() {
    return stub.batchRemoveMediaItemsFromAlbumCallable();
  }

  @Override
  public final void close() {
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
          new ApiFunction<SearchMediaItemsPage, SearchMediaItemsPagedResponse>() {
            @Override
            public SearchMediaItemsPagedResponse apply(SearchMediaItemsPage input) {
              return new SearchMediaItemsPagedResponse(input);
            }
          },
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
          new ApiFunction<ListMediaItemsPage, ListMediaItemsPagedResponse>() {
            @Override
            public ListMediaItemsPagedResponse apply(ListMediaItemsPage input) {
              return new ListMediaItemsPagedResponse(input);
            }
          },
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
          futurePage,
          new ApiFunction<ListAlbumsPage, ListAlbumsPagedResponse>() {
            @Override
            public ListAlbumsPagedResponse apply(ListAlbumsPage input) {
              return new ListAlbumsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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
          new ApiFunction<ListSharedAlbumsPage, ListSharedAlbumsPagedResponse>() {
            @Override
            public ListSharedAlbumsPagedResponse apply(ListSharedAlbumsPage input) {
              return new ListSharedAlbumsPagedResponse(input);
            }
          },
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
