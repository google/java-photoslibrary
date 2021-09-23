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

import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.*;
import java.io.IOException;
import java.util.function.BiConsumer;

/** Represents an {@link ToolPanel} that lets user create a new album in the library. */
public class PlainCreateAlbumToolPanel extends AbstractCreateAlbumToolPanel {

  public PlainCreateAlbumToolPanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    super(onCreateClicked);
    setLayout(new FlowLayout(FlowLayout.LEFT));
    add(getCreatePanel(onCreateClicked));
  }
}
