package com.moloco.sdk;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public final class ConfigsOuterClass {

    public interface ConfigsOrBuilder extends MessageLiteOrBuilder {
        Configs.AndroidConfigs getAndroidConfig();

        Configs.ClientConfigsCase getClientConfigsCase();

        Configs.CommonConfigs getCommonConfigs();

        Configs.IOSConfigs getIosConfig();

        boolean hasAndroidConfig();

        boolean hasCommonConfigs();

        boolean hasIosConfig();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ConfigsOuterClass() {
    }

    public static final class Configs extends GeneratedMessageLite<Configs, Builder> implements ConfigsOrBuilder {
        public static final int ANDROID_CONFIG_FIELD_NUMBER = 1;
        public static final int COMMON_CONFIGS_FIELD_NUMBER = 3;
        private static final Configs DEFAULT_INSTANCE;
        public static final int IOS_CONFIG_FIELD_NUMBER = 2;
        private static volatile Parser<Configs> PARSER;
        private int clientConfigsCase_ = 0;
        private Object clientConfigs_;
        private CommonConfigs commonConfigs_;

        public interface AndroidConfigsOrBuilder extends MessageLiteOrBuilder {
        }

        public interface CommonConfigsOrBuilder extends MessageLiteOrBuilder {
            CommonConfigs.MediaConfig getMediaConfig();

            boolean hasMediaConfig();
        }

        public interface IOSConfigsOrBuilder extends MessageLiteOrBuilder {
        }

        private Configs() {
        }

        public static final class AndroidConfigs extends GeneratedMessageLite<AndroidConfigs, Builder> implements AndroidConfigsOrBuilder {
            private static final AndroidConfigs DEFAULT_INSTANCE;
            private static volatile Parser<AndroidConfigs> PARSER;

            private AndroidConfigs() {
            }

            public static AndroidConfigs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AndroidConfigs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AndroidConfigs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AndroidConfigs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AndroidConfigs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AndroidConfigs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AndroidConfigs parseFrom(InputStream inputStream) throws IOException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AndroidConfigs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AndroidConfigs parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AndroidConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AndroidConfigs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AndroidConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AndroidConfigs parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AndroidConfigs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AndroidConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AndroidConfigs androidConfigs) {
                return DEFAULT_INSTANCE.createBuilder(androidConfigs);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AndroidConfigs, Builder> implements AndroidConfigsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AndroidConfigs.DEFAULT_INSTANCE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AndroidConfigs();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AndroidConfigs> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AndroidConfigs.class) {
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
                AndroidConfigs androidConfigs = new AndroidConfigs();
                DEFAULT_INSTANCE = androidConfigs;
                GeneratedMessageLite.registerDefaultInstance(AndroidConfigs.class, androidConfigs);
            }

            public static AndroidConfigs getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AndroidConfigs> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class IOSConfigs extends GeneratedMessageLite<IOSConfigs, Builder> implements IOSConfigsOrBuilder {
            private static final IOSConfigs DEFAULT_INSTANCE;
            private static volatile Parser<IOSConfigs> PARSER;

            private IOSConfigs() {
            }

            public static IOSConfigs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static IOSConfigs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static IOSConfigs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static IOSConfigs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static IOSConfigs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static IOSConfigs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static IOSConfigs parseFrom(InputStream inputStream) throws IOException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static IOSConfigs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static IOSConfigs parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (IOSConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static IOSConfigs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static IOSConfigs parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static IOSConfigs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(IOSConfigs iOSConfigs) {
                return DEFAULT_INSTANCE.createBuilder(iOSConfigs);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<IOSConfigs, Builder> implements IOSConfigsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(IOSConfigs.DEFAULT_INSTANCE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new IOSConfigs();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<IOSConfigs> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (IOSConfigs.class) {
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
                IOSConfigs iOSConfigs = new IOSConfigs();
                DEFAULT_INSTANCE = iOSConfigs;
                GeneratedMessageLite.registerDefaultInstance(IOSConfigs.class, iOSConfigs);
            }

            public static IOSConfigs getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<IOSConfigs> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class CommonConfigs extends GeneratedMessageLite<CommonConfigs, Builder> implements CommonConfigsOrBuilder {
            private static final CommonConfigs DEFAULT_INSTANCE;
            public static final int MEDIA_CONFIG_FIELD_NUMBER = 1;
            private static volatile Parser<CommonConfigs> PARSER;
            private MediaConfig mediaConfig_;

            public interface MediaConfigOrBuilder extends MessageLiteOrBuilder {
                double getMinStreamingPlayableDurationOnTimeoutSecs();

                long getStreamingChunkSizeKilobytes();

                boolean hasMinStreamingPlayableDurationOnTimeoutSecs();

                boolean hasStreamingChunkSizeKilobytes();
            }

            private CommonConfigs() {
            }

            public static final class MediaConfig extends GeneratedMessageLite<MediaConfig, Builder> implements MediaConfigOrBuilder {
                private static final MediaConfig DEFAULT_INSTANCE;
                public static final int MIN_STREAMING_PLAYABLE_DURATION_ON_TIMEOUT_SECS_FIELD_NUMBER = 2;
                private static volatile Parser<MediaConfig> PARSER = null;
                public static final int STREAMING_CHUNK_SIZE_KILOBYTES_FIELD_NUMBER = 1;
                private int bitField0_;
                private double minStreamingPlayableDurationOnTimeoutSecs_;
                private long streamingChunkSizeKilobytes_;

                private MediaConfig() {
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                public boolean hasStreamingChunkSizeKilobytes() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                public long getStreamingChunkSizeKilobytes() {
                    return this.streamingChunkSizeKilobytes_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setStreamingChunkSizeKilobytes(long j) {
                    this.bitField0_ |= 1;
                    this.streamingChunkSizeKilobytes_ = j;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearStreamingChunkSizeKilobytes() {
                    this.bitField0_ &= -2;
                    this.streamingChunkSizeKilobytes_ = 0L;
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                public boolean hasMinStreamingPlayableDurationOnTimeoutSecs() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                public double getMinStreamingPlayableDurationOnTimeoutSecs() {
                    return this.minStreamingPlayableDurationOnTimeoutSecs_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMinStreamingPlayableDurationOnTimeoutSecs(double d) {
                    this.bitField0_ |= 2;
                    this.minStreamingPlayableDurationOnTimeoutSecs_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMinStreamingPlayableDurationOnTimeoutSecs() {
                    this.bitField0_ &= -3;
                    this.minStreamingPlayableDurationOnTimeoutSecs_ = 0.0d;
                }

                public static MediaConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static MediaConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static MediaConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static MediaConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static MediaConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static MediaConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static MediaConfig parseFrom(InputStream inputStream) throws IOException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static MediaConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static MediaConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (MediaConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static MediaConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (MediaConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static MediaConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static MediaConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (MediaConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Builder newBuilder(MediaConfig mediaConfig) {
                    return DEFAULT_INSTANCE.createBuilder(mediaConfig);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<MediaConfig, Builder> implements MediaConfigOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(MediaConfig.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                    public boolean hasStreamingChunkSizeKilobytes() {
                        return ((MediaConfig) this.instance).hasStreamingChunkSizeKilobytes();
                    }

                    @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                    public long getStreamingChunkSizeKilobytes() {
                        return ((MediaConfig) this.instance).getStreamingChunkSizeKilobytes();
                    }

                    public Builder setStreamingChunkSizeKilobytes(long j) {
                        copyOnWrite();
                        ((MediaConfig) this.instance).setStreamingChunkSizeKilobytes(j);
                        return this;
                    }

                    public Builder clearStreamingChunkSizeKilobytes() {
                        copyOnWrite();
                        ((MediaConfig) this.instance).clearStreamingChunkSizeKilobytes();
                        return this;
                    }

                    @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                    public boolean hasMinStreamingPlayableDurationOnTimeoutSecs() {
                        return ((MediaConfig) this.instance).hasMinStreamingPlayableDurationOnTimeoutSecs();
                    }

                    @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigs.MediaConfigOrBuilder
                    public double getMinStreamingPlayableDurationOnTimeoutSecs() {
                        return ((MediaConfig) this.instance).getMinStreamingPlayableDurationOnTimeoutSecs();
                    }

                    public Builder setMinStreamingPlayableDurationOnTimeoutSecs(double d) {
                        copyOnWrite();
                        ((MediaConfig) this.instance).setMinStreamingPlayableDurationOnTimeoutSecs(d);
                        return this;
                    }

                    public Builder clearMinStreamingPlayableDurationOnTimeoutSecs() {
                        copyOnWrite();
                        ((MediaConfig) this.instance).clearMinStreamingPlayableDurationOnTimeoutSecs();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new MediaConfig();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002က\u0001", new Object[]{"bitField0_", "streamingChunkSizeKilobytes_", "minStreamingPlayableDurationOnTimeoutSecs_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<MediaConfig> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (MediaConfig.class) {
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
                    MediaConfig mediaConfig = new MediaConfig();
                    DEFAULT_INSTANCE = mediaConfig;
                    GeneratedMessageLite.registerDefaultInstance(MediaConfig.class, mediaConfig);
                }

                public static MediaConfig getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<MediaConfig> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigsOrBuilder
            public boolean hasMediaConfig() {
                return this.mediaConfig_ != null;
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigsOrBuilder
            public MediaConfig getMediaConfig() {
                MediaConfig mediaConfig = this.mediaConfig_;
                return mediaConfig == null ? MediaConfig.getDefaultInstance() : mediaConfig;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMediaConfig(MediaConfig mediaConfig) {
                mediaConfig.getClass();
                this.mediaConfig_ = mediaConfig;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeMediaConfig(MediaConfig mediaConfig) {
                mediaConfig.getClass();
                MediaConfig mediaConfig2 = this.mediaConfig_;
                if (mediaConfig2 != null && mediaConfig2 != MediaConfig.getDefaultInstance()) {
                    this.mediaConfig_ = MediaConfig.newBuilder(this.mediaConfig_).mergeFrom(mediaConfig).buildPartial();
                } else {
                    this.mediaConfig_ = mediaConfig;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMediaConfig() {
                this.mediaConfig_ = null;
            }

            public static CommonConfigs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static CommonConfigs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static CommonConfigs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static CommonConfigs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static CommonConfigs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static CommonConfigs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static CommonConfigs parseFrom(InputStream inputStream) throws IOException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CommonConfigs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CommonConfigs parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (CommonConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CommonConfigs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CommonConfigs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CommonConfigs parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static CommonConfigs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CommonConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(CommonConfigs commonConfigs) {
                return DEFAULT_INSTANCE.createBuilder(commonConfigs);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<CommonConfigs, Builder> implements CommonConfigsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(CommonConfigs.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigsOrBuilder
                public boolean hasMediaConfig() {
                    return ((CommonConfigs) this.instance).hasMediaConfig();
                }

                @Override // com.moloco.sdk.ConfigsOuterClass.Configs.CommonConfigsOrBuilder
                public MediaConfig getMediaConfig() {
                    return ((CommonConfigs) this.instance).getMediaConfig();
                }

                public Builder setMediaConfig(MediaConfig mediaConfig) {
                    copyOnWrite();
                    ((CommonConfigs) this.instance).setMediaConfig(mediaConfig);
                    return this;
                }

                public Builder setMediaConfig(MediaConfig.Builder builder) {
                    copyOnWrite();
                    ((CommonConfigs) this.instance).setMediaConfig(builder.build());
                    return this;
                }

                public Builder mergeMediaConfig(MediaConfig mediaConfig) {
                    copyOnWrite();
                    ((CommonConfigs) this.instance).mergeMediaConfig(mediaConfig);
                    return this;
                }

                public Builder clearMediaConfig() {
                    copyOnWrite();
                    ((CommonConfigs) this.instance).clearMediaConfig();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new CommonConfigs();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"mediaConfig_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<CommonConfigs> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (CommonConfigs.class) {
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
                CommonConfigs commonConfigs = new CommonConfigs();
                DEFAULT_INSTANCE = commonConfigs;
                GeneratedMessageLite.registerDefaultInstance(CommonConfigs.class, commonConfigs);
            }

            public static CommonConfigs getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<CommonConfigs> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum ClientConfigsCase {
            ANDROID_CONFIG(1),
            IOS_CONFIG(2),
            CLIENTCONFIGS_NOT_SET(0);

            private final int value;

            ClientConfigsCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ClientConfigsCase valueOf(int i) {
                return forNumber(i);
            }

            public static ClientConfigsCase forNumber(int i) {
                if (i == 0) {
                    return CLIENTCONFIGS_NOT_SET;
                }
                if (i == 1) {
                    return ANDROID_CONFIG;
                }
                if (i != 2) {
                    return null;
                }
                return IOS_CONFIG;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public ClientConfigsCase getClientConfigsCase() {
            return ClientConfigsCase.forNumber(this.clientConfigsCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientConfigs() {
            this.clientConfigsCase_ = 0;
            this.clientConfigs_ = null;
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public boolean hasAndroidConfig() {
            return this.clientConfigsCase_ == 1;
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public AndroidConfigs getAndroidConfig() {
            if (this.clientConfigsCase_ == 1) {
                return (AndroidConfigs) this.clientConfigs_;
            }
            return AndroidConfigs.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroidConfig(AndroidConfigs androidConfigs) {
            androidConfigs.getClass();
            this.clientConfigs_ = androidConfigs;
            this.clientConfigsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAndroidConfig(AndroidConfigs androidConfigs) {
            androidConfigs.getClass();
            if (this.clientConfigsCase_ == 1 && this.clientConfigs_ != AndroidConfigs.getDefaultInstance()) {
                this.clientConfigs_ = AndroidConfigs.newBuilder((AndroidConfigs) this.clientConfigs_).mergeFrom(androidConfigs).buildPartial();
            } else {
                this.clientConfigs_ = androidConfigs;
            }
            this.clientConfigsCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndroidConfig() {
            if (this.clientConfigsCase_ == 1) {
                this.clientConfigsCase_ = 0;
                this.clientConfigs_ = null;
            }
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public boolean hasIosConfig() {
            return this.clientConfigsCase_ == 2;
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public IOSConfigs getIosConfig() {
            if (this.clientConfigsCase_ == 2) {
                return (IOSConfigs) this.clientConfigs_;
            }
            return IOSConfigs.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIosConfig(IOSConfigs iOSConfigs) {
            iOSConfigs.getClass();
            this.clientConfigs_ = iOSConfigs;
            this.clientConfigsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeIosConfig(IOSConfigs iOSConfigs) {
            iOSConfigs.getClass();
            if (this.clientConfigsCase_ == 2 && this.clientConfigs_ != IOSConfigs.getDefaultInstance()) {
                this.clientConfigs_ = IOSConfigs.newBuilder((IOSConfigs) this.clientConfigs_).mergeFrom(iOSConfigs).buildPartial();
            } else {
                this.clientConfigs_ = iOSConfigs;
            }
            this.clientConfigsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIosConfig() {
            if (this.clientConfigsCase_ == 2) {
                this.clientConfigsCase_ = 0;
                this.clientConfigs_ = null;
            }
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public boolean hasCommonConfigs() {
            return this.commonConfigs_ != null;
        }

        @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
        public CommonConfigs getCommonConfigs() {
            CommonConfigs commonConfigs = this.commonConfigs_;
            return commonConfigs == null ? CommonConfigs.getDefaultInstance() : commonConfigs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCommonConfigs(CommonConfigs commonConfigs) {
            commonConfigs.getClass();
            this.commonConfigs_ = commonConfigs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCommonConfigs(CommonConfigs commonConfigs) {
            commonConfigs.getClass();
            CommonConfigs commonConfigs2 = this.commonConfigs_;
            if (commonConfigs2 != null && commonConfigs2 != CommonConfigs.getDefaultInstance()) {
                this.commonConfigs_ = CommonConfigs.newBuilder(this.commonConfigs_).mergeFrom(commonConfigs).buildPartial();
            } else {
                this.commonConfigs_ = commonConfigs;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCommonConfigs() {
            this.commonConfigs_ = null;
        }

        public static Configs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Configs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Configs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Configs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Configs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Configs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Configs parseFrom(InputStream inputStream) throws IOException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Configs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Configs parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Configs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Configs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Configs parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Configs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Configs configs) {
            return DEFAULT_INSTANCE.createBuilder(configs);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Configs, Builder> implements ConfigsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Configs.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public ClientConfigsCase getClientConfigsCase() {
                return ((Configs) this.instance).getClientConfigsCase();
            }

            public Builder clearClientConfigs() {
                copyOnWrite();
                ((Configs) this.instance).clearClientConfigs();
                return this;
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public boolean hasAndroidConfig() {
                return ((Configs) this.instance).hasAndroidConfig();
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public AndroidConfigs getAndroidConfig() {
                return ((Configs) this.instance).getAndroidConfig();
            }

            public Builder setAndroidConfig(AndroidConfigs androidConfigs) {
                copyOnWrite();
                ((Configs) this.instance).setAndroidConfig(androidConfigs);
                return this;
            }

            public Builder setAndroidConfig(AndroidConfigs.Builder builder) {
                copyOnWrite();
                ((Configs) this.instance).setAndroidConfig(builder.build());
                return this;
            }

            public Builder mergeAndroidConfig(AndroidConfigs androidConfigs) {
                copyOnWrite();
                ((Configs) this.instance).mergeAndroidConfig(androidConfigs);
                return this;
            }

            public Builder clearAndroidConfig() {
                copyOnWrite();
                ((Configs) this.instance).clearAndroidConfig();
                return this;
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public boolean hasIosConfig() {
                return ((Configs) this.instance).hasIosConfig();
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public IOSConfigs getIosConfig() {
                return ((Configs) this.instance).getIosConfig();
            }

            public Builder setIosConfig(IOSConfigs iOSConfigs) {
                copyOnWrite();
                ((Configs) this.instance).setIosConfig(iOSConfigs);
                return this;
            }

            public Builder setIosConfig(IOSConfigs.Builder builder) {
                copyOnWrite();
                ((Configs) this.instance).setIosConfig(builder.build());
                return this;
            }

            public Builder mergeIosConfig(IOSConfigs iOSConfigs) {
                copyOnWrite();
                ((Configs) this.instance).mergeIosConfig(iOSConfigs);
                return this;
            }

            public Builder clearIosConfig() {
                copyOnWrite();
                ((Configs) this.instance).clearIosConfig();
                return this;
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public boolean hasCommonConfigs() {
                return ((Configs) this.instance).hasCommonConfigs();
            }

            @Override // com.moloco.sdk.ConfigsOuterClass.ConfigsOrBuilder
            public CommonConfigs getCommonConfigs() {
                return ((Configs) this.instance).getCommonConfigs();
            }

            public Builder setCommonConfigs(CommonConfigs commonConfigs) {
                copyOnWrite();
                ((Configs) this.instance).setCommonConfigs(commonConfigs);
                return this;
            }

            public Builder setCommonConfigs(CommonConfigs.Builder builder) {
                copyOnWrite();
                ((Configs) this.instance).setCommonConfigs(builder.build());
                return this;
            }

            public Builder mergeCommonConfigs(CommonConfigs commonConfigs) {
                copyOnWrite();
                ((Configs) this.instance).mergeCommonConfigs(commonConfigs);
                return this;
            }

            public Builder clearCommonConfigs() {
                copyOnWrite();
                ((Configs) this.instance).clearCommonConfigs();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Configs();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003\t", new Object[]{"clientConfigs_", "clientConfigsCase_", AndroidConfigs.class, IOSConfigs.class, "commonConfigs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Configs> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Configs.class) {
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
            Configs configs = new Configs();
            DEFAULT_INSTANCE = configs;
            GeneratedMessageLite.registerDefaultInstance(Configs.class, configs);
        }

        public static Configs getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Configs> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.ConfigsOuterClass$1, reason: invalid class name */
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
}
