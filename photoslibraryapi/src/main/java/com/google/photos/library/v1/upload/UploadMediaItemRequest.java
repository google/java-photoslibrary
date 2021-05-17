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

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Optional;

/** Represents an upload request. */
public final class UploadMediaItemRequest {

  private static final int DEFAULT_CHUNK_SIZE = 1024 * 1024 * 10; // 10 MB

  private final Optional<String> fileName;
  private final Optional<String> mimeType;
  private final Optional<String> uploadUrl;
  private final int chunkSize;
  private final RandomAccessFile dataFile;

  private UploadMediaItemRequest(
      Optional<String> fileName,
      Optional<String> uploadUrl,
      int chunkSize,
      Optional<String> mimeType,
      RandomAccessFile dataFile) {
    this.fileName = fileName;
    this.uploadUrl = uploadUrl;
    this.chunkSize = chunkSize;
    this.mimeType = mimeType;
    this.dataFile = dataFile;
  }

  /** Returns the file name to be uploaded. */
  public Optional<String> getFileName() {
    return fileName;
  }

  /** Returns the mime type for the file to be uploaded. */
  public Optional<String> getMimeType() {
    return mimeType;
  }

  /** Returns the url where this file will be uploaded. */
  public Optional<String> getUploadUrl() {
    return uploadUrl;
  }

  /** Returns the chunk size where the file will be split. */
  public int getChunkSize() {
    return chunkSize;
  }

  /** Returns the total size of the file. */
  public long getFileSize() throws IOException {
    return dataFile.getChannel().size();
  }

  /** Reads bytes from the input file. */
  int readData(byte[] bytes) throws IOException {
    return dataFile.read(bytes);
  }

  /** Moves the cursor of the input file. */
  void seekCursor(long offset) throws IOException {
    dataFile.seek(offset);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UploadMediaItemRequest that = (UploadMediaItemRequest) o;
    return getChunkSize() == that.getChunkSize()
        && getFileName().equals(that.getFileName())
        && getMimeType().equals(that.getMimeType())
        && getUploadUrl().equals(that.getUploadUrl())
        && dataFile.equals(that.dataFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFileName(), getMimeType(), getUploadUrl(), getChunkSize(), dataFile);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Builder for {@link UploadMediaItemRequest}. */
  public static final class Builder {

    private Optional<String> fileName;
    private Optional<String> mimeType;
    private Optional<String> uploadUrl;
    private int chunkSize;
    private RandomAccessFile dataFile;

    private Builder() {
      chunkSize = DEFAULT_CHUNK_SIZE;
      fileName = Optional.empty();
      mimeType = Optional.empty();
      uploadUrl = Optional.empty();
    }

    public Builder mergeFrom(UploadMediaItemRequest other) {

      if (!other.getFileName().isEmpty()) {
        fileName = other.fileName;
      }
      if (!other.getMimeType().isEmpty()) {
        mimeType = other.mimeType;
      }
      if (!other.getUploadUrl().isEmpty()) {
        uploadUrl = other.uploadUrl;
      }
      chunkSize = other.getChunkSize();
      dataFile = other.dataFile;

      return this;
    }

    /**
     * @deprecated As of 1.5.0, set the file name in {@link
     *     com.google.photos.library.v1.proto.NewMediaItem} instead, which also supports Unicode
     *     strings. For example, use {@link
     *     com.google.photos.library.v1.util.NewMediaItemFactory#createNewMediaItem(String, String,
     *     String)} to generate a NewMediaItem with a description and file name.
     */
    @Deprecated
    public Builder setFileName(String fileName) {
      this.fileName = Optional.of(fileName);
      return this;
    }

    public Builder setMimeType(String mimeType) {
      this.mimeType = Optional.of(mimeType);
      return this;
    }

    public Builder setUploadUrl(String uploadUrl) {
      this.uploadUrl = Optional.of(uploadUrl);
      return this;
    }

    public Builder setChunkSize(int chunkSize) {
      this.chunkSize = chunkSize;
      return this;
    }

    public Builder setDataFile(RandomAccessFile dataFile) {
      this.dataFile = dataFile;
      return this;
    }

    public UploadMediaItemRequest build() {
      UploadMediaItemRequest uploadMediaItemRequest =
          new UploadMediaItemRequest(fileName, uploadUrl, chunkSize, mimeType, dataFile);
      return uploadMediaItemRequest;
    }
  }
}
