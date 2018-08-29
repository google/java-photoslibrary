package com.google.photos.library.sample.components;

import com.google.photos.library.sample.Resources;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import com.google.photos.library.sample.views.ConnectToPhotosView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Represents the top panel of sample app, which lets user go back to the previous view and sign
 * out.
 */
public class AppPanel extends JPanel {

  private static final String BACKGROUND_COLOR = "0x212121";
  private static final Border BORDER =
      new EmptyBorder(14 /* top */, 24 /* left */, 14 /* bottom */, 24 /* right */);

  private static final int CONTENT_HGAP = 16;
  private static final int CONTENT_VGAP = 0;

  private static final int BACK_WIDTH = 16;
  private static final int BACK_HEIGHT = 16;

  private static final String TITLE_COLOR = "#ffffff";
  private static final int TITLE_FONT_SIZE = 14;
  private static final float TITLE_FONT_WEIGHT = 1.5f;
  private static final int TITLE_LINE_MARGIN = 0;

  private static final String SIGNOUT_TEXT = "SIGN OUT";
  private static final Dimension SIGNOUT_DIMENSION =
      new Dimension(108 /* width */, 36 /* height */);

  public AppPanel(String title, Consumer<AbstractCustomView> onSignoutClicked) {
    initializePanel();

    add(getTitleLabel(title), BorderLayout.CENTER);
    add(getSignoutButton(onSignoutClicked), BorderLayout.LINE_END);
  }

  public AppPanel(
      String title,
      Consumer<AbstractCustomView> onBackClicked,
      Consumer<AbstractCustomView> onSignoutClicked) {
    initializePanel();

    JPanel contentPanel = initializeContentPanel();
    contentPanel.add(getBackLabel(onBackClicked), BorderLayout.LINE_START);
    contentPanel.add(getTitleLabel(title), BorderLayout.CENTER);
    add(getSignoutButton(onSignoutClicked), BorderLayout.LINE_END);
  }

  private void initializePanel() {
    setLayout(new BorderLayout());
    setBackground(Color.decode(BACKGROUND_COLOR));
    setBorder(BORDER);
  }

  private JPanel initializeContentPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(CONTENT_HGAP, CONTENT_VGAP));
    panel.setBackground(Color.decode(BACKGROUND_COLOR));
    panel.setBorder(UIHelper.NO_BORDER);
    add(panel, BorderLayout.CENTER);
    return panel;
  }

  private JLabel getBackLabel(Consumer<AbstractCustomView> onBackClicked) {
    JLabel backLabel = new JLabel("", getBackIcon(), JLabel.CENTER);
    final AppPanel self = this;
    backLabel.addMouseListener(
        new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            AbstractCustomView customView = (AbstractCustomView) self.getRootPane().getParent();
            onBackClicked.accept(customView);
          }
        });
    backLabel.setVerticalAlignment(SwingConstants.CENTER);
    return backLabel;
  }

  private ImageIcon getBackIcon() {
    ImageIcon imageIcon =
        new ImageIcon(ConnectToPhotosView.class.getResource(Resources.BACK_ICON_RESOURCE));
    return new ImageIcon(
        imageIcon.getImage().getScaledInstance(BACK_WIDTH, BACK_HEIGHT, Image.SCALE_SMOOTH));
  }

  private JLabel getTitleLabel(String title) {
    JLabel label =
        new JLabel(
            String.format(
                "<html><div style=\"color: %s\">%s</div></html>",
                TITLE_COLOR,
                UIHelper.getFormattedText(
                    title, TITLE_FONT_SIZE, TITLE_FONT_WEIGHT, TITLE_LINE_MARGIN)));
    label.setVerticalAlignment(SwingConstants.CENTER);
    return label;
  }

  private CustomButton getSignoutButton(Consumer<AbstractCustomView> onSignoutClicked) {
    CustomButton button = new CustomButton(SIGNOUT_TEXT);
    UIHelper.setFixedSize(button, SIGNOUT_DIMENSION);
    button.addActionListener(
        actionEvent -> {
          AbstractCustomView customView = (AbstractCustomView) getRootPane().getParent();
          onSignoutClicked.accept(customView);
        });
    return button;
  }
}
