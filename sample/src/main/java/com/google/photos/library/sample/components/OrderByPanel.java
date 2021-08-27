/*
 * Copyright 2021 Google LLC
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

import com.google.photos.library.v1.util.OrderBy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.swing.*;

/** A component that lets user enter day, month, and year. */
public final class OrderByPanel extends JPanel implements ActionListener {
  ButtonGroup group = new ButtonGroup();
  private final Map<JRadioButton, OrderBy> orderByRadioButton = new HashMap<>();

  private final List<Consumer<OrderBy>> orderByConsumers;

  public OrderByPanel() {
    super();
    setLayout(new GridLayout(3 /* rows */, 1 /* cols */));

    JRadioButton undefined = new JRadioButton("Default (undefined)");
    undefined.setSelected(true);
    undefined.addActionListener(this);
    add(undefined);
    group.add(undefined);

    // Create the radio buttons with different sort options and
    // map the radio button to its own OrderBy configuration that will be included
    // in the API request.

    JRadioButton newestFirst = new JRadioButton("Newest first");
    orderByRadioButton.put(newestFirst, OrderBy.MEDIAMETADATA_CREATION_TIME_DESC);
    newestFirst.addActionListener(this);
    add(newestFirst);
    group.add(newestFirst);

    JRadioButton oldestFirst = new JRadioButton("Oldest first");
    orderByRadioButton.put(oldestFirst, OrderBy.MEDIAMETADATA_CREATION_TIME);
    oldestFirst.addActionListener(this);
    add(oldestFirst);
    group.add(oldestFirst);

    orderByConsumers = new ArrayList<>();
  }

  public void addOrderByConsumer(Consumer<OrderBy> orderByConsumer) {
    orderByConsumers.add(orderByConsumer);
  }

  /**
   * Returns the selected order or null if none is selected.
   *
   * @return
   */
  public OrderBy getSelectedOrderBy() {
    for (Map.Entry<JRadioButton, OrderBy> entry : orderByRadioButton.entrySet()) {
      if (entry.getKey().isSelected()) {
        return entry.getValue();
      }
    }
    return null;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    for (Consumer<OrderBy> orderByConsumer : orderByConsumers) {
      orderByConsumer.accept(getSelectedOrderBy());
    }
  }
}
