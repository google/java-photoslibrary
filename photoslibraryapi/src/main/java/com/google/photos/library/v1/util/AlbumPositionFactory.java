package com.google.photos.library.v1.util;

import static com.google.photos.library.v1.proto.AlbumPosition.PositionType;

import com.google.photos.library.v1.proto.AlbumPosition;

/** Factory class to create different {@link AlbumPosition}s. */
public final class AlbumPositionFactory {
  private AlbumPositionFactory() {}

  /**
   * Creates an {@link AlbumPosition} positioned at the start of the album.
   *
   * @see AlbumPosition.PositionType#FIRST_IN_ALBUM
   */
  public static final AlbumPosition createFirstInAlbum() {
    return AlbumPosition.newBuilder().setPosition(PositionType.FIRST_IN_ALBUM).build();
  }

  /**
   * Creates an {@link AlbumPosition} positioned at the end of the album.
   *
   * @see AlbumPosition.PositionType#LAST_IN_ALBUM
   */
  public static final AlbumPosition createLastInAlbum() {
    return AlbumPosition.newBuilder().setPosition(PositionType.LAST_IN_ALBUM).build();
  }

  /**
   * Creates an {@link AlbumPosition} positioned after the provided media item.
   *
   * @see AlbumPosition.PositionType#AFTER_MEDIA_ITEM
   * @throws IllegalArgumentException Thrown if mediaItemId is null or empty.
   */
  public static final AlbumPosition createAfterMediaItem(String mediaItemId) {
    if (mediaItemId == null || mediaItemId.isEmpty()) {
      throw new IllegalArgumentException("Media item ID cannot be null or empty.");
    }
    return AlbumPosition.newBuilder()
        .setPosition(PositionType.AFTER_MEDIA_ITEM)
        .setRelativeMediaItemId(mediaItemId)
        .build();
  }

  /**
   * Creates an {@link AlbumPosition} positioned after the provided enrichment item.
   *
   * @see AlbumPosition.PositionType#AFTER_ENRICHMENT_ITEM
   * @throws IllegalArgumentException Thrown if enrichmentItemId is null or empty.
   */
  public static final AlbumPosition createAfterEnrichmentItem(String enrichmentItemId) {
    if (enrichmentItemId == null || enrichmentItemId.isEmpty()) {
      throw new IllegalArgumentException("Enrichment item ID cannot be null or empty.");
    }
    return AlbumPosition.newBuilder()
        .setPosition(PositionType.AFTER_ENRICHMENT_ITEM)
        .setRelativeEnrichmentItemId(enrichmentItemId)
        .build();
  }
}
