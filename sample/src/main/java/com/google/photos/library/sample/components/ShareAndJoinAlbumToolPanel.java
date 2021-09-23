package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.*;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.*;

/**
 * Represents a {@link ToolPanel} that lets user open a list of shareable albums and join a shared
 * album.
 */
public final class ShareAndJoinAlbumToolPanel extends ToolPanel {

  private static final int VGAP = 20;

  private static final String TITLE = "Google Photos shared albums";
  private static final int TITLE_SIZE = 20;

  private static final String DESCRIPTION =
      "Viewing all shared albums. Use the ‘Share An Album’ action to list all the available "
          + "albums to share. Use the ‘Join Album’ action to join a shared album using a "
          + "share token.";

  private static final int DESCRIPTION_SIZE = 13;

  private static final String SHARE_TEXT = "SHARE ALBUM";
  private static final Dimension SHARE_DIMENSION = new Dimension(144 /* width */, 36 /* height */);

  private static final String JOIN_TEXT = "JOIN ALBUM";
  private static final Dimension JOIN_DIMENSION = new Dimension(144 /* width */, 36 /* height */);
  private static final String JOIN_ALBUM_INPUT_TITLE = "Join album";
  private static final String JOIN_ALBUM_INPUT_DESCRIPTION =
      "To join a shared album, enter the share token of the "
          + "album here and click on 'ok'.\n"
          + "Note that you can only join albums that haven't been added to your Google Photos "
          + "library yet and that have been shared by this application.";

  public ShareAndJoinAlbumToolPanel(
      Consumer<AbstractCustomView> onShareClicked,
      BiConsumer<AbstractCustomView, String> onJoinClicked) {
    super();
    setLayout(new BorderLayout(0 /* unset hgap */, VGAP));
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getDescriptionLabel(), BorderLayout.CENTER);
    add(getShareAndJoinPanel(onShareClicked, onJoinClicked), BorderLayout.PAGE_END);
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

  private JPanel getShareAndJoinPanel(
      Consumer<AbstractCustomView> onShareClicked,
      BiConsumer<AbstractCustomView, String> onJoinClicked) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getShareButton(onShareClicked));
    // Adds a gap of 20px
    panel.add(Box.createRigidArea(new Dimension(20 /* width */, 0 /* height */)));
    panel.add(getJoinButton(onJoinClicked));
    return panel;
  }

  private CustomButton getShareButton(Consumer<AbstractCustomView> onShareClicked) {
    CustomButton button = new CustomButton(SHARE_TEXT);
    UIHelper.setFixedSize(button, SHARE_DIMENSION);

    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          onShareClicked.accept(customView);
        });
    return button;
  }

  private CustomButton getJoinButton(BiConsumer<AbstractCustomView, String> onJoinClicked) {
    CustomButton button = new CustomButton(JOIN_TEXT);
    UIHelper.setFixedSize(button, JOIN_DIMENSION);

    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          Optional<String> shareToken =
              Optional.ofNullable(
                  (String)
                      JOptionPane.showInputDialog(
                          customView,
                          JOIN_ALBUM_INPUT_DESCRIPTION,
                          JOIN_ALBUM_INPUT_TITLE,
                          JOptionPane.PLAIN_MESSAGE));
          if (shareToken.isPresent()) {
            onJoinClicked.accept(customView, shareToken.get());
          }
        });
    return button;
  }
}
