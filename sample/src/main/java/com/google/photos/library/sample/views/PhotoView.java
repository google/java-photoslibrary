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
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.types.proto.MediaItem;
import com.google.photos.types.proto.MediaMetadata;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** An {@link AbstractCustomView} that shows a single media item. */
public class PhotoView extends AbstractCustomView {
  private static final Dimension DIALOG_DIMENSION =
      new Dimension(1000 /* width */, 988 /* height */);
  private static final int CONTENT_PANEL_HGAP = 24;
  private static final int CONTENT_PANEL_VGAP = 24;
  private static final Border CONTENT_BORDER =
      new EmptyBorder(32 /* top */, 32 /* left */, 32 /* bottom */, 32 /* right */);

  private static final String META_TEXT = "Meta";
  private static final int META_TEXT_SIZE = 18;
  private static final Border METADATA_BORDER =
      new EmptyBorder(24 /* top */, 24 /* left */, 24 /* bottom */, 24 /* right */);
  private static final int METADATA_TEXT_SIZE = 11;

  private final AppPanel appPanel;
  private final MediaItem mediaItem;
  private final Consumer<PhotoView> onClosed;

  public PhotoView(AppPanel appPanel, MediaItem mediaItem, Consumer<PhotoView> onClosed)
      throws IOException {
    this.appPanel = appPanel;
    this.mediaItem = mediaItem;
    this.onClosed = onClosed;

    UIHelper.setFixedSize(this, DIALOG_DIMENSION);

    initializeView();
  }

  @Override
  protected void initialize() throws IOException {
    initializeDialog(appPanel, onClosed);

    JPanel contentPanel = initializeContentPanel();
    contentPanel.add(initializeMetaPanel(mediaItem), BorderLayout.PAGE_START);
    contentPanel.add(visualizeMediaItem(mediaItem), BorderLayout.CENTER);
  }

  @Override
  protected void update() {}

  /** Sets up title, size and layout of the view. */
  private void initializeDialog(AppPanel appPanel, Consumer<PhotoView> onClosed) {
    setLayout(new BorderLayout());
    setTitle(Resources.TITLE);
    add(appPanel, BorderLayout.PAGE_START);

    final PhotoView self = this;
    addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
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

  /** Creates a panel for metadata. */
  private JPanel initializeMetaPanel(MediaItem mediaItem) {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(getMetaLabel(), BorderLayout.PAGE_START);
    if (mediaItem.hasMediaMetadata()) {
      panel.add(getMetaDataPanel(mediaItem.getMediaMetadata()), BorderLayout.CENTER);
    }
    return panel;
  }

  private static JLabel getMetaLabel() {
    JLabel label = UIHelper.getFormattedLabel(META_TEXT, META_TEXT_SIZE);
    label.setHorizontalAlignment(SwingConstants.LEFT);
    label.setVerticalAlignment(SwingConstants.CENTER);
    return label;
  }

  private static JPanel getMetaDataPanel(MediaMetadata metadata) {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2 /* rows */, 2 /* cols */, 32 /* hgap */, 10 /* vgap */));
    panel.setBorder(METADATA_BORDER);
    if (metadata.hasCreationTime()) {
      panel.add(
          UIHelper.getFormattedLabel(metadata.getCreationTime().toString(), METADATA_TEXT_SIZE));
    }
    panel.add(
        UIHelper.getFormattedLabel(
            String.format("%d X %d", metadata.getWidth(), metadata.getHeight()),
            METADATA_TEXT_SIZE));
    if (metadata.hasPhoto()) {
      panel.add(
          UIHelper.getFormattedLabel(metadata.getPhoto().getCameraModel(), METADATA_TEXT_SIZE));
      if (metadata.getPhoto().hasExposureTime()) {
        panel.add(
            UIHelper.getFormattedLabel(
                String.format(
                    "%f %s %f %d",
                    metadata.getPhoto().getApertureFNumber(),
                    metadata.getPhoto().getExposureTime().toString(),
                    metadata.getPhoto().getFocalLength(),
                    metadata.getPhoto().getIsoEquivalent()),
                METADATA_TEXT_SIZE));
      }
    }
    return panel;
  }

  private static JLabel visualizeMediaItem(MediaItem mediaItem) throws MalformedURLException {
    URL imgSource = new URL(getResizedImageSource(mediaItem.getBaseUrl()));
    ImageIcon imgIcon = new ImageIcon(imgSource);
    JLabel label = new JLabel("", imgIcon, JLabel.CENTER);
    return label;
  }

  private static String getResizedImageSource(String baseUrl) {
    // Gets the image cropped to `950x650`
    return String.format("%s=w950-h650-c", baseUrl);
  }
}
