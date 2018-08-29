package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import java.awt.Color;
import javax.swing.JButton;

/** Represents a customized button. */
public class CustomButton extends JButton {

  private static final float FONT_SIZE = 13;
  private static final float FONT_WEIGHT = 1.6f;
  private static final String BACKGROUND_COLOR = "0x4285f4";
  private static final String FOREGROUND_COLOR = "0xffffff";

  public CustomButton(String text) {
    super(text);
    configureButton();
  }

  private void configureButton() {
    setBorderPainted(false);
    setOpaque(true);
    setFont(UIHelper.resizeFont(getFont(), FONT_WEIGHT, FONT_SIZE));
    setBackground(Color.decode(BACKGROUND_COLOR));
    setForeground(Color.decode(FOREGROUND_COLOR));
  }
}
