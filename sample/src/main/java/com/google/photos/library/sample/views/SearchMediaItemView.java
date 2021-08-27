/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.photos.library.sample.views;

import com.google.common.collect.Lists;
import com.google.photos.library.sample.Resources;
import com.google.photos.library.sample.components.AppPanel;
import com.google.photos.library.sample.components.CustomButton;
import com.google.photos.library.sample.components.DatePickerPanel;
import com.google.photos.library.sample.components.OrderByPanel;
import com.google.photos.library.sample.helpers.UIHelper;
import com.google.photos.library.v1.proto.ContentCategory;
import com.google.photos.library.v1.proto.DateFilter;
import com.google.photos.library.v1.proto.SearchMediaItemsRequest;
import com.google.photos.library.v1.util.OrderBy;
import com.google.photos.types.proto.DateRange;
import com.google.type.Date;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * A {@link AbstractCustomView} that shows search filters: - include content categories - exclude
 * content categories - date range
 */
public class SearchMediaItemView extends AbstractCustomView {
  private static final Dimension WINDOW_DIMENSION =
      new Dimension(1000 /* width */, 922 /* height */);
  private static final Border CONTENT_BORDER =
      new EmptyBorder(32 /* top */, 32 /* left */, 32 /* bottom */, 32 /* right */);

  private static final String SEARCH_INTRO_TITLE = "Load from search";
  private static final int SEARCH_INTRO_TITLE_SIZE = 20;
  private static final String SEARCH_INTRO_DESC =
      "Load photos from your Google Photos Library. Choose from the search options below.<br/>"
          + "Try combining different categories and dates.";
  private static final int DESCRIPTION_SIZE = 13;

  private static final String INCLUDE_CATEGORIES_TEXT = "Include these categories";
  private static final String EXCLUDE_CATEGORIES_TEXT = "Exclude these categories";
  private static final String DATE_FILTERS_TEXT = "Apply range filters";
  private static final int TITLE_SIZE = 16;

  private static final String START_DATE_TEXT = "Start date";
  private static final String END_DATE_TEXT = "End date";

  private static final String SORT_TEXT_TITLE = "Sort results";
  private static final String SORT_TEXT_DESC =
      "Sort results for searches that only include a date filter.";

  private static final String APPLY_FILTERS_TEXT = "APPLY FILTERS";
  private static final Dimension APPLY_FILTERS_DIMENSION =
      new Dimension(144 /* width */, 36 /* height */);

  private final AppPanel appPanel;
  private final Consumer<SearchMediaItemView> onClosed;
  private final BiConsumer<SearchMediaItemView, SearchMediaItemsRequest> onApplyFiltersClicked;

  private SearchMediaItemsRequest.Builder requestBuilder;
  private List<JCheckBox> includeCategoryCheckBoxes;
  private List<JCheckBox> excludeCategoryCheckBoxes;
  private Map<JCheckBox, ContentCategory> contentCategoryByCheckBoxFn;

  public SearchMediaItemView(
      AppPanel appPanel,
      Consumer<SearchMediaItemView> onClosed,
      BiConsumer<SearchMediaItemView, SearchMediaItemsRequest> onApplyFiltersClicked) {
    this.appPanel = appPanel;
    this.onClosed = onClosed;
    this.onApplyFiltersClicked = onApplyFiltersClicked;
    requestBuilder = SearchMediaItemsRequest.newBuilder();

    UIHelper.setFixedSize(this, WINDOW_DIMENSION);

    initializeView();
  }

  @Override
  protected void initialize() {
    initializeDialog(appPanel, onClosed);

    initializeContentCategory();
    JPanel contentPanel = initializeContentPanel();
    contentPanel.add(initializeIntroductionPanel(), BorderLayout.PAGE_START);

    JPanel filterPanel = initializeFilterPanel();
    contentPanel.add(filterPanel, BorderLayout.CENTER);

    filterPanel.add(initializeCheckBoxGroup(INCLUDE_CATEGORIES_TEXT, includeCategoryCheckBoxes));
    filterPanel.add(initializeCheckBoxGroup(EXCLUDE_CATEGORIES_TEXT, excludeCategoryCheckBoxes));
    filterPanel.add(initializeDateFilters());
    filterPanel.add(initializeSort());

    contentPanel.add(initializeApplyPanel(onApplyFiltersClicked), BorderLayout.PAGE_END);
  }

  @Override
  protected void update() {}

  /** Sets up title, size and layout of the view. */
  private void initializeDialog(AppPanel appPanel, Consumer<SearchMediaItemView> onClose) {
    setTitle(Resources.TITLE);
    setLayout(new BorderLayout());
    add(appPanel, BorderLayout.PAGE_START);

    final SearchMediaItemView self = this;
    addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent windowEvent) {
            onClose.accept(self);
          }
        });
  }

  /** Creates a border-layout panel with padding. */
  private JPanel initializeContentPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(0 /* hgap */, 20 /* vgap */));

    JScrollPane scrollPane =
        new JScrollPane(
            panel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(UIHelper.NO_BORDER);

    JPanel outerPanel = new JPanel();
    outerPanel.setLayout(new GridLayout(1 /* rows */, 1 /* cols */));
    outerPanel.setBorder(CONTENT_BORDER);
    outerPanel.add(scrollPane);
    add(outerPanel, BorderLayout.CENTER);

    return panel;
  }

  private JPanel initializeIntroductionPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout(0 /* hgap */, 16 /* vgap */));
    panel.add(getSearchIntroLabel(), BorderLayout.PAGE_START);
    panel.add(getSearchDescLabel(), BorderLayout.CENTER);
    return panel;
  }

  private JPanel initializeFilterPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    return panel;
  }

  private void initializeContentCategory() {
    contentCategoryByCheckBoxFn = new HashMap<>();

    includeCategoryCheckBoxes =
        Lists.newArrayList(ContentCategory.values())
            .stream()
            .map(
                contentCategory -> {
                  JCheckBox checkBox = new JCheckBox(contentCategory.name());
                  contentCategoryByCheckBoxFn.put(checkBox, contentCategory);
                  return checkBox;
                })
            .collect(Collectors.toList());
    initializeCheckBoxGroup(INCLUDE_CATEGORIES_TEXT, includeCategoryCheckBoxes);

    excludeCategoryCheckBoxes =
        Lists.newArrayList(ContentCategory.values())
            .stream()
            .map(
                contentCategory -> {
                  JCheckBox checkBox = new JCheckBox(contentCategory.name());
                  contentCategoryByCheckBoxFn.put(checkBox, contentCategory);
                  return checkBox;
                })
            .collect(Collectors.toList());
  }

  private JPanel initializeSort() {
    // Add the radio buttons to the panel to display them.
    JPanel groupPanel = new JPanel();
    groupPanel.setLayout(new BorderLayout());
    groupPanel.add(
        UIHelper.getFormattedLabel(SORT_TEXT_TITLE, TITLE_SIZE), BorderLayout.PAGE_START);
    groupPanel.add(
        UIHelper.getFormattedLabel(SORT_TEXT_DESC, DESCRIPTION_SIZE), BorderLayout.LINE_START);
    OrderByPanel orderBySelection = new OrderByPanel();
    orderBySelection.addOrderByConsumer(getOrderByConsumer(orderBySelection));
    groupPanel.add(orderBySelection, BorderLayout.PAGE_END);
    return groupPanel;
  }

  private JPanel initializeDateFilters() {
    JPanel groupPanel = new JPanel();
    groupPanel.setLayout(new BorderLayout());
    groupPanel.add(
        UIHelper.getFormattedLabel(DATE_FILTERS_TEXT, TITLE_SIZE), BorderLayout.PAGE_START);

    JPanel dateRangePanel = new JPanel();
    dateRangePanel.setLayout(new GridLayout(4 /* rows */, 1 /* cols */));
    dateRangePanel.setBorder(
        new EmptyBorder(8 /* top */, 16 /* left */, 8 /* bottom */, 16 /* right */));

    DatePickerPanel startDatePicker = new DatePickerPanel();
    DatePickerPanel endDatePicker = new DatePickerPanel();

    startDatePicker.addDateConsumer(getDateRangeDateConsumer(startDatePicker, endDatePicker));
    endDatePicker.addDateConsumer(getDateRangeDateConsumer(startDatePicker, endDatePicker));

    dateRangePanel.add(UIHelper.getFormattedLabel(START_DATE_TEXT, DESCRIPTION_SIZE));
    dateRangePanel.add(startDatePicker);
    dateRangePanel.add(UIHelper.getFormattedLabel(END_DATE_TEXT, DESCRIPTION_SIZE));
    dateRangePanel.add(endDatePicker);

    groupPanel.add(dateRangePanel, BorderLayout.CENTER);
    return groupPanel;
  }

  private JPanel initializeApplyPanel(
      BiConsumer<SearchMediaItemView, SearchMediaItemsRequest> onApplyFiltersClicked) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel.add(initializeApplyButton(onApplyFiltersClicked));
    return panel;
  }

  private CustomButton initializeApplyButton(
      BiConsumer<SearchMediaItemView, SearchMediaItemsRequest> onApplyFiltersClicked) {
    CustomButton applyButton = new CustomButton(APPLY_FILTERS_TEXT);
    UIHelper.setFixedSize(applyButton, APPLY_FILTERS_DIMENSION);
    applyButton.addActionListener(getOnApplyButtonClicked(onApplyFiltersClicked));
    return applyButton;
  }

  private JPanel initializeCheckBoxGroup(String title, List<JCheckBox> checkBoxes) {
    JPanel groupPanel = new JPanel();
    groupPanel.setLayout(new BorderLayout(0 /* hgap */, 12 /* vgap */));

    groupPanel.add(UIHelper.getFormattedLabel(title, TITLE_SIZE), BorderLayout.PAGE_START);

    JPanel checkBoxPanel = new JPanel();
    checkBoxPanel.setLayout(new GridLayout(0 /* rows */, 3 /* cols */));
    for (JCheckBox checkBox : checkBoxes) {
      checkBoxPanel.add(checkBox);
    }
    groupPanel.add(checkBoxPanel);

    return groupPanel;
  }

  private Consumer<OrderBy> getOrderByConsumer(OrderByPanel panel) {
    return orderBy -> {
      requestBuilder.clearOrderBy();
      if (orderBy != null) {
        // Use the string representation as input for the API call.
        requestBuilder.setOrderBy(orderBy.getRequestValue());
      }
    };
  }

  private Consumer<Date> getDateRangeDateConsumer(
      DatePickerPanel startDatePicker, DatePickerPanel endDatePicker) {
    return date -> {
      DateRange selectedRange =
          DateRange.newBuilder()
              .setStartDate(startDatePicker.getSelectedDate())
              .setEndDate(endDatePicker.getSelectedDate())
              .build();
      // Overwrite the previously set date filter with the new range.
      requestBuilder
          .getFiltersBuilder()
          .setDateFilter(DateFilter.newBuilder().addRanges(selectedRange));
    };
  }

  private ActionListener getOnApplyButtonClicked(
      BiConsumer<SearchMediaItemView, SearchMediaItemsRequest> onApplyFiltersClicked) {
    return actionEvent -> {
      List<ContentCategory> includedCategories = getIncludedContentCategories();
      List<ContentCategory> excludedCategories = getExcludedContentCategories();

      // Add a content filter only if include or exclude categories are selected.
      if (includedCategories.isEmpty() && excludedCategories.isEmpty()) {
        requestBuilder.getFiltersBuilder().clearContentFilter();
      } else {
        requestBuilder.getFiltersBuilder().getContentFilterBuilder().clear();
        requestBuilder
            .getFiltersBuilder()
            .getContentFilterBuilder()
            .addAllIncludedContentCategories(includedCategories)
            .addAllExcludedContentCategories(excludedCategories);
      }
      onApplyFiltersClicked.accept(this, requestBuilder.build());
    };
  }

  private List<ContentCategory> getIncludedContentCategories() {
    return includeCategoryCheckBoxes
        .stream()
        .filter(JCheckBox::isSelected)
        .map(contentCategoryByCheckBoxFn::get)
        .collect(Collectors.toList());
  }

  private List<ContentCategory> getExcludedContentCategories() {
    return excludeCategoryCheckBoxes
        .stream()
        .filter(JCheckBox::isSelected)
        .map(contentCategoryByCheckBoxFn::get)
        .collect(Collectors.toList());
  }

  private JLabel getSearchIntroLabel() {
    JLabel label = UIHelper.getFormattedLabel(SEARCH_INTRO_TITLE, SEARCH_INTRO_TITLE_SIZE);
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setHorizontalAlignment(SwingConstants.LEFT);
    return label;
  }

  private JLabel getSearchDescLabel() {
    JLabel label =
        new JLabel(
            String.format(
                "<html>%s</html>", UIHelper.getFormattedText(SEARCH_INTRO_DESC, DESCRIPTION_SIZE)));
    label.setVerticalAlignment(SwingConstants.CENTER);
    label.setHorizontalAlignment(SwingConstants.LEFT);
    return label;
  }
}
