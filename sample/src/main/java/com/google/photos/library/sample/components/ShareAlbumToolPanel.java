package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.types.proto.Album;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.function.BiConsumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** Represents a {@link ToolPanel} that contains album metadata and let user share an album. */
public final class ShareAlbumToolPanel extends ToolPanel {
  private static final String META_TEXT = "Meta";
  private static final int META_TEXT_SIZE = 20;

  private static final Border METADATA_BORDER =
      new EmptyBorder(12 /* top */, 24 /* left */, 12 /* bottom */, 24 /* right */);

  private static final String SHARE_TEXT = "SHARE ALBUM";
  private static final Dimension SHARE_DIMENSION = new Dimension(144 /* width */, 36 /* height */);

  public ShareAlbumToolPanel(Album album, BiConsumer<AbstractCustomView, Album> onShareClicked) {
    super();
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getMetadataTextArea(album), BorderLayout.CENTER);
    // Adds share button for not-shared albums
    if (!album.hasShareInfo()) {
      add(getSharePanel(album, onShareClicked), BorderLayout.PAGE_END);
    }
  }

  private JLabel getTitleLabel() {
    JLabel label =
        new JLabel(
            String.format("<html>%s</html>", UIHelper.getFormattedText(META_TEXT, META_TEXT_SIZE)));
    return label;
  }

  private JTextArea getMetadataTextArea(Album album) {
    JTextArea metadataTextArea = new JTextArea();
    metadataTextArea.setBorder(METADATA_BORDER);
    metadataTextArea.setLayout(
        new GridLayout(2 /* rows */, 1 /* cols */, 0 /* unset hgap */, 10 /* vgap */));
    metadataTextArea.setEditable(false);
    metadataTextArea.setLineWrap(true);
    metadataTextArea.append(String.format("Product URL: %s", album.getProductUrl()));
    if (album.hasShareInfo()) {
      metadataTextArea.append(
          String.format("\nShare URL: %s", album.getShareInfo().getShareableUrl()));
      metadataTextArea.append(
          String.format("\nShare Token: %s", album.getShareInfo().getShareToken()));
    }
    return metadataTextArea;
  }

  private JPanel getSharePanel(Album album, BiConsumer<AbstractCustomView, Album> onShareClicked) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getShareButton(album, onShareClicked));
    return panel;
  }

  private CustomButton getShareButton(
      Album album, BiConsumer<AbstractCustomView, Album> onShareClicked) {
    CustomButton button = new CustomButton(SHARE_TEXT);
    UIHelper.setFixedSize(button, SHARE_DIMENSION);
    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          onShareClicked.accept(customView, album);
        });
    return button;
  }
}
