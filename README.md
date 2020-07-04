# Google Photos Library API Java Client Library

This repository contains the Java client library for the [Google Photos Library API](https://developers.google.com/photos).

[![Build Status](https://travis-ci.org/google/java-photoslibrary.svg?branch=master)](https://travis-ci.org/google/java-photoslibrary)

## Requirements and preparation

* Java 1.8+
* Gradle build system or Maven 3.0+ recommended.
* OAuth 2.0 credentials configured for your project as [described below](#set-up-your-oauth2-credentials-for-java). (Note that to run the samples, use the "*other*" client type.)

## Download the client library

Firstly, download the library or include it in your build configuration. Then, set up OAuth 2.0 credentials to access the API.

Next, you can follow the [samples](sample/) to see the client library in action.

### Option 1: Gradle dependency
To use this library with Gradle, add the following dependency to your `build.gradle` file:
```
repositories {
    mavenCentral()
}
dependencies {
    compile 'com.google.photos.library:google-photos-library-client:1.2.0'
}
```

### Option 2: Maven dependency
To use this library with Maven, add the following to your Maven `pom.xml` file:
```
<dependency>
  <groupId>com.google.photos.library</groupId>
  <artifactId>google-photos-library-client</artifactId>
  <version>1.2.0</version>
</dependency>
```

### Option 3: Download a release
The [releases page](https://github.com/google/java-photoslibrary/releases) contains different artifacts for each library release, including jar files.

### Option 4: Clone the repository

Use this method if you want to alter or contribute to this library (e.g., submitting pull requests) or wish to try our samples. When you clone the repository,  **all** files in this repository will be downloaded.

1. Run `git clone https://github.com/google/java-photoslibrary.git` at
   the command prompt.
2. You'll get a **java-photoslibrary** directory. Navigate to it by running
    `cd java-photoslibrary`.
3. Open the `build.gradle` file in your IDE or run `./gradlew assemble` at the
   command prompt to build the project. See `./gradlew tasks` to see available tasks

## Set up your OAuth2 credentials for Java

The Google Photos Library API uses [OAuth2](https://oauth.net/2/) as the
authentication mechanism. Note that the Library API does not support service accounts.

To complete the “Enable the API” and “Configure OAuth2.0” steps in the below procedure, refer to the [get started guide in the developer documentation](https://developers.google.com/photos/library/guides/)

Follow the below steps:
1. Set up a Google developers project
1. Enable the *Google Photos Library API* in your developer project
1. Configure OAuth 2.0 credentials, including a callback URI
1. Either download your OAuth credentials as a JSON file or note your client ID and secret.

To try out the samples in this repository, select "*other*" as the application type.

This client library works with the [Google Auth Library for Java](https://github.com/google/google-auth-library-java).
Specify your client OAuth configuration in the `CredentialsProvider` when creating the `PhotoLibrarySettings` for a `PhotosLibraryClient` object.
See the file `PhotosLibraryClientFactory.java` for an example on how to create
a new `PhotosLibraryClient` object with credentials from the Google Auth Library.

## Sample usage

Here's a short example that shows how to create a new album:

```java
// [START sample_usage]
// Set up the Photos Library Client that interacts with the API
PhotosLibrarySettings settings =
     PhotosLibrarySettings.newBuilder()
    .setCredentialsProvider(
        FixedCredentialsProvider.create(/* Add credentials here. */)) 
    .build();

try (PhotosLibraryClient photosLibraryClient =
    PhotosLibraryClient.initialize(settings)) {

    // Create a new Album  with at title
    Album createdAlbum = photosLibraryClient.createAlbum("My Album");

    // Get some properties from the album, such as its ID and product URL
    String id = album.getId();
    String url = album.getProductUrl();

} catch (ApiException e) {
    // Error during album creation
}
// [END sample_usage]
```

## Samples

 A few examples are included in the [sample](sample/) directory. They show how
 to access media items, filter media, share albums and upload files.

The [API developer documentation](https://developers.google.com/photos) also includes
code snippets for this client library in Java.

## Reference documentation

Javadoc for this library can be found in the [gh-pages](https://github.com/google/java-photoslibrary/tree/gh-pages) branch of this repository.
You can browse it at https://google.github.io/java-photoslibrary/index.html

General Google Photos Library API documentation can be found on our Google Developers
site: https://developers.google.com/photos

## Getting support

For client library specific bug reports, feature requests, and patches,
create an issue on the [issue
tracker](https://github.com/google/java-photoslibrary/issues).

See the [support page](https://developers.google.com/photos/library/support/how-to-get-help)
for any other API questions, bug reports, or feature requests.

## Announcements and updates

For general Google Photos Library API and client library updates and news, follow:

* [Java client library release notes](https://github.com/google/java-photoslibrary/releases)
* [Google Photos Library API release notes](https://developers.google.com/photos/library/support/release-notes)

## License

Copyright 2018 Google LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
