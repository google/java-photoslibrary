package com.google.photos.library.sample.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** Represents an abstract view that can show, hide and update itself. */
public abstract class AbstractCustomView extends JFrame {
  private static final String DEFAULT_DIALOG_BACKGROUND = "0xf8f9fa";

  private final LoadingView loadingView;
  private final Thread updateThread;

  public AbstractCustomView() {
    hideView();
    loadingView = LoadingView.getLoadingView();
    updateThread = getUpdateThread();

    getRootPane().setOpaque(false);
    getContentPane().setBackground(Color.decode(DEFAULT_DIALOG_BACKGROUND));
  }

  public final void showView() {
    setVisible(true);
  }

  public final void hideView() {
    setVisible(false);
  }

  /** Initializes the view in a new thread and shows loading indicator. */
  public final void initializeView() {
    loadingView.showView();
    getInitializationThread().start();
  }

  /** Updates the view in a new thread and shows loading indicator. */
  public final void updateView() {
    loadingView.showView();
    updateThread.start();
  }

  /** View initialization method */
  protected abstract void initialize() throws Exception;

  /** View update method */
  protected abstract void update() throws Exception;

  private final Thread getUpdateThread() {
    return new Thread(
        () -> {
          try {
            update();
            loadingView.hideView();
          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
          }
        });
  }

  private final Thread getInitializationThread() {
    return new Thread(
        () -> {
          try {
            moveToCenter();
            initialize();
            requestFocusInWindow();
            loadingView.hideView();
            showView();
          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
          }
        });
  }

  private final void moveToCenter() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(
        screenSize.width / 2 - this.getSize().width / 2,
        screenSize.height / 2 - this.getSize().height / 2);
  }
}
