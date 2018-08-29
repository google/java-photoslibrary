package com.google.photos.library.sample.components;

import com.google.photos.library.sample.Resources;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.ConnectToPhotosView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/** Represents a styled button for Connect To Google Photos. */
public final class ConnectToPhotosButton extends CustomButton {
  private static final String TEXT = "Connect to Google Photos";
  private static final Dimension DIMENSION = new Dimension(280 /* width */, 40 /* height */);
  private static final String FOREGROUND_COLOR = "0x3c4043";
  private static final String BACKGROUND_COLOR = "0xffffff";
  private static final float FONT_SIZE = 14;
  private static final float FONT_WEIGHT = 1.5f;
  private static final int ICON_WIDTH = 24;
  private static final int ICON_HEIGHT = 24;
  private static final int ICON_TEXT_GAP = 8;

  public ConnectToPhotosButton() {
    super(TEXT);
    UIHelper.setFixedSize(this, DIMENSION);
    setForeground(Color.decode(FOREGROUND_COLOR));
    setBackground(Color.decode(BACKGROUND_COLOR));
    setText(TEXT);
    setIcon(getConnectIcon());
    setIconTextGap(ICON_TEXT_GAP);
    setFont(UIHelper.resizeFont(getFont(), FONT_WEIGHT, FONT_SIZE));
  }

  private static ImageIcon getConnectIcon() {
    ImageIcon imageIcon =
        new ImageIcon(ConnectToPhotosView.class.getResource(Resources.GOOGLE_PHOTOS_ICON_RESOURCE));
    return new ImageIcon(
        imageIcon.getImage().getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH));
  }
}
