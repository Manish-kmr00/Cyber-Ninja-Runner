package io.bidmachine.protobuf;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.TimestampOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.adcom.PlacementOrBuilder;
import com.explorestack.protobuf.openrtb.Openrtb;
import com.explorestack.protobuf.openrtb.OpenrtbOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class ResponsePayload extends GeneratedMessageV3 implements ResponsePayloadOrBuilder {
    public static final int CACHE_TIME_FIELD_NUMBER = 1;
    private static final ResponsePayload DEFAULT_INSTANCE = new ResponsePayload();
    private static final Parser<ResponsePayload> PARSER = new AbstractParser<ResponsePayload>() { // from class: io.bidmachine.protobuf.ResponsePayload.1
        @Override // com.explorestack.protobuf.Parser
        public ResponsePayload parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ResponsePayload(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int REQUEST_ITEM_SPEC_FIELD_NUMBER = 4;
    public static final int RESPONSE_CACHE_FIELD_NUMBER = 3;
    public static final int RESPONSE_CACHE_URL_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private Timestamp cacheTime_;
    private byte memoizedIsInitialized;
    private int payloadOneofCase_;
    private Object payloadOneof_;
    private Placement requestItemSpec_;

    private ResponsePayload(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.payloadOneofCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private ResponsePayload() {
        this.payloadOneofCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ResponsePayload();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private ResponsePayload(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                Timestamp timestamp = this.cacheTime_;
                                Timestamp.Builder builder = timestamp != null ? timestamp.toBuilder() : null;
                                Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                this.cacheTime_ = timestamp2;
                                if (builder != null) {
                                    builder.mergeFrom(timestamp2);
                                    this.cacheTime_ = builder.buildPartial();
                                }
                            } else if (tag == 18) {
                                String stringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.payloadOneofCase_ = 2;
                                this.payloadOneof_ = stringRequireUtf8;
                            } else if (tag == 26) {
                                Openrtb.Builder builder2 = this.payloadOneofCase_ == 3 ? ((Openrtb) this.payloadOneof_).toBuilder() : null;
                                MessageLite message = codedInputStream.readMessage(Openrtb.parser(), extensionRegistryLite);
                                this.payloadOneof_ = message;
                                if (builder2 != null) {
                                    builder2.mergeFrom((Openrtb) message);
                                    this.payloadOneof_ = builder2.buildPartial();
                                }
                                this.payloadOneofCase_ = 3;
                            } else if (tag == 34) {
                                Placement placement = this.requestItemSpec_;
                                Placement.Builder builder3 = placement != null ? placement.toBuilder() : null;
                                Placement placement2 = (Placement) codedInputStream.readMessage(Placement.parser(), extensionRegistryLite);
                                this.requestItemSpec_ = placement2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(placement2);
                                    this.requestItemSpec_ = builder3.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        this.unknownFields = builderNewBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CacheProto.internal_static_bidmachine_protobuf_ResponsePayload_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CacheProto.internal_static_bidmachine_protobuf_ResponsePayload_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponsePayload.class, Builder.class);
    }

    public enum PayloadOneofCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        RESPONSE_CACHE_URL(2),
        RESPONSE_CACHE(3),
        PAYLOADONEOF_NOT_SET(0);

        private final int value;

        PayloadOneofCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static PayloadOneofCase valueOf(int i) {
            return forNumber(i);
        }

        public static PayloadOneofCase forNumber(int i) {
            if (i == 0) {
                return PAYLOADONEOF_NOT_SET;
            }
            if (i == 2) {
                return RESPONSE_CACHE_URL;
            }
            if (i != 3) {
                return null;
            }
            return RESPONSE_CACHE;
        }

        @Override // com.explorestack.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public PayloadOneofCase getPayloadOneofCase() {
        return PayloadOneofCase.forNumber(this.payloadOneofCase_);
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public boolean hasCacheTime() {
        return this.cacheTime_ != null;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public Timestamp getCacheTime() {
        Timestamp timestamp = this.cacheTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public TimestampOrBuilder getCacheTimeOrBuilder() {
        return getCacheTime();
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public boolean hasRequestItemSpec() {
        return this.requestItemSpec_ != null;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public Placement getRequestItemSpec() {
        Placement placement = this.requestItemSpec_;
        return placement == null ? Placement.getDefaultInstance() : placement;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public PlacementOrBuilder getRequestItemSpecOrBuilder() {
        return getRequestItemSpec();
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public boolean hasResponseCacheUrl() {
        return this.payloadOneofCase_ == 2;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public String getResponseCacheUrl() {
        Object obj;
        if (this.payloadOneofCase_ != 2) {
            obj = "";
        } else {
            obj = this.payloadOneof_;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        if (this.payloadOneofCase_ == 2) {
            this.payloadOneof_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public ByteString getResponseCacheUrlBytes() {
        Object obj;
        if (this.payloadOneofCase_ != 2) {
            obj = "";
        } else {
            obj = this.payloadOneof_;
        }
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            if (this.payloadOneofCase_ == 2) {
                this.payloadOneof_ = byteStringCopyFromUtf8;
            }
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public boolean hasResponseCache() {
        return this.payloadOneofCase_ == 3;
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public Openrtb getResponseCache() {
        if (this.payloadOneofCase_ == 3) {
            return (Openrtb) this.payloadOneof_;
        }
        return Openrtb.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
    public OpenrtbOrBuilder getResponseCacheOrBuilder() {
        if (this.payloadOneofCase_ == 3) {
            return (Openrtb) this.payloadOneof_;
        }
        return Openrtb.getDefaultInstance();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.cacheTime_ != null) {
            codedOutputStream.writeMessage(1, getCacheTime());
        }
        if (this.payloadOneofCase_ == 2) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.payloadOneof_);
        }
        if (this.payloadOneofCase_ == 3) {
            codedOutputStream.writeMessage(3, (Openrtb) this.payloadOneof_);
        }
        if (this.requestItemSpec_ != null) {
            codedOutputStream.writeMessage(4, getRequestItemSpec());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = this.cacheTime_ != null ? CodedOutputStream.computeMessageSize(1, getCacheTime()) : 0;
        if (this.payloadOneofCase_ == 2) {
            iComputeMessageSize += GeneratedMessageV3.computeStringSize(2, this.payloadOneof_);
        }
        if (this.payloadOneofCase_ == 3) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, (Openrtb) this.payloadOneof_);
        }
        if (this.requestItemSpec_ != null) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, getRequestItemSpec());
        }
        int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePayload)) {
            return super.equals(obj);
        }
        ResponsePayload responsePayload = (ResponsePayload) obj;
        if (hasCacheTime() != responsePayload.hasCacheTime()) {
            return false;
        }
        if ((hasCacheTime() && !getCacheTime().equals(responsePayload.getCacheTime())) || hasRequestItemSpec() != responsePayload.hasRequestItemSpec()) {
            return false;
        }
        if ((hasRequestItemSpec() && !getRequestItemSpec().equals(responsePayload.getRequestItemSpec())) || !getPayloadOneofCase().equals(responsePayload.getPayloadOneofCase())) {
            return false;
        }
        int i = this.payloadOneofCase_;
        if (i == 2) {
            if (!getResponseCacheUrl().equals(responsePayload.getResponseCacheUrl())) {
                return false;
            }
        } else if (i == 3 && !getResponseCache().equals(responsePayload.getResponseCache())) {
            return false;
        }
        return this.unknownFields.equals(responsePayload.unknownFields);
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        int i;
        int iHashCode;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode2 = 779 + getDescriptor().hashCode();
        if (hasCacheTime()) {
            iHashCode2 = (((iHashCode2 * 37) + 1) * 53) + getCacheTime().hashCode();
        }
        if (hasRequestItemSpec()) {
            iHashCode2 = (((iHashCode2 * 37) + 4) * 53) + getRequestItemSpec().hashCode();
        }
        int i2 = this.payloadOneofCase_;
        if (i2 == 2) {
            i = ((iHashCode2 * 37) + 2) * 53;
            iHashCode = getResponseCacheUrl().hashCode();
        } else {
            if (i2 == 3) {
                i = ((iHashCode2 * 37) + 3) * 53;
                iHashCode = getResponseCache().hashCode();
            }
            int iHashCode3 = (iHashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode3;
            return iHashCode3;
        }
        iHashCode2 = i + iHashCode;
        int iHashCode4 = (iHashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode4;
        return iHashCode4;
    }

    public static ResponsePayload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ResponsePayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ResponsePayload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ResponsePayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ResponsePayload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ResponsePayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ResponsePayload parseFrom(InputStream inputStream) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ResponsePayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResponsePayload parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ResponsePayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResponsePayload parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ResponsePayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResponsePayload) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ResponsePayload responsePayload) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(responsePayload);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.explorestack.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponsePayloadOrBuilder {
        private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> cacheTimeBuilder_;
        private Timestamp cacheTime_;
        private int payloadOneofCase_;
        private Object payloadOneof_;
        private SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> requestItemSpecBuilder_;
        private Placement requestItemSpec_;
        private SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> responseCacheBuilder_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CacheProto.internal_static_bidmachine_protobuf_ResponsePayload_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CacheProto.internal_static_bidmachine_protobuf_ResponsePayload_fieldAccessorTable.ensureFieldAccessorsInitialized(ResponsePayload.class, Builder.class);
        }

        private Builder() {
            this.payloadOneofCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.payloadOneofCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ResponsePayload.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.cacheTimeBuilder_ == null) {
                this.cacheTime_ = null;
            } else {
                this.cacheTime_ = null;
                this.cacheTimeBuilder_ = null;
            }
            if (this.requestItemSpecBuilder_ == null) {
                this.requestItemSpec_ = null;
            } else {
                this.requestItemSpec_ = null;
                this.requestItemSpecBuilder_ = null;
            }
            this.payloadOneofCase_ = 0;
            this.payloadOneof_ = null;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CacheProto.internal_static_bidmachine_protobuf_ResponsePayload_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public ResponsePayload getDefaultInstanceForType() {
            return ResponsePayload.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public ResponsePayload build() {
            ResponsePayload responsePayloadBuildPartial = buildPartial();
            if (responsePayloadBuildPartial.isInitialized()) {
                return responsePayloadBuildPartial;
            }
            throw newUninitializedMessageException((Message) responsePayloadBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public ResponsePayload buildPartial() {
            ResponsePayload responsePayload = new ResponsePayload(this);
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 == null) {
                responsePayload.cacheTime_ = this.cacheTime_;
            } else {
                responsePayload.cacheTime_ = (Timestamp) singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV4 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV4 == null) {
                responsePayload.requestItemSpec_ = this.requestItemSpec_;
            } else {
                responsePayload.requestItemSpec_ = (Placement) singleFieldBuilderV4.build();
            }
            if (this.payloadOneofCase_ == 2) {
                responsePayload.payloadOneof_ = this.payloadOneof_;
            }
            if (this.payloadOneofCase_ == 3) {
                SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV5 = this.responseCacheBuilder_;
                if (singleFieldBuilderV5 == null) {
                    responsePayload.payloadOneof_ = this.payloadOneof_;
                } else {
                    responsePayload.payloadOneof_ = singleFieldBuilderV5.build();
                }
            }
            responsePayload.payloadOneofCase_ = this.payloadOneofCase_;
            onBuilt();
            return responsePayload;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public Builder mo4742clone() {
            return (Builder) super.mo4742clone();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ResponsePayload) {
                return mergeFrom((ResponsePayload) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(ResponsePayload responsePayload) {
            if (responsePayload == ResponsePayload.getDefaultInstance()) {
                return this;
            }
            if (responsePayload.hasCacheTime()) {
                mergeCacheTime(responsePayload.getCacheTime());
            }
            if (responsePayload.hasRequestItemSpec()) {
                mergeRequestItemSpec(responsePayload.getRequestItemSpec());
            }
            int i = AnonymousClass2.$SwitchMap$io$bidmachine$protobuf$ResponsePayload$PayloadOneofCase[responsePayload.getPayloadOneofCase().ordinal()];
            if (i == 1) {
                this.payloadOneofCase_ = 2;
                this.payloadOneof_ = responsePayload.payloadOneof_;
                onChanged();
            } else if (i == 2) {
                mergeResponseCache(responsePayload.getResponseCache());
            }
            mergeUnknownFields(responsePayload.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ResponsePayload responsePayload = null;
            try {
                try {
                    ResponsePayload responsePayload2 = (ResponsePayload) ResponsePayload.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (responsePayload2 != null) {
                        mergeFrom(responsePayload2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ResponsePayload responsePayload3 = (ResponsePayload) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        responsePayload = responsePayload3;
                        if (responsePayload != null) {
                            mergeFrom(responsePayload);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (responsePayload != null) {
                    mergeFrom(responsePayload);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public PayloadOneofCase getPayloadOneofCase() {
            return PayloadOneofCase.forNumber(this.payloadOneofCase_);
        }

        public Builder clearPayloadOneof() {
            this.payloadOneofCase_ = 0;
            this.payloadOneof_ = null;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public boolean hasCacheTime() {
            return (this.cacheTimeBuilder_ == null && this.cacheTime_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public Timestamp getCacheTime() {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Timestamp timestamp = this.cacheTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilderV3.getMessage();
        }

        public Builder setCacheTime(Timestamp timestamp) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 == null) {
                timestamp.getClass();
                this.cacheTime_ = timestamp;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(timestamp);
            }
            return this;
        }

        public Builder setCacheTime(Timestamp.Builder builder) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.cacheTime_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeCacheTime(Timestamp timestamp) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Timestamp timestamp2 = this.cacheTime_;
                if (timestamp2 != null) {
                    this.cacheTime_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                } else {
                    this.cacheTime_ = timestamp;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(timestamp);
            }
            return this;
        }

        public Builder clearCacheTime() {
            if (this.cacheTimeBuilder_ == null) {
                this.cacheTime_ = null;
                onChanged();
            } else {
                this.cacheTime_ = null;
                this.cacheTimeBuilder_ = null;
            }
            return this;
        }

        public Timestamp.Builder getCacheTimeBuilder() {
            onChanged();
            return (Timestamp.Builder) getCacheTimeFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public TimestampOrBuilder getCacheTimeOrBuilder() {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.cacheTimeBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (TimestampOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Timestamp timestamp = this.cacheTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCacheTimeFieldBuilder() {
            if (this.cacheTimeBuilder_ == null) {
                this.cacheTimeBuilder_ = new SingleFieldBuilderV3<>(getCacheTime(), getParentForChildren(), isClean());
                this.cacheTime_ = null;
            }
            return this.cacheTimeBuilder_;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public boolean hasRequestItemSpec() {
            return (this.requestItemSpecBuilder_ == null && this.requestItemSpec_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public Placement getRequestItemSpec() {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV3 == null) {
                Placement placement = this.requestItemSpec_;
                return placement == null ? Placement.getDefaultInstance() : placement;
            }
            return (Placement) singleFieldBuilderV3.getMessage();
        }

        public Builder setRequestItemSpec(Placement placement) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV3 == null) {
                placement.getClass();
                this.requestItemSpec_ = placement;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(placement);
            }
            return this;
        }

        public Builder setRequestItemSpec(Placement.Builder builder) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.requestItemSpec_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeRequestItemSpec(Placement placement) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV3 == null) {
                Placement placement2 = this.requestItemSpec_;
                if (placement2 != null) {
                    this.requestItemSpec_ = Placement.newBuilder(placement2).mergeFrom(placement).buildPartial();
                } else {
                    this.requestItemSpec_ = placement;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(placement);
            }
            return this;
        }

        public Builder clearRequestItemSpec() {
            if (this.requestItemSpecBuilder_ == null) {
                this.requestItemSpec_ = null;
                onChanged();
            } else {
                this.requestItemSpec_ = null;
                this.requestItemSpecBuilder_ = null;
            }
            return this;
        }

        public Placement.Builder getRequestItemSpecBuilder() {
            onChanged();
            return (Placement.Builder) getRequestItemSpecFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public PlacementOrBuilder getRequestItemSpecOrBuilder() {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.requestItemSpecBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (PlacementOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Placement placement = this.requestItemSpec_;
            return placement == null ? Placement.getDefaultInstance() : placement;
        }

        private SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> getRequestItemSpecFieldBuilder() {
            if (this.requestItemSpecBuilder_ == null) {
                this.requestItemSpecBuilder_ = new SingleFieldBuilderV3<>(getRequestItemSpec(), getParentForChildren(), isClean());
                this.requestItemSpec_ = null;
            }
            return this.requestItemSpecBuilder_;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public boolean hasResponseCacheUrl() {
            return this.payloadOneofCase_ == 2;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public String getResponseCacheUrl() {
            Object obj;
            if (this.payloadOneofCase_ != 2) {
                obj = "";
            } else {
                obj = this.payloadOneof_;
            }
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                if (this.payloadOneofCase_ == 2) {
                    this.payloadOneof_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public ByteString getResponseCacheUrlBytes() {
            Object obj;
            if (this.payloadOneofCase_ != 2) {
                obj = "";
            } else {
                obj = this.payloadOneof_;
            }
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                if (this.payloadOneofCase_ == 2) {
                    this.payloadOneof_ = byteStringCopyFromUtf8;
                }
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setResponseCacheUrl(String str) {
            str.getClass();
            this.payloadOneofCase_ = 2;
            this.payloadOneof_ = str;
            onChanged();
            return this;
        }

        public Builder clearResponseCacheUrl() {
            if (this.payloadOneofCase_ == 2) {
                this.payloadOneofCase_ = 0;
                this.payloadOneof_ = null;
                onChanged();
            }
            return this;
        }

        public Builder setResponseCacheUrlBytes(ByteString byteString) {
            byteString.getClass();
            ResponsePayload.checkByteStringIsUtf8(byteString);
            this.payloadOneofCase_ = 2;
            this.payloadOneof_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public boolean hasResponseCache() {
            return this.payloadOneofCase_ == 3;
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public Openrtb getResponseCache() {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3 = this.responseCacheBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadOneofCase_ == 3) {
                    return (Openrtb) this.payloadOneof_;
                }
                return Openrtb.getDefaultInstance();
            }
            if (this.payloadOneofCase_ == 3) {
                return (Openrtb) singleFieldBuilderV3.getMessage();
            }
            return Openrtb.getDefaultInstance();
        }

        public Builder setResponseCache(Openrtb openrtb) {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3 = this.responseCacheBuilder_;
            if (singleFieldBuilderV3 == null) {
                openrtb.getClass();
                this.payloadOneof_ = openrtb;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(openrtb);
            }
            this.payloadOneofCase_ = 3;
            return this;
        }

        public Builder setResponseCache(Openrtb.Builder builder) {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3 = this.responseCacheBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.payloadOneof_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.payloadOneofCase_ = 3;
            return this;
        }

        public Builder mergeResponseCache(Openrtb openrtb) {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3 = this.responseCacheBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadOneofCase_ == 3 && this.payloadOneof_ != Openrtb.getDefaultInstance()) {
                    this.payloadOneof_ = Openrtb.newBuilder((Openrtb) this.payloadOneof_).mergeFrom(openrtb).buildPartial();
                } else {
                    this.payloadOneof_ = openrtb;
                }
                onChanged();
            } else {
                if (this.payloadOneofCase_ == 3) {
                    singleFieldBuilderV3.mergeFrom(openrtb);
                }
                this.responseCacheBuilder_.setMessage(openrtb);
            }
            this.payloadOneofCase_ = 3;
            return this;
        }

        public Builder clearResponseCache() {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3 = this.responseCacheBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.payloadOneofCase_ == 3) {
                    this.payloadOneofCase_ = 0;
                    this.payloadOneof_ = null;
                    onChanged();
                }
            } else {
                if (this.payloadOneofCase_ == 3) {
                    this.payloadOneofCase_ = 0;
                    this.payloadOneof_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Openrtb.Builder getResponseCacheBuilder() {
            return (Openrtb.Builder) getResponseCacheFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ResponsePayloadOrBuilder
        public OpenrtbOrBuilder getResponseCacheOrBuilder() {
            SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> singleFieldBuilderV3;
            int i = this.payloadOneofCase_;
            if (i == 3 && (singleFieldBuilderV3 = this.responseCacheBuilder_) != null) {
                return (OpenrtbOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i == 3) {
                return (Openrtb) this.payloadOneof_;
            }
            return Openrtb.getDefaultInstance();
        }

        private SingleFieldBuilderV3<Openrtb, Openrtb.Builder, OpenrtbOrBuilder> getResponseCacheFieldBuilder() {
            if (this.responseCacheBuilder_ == null) {
                if (this.payloadOneofCase_ != 3) {
                    this.payloadOneof_ = Openrtb.getDefaultInstance();
                }
                this.responseCacheBuilder_ = new SingleFieldBuilderV3<>((Openrtb) this.payloadOneof_, getParentForChildren(), isClean());
                this.payloadOneof_ = null;
            }
            this.payloadOneofCase_ = 3;
            onChanged();
            return this.responseCacheBuilder_;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    /* JADX INFO: renamed from: io.bidmachine.protobuf.ResponsePayload$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$ResponsePayload$PayloadOneofCase;

        static {
            int[] iArr = new int[PayloadOneofCase.values().length];
            $SwitchMap$io$bidmachine$protobuf$ResponsePayload$PayloadOneofCase = iArr;
            try {
                iArr[PayloadOneofCase.RESPONSE_CACHE_URL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$ResponsePayload$PayloadOneofCase[PayloadOneofCase.RESPONSE_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$ResponsePayload$PayloadOneofCase[PayloadOneofCase.PAYLOADONEOF_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ResponsePayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ResponsePayload> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<ResponsePayload> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public ResponsePayload getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
