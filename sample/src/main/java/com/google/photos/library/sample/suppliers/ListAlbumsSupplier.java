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

package com.google.photos.library.sample.suppliers;

import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.ListAlbumsRequest;
import com.google.photos.library.v1.proto.ListAlbumsResponse;
import com.google.photos.types.proto.Album;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class ListAlbumsSupplier implements AlbumsSupplier {
  private final PhotosLibraryClient client;
  private final ListAlbumsRequest baseRequest;
  private Optional<ListAlbumsRequest> request;

  public ListAlbumsSupplier(PhotosLibraryClient client, ListAlbumsRequest request) {
    this.client = client;
    this.baseRequest = request;
    this.request = Optional.of(this.baseRequest);
  }

  @Override
  public List<Album> get() {
    if (!request.isPresent()) {
      return Collections.emptyList();
    }
    ListAlbumsResponse response = client.listAlbumsCallable().call(request.get());
    if (response.getNextPageToken().isEmpty()) {
      request = Optional.empty();
    } else {
      request =
          Optional.of(request.get().toBuilder().setPageToken(response.getNextPageToken()).build());
    }
    return response.getAlbumsList();
  }

  @Override
  public void refresh() {
    this.request = Optional.of(this.baseRequest);
  }
}
