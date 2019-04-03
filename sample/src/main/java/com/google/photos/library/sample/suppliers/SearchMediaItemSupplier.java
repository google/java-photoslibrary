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
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import com.google.photos.types.proto.MediaItem;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Supplier;

public final class SearchMediaItemSupplier implements Supplier<Iterable<MediaItem>> {
  private final PhotosLibraryClient client;
  private SearchMediaItemsRequest baseRequest;
  private Optional<SearchMediaItemsRequest> request;

  public SearchMediaItemSupplier(PhotosLibraryClient client, SearchMediaItemsRequest request) {
    this.client = client;
    this.baseRequest = request;
    this.request = Optional.of(request);
  }

  public void refresh() {
    this.request = Optional.of(this.baseRequest);
  }

  public void setBaseRequest(SearchMediaItemsRequest request) {
    this.baseRequest = request;
  }

  @Override
  public Iterable<MediaItem> get() {
    if (!request.isPresent()) {
      return Collections.emptyList();
    }
    SearchMediaItemsResponse response = client.searchMediaItemsCallable().call(request.get());
    if (response.getNextPageToken().isEmpty()) {
      request = Optional.empty();
    } else {
      request =
          Optional.of(request.get().toBuilder().setPageToken(response.getNextPageToken()).build());
    }
    return response.getMediaItemsList();
  }
}
