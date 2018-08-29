package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import java.awt.BorderLayout;
import javax.swing.JLabel;

/** Represents a {@link ToolPanel} for shareable album list view. */
public final class ShareableAlbumToolPanel extends ToolPanel {
  private static final int VGAP = 20;

  private static final String TITLE = "Shareable albums";
  private static final int TITLE_SIZE = 20;

  private static final String DESCRIPTION = "You're viewing all albums that are able to be shared.";
  private static final int DESCRIPTION_SIZE = 13;

  public ShareableAlbumToolPanel() {
    super();
    setLayout(new BorderLayout(0 /* unset hgap */, VGAP));
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getDescriptionLabel(), BorderLayout.CENTER);
  }

  private JLabel getTitleLabel() {
    JLabel label =
        new JLabel(String.format("<html>%s</html>", UIHelper.getFormattedText(TITLE, TITLE_SIZE)));
    return label;
  }

  private JLabel getDescriptionLabel() {
    JLabel label =
        new JLabel(
            String.format(
                "<html>%s</html>", UIHelper.getFormattedText(DESCRIPTION, DESCRIPTION_SIZE)));
    return label;
  }
}
