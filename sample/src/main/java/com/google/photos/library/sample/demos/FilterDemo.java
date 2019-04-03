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
import static com.google.photos.library.sample.helpers.UIHelper.getFormattedText;

import com.google.common.collect.ImmutableList;
import com.google.photos.library.sample.components.AppPanel;
import com.google.photos.library.sample.components.SearchToolPanel;
import com.google.photos.library.sample.factories.PhotosLibraryClientFactory;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.suppliers.SearchMediaItemSupplier;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.library.sample.views.ConnectToPhotosView;
import com.google.photos.library.sample.views.PhotoListView;
import com.google.photos.library.sample.views.PhotoView;
import com.google.photos.library.sample.views.SearchMediaItemView;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.types.proto.MediaItem;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 * Google Photos Library API Sample.
 *
 * <p>Sample app for filter use cases: content categories and date range.
 *
 * <p>This sample uses the following api methods:
 *
 * <ul>
 *   <li>searchMediaItems
 * </ul>
 */
public final class FilterDemo {

  public static final String FILTER_TITLE = "Photos filter sample app";
  public static final String FILTER_SAMPLE_IMAGE_RESOURCE = "/assets/filter.png";
  public static final String FILTER_INTRODUCTION =
      "<html>"
          + getFormattedText(
              "Google Photos Library API Sample", 14 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText("Read from library and filter", 22 /* fontSize */, 10 /* lineMargin */)
          + getFormattedText("This sample will cover", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Connecting to a Google Photos library", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Requesting scopes from the Google Photos user",
              12 /* fontSize */,
              2 /* lineMargin */)
          + getFormattedText(" - Reading the entire library", 12 /* fontSize */, 2 /* lineMargin */)
          + getFormattedText(
              " - Applying filters on a library", 12 /* fontSize */, 2 /* lineMargin */)
          + "</html>";

  private static final List<String> REQUIRED_SCOPES =
      ImmutableList.of("https://www.googleapis.com/auth/photoslibrary.readonly");

  private FilterDemo() {}

  /**
   * Runs the filter sample. An optional path to a credentials file can be specified as the first
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
            FILTER_INTRODUCTION,
            FILTER_SAMPLE_IMAGE_RESOURCE,
            credentialsFile,
            getOnCredentialsSelectedFn(),
            getOnApplicationClosedFn() /* onViewClosed */);
    connectToPhotosView.showView();
  }

  private static BiConsumer<ConnectToPhotosView, String> getOnCredentialsSelectedFn() {
    return (connectForm, credentialsPath) -> {
      try {
        PhotosLibraryClient client =
            PhotosLibraryClientFactory.createClient(credentialsPath, REQUIRED_SCOPES);
        connectForm.hideView();
        showPhotosInLibrary(client);
      } catch (Exception e) {
        JOptionPane.showMessageDialog(connectForm, e.getMessage());
      }
    };
  }

  private static void showPhotosInLibrary(PhotosLibraryClient client) throws IOException {
    SearchMediaItemsRequest request = SearchMediaItemsRequest.getDefaultInstance();
    final SearchMediaItemSupplier mediaItemSupplier = new SearchMediaItemSupplier(client, request);
    AppPanel appPanel =
        new AppPanel(FILTER_TITLE, getOnApplicationClosedFn() /* onSignoutClicked */);
    SearchToolPanel searchToolPanel = new SearchToolPanel(getOnSearchClickedFn(mediaItemSupplier));
    PhotoListView photoListView =
        new PhotoListView(
            appPanel,
            searchToolPanel,
            mediaItemSupplier,
            getOnItemClicked(),
            getOnApplicationClosedFn());
    photoListView.showView();
  }

  private static Consumer<AbstractCustomView> getOnSearchClickedFn(
      SearchMediaItemSupplier mediaItemSupplier) {
    return abstractCustomView -> {
      PhotoListView photoListView = (PhotoListView) abstractCustomView;
      photoListView.hideView();
      try {
        AppPanel appPanel =
            new AppPanel(
                FILTER_TITLE,
                getOnBackClickedFn(photoListView),
                getOnApplicationClosedFn() /* onSignoutClicked */);
        SearchMediaItemView searchMediaItemView =
            new SearchMediaItemView(
                appPanel,
                searchForm -> photoListView.showView(), /* On form closed */
                getOnApplyFiltersClickedFn(photoListView, mediaItemSupplier));
        searchMediaItemView.showView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(photoListView, e.getMessage());
        photoListView.showView();
      }
    };
  }

  static BiConsumer<PhotoListView, MediaItem> getOnItemClicked() {
    return (photoListView, mediaItem) -> {
      photoListView.hideView();
      try {
        AppPanel appPanel =
            new AppPanel(
                mediaItem.getDescription(),
                getOnBackClickedFn(photoListView),
                getOnApplicationClosedFn() /* onSignoutClicked */);
        PhotoView photoView = new PhotoView(appPanel, mediaItem, view -> photoListView.showView());
        photoView.showView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(photoListView, e.getMessage());
        photoListView.showView();
      }
    };
  }

  private static BiConsumer<SearchMediaItemView, SearchMediaItemsRequest>
      getOnApplyFiltersClickedFn(
          PhotoListView photoListView, SearchMediaItemSupplier mediaItemSupplier) {
    return (searchMediaItemView, searchMediaItemsRequest) -> {
      searchMediaItemView.hideView();
      mediaItemSupplier.setBaseRequest(searchMediaItemsRequest);
      try {
        photoListView.updateView();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(photoListView, e.getMessage());
      }
      photoListView.showView();
    };
  }

  static <T> Consumer<T> getOnApplicationClosedFn() {
    return view -> System.exit(0);
  }

  static <T extends AbstractCustomView> Consumer<T> getOnBackClickedFn(
      AbstractCustomView photoListView) {
    return abstractCustomView -> {
      abstractCustomView.hideView();
      abstractCustomView.dispose();
      photoListView.showView();
    };
  }
}
