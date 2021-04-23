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

package com.google.photos.library.sample.demos.upload;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

/** Helper methods for the upload demo application. */
public class UploadDemoHelper {
  /** Default format to use when generating images using {@link #generateDefaultImage(File)}. */
  private static final String DEFAULT_IMAGE_FORMAT = "jpg";

  /** Default width of the image when generated using {@link #generateDefaultImage(File)}. */
  private static final int DEFAULT_IMAGE_WIDTH = 700;

  /** Default height of the image when generated using {@link #generateDefaultImage(File)}. */
  private static final int DEFAULT_IMAGE_HEIGHT = 250;

  /**
   * Generates multiple files with default settings.
   *
   * <p>The files are created as temporary files and are set to be deleted on exit.
   *
   * @param numberToGenerate Number of temporary files to generate.
   * @return Temporary files
   * @see #generateDefaultImage(File)
   */
  public static File[] generateFiles(int numberToGenerate) throws IOException {
    File[] files = new File[numberToGenerate];

    for (int i = 0; i < numberToGenerate; i++) {
      File tempFile = File.createTempFile("uploadsample", ".jpg");
      tempFile.deleteOnExit();
      UploadDemoHelper.generateDefaultImage(tempFile);
      files[i] = tempFile;
    }

    return files;
  }

  /** Generate an image with default parameters and store it in the {@link File}. */
  public static void generateDefaultImage(File file) throws IOException {
    generateDefaultImage(file, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT, DEFAULT_IMAGE_FORMAT);
  }

  /**
   * Generates an image and store it in the {@link File}.
   *
   * <p>The image has an orange/green gradient background and contains the current date/time and a
   * random number.
   *
   * @see ImageIO
   */
  public static void generateDefaultImage(File file, int width, int height, String format)
      throws IOException {
    final String dateString =
        DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss.SSS").format(ZonedDateTime.now());
    final String randomString = String.format("%.15f", Math.random());

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    RenderingHints rh =
        new RenderingHints(
            RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.setRenderingHints(rh);
    graphics.setColor(Color.WHITE);
    graphics.setPaint(new GradientPaint(0, 0, Color.orange, width, height, Color.green));
    graphics.fillRect(0, 0, width, height);
    graphics.setColor(Color.BLACK);
    graphics.setFont(new Font("SansSerif", Font.PLAIN, 35));
    graphics.drawString(dateString, 5, 40);
    graphics.drawString(randomString, 5, 80);

    ImageIO.write(bufferedImage, format, file);
  }
}
