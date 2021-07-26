package com.google.photos.library.v1.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

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
    value = "by gRPC proto compiler",
    comments = "Source: google/photos/library/v1/photos_library.proto")
public final class PhotosLibraryGrpc {

  private PhotosLibraryGrpc() {}

  public static final String SERVICE_NAME = "google.photos.library.v1.PhotosLibrary";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      getCreateAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAlbum",
      requestType = com.google.photos.library.v1.proto.CreateAlbumRequest.class,
      responseType = com.google.photos.types.proto.Album.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.CreateAlbumRequest,
          com.google.photos.types.proto.Album>
      getCreateAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      getBatchCreateMediaItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateMediaItems",
      requestType = com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest.class,
      responseType = com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>
      getBatchCreateMediaItemsMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "BatchCreateMediaItems"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      getBatchAddMediaItemsToAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchAddMediaItemsToAlbum",
      requestType = com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
          com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>
      getBatchAddMediaItemsToAlbumMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "BatchAddMediaItemsToAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      getSearchMediaItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchMediaItems",
      requestType = com.google.photos.library.v1.proto.SearchMediaItemsRequest.class,
      responseType = com.google.photos.library.v1.proto.SearchMediaItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.SearchMediaItemsRequest,
          com.google.photos.library.v1.proto.SearchMediaItemsResponse>
      getSearchMediaItemsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchMediaItems"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      getListMediaItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMediaItems",
      requestType = com.google.photos.library.v1.proto.ListMediaItemsRequest.class,
      responseType = com.google.photos.library.v1.proto.ListMediaItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListMediaItemsRequest,
          com.google.photos.library.v1.proto.ListMediaItemsResponse>
      getListMediaItemsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMediaItems"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getGetMediaItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMediaItem",
      requestType = com.google.photos.library.v1.proto.GetMediaItemRequest.class,
      responseType = com.google.photos.types.proto.MediaItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getGetMediaItemMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMediaItem"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      getBatchGetMediaItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetMediaItems",
      requestType = com.google.photos.library.v1.proto.BatchGetMediaItemsRequest.class,
      responseType = com.google.photos.library.v1.proto.BatchGetMediaItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
          com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>
      getBatchGetMediaItemsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetMediaItems"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      getListAlbumsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAlbums",
      requestType = com.google.photos.library.v1.proto.ListAlbumsRequest.class,
      responseType = com.google.photos.library.v1.proto.ListAlbumsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListAlbumsRequest,
          com.google.photos.library.v1.proto.ListAlbumsResponse>
      getListAlbumsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAlbums"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      getGetAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAlbum",
      requestType = com.google.photos.library.v1.proto.GetAlbumRequest.class,
      responseType = com.google.photos.types.proto.Album.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetAlbumRequest, com.google.photos.types.proto.Album>
      getGetAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      getGetSharedAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSharedAlbum",
      requestType = com.google.photos.library.v1.proto.GetSharedAlbumRequest.class,
      responseType = com.google.photos.types.proto.Album.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.GetSharedAlbumRequest,
          com.google.photos.types.proto.Album>
      getGetSharedAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSharedAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      getAddEnrichmentToAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddEnrichmentToAlbum",
      requestType = com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
          com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>
      getAddEnrichmentToAlbumMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "AddEnrichmentToAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      getJoinSharedAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinSharedAlbum",
      requestType = com.google.photos.library.v1.proto.JoinSharedAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.JoinSharedAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
          com.google.photos.library.v1.proto.JoinSharedAlbumResponse>
      getJoinSharedAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinSharedAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      getLeaveSharedAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveSharedAlbum",
      requestType = com.google.photos.library.v1.proto.LeaveSharedAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.LeaveSharedAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
          com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>
      getLeaveSharedAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LeaveSharedAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      getShareAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ShareAlbum",
      requestType = com.google.photos.library.v1.proto.ShareAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.ShareAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ShareAlbumRequest,
          com.google.photos.library.v1.proto.ShareAlbumResponse>
      getShareAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ShareAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      getListSharedAlbumsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSharedAlbums",
      requestType = com.google.photos.library.v1.proto.ListSharedAlbumsRequest.class,
      responseType = com.google.photos.library.v1.proto.ListSharedAlbumsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
          com.google.photos.library.v1.proto.ListSharedAlbumsResponse>
      getListSharedAlbumsMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSharedAlbums"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      getUnshareAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnshareAlbum",
      requestType = com.google.photos.library.v1.proto.UnshareAlbumRequest.class,
      responseType = com.google.photos.library.v1.proto.UnshareAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UnshareAlbumRequest,
          com.google.photos.library.v1.proto.UnshareAlbumResponse>
      getUnshareAlbumMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnshareAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      getBatchRemoveMediaItemsFromAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRemoveMediaItemsFromAlbum",
      requestType = com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest.class,
      responseType =
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
          com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>
      getBatchRemoveMediaItemsFromAlbumMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "BatchRemoveMediaItemsFromAlbum"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UpdateAlbumRequest,
          com.google.photos.types.proto.Album>
      getUpdateAlbumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAlbum",
      requestType = com.google.photos.library.v1.proto.UpdateAlbumRequest.class,
      responseType = com.google.photos.types.proto.Album.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UpdateAlbumRequest,
          com.google.photos.types.proto.Album>
      getUpdateAlbumMethod() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.UpdateAlbumRequest,
            com.google.photos.types.proto.Album>
        getUpdateAlbumMethod;
    if ((getUpdateAlbumMethod = PhotosLibraryGrpc.getUpdateAlbumMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getUpdateAlbumMethod = PhotosLibraryGrpc.getUpdateAlbumMethod) == null) {
          PhotosLibraryGrpc.getUpdateAlbumMethod =
              getUpdateAlbumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.UpdateAlbumRequest,
                          com.google.photos.types.proto.Album>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAlbum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.UpdateAlbumRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.Album.getDefaultInstance()))
                      .setSchemaDescriptor(new PhotosLibraryMethodDescriptorSupplier("UpdateAlbum"))
                      .build();
        }
      }
    }
    return getUpdateAlbumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UpdateMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getUpdateMediaItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMediaItem",
      requestType = com.google.photos.library.v1.proto.UpdateMediaItemRequest.class,
      responseType = com.google.photos.types.proto.MediaItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.photos.library.v1.proto.UpdateMediaItemRequest,
          com.google.photos.types.proto.MediaItem>
      getUpdateMediaItemMethod() {
    io.grpc.MethodDescriptor<
            com.google.photos.library.v1.proto.UpdateMediaItemRequest,
            com.google.photos.types.proto.MediaItem>
        getUpdateMediaItemMethod;
    if ((getUpdateMediaItemMethod = PhotosLibraryGrpc.getUpdateMediaItemMethod) == null) {
      synchronized (PhotosLibraryGrpc.class) {
        if ((getUpdateMediaItemMethod = PhotosLibraryGrpc.getUpdateMediaItemMethod) == null) {
          PhotosLibraryGrpc.getUpdateMediaItemMethod =
              getUpdateMediaItemMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.photos.library.v1.proto.UpdateMediaItemRequest,
                          com.google.photos.types.proto.MediaItem>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMediaItem"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.library.v1.proto.UpdateMediaItemRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.photos.types.proto.MediaItem.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhotosLibraryMethodDescriptorSupplier("UpdateMediaItem"))
                      .build();
        }
      }
    }
    return getUpdateMediaItemMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PhotosLibraryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryStub>() {
          @java.lang.Override
          public PhotosLibraryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhotosLibraryStub(channel, callOptions);
          }
        };
    return PhotosLibraryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PhotosLibraryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryBlockingStub>() {
          @java.lang.Override
          public PhotosLibraryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhotosLibraryBlockingStub(channel, callOptions);
          }
        };
    return PhotosLibraryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PhotosLibraryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhotosLibraryFutureStub>() {
          @java.lang.Override
          public PhotosLibraryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhotosLibraryFutureStub(channel, callOptions);
          }
        };
    return PhotosLibraryFutureStub.newStub(factory, channel);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAlbumMethod(), responseObserver);
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
     * specified, the call adds the media item to the album too. Each album can
     * contain up to 20,000 media items. By default, the media item will be added
     * to the end of the library or album.
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateMediaItemsMethod(), responseObserver);
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
     * Each album can contain up to 20,000 media items.
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchAddMediaItemsToAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchMediaItemsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMediaItemsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMediaItemMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchGetMediaItemsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAlbumsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSharedAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddEnrichmentToAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getJoinSharedAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLeaveSharedAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShareAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSharedAlbumsMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnshareAlbumMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRemoveMediaItemsFromAlbumMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the album with the specified `id`.
     * Only the `id`, `title` and `cover_photo_media_item_id` fields of the album
     * are read. The album must have been created by the developer via the API and
     * must be owned by the user.
     * </pre>
     */
    public void updateAlbum(
        com.google.photos.library.v1.proto.UpdateAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAlbumMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the media item with the specified `id`.
     * Only the `id` and `description` fields of the media item are read. The
     * media item must have been created by the developer via the API and must be
     * owned by the user.
     * </pre>
     */
    public void updateMediaItem(
        com.google.photos.library.v1.proto.UpdateMediaItemRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMediaItemMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.CreateAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_CREATE_ALBUM)))
          .addMethod(
              getBatchCreateMediaItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchCreateMediaItemsRequest,
                      com.google.photos.library.v1.proto.BatchCreateMediaItemsResponse>(
                      this, METHODID_BATCH_CREATE_MEDIA_ITEMS)))
          .addMethod(
              getBatchAddMediaItemsToAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumRequest,
                      com.google.photos.library.v1.proto.BatchAddMediaItemsToAlbumResponse>(
                      this, METHODID_BATCH_ADD_MEDIA_ITEMS_TO_ALBUM)))
          .addMethod(
              getSearchMediaItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.SearchMediaItemsRequest,
                      com.google.photos.library.v1.proto.SearchMediaItemsResponse>(
                      this, METHODID_SEARCH_MEDIA_ITEMS)))
          .addMethod(
              getListMediaItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListMediaItemsRequest,
                      com.google.photos.library.v1.proto.ListMediaItemsResponse>(
                      this, METHODID_LIST_MEDIA_ITEMS)))
          .addMethod(
              getGetMediaItemMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetMediaItemRequest,
                      com.google.photos.types.proto.MediaItem>(this, METHODID_GET_MEDIA_ITEM)))
          .addMethod(
              getBatchGetMediaItemsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchGetMediaItemsRequest,
                      com.google.photos.library.v1.proto.BatchGetMediaItemsResponse>(
                      this, METHODID_BATCH_GET_MEDIA_ITEMS)))
          .addMethod(
              getListAlbumsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListAlbumsRequest,
                      com.google.photos.library.v1.proto.ListAlbumsResponse>(
                      this, METHODID_LIST_ALBUMS)))
          .addMethod(
              getGetAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_GET_ALBUM)))
          .addMethod(
              getGetSharedAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.GetSharedAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_GET_SHARED_ALBUM)))
          .addMethod(
              getAddEnrichmentToAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.AddEnrichmentToAlbumRequest,
                      com.google.photos.library.v1.proto.AddEnrichmentToAlbumResponse>(
                      this, METHODID_ADD_ENRICHMENT_TO_ALBUM)))
          .addMethod(
              getJoinSharedAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.JoinSharedAlbumRequest,
                      com.google.photos.library.v1.proto.JoinSharedAlbumResponse>(
                      this, METHODID_JOIN_SHARED_ALBUM)))
          .addMethod(
              getLeaveSharedAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.LeaveSharedAlbumRequest,
                      com.google.photos.library.v1.proto.LeaveSharedAlbumResponse>(
                      this, METHODID_LEAVE_SHARED_ALBUM)))
          .addMethod(
              getShareAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ShareAlbumRequest,
                      com.google.photos.library.v1.proto.ShareAlbumResponse>(
                      this, METHODID_SHARE_ALBUM)))
          .addMethod(
              getListSharedAlbumsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.ListSharedAlbumsRequest,
                      com.google.photos.library.v1.proto.ListSharedAlbumsResponse>(
                      this, METHODID_LIST_SHARED_ALBUMS)))
          .addMethod(
              getUnshareAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.UnshareAlbumRequest,
                      com.google.photos.library.v1.proto.UnshareAlbumResponse>(
                      this, METHODID_UNSHARE_ALBUM)))
          .addMethod(
              getBatchRemoveMediaItemsFromAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumRequest,
                      com.google.photos.library.v1.proto.BatchRemoveMediaItemsFromAlbumResponse>(
                      this, METHODID_BATCH_REMOVE_MEDIA_ITEMS_FROM_ALBUM)))
          .addMethod(
              getUpdateAlbumMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.UpdateAlbumRequest,
                      com.google.photos.types.proto.Album>(this, METHODID_UPDATE_ALBUM)))
          .addMethod(
              getUpdateMediaItemMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.photos.library.v1.proto.UpdateMediaItemRequest,
                      com.google.photos.types.proto.MediaItem>(this, METHODID_UPDATE_MEDIA_ITEM)))
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
  public static final class PhotosLibraryStub
      extends io.grpc.stub.AbstractAsyncStub<PhotosLibraryStub> {
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAlbumMethod(), getCallOptions()),
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
     * specified, the call adds the media item to the album too. Each album can
     * contain up to 20,000 media items. By default, the media item will be added
     * to the end of the library or album.
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateMediaItemsMethod(), getCallOptions()),
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
     * Each album can contain up to 20,000 media items.
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchAddMediaItemsToAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMediaItemsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMediaItemsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMediaItemMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchGetMediaItemsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAlbumsMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAlbumMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSharedAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddEnrichmentToAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinSharedAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaveSharedAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShareAlbumMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSharedAlbumsMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnshareAlbumMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRemoveMediaItemsFromAlbumMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the album with the specified `id`.
     * Only the `id`, `title` and `cover_photo_media_item_id` fields of the album
     * are read. The album must have been created by the developer via the API and
     * must be owned by the user.
     * </pre>
     */
    public void updateAlbum(
        com.google.photos.library.v1.proto.UpdateAlbumRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAlbumMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the media item with the specified `id`.
     * Only the `id` and `description` fields of the media item are read. The
     * media item must have been created by the developer via the API and must be
     * owned by the user.
     * </pre>
     */
    public void updateMediaItem(
        com.google.photos.library.v1.proto.UpdateMediaItemRequest request,
        io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMediaItemMethod(), getCallOptions()),
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
      extends io.grpc.stub.AbstractBlockingStub<PhotosLibraryBlockingStub> {
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAlbumMethod(), getCallOptions(), request);
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
     * specified, the call adds the media item to the album too. Each album can
     * contain up to 20,000 media items. By default, the media item will be added
     * to the end of the library or album.
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateMediaItemsMethod(), getCallOptions(), request);
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
     * Each album can contain up to 20,000 media items.
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchAddMediaItemsToAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMediaItemsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMediaItemsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMediaItemMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchGetMediaItemsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAlbumsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSharedAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddEnrichmentToAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinSharedAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaveSharedAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShareAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharedAlbumsMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnshareAlbumMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRemoveMediaItemsFromAlbumMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the album with the specified `id`.
     * Only the `id`, `title` and `cover_photo_media_item_id` fields of the album
     * are read. The album must have been created by the developer via the API and
     * must be owned by the user.
     * </pre>
     */
    public com.google.photos.types.proto.Album updateAlbum(
        com.google.photos.library.v1.proto.UpdateAlbumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAlbumMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the media item with the specified `id`.
     * Only the `id` and `description` fields of the media item are read. The
     * media item must have been created by the developer via the API and must be
     * owned by the user.
     * </pre>
     */
    public com.google.photos.types.proto.MediaItem updateMediaItem(
        com.google.photos.library.v1.proto.UpdateMediaItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMediaItemMethod(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractFutureStub<PhotosLibraryFutureStub> {
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAlbumMethod(), getCallOptions()), request);
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
     * specified, the call adds the media item to the album too. Each album can
     * contain up to 20,000 media items. By default, the media item will be added
     * to the end of the library or album.
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateMediaItemsMethod(), getCallOptions()), request);
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
     * Each album can contain up to 20,000 media items.
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchAddMediaItemsToAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMediaItemsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMediaItemsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMediaItemMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchGetMediaItemsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAlbumsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSharedAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddEnrichmentToAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinSharedAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaveSharedAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShareAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSharedAlbumsMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnshareAlbumMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRemoveMediaItemsFromAlbumMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Update the album with the specified `id`.
     * Only the `id`, `title` and `cover_photo_media_item_id` fields of the album
     * are read. The album must have been created by the developer via the API and
     * must be owned by the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.photos.types.proto.Album>
        updateAlbum(com.google.photos.library.v1.proto.UpdateAlbumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAlbumMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the media item with the specified `id`.
     * Only the `id` and `description` fields of the media item are read. The
     * media item must have been created by the developer via the API and must be
     * owned by the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.photos.types.proto.MediaItem>
        updateMediaItem(com.google.photos.library.v1.proto.UpdateMediaItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMediaItemMethod(), getCallOptions()), request);
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
  private static final int METHODID_UPDATE_ALBUM = 17;
  private static final int METHODID_UPDATE_MEDIA_ITEM = 18;

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
        case METHODID_UPDATE_ALBUM:
          serviceImpl.updateAlbum(
              (com.google.photos.library.v1.proto.UpdateAlbumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.Album>) responseObserver);
          break;
        case METHODID_UPDATE_MEDIA_ITEM:
          serviceImpl.updateMediaItem(
              (com.google.photos.library.v1.proto.UpdateMediaItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.photos.types.proto.MediaItem>)
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
                      .addMethod(getCreateAlbumMethod())
                      .addMethod(getBatchCreateMediaItemsMethod())
                      .addMethod(getBatchAddMediaItemsToAlbumMethod())
                      .addMethod(getSearchMediaItemsMethod())
                      .addMethod(getListMediaItemsMethod())
                      .addMethod(getGetMediaItemMethod())
                      .addMethod(getBatchGetMediaItemsMethod())
                      .addMethod(getListAlbumsMethod())
                      .addMethod(getGetAlbumMethod())
                      .addMethod(getGetSharedAlbumMethod())
                      .addMethod(getAddEnrichmentToAlbumMethod())
                      .addMethod(getJoinSharedAlbumMethod())
                      .addMethod(getLeaveSharedAlbumMethod())
                      .addMethod(getShareAlbumMethod())
                      .addMethod(getListSharedAlbumsMethod())
                      .addMethod(getUnshareAlbumMethod())
                      .addMethod(getBatchRemoveMediaItemsFromAlbumMethod())
                      .addMethod(getUpdateAlbumMethod())
                      .addMethod(getUpdateMediaItemMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
