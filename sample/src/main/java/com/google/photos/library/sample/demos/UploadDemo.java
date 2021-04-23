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

package com.google.photos.library.sample.demos;

import com.google.common.collect.ImmutableList;
import com.google.photos.library.sample.demos.upload.UploadDemoHelper;
import com.google.photos.library.sample.demos.upload.Uploader;
import com.google.photos.library.sample.factories.PhotosLibraryClientFactory;
import com.google.photos.library.v1.PhotosLibraryClient;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Google Photos Library API upload sample.
 *
 * <p>Sample app that shows how to efficiently upload many images. It includes multithreading using
 * a {@link java.util.concurrent.CompletionService}, but the principles can be applied to other
 * multi-threading techniques.
 *
 * <p>This sample app should be run from the commandline and is controlled via commandline
 * arguments, see {@link #main(String[])}. It can upload a list of files specified on the
 * commandline or it can also generate small or large image files to upload.
 *
 * <p>This sample uses the following API methods:
 *
 * <ul>
 *   <li>batchCreateMediaItems: create media items in an album
 *   <li>uploadMediaItem: upload a photo
 * </ul>
 *
 * See the class {@link Uploader} for
 */
public final class UploadDemo {

  /** OAuth scopes to request. This demo requires `photoslibrary.appendonly` at a minimum. */
  private static final List<String> REQUIRED_SCOPES =
      ImmutableList.of("https://www.googleapis.com/auth/photoslibrary.appendonly");

  /**
   * Upload demo app for the Google Photos Library API.
   *
   * <p>This app shows how to efficiently upload media, including parallelization and other best
   * practices. Use the '-generateImages` option to have this sample generate images and upload them
   * to the connected Google Photos library.
   *
   * <p>Supported argument options:
   *
   * <ul>
   *   <li>[path to credentials file] -generateImages [Number of images to generate]
   *   <li>[path to credentials file] -uploadFiles [path to file, path to file, ...]
   * </ul>
   *
   * The credentials file should be the JSON file downloaded from the Google API console for a key
   * of the 'desktop app' type.
   *
   * @param args Commandline arguments.
   */
  public static void main(String[] args) {

    // At least 3 arguments are required.
    if (args.length < 3) {
      printHelp();
      System.exit(2);
    }

    // Parse the commandline parameters: [credentials file] [-generateImages|-uploadFiles]
    final String credentialsFile = args[0];
    final boolean generateImages = args[1].equals("-generateImages");
    final boolean uploadFiles = args[1].equals("-uploadFiles");

    // The files to upload.
    File[] filesToUpload = new File[0];

    if (args.length == 3 && generateImages) {
      // Option set to generate images, the third parameter contains the number of images to
      // generate.
      int numberToGenerate = Integer.parseInt(args[2]);
      try {
        // Generate temporary image files for upload.
        filesToUpload = UploadDemoHelper.generateFiles(numberToGenerate);
      } catch (IOException e) {
        // Could not generate files.
        System.err.println("Could not generate temporary files: " + e.getMessage());
        System.exit(3);
      }
    } else if (uploadFiles) {
      // The arguments contain a list of files to upload, parse this list.
      // Skip the first two commandline arguments.
      filesToUpload = new File[args.length - 2];
      for (int i = 2; i < args.length; i++) {
        filesToUpload[i - 2] = new File(args[i]);
      }
    } else {
      // Invalid parameter combination.
      printHelp();
      System.exit(2);
    }

    // Create a new PhotosLibraryClient that is used by the Uploader in this sample.
    // Note that both the client and the Uploader objects are automatically closed after execution
    // to clean up any resources.
    try (PhotosLibraryClient client =
            PhotosLibraryClientFactory.createClient(credentialsFile, REQUIRED_SCOPES);
        Uploader demo = new Uploader(client)) {
      demo.uploadFiles(filesToUpload);
      demo.printState();
    } catch (IOException e) {
      System.err.println("IOException while running the sample: " + e.getMessage());
      e.printStackTrace();
    } catch (GeneralSecurityException e) {
      System.err.println("GeneralSecurityException while running the sample: " + e.getMessage());
      e.printStackTrace();
    } catch (InterruptedException | ExecutionException e) {
      System.err.println("Threading exception while initializing client: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private static void printHelp() {
    System.out.println(
        "Upload demo app for the Google Photos Library API.\n"
            + "This app shows how to efficiently upload media, including parallelization and other"
            + "best practices.\n"
            + "Use the '-generateImages` option to have this sample generate images and upload them "
            + "to the connected Google Photos library.\n"
            + "\n"
            + "Supported argument options: \n"
            + "  [path to credentials file] -generateImages [Number of images to generate]\n"
            + "  [path to credentials file] -uploadFiles [path to file, path to file, ...]\n"
            + "\n"
            + "The credentials file should be the JSON file downloaded from the Google API console for a key of the 'desktop app' type.");
  }
}
