package com.google.photos.library.sample.components;

import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.sample.views.AbstractCustomView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Represents a {@link ToolPanel} that lets user search for media items in the library. */
public final class SearchToolPanel extends ToolPanel {

  private static final int VGAP = 20;

  private static final String TITLE = "Google Photos library";
  private static final int TITLE_SIZE = 20;
  private static final String DESCRIPTION =
      "You're viewing all photos in the user library. "
          + "Use the search action to refine your results with filters.";
  private static final int DESCRIPTION_SIZE = 13;
  private static final String SEARCH_TEXT = "SEARCH";
  private static final Dimension SEARCH_DIMENSION = new Dimension(94 /* width */, 36 /* height */);

  public SearchToolPanel(Consumer<AbstractCustomView> onSearchClicked) {
    super();
    setLayout(new BorderLayout(0 /* unset hgap */, VGAP));
    add(getTitleLabel(), BorderLayout.PAGE_START);
    add(getDescriptionLabel(), BorderLayout.CENTER);
    add(getSearchPanel(onSearchClicked), BorderLayout.PAGE_END);
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

  private JPanel getSearchPanel(Consumer<AbstractCustomView> onSearchClicked) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(getSearchButton(onSearchClicked));
    return panel;
  }

  private CustomButton getSearchButton(Consumer<AbstractCustomView> onSearchClicked) {
    CustomButton button = new CustomButton(SEARCH_TEXT);
    UIHelper.setFixedSize(button, SEARCH_DIMENSION);
    button.addActionListener(
        actionEvent -> {
          // Gets the view that contains this panel.
          AbstractCustomView parentView = (AbstractCustomView) getRootPane().getParent();
          onSearchClicked.accept(parentView);
        });
    return button;
  }
}
