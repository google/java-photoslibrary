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

package com.google.photos.library.sample.components;

import com.google.type.Date;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

/** A component that lets user enter day, month, and year. */
public final class DatePickerPanel extends JPanel implements ActionListener {
  private final JFormattedTextField yearTextField;
  private final JFormattedTextField monthTextField;
  private final JFormattedTextField dayTextField;
  private List<Consumer<Date>> dateConsumers;

  public DatePickerPanel() {
    super();
    setLayout(new GridLayout(1 /* rows */, 3 /* cols */));

    yearTextField = new JFormattedTextField();
    yearTextField.setToolTipText("Year (YYYY)");
    yearTextField.addActionListener(this);
    add(yearTextField);

    monthTextField = new JFormattedTextField();
    monthTextField.setToolTipText("Month (MM)");
    monthTextField.addActionListener(this);
    add(monthTextField);

    dayTextField = new JFormattedTextField();
    dayTextField.setToolTipText("Day (DD)");
    dayTextField.addActionListener(this);
    add(dayTextField);

    dateConsumers = new ArrayList<>();
  }

  public void addDateConsumer(Consumer<Date> dateConsumer) {
    dateConsumers.add(dateConsumer);
  }

  public Date getSelectedDate() {
    Date.Builder dateBuilder = Date.newBuilder();

    OptionalInt year = tryParseInt(yearTextField.getText());
    if (year.isPresent()) {
      dateBuilder.setYear(year.getAsInt());
    }

    OptionalInt month = tryParseInt(monthTextField.getText());
    if (month.isPresent()) {
      dateBuilder.setMonth(month.getAsInt());
    }

    OptionalInt day = tryParseInt(dayTextField.getText());
    if (day.isPresent()) {
      dateBuilder.setDay(day.getAsInt());
    }

    return dateBuilder.build();
  }

  private OptionalInt tryParseInt(String text) {
    return Optional.of(text)
        .filter(s -> s.matches("\\d+"))
        .map(s -> OptionalInt.of(Integer.parseInt(s)))
        .orElse(OptionalInt.empty());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (Consumer<Date> dateConsumer : dateConsumers) {
      dateConsumer.accept(getSelectedDate());
    }
  }
}
