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

package com.google.photos.library.v1.upload;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;

/** Base stub class for uploading with Photos Library API. */
public abstract class PhotosLibraryUploadStub implements BackgroundResource {
  public UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> uploadMediaItemCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadMediaItemCallable()");
  }
}
