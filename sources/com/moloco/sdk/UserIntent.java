package com.moloco.sdk;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class UserIntent {

    public interface UserAdInteractionExtOrBuilder extends MessageLiteOrBuilder {
        String getAdvertisingId();

        ByteString getAdvertisingIdBytes();

        UserAdInteractionExt.App getApp();

        UserAdInteractionExt.AppBackgroundingInteraction getAppBackgroundingInteraction();

        UserAdInteractionExt.AppForegroundingInteraction getAppForegroundingInteraction();

        UserAdInteractionExt.ClickInteraction getClickInteraction();

        long getClientTimestamp();

        UserAdInteractionExt.Device getDevice();

        UserAdInteractionExt.ImpressionInteraction getImpInteraction();

        UserAdInteractionExt.InfoExtCase getInfoExtCase();

        String getMref();

        ByteString getMrefBytes();

        UserAdInteractionExt.Network getNetwork();

        UserAdInteractionExt.MolocoSDK getSdk();

        boolean hasApp();

        boolean hasAppBackgroundingInteraction();

        boolean hasAppForegroundingInteraction();

        boolean hasClickInteraction();

        boolean hasDevice();

        boolean hasImpInteraction();

        boolean hasNetwork();

        boolean hasSdk();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private UserIntent() {
    }

    public static final class UserAdInteractionExt extends GeneratedMessageLite<UserAdInteractionExt, Builder> implements UserAdInteractionExtOrBuilder {
        public static final int ADVERTISING_ID_FIELD_NUMBER = 3;
        public static final int APP_BACKGROUNDING_INTERACTION_FIELD_NUMBER = 103;
        public static final int APP_FIELD_NUMBER = 5;
        public static final int APP_FOREGROUNDING_INTERACTION_FIELD_NUMBER = 102;
        public static final int CLICK_INTERACTION_FIELD_NUMBER = 101;
        public static final int CLIENT_TIMESTAMP_FIELD_NUMBER = 2;
        private static final UserAdInteractionExt DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 4;
        public static final int IMP_INTERACTION_FIELD_NUMBER = 100;
        public static final int MREF_FIELD_NUMBER = 1;
        public static final int NETWORK_FIELD_NUMBER = 6;
        private static volatile Parser<UserAdInteractionExt> PARSER = null;
        public static final int SDK_FIELD_NUMBER = 7;
        private App app_;
        private long clientTimestamp_;
        private Device device_;
        private Object infoExt_;
        private Network network_;
        private MolocoSDK sdk_;
        private int infoExtCase_ = 0;
        private String mref_ = "";
        private String advertisingId_ = "";

        public interface AppBackgroundingInteractionOrBuilder extends MessageLiteOrBuilder {
        }

        public interface AppForegroundingInteractionOrBuilder extends MessageLiteOrBuilder {
            long getBgTsMs();
        }

        public interface AppOrBuilder extends MessageLiteOrBuilder {
            String getId();

            ByteString getIdBytes();

            String getVer();

            ByteString getVerBytes();
        }

        public interface ButtonOrBuilder extends MessageLiteOrBuilder {
            Position getPos();

            Size getSize();

            Button.Type getType();

            int getTypeValue();

            boolean hasPos();

            boolean hasSize();
        }

        public interface ClickInteractionOrBuilder extends MessageLiteOrBuilder {
            Button getButtons(int i);

            int getButtonsCount();

            List<Button> getButtonsList();

            Position getClickPos();

            Size getScreenSize();

            Position getViewPos();

            Size getViewSize();

            boolean hasClickPos();

            boolean hasScreenSize();

            boolean hasViewPos();

            boolean hasViewSize();
        }

        public interface DeviceOrBuilder extends MessageLiteOrBuilder {
            String getModel();

            ByteString getModelBytes();

            Device.OsType getOs();

            int getOsValue();

            String getOsVer();

            ByteString getOsVerBytes();

            float getScreenScale();
        }

        public interface ImpressionInteractionOrBuilder extends MessageLiteOrBuilder {
        }

        public interface MolocoSDKOrBuilder extends MessageLiteOrBuilder {
            String getAdapterVer();

            ByteString getAdapterVerBytes();

            String getCoreVer();

            ByteString getCoreVerBytes();
        }

        public interface NetworkOrBuilder extends MessageLiteOrBuilder {
            String getCarrier();

            ByteString getCarrierBytes();

            Network.ConnectionType getConnectionType();

            int getConnectionTypeValue();
        }

        public interface PositionOrBuilder extends MessageLiteOrBuilder {
            float getX();

            float getY();
        }

        public interface SizeOrBuilder extends MessageLiteOrBuilder {
            float getH();

            float getW();
        }

        private UserAdInteractionExt() {
        }

        public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
            private static final Device DEFAULT_INSTANCE;
            public static final int MODEL_FIELD_NUMBER = 3;
            public static final int OS_FIELD_NUMBER = 1;
            public static final int OS_VER_FIELD_NUMBER = 2;
            private static volatile Parser<Device> PARSER = null;
            public static final int SCREEN_SCALE_FIELD_NUMBER = 4;
            private int os_;
            private float screenScale_;
            private String osVer_ = "";
            private String model_ = "";

            private Device() {
            }

            public enum OsType implements Internal.EnumLite {
                UNKNOWN(0),
                ANDROID(1),
                IOS(2),
                UNRECOGNIZED(-1);

                public static final int ANDROID_VALUE = 1;
                public static final int IOS_VALUE = 2;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<OsType> internalValueMap = new Internal.EnumLiteMap<OsType>() { // from class: com.moloco.sdk.UserIntent.UserAdInteractionExt.Device.OsType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public OsType findValueByNumber(int i) {
                        return OsType.forNumber(i);
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
                public static OsType valueOf(int i) {
                    return forNumber(i);
                }

                public static OsType forNumber(int i) {
                    if (i == 0) {
                        return UNKNOWN;
                    }
                    if (i == 1) {
                        return ANDROID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return IOS;
                }

                public static Internal.EnumLiteMap<OsType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return OsTypeVerifier.INSTANCE;
                }

                private static final class OsTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new OsTypeVerifier();

                    private OsTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return OsType.forNumber(i) != null;
                    }
                }

                OsType(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public int getOsValue() {
                return this.os_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public OsType getOs() {
                OsType osTypeForNumber = OsType.forNumber(this.os_);
                return osTypeForNumber == null ? OsType.UNRECOGNIZED : osTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsValue(int i) {
                this.os_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOs(OsType osType) {
                this.os_ = osType.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOs() {
                this.os_ = 0;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public String getOsVer() {
                return this.osVer_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public ByteString getOsVerBytes() {
                return ByteString.copyFromUtf8(this.osVer_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsVer(String str) {
                str.getClass();
                this.osVer_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOsVer() {
                this.osVer_ = getDefaultInstance().getOsVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsVerBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.osVer_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public String getModel() {
                return this.model_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public ByteString getModelBytes() {
                return ByteString.copyFromUtf8(this.model_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModel(String str) {
                str.getClass();
                this.model_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearModel() {
                this.model_ = getDefaultInstance().getModel();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModelBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.model_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
            public float getScreenScale() {
                return this.screenScale_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setScreenScale(float f) {
                this.screenScale_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearScreenScale() {
                this.screenScale_ = 0.0f;
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

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public int getOsValue() {
                    return ((Device) this.instance).getOsValue();
                }

                public Builder setOsValue(int i) {
                    copyOnWrite();
                    ((Device) this.instance).setOsValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public OsType getOs() {
                    return ((Device) this.instance).getOs();
                }

                public Builder setOs(OsType osType) {
                    copyOnWrite();
                    ((Device) this.instance).setOs(osType);
                    return this;
                }

                public Builder clearOs() {
                    copyOnWrite();
                    ((Device) this.instance).clearOs();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public String getOsVer() {
                    return ((Device) this.instance).getOsVer();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public ByteString getOsVerBytes() {
                    return ((Device) this.instance).getOsVerBytes();
                }

                public Builder setOsVer(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setOsVer(str);
                    return this;
                }

                public Builder clearOsVer() {
                    copyOnWrite();
                    ((Device) this.instance).clearOsVer();
                    return this;
                }

                public Builder setOsVerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setOsVerBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public String getModel() {
                    return ((Device) this.instance).getModel();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
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

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.DeviceOrBuilder
                public float getScreenScale() {
                    return ((Device) this.instance).getScreenScale();
                }

                public Builder setScreenScale(float f) {
                    copyOnWrite();
                    ((Device) this.instance).setScreenScale(f);
                    return this;
                }

                public Builder clearScreenScale() {
                    copyOnWrite();
                    ((Device) this.instance).clearScreenScale();
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
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004\u0001", new Object[]{"os_", "osVer_", "model_", "screenScale_"});
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

        public static final class App extends GeneratedMessageLite<App, Builder> implements AppOrBuilder {
            private static final App DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 1;
            private static volatile Parser<App> PARSER = null;
            public static final int VER_FIELD_NUMBER = 2;
            private String id_ = "";
            private String ver_ = "";

            private App() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
            public ByteString getIdBytes() {
                return ByteString.copyFromUtf8(this.id_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(String str) {
                str.getClass();
                this.id_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.id_ = getDefaultInstance().getId();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIdBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.id_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
            public String getVer() {
                return this.ver_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
            public ByteString getVerBytes() {
                return ByteString.copyFromUtf8(this.ver_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVer(String str) {
                str.getClass();
                this.ver_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVer() {
                this.ver_ = getDefaultInstance().getVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVerBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.ver_ = byteString.toStringUtf8();
            }

            public static App parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static App parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static App parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static App parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static App parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static App parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static App parseFrom(InputStream inputStream) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static App parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static App parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (App) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static App parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static App parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static App parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (App) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(App app) {
                return DEFAULT_INSTANCE.createBuilder(app);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<App, Builder> implements AppOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(App.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
                public String getId() {
                    return ((App) this.instance).getId();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
                public ByteString getIdBytes() {
                    return ((App) this.instance).getIdBytes();
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((App) this.instance).setId(str);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((App) this.instance).clearId();
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setIdBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
                public String getVer() {
                    return ((App) this.instance).getVer();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppOrBuilder
                public ByteString getVerBytes() {
                    return ((App) this.instance).getVerBytes();
                }

                public Builder setVer(String str) {
                    copyOnWrite();
                    ((App) this.instance).setVer(str);
                    return this;
                }

                public Builder clearVer() {
                    copyOnWrite();
                    ((App) this.instance).clearVer();
                    return this;
                }

                public Builder setVerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setVerBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new App();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"id_", "ver_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<App> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (App.class) {
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
                App app = new App();
                DEFAULT_INSTANCE = app;
                GeneratedMessageLite.registerDefaultInstance(App.class, app);
            }

            public static App getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<App> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Network extends GeneratedMessageLite<Network, Builder> implements NetworkOrBuilder {
            public static final int CARRIER_FIELD_NUMBER = 2;
            public static final int CONNECTION_TYPE_FIELD_NUMBER = 1;
            private static final Network DEFAULT_INSTANCE;
            private static volatile Parser<Network> PARSER;
            private String carrier_ = "";
            private int connectionType_;

            private Network() {
            }

            public enum ConnectionType implements Internal.EnumLite {
                UNKNOWN(0),
                WIFI(1),
                CELLULAR(2),
                UNRECOGNIZED(-1);

                public static final int CELLULAR_VALUE = 2;
                public static final int UNKNOWN_VALUE = 0;
                public static final int WIFI_VALUE = 1;
                private static final Internal.EnumLiteMap<ConnectionType> internalValueMap = new Internal.EnumLiteMap<ConnectionType>() { // from class: com.moloco.sdk.UserIntent.UserAdInteractionExt.Network.ConnectionType.1
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
                    if (i != 2) {
                        return null;
                    }
                    return CELLULAR;
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

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
            public int getConnectionTypeValue() {
                return this.connectionType_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
            public ConnectionType getConnectionType() {
                ConnectionType connectionTypeForNumber = ConnectionType.forNumber(this.connectionType_);
                return connectionTypeForNumber == null ? ConnectionType.UNRECOGNIZED : connectionTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setConnectionTypeValue(int i) {
                this.connectionType_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setConnectionType(ConnectionType connectionType) {
                this.connectionType_ = connectionType.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearConnectionType() {
                this.connectionType_ = 0;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
            public String getCarrier() {
                return this.carrier_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
            public ByteString getCarrierBytes() {
                return ByteString.copyFromUtf8(this.carrier_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrier(String str) {
                str.getClass();
                this.carrier_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCarrier() {
                this.carrier_ = getDefaultInstance().getCarrier();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrierBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.carrier_ = byteString.toStringUtf8();
            }

            public static Network parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Network parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Network parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Network parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Network parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Network parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Network parseFrom(InputStream inputStream) throws IOException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Network parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Network parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Network) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Network parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Network) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Network parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Network parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Network) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Network network) {
                return DEFAULT_INSTANCE.createBuilder(network);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Network, Builder> implements NetworkOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Network.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
                public int getConnectionTypeValue() {
                    return ((Network) this.instance).getConnectionTypeValue();
                }

                public Builder setConnectionTypeValue(int i) {
                    copyOnWrite();
                    ((Network) this.instance).setConnectionTypeValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
                public ConnectionType getConnectionType() {
                    return ((Network) this.instance).getConnectionType();
                }

                public Builder setConnectionType(ConnectionType connectionType) {
                    copyOnWrite();
                    ((Network) this.instance).setConnectionType(connectionType);
                    return this;
                }

                public Builder clearConnectionType() {
                    copyOnWrite();
                    ((Network) this.instance).clearConnectionType();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
                public String getCarrier() {
                    return ((Network) this.instance).getCarrier();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.NetworkOrBuilder
                public ByteString getCarrierBytes() {
                    return ((Network) this.instance).getCarrierBytes();
                }

                public Builder setCarrier(String str) {
                    copyOnWrite();
                    ((Network) this.instance).setCarrier(str);
                    return this;
                }

                public Builder clearCarrier() {
                    copyOnWrite();
                    ((Network) this.instance).clearCarrier();
                    return this;
                }

                public Builder setCarrierBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Network) this.instance).setCarrierBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Network();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"connectionType_", "carrier_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Network> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Network.class) {
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
                Network network = new Network();
                DEFAULT_INSTANCE = network;
                GeneratedMessageLite.registerDefaultInstance(Network.class, network);
            }

            public static Network getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Network> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class MolocoSDK extends GeneratedMessageLite<MolocoSDK, Builder> implements MolocoSDKOrBuilder {
            public static final int ADAPTER_VER_FIELD_NUMBER = 2;
            public static final int CORE_VER_FIELD_NUMBER = 1;
            private static final MolocoSDK DEFAULT_INSTANCE;
            private static volatile Parser<MolocoSDK> PARSER;
            private String coreVer_ = "";
            private String adapterVer_ = "";

            private MolocoSDK() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
            public String getCoreVer() {
                return this.coreVer_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
            public ByteString getCoreVerBytes() {
                return ByteString.copyFromUtf8(this.coreVer_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCoreVer(String str) {
                str.getClass();
                this.coreVer_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCoreVer() {
                this.coreVer_ = getDefaultInstance().getCoreVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCoreVerBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.coreVer_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
            public String getAdapterVer() {
                return this.adapterVer_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
            public ByteString getAdapterVerBytes() {
                return ByteString.copyFromUtf8(this.adapterVer_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAdapterVer(String str) {
                str.getClass();
                this.adapterVer_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAdapterVer() {
                this.adapterVer_ = getDefaultInstance().getAdapterVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAdapterVerBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.adapterVer_ = byteString.toStringUtf8();
            }

            public static MolocoSDK parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static MolocoSDK parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static MolocoSDK parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static MolocoSDK parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static MolocoSDK parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static MolocoSDK parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static MolocoSDK parseFrom(InputStream inputStream) throws IOException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MolocoSDK parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MolocoSDK parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (MolocoSDK) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static MolocoSDK parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MolocoSDK) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MolocoSDK parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static MolocoSDK parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MolocoSDK) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(MolocoSDK molocoSDK) {
                return DEFAULT_INSTANCE.createBuilder(molocoSDK);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<MolocoSDK, Builder> implements MolocoSDKOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(MolocoSDK.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
                public String getCoreVer() {
                    return ((MolocoSDK) this.instance).getCoreVer();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
                public ByteString getCoreVerBytes() {
                    return ((MolocoSDK) this.instance).getCoreVerBytes();
                }

                public Builder setCoreVer(String str) {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).setCoreVer(str);
                    return this;
                }

                public Builder clearCoreVer() {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).clearCoreVer();
                    return this;
                }

                public Builder setCoreVerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).setCoreVerBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
                public String getAdapterVer() {
                    return ((MolocoSDK) this.instance).getAdapterVer();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.MolocoSDKOrBuilder
                public ByteString getAdapterVerBytes() {
                    return ((MolocoSDK) this.instance).getAdapterVerBytes();
                }

                public Builder setAdapterVer(String str) {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).setAdapterVer(str);
                    return this;
                }

                public Builder clearAdapterVer() {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).clearAdapterVer();
                    return this;
                }

                public Builder setAdapterVerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((MolocoSDK) this.instance).setAdapterVerBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new MolocoSDK();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"coreVer_", "adapterVer_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<MolocoSDK> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (MolocoSDK.class) {
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
                MolocoSDK molocoSDK = new MolocoSDK();
                DEFAULT_INSTANCE = molocoSDK;
                GeneratedMessageLite.registerDefaultInstance(MolocoSDK.class, molocoSDK);
            }

            public static MolocoSDK getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<MolocoSDK> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class ImpressionInteraction extends GeneratedMessageLite<ImpressionInteraction, Builder> implements ImpressionInteractionOrBuilder {
            private static final ImpressionInteraction DEFAULT_INSTANCE;
            private static volatile Parser<ImpressionInteraction> PARSER;

            private ImpressionInteraction() {
            }

            public static ImpressionInteraction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ImpressionInteraction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ImpressionInteraction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ImpressionInteraction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ImpressionInteraction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ImpressionInteraction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ImpressionInteraction parseFrom(InputStream inputStream) throws IOException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ImpressionInteraction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ImpressionInteraction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ImpressionInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ImpressionInteraction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ImpressionInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ImpressionInteraction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ImpressionInteraction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ImpressionInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ImpressionInteraction impressionInteraction) {
                return DEFAULT_INSTANCE.createBuilder(impressionInteraction);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ImpressionInteraction, Builder> implements ImpressionInteractionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ImpressionInteraction.DEFAULT_INSTANCE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ImpressionInteraction();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ImpressionInteraction> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ImpressionInteraction.class) {
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
                ImpressionInteraction impressionInteraction = new ImpressionInteraction();
                DEFAULT_INSTANCE = impressionInteraction;
                GeneratedMessageLite.registerDefaultInstance(ImpressionInteraction.class, impressionInteraction);
            }

            public static ImpressionInteraction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ImpressionInteraction> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Position extends GeneratedMessageLite<Position, Builder> implements PositionOrBuilder {
            private static final Position DEFAULT_INSTANCE;
            private static volatile Parser<Position> PARSER = null;
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private float x_;
            private float y_;

            private Position() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.PositionOrBuilder
            public float getX() {
                return this.x_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setX(float f) {
                this.x_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearX() {
                this.x_ = 0.0f;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.PositionOrBuilder
            public float getY() {
                return this.y_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setY(float f) {
                this.y_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearY() {
                this.y_ = 0.0f;
            }

            public static Position parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Position parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Position parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Position parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Position parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Position parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Position parseFrom(InputStream inputStream) throws IOException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Position parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Position parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Position) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Position parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Position) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Position parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Position parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Position) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Position position) {
                return DEFAULT_INSTANCE.createBuilder(position);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Position, Builder> implements PositionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Position.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.PositionOrBuilder
                public float getX() {
                    return ((Position) this.instance).getX();
                }

                public Builder setX(float f) {
                    copyOnWrite();
                    ((Position) this.instance).setX(f);
                    return this;
                }

                public Builder clearX() {
                    copyOnWrite();
                    ((Position) this.instance).clearX();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.PositionOrBuilder
                public float getY() {
                    return ((Position) this.instance).getY();
                }

                public Builder setY(float f) {
                    copyOnWrite();
                    ((Position) this.instance).setY(f);
                    return this;
                }

                public Builder clearY() {
                    copyOnWrite();
                    ((Position) this.instance).clearY();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Position();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"x_", "y_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Position> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Position.class) {
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
                Position position = new Position();
                DEFAULT_INSTANCE = position;
                GeneratedMessageLite.registerDefaultInstance(Position.class, position);
            }

            public static Position getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Position> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Size extends GeneratedMessageLite<Size, Builder> implements SizeOrBuilder {
            private static final Size DEFAULT_INSTANCE;
            public static final int H_FIELD_NUMBER = 2;
            private static volatile Parser<Size> PARSER = null;
            public static final int W_FIELD_NUMBER = 1;
            private float h_;
            private float w_;

            private Size() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.SizeOrBuilder
            public float getW() {
                return this.w_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setW(float f) {
                this.w_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearW() {
                this.w_ = 0.0f;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.SizeOrBuilder
            public float getH() {
                return this.h_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setH(float f) {
                this.h_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearH() {
                this.h_ = 0.0f;
            }

            public static Size parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Size parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Size parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Size parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Size parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Size parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Size parseFrom(InputStream inputStream) throws IOException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Size parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Size parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Size) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Size parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Size) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Size parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Size parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Size) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Size size) {
                return DEFAULT_INSTANCE.createBuilder(size);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Size, Builder> implements SizeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Size.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.SizeOrBuilder
                public float getW() {
                    return ((Size) this.instance).getW();
                }

                public Builder setW(float f) {
                    copyOnWrite();
                    ((Size) this.instance).setW(f);
                    return this;
                }

                public Builder clearW() {
                    copyOnWrite();
                    ((Size) this.instance).clearW();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.SizeOrBuilder
                public float getH() {
                    return ((Size) this.instance).getH();
                }

                public Builder setH(float f) {
                    copyOnWrite();
                    ((Size) this.instance).setH(f);
                    return this;
                }

                public Builder clearH() {
                    copyOnWrite();
                    ((Size) this.instance).clearH();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Size();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0001\u0002\u0001", new Object[]{"w_", "h_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Size> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Size.class) {
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
                Size size = new Size();
                DEFAULT_INSTANCE = size;
                GeneratedMessageLite.registerDefaultInstance(Size.class, size);
            }

            public static Size getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Size> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Button extends GeneratedMessageLite<Button, Builder> implements ButtonOrBuilder {
            private static final Button DEFAULT_INSTANCE;
            private static volatile Parser<Button> PARSER = null;
            public static final int POS_FIELD_NUMBER = 2;
            public static final int SIZE_FIELD_NUMBER = 3;
            public static final int TYPE_FIELD_NUMBER = 1;
            private Position pos_;
            private Size size_;
            private int type_;

            private Button() {
            }

            public enum Type implements Internal.EnumLite {
                NONE(0),
                CLOSE(1),
                SKIP(2),
                MUTE(3),
                UNMUTE(4),
                CTA(5),
                REPLAY(6),
                DEC_SKIP(7),
                AD_BADGE(8),
                UNRECOGNIZED(-1);

                public static final int AD_BADGE_VALUE = 8;
                public static final int CLOSE_VALUE = 1;
                public static final int CTA_VALUE = 5;
                public static final int DEC_SKIP_VALUE = 7;
                public static final int MUTE_VALUE = 3;
                public static final int NONE_VALUE = 0;
                public static final int REPLAY_VALUE = 6;
                public static final int SKIP_VALUE = 2;
                public static final int UNMUTE_VALUE = 4;
                private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.moloco.sdk.UserIntent.UserAdInteractionExt.Button.Type.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public Type findValueByNumber(int i) {
                        return Type.forNumber(i);
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
                public static Type valueOf(int i) {
                    return forNumber(i);
                }

                public static Type forNumber(int i) {
                    switch (i) {
                        case 0:
                            return NONE;
                        case 1:
                            return CLOSE;
                        case 2:
                            return SKIP;
                        case 3:
                            return MUTE;
                        case 4:
                            return UNMUTE;
                        case 5:
                            return CTA;
                        case 6:
                            return REPLAY;
                        case 7:
                            return DEC_SKIP;
                        case 8:
                            return AD_BADGE;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return TypeVerifier.INSTANCE;
                }

                private static final class TypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new TypeVerifier();

                    private TypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return Type.forNumber(i) != null;
                    }
                }

                Type(int i) {
                    this.value = i;
                }
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public Type getType() {
                Type typeForNumber = Type.forNumber(this.type_);
                return typeForNumber == null ? Type.UNRECOGNIZED : typeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTypeValue(int i) {
                this.type_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(Type type) {
                this.type_ = type.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.type_ = 0;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public boolean hasPos() {
                return this.pos_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public Position getPos() {
                Position position = this.pos_;
                return position == null ? Position.getDefaultInstance() : position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPos(Position position) {
                position.getClass();
                this.pos_ = position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergePos(Position position) {
                position.getClass();
                Position position2 = this.pos_;
                if (position2 != null && position2 != Position.getDefaultInstance()) {
                    this.pos_ = Position.newBuilder(this.pos_).mergeFrom(position).buildPartial();
                } else {
                    this.pos_ = position;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPos() {
                this.pos_ = null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public boolean hasSize() {
                return this.size_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
            public Size getSize() {
                Size size = this.size_;
                return size == null ? Size.getDefaultInstance() : size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSize(Size size) {
                size.getClass();
                this.size_ = size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeSize(Size size) {
                size.getClass();
                Size size2 = this.size_;
                if (size2 != null && size2 != Size.getDefaultInstance()) {
                    this.size_ = Size.newBuilder(this.size_).mergeFrom(size).buildPartial();
                } else {
                    this.size_ = size;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSize() {
                this.size_ = null;
            }

            public static Button parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Button parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Button parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Button parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Button parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Button parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Button parseFrom(InputStream inputStream) throws IOException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Button parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Button parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Button) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Button parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Button) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Button parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Button parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Button) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Button button) {
                return DEFAULT_INSTANCE.createBuilder(button);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Button, Builder> implements ButtonOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Button.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public int getTypeValue() {
                    return ((Button) this.instance).getTypeValue();
                }

                public Builder setTypeValue(int i) {
                    copyOnWrite();
                    ((Button) this.instance).setTypeValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public Type getType() {
                    return ((Button) this.instance).getType();
                }

                public Builder setType(Type type) {
                    copyOnWrite();
                    ((Button) this.instance).setType(type);
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((Button) this.instance).clearType();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public boolean hasPos() {
                    return ((Button) this.instance).hasPos();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public Position getPos() {
                    return ((Button) this.instance).getPos();
                }

                public Builder setPos(Position position) {
                    copyOnWrite();
                    ((Button) this.instance).setPos(position);
                    return this;
                }

                public Builder setPos(Position.Builder builder) {
                    copyOnWrite();
                    ((Button) this.instance).setPos(builder.build());
                    return this;
                }

                public Builder mergePos(Position position) {
                    copyOnWrite();
                    ((Button) this.instance).mergePos(position);
                    return this;
                }

                public Builder clearPos() {
                    copyOnWrite();
                    ((Button) this.instance).clearPos();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public boolean hasSize() {
                    return ((Button) this.instance).hasSize();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ButtonOrBuilder
                public Size getSize() {
                    return ((Button) this.instance).getSize();
                }

                public Builder setSize(Size size) {
                    copyOnWrite();
                    ((Button) this.instance).setSize(size);
                    return this;
                }

                public Builder setSize(Size.Builder builder) {
                    copyOnWrite();
                    ((Button) this.instance).setSize(builder.build());
                    return this;
                }

                public Builder mergeSize(Size size) {
                    copyOnWrite();
                    ((Button) this.instance).mergeSize(size);
                    return this;
                }

                public Builder clearSize() {
                    copyOnWrite();
                    ((Button) this.instance).clearSize();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Button();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"type_", "pos_", "size_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Button> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Button.class) {
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
                Button button = new Button();
                DEFAULT_INSTANCE = button;
                GeneratedMessageLite.registerDefaultInstance(Button.class, button);
            }

            public static Button getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Button> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class ClickInteraction extends GeneratedMessageLite<ClickInteraction, Builder> implements ClickInteractionOrBuilder {
            public static final int BUTTONS_FIELD_NUMBER = 5;
            public static final int CLICK_POS_FIELD_NUMBER = 1;
            private static final ClickInteraction DEFAULT_INSTANCE;
            private static volatile Parser<ClickInteraction> PARSER = null;
            public static final int SCREEN_SIZE_FIELD_NUMBER = 2;
            public static final int VIEW_POS_FIELD_NUMBER = 3;
            public static final int VIEW_SIZE_FIELD_NUMBER = 4;
            private Internal.ProtobufList<Button> buttons_ = emptyProtobufList();
            private Position clickPos_;
            private Size screenSize_;
            private Position viewPos_;
            private Size viewSize_;

            private ClickInteraction() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public boolean hasClickPos() {
                return this.clickPos_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public Position getClickPos() {
                Position position = this.clickPos_;
                return position == null ? Position.getDefaultInstance() : position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClickPos(Position position) {
                position.getClass();
                this.clickPos_ = position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeClickPos(Position position) {
                position.getClass();
                Position position2 = this.clickPos_;
                if (position2 != null && position2 != Position.getDefaultInstance()) {
                    this.clickPos_ = Position.newBuilder(this.clickPos_).mergeFrom(position).buildPartial();
                } else {
                    this.clickPos_ = position;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearClickPos() {
                this.clickPos_ = null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public boolean hasScreenSize() {
                return this.screenSize_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public Size getScreenSize() {
                Size size = this.screenSize_;
                return size == null ? Size.getDefaultInstance() : size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setScreenSize(Size size) {
                size.getClass();
                this.screenSize_ = size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeScreenSize(Size size) {
                size.getClass();
                Size size2 = this.screenSize_;
                if (size2 != null && size2 != Size.getDefaultInstance()) {
                    this.screenSize_ = Size.newBuilder(this.screenSize_).mergeFrom(size).buildPartial();
                } else {
                    this.screenSize_ = size;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearScreenSize() {
                this.screenSize_ = null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public boolean hasViewPos() {
                return this.viewPos_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public Position getViewPos() {
                Position position = this.viewPos_;
                return position == null ? Position.getDefaultInstance() : position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setViewPos(Position position) {
                position.getClass();
                this.viewPos_ = position;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeViewPos(Position position) {
                position.getClass();
                Position position2 = this.viewPos_;
                if (position2 != null && position2 != Position.getDefaultInstance()) {
                    this.viewPos_ = Position.newBuilder(this.viewPos_).mergeFrom(position).buildPartial();
                } else {
                    this.viewPos_ = position;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearViewPos() {
                this.viewPos_ = null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public boolean hasViewSize() {
                return this.viewSize_ != null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public Size getViewSize() {
                Size size = this.viewSize_;
                return size == null ? Size.getDefaultInstance() : size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setViewSize(Size size) {
                size.getClass();
                this.viewSize_ = size;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeViewSize(Size size) {
                size.getClass();
                Size size2 = this.viewSize_;
                if (size2 != null && size2 != Size.getDefaultInstance()) {
                    this.viewSize_ = Size.newBuilder(this.viewSize_).mergeFrom(size).buildPartial();
                } else {
                    this.viewSize_ = size;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearViewSize() {
                this.viewSize_ = null;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public List<Button> getButtonsList() {
                return this.buttons_;
            }

            public List<? extends ButtonOrBuilder> getButtonsOrBuilderList() {
                return this.buttons_;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public int getButtonsCount() {
                return this.buttons_.size();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
            public Button getButtons(int i) {
                return this.buttons_.get(i);
            }

            public ButtonOrBuilder getButtonsOrBuilder(int i) {
                return this.buttons_.get(i);
            }

            private void ensureButtonsIsMutable() {
                Internal.ProtobufList<Button> protobufList = this.buttons_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.buttons_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setButtons(int i, Button button) {
                button.getClass();
                ensureButtonsIsMutable();
                this.buttons_.set(i, button);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addButtons(Button button) {
                button.getClass();
                ensureButtonsIsMutable();
                this.buttons_.add(button);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addButtons(int i, Button button) {
                button.getClass();
                ensureButtonsIsMutable();
                this.buttons_.add(i, button);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllButtons(Iterable<? extends Button> iterable) {
                ensureButtonsIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.buttons_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearButtons() {
                this.buttons_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeButtons(int i) {
                ensureButtonsIsMutable();
                this.buttons_.remove(i);
            }

            public static ClickInteraction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ClickInteraction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ClickInteraction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ClickInteraction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ClickInteraction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ClickInteraction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ClickInteraction parseFrom(InputStream inputStream) throws IOException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClickInteraction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClickInteraction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ClickInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ClickInteraction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClickInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ClickInteraction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ClickInteraction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ClickInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ClickInteraction clickInteraction) {
                return DEFAULT_INSTANCE.createBuilder(clickInteraction);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ClickInteraction, Builder> implements ClickInteractionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ClickInteraction.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public boolean hasClickPos() {
                    return ((ClickInteraction) this.instance).hasClickPos();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public Position getClickPos() {
                    return ((ClickInteraction) this.instance).getClickPos();
                }

                public Builder setClickPos(Position position) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setClickPos(position);
                    return this;
                }

                public Builder setClickPos(Position.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setClickPos(builder.build());
                    return this;
                }

                public Builder mergeClickPos(Position position) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).mergeClickPos(position);
                    return this;
                }

                public Builder clearClickPos() {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).clearClickPos();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public boolean hasScreenSize() {
                    return ((ClickInteraction) this.instance).hasScreenSize();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public Size getScreenSize() {
                    return ((ClickInteraction) this.instance).getScreenSize();
                }

                public Builder setScreenSize(Size size) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setScreenSize(size);
                    return this;
                }

                public Builder setScreenSize(Size.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setScreenSize(builder.build());
                    return this;
                }

                public Builder mergeScreenSize(Size size) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).mergeScreenSize(size);
                    return this;
                }

                public Builder clearScreenSize() {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).clearScreenSize();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public boolean hasViewPos() {
                    return ((ClickInteraction) this.instance).hasViewPos();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public Position getViewPos() {
                    return ((ClickInteraction) this.instance).getViewPos();
                }

                public Builder setViewPos(Position position) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setViewPos(position);
                    return this;
                }

                public Builder setViewPos(Position.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setViewPos(builder.build());
                    return this;
                }

                public Builder mergeViewPos(Position position) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).mergeViewPos(position);
                    return this;
                }

                public Builder clearViewPos() {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).clearViewPos();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public boolean hasViewSize() {
                    return ((ClickInteraction) this.instance).hasViewSize();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public Size getViewSize() {
                    return ((ClickInteraction) this.instance).getViewSize();
                }

                public Builder setViewSize(Size size) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setViewSize(size);
                    return this;
                }

                public Builder setViewSize(Size.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setViewSize(builder.build());
                    return this;
                }

                public Builder mergeViewSize(Size size) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).mergeViewSize(size);
                    return this;
                }

                public Builder clearViewSize() {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).clearViewSize();
                    return this;
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public List<Button> getButtonsList() {
                    return Collections.unmodifiableList(((ClickInteraction) this.instance).getButtonsList());
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public int getButtonsCount() {
                    return ((ClickInteraction) this.instance).getButtonsCount();
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.ClickInteractionOrBuilder
                public Button getButtons(int i) {
                    return ((ClickInteraction) this.instance).getButtons(i);
                }

                public Builder setButtons(int i, Button button) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setButtons(i, button);
                    return this;
                }

                public Builder setButtons(int i, Button.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).setButtons(i, builder.build());
                    return this;
                }

                public Builder addButtons(Button button) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).addButtons(button);
                    return this;
                }

                public Builder addButtons(int i, Button button) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).addButtons(i, button);
                    return this;
                }

                public Builder addButtons(Button.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).addButtons(builder.build());
                    return this;
                }

                public Builder addButtons(int i, Button.Builder builder) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).addButtons(i, builder.build());
                    return this;
                }

                public Builder addAllButtons(Iterable<? extends Button> iterable) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).addAllButtons(iterable);
                    return this;
                }

                public Builder clearButtons() {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).clearButtons();
                    return this;
                }

                public Builder removeButtons(int i) {
                    copyOnWrite();
                    ((ClickInteraction) this.instance).removeButtons(i);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ClickInteraction();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0002\t\u0003\t\u0004\t\u0005\u001b", new Object[]{"clickPos_", "screenSize_", "viewPos_", "viewSize_", "buttons_", Button.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ClickInteraction> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ClickInteraction.class) {
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
                ClickInteraction clickInteraction = new ClickInteraction();
                DEFAULT_INSTANCE = clickInteraction;
                GeneratedMessageLite.registerDefaultInstance(ClickInteraction.class, clickInteraction);
            }

            public static ClickInteraction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ClickInteraction> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AppForegroundingInteraction extends GeneratedMessageLite<AppForegroundingInteraction, Builder> implements AppForegroundingInteractionOrBuilder {
            public static final int BG_TS_MS_FIELD_NUMBER = 1;
            private static final AppForegroundingInteraction DEFAULT_INSTANCE;
            private static volatile Parser<AppForegroundingInteraction> PARSER;
            private long bgTsMs_;

            private AppForegroundingInteraction() {
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppForegroundingInteractionOrBuilder
            public long getBgTsMs() {
                return this.bgTsMs_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBgTsMs(long j) {
                this.bgTsMs_ = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBgTsMs() {
                this.bgTsMs_ = 0L;
            }

            public static AppForegroundingInteraction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AppForegroundingInteraction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AppForegroundingInteraction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AppForegroundingInteraction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AppForegroundingInteraction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AppForegroundingInteraction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AppForegroundingInteraction parseFrom(InputStream inputStream) throws IOException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppForegroundingInteraction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppForegroundingInteraction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AppForegroundingInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppForegroundingInteraction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppForegroundingInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppForegroundingInteraction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AppForegroundingInteraction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppForegroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AppForegroundingInteraction appForegroundingInteraction) {
                return DEFAULT_INSTANCE.createBuilder(appForegroundingInteraction);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AppForegroundingInteraction, Builder> implements AppForegroundingInteractionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AppForegroundingInteraction.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.UserIntent.UserAdInteractionExt.AppForegroundingInteractionOrBuilder
                public long getBgTsMs() {
                    return ((AppForegroundingInteraction) this.instance).getBgTsMs();
                }

                public Builder setBgTsMs(long j) {
                    copyOnWrite();
                    ((AppForegroundingInteraction) this.instance).setBgTsMs(j);
                    return this;
                }

                public Builder clearBgTsMs() {
                    copyOnWrite();
                    ((AppForegroundingInteraction) this.instance).clearBgTsMs();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AppForegroundingInteraction();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"bgTsMs_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AppForegroundingInteraction> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AppForegroundingInteraction.class) {
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
                AppForegroundingInteraction appForegroundingInteraction = new AppForegroundingInteraction();
                DEFAULT_INSTANCE = appForegroundingInteraction;
                GeneratedMessageLite.registerDefaultInstance(AppForegroundingInteraction.class, appForegroundingInteraction);
            }

            public static AppForegroundingInteraction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AppForegroundingInteraction> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AppBackgroundingInteraction extends GeneratedMessageLite<AppBackgroundingInteraction, Builder> implements AppBackgroundingInteractionOrBuilder {
            private static final AppBackgroundingInteraction DEFAULT_INSTANCE;
            private static volatile Parser<AppBackgroundingInteraction> PARSER;

            private AppBackgroundingInteraction() {
            }

            public static AppBackgroundingInteraction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AppBackgroundingInteraction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AppBackgroundingInteraction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AppBackgroundingInteraction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AppBackgroundingInteraction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AppBackgroundingInteraction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AppBackgroundingInteraction parseFrom(InputStream inputStream) throws IOException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppBackgroundingInteraction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppBackgroundingInteraction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AppBackgroundingInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AppBackgroundingInteraction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppBackgroundingInteraction) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AppBackgroundingInteraction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AppBackgroundingInteraction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AppBackgroundingInteraction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AppBackgroundingInteraction appBackgroundingInteraction) {
                return DEFAULT_INSTANCE.createBuilder(appBackgroundingInteraction);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AppBackgroundingInteraction, Builder> implements AppBackgroundingInteractionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AppBackgroundingInteraction.DEFAULT_INSTANCE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AppBackgroundingInteraction();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AppBackgroundingInteraction> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AppBackgroundingInteraction.class) {
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
                AppBackgroundingInteraction appBackgroundingInteraction = new AppBackgroundingInteraction();
                DEFAULT_INSTANCE = appBackgroundingInteraction;
                GeneratedMessageLite.registerDefaultInstance(AppBackgroundingInteraction.class, appBackgroundingInteraction);
            }

            public static AppBackgroundingInteraction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AppBackgroundingInteraction> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum InfoExtCase {
            IMP_INTERACTION(100),
            CLICK_INTERACTION(101),
            APP_FOREGROUNDING_INTERACTION(102),
            APP_BACKGROUNDING_INTERACTION(103),
            INFOEXT_NOT_SET(0);

            private final int value;

            InfoExtCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static InfoExtCase valueOf(int i) {
                return forNumber(i);
            }

            public static InfoExtCase forNumber(int i) {
                if (i != 0) {
                    switch (i) {
                        case 100:
                            return IMP_INTERACTION;
                        case 101:
                            return CLICK_INTERACTION;
                        case 102:
                            return APP_FOREGROUNDING_INTERACTION;
                        case 103:
                            return APP_BACKGROUNDING_INTERACTION;
                        default:
                            return null;
                    }
                }
                return INFOEXT_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public InfoExtCase getInfoExtCase() {
            return InfoExtCase.forNumber(this.infoExtCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfoExt() {
            this.infoExtCase_ = 0;
            this.infoExt_ = null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public String getMref() {
            return this.mref_;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public ByteString getMrefBytes() {
            return ByteString.copyFromUtf8(this.mref_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMref(String str) {
            str.getClass();
            this.mref_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMref() {
            this.mref_ = getDefaultInstance().getMref();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMrefBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.mref_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public long getClientTimestamp() {
            return this.clientTimestamp_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientTimestamp(long j) {
            this.clientTimestamp_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientTimestamp() {
            this.clientTimestamp_ = 0L;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public String getAdvertisingId() {
            return this.advertisingId_;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public ByteString getAdvertisingIdBytes() {
            return ByteString.copyFromUtf8(this.advertisingId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdvertisingId(String str) {
            str.getClass();
            this.advertisingId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdvertisingId() {
            this.advertisingId_ = getDefaultInstance().getAdvertisingId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdvertisingIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.advertisingId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasDevice() {
            return this.device_ != null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
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

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasApp() {
            return this.app_ != null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public App getApp() {
            App app = this.app_;
            return app == null ? App.getDefaultInstance() : app;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApp(App app) {
            app.getClass();
            this.app_ = app;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeApp(App app) {
            app.getClass();
            App app2 = this.app_;
            if (app2 != null && app2 != App.getDefaultInstance()) {
                this.app_ = App.newBuilder(this.app_).mergeFrom(app).buildPartial();
            } else {
                this.app_ = app;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApp() {
            this.app_ = null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasNetwork() {
            return this.network_ != null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public Network getNetwork() {
            Network network = this.network_;
            return network == null ? Network.getDefaultInstance() : network;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetwork(Network network) {
            network.getClass();
            this.network_ = network;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeNetwork(Network network) {
            network.getClass();
            Network network2 = this.network_;
            if (network2 != null && network2 != Network.getDefaultInstance()) {
                this.network_ = Network.newBuilder(this.network_).mergeFrom(network).buildPartial();
            } else {
                this.network_ = network;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetwork() {
            this.network_ = null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasSdk() {
            return this.sdk_ != null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public MolocoSDK getSdk() {
            MolocoSDK molocoSDK = this.sdk_;
            return molocoSDK == null ? MolocoSDK.getDefaultInstance() : molocoSDK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdk(MolocoSDK molocoSDK) {
            molocoSDK.getClass();
            this.sdk_ = molocoSDK;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSdk(MolocoSDK molocoSDK) {
            molocoSDK.getClass();
            MolocoSDK molocoSDK2 = this.sdk_;
            if (molocoSDK2 != null && molocoSDK2 != MolocoSDK.getDefaultInstance()) {
                this.sdk_ = MolocoSDK.newBuilder(this.sdk_).mergeFrom(molocoSDK).buildPartial();
            } else {
                this.sdk_ = molocoSDK;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdk() {
            this.sdk_ = null;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasImpInteraction() {
            return this.infoExtCase_ == 100;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public ImpressionInteraction getImpInteraction() {
            if (this.infoExtCase_ == 100) {
                return (ImpressionInteraction) this.infoExt_;
            }
            return ImpressionInteraction.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImpInteraction(ImpressionInteraction impressionInteraction) {
            impressionInteraction.getClass();
            this.infoExt_ = impressionInteraction;
            this.infoExtCase_ = 100;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeImpInteraction(ImpressionInteraction impressionInteraction) {
            impressionInteraction.getClass();
            if (this.infoExtCase_ == 100 && this.infoExt_ != ImpressionInteraction.getDefaultInstance()) {
                this.infoExt_ = ImpressionInteraction.newBuilder((ImpressionInteraction) this.infoExt_).mergeFrom(impressionInteraction).buildPartial();
            } else {
                this.infoExt_ = impressionInteraction;
            }
            this.infoExtCase_ = 100;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImpInteraction() {
            if (this.infoExtCase_ == 100) {
                this.infoExtCase_ = 0;
                this.infoExt_ = null;
            }
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasClickInteraction() {
            return this.infoExtCase_ == 101;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public ClickInteraction getClickInteraction() {
            if (this.infoExtCase_ == 101) {
                return (ClickInteraction) this.infoExt_;
            }
            return ClickInteraction.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClickInteraction(ClickInteraction clickInteraction) {
            clickInteraction.getClass();
            this.infoExt_ = clickInteraction;
            this.infoExtCase_ = 101;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClickInteraction(ClickInteraction clickInteraction) {
            clickInteraction.getClass();
            if (this.infoExtCase_ == 101 && this.infoExt_ != ClickInteraction.getDefaultInstance()) {
                this.infoExt_ = ClickInteraction.newBuilder((ClickInteraction) this.infoExt_).mergeFrom(clickInteraction).buildPartial();
            } else {
                this.infoExt_ = clickInteraction;
            }
            this.infoExtCase_ = 101;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClickInteraction() {
            if (this.infoExtCase_ == 101) {
                this.infoExtCase_ = 0;
                this.infoExt_ = null;
            }
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasAppForegroundingInteraction() {
            return this.infoExtCase_ == 102;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public AppForegroundingInteraction getAppForegroundingInteraction() {
            if (this.infoExtCase_ == 102) {
                return (AppForegroundingInteraction) this.infoExt_;
            }
            return AppForegroundingInteraction.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppForegroundingInteraction(AppForegroundingInteraction appForegroundingInteraction) {
            appForegroundingInteraction.getClass();
            this.infoExt_ = appForegroundingInteraction;
            this.infoExtCase_ = 102;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppForegroundingInteraction(AppForegroundingInteraction appForegroundingInteraction) {
            appForegroundingInteraction.getClass();
            if (this.infoExtCase_ == 102 && this.infoExt_ != AppForegroundingInteraction.getDefaultInstance()) {
                this.infoExt_ = AppForegroundingInteraction.newBuilder((AppForegroundingInteraction) this.infoExt_).mergeFrom(appForegroundingInteraction).buildPartial();
            } else {
                this.infoExt_ = appForegroundingInteraction;
            }
            this.infoExtCase_ = 102;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppForegroundingInteraction() {
            if (this.infoExtCase_ == 102) {
                this.infoExtCase_ = 0;
                this.infoExt_ = null;
            }
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public boolean hasAppBackgroundingInteraction() {
            return this.infoExtCase_ == 103;
        }

        @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
        public AppBackgroundingInteraction getAppBackgroundingInteraction() {
            if (this.infoExtCase_ == 103) {
                return (AppBackgroundingInteraction) this.infoExt_;
            }
            return AppBackgroundingInteraction.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppBackgroundingInteraction(AppBackgroundingInteraction appBackgroundingInteraction) {
            appBackgroundingInteraction.getClass();
            this.infoExt_ = appBackgroundingInteraction;
            this.infoExtCase_ = 103;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppBackgroundingInteraction(AppBackgroundingInteraction appBackgroundingInteraction) {
            appBackgroundingInteraction.getClass();
            if (this.infoExtCase_ == 103 && this.infoExt_ != AppBackgroundingInteraction.getDefaultInstance()) {
                this.infoExt_ = AppBackgroundingInteraction.newBuilder((AppBackgroundingInteraction) this.infoExt_).mergeFrom(appBackgroundingInteraction).buildPartial();
            } else {
                this.infoExt_ = appBackgroundingInteraction;
            }
            this.infoExtCase_ = 103;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppBackgroundingInteraction() {
            if (this.infoExtCase_ == 103) {
                this.infoExtCase_ = 0;
                this.infoExt_ = null;
            }
        }

        public static UserAdInteractionExt parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UserAdInteractionExt parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserAdInteractionExt parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserAdInteractionExt parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserAdInteractionExt parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserAdInteractionExt parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserAdInteractionExt parseFrom(InputStream inputStream) throws IOException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserAdInteractionExt parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserAdInteractionExt parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserAdInteractionExt) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserAdInteractionExt parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserAdInteractionExt) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserAdInteractionExt parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserAdInteractionExt parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserAdInteractionExt) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UserAdInteractionExt userAdInteractionExt) {
            return DEFAULT_INSTANCE.createBuilder(userAdInteractionExt);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UserAdInteractionExt, Builder> implements UserAdInteractionExtOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UserAdInteractionExt.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public InfoExtCase getInfoExtCase() {
                return ((UserAdInteractionExt) this.instance).getInfoExtCase();
            }

            public Builder clearInfoExt() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearInfoExt();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public String getMref() {
                return ((UserAdInteractionExt) this.instance).getMref();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public ByteString getMrefBytes() {
                return ((UserAdInteractionExt) this.instance).getMrefBytes();
            }

            public Builder setMref(String str) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setMref(str);
                return this;
            }

            public Builder clearMref() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearMref();
                return this;
            }

            public Builder setMrefBytes(ByteString byteString) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setMrefBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public long getClientTimestamp() {
                return ((UserAdInteractionExt) this.instance).getClientTimestamp();
            }

            public Builder setClientTimestamp(long j) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setClientTimestamp(j);
                return this;
            }

            public Builder clearClientTimestamp() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearClientTimestamp();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public String getAdvertisingId() {
                return ((UserAdInteractionExt) this.instance).getAdvertisingId();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public ByteString getAdvertisingIdBytes() {
                return ((UserAdInteractionExt) this.instance).getAdvertisingIdBytes();
            }

            public Builder setAdvertisingId(String str) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAdvertisingId(str);
                return this;
            }

            public Builder clearAdvertisingId() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearAdvertisingId();
                return this;
            }

            public Builder setAdvertisingIdBytes(ByteString byteString) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAdvertisingIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasDevice() {
                return ((UserAdInteractionExt) this.instance).hasDevice();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public Device getDevice() {
                return ((UserAdInteractionExt) this.instance).getDevice();
            }

            public Builder setDevice(Device device) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setDevice(device);
                return this;
            }

            public Builder setDevice(Device.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setDevice(builder.build());
                return this;
            }

            public Builder mergeDevice(Device device) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeDevice(device);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearDevice();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasApp() {
                return ((UserAdInteractionExt) this.instance).hasApp();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public App getApp() {
                return ((UserAdInteractionExt) this.instance).getApp();
            }

            public Builder setApp(App app) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setApp(app);
                return this;
            }

            public Builder setApp(App.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setApp(builder.build());
                return this;
            }

            public Builder mergeApp(App app) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeApp(app);
                return this;
            }

            public Builder clearApp() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearApp();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasNetwork() {
                return ((UserAdInteractionExt) this.instance).hasNetwork();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public Network getNetwork() {
                return ((UserAdInteractionExt) this.instance).getNetwork();
            }

            public Builder setNetwork(Network network) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setNetwork(network);
                return this;
            }

            public Builder setNetwork(Network.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setNetwork(builder.build());
                return this;
            }

            public Builder mergeNetwork(Network network) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeNetwork(network);
                return this;
            }

            public Builder clearNetwork() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearNetwork();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasSdk() {
                return ((UserAdInteractionExt) this.instance).hasSdk();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public MolocoSDK getSdk() {
                return ((UserAdInteractionExt) this.instance).getSdk();
            }

            public Builder setSdk(MolocoSDK molocoSDK) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setSdk(molocoSDK);
                return this;
            }

            public Builder setSdk(MolocoSDK.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setSdk(builder.build());
                return this;
            }

            public Builder mergeSdk(MolocoSDK molocoSDK) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeSdk(molocoSDK);
                return this;
            }

            public Builder clearSdk() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearSdk();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasImpInteraction() {
                return ((UserAdInteractionExt) this.instance).hasImpInteraction();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public ImpressionInteraction getImpInteraction() {
                return ((UserAdInteractionExt) this.instance).getImpInteraction();
            }

            public Builder setImpInteraction(ImpressionInteraction impressionInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setImpInteraction(impressionInteraction);
                return this;
            }

            public Builder setImpInteraction(ImpressionInteraction.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setImpInteraction(builder.build());
                return this;
            }

            public Builder mergeImpInteraction(ImpressionInteraction impressionInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeImpInteraction(impressionInteraction);
                return this;
            }

            public Builder clearImpInteraction() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearImpInteraction();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasClickInteraction() {
                return ((UserAdInteractionExt) this.instance).hasClickInteraction();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public ClickInteraction getClickInteraction() {
                return ((UserAdInteractionExt) this.instance).getClickInteraction();
            }

            public Builder setClickInteraction(ClickInteraction clickInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setClickInteraction(clickInteraction);
                return this;
            }

            public Builder setClickInteraction(ClickInteraction.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setClickInteraction(builder.build());
                return this;
            }

            public Builder mergeClickInteraction(ClickInteraction clickInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeClickInteraction(clickInteraction);
                return this;
            }

            public Builder clearClickInteraction() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearClickInteraction();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasAppForegroundingInteraction() {
                return ((UserAdInteractionExt) this.instance).hasAppForegroundingInteraction();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public AppForegroundingInteraction getAppForegroundingInteraction() {
                return ((UserAdInteractionExt) this.instance).getAppForegroundingInteraction();
            }

            public Builder setAppForegroundingInteraction(AppForegroundingInteraction appForegroundingInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAppForegroundingInteraction(appForegroundingInteraction);
                return this;
            }

            public Builder setAppForegroundingInteraction(AppForegroundingInteraction.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAppForegroundingInteraction(builder.build());
                return this;
            }

            public Builder mergeAppForegroundingInteraction(AppForegroundingInteraction appForegroundingInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeAppForegroundingInteraction(appForegroundingInteraction);
                return this;
            }

            public Builder clearAppForegroundingInteraction() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearAppForegroundingInteraction();
                return this;
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public boolean hasAppBackgroundingInteraction() {
                return ((UserAdInteractionExt) this.instance).hasAppBackgroundingInteraction();
            }

            @Override // com.moloco.sdk.UserIntent.UserAdInteractionExtOrBuilder
            public AppBackgroundingInteraction getAppBackgroundingInteraction() {
                return ((UserAdInteractionExt) this.instance).getAppBackgroundingInteraction();
            }

            public Builder setAppBackgroundingInteraction(AppBackgroundingInteraction appBackgroundingInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAppBackgroundingInteraction(appBackgroundingInteraction);
                return this;
            }

            public Builder setAppBackgroundingInteraction(AppBackgroundingInteraction.Builder builder) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).setAppBackgroundingInteraction(builder.build());
                return this;
            }

            public Builder mergeAppBackgroundingInteraction(AppBackgroundingInteraction appBackgroundingInteraction) {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).mergeAppBackgroundingInteraction(appBackgroundingInteraction);
                return this;
            }

            public Builder clearAppBackgroundingInteraction() {
                copyOnWrite();
                ((UserAdInteractionExt) this.instance).clearAppBackgroundingInteraction();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UserAdInteractionExt();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001g\u000b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004\t\u0005\t\u0006\t\u0007\td<\u0000e<\u0000f<\u0000g<\u0000", new Object[]{"infoExt_", "infoExtCase_", "mref_", "clientTimestamp_", "advertisingId_", "device_", "app_", "network_", "sdk_", ImpressionInteraction.class, ClickInteraction.class, AppForegroundingInteraction.class, AppBackgroundingInteraction.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UserAdInteractionExt> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (UserAdInteractionExt.class) {
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
            UserAdInteractionExt userAdInteractionExt = new UserAdInteractionExt();
            DEFAULT_INSTANCE = userAdInteractionExt;
            GeneratedMessageLite.registerDefaultInstance(UserAdInteractionExt.class, userAdInteractionExt);
        }

        public static UserAdInteractionExt getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserAdInteractionExt> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.UserIntent$1, reason: invalid class name */
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
