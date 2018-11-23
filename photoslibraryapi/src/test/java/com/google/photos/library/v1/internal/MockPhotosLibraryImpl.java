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
package com.google.photos.library.v1.internal;

import com.google.api.core.BetaApi;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest;
import com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse;
import com.google.photos.library.v1.proto.Album;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse;
import com.google.photos.library.v1.proto.BatchGetMediaItemsRequest;
import com.google.photos.library.v1.proto.BatchGetMediaItemsResponse;
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
import com.google.photos.library.v1.proto.MediaItem;
import com.google.photos.library.v1.proto.PhotosLibraryGrpc.PhotosLibraryImplBase;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsResponse;
import com.google.photos.library.v1.proto.ShareAlbumRequest;
import com.google.photos.library.v1.proto.ShareAlbumResponse;
import com.google.photos.library.v1.proto.UnshareAlbumRequest;
import com.google.photos.library.v1.proto.UnshareAlbumResponse;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockPhotosLibraryImpl extends PhotosLibraryImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<Object> responses;

  public MockPhotosLibraryImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void addResponse(GeneratedMessageV3 response) {
    responses.add(response);
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createAlbum(CreateAlbumRequest request, StreamObserver<Album> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Album) {
      requests.add(request);
      responseObserver.onNext((Album) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchCreateMediaItems(
      BatchCreateMediaItemsRequest request,
      StreamObserver<BatchCreateMediaItemsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchCreateMediaItemsResponse) {
      requests.add(request);
      responseObserver.onNext((BatchCreateMediaItemsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void searchMediaItems(
      SearchMediaItemsRequest request, StreamObserver<SearchMediaItemsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SearchMediaItemsResponse) {
      requests.add(request);
      responseObserver.onNext((SearchMediaItemsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listMediaItems(
      ListMediaItemsRequest request, StreamObserver<ListMediaItemsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListMediaItemsResponse) {
      requests.add(request);
      responseObserver.onNext((ListMediaItemsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getMediaItem(
      GetMediaItemRequest request, StreamObserver<MediaItem> responseObserver) {
    Object response = responses.remove();
    if (response instanceof MediaItem) {
      requests.add(request);
      responseObserver.onNext((MediaItem) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchGetMediaItems(
      BatchGetMediaItemsRequest request,
      StreamObserver<BatchGetMediaItemsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchGetMediaItemsResponse) {
      requests.add(request);
      responseObserver.onNext((BatchGetMediaItemsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listAlbums(
      ListAlbumsRequest request, StreamObserver<ListAlbumsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAlbumsResponse) {
      requests.add(request);
      responseObserver.onNext((ListAlbumsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getAlbum(GetAlbumRequest request, StreamObserver<Album> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Album) {
      requests.add(request);
      responseObserver.onNext((Album) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getSharedAlbum(
      GetSharedAlbumRequest request, StreamObserver<Album> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Album) {
      requests.add(request);
      responseObserver.onNext((Album) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void addEnrichmentToAlbum(
      AddEnrichmentToAlbumRequest request,
      StreamObserver<AddEnrichmentToAlbumResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AddEnrichmentToAlbumResponse) {
      requests.add(request);
      responseObserver.onNext((AddEnrichmentToAlbumResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void joinSharedAlbum(
      JoinSharedAlbumRequest request, StreamObserver<JoinSharedAlbumResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof JoinSharedAlbumResponse) {
      requests.add(request);
      responseObserver.onNext((JoinSharedAlbumResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void leaveSharedAlbum(
      LeaveSharedAlbumRequest request, StreamObserver<LeaveSharedAlbumResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof LeaveSharedAlbumResponse) {
      requests.add(request);
      responseObserver.onNext((LeaveSharedAlbumResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void shareAlbum(
      ShareAlbumRequest request, StreamObserver<ShareAlbumResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ShareAlbumResponse) {
      requests.add(request);
      responseObserver.onNext((ShareAlbumResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listSharedAlbums(
      ListSharedAlbumsRequest request, StreamObserver<ListSharedAlbumsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListSharedAlbumsResponse) {
      requests.add(request);
      responseObserver.onNext((ListSharedAlbumsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void unshareAlbum(
      UnshareAlbumRequest request, StreamObserver<UnshareAlbumResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof UnshareAlbumResponse) {
      requests.add(request);
      responseObserver.onNext((UnshareAlbumResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
