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

package com.google.photos.library.v1.upload;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mock;

import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.auth.Credentials;
import com.google.photos.library.v1.PhotosLibrarySettings;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HttpClientBuilder.class)
public class PhotosLibraryUploadCallableTest {

  @Rule public TemporaryFolder tempFolder = new TemporaryFolder();

  private final String authorizationValue = "auth-token";
  private final URI successfulUploadUrl =
      URI.create("http://google.com/photosUpload?parameter=yes");
  public final int successfulUploadChunkSize = 10;
  public final String successfulUploadToken = "Upload Token";

  private ClientContext clientContext;
  private UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> settings;
  private UploadMediaItemRequest uploadRequest;
  private PhotosLibraryUploadCallable callable;
  private CloseableHttpClient httpClient;

  @Before
  public void setUp() throws IOException {
    // Mock HttpClient and Builder
    HttpClientBuilder httpClientBuilder = PowerMockito.mock(HttpClientBuilder.class);
    PowerMockito.mockStatic(HttpClientBuilder.class);
    when(HttpClientBuilder.create())
        .thenAnswer((Answer<HttpClientBuilder>) invocation -> httpClientBuilder);
    when(httpClientBuilder.useSystemProperties()).thenReturn(httpClientBuilder);
    when(httpClientBuilder.setDefaultRequestConfig(any())).thenReturn(httpClientBuilder);
    httpClient = mock(CloseableHttpClient.class);
    when(httpClientBuilder.build()).thenReturn(httpClient);

    Credentials credentials = mock(Credentials.class);
    when(credentials.getRequestMetadata())
        .thenReturn(Map.of("Authorization", List.of(authorizationValue)));

    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(FakeCallContext.createDefault())
            .setExecutor(Executors.newSingleThreadScheduledExecutor())
            .setCredentials(credentials)
            .build();

    UnaryCallSettings.Builder<UploadMediaItemRequest, UploadMediaItemResponse>
        uploadSettingsBuilder =
            PhotosLibrarySettings.Builder.createDefault().uploadMediaItemSettingsBuilder();
    settings = uploadSettingsBuilder.build();

    // Create a temporary file and write content to it.
    File file = tempFolder.newFile();
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write("This is a test file");
    writer.close();

    uploadRequest =
        UploadMediaItemRequest.newBuilder()
            .setDataFile(new RandomAccessFile(file, "r"))
            .setChunkSize(5)
            .setMimeType("image/jpg")
            .build();

    callable = new PhotosLibraryUploadCallable(uploadRequest, clientContext, settings);
  }

  @Test
  public void emptyFileThrowsException() throws IOException {
    // Create an empty temporary file and open it for reading.
    RandomAccessFile emptyFile = new RandomAccessFile(tempFolder.newFile(), "r");
    UploadMediaItemRequest request =
        UploadMediaItemRequest.newBuilder().setDataFile(emptyFile).build();

    PhotosLibraryUploadCallable callable =
        new PhotosLibraryUploadCallable(request, clientContext, settings);

    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, callable::call);
    assertEquals("The file is empty.", e.getMessage());
  }

  @Test
  public void invalidStatusCodeAtGetUploadUrlThrowsException() throws IOException {
    int statusCode = 500;
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 1.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(errorResponse /* get upload url */);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown when getting URL",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusCodeAtGetUploadedBytesThrowsException() throws IOException {
    int statusCode = 500;
    CloseableHttpResponse[] successResponses = createMockUploadFlow();
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 2.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            successResponses[0] /* get upload url */, errorResponse /* get uploaded bytes */);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown when getting uploaded bytes",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusCodeAtByteUploadThrowsException() throws IOException {
    int statusCode = 500;
    CloseableHttpResponse[] successResponses = createMockUploadFlow();
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 3.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            successResponses[0] /* get upload url */,
            successResponses[1] /* get uploaded bytes */,
            errorResponse /* first byte upload */);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown at first byte upload",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusCodeAtGetUploadedBytesAfterUploadThrowsException() throws IOException {
    int statusCode = 500;
    CloseableHttpResponse[] successResponses = createMockUploadFlow();
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 4.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            successResponses[0] /* get upload url */,
            successResponses[1] /* get uploaded bytes */,
            successResponses[2] /* first byte upload */,
            errorResponse /* get uploaded bytes*/);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown when getting uploaded bytes after first upload",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusCodeAtFinalByteUploadThrowsException() throws IOException {
    int statusCode = 500;
    CloseableHttpResponse[] successResponses = createMockUploadFlow();
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 5.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            successResponses[0] /* get upload url */,
            successResponses[1] /* get uploaded bytes */,
            successResponses[2] /* first byte upload */,
            successResponses[3] /* get uploaded bytes*/,
            errorResponse /* final byte upload */);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown at final byte upload",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusCodeAtGetUploadedBytesAfterFinalByteUploadThrowsException()
      throws IOException {
    int statusCode = 500;
    CloseableHttpResponse[] successResponses = createMockUploadFlow();
    CloseableHttpResponse errorResponse = createMockHttpResponse(statusCode);

    // Failure at request 6.
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            successResponses[0] /* get upload url */,
            successResponses[1] /* get uploaded bytes */,
            successResponses[2] /* first byte upload */,
            successResponses[3] /* get uploaded bytes*/,
            successResponses[4] /* final byte upload */,
            errorResponse /* get uploaded bytes*/);
    HttpResponseException exception =
        assertThrows(
            "HttpResponseException thrown when getting uploaded bytes after final upload",
            HttpResponseException.class,
            callable::call);
    assertEquals(statusCode, exception.getStatusCode());
  }

  @Test
  public void invalidStatusHeaderThrowsException() throws IOException {
    CloseableHttpResponse response = createMockHttpResponse(200);
    when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(response);

    mockHeaderResponse(response, "X-Goog-Upload-Status", "InvalidStatus");

    IllegalStateException e = assertThrows(IllegalStateException.class, callable::call);
    assertEquals(ExceptionStrings.INVALID_UPLOAD_STATUS, e.getMessage());
  }

  @Test
  public void noStatusHeaderThrowsException() throws IOException {
    CloseableHttpResponse emptyResponse = createMockHttpResponse(200);
    when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(emptyResponse);

    IllegalStateException e = assertThrows(IllegalStateException.class, callable::call);
    assertEquals(ExceptionStrings.INVALID_UPLOAD_STATUS, e.getMessage());
  }

  @Test
  public void successfulUpload() throws Exception {
    final int fileSize = Math.toIntExact(uploadRequest.getFileSize());

    // Queue up all responses.
    CloseableHttpResponse[] responses = createMockUploadFlow();
    when(httpClient.execute(any(HttpUriRequest.class)))
        .thenReturn(
            responses[0], responses[1], responses[2], responses[3], responses[4], responses[5]);

    // Capture all HTTP requests and execute the call.
    ArgumentCaptor<HttpPost> urlCaptor = ArgumentCaptor.forClass(HttpPost.class);
    UploadMediaItemResponse response = callable.call();

    // Confirm that all requests contain the necessary details
    verify(httpClient, times(6)).execute(urlCaptor.capture());
    List<HttpPost> requests = urlCaptor.getAllValues();

    // Request 1: Get Upload URL.
    HttpPost request = requests.get(0);
    assertHeaderEquals(request, "X-Goog-Upload-Command", "start");
    assertHeaderEquals(request, "X-Goog-Upload-Protocol", "resumable");
    assertHeaderEquals(request, "X-Goog-Upload-Content-Type", uploadRequest.getMimeType().get());
    assertHeaderEquals(request, "X-Goog-Upload-Raw-Size", String.valueOf(fileSize));
    assertHeaderEquals(request, "Authorization", authorizationValue);

    // Request 2: Get uploaded bytes.
    request = requests.get(1);
    assertEquals(successfulUploadUrl, request.getURI());
    assertHeaderEquals(request, "X-Goog-Upload-Command", "query");

    // Request 3: Upload the first chunk of bytes
    request = requests.get(2);
    assertEquals(successfulUploadUrl, request.getURI());
    assertHeaderEquals(request, "X-Goog-Upload-Command", "upload");
    assertHeaderEquals(request, "X-Goog-Upload-Offset", "0");
    assertEquals(successfulUploadChunkSize, request.getEntity().getContentLength());

    // Request 4: Get uploaded bytes.
    request = requests.get(3);
    assertEquals(successfulUploadUrl, request.getURI());
    assertHeaderEquals(request, "X-Goog-Upload-Command", "query");

    // Request 5: Final chunk upload.
    request = requests.get(4);
    assertEquals(successfulUploadUrl, request.getURI());
    assertHeaderEquals(request, "X-Goog-Upload-Command", "upload,finalize");
    assertHeaderEquals(request, "X-Goog-Upload-Offset", String.valueOf(successfulUploadChunkSize));

    // First request uploaded the first chunk, confirm that the remaining bytes were uploaded.
    assertEquals(fileSize - successfulUploadChunkSize, request.getEntity().getContentLength());

    // Request 6: Get uploaded bytes.
    request = requests.get(5);
    assertEquals(successfulUploadUrl, request.getURI());
    assertHeaderEquals(request, "X-Goog-Upload-Command", "query");

    assertEquals(successfulUploadToken, response.getUploadToken().get());
  }

  /**
   * Create a sequence of mock {@link CloseableHttpResponse}s that show a successful upload flow.
   */
  private CloseableHttpResponse[] createMockUploadFlow() throws IOException {
    // The upload is done in 5 requests. It's expected that bytes are split up into 2 requests,
    // based on the chunk size configured in the request and returned here.
    List<CloseableHttpResponse> list = new ArrayList<>(6);

    // Request 1: Get Upload URL.
    CloseableHttpResponse response = createMockHttpResponse(200);
    mockHeaderResponse(response, "X-Goog-Upload-Status", "active");
    mockHeaderResponse(response, "X-Goog-Upload-URL", successfulUploadUrl.toString());
    mockHeaderResponse(
        response, "X-Goog-Upload-Chunk-Granularity", Integer.toString(successfulUploadChunkSize));
    list.add(response);

    // Request 2: Get uploaded bytes.
    response = createMockHttpResponse(200);
    mockHeaderResponse(response, "X-Goog-Upload-Status", "active");
    mockHeaderResponse(response, "X-Goog-Upload-Size-Received", Integer.toString(0));
    list.add(response);

    // Request 3: Upload of the first chunk
    response = createMockHttpResponse(200);
    list.add(response);

    // Request 4: Get uploaded bytes.
    response = createMockHttpResponse(200);
    mockHeaderResponse(response, "X-Goog-Upload-Status", "active");
    mockHeaderResponse(
        response, "X-Goog-Upload-Size-Received", Integer.toString(successfulUploadChunkSize));
    list.add(response);

    // Request 5: Upload of the final chunk
    response = createMockHttpResponse(200);
    BasicHttpEntity uploadTokenEntity = new BasicHttpEntity();
    uploadTokenEntity.setContent(new ByteArrayInputStream(successfulUploadToken.getBytes()));
    when(response.getEntity()).thenReturn(uploadTokenEntity);
    list.add(response);

    // Request 6: Get uploaded bytes after upload has completed.
    response = createMockHttpResponse(200);
    mockHeaderResponse(response, "X-Goog-Upload-Status", "final");
    mockHeaderResponse(
        response, "X-Goog-Upload-Size-Received", String.valueOf(uploadRequest.getFileSize()));
    list.add(response);

    return list.toArray(new CloseableHttpResponse[0]);
  }

  private static void assertHeaderEquals(
      HttpPost request, String headerName, String expectedValue) {
    assertTrue("Header is missing in request: " + headerName, request.containsHeader(headerName));
    assertEquals(expectedValue, request.getFirstHeader(headerName).getValue());
  }

  /** Mocks access to the given header to return a value. */
  private static void mockHeaderResponse(
      CloseableHttpResponse response, String headerName, String headerValue) {
    Header header = new BasicHeader(headerName, headerValue);
    when(response.getFirstHeader(headerName)).thenReturn(header);
    when(response.getLastHeader(headerName)).thenReturn(header);
    when(response.getHeaders(headerName)).thenReturn(new Header[] {header});
  }

  /** Create a mock {@link CloseableHttpResponse} that contains a HTTP status code. */
  private static CloseableHttpResponse createMockHttpResponse(int httpStatusCode) {
    CloseableHttpResponse response = mock(CloseableHttpResponse.class);
    StatusLine status = mock(StatusLine.class);
    when(status.getStatusCode()).thenReturn(httpStatusCode);
    when(response.getStatusLine()).thenReturn(status);
    return response;
  }
}
