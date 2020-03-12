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

import static org.threeten.bp.temporal.ChronoUnit.MILLIS;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
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

  private static final Duration UNLIMITED_TIMEOUT = Duration.ZERO;
  private static final int UNLIMITED_RETRIES = 0;

  private final UploadMediaItemRequest request;
  private final ClientContext clientContext;
  private final PhotosLibrarySettings photosLibrarySettings;
  // The resume url that can be extracted when there is an error.
  private final AtomicReference<String> atomicResumeUrl;
  // This is the chunkSize closest to the request chunkSize which can be handled by the server.
  // It is not guaranteed that the chunkSize specified in the request will be the amount of data
  // to be uploaded each request. It depends on how granular the server is able to handle.
  private int optimalChunkSize;

  PhotosLibraryUploadCallable(
      UploadMediaItemRequest request,
      ClientContext clientContext,
      PhotosLibrarySettings photosLibrarySettings) {
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
    long initialMillis = clientContext.getClock().millisTime();
    // Gets upload url (resume url)
    String uploadUrl = getUploadUrl();
    this.atomicResumeUrl.set(uploadUrl);
    checkForTimeout(initialMillis);

    Optional<HttpResponse> response = Optional.empty();
    RetrySettings retrySettings =
        photosLibrarySettings.uploadMediaItemSettings().getRetrySettings();

    // There is no error by default
    boolean successful = false;
    int retries = 0;
    OptionalLong previousDelayMillis = OptionalLong.empty();

    while (!successful
        && (retrySettings.getMaxAttempts() == UNLIMITED_RETRIES
            || retries < retrySettings.getMaxAttempts())) {
      retries++;
      // Keeps uploading bytes from the request media item by chunk
      long receivedByteCount = getReceivedByteCount(uploadUrl);
      // Moves the cursor to the correct position and reset failure indicator
      // before starting/resuming an upload
      request.seekCursor(receivedByteCount);
      successful = true;

      while (receivedByteCount < request.getFileSize()) {
        // Uploads the next chunk
        response = Optional.of(uploadNextChunk(uploadUrl, receivedByteCount));
        checkForTimeout(initialMillis);

        if (!isStatusOk(response.get().getStatusLine().getStatusCode())) {
          successful = false;
          break;
        }

        // Verifies the amount of data that has been received
        receivedByteCount = getReceivedByteCount(uploadUrl);
        checkForTimeout(initialMillis);
      }

      // There are some failures while uploading the media item and maxAttempts
      // has not been exceeded
      if (!successful && retries < retrySettings.getMaxAttempts()) {
        // Calculates delay millis for the current retry
        long delayMillis = retrySettings.getInitialRetryDelay().get(MILLIS);
        if (previousDelayMillis.isPresent()) {
          delayMillis =
              (long) (previousDelayMillis.getAsLong() * retrySettings.getRetryDelayMultiplier());
        }
        // Calculates actual delay millis and randomizes the duration if necessary
        long actualDelayMillis =
            Math.min(delayMillis, retrySettings.getMaxRetryDelay().get(MILLIS));
        if (retrySettings.isJittered()) {
          actualDelayMillis = ThreadLocalRandom.current().nextLong(actualDelayMillis);
        }

        // Sleeps
        Thread.sleep(actualDelayMillis);
        checkForTimeout(initialMillis);

        // Update previousDelayMillis
        previousDelayMillis = OptionalLong.of(actualDelayMillis);
      }
    }

    if (!successful) {
      if (response.isPresent()) {
        throw new HttpResponseException(
            response.get().getStatusLine().getStatusCode(), ExceptionStrings.INVALID_UPLOAD_RESULT);
      } else {
        throw new IllegalStateException(ExceptionStrings.UNKNOWN_ERROR);
      }
    }

    // Builds an upload response from the final httpResponse
    return buildUploadMediaItemResponse(response);
  }

  private void checkForTimeout(long initialMillis) throws TimeoutException {
    if (photosLibrarySettings.uploadMediaItemSettings().getRetrySettings().getTotalTimeout()
        != UNLIMITED_TIMEOUT) {
      long duration = clientContext.getClock().millisTime() - initialMillis;
      if (duration
          > photosLibrarySettings
              .uploadMediaItemSettings()
              .getRetrySettings()
              .getTotalTimeout()
              .get(MILLIS)) {
        throw new TimeoutException(ExceptionStrings.UPLOAD_TIMED_OUT);
      }
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

    if (response.getFirstHeader(UPLOAD_GRANULARITY_HEADER) != null) {
      updateOptimalChunkSize(
          Integer.parseInt(response.getFirstHeader(UPLOAD_GRANULARITY_HEADER).getValue()));
    }

    switch (response.getFirstHeader(UPLOAD_STATUS_HEADER).getValue()) {
      case UploadStatuses.ACTIVE:
        return response.getFirstHeader(UPLOAD_URL_HEADER).getValue();
      case UploadStatuses.FINAL:
        throw new IllegalArgumentException(ExceptionStrings.UPLOAD_URL_REJECTED);
      default:
        throw new IllegalStateException(ExceptionStrings.INVALID_UPLOAD_STATUS);
    }
  }

  /** Gets the number of bytes the server has received. */
  private long getReceivedByteCount(String uploadUrl) throws IOException {
    HttpPost httpPost = createAuthenticatedPostRequest(uploadUrl);
    httpPost.addHeader(UPLOAD_PROTOCOL_HEADER, UPLOAD_PROTOCOL_VALUE);
    httpPost.addHeader(UPLOAD_COMMAND_HEADER, UploadCommands.QUERY);

    CloseableHttpClient httpClient = HttpClientBuilder.create().useSystemProperties().build();
    HttpResponse response = httpClient.execute(httpPost);

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
    if (photosLibrarySettings.uploadMediaItemSettings().getRetrySettings().getTotalTimeout()
        != UNLIMITED_TIMEOUT) {
      configBuilder.setConnectionRequestTimeout(
          Math.toIntExact(
              photosLibrarySettings
                  .uploadMediaItemSettings()
                  .getRetrySettings()
                  .getTotalTimeout()
                  .get(MILLIS)));
    }
    return configBuilder.build();
  }

  private UploadMediaItemResponse buildUploadMediaItemResponse(Optional<HttpResponse> response)
      throws IOException {
    if (!response.isPresent() || !isStatusOk(response.get().getStatusLine().getStatusCode())) {
      throw new IllegalArgumentException(ExceptionStrings.INVALID_UPLOAD_RESULT);
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
