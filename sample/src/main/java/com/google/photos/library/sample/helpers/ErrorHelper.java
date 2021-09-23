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

package com.google.photos.library.sample.helpers;

import com.google.photos.library.sample.views.AbstractCustomView;
import javax.swing.*;

/** Utility methods for handling errors. */
public class ErrorHelper {

  /**
   * Show a dialog with the message and the exception.
   *
   * @param view Parent for dialog
   * @param exception Exception that caused this error
   * @param message Message to include in the dialog
   */
  public static void showErrorMessage(
      AbstractCustomView view, Exception exception, String message) {
    JOptionPane.showMessageDialog(view, message + "\n" + exception.getMessage());
  }

  /**
   * Show a dialog with the message and the exception.
   *
   * @param view Parent for dialog
   * @param exception Exception that caused this error
   */
  public static void showErrorMessage(AbstractCustomView view, Exception exception) {
    JOptionPane.showMessageDialog(view, exception.getMessage());
  }

  /**
   * Exit the app and show a dialog with the message and the exception.
   *
   * @param view Parent for dialog
   * @param exception Exception that caused this error
   * @param message Message to include in the dialog
   */
  public static void showFatalErrorMessage(
      AbstractCustomView view, Exception exception, String message) {
    JOptionPane.showMessageDialog(view, message + "\n" + exception.getMessage());
    System.exit(5);
  }
}
