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

package com.google.photos.library.sample.demos;

import static com.google.photos.library.sample.Resources.TITLE;
import static com.google.photos.library.sample.demos.FilterDemo.getOnApplicationClosedFn;
import static com.google.photos.library.sample.demos.FilterDemo.getOnBackClickedFn;
import static com.google.photos.library.sample.demos.FilterDemo.getOnItemClicked;
import static com.google.photos.library.sample.helpers.UIHelper.getFormattedText;

import com.google.api.core.ApiFuture;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.photos.library.sample.components.AppPanel;
import com.google.photos.library.sample.components.CreateAlbumToolPanel;
import com.google.photos.library.sample.components.UploadToAlbumToolPanel;
import com.google.photos.library.sample.factories.PhotosLibraryClientFactory;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.suppliers.ListAlbumsSupplier;
import com.google.photos.library.sample.suppliers.SearchMediaItemSupplier;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.library.sample.views.AlbumListView;
import com.google.photos.library.sample.views.ConnectToPhotosView;
import com.google.photos.library.sample.views.LoadingView;
import com.google.photos.library.sample.views.PhotoListView;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest;
import com.google.photos.library.v1.proto.ListAlbumsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.upload.UploadMediaItemRequest;
import com.google.photos.library.v1.upload.UploadMediaItemResponse;
import com.google.photos.types.proto.Album;
import java.awt.FontFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 * Google Photos Library API Sample.
 *
 * <p>Sample app for album use cases: read, add and create.
 *
 * <p>This sample uses the following api methods:
 *
 * <ul>
 *   <li>batchCreateMediaItems: create media items in an album
 *   <li>createAlbum: create a new album
 *   <li>listAlbums: list albums in a library
 *   <li>searchMediaItems: list photos in an album
 *   <li>uploadMediaItem: upload a photo
 * </ul>
 */
public final class AlbumDemo {
  public static final String ALBUM_TITLE = "Photos album sample app";
  public static final String ALBUM_SAMPLE_IMAGE_RESOURCE = "/assets/album.png";
  public static final String ALBUM_INTRODUCTION =
      "<html>"
          + getFormattedText(
              "Google Photos Library API Sample", 14 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText("Albums: read, add + create", 22 /* fontSize */, 10 /* lineMargin */)
          + getFormattedText("This sample will cover", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Connecting to a Google Photos library", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Requesting scopes from the Google Photos user",
              12 /* fontSize */,
              2 /* lineMargin */)
          + getFormattedText(" - Reading the album list", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(" - Creating an album", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Adding media items to an album", 12 /* fontSize */, 2 /* lineMargin */)
          + "</html>";

  private static final List<String> REQUIRED_SCOPES =
      ImmutableList.of(
          "https://www.googleapis.com/auth/photoslibrary.readonly",
          "https://www.googleapis.com/auth/photoslibrary.appendonly");

  private static final String FILE_ACCESS_MODE = "r";

  private AlbumDemo() {}

  /**
   * Runs the album sample. An optional path to a credentials file can be specified as the first
   * commandline argument.
   */
  public static void main(String[] args) {
    // If the first argument is set, it contains the path to the credentials file.
    Optional<String> credentialsFile = Optional.empty();

    if (args.length > 0) {
      credentialsFile = Optional.of(args[0]);
    }

    UIHelper.setUp();

    ConnectToPhotosView connectToPhotosView =
        new ConnectToPhotosView(
            TITLE,
            ALBUM_INTRODUCTION,
            ALBUM_SAMPLE_IMAGE_RESOURCE,
            credentialsFile,
            getOnCredentialsSelectedFn(),
            getOnApplicationClosedFn() /* onViewClosed */);
    connectToPhotosView.showView();
  }

  private static BiConsumer<ConnectToPhotosView, String> getOnCredentialsSelectedFn() {
    return (connectToPhotosView, credentialsPath) -> {
      connectToPhotosView.hideView();
      try {
        PhotosLibraryClient client =
            PhotosLibraryClientFactory.createClient(credentialsPath, REQUIRED_SCOPES);
        connectToPhotosView.hideView();
        showAlbums(client);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(connectToPhotosView, e.getMessage());
      }
    };
  }

  private static void showAlbums(PhotosLibraryClient client)
      throws IOException, FontFormatException {
    ListAlbumsRequest request = ListAlbumsRequest.getDefaultInstance();
    final ListAlbumsSupplier listAlbumsSupplier = new ListAlbumsSupplier(client, request);
    AppPanel appPanel =
        new AppPanel(ALBUM_TITLE, getOnApplicationClosedFn() /* onSignoutClicked */);
    CreateAlbumToolPanel createAlbumToolPanel =
        new CreateAlbumToolPanel(getOnCreateClickedFn(client));
    AlbumListView albumListView =
        new AlbumListView(
            appPanel,
            createAlbumToolPanel,
            listAlbumsSupplier,
            getOnAlbumClickedFn(client),
            getOnApplicationClosedFn() /* onViewClosed */);
    albumListView.showView();
  }

  private static BiConsumer<AbstractCustomView, String> getOnCreateClickedFn(
      PhotosLibraryClient client) {
    return (abstractCustomView, newAlbumTitle) -> {
      try {
        client.createAlbum(Album.newBuilder().setTitle(newAlbumTitle).build());
        abstractCustomView.updateView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(abstractCustomView, e.getMessage());
        abstractCustomView.showView();
      }
    };
  }

  private static BiConsumer<AlbumListView, Album> getOnAlbumClickedFn(PhotosLibraryClient client) {
    return (albumListView, album) -> {
      albumListView.hideView();
      try {
        showPhotosInAlbum(albumListView, client, album, photoListView -> albumListView.showView());
      } catch (Exception e) {
        JOptionPane.showMessageDialog(albumListView, e.getMessage());
        albumListView.showView();
      }
    };
  }

  private static void showPhotosInAlbum(
      AlbumListView albumListView,
      PhotosLibraryClient client,
      Album album,
      Consumer<PhotoListView> onAlbumClosed)
      throws IOException {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setAlbumId(album.getId()).build();
    SearchMediaItemSupplier mediaItemSupplier = new SearchMediaItemSupplier(client, request);

    AppPanel appPanel =
        new AppPanel(
            ALBUM_TITLE,
            getOnBackClickedFn(albumListView),
            getOnApplicationClosedFn() /* onSignoutClicked */);
    UploadToAlbumToolPanel uploadToAlbumToolPanel =
        new UploadToAlbumToolPanel(album, getOnFileSelectedFn(client, album));

    PhotoListView photoListView =
        new PhotoListView(
            appPanel, uploadToAlbumToolPanel, mediaItemSupplier, getOnItemClicked(), onAlbumClosed);
    photoListView.showView();
  }

  private static BiConsumer<AbstractCustomView, List<String>> getOnFileSelectedFn(
      PhotosLibraryClient client, Album album) {
    return (abstractCustomView, mediaItemPaths) -> {
      PhotoListView photoListView = (PhotoListView) abstractCustomView;
      for (String mediaItemPath : mediaItemPaths) {
        try {
          UploadMediaItemRequest.Builder uploadRequestBuilder = UploadMediaItemRequest.newBuilder();
          uploadRequestBuilder
              .setMimeType(URLConnection.guessContentTypeFromName(mediaItemPath))
              .setDataFile(new RandomAccessFile(mediaItemPath, FILE_ACCESS_MODE));
          ApiFuture<UploadMediaItemResponse> uploadResponseFuture =
              client.uploadMediaItemCallable().futureCall(uploadRequestBuilder.build());

          // Show loading dialog while uploading
          LoadingView.getLoadingView().showView();

          uploadResponseFuture.addListener(
              getOnUploadFinished(
                  client, photoListView, uploadResponseFuture, album, mediaItemPath),
              MoreExecutors.directExecutor());
        } catch (FileNotFoundException e) {
          LoadingView.getLoadingView().hideView();
          JOptionPane.showMessageDialog(photoListView, e.getMessage());
        }
      }
    };
  }

  private static Runnable getOnUploadFinished(
      PhotosLibraryClient client,
      PhotoListView photoListView,
      ApiFuture<UploadMediaItemResponse> uploadResponseFuture,
      Album album,
      String fileName) {
    return () -> {
      try {
        UploadMediaItemResponse uploadResponse = uploadResponseFuture.get();
        // Check if the upload is successful
        if (uploadResponse.getUploadToken().isPresent()) {
          BatchCreateMediaItemsRequest.Builder createRequestBuilder =
              BatchCreateMediaItemsRequest.newBuilder();
          createRequestBuilder.setAlbumId(album.getId());
          createRequestBuilder
              .addNewMediaItemsBuilder()
              .getSimpleMediaItemBuilder()
              .setFileName(fileName)
              .setUploadToken(uploadResponse.getUploadToken().get());
          client.batchCreateMediaItems(createRequestBuilder.build());

          // Hide loading dialog after finishing creating
          LoadingView.getLoadingView().hideView();

          photoListView.updateView();
        } else {
          LoadingView.getLoadingView().hideView();
          JOptionPane.showMessageDialog(photoListView, uploadResponse.getError());
        }
      } catch (Exception e) {
        LoadingView.getLoadingView().hideView();
        JOptionPane.showMessageDialog(photoListView, e.getMessage());
      }
    };
  }
}
