# Google Photos Library API Java Client Library

This repository contains the Java client library for the [Google Photos Library API](https://developers.google.com/photos).

**This client library is still being incubated and will be available as a released artifact soon. 
Right now you can clone this repository, but it is recommended to wait for the first release before 
building with it.**

## Requirements and Preparation

* Java 1.8+
* Gradle build system or Maven 3.0+ recommended.
* To use this library to connect to the Google Photos Library API, you need an
  [OAuth 2 client ID and secret](https://developers.google.com/photos/library/guides/get-started#request-id).
  If you use the [Google Auth Library for Java](https://github.com/google/google-auth-library-java),
  follow the [steps below](#setting-up-your-oauth2-credentials)
  to get started. Make sure that the OAuth client is configured as an "other type".

## Getting started

First download the library or include it in your build configuration. Then, set
up OAuth 2.0 credentials to access the API.
Next you can follow the [samples](samples/) to see the client library in action.

### Clone the repository

This method is suitable for those who want to alter or contribute to
this library (e.g., submitting pull requests) or wish to try our examples.
**All** files in this repository will be downloaded.

1. Run `git clone https://github.com/google/java-photoslibrary.git` at
   the command prompt.
2. You'll get a **java-photoslibrary** directory. Navigate to it by running
    `cd java-photoslibrary`.
3. Open the `build.gradle` file in your IDE or run `./gradlew assemble` at the
   command prompt to build the project. See `./gradlew tasks` to see available tasks

## Basic Usage

The best way to learn how to use this library is to [review the samples](samples/).
The [developer documentation](https://developers.google.com/photos) also include
code snippets for this client library in PHP.

Once you have set up the dependencies and OAuth 2 credentials, you can access
the API.
Here's a short example that shows how to create a new album:

```java
// Set up the Photos Library Client that interacts with the API
PhotosLibrarySettings settings =
    PhotosLibrarySettings.newBuilder()
    .setCredentialsProvider(/* TODO: Add credentials here. */)
    .build();
PhotosLibraryClient client = PhotosLibraryClient.initialize(settings);

Album newAlbum = Album.newBuilder().setTitle("My Album").build();

try {
    // Create a new Album  with at title
    Album createdAlbum = photosLibraryClient.createAlbum("My Album");
    // Get some properties from the album, such as its ID and product URL
    String id = album.getId();
    String url = album.getProductUrl();
} catch (ApiException e) {
    // Error during album creation
}
```

## Setting up your OAuth2 credentials

The Google Photos Library API uses [OAuth2](https://oauth.net/2/) as the
authentication mechanism. Note that service accounts are not supported.

Follow the [get started guide in the developer documentation](https://developers.google.com/photos)
to set up a Google developers account, enable the Google Photos Library API and
configure OAuth 2.0 for your project.

**Note that you must select other as the application type if you are following
the samples in this repository.**

This client library works with the [Google Auth Library for Java](https://github.com/google/google-auth-library-java).
Specify the `CredentialsProvider` when creating the `PhotoLibrarySettings` for
a `PhotosLibraryClient` object.
See the file `PhotosLibraryClientFactory.java` for an example on how to create
a new `PhotosLibraryClient` object with credentials from the Google Auth Library.


## Samples

 Three samples are included in the [samples](samples/) directory. They show how
 to access media items, filter media, share albums and upload files.

## Documentation

Javadoc for this library can be found in the [gh-pages](https://github.com/google/photos-library-java-lib/tree/gh-pages) branch of this repository.

General Google Photos Library API documentation can be found on our Google Developers
site: https://developers.google.com/photos

## Getting support

For client library specific bug reports, feature requests, and patches,
create an issue on the [issue
tracker](https://github.com/google/photos-library-java-lib/issues).

See the [support page](https://developers.google.com/photos/library/support/how-to-get-help)
for any other API questions, bug reports, or feature requests.

## Announcements and updates

For general Google Photos Library API and client library updates and news, follow:

* [Java client library release notes](TODO)
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
