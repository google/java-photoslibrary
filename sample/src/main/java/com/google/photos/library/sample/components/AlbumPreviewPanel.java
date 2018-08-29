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

package com.google.photos.library.sample.components;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Represents an album preview, which contains the album thumbnail and title. */
public final class AlbumPreviewPanel extends JPanel {
  private static final int HGAP = 0;
  private static final int VGAP = 6;

  public AlbumPreviewPanel(JLabel thumbnail, JLabel title) {
    setLayout(new BorderLayout(HGAP, VGAP));
    add(thumbnail, BorderLayout.CENTER);
    add(title, BorderLayout.PAGE_END);
  }
}
