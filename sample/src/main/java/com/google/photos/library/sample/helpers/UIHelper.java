package com.google.photos.library.sample.helpers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** Represents a helper for UI. */
public final class UIHelper {
  public static final Border NO_BORDER =
      new EmptyBorder(0 /* top */, 0 /* left */, 0 /* bottom */, 0 /* right */);

  private static final float DEFAULT_FONT_WEIGHT = 1.5f;
  private static final int DEFAULT_LINE_MARGIN = 0;

  private UIHelper() {}

  public static void setUp() {
    System.setProperty("awt.useSystemAAFontSettings", "on");
    System.setProperty("swing.aatext", "true");
  }

  public static void setFixedSize(Component component, Dimension dimension) {
    component.setSize(dimension);
    component.setPreferredSize(dimension);
    component.setMaximumSize(dimension);
    component.setMinimumSize(dimension);
  }

  public static String getFormattedText(String text, int fontSize) {
    return getFormattedText(text, fontSize, DEFAULT_FONT_WEIGHT, DEFAULT_LINE_MARGIN);
  }

  public static String getFormattedText(String text, int fontSize, int lineMargin) {
    return getFormattedText(text, fontSize, DEFAULT_FONT_WEIGHT, lineMargin);
  }

  public static String getFormattedText(
      String text, int fontSize, float fontWeight, int lineMargin) {
    return String.format(
        "<p style=\"font-size:%dpx; font-weight: %f; margin-top:%dpx; margin-bottom:%dpx\">%s</p>",
        fontSize, fontWeight, lineMargin, lineMargin, text);
  }

  public static JLabel getFormattedLabel(String text, int fontSize) {
    String formattedText =
        getFormattedText(text, fontSize, DEFAULT_FONT_WEIGHT, DEFAULT_LINE_MARGIN);
    return new JLabel(String.format("<html>%s</html>", formattedText));
  }

  public static JLabel getFormattedLabel(String text, int fontSize, int lineMargin) {
    String formattedText = getFormattedText(text, fontSize, DEFAULT_FONT_WEIGHT, lineMargin);
    return new JLabel(String.format("<html>%s</html>", formattedText));
  }

  public static JLabel getFormattedLabel(
      String text, int fontSize, float fontWeight, int lineMargin) {
    String formattedText =
        String.format(
            "<p style=\"font-size:%dpx; font-weight: %f; margin-top:%dpx; margin-bottom:%dpx\">%s</p>",
            fontSize, fontWeight, lineMargin, lineMargin, text);
    return new JLabel(String.format("<html>%s</html>", formattedText));
  }

  public static Font resizeFont(Font font, float fontWeight, float fontSize) {
    Map<TextAttribute, Object> attributes = new HashMap<>();
    attributes.put(TextAttribute.WEIGHT, fontWeight);
    attributes.put(TextAttribute.SIZE, fontSize);
    return font.deriveFont(attributes);
  }
}
