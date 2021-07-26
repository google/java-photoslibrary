// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/photos/library/v1/photos_library.proto

package com.google.photos.library.v1.proto;

/**
 *
 *
 * <pre>
 * New media item that's created in a user's Google Photos account.
 * </pre>
 *
 * Protobuf type {@code google.photos.library.v1.NewMediaItem}
 */
public final class NewMediaItem extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.photos.library.v1.NewMediaItem)
    NewMediaItemOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use NewMediaItem.newBuilder() to construct.
  private NewMediaItem(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private NewMediaItem() {
    description_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new NewMediaItem();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private NewMediaItem(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
              java.lang.String s = input.readStringRequireUtf8();

              description_ = s;
              break;
            }
          case 18:
            {
              com.google.photos.library.v1.proto.SimpleMediaItem.Builder subBuilder = null;
              if (newMediaItemTypeCase_ == 2) {
                subBuilder =
                    ((com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_)
                        .toBuilder();
              }
              newMediaItemType_ =
                  input.readMessage(
                      com.google.photos.library.v1.proto.SimpleMediaItem.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(
                    (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_);
                newMediaItemType_ = subBuilder.buildPartial();
              }
              newMediaItemTypeCase_ = 2;
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_NewMediaItem_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_NewMediaItem_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.photos.library.v1.proto.NewMediaItem.class,
            com.google.photos.library.v1.proto.NewMediaItem.Builder.class);
  }

  private int newMediaItemTypeCase_ = 0;
  private java.lang.Object newMediaItemType_;

  public enum NewMediaItemTypeCase
      implements
          com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    SIMPLE_MEDIA_ITEM(2),
    NEWMEDIAITEMTYPE_NOT_SET(0);
    private final int value;

    private NewMediaItemTypeCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static NewMediaItemTypeCase valueOf(int value) {
      return forNumber(value);
    }

    public static NewMediaItemTypeCase forNumber(int value) {
      switch (value) {
        case 2:
          return SIMPLE_MEDIA_ITEM;
        case 0:
          return NEWMEDIAITEMTYPE_NOT_SET;
        default:
          return null;
      }
    }

    public int getNumber() {
      return this.value;
    }
  };

  public NewMediaItemTypeCase getNewMediaItemTypeCase() {
    return NewMediaItemTypeCase.forNumber(newMediaItemTypeCase_);
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 1;
  private volatile java.lang.Object description_;
  /**
   *
   *
   * <pre>
   * Description of the media item. This will be shown to the user in the item's
   * info section in the Google Photos app.
   * This string shouldn't be more than 1000 characters.
   * </pre>
   *
   * <code>string description = 1;</code>
   *
   * @return The description.
   */
  @java.lang.Override
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Description of the media item. This will be shown to the user in the item's
   * info section in the Google Photos app.
   * This string shouldn't be more than 1000 characters.
   * </pre>
   *
   * <code>string description = 1;</code>
   *
   * @return The bytes for description.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SIMPLE_MEDIA_ITEM_FIELD_NUMBER = 2;
  /**
   *
   *
   * <pre>
   * A new media item that has been uploaded via the included `uploadToken`.
   * </pre>
   *
   * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
   *
   * @return Whether the simpleMediaItem field is set.
   */
  @java.lang.Override
  public boolean hasSimpleMediaItem() {
    return newMediaItemTypeCase_ == 2;
  }
  /**
   *
   *
   * <pre>
   * A new media item that has been uploaded via the included `uploadToken`.
   * </pre>
   *
   * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
   *
   * @return The simpleMediaItem.
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.SimpleMediaItem getSimpleMediaItem() {
    if (newMediaItemTypeCase_ == 2) {
      return (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_;
    }
    return com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
  }
  /**
   *
   *
   * <pre>
   * A new media item that has been uploaded via the included `uploadToken`.
   * </pre>
   *
   * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.SimpleMediaItemOrBuilder getSimpleMediaItemOrBuilder() {
    if (newMediaItemTypeCase_ == 2) {
      return (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_;
    }
    return com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
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
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, description_);
    }
    if (newMediaItemTypeCase_ == 2) {
      output.writeMessage(
          2, (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, description_);
    }
    if (newMediaItemTypeCase_ == 2) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_);
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
    if (!(obj instanceof com.google.photos.library.v1.proto.NewMediaItem)) {
      return super.equals(obj);
    }
    com.google.photos.library.v1.proto.NewMediaItem other =
        (com.google.photos.library.v1.proto.NewMediaItem) obj;

    if (!getDescription().equals(other.getDescription())) return false;
    if (!getNewMediaItemTypeCase().equals(other.getNewMediaItemTypeCase())) return false;
    switch (newMediaItemTypeCase_) {
      case 2:
        if (!getSimpleMediaItem().equals(other.getSimpleMediaItem())) return false;
        break;
      case 0:
      default:
    }
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
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    switch (newMediaItemTypeCase_) {
      case 2:
        hash = (37 * hash) + SIMPLE_MEDIA_ITEM_FIELD_NUMBER;
        hash = (53 * hash) + getSimpleMediaItem().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.NewMediaItem parseFrom(
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

  public static Builder newBuilder(com.google.photos.library.v1.proto.NewMediaItem prototype) {
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
   * New media item that's created in a user's Google Photos account.
   * </pre>
   *
   * Protobuf type {@code google.photos.library.v1.NewMediaItem}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.photos.library.v1.NewMediaItem)
      com.google.photos.library.v1.proto.NewMediaItemOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_NewMediaItem_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_NewMediaItem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.photos.library.v1.proto.NewMediaItem.class,
              com.google.photos.library.v1.proto.NewMediaItem.Builder.class);
    }

    // Construct using com.google.photos.library.v1.proto.NewMediaItem.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      description_ = "";

      newMediaItemTypeCase_ = 0;
      newMediaItemType_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_NewMediaItem_descriptor;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.NewMediaItem getDefaultInstanceForType() {
      return com.google.photos.library.v1.proto.NewMediaItem.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.NewMediaItem build() {
      com.google.photos.library.v1.proto.NewMediaItem result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.NewMediaItem buildPartial() {
      com.google.photos.library.v1.proto.NewMediaItem result =
          new com.google.photos.library.v1.proto.NewMediaItem(this);
      result.description_ = description_;
      if (newMediaItemTypeCase_ == 2) {
        if (simpleMediaItemBuilder_ == null) {
          result.newMediaItemType_ = newMediaItemType_;
        } else {
          result.newMediaItemType_ = simpleMediaItemBuilder_.build();
        }
      }
      result.newMediaItemTypeCase_ = newMediaItemTypeCase_;
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
      if (other instanceof com.google.photos.library.v1.proto.NewMediaItem) {
        return mergeFrom((com.google.photos.library.v1.proto.NewMediaItem) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.photos.library.v1.proto.NewMediaItem other) {
      if (other == com.google.photos.library.v1.proto.NewMediaItem.getDefaultInstance())
        return this;
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      switch (other.getNewMediaItemTypeCase()) {
        case SIMPLE_MEDIA_ITEM:
          {
            mergeSimpleMediaItem(other.getSimpleMediaItem());
            break;
          }
        case NEWMEDIAITEMTYPE_NOT_SET:
          {
            break;
          }
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
      com.google.photos.library.v1.proto.NewMediaItem parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.photos.library.v1.proto.NewMediaItem) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int newMediaItemTypeCase_ = 0;
    private java.lang.Object newMediaItemType_;

    public NewMediaItemTypeCase getNewMediaItemTypeCase() {
      return NewMediaItemTypeCase.forNumber(newMediaItemTypeCase_);
    }

    public Builder clearNewMediaItemType() {
      newMediaItemTypeCase_ = 0;
      newMediaItemType_ = null;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     *
     *
     * <pre>
     * Description of the media item. This will be shown to the user in the item's
     * info section in the Google Photos app.
     * This string shouldn't be more than 1000 characters.
     * </pre>
     *
     * <code>string description = 1;</code>
     *
     * @return The description.
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Description of the media item. This will be shown to the user in the item's
     * info section in the Google Photos app.
     * This string shouldn't be more than 1000 characters.
     * </pre>
     *
     * <code>string description = 1;</code>
     *
     * @return The bytes for description.
     */
    public com.google.protobuf.ByteString getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Description of the media item. This will be shown to the user in the item's
     * info section in the Google Photos app.
     * This string shouldn't be more than 1000 characters.
     * </pre>
     *
     * <code>string description = 1;</code>
     *
     * @param value The description to set.
     * @return This builder for chaining.
     */
    public Builder setDescription(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      description_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Description of the media item. This will be shown to the user in the item's
     * info section in the Google Photos app.
     * This string shouldn't be more than 1000 characters.
     * </pre>
     *
     * <code>string description = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDescription() {

      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Description of the media item. This will be shown to the user in the item's
     * info section in the Google Photos app.
     * This string shouldn't be more than 1000 characters.
     * </pre>
     *
     * <code>string description = 1;</code>
     *
     * @param value The bytes for description to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptionBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      description_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.SimpleMediaItem,
            com.google.photos.library.v1.proto.SimpleMediaItem.Builder,
            com.google.photos.library.v1.proto.SimpleMediaItemOrBuilder>
        simpleMediaItemBuilder_;
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     *
     * @return Whether the simpleMediaItem field is set.
     */
    @java.lang.Override
    public boolean hasSimpleMediaItem() {
      return newMediaItemTypeCase_ == 2;
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     *
     * @return The simpleMediaItem.
     */
    @java.lang.Override
    public com.google.photos.library.v1.proto.SimpleMediaItem getSimpleMediaItem() {
      if (simpleMediaItemBuilder_ == null) {
        if (newMediaItemTypeCase_ == 2) {
          return (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_;
        }
        return com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
      } else {
        if (newMediaItemTypeCase_ == 2) {
          return simpleMediaItemBuilder_.getMessage();
        }
        return com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    public Builder setSimpleMediaItem(com.google.photos.library.v1.proto.SimpleMediaItem value) {
      if (simpleMediaItemBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        newMediaItemType_ = value;
        onChanged();
      } else {
        simpleMediaItemBuilder_.setMessage(value);
      }
      newMediaItemTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    public Builder setSimpleMediaItem(
        com.google.photos.library.v1.proto.SimpleMediaItem.Builder builderForValue) {
      if (simpleMediaItemBuilder_ == null) {
        newMediaItemType_ = builderForValue.build();
        onChanged();
      } else {
        simpleMediaItemBuilder_.setMessage(builderForValue.build());
      }
      newMediaItemTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    public Builder mergeSimpleMediaItem(com.google.photos.library.v1.proto.SimpleMediaItem value) {
      if (simpleMediaItemBuilder_ == null) {
        if (newMediaItemTypeCase_ == 2
            && newMediaItemType_
                != com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance()) {
          newMediaItemType_ =
              com.google.photos.library.v1.proto.SimpleMediaItem.newBuilder(
                      (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          newMediaItemType_ = value;
        }
        onChanged();
      } else {
        if (newMediaItemTypeCase_ == 2) {
          simpleMediaItemBuilder_.mergeFrom(value);
        }
        simpleMediaItemBuilder_.setMessage(value);
      }
      newMediaItemTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    public Builder clearSimpleMediaItem() {
      if (simpleMediaItemBuilder_ == null) {
        if (newMediaItemTypeCase_ == 2) {
          newMediaItemTypeCase_ = 0;
          newMediaItemType_ = null;
          onChanged();
        }
      } else {
        if (newMediaItemTypeCase_ == 2) {
          newMediaItemTypeCase_ = 0;
          newMediaItemType_ = null;
        }
        simpleMediaItemBuilder_.clear();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    public com.google.photos.library.v1.proto.SimpleMediaItem.Builder getSimpleMediaItemBuilder() {
      return getSimpleMediaItemFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    @java.lang.Override
    public com.google.photos.library.v1.proto.SimpleMediaItemOrBuilder
        getSimpleMediaItemOrBuilder() {
      if ((newMediaItemTypeCase_ == 2) && (simpleMediaItemBuilder_ != null)) {
        return simpleMediaItemBuilder_.getMessageOrBuilder();
      } else {
        if (newMediaItemTypeCase_ == 2) {
          return (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_;
        }
        return com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * A new media item that has been uploaded via the included `uploadToken`.
     * </pre>
     *
     * <code>.google.photos.library.v1.SimpleMediaItem simple_media_item = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.SimpleMediaItem,
            com.google.photos.library.v1.proto.SimpleMediaItem.Builder,
            com.google.photos.library.v1.proto.SimpleMediaItemOrBuilder>
        getSimpleMediaItemFieldBuilder() {
      if (simpleMediaItemBuilder_ == null) {
        if (!(newMediaItemTypeCase_ == 2)) {
          newMediaItemType_ =
              com.google.photos.library.v1.proto.SimpleMediaItem.getDefaultInstance();
        }
        simpleMediaItemBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.photos.library.v1.proto.SimpleMediaItem,
                com.google.photos.library.v1.proto.SimpleMediaItem.Builder,
                com.google.photos.library.v1.proto.SimpleMediaItemOrBuilder>(
                (com.google.photos.library.v1.proto.SimpleMediaItem) newMediaItemType_,
                getParentForChildren(),
                isClean());
        newMediaItemType_ = null;
      }
      newMediaItemTypeCase_ = 2;
      onChanged();
      ;
      return simpleMediaItemBuilder_;
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

    // @@protoc_insertion_point(builder_scope:google.photos.library.v1.NewMediaItem)
  }

  // @@protoc_insertion_point(class_scope:google.photos.library.v1.NewMediaItem)
  private static final com.google.photos.library.v1.proto.NewMediaItem DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.photos.library.v1.proto.NewMediaItem();
  }

  public static com.google.photos.library.v1.proto.NewMediaItem getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<NewMediaItem> PARSER =
      new com.google.protobuf.AbstractParser<NewMediaItem>() {
        @java.lang.Override
        public NewMediaItem parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new NewMediaItem(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<NewMediaItem> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<NewMediaItem> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.photos.library.v1.proto.NewMediaItem getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
