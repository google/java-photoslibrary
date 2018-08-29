package com.google.photos.library.sample.components;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/** An abstract panel that may contain metadata, buttons. */
public abstract class ToolPanel extends JPanel {
  private static final int DEFAULT_HGAP = 0;
  private static final int DEFAULT_VGAP = 8;

  public ToolPanel() {
    setLayout(new BorderLayout(DEFAULT_HGAP, DEFAULT_VGAP));
  }
}
