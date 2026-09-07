package io.bidmachine.protobuf.sdk;

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
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class User extends GeneratedMessageV3 implements UserOrBuilder {
    public static final int CCPA_FIELD_NUMBER = 3;
    public static final int CONSENT_FIELD_NUMBER = 1;
    public static final int COPPA_FIELD_NUMBER = 6;
    public static final int GDPR_FIELD_NUMBER = 2;
    public static final int GPP_FIELD_NUMBER = 4;
    public static final int GPP_SID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object ccpa_;
    private volatile Object consent_;
    private boolean coppa_;
    private boolean gdpr_;
    private int gppSidMemoizedSerializedSize;
    private Internal.IntList gppSid_;
    private volatile Object gpp_;
    private byte memoizedIsInitialized;
    private static final User DEFAULT_INSTANCE = new User();
    private static final Parser<User> PARSER = new AbstractParser<User>() { // from class: io.bidmachine.protobuf.sdk.User.1
        @Override // com.explorestack.protobuf.Parser
        public User parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new User(codedInputStream, extensionRegistryLite);
        }
    };

    private User(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.gppSidMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
    }

    private User() {
        this.gppSidMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.consent_ = "";
        this.ccpa_ = "";
        this.gpp_ = "";
        this.gppSid_ = emptyIntList();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new User();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private User(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            this.consent_ = codedInputStream.readStringRequireUtf8();
                        } else if (tag == 16) {
                            this.gdpr_ = codedInputStream.readBool();
                        } else if (tag == 26) {
                            this.ccpa_ = codedInputStream.readStringRequireUtf8();
                        } else if (tag == 34) {
                            this.gpp_ = codedInputStream.readStringRequireUtf8();
                        } else if (tag == 40) {
                            if (!z2) {
                                this.gppSid_ = newIntList();
                                z2 = true;
                            }
                            this.gppSid_.addInt(codedInputStream.readUInt32());
                        } else if (tag == 42) {
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (!z2 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.gppSid_ = newIntList();
                                z2 = true;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.gppSid_.addInt(codedInputStream.readUInt32());
                            }
                            codedInputStream.popLimit(iPushLimit);
                        } else if (tag == 48) {
                            this.coppa_ = codedInputStream.readBool();
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
                if (z2) {
                    this.gppSid_.makeImmutable();
                }
                this.unknownFields = builderNewBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2) {
            this.gppSid_.makeImmutable();
        }
        this.unknownFields = builderNewBuilder.build();
        makeExtensionsImmutable();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_User_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_User_fieldAccessorTable.ensureFieldAccessorsInitialized(User.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public String getConsent() {
        Object obj = this.consent_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.consent_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public ByteString getConsentBytes() {
        Object obj = this.consent_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.consent_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public boolean getGdpr() {
        return this.gdpr_;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public String getCcpa() {
        Object obj = this.ccpa_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.ccpa_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public ByteString getCcpaBytes() {
        Object obj = this.ccpa_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.ccpa_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public String getGpp() {
        Object obj = this.gpp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.gpp_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public ByteString getGppBytes() {
        Object obj = this.gpp_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.gpp_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public List<Integer> getGppSidList() {
        return this.gppSid_;
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public int getGppSidCount() {
        return this.gppSid_.size();
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public int getGppSid(int i) {
        return this.gppSid_.getInt(i);
    }

    @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
    public boolean getCoppa() {
        return this.coppa_;
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
        getSerializedSize();
        if (!getConsentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.consent_);
        }
        boolean z = this.gdpr_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        if (!getCcpaBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.ccpa_);
        }
        if (!getGppBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.gpp_);
        }
        if (getGppSidList().size() > 0) {
            codedOutputStream.writeUInt32NoTag(42);
            codedOutputStream.writeUInt32NoTag(this.gppSidMemoizedSerializedSize);
        }
        for (int i = 0; i < this.gppSid_.size(); i++) {
            codedOutputStream.writeUInt32NoTag(this.gppSid_.getInt(i));
        }
        boolean z2 = this.coppa_;
        if (z2) {
            codedOutputStream.writeBool(6, z2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int iComputeStringSize = !getConsentBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.consent_) : 0;
        boolean z = this.gdpr_;
        if (z) {
            iComputeStringSize += CodedOutputStream.computeBoolSize(2, z);
        }
        if (!getCcpaBytes().isEmpty()) {
            iComputeStringSize += GeneratedMessageV3.computeStringSize(3, this.ccpa_);
        }
        if (!getGppBytes().isEmpty()) {
            iComputeStringSize += GeneratedMessageV3.computeStringSize(4, this.gpp_);
        }
        int iComputeUInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.gppSid_.size(); i2++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(this.gppSid_.getInt(i2));
        }
        int iComputeBoolSize = iComputeStringSize + iComputeUInt32SizeNoTag;
        if (!getGppSidList().isEmpty()) {
            iComputeBoolSize = iComputeBoolSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeUInt32SizeNoTag);
        }
        this.gppSidMemoizedSerializedSize = iComputeUInt32SizeNoTag;
        boolean z2 = this.coppa_;
        if (z2) {
            iComputeBoolSize += CodedOutputStream.computeBoolSize(6, z2);
        }
        int serializedSize = iComputeBoolSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return super.equals(obj);
        }
        User user = (User) obj;
        return getConsent().equals(user.getConsent()) && getGdpr() == user.getGdpr() && getCcpa().equals(user.getCcpa()) && getGpp().equals(user.getGpp()) && getGppSidList().equals(user.getGppSidList()) && getCoppa() == user.getCoppa() && this.unknownFields.equals(user.unknownFields);
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int iHashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getConsent().hashCode()) * 37) + 2) * 53) + Internal.hashBoolean(getGdpr())) * 37) + 3) * 53) + getCcpa().hashCode()) * 37) + 4) * 53) + getGpp().hashCode();
        if (getGppSidCount() > 0) {
            iHashCode = (((iHashCode * 37) + 5) * 53) + getGppSidList().hashCode();
        }
        int iHashBoolean = (((((iHashCode * 37) + 6) * 53) + Internal.hashBoolean(getCoppa())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = iHashBoolean;
        return iHashBoolean;
    }

    public static User parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static User parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static User parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static User parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static User parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static User parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static User parseFrom(InputStream inputStream) throws IOException {
        return (User) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static User parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (User) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static User parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (User) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static User parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (User) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static User parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (User) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static User parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (User) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(User user) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(user);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserOrBuilder {
        private int bitField0_;
        private Object ccpa_;
        private Object consent_;
        private boolean coppa_;
        private boolean gdpr_;
        private Internal.IntList gppSid_;
        private Object gpp_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_User_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_User_fieldAccessorTable.ensureFieldAccessorsInitialized(User.class, Builder.class);
        }

        private Builder() {
            this.consent_ = "";
            this.ccpa_ = "";
            this.gpp_ = "";
            this.gppSid_ = User.emptyIntList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.consent_ = "";
            this.ccpa_ = "";
            this.gpp_ = "";
            this.gppSid_ = User.emptyIntList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = User.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.consent_ = "";
            this.gdpr_ = false;
            this.ccpa_ = "";
            this.gpp_ = "";
            this.gppSid_ = User.emptyIntList();
            this.bitField0_ &= -2;
            this.coppa_ = false;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SDKContextProto.internal_static_bidmachine_protobuf_sdk_context_User_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public User getDefaultInstanceForType() {
            return User.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public User build() {
            User userBuildPartial = buildPartial();
            if (userBuildPartial.isInitialized()) {
                return userBuildPartial;
            }
            throw newUninitializedMessageException((Message) userBuildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public User buildPartial() {
            User user = new User(this);
            user.consent_ = this.consent_;
            user.gdpr_ = this.gdpr_;
            user.ccpa_ = this.ccpa_;
            user.gpp_ = this.gpp_;
            if ((this.bitField0_ & 1) != 0) {
                this.gppSid_.makeImmutable();
                this.bitField0_ &= -2;
            }
            user.gppSid_ = this.gppSid_;
            user.coppa_ = this.coppa_;
            onBuilt();
            return user;
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
            if (message instanceof User) {
                return mergeFrom((User) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(User user) {
            if (user == User.getDefaultInstance()) {
                return this;
            }
            if (!user.getConsent().isEmpty()) {
                this.consent_ = user.consent_;
                onChanged();
            }
            if (user.getGdpr()) {
                setGdpr(user.getGdpr());
            }
            if (!user.getCcpa().isEmpty()) {
                this.ccpa_ = user.ccpa_;
                onChanged();
            }
            if (!user.getGpp().isEmpty()) {
                this.gpp_ = user.gpp_;
                onChanged();
            }
            if (!user.gppSid_.isEmpty()) {
                if (this.gppSid_.isEmpty()) {
                    this.gppSid_ = user.gppSid_;
                    this.bitField0_ &= -2;
                } else {
                    ensureGppSidIsMutable();
                    this.gppSid_.addAll(user.gppSid_);
                }
                onChanged();
            }
            if (user.getCoppa()) {
                setCoppa(user.getCoppa());
            }
            mergeUnknownFields(user.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            User user = null;
            try {
                try {
                    User user2 = (User) User.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (user2 != null) {
                        mergeFrom(user2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    User user3 = (User) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        user = user3;
                        if (user != null) {
                            mergeFrom(user);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (user != null) {
                    mergeFrom(user);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public String getConsent() {
            Object obj = this.consent_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.consent_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public ByteString getConsentBytes() {
            Object obj = this.consent_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.consent_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setConsent(String str) {
            str.getClass();
            this.consent_ = str;
            onChanged();
            return this;
        }

        public Builder clearConsent() {
            this.consent_ = User.getDefaultInstance().getConsent();
            onChanged();
            return this;
        }

        public Builder setConsentBytes(ByteString byteString) {
            byteString.getClass();
            User.checkByteStringIsUtf8(byteString);
            this.consent_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public boolean getGdpr() {
            return this.gdpr_;
        }

        public Builder setGdpr(boolean z) {
            this.gdpr_ = z;
            onChanged();
            return this;
        }

        public Builder clearGdpr() {
            this.gdpr_ = false;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public String getCcpa() {
            Object obj = this.ccpa_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.ccpa_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public ByteString getCcpaBytes() {
            Object obj = this.ccpa_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ccpa_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setCcpa(String str) {
            str.getClass();
            this.ccpa_ = str;
            onChanged();
            return this;
        }

        public Builder clearCcpa() {
            this.ccpa_ = User.getDefaultInstance().getCcpa();
            onChanged();
            return this;
        }

        public Builder setCcpaBytes(ByteString byteString) {
            byteString.getClass();
            User.checkByteStringIsUtf8(byteString);
            this.ccpa_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public String getGpp() {
            Object obj = this.gpp_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.gpp_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public ByteString getGppBytes() {
            Object obj = this.gpp_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.gpp_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setGpp(String str) {
            str.getClass();
            this.gpp_ = str;
            onChanged();
            return this;
        }

        public Builder clearGpp() {
            this.gpp_ = User.getDefaultInstance().getGpp();
            onChanged();
            return this;
        }

        public Builder setGppBytes(ByteString byteString) {
            byteString.getClass();
            User.checkByteStringIsUtf8(byteString);
            this.gpp_ = byteString;
            onChanged();
            return this;
        }

        private void ensureGppSidIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.gppSid_ = User.mutableCopy(this.gppSid_);
                this.bitField0_ |= 1;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public List<Integer> getGppSidList() {
            return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.gppSid_) : this.gppSid_;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public int getGppSidCount() {
            return this.gppSid_.size();
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public int getGppSid(int i) {
            return this.gppSid_.getInt(i);
        }

        public Builder setGppSid(int i, int i2) {
            ensureGppSidIsMutable();
            this.gppSid_.setInt(i, i2);
            onChanged();
            return this;
        }

        public Builder addGppSid(int i) {
            ensureGppSidIsMutable();
            this.gppSid_.addInt(i);
            onChanged();
            return this;
        }

        public Builder addAllGppSid(Iterable<? extends Integer> iterable) {
            ensureGppSidIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gppSid_);
            onChanged();
            return this;
        }

        public Builder clearGppSid() {
            this.gppSid_ = User.emptyIntList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.UserOrBuilder
        public boolean getCoppa() {
            return this.coppa_;
        }

        public Builder setCoppa(boolean z) {
            this.coppa_ = z;
            onChanged();
            return this;
        }

        public Builder clearCoppa() {
            this.coppa_ = false;
            onChanged();
            return this;
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

    public static User getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<User> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<User> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public User getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
