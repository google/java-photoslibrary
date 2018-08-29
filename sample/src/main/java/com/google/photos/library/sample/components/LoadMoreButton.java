package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import java.awt.Color;
import java.awt.Dimension;

/** Represents a styled button that lets user paginate results. */
public class LoadMoreButton extends CustomButton {

  private static final Dimension DIMENSION = new Dimension(0 /* unset width */, 36 /* height */);
  private static final String FOREGROUND_COLOR = "0x3c4043";
  private static final String BACKGROUND_COLOR = "0xe8eaed";

  public LoadMoreButton(String text) {
    super(text);
    UIHelper.setFixedSize(this, DIMENSION);
    setForeground(Color.decode(FOREGROUND_COLOR));
    setBackground(Color.decode(BACKGROUND_COLOR));
  }
}
