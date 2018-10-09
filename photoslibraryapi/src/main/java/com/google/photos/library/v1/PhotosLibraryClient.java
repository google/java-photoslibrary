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
import com.google.photos.library.v1.proto.Album;
import com.google.photos.library.v1.proto.AlbumPosition;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.ListMediaItemsRequest;
import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.upload.PhotosLibraryUploadStub;
import com.google.photos.library.v1.upload.PhotosLibraryUploadStubImpl;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
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
    return uploadStub.uploadMediaItemCallable().call(request);
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
    if (albumTitle == null || albumTitle.isEmpty()) {
      throw new IllegalArgumentException("The album title cannot be null or empty.");
    }

    return super.createAlbum(Album.newBuilder().setTitle(albumTitle).build());
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
}
