// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Articles.proto

package com.ubb.pcis2083.soa.articles;

/**
 * Protobuf type {@code com.ubb.pcis2083.soa.articles.Article}
 */
public  final class Article extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ubb.pcis2083.soa.articles.Article)
    ArticleOrBuilder {
  // Use Article.newBuilder() to construct.
  private Article(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Article() {
    id_ = 0L;
    title_ = "";
    text_ = "";
    labelId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Article(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt64();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            title_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            text_ = s;
            break;
          }
          case 32: {

            labelId_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ubb.pcis2083.soa.articles.Articles.internal_static_com_ubb_pcis2083_soa_articles_Article_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ubb.pcis2083.soa.articles.Articles.internal_static_com_ubb_pcis2083_soa_articles_Article_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ubb.pcis2083.soa.articles.Article.class, com.ubb.pcis2083.soa.articles.Article.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int TITLE_FIELD_NUMBER = 2;
  private volatile java.lang.Object title_;
  /**
   * <code>string title = 2;</code>
   */
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TEXT_FIELD_NUMBER = 3;
  private volatile java.lang.Object text_;
  /**
   * <code>string text = 3;</code>
   */
  public java.lang.String getText() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      text_ = s;
      return s;
    }
  }
  /**
   * <code>string text = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      text_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LABELID_FIELD_NUMBER = 4;
  private long labelId_;
  /**
   * <code>int64 labelId = 4;</code>
   */
  public long getLabelId() {
    return labelId_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (!getTitleBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, title_);
    }
    if (!getTextBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, text_);
    }
    if (labelId_ != 0L) {
      output.writeInt64(4, labelId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (!getTitleBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, title_);
    }
    if (!getTextBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, text_);
    }
    if (labelId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, labelId_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ubb.pcis2083.soa.articles.Article)) {
      return super.equals(obj);
    }
    com.ubb.pcis2083.soa.articles.Article other = (com.ubb.pcis2083.soa.articles.Article) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getTitle()
        .equals(other.getTitle());
    result = result && getText()
        .equals(other.getText());
    result = result && (getLabelId()
        == other.getLabelId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + TEXT_FIELD_NUMBER;
    hash = (53 * hash) + getText().hashCode();
    hash = (37 * hash) + LABELID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLabelId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ubb.pcis2083.soa.articles.Article parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ubb.pcis2083.soa.articles.Article prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.ubb.pcis2083.soa.articles.Article}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ubb.pcis2083.soa.articles.Article)
      com.ubb.pcis2083.soa.articles.ArticleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ubb.pcis2083.soa.articles.Articles.internal_static_com_ubb_pcis2083_soa_articles_Article_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ubb.pcis2083.soa.articles.Articles.internal_static_com_ubb_pcis2083_soa_articles_Article_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ubb.pcis2083.soa.articles.Article.class, com.ubb.pcis2083.soa.articles.Article.Builder.class);
    }

    // Construct using com.ubb.pcis2083.soa.articles.Article.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0L;

      title_ = "";

      text_ = "";

      labelId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ubb.pcis2083.soa.articles.Articles.internal_static_com_ubb_pcis2083_soa_articles_Article_descriptor;
    }

    public com.ubb.pcis2083.soa.articles.Article getDefaultInstanceForType() {
      return com.ubb.pcis2083.soa.articles.Article.getDefaultInstance();
    }

    public com.ubb.pcis2083.soa.articles.Article build() {
      com.ubb.pcis2083.soa.articles.Article result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.ubb.pcis2083.soa.articles.Article buildPartial() {
      com.ubb.pcis2083.soa.articles.Article result = new com.ubb.pcis2083.soa.articles.Article(this);
      result.id_ = id_;
      result.title_ = title_;
      result.text_ = text_;
      result.labelId_ = labelId_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ubb.pcis2083.soa.articles.Article) {
        return mergeFrom((com.ubb.pcis2083.soa.articles.Article)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ubb.pcis2083.soa.articles.Article other) {
      if (other == com.ubb.pcis2083.soa.articles.Article.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        onChanged();
      }
      if (!other.getText().isEmpty()) {
        text_ = other.text_;
        onChanged();
      }
      if (other.getLabelId() != 0L) {
        setLabelId(other.getLabelId());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ubb.pcis2083.soa.articles.Article parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ubb.pcis2083.soa.articles.Article) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_ ;
    /**
     * <code>int64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>int64 id = 1;</code>
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 2;</code>
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      title_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder clearTitle() {
      
      title_ = getDefaultInstance().getTitle();
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      title_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object text_ = "";
    /**
     * <code>string text = 3;</code>
     */
    public java.lang.String getText() {
      java.lang.Object ref = text_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        text_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string text = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      java.lang.Object ref = text_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        text_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string text = 3;</code>
     */
    public Builder setText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      text_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string text = 3;</code>
     */
    public Builder clearText() {
      
      text_ = getDefaultInstance().getText();
      onChanged();
      return this;
    }
    /**
     * <code>string text = 3;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      text_ = value;
      onChanged();
      return this;
    }

    private long labelId_ ;
    /**
     * <code>int64 labelId = 4;</code>
     */
    public long getLabelId() {
      return labelId_;
    }
    /**
     * <code>int64 labelId = 4;</code>
     */
    public Builder setLabelId(long value) {
      
      labelId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 labelId = 4;</code>
     */
    public Builder clearLabelId() {
      
      labelId_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.ubb.pcis2083.soa.articles.Article)
  }

  // @@protoc_insertion_point(class_scope:com.ubb.pcis2083.soa.articles.Article)
  private static final com.ubb.pcis2083.soa.articles.Article DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ubb.pcis2083.soa.articles.Article();
  }

  public static com.ubb.pcis2083.soa.articles.Article getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Article>
      PARSER = new com.google.protobuf.AbstractParser<Article>() {
    public Article parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Article(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Article> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Article> getParserForType() {
    return PARSER;
  }

  public com.ubb.pcis2083.soa.articles.Article getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

