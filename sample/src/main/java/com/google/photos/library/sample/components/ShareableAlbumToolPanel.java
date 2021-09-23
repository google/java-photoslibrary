package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.*;
import java.io.IOException;
import java.util.function.BiConsumer;
import javax.swing.JLabel;

/** Represents a {@link ToolPanel} for shareable album list view. */
public final class ShareableAlbumToolPanel extends ToolPanel {
  private static final int VGAP = 20;

  private static final String TITLE = "Albums you can share";
  private static final int TITLE_SIZE = 20;

  private static final String DESCRIPTION =
      "You're viewing all albums that you can share, this only includes albums that have been "
          + "created by this app.";
  private static final int DESCRIPTION_SIZE = 13;

  public ShareableAlbumToolPanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    super();
    setLayout(new BorderLayout(0 /* unset hgap */, VGAP));
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getDescriptionLabel(), BorderLayout.CENTER);
    add(new PlainCreateAlbumToolPanel(onCreateClicked), BorderLayout.PAGE_END);
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
