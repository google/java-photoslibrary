package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Optional;
import java.util.function.BiConsumer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** Represents an {@link ToolPanel} that lets user create a new album in the library. */
public final class CreateAlbumToolPanel extends ToolPanel {

  private static final int VGAP = 20;

  private static final String TITLE = "Google Photos albums";
  private static final int TITLE_SIZE = 20;

  private static final String DESCRIPTION =
      "You're viewing all albums in the user library. "
          + "Use the create action to add a new album.";
  private static final int DESCRIPTION_SIZE = 13;

  private static final String CREATE_TEXT = "CREATE ALBUM";
  private static final Dimension CREATE_DIMENSION = new Dimension(144 /* width */, 36 /* height */);
  private static final String CREATE_ALBUM_INPUT_TITLE = "Create album";
  private static final String CREATE_ALBUM_INPUT_DESCRIPTION =
      "To create a new album," + "enter the title here and click on 'OK'.";

  public CreateAlbumToolPanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    super();
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

  private JPanel getCreatePanel(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getCreateButton(onCreateClicked));
    return panel;
  }

  private CustomButton getCreateButton(BiConsumer<AbstractCustomView, String> onCreateClicked)
      throws IOException, FontFormatException {
    CustomButton button = new CustomButton(CREATE_TEXT);
    UIHelper.setFixedSize(button, CREATE_DIMENSION);

    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          Optional<String> albumTitle =
              Optional.ofNullable(
                  (String)
                      JOptionPane.showInputDialog(
                          customView,
                          CREATE_ALBUM_INPUT_DESCRIPTION,
                          CREATE_ALBUM_INPUT_TITLE,
                          JOptionPane.PLAIN_MESSAGE));
          if (albumTitle.isPresent()) {
            onCreateClicked.accept(customView, albumTitle.get());
          }
        });
    return button;
  }
}
