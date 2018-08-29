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

import com.google.photos.library.sample.components.ConnectToPhotosButton;
import com.google.photos.library.sample.helpers.UIHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** An {@link AbstractCustomView} that lets user login to Google Photos via API. */
public final class ConnectToPhotosView extends AbstractCustomView {

  private static final String CREDENTIAL_CHOOSER_TITLE = "Select credential file";

  private static final Dimension WINDOW_DIMENSION =
      new Dimension(775 /* width */, 428 /* height */);
  private static final Border WINDOW_PADDING =
      new EmptyBorder(54 /* top */, 44 /* left */, 54 /* bottom */, 44 /* right */);

  private static final int SAMPLE_IMAGE_WIDTH = 164;
  private static final int SAMPLE_IMAGE_HEIGHT = 164;
  private static final Border SAMPLE_IMAGE_PADDING =
      new EmptyBorder(0 /* top */, 56 /* left */, 0 /* bottom */, 56 /* right */);

  private final String title;
  private final String introduction;
  private final String sampleImageResource;
  private final Optional<String> credentialsFile;
  private final BiConsumer<ConnectToPhotosView, String> onCredentialsSelected;
  private final Consumer<ConnectToPhotosView> onClosed;

  public ConnectToPhotosView(
      String title,
      String introduction,
      String sampleImageResource,
      Optional<String> credentialsFile,
      BiConsumer<ConnectToPhotosView, String> onCredentialsSelected,
      Consumer<ConnectToPhotosView> onClosed) {
    this.title = title;
    this.introduction = introduction;
    this.sampleImageResource = sampleImageResource;
    this.credentialsFile = credentialsFile;
    this.onCredentialsSelected = onCredentialsSelected;
    this.onClosed = onClosed;

    UIHelper.setFixedSize(this, WINDOW_DIMENSION);

    initializeView();
  }

  @Override
  protected void initialize() {
    initializeDialog(title, onClosed);

    JPanel contentPanel = initializeContentPanel();
    contentPanel.add(getIntroLabel(introduction), BorderLayout.CENTER);
    contentPanel.add(getSampleIconLabel(sampleImageResource), BorderLayout.LINE_END);
    contentPanel.add(
        getConnectPanel(onCredentialsSelected, credentialsFile), BorderLayout.PAGE_END);
  }

  @Override
  protected void update() {}

  /** Sets up title, size and layout of the view. */
  private void initializeDialog(String title, Consumer<ConnectToPhotosView> onClosed) {
    setTitle(title);
    setLayout(new GridLayout(1 /* rows */, 1 /* cols */));

    final ConnectToPhotosView self = this;
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
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new BorderLayout());
    contentPanel.setBorder(WINDOW_PADDING);
    add(contentPanel);
    return contentPanel;
  }

  private JLabel getIntroLabel(String introduction) {
    JLabel introLabel = new JLabel(introduction);
    introLabel.setVerticalAlignment(SwingConstants.TOP);
    introLabel.setHorizontalAlignment(SwingConstants.LEFT);
    return introLabel;
  }

  private JLabel getSampleIconLabel(String sampleImageResource) {
    ImageIcon originalImage =
        new ImageIcon(ConnectToPhotosView.class.getResource(sampleImageResource));
    JLabel iconLabel =
        new JLabel(
            new ImageIcon(
                originalImage
                    .getImage()
                    .getScaledInstance(
                        SAMPLE_IMAGE_WIDTH, SAMPLE_IMAGE_HEIGHT, Image.SCALE_SMOOTH)));
    iconLabel.setVerticalAlignment(SwingConstants.CENTER);
    iconLabel.setBorder(SAMPLE_IMAGE_PADDING);
    return iconLabel;
  }

  private JPanel getConnectPanel(
      BiConsumer<ConnectToPhotosView, String> onCredentialsSelected,
      Optional<String> credentialsFile) {
    JPanel connectPanel = new JPanel();
    connectPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    if (credentialsFile.isPresent()) {
      // Add a connect button that loads the supplied credentials file.
      connectPanel.add(getConnectButton(onCredentialsSelected, credentialsFile.get()));
    } else {
      // Add a connect button that prompts the user for the credentials file.
      connectPanel.add(getConnectButton(onCredentialsSelected));
    }
    return connectPanel;
  }

  /** Creates a button that uses the given credential file. */
  private ConnectToPhotosButton getConnectButton(
      BiConsumer<ConnectToPhotosView, String> onCredentialsSelected, String credentialsPath) {
    ConnectToPhotosButton connectButton = new ConnectToPhotosButton();
    connectButton.addActionListener(
        actionEvent -> onCredentialsSelected.accept(this, credentialsPath));
    return connectButton;
  }

  /** Creates a button that lets user choose a credential file. */
  private ConnectToPhotosButton getConnectButton(
      BiConsumer<ConnectToPhotosView, String> onCredentialsSelected) {
    ConnectToPhotosButton connectButton = new ConnectToPhotosButton();
    connectButton.addActionListener(
        actionEvent -> {
          Optional<String> chosenFilePath = chooseCredentialsPath();
          if (chosenFilePath.isPresent()) {
            onCredentialsSelected.accept(this, chosenFilePath.get());
          }
        });
    return connectButton;
  }

  private Optional<String> chooseCredentialsPath() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle(CREDENTIAL_CHOOSER_TITLE);
    int returnVal = fileChooser.showDialog(this, null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      return Optional.of(fileChooser.getSelectedFile().getPath());
    }
    return Optional.empty();
  }
}
