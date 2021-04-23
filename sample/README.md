# Google Photos Library API Java Client Library Samples

This directory contains three samples to help you get started with the Java
client library for the [Google Photos Library API](https://developers.google.com/photos).

## Get started

1. Follow the steps in the client library get started guide either by
  [cloning this repository](../README.md#using-git-clone) or [downloading a compressed tarball](../README.md#downloading-a-compressed-tarball).
1. Set up your Google Developers project, enable the Google Photos Library API
   and set up new OAuth credentials **for an "other-type" application**.
   Download the OAuth configuration as a JSON file. See [Setting up your OAuth2 credentials](../README.md#Setting-up-your-OAuth2-credentials).
2. Open the `build.gradle` file in this directory in your IDE or make a build from the commandline
    using `./gradlew assemble` to build the samples.
3. Run one of the samples main classes from the package `com.google.photos.library.sample.demos` .
   You can also run one of the following gradle tasks, for example `./gradlew sample:runAlbum`:
   * `sample:runAlbum`
   * `sample:runFilter`
   * `sample:runShare`
   * `sample:runUpload`

Note: You may need to clean your build project and build directories (`./gradlew clean`) before you
run a different sample app. The user authentication credentials are cached for all samples together
and execution will fail for samples that require different authentication scopes.

## Samples
This repository includes three samples.

### Filters
Class: `com.google.photos.library.sample.demos.FilterDemo`.
[File: `FilterDemo.java`](src/main/java/com/google/photos/library/sample/demos/FilterDemo.java)

Shows how to list media, apply filters and read media metadata.

### Albums and Uploads
Class: `com.google.photos.library.sample.demos.AlbumDemo`.
[File: `AlbumDemo.java`](src/main/java/com/google/photos/library/sample/demos/AlbumDemo.java)

Shows how to list albums, list the content of albums, create new albums and
upload media.

### Sharing
Class: `com.google.photos.library.sample.demos.ShareDemo`.
[File: `AlbumDemo.java`](src/main/java/com/google/photos/library/sample/demos/ShareDemo.java)

Shows how to share an album created by this application using `share tokens`.

### Upload
Class: `com.google.photos.library.sample.demos.UploadDemo`.
[File: `AlbumDemo.java`](src/main/java/com/google/photos/library/sample/demos/UploadDemo.java)

Shows how to efficiently upload media, including parallelization and other best
practices.