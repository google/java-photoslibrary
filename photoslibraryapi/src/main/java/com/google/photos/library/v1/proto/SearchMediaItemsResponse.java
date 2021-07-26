// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/photos/library/v1/photos_library.proto

package com.google.photos.library.v1.proto;

/**
 *
 *
 * <pre>
 * List of media items that match the search parameters.
 * </pre>
 *
 * Protobuf type {@code google.photos.library.v1.SearchMediaItemsResponse}
 */
public final class SearchMediaItemsResponse extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.photos.library.v1.SearchMediaItemsResponse)
    SearchMediaItemsResponseOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use SearchMediaItemsResponse.newBuilder() to construct.
  private SearchMediaItemsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private SearchMediaItemsResponse() {
    mediaItems_ = java.util.Collections.emptyList();
    nextPageToken_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new SearchMediaItemsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private SearchMediaItemsResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                mediaItems_ = new java.util.ArrayList<com.google.photos.types.proto.MediaItem>();
                mutable_bitField0_ |= 0x00000001;
              }
              mediaItems_.add(
                  input.readMessage(
                      com.google.photos.types.proto.MediaItem.parser(), extensionRegistry));
              break;
            }
          case 18:
            {
              java.lang.String s = input.readStringRequireUtf8();

              nextPageToken_ = s;
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        mediaItems_ = java.util.Collections.unmodifiableList(mediaItems_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_SearchMediaItemsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_SearchMediaItemsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.photos.library.v1.proto.SearchMediaItemsResponse.class,
            com.google.photos.library.v1.proto.SearchMediaItemsResponse.Builder.class);
  }

  public static final int MEDIA_ITEMS_FIELD_NUMBER = 1;
  private java.util.List<com.google.photos.types.proto.MediaItem> mediaItems_;
  /**
   *
   *
   * <pre>
   * Output only. List of media items that match the search parameters.
   * </pre>
   *
   * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.google.photos.types.proto.MediaItem> getMediaItemsList() {
    return mediaItems_;
  }
  /**
   *
   *
   * <pre>
   * Output only. List of media items that match the search parameters.
   * </pre>
   *
   * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.google.photos.types.proto.MediaItemOrBuilder>
      getMediaItemsOrBuilderList() {
    return mediaItems_;
  }
  /**
   *
   *
   * <pre>
   * Output only. List of media items that match the search parameters.
   * </pre>
   *
   * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
   */
  @java.lang.Override
  public int getMediaItemsCount() {
    return mediaItems_.size();
  }
  /**
   *
   *
   * <pre>
   * Output only. List of media items that match the search parameters.
   * </pre>
   *
   * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
   */
  @java.lang.Override
  public com.google.photos.types.proto.MediaItem getMediaItems(int index) {
    return mediaItems_.get(index);
  }
  /**
   *
   *
   * <pre>
   * Output only. List of media items that match the search parameters.
   * </pre>
   *
   * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
   */
  @java.lang.Override
  public com.google.photos.types.proto.MediaItemOrBuilder getMediaItemsOrBuilder(int index) {
    return mediaItems_.get(index);
  }

  public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
  private volatile java.lang.Object nextPageToken_;
  /**
   *
   *
   * <pre>
   * Output only. Use this token to get the next set of media items. Its
   * presence is the only reliable indicator of more media items being available
   * in the next request.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The nextPageToken.
   */
  @java.lang.Override
  public java.lang.String getNextPageToken() {
    java.lang.Object ref = nextPageToken_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nextPageToken_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Output only. Use this token to get the next set of media items. Its
   * presence is the only reliable indicator of more media items being available
   * in the next request.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The bytes for nextPageToken.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getNextPageTokenBytes() {
    java.lang.Object ref = nextPageToken_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      nextPageToken_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    for (int i = 0; i < mediaItems_.size(); i++) {
      output.writeMessage(1, mediaItems_.get(i));
    }
    if (!getNextPageTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, nextPageToken_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < mediaItems_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, mediaItems_.get(i));
    }
    if (!getNextPageTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, nextPageToken_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.photos.library.v1.proto.SearchMediaItemsResponse)) {
      return super.equals(obj);
    }
    com.google.photos.library.v1.proto.SearchMediaItemsResponse other =
        (com.google.photos.library.v1.proto.SearchMediaItemsResponse) obj;

    if (!getMediaItemsList().equals(other.getMediaItemsList())) return false;
    if (!getNextPageToken().equals(other.getNextPageToken())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMediaItemsCount() > 0) {
      hash = (37 * hash) + MEDIA_ITEMS_FIELD_NUMBER;
      hash = (53 * hash) + getMediaItemsList().hashCode();
    }
    hash = (37 * hash) + NEXT_PAGE_TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getNextPageToken().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      com.google.photos.library.v1.proto.SearchMediaItemsResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * List of media items that match the search parameters.
   * </pre>
   *
   * Protobuf type {@code google.photos.library.v1.SearchMediaItemsResponse}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.photos.library.v1.SearchMediaItemsResponse)
      com.google.photos.library.v1.proto.SearchMediaItemsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_SearchMediaItemsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_SearchMediaItemsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.photos.library.v1.proto.SearchMediaItemsResponse.class,
              com.google.photos.library.v1.proto.SearchMediaItemsResponse.Builder.class);
    }

    // Construct using com.google.photos.library.v1.proto.SearchMediaItemsResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getMediaItemsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (mediaItemsBuilder_ == null) {
        mediaItems_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        mediaItemsBuilder_.clear();
      }
      nextPageToken_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_SearchMediaItemsResponse_descriptor;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.SearchMediaItemsResponse getDefaultInstanceForType() {
      return com.google.photos.library.v1.proto.SearchMediaItemsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.SearchMediaItemsResponse build() {
      com.google.photos.library.v1.proto.SearchMediaItemsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.SearchMediaItemsResponse buildPartial() {
      com.google.photos.library.v1.proto.SearchMediaItemsResponse result =
          new com.google.photos.library.v1.proto.SearchMediaItemsResponse(this);
      int from_bitField0_ = bitField0_;
      if (mediaItemsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          mediaItems_ = java.util.Collections.unmodifiableList(mediaItems_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.mediaItems_ = mediaItems_;
      } else {
        result.mediaItems_ = mediaItemsBuilder_.build();
      }
      result.nextPageToken_ = nextPageToken_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.photos.library.v1.proto.SearchMediaItemsResponse) {
        return mergeFrom((com.google.photos.library.v1.proto.SearchMediaItemsResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.photos.library.v1.proto.SearchMediaItemsResponse other) {
      if (other == com.google.photos.library.v1.proto.SearchMediaItemsResponse.getDefaultInstance())
        return this;
      if (mediaItemsBuilder_ == null) {
        if (!other.mediaItems_.isEmpty()) {
          if (mediaItems_.isEmpty()) {
            mediaItems_ = other.mediaItems_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMediaItemsIsMutable();
            mediaItems_.addAll(other.mediaItems_);
          }
          onChanged();
        }
      } else {
        if (!other.mediaItems_.isEmpty()) {
          if (mediaItemsBuilder_.isEmpty()) {
            mediaItemsBuilder_.dispose();
            mediaItemsBuilder_ = null;
            mediaItems_ = other.mediaItems_;
            bitField0_ = (bitField0_ & ~0x00000001);
            mediaItemsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getMediaItemsFieldBuilder()
                    : null;
          } else {
            mediaItemsBuilder_.addAllMessages(other.mediaItems_);
          }
        }
      }
      if (!other.getNextPageToken().isEmpty()) {
        nextPageToken_ = other.nextPageToken_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.photos.library.v1.proto.SearchMediaItemsResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.google.photos.library.v1.proto.SearchMediaItemsResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bitField0_;

    private java.util.List<com.google.photos.types.proto.MediaItem> mediaItems_ =
        java.util.Collections.emptyList();

    private void ensureMediaItemsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        mediaItems_ = new java.util.ArrayList<com.google.photos.types.proto.MediaItem>(mediaItems_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.photos.types.proto.MediaItem,
            com.google.photos.types.proto.MediaItem.Builder,
            com.google.photos.types.proto.MediaItemOrBuilder>
        mediaItemsBuilder_;

    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public java.util.List<com.google.photos.types.proto.MediaItem> getMediaItemsList() {
      if (mediaItemsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(mediaItems_);
      } else {
        return mediaItemsBuilder_.getMessageList();
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public int getMediaItemsCount() {
      if (mediaItemsBuilder_ == null) {
        return mediaItems_.size();
      } else {
        return mediaItemsBuilder_.getCount();
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public com.google.photos.types.proto.MediaItem getMediaItems(int index) {
      if (mediaItemsBuilder_ == null) {
        return mediaItems_.get(index);
      } else {
        return mediaItemsBuilder_.getMessage(index);
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder setMediaItems(int index, com.google.photos.types.proto.MediaItem value) {
      if (mediaItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMediaItemsIsMutable();
        mediaItems_.set(index, value);
        onChanged();
      } else {
        mediaItemsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder setMediaItems(
        int index, com.google.photos.types.proto.MediaItem.Builder builderForValue) {
      if (mediaItemsBuilder_ == null) {
        ensureMediaItemsIsMutable();
        mediaItems_.set(index, builderForValue.build());
        onChanged();
      } else {
        mediaItemsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder addMediaItems(com.google.photos.types.proto.MediaItem value) {
      if (mediaItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMediaItemsIsMutable();
        mediaItems_.add(value);
        onChanged();
      } else {
        mediaItemsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder addMediaItems(int index, com.google.photos.types.proto.MediaItem value) {
      if (mediaItemsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMediaItemsIsMutable();
        mediaItems_.add(index, value);
        onChanged();
      } else {
        mediaItemsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder addMediaItems(com.google.photos.types.proto.MediaItem.Builder builderForValue) {
      if (mediaItemsBuilder_ == null) {
        ensureMediaItemsIsMutable();
        mediaItems_.add(builderForValue.build());
        onChanged();
      } else {
        mediaItemsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder addMediaItems(
        int index, com.google.photos.types.proto.MediaItem.Builder builderForValue) {
      if (mediaItemsBuilder_ == null) {
        ensureMediaItemsIsMutable();
        mediaItems_.add(index, builderForValue.build());
        onChanged();
      } else {
        mediaItemsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder addAllMediaItems(
        java.lang.Iterable<? extends com.google.photos.types.proto.MediaItem> values) {
      if (mediaItemsBuilder_ == null) {
        ensureMediaItemsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, mediaItems_);
        onChanged();
      } else {
        mediaItemsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder clearMediaItems() {
      if (mediaItemsBuilder_ == null) {
        mediaItems_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        mediaItemsBuilder_.clear();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public Builder removeMediaItems(int index) {
      if (mediaItemsBuilder_ == null) {
        ensureMediaItemsIsMutable();
        mediaItems_.remove(index);
        onChanged();
      } else {
        mediaItemsBuilder_.remove(index);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public com.google.photos.types.proto.MediaItem.Builder getMediaItemsBuilder(int index) {
      return getMediaItemsFieldBuilder().getBuilder(index);
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public com.google.photos.types.proto.MediaItemOrBuilder getMediaItemsOrBuilder(int index) {
      if (mediaItemsBuilder_ == null) {
        return mediaItems_.get(index);
      } else {
        return mediaItemsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public java.util.List<? extends com.google.photos.types.proto.MediaItemOrBuilder>
        getMediaItemsOrBuilderList() {
      if (mediaItemsBuilder_ != null) {
        return mediaItemsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(mediaItems_);
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public com.google.photos.types.proto.MediaItem.Builder addMediaItemsBuilder() {
      return getMediaItemsFieldBuilder()
          .addBuilder(com.google.photos.types.proto.MediaItem.getDefaultInstance());
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public com.google.photos.types.proto.MediaItem.Builder addMediaItemsBuilder(int index) {
      return getMediaItemsFieldBuilder()
          .addBuilder(index, com.google.photos.types.proto.MediaItem.getDefaultInstance());
    }
    /**
     *
     *
     * <pre>
     * Output only. List of media items that match the search parameters.
     * </pre>
     *
     * <code>repeated .google.photos.types.MediaItem media_items = 1;</code>
     */
    public java.util.List<com.google.photos.types.proto.MediaItem.Builder>
        getMediaItemsBuilderList() {
      return getMediaItemsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.photos.types.proto.MediaItem,
            com.google.photos.types.proto.MediaItem.Builder,
            com.google.photos.types.proto.MediaItemOrBuilder>
        getMediaItemsFieldBuilder() {
      if (mediaItemsBuilder_ == null) {
        mediaItemsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.google.photos.types.proto.MediaItem,
                com.google.photos.types.proto.MediaItem.Builder,
                com.google.photos.types.proto.MediaItemOrBuilder>(
                mediaItems_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
        mediaItems_ = null;
      }
      return mediaItemsBuilder_;
    }

    private java.lang.Object nextPageToken_ = "";
    /**
     *
     *
     * <pre>
     * Output only. Use this token to get the next set of media items. Its
     * presence is the only reliable indicator of more media items being available
     * in the next request.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     *
     * @return The nextPageToken.
     */
    public java.lang.String getNextPageToken() {
      java.lang.Object ref = nextPageToken_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nextPageToken_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. Use this token to get the next set of media items. Its
     * presence is the only reliable indicator of more media items being available
     * in the next request.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     *
     * @return The bytes for nextPageToken.
     */
    public com.google.protobuf.ByteString getNextPageTokenBytes() {
      java.lang.Object ref = nextPageToken_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        nextPageToken_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Output only. Use this token to get the next set of media items. Its
     * presence is the only reliable indicator of more media items being available
     * in the next request.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     *
     * @param value The nextPageToken to set.
     * @return This builder for chaining.
     */
    public Builder setNextPageToken(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      nextPageToken_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. Use this token to get the next set of media items. Its
     * presence is the only reliable indicator of more media items being available
     * in the next request.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearNextPageToken() {

      nextPageToken_ = getDefaultInstance().getNextPageToken();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Output only. Use this token to get the next set of media items. Its
     * presence is the only reliable indicator of more media items being available
     * in the next request.
     * </pre>
     *
     * <code>string next_page_token = 2;</code>
     *
     * @param value The bytes for nextPageToken to set.
     * @return This builder for chaining.
     */
    public Builder setNextPageTokenBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      nextPageToken_ = value;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.photos.library.v1.SearchMediaItemsResponse)
  }

  // @@protoc_insertion_point(class_scope:google.photos.library.v1.SearchMediaItemsResponse)
  private static final com.google.photos.library.v1.proto.SearchMediaItemsResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.photos.library.v1.proto.SearchMediaItemsResponse();
  }

  public static com.google.photos.library.v1.proto.SearchMediaItemsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SearchMediaItemsResponse> PARSER =
      new com.google.protobuf.AbstractParser<SearchMediaItemsResponse>() {
        @java.lang.Override
        public SearchMediaItemsResponse parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new SearchMediaItemsResponse(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<SearchMediaItemsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SearchMediaItemsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.photos.library.v1.proto.SearchMediaItemsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
