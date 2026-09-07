package com.moloco.sdk;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BidToken {

    public interface BidTokenRequestV2OrBuilder extends MessageLiteOrBuilder {
        BidTokenRequestV2.BidTokenComponents getBidTokenComponents();

        boolean hasBidTokenComponents();
    }

    public interface BidTokenRequestV3OrBuilder extends MessageLiteOrBuilder {
    }

    public interface BidTokenResponseV2OrBuilder extends MessageLiteOrBuilder {
        String getBidToken();

        ByteString getBidTokenBytes();
    }

    public interface BidTokenResponseV3OrBuilder extends MessageLiteOrBuilder {
        String getBidToken();

        ByteString getBidTokenBytes();

        BidTokenResponseV3.ClientTokenConfigs getClientTokenConfigs();

        String getPk();

        ByteString getPkBytes();

        boolean hasClientTokenConfigs();
    }

    public interface ClientBidTokenComponentsOrBuilder extends MessageLiteOrBuilder {
        ClientBidTokenComponents.AccessibilityInfo getAccessibilityInfo();

        ClientBidTokenComponents.AdvertisingInfo getAdInfo();

        ClientBidTokenComponents.AudioInfo getAudioInfo();

        ClientBidTokenComponents.BatteryInfo getBatteryInfo();

        ClientBidTokenComponents.Device getDevice();

        ClientBidTokenComponents.DirInfo getDirInfo();

        String getIdfv();

        ByteString getIdfvBytes();

        ClientBidTokenComponents.SdkInfo getInfo();

        ClientBidTokenComponents.MemoryInfo getMemoryInfo();

        ClientBidTokenComponents.NetworkInfo getNetworkInfo();

        ClientBidTokenComponents.Privacy getPrivacy();

        boolean hasAccessibilityInfo();

        boolean hasAdInfo();

        boolean hasAudioInfo();

        boolean hasBatteryInfo();

        boolean hasDevice();

        boolean hasDirInfo();

        boolean hasIdfv();

        boolean hasInfo();

        boolean hasMemoryInfo();

        boolean hasNetworkInfo();

        boolean hasPrivacy();
    }

    public interface ClientBidTokenOrBuilder extends MessageLiteOrBuilder {
        ByteString getEs();

        ByteString getPayload();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private BidToken() {
    }

    public static final class BidTokenRequestV2 extends GeneratedMessageLite<BidTokenRequestV2, Builder> implements BidTokenRequestV2OrBuilder {
        public static final int BID_TOKEN_COMPONENTS_FIELD_NUMBER = 2;
        private static final BidTokenRequestV2 DEFAULT_INSTANCE;
        private static volatile Parser<BidTokenRequestV2> PARSER;
        private BidTokenComponents bidTokenComponents_;

        public interface BidTokenComponentsOrBuilder extends MessageLiteOrBuilder {
            String getIdfv();

            ByteString getIdfvBytes();

            BidTokenComponents.Privacy getPrivacy();

            boolean hasIdfv();

            boolean hasPrivacy();
        }

        private BidTokenRequestV2() {
        }

        public static final class BidTokenComponents extends GeneratedMessageLite<BidTokenComponents, Builder> implements BidTokenComponentsOrBuilder {
            private static final BidTokenComponents DEFAULT_INSTANCE;
            public static final int IDFV_FIELD_NUMBER = 1;
            private static volatile Parser<BidTokenComponents> PARSER = null;
            public static final int PRIVACY_FIELD_NUMBER = 2;
            private int bitField0_;
            private String idfv_ = "";
            private Privacy privacy_;

            public interface PrivacyOrBuilder extends MessageLiteOrBuilder {
                boolean getCcpa();

                boolean getCoppa();

                boolean getGdpr();

                String getTcfConsentString();

                ByteString getTcfConsentStringBytes();

                String getUsPrivacy();

                ByteString getUsPrivacyBytes();

                boolean hasCcpa();

                boolean hasCoppa();

                boolean hasGdpr();

                boolean hasTcfConsentString();

                boolean hasUsPrivacy();
            }

            private BidTokenComponents() {
            }

            public static final class Privacy extends GeneratedMessageLite<Privacy, Builder> implements PrivacyOrBuilder {
                public static final int CCPA_FIELD_NUMBER = 1;
                public static final int COPPA_FIELD_NUMBER = 3;
                private static final Privacy DEFAULT_INSTANCE;
                public static final int GDPR_FIELD_NUMBER = 2;
                private static volatile Parser<Privacy> PARSER = null;
                public static final int TCF_CONSENT_STRING_FIELD_NUMBER = 5;
                public static final int US_PRIVACY_FIELD_NUMBER = 4;
                private int bitField0_;
                private boolean ccpa_;
                private boolean coppa_;
                private boolean gdpr_;
                private String usPrivacy_ = "";
                private String tcfConsentString_ = "";

                private Privacy() {
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean hasCcpa() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean getCcpa() {
                    return this.ccpa_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCcpa(boolean z) {
                    this.bitField0_ |= 1;
                    this.ccpa_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCcpa() {
                    this.bitField0_ &= -2;
                    this.ccpa_ = false;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean hasGdpr() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean getGdpr() {
                    return this.gdpr_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setGdpr(boolean z) {
                    this.bitField0_ |= 2;
                    this.gdpr_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearGdpr() {
                    this.bitField0_ &= -3;
                    this.gdpr_ = false;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean hasCoppa() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean getCoppa() {
                    return this.coppa_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCoppa(boolean z) {
                    this.bitField0_ |= 4;
                    this.coppa_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCoppa() {
                    this.bitField0_ &= -5;
                    this.coppa_ = false;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean hasUsPrivacy() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public String getUsPrivacy() {
                    return this.usPrivacy_;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public ByteString getUsPrivacyBytes() {
                    return ByteString.copyFromUtf8(this.usPrivacy_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setUsPrivacy(String str) {
                    str.getClass();
                    this.bitField0_ |= 8;
                    this.usPrivacy_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearUsPrivacy() {
                    this.bitField0_ &= -9;
                    this.usPrivacy_ = getDefaultInstance().getUsPrivacy();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setUsPrivacyBytes(ByteString byteString) {
                    checkByteStringIsUtf8(byteString);
                    this.usPrivacy_ = byteString.toStringUtf8();
                    this.bitField0_ |= 8;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public boolean hasTcfConsentString() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public String getTcfConsentString() {
                    return this.tcfConsentString_;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                public ByteString getTcfConsentStringBytes() {
                    return ByteString.copyFromUtf8(this.tcfConsentString_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setTcfConsentString(String str) {
                    str.getClass();
                    this.bitField0_ |= 16;
                    this.tcfConsentString_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearTcfConsentString() {
                    this.bitField0_ &= -17;
                    this.tcfConsentString_ = getDefaultInstance().getTcfConsentString();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setTcfConsentStringBytes(ByteString byteString) {
                    checkByteStringIsUtf8(byteString);
                    this.tcfConsentString_ = byteString.toStringUtf8();
                    this.bitField0_ |= 16;
                }

                public static Privacy parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Privacy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Privacy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Privacy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Privacy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Privacy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Privacy parseFrom(InputStream inputStream) throws IOException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Privacy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Privacy parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Privacy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Privacy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Privacy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Privacy parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Privacy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Builder newBuilder(Privacy privacy) {
                    return DEFAULT_INSTANCE.createBuilder(privacy);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<Privacy, Builder> implements PrivacyOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Privacy.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean hasCcpa() {
                        return ((Privacy) this.instance).hasCcpa();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean getCcpa() {
                        return ((Privacy) this.instance).getCcpa();
                    }

                    public Builder setCcpa(boolean z) {
                        copyOnWrite();
                        ((Privacy) this.instance).setCcpa(z);
                        return this;
                    }

                    public Builder clearCcpa() {
                        copyOnWrite();
                        ((Privacy) this.instance).clearCcpa();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean hasGdpr() {
                        return ((Privacy) this.instance).hasGdpr();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean getGdpr() {
                        return ((Privacy) this.instance).getGdpr();
                    }

                    public Builder setGdpr(boolean z) {
                        copyOnWrite();
                        ((Privacy) this.instance).setGdpr(z);
                        return this;
                    }

                    public Builder clearGdpr() {
                        copyOnWrite();
                        ((Privacy) this.instance).clearGdpr();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean hasCoppa() {
                        return ((Privacy) this.instance).hasCoppa();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean getCoppa() {
                        return ((Privacy) this.instance).getCoppa();
                    }

                    public Builder setCoppa(boolean z) {
                        copyOnWrite();
                        ((Privacy) this.instance).setCoppa(z);
                        return this;
                    }

                    public Builder clearCoppa() {
                        copyOnWrite();
                        ((Privacy) this.instance).clearCoppa();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean hasUsPrivacy() {
                        return ((Privacy) this.instance).hasUsPrivacy();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public String getUsPrivacy() {
                        return ((Privacy) this.instance).getUsPrivacy();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public ByteString getUsPrivacyBytes() {
                        return ((Privacy) this.instance).getUsPrivacyBytes();
                    }

                    public Builder setUsPrivacy(String str) {
                        copyOnWrite();
                        ((Privacy) this.instance).setUsPrivacy(str);
                        return this;
                    }

                    public Builder clearUsPrivacy() {
                        copyOnWrite();
                        ((Privacy) this.instance).clearUsPrivacy();
                        return this;
                    }

                    public Builder setUsPrivacyBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Privacy) this.instance).setUsPrivacyBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public boolean hasTcfConsentString() {
                        return ((Privacy) this.instance).hasTcfConsentString();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public String getTcfConsentString() {
                        return ((Privacy) this.instance).getTcfConsentString();
                    }

                    @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponents.PrivacyOrBuilder
                    public ByteString getTcfConsentStringBytes() {
                        return ((Privacy) this.instance).getTcfConsentStringBytes();
                    }

                    public Builder setTcfConsentString(String str) {
                        copyOnWrite();
                        ((Privacy) this.instance).setTcfConsentString(str);
                        return this;
                    }

                    public Builder clearTcfConsentString() {
                        copyOnWrite();
                        ((Privacy) this.instance).clearTcfConsentString();
                        return this;
                    }

                    public Builder setTcfConsentStringBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Privacy) this.instance).setTcfConsentStringBytes(byteString);
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Privacy();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ለ\u0003\u0005ለ\u0004", new Object[]{"bitField0_", "ccpa_", "gdpr_", "coppa_", "usPrivacy_", "tcfConsentString_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Privacy> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Privacy.class) {
                                    defaultInstanceBasedParser = PARSER;
                                    if (defaultInstanceBasedParser == null) {
                                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                        PARSER = defaultInstanceBasedParser;
                                    }
                                    break;
                                }
                            }
                            return defaultInstanceBasedParser;
                        case 6:
                            return (byte) 1;
                        case 7:
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                static {
                    Privacy privacy = new Privacy();
                    DEFAULT_INSTANCE = privacy;
                    GeneratedMessageLite.registerDefaultInstance(Privacy.class, privacy);
                }

                public static Privacy getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Privacy> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
            public boolean hasIdfv() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
            public String getIdfv() {
                return this.idfv_;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
            public ByteString getIdfvBytes() {
                return ByteString.copyFromUtf8(this.idfv_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdfv(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.idfv_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIdfv() {
                this.bitField0_ &= -2;
                this.idfv_ = getDefaultInstance().getIdfv();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdfvBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.idfv_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
            public boolean hasPrivacy() {
                return this.privacy_ != null;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
            public Privacy getPrivacy() {
                Privacy privacy = this.privacy_;
                return privacy == null ? Privacy.getDefaultInstance() : privacy;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPrivacy(Privacy privacy) {
                privacy.getClass();
                this.privacy_ = privacy;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergePrivacy(Privacy privacy) {
                privacy.getClass();
                Privacy privacy2 = this.privacy_;
                if (privacy2 != null && privacy2 != Privacy.getDefaultInstance()) {
                    this.privacy_ = Privacy.newBuilder(this.privacy_).mergeFrom(privacy).buildPartial();
                } else {
                    this.privacy_ = privacy;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPrivacy() {
                this.privacy_ = null;
            }

            public static BidTokenComponents parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static BidTokenComponents parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static BidTokenComponents parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static BidTokenComponents parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static BidTokenComponents parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static BidTokenComponents parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static BidTokenComponents parseFrom(InputStream inputStream) throws IOException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BidTokenComponents parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BidTokenComponents parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (BidTokenComponents) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BidTokenComponents parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenComponents) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BidTokenComponents parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static BidTokenComponents parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(BidTokenComponents bidTokenComponents) {
                return DEFAULT_INSTANCE.createBuilder(bidTokenComponents);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<BidTokenComponents, Builder> implements BidTokenComponentsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(BidTokenComponents.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
                public boolean hasIdfv() {
                    return ((BidTokenComponents) this.instance).hasIdfv();
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
                public String getIdfv() {
                    return ((BidTokenComponents) this.instance).getIdfv();
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
                public ByteString getIdfvBytes() {
                    return ((BidTokenComponents) this.instance).getIdfvBytes();
                }

                public Builder setIdfv(String str) {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).setIdfv(str);
                    return this;
                }

                public Builder clearIdfv() {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).clearIdfv();
                    return this;
                }

                public Builder setIdfvBytes(ByteString byteString) {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).setIdfvBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
                public boolean hasPrivacy() {
                    return ((BidTokenComponents) this.instance).hasPrivacy();
                }

                @Override // com.moloco.sdk.BidToken.BidTokenRequestV2.BidTokenComponentsOrBuilder
                public Privacy getPrivacy() {
                    return ((BidTokenComponents) this.instance).getPrivacy();
                }

                public Builder setPrivacy(Privacy privacy) {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).setPrivacy(privacy);
                    return this;
                }

                public Builder setPrivacy(Privacy.Builder builder) {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).setPrivacy(builder.build());
                    return this;
                }

                public Builder mergePrivacy(Privacy privacy) {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).mergePrivacy(privacy);
                    return this;
                }

                public Builder clearPrivacy() {
                    copyOnWrite();
                    ((BidTokenComponents) this.instance).clearPrivacy();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new BidTokenComponents();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002\t", new Object[]{"bitField0_", "idfv_", "privacy_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BidTokenComponents> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (BidTokenComponents.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                BidTokenComponents bidTokenComponents = new BidTokenComponents();
                DEFAULT_INSTANCE = bidTokenComponents;
                GeneratedMessageLite.registerDefaultInstance(BidTokenComponents.class, bidTokenComponents);
            }

            public static BidTokenComponents getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<BidTokenComponents> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.BidToken.BidTokenRequestV2OrBuilder
        public boolean hasBidTokenComponents() {
            return this.bidTokenComponents_ != null;
        }

        @Override // com.moloco.sdk.BidToken.BidTokenRequestV2OrBuilder
        public BidTokenComponents getBidTokenComponents() {
            BidTokenComponents bidTokenComponents = this.bidTokenComponents_;
            return bidTokenComponents == null ? BidTokenComponents.getDefaultInstance() : bidTokenComponents;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidTokenComponents(BidTokenComponents bidTokenComponents) {
            bidTokenComponents.getClass();
            this.bidTokenComponents_ = bidTokenComponents;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBidTokenComponents(BidTokenComponents bidTokenComponents) {
            bidTokenComponents.getClass();
            BidTokenComponents bidTokenComponents2 = this.bidTokenComponents_;
            if (bidTokenComponents2 != null && bidTokenComponents2 != BidTokenComponents.getDefaultInstance()) {
                this.bidTokenComponents_ = BidTokenComponents.newBuilder(this.bidTokenComponents_).mergeFrom(bidTokenComponents).buildPartial();
            } else {
                this.bidTokenComponents_ = bidTokenComponents;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBidTokenComponents() {
            this.bidTokenComponents_ = null;
        }

        public static BidTokenRequestV2 parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BidTokenRequestV2 parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BidTokenRequestV2 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BidTokenRequestV2 parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BidTokenRequestV2 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BidTokenRequestV2 parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BidTokenRequestV2 parseFrom(InputStream inputStream) throws IOException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenRequestV2 parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenRequestV2 parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BidTokenRequestV2) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenRequestV2 parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV2) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenRequestV2 parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BidTokenRequestV2 parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BidTokenRequestV2 bidTokenRequestV2) {
            return DEFAULT_INSTANCE.createBuilder(bidTokenRequestV2);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BidTokenRequestV2, Builder> implements BidTokenRequestV2OrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BidTokenRequestV2.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2OrBuilder
            public boolean hasBidTokenComponents() {
                return ((BidTokenRequestV2) this.instance).hasBidTokenComponents();
            }

            @Override // com.moloco.sdk.BidToken.BidTokenRequestV2OrBuilder
            public BidTokenComponents getBidTokenComponents() {
                return ((BidTokenRequestV2) this.instance).getBidTokenComponents();
            }

            public Builder setBidTokenComponents(BidTokenComponents bidTokenComponents) {
                copyOnWrite();
                ((BidTokenRequestV2) this.instance).setBidTokenComponents(bidTokenComponents);
                return this;
            }

            public Builder setBidTokenComponents(BidTokenComponents.Builder builder) {
                copyOnWrite();
                ((BidTokenRequestV2) this.instance).setBidTokenComponents(builder.build());
                return this;
            }

            public Builder mergeBidTokenComponents(BidTokenComponents bidTokenComponents) {
                copyOnWrite();
                ((BidTokenRequestV2) this.instance).mergeBidTokenComponents(bidTokenComponents);
                return this;
            }

            public Builder clearBidTokenComponents() {
                copyOnWrite();
                ((BidTokenRequestV2) this.instance).clearBidTokenComponents();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BidTokenRequestV2();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"bidTokenComponents_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BidTokenRequestV2> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (BidTokenRequestV2.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BidTokenRequestV2 bidTokenRequestV2 = new BidTokenRequestV2();
            DEFAULT_INSTANCE = bidTokenRequestV2;
            GeneratedMessageLite.registerDefaultInstance(BidTokenRequestV2.class, bidTokenRequestV2);
        }

        public static BidTokenRequestV2 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BidTokenRequestV2> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.BidToken$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class BidTokenResponseV2 extends GeneratedMessageLite<BidTokenResponseV2, Builder> implements BidTokenResponseV2OrBuilder {
        public static final int BID_TOKEN_FIELD_NUMBER = 1;
        private static final BidTokenResponseV2 DEFAULT_INSTANCE;
        private static volatile Parser<BidTokenResponseV2> PARSER;
        private String bidToken_ = "";

        private BidTokenResponseV2() {
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV2OrBuilder
        public String getBidToken() {
            return this.bidToken_;
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV2OrBuilder
        public ByteString getBidTokenBytes() {
            return ByteString.copyFromUtf8(this.bidToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidToken(String str) {
            str.getClass();
            this.bidToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBidToken() {
            this.bidToken_ = getDefaultInstance().getBidToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.bidToken_ = byteString.toStringUtf8();
        }

        public static BidTokenResponseV2 parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BidTokenResponseV2 parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BidTokenResponseV2 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BidTokenResponseV2 parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BidTokenResponseV2 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BidTokenResponseV2 parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BidTokenResponseV2 parseFrom(InputStream inputStream) throws IOException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenResponseV2 parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenResponseV2 parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BidTokenResponseV2) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenResponseV2 parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV2) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenResponseV2 parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BidTokenResponseV2 parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BidTokenResponseV2 bidTokenResponseV2) {
            return DEFAULT_INSTANCE.createBuilder(bidTokenResponseV2);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BidTokenResponseV2, Builder> implements BidTokenResponseV2OrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BidTokenResponseV2.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV2OrBuilder
            public String getBidToken() {
                return ((BidTokenResponseV2) this.instance).getBidToken();
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV2OrBuilder
            public ByteString getBidTokenBytes() {
                return ((BidTokenResponseV2) this.instance).getBidTokenBytes();
            }

            public Builder setBidToken(String str) {
                copyOnWrite();
                ((BidTokenResponseV2) this.instance).setBidToken(str);
                return this;
            }

            public Builder clearBidToken() {
                copyOnWrite();
                ((BidTokenResponseV2) this.instance).clearBidToken();
                return this;
            }

            public Builder setBidTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((BidTokenResponseV2) this.instance).setBidTokenBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BidTokenResponseV2();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"bidToken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BidTokenResponseV2> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (BidTokenResponseV2.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BidTokenResponseV2 bidTokenResponseV2 = new BidTokenResponseV2();
            DEFAULT_INSTANCE = bidTokenResponseV2;
            GeneratedMessageLite.registerDefaultInstance(BidTokenResponseV2.class, bidTokenResponseV2);
        }

        public static BidTokenResponseV2 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BidTokenResponseV2> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class BidTokenRequestV3 extends GeneratedMessageLite<BidTokenRequestV3, Builder> implements BidTokenRequestV3OrBuilder {
        private static final BidTokenRequestV3 DEFAULT_INSTANCE;
        private static volatile Parser<BidTokenRequestV3> PARSER;

        private BidTokenRequestV3() {
        }

        public static BidTokenRequestV3 parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BidTokenRequestV3 parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BidTokenRequestV3 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BidTokenRequestV3 parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BidTokenRequestV3 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BidTokenRequestV3 parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BidTokenRequestV3 parseFrom(InputStream inputStream) throws IOException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenRequestV3 parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenRequestV3 parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BidTokenRequestV3) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenRequestV3 parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV3) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenRequestV3 parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BidTokenRequestV3 parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenRequestV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BidTokenRequestV3 bidTokenRequestV3) {
            return DEFAULT_INSTANCE.createBuilder(bidTokenRequestV3);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BidTokenRequestV3, Builder> implements BidTokenRequestV3OrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BidTokenRequestV3.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BidTokenRequestV3();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BidTokenRequestV3> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (BidTokenRequestV3.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BidTokenRequestV3 bidTokenRequestV3 = new BidTokenRequestV3();
            DEFAULT_INSTANCE = bidTokenRequestV3;
            GeneratedMessageLite.registerDefaultInstance(BidTokenRequestV3.class, bidTokenRequestV3);
        }

        public static BidTokenRequestV3 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BidTokenRequestV3> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class BidTokenResponseV3 extends GeneratedMessageLite<BidTokenResponseV3, Builder> implements BidTokenResponseV3OrBuilder {
        public static final int BID_TOKEN_FIELD_NUMBER = 1;
        public static final int CLIENT_TOKEN_CONFIGS_FIELD_NUMBER = 3;
        private static final BidTokenResponseV3 DEFAULT_INSTANCE;
        private static volatile Parser<BidTokenResponseV3> PARSER = null;
        public static final int PK_FIELD_NUMBER = 2;
        private ClientTokenConfigs clientTokenConfigs_;
        private String bidToken_ = "";
        private String pk_ = "";

        public interface ClientTokenConfigsOrBuilder extends MessageLiteOrBuilder {
            boolean getEnableDbt();
        }

        private BidTokenResponseV3() {
        }

        public static final class ClientTokenConfigs extends GeneratedMessageLite<ClientTokenConfigs, Builder> implements ClientTokenConfigsOrBuilder {
            private static final ClientTokenConfigs DEFAULT_INSTANCE;
            public static final int ENABLE_DBT_FIELD_NUMBER = 1;
            private static volatile Parser<ClientTokenConfigs> PARSER;
            private boolean enableDbt_;

            private ClientTokenConfigs() {
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3.ClientTokenConfigsOrBuilder
            public boolean getEnableDbt() {
                return this.enableDbt_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnableDbt(boolean z) {
                this.enableDbt_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnableDbt() {
                this.enableDbt_ = false;
            }

            public static ClientTokenConfigs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ClientTokenConfigs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ClientTokenConfigs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ClientTokenConfigs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ClientTokenConfigs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ClientTokenConfigs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ClientTokenConfigs parseFrom(InputStream inputStream) throws IOException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClientTokenConfigs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClientTokenConfigs parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ClientTokenConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClientTokenConfigs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientTokenConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClientTokenConfigs parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ClientTokenConfigs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClientTokenConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ClientTokenConfigs clientTokenConfigs) {
                return DEFAULT_INSTANCE.createBuilder(clientTokenConfigs);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ClientTokenConfigs, Builder> implements ClientTokenConfigsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ClientTokenConfigs.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.BidTokenResponseV3.ClientTokenConfigsOrBuilder
                public boolean getEnableDbt() {
                    return ((ClientTokenConfigs) this.instance).getEnableDbt();
                }

                public Builder setEnableDbt(boolean z) {
                    copyOnWrite();
                    ((ClientTokenConfigs) this.instance).setEnableDbt(z);
                    return this;
                }

                public Builder clearEnableDbt() {
                    copyOnWrite();
                    ((ClientTokenConfigs) this.instance).clearEnableDbt();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ClientTokenConfigs();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"enableDbt_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ClientTokenConfigs> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ClientTokenConfigs.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                ClientTokenConfigs clientTokenConfigs = new ClientTokenConfigs();
                DEFAULT_INSTANCE = clientTokenConfigs;
                GeneratedMessageLite.registerDefaultInstance(ClientTokenConfigs.class, clientTokenConfigs);
            }

            public static ClientTokenConfigs getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ClientTokenConfigs> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public String getBidToken() {
            return this.bidToken_;
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public ByteString getBidTokenBytes() {
            return ByteString.copyFromUtf8(this.bidToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidToken(String str) {
            str.getClass();
            this.bidToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBidToken() {
            this.bidToken_ = getDefaultInstance().getBidToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidTokenBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.bidToken_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public String getPk() {
            return this.pk_;
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public ByteString getPkBytes() {
            return ByteString.copyFromUtf8(this.pk_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPk(String str) {
            str.getClass();
            this.pk_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPk() {
            this.pk_ = getDefaultInstance().getPk();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPkBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.pk_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public boolean hasClientTokenConfigs() {
            return this.clientTokenConfigs_ != null;
        }

        @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
        public ClientTokenConfigs getClientTokenConfigs() {
            ClientTokenConfigs clientTokenConfigs = this.clientTokenConfigs_;
            return clientTokenConfigs == null ? ClientTokenConfigs.getDefaultInstance() : clientTokenConfigs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTokenConfigs(ClientTokenConfigs clientTokenConfigs) {
            clientTokenConfigs.getClass();
            this.clientTokenConfigs_ = clientTokenConfigs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClientTokenConfigs(ClientTokenConfigs clientTokenConfigs) {
            clientTokenConfigs.getClass();
            ClientTokenConfigs clientTokenConfigs2 = this.clientTokenConfigs_;
            if (clientTokenConfigs2 != null && clientTokenConfigs2 != ClientTokenConfigs.getDefaultInstance()) {
                this.clientTokenConfigs_ = ClientTokenConfigs.newBuilder(this.clientTokenConfigs_).mergeFrom(clientTokenConfigs).buildPartial();
            } else {
                this.clientTokenConfigs_ = clientTokenConfigs;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientTokenConfigs() {
            this.clientTokenConfigs_ = null;
        }

        public static BidTokenResponseV3 parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BidTokenResponseV3 parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BidTokenResponseV3 parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BidTokenResponseV3 parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BidTokenResponseV3 parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BidTokenResponseV3 parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BidTokenResponseV3 parseFrom(InputStream inputStream) throws IOException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenResponseV3 parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenResponseV3 parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BidTokenResponseV3) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BidTokenResponseV3 parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV3) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BidTokenResponseV3 parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BidTokenResponseV3 parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BidTokenResponseV3) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BidTokenResponseV3 bidTokenResponseV3) {
            return DEFAULT_INSTANCE.createBuilder(bidTokenResponseV3);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BidTokenResponseV3, Builder> implements BidTokenResponseV3OrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BidTokenResponseV3.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public String getBidToken() {
                return ((BidTokenResponseV3) this.instance).getBidToken();
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public ByteString getBidTokenBytes() {
                return ((BidTokenResponseV3) this.instance).getBidTokenBytes();
            }

            public Builder setBidToken(String str) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setBidToken(str);
                return this;
            }

            public Builder clearBidToken() {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).clearBidToken();
                return this;
            }

            public Builder setBidTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setBidTokenBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public String getPk() {
                return ((BidTokenResponseV3) this.instance).getPk();
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public ByteString getPkBytes() {
                return ((BidTokenResponseV3) this.instance).getPkBytes();
            }

            public Builder setPk(String str) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setPk(str);
                return this;
            }

            public Builder clearPk() {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).clearPk();
                return this;
            }

            public Builder setPkBytes(ByteString byteString) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setPkBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public boolean hasClientTokenConfigs() {
                return ((BidTokenResponseV3) this.instance).hasClientTokenConfigs();
            }

            @Override // com.moloco.sdk.BidToken.BidTokenResponseV3OrBuilder
            public ClientTokenConfigs getClientTokenConfigs() {
                return ((BidTokenResponseV3) this.instance).getClientTokenConfigs();
            }

            public Builder setClientTokenConfigs(ClientTokenConfigs clientTokenConfigs) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setClientTokenConfigs(clientTokenConfigs);
                return this;
            }

            public Builder setClientTokenConfigs(ClientTokenConfigs.Builder builder) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).setClientTokenConfigs(builder.build());
                return this;
            }

            public Builder mergeClientTokenConfigs(ClientTokenConfigs clientTokenConfigs) {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).mergeClientTokenConfigs(clientTokenConfigs);
                return this;
            }

            public Builder clearClientTokenConfigs() {
                copyOnWrite();
                ((BidTokenResponseV3) this.instance).clearClientTokenConfigs();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BidTokenResponseV3();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\t", new Object[]{"bidToken_", "pk_", "clientTokenConfigs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BidTokenResponseV3> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (BidTokenResponseV3.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BidTokenResponseV3 bidTokenResponseV3 = new BidTokenResponseV3();
            DEFAULT_INSTANCE = bidTokenResponseV3;
            GeneratedMessageLite.registerDefaultInstance(BidTokenResponseV3.class, bidTokenResponseV3);
        }

        public static BidTokenResponseV3 getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BidTokenResponseV3> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ClientBidTokenComponents extends GeneratedMessageLite<ClientBidTokenComponents, Builder> implements ClientBidTokenComponentsOrBuilder {
        public static final int ACCESSIBILITY_INFO_FIELD_NUMBER = 11;
        public static final int AD_INFO_FIELD_NUMBER = 8;
        public static final int AUDIO_INFO_FIELD_NUMBER = 10;
        public static final int BATTERY_INFO_FIELD_NUMBER = 9;
        private static final ClientBidTokenComponents DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 3;
        public static final int DIR_INFO_FIELD_NUMBER = 6;
        public static final int IDFV_FIELD_NUMBER = 1;
        public static final int INFO_FIELD_NUMBER = 4;
        public static final int MEMORY_INFO_FIELD_NUMBER = 5;
        public static final int NETWORK_INFO_FIELD_NUMBER = 7;
        private static volatile Parser<ClientBidTokenComponents> PARSER = null;
        public static final int PRIVACY_FIELD_NUMBER = 2;
        private AccessibilityInfo accessibilityInfo_;
        private AdvertisingInfo adInfo_;
        private AudioInfo audioInfo_;
        private BatteryInfo batteryInfo_;
        private int bitField0_;
        private Device device_;
        private DirInfo dirInfo_;
        private String idfv_ = "";
        private SdkInfo info_;
        private MemoryInfo memoryInfo_;
        private NetworkInfo networkInfo_;
        private Privacy privacy_;

        public interface AccessibilityInfoOrBuilder extends MessageLiteOrBuilder {
            boolean getAccessibilityCaptioningEnabled();

            boolean getAccessibilityLargePointerIcon();

            float getFontScale();

            boolean getReduceBrightColorsActivated();

            boolean hasAccessibilityCaptioningEnabled();

            boolean hasAccessibilityLargePointerIcon();

            boolean hasFontScale();

            boolean hasReduceBrightColorsActivated();
        }

        public interface AdvertisingInfoOrBuilder extends MessageLiteOrBuilder {
            boolean getDnt();

            String getId();

            ByteString getIdBytes();

            boolean hasDnt();

            boolean hasId();
        }

        public interface AudioInfoOrBuilder extends MessageLiteOrBuilder {
            AudioInfo.MuteSwitchState getMuteSwitch();

            int getMuteSwitchValue();

            int getVol();

            boolean hasMuteSwitch();

            boolean hasVol();
        }

        public interface BatteryInfoOrBuilder extends MessageLiteOrBuilder {
            BatteryInfo.BatteryStatus getBatteryStatus();

            int getBatteryStatusValue();

            boolean getLowPowMode();

            int getMaxBatteryLevel();

            boolean hasBatteryStatus();

            boolean hasLowPowMode();

            boolean hasMaxBatteryLevel();
        }

        public interface DeviceOrBuilder extends MessageLiteOrBuilder {
            String getCarrier();

            ByteString getCarrierBytes();

            long getDbt();

            int getDevicetype();

            Geo getGeo();

            int getH();

            boolean getHasGy();

            String getHwv();

            ByteString getHwvBytes();

            int getJs();

            String getKbLoc();

            ByteString getKbLocBytes();

            String getLanguage();

            ByteString getLanguageBytes();

            String getLocale();

            ByteString getLocaleBytes();

            String getMake();

            ByteString getMakeBytes();

            String getModel();

            ByteString getModelBytes();

            Device.Orientation getOrtn();

            int getOrtnValue();

            String getOs();

            ByteString getOsBytes();

            String getOsv();

            ByteString getOsvBytes();

            int getPpi();

            double getPxratio();

            int getW();

            float getXdpi();

            float getYdpi();

            boolean hasCarrier();

            boolean hasDbt();

            boolean hasDevicetype();

            boolean hasGeo();

            boolean hasH();

            boolean hasHasGy();

            boolean hasHwv();

            boolean hasJs();

            boolean hasKbLoc();

            boolean hasLanguage();

            boolean hasLocale();

            boolean hasMake();

            boolean hasModel();

            boolean hasOrtn();

            boolean hasOs();

            boolean hasOsv();

            boolean hasPpi();

            boolean hasPxratio();

            boolean hasW();

            boolean hasXdpi();

            boolean hasYdpi();
        }

        public interface DirInfoOrBuilder extends MessageLiteOrBuilder {
            long getDsizeBytes();

            boolean hasDsizeBytes();
        }

        public interface GeoOrBuilder extends MessageLiteOrBuilder {
            int getUtcoffset();

            boolean hasUtcoffset();
        }

        public interface MemoryInfoOrBuilder extends MessageLiteOrBuilder {
            boolean getLowMem();

            long getLowMemThresholdBytes();

            long getTotalMemBytes();

            boolean hasLowMem();

            boolean hasLowMemThresholdBytes();

            boolean hasTotalMemBytes();
        }

        public interface NetworkInfoOrBuilder extends MessageLiteOrBuilder {
            int getMcc();

            int getMnc();

            boolean getRestricted();

            NetworkInfo.ConnectionType getType();

            int getTypeValue();

            boolean hasMcc();

            boolean hasMnc();

            boolean hasRestricted();

            boolean hasType();
        }

        public interface PrivacyOrBuilder extends MessageLiteOrBuilder {
            boolean getCcpa();

            boolean getCoppa();

            boolean getGdpr();

            String getTcfConsentString();

            ByteString getTcfConsentStringBytes();

            String getUsPrivacy();

            ByteString getUsPrivacyBytes();

            boolean hasCcpa();

            boolean hasCoppa();

            boolean hasGdpr();

            boolean hasTcfConsentString();

            boolean hasUsPrivacy();
        }

        public interface SdkInfoOrBuilder extends MessageLiteOrBuilder {
            boolean getInitialized();

            boolean hasInitialized();
        }

        private ClientBidTokenComponents() {
        }

        public static final class Privacy extends GeneratedMessageLite<Privacy, Builder> implements PrivacyOrBuilder {
            public static final int CCPA_FIELD_NUMBER = 1;
            public static final int COPPA_FIELD_NUMBER = 3;
            private static final Privacy DEFAULT_INSTANCE;
            public static final int GDPR_FIELD_NUMBER = 2;
            private static volatile Parser<Privacy> PARSER = null;
            public static final int TCF_CONSENT_STRING_FIELD_NUMBER = 5;
            public static final int US_PRIVACY_FIELD_NUMBER = 4;
            private int bitField0_;
            private boolean ccpa_;
            private boolean coppa_;
            private boolean gdpr_;
            private String usPrivacy_ = "";
            private String tcfConsentString_ = "";

            private Privacy() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean hasCcpa() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean getCcpa() {
                return this.ccpa_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCcpa(boolean z) {
                this.bitField0_ |= 1;
                this.ccpa_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCcpa() {
                this.bitField0_ &= -2;
                this.ccpa_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean hasGdpr() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean getGdpr() {
                return this.gdpr_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGdpr(boolean z) {
                this.bitField0_ |= 2;
                this.gdpr_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGdpr() {
                this.bitField0_ &= -3;
                this.gdpr_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean hasCoppa() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean getCoppa() {
                return this.coppa_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCoppa(boolean z) {
                this.bitField0_ |= 4;
                this.coppa_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCoppa() {
                this.bitField0_ &= -5;
                this.coppa_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean hasUsPrivacy() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public String getUsPrivacy() {
                return this.usPrivacy_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public ByteString getUsPrivacyBytes() {
                return ByteString.copyFromUtf8(this.usPrivacy_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsPrivacy(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.usPrivacy_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUsPrivacy() {
                this.bitField0_ &= -9;
                this.usPrivacy_ = getDefaultInstance().getUsPrivacy();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUsPrivacyBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.usPrivacy_ = byteString.toStringUtf8();
                this.bitField0_ |= 8;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public boolean hasTcfConsentString() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public String getTcfConsentString() {
                return this.tcfConsentString_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
            public ByteString getTcfConsentStringBytes() {
                return ByteString.copyFromUtf8(this.tcfConsentString_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTcfConsentString(String str) {
                str.getClass();
                this.bitField0_ |= 16;
                this.tcfConsentString_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTcfConsentString() {
                this.bitField0_ &= -17;
                this.tcfConsentString_ = getDefaultInstance().getTcfConsentString();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTcfConsentStringBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.tcfConsentString_ = byteString.toStringUtf8();
                this.bitField0_ |= 16;
            }

            public static Privacy parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Privacy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Privacy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Privacy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Privacy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Privacy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Privacy parseFrom(InputStream inputStream) throws IOException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Privacy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Privacy parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Privacy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Privacy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Privacy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Privacy parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Privacy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Privacy privacy) {
                return DEFAULT_INSTANCE.createBuilder(privacy);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Privacy, Builder> implements PrivacyOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Privacy.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean hasCcpa() {
                    return ((Privacy) this.instance).hasCcpa();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean getCcpa() {
                    return ((Privacy) this.instance).getCcpa();
                }

                public Builder setCcpa(boolean z) {
                    copyOnWrite();
                    ((Privacy) this.instance).setCcpa(z);
                    return this;
                }

                public Builder clearCcpa() {
                    copyOnWrite();
                    ((Privacy) this.instance).clearCcpa();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean hasGdpr() {
                    return ((Privacy) this.instance).hasGdpr();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean getGdpr() {
                    return ((Privacy) this.instance).getGdpr();
                }

                public Builder setGdpr(boolean z) {
                    copyOnWrite();
                    ((Privacy) this.instance).setGdpr(z);
                    return this;
                }

                public Builder clearGdpr() {
                    copyOnWrite();
                    ((Privacy) this.instance).clearGdpr();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean hasCoppa() {
                    return ((Privacy) this.instance).hasCoppa();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean getCoppa() {
                    return ((Privacy) this.instance).getCoppa();
                }

                public Builder setCoppa(boolean z) {
                    copyOnWrite();
                    ((Privacy) this.instance).setCoppa(z);
                    return this;
                }

                public Builder clearCoppa() {
                    copyOnWrite();
                    ((Privacy) this.instance).clearCoppa();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean hasUsPrivacy() {
                    return ((Privacy) this.instance).hasUsPrivacy();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public String getUsPrivacy() {
                    return ((Privacy) this.instance).getUsPrivacy();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public ByteString getUsPrivacyBytes() {
                    return ((Privacy) this.instance).getUsPrivacyBytes();
                }

                public Builder setUsPrivacy(String str) {
                    copyOnWrite();
                    ((Privacy) this.instance).setUsPrivacy(str);
                    return this;
                }

                public Builder clearUsPrivacy() {
                    copyOnWrite();
                    ((Privacy) this.instance).clearUsPrivacy();
                    return this;
                }

                public Builder setUsPrivacyBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Privacy) this.instance).setUsPrivacyBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public boolean hasTcfConsentString() {
                    return ((Privacy) this.instance).hasTcfConsentString();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public String getTcfConsentString() {
                    return ((Privacy) this.instance).getTcfConsentString();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.PrivacyOrBuilder
                public ByteString getTcfConsentStringBytes() {
                    return ((Privacy) this.instance).getTcfConsentStringBytes();
                }

                public Builder setTcfConsentString(String str) {
                    copyOnWrite();
                    ((Privacy) this.instance).setTcfConsentString(str);
                    return this;
                }

                public Builder clearTcfConsentString() {
                    copyOnWrite();
                    ((Privacy) this.instance).clearTcfConsentString();
                    return this;
                }

                public Builder setTcfConsentStringBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Privacy) this.instance).setTcfConsentStringBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Privacy();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ለ\u0003\u0005ለ\u0004", new Object[]{"bitField0_", "ccpa_", "gdpr_", "coppa_", "usPrivacy_", "tcfConsentString_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Privacy> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Privacy.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Privacy privacy = new Privacy();
                DEFAULT_INSTANCE = privacy;
                GeneratedMessageLite.registerDefaultInstance(Privacy.class, privacy);
            }

            public static Privacy getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Privacy> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
            public static final int CARRIER_FIELD_NUMBER = 6;
            public static final int DBT_FIELD_NUMBER = 15;
            private static final Device DEFAULT_INSTANCE;
            public static final int DEVICETYPE_FIELD_NUMBER = 7;
            public static final int GEO_FIELD_NUMBER = 9;
            public static final int HAS_GY_FIELD_NUMBER = 17;
            public static final int HWV_FIELD_NUMBER = 5;
            public static final int H_FIELD_NUMBER = 11;
            public static final int JS_FIELD_NUMBER = 8;
            public static final int KB_LOC_FIELD_NUMBER = 18;
            public static final int LANGUAGE_FIELD_NUMBER = 1;
            public static final int LOCALE_FIELD_NUMBER = 19;
            public static final int MAKE_FIELD_NUMBER = 3;
            public static final int MODEL_FIELD_NUMBER = 4;
            public static final int ORTN_FIELD_NUMBER = 16;
            public static final int OSV_FIELD_NUMBER = 2;
            public static final int OS_FIELD_NUMBER = 14;
            private static volatile Parser<Device> PARSER = null;
            public static final int PPI_FIELD_NUMBER = 12;
            public static final int PXRATIO_FIELD_NUMBER = 13;
            public static final int W_FIELD_NUMBER = 10;
            public static final int XDPI_FIELD_NUMBER = 20;
            public static final int YDPI_FIELD_NUMBER = 21;
            private int bitField0_;
            private long dbt_;
            private int devicetype_;
            private Geo geo_;
            private int h_;
            private boolean hasGy_;
            private int js_;
            private int ortn_;
            private int ppi_;
            private double pxratio_;
            private int w_;
            private float xdpi_;
            private float ydpi_;
            private String language_ = "";
            private String osv_ = "";
            private String make_ = "";
            private String model_ = "";
            private String hwv_ = "";
            private String carrier_ = "";
            private String os_ = "";
            private String kbLoc_ = "";
            private String locale_ = "";

            private Device() {
            }

            public enum Orientation implements Internal.EnumLite {
                UNKNOWN(0),
                PORTRAIT(1),
                LANDSCAPE(2),
                UNRECOGNIZED(-1);

                public static final int LANDSCAPE_VALUE = 2;
                public static final int PORTRAIT_VALUE = 1;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<Orientation> internalValueMap = new Internal.EnumLiteMap<Orientation>() { // from class: com.moloco.sdk.BidToken.ClientBidTokenComponents.Device.Orientation.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public Orientation findValueByNumber(int i) {
                        return Orientation.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static Orientation valueOf(int i) {
                    return forNumber(i);
                }

                public static Orientation forNumber(int i) {
                    if (i == 0) {
                        return UNKNOWN;
                    }
                    if (i == 1) {
                        return PORTRAIT;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return LANDSCAPE;
                }

                public static Internal.EnumLiteMap<Orientation> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return OrientationVerifier.INSTANCE;
                }

                private static final class OrientationVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new OrientationVerifier();

                    private OrientationVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return Orientation.forNumber(i) != null;
                    }
                }

                Orientation(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasLanguage() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getLanguage() {
                return this.language_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getLanguageBytes() {
                return ByteString.copyFromUtf8(this.language_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLanguage(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.language_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLanguage() {
                this.bitField0_ &= -2;
                this.language_ = getDefaultInstance().getLanguage();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLanguageBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.language_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasOsv() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getOsv() {
                return this.osv_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getOsvBytes() {
                return ByteString.copyFromUtf8(this.osv_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsv(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.osv_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOsv() {
                this.bitField0_ &= -3;
                this.osv_ = getDefaultInstance().getOsv();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsvBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.osv_ = byteString.toStringUtf8();
                this.bitField0_ |= 2;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasMake() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getMake() {
                return this.make_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getMakeBytes() {
                return ByteString.copyFromUtf8(this.make_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMake(String str) {
                str.getClass();
                this.bitField0_ |= 4;
                this.make_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMake() {
                this.bitField0_ &= -5;
                this.make_ = getDefaultInstance().getMake();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMakeBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.make_ = byteString.toStringUtf8();
                this.bitField0_ |= 4;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasModel() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getModel() {
                return this.model_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getModelBytes() {
                return ByteString.copyFromUtf8(this.model_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModel(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.model_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearModel() {
                this.bitField0_ &= -9;
                this.model_ = getDefaultInstance().getModel();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModelBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.model_ = byteString.toStringUtf8();
                this.bitField0_ |= 8;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasHwv() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getHwv() {
                return this.hwv_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getHwvBytes() {
                return ByteString.copyFromUtf8(this.hwv_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHwv(String str) {
                str.getClass();
                this.bitField0_ |= 16;
                this.hwv_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHwv() {
                this.bitField0_ &= -17;
                this.hwv_ = getDefaultInstance().getHwv();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHwvBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.hwv_ = byteString.toStringUtf8();
                this.bitField0_ |= 16;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasCarrier() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getCarrier() {
                return this.carrier_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getCarrierBytes() {
                return ByteString.copyFromUtf8(this.carrier_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrier(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.carrier_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCarrier() {
                this.bitField0_ &= -33;
                this.carrier_ = getDefaultInstance().getCarrier();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrierBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.carrier_ = byteString.toStringUtf8();
                this.bitField0_ |= 32;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasDevicetype() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getDevicetype() {
                return this.devicetype_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDevicetype(int i) {
                this.bitField0_ |= 64;
                this.devicetype_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDevicetype() {
                this.bitField0_ &= -65;
                this.devicetype_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasJs() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getJs() {
                return this.js_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setJs(int i) {
                this.bitField0_ |= 128;
                this.js_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearJs() {
                this.bitField0_ &= -129;
                this.js_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasGeo() {
                return (this.bitField0_ & 256) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public Geo getGeo() {
                Geo geo = this.geo_;
                return geo == null ? Geo.getDefaultInstance() : geo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGeo(Geo geo) {
                geo.getClass();
                this.geo_ = geo;
                this.bitField0_ |= 256;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeGeo(Geo geo) {
                geo.getClass();
                Geo geo2 = this.geo_;
                if (geo2 != null && geo2 != Geo.getDefaultInstance()) {
                    this.geo_ = Geo.newBuilder(this.geo_).mergeFrom(geo).buildPartial();
                } else {
                    this.geo_ = geo;
                }
                this.bitField0_ |= 256;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGeo() {
                this.geo_ = null;
                this.bitField0_ &= -257;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasW() {
                return (this.bitField0_ & 512) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getW() {
                return this.w_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setW(int i) {
                this.bitField0_ |= 512;
                this.w_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearW() {
                this.bitField0_ &= -513;
                this.w_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasH() {
                return (this.bitField0_ & 1024) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getH() {
                return this.h_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setH(int i) {
                this.bitField0_ |= 1024;
                this.h_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearH() {
                this.bitField0_ &= -1025;
                this.h_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasPpi() {
                return (this.bitField0_ & 2048) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getPpi() {
                return this.ppi_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPpi(int i) {
                this.bitField0_ |= 2048;
                this.ppi_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPpi() {
                this.bitField0_ &= -2049;
                this.ppi_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasPxratio() {
                return (this.bitField0_ & 4096) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public double getPxratio() {
                return this.pxratio_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPxratio(double d) {
                this.bitField0_ |= 4096;
                this.pxratio_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPxratio() {
                this.bitField0_ &= -4097;
                this.pxratio_ = 0.0d;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasOs() {
                return (this.bitField0_ & 8192) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getOs() {
                return this.os_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getOsBytes() {
                return ByteString.copyFromUtf8(this.os_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOs(String str) {
                str.getClass();
                this.bitField0_ |= 8192;
                this.os_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOs() {
                this.bitField0_ &= -8193;
                this.os_ = getDefaultInstance().getOs();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.os_ = byteString.toStringUtf8();
                this.bitField0_ |= 8192;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasDbt() {
                return (this.bitField0_ & 16384) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public long getDbt() {
                return this.dbt_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDbt(long j) {
                this.bitField0_ |= 16384;
                this.dbt_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDbt() {
                this.bitField0_ &= -16385;
                this.dbt_ = 0L;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasOrtn() {
                return (this.bitField0_ & 32768) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public int getOrtnValue() {
                return this.ortn_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public Orientation getOrtn() {
                Orientation orientationForNumber = Orientation.forNumber(this.ortn_);
                return orientationForNumber == null ? Orientation.UNRECOGNIZED : orientationForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOrtnValue(int i) {
                this.bitField0_ |= 32768;
                this.ortn_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOrtn(Orientation orientation) {
                this.ortn_ = orientation.getNumber();
                this.bitField0_ |= 32768;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOrtn() {
                this.bitField0_ &= -32769;
                this.ortn_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasHasGy() {
                return (this.bitField0_ & 65536) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean getHasGy() {
                return this.hasGy_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHasGy(boolean z) {
                this.bitField0_ |= 65536;
                this.hasGy_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHasGy() {
                this.bitField0_ &= -65537;
                this.hasGy_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasKbLoc() {
                return (this.bitField0_ & 131072) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getKbLoc() {
                return this.kbLoc_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getKbLocBytes() {
                return ByteString.copyFromUtf8(this.kbLoc_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setKbLoc(String str) {
                str.getClass();
                this.bitField0_ |= 131072;
                this.kbLoc_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearKbLoc() {
                this.bitField0_ &= -131073;
                this.kbLoc_ = getDefaultInstance().getKbLoc();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setKbLocBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.kbLoc_ = byteString.toStringUtf8();
                this.bitField0_ |= 131072;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasLocale() {
                return (this.bitField0_ & 262144) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public String getLocale() {
                return this.locale_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public ByteString getLocaleBytes() {
                return ByteString.copyFromUtf8(this.locale_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLocale(String str) {
                str.getClass();
                this.bitField0_ |= 262144;
                this.locale_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLocale() {
                this.bitField0_ &= -262145;
                this.locale_ = getDefaultInstance().getLocale();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLocaleBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.locale_ = byteString.toStringUtf8();
                this.bitField0_ |= 262144;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasXdpi() {
                return (this.bitField0_ & 524288) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public float getXdpi() {
                return this.xdpi_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXdpi(float f) {
                this.bitField0_ |= 524288;
                this.xdpi_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXdpi() {
                this.bitField0_ &= -524289;
                this.xdpi_ = 0.0f;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public boolean hasYdpi() {
                return (this.bitField0_ & 1048576) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
            public float getYdpi() {
                return this.ydpi_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYdpi(float f) {
                this.bitField0_ |= 1048576;
                this.ydpi_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYdpi() {
                this.bitField0_ &= -1048577;
                this.ydpi_ = 0.0f;
            }

            public static Device parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Device parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Device parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Device parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Device parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Device parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Device parseFrom(InputStream inputStream) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Device parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Device parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Device parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Device parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Device parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Device device) {
                return DEFAULT_INSTANCE.createBuilder(device);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Device, Builder> implements DeviceOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Device.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasLanguage() {
                    return ((Device) this.instance).hasLanguage();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getLanguage() {
                    return ((Device) this.instance).getLanguage();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getLanguageBytes() {
                    return ((Device) this.instance).getLanguageBytes();
                }

                public Builder setLanguage(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setLanguage(str);
                    return this;
                }

                public Builder clearLanguage() {
                    copyOnWrite();
                    ((Device) this.instance).clearLanguage();
                    return this;
                }

                public Builder setLanguageBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setLanguageBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasOsv() {
                    return ((Device) this.instance).hasOsv();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getOsv() {
                    return ((Device) this.instance).getOsv();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getOsvBytes() {
                    return ((Device) this.instance).getOsvBytes();
                }

                public Builder setOsv(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setOsv(str);
                    return this;
                }

                public Builder clearOsv() {
                    copyOnWrite();
                    ((Device) this.instance).clearOsv();
                    return this;
                }

                public Builder setOsvBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setOsvBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasMake() {
                    return ((Device) this.instance).hasMake();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getMake() {
                    return ((Device) this.instance).getMake();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getMakeBytes() {
                    return ((Device) this.instance).getMakeBytes();
                }

                public Builder setMake(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setMake(str);
                    return this;
                }

                public Builder clearMake() {
                    copyOnWrite();
                    ((Device) this.instance).clearMake();
                    return this;
                }

                public Builder setMakeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setMakeBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasModel() {
                    return ((Device) this.instance).hasModel();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getModel() {
                    return ((Device) this.instance).getModel();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getModelBytes() {
                    return ((Device) this.instance).getModelBytes();
                }

                public Builder setModel(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setModel(str);
                    return this;
                }

                public Builder clearModel() {
                    copyOnWrite();
                    ((Device) this.instance).clearModel();
                    return this;
                }

                public Builder setModelBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setModelBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasHwv() {
                    return ((Device) this.instance).hasHwv();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getHwv() {
                    return ((Device) this.instance).getHwv();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getHwvBytes() {
                    return ((Device) this.instance).getHwvBytes();
                }

                public Builder setHwv(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setHwv(str);
                    return this;
                }

                public Builder clearHwv() {
                    copyOnWrite();
                    ((Device) this.instance).clearHwv();
                    return this;
                }

                public Builder setHwvBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setHwvBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasCarrier() {
                    return ((Device) this.instance).hasCarrier();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getCarrier() {
                    return ((Device) this.instance).getCarrier();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getCarrierBytes() {
                    return ((Device) this.instance).getCarrierBytes();
                }

                public Builder setCarrier(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setCarrier(str);
                    return this;
                }

                public Builder clearCarrier() {
                    copyOnWrite();
                    ((Device) this.instance).clearCarrier();
                    return this;
                }

                public Builder setCarrierBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setCarrierBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasDevicetype() {
                    return ((Device) this.instance).hasDevicetype();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getDevicetype() {
                    return ((Device) this.instance).getDevicetype();
                }

                public Builder setDevicetype(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setDevicetype(i);
                    return this;
                }

                public Builder clearDevicetype() {
                    copyOnWrite();
                    ((Device) this.instance).clearDevicetype();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasJs() {
                    return ((Device) this.instance).hasJs();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getJs() {
                    return ((Device) this.instance).getJs();
                }

                public Builder setJs(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setJs(i);
                    return this;
                }

                public Builder clearJs() {
                    copyOnWrite();
                    ((Device) this.instance).clearJs();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasGeo() {
                    return ((Device) this.instance).hasGeo();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public Geo getGeo() {
                    return ((Device) this.instance).getGeo();
                }

                public Builder setGeo(Geo geo) {
                    copyOnWrite();
                    ((Device) this.instance).setGeo(geo);
                    return this;
                }

                public Builder setGeo(Geo.Builder builder) {
                    copyOnWrite();
                    ((Device) this.instance).setGeo(builder.build());
                    return this;
                }

                public Builder mergeGeo(Geo geo) {
                    copyOnWrite();
                    ((Device) this.instance).mergeGeo(geo);
                    return this;
                }

                public Builder clearGeo() {
                    copyOnWrite();
                    ((Device) this.instance).clearGeo();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasW() {
                    return ((Device) this.instance).hasW();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getW() {
                    return ((Device) this.instance).getW();
                }

                public Builder setW(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setW(i);
                    return this;
                }

                public Builder clearW() {
                    copyOnWrite();
                    ((Device) this.instance).clearW();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasH() {
                    return ((Device) this.instance).hasH();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getH() {
                    return ((Device) this.instance).getH();
                }

                public Builder setH(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setH(i);
                    return this;
                }

                public Builder clearH() {
                    copyOnWrite();
                    ((Device) this.instance).clearH();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasPpi() {
                    return ((Device) this.instance).hasPpi();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getPpi() {
                    return ((Device) this.instance).getPpi();
                }

                public Builder setPpi(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setPpi(i);
                    return this;
                }

                public Builder clearPpi() {
                    copyOnWrite();
                    ((Device) this.instance).clearPpi();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasPxratio() {
                    return ((Device) this.instance).hasPxratio();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public double getPxratio() {
                    return ((Device) this.instance).getPxratio();
                }

                public Builder setPxratio(double d) {
                    copyOnWrite();
                    ((Device) this.instance).setPxratio(d);
                    return this;
                }

                public Builder clearPxratio() {
                    copyOnWrite();
                    ((Device) this.instance).clearPxratio();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasOs() {
                    return ((Device) this.instance).hasOs();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getOs() {
                    return ((Device) this.instance).getOs();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getOsBytes() {
                    return ((Device) this.instance).getOsBytes();
                }

                public Builder setOs(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setOs(str);
                    return this;
                }

                public Builder clearOs() {
                    copyOnWrite();
                    ((Device) this.instance).clearOs();
                    return this;
                }

                public Builder setOsBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setOsBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasDbt() {
                    return ((Device) this.instance).hasDbt();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public long getDbt() {
                    return ((Device) this.instance).getDbt();
                }

                public Builder setDbt(long j) {
                    copyOnWrite();
                    ((Device) this.instance).setDbt(j);
                    return this;
                }

                public Builder clearDbt() {
                    copyOnWrite();
                    ((Device) this.instance).clearDbt();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasOrtn() {
                    return ((Device) this.instance).hasOrtn();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public int getOrtnValue() {
                    return ((Device) this.instance).getOrtnValue();
                }

                public Builder setOrtnValue(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setOrtnValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public Orientation getOrtn() {
                    return ((Device) this.instance).getOrtn();
                }

                public Builder setOrtn(Orientation orientation) {
                    copyOnWrite();
                    ((Device) this.instance).setOrtn(orientation);
                    return this;
                }

                public Builder clearOrtn() {
                    copyOnWrite();
                    ((Device) this.instance).clearOrtn();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasHasGy() {
                    return ((Device) this.instance).hasHasGy();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean getHasGy() {
                    return ((Device) this.instance).getHasGy();
                }

                public Builder setHasGy(boolean z) {
                    copyOnWrite();
                    ((Device) this.instance).setHasGy(z);
                    return this;
                }

                public Builder clearHasGy() {
                    copyOnWrite();
                    ((Device) this.instance).clearHasGy();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasKbLoc() {
                    return ((Device) this.instance).hasKbLoc();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getKbLoc() {
                    return ((Device) this.instance).getKbLoc();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getKbLocBytes() {
                    return ((Device) this.instance).getKbLocBytes();
                }

                public Builder setKbLoc(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setKbLoc(str);
                    return this;
                }

                public Builder clearKbLoc() {
                    copyOnWrite();
                    ((Device) this.instance).clearKbLoc();
                    return this;
                }

                public Builder setKbLocBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setKbLocBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasLocale() {
                    return ((Device) this.instance).hasLocale();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public String getLocale() {
                    return ((Device) this.instance).getLocale();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public ByteString getLocaleBytes() {
                    return ((Device) this.instance).getLocaleBytes();
                }

                public Builder setLocale(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setLocale(str);
                    return this;
                }

                public Builder clearLocale() {
                    copyOnWrite();
                    ((Device) this.instance).clearLocale();
                    return this;
                }

                public Builder setLocaleBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setLocaleBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasXdpi() {
                    return ((Device) this.instance).hasXdpi();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public float getXdpi() {
                    return ((Device) this.instance).getXdpi();
                }

                public Builder setXdpi(float f) {
                    copyOnWrite();
                    ((Device) this.instance).setXdpi(f);
                    return this;
                }

                public Builder clearXdpi() {
                    copyOnWrite();
                    ((Device) this.instance).clearXdpi();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public boolean hasYdpi() {
                    return ((Device) this.instance).hasYdpi();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DeviceOrBuilder
                public float getYdpi() {
                    return ((Device) this.instance).getYdpi();
                }

                public Builder setYdpi(float f) {
                    copyOnWrite();
                    ((Device) this.instance).setYdpi(f);
                    return this;
                }

                public Builder clearYdpi() {
                    copyOnWrite();
                    ((Device) this.instance).clearYdpi();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Device();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006ለ\u0005\u0007ဋ\u0006\bဋ\u0007\tဉ\b\nဋ\t\u000bဋ\n\fဋ\u000b\rက\f\u000eለ\r\u000fဃ\u000e\u0010ဌ\u000f\u0011ဇ\u0010\u0012ለ\u0011\u0013ለ\u0012\u0014ခ\u0013\u0015ခ\u0014", new Object[]{"bitField0_", "language_", "osv_", "make_", "model_", "hwv_", "carrier_", "devicetype_", "js_", "geo_", "w_", "h_", "ppi_", "pxratio_", "os_", "dbt_", "ortn_", "hasGy_", "kbLoc_", "locale_", "xdpi_", "ydpi_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Device> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Device.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Device device = new Device();
                DEFAULT_INSTANCE = device;
                GeneratedMessageLite.registerDefaultInstance(Device.class, device);
            }

            public static Device getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Device> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Geo extends GeneratedMessageLite<Geo, Builder> implements GeoOrBuilder {
            private static final Geo DEFAULT_INSTANCE;
            private static volatile Parser<Geo> PARSER = null;
            public static final int UTCOFFSET_FIELD_NUMBER = 1;
            private int bitField0_;
            private int utcoffset_;

            private Geo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.GeoOrBuilder
            public boolean hasUtcoffset() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.GeoOrBuilder
            public int getUtcoffset() {
                return this.utcoffset_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUtcoffset(int i) {
                this.bitField0_ |= 1;
                this.utcoffset_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUtcoffset() {
                this.bitField0_ &= -2;
                this.utcoffset_ = 0;
            }

            public static Geo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Geo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Geo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Geo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Geo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Geo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Geo parseFrom(InputStream inputStream) throws IOException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Geo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Geo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Geo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Geo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Geo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Geo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Geo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Geo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Geo geo) {
                return DEFAULT_INSTANCE.createBuilder(geo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Geo, Builder> implements GeoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Geo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.GeoOrBuilder
                public boolean hasUtcoffset() {
                    return ((Geo) this.instance).hasUtcoffset();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.GeoOrBuilder
                public int getUtcoffset() {
                    return ((Geo) this.instance).getUtcoffset();
                }

                public Builder setUtcoffset(int i) {
                    copyOnWrite();
                    ((Geo) this.instance).setUtcoffset(i);
                    return this;
                }

                public Builder clearUtcoffset() {
                    copyOnWrite();
                    ((Geo) this.instance).clearUtcoffset();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Geo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"bitField0_", "utcoffset_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Geo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Geo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Geo geo = new Geo();
                DEFAULT_INSTANCE = geo;
                GeneratedMessageLite.registerDefaultInstance(Geo.class, geo);
            }

            public static Geo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Geo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class SdkInfo extends GeneratedMessageLite<SdkInfo, Builder> implements SdkInfoOrBuilder {
            private static final SdkInfo DEFAULT_INSTANCE;
            public static final int INITIALIZED_FIELD_NUMBER = 1;
            private static volatile Parser<SdkInfo> PARSER;
            private int bitField0_;
            private boolean initialized_;

            private SdkInfo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.SdkInfoOrBuilder
            public boolean hasInitialized() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.SdkInfoOrBuilder
            public boolean getInitialized() {
                return this.initialized_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setInitialized(boolean z) {
                this.bitField0_ |= 1;
                this.initialized_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearInitialized() {
                this.bitField0_ &= -2;
                this.initialized_ = false;
            }

            public static SdkInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static SdkInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static SdkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static SdkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static SdkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static SdkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static SdkInfo parseFrom(InputStream inputStream) throws IOException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SdkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SdkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (SdkInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SdkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SdkInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SdkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static SdkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SdkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(SdkInfo sdkInfo) {
                return DEFAULT_INSTANCE.createBuilder(sdkInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<SdkInfo, Builder> implements SdkInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(SdkInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.SdkInfoOrBuilder
                public boolean hasInitialized() {
                    return ((SdkInfo) this.instance).hasInitialized();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.SdkInfoOrBuilder
                public boolean getInitialized() {
                    return ((SdkInfo) this.instance).getInitialized();
                }

                public Builder setInitialized(boolean z) {
                    copyOnWrite();
                    ((SdkInfo) this.instance).setInitialized(z);
                    return this;
                }

                public Builder clearInitialized() {
                    copyOnWrite();
                    ((SdkInfo) this.instance).clearInitialized();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new SdkInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"bitField0_", "initialized_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<SdkInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (SdkInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                SdkInfo sdkInfo = new SdkInfo();
                DEFAULT_INSTANCE = sdkInfo;
                GeneratedMessageLite.registerDefaultInstance(SdkInfo.class, sdkInfo);
            }

            public static SdkInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<SdkInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class MemoryInfo extends GeneratedMessageLite<MemoryInfo, Builder> implements MemoryInfoOrBuilder {
            private static final MemoryInfo DEFAULT_INSTANCE;
            public static final int LOW_MEM_FIELD_NUMBER = 1;
            public static final int LOW_MEM_THRESHOLD_BYTES_FIELD_NUMBER = 2;
            private static volatile Parser<MemoryInfo> PARSER = null;
            public static final int TOTAL_MEM_BYTES_FIELD_NUMBER = 3;
            private int bitField0_;
            private long lowMemThresholdBytes_;
            private boolean lowMem_;
            private long totalMemBytes_;

            private MemoryInfo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public boolean hasLowMem() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public boolean getLowMem() {
                return this.lowMem_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLowMem(boolean z) {
                this.bitField0_ |= 1;
                this.lowMem_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLowMem() {
                this.bitField0_ &= -2;
                this.lowMem_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public boolean hasLowMemThresholdBytes() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public long getLowMemThresholdBytes() {
                return this.lowMemThresholdBytes_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLowMemThresholdBytes(long j) {
                this.bitField0_ |= 2;
                this.lowMemThresholdBytes_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLowMemThresholdBytes() {
                this.bitField0_ &= -3;
                this.lowMemThresholdBytes_ = 0L;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public boolean hasTotalMemBytes() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
            public long getTotalMemBytes() {
                return this.totalMemBytes_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTotalMemBytes(long j) {
                this.bitField0_ |= 4;
                this.totalMemBytes_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTotalMemBytes() {
                this.bitField0_ &= -5;
                this.totalMemBytes_ = 0L;
            }

            public static MemoryInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static MemoryInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static MemoryInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static MemoryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static MemoryInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static MemoryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static MemoryInfo parseFrom(InputStream inputStream) throws IOException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MemoryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MemoryInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (MemoryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MemoryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MemoryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MemoryInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static MemoryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MemoryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(MemoryInfo memoryInfo) {
                return DEFAULT_INSTANCE.createBuilder(memoryInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<MemoryInfo, Builder> implements MemoryInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(MemoryInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public boolean hasLowMem() {
                    return ((MemoryInfo) this.instance).hasLowMem();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public boolean getLowMem() {
                    return ((MemoryInfo) this.instance).getLowMem();
                }

                public Builder setLowMem(boolean z) {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).setLowMem(z);
                    return this;
                }

                public Builder clearLowMem() {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).clearLowMem();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public boolean hasLowMemThresholdBytes() {
                    return ((MemoryInfo) this.instance).hasLowMemThresholdBytes();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public long getLowMemThresholdBytes() {
                    return ((MemoryInfo) this.instance).getLowMemThresholdBytes();
                }

                public Builder setLowMemThresholdBytes(long j) {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).setLowMemThresholdBytes(j);
                    return this;
                }

                public Builder clearLowMemThresholdBytes() {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).clearLowMemThresholdBytes();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public boolean hasTotalMemBytes() {
                    return ((MemoryInfo) this.instance).hasTotalMemBytes();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.MemoryInfoOrBuilder
                public long getTotalMemBytes() {
                    return ((MemoryInfo) this.instance).getTotalMemBytes();
                }

                public Builder setTotalMemBytes(long j) {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).setTotalMemBytes(j);
                    return this;
                }

                public Builder clearTotalMemBytes() {
                    copyOnWrite();
                    ((MemoryInfo) this.instance).clearTotalMemBytes();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new MemoryInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဃ\u0001\u0003ဃ\u0002", new Object[]{"bitField0_", "lowMem_", "lowMemThresholdBytes_", "totalMemBytes_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<MemoryInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (MemoryInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                MemoryInfo memoryInfo = new MemoryInfo();
                DEFAULT_INSTANCE = memoryInfo;
                GeneratedMessageLite.registerDefaultInstance(MemoryInfo.class, memoryInfo);
            }

            public static MemoryInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<MemoryInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class DirInfo extends GeneratedMessageLite<DirInfo, Builder> implements DirInfoOrBuilder {
            private static final DirInfo DEFAULT_INSTANCE;
            public static final int DSIZE_BYTES_FIELD_NUMBER = 1;
            private static volatile Parser<DirInfo> PARSER;
            private int bitField0_;
            private long dsizeBytes_;

            private DirInfo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DirInfoOrBuilder
            public boolean hasDsizeBytes() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DirInfoOrBuilder
            public long getDsizeBytes() {
                return this.dsizeBytes_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDsizeBytes(long j) {
                this.bitField0_ |= 1;
                this.dsizeBytes_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDsizeBytes() {
                this.bitField0_ &= -2;
                this.dsizeBytes_ = 0L;
            }

            public static DirInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static DirInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static DirInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static DirInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static DirInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static DirInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static DirInfo parseFrom(InputStream inputStream) throws IOException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static DirInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static DirInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DirInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static DirInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DirInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static DirInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static DirInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DirInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(DirInfo dirInfo) {
                return DEFAULT_INSTANCE.createBuilder(dirInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<DirInfo, Builder> implements DirInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(DirInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DirInfoOrBuilder
                public boolean hasDsizeBytes() {
                    return ((DirInfo) this.instance).hasDsizeBytes();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.DirInfoOrBuilder
                public long getDsizeBytes() {
                    return ((DirInfo) this.instance).getDsizeBytes();
                }

                public Builder setDsizeBytes(long j) {
                    copyOnWrite();
                    ((DirInfo) this.instance).setDsizeBytes(j);
                    return this;
                }

                public Builder clearDsizeBytes() {
                    copyOnWrite();
                    ((DirInfo) this.instance).clearDsizeBytes();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new DirInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဃ\u0000", new Object[]{"bitField0_", "dsizeBytes_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<DirInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (DirInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                DirInfo dirInfo = new DirInfo();
                DEFAULT_INSTANCE = dirInfo;
                GeneratedMessageLite.registerDefaultInstance(DirInfo.class, dirInfo);
            }

            public static DirInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DirInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class NetworkInfo extends GeneratedMessageLite<NetworkInfo, Builder> implements NetworkInfoOrBuilder {
            private static final NetworkInfo DEFAULT_INSTANCE;
            public static final int MCC_FIELD_NUMBER = 3;
            public static final int MNC_FIELD_NUMBER = 4;
            private static volatile Parser<NetworkInfo> PARSER = null;
            public static final int RESTRICTED_FIELD_NUMBER = 2;
            public static final int TYPE_FIELD_NUMBER = 1;
            private int bitField0_;
            private int mcc_;
            private int mnc_;
            private boolean restricted_;
            private int type_;

            private NetworkInfo() {
            }

            public enum ConnectionType implements Internal.EnumLite {
                UNKNOWN(0),
                WIFI(1),
                CELLULAR(2),
                NO_NETWORK(3),
                UNRECOGNIZED(-1);

                public static final int CELLULAR_VALUE = 2;
                public static final int NO_NETWORK_VALUE = 3;
                public static final int UNKNOWN_VALUE = 0;
                public static final int WIFI_VALUE = 1;
                private static final Internal.EnumLiteMap<ConnectionType> internalValueMap = new Internal.EnumLiteMap<ConnectionType>() { // from class: com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public ConnectionType findValueByNumber(int i) {
                        return ConnectionType.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static ConnectionType valueOf(int i) {
                    return forNumber(i);
                }

                public static ConnectionType forNumber(int i) {
                    if (i == 0) {
                        return UNKNOWN;
                    }
                    if (i == 1) {
                        return WIFI;
                    }
                    if (i == 2) {
                        return CELLULAR;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return NO_NETWORK;
                }

                public static Internal.EnumLiteMap<ConnectionType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return ConnectionTypeVerifier.INSTANCE;
                }

                private static final class ConnectionTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new ConnectionTypeVerifier();

                    private ConnectionTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return ConnectionType.forNumber(i) != null;
                    }
                }

                ConnectionType(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public boolean hasType() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public ConnectionType getType() {
                ConnectionType connectionTypeForNumber = ConnectionType.forNumber(this.type_);
                return connectionTypeForNumber == null ? ConnectionType.UNRECOGNIZED : connectionTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTypeValue(int i) {
                this.bitField0_ |= 1;
                this.type_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(ConnectionType connectionType) {
                this.type_ = connectionType.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.bitField0_ &= -2;
                this.type_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public boolean hasRestricted() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public boolean getRestricted() {
                return this.restricted_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRestricted(boolean z) {
                this.bitField0_ |= 2;
                this.restricted_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRestricted() {
                this.bitField0_ &= -3;
                this.restricted_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public boolean hasMcc() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public int getMcc() {
                return this.mcc_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMcc(int i) {
                this.bitField0_ |= 4;
                this.mcc_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMcc() {
                this.bitField0_ &= -5;
                this.mcc_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public boolean hasMnc() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
            public int getMnc() {
                return this.mnc_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMnc(int i) {
                this.bitField0_ |= 8;
                this.mnc_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMnc() {
                this.bitField0_ &= -9;
                this.mnc_ = 0;
            }

            public static NetworkInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static NetworkInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static NetworkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static NetworkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NetworkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static NetworkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static NetworkInfo parseFrom(InputStream inputStream) throws IOException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NetworkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NetworkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NetworkInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NetworkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NetworkInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NetworkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NetworkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NetworkInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(NetworkInfo networkInfo) {
                return DEFAULT_INSTANCE.createBuilder(networkInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<NetworkInfo, Builder> implements NetworkInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(NetworkInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public boolean hasType() {
                    return ((NetworkInfo) this.instance).hasType();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public int getTypeValue() {
                    return ((NetworkInfo) this.instance).getTypeValue();
                }

                public Builder setTypeValue(int i) {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).setTypeValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public ConnectionType getType() {
                    return ((NetworkInfo) this.instance).getType();
                }

                public Builder setType(ConnectionType connectionType) {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).setType(connectionType);
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).clearType();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public boolean hasRestricted() {
                    return ((NetworkInfo) this.instance).hasRestricted();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public boolean getRestricted() {
                    return ((NetworkInfo) this.instance).getRestricted();
                }

                public Builder setRestricted(boolean z) {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).setRestricted(z);
                    return this;
                }

                public Builder clearRestricted() {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).clearRestricted();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public boolean hasMcc() {
                    return ((NetworkInfo) this.instance).hasMcc();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public int getMcc() {
                    return ((NetworkInfo) this.instance).getMcc();
                }

                public Builder setMcc(int i) {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).setMcc(i);
                    return this;
                }

                public Builder clearMcc() {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).clearMcc();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public boolean hasMnc() {
                    return ((NetworkInfo) this.instance).hasMnc();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.NetworkInfoOrBuilder
                public int getMnc() {
                    return ((NetworkInfo) this.instance).getMnc();
                }

                public Builder setMnc(int i) {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).setMnc(i);
                    return this;
                }

                public Builder clearMnc() {
                    copyOnWrite();
                    ((NetworkInfo) this.instance).clearMnc();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NetworkInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဋ\u0002\u0004ဋ\u0003", new Object[]{"bitField0_", "type_", "restricted_", "mcc_", "mnc_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NetworkInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (NetworkInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                NetworkInfo networkInfo = new NetworkInfo();
                DEFAULT_INSTANCE = networkInfo;
                GeneratedMessageLite.registerDefaultInstance(NetworkInfo.class, networkInfo);
            }

            public static NetworkInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NetworkInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AdvertisingInfo extends GeneratedMessageLite<AdvertisingInfo, Builder> implements AdvertisingInfoOrBuilder {
            private static final AdvertisingInfo DEFAULT_INSTANCE;
            public static final int DNT_FIELD_NUMBER = 2;
            public static final int ID_FIELD_NUMBER = 1;
            private static volatile Parser<AdvertisingInfo> PARSER;
            private int bitField0_;
            private boolean dnt_;
            private String id_ = "";

            private AdvertisingInfo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
            public ByteString getIdBytes() {
                return ByteString.copyFromUtf8(this.id_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.id_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.bitField0_ &= -2;
                this.id_ = getDefaultInstance().getId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.id_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
            public boolean hasDnt() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
            public boolean getDnt() {
                return this.dnt_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDnt(boolean z) {
                this.bitField0_ |= 2;
                this.dnt_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDnt() {
                this.bitField0_ &= -3;
                this.dnt_ = false;
            }

            public static AdvertisingInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AdvertisingInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AdvertisingInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AdvertisingInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AdvertisingInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AdvertisingInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AdvertisingInfo parseFrom(InputStream inputStream) throws IOException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AdvertisingInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AdvertisingInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AdvertisingInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AdvertisingInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdvertisingInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AdvertisingInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AdvertisingInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdvertisingInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AdvertisingInfo advertisingInfo) {
                return DEFAULT_INSTANCE.createBuilder(advertisingInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AdvertisingInfo, Builder> implements AdvertisingInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AdvertisingInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
                public boolean hasId() {
                    return ((AdvertisingInfo) this.instance).hasId();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
                public String getId() {
                    return ((AdvertisingInfo) this.instance).getId();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
                public ByteString getIdBytes() {
                    return ((AdvertisingInfo) this.instance).getIdBytes();
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((AdvertisingInfo) this.instance).setId(str);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((AdvertisingInfo) this.instance).clearId();
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((AdvertisingInfo) this.instance).setIdBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
                public boolean hasDnt() {
                    return ((AdvertisingInfo) this.instance).hasDnt();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AdvertisingInfoOrBuilder
                public boolean getDnt() {
                    return ((AdvertisingInfo) this.instance).getDnt();
                }

                public Builder setDnt(boolean z) {
                    copyOnWrite();
                    ((AdvertisingInfo) this.instance).setDnt(z);
                    return this;
                }

                public Builder clearDnt() {
                    copyOnWrite();
                    ((AdvertisingInfo) this.instance).clearDnt();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AdvertisingInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ဇ\u0001", new Object[]{"bitField0_", "id_", "dnt_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AdvertisingInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AdvertisingInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                AdvertisingInfo advertisingInfo = new AdvertisingInfo();
                DEFAULT_INSTANCE = advertisingInfo;
                GeneratedMessageLite.registerDefaultInstance(AdvertisingInfo.class, advertisingInfo);
            }

            public static AdvertisingInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AdvertisingInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class BatteryInfo extends GeneratedMessageLite<BatteryInfo, Builder> implements BatteryInfoOrBuilder {
            public static final int BATTERY_STATUS_FIELD_NUMBER = 2;
            private static final BatteryInfo DEFAULT_INSTANCE;
            public static final int LOW_POW_MODE_FIELD_NUMBER = 3;
            public static final int MAX_BATTERY_LEVEL_FIELD_NUMBER = 1;
            private static volatile Parser<BatteryInfo> PARSER;
            private int batteryStatus_;
            private int bitField0_;
            private boolean lowPowMode_;
            private int maxBatteryLevel_;

            private BatteryInfo() {
            }

            public enum BatteryStatus implements Internal.EnumLite {
                UNKNOWN(0),
                CHARGING(1),
                DISCHARGING(2),
                NOT_CHARGING(3),
                FULL(4),
                UNRECOGNIZED(-1);

                public static final int CHARGING_VALUE = 1;
                public static final int DISCHARGING_VALUE = 2;
                public static final int FULL_VALUE = 4;
                public static final int NOT_CHARGING_VALUE = 3;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<BatteryStatus> internalValueMap = new Internal.EnumLiteMap<BatteryStatus>() { // from class: com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public BatteryStatus findValueByNumber(int i) {
                        return BatteryStatus.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static BatteryStatus valueOf(int i) {
                    return forNumber(i);
                }

                public static BatteryStatus forNumber(int i) {
                    if (i == 0) {
                        return UNKNOWN;
                    }
                    if (i == 1) {
                        return CHARGING;
                    }
                    if (i == 2) {
                        return DISCHARGING;
                    }
                    if (i == 3) {
                        return NOT_CHARGING;
                    }
                    if (i != 4) {
                        return null;
                    }
                    return FULL;
                }

                public static Internal.EnumLiteMap<BatteryStatus> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return BatteryStatusVerifier.INSTANCE;
                }

                private static final class BatteryStatusVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new BatteryStatusVerifier();

                    private BatteryStatusVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return BatteryStatus.forNumber(i) != null;
                    }
                }

                BatteryStatus(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public boolean hasMaxBatteryLevel() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public int getMaxBatteryLevel() {
                return this.maxBatteryLevel_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMaxBatteryLevel(int i) {
                this.bitField0_ |= 1;
                this.maxBatteryLevel_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMaxBatteryLevel() {
                this.bitField0_ &= -2;
                this.maxBatteryLevel_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public boolean hasBatteryStatus() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public int getBatteryStatusValue() {
                return this.batteryStatus_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public BatteryStatus getBatteryStatus() {
                BatteryStatus batteryStatusForNumber = BatteryStatus.forNumber(this.batteryStatus_);
                return batteryStatusForNumber == null ? BatteryStatus.UNRECOGNIZED : batteryStatusForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBatteryStatusValue(int i) {
                this.bitField0_ |= 2;
                this.batteryStatus_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBatteryStatus(BatteryStatus batteryStatus) {
                this.batteryStatus_ = batteryStatus.getNumber();
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBatteryStatus() {
                this.bitField0_ &= -3;
                this.batteryStatus_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public boolean hasLowPowMode() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
            public boolean getLowPowMode() {
                return this.lowPowMode_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLowPowMode(boolean z) {
                this.bitField0_ |= 4;
                this.lowPowMode_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLowPowMode() {
                this.bitField0_ &= -5;
                this.lowPowMode_ = false;
            }

            public static BatteryInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static BatteryInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static BatteryInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static BatteryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static BatteryInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static BatteryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static BatteryInfo parseFrom(InputStream inputStream) throws IOException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BatteryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BatteryInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (BatteryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BatteryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatteryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BatteryInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static BatteryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatteryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(BatteryInfo batteryInfo) {
                return DEFAULT_INSTANCE.createBuilder(batteryInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<BatteryInfo, Builder> implements BatteryInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(BatteryInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public boolean hasMaxBatteryLevel() {
                    return ((BatteryInfo) this.instance).hasMaxBatteryLevel();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public int getMaxBatteryLevel() {
                    return ((BatteryInfo) this.instance).getMaxBatteryLevel();
                }

                public Builder setMaxBatteryLevel(int i) {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).setMaxBatteryLevel(i);
                    return this;
                }

                public Builder clearMaxBatteryLevel() {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).clearMaxBatteryLevel();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public boolean hasBatteryStatus() {
                    return ((BatteryInfo) this.instance).hasBatteryStatus();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public int getBatteryStatusValue() {
                    return ((BatteryInfo) this.instance).getBatteryStatusValue();
                }

                public Builder setBatteryStatusValue(int i) {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).setBatteryStatusValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public BatteryStatus getBatteryStatus() {
                    return ((BatteryInfo) this.instance).getBatteryStatus();
                }

                public Builder setBatteryStatus(BatteryStatus batteryStatus) {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).setBatteryStatus(batteryStatus);
                    return this;
                }

                public Builder clearBatteryStatus() {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).clearBatteryStatus();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public boolean hasLowPowMode() {
                    return ((BatteryInfo) this.instance).hasLowPowMode();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.BatteryInfoOrBuilder
                public boolean getLowPowMode() {
                    return ((BatteryInfo) this.instance).getLowPowMode();
                }

                public Builder setLowPowMode(boolean z) {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).setLowPowMode(z);
                    return this;
                }

                public Builder clearLowPowMode() {
                    copyOnWrite();
                    ((BatteryInfo) this.instance).clearLowPowMode();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new BatteryInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဌ\u0001\u0003ဇ\u0002", new Object[]{"bitField0_", "maxBatteryLevel_", "batteryStatus_", "lowPowMode_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BatteryInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (BatteryInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                BatteryInfo batteryInfo = new BatteryInfo();
                DEFAULT_INSTANCE = batteryInfo;
                GeneratedMessageLite.registerDefaultInstance(BatteryInfo.class, batteryInfo);
            }

            public static BatteryInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<BatteryInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AudioInfo extends GeneratedMessageLite<AudioInfo, Builder> implements AudioInfoOrBuilder {
            private static final AudioInfo DEFAULT_INSTANCE;
            public static final int MUTE_SWITCH_FIELD_NUMBER = 1;
            private static volatile Parser<AudioInfo> PARSER = null;
            public static final int VOL_FIELD_NUMBER = 2;
            private int bitField0_;
            private int muteSwitch_;
            private int vol_;

            private AudioInfo() {
            }

            public enum MuteSwitchState implements Internal.EnumLite {
                SILENT(0),
                VIBRATE(1),
                NORMAL(2),
                UNRECOGNIZED(-1);

                public static final int NORMAL_VALUE = 2;
                public static final int SILENT_VALUE = 0;
                public static final int VIBRATE_VALUE = 1;
                private static final Internal.EnumLiteMap<MuteSwitchState> internalValueMap = new Internal.EnumLiteMap<MuteSwitchState>() { // from class: com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public MuteSwitchState findValueByNumber(int i) {
                        return MuteSwitchState.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    if (this == UNRECOGNIZED) {
                        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                    }
                    return this.value;
                }

                @Deprecated
                public static MuteSwitchState valueOf(int i) {
                    return forNumber(i);
                }

                public static MuteSwitchState forNumber(int i) {
                    if (i == 0) {
                        return SILENT;
                    }
                    if (i == 1) {
                        return VIBRATE;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return NORMAL;
                }

                public static Internal.EnumLiteMap<MuteSwitchState> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return MuteSwitchStateVerifier.INSTANCE;
                }

                private static final class MuteSwitchStateVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new MuteSwitchStateVerifier();

                    private MuteSwitchStateVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return MuteSwitchState.forNumber(i) != null;
                    }
                }

                MuteSwitchState(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
            public boolean hasMuteSwitch() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
            public int getMuteSwitchValue() {
                return this.muteSwitch_;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
            public MuteSwitchState getMuteSwitch() {
                MuteSwitchState muteSwitchStateForNumber = MuteSwitchState.forNumber(this.muteSwitch_);
                return muteSwitchStateForNumber == null ? MuteSwitchState.UNRECOGNIZED : muteSwitchStateForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMuteSwitchValue(int i) {
                this.bitField0_ |= 1;
                this.muteSwitch_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMuteSwitch(MuteSwitchState muteSwitchState) {
                this.muteSwitch_ = muteSwitchState.getNumber();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMuteSwitch() {
                this.bitField0_ &= -2;
                this.muteSwitch_ = 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
            public boolean hasVol() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
            public int getVol() {
                return this.vol_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVol(int i) {
                this.bitField0_ |= 2;
                this.vol_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVol() {
                this.bitField0_ &= -3;
                this.vol_ = 0;
            }

            public static AudioInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AudioInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AudioInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AudioInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AudioInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AudioInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AudioInfo parseFrom(InputStream inputStream) throws IOException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AudioInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AudioInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AudioInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AudioInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AudioInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AudioInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AudioInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AudioInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AudioInfo audioInfo) {
                return DEFAULT_INSTANCE.createBuilder(audioInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AudioInfo, Builder> implements AudioInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AudioInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
                public boolean hasMuteSwitch() {
                    return ((AudioInfo) this.instance).hasMuteSwitch();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
                public int getMuteSwitchValue() {
                    return ((AudioInfo) this.instance).getMuteSwitchValue();
                }

                public Builder setMuteSwitchValue(int i) {
                    copyOnWrite();
                    ((AudioInfo) this.instance).setMuteSwitchValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
                public MuteSwitchState getMuteSwitch() {
                    return ((AudioInfo) this.instance).getMuteSwitch();
                }

                public Builder setMuteSwitch(MuteSwitchState muteSwitchState) {
                    copyOnWrite();
                    ((AudioInfo) this.instance).setMuteSwitch(muteSwitchState);
                    return this;
                }

                public Builder clearMuteSwitch() {
                    copyOnWrite();
                    ((AudioInfo) this.instance).clearMuteSwitch();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
                public boolean hasVol() {
                    return ((AudioInfo) this.instance).hasVol();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AudioInfoOrBuilder
                public int getVol() {
                    return ((AudioInfo) this.instance).getVol();
                }

                public Builder setVol(int i) {
                    copyOnWrite();
                    ((AudioInfo) this.instance).setVol(i);
                    return this;
                }

                public Builder clearVol() {
                    copyOnWrite();
                    ((AudioInfo) this.instance).clearVol();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AudioInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "muteSwitch_", "vol_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AudioInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AudioInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                AudioInfo audioInfo = new AudioInfo();
                DEFAULT_INSTANCE = audioInfo;
                GeneratedMessageLite.registerDefaultInstance(AudioInfo.class, audioInfo);
            }

            public static AudioInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AudioInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AccessibilityInfo extends GeneratedMessageLite<AccessibilityInfo, Builder> implements AccessibilityInfoOrBuilder {
            public static final int ACCESSIBILITY_CAPTIONING_ENABLED_FIELD_NUMBER = 1;
            public static final int ACCESSIBILITY_LARGE_POINTER_ICON_FIELD_NUMBER = 2;
            private static final AccessibilityInfo DEFAULT_INSTANCE;
            public static final int FONT_SCALE_FIELD_NUMBER = 4;
            private static volatile Parser<AccessibilityInfo> PARSER = null;
            public static final int REDUCE_BRIGHT_COLORS_ACTIVATED_FIELD_NUMBER = 3;
            private boolean accessibilityCaptioningEnabled_;
            private boolean accessibilityLargePointerIcon_;
            private int bitField0_;
            private float fontScale_;
            private boolean reduceBrightColorsActivated_;

            private AccessibilityInfo() {
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean hasAccessibilityCaptioningEnabled() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean getAccessibilityCaptioningEnabled() {
                return this.accessibilityCaptioningEnabled_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAccessibilityCaptioningEnabled(boolean z) {
                this.bitField0_ |= 1;
                this.accessibilityCaptioningEnabled_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAccessibilityCaptioningEnabled() {
                this.bitField0_ &= -2;
                this.accessibilityCaptioningEnabled_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean hasAccessibilityLargePointerIcon() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean getAccessibilityLargePointerIcon() {
                return this.accessibilityLargePointerIcon_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAccessibilityLargePointerIcon(boolean z) {
                this.bitField0_ |= 2;
                this.accessibilityLargePointerIcon_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAccessibilityLargePointerIcon() {
                this.bitField0_ &= -3;
                this.accessibilityLargePointerIcon_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean hasReduceBrightColorsActivated() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean getReduceBrightColorsActivated() {
                return this.reduceBrightColorsActivated_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setReduceBrightColorsActivated(boolean z) {
                this.bitField0_ |= 4;
                this.reduceBrightColorsActivated_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearReduceBrightColorsActivated() {
                this.bitField0_ &= -5;
                this.reduceBrightColorsActivated_ = false;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public boolean hasFontScale() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
            public float getFontScale() {
                return this.fontScale_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFontScale(float f) {
                this.bitField0_ |= 8;
                this.fontScale_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFontScale() {
                this.bitField0_ &= -9;
                this.fontScale_ = 0.0f;
            }

            public static AccessibilityInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AccessibilityInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AccessibilityInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AccessibilityInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AccessibilityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AccessibilityInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AccessibilityInfo parseFrom(InputStream inputStream) throws IOException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AccessibilityInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AccessibilityInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AccessibilityInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AccessibilityInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AccessibilityInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AccessibilityInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AccessibilityInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AccessibilityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AccessibilityInfo accessibilityInfo) {
                return DEFAULT_INSTANCE.createBuilder(accessibilityInfo);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AccessibilityInfo, Builder> implements AccessibilityInfoOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AccessibilityInfo.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean hasAccessibilityCaptioningEnabled() {
                    return ((AccessibilityInfo) this.instance).hasAccessibilityCaptioningEnabled();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean getAccessibilityCaptioningEnabled() {
                    return ((AccessibilityInfo) this.instance).getAccessibilityCaptioningEnabled();
                }

                public Builder setAccessibilityCaptioningEnabled(boolean z) {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).setAccessibilityCaptioningEnabled(z);
                    return this;
                }

                public Builder clearAccessibilityCaptioningEnabled() {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).clearAccessibilityCaptioningEnabled();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean hasAccessibilityLargePointerIcon() {
                    return ((AccessibilityInfo) this.instance).hasAccessibilityLargePointerIcon();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean getAccessibilityLargePointerIcon() {
                    return ((AccessibilityInfo) this.instance).getAccessibilityLargePointerIcon();
                }

                public Builder setAccessibilityLargePointerIcon(boolean z) {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).setAccessibilityLargePointerIcon(z);
                    return this;
                }

                public Builder clearAccessibilityLargePointerIcon() {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).clearAccessibilityLargePointerIcon();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean hasReduceBrightColorsActivated() {
                    return ((AccessibilityInfo) this.instance).hasReduceBrightColorsActivated();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean getReduceBrightColorsActivated() {
                    return ((AccessibilityInfo) this.instance).getReduceBrightColorsActivated();
                }

                public Builder setReduceBrightColorsActivated(boolean z) {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).setReduceBrightColorsActivated(z);
                    return this;
                }

                public Builder clearReduceBrightColorsActivated() {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).clearReduceBrightColorsActivated();
                    return this;
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public boolean hasFontScale() {
                    return ((AccessibilityInfo) this.instance).hasFontScale();
                }

                @Override // com.moloco.sdk.BidToken.ClientBidTokenComponents.AccessibilityInfoOrBuilder
                public float getFontScale() {
                    return ((AccessibilityInfo) this.instance).getFontScale();
                }

                public Builder setFontScale(float f) {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).setFontScale(f);
                    return this;
                }

                public Builder clearFontScale() {
                    copyOnWrite();
                    ((AccessibilityInfo) this.instance).clearFontScale();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AccessibilityInfo();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "accessibilityCaptioningEnabled_", "accessibilityLargePointerIcon_", "reduceBrightColorsActivated_", "fontScale_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AccessibilityInfo> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AccessibilityInfo.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                AccessibilityInfo accessibilityInfo = new AccessibilityInfo();
                DEFAULT_INSTANCE = accessibilityInfo;
                GeneratedMessageLite.registerDefaultInstance(AccessibilityInfo.class, accessibilityInfo);
            }

            public static AccessibilityInfo getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AccessibilityInfo> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasIdfv() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public String getIdfv() {
            return this.idfv_;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public ByteString getIdfvBytes() {
            return ByteString.copyFromUtf8(this.idfv_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfv(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.idfv_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdfv() {
            this.bitField0_ &= -2;
            this.idfv_ = getDefaultInstance().getIdfv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfvBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfv_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasPrivacy() {
            return this.privacy_ != null;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public Privacy getPrivacy() {
            Privacy privacy = this.privacy_;
            return privacy == null ? Privacy.getDefaultInstance() : privacy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrivacy(Privacy privacy) {
            privacy.getClass();
            this.privacy_ = privacy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePrivacy(Privacy privacy) {
            privacy.getClass();
            Privacy privacy2 = this.privacy_;
            if (privacy2 != null && privacy2 != Privacy.getDefaultInstance()) {
                this.privacy_ = Privacy.newBuilder(this.privacy_).mergeFrom(privacy).buildPartial();
            } else {
                this.privacy_ = privacy;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrivacy() {
            this.privacy_ = null;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasDevice() {
            return this.device_ != null;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public Device getDevice() {
            Device device = this.device_;
            return device == null ? Device.getDefaultInstance() : device;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device device) {
            device.getClass();
            this.device_ = device;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDevice(Device device) {
            device.getClass();
            Device device2 = this.device_;
            if (device2 != null && device2 != Device.getDefaultInstance()) {
                this.device_ = Device.newBuilder(this.device_).mergeFrom(device).buildPartial();
            } else {
                this.device_ = device;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasInfo() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public SdkInfo getInfo() {
            SdkInfo sdkInfo = this.info_;
            return sdkInfo == null ? SdkInfo.getDefaultInstance() : sdkInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInfo(SdkInfo sdkInfo) {
            sdkInfo.getClass();
            this.info_ = sdkInfo;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInfo(SdkInfo sdkInfo) {
            sdkInfo.getClass();
            SdkInfo sdkInfo2 = this.info_;
            if (sdkInfo2 != null && sdkInfo2 != SdkInfo.getDefaultInstance()) {
                this.info_ = SdkInfo.newBuilder(this.info_).mergeFrom(sdkInfo).buildPartial();
            } else {
                this.info_ = sdkInfo;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfo() {
            this.info_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasMemoryInfo() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public MemoryInfo getMemoryInfo() {
            MemoryInfo memoryInfo = this.memoryInfo_;
            return memoryInfo == null ? MemoryInfo.getDefaultInstance() : memoryInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMemoryInfo(MemoryInfo memoryInfo) {
            memoryInfo.getClass();
            this.memoryInfo_ = memoryInfo;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMemoryInfo(MemoryInfo memoryInfo) {
            memoryInfo.getClass();
            MemoryInfo memoryInfo2 = this.memoryInfo_;
            if (memoryInfo2 != null && memoryInfo2 != MemoryInfo.getDefaultInstance()) {
                this.memoryInfo_ = MemoryInfo.newBuilder(this.memoryInfo_).mergeFrom(memoryInfo).buildPartial();
            } else {
                this.memoryInfo_ = memoryInfo;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMemoryInfo() {
            this.memoryInfo_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasDirInfo() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public DirInfo getDirInfo() {
            DirInfo dirInfo = this.dirInfo_;
            return dirInfo == null ? DirInfo.getDefaultInstance() : dirInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDirInfo(DirInfo dirInfo) {
            dirInfo.getClass();
            this.dirInfo_ = dirInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDirInfo(DirInfo dirInfo) {
            dirInfo.getClass();
            DirInfo dirInfo2 = this.dirInfo_;
            if (dirInfo2 != null && dirInfo2 != DirInfo.getDefaultInstance()) {
                this.dirInfo_ = DirInfo.newBuilder(this.dirInfo_).mergeFrom(dirInfo).buildPartial();
            } else {
                this.dirInfo_ = dirInfo;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDirInfo() {
            this.dirInfo_ = null;
            this.bitField0_ &= -9;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasNetworkInfo() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public NetworkInfo getNetworkInfo() {
            NetworkInfo networkInfo = this.networkInfo_;
            return networkInfo == null ? NetworkInfo.getDefaultInstance() : networkInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkInfo(NetworkInfo networkInfo) {
            networkInfo.getClass();
            this.networkInfo_ = networkInfo;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeNetworkInfo(NetworkInfo networkInfo) {
            networkInfo.getClass();
            NetworkInfo networkInfo2 = this.networkInfo_;
            if (networkInfo2 != null && networkInfo2 != NetworkInfo.getDefaultInstance()) {
                this.networkInfo_ = NetworkInfo.newBuilder(this.networkInfo_).mergeFrom(networkInfo).buildPartial();
            } else {
                this.networkInfo_ = networkInfo;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetworkInfo() {
            this.networkInfo_ = null;
            this.bitField0_ &= -17;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasAdInfo() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public AdvertisingInfo getAdInfo() {
            AdvertisingInfo advertisingInfo = this.adInfo_;
            return advertisingInfo == null ? AdvertisingInfo.getDefaultInstance() : advertisingInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdInfo(AdvertisingInfo advertisingInfo) {
            advertisingInfo.getClass();
            this.adInfo_ = advertisingInfo;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAdInfo(AdvertisingInfo advertisingInfo) {
            advertisingInfo.getClass();
            AdvertisingInfo advertisingInfo2 = this.adInfo_;
            if (advertisingInfo2 != null && advertisingInfo2 != AdvertisingInfo.getDefaultInstance()) {
                this.adInfo_ = AdvertisingInfo.newBuilder(this.adInfo_).mergeFrom(advertisingInfo).buildPartial();
            } else {
                this.adInfo_ = advertisingInfo;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdInfo() {
            this.adInfo_ = null;
            this.bitField0_ &= -33;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasBatteryInfo() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public BatteryInfo getBatteryInfo() {
            BatteryInfo batteryInfo = this.batteryInfo_;
            return batteryInfo == null ? BatteryInfo.getDefaultInstance() : batteryInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBatteryInfo(BatteryInfo batteryInfo) {
            batteryInfo.getClass();
            this.batteryInfo_ = batteryInfo;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBatteryInfo(BatteryInfo batteryInfo) {
            batteryInfo.getClass();
            BatteryInfo batteryInfo2 = this.batteryInfo_;
            if (batteryInfo2 != null && batteryInfo2 != BatteryInfo.getDefaultInstance()) {
                this.batteryInfo_ = BatteryInfo.newBuilder(this.batteryInfo_).mergeFrom(batteryInfo).buildPartial();
            } else {
                this.batteryInfo_ = batteryInfo;
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBatteryInfo() {
            this.batteryInfo_ = null;
            this.bitField0_ &= -65;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasAudioInfo() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public AudioInfo getAudioInfo() {
            AudioInfo audioInfo = this.audioInfo_;
            return audioInfo == null ? AudioInfo.getDefaultInstance() : audioInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAudioInfo(AudioInfo audioInfo) {
            audioInfo.getClass();
            this.audioInfo_ = audioInfo;
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAudioInfo(AudioInfo audioInfo) {
            audioInfo.getClass();
            AudioInfo audioInfo2 = this.audioInfo_;
            if (audioInfo2 != null && audioInfo2 != AudioInfo.getDefaultInstance()) {
                this.audioInfo_ = AudioInfo.newBuilder(this.audioInfo_).mergeFrom(audioInfo).buildPartial();
            } else {
                this.audioInfo_ = audioInfo;
            }
            this.bitField0_ |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAudioInfo() {
            this.audioInfo_ = null;
            this.bitField0_ &= -129;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public boolean hasAccessibilityInfo() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
        public AccessibilityInfo getAccessibilityInfo() {
            AccessibilityInfo accessibilityInfo = this.accessibilityInfo_;
            return accessibilityInfo == null ? AccessibilityInfo.getDefaultInstance() : accessibilityInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessibilityInfo(AccessibilityInfo accessibilityInfo) {
            accessibilityInfo.getClass();
            this.accessibilityInfo_ = accessibilityInfo;
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAccessibilityInfo(AccessibilityInfo accessibilityInfo) {
            accessibilityInfo.getClass();
            AccessibilityInfo accessibilityInfo2 = this.accessibilityInfo_;
            if (accessibilityInfo2 != null && accessibilityInfo2 != AccessibilityInfo.getDefaultInstance()) {
                this.accessibilityInfo_ = AccessibilityInfo.newBuilder(this.accessibilityInfo_).mergeFrom(accessibilityInfo).buildPartial();
            } else {
                this.accessibilityInfo_ = accessibilityInfo;
            }
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAccessibilityInfo() {
            this.accessibilityInfo_ = null;
            this.bitField0_ &= -257;
        }

        public static ClientBidTokenComponents parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ClientBidTokenComponents parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientBidTokenComponents parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientBidTokenComponents parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientBidTokenComponents parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientBidTokenComponents parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientBidTokenComponents parseFrom(InputStream inputStream) throws IOException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientBidTokenComponents parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientBidTokenComponents parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientBidTokenComponents) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientBidTokenComponents parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidTokenComponents) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientBidTokenComponents parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientBidTokenComponents parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidTokenComponents) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClientBidTokenComponents clientBidTokenComponents) {
            return DEFAULT_INSTANCE.createBuilder(clientBidTokenComponents);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClientBidTokenComponents, Builder> implements ClientBidTokenComponentsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ClientBidTokenComponents.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasIdfv() {
                return ((ClientBidTokenComponents) this.instance).hasIdfv();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public String getIdfv() {
                return ((ClientBidTokenComponents) this.instance).getIdfv();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public ByteString getIdfvBytes() {
                return ((ClientBidTokenComponents) this.instance).getIdfvBytes();
            }

            public Builder setIdfv(String str) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setIdfv(str);
                return this;
            }

            public Builder clearIdfv() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearIdfv();
                return this;
            }

            public Builder setIdfvBytes(ByteString byteString) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setIdfvBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasPrivacy() {
                return ((ClientBidTokenComponents) this.instance).hasPrivacy();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public Privacy getPrivacy() {
                return ((ClientBidTokenComponents) this.instance).getPrivacy();
            }

            public Builder setPrivacy(Privacy privacy) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setPrivacy(privacy);
                return this;
            }

            public Builder setPrivacy(Privacy.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setPrivacy(builder.build());
                return this;
            }

            public Builder mergePrivacy(Privacy privacy) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergePrivacy(privacy);
                return this;
            }

            public Builder clearPrivacy() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearPrivacy();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasDevice() {
                return ((ClientBidTokenComponents) this.instance).hasDevice();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public Device getDevice() {
                return ((ClientBidTokenComponents) this.instance).getDevice();
            }

            public Builder setDevice(Device device) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setDevice(device);
                return this;
            }

            public Builder setDevice(Device.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setDevice(builder.build());
                return this;
            }

            public Builder mergeDevice(Device device) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeDevice(device);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearDevice();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasInfo() {
                return ((ClientBidTokenComponents) this.instance).hasInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public SdkInfo getInfo() {
                return ((ClientBidTokenComponents) this.instance).getInfo();
            }

            public Builder setInfo(SdkInfo sdkInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setInfo(sdkInfo);
                return this;
            }

            public Builder setInfo(SdkInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setInfo(builder.build());
                return this;
            }

            public Builder mergeInfo(SdkInfo sdkInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeInfo(sdkInfo);
                return this;
            }

            public Builder clearInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasMemoryInfo() {
                return ((ClientBidTokenComponents) this.instance).hasMemoryInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public MemoryInfo getMemoryInfo() {
                return ((ClientBidTokenComponents) this.instance).getMemoryInfo();
            }

            public Builder setMemoryInfo(MemoryInfo memoryInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setMemoryInfo(memoryInfo);
                return this;
            }

            public Builder setMemoryInfo(MemoryInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setMemoryInfo(builder.build());
                return this;
            }

            public Builder mergeMemoryInfo(MemoryInfo memoryInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeMemoryInfo(memoryInfo);
                return this;
            }

            public Builder clearMemoryInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearMemoryInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasDirInfo() {
                return ((ClientBidTokenComponents) this.instance).hasDirInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public DirInfo getDirInfo() {
                return ((ClientBidTokenComponents) this.instance).getDirInfo();
            }

            public Builder setDirInfo(DirInfo dirInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setDirInfo(dirInfo);
                return this;
            }

            public Builder setDirInfo(DirInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setDirInfo(builder.build());
                return this;
            }

            public Builder mergeDirInfo(DirInfo dirInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeDirInfo(dirInfo);
                return this;
            }

            public Builder clearDirInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearDirInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasNetworkInfo() {
                return ((ClientBidTokenComponents) this.instance).hasNetworkInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public NetworkInfo getNetworkInfo() {
                return ((ClientBidTokenComponents) this.instance).getNetworkInfo();
            }

            public Builder setNetworkInfo(NetworkInfo networkInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setNetworkInfo(networkInfo);
                return this;
            }

            public Builder setNetworkInfo(NetworkInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setNetworkInfo(builder.build());
                return this;
            }

            public Builder mergeNetworkInfo(NetworkInfo networkInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeNetworkInfo(networkInfo);
                return this;
            }

            public Builder clearNetworkInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearNetworkInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasAdInfo() {
                return ((ClientBidTokenComponents) this.instance).hasAdInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public AdvertisingInfo getAdInfo() {
                return ((ClientBidTokenComponents) this.instance).getAdInfo();
            }

            public Builder setAdInfo(AdvertisingInfo advertisingInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAdInfo(advertisingInfo);
                return this;
            }

            public Builder setAdInfo(AdvertisingInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAdInfo(builder.build());
                return this;
            }

            public Builder mergeAdInfo(AdvertisingInfo advertisingInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeAdInfo(advertisingInfo);
                return this;
            }

            public Builder clearAdInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearAdInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasBatteryInfo() {
                return ((ClientBidTokenComponents) this.instance).hasBatteryInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public BatteryInfo getBatteryInfo() {
                return ((ClientBidTokenComponents) this.instance).getBatteryInfo();
            }

            public Builder setBatteryInfo(BatteryInfo batteryInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setBatteryInfo(batteryInfo);
                return this;
            }

            public Builder setBatteryInfo(BatteryInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setBatteryInfo(builder.build());
                return this;
            }

            public Builder mergeBatteryInfo(BatteryInfo batteryInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeBatteryInfo(batteryInfo);
                return this;
            }

            public Builder clearBatteryInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearBatteryInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasAudioInfo() {
                return ((ClientBidTokenComponents) this.instance).hasAudioInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public AudioInfo getAudioInfo() {
                return ((ClientBidTokenComponents) this.instance).getAudioInfo();
            }

            public Builder setAudioInfo(AudioInfo audioInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAudioInfo(audioInfo);
                return this;
            }

            public Builder setAudioInfo(AudioInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAudioInfo(builder.build());
                return this;
            }

            public Builder mergeAudioInfo(AudioInfo audioInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeAudioInfo(audioInfo);
                return this;
            }

            public Builder clearAudioInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearAudioInfo();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public boolean hasAccessibilityInfo() {
                return ((ClientBidTokenComponents) this.instance).hasAccessibilityInfo();
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenComponentsOrBuilder
            public AccessibilityInfo getAccessibilityInfo() {
                return ((ClientBidTokenComponents) this.instance).getAccessibilityInfo();
            }

            public Builder setAccessibilityInfo(AccessibilityInfo accessibilityInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAccessibilityInfo(accessibilityInfo);
                return this;
            }

            public Builder setAccessibilityInfo(AccessibilityInfo.Builder builder) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).setAccessibilityInfo(builder.build());
                return this;
            }

            public Builder mergeAccessibilityInfo(AccessibilityInfo accessibilityInfo) {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).mergeAccessibilityInfo(accessibilityInfo);
                return this;
            }

            public Builder clearAccessibilityInfo() {
                copyOnWrite();
                ((ClientBidTokenComponents) this.instance).clearAccessibilityInfo();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ClientBidTokenComponents();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ለ\u0000\u0002\t\u0003\t\u0004ဉ\u0001\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဉ\u0004\bဉ\u0005\tဉ\u0006\nဉ\u0007\u000bဉ\b", new Object[]{"bitField0_", "idfv_", "privacy_", "device_", "info_", "memoryInfo_", "dirInfo_", "networkInfo_", "adInfo_", "batteryInfo_", "audioInfo_", "accessibilityInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClientBidTokenComponents> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ClientBidTokenComponents.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ClientBidTokenComponents clientBidTokenComponents = new ClientBidTokenComponents();
            DEFAULT_INSTANCE = clientBidTokenComponents;
            GeneratedMessageLite.registerDefaultInstance(ClientBidTokenComponents.class, clientBidTokenComponents);
        }

        public static ClientBidTokenComponents getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientBidTokenComponents> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ClientBidToken extends GeneratedMessageLite<ClientBidToken, Builder> implements ClientBidTokenOrBuilder {
        private static final ClientBidToken DEFAULT_INSTANCE;
        public static final int ES_FIELD_NUMBER = 1;
        private static volatile Parser<ClientBidToken> PARSER = null;
        public static final int PAYLOAD_FIELD_NUMBER = 2;
        private ByteString es_ = ByteString.EMPTY;
        private ByteString payload_ = ByteString.EMPTY;

        private ClientBidToken() {
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenOrBuilder
        public ByteString getEs() {
            return this.es_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEs(ByteString byteString) {
            byteString.getClass();
            this.es_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEs() {
            this.es_ = getDefaultInstance().getEs();
        }

        @Override // com.moloco.sdk.BidToken.ClientBidTokenOrBuilder
        public ByteString getPayload() {
            return this.payload_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPayload(ByteString byteString) {
            byteString.getClass();
            this.payload_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPayload() {
            this.payload_ = getDefaultInstance().getPayload();
        }

        public static ClientBidToken parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ClientBidToken parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ClientBidToken parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ClientBidToken parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ClientBidToken parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ClientBidToken parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ClientBidToken parseFrom(InputStream inputStream) throws IOException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientBidToken parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientBidToken parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ClientBidToken) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ClientBidToken parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidToken) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ClientBidToken parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ClientBidToken parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ClientBidToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClientBidToken clientBidToken) {
            return DEFAULT_INSTANCE.createBuilder(clientBidToken);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClientBidToken, Builder> implements ClientBidTokenOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ClientBidToken.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenOrBuilder
            public ByteString getEs() {
                return ((ClientBidToken) this.instance).getEs();
            }

            public Builder setEs(ByteString byteString) {
                copyOnWrite();
                ((ClientBidToken) this.instance).setEs(byteString);
                return this;
            }

            public Builder clearEs() {
                copyOnWrite();
                ((ClientBidToken) this.instance).clearEs();
                return this;
            }

            @Override // com.moloco.sdk.BidToken.ClientBidTokenOrBuilder
            public ByteString getPayload() {
                return ((ClientBidToken) this.instance).getPayload();
            }

            public Builder setPayload(ByteString byteString) {
                copyOnWrite();
                ((ClientBidToken) this.instance).setPayload(byteString);
                return this;
            }

            public Builder clearPayload() {
                copyOnWrite();
                ((ClientBidToken) this.instance).clearPayload();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ClientBidToken();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\n", new Object[]{"es_", "payload_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClientBidToken> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ClientBidToken.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ClientBidToken clientBidToken = new ClientBidToken();
            DEFAULT_INSTANCE = clientBidToken;
            GeneratedMessageLite.registerDefaultInstance(ClientBidToken.class, clientBidToken);
        }

        public static ClientBidToken getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientBidToken> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
