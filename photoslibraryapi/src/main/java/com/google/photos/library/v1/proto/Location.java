// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/photos/library/v1/photos_library.proto

package com.google.photos.library.v1.proto;

/**
 *
 *
 * <pre>
 * Represents a physical location.
 * </pre>
 *
 * Protobuf type {@code google.photos.library.v1.Location}
 */
public final class Location extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.photos.library.v1.Location)
    LocationOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use Location.newBuilder() to construct.
  private Location(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private Location() {
    locationName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new Location();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private Location(
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

              locationName_ = s;
              break;
            }
          case 18:
            {
              com.google.type.LatLng.Builder subBuilder = null;
              if (latlng_ != null) {
                subBuilder = latlng_.toBuilder();
              }
              latlng_ = input.readMessage(com.google.type.LatLng.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(latlng_);
                latlng_ = subBuilder.buildPartial();
              }

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
        .internal_static_google_photos_library_v1_Location_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_Location_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.photos.library.v1.proto.Location.class,
            com.google.photos.library.v1.proto.Location.Builder.class);
  }

  public static final int LOCATION_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object locationName_;
  /**
   *
   *
   * <pre>
   * Name of the location to be displayed.
   * </pre>
   *
   * <code>string location_name = 1;</code>
   *
   * @return The locationName.
   */
  @java.lang.Override
  public java.lang.String getLocationName() {
    java.lang.Object ref = locationName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      locationName_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Name of the location to be displayed.
   * </pre>
   *
   * <code>string location_name = 1;</code>
   *
   * @return The bytes for locationName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getLocationNameBytes() {
    java.lang.Object ref = locationName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      locationName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LATLNG_FIELD_NUMBER = 2;
  private com.google.type.LatLng latlng_;
  /**
   *
   *
   * <pre>
   * Position of the location on the map.
   * </pre>
   *
   * <code>.google.type.LatLng latlng = 2;</code>
   *
   * @return Whether the latlng field is set.
   */
  @java.lang.Override
  public boolean hasLatlng() {
    return latlng_ != null;
  }
  /**
   *
   *
   * <pre>
   * Position of the location on the map.
   * </pre>
   *
   * <code>.google.type.LatLng latlng = 2;</code>
   *
   * @return The latlng.
   */
  @java.lang.Override
  public com.google.type.LatLng getLatlng() {
    return latlng_ == null ? com.google.type.LatLng.getDefaultInstance() : latlng_;
  }
  /**
   *
   *
   * <pre>
   * Position of the location on the map.
   * </pre>
   *
   * <code>.google.type.LatLng latlng = 2;</code>
   */
  @java.lang.Override
  public com.google.type.LatLngOrBuilder getLatlngOrBuilder() {
    return getLatlng();
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(locationName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, locationName_);
    }
    if (latlng_ != null) {
      output.writeMessage(2, getLatlng());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(locationName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, locationName_);
    }
    if (latlng_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getLatlng());
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
    if (!(obj instanceof com.google.photos.library.v1.proto.Location)) {
      return super.equals(obj);
    }
    com.google.photos.library.v1.proto.Location other =
        (com.google.photos.library.v1.proto.Location) obj;

    if (!getLocationName().equals(other.getLocationName())) return false;
    if (hasLatlng() != other.hasLatlng()) return false;
    if (hasLatlng()) {
      if (!getLatlng().equals(other.getLatlng())) return false;
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
    hash = (37 * hash) + LOCATION_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getLocationName().hashCode();
    if (hasLatlng()) {
      hash = (37 * hash) + LATLNG_FIELD_NUMBER;
      hash = (53 * hash) + getLatlng().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.Location parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.Location parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.Location parseFrom(
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

  public static Builder newBuilder(com.google.photos.library.v1.proto.Location prototype) {
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
   * Represents a physical location.
   * </pre>
   *
   * Protobuf type {@code google.photos.library.v1.Location}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.photos.library.v1.Location)
      com.google.photos.library.v1.proto.LocationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_Location_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_Location_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.photos.library.v1.proto.Location.class,
              com.google.photos.library.v1.proto.Location.Builder.class);
    }

    // Construct using com.google.photos.library.v1.proto.Location.newBuilder()
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
      locationName_ = "";

      if (latlngBuilder_ == null) {
        latlng_ = null;
      } else {
        latlng_ = null;
        latlngBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_Location_descriptor;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.Location getDefaultInstanceForType() {
      return com.google.photos.library.v1.proto.Location.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.Location build() {
      com.google.photos.library.v1.proto.Location result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.Location buildPartial() {
      com.google.photos.library.v1.proto.Location result =
          new com.google.photos.library.v1.proto.Location(this);
      result.locationName_ = locationName_;
      if (latlngBuilder_ == null) {
        result.latlng_ = latlng_;
      } else {
        result.latlng_ = latlngBuilder_.build();
      }
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
      if (other instanceof com.google.photos.library.v1.proto.Location) {
        return mergeFrom((com.google.photos.library.v1.proto.Location) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.photos.library.v1.proto.Location other) {
      if (other == com.google.photos.library.v1.proto.Location.getDefaultInstance()) return this;
      if (!other.getLocationName().isEmpty()) {
        locationName_ = other.locationName_;
        onChanged();
      }
      if (other.hasLatlng()) {
        mergeLatlng(other.getLatlng());
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
      com.google.photos.library.v1.proto.Location parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.photos.library.v1.proto.Location) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object locationName_ = "";
    /**
     *
     *
     * <pre>
     * Name of the location to be displayed.
     * </pre>
     *
     * <code>string location_name = 1;</code>
     *
     * @return The locationName.
     */
    public java.lang.String getLocationName() {
      java.lang.Object ref = locationName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        locationName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Name of the location to be displayed.
     * </pre>
     *
     * <code>string location_name = 1;</code>
     *
     * @return The bytes for locationName.
     */
    public com.google.protobuf.ByteString getLocationNameBytes() {
      java.lang.Object ref = locationName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        locationName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Name of the location to be displayed.
     * </pre>
     *
     * <code>string location_name = 1;</code>
     *
     * @param value The locationName to set.
     * @return This builder for chaining.
     */
    public Builder setLocationName(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      locationName_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Name of the location to be displayed.
     * </pre>
     *
     * <code>string location_name = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearLocationName() {

      locationName_ = getDefaultInstance().getLocationName();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Name of the location to be displayed.
     * </pre>
     *
     * <code>string location_name = 1;</code>
     *
     * @param value The bytes for locationName to set.
     * @return This builder for chaining.
     */
    public Builder setLocationNameBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      locationName_ = value;
      onChanged();
      return this;
    }

    private com.google.type.LatLng latlng_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.type.LatLng, com.google.type.LatLng.Builder, com.google.type.LatLngOrBuilder>
        latlngBuilder_;
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     *
     * @return Whether the latlng field is set.
     */
    public boolean hasLatlng() {
      return latlngBuilder_ != null || latlng_ != null;
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     *
     * @return The latlng.
     */
    public com.google.type.LatLng getLatlng() {
      if (latlngBuilder_ == null) {
        return latlng_ == null ? com.google.type.LatLng.getDefaultInstance() : latlng_;
      } else {
        return latlngBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public Builder setLatlng(com.google.type.LatLng value) {
      if (latlngBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        latlng_ = value;
        onChanged();
      } else {
        latlngBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public Builder setLatlng(com.google.type.LatLng.Builder builderForValue) {
      if (latlngBuilder_ == null) {
        latlng_ = builderForValue.build();
        onChanged();
      } else {
        latlngBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public Builder mergeLatlng(com.google.type.LatLng value) {
      if (latlngBuilder_ == null) {
        if (latlng_ != null) {
          latlng_ = com.google.type.LatLng.newBuilder(latlng_).mergeFrom(value).buildPartial();
        } else {
          latlng_ = value;
        }
        onChanged();
      } else {
        latlngBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public Builder clearLatlng() {
      if (latlngBuilder_ == null) {
        latlng_ = null;
        onChanged();
      } else {
        latlng_ = null;
        latlngBuilder_ = null;
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public com.google.type.LatLng.Builder getLatlngBuilder() {

      onChanged();
      return getLatlngFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    public com.google.type.LatLngOrBuilder getLatlngOrBuilder() {
      if (latlngBuilder_ != null) {
        return latlngBuilder_.getMessageOrBuilder();
      } else {
        return latlng_ == null ? com.google.type.LatLng.getDefaultInstance() : latlng_;
      }
    }
    /**
     *
     *
     * <pre>
     * Position of the location on the map.
     * </pre>
     *
     * <code>.google.type.LatLng latlng = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.type.LatLng, com.google.type.LatLng.Builder, com.google.type.LatLngOrBuilder>
        getLatlngFieldBuilder() {
      if (latlngBuilder_ == null) {
        latlngBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.type.LatLng,
                com.google.type.LatLng.Builder,
                com.google.type.LatLngOrBuilder>(getLatlng(), getParentForChildren(), isClean());
        latlng_ = null;
      }
      return latlngBuilder_;
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

    // @@protoc_insertion_point(builder_scope:google.photos.library.v1.Location)
  }

  // @@protoc_insertion_point(class_scope:google.photos.library.v1.Location)
  private static final com.google.photos.library.v1.proto.Location DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.photos.library.v1.proto.Location();
  }

  public static com.google.photos.library.v1.proto.Location getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Location> PARSER =
      new com.google.protobuf.AbstractParser<Location>() {
        @java.lang.Override
        public Location parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new Location(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<Location> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Location> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.photos.library.v1.proto.Location getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
