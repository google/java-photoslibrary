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
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeCallContext;
import io.grpc.Status;
import java.io.RandomAccessFile;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/** Tests for {@link UploadRetryCallable}. */
@RunWith(JUnit4.class)
public class UploadRetryCallableTest {

  private UnaryCallable<UploadMediaItemRequest, UploadMediaItemResponse> internalCall =
      Mockito.mock(UnaryCallable.class);
  private ApiCallContext apiCallContext;
  private ClientContext clientContext;
  private UnaryCallSettings<UploadMediaItemRequest, UploadMediaItemResponse> settings;

  /** Set up a test by initializing the contexts and settings. */
  @Before
  public void initializeContexts() {
    apiCallContext = FakeCallContext.createDefault();
    clientContext =
        ClientContext.newBuilder()
            .setDefaultCallContext(apiCallContext)
            .setExecutor(Executors.newSingleThreadScheduledExecutor())
            .build();
    settings =
        UnaryCallSettings
            .<UploadMediaItemRequest, UploadMediaItemResponse>newUnaryCallSettingsBuilder()
            .setRetryableCodes(StatusCode.Code.UNAVAILABLE)
            .setRetrySettings(RetrySettings.newBuilder().build())
            .build();
  }

  /**
   * Tests that the upload URL is not changed if a {@link UploadRetryCallable} is called multiple
   * times for successful uploads.
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void repeatedSuccessfulUploads_useOriginalUrl()
      throws InterruptedException, ExecutionException {

    UploadMediaItemRequest request = getRequest();
    final String uploadUrl = request.getUploadUrl().get();

    UploadMediaItemResponse response = UploadMediaItemResponse.newBuilder().build();

    // Capture the request passed into the inner callable.
    ArgumentCaptor<UploadMediaItemRequest> argumentCaptor =
        ArgumentCaptor.forClass(UploadMediaItemRequest.class);
    Mockito.when(internalCall.futureCall(argumentCaptor.capture(), (ApiCallContext) Mockito.any()))
        .thenReturn(ApiFutures.immediateFuture(response));

    UploadRetryCallable retryCallable = new UploadRetryCallable(internalCall, clientContext);

    ApiFuture<UploadMediaItemResponse> r = retryCallable.futureCall(request, apiCallContext);
    UploadMediaItemResponse actualResponse = r.get();
    assertEquals(response, actualResponse);

    // Confirm that the upload URL has not changed for the first call.
    Optional<String> actualUploadUrl = argumentCaptor.getValue().getUploadUrl();
    assertTrue(actualUploadUrl.isPresent());
    assertEquals(uploadUrl, actualUploadUrl.get());

    // Make a second call.
    r = retryCallable.futureCall(request, apiCallContext);
    actualResponse = r.get();
    assertEquals(response, actualResponse);

    // Confirm that the upload URL has not changed for the second call.
    actualUploadUrl = argumentCaptor.getValue().getUploadUrl();
    assertTrue(actualUploadUrl.isPresent());
    assertEquals(uploadUrl, actualUploadUrl.get());
  }

  /**
   * Tests that the calling the same {@link UploadRetryCallable} object for different
   * UploadMediaItemRequests throws an {@link IllegalArgumentException}.
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void differentUploadRequests_throwsException()
      throws InterruptedException, ExecutionException {

    // Fully populated request.
    UploadMediaItemRequest firstRequest = getRequest();
    // Empty request that is not equal to the first request.
    UploadMediaItemRequest secondRequest = UploadMediaItemRequest.newBuilder().build();

    // Set up the internal callable with a successful response.
    UploadMediaItemResponse response = UploadMediaItemResponse.newBuilder().build();
    Mockito.when(internalCall.futureCall(Mockito.any(), Mockito.any()))
        .thenReturn(ApiFutures.immediateFuture(response));

    UploadRetryCallable retryCallable = new UploadRetryCallable(internalCall, clientContext);
    // First call succeeds
    ApiFuture<UploadMediaItemResponse> r = retryCallable.futureCall(firstRequest, apiCallContext);
    r.get();

    // Reusing the same UploadRetryCallable object for a different request throws an exception.
    assertThrows(
        IllegalArgumentException.class,
        () -> retryCallable.futureCall(secondRequest, apiCallContext));
  }

  /**
   * Tests that even when an {@link ApiException} is thrown all calls use the same upload URL.
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void uploadExceptionWithoutResumeUrl_originalUrlUsedforRetry()
      throws InterruptedException, ExecutionException {

    UploadMediaItemRequest request = getRequest();
    final String uploadUrl = request.getUploadUrl().get();

    UploadMediaItemResponse response = UploadMediaItemResponse.newBuilder().build();

    // Exception to return when the second call fails.
    ApiException exception =
        new ApiException(
            "API Exception",
            new RuntimeException(),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true);

    // Capture the request passed into the inner callable.
    ArgumentCaptor<UploadMediaItemRequest> argumentCaptor =
        ArgumentCaptor.forClass(UploadMediaItemRequest.class);
    Mockito.when(internalCall.futureCall(argumentCaptor.capture(), (ApiCallContext) Mockito.any()))
        // The first call fails.
        .thenReturn(ApiFutures.immediateFailedFuture(exception))
        // Second call completes.
        .thenReturn(ApiFutures.immediateFuture(response));

    UploadRetryCallable retryCallable = new UploadRetryCallable(internalCall, clientContext);

    ApiFuture<UploadMediaItemResponse> firstCall =
        retryCallable.futureCall(request, apiCallContext);
    // The first call should throw an exception that is caused by the ApiException.
    Throwable t = assertThrows(Exception.class, firstCall::get);
    assertEquals(ApiException.class, t.getCause().getClass());

    // Call the callable again and load its result.
    ApiFuture<UploadMediaItemResponse> secondCall =
        retryCallable.futureCall(request, apiCallContext);
    secondCall.get();

    // Get the upload URL used in the request.
    Optional<String> actualUploadUrl = argumentCaptor.getValue().getUploadUrl();
    assertTrue(actualUploadUrl.isPresent());
    assertEquals(uploadUrl, actualUploadUrl.get());
  }

  /**
   * Tests that when an {@link UploadApiException} is thrown that contains a resume URL, subsequent
   * calls use the new resume URL.
   *
   * @throws InterruptedException
   * @throws ExecutionException
   */
  @Test
  public void uploadExceptionWithResumeUrl_newUrlUsedforRetry()
      throws InterruptedException, ExecutionException {

    UploadMediaItemRequest request = getRequest();
    UploadMediaItemResponse response = UploadMediaItemResponse.newBuilder().build();

    // Exception to return when the second call fails.
    final String newUploadUrl = "new upload URL";
    UploadApiException exception =
        new UploadApiException(
            "upload exception",
            new Exception(),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true,
            newUploadUrl);

    // Capture the request passed into the inner callable.
    ArgumentCaptor<UploadMediaItemRequest> argumentCaptor =
        ArgumentCaptor.forClass(UploadMediaItemRequest.class);
    Mockito.when(internalCall.futureCall(argumentCaptor.capture(), (ApiCallContext) Mockito.any()))
        // The first call fails.
        .thenReturn(ApiFutures.immediateFailedFuture(exception))
        // Second call completes.
        .thenReturn(ApiFutures.immediateFuture(response));

    UploadRetryCallable retryCallable = new UploadRetryCallable(internalCall, clientContext);

    ApiFuture<UploadMediaItemResponse> call = retryCallable.futureCall(request, apiCallContext);
    // Get the result from the Future.
    Throwable throwable = assertThrows(Exception.class, call::get);

    // The first call should throw an exception that is caused by the UploadApiException.
    assertNotNull(throwable);
    assertTrue(throwable.getCause() instanceof UploadApiException);

    // Call the callable again, this time the URL in the request should have been updated.
    call = retryCallable.futureCall(request, apiCallContext);
    call.get();

    // Get the upload URL used in the request.
    Optional<String> actualUploadUrl = argumentCaptor.getValue().getUploadUrl();
    assertTrue(actualUploadUrl.isPresent());
    assertEquals(newUploadUrl, actualUploadUrl.get());
  }

  /**
   * Creates a new {@link UploadMediaItemRequest} that contains all possible fields, including a
   * mock {@link RandomAccessFile}.
   *
   * @return New {@link UploadMediaItemRequest}
   */
  private static UploadMediaItemRequest getRequest() {

    String fileName = "myFile.jpg";
    String mimeType = "image/jpg";
    String uploadUrl = "defaultUploadUrl";
    int chunkSize = 1000;
    RandomAccessFile randomAccessFile = mock(RandomAccessFile.class);

    return UploadMediaItemRequest.newBuilder()
        .setFileName(fileName)
        .setMimeType(mimeType)
        .setUploadUrl(uploadUrl)
        .setChunkSize(chunkSize)
        .setDataFile(randomAccessFile)
        .build();
  }
}
