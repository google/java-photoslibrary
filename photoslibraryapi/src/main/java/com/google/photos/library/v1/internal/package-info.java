/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= InternalPhotosLibraryClient =======================
 *
 * <p>Service Description: Service which allows developers to perform the following actions on
 * behalf of the user: - upload media items directly to their Google Photos library - create albums
 * - add media items (including album enrichments) to albums - list and download content from their
 * Google Photos library - filter results by media type, date range or content category - create,
 * join, and access shared albums
 *
 * <p>Sample for InternalPhotosLibraryClient:
 *
 * <pre>{@code
 * try (InternalPhotosLibraryClient internalPhotosLibraryClient =
 *     InternalPhotosLibraryClient.create()) {
 *   Album album = Album.newBuilder().build();
 *   Album response = internalPhotosLibraryClient.createAlbum(album);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.photos.library.v1.internal;

import javax.annotation.Generated;
