package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.*;
import java.io.IOException;
import java.util.function.BiConsumer;
import javax.swing.JLabel;

/**
 * Represents an {@link ToolPanel} that lets user create a new album in the library and includes a
 * title and introduction.
 */
public final class CreateAlbumToolPanel extends AbstractCreateAlbumToolPanel {

  private static final int VGAP = 20;

  private static final String TITLE = "Google Photos albums";
  private static final int TITLE_SIZE = 20;

  private static final String DESCRIPTION =
      "You're viewing all albums in the user library. "
          + "Use the create action to add a new album.";
  private static final int DESCRIPTION_SIZE = 13;

  public CreateAlbumToolPanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    super(onCreateClicked);
    setLayout(new BorderLayout(0 /* unset hgap */, VGAP));
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getDescriptionLabel(), BorderLayout.CENTER);
    add(getCreatePanel(onCreateClicked), BorderLayout.PAGE_END);
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
