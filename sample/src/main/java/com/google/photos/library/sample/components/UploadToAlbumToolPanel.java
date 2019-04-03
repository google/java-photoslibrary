package com.google.photos.library.sample.components;

import com.google.common.collect.Lists;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.types.proto.Album;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/** Represents a {@link ToolPanel} that lets user upload media items to an album. */
public final class UploadToAlbumToolPanel extends ToolPanel {

  private static final String META_TEXT = "Meta";
  private static final int META_TEXT_SIZE = 20;

  private static final Border METADATA_BORDER =
      new EmptyBorder(12 /* top */, 24 /* left */, 24 /* bottom */, 24 /* right */);
  private static final int METADATA_TEXT_SIZE = 11;

  private static final String UPLOAD_TEXT = "UPLOAD PHOTOS";
  private static final Dimension UPLOAD_DIMENSION = new Dimension(160 /* width */, 36 /* height */);
  private static final String FILE_CHOOSER_TITLE = "Upload photos";

  public UploadToAlbumToolPanel(
      Album album, BiConsumer<AbstractCustomView, List<String>> onUploadFilesSelected) {
    super();
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getMetaDataPanel(album), BorderLayout.CENTER);
    // Adds upload button for owned albums
    if (album.getIsWriteable()) {
      add(getUploadPanel(onUploadFilesSelected), BorderLayout.PAGE_END);
    }
  }

  private JLabel getTitleLabel() {
    JLabel label =
        new JLabel(
            String.format("<html>%s</html>", UIHelper.getFormattedText(META_TEXT, META_TEXT_SIZE)));
    return label;
  }

  private JPanel getMetaDataPanel(Album album) {
    JPanel metadataPanel = new JPanel();
    metadataPanel.setBorder(METADATA_BORDER);
    metadataPanel.setLayout(
        new GridLayout(2 /* rows */, 1 /* cols */, 0 /* unset hgap */, 10 /* vgap */));

    metadataPanel.add(
        UIHelper.getFormattedLabel(
            String.format("<html>URL: %s</html>", album.getProductUrl()), METADATA_TEXT_SIZE));
    if (album.hasShareInfo()) {
      metadataPanel.add(
          UIHelper.getFormattedLabel(
              String.format("<html>Share URL: %s</html>", album.getShareInfo().getShareableUrl()),
              METADATA_TEXT_SIZE));
    }

    return metadataPanel;
  }

  private JPanel getUploadPanel(
      BiConsumer<AbstractCustomView, List<String>> onUploadFilesSelected) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getUpdateButton(onUploadFilesSelected));
    return panel;
  }

  private CustomButton getUpdateButton(
      BiConsumer<AbstractCustomView, List<String>> onUploadFilesSelected) {
    CustomButton button = new CustomButton(UPLOAD_TEXT);
    UIHelper.setFixedSize(button, UPLOAD_DIMENSION);
    button.addActionListener(
        actionEvent -> {
          List<String> selectedFiles = getSelectedFiles();
          if (!selectedFiles.isEmpty()) {
            AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
            onUploadFilesSelected.accept(customView, selectedFiles);
          }
        });
    return button;
  }

  private List<String> getSelectedFiles() {
    AbstractCustomView view = (AbstractCustomView) getRootPane().getParent();
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle(FILE_CHOOSER_TITLE);
    fileChooser.setMultiSelectionEnabled(true);
    int returnVal = fileChooser.showDialog(view, null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      return Lists.newArrayList(fileChooser.getSelectedFiles())
          .stream()
          .map(File::getPath)
          .collect(Collectors.toList());
    }
    return Lists.newArrayList();
  }
}
