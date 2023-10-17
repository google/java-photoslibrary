// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/photos/library/v1/photos_library.proto

package com.google.photos.library.v1.proto;

public interface BatchRemoveMediaItemsFromAlbumRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.photos.library.v1.BatchRemoveMediaItemsFromAlbumRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   * be removed.
   * Must not contain repeated identifiers and cannot be empty. The maximum
   * number of media items that can be removed in one call is 50.
   * </pre>
   *
   * <code>repeated string media_item_ids = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return A list containing the mediaItemIds.
   */
  java.util.List<java.lang.String> getMediaItemIdsList();
  /**
   *
   *
   * <pre>
   * Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   * be removed.
   * Must not contain repeated identifiers and cannot be empty. The maximum
   * number of media items that can be removed in one call is 50.
   * </pre>
   *
   * <code>repeated string media_item_ids = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The count of mediaItemIds.
   */
  int getMediaItemIdsCount();
  /**
   *
   *
   * <pre>
   * Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   * be removed.
   * Must not contain repeated identifiers and cannot be empty. The maximum
   * number of media items that can be removed in one call is 50.
   * </pre>
   *
   * <code>repeated string media_item_ids = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @param index The index of the element to return.
   * @return The mediaItemIds at the given index.
   */
  java.lang.String getMediaItemIds(int index);
  /**
   *
   *
   * <pre>
   * Required. Identifiers of the [MediaItem][google.photos.types.MediaItem]s to
   * be removed.
   * Must not contain repeated identifiers and cannot be empty. The maximum
   * number of media items that can be removed in one call is 50.
   * </pre>
   *
   * <code>repeated string media_item_ids = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the mediaItemIds at the given index.
   */
  com.google.protobuf.ByteString getMediaItemIdsBytes(int index);

  /**
   *
   *
   * <pre>
   * Required. Identifier of the [Album][google.photos.types.Album] that the
   * media items are to be removed from.
   * </pre>
   *
   * <code>string album_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The albumId.
   */
  java.lang.String getAlbumId();
  /**
   *
   *
   * <pre>
   * Required. Identifier of the [Album][google.photos.types.Album] that the
   * media items are to be removed from.
   * </pre>
   *
   * <code>string album_id = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for albumId.
   */
  com.google.protobuf.ByteString getAlbumIdBytes();
}