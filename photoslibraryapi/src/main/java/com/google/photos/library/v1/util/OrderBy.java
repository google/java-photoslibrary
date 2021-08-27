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

package com.google.photos.library.v1.util;

import com.google.photos.library.v1.proto.Filters;

/**
 * Order of search results.
 *
 * <p>The value expected by the Library API can be retrieved from {@link #getRequestValue()}.
 *
 * @see com.google.photos.library.v1.PhotosLibraryClient#searchMediaItems(Filters, OrderBy...)
 */
public enum OrderBy {
  MEDIAMETADATA_CREATION_TIME("MediaMetadata.creation_time"),
  MEDIAMETADATA_CREATION_TIME_DESC("MediaMetadata.creation_time desc");

  /** Separator used to join multiple order configurations. */
  public static final String SEPARATOR = ",";

  /** String representation of this order as expected by the API. */
  private final String requestValue;

  /**
   * Order of search results.
   *
   * @param requestValue String representation as expected by the API.
   */
  OrderBy(String requestValue) {
    this.requestValue = requestValue;
  }

  /**
   * String representation of a sort option. Returns a string that is accepted by the Google Photos
   * Library as a parameter.
   *
   * @return Representation of this order as accepted by the API.
   */
  public String getRequestValue() {
    return requestValue;
  }
}
