package io.bidmachine.protobuf;

import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes11.dex */
public final class Extras extends GeneratedMessageV3 implements ExtrasOrBuilder {
    public static final int INTERNAL_FIELD_NUMBER = 2;
    public static final int PRIVATE_FIELD_NUMBER = 1;
    public static final int PUBLIC_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private Struct internal_;
    private byte memoizedIsInitialized;
    private Struct private_;
    private Struct public_;
    private static final Extras DEFAULT_INSTANCE = new Extras();
    private static final Parser<Extras> PARSER = new AbstractParser<Extras>() { // from class: io.bidmachine.protobuf.Extras.1
        @Override // com.explorestack.protobuf.Parser
        public Extras parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Extras(codedInputStream, extensionRegistryLite);
        }
    };

    private Extras(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Extras() {
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Extras();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Extras(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Struct.Builder builder;
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            Struct struct = this.private_;
                            builder = struct != null ? struct.toBuilder() : null;
                            Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            this.private_ = struct2;
                            if (builder != null) {
                                builder.mergeFrom(struct2);
                                this.private_ = builder.buildPartial();
                            }
                        } else if (tag == 18) {
                            Struct struct3 = this.internal_;
                            builder = struct3 != null ? struct3.toBuilder() : null;
                            Struct struct4 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            this.internal_ = struct4;
                            if (builder != null) {
                                builder.mergeFrom(struct4);
                                this.internal_ = builder.buildPartial();
                            }
                        } else if (tag == 26) {
                            Struct struct5 = this.public_;
                            builder = struct5 != null ? struct5.toBuilder() : null;
                            Struct struct6 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                            this.public_ = struct6;
                            if (builder != null) {
                                builder.mergeFrom(struct6);
                                this.public_ = builder.buildPartial();
                            }
                        } else if (!parseUnknownField(codedInputStream, builderNewBuilder, extensionRegistryLite, tag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
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
        return ExtensionsProto.internal_static_bidmachine_protobuf_Extras_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ExtensionsProto.internal_static_bidmachine_protobuf_Extras_fieldAccessorTable.ensureFieldAccessorsInitialized(Extras.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public boolean hasPrivate() {
        return this.private_ != null;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public Struct getPrivate() {
        Struct struct = this.private_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public StructOrBuilder getPrivateOrBuilder() {
        return getPrivate();
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public boolean hasInternal() {
        return this.internal_ != null;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public Struct getInternal() {
        Struct struct = this.internal_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public StructOrBuilder getInternalOrBuilder() {
        return getInternal();
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public boolean hasPublic() {
        return this.public_ != null;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public Struct getPublic() {
        Struct struct = this.public_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.ExtrasOrBuilder
    public StructOrBuilder getPublicOrBuilder() {
        return getPublic();
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
        if (this.private_ != null) {
            codedOutputStream.writeMessage(1, getPrivate());
        }
        if (this.internal_ != null) {
            codedOutputStream.writeMessage(2, getInternal());
        }
        if (this.public_ != null) {
            codedOutputStream.writeMessage(3, getPublic());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = this.private_ != null ? CodedOutputStream.computeMessageSize(1, getPrivate()) : 0;
        if (this.internal_ != null) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getInternal());
        }
        if (this.public_ != null) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, getPublic());
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
        if (!(obj instanceof Extras)) {
            return super.equals(obj);
        }
        Extras extras = (Extras) obj;
        if (hasPrivate() != extras.hasPrivate()) {
            return false;
        }
        if ((hasPrivate() && !getPrivate().equals(extras.getPrivate())) || hasInternal() != extras.hasInternal()) {
            return false;
        }
        if ((!hasInternal() || getInternal().equals(extras.getInternal())) && hasPublic() == extras.hasPublic()) {
            return (!hasPublic() || getPublic().equals(extras.getPublic())) && this.unknownFields.equals(extras.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = 779 + getDescriptor().hashCode();
        if (hasPrivate()) {
            iHashCode = (((iHashCode * 37) + 1) * 53) + getPrivate().hashCode();
        }
        if (hasInternal()) {
            iHashCode = (((iHashCode * 37) + 2) * 53) + getInternal().hashCode();
        }
        if (hasPublic()) {
            iHashCode = (((iHashCode * 37) + 3) * 53) + getPublic().hashCode();
        }
        int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashCode2;
        return iHashCode2;
    }

    public static Extras parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Extras parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Extras parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Extras parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Extras parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Extras parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Extras parseFrom(InputStream inputStream) throws IOException {
        return (Extras) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Extras parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Extras) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Extras parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Extras) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Extras parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Extras) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Extras parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Extras) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Extras parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Extras) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Extras extras) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(extras);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExtrasOrBuilder {
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> internalBuilder_;
        private Struct internal_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> privateBuilder_;
        private Struct private_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> publicBuilder_;
        private Struct public_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExtensionsProto.internal_static_bidmachine_protobuf_Extras_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExtensionsProto.internal_static_bidmachine_protobuf_Extras_fieldAccessorTable.ensureFieldAccessorsInitialized(Extras.class, Builder.class);
        }

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Extras.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.privateBuilder_ == null) {
                this.private_ = null;
            } else {
                this.private_ = null;
                this.privateBuilder_ = null;
            }
            if (this.internalBuilder_ == null) {
                this.internal_ = null;
            } else {
                this.internal_ = null;
                this.internalBuilder_ = null;
            }
            if (this.publicBuilder_ == null) {
                this.public_ = null;
            } else {
                this.public_ = null;
                this.publicBuilder_ = null;
            }
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ExtensionsProto.internal_static_bidmachine_protobuf_Extras_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Extras getDefaultInstanceForType() {
            return Extras.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Extras build() {
            Extras extrasBuildPartial = buildPartial();
            if (extrasBuildPartial.isInitialized()) {
                return extrasBuildPartial;
            }
            throw newUninitializedMessageException((Message) extrasBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Extras buildPartial() {
            Extras extras = new Extras(this);
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 == null) {
                extras.private_ = this.private_;
            } else {
                extras.private_ = (Struct) singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV4 = this.internalBuilder_;
            if (singleFieldBuilderV4 == null) {
                extras.internal_ = this.internal_;
            } else {
                extras.internal_ = (Struct) singleFieldBuilderV4.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV5 = this.publicBuilder_;
            if (singleFieldBuilderV5 == null) {
                extras.public_ = this.public_;
            } else {
                extras.public_ = (Struct) singleFieldBuilderV5.build();
            }
            onBuilt();
            return extras;
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
            if (message instanceof Extras) {
                return mergeFrom((Extras) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Extras extras) {
            if (extras == Extras.getDefaultInstance()) {
                return this;
            }
            if (extras.hasPrivate()) {
                mergePrivate(extras.getPrivate());
            }
            if (extras.hasInternal()) {
                mergeInternal(extras.getInternal());
            }
            if (extras.hasPublic()) {
                mergePublic(extras.getPublic());
            }
            mergeUnknownFields(extras.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            Extras extras = null;
            try {
                try {
                    Extras extras2 = (Extras) Extras.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (extras2 != null) {
                        mergeFrom(extras2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Extras extras3 = (Extras) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        extras = extras3;
                        if (extras != null) {
                            mergeFrom(extras);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (extras != null) {
                    mergeFrom(extras);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public boolean hasPrivate() {
            return (this.privateBuilder_ == null && this.private_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public Struct getPrivate() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.private_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return (Struct) singleFieldBuilderV3.getMessage();
        }

        public Builder setPrivate(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.private_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setPrivate(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.private_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergePrivate(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.private_;
                if (struct2 != null) {
                    this.private_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.private_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder clearPrivate() {
            if (this.privateBuilder_ == null) {
                this.private_ = null;
                onChanged();
            } else {
                this.private_ = null;
                this.privateBuilder_ = null;
            }
            return this;
        }

        public Struct.Builder getPrivateBuilder() {
            onChanged();
            return (Struct.Builder) getPrivateFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public StructOrBuilder getPrivateOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.privateBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (StructOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.private_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getPrivateFieldBuilder() {
            if (this.privateBuilder_ == null) {
                this.privateBuilder_ = new SingleFieldBuilderV3<>(getPrivate(), getParentForChildren(), isClean());
                this.private_ = null;
            }
            return this.privateBuilder_;
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public boolean hasInternal() {
            return (this.internalBuilder_ == null && this.internal_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public Struct getInternal() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.internalBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.internal_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return (Struct) singleFieldBuilderV3.getMessage();
        }

        public Builder setInternal(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.internalBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.internal_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setInternal(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.internalBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.internal_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergeInternal(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.internalBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.internal_;
                if (struct2 != null) {
                    this.internal_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.internal_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder clearInternal() {
            if (this.internalBuilder_ == null) {
                this.internal_ = null;
                onChanged();
            } else {
                this.internal_ = null;
                this.internalBuilder_ = null;
            }
            return this;
        }

        public Struct.Builder getInternalBuilder() {
            onChanged();
            return (Struct.Builder) getInternalFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public StructOrBuilder getInternalOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.internalBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (StructOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.internal_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getInternalFieldBuilder() {
            if (this.internalBuilder_ == null) {
                this.internalBuilder_ = new SingleFieldBuilderV3<>(getInternal(), getParentForChildren(), isClean());
                this.internal_ = null;
            }
            return this.internalBuilder_;
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public boolean hasPublic() {
            return (this.publicBuilder_ == null && this.public_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public Struct getPublic() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.publicBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.public_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return (Struct) singleFieldBuilderV3.getMessage();
        }

        public Builder setPublic(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.publicBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.public_ = struct;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(struct);
            }
            return this;
        }

        public Builder setPublic(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.publicBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.public_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder mergePublic(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.publicBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.public_;
                if (struct2 != null) {
                    this.public_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.public_ = struct;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(struct);
            }
            return this;
        }

        public Builder clearPublic() {
            if (this.publicBuilder_ == null) {
                this.public_ = null;
                onChanged();
            } else {
                this.public_ = null;
                this.publicBuilder_ = null;
            }
            return this;
        }

        public Struct.Builder getPublicBuilder() {
            onChanged();
            return (Struct.Builder) getPublicFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.ExtrasOrBuilder
        public StructOrBuilder getPublicOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.publicBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (StructOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.public_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getPublicFieldBuilder() {
            if (this.publicBuilder_ == null) {
                this.publicBuilder_ = new SingleFieldBuilderV3<>(getPublic(), getParentForChildren(), isClean());
                this.public_ = null;
            }
            return this.publicBuilder_;
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

    public static Extras getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Extras> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Extras> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Extras getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
