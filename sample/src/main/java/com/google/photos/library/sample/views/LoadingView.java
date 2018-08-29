package com.google.photos.library.sample.views;

import com.google.photos.library.sample.helpers.UIHelper;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public final class LoadingView extends JDialog {
  private static final Dimension LOADING_DIMENSION =
      new Dimension(250 /* width */, 50 /* height */);
  private static final Border BORDER =
      BorderFactory.createEmptyBorder(10 /* top */, 10 /* left */, 10 /* bottom */, 10 /* right */);

  private static Optional<LoadingView> loadingView = Optional.empty();

  private LoadingView() {
    UIHelper.setFixedSize(this, LOADING_DIMENSION);
    setTitle("Loading");
    moveToCenter();
    setResizable(false);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    JProgressBar progressBar = new JProgressBar();
    progressBar.setIndeterminate(true);

    JPanel panel = new JPanel();
    panel.setBorder(BORDER);
    panel.setLayout(new GridLayout(1 /* rows */, 1 /* cols */));
    panel.add(progressBar);

    add(panel);
  }

  public static LoadingView getLoadingView() {
    if (!loadingView.isPresent()) {
      loadingView = Optional.of(new LoadingView());
    }
    return loadingView.get();
  }

  public void showView() {
    setVisible(true);
  }

  public void hideView() {
    setVisible(false);
  }

  private void moveToCenter() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
        screenSize.width / 2 - this.getSize().width / 2,
        screenSize.height / 2 - this.getSize().height / 2);
  }
}
