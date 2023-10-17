// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/photos/library/v1/photos_library.proto

package com.google.photos.library.v1.proto;

/**
 *
 *
 * <pre>
 * An enrichment containing a map, showing origin and destination locations.
 * </pre>
 *
 * Protobuf type {@code google.photos.library.v1.MapEnrichment}
 */
public final class MapEnrichment extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.photos.library.v1.MapEnrichment)
    MapEnrichmentOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use MapEnrichment.newBuilder() to construct.
  private MapEnrichment(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private MapEnrichment() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new MapEnrichment();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_MapEnrichment_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.photos.library.v1.proto.LibraryServiceProto
        .internal_static_google_photos_library_v1_MapEnrichment_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.photos.library.v1.proto.MapEnrichment.class,
            com.google.photos.library.v1.proto.MapEnrichment.Builder.class);
  }

  public static final int ORIGIN_FIELD_NUMBER = 1;
  private com.google.photos.library.v1.proto.Location origin_;
  /**
   *
   *
   * <pre>
   * Origin location for this enrichment item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location origin = 1;</code>
   *
   * @return Whether the origin field is set.
   */
  @java.lang.Override
  public boolean hasOrigin() {
    return origin_ != null;
  }
  /**
   *
   *
   * <pre>
   * Origin location for this enrichment item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location origin = 1;</code>
   *
   * @return The origin.
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.Location getOrigin() {
    return origin_ == null
        ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
        : origin_;
  }
  /**
   *
   *
   * <pre>
   * Origin location for this enrichment item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location origin = 1;</code>
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.LocationOrBuilder getOriginOrBuilder() {
    return origin_ == null
        ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
        : origin_;
  }

  public static final int DESTINATION_FIELD_NUMBER = 2;
  private com.google.photos.library.v1.proto.Location destination_;
  /**
   *
   *
   * <pre>
   * Destination location for this enrichemt item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location destination = 2;</code>
   *
   * @return Whether the destination field is set.
   */
  @java.lang.Override
  public boolean hasDestination() {
    return destination_ != null;
  }
  /**
   *
   *
   * <pre>
   * Destination location for this enrichemt item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location destination = 2;</code>
   *
   * @return The destination.
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.Location getDestination() {
    return destination_ == null
        ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
        : destination_;
  }
  /**
   *
   *
   * <pre>
   * Destination location for this enrichemt item.
   * </pre>
   *
   * <code>.google.photos.library.v1.Location destination = 2;</code>
   */
  @java.lang.Override
  public com.google.photos.library.v1.proto.LocationOrBuilder getDestinationOrBuilder() {
    return destination_ == null
        ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
        : destination_;
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
    if (origin_ != null) {
      output.writeMessage(1, getOrigin());
    }
    if (destination_ != null) {
      output.writeMessage(2, getDestination());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (origin_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getOrigin());
    }
    if (destination_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getDestination());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.photos.library.v1.proto.MapEnrichment)) {
      return super.equals(obj);
    }
    com.google.photos.library.v1.proto.MapEnrichment other =
        (com.google.photos.library.v1.proto.MapEnrichment) obj;

    if (hasOrigin() != other.hasOrigin()) return false;
    if (hasOrigin()) {
      if (!getOrigin().equals(other.getOrigin())) return false;
    }
    if (hasDestination() != other.hasDestination()) return false;
    if (hasDestination()) {
      if (!getDestination().equals(other.getDestination())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasOrigin()) {
      hash = (37 * hash) + ORIGIN_FIELD_NUMBER;
      hash = (53 * hash) + getOrigin().hashCode();
    }
    if (hasDestination()) {
      hash = (37 * hash) + DESTINATION_FIELD_NUMBER;
      hash = (53 * hash) + getDestination().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.photos.library.v1.proto.MapEnrichment parseFrom(
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

  public static Builder newBuilder(com.google.photos.library.v1.proto.MapEnrichment prototype) {
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
   * An enrichment containing a map, showing origin and destination locations.
   * </pre>
   *
   * Protobuf type {@code google.photos.library.v1.MapEnrichment}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.photos.library.v1.MapEnrichment)
      com.google.photos.library.v1.proto.MapEnrichmentOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_MapEnrichment_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_MapEnrichment_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.photos.library.v1.proto.MapEnrichment.class,
              com.google.photos.library.v1.proto.MapEnrichment.Builder.class);
    }

    // Construct using com.google.photos.library.v1.proto.MapEnrichment.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      origin_ = null;
      if (originBuilder_ != null) {
        originBuilder_.dispose();
        originBuilder_ = null;
      }
      destination_ = null;
      if (destinationBuilder_ != null) {
        destinationBuilder_.dispose();
        destinationBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.photos.library.v1.proto.LibraryServiceProto
          .internal_static_google_photos_library_v1_MapEnrichment_descriptor;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.MapEnrichment getDefaultInstanceForType() {
      return com.google.photos.library.v1.proto.MapEnrichment.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.MapEnrichment build() {
      com.google.photos.library.v1.proto.MapEnrichment result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.photos.library.v1.proto.MapEnrichment buildPartial() {
      com.google.photos.library.v1.proto.MapEnrichment result =
          new com.google.photos.library.v1.proto.MapEnrichment(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.photos.library.v1.proto.MapEnrichment result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.origin_ = originBuilder_ == null ? origin_ : originBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.destination_ =
            destinationBuilder_ == null ? destination_ : destinationBuilder_.build();
      }
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
      if (other instanceof com.google.photos.library.v1.proto.MapEnrichment) {
        return mergeFrom((com.google.photos.library.v1.proto.MapEnrichment) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.photos.library.v1.proto.MapEnrichment other) {
      if (other == com.google.photos.library.v1.proto.MapEnrichment.getDefaultInstance())
        return this;
      if (other.hasOrigin()) {
        mergeOrigin(other.getOrigin());
      }
      if (other.hasDestination()) {
        mergeDestination(other.getDestination());
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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
                input.readMessage(getOriginFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 18:
              {
                input.readMessage(getDestinationFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private com.google.photos.library.v1.proto.Location origin_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.Location,
            com.google.photos.library.v1.proto.Location.Builder,
            com.google.photos.library.v1.proto.LocationOrBuilder>
        originBuilder_;
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     *
     * @return Whether the origin field is set.
     */
    public boolean hasOrigin() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     *
     * @return The origin.
     */
    public com.google.photos.library.v1.proto.Location getOrigin() {
      if (originBuilder_ == null) {
        return origin_ == null
            ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
            : origin_;
      } else {
        return originBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public Builder setOrigin(com.google.photos.library.v1.proto.Location value) {
      if (originBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        origin_ = value;
      } else {
        originBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public Builder setOrigin(com.google.photos.library.v1.proto.Location.Builder builderForValue) {
      if (originBuilder_ == null) {
        origin_ = builderForValue.build();
      } else {
        originBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public Builder mergeOrigin(com.google.photos.library.v1.proto.Location value) {
      if (originBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)
            && origin_ != null
            && origin_ != com.google.photos.library.v1.proto.Location.getDefaultInstance()) {
          getOriginBuilder().mergeFrom(value);
        } else {
          origin_ = value;
        }
      } else {
        originBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public Builder clearOrigin() {
      bitField0_ = (bitField0_ & ~0x00000001);
      origin_ = null;
      if (originBuilder_ != null) {
        originBuilder_.dispose();
        originBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public com.google.photos.library.v1.proto.Location.Builder getOriginBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getOriginFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    public com.google.photos.library.v1.proto.LocationOrBuilder getOriginOrBuilder() {
      if (originBuilder_ != null) {
        return originBuilder_.getMessageOrBuilder();
      } else {
        return origin_ == null
            ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
            : origin_;
      }
    }
    /**
     *
     *
     * <pre>
     * Origin location for this enrichment item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location origin = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.Location,
            com.google.photos.library.v1.proto.Location.Builder,
            com.google.photos.library.v1.proto.LocationOrBuilder>
        getOriginFieldBuilder() {
      if (originBuilder_ == null) {
        originBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.photos.library.v1.proto.Location,
                com.google.photos.library.v1.proto.Location.Builder,
                com.google.photos.library.v1.proto.LocationOrBuilder>(
                getOrigin(), getParentForChildren(), isClean());
        origin_ = null;
      }
      return originBuilder_;
    }

    private com.google.photos.library.v1.proto.Location destination_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.Location,
            com.google.photos.library.v1.proto.Location.Builder,
            com.google.photos.library.v1.proto.LocationOrBuilder>
        destinationBuilder_;
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     *
     * @return Whether the destination field is set.
     */
    public boolean hasDestination() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     *
     * @return The destination.
     */
    public com.google.photos.library.v1.proto.Location getDestination() {
      if (destinationBuilder_ == null) {
        return destination_ == null
            ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
            : destination_;
      } else {
        return destinationBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public Builder setDestination(com.google.photos.library.v1.proto.Location value) {
      if (destinationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        destination_ = value;
      } else {
        destinationBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public Builder setDestination(
        com.google.photos.library.v1.proto.Location.Builder builderForValue) {
      if (destinationBuilder_ == null) {
        destination_ = builderForValue.build();
      } else {
        destinationBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public Builder mergeDestination(com.google.photos.library.v1.proto.Location value) {
      if (destinationBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)
            && destination_ != null
            && destination_ != com.google.photos.library.v1.proto.Location.getDefaultInstance()) {
          getDestinationBuilder().mergeFrom(value);
        } else {
          destination_ = value;
        }
      } else {
        destinationBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public Builder clearDestination() {
      bitField0_ = (bitField0_ & ~0x00000002);
      destination_ = null;
      if (destinationBuilder_ != null) {
        destinationBuilder_.dispose();
        destinationBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public com.google.photos.library.v1.proto.Location.Builder getDestinationBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getDestinationFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    public com.google.photos.library.v1.proto.LocationOrBuilder getDestinationOrBuilder() {
      if (destinationBuilder_ != null) {
        return destinationBuilder_.getMessageOrBuilder();
      } else {
        return destination_ == null
            ? com.google.photos.library.v1.proto.Location.getDefaultInstance()
            : destination_;
      }
    }
    /**
     *
     *
     * <pre>
     * Destination location for this enrichemt item.
     * </pre>
     *
     * <code>.google.photos.library.v1.Location destination = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.photos.library.v1.proto.Location,
            com.google.photos.library.v1.proto.Location.Builder,
            com.google.photos.library.v1.proto.LocationOrBuilder>
        getDestinationFieldBuilder() {
      if (destinationBuilder_ == null) {
        destinationBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.photos.library.v1.proto.Location,
                com.google.photos.library.v1.proto.Location.Builder,
                com.google.photos.library.v1.proto.LocationOrBuilder>(
                getDestination(), getParentForChildren(), isClean());
        destination_ = null;
      }
      return destinationBuilder_;
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

    // @@protoc_insertion_point(builder_scope:google.photos.library.v1.MapEnrichment)
  }

  // @@protoc_insertion_point(class_scope:google.photos.library.v1.MapEnrichment)
  private static final com.google.photos.library.v1.proto.MapEnrichment DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.photos.library.v1.proto.MapEnrichment();
  }

  public static com.google.photos.library.v1.proto.MapEnrichment getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MapEnrichment> PARSER =
      new com.google.protobuf.AbstractParser<MapEnrichment>() {
        @java.lang.Override
        public MapEnrichment parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<MapEnrichment> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MapEnrichment> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.photos.library.v1.proto.MapEnrichment getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}