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

import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.threeten.bp.Duration;

final class PhotosLibraryUploadCallable implements Callable<UploadMediaItemResponse> {

  private static final class UploadCommands {
    private static final String START = "start";
    private static final String UPLOAD = "upload";
    private static final String QUERY = "query";
    private static final String FINALIZE = "finalize";
    private static final String CANCEL = "cancel";

    private UploadCommands() {}
  }

  private static final class UploadStatuses {
    private static final String ACTIVE = "active";
    private static final String FINAL = "final";

    private UploadStatuses() {}
  }

  private static final String FILE_NAME_HEADER = "X-Goog-Upload-File-Name";
  private static final String FILE_SIZE_HEADER = "X-Goog-Upload-Raw-Size";
  private static final String UPLOAD_PROTOCOL_HEADER = "X-Goog-Upload-Protocol";
  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_CONTENT_TYPE_HEADER = "X-Goog-Upload-Content-Type";
  private static final String UPLOAD_STATUS_HEADER = "X-Goog-Upload-Status";
  private static final String UPLOAD_URL_HEADER = "X-Goog-Upload-URL";
  private static final String UPLOAD_OFFSET_HEADER = "X-Goog-Upload-Offset";
  private static final String UPLOAD_SIZE_HEADER = "X-Goog-Upload-Header-Content-Length";
  private static final String UPLOAD_GRANULARITY_HEADER = "X-Goog-Upload-Chunk-Granularity";
  private static final String RECEIVED_BYTE_COUNT_HEADER = "X-Goog-Upload-Size-Received";

  private static final String UPLOAD_PROTOCOL_VALUE = "resumable";

  private static final long UNLIMITED_TIMEOUT = 0L;

  private final UploadMediaItemRequest request;
  private final ClientContext clientContext;
  private final UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse>
      photosLibrarySettings;

  // The resume url that can be extracted when there is an error.
  private final AtomicReference<String> atomicResumeUrl;
  // This is the chunkSize closest to the request chunkSize which can be handled by the server.
  // It is not guaranteed that the chunkSize specified in the request will be the amount of data
  // to be uploaded each request. It depends on how granular the server is able to handle.
  private int optimalChunkSize;

  PhotosLibraryUploadCallable(
      UploadMediaItemRequest request,
      ClientContext clientContext,
      UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> photosLibrarySettings) {
    this.request = request;
    this.clientContext = clientContext;
    this.photosLibrarySettings = photosLibrarySettings;
    this.atomicResumeUrl = new AtomicReference<>();
  }

  public AtomicReference<String> getAtomicResumeUrl() {
    return atomicResumeUrl;
  }

  /** Executes upload process for the request. */
  @Override
  public UploadMediaItemResponse call() throws Exception {
    // Fails if the file has an invalid size
    if (request.getFileSize() < 1) {
      throw new IllegalArgumentException("The file is empty.");
    }

    // The time when this call was started.
    Duration startTime = Duration.ofNanos(clientContext.getClock().nanoTime());

    // Throws an exception when it fails to get the upload URL
    String uploadUrl = getUploadUrl();
    this.atomicResumeUrl.set(uploadUrl);

    checkForTimeoutAndInterrupt(startTime);

    Optional<HttpResponse> response = Optional.empty();

    // Keeps uploading bytes from the request media item by chunk
    long receivedByteCount = getReceivedByteCount(uploadUrl);

    // Moves the cursor to the correct position and reset failure indicator
    // before starting/resuming an upload
    request.seekCursor(receivedByteCount);
    boolean successful = true;

    // Upload in chunks as long as there's no error and there is data to upload
    while (successful && receivedByteCount < request.getFileSize()) {
      // Upload the next chunk
      response = Optional.ofNullable(uploadNextChunk(uploadUrl, receivedByteCount));
      checkForTimeoutAndInterrupt(startTime);

      // Upload is successful if a response with an OK HTTP status was returned
      successful =
          response.isPresent() && isStatusOk(response.get().getStatusLine().getStatusCode());

      receivedByteCount = getReceivedByteCount(uploadUrl);
      checkForTimeoutAndInterrupt(startTime);
    }

    // Builds an upload response from the final httpResponse or throw an exception if it failed
    return buildUploadMediaItemResponse(response);
  }

  private void checkForTimeoutAndInterrupt(Duration initialTime)
      throws TimeoutException, InterruptedException {
    if (Thread.currentThread().isInterrupted()) {
      throw new InterruptedException(ExceptionStrings.UPLOAD_THREAD_INTERRUPTED);
    }

    final Duration totalTimeout = photosLibrarySettings.getRetrySettings().getTotalTimeout();
    if (totalTimeout.isZero()) {
      // No timeout.
      return;
    }
    Duration timeElapsed = Duration.ofNanos(clientContext.getClock().nanoTime()).minus(initialTime);
    if (timeElapsed.toNanos() > totalTimeout.toNanos()) {
      throw new TimeoutException(ExceptionStrings.UPLOAD_TIMED_OUT);
    }
  }

  /** Initiates the upload and get an upload url. */
  private String getUploadUrl() throws IOException {
    if (request.getUploadUrl().isPresent()) {
      return request.getUploadUrl().get();
    }
    HttpPost httpPost = createAuthenticatedPostRequest(PhotosLibrarySettings.getUploadEndpoint());
    httpPost.addHeader(UPLOAD_PROTOCOL_HEADER, UPLOAD_PROTOCOL_VALUE);
    httpPost.addHeader(UPLOAD_COMMAND_HEADER, UploadCommands.START);
    httpPost.addHeader(FILE_SIZE_HEADER, String.valueOf(request.getFileSize()));

    if (request.getMimeType().isPresent()) {
      httpPost.addHeader(UPLOAD_CONTENT_TYPE_HEADER, request.getMimeType().get());
    }

    if (request.getFileName().isPresent()) {
      httpPost.addHeader(FILE_NAME_HEADER, request.getFileName().get());
    }

    CloseableHttpClient httpClient = HttpClientBuilder.create().useSystemProperties().build();
    HttpResponse response = httpClient.execute(httpPost);

    // Throw an exception if the server did not respond with a success status
    if (!isStatusOk(response.getStatusLine().getStatusCode())) {
      throw new HttpResponseException(
          response.getStatusLine().getStatusCode(),
          ExceptionStrings.NOT_INITIALIZED + " " + response.getStatusLine().getReasonPhrase());
    }

    if (response.getFirstHeader(UPLOAD_GRANULARITY_HEADER) != null) {
      updateOptimalChunkSize(
          Integer.parseInt(response.getFirstHeader(UPLOAD_GRANULARITY_HEADER).getValue()));
    }

    Header headerStatus = response.getFirstHeader(UPLOAD_STATUS_HEADER);
    if (headerStatus == null) {
      throw new IllegalStateException(ExceptionStrings.INVALID_UPLOAD_STATUS);
    }

    switch (headerStatus.getValue()) {
      case UploadStatuses.ACTIVE:
        return response.getFirstHeader(UPLOAD_URL_HEADER).getValue();
      case UploadStatuses.FINAL:
        throw new IllegalArgumentException(ExceptionStrings.UPLOAD_URL_REJECTED);
      default:
        throw new IllegalStateException(ExceptionStrings.INVALID_UPLOAD_STATUS);
    }
  }

  /**
   * Gets the number of bytes the server has received. Throws an {@link IOException} if the server
   * did not respond with an expected status. Throws a {@link HttpResponseException} if the server
   * responded with a non-OK status.
   */
  private long getReceivedByteCount(String uploadUrl) throws IOException {
    HttpPost httpPost = createAuthenticatedPostRequest(uploadUrl);
    httpPost.addHeader(UPLOAD_PROTOCOL_HEADER, UPLOAD_PROTOCOL_VALUE);
    httpPost.addHeader(UPLOAD_COMMAND_HEADER, UploadCommands.QUERY);

    CloseableHttpClient httpClient = HttpClientBuilder.create().useSystemProperties().build();
    HttpResponse response = httpClient.execute(httpPost);

    if (!isStatusOk(response.getStatusLine().getStatusCode())) {
      throw new HttpResponseException(
          response.getStatusLine().getStatusCode(),
          ExceptionStrings.INVALID_PROGRESS + " " + response.getStatusLine().getReasonPhrase());
    }

    if (response.getFirstHeader(UPLOAD_GRANULARITY_HEADER) != null) {
      updateOptimalChunkSize(
          Integer.parseInt(response.getFirstHeader(UPLOAD_GRANULARITY_HEADER).getValue()));
    }

    switch (response.getFirstHeader(UPLOAD_STATUS_HEADER).getValue()) {
      case UploadStatuses.ACTIVE:
        return Long.parseLong(response.getFirstHeader(RECEIVED_BYTE_COUNT_HEADER).getValue());
      case UploadStatuses.FINAL:
        return request.getFileSize();
      default:
        throw new IllegalStateException(ExceptionStrings.INVALID_UPLOAD_STATUS);
    }
  }

  /** Uploads the next byte chunk of the media item. */
  private HttpResponse uploadNextChunk(String uploadUrl, long receivedByteCount)
      throws IOException {
    // Reads data from input stream
    byte[] dataChunk = new byte[optimalChunkSize];
    int readByteCount = request.readData(dataChunk);

    // Avoid uploading the whole chunk when only a part of it contains data
    if (readByteCount < optimalChunkSize) {
      dataChunk = trimByteArray(dataChunk, readByteCount);
    }

    HttpPost httpPost = createAuthenticatedPostRequest(uploadUrl);
    httpPost.addHeader(UPLOAD_PROTOCOL_HEADER, UPLOAD_PROTOCOL_VALUE);

    if (receivedByteCount + readByteCount == request.getFileSize()) {
      httpPost.addHeader(
          UPLOAD_COMMAND_HEADER, String.join(",", UploadCommands.UPLOAD, UploadCommands.FINALIZE));
    } else {
      httpPost.addHeader(UPLOAD_COMMAND_HEADER, UploadCommands.UPLOAD);
    }

    httpPost.addHeader(UPLOAD_OFFSET_HEADER, String.valueOf(receivedByteCount));
    httpPost.addHeader(UPLOAD_SIZE_HEADER, String.valueOf(readByteCount));
    httpPost.setEntity(EntityBuilder.create().setBinary(dataChunk).build());

    CloseableHttpClient httpClient =
        HttpClientBuilder.create()
            .useSystemProperties()
            .setDefaultRequestConfig(getRequestConfig())
            .build();
    return httpClient.execute(httpPost);
  }

  private RequestConfig getRequestConfig() {
    RequestConfig.Builder configBuilder = RequestConfig.custom();
    if (photosLibrarySettings.getRetrySettings().getTotalTimeout().toNanos() != UNLIMITED_TIMEOUT) {
      // The timeout is set in ms
      configBuilder.setConnectionRequestTimeout(
          Math.toIntExact(photosLibrarySettings.getRetrySettings().getTotalTimeout().toMillis()));
    }
    return configBuilder.build();
  }

  private UploadMediaItemResponse buildUploadMediaItemResponse(Optional<HttpResponse> response)
      throws IOException {
    if (!response.isPresent()) {
      throw new IllegalArgumentException(ExceptionStrings.INVALID_UPLOAD_RESULT);
    } else if (!isStatusOk(response.get().getStatusLine().getStatusCode())) {
      throw new HttpResponseException(
          response.get().getStatusLine().getStatusCode(),
          ExceptionStrings.INVALID_UPLOAD_RESULT
              + " "
              + response.get().getStatusLine().getReasonPhrase());
    }
    return UploadMediaItemResponse.newBuilder()
        .setUploadToken(EntityUtils.toString(response.get().getEntity()))
        .build();
  }

  private HttpPost createAuthenticatedPostRequest(String uploadUrl) throws IOException {
    HttpPost request = new HttpPost(uploadUrl);
    Map<String, List<String>> requestMetadata = clientContext.getCredentials().getRequestMetadata();
    for (Entry<String, List<String>> entry : requestMetadata.entrySet()) {
      request.addHeader(entry.getKey(), String.join(", ", entry.getValue()));
    }
    return request;
  }

  private void updateOptimalChunkSize(int uploadGranularity) {
    // Gets the multiply of upload granularity closest to specified chunkSize
    optimalChunkSize = (1 + (request.getChunkSize() - 1) / uploadGranularity) * uploadGranularity;
  }

  private static boolean isStatusOk(int statusCode) {
    return statusCode == HttpStatus.SC_OK;
  }

  private static byte[] trimByteArray(byte[] originalBytes, int newSize) {
    if (newSize > originalBytes.length) {
      return originalBytes;
    }
    byte[] newBytes = new byte[newSize];
    System.arraycopy(originalBytes, 0, newBytes, 0, newSize);
    return newBytes;
  }
}
