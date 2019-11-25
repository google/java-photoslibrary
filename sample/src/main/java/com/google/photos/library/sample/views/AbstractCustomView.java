package com.google.photos.library.sample.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.Thread.State;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** Represents an abstract view that can show, hide and update itself. */
public abstract class AbstractCustomView extends JFrame {
  private static final String DEFAULT_DIALOG_BACKGROUND = "0xf8f9fa";

  private final LoadingView loadingView;

  private final Thread initializationThread;

  private final Object updateLock = new Object();
  private Thread updateThread = null;
  private boolean rerunUpdate = false;

  public AbstractCustomView() {
    hideView();
    loadingView = LoadingView.getLoadingView();
    initializationThread = getInitializationThread();

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
    if (initializationThread.getState() == State.NEW) {
      loadingView.showView();
      initializationThread.start();
    }
  }

  /** Updates the view in a new thread and shows loading indicator. */
  public final void updateView() {
    synchronized (updateLock) {
      if ((updateThread == null || updateThread.getState() == State.TERMINATED)
          && initializationThread.getState() == State.TERMINATED) {
        updateThread = getUpdateThread();
        loadingView.showView();
        updateThread.start();
      } else {
        rerunUpdate = true;
      }
    }
  }

  /** View initialization method */
  protected abstract void initialize() throws Exception;

  /** View update method */
  protected abstract void update() throws Exception;

  private final Thread getUpdateThread() {
    final Runnable updateRunnable =
        () -> {
          try {
            update();
          } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
          }
        };
    return new Thread(
        () -> {
          while (true) {
            updateRunnable.run();
            synchronized (updateLock) {
              if (rerunUpdate) {
                rerunUpdate = false;
              } else {
                loadingView.hideView();
                break;
              }
            }
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
            showView();
            synchronized (updateLock) {
              if (rerunUpdate) {
                rerunUpdate = false;
                updateThread = getUpdateThread();
                updateThread.start();
              } else {
                loadingView.hideView();
              }
            }
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
