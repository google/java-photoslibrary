package com.google.photos.library.v1.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Service which allows developers to perform the following actions on behalf of
 * the user:
 * - upload media items directly to their Google Photos library
 * - create albums
 * - add media items (including album enrichments) to albums
 * - list and download content from their Google Photos library
 * - filter results by media type, date range or content category
 * - create, join, and access shared albums
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/photos/library/v1/photos_library.proto")
public final class PhotosLibraryGrpc {

  private PhotosLibraryGrpc() {}

  public static final String SERVICE_NAME = "google.photos.library.v1.PhotosLibrary";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      METHOD_CREATE_ALBUM = getCreateAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      getCreateAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      getCreateAlbumMethod() {
    return getCreateAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      getCreateAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.CreateAlbumRequest,
            com.google.photos.types.proto.Album>
        getCreateAlbumMethod;
    if ((getCreateAlbumMethod = PhotosLibraryGrpc.getCreateAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getCreateAlbumMethod = PhotosLibraryGrpc.getCreateAlbumMethod) == null) {
          PhotosLibraryGrpc.getCreateAlbumMethod =
              getCreateAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.CreateAlbumRequest,
                          com.google.photos.types.proto.Album>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "CreateAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.CreateAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.Album.getDefaultInstance()))
                      .setSchemaDescriptor(new PhotosLibraryMethodDescriptorSupplier("CreateAlbum"))
                      .build();
        }
      }
    }
    return getCreateAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchCreateMediaItemsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      METHOD_BATCH_CREATE_MEDIA_ITEMS = getBatchCreateMediaItemsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      getBatchCreateMediaItemsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      getBatchCreateMediaItemsMethod() {
    return getBatchCreateMediaItemsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      getBatchCreateMediaItemsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
            com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
        getBatchCreateMediaItemsMethod;
    if ((getBatchCreateMediaItemsMethod = PhotosLibraryGrpc.getBatchCreateMediaItemsMethod)
        == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getBatchCreateMediaItemsMethod = PhotosLibraryGrpc.getBatchCreateMediaItemsMethod)
            == null) {
          PhotosLibraryGrpc.getBatchCreateMediaItemsMethod =
              getBatchCreateMediaItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
                          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "BatchCreateMediaItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("BatchCreateMediaItems"))
                      .build();
        }
      }
    }
    return getBatchCreateMediaItemsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchAddMediaItemsToAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      METHOD_BATCH_ADD_MEDIA_ITEMS_TO_ALBUM = getBatchAddMediaItemsToAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      getBatchAddMediaItemsToAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      getBatchAddMediaItemsToAlbumMethod() {
    return getBatchAddMediaItemsToAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      getBatchAddMediaItemsToAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
            com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
        getBatchAddMediaItemsToAlbumMethod;
    if ((getBatchAddMediaItemsToAlbumMethod = PhotosLibraryGrpc.getBatchAddMediaItemsToAlbumMethod)
        == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getBatchAddMediaItemsToAlbumMethod =
                PhotosLibraryGrpc.getBatchAddMediaItemsToAlbumMethod)
            == null) {
          PhotosLibraryGrpc.getBatchAddMediaItemsToAlbumMethod =
              getBatchAddMediaItemsToAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
                          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary",
                              "BatchAddMediaItemsToAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("BatchAddMediaItemsToAlbum"))
                      .build();
        }
      }
    }
    return getBatchAddMediaItemsToAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchMediaItemsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      METHOD_SEARCH_MEDIA_ITEMS = getSearchMediaItemsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      getSearchMediaItemsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      getSearchMediaItemsMethod() {
    return getSearchMediaItemsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      getSearchMediaItemsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.SearchMediaItemsRequest,
            com.google.photos.library.v1.proto.SearchMediaItemsResponse>
        getSearchMediaItemsMethod;
    if ((getSearchMediaItemsMethod = PhotosLibraryGrpc.getSearchMediaItemsMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getSearchMediaItemsMethod = PhotosLibraryGrpc.getSearchMediaItemsMethod) == null) {
          PhotosLibraryGrpc.getSearchMediaItemsMethod =
              getSearchMediaItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.SearchMediaItemsRequest,
                          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "SearchMediaItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.SearchMediaItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.SearchMediaItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("SearchMediaItems"))
                      .build();
        }
      }
    }
    return getSearchMediaItemsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListMediaItemsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      METHOD_LIST_MEDIA_ITEMS = getListMediaItemsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      getListMediaItemsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      getListMediaItemsMethod() {
    return getListMediaItemsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      getListMediaItemsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.ListMediaItemsRequest,
            com.google.photos.library.v1.proto.ListMediaItemsResponse>
        getListMediaItemsMethod;
    if ((getListMediaItemsMethod = PhotosLibraryGrpc.getListMediaItemsMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getListMediaItemsMethod = PhotosLibraryGrpc.getListMediaItemsMethod) == null) {
          PhotosLibraryGrpc.getListMediaItemsMethod =
              getListMediaItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.ListMediaItemsRequest,
                          com.google.photos.library.v1.proto.ListMediaItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "ListMediaItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListMediaItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListMediaItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("ListMediaItems"))
                      .build();
        }
      }
    }
    return getListMediaItemsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMediaItemMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      METHOD_GET_MEDIA_ITEM = getGetMediaItemMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getGetMediaItemMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getGetMediaItemMethod() {
    return getGetMediaItemMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getGetMediaItemMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.GetMediaItemRequest,
            com.google.photos.types.proto.MediaItem>
        getGetMediaItemMethod;
    if ((getGetMediaItemMethod = PhotosLibraryGrpc.getGetMediaItemMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getGetMediaItemMethod = PhotosLibraryGrpc.getGetMediaItemMethod) == null) {
          PhotosLibraryGrpc.getGetMediaItemMethod =
              getGetMediaItemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.GetMediaItemRequest,
                          com.google.photos.types.proto.MediaItem>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "GetMediaItem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.GetMediaItemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.MediaItem.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("GetMediaItem"))
                      .build();
        }
      }
    }
    return getGetMediaItemMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchGetMediaItemsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      METHOD_BATCH_GET_MEDIA_ITEMS = getBatchGetMediaItemsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      getBatchGetMediaItemsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      getBatchGetMediaItemsMethod() {
    return getBatchGetMediaItemsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      getBatchGetMediaItemsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
            com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
        getBatchGetMediaItemsMethod;
    if ((getBatchGetMediaItemsMethod = PhotosLibraryGrpc.getBatchGetMediaItemsMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getBatchGetMediaItemsMethod = PhotosLibraryGrpc.getBatchGetMediaItemsMethod) == null) {
          PhotosLibraryGrpc.getBatchGetMediaItemsMethod =
              getBatchGetMediaItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
                          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "BatchGetMediaItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchGetMediaItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.BatchGetMediaItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("BatchGetMediaItems"))
                      .build();
        }
      }
    }
    return getBatchGetMediaItemsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAlbumsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      METHOD_LIST_ALBUMS = getListAlbumsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      getListAlbumsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      getListAlbumsMethod() {
    return getListAlbumsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      getListAlbumsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.ListAlbumsRequest,
            com.google.photos.library.v1.proto.ListAlbumsResponse>
        getListAlbumsMethod;
    if ((getListAlbumsMethod = PhotosLibraryGrpc.getListAlbumsMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getListAlbumsMethod = PhotosLibraryGrpc.getListAlbumsMethod) == null) {
          PhotosLibraryGrpc.getListAlbumsMethod =
              getListAlbumsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.ListAlbumsRequest,
                          com.google.photos.library.v1.proto.ListAlbumsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "ListAlbums"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListAlbumsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListAlbumsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new PhotosLibraryMethodDescriptorSupplier("ListAlbums"))
                      .build();
        }
      }
    }
    return getListAlbumsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      METHOD_GET_ALBUM = getGetAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      getGetAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      getGetAlbumMethod() {
    return getGetAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      getGetAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
        getGetAlbumMethod;
    if ((getGetAlbumMethod = PhotosLibraryGrpc.getGetAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getGetAlbumMethod = PhotosLibraryGrpc.getGetAlbumMethod) == null) {
          PhotosLibraryGrpc.getGetAlbumMethod =
              getGetAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.GetAlbumRequest,
                          com.google.photos.types.proto.Album>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "GetAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.GetAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.Album.getDefaultInstance()))
                      .setSchemaDescriptor(new PhotosLibraryMethodDescriptorSupplier("GetAlbum"))
                      .build();
        }
      }
    }
    return getGetAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSharedAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      METHOD_GET_SHARED_ALBUM = getGetSharedAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      getGetSharedAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      getGetSharedAlbumMethod() {
    return getGetSharedAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      getGetSharedAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.GetSharedAlbumRequest,
            com.google.photos.types.proto.Album>
        getGetSharedAlbumMethod;
    if ((getGetSharedAlbumMethod = PhotosLibraryGrpc.getGetSharedAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getGetSharedAlbumMethod = PhotosLibraryGrpc.getGetSharedAlbumMethod) == null) {
          PhotosLibraryGrpc.getGetSharedAlbumMethod =
              getGetSharedAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.GetSharedAlbumRequest,
                          com.google.photos.types.proto.Album>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "GetSharedAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.GetSharedAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.Album.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("GetSharedAlbum"))
                      .build();
        }
      }
    }
    return getGetSharedAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddEnrichmentToAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      METHOD_ADD_ENRICHMENT_TO_ALBUM = getAddEnrichmentToAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      getAddEnrichmentToAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      getAddEnrichmentToAlbumMethod() {
    return getAddEnrichmentToAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      getAddEnrichmentToAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
            com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
        getAddEnrichmentToAlbumMethod;
    if ((getAddEnrichmentToAlbumMethod = PhotosLibraryGrpc.getAddEnrichmentToAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getAddEnrichmentToAlbumMethod = PhotosLibraryGrpc.getAddEnrichmentToAlbumMethod)
            == null) {
          PhotosLibraryGrpc.getAddEnrichmentToAlbumMethod =
              getAddEnrichmentToAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
                          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "AddEnrichmentToAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("AddEnrichmentToAlbum"))
                      .build();
        }
      }
    }
    return getAddEnrichmentToAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getJoinSharedAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      METHOD_JOIN_SHARED_ALBUM = getJoinSharedAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      getJoinSharedAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      getJoinSharedAlbumMethod() {
    return getJoinSharedAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      getJoinSharedAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
            com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
        getJoinSharedAlbumMethod;
    if ((getJoinSharedAlbumMethod = PhotosLibraryGrpc.getJoinSharedAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getJoinSharedAlbumMethod = PhotosLibraryGrpc.getJoinSharedAlbumMethod) == null) {
          PhotosLibraryGrpc.getJoinSharedAlbumMethod =
              getJoinSharedAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
                          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "JoinSharedAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.JoinSharedAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.JoinSharedAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("JoinSharedAlbum"))
                      .build();
        }
      }
    }
    return getJoinSharedAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLeaveSharedAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      METHOD_LEAVE_SHARED_ALBUM = getLeaveSharedAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      getLeaveSharedAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      getLeaveSharedAlbumMethod() {
    return getLeaveSharedAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      getLeaveSharedAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
            com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
        getLeaveSharedAlbumMethod;
    if ((getLeaveSharedAlbumMethod = PhotosLibraryGrpc.getLeaveSharedAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getLeaveSharedAlbumMethod = PhotosLibraryGrpc.getLeaveSharedAlbumMethod) == null) {
          PhotosLibraryGrpc.getLeaveSharedAlbumMethod =
              getLeaveSharedAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
                          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "LeaveSharedAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.LeaveSharedAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.LeaveSharedAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("LeaveSharedAlbum"))
                      .build();
        }
      }
    }
    return getLeaveSharedAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getShareAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      METHOD_SHARE_ALBUM = getShareAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      getShareAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      getShareAlbumMethod() {
    return getShareAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      getShareAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.ShareAlbumRequest,
            com.google.photos.library.v1.proto.ShareAlbumResponse>
        getShareAlbumMethod;
    if ((getShareAlbumMethod = PhotosLibraryGrpc.getShareAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getShareAlbumMethod = PhotosLibraryGrpc.getShareAlbumMethod) == null) {
          PhotosLibraryGrpc.getShareAlbumMethod =
              getShareAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.ShareAlbumRequest,
                          com.google.photos.library.v1.proto.ShareAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "ShareAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ShareAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ShareAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new PhotosLibraryMethodDescriptorSupplier("ShareAlbum"))
                      .build();
        }
      }
    }
    return getShareAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSharedAlbumsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      METHOD_LIST_SHARED_ALBUMS = getListSharedAlbumsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      getListSharedAlbumsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      getListSharedAlbumsMethod() {
    return getListSharedAlbumsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      getListSharedAlbumsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
            com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
        getListSharedAlbumsMethod;
    if ((getListSharedAlbumsMethod = PhotosLibraryGrpc.getListSharedAlbumsMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getListSharedAlbumsMethod = PhotosLibraryGrpc.getListSharedAlbumsMethod) == null) {
          PhotosLibraryGrpc.getListSharedAlbumsMethod =
              getListSharedAlbumsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
                          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "ListSharedAlbums"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListSharedAlbumsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.ListSharedAlbumsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("ListSharedAlbums"))
                      .build();
        }
      }
    }
    return getListSharedAlbumsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUnshareAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      METHOD_UNSHARE_ALBUM = getUnshareAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      getUnshareAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      getUnshareAlbumMethod() {
    return getUnshareAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      getUnshareAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.UnshareAlbumRequest,
            com.google.photos.library.v1.proto.UnshareAlbumResponse>
        getUnshareAlbumMethod;
    if ((getUnshareAlbumMethod = PhotosLibraryGrpc.getUnshareAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getUnshareAlbumMethod = PhotosLibraryGrpc.getUnshareAlbumMethod) == null) {
          PhotosLibraryGrpc.getUnshareAlbumMethod =
              getUnshareAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.UnshareAlbumRequest,
                          com.google.photos.library.v1.proto.UnshareAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary", "UnshareAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.UnshareAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.UnshareAlbumResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("UnshareAlbum"))
                      .build();
        }
      }
    }
    return getUnshareAlbumMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBatchRemoveMediaItemsFromAlbumMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      METHOD_BATCH_REMOVE_MEDIA_ITEMS_FROM_ALBUM = getBatchRemoveMediaItemsFromAlbumMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      getBatchRemoveMediaItemsFromAlbumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      getBatchRemoveMediaItemsFromAlbumMethod() {
    return getBatchRemoveMediaItemsFromAlbumMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      getBatchRemoveMediaItemsFromAlbumMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
            com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
        getBatchRemoveMediaItemsFromAlbumMethod;
    if ((getBatchRemoveMediaItemsFromAlbumMethod =
            PhotosLibraryGrpc.getBatchRemoveMediaItemsFromAlbumMethod)
        == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getBatchRemoveMediaItemsFromAlbumMethod =
                PhotosLibraryGrpc.getBatchRemoveMediaItemsFromAlbumMethod)
            == null) {
          PhotosLibraryGrpc.getBatchRemoveMediaItemsFromAlbumMethod =
              getBatchRemoveMediaItemsFromAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
                          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.photos.library.v1.PhotosLibrary",
                              "BatchRemoveMediaItemsFromAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto
                                  .BatchRemoveMediaItemsFromAlbumRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto
                                  .BatchRemoveMediaItemsFromAlbumResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier(
                              "BatchRemoveMediaItemsFromAlbum"))
                      .build();
        }
      }
    }
    return getBatchRemoveMediaItemsFromAlbumMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PhotosLibraryStub newStub(io.grpc.Channel channel) {
    return new PhotosLibraryStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PhotosLibraryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new PhotosLibraryBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PhotosLibraryFutureStub newFutureStub(io.grpc.Channel channel) {
    return new PhotosLibraryFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Service which allows developers to perform the following actions on behalf of
   * the user:
   * - upload media items directly to their Google Photos library
   * - create albums
   * - add media items (including album enrichments) to albums
   * - list and download content from their Google Photos library
   * - filter results by media type, date range or content category
   * - create, join, and access shared albums
   * </pre>
   */
  public abstract static class PhotosLibraryImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an album in a user's Google Photos library.
     * </pre>
     */
    public void createAlbum(
        com.google.photos.library.v1.proto.CreateAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more media items in a user's Google Photos library.
     * This is the second step for creating a media item. For details regarding
     * Step 1, uploading the raw bytes to a Google Server, see
     * &lt;a href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
     * This call adds the media item to the library. If an album `id` is
     * specified, the call adds the media item to the album too. By default, the
     * media item will be added to the end of the library or album.
     * If an album `id` and position are both defined, the media item is
     * added to the album at the specified position.
     * If the call contains multiple media items, they're added at the specified
     * position.
     * If you are creating a media item in a shared album where you are not the
     * owner, you are not allowed to position the media item. Doing so will result
     * in a `BAD REQUEST` error.
     * </pre>
     */
    public void batchCreateMediaItems(
        com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateMediaItemsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more media items in a user's Google Photos library to
     * an album. The media items and albums must have been created by the
     * developer via the API.
     * Media items are added to the end of the album. If multiple media items are
     * given, they are added in the order specified in this call.
     * Only media items that are in the user's library can be added to an
     * album. For albums that are shared, the album must either be owned by the
     * user or the user must have joined the album as a collaborator.
     * Partial success is not supported. The entire request will fail if an
     * invalid media item or album is specified.
     * </pre>
     */
    public void batchAddMediaItemsToAlbum(
        com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchAddMediaItemsToAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for media items in a user's Google Photos library.
     * If no filters are set, then all media items in the user's library are
     * returned.
     * If an album is set, all media items in the specified album are returned.
     * If filters are specified, media items that match the filters from the
     * user's library are listed. If you set both the album and the filters, the
     * request results in an error.
     * </pre>
     */
    public void searchMediaItems(
        com.google.photos.library.v1.proto.SearchMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.SearchMediaItemsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchMediaItemsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all media items from a user's Google Photos library.
     * </pre>
     */
    public void listMediaItems(
        com.google.photos.library.v1.proto.ListMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListMediaItemsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListMediaItemsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the media item for the specified media item identifier.
     * </pre>
     */
    public void getMediaItem(
        com.google.photos.library.v1.proto.GetMediaItemRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMediaItemMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of media items for the specified media item identifiers.
     * Items are returned in the same order as the supplied identifiers.
     * </pre>
     */
    public void batchGetMediaItems(
        com.google.photos.library.v1.proto.BatchGetMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchGetMediaItemsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all albums shown to a user in the Albums tab of the Google
     * Photos app.
     * </pre>
     */
    public void listAlbums(
        com.google.photos.library.v1.proto.ListAlbumsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListAlbumsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAlbumsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `albumId`.
     * The `albumId` must be the ID of an album owned by the user or a shared
     * album that the user has joined.
     * </pre>
     */
    public void getAlbum(
        com.google.photos.library.v1.proto.GetAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `shareToken`.
     * </pre>
     */
    public void getSharedAlbum(
        com.google.photos.library.v1.proto.GetSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSharedAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an enrichment at a specified position in a defined album.
     * </pre>
     */
    public void addEnrichmentToAlbum(
        com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAddEnrichmentToAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Joins a shared album on behalf of the Google Photos user.
     * </pre>
     */
    public void joinSharedAlbum(
        com.google.photos.library.v1.proto.JoinSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getJoinSharedAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Leaves a previously-joined shared album on behalf of the Google Photos
     * user. The user must not own this album.
     * </pre>
     */
    public void leaveSharedAlbum(
        com.google.photos.library.v1.proto.LeaveSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getLeaveSharedAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks an album as shared and accessible to other users. This action can
     * only be performed on albums which were created by the developer via the
     * API.
     * </pre>
     */
    public void shareAlbum(
        com.google.photos.library.v1.proto.ShareAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ShareAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getShareAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all shared albums available in the Sharing tab of the
     * user's Google Photos app.
     * </pre>
     */
    public void listSharedAlbums(
        com.google.photos.library.v1.proto.ListSharedAlbumsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListSharedAlbumsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a previously shared album as private. This means that the album is
     * no longer shared and all the non-owners will lose access to the album. All
     * non-owner content will be removed from the album. If a non-owner has
     * previously added the album to their library, they will retain all photos in
     * their library. This action can only be performed on albums which were
     * created by the developer via the API.
     * </pre>
     */
    public void unshareAlbum(
        com.google.photos.library.v1.proto.UnshareAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.UnshareAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUnshareAlbumMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes one or more media items from a specified album. The media items and
     * the album must have been created by the developer via the API.
     * For albums that are shared, this action is only supported for media items
     * that were added to the album by this user, or for all media items if the
     * album was created by this user.
     * Partial success is not supported. The entire request will fail and no
     * action will be performed on the album if an invalid media item or album is
     * specified.
     * </pre>
     */
    public void batchRemoveMediaItemsFromAlbum(
        com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(
          getBatchRemoveMediaItemsFromAlbumMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.CreateAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_CREATE_ALBUM)))
          .addMethod(
              getBatchCreateMediaItemsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
                      com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>(
                      this, METHODID_BATCH_CREATE_MEDIA_ITEMS)))
          .addMethod(
              getBatchAddMediaItemsToAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
                      com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>(
                      this, METHODID_BATCH_ADD_MEDIA_ITEMS_TO_ALBUM)))
          .addMethod(
              getSearchMediaItemsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.SearchMediaItemsRequest,
                      com.google.photos.library.v1.proto.SearchMediaItemsResponse>(
                      this, METHODID_SEARCH_MEDIA_ITEMS)))
          .addMethod(
              getListMediaItemsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListMediaItemsRequest,
                      com.google.photos.library.v1.proto.ListMediaItemsResponse>(
                      this, METHODID_LIST_MEDIA_ITEMS)))
          .addMethod(
              getGetMediaItemMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetMediaItemRequest,
                      com.google.photos.types.proto.MediaItem>(this, METHODID_GET_MEDIA_ITEM)))
          .addMethod(
              getBatchGetMediaItemsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
                      com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>(
                      this, METHODID_BATCH_GET_MEDIA_ITEMS)))
          .addMethod(
              getListAlbumsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListAlbumsRequest,
                      com.google.photos.library.v1.proto.ListAlbumsResponse>(
                      this, METHODID_LIST_ALBUMS)))
          .addMethod(
              getGetAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_GET_ALBUM)))
          .addMethod(
              getGetSharedAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetSharedAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_GET_SHARED_ALBUM)))
          .addMethod(
              getAddEnrichmentToAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
                      com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>(
                      this, METHODID_ADD_ENRICHMENT_TO_ALBUM)))
          .addMethod(
              getJoinSharedAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
                      com.google.photos.library.v1.proto.JoinSharedAlbumResponse>(
                      this, METHODID_JOIN_SHARED_ALBUM)))
          .addMethod(
              getLeaveSharedAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
                      com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>(
                      this, METHODID_LEAVE_SHARED_ALBUM)))
          .addMethod(
              getShareAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ShareAlbumRequest,
                      com.google.photos.library.v1.proto.ShareAlbumResponse>(
                      this, METHODID_SHARE_ALBUM)))
          .addMethod(
              getListSharedAlbumsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
                      com.google.photos.library.v1.proto.ListSharedAlbumsResponse>(
                      this, METHODID_LIST_SHARED_ALBUMS)))
          .addMethod(
              getUnshareAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.UnshareAlbumRequest,
                      com.google.photos.library.v1.proto.UnshareAlbumResponse>(
                      this, METHODID_UNSHARE_ALBUM)))
          .addMethod(
              getBatchRemoveMediaItemsFromAlbumMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
                      com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>(
                      this, METHODID_BATCH_REMOVE_MEDIA_ITEMS_FROM_ALBUM)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service which allows developers to perform the following actions on behalf of
   * the user:
   * - upload media items directly to their Google Photos library
   * - create albums
   * - add media items (including album enrichments) to albums
   * - list and download content from their Google Photos library
   * - filter results by media type, date range or content category
   * - create, join, and access shared albums
   * </pre>
   */
  public static final class PhotosLibraryStub extends io.grpc.stub.AbstractStub<PhotosLibraryStub> {
    private PhotosLibraryStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhotosLibraryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhotosLibraryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhotosLibraryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an album in a user's Google Photos library.
     * </pre>
     */
    public void createAlbum(
        com.google.photos.library.v1.proto.CreateAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more media items in a user's Google Photos library.
     * This is the second step for creating a media item. For details regarding
     * Step 1, uploading the raw bytes to a Google Server, see
     * &lt;a href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
     * This call adds the media item to the library. If an album `id` is
     * specified, the call adds the media item to the album too. By default, the
     * media item will be added to the end of the library or album.
     * If an album `id` and position are both defined, the media item is
     * added to the album at the specified position.
     * If the call contains multiple media items, they're added at the specified
     * position.
     * If you are creating a media item in a shared album where you are not the
     * owner, you are not allowed to position the media item. Doing so will result
     * in a `BAD REQUEST` error.
     * </pre>
     */
    public void batchCreateMediaItems(
        com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateMediaItemsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more media items in a user's Google Photos library to
     * an album. The media items and albums must have been created by the
     * developer via the API.
     * Media items are added to the end of the album. If multiple media items are
     * given, they are added in the order specified in this call.
     * Only media items that are in the user's library can be added to an
     * album. For albums that are shared, the album must either be owned by the
     * user or the user must have joined the album as a collaborator.
     * Partial success is not supported. The entire request will fail if an
     * invalid media item or album is specified.
     * </pre>
     */
    public void batchAddMediaItemsToAlbum(
        com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchAddMediaItemsToAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for media items in a user's Google Photos library.
     * If no filters are set, then all media items in the user's library are
     * returned.
     * If an album is set, all media items in the specified album are returned.
     * If filters are specified, media items that match the filters from the
     * user's library are listed. If you set both the album and the filters, the
     * request results in an error.
     * </pre>
     */
    public void searchMediaItems(
        com.google.photos.library.v1.proto.SearchMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.SearchMediaItemsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchMediaItemsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all media items from a user's Google Photos library.
     * </pre>
     */
    public void listMediaItems(
        com.google.photos.library.v1.proto.ListMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListMediaItemsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMediaItemsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the media item for the specified media item identifier.
     * </pre>
     */
    public void getMediaItem(
        com.google.photos.library.v1.proto.GetMediaItemRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMediaItemMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of media items for the specified media item identifiers.
     * Items are returned in the same order as the supplied identifiers.
     * </pre>
     */
    public void batchGetMediaItems(
        com.google.photos.library.v1.proto.BatchGetMediaItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchGetMediaItemsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all albums shown to a user in the Albums tab of the Google
     * Photos app.
     * </pre>
     */
    public void listAlbums(
        com.google.photos.library.v1.proto.ListAlbumsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListAlbumsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAlbumsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `albumId`.
     * The `albumId` must be the ID of an album owned by the user or a shared
     * album that the user has joined.
     * </pre>
     */
    public void getAlbum(
        com.google.photos.library.v1.proto.GetAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `shareToken`.
     * </pre>
     */
    public void getSharedAlbum(
        com.google.photos.library.v1.proto.GetSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSharedAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an enrichment at a specified position in a defined album.
     * </pre>
     */
    public void addEnrichmentToAlbum(
        com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddEnrichmentToAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Joins a shared album on behalf of the Google Photos user.
     * </pre>
     */
    public void joinSharedAlbum(
        com.google.photos.library.v1.proto.JoinSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getJoinSharedAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Leaves a previously-joined shared album on behalf of the Google Photos
     * user. The user must not own this album.
     * </pre>
     */
    public void leaveSharedAlbum(
        com.google.photos.library.v1.proto.LeaveSharedAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaveSharedAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks an album as shared and accessible to other users. This action can
     * only be performed on albums which were created by the developer via the
     * API.
     * </pre>
     */
    public void shareAlbum(
        com.google.photos.library.v1.proto.ShareAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ShareAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getShareAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all shared albums available in the Sharing tab of the
     * user's Google Photos app.
     * </pre>
     */
    public void listSharedAlbums(
        com.google.photos.library.v1.proto.ListSharedAlbumsRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSharedAlbumsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a previously shared album as private. This means that the album is
     * no longer shared and all the non-owners will lose access to the album. All
     * non-owner content will be removed from the album. If a non-owner has
     * previously added the album to their library, they will retain all photos in
     * their library. This action can only be performed on albums which were
     * created by the developer via the API.
     * </pre>
     */
    public void unshareAlbum(
        com.google.photos.library.v1.proto.UnshareAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.UnshareAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnshareAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes one or more media items from a specified album. The media items and
     * the album must have been created by the developer via the API.
     * For albums that are shared, this action is only supported for media items
     * that were added to the album by this user, or for all media items if the
     * album was created by this user.
     * Partial success is not supported. The entire request will fail and no
     * action will be performed on the album if an invalid media item or album is
     * specified.
     * </pre>
     */
    public void batchRemoveMediaItemsFromAlbum(
        com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest request,
        io.grpc.stub.StreamObserver<
                com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchRemoveMediaItemsFromAlbumMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service which allows developers to perform the following actions on behalf of
   * the user:
   * - upload media items directly to their Google Photos library
   * - create albums
   * - add media items (including album enrichments) to albums
   * - list and download content from their Google Photos library
   * - filter results by media type, date range or content category
   * - create, join, and access shared albums
   * </pre>
   */
  public static final class PhotosLibraryBlockingStub
      extends io.grpc.stub.AbstractStub<PhotosLibraryBlockingStub> {
    private PhotosLibraryBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhotosLibraryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhotosLibraryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhotosLibraryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an album in a user's Google Photos library.
     * </pre>
     */
    public com.google.photos.types.proto.Album createAlbum(
        com.google.photos.library.v1.proto.CreateAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more media items in a user's Google Photos library.
     * This is the second step for creating a media item. For details regarding
     * Step 1, uploading the raw bytes to a Google Server, see
     * &lt;a href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
     * This call adds the media item to the library. If an album `id` is
     * specified, the call adds the media item to the album too. By default, the
     * media item will be added to the end of the library or album.
     * If an album `id` and position are both defined, the media item is
     * added to the album at the specified position.
     * If the call contains multiple media items, they're added at the specified
     * position.
     * If you are creating a media item in a shared album where you are not the
     * owner, you are not allowed to position the media item. Doing so will result
     * in a `BAD REQUEST` error.
     * </pre>
     */
    public com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse batchCreateMediaItems(
        com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateMediaItemsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more media items in a user's Google Photos library to
     * an album. The media items and albums must have been created by the
     * developer via the API.
     * Media items are added to the end of the album. If multiple media items are
     * given, they are added in the order specified in this call.
     * Only media items that are in the user's library can be added to an
     * album. For albums that are shared, the album must either be owned by the
     * user or the user must have joined the album as a collaborator.
     * Partial success is not supported. The entire request will fail if an
     * invalid media item or album is specified.
     * </pre>
     */
    public com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse
        batchAddMediaItemsToAlbum(
            com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchAddMediaItemsToAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for media items in a user's Google Photos library.
     * If no filters are set, then all media items in the user's library are
     * returned.
     * If an album is set, all media items in the specified album are returned.
     * If filters are specified, media items that match the filters from the
     * user's library are listed. If you set both the album and the filters, the
     * request results in an error.
     * </pre>
     */
    public com.google.photos.library.v1.proto.SearchMediaItemsResponse searchMediaItems(
        com.google.photos.library.v1.proto.SearchMediaItemsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchMediaItemsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all media items from a user's Google Photos library.
     * </pre>
     */
    public com.google.photos.library.v1.proto.ListMediaItemsResponse listMediaItems(
        com.google.photos.library.v1.proto.ListMediaItemsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMediaItemsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the media item for the specified media item identifier.
     * </pre>
     */
    public com.google.photos.types.proto.MediaItem getMediaItem(
        com.google.photos.library.v1.proto.GetMediaItemRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMediaItemMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of media items for the specified media item identifiers.
     * Items are returned in the same order as the supplied identifiers.
     * </pre>
     */
    public com.google.photos.library.v1.proto.BatchGetMediaItemsResponse batchGetMediaItems(
        com.google.photos.library.v1.proto.BatchGetMediaItemsRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchGetMediaItemsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all albums shown to a user in the Albums tab of the Google
     * Photos app.
     * </pre>
     */
    public com.google.photos.library.v1.proto.ListAlbumsResponse listAlbums(
        com.google.photos.library.v1.proto.ListAlbumsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAlbumsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `albumId`.
     * The `albumId` must be the ID of an album owned by the user or a shared
     * album that the user has joined.
     * </pre>
     */
    public com.google.photos.types.proto.Album getAlbum(
        com.google.photos.library.v1.proto.GetAlbumRequest request) {
      return blockingUnaryCall(getChannel(), getGetAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `shareToken`.
     * </pre>
     */
    public com.google.photos.types.proto.Album getSharedAlbum(
        com.google.photos.library.v1.proto.GetSharedAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSharedAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an enrichment at a specified position in a defined album.
     * </pre>
     */
    public com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse addEnrichmentToAlbum(
        com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddEnrichmentToAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Joins a shared album on behalf of the Google Photos user.
     * </pre>
     */
    public com.google.photos.library.v1.proto.JoinSharedAlbumResponse joinSharedAlbum(
        com.google.photos.library.v1.proto.JoinSharedAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getJoinSharedAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Leaves a previously-joined shared album on behalf of the Google Photos
     * user. The user must not own this album.
     * </pre>
     */
    public com.google.photos.library.v1.proto.LeaveSharedAlbumResponse leaveSharedAlbum(
        com.google.photos.library.v1.proto.LeaveSharedAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getLeaveSharedAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks an album as shared and accessible to other users. This action can
     * only be performed on albums which were created by the developer via the
     * API.
     * </pre>
     */
    public com.google.photos.library.v1.proto.ShareAlbumResponse shareAlbum(
        com.google.photos.library.v1.proto.ShareAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getShareAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all shared albums available in the Sharing tab of the
     * user's Google Photos app.
     * </pre>
     */
    public com.google.photos.library.v1.proto.ListSharedAlbumsResponse listSharedAlbums(
        com.google.photos.library.v1.proto.ListSharedAlbumsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSharedAlbumsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a previously shared album as private. This means that the album is
     * no longer shared and all the non-owners will lose access to the album. All
     * non-owner content will be removed from the album. If a non-owner has
     * previously added the album to their library, they will retain all photos in
     * their library. This action can only be performed on albums which were
     * created by the developer via the API.
     * </pre>
     */
    public com.google.photos.library.v1.proto.UnshareAlbumResponse unshareAlbum(
        com.google.photos.library.v1.proto.UnshareAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnshareAlbumMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes one or more media items from a specified album. The media items and
     * the album must have been created by the developer via the API.
     * For albums that are shared, this action is only supported for media items
     * that were added to the album by this user, or for all media items if the
     * album was created by this user.
     * Partial success is not supported. The entire request will fail and no
     * action will be performed on the album if an invalid media item or album is
     * specified.
     * </pre>
     */
    public com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse
        batchRemoveMediaItemsFromAlbum(
            com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchRemoveMediaItemsFromAlbumMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service which allows developers to perform the following actions on behalf of
   * the user:
   * - upload media items directly to their Google Photos library
   * - create albums
   * - add media items (including album enrichments) to albums
   * - list and download content from their Google Photos library
   * - filter results by media type, date range or content category
   * - create, join, and access shared albums
   * </pre>
   */
  public static final class PhotosLibraryFutureStub
      extends io.grpc.stub.AbstractStub<PhotosLibraryFutureStub> {
    private PhotosLibraryFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PhotosLibraryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhotosLibraryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhotosLibraryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an album in a user's Google Photos library.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.photos.types.proto.Album>
        createAlbum(com.google.photos.library.v1.proto.CreateAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates one or more media items in a user's Google Photos library.
     * This is the second step for creating a media item. For details regarding
     * Step 1, uploading the raw bytes to a Google Server, see
     * &lt;a href="/photos/library/guides/upload-media"&gt;Uploading media&lt;/a&gt;.
     * This call adds the media item to the library. If an album `id` is
     * specified, the call adds the media item to the album too. By default, the
     * media item will be added to the end of the library or album.
     * If an album `id` and position are both defined, the media item is
     * added to the album at the specified position.
     * If the call contains multiple media items, they're added at the specified
     * position.
     * If you are creating a media item in a shared album where you are not the
     * owner, you are not allowed to position the media item. Doing so will result
     * in a `BAD REQUEST` error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
        batchCreateMediaItems(
            com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateMediaItemsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more media items in a user's Google Photos library to
     * an album. The media items and albums must have been created by the
     * developer via the API.
     * Media items are added to the end of the album. If multiple media items are
     * given, they are added in the order specified in this call.
     * Only media items that are in the user's library can be added to an
     * album. For albums that are shared, the album must either be owned by the
     * user or the user must have joined the album as a collaborator.
     * Partial success is not supported. The entire request will fail if an
     * invalid media item or album is specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
        batchAddMediaItemsToAlbum(
            com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchAddMediaItemsToAlbumMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Searches for media items in a user's Google Photos library.
     * If no filters are set, then all media items in the user's library are
     * returned.
     * If an album is set, all media items in the specified album are returned.
     * If filters are specified, media items that match the filters from the
     * user's library are listed. If you set both the album and the filters, the
     * request results in an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.SearchMediaItemsResponse>
        searchMediaItems(com.google.photos.library.v1.proto.SearchMediaItemsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchMediaItemsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all media items from a user's Google Photos library.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.ListMediaItemsResponse>
        listMediaItems(com.google.photos.library.v1.proto.ListMediaItemsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMediaItemsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the media item for the specified media item identifier.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.types.proto.MediaItem>
        getMediaItem(com.google.photos.library.v1.proto.GetMediaItemRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMediaItemMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of media items for the specified media item identifiers.
     * Items are returned in the same order as the supplied identifiers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
        batchGetMediaItems(com.google.photos.library.v1.proto.BatchGetMediaItemsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchGetMediaItemsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all albums shown to a user in the Albums tab of the Google
     * Photos app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.ListAlbumsResponse>
        listAlbums(com.google.photos.library.v1.proto.ListAlbumsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAlbumsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `albumId`.
     * The `albumId` must be the ID of an album owned by the user or a shared
     * album that the user has joined.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.photos.types.proto.Album>
        getAlbum(com.google.photos.library.v1.proto.GetAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the album based on the specified `shareToken`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.photos.types.proto.Album>
        getSharedAlbum(com.google.photos.library.v1.proto.GetSharedAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSharedAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an enrichment at a specified position in a defined album.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
        addEnrichmentToAlbum(
            com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddEnrichmentToAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Joins a shared album on behalf of the Google Photos user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
        joinSharedAlbum(com.google.photos.library.v1.proto.JoinSharedAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getJoinSharedAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Leaves a previously-joined shared album on behalf of the Google Photos
     * user. The user must not own this album.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
        leaveSharedAlbum(com.google.photos.library.v1.proto.LeaveSharedAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaveSharedAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks an album as shared and accessible to other users. This action can
     * only be performed on albums which were created by the developer via the
     * API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.ShareAlbumResponse>
        shareAlbum(com.google.photos.library.v1.proto.ShareAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getShareAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all shared albums available in the Sharing tab of the
     * user's Google Photos app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
        listSharedAlbums(com.google.photos.library.v1.proto.ListSharedAlbumsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSharedAlbumsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a previously shared album as private. This means that the album is
     * no longer shared and all the non-owners will lose access to the album. All
     * non-owner content will be removed from the album. If a non-owner has
     * previously added the album to their library, they will retain all photos in
     * their library. This action can only be performed on albums which were
     * created by the developer via the API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.UnshareAlbumResponse>
        unshareAlbum(com.google.photos.library.v1.proto.UnshareAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnshareAlbumMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes one or more media items from a specified album. The media items and
     * the album must have been created by the developer via the API.
     * For albums that are shared, this action is only supported for media items
     * that were added to the album by this user, or for all media items if the
     * album was created by this user.
     * Partial success is not supported. The entire request will fail and no
     * action will be performed on the album if an invalid media item or album is
     * specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
        batchRemoveMediaItemsFromAlbum(
            com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchRemoveMediaItemsFromAlbumMethodHelper(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_ALBUM = 0;
  private static final int METHODID_BATCH_CREATE_MEDIA_ITEMS = 1;
  private static final int METHODID_BATCH_ADD_MEDIA_ITEMS_TO_ALBUM = 2;
  private static final int METHODID_SEARCH_MEDIA_ITEMS = 3;
  private static final int METHODID_LIST_MEDIA_ITEMS = 4;
  private static final int METHODID_GET_MEDIA_ITEM = 5;
  private static final int METHODID_BATCH_GET_MEDIA_ITEMS = 6;
  private static final int METHODID_LIST_ALBUMS = 7;
  private static final int METHODID_GET_ALBUM = 8;
  private static final int METHODID_GET_SHARED_ALBUM = 9;
  private static final int METHODID_ADD_ENRICHMENT_TO_ALBUM = 10;
  private static final int METHODID_JOIN_SHARED_ALBUM = 11;
  private static final int METHODID_LEAVE_SHARED_ALBUM = 12;
  private static final int METHODID_SHARE_ALBUM = 13;
  private static final int METHODID_LIST_SHARED_ALBUMS = 14;
  private static final int METHODID_UNSHARE_ALBUM = 15;
  private static final int METHODID_BATCH_REMOVE_MEDIA_ITEMS_FROM_ALBUM = 16;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PhotosLibraryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PhotosLibraryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ALBUM:
          serviceImpl.createAlbum(
              (com.google.photos.library.v1.proto.CreateAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_MEDIA_ITEMS:
          serviceImpl.batchCreateMediaItems(
              (com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_ADD_MEDIA_ITEMS_TO_ALBUM:
          serviceImpl.batchAddMediaItemsToAlbum(
              (com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_MEDIA_ITEMS:
          serviceImpl.searchMediaItems(
              (com.google.photos.library.v1.proto.SearchMediaItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.SearchMediaItemsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MEDIA_ITEMS:
          serviceImpl.listMediaItems(
              (com.google.photos.library.v1.proto.ListMediaItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.ListMediaItemsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MEDIA_ITEM:
          serviceImpl.getMediaItem(
              (com.google.photos.library.v1.proto.GetMediaItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_MEDIA_ITEMS:
          serviceImpl.batchGetMediaItems(
              (com.google.photos.library.v1.proto.BatchGetMediaItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ALBUMS:
          serviceImpl.listAlbums(
              (com.google.photos.library.v1.proto.ListAlbumsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ListAlbumsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ALBUM:
          serviceImpl.getAlbum(
              (com.google.photos.library.v1.proto.GetAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album>) responseObserver);
          break;
        case METHODID_GET_SHARED_ALBUM:
          serviceImpl.getSharedAlbum(
              (com.google.photos.library.v1.proto.GetSharedAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album>) responseObserver);
          break;
        case METHODID_ADD_ENRICHMENT_TO_ALBUM:
          serviceImpl.addEnrichmentToAlbum(
              (com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_JOIN_SHARED_ALBUM:
          serviceImpl.joinSharedAlbum(
              (com.google.photos.library.v1.proto.JoinSharedAlbumRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.JoinSharedAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_LEAVE_SHARED_ALBUM:
          serviceImpl.leaveSharedAlbum(
              (com.google.photos.library.v1.proto.LeaveSharedAlbumRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_SHARE_ALBUM:
          serviceImpl.shareAlbum(
              (com.google.photos.library.v1.proto.ShareAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.ShareAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SHARED_ALBUMS:
          serviceImpl.listSharedAlbums(
              (com.google.photos.library.v1.proto.ListSharedAlbumsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.ListSharedAlbumsResponse>)
                  responseObserver);
          break;
        case METHODID_UNSHARE_ALBUM:
          serviceImpl.unshareAlbum(
              (com.google.photos.library.v1.proto.UnshareAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.library.v1.proto.UnshareAlbumResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_REMOVE_MEDIA_ITEMS_FROM_ALBUM:
          serviceImpl.batchRemoveMediaItemsFromAlbum(
              (com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class PhotosLibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PhotosLibraryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.photos.library.v1.proto.LibraryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PhotosLibrary");
    }
  }

  private static final class PhotosLibraryFileDescriptorSupplier
      extends PhotosLibraryBaseDescriptorSupplier {
    PhotosLibraryFileDescriptorSupplier() {}
  }

  private static final class PhotosLibraryMethodDescriptorSupplier
      extends PhotosLibraryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PhotosLibraryMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PhotosLibraryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PhotosLibraryFileDescriptorSupplier())
                      .addMethod(getCreateAlbumMethodHelper())
                      .addMethod(getBatchCreateMediaItemsMethodHelper())
                      .addMethod(getBatchAddMediaItemsToAlbumMethodHelper())
                      .addMethod(getSearchMediaItemsMethodHelper())
                      .addMethod(getListMediaItemsMethodHelper())
                      .addMethod(getGetMediaItemMethodHelper())
                      .addMethod(getBatchGetMediaItemsMethodHelper())
                      .addMethod(getListAlbumsMethodHelper())
                      .addMethod(getGetAlbumMethodHelper())
                      .addMethod(getGetSharedAlbumMethodHelper())
                      .addMethod(getAddEnrichmentToAlbumMethodHelper())
                      .addMethod(getJoinSharedAlbumMethodHelper())
                      .addMethod(getLeaveSharedAlbumMethodHelper())
                      .addMethod(getShareAlbumMethodHelper())
                      .addMethod(getListSharedAlbumsMethodHelper())
                      .addMethod(getUnshareAlbumMethodHelper())
                      .addMethod(getBatchRemoveMediaItemsFromAlbumMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
