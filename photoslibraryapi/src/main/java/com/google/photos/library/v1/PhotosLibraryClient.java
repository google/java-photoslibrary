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

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Strings;
import com.google.photos.library.v1.internal.InternalPhotosLibraryClient;
import com.google.photos.library.v1.internal.InternalPhotosLibrarySettings;
import com.google.photos.library.v1.internal.stub.PhotosLibraryStub;
import com.google.photos.library.v1.proto.AlbumPosition;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.Filters;
import com.google.photos.library.v1.proto.ListMediaItemsRequest;
import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.upload.PhotosLibraryUploadStub;
import com.google.photos.library.v1.upload.PhotosLibraryUploadStubImpl;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import com.google.photos.library.v1.util.OrderBy;
import com.google.photos.types.proto.Album;
import com.google.photos.types.proto.MediaItem;
import com.google.protobuf.FieldMask;
import io.grpc.Status.Code;
import java.io.IOException;
import java.util.List;

/**
 * An wrapper class of {@link InternalPhotosLibraryClient}.
 *
 * <p>Client to interact with the Google Photos Library API. You can perform the following actions
 * on behalf of the user:
 *
 * <ul>
 *   <li>upload media items directly to their Google Photos library
 *   <li>create albums
 *   <li>add media items (including album enrichments) to albums
 *   <li>list and download content from their Google Photos library
 *   <li>filter results by media type, date range or content category
 *   <li>create, join, and access shared albums
 * </ul>
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * PhotosLibrarySettings photosLibrarySettings =
 *     PhotosLibrarySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * try (PhotosLibraryClient photosLibraryClient =
 *     PhotosLibraryClient.initialize(photosLibrarySettings)) {
 *   Album createdAlbum = photosLibraryClient.createAlbum("My Album");
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the photosLibraryClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>Do not use {@link PhotosLibraryClient#create()} or {@link
 * PhotosLibraryClient#create(InternalPhotosLibrarySettings)} for this wrapper.
 */
public final class PhotosLibraryClient extends InternalPhotosLibraryClient {

  private final PhotosLibraryUploadStub uploadStub;
  private final PhotosLibrarySettings settings;

  protected PhotosLibraryClient(PhotosLibrarySettings settings) throws IOException {
    super(settings);
    this.settings = settings;
    this.uploadStub = PhotosLibraryUploadStubImpl.createStub(settings);
  }

  protected PhotosLibraryClient(PhotosLibraryStub stub, PhotosLibraryUploadStub uploadStub) {
    super(stub);
    this.settings = null;
    this.uploadStub = uploadStub;
  }

  /** Creates an {@link PhotosLibraryClient} instance with {@link PhotosLibrarySettings}. */
  public static PhotosLibraryClient initialize(PhotosLibrarySettings settings) throws IOException {
    return new PhotosLibraryClient(settings);
  }

  /** Returns a callable to upload a file to Google Photos. */
  public final UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse>
      uploadMediaItemCallable() {
    return uploadStub.uploadMediaItemCallable();
  }

  /** Uploads a file to Google Photos. */
  public final UploadMediaItemResponse uploadMediaItem(UploadMediaItemRequest request) {
    return uploadMediaItemCallable().call(request);
  }

  /* batchCreateMediaItems convenience methods */

  /**
   * Creates one or more media items in a user's Google Photos library.
   *
   * <p>The items are only added to the library and <b>not</b> to an album.
   *
   * @param newMediaItems List of media items to be created.
   * @see #batchCreateMediaItems(String, List, AlbumPosition)
   */
  public final BatchCreateMediaItemsResponse batchCreateMediaItems(
      List<NewMediaItem> newMediaItems) {
    if (newMediaItems == null) {
      throw new InvalidArgumentException(
          "Request must have a list of new media items.",
          null /* cause */,
          GrpcStatusCode.of(Code.INVALID_ARGUMENT),
          false /* retryable */);
    }

    BatchCreateMediaItemsRequest request =
        BatchCreateMediaItemsRequest.newBuilder().addAllNewMediaItems(newMediaItems).build();
    return batchCreateMediaItems(request);
  }

  /**
   * Creates one or more media items in a user's Google Photos library and adds them to an album.
   *
   * @param albumId Identifier of the album where the media items are added. The media items are
   *     also added to the user's library.
   * @param newMediaItems List of media items to be created.
   * @see #batchCreateMediaItems(String, List, AlbumPosition)
   */
  public final BatchCreateMediaItemsResponse batchCreateMediaItems(
      String albumId, List<NewMediaItem> newMediaItems) {
    if (Strings.isNullOrEmpty(albumId)) {
      throw new InvalidArgumentException(
          "Request must have an album id.",
          null /* cause */,
          GrpcStatusCode.of(Code.INVALID_ARGUMENT),
          false /* retryable */);
    }

    BatchCreateMediaItemsRequest request =
        BatchCreateMediaItemsRequest.newBuilder()
            .setAlbumId(albumId)
            .addAllNewMediaItems(newMediaItems)
            .build();
    return batchCreateMediaItems(request);
  }

  /**
   * Creates an album in a user's Google Photos library.
   *
   * @param albumTitle Name of the album displayed to the user in their Google Photos account. This
   *     string shouldn't be more than 500 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   * @throws IllegalArgumentException if albumTitle is null or empty.
   */
  public final Album createAlbum(String albumTitle) {
    if (Strings.isNullOrEmpty(albumTitle)) {
      throw new IllegalArgumentException("The album title cannot be null or empty.");
    }

    return super.createAlbum(Album.newBuilder().setTitle(albumTitle).build());
  }

  /**
   * Updates the title of an album.
   *
   * <p>Only the `id` field of the album is used to identify the album. The album must be created by
   * the developer and owned by the user.
   *
   * @param album Required. The [Album][google.photos.types.Album] to update.
   *     <p>The album’s `id` field is used to identify the album to be updated.
   * @param newTitle Required. The new title of the album.
   * @return The updated album.
   * @throws IllegalArgumentException if newTitle is null or empty.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Album updateAlbumTitle(Album album, String newTitle) {
    if (Strings.isNullOrEmpty(newTitle)) {
      throw new IllegalArgumentException("The new album title cannot be null or empty.");
    }

    Album newAlbum = Album.newBuilder(album).setTitle(newTitle).build();
    FieldMask updateMask = FieldMask.newBuilder().addPaths("title").build();
    return super.updateAlbum(newAlbum, updateMask);
  }

  /**
   * Updates the media item used as the cover photo for an album.
   *
   * <p>The newCoverPhotoMediaItem must be a media item contained within the album.
   *
   * <p>Only the `id` field of the album is used to identify the album. The album must be created by
   * the developer and owned by the user.
   *
   * @param album Required. The [Album][google.photos.types.Album] to update.
   *     <p>The album’s `id` field is used to identify the album to be updated.
   * @param newCoverPhotoMediaItem Required. The new cover photo for the album.
   * @return The updated album.
   * @throws IllegalArgumentException if newCoverPhotoMediaItem is null.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails.
   */
  public final Album updateAlbumCoverPhoto(Album album, MediaItem newCoverPhotoMediaItem) {
    if (newCoverPhotoMediaItem == null) {
      throw new IllegalArgumentException("The new cover photo media item cannot be null.");
    }

    return updateAlbumCoverPhoto(album, newCoverPhotoMediaItem.getId());
  }

  /**
   * Updates the media item used as the cover photo for an album.
   *
   * <p>The newCoverPhotoMediaItemId must refer to a media item contained within the album.
   *
   * <p>Only the `id` field of the album is used to identify the album. The album must be created by
   * the developer and owned by the user.
   *
   * @param album Required. The [Album][google.photos.types.Album] to update.
   *     <p>The album’s `id` field is used to identify the album to be updated.
   * @param newCoverPhotoMediaItemId Required. The identifier of the new cover photo for the album.
   * @return The updated album.
   * @throws IllegalArgumentException if newCoverPhotoMediaItem is null.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails.
   */
  public final Album updateAlbumCoverPhoto(Album album, String newCoverPhotoMediaItemId) {
    if (Strings.isNullOrEmpty(newCoverPhotoMediaItemId)) {
      throw new IllegalArgumentException(
          "The new cover photo media item identifier cannot be null.");
    }

    Album newAlbum =
        Album.newBuilder(album).setCoverPhotoMediaItemId(newCoverPhotoMediaItemId).build();
    // FieldMask paths must be specified in snake_case.
    FieldMask updateMask = FieldMask.newBuilder().addPaths("cover_photo_media_item_id").build();

    return super.updateAlbum(newAlbum, updateMask);
  }

  /**
   * Updates the description of a media item.
   *
   * <p>Only the `id` field of the media item is used to identify the item. The media item must be
   * created by the developer and owned by the user.
   *
   * @param mediaItem Required. The [MediaItem][google.photos.types.MediaItem] to update.
   *     <p>The media item's `id` field is used to identify the media item to be updated.
   * @param newDescription Required. The new description of the media item.
   * @return The updated media item.
   * @throws IllegalArgumentException if newDescription is null.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails.
   */
  public final MediaItem updateMediaItemDescription(MediaItem mediaItem, String newDescription) {
    if (newDescription == null) {
      throw new IllegalArgumentException("The new edia item description cannot be null.");
    }

    MediaItem newMediaItem = MediaItem.newBuilder(mediaItem).setDescription(newDescription).build();
    FieldMask updateMask = FieldMask.newBuilder().addPaths("description").build();
    return super.updateMediaItem(newMediaItem, updateMask);
  }

  /**
   * Lists all albums shown to a user in the Albums tab of the Google Photos app.
   *
   * <p>Calls {@link #listAlbums(boolean)} with excludeNonAppCreateData set to false.
   */
  public final ListAlbumsPagedResponse listAlbums() {
    return super.listAlbums(false);
  }

  /**
   * List all media items in a user's Google Photos library.
   *
   * <p>Calls {@link #listMediaItems(ListMediaItemsRequest)} with an empty {@link
   * ListMediaItemsRequest}.
   */
  public final ListMediaItemsPagedResponse listMediaItems() {
    return super.listMediaItems(ListMediaItemsRequest.newBuilder().build());
  }

  /**
   * Lists all shared albums available in the Sharing tab of the user's Google Photos app.
   *
   * <p>Calls {@link #listSharedAlbums(boolean)} with excludeNonAppCreateData set to false.
   */
  public final ListSharedAlbumsPagedResponse listSharedAlbums() {
    return super.listSharedAlbums(false);
  }

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
   *   OrderBy newestFirstOrder = OrderBy.MEDIAMETADATA_CREATION_TIME_DESC;
   *   for (MediaItem element :
   *       internalPhotosLibraryClient.searchMediaItems(filters, newestFirstOrder).iterateAll()) {
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
   *     {@link OrderBy#MEDIAMETADATA_CREATION_TIME} displays search results in the opposite order, oldest first
   *     then newest last. To display results newest first then oldest last, include the `desc`
   *     argument using {@link OrderBy#MEDIAMETADATA_CREATION_TIME_DESC}.
   *     <p>The only additional filters that can be used with this parameter are
   *     [includeArchivedMedia][google.photos.library.v1.Filters.include_archived_media] and
   *     [excludeNonAppCreatedData][google.photos.library.v1.Filters.exclude_non_app_created_data].
   *     No other filters are supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMediaItemsPagedResponse searchMediaItems(Filters filters, OrderBy... orderBy) {
    // Construct the orderBy string.
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < orderBy.length; i++) {
      builder.append(orderBy[i].getRequestValue());
      // Add the separator string if there are additional values.
      if (i < orderBy.length - 1) {
        builder.append(OrderBy.SEPARATOR);
      }
    }

    return super.searchMediaItems(filters, builder.toString());
  }

  @Override
  public void close() {
    super.close();
    try {
      uploadStub.close();
    } catch (Exception e) {
      // workaround to avoid to modify parent's signature. Should not be needed starting from gax v2
      throw new RuntimeException(e);
    }
  }
}
