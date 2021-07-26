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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PhotosLibrary service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PhotosLibraryStub implements BackgroundResource {

  public UnaryCallable<CreateAlbumRequest, Album> createAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: createAlbumCallable()");
  }

  public UnaryCallable<BatchCreateMediaItemsRequest, BatchCreateMediaItemsResponse>
      batchCreateMediaItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateMediaItemsCallable()");
  }

  public UnaryCallable<BatchAddMediaItemsToAlbumRequest, BatchAddMediaItemsToAlbumResponse>
      batchAddMediaItemsToAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: batchAddMediaItemsToAlbumCallable()");
  }

  public UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsPagedResponse>
      searchMediaItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchMediaItemsPagedCallable()");
  }

  public UnaryCallable<SearchMediaItemsRequest, SearchMediaItemsResponse>
      searchMediaItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchMediaItemsCallable()");
  }

  public UnaryCallable<ListMediaItemsRequest, ListMediaItemsPagedResponse>
      listMediaItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMediaItemsPagedCallable()");
  }

  public UnaryCallable<ListMediaItemsRequest, ListMediaItemsResponse> listMediaItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMediaItemsCallable()");
  }

  public UnaryCallable<GetMediaItemRequest, MediaItem> getMediaItemCallable() {
    throw new UnsupportedOperationException("Not implemented: getMediaItemCallable()");
  }

  public UnaryCallable<BatchGetMediaItemsRequest, BatchGetMediaItemsResponse>
      batchGetMediaItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetMediaItemsCallable()");
  }

  public UnaryCallable<ListAlbumsRequest, ListAlbumsPagedResponse> listAlbumsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAlbumsPagedCallable()");
  }

  public UnaryCallable<ListAlbumsRequest, ListAlbumsResponse> listAlbumsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAlbumsCallable()");
  }

  public UnaryCallable<GetAlbumRequest, Album> getAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: getAlbumCallable()");
  }

  public UnaryCallable<GetSharedAlbumRequest, Album> getSharedAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: getSharedAlbumCallable()");
  }

  public UnaryCallable<AddEnrichmentToAlbumRequest, AddEnrichmentToAlbumResponse>
      addEnrichmentToAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: addEnrichmentToAlbumCallable()");
  }

  public UnaryCallable<JoinSharedAlbumRequest, JoinSharedAlbumResponse> joinSharedAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: joinSharedAlbumCallable()");
  }

  public UnaryCallable<LeaveSharedAlbumRequest, LeaveSharedAlbumResponse>
      leaveSharedAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: leaveSharedAlbumCallable()");
  }

  public UnaryCallable<ShareAlbumRequest, ShareAlbumResponse> shareAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: shareAlbumCallable()");
  }

  public UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsPagedResponse>
      listSharedAlbumsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharedAlbumsPagedCallable()");
  }

  public UnaryCallable<ListSharedAlbumsRequest, ListSharedAlbumsResponse>
      listSharedAlbumsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharedAlbumsCallable()");
  }

  public UnaryCallable<UnshareAlbumRequest, UnshareAlbumResponse> unshareAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: unshareAlbumCallable()");
  }

  public UnaryCallable<
          BatchRemoveMediaItemsFromAlbumRequest, BatchRemoveMediaItemsFromAlbumResponse>
      batchRemoveMediaItemsFromAlbumCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRemoveMediaItemsFromAlbumCallable()");
  }

  public UnaryCallable<UpdateAlbumRequest, Album> updateAlbumCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAlbumCallable()");
  }

  public UnaryCallable<UpdateMediaItemRequest, MediaItem> updateMediaItemCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMediaItemCallable()");
  }

  @Override
  public abstract void close();
}
