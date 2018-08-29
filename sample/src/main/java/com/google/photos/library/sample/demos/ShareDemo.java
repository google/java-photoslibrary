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

import com.google.common.collect.ImmutableList;
import com.google.photos.library.sample.components.AppPanel;
import com.google.photos.library.sample.components.ShareAlbumToolPanel;
import com.google.photos.library.sample.components.ShareAndJoinAlbumToolPanel;
import com.google.photos.library.sample.components.ShareableAlbumToolPanel;
import com.google.photos.library.sample.factories.PhotosLibraryClientFactory;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.suppliers.ListAlbumsSupplier;
import com.google.photos.library.sample.suppliers.ListSharedAlbumsSupplier;
import com.google.photos.library.sample.suppliers.SearchMediaItemSupplier;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.library.sample.views.AlbumListView;
import com.google.photos.library.sample.views.ConnectToPhotosView;
import com.google.photos.library.sample.views.PhotoListView;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.Album;
import com.google.photos.library.v1.proto.ListAlbumsRequest;
import com.google.photos.library.v1.proto.ListSharedAlbumsRequest;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.proto.ShareAlbumResponse;
import com.google.photos.library.v1.proto.SharedAlbumOptions;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 * Google Photos Library API Sample.
 *
 * <p>Sample app for sharing use cases: share and join.
 *
 * <p>This sample uses the following api methods:
 *
 * <ul>
 *   <li>listAlbums: list albums in a library
 *   <li>searchMediaItem: list photos in an album
 *   <li>joinSharedAlbum: join a shared album
 *   <li>shareAlbum: share an album
 * </ul>
 */
public final class ShareDemo {
  public static final String SHARE_TITLE = "Photos share sample app";
  public static final String SHARE_SAMPLE_IMAGE_RESOURCE = "/assets/share.png";
  public static final String SHARE_INTRODUCTION =
      "<html>"
          + getFormattedText(
              "Google Photos Library API Sample", 14 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText("Share and join", 22 /* fontSize */, 10 /* lineMargin */)
          + getFormattedText("This sample will cover", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Connecting to a Google Photos library", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Requesting scopes from the Google Photos user",
              12 /* fontSize */,
              2 /* lineMargin */)
          + getFormattedText(" - Reading the album list", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(" - Joining a shared album", 12 /* fontSize */, 2 /* lineMargin */)
          + "</html>";

  private static final List<String> REQUIRED_SCOPES =
      ImmutableList.of(
          "https://www.googleapis.com/auth/photoslibrary.readonly",
          "https://www.googleapis.com/auth/photoslibrary.sharing");

  private static final SharedAlbumOptions DEFAULT_SHARE_OPTIONS =
      SharedAlbumOptions.getDefaultInstance();

  private ShareDemo() {}

  /**
   * Runs the share sample. An optional path to a credentials file can be specified as the first
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
            SHARE_INTRODUCTION,
            SHARE_SAMPLE_IMAGE_RESOURCE,
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
        showSharedAlbums(client);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(connectToPhotosView, e.getMessage());
      }
    };
  }

  private static void showSharedAlbums(PhotosLibraryClient client) throws IOException {
    ListSharedAlbumsRequest request = ListSharedAlbumsRequest.getDefaultInstance();
    final ListSharedAlbumsSupplier albumSupplier = new ListSharedAlbumsSupplier(client, request);
    AppPanel appPanel =
        new AppPanel(SHARE_TITLE, getOnApplicationClosedFn() /* onSignoutClicked */);
    ShareAndJoinAlbumToolPanel shareAndJoinAlbumToolPanel =
        new ShareAndJoinAlbumToolPanel(
            getOnListShareableAlbumsClickedFn(client), getOnJoinClickedFn(client));
    AlbumListView sharedAlbumListView =
        new AlbumListView(
            appPanel,
            shareAndJoinAlbumToolPanel,
            albumSupplier,
            getOnAlbumClickedFn(client),
            getOnApplicationClosedFn());
    sharedAlbumListView.showView();
  }

  private static BiConsumer<AbstractCustomView, String> getOnJoinClickedFn(
      PhotosLibraryClient client) {
    return (abstractCustomView, shareToken) -> {
      client.joinSharedAlbum(shareToken);
      try {
        abstractCustomView.updateView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(abstractCustomView, e.getMessage());
      }
    };
  }

  private static Consumer<AbstractCustomView> getOnListShareableAlbumsClickedFn(
      PhotosLibraryClient client) {
    return abstractCustomView -> {
      AlbumListView sharedAlbumListView = (AlbumListView) abstractCustomView;
      sharedAlbumListView.hideView();
      final ListAlbumsSupplier albumsSupplier =
          new ListAlbumsSupplier(client, ListAlbumsRequest.getDefaultInstance());
      try {
        AppPanel appPanel =
            new AppPanel(
                SHARE_TITLE, getOnBackClickedFn(sharedAlbumListView), getOnApplicationClosedFn());
        ShareableAlbumToolPanel shareableAlbumToolPanel = new ShareableAlbumToolPanel();

        AlbumListView shareableAlbumListView =
            new AlbumListView(
                appPanel,
                shareableAlbumToolPanel,
                albumsSupplier,
                getOnAlbumClickedFn(client),
                getOnBackClickedFn(sharedAlbumListView));
        shareableAlbumListView.showView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(sharedAlbumListView, e.getMessage());
        sharedAlbumListView.showView();
      }
    };
  }

  private static BiConsumer<AlbumListView, Album> getOnAlbumClickedFn(PhotosLibraryClient client) {
    return (albumListView, album) -> {
      albumListView.hideView();
      try {
        showPhotosInAlbum(albumListView, client, album);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(albumListView, e.getMessage());
        albumListView.showView();
      }
    };
  }

  private static void showPhotosInAlbum(
      AlbumListView albumListView, PhotosLibraryClient client, Album album) throws IOException {
    SearchMediaItemsRequest request =
        SearchMediaItemsRequest.newBuilder().setAlbumId(album.getId()).build();
    SearchMediaItemSupplier mediaItemSupplier = new SearchMediaItemSupplier(client, request);

    AppPanel appPanel =
        new AppPanel(
            SHARE_TITLE,
            getOnBackClickedFn(albumListView),
            getOnApplicationClosedFn() /* onSignoutClicked */);

    ShareAlbumToolPanel toolPanel =
        new ShareAlbumToolPanel(album, getOnShareClickedFn(albumListView, client));

    PhotoListView photoListViewForm =
        new PhotoListView(
            appPanel,
            toolPanel,
            mediaItemSupplier,
            getOnItemClicked(),
            getOnAlbumViewClosed(albumListView));
    photoListViewForm.showView();
  }

  private static Consumer<PhotoListView> getOnAlbumViewClosed(AlbumListView albumListView) {
    return photoListView -> {
      try {
        albumListView.updateView();
        albumListView.showView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(photoListView, e.getMessage());
      }
    };
  }

  private static BiConsumer<AbstractCustomView, Album> getOnShareClickedFn(
      AlbumListView albumListView, PhotosLibraryClient client) {
    return (abstractCustomView, album) -> {
      // Release the current view
      abstractCustomView.hideView();
      abstractCustomView.dispose();

      ShareAlbumResponse response = client.shareAlbum(album.getId(), DEFAULT_SHARE_OPTIONS);
      Album sharedAlbum = album.toBuilder().setShareInfo(response.getShareInfo()).build();

      // Show a new view for the album
      try {
        showPhotosInAlbum(albumListView, client, sharedAlbum);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(abstractCustomView, e.getMessage());
      }
    };
  }
}
