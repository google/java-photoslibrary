/*
 * Copyright 2021 Google LLC
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

package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.*;
import java.io.IOException;
import java.util.Optional;
import java.util.function.BiConsumer;
import javax.swing.*;

/** Represents an {@link ToolPanel} that lets user create a new album in the library. */
public abstract class AbstractCreateAlbumToolPanel extends ToolPanel {
  private static final String CREATE_TEXT = "CREATE ALBUM";
  private static final Dimension CREATE_DIMENSION = new Dimension(144 /* width */, 36 /* height */);
  private static final String CREATE_ALBUM_INPUT_TITLE = "Create album";
  private static final String CREATE_ALBUM_INPUT_DESCRIPTION =
      "To create a new album," + "enter the title here and click on 'OK'.";

  public AbstractCreateAlbumToolPanel(BiConsumer<AbstractCustomView, String> onCreateClicked) {
    super();
  }

  protected JPanel getCreatePanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getCreateButton(onCreateClicked));
    return panel;
  }

  protected CustomButton getCreateButton(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    CustomButton button = new CustomButton(CREATE_TEXT);
    UIHelper.setFixedSize(button, CREATE_DIMENSION);

    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          Optional<String> albumTitle =
              Optional.ofNullable(
                  (String)
                      JOptionPane.showInputDialog(
                          customView,
                          CREATE_ALBUM_INPUT_DESCRIPTION,
                          CREATE_ALBUM_INPUT_TITLE,
                          JOptionPane.PLAIN_MESSAGE));
          if (albumTitle.isPresent()) {
            onCreateClicked.accept(customView, albumTitle.get());
          }
        });
    return button;
  }
}
