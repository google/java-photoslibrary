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

package com.google.photos.library.sample.views;

import com.google.photos.library.sample.Resources;
import com.google.photos.library.sample.components.AppPanel;
import com.google.photos.library.sample.components.LoadMoreButton;
import com.google.photos.library.sample.components.ToolPanel;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.suppliers.SearchMediaItemSupplier;
import com.google.photos.types.proto.MediaItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** An {@link AbstractCustomView} that shows list of media items. */
public class PhotoListView extends AbstractCustomView {
  private static final String LOAD_MORE_TEXT = "LOAD MORE PHOTOS";

  private static final int CONTENT_PANEL_HGAP = 32;
  private static final int CONTENT_PANEL_VGAP = 32;
  private static final Border CONTENT_BORDER =
      new EmptyBorder(32 /* top */, 40 /* left */, 32 /* bottom */, 40 /* right */);

  private static final int ITEMS_PER_ROW = 5;
  private static final int ITEM_GRID_HGAP = 25;
  private static final int ITEM_GRID_VGAP = 25;
  private static final int ITEM_WIDTH = 162;
  private static final int ITEM_HEIGHT = 162;

  private static final Dimension DIALOG_DIMENSION =
      new Dimension(1000 /* width */, 922 /* height */);

  private final AppPanel appPanel;
  private final ToolPanel toolPanel;
  private final SearchMediaItemSupplier mediaItemSupplier;
  private final BiConsumer<PhotoListView, MediaItem> onItemClicked;
  private final Consumer<PhotoListView> onClosed;

  private JPanel photoGridPanel;

  public PhotoListView(
      AppPanel appPanel,
      ToolPanel toolPanel,
      SearchMediaItemSupplier mediaItemSupplier,
      BiConsumer<PhotoListView, MediaItem> onItemClicked,
      Consumer<PhotoListView> onClosed) {
    this.appPanel = appPanel;
    this.toolPanel = toolPanel;
    this.mediaItemSupplier = mediaItemSupplier;
    this.onItemClicked = onItemClicked;
    this.onClosed = onClosed;

    UIHelper.setFixedSize(this, DIALOG_DIMENSION);

    initializeView();
  }

  @Override
  protected void initialize() throws Exception {
    initializeDialog(appPanel, onClosed);

    JPanel contentPanel = initializeContentPanel();
    contentPanel.add(toolPanel, BorderLayout.PAGE_START);
    contentPanel.add(initializePhotoGridPanel(mediaItemSupplier.get()), BorderLayout.CENTER);
    contentPanel.add(initializeLoadMoreButton(), BorderLayout.PAGE_END);
  }

  @Override
  protected void update() throws MalformedURLException {
    photoGridPanel.removeAll();
    mediaItemSupplier.refresh();
    addNewMediaItemsToPanel(mediaItemSupplier.get());
    photoGridPanel.updateUI();
  }

  /** Sets up title, size and layout of the view. */
  private void initializeDialog(AppPanel appPanel, Consumer<PhotoListView> onClosed) {
    setTitle(Resources.TITLE);
    setLayout(new BorderLayout());
    add(appPanel, BorderLayout.PAGE_START);

    final PhotoListView self = this;
    addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent windowEvent) {
            onClosed.accept(self);
          }
        });
  }

  /** Creates a border-layout panel with padding. */
  private JPanel initializeContentPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(CONTENT_PANEL_HGAP, CONTENT_PANEL_VGAP));
    panel.setBorder(CONTENT_BORDER);
    add(panel, BorderLayout.CENTER);
    return panel;
  }

  private JScrollPane initializePhotoGridPanel(Iterable<MediaItem> seedMediaItems)
      throws MalformedURLException {
    photoGridPanel = new JPanel();
    photoGridPanel.setLayout(
        new GridLayout(0 /* unlimited rows */, ITEMS_PER_ROW, ITEM_GRID_HGAP, ITEM_GRID_VGAP));
    addNewMediaItemsToPanel(seedMediaItems);

    JScrollPane scrollPane =
        new JScrollPane(
            photoGridPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(UIHelper.NO_BORDER);
    return scrollPane;
  }

  /** Creates a button that lets user paginate the results. */
  private LoadMoreButton initializeLoadMoreButton() {
    LoadMoreButton button = new LoadMoreButton(LOAD_MORE_TEXT);
    button.addActionListener(
        actionEvent -> {
          try {
            addNewMediaItemsToPanel(mediaItemSupplier.get());
          } catch (MalformedURLException e) {
            e.printStackTrace();
          }
        });
    return button;
  }

  private void addNewMediaItemsToPanel(Iterable<MediaItem> mediaItems)
      throws MalformedURLException {
    for (MediaItem mediaItem : mediaItems) {
      photoGridPanel.add(visualizeMediaItem(mediaItem));
    }
  }

  private JLabel visualizeMediaItem(MediaItem mediaItem) throws MalformedURLException {
    URL imgSource = new URL(getResizedImageSource(mediaItem.getBaseUrl()));
    ImageIcon fetchedImage = new ImageIcon(imgSource);
    JLabel label = new JLabel("", fetchedImage, JLabel.CENTER);
    final PhotoListView self = this;
    label.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            onItemClicked.accept(self, mediaItem);
          }
        });
    return label;
  }

  private static String getResizedImageSource(String baseUrl) {
    // Gets the image cropped to `ITEM_WIDTH x ITEM_HEIGHT`
    return String.format("%s=w%d-h%d-c", baseUrl, ITEM_WIDTH, ITEM_HEIGHT);
  }
}
