package com.google.photos.library.v1.util;

import com.google.photos.library.v1.proto.NewMediaItem;
import com.google.photos.library.v1.proto.SimpleMediaItem;

/** Factory class to create different {@link NewMediaItem}s. */
public final class NewMediaItemFactory {
  private NewMediaItemFactory() {}

  /**
   * Creates a {@link NewMediaItem} with the given description and upload token.
   *
   * @see SimpleMediaItem
   * @throws IllegalArgumentException Thrown if either the description or uploadToken is null or
   *     empty.
   */
  public static final NewMediaItem createNewMediaItem(String description, String uploadToken) {
    if (description == null || description.isEmpty()) {
      throw new IllegalArgumentException("The description cannot be null or empty.");
    }
    if (uploadToken == null || uploadToken.isEmpty()) {
      throw new IllegalArgumentException("The upload token cannot be null or empty.");
    }

    return NewMediaItem.newBuilder()
        .setDescription(description)
        .setSimpleMediaItem(SimpleMediaItem.newBuilder().setUploadToken(uploadToken))
        .build();
  }

  /**
   * Creates a {@link NewMediaItem} with the given upload token.
   *
   * @see SimpleMediaItem
   * @throws IllegalArgumentException Thrown if the uploadToken is null or empty.
   */
  public static final NewMediaItem createNewMediaItem(String uploadToken) {
    if (uploadToken == null || uploadToken.isEmpty()) {
      throw new IllegalArgumentException("The upload token cannot be null or empty.");
    }

    return NewMediaItem.newBuilder()
        .setSimpleMediaItem(SimpleMediaItem.newBuilder().setUploadToken(uploadToken))
        .build();
  }
}
