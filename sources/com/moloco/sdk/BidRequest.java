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
import com.json.qc;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BidRequest {

    public interface SdkBidRequestOrBuilder extends MessageLiteOrBuilder {
        SdkBidRequest.App getApp();

        SdkBidRequest.Device getDevice();

        SdkBidRequest.Imp getImp();

        SdkBidRequest.Regs getRegs();

        int getTmax();

        SdkBidRequest.User getUser();

        boolean hasApp();

        boolean hasDevice();

        boolean hasImp();

        boolean hasRegs();

        boolean hasTmax();

        boolean hasUser();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private BidRequest() {
    }

    public static final class SdkBidRequest extends GeneratedMessageLite<SdkBidRequest, Builder> implements SdkBidRequestOrBuilder {
        public static final int APP_FIELD_NUMBER = 1;
        private static final SdkBidRequest DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 2;
        public static final int IMP_FIELD_NUMBER = 3;
        private static volatile Parser<SdkBidRequest> PARSER = null;
        public static final int REGS_FIELD_NUMBER = 4;
        public static final int TMAX_FIELD_NUMBER = 5;
        public static final int USER_FIELD_NUMBER = 6;
        private App app_;
        private int bitField0_;
        private Device device_;
        private Imp imp_;
        private byte memoizedIsInitialized = 2;
        private Regs regs_;
        private int tmax_;
        private User user_;

        public interface AppOrBuilder extends MessageLiteOrBuilder {
            String getBundle();

            ByteString getBundleBytes();

            String getVer();

            ByteString getVerBytes();

            boolean hasBundle();

            boolean hasVer();
        }

        public interface DeviceOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Device, Device.Builder> {
            String getCarrier();

            ByteString getCarrierBytes();

            Device.ConnectionType getConnectiontype();

            Device.DeviceType getDevicetype();

            @Deprecated
            String getDidmd5();

            @Deprecated
            ByteString getDidmd5Bytes();

            @Deprecated
            String getDidsha1();

            @Deprecated
            ByteString getDidsha1Bytes();

            boolean getDnt();

            @Deprecated
            String getDpidmd5();

            @Deprecated
            ByteString getDpidmd5Bytes();

            @Deprecated
            String getDpidsha1();

            @Deprecated
            ByteString getDpidsha1Bytes();

            String getFlashver();

            ByteString getFlashverBytes();

            Device.Geo getGeo();

            boolean getGeofetch();

            int getH();

            String getHwv();

            ByteString getHwvBytes();

            String getIfa();

            ByteString getIfaBytes();

            String getIp();

            ByteString getIpBytes();

            String getIpv6();

            ByteString getIpv6Bytes();

            boolean getJs();

            String getLangb();

            ByteString getLangbBytes();

            String getLanguage();

            ByteString getLanguageBytes();

            boolean getLmt();

            @Deprecated
            String getMacmd5();

            @Deprecated
            ByteString getMacmd5Bytes();

            @Deprecated
            String getMacsha1();

            @Deprecated
            ByteString getMacsha1Bytes();

            String getMake();

            ByteString getMakeBytes();

            String getMccmnc();

            ByteString getMccmncBytes();

            String getModel();

            ByteString getModelBytes();

            String getOs();

            ByteString getOsBytes();

            String getOsv();

            ByteString getOsvBytes();

            int getPpi();

            double getPxratio();

            Device.UserAgent getSua();

            String getUa();

            ByteString getUaBytes();

            int getW();

            boolean hasCarrier();

            boolean hasConnectiontype();

            boolean hasDevicetype();

            @Deprecated
            boolean hasDidmd5();

            @Deprecated
            boolean hasDidsha1();

            boolean hasDnt();

            @Deprecated
            boolean hasDpidmd5();

            @Deprecated
            boolean hasDpidsha1();

            boolean hasFlashver();

            boolean hasGeo();

            boolean hasGeofetch();

            boolean hasH();

            boolean hasHwv();

            boolean hasIfa();

            boolean hasIp();

            boolean hasIpv6();

            boolean hasJs();

            boolean hasLangb();

            boolean hasLanguage();

            boolean hasLmt();

            @Deprecated
            boolean hasMacmd5();

            @Deprecated
            boolean hasMacsha1();

            boolean hasMake();

            boolean hasMccmnc();

            boolean hasModel();

            boolean hasOs();

            boolean hasOsv();

            boolean hasPpi();

            boolean hasPxratio();

            boolean hasSua();

            boolean hasUa();

            boolean hasW();
        }

        public interface ImpOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Imp, Imp.Builder> {
            Imp.Audio getAudio();

            Imp.Banner getBanner();

            double getBidfloor();

            String getBidfloorcur();

            ByteString getBidfloorcurBytes();

            boolean getClickbrowser();

            String getDisplaymanager();

            ByteString getDisplaymanagerBytes();

            String getDisplaymanagerver();

            ByteString getDisplaymanagerverBytes();

            int getExp();

            String getId();

            ByteString getIdBytes();

            String getIframebuster(int i);

            ByteString getIframebusterBytes(int i);

            int getIframebusterCount();

            List<String> getIframebusterList();

            boolean getInstl();

            Imp.Metric getMetric(int i);

            int getMetricCount();

            List<Imp.Metric> getMetricList();

            Imp.Native getNative();

            Imp.Pmp getPmp();

            boolean getRwdd();

            boolean getSecure();

            Imp.ServerSideAdInsertionType getSsai();

            String getTagid();

            ByteString getTagidBytes();

            Imp.Video getVideo();

            boolean hasAudio();

            boolean hasBanner();

            boolean hasBidfloor();

            boolean hasBidfloorcur();

            boolean hasClickbrowser();

            boolean hasDisplaymanager();

            boolean hasDisplaymanagerver();

            boolean hasExp();

            boolean hasId();

            boolean hasInstl();

            boolean hasNative();

            boolean hasPmp();

            boolean hasRwdd();

            boolean hasSecure();

            boolean hasSsai();

            boolean hasTagid();

            boolean hasVideo();
        }

        public interface RegsOrBuilder extends MessageLiteOrBuilder {
            boolean getCoppa();

            Regs.Ext getExt();

            boolean hasCoppa();

            boolean hasExt();
        }

        public interface UserOrBuilder extends MessageLiteOrBuilder {
            String getId();

            ByteString getIdBytes();

            boolean hasId();
        }

        private SdkBidRequest() {
        }

        public static final class App extends GeneratedMessageLite<App, Builder> implements AppOrBuilder {
            public static final int BUNDLE_FIELD_NUMBER = 1;
            private static final App DEFAULT_INSTANCE;
            private static volatile Parser<App> PARSER = null;
            public static final int VER_FIELD_NUMBER = 2;
            private int bitField0_;
            private byte memoizedIsInitialized = 2;
            private String bundle_ = "";
            private String ver_ = "";

            private App() {
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public boolean hasBundle() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public String getBundle() {
                return this.bundle_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public ByteString getBundleBytes() {
                return ByteString.copyFromUtf8(this.bundle_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBundle(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.bundle_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBundle() {
                this.bitField0_ &= -2;
                this.bundle_ = getDefaultInstance().getBundle();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBundleBytes(ByteString byteString) {
                this.bundle_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public boolean hasVer() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public String getVer() {
                return this.ver_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
            public ByteString getVerBytes() {
                return ByteString.copyFromUtf8(this.ver_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVer(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.ver_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVer() {
                this.bitField0_ &= -3;
                this.ver_ = getDefaultInstance().getVer();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVerBytes(ByteString byteString) {
                this.ver_ = byteString.toStringUtf8();
                this.bitField0_ |= 2;
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
                public boolean hasBundle() {
                    return ((App) this.instance).hasBundle();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
                public String getBundle() {
                    return ((App) this.instance).getBundle();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
                public ByteString getBundleBytes() {
                    return ((App) this.instance).getBundleBytes();
                }

                public Builder setBundle(String str) {
                    copyOnWrite();
                    ((App) this.instance).setBundle(str);
                    return this;
                }

                public Builder clearBundle() {
                    copyOnWrite();
                    ((App) this.instance).clearBundle();
                    return this;
                }

                public Builder setBundleBytes(ByteString byteString) {
                    copyOnWrite();
                    ((App) this.instance).setBundleBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
                public boolean hasVer() {
                    return ((App) this.instance).hasVer();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
                public String getVer() {
                    return ((App) this.instance).getVer();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.AppOrBuilder
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
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔈ\u0001", new Object[]{"bitField0_", "bundle_", "ver_"});
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
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

        public static final class Device extends GeneratedMessageLite.ExtendableMessage<Device, Builder> implements DeviceOrBuilder {
            public static final int CARRIER_FIELD_NUMBER = 10;
            public static final int CONNECTIONTYPE_FIELD_NUMBER = 17;
            private static final Device DEFAULT_INSTANCE;
            public static final int DEVICETYPE_FIELD_NUMBER = 18;
            public static final int DIDMD5_FIELD_NUMBER = 6;
            public static final int DIDSHA1_FIELD_NUMBER = 5;
            public static final int DNT_FIELD_NUMBER = 1;
            public static final int DPIDMD5_FIELD_NUMBER = 8;
            public static final int DPIDSHA1_FIELD_NUMBER = 7;
            public static final int FLASHVER_FIELD_NUMBER = 19;
            public static final int GEOFETCH_FIELD_NUMBER = 29;
            public static final int GEO_FIELD_NUMBER = 4;
            public static final int HWV_FIELD_NUMBER = 24;
            public static final int H_FIELD_NUMBER = 26;
            public static final int IFA_FIELD_NUMBER = 20;
            public static final int IPV6_FIELD_NUMBER = 9;
            public static final int IP_FIELD_NUMBER = 3;
            public static final int JS_FIELD_NUMBER = 16;
            public static final int LANGB_FIELD_NUMBER = 32;
            public static final int LANGUAGE_FIELD_NUMBER = 11;
            public static final int LMT_FIELD_NUMBER = 23;
            public static final int MACMD5_FIELD_NUMBER = 22;
            public static final int MACSHA1_FIELD_NUMBER = 21;
            public static final int MAKE_FIELD_NUMBER = 12;
            public static final int MCCMNC_FIELD_NUMBER = 30;
            public static final int MODEL_FIELD_NUMBER = 13;
            public static final int OSV_FIELD_NUMBER = 15;
            public static final int OS_FIELD_NUMBER = 14;
            private static volatile Parser<Device> PARSER = null;
            public static final int PPI_FIELD_NUMBER = 27;
            public static final int PXRATIO_FIELD_NUMBER = 28;
            public static final int SUA_FIELD_NUMBER = 31;
            public static final int UA_FIELD_NUMBER = 2;
            public static final int W_FIELD_NUMBER = 25;
            private int bitField0_;
            private int connectiontype_;
            private boolean dnt_;
            private Geo geo_;
            private boolean geofetch_;
            private int h_;
            private boolean js_;
            private boolean lmt_;
            private int ppi_;
            private double pxratio_;
            private UserAgent sua_;
            private int w_;
            private byte memoizedIsInitialized = 2;
            private String ua_ = "";
            private String ip_ = "";
            private String ipv6_ = "";
            private int devicetype_ = 1;
            private String make_ = "";
            private String model_ = "";
            private String os_ = "";
            private String osv_ = "";
            private String hwv_ = "";
            private String flashver_ = "";
            private String language_ = "";
            private String langb_ = "";
            private String carrier_ = "";
            private String mccmnc_ = "";
            private String ifa_ = "";
            private String didsha1_ = "";
            private String didmd5_ = "";
            private String dpidsha1_ = "";
            private String dpidmd5_ = "";
            private String macsha1_ = "";
            private String macmd5_ = "";

            public interface GeoOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Geo, Geo.Builder> {
                int getAccuracy();

                String getCity();

                ByteString getCityBytes();

                String getCountry();

                ByteString getCountryBytes();

                Geo.LocationService getIpservice();

                int getLastfix();

                double getLat();

                double getLon();

                String getMetro();

                ByteString getMetroBytes();

                String getRegion();

                ByteString getRegionBytes();

                String getRegionfips104();

                ByteString getRegionfips104Bytes();

                Geo.LocationType getType();

                int getUtcoffset();

                String getZip();

                ByteString getZipBytes();

                boolean hasAccuracy();

                boolean hasCity();

                boolean hasCountry();

                boolean hasIpservice();

                boolean hasLastfix();

                boolean hasLat();

                boolean hasLon();

                boolean hasMetro();

                boolean hasRegion();

                boolean hasRegionfips104();

                boolean hasType();

                boolean hasUtcoffset();

                boolean hasZip();
            }

            public interface UserAgentOrBuilder extends MessageLiteOrBuilder {
                String getArchitecture();

                ByteString getArchitectureBytes();

                String getBitness();

                ByteString getBitnessBytes();

                UserAgent.BrandVersion getBrowsers(int i);

                int getBrowsersCount();

                List<UserAgent.BrandVersion> getBrowsersList();

                boolean getMobile();

                String getModel();

                ByteString getModelBytes();

                UserAgent.BrandVersion getPlatform();

                UserAgent.UserAgentSource getSource();

                boolean hasArchitecture();

                boolean hasBitness();

                boolean hasMobile();

                boolean hasModel();

                boolean hasPlatform();

                boolean hasSource();
            }

            private Device() {
            }

            public enum DeviceType implements Internal.EnumLite {
                MOBILE(1),
                PERSONAL_COMPUTER(2),
                CONNECTED_TV(3),
                HIGHEND_PHONE(4),
                TABLET(5),
                CONNECTED_DEVICE(6),
                SET_TOP_BOX(7),
                OOH_DEVICE(8);

                public static final int CONNECTED_DEVICE_VALUE = 6;
                public static final int CONNECTED_TV_VALUE = 3;
                public static final int HIGHEND_PHONE_VALUE = 4;
                public static final int MOBILE_VALUE = 1;
                public static final int OOH_DEVICE_VALUE = 8;
                public static final int PERSONAL_COMPUTER_VALUE = 2;
                public static final int SET_TOP_BOX_VALUE = 7;
                public static final int TABLET_VALUE = 5;
                private static final Internal.EnumLiteMap<DeviceType> internalValueMap = new Internal.EnumLiteMap<DeviceType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Device.DeviceType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public DeviceType findValueByNumber(int i) {
                        return DeviceType.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static DeviceType valueOf(int i) {
                    return forNumber(i);
                }

                public static DeviceType forNumber(int i) {
                    switch (i) {
                        case 1:
                            return MOBILE;
                        case 2:
                            return PERSONAL_COMPUTER;
                        case 3:
                            return CONNECTED_TV;
                        case 4:
                            return HIGHEND_PHONE;
                        case 5:
                            return TABLET;
                        case 6:
                            return CONNECTED_DEVICE;
                        case 7:
                            return SET_TOP_BOX;
                        case 8:
                            return OOH_DEVICE;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<DeviceType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return DeviceTypeVerifier.INSTANCE;
                }

                private static final class DeviceTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new DeviceTypeVerifier();

                    private DeviceTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return DeviceType.forNumber(i) != null;
                    }
                }

                DeviceType(int i) {
                    this.value = i;
                }
            }

            public enum ConnectionType implements Internal.EnumLite {
                CONNECTION_UNKNOWN(0),
                ETHERNET(1),
                WIFI(2),
                CELL_UNKNOWN(3),
                CELL_2G(4),
                CELL_3G(5),
                CELL_4G(6),
                CELL_5G(7);

                public static final int CELL_2G_VALUE = 4;
                public static final int CELL_3G_VALUE = 5;
                public static final int CELL_4G_VALUE = 6;
                public static final int CELL_5G_VALUE = 7;
                public static final int CELL_UNKNOWN_VALUE = 3;
                public static final int CONNECTION_UNKNOWN_VALUE = 0;
                public static final int ETHERNET_VALUE = 1;
                public static final int WIFI_VALUE = 2;
                private static final Internal.EnumLiteMap<ConnectionType> internalValueMap = new Internal.EnumLiteMap<ConnectionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Device.ConnectionType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public ConnectionType findValueByNumber(int i) {
                        return ConnectionType.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static ConnectionType valueOf(int i) {
                    return forNumber(i);
                }

                public static ConnectionType forNumber(int i) {
                    switch (i) {
                        case 0:
                            return CONNECTION_UNKNOWN;
                        case 1:
                            return ETHERNET;
                        case 2:
                            return WIFI;
                        case 3:
                            return CELL_UNKNOWN;
                        case 4:
                            return CELL_2G;
                        case 5:
                            return CELL_3G;
                        case 6:
                            return CELL_4G;
                        case 7:
                            return CELL_5G;
                        default:
                            return null;
                    }
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

            public static final class Geo extends GeneratedMessageLite.ExtendableMessage<Geo, Builder> implements GeoOrBuilder {
                public static final int ACCURACY_FIELD_NUMBER = 11;
                public static final int CITY_FIELD_NUMBER = 7;
                public static final int COUNTRY_FIELD_NUMBER = 3;
                private static final Geo DEFAULT_INSTANCE;
                public static final int IPSERVICE_FIELD_NUMBER = 13;
                public static final int LASTFIX_FIELD_NUMBER = 12;
                public static final int LAT_FIELD_NUMBER = 1;
                public static final int LON_FIELD_NUMBER = 2;
                public static final int METRO_FIELD_NUMBER = 6;
                private static volatile Parser<Geo> PARSER = null;
                public static final int REGIONFIPS104_FIELD_NUMBER = 5;
                public static final int REGION_FIELD_NUMBER = 4;
                public static final int TYPE_FIELD_NUMBER = 9;
                public static final int UTCOFFSET_FIELD_NUMBER = 10;
                public static final int ZIP_FIELD_NUMBER = 8;
                private int accuracy_;
                private int bitField0_;
                private int lastfix_;
                private double lat_;
                private double lon_;
                private int utcoffset_;
                private byte memoizedIsInitialized = 2;
                private String country_ = "";
                private String region_ = "";
                private String regionfips104_ = "";
                private String metro_ = "";
                private String city_ = "";
                private String zip_ = "";
                private int type_ = 1;
                private int ipservice_ = 1;

                private Geo() {
                }

                public enum LocationType implements Internal.EnumLite {
                    GPS_LOCATION(1),
                    IP(2),
                    USER_PROVIDED(3);

                    public static final int GPS_LOCATION_VALUE = 1;
                    public static final int IP_VALUE = 2;
                    public static final int USER_PROVIDED_VALUE = 3;
                    private static final Internal.EnumLiteMap<LocationType> internalValueMap = new Internal.EnumLiteMap<LocationType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Device.Geo.LocationType.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public LocationType findValueByNumber(int i) {
                            return LocationType.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static LocationType valueOf(int i) {
                        return forNumber(i);
                    }

                    public static LocationType forNumber(int i) {
                        if (i == 1) {
                            return GPS_LOCATION;
                        }
                        if (i == 2) {
                            return IP;
                        }
                        if (i != 3) {
                            return null;
                        }
                        return USER_PROVIDED;
                    }

                    public static Internal.EnumLiteMap<LocationType> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return LocationTypeVerifier.INSTANCE;
                    }

                    private static final class LocationTypeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new LocationTypeVerifier();

                        private LocationTypeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return LocationType.forNumber(i) != null;
                        }
                    }

                    LocationType(int i) {
                        this.value = i;
                    }
                }

                public enum LocationService implements Internal.EnumLite {
                    IP2LOCATION(1),
                    NEUSTAR(2),
                    MAXMIND(3),
                    NETACUITY(4);

                    public static final int IP2LOCATION_VALUE = 1;
                    public static final int MAXMIND_VALUE = 3;
                    public static final int NETACUITY_VALUE = 4;
                    public static final int NEUSTAR_VALUE = 2;
                    private static final Internal.EnumLiteMap<LocationService> internalValueMap = new Internal.EnumLiteMap<LocationService>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Device.Geo.LocationService.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public LocationService findValueByNumber(int i) {
                            return LocationService.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static LocationService valueOf(int i) {
                        return forNumber(i);
                    }

                    public static LocationService forNumber(int i) {
                        if (i == 1) {
                            return IP2LOCATION;
                        }
                        if (i == 2) {
                            return NEUSTAR;
                        }
                        if (i == 3) {
                            return MAXMIND;
                        }
                        if (i != 4) {
                            return null;
                        }
                        return NETACUITY;
                    }

                    public static Internal.EnumLiteMap<LocationService> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return LocationServiceVerifier.INSTANCE;
                    }

                    private static final class LocationServiceVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new LocationServiceVerifier();

                        private LocationServiceVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return LocationService.forNumber(i) != null;
                        }
                    }

                    LocationService(int i) {
                        this.value = i;
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasLat() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public double getLat() {
                    return this.lat_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setLat(double d) {
                    this.bitField0_ |= 1;
                    this.lat_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearLat() {
                    this.bitField0_ &= -2;
                    this.lat_ = 0.0d;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasLon() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public double getLon() {
                    return this.lon_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setLon(double d) {
                    this.bitField0_ |= 2;
                    this.lon_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearLon() {
                    this.bitField0_ &= -3;
                    this.lon_ = 0.0d;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasCountry() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getCountry() {
                    return this.country_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getCountryBytes() {
                    return ByteString.copyFromUtf8(this.country_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCountry(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.country_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCountry() {
                    this.bitField0_ &= -5;
                    this.country_ = getDefaultInstance().getCountry();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCountryBytes(ByteString byteString) {
                    this.country_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasRegion() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getRegion() {
                    return this.region_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getRegionBytes() {
                    return ByteString.copyFromUtf8(this.region_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRegion(String str) {
                    str.getClass();
                    this.bitField0_ |= 8;
                    this.region_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRegion() {
                    this.bitField0_ &= -9;
                    this.region_ = getDefaultInstance().getRegion();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRegionBytes(ByteString byteString) {
                    this.region_ = byteString.toStringUtf8();
                    this.bitField0_ |= 8;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasRegionfips104() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getRegionfips104() {
                    return this.regionfips104_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getRegionfips104Bytes() {
                    return ByteString.copyFromUtf8(this.regionfips104_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRegionfips104(String str) {
                    str.getClass();
                    this.bitField0_ |= 16;
                    this.regionfips104_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRegionfips104() {
                    this.bitField0_ &= -17;
                    this.regionfips104_ = getDefaultInstance().getRegionfips104();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRegionfips104Bytes(ByteString byteString) {
                    this.regionfips104_ = byteString.toStringUtf8();
                    this.bitField0_ |= 16;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasMetro() {
                    return (this.bitField0_ & 32) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getMetro() {
                    return this.metro_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getMetroBytes() {
                    return ByteString.copyFromUtf8(this.metro_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMetro(String str) {
                    str.getClass();
                    this.bitField0_ |= 32;
                    this.metro_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMetro() {
                    this.bitField0_ &= -33;
                    this.metro_ = getDefaultInstance().getMetro();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMetroBytes(ByteString byteString) {
                    this.metro_ = byteString.toStringUtf8();
                    this.bitField0_ |= 32;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasCity() {
                    return (this.bitField0_ & 64) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getCity() {
                    return this.city_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getCityBytes() {
                    return ByteString.copyFromUtf8(this.city_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCity(String str) {
                    str.getClass();
                    this.bitField0_ |= 64;
                    this.city_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCity() {
                    this.bitField0_ &= -65;
                    this.city_ = getDefaultInstance().getCity();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCityBytes(ByteString byteString) {
                    this.city_ = byteString.toStringUtf8();
                    this.bitField0_ |= 64;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasZip() {
                    return (this.bitField0_ & 128) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public String getZip() {
                    return this.zip_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public ByteString getZipBytes() {
                    return ByteString.copyFromUtf8(this.zip_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setZip(String str) {
                    str.getClass();
                    this.bitField0_ |= 128;
                    this.zip_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearZip() {
                    this.bitField0_ &= -129;
                    this.zip_ = getDefaultInstance().getZip();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setZipBytes(ByteString byteString) {
                    this.zip_ = byteString.toStringUtf8();
                    this.bitField0_ |= 128;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasType() {
                    return (this.bitField0_ & 256) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public LocationType getType() {
                    LocationType locationTypeForNumber = LocationType.forNumber(this.type_);
                    return locationTypeForNumber == null ? LocationType.GPS_LOCATION : locationTypeForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setType(LocationType locationType) {
                    this.type_ = locationType.getNumber();
                    this.bitField0_ |= 256;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearType() {
                    this.bitField0_ &= -257;
                    this.type_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasAccuracy() {
                    return (this.bitField0_ & 512) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public int getAccuracy() {
                    return this.accuracy_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setAccuracy(int i) {
                    this.bitField0_ |= 512;
                    this.accuracy_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearAccuracy() {
                    this.bitField0_ &= -513;
                    this.accuracy_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasLastfix() {
                    return (this.bitField0_ & 1024) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public int getLastfix() {
                    return this.lastfix_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setLastfix(int i) {
                    this.bitField0_ |= 1024;
                    this.lastfix_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearLastfix() {
                    this.bitField0_ &= -1025;
                    this.lastfix_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasIpservice() {
                    return (this.bitField0_ & 2048) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public LocationService getIpservice() {
                    LocationService locationServiceForNumber = LocationService.forNumber(this.ipservice_);
                    return locationServiceForNumber == null ? LocationService.IP2LOCATION : locationServiceForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setIpservice(LocationService locationService) {
                    this.ipservice_ = locationService.getNumber();
                    this.bitField0_ |= 2048;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearIpservice() {
                    this.bitField0_ &= -2049;
                    this.ipservice_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public boolean hasUtcoffset() {
                    return (this.bitField0_ & 4096) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                public int getUtcoffset() {
                    return this.utcoffset_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setUtcoffset(int i) {
                    this.bitField0_ |= 4096;
                    this.utcoffset_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearUtcoffset() {
                    this.bitField0_ &= -4097;
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

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Geo geo) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(geo);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Geo, Builder> implements GeoOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Geo.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasLat() {
                        return ((Geo) this.instance).hasLat();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public double getLat() {
                        return ((Geo) this.instance).getLat();
                    }

                    public Builder setLat(double d) {
                        copyOnWrite();
                        ((Geo) this.instance).setLat(d);
                        return this;
                    }

                    public Builder clearLat() {
                        copyOnWrite();
                        ((Geo) this.instance).clearLat();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasLon() {
                        return ((Geo) this.instance).hasLon();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public double getLon() {
                        return ((Geo) this.instance).getLon();
                    }

                    public Builder setLon(double d) {
                        copyOnWrite();
                        ((Geo) this.instance).setLon(d);
                        return this;
                    }

                    public Builder clearLon() {
                        copyOnWrite();
                        ((Geo) this.instance).clearLon();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasCountry() {
                        return ((Geo) this.instance).hasCountry();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getCountry() {
                        return ((Geo) this.instance).getCountry();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getCountryBytes() {
                        return ((Geo) this.instance).getCountryBytes();
                    }

                    public Builder setCountry(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setCountry(str);
                        return this;
                    }

                    public Builder clearCountry() {
                        copyOnWrite();
                        ((Geo) this.instance).clearCountry();
                        return this;
                    }

                    public Builder setCountryBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setCountryBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasRegion() {
                        return ((Geo) this.instance).hasRegion();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getRegion() {
                        return ((Geo) this.instance).getRegion();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getRegionBytes() {
                        return ((Geo) this.instance).getRegionBytes();
                    }

                    public Builder setRegion(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setRegion(str);
                        return this;
                    }

                    public Builder clearRegion() {
                        copyOnWrite();
                        ((Geo) this.instance).clearRegion();
                        return this;
                    }

                    public Builder setRegionBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setRegionBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasRegionfips104() {
                        return ((Geo) this.instance).hasRegionfips104();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getRegionfips104() {
                        return ((Geo) this.instance).getRegionfips104();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getRegionfips104Bytes() {
                        return ((Geo) this.instance).getRegionfips104Bytes();
                    }

                    public Builder setRegionfips104(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setRegionfips104(str);
                        return this;
                    }

                    public Builder clearRegionfips104() {
                        copyOnWrite();
                        ((Geo) this.instance).clearRegionfips104();
                        return this;
                    }

                    public Builder setRegionfips104Bytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setRegionfips104Bytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasMetro() {
                        return ((Geo) this.instance).hasMetro();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getMetro() {
                        return ((Geo) this.instance).getMetro();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getMetroBytes() {
                        return ((Geo) this.instance).getMetroBytes();
                    }

                    public Builder setMetro(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setMetro(str);
                        return this;
                    }

                    public Builder clearMetro() {
                        copyOnWrite();
                        ((Geo) this.instance).clearMetro();
                        return this;
                    }

                    public Builder setMetroBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setMetroBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasCity() {
                        return ((Geo) this.instance).hasCity();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getCity() {
                        return ((Geo) this.instance).getCity();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getCityBytes() {
                        return ((Geo) this.instance).getCityBytes();
                    }

                    public Builder setCity(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setCity(str);
                        return this;
                    }

                    public Builder clearCity() {
                        copyOnWrite();
                        ((Geo) this.instance).clearCity();
                        return this;
                    }

                    public Builder setCityBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setCityBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasZip() {
                        return ((Geo) this.instance).hasZip();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public String getZip() {
                        return ((Geo) this.instance).getZip();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public ByteString getZipBytes() {
                        return ((Geo) this.instance).getZipBytes();
                    }

                    public Builder setZip(String str) {
                        copyOnWrite();
                        ((Geo) this.instance).setZip(str);
                        return this;
                    }

                    public Builder clearZip() {
                        copyOnWrite();
                        ((Geo) this.instance).clearZip();
                        return this;
                    }

                    public Builder setZipBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Geo) this.instance).setZipBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasType() {
                        return ((Geo) this.instance).hasType();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public LocationType getType() {
                        return ((Geo) this.instance).getType();
                    }

                    public Builder setType(LocationType locationType) {
                        copyOnWrite();
                        ((Geo) this.instance).setType(locationType);
                        return this;
                    }

                    public Builder clearType() {
                        copyOnWrite();
                        ((Geo) this.instance).clearType();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasAccuracy() {
                        return ((Geo) this.instance).hasAccuracy();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public int getAccuracy() {
                        return ((Geo) this.instance).getAccuracy();
                    }

                    public Builder setAccuracy(int i) {
                        copyOnWrite();
                        ((Geo) this.instance).setAccuracy(i);
                        return this;
                    }

                    public Builder clearAccuracy() {
                        copyOnWrite();
                        ((Geo) this.instance).clearAccuracy();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasLastfix() {
                        return ((Geo) this.instance).hasLastfix();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public int getLastfix() {
                        return ((Geo) this.instance).getLastfix();
                    }

                    public Builder setLastfix(int i) {
                        copyOnWrite();
                        ((Geo) this.instance).setLastfix(i);
                        return this;
                    }

                    public Builder clearLastfix() {
                        copyOnWrite();
                        ((Geo) this.instance).clearLastfix();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasIpservice() {
                        return ((Geo) this.instance).hasIpservice();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public LocationService getIpservice() {
                        return ((Geo) this.instance).getIpservice();
                    }

                    public Builder setIpservice(LocationService locationService) {
                        copyOnWrite();
                        ((Geo) this.instance).setIpservice(locationService);
                        return this;
                    }

                    public Builder clearIpservice() {
                        copyOnWrite();
                        ((Geo) this.instance).clearIpservice();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
                    public boolean hasUtcoffset() {
                        return ((Geo) this.instance).hasUtcoffset();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.GeoOrBuilder
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
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဌ\b\nင\f\u000bင\t\fင\n\rဌ\u000b", new Object[]{"bitField0_", "lat_", "lon_", "country_", "region_", "regionfips104_", "metro_", "city_", "zip_", "type_", LocationType.internalGetVerifier(), "utcoffset_", "accuracy_", "lastfix_", "ipservice_", LocationService.internalGetVerifier()});
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
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

            public static final class UserAgent extends GeneratedMessageLite<UserAgent, Builder> implements UserAgentOrBuilder {
                public static final int ARCHITECTURE_FIELD_NUMBER = 4;
                public static final int BITNESS_FIELD_NUMBER = 5;
                public static final int BROWSERS_FIELD_NUMBER = 1;
                private static final UserAgent DEFAULT_INSTANCE;
                public static final int MOBILE_FIELD_NUMBER = 3;
                public static final int MODEL_FIELD_NUMBER = 6;
                private static volatile Parser<UserAgent> PARSER = null;
                public static final int PLATFORM_FIELD_NUMBER = 2;
                public static final int SOURCE_FIELD_NUMBER = 7;
                private int bitField0_;
                private boolean mobile_;
                private BrandVersion platform_;
                private int source_;
                private Internal.ProtobufList<BrandVersion> browsers_ = emptyProtobufList();
                private String architecture_ = "";
                private String bitness_ = "";
                private String model_ = "";

                public interface BrandVersionOrBuilder extends MessageLiteOrBuilder {
                    String getBrand();

                    ByteString getBrandBytes();

                    String getVersion(int i);

                    ByteString getVersionBytes(int i);

                    int getVersionCount();

                    List<String> getVersionList();

                    boolean hasBrand();
                }

                private UserAgent() {
                }

                public enum UserAgentSource implements Internal.EnumLite {
                    UNKNOWN_SOURCE(0),
                    CLIENT_HINTS_LOW_ENTROPY(1),
                    CLIENT_HINTS_HIGH_ENTROPY(2),
                    USER_AGENT_STRING(3);

                    public static final int CLIENT_HINTS_HIGH_ENTROPY_VALUE = 2;
                    public static final int CLIENT_HINTS_LOW_ENTROPY_VALUE = 1;
                    public static final int UNKNOWN_SOURCE_VALUE = 0;
                    public static final int USER_AGENT_STRING_VALUE = 3;
                    private static final Internal.EnumLiteMap<UserAgentSource> internalValueMap = new Internal.EnumLiteMap<UserAgentSource>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.UserAgentSource.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public UserAgentSource findValueByNumber(int i) {
                            return UserAgentSource.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static UserAgentSource valueOf(int i) {
                        return forNumber(i);
                    }

                    public static UserAgentSource forNumber(int i) {
                        if (i == 0) {
                            return UNKNOWN_SOURCE;
                        }
                        if (i == 1) {
                            return CLIENT_HINTS_LOW_ENTROPY;
                        }
                        if (i == 2) {
                            return CLIENT_HINTS_HIGH_ENTROPY;
                        }
                        if (i != 3) {
                            return null;
                        }
                        return USER_AGENT_STRING;
                    }

                    public static Internal.EnumLiteMap<UserAgentSource> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return UserAgentSourceVerifier.INSTANCE;
                    }

                    private static final class UserAgentSourceVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new UserAgentSourceVerifier();

                        private UserAgentSourceVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return UserAgentSource.forNumber(i) != null;
                        }
                    }

                    UserAgentSource(int i) {
                        this.value = i;
                    }
                }

                public static final class BrandVersion extends GeneratedMessageLite<BrandVersion, Builder> implements BrandVersionOrBuilder {
                    public static final int BRAND_FIELD_NUMBER = 1;
                    private static final BrandVersion DEFAULT_INSTANCE;
                    private static volatile Parser<BrandVersion> PARSER = null;
                    public static final int VERSION_FIELD_NUMBER = 2;
                    private int bitField0_;
                    private String brand_ = "";
                    private Internal.ProtobufList<String> version_ = GeneratedMessageLite.emptyProtobufList();

                    private BrandVersion() {
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public boolean hasBrand() {
                        return (this.bitField0_ & 1) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public String getBrand() {
                        return this.brand_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public ByteString getBrandBytes() {
                        return ByteString.copyFromUtf8(this.brand_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setBrand(String str) {
                        str.getClass();
                        this.bitField0_ |= 1;
                        this.brand_ = str;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearBrand() {
                        this.bitField0_ &= -2;
                        this.brand_ = getDefaultInstance().getBrand();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setBrandBytes(ByteString byteString) {
                        this.brand_ = byteString.toStringUtf8();
                        this.bitField0_ |= 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public List<String> getVersionList() {
                        return this.version_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public int getVersionCount() {
                        return this.version_.size();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public String getVersion(int i) {
                        return this.version_.get(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                    public ByteString getVersionBytes(int i) {
                        return ByteString.copyFromUtf8(this.version_.get(i));
                    }

                    private void ensureVersionIsMutable() {
                        Internal.ProtobufList<String> protobufList = this.version_;
                        if (protobufList.isModifiable()) {
                            return;
                        }
                        this.version_ = GeneratedMessageLite.mutableCopy(protobufList);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setVersion(int i, String str) {
                        str.getClass();
                        ensureVersionIsMutable();
                        this.version_.set(i, str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addVersion(String str) {
                        str.getClass();
                        ensureVersionIsMutable();
                        this.version_.add(str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAllVersion(Iterable<String> iterable) {
                        ensureVersionIsMutable();
                        AbstractMessageLite.addAll((Iterable) iterable, (List) this.version_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearVersion() {
                        this.version_ = GeneratedMessageLite.emptyProtobufList();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addVersionBytes(ByteString byteString) {
                        ensureVersionIsMutable();
                        this.version_.add(byteString.toStringUtf8());
                    }

                    public static BrandVersion parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                    }

                    public static BrandVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                    }

                    public static BrandVersion parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                    }

                    public static BrandVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                    }

                    public static BrandVersion parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                    }

                    public static BrandVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                    }

                    public static BrandVersion parseFrom(InputStream inputStream) throws IOException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static BrandVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static BrandVersion parseDelimitedFrom(InputStream inputStream) throws IOException {
                        return (BrandVersion) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static BrandVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (BrandVersion) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static BrandVersion parseFrom(CodedInputStream codedInputStream) throws IOException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                    }

                    public static BrandVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (BrandVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                    }

                    public static Builder newBuilder() {
                        return DEFAULT_INSTANCE.createBuilder();
                    }

                    public static Builder newBuilder(BrandVersion brandVersion) {
                        return DEFAULT_INSTANCE.createBuilder(brandVersion);
                    }

                    public static final class Builder extends GeneratedMessageLite.Builder<BrandVersion, Builder> implements BrandVersionOrBuilder {
                        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                            this();
                        }

                        private Builder() {
                            super(BrandVersion.DEFAULT_INSTANCE);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public boolean hasBrand() {
                            return ((BrandVersion) this.instance).hasBrand();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public String getBrand() {
                            return ((BrandVersion) this.instance).getBrand();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public ByteString getBrandBytes() {
                            return ((BrandVersion) this.instance).getBrandBytes();
                        }

                        public Builder setBrand(String str) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).setBrand(str);
                            return this;
                        }

                        public Builder clearBrand() {
                            copyOnWrite();
                            ((BrandVersion) this.instance).clearBrand();
                            return this;
                        }

                        public Builder setBrandBytes(ByteString byteString) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).setBrandBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public List<String> getVersionList() {
                            return Collections.unmodifiableList(((BrandVersion) this.instance).getVersionList());
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public int getVersionCount() {
                            return ((BrandVersion) this.instance).getVersionCount();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public String getVersion(int i) {
                            return ((BrandVersion) this.instance).getVersion(i);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgent.BrandVersionOrBuilder
                        public ByteString getVersionBytes(int i) {
                            return ((BrandVersion) this.instance).getVersionBytes(i);
                        }

                        public Builder setVersion(int i, String str) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).setVersion(i, str);
                            return this;
                        }

                        public Builder addVersion(String str) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).addVersion(str);
                            return this;
                        }

                        public Builder addAllVersion(Iterable<String> iterable) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).addAllVersion(iterable);
                            return this;
                        }

                        public Builder clearVersion() {
                            copyOnWrite();
                            ((BrandVersion) this.instance).clearVersion();
                            return this;
                        }

                        public Builder addVersionBytes(ByteString byteString) {
                            copyOnWrite();
                            ((BrandVersion) this.instance).addVersionBytes(byteString);
                            return this;
                        }
                    }

                    @Override // com.google.protobuf.GeneratedMessageLite
                    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                        AnonymousClass1 anonymousClass1 = null;
                        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                            case 1:
                                return new BrandVersion();
                            case 2:
                                return new Builder(anonymousClass1);
                            case 3:
                                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001a", new Object[]{"bitField0_", "brand_", "version_"});
                            case 4:
                                return DEFAULT_INSTANCE;
                            case 5:
                                Parser<BrandVersion> defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    synchronized (BrandVersion.class) {
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
                        BrandVersion brandVersion = new BrandVersion();
                        DEFAULT_INSTANCE = brandVersion;
                        GeneratedMessageLite.registerDefaultInstance(BrandVersion.class, brandVersion);
                    }

                    public static BrandVersion getDefaultInstance() {
                        return DEFAULT_INSTANCE;
                    }

                    public static Parser<BrandVersion> parser() {
                        return DEFAULT_INSTANCE.getParserForType();
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public List<BrandVersion> getBrowsersList() {
                    return this.browsers_;
                }

                public List<? extends BrandVersionOrBuilder> getBrowsersOrBuilderList() {
                    return this.browsers_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public int getBrowsersCount() {
                    return this.browsers_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public BrandVersion getBrowsers(int i) {
                    return this.browsers_.get(i);
                }

                public BrandVersionOrBuilder getBrowsersOrBuilder(int i) {
                    return this.browsers_.get(i);
                }

                private void ensureBrowsersIsMutable() {
                    Internal.ProtobufList<BrandVersion> protobufList = this.browsers_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.browsers_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBrowsers(int i, BrandVersion brandVersion) {
                    brandVersion.getClass();
                    ensureBrowsersIsMutable();
                    this.browsers_.set(i, brandVersion);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBrowsers(BrandVersion brandVersion) {
                    brandVersion.getClass();
                    ensureBrowsersIsMutable();
                    this.browsers_.add(brandVersion);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBrowsers(int i, BrandVersion brandVersion) {
                    brandVersion.getClass();
                    ensureBrowsersIsMutable();
                    this.browsers_.add(i, brandVersion);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBrowsers(Iterable<? extends BrandVersion> iterable) {
                    ensureBrowsersIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.browsers_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBrowsers() {
                    this.browsers_ = emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void removeBrowsers(int i) {
                    ensureBrowsersIsMutable();
                    this.browsers_.remove(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasPlatform() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public BrandVersion getPlatform() {
                    BrandVersion brandVersion = this.platform_;
                    return brandVersion == null ? BrandVersion.getDefaultInstance() : brandVersion;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPlatform(BrandVersion brandVersion) {
                    brandVersion.getClass();
                    this.platform_ = brandVersion;
                    this.bitField0_ |= 1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void mergePlatform(BrandVersion brandVersion) {
                    brandVersion.getClass();
                    BrandVersion brandVersion2 = this.platform_;
                    if (brandVersion2 != null && brandVersion2 != BrandVersion.getDefaultInstance()) {
                        this.platform_ = BrandVersion.newBuilder(this.platform_).mergeFrom(brandVersion).buildPartial();
                    } else {
                        this.platform_ = brandVersion;
                    }
                    this.bitField0_ |= 1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPlatform() {
                    this.platform_ = null;
                    this.bitField0_ &= -2;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasMobile() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean getMobile() {
                    return this.mobile_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMobile(boolean z) {
                    this.bitField0_ |= 2;
                    this.mobile_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMobile() {
                    this.bitField0_ &= -3;
                    this.mobile_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasArchitecture() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public String getArchitecture() {
                    return this.architecture_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public ByteString getArchitectureBytes() {
                    return ByteString.copyFromUtf8(this.architecture_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setArchitecture(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.architecture_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearArchitecture() {
                    this.bitField0_ &= -5;
                    this.architecture_ = getDefaultInstance().getArchitecture();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setArchitectureBytes(ByteString byteString) {
                    this.architecture_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasBitness() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public String getBitness() {
                    return this.bitness_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public ByteString getBitnessBytes() {
                    return ByteString.copyFromUtf8(this.bitness_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBitness(String str) {
                    str.getClass();
                    this.bitField0_ |= 8;
                    this.bitness_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBitness() {
                    this.bitField0_ &= -9;
                    this.bitness_ = getDefaultInstance().getBitness();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBitnessBytes(ByteString byteString) {
                    this.bitness_ = byteString.toStringUtf8();
                    this.bitField0_ |= 8;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasModel() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public String getModel() {
                    return this.model_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public ByteString getModelBytes() {
                    return ByteString.copyFromUtf8(this.model_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setModel(String str) {
                    str.getClass();
                    this.bitField0_ |= 16;
                    this.model_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearModel() {
                    this.bitField0_ &= -17;
                    this.model_ = getDefaultInstance().getModel();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setModelBytes(ByteString byteString) {
                    this.model_ = byteString.toStringUtf8();
                    this.bitField0_ |= 16;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public boolean hasSource() {
                    return (this.bitField0_ & 32) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                public UserAgentSource getSource() {
                    UserAgentSource userAgentSourceForNumber = UserAgentSource.forNumber(this.source_);
                    return userAgentSourceForNumber == null ? UserAgentSource.UNKNOWN_SOURCE : userAgentSourceForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSource(UserAgentSource userAgentSource) {
                    this.source_ = userAgentSource.getNumber();
                    this.bitField0_ |= 32;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSource() {
                    this.bitField0_ &= -33;
                    this.source_ = 0;
                }

                public static UserAgent parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static UserAgent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static UserAgent parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static UserAgent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static UserAgent parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static UserAgent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static UserAgent parseFrom(InputStream inputStream) throws IOException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static UserAgent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static UserAgent parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (UserAgent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static UserAgent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (UserAgent) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static UserAgent parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static UserAgent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (UserAgent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Builder newBuilder(UserAgent userAgent) {
                    return DEFAULT_INSTANCE.createBuilder(userAgent);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<UserAgent, Builder> implements UserAgentOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(UserAgent.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public List<BrandVersion> getBrowsersList() {
                        return Collections.unmodifiableList(((UserAgent) this.instance).getBrowsersList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public int getBrowsersCount() {
                        return ((UserAgent) this.instance).getBrowsersCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public BrandVersion getBrowsers(int i) {
                        return ((UserAgent) this.instance).getBrowsers(i);
                    }

                    public Builder setBrowsers(int i, BrandVersion brandVersion) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setBrowsers(i, brandVersion);
                        return this;
                    }

                    public Builder setBrowsers(int i, BrandVersion.Builder builder) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setBrowsers(i, builder.build());
                        return this;
                    }

                    public Builder addBrowsers(BrandVersion brandVersion) {
                        copyOnWrite();
                        ((UserAgent) this.instance).addBrowsers(brandVersion);
                        return this;
                    }

                    public Builder addBrowsers(int i, BrandVersion brandVersion) {
                        copyOnWrite();
                        ((UserAgent) this.instance).addBrowsers(i, brandVersion);
                        return this;
                    }

                    public Builder addBrowsers(BrandVersion.Builder builder) {
                        copyOnWrite();
                        ((UserAgent) this.instance).addBrowsers(builder.build());
                        return this;
                    }

                    public Builder addBrowsers(int i, BrandVersion.Builder builder) {
                        copyOnWrite();
                        ((UserAgent) this.instance).addBrowsers(i, builder.build());
                        return this;
                    }

                    public Builder addAllBrowsers(Iterable<? extends BrandVersion> iterable) {
                        copyOnWrite();
                        ((UserAgent) this.instance).addAllBrowsers(iterable);
                        return this;
                    }

                    public Builder clearBrowsers() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearBrowsers();
                        return this;
                    }

                    public Builder removeBrowsers(int i) {
                        copyOnWrite();
                        ((UserAgent) this.instance).removeBrowsers(i);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasPlatform() {
                        return ((UserAgent) this.instance).hasPlatform();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public BrandVersion getPlatform() {
                        return ((UserAgent) this.instance).getPlatform();
                    }

                    public Builder setPlatform(BrandVersion brandVersion) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setPlatform(brandVersion);
                        return this;
                    }

                    public Builder setPlatform(BrandVersion.Builder builder) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setPlatform(builder.build());
                        return this;
                    }

                    public Builder mergePlatform(BrandVersion brandVersion) {
                        copyOnWrite();
                        ((UserAgent) this.instance).mergePlatform(brandVersion);
                        return this;
                    }

                    public Builder clearPlatform() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearPlatform();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasMobile() {
                        return ((UserAgent) this.instance).hasMobile();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean getMobile() {
                        return ((UserAgent) this.instance).getMobile();
                    }

                    public Builder setMobile(boolean z) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setMobile(z);
                        return this;
                    }

                    public Builder clearMobile() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearMobile();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasArchitecture() {
                        return ((UserAgent) this.instance).hasArchitecture();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public String getArchitecture() {
                        return ((UserAgent) this.instance).getArchitecture();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public ByteString getArchitectureBytes() {
                        return ((UserAgent) this.instance).getArchitectureBytes();
                    }

                    public Builder setArchitecture(String str) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setArchitecture(str);
                        return this;
                    }

                    public Builder clearArchitecture() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearArchitecture();
                        return this;
                    }

                    public Builder setArchitectureBytes(ByteString byteString) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setArchitectureBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasBitness() {
                        return ((UserAgent) this.instance).hasBitness();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public String getBitness() {
                        return ((UserAgent) this.instance).getBitness();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public ByteString getBitnessBytes() {
                        return ((UserAgent) this.instance).getBitnessBytes();
                    }

                    public Builder setBitness(String str) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setBitness(str);
                        return this;
                    }

                    public Builder clearBitness() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearBitness();
                        return this;
                    }

                    public Builder setBitnessBytes(ByteString byteString) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setBitnessBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasModel() {
                        return ((UserAgent) this.instance).hasModel();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public String getModel() {
                        return ((UserAgent) this.instance).getModel();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public ByteString getModelBytes() {
                        return ((UserAgent) this.instance).getModelBytes();
                    }

                    public Builder setModel(String str) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setModel(str);
                        return this;
                    }

                    public Builder clearModel() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearModel();
                        return this;
                    }

                    public Builder setModelBytes(ByteString byteString) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setModelBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public boolean hasSource() {
                        return ((UserAgent) this.instance).hasSource();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Device.UserAgentOrBuilder
                    public UserAgentSource getSource() {
                        return ((UserAgent) this.instance).getSource();
                    }

                    public Builder setSource(UserAgentSource userAgentSource) {
                        copyOnWrite();
                        ((UserAgent) this.instance).setSource(userAgentSource);
                        return this;
                    }

                    public Builder clearSource() {
                        copyOnWrite();
                        ((UserAgent) this.instance).clearSource();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new UserAgent();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဇ\u0001\u0004ဈ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဌ\u0005", new Object[]{"bitField0_", "browsers_", BrandVersion.class, "platform_", "mobile_", "architecture_", "bitness_", "model_", "source_", UserAgentSource.internalGetVerifier()});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<UserAgent> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (UserAgent.class) {
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
                    UserAgent userAgent = new UserAgent();
                    DEFAULT_INSTANCE = userAgent;
                    GeneratedMessageLite.registerDefaultInstance(UserAgent.class, userAgent);
                }

                public static UserAgent getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<UserAgent> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasGeo() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public Geo getGeo() {
                Geo geo = this.geo_;
                return geo == null ? Geo.getDefaultInstance() : geo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGeo(Geo geo) {
                geo.getClass();
                this.geo_ = geo;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeGeo(Geo geo) {
                geo.getClass();
                Geo geo2 = this.geo_;
                if (geo2 != null && geo2 != Geo.getDefaultInstance()) {
                    this.geo_ = ((Geo.Builder) Geo.newBuilder(this.geo_).mergeFrom(geo)).buildPartial();
                } else {
                    this.geo_ = geo;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGeo() {
                this.geo_ = null;
                this.bitField0_ &= -2;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasDnt() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasLmt() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean getLmt() {
                return this.lmt_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLmt(boolean z) {
                this.bitField0_ |= 4;
                this.lmt_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLmt() {
                this.bitField0_ &= -5;
                this.lmt_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasUa() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getUa() {
                return this.ua_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getUaBytes() {
                return ByteString.copyFromUtf8(this.ua_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUa(String str) {
                str.getClass();
                this.bitField0_ |= 8;
                this.ua_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUa() {
                this.bitField0_ &= -9;
                this.ua_ = getDefaultInstance().getUa();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUaBytes(ByteString byteString) {
                this.ua_ = byteString.toStringUtf8();
                this.bitField0_ |= 8;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasSua() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public UserAgent getSua() {
                UserAgent userAgent = this.sua_;
                return userAgent == null ? UserAgent.getDefaultInstance() : userAgent;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSua(UserAgent userAgent) {
                userAgent.getClass();
                this.sua_ = userAgent;
                this.bitField0_ |= 16;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeSua(UserAgent userAgent) {
                userAgent.getClass();
                UserAgent userAgent2 = this.sua_;
                if (userAgent2 != null && userAgent2 != UserAgent.getDefaultInstance()) {
                    this.sua_ = UserAgent.newBuilder(this.sua_).mergeFrom(userAgent).buildPartial();
                } else {
                    this.sua_ = userAgent;
                }
                this.bitField0_ |= 16;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSua() {
                this.sua_ = null;
                this.bitField0_ &= -17;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasIp() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getIp() {
                return this.ip_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getIpBytes() {
                return ByteString.copyFromUtf8(this.ip_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIp(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.ip_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIp() {
                this.bitField0_ &= -33;
                this.ip_ = getDefaultInstance().getIp();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIpBytes(ByteString byteString) {
                this.ip_ = byteString.toStringUtf8();
                this.bitField0_ |= 32;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasIpv6() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getIpv6() {
                return this.ipv6_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getIpv6Bytes() {
                return ByteString.copyFromUtf8(this.ipv6_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIpv6(String str) {
                str.getClass();
                this.bitField0_ |= 64;
                this.ipv6_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIpv6() {
                this.bitField0_ &= -65;
                this.ipv6_ = getDefaultInstance().getIpv6();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIpv6Bytes(ByteString byteString) {
                this.ipv6_ = byteString.toStringUtf8();
                this.bitField0_ |= 64;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasDevicetype() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public DeviceType getDevicetype() {
                DeviceType deviceTypeForNumber = DeviceType.forNumber(this.devicetype_);
                return deviceTypeForNumber == null ? DeviceType.MOBILE : deviceTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDevicetype(DeviceType deviceType) {
                this.devicetype_ = deviceType.getNumber();
                this.bitField0_ |= 128;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDevicetype() {
                this.bitField0_ &= -129;
                this.devicetype_ = 1;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasMake() {
                return (this.bitField0_ & 256) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getMake() {
                return this.make_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getMakeBytes() {
                return ByteString.copyFromUtf8(this.make_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMake(String str) {
                str.getClass();
                this.bitField0_ |= 256;
                this.make_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMake() {
                this.bitField0_ &= -257;
                this.make_ = getDefaultInstance().getMake();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMakeBytes(ByteString byteString) {
                this.make_ = byteString.toStringUtf8();
                this.bitField0_ |= 256;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasModel() {
                return (this.bitField0_ & 512) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getModel() {
                return this.model_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getModelBytes() {
                return ByteString.copyFromUtf8(this.model_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModel(String str) {
                str.getClass();
                this.bitField0_ |= 512;
                this.model_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearModel() {
                this.bitField0_ &= -513;
                this.model_ = getDefaultInstance().getModel();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setModelBytes(ByteString byteString) {
                this.model_ = byteString.toStringUtf8();
                this.bitField0_ |= 512;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasOs() {
                return (this.bitField0_ & 1024) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getOs() {
                return this.os_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getOsBytes() {
                return ByteString.copyFromUtf8(this.os_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOs(String str) {
                str.getClass();
                this.bitField0_ |= 1024;
                this.os_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOs() {
                this.bitField0_ &= -1025;
                this.os_ = getDefaultInstance().getOs();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsBytes(ByteString byteString) {
                this.os_ = byteString.toStringUtf8();
                this.bitField0_ |= 1024;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasOsv() {
                return (this.bitField0_ & 2048) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getOsv() {
                return this.osv_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getOsvBytes() {
                return ByteString.copyFromUtf8(this.osv_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsv(String str) {
                str.getClass();
                this.bitField0_ |= 2048;
                this.osv_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOsv() {
                this.bitField0_ &= -2049;
                this.osv_ = getDefaultInstance().getOsv();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOsvBytes(ByteString byteString) {
                this.osv_ = byteString.toStringUtf8();
                this.bitField0_ |= 2048;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasHwv() {
                return (this.bitField0_ & 4096) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getHwv() {
                return this.hwv_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getHwvBytes() {
                return ByteString.copyFromUtf8(this.hwv_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHwv(String str) {
                str.getClass();
                this.bitField0_ |= 4096;
                this.hwv_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHwv() {
                this.bitField0_ &= -4097;
                this.hwv_ = getDefaultInstance().getHwv();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHwvBytes(ByteString byteString) {
                this.hwv_ = byteString.toStringUtf8();
                this.bitField0_ |= 4096;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasW() {
                return (this.bitField0_ & 8192) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public int getW() {
                return this.w_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setW(int i) {
                this.bitField0_ |= 8192;
                this.w_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearW() {
                this.bitField0_ &= -8193;
                this.w_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasH() {
                return (this.bitField0_ & 16384) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public int getH() {
                return this.h_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setH(int i) {
                this.bitField0_ |= 16384;
                this.h_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearH() {
                this.bitField0_ &= -16385;
                this.h_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasPpi() {
                return (this.bitField0_ & 32768) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public int getPpi() {
                return this.ppi_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPpi(int i) {
                this.bitField0_ |= 32768;
                this.ppi_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPpi() {
                this.bitField0_ &= -32769;
                this.ppi_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasPxratio() {
                return (this.bitField0_ & 65536) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public double getPxratio() {
                return this.pxratio_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPxratio(double d) {
                this.bitField0_ |= 65536;
                this.pxratio_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPxratio() {
                this.bitField0_ &= -65537;
                this.pxratio_ = 0.0d;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasJs() {
                return (this.bitField0_ & 131072) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean getJs() {
                return this.js_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setJs(boolean z) {
                this.bitField0_ |= 131072;
                this.js_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearJs() {
                this.bitField0_ &= -131073;
                this.js_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasGeofetch() {
                return (this.bitField0_ & 262144) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean getGeofetch() {
                return this.geofetch_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setGeofetch(boolean z) {
                this.bitField0_ |= 262144;
                this.geofetch_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearGeofetch() {
                this.bitField0_ &= -262145;
                this.geofetch_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasFlashver() {
                return (this.bitField0_ & 524288) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getFlashver() {
                return this.flashver_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getFlashverBytes() {
                return ByteString.copyFromUtf8(this.flashver_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFlashver(String str) {
                str.getClass();
                this.bitField0_ |= 524288;
                this.flashver_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFlashver() {
                this.bitField0_ &= -524289;
                this.flashver_ = getDefaultInstance().getFlashver();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFlashverBytes(ByteString byteString) {
                this.flashver_ = byteString.toStringUtf8();
                this.bitField0_ |= 524288;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasLanguage() {
                return (this.bitField0_ & 1048576) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getLanguage() {
                return this.language_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getLanguageBytes() {
                return ByteString.copyFromUtf8(this.language_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLanguage(String str) {
                str.getClass();
                this.bitField0_ |= 1048576;
                this.language_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLanguage() {
                this.bitField0_ &= -1048577;
                this.language_ = getDefaultInstance().getLanguage();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLanguageBytes(ByteString byteString) {
                this.language_ = byteString.toStringUtf8();
                this.bitField0_ |= 1048576;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasLangb() {
                return (this.bitField0_ & 2097152) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getLangb() {
                return this.langb_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getLangbBytes() {
                return ByteString.copyFromUtf8(this.langb_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLangb(String str) {
                str.getClass();
                this.bitField0_ |= 2097152;
                this.langb_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLangb() {
                this.bitField0_ &= -2097153;
                this.langb_ = getDefaultInstance().getLangb();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLangbBytes(ByteString byteString) {
                this.langb_ = byteString.toStringUtf8();
                this.bitField0_ |= 2097152;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasCarrier() {
                return (this.bitField0_ & 4194304) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getCarrier() {
                return this.carrier_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getCarrierBytes() {
                return ByteString.copyFromUtf8(this.carrier_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrier(String str) {
                str.getClass();
                this.bitField0_ |= 4194304;
                this.carrier_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCarrier() {
                this.bitField0_ &= -4194305;
                this.carrier_ = getDefaultInstance().getCarrier();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCarrierBytes(ByteString byteString) {
                this.carrier_ = byteString.toStringUtf8();
                this.bitField0_ |= 4194304;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasMccmnc() {
                return (this.bitField0_ & 8388608) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getMccmnc() {
                return this.mccmnc_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getMccmncBytes() {
                return ByteString.copyFromUtf8(this.mccmnc_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMccmnc(String str) {
                str.getClass();
                this.bitField0_ |= 8388608;
                this.mccmnc_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMccmnc() {
                this.bitField0_ &= -8388609;
                this.mccmnc_ = getDefaultInstance().getMccmnc();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMccmncBytes(ByteString byteString) {
                this.mccmnc_ = byteString.toStringUtf8();
                this.bitField0_ |= 8388608;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasConnectiontype() {
                return (this.bitField0_ & 16777216) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ConnectionType getConnectiontype() {
                ConnectionType connectionTypeForNumber = ConnectionType.forNumber(this.connectiontype_);
                return connectionTypeForNumber == null ? ConnectionType.CONNECTION_UNKNOWN : connectionTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setConnectiontype(ConnectionType connectionType) {
                this.connectiontype_ = connectionType.getNumber();
                this.bitField0_ |= 16777216;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearConnectiontype() {
                this.bitField0_ &= -16777217;
                this.connectiontype_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public boolean hasIfa() {
                return (this.bitField0_ & 33554432) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public String getIfa() {
                return this.ifa_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            public ByteString getIfaBytes() {
                return ByteString.copyFromUtf8(this.ifa_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIfa(String str) {
                str.getClass();
                this.bitField0_ |= 33554432;
                this.ifa_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIfa() {
                this.bitField0_ &= -33554433;
                this.ifa_ = getDefaultInstance().getIfa();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIfaBytes(ByteString byteString) {
                this.ifa_ = byteString.toStringUtf8();
                this.bitField0_ |= 33554432;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasDidsha1() {
                return (this.bitField0_ & 67108864) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getDidsha1() {
                return this.didsha1_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getDidsha1Bytes() {
                return ByteString.copyFromUtf8(this.didsha1_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDidsha1(String str) {
                str.getClass();
                this.bitField0_ |= 67108864;
                this.didsha1_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDidsha1() {
                this.bitField0_ &= -67108865;
                this.didsha1_ = getDefaultInstance().getDidsha1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDidsha1Bytes(ByteString byteString) {
                this.didsha1_ = byteString.toStringUtf8();
                this.bitField0_ |= 67108864;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasDidmd5() {
                return (this.bitField0_ & 134217728) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getDidmd5() {
                return this.didmd5_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getDidmd5Bytes() {
                return ByteString.copyFromUtf8(this.didmd5_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDidmd5(String str) {
                str.getClass();
                this.bitField0_ |= 134217728;
                this.didmd5_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDidmd5() {
                this.bitField0_ &= -134217729;
                this.didmd5_ = getDefaultInstance().getDidmd5();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDidmd5Bytes(ByteString byteString) {
                this.didmd5_ = byteString.toStringUtf8();
                this.bitField0_ |= 134217728;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasDpidsha1() {
                return (this.bitField0_ & 268435456) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getDpidsha1() {
                return this.dpidsha1_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getDpidsha1Bytes() {
                return ByteString.copyFromUtf8(this.dpidsha1_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDpidsha1(String str) {
                str.getClass();
                this.bitField0_ |= 268435456;
                this.dpidsha1_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDpidsha1() {
                this.bitField0_ &= -268435457;
                this.dpidsha1_ = getDefaultInstance().getDpidsha1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDpidsha1Bytes(ByteString byteString) {
                this.dpidsha1_ = byteString.toStringUtf8();
                this.bitField0_ |= 268435456;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasDpidmd5() {
                return (this.bitField0_ & 536870912) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getDpidmd5() {
                return this.dpidmd5_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getDpidmd5Bytes() {
                return ByteString.copyFromUtf8(this.dpidmd5_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDpidmd5(String str) {
                str.getClass();
                this.bitField0_ |= 536870912;
                this.dpidmd5_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDpidmd5() {
                this.bitField0_ &= -536870913;
                this.dpidmd5_ = getDefaultInstance().getDpidmd5();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDpidmd5Bytes(ByteString byteString) {
                this.dpidmd5_ = byteString.toStringUtf8();
                this.bitField0_ |= 536870912;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasMacsha1() {
                return (this.bitField0_ & 1073741824) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getMacsha1() {
                return this.macsha1_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getMacsha1Bytes() {
                return ByteString.copyFromUtf8(this.macsha1_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMacsha1(String str) {
                str.getClass();
                this.bitField0_ |= 1073741824;
                this.macsha1_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMacsha1() {
                this.bitField0_ &= -1073741825;
                this.macsha1_ = getDefaultInstance().getMacsha1();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMacsha1Bytes(ByteString byteString) {
                this.macsha1_ = byteString.toStringUtf8();
                this.bitField0_ |= 1073741824;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public boolean hasMacmd5() {
                return (this.bitField0_ & Integer.MIN_VALUE) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public String getMacmd5() {
                return this.macmd5_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
            @Deprecated
            public ByteString getMacmd5Bytes() {
                return ByteString.copyFromUtf8(this.macmd5_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMacmd5(String str) {
                str.getClass();
                this.bitField0_ |= Integer.MIN_VALUE;
                this.macmd5_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMacmd5() {
                this.bitField0_ &= Integer.MAX_VALUE;
                this.macmd5_ = getDefaultInstance().getMacmd5();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMacmd5Bytes(ByteString byteString) {
                this.macmd5_ = byteString.toStringUtf8();
                this.bitField0_ |= Integer.MIN_VALUE;
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

            /* JADX WARN: Multi-variable type inference failed */
            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Builder newBuilder(Device device) {
                return (Builder) DEFAULT_INSTANCE.createBuilder(device);
            }

            public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Device, Builder> implements DeviceOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Device.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasGeo() {
                    return ((Device) this.instance).hasGeo();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public Geo getGeo() {
                    return ((Device) this.instance).getGeo();
                }

                public Builder setGeo(Geo geo) {
                    copyOnWrite();
                    ((Device) this.instance).setGeo(geo);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setGeo(Geo.Builder builder) {
                    copyOnWrite();
                    ((Device) this.instance).setGeo((Geo) builder.build());
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasDnt() {
                    return ((Device) this.instance).hasDnt();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean getDnt() {
                    return ((Device) this.instance).getDnt();
                }

                public Builder setDnt(boolean z) {
                    copyOnWrite();
                    ((Device) this.instance).setDnt(z);
                    return this;
                }

                public Builder clearDnt() {
                    copyOnWrite();
                    ((Device) this.instance).clearDnt();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasLmt() {
                    return ((Device) this.instance).hasLmt();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean getLmt() {
                    return ((Device) this.instance).getLmt();
                }

                public Builder setLmt(boolean z) {
                    copyOnWrite();
                    ((Device) this.instance).setLmt(z);
                    return this;
                }

                public Builder clearLmt() {
                    copyOnWrite();
                    ((Device) this.instance).clearLmt();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasUa() {
                    return ((Device) this.instance).hasUa();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getUa() {
                    return ((Device) this.instance).getUa();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getUaBytes() {
                    return ((Device) this.instance).getUaBytes();
                }

                public Builder setUa(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setUa(str);
                    return this;
                }

                public Builder clearUa() {
                    copyOnWrite();
                    ((Device) this.instance).clearUa();
                    return this;
                }

                public Builder setUaBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setUaBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasSua() {
                    return ((Device) this.instance).hasSua();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public UserAgent getSua() {
                    return ((Device) this.instance).getSua();
                }

                public Builder setSua(UserAgent userAgent) {
                    copyOnWrite();
                    ((Device) this.instance).setSua(userAgent);
                    return this;
                }

                public Builder setSua(UserAgent.Builder builder) {
                    copyOnWrite();
                    ((Device) this.instance).setSua(builder.build());
                    return this;
                }

                public Builder mergeSua(UserAgent userAgent) {
                    copyOnWrite();
                    ((Device) this.instance).mergeSua(userAgent);
                    return this;
                }

                public Builder clearSua() {
                    copyOnWrite();
                    ((Device) this.instance).clearSua();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasIp() {
                    return ((Device) this.instance).hasIp();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getIp() {
                    return ((Device) this.instance).getIp();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getIpBytes() {
                    return ((Device) this.instance).getIpBytes();
                }

                public Builder setIp(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setIp(str);
                    return this;
                }

                public Builder clearIp() {
                    copyOnWrite();
                    ((Device) this.instance).clearIp();
                    return this;
                }

                public Builder setIpBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setIpBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasIpv6() {
                    return ((Device) this.instance).hasIpv6();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getIpv6() {
                    return ((Device) this.instance).getIpv6();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getIpv6Bytes() {
                    return ((Device) this.instance).getIpv6Bytes();
                }

                public Builder setIpv6(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setIpv6(str);
                    return this;
                }

                public Builder clearIpv6() {
                    copyOnWrite();
                    ((Device) this.instance).clearIpv6();
                    return this;
                }

                public Builder setIpv6Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setIpv6Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasDevicetype() {
                    return ((Device) this.instance).hasDevicetype();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public DeviceType getDevicetype() {
                    return ((Device) this.instance).getDevicetype();
                }

                public Builder setDevicetype(DeviceType deviceType) {
                    copyOnWrite();
                    ((Device) this.instance).setDevicetype(deviceType);
                    return this;
                }

                public Builder clearDevicetype() {
                    copyOnWrite();
                    ((Device) this.instance).clearDevicetype();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasMake() {
                    return ((Device) this.instance).hasMake();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getMake() {
                    return ((Device) this.instance).getMake();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasModel() {
                    return ((Device) this.instance).hasModel();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getModel() {
                    return ((Device) this.instance).getModel();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasOs() {
                    return ((Device) this.instance).hasOs();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getOs() {
                    return ((Device) this.instance).getOs();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasOsv() {
                    return ((Device) this.instance).hasOsv();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getOsv() {
                    return ((Device) this.instance).getOsv();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasHwv() {
                    return ((Device) this.instance).hasHwv();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getHwv() {
                    return ((Device) this.instance).getHwv();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasW() {
                    return ((Device) this.instance).hasW();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasH() {
                    return ((Device) this.instance).hasH();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasPpi() {
                    return ((Device) this.instance).hasPpi();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasPxratio() {
                    return ((Device) this.instance).hasPxratio();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasJs() {
                    return ((Device) this.instance).hasJs();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean getJs() {
                    return ((Device) this.instance).getJs();
                }

                public Builder setJs(boolean z) {
                    copyOnWrite();
                    ((Device) this.instance).setJs(z);
                    return this;
                }

                public Builder clearJs() {
                    copyOnWrite();
                    ((Device) this.instance).clearJs();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasGeofetch() {
                    return ((Device) this.instance).hasGeofetch();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean getGeofetch() {
                    return ((Device) this.instance).getGeofetch();
                }

                public Builder setGeofetch(boolean z) {
                    copyOnWrite();
                    ((Device) this.instance).setGeofetch(z);
                    return this;
                }

                public Builder clearGeofetch() {
                    copyOnWrite();
                    ((Device) this.instance).clearGeofetch();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasFlashver() {
                    return ((Device) this.instance).hasFlashver();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getFlashver() {
                    return ((Device) this.instance).getFlashver();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getFlashverBytes() {
                    return ((Device) this.instance).getFlashverBytes();
                }

                public Builder setFlashver(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setFlashver(str);
                    return this;
                }

                public Builder clearFlashver() {
                    copyOnWrite();
                    ((Device) this.instance).clearFlashver();
                    return this;
                }

                public Builder setFlashverBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setFlashverBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasLanguage() {
                    return ((Device) this.instance).hasLanguage();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getLanguage() {
                    return ((Device) this.instance).getLanguage();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasLangb() {
                    return ((Device) this.instance).hasLangb();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getLangb() {
                    return ((Device) this.instance).getLangb();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getLangbBytes() {
                    return ((Device) this.instance).getLangbBytes();
                }

                public Builder setLangb(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setLangb(str);
                    return this;
                }

                public Builder clearLangb() {
                    copyOnWrite();
                    ((Device) this.instance).clearLangb();
                    return this;
                }

                public Builder setLangbBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setLangbBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasCarrier() {
                    return ((Device) this.instance).hasCarrier();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getCarrier() {
                    return ((Device) this.instance).getCarrier();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
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

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasMccmnc() {
                    return ((Device) this.instance).hasMccmnc();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getMccmnc() {
                    return ((Device) this.instance).getMccmnc();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getMccmncBytes() {
                    return ((Device) this.instance).getMccmncBytes();
                }

                public Builder setMccmnc(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setMccmnc(str);
                    return this;
                }

                public Builder clearMccmnc() {
                    copyOnWrite();
                    ((Device) this.instance).clearMccmnc();
                    return this;
                }

                public Builder setMccmncBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setMccmncBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasConnectiontype() {
                    return ((Device) this.instance).hasConnectiontype();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ConnectionType getConnectiontype() {
                    return ((Device) this.instance).getConnectiontype();
                }

                public Builder setConnectiontype(ConnectionType connectionType) {
                    copyOnWrite();
                    ((Device) this.instance).setConnectiontype(connectionType);
                    return this;
                }

                public Builder clearConnectiontype() {
                    copyOnWrite();
                    ((Device) this.instance).clearConnectiontype();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public boolean hasIfa() {
                    return ((Device) this.instance).hasIfa();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public String getIfa() {
                    return ((Device) this.instance).getIfa();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                public ByteString getIfaBytes() {
                    return ((Device) this.instance).getIfaBytes();
                }

                public Builder setIfa(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setIfa(str);
                    return this;
                }

                public Builder clearIfa() {
                    copyOnWrite();
                    ((Device) this.instance).clearIfa();
                    return this;
                }

                public Builder setIfaBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setIfaBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasDidsha1() {
                    return ((Device) this.instance).hasDidsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getDidsha1() {
                    return ((Device) this.instance).getDidsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getDidsha1Bytes() {
                    return ((Device) this.instance).getDidsha1Bytes();
                }

                @Deprecated
                public Builder setDidsha1(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setDidsha1(str);
                    return this;
                }

                @Deprecated
                public Builder clearDidsha1() {
                    copyOnWrite();
                    ((Device) this.instance).clearDidsha1();
                    return this;
                }

                @Deprecated
                public Builder setDidsha1Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setDidsha1Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasDidmd5() {
                    return ((Device) this.instance).hasDidmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getDidmd5() {
                    return ((Device) this.instance).getDidmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getDidmd5Bytes() {
                    return ((Device) this.instance).getDidmd5Bytes();
                }

                @Deprecated
                public Builder setDidmd5(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setDidmd5(str);
                    return this;
                }

                @Deprecated
                public Builder clearDidmd5() {
                    copyOnWrite();
                    ((Device) this.instance).clearDidmd5();
                    return this;
                }

                @Deprecated
                public Builder setDidmd5Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setDidmd5Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasDpidsha1() {
                    return ((Device) this.instance).hasDpidsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getDpidsha1() {
                    return ((Device) this.instance).getDpidsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getDpidsha1Bytes() {
                    return ((Device) this.instance).getDpidsha1Bytes();
                }

                @Deprecated
                public Builder setDpidsha1(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setDpidsha1(str);
                    return this;
                }

                @Deprecated
                public Builder clearDpidsha1() {
                    copyOnWrite();
                    ((Device) this.instance).clearDpidsha1();
                    return this;
                }

                @Deprecated
                public Builder setDpidsha1Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setDpidsha1Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasDpidmd5() {
                    return ((Device) this.instance).hasDpidmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getDpidmd5() {
                    return ((Device) this.instance).getDpidmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getDpidmd5Bytes() {
                    return ((Device) this.instance).getDpidmd5Bytes();
                }

                @Deprecated
                public Builder setDpidmd5(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setDpidmd5(str);
                    return this;
                }

                @Deprecated
                public Builder clearDpidmd5() {
                    copyOnWrite();
                    ((Device) this.instance).clearDpidmd5();
                    return this;
                }

                @Deprecated
                public Builder setDpidmd5Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setDpidmd5Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasMacsha1() {
                    return ((Device) this.instance).hasMacsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getMacsha1() {
                    return ((Device) this.instance).getMacsha1();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getMacsha1Bytes() {
                    return ((Device) this.instance).getMacsha1Bytes();
                }

                @Deprecated
                public Builder setMacsha1(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setMacsha1(str);
                    return this;
                }

                @Deprecated
                public Builder clearMacsha1() {
                    copyOnWrite();
                    ((Device) this.instance).clearMacsha1();
                    return this;
                }

                @Deprecated
                public Builder setMacsha1Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setMacsha1Bytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public boolean hasMacmd5() {
                    return ((Device) this.instance).hasMacmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public String getMacmd5() {
                    return ((Device) this.instance).getMacmd5();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.DeviceOrBuilder
                @Deprecated
                public ByteString getMacmd5Bytes() {
                    return ((Device) this.instance).getMacmd5Bytes();
                }

                @Deprecated
                public Builder setMacmd5(String str) {
                    copyOnWrite();
                    ((Device) this.instance).setMacmd5(str);
                    return this;
                }

                @Deprecated
                public Builder clearMacmd5() {
                    copyOnWrite();
                    ((Device) this.instance).clearMacmd5();
                    return this;
                }

                @Deprecated
                public Builder setMacmd5Bytes(ByteString byteString) {
                    copyOnWrite();
                    ((Device) this.instance).setMacmd5Bytes(byteString);
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
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001 \u0000\u0001\u0001  \u0000\u0000\u0001\u0001ဇ\u0001\u0002ဈ\u0003\u0003ဈ\u0005\u0004ᐉ\u0000\u0005ဈ\u001a\u0006ဈ\u001b\u0007ဈ\u001c\bဈ\u001d\tဈ\u0006\nဈ\u0016\u000bဈ\u0014\fဈ\b\rဈ\t\u000eဈ\n\u000fဈ\u000b\u0010ဇ\u0011\u0011ဌ\u0018\u0012ဌ\u0007\u0013ဈ\u0013\u0014ဈ\u0019\u0015ဈ\u001e\u0016ဈ\u001f\u0017ဇ\u0002\u0018ဈ\f\u0019င\r\u001aင\u000e\u001bင\u000f\u001cက\u0010\u001dဇ\u0012\u001eဈ\u0017\u001fဉ\u0004 ဈ\u0015", new Object[]{"bitField0_", "dnt_", "ua_", "ip_", "geo_", "didsha1_", "didmd5_", "dpidsha1_", "dpidmd5_", "ipv6_", "carrier_", "language_", "make_", "model_", "os_", "osv_", "js_", "connectiontype_", ConnectionType.internalGetVerifier(), "devicetype_", DeviceType.internalGetVerifier(), "flashver_", "ifa_", "macsha1_", "macmd5_", "lmt_", "hwv_", "w_", "h_", "ppi_", "pxratio_", "geofetch_", "mccmnc_", "sua_", "langb_"});
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
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

        public static final class Imp extends GeneratedMessageLite.ExtendableMessage<Imp, Builder> implements ImpOrBuilder {
            public static final int AUDIO_FIELD_NUMBER = 15;
            public static final int BANNER_FIELD_NUMBER = 2;
            public static final int BIDFLOORCUR_FIELD_NUMBER = 9;
            public static final int BIDFLOOR_FIELD_NUMBER = 8;
            public static final int CLICKBROWSER_FIELD_NUMBER = 16;
            private static final Imp DEFAULT_INSTANCE;
            public static final int DISPLAYMANAGERVER_FIELD_NUMBER = 5;
            public static final int DISPLAYMANAGER_FIELD_NUMBER = 4;
            public static final int EXP_FIELD_NUMBER = 14;
            public static final int ID_FIELD_NUMBER = 1;
            public static final int IFRAMEBUSTER_FIELD_NUMBER = 10;
            public static final int INSTL_FIELD_NUMBER = 6;
            public static final int METRIC_FIELD_NUMBER = 17;
            public static final int NATIVE_FIELD_NUMBER = 13;
            private static volatile Parser<Imp> PARSER = null;
            public static final int PMP_FIELD_NUMBER = 11;
            public static final int RWDD_FIELD_NUMBER = 18;
            public static final int SECURE_FIELD_NUMBER = 12;
            public static final int SSAI_FIELD_NUMBER = 19;
            public static final int TAGID_FIELD_NUMBER = 7;
            public static final int VIDEO_FIELD_NUMBER = 3;
            private Audio audio_;
            private Banner banner_;
            private double bidfloor_;
            private int bitField0_;
            private boolean clickbrowser_;
            private int exp_;
            private boolean instl_;
            private Native native_;
            private Pmp pmp_;
            private boolean rwdd_;
            private boolean secure_;
            private int ssai_;
            private Video video_;
            private byte memoizedIsInitialized = 2;
            private String id_ = "";
            private String displaymanager_ = "";
            private String displaymanagerver_ = "";
            private String tagid_ = "";
            private String bidfloorcur_ = "USD";
            private Internal.ProtobufList<String> iframebuster_ = GeneratedMessageLite.emptyProtobufList();
            private Internal.ProtobufList<Metric> metric_ = emptyProtobufList();

            public interface AudioOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Audio, Audio.Builder> {
                APIFramework getApi(int i);

                int getApiCount();

                List<APIFramework> getApiList();

                CreativeAttribute getBattr(int i);

                int getBattrCount();

                List<CreativeAttribute> getBattrList();

                Banner getCompanionad(int i);

                int getCompanionadCount();

                List<Banner> getCompanionadList();

                CompanionType getCompaniontype(int i);

                int getCompaniontypeCount();

                List<CompanionType> getCompaniontypeList();

                ContentDeliveryMethod getDelivery(int i);

                int getDeliveryCount();

                List<ContentDeliveryMethod> getDeliveryList();

                Audio.FeedType getFeed();

                int getMaxbitrate();

                int getMaxduration();

                int getMaxextended();

                int getMaxseq();

                String getMimes(int i);

                ByteString getMimesBytes(int i);

                int getMimesCount();

                List<String> getMimesList();

                int getMinbitrate();

                double getMincpmpersec();

                int getMinduration();

                Audio.VolumeNormalizationMode getNvol();

                int getPoddur();

                String getPodid();

                ByteString getPodidBytes();

                PodSequence getPodseq();

                Protocol getProtocols(int i);

                int getProtocolsCount();

                List<Protocol> getProtocolsList();

                int getRqddurs(int i);

                int getRqddursCount();

                List<Integer> getRqddursList();

                @Deprecated
                int getSequence();

                SlotPositionInPod getSlotinpod();

                int getStartdelay();

                boolean getStitched();

                boolean hasFeed();

                boolean hasMaxbitrate();

                boolean hasMaxduration();

                boolean hasMaxextended();

                boolean hasMaxseq();

                boolean hasMinbitrate();

                boolean hasMincpmpersec();

                boolean hasMinduration();

                boolean hasNvol();

                boolean hasPoddur();

                boolean hasPodid();

                boolean hasPodseq();

                @Deprecated
                boolean hasSequence();

                boolean hasSlotinpod();

                boolean hasStartdelay();

                boolean hasStitched();
            }

            public interface BannerOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Banner, Banner.Builder> {
                APIFramework getApi(int i);

                int getApiCount();

                List<APIFramework> getApiList();

                CreativeAttribute getBattr(int i);

                int getBattrCount();

                List<CreativeAttribute> getBattrList();

                Banner.BannerAdType getBtype(int i);

                int getBtypeCount();

                List<Banner.BannerAdType> getBtypeList();

                Banner.ExpandableDirection getExpdir(int i);

                int getExpdirCount();

                List<Banner.ExpandableDirection> getExpdirList();

                Banner.Format getFormat(int i);

                int getFormatCount();

                List<Banner.Format> getFormatList();

                int getH();

                @Deprecated
                int getHmax();

                @Deprecated
                int getHmin();

                String getId();

                ByteString getIdBytes();

                String getMimes(int i);

                ByteString getMimesBytes(int i);

                int getMimesCount();

                List<String> getMimesList();

                AdPosition getPos();

                boolean getTopframe();

                boolean getVcm();

                int getW();

                @Deprecated
                int getWmax();

                @Deprecated
                int getWmin();

                boolean hasH();

                @Deprecated
                boolean hasHmax();

                @Deprecated
                boolean hasHmin();

                boolean hasId();

                boolean hasPos();

                boolean hasTopframe();

                boolean hasVcm();

                boolean hasW();

                @Deprecated
                boolean hasWmax();

                @Deprecated
                boolean hasWmin();
            }

            public interface MetricOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Metric, Metric.Builder> {
                String getType();

                ByteString getTypeBytes();

                double getValue();

                String getVendor();

                ByteString getVendorBytes();

                boolean hasType();

                boolean hasValue();

                boolean hasVendor();
            }

            public interface NativeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Native, Native.Builder> {
                APIFramework getApi(int i);

                int getApiCount();

                List<APIFramework> getApiList();

                CreativeAttribute getBattr(int i);

                int getBattrCount();

                List<CreativeAttribute> getBattrList();

                String getRequest();

                ByteString getRequestBytes();

                Native.NativeRequest getRequestNative();

                Native.RequestOneofCase getRequestOneofCase();

                String getVer();

                ByteString getVerBytes();

                boolean hasRequest();

                boolean hasRequestNative();

                boolean hasVer();
            }

            public interface PmpOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Pmp, Pmp.Builder> {
                Pmp.Deal getDeals(int i);

                int getDealsCount();

                List<Pmp.Deal> getDealsList();

                boolean getPrivateAuction();

                boolean hasPrivateAuction();
            }

            public interface VideoOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Video, Video.Builder> {
                APIFramework getApi(int i);

                int getApiCount();

                List<APIFramework> getApiList();

                CreativeAttribute getBattr(int i);

                int getBattrCount();

                List<CreativeAttribute> getBattrList();

                boolean getBoxingallowed();

                Banner getCompanionad(int i);

                int getCompanionadCount();

                List<Banner> getCompanionadList();

                CompanionType getCompaniontype(int i);

                int getCompaniontypeCount();

                List<CompanionType> getCompaniontypeList();

                ContentDeliveryMethod getDelivery(int i);

                int getDeliveryCount();

                List<ContentDeliveryMethod> getDeliveryList();

                int getH();

                Video.VideoLinearity getLinearity();

                int getMaxbitrate();

                int getMaxduration();

                int getMaxextended();

                int getMaxseq();

                String getMimes(int i);

                ByteString getMimesBytes(int i);

                int getMimesCount();

                List<String> getMimesList();

                int getMinbitrate();

                double getMincpmpersec();

                int getMinduration();

                Video.VideoPlacementType getPlacement();

                Video.PlaybackCessationMode getPlaybackend();

                Video.PlaybackMethod getPlaybackmethod(int i);

                int getPlaybackmethodCount();

                List<Video.PlaybackMethod> getPlaybackmethodList();

                int getPoddur();

                String getPodid();

                ByteString getPodidBytes();

                PodSequence getPodseq();

                AdPosition getPos();

                @Deprecated
                Protocol getProtocol();

                Protocol getProtocols(int i);

                int getProtocolsCount();

                List<Protocol> getProtocolsList();

                int getRqddurs(int i);

                int getRqddursCount();

                List<Integer> getRqddursList();

                @Deprecated
                int getSequence();

                boolean getSkip();

                int getSkipafter();

                int getSkipmin();

                SlotPositionInPod getSlotinpod();

                int getStartdelay();

                int getW();

                boolean hasBoxingallowed();

                boolean hasH();

                boolean hasLinearity();

                boolean hasMaxbitrate();

                boolean hasMaxduration();

                boolean hasMaxextended();

                boolean hasMaxseq();

                boolean hasMinbitrate();

                boolean hasMincpmpersec();

                boolean hasMinduration();

                boolean hasPlacement();

                boolean hasPlaybackend();

                boolean hasPoddur();

                boolean hasPodid();

                boolean hasPodseq();

                boolean hasPos();

                @Deprecated
                boolean hasProtocol();

                @Deprecated
                boolean hasSequence();

                boolean hasSkip();

                boolean hasSkipafter();

                boolean hasSkipmin();

                boolean hasSlotinpod();

                boolean hasStartdelay();

                boolean hasW();
            }

            private Imp() {
            }

            public enum ServerSideAdInsertionType implements Internal.EnumLite {
                SERVER_SIDE_AD_INSERTION_TYPE_UNKNOWN(0),
                CLIENT_SIDE_ONLY(1),
                SERVER_SIDE_STITCHED_CLIENT_TRACKER(2),
                SERVER_SIDE_ONLY(3);

                public static final int CLIENT_SIDE_ONLY_VALUE = 1;
                public static final int SERVER_SIDE_AD_INSERTION_TYPE_UNKNOWN_VALUE = 0;
                public static final int SERVER_SIDE_ONLY_VALUE = 3;
                public static final int SERVER_SIDE_STITCHED_CLIENT_TRACKER_VALUE = 2;
                private static final Internal.EnumLiteMap<ServerSideAdInsertionType> internalValueMap = new Internal.EnumLiteMap<ServerSideAdInsertionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.ServerSideAdInsertionType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public ServerSideAdInsertionType findValueByNumber(int i) {
                        return ServerSideAdInsertionType.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static ServerSideAdInsertionType valueOf(int i) {
                    return forNumber(i);
                }

                public static ServerSideAdInsertionType forNumber(int i) {
                    if (i == 0) {
                        return SERVER_SIDE_AD_INSERTION_TYPE_UNKNOWN;
                    }
                    if (i == 1) {
                        return CLIENT_SIDE_ONLY;
                    }
                    if (i == 2) {
                        return SERVER_SIDE_STITCHED_CLIENT_TRACKER;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return SERVER_SIDE_ONLY;
                }

                public static Internal.EnumLiteMap<ServerSideAdInsertionType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return ServerSideAdInsertionTypeVerifier.INSTANCE;
                }

                private static final class ServerSideAdInsertionTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new ServerSideAdInsertionTypeVerifier();

                    private ServerSideAdInsertionTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return ServerSideAdInsertionType.forNumber(i) != null;
                    }
                }

                ServerSideAdInsertionType(int i) {
                    this.value = i;
                }
            }

            public enum AdPosition implements Internal.EnumLite {
                UNKNOWN(0),
                ABOVE_THE_FOLD(1),
                LOCKED(2),
                BELOW_THE_FOLD(3),
                HEADER(4),
                FOOTER(5),
                SIDEBAR(6),
                AD_POSITION_FULLSCREEN(7);

                public static final int ABOVE_THE_FOLD_VALUE = 1;
                public static final int AD_POSITION_FULLSCREEN_VALUE = 7;
                public static final int BELOW_THE_FOLD_VALUE = 3;
                public static final int FOOTER_VALUE = 5;
                public static final int HEADER_VALUE = 4;
                public static final int LOCKED_VALUE = 2;
                public static final int SIDEBAR_VALUE = 6;
                public static final int UNKNOWN_VALUE = 0;
                private static final Internal.EnumLiteMap<AdPosition> internalValueMap = new Internal.EnumLiteMap<AdPosition>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AdPosition.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public AdPosition findValueByNumber(int i) {
                        return AdPosition.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static AdPosition valueOf(int i) {
                    return forNumber(i);
                }

                public static AdPosition forNumber(int i) {
                    switch (i) {
                        case 0:
                            return UNKNOWN;
                        case 1:
                            return ABOVE_THE_FOLD;
                        case 2:
                            return LOCKED;
                        case 3:
                            return BELOW_THE_FOLD;
                        case 4:
                            return HEADER;
                        case 5:
                            return FOOTER;
                        case 6:
                            return SIDEBAR;
                        case 7:
                            return AD_POSITION_FULLSCREEN;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<AdPosition> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return AdPositionVerifier.INSTANCE;
                }

                private static final class AdPositionVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new AdPositionVerifier();

                    private AdPositionVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return AdPosition.forNumber(i) != null;
                    }
                }

                AdPosition(int i) {
                    this.value = i;
                }
            }

            public enum CreativeAttribute implements Internal.EnumLite {
                AUDIO_AUTO_PLAY(1),
                AUDIO_USER_INITIATED(2),
                EXPANDABLE_AUTOMATIC(3),
                EXPANDABLE_CLICK_INITIATED(4),
                EXPANDABLE_ROLLOVER_INITIATED(5),
                VIDEO_IN_BANNER_AUTO_PLAY(6),
                VIDEO_IN_BANNER_USER_INITIATED(7),
                POP(8),
                PROVOCATIVE_OR_SUGGESTIVE(9),
                ANNOYING(10),
                SURVEYS(11),
                TEXT_ONLY(12),
                USER_INTERACTIVE(13),
                WINDOWS_DIALOG_OR_ALERT_STYLE(14),
                HAS_AUDIO_ON_OFF_BUTTON(15),
                AD_CAN_BE_SKIPPED(16),
                FLASH(17),
                RESPONSIVE(18);

                public static final int AD_CAN_BE_SKIPPED_VALUE = 16;
                public static final int ANNOYING_VALUE = 10;
                public static final int AUDIO_AUTO_PLAY_VALUE = 1;
                public static final int AUDIO_USER_INITIATED_VALUE = 2;
                public static final int EXPANDABLE_AUTOMATIC_VALUE = 3;
                public static final int EXPANDABLE_CLICK_INITIATED_VALUE = 4;
                public static final int EXPANDABLE_ROLLOVER_INITIATED_VALUE = 5;
                public static final int FLASH_VALUE = 17;
                public static final int HAS_AUDIO_ON_OFF_BUTTON_VALUE = 15;
                public static final int POP_VALUE = 8;
                public static final int PROVOCATIVE_OR_SUGGESTIVE_VALUE = 9;
                public static final int RESPONSIVE_VALUE = 18;
                public static final int SURVEYS_VALUE = 11;
                public static final int TEXT_ONLY_VALUE = 12;
                public static final int USER_INTERACTIVE_VALUE = 13;
                public static final int VIDEO_IN_BANNER_AUTO_PLAY_VALUE = 6;
                public static final int VIDEO_IN_BANNER_USER_INITIATED_VALUE = 7;
                public static final int WINDOWS_DIALOG_OR_ALERT_STYLE_VALUE = 14;
                private static final Internal.EnumLiteMap<CreativeAttribute> internalValueMap = new Internal.EnumLiteMap<CreativeAttribute>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.CreativeAttribute.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public CreativeAttribute findValueByNumber(int i) {
                        return CreativeAttribute.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static CreativeAttribute valueOf(int i) {
                    return forNumber(i);
                }

                public static CreativeAttribute forNumber(int i) {
                    switch (i) {
                        case 1:
                            return AUDIO_AUTO_PLAY;
                        case 2:
                            return AUDIO_USER_INITIATED;
                        case 3:
                            return EXPANDABLE_AUTOMATIC;
                        case 4:
                            return EXPANDABLE_CLICK_INITIATED;
                        case 5:
                            return EXPANDABLE_ROLLOVER_INITIATED;
                        case 6:
                            return VIDEO_IN_BANNER_AUTO_PLAY;
                        case 7:
                            return VIDEO_IN_BANNER_USER_INITIATED;
                        case 8:
                            return POP;
                        case 9:
                            return PROVOCATIVE_OR_SUGGESTIVE;
                        case 10:
                            return ANNOYING;
                        case 11:
                            return SURVEYS;
                        case 12:
                            return TEXT_ONLY;
                        case 13:
                            return USER_INTERACTIVE;
                        case 14:
                            return WINDOWS_DIALOG_OR_ALERT_STYLE;
                        case 15:
                            return HAS_AUDIO_ON_OFF_BUTTON;
                        case 16:
                            return AD_CAN_BE_SKIPPED;
                        case 17:
                            return FLASH;
                        case 18:
                            return RESPONSIVE;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<CreativeAttribute> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return CreativeAttributeVerifier.INSTANCE;
                }

                private static final class CreativeAttributeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new CreativeAttributeVerifier();

                    private CreativeAttributeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return CreativeAttribute.forNumber(i) != null;
                    }
                }

                CreativeAttribute(int i) {
                    this.value = i;
                }
            }

            public enum APIFramework implements Internal.EnumLite {
                VPAID_1(1),
                VPAID_2(2),
                MRAID_1(3),
                ORMMA(4),
                MRAID_2(5),
                MRAID_3(6),
                OMID_1(7),
                SIMID_1_0(8),
                SIMID_1_1(9);

                public static final int MRAID_1_VALUE = 3;
                public static final int MRAID_2_VALUE = 5;
                public static final int MRAID_3_VALUE = 6;
                public static final int OMID_1_VALUE = 7;
                public static final int ORMMA_VALUE = 4;
                public static final int SIMID_1_0_VALUE = 8;
                public static final int SIMID_1_1_VALUE = 9;
                public static final int VPAID_1_VALUE = 1;
                public static final int VPAID_2_VALUE = 2;
                private static final Internal.EnumLiteMap<APIFramework> internalValueMap = new Internal.EnumLiteMap<APIFramework>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.APIFramework.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public APIFramework findValueByNumber(int i) {
                        return APIFramework.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static APIFramework valueOf(int i) {
                    return forNumber(i);
                }

                public static APIFramework forNumber(int i) {
                    switch (i) {
                        case 1:
                            return VPAID_1;
                        case 2:
                            return VPAID_2;
                        case 3:
                            return MRAID_1;
                        case 4:
                            return ORMMA;
                        case 5:
                            return MRAID_2;
                        case 6:
                            return MRAID_3;
                        case 7:
                            return OMID_1;
                        case 8:
                            return SIMID_1_0;
                        case 9:
                            return SIMID_1_1;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<APIFramework> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return APIFrameworkVerifier.INSTANCE;
                }

                private static final class APIFrameworkVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new APIFrameworkVerifier();

                    private APIFrameworkVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return APIFramework.forNumber(i) != null;
                    }
                }

                APIFramework(int i) {
                    this.value = i;
                }
            }

            public enum CompanionType implements Internal.EnumLite {
                STATIC(1),
                HTML(2),
                COMPANION_IFRAME(3);

                public static final int COMPANION_IFRAME_VALUE = 3;
                public static final int HTML_VALUE = 2;
                public static final int STATIC_VALUE = 1;
                private static final Internal.EnumLiteMap<CompanionType> internalValueMap = new Internal.EnumLiteMap<CompanionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.CompanionType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public CompanionType findValueByNumber(int i) {
                        return CompanionType.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static CompanionType valueOf(int i) {
                    return forNumber(i);
                }

                public static CompanionType forNumber(int i) {
                    if (i == 1) {
                        return STATIC;
                    }
                    if (i == 2) {
                        return HTML;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return COMPANION_IFRAME;
                }

                public static Internal.EnumLiteMap<CompanionType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return CompanionTypeVerifier.INSTANCE;
                }

                private static final class CompanionTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new CompanionTypeVerifier();

                    private CompanionTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return CompanionType.forNumber(i) != null;
                    }
                }

                CompanionType(int i) {
                    this.value = i;
                }
            }

            public enum ContentDeliveryMethod implements Internal.EnumLite {
                STREAMING(1),
                PROGRESSIVE(2),
                DOWNLOAD(3);

                public static final int DOWNLOAD_VALUE = 3;
                public static final int PROGRESSIVE_VALUE = 2;
                public static final int STREAMING_VALUE = 1;
                private static final Internal.EnumLiteMap<ContentDeliveryMethod> internalValueMap = new Internal.EnumLiteMap<ContentDeliveryMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.ContentDeliveryMethod.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public ContentDeliveryMethod findValueByNumber(int i) {
                        return ContentDeliveryMethod.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static ContentDeliveryMethod valueOf(int i) {
                    return forNumber(i);
                }

                public static ContentDeliveryMethod forNumber(int i) {
                    if (i == 1) {
                        return STREAMING;
                    }
                    if (i == 2) {
                        return PROGRESSIVE;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return DOWNLOAD;
                }

                public static Internal.EnumLiteMap<ContentDeliveryMethod> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return ContentDeliveryMethodVerifier.INSTANCE;
                }

                private static final class ContentDeliveryMethodVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new ContentDeliveryMethodVerifier();

                    private ContentDeliveryMethodVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return ContentDeliveryMethod.forNumber(i) != null;
                    }
                }

                ContentDeliveryMethod(int i) {
                    this.value = i;
                }
            }

            public enum SlotPositionInPod implements Internal.EnumLite {
                SLOT_POSITION_POD_ANY(0),
                SLOT_POSITION_POD_LAST(-1),
                SLOT_POSITION_POD_FIRST(1),
                SLOT_POSITION_POD_FIRST_OR_LAST(2);

                public static final int SLOT_POSITION_POD_ANY_VALUE = 0;
                public static final int SLOT_POSITION_POD_FIRST_OR_LAST_VALUE = 2;
                public static final int SLOT_POSITION_POD_FIRST_VALUE = 1;
                public static final int SLOT_POSITION_POD_LAST_VALUE = -1;
                private static final Internal.EnumLiteMap<SlotPositionInPod> internalValueMap = new Internal.EnumLiteMap<SlotPositionInPod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.SlotPositionInPod.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public SlotPositionInPod findValueByNumber(int i) {
                        return SlotPositionInPod.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static SlotPositionInPod valueOf(int i) {
                    return forNumber(i);
                }

                public static SlotPositionInPod forNumber(int i) {
                    if (i == -1) {
                        return SLOT_POSITION_POD_LAST;
                    }
                    if (i == 0) {
                        return SLOT_POSITION_POD_ANY;
                    }
                    if (i == 1) {
                        return SLOT_POSITION_POD_FIRST;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return SLOT_POSITION_POD_FIRST_OR_LAST;
                }

                public static Internal.EnumLiteMap<SlotPositionInPod> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return SlotPositionInPodVerifier.INSTANCE;
                }

                private static final class SlotPositionInPodVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new SlotPositionInPodVerifier();

                    private SlotPositionInPodVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return SlotPositionInPod.forNumber(i) != null;
                    }
                }

                SlotPositionInPod(int i) {
                    this.value = i;
                }
            }

            public enum Protocol implements Internal.EnumLite {
                VAST_1_0(1),
                VAST_2_0(2),
                VAST_3_0(3),
                VAST_1_0_WRAPPER(4),
                VAST_2_0_WRAPPER(5),
                VAST_3_0_WRAPPER(6),
                VAST_4_0(7),
                VAST_4_0_WRAPPER(8),
                DAAST_1_0(9),
                DAAST_1_0_WRAPPER(10),
                VAST_4_1(11),
                VAST_4_1_WRAPPER(12),
                VAST_4_2(13),
                VAST_4_2_WRAPPER(14);

                public static final int DAAST_1_0_VALUE = 9;
                public static final int DAAST_1_0_WRAPPER_VALUE = 10;
                public static final int VAST_1_0_VALUE = 1;
                public static final int VAST_1_0_WRAPPER_VALUE = 4;
                public static final int VAST_2_0_VALUE = 2;
                public static final int VAST_2_0_WRAPPER_VALUE = 5;
                public static final int VAST_3_0_VALUE = 3;
                public static final int VAST_3_0_WRAPPER_VALUE = 6;
                public static final int VAST_4_0_VALUE = 7;
                public static final int VAST_4_0_WRAPPER_VALUE = 8;
                public static final int VAST_4_1_VALUE = 11;
                public static final int VAST_4_1_WRAPPER_VALUE = 12;
                public static final int VAST_4_2_VALUE = 13;
                public static final int VAST_4_2_WRAPPER_VALUE = 14;
                private static final Internal.EnumLiteMap<Protocol> internalValueMap = new Internal.EnumLiteMap<Protocol>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Protocol.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public Protocol findValueByNumber(int i) {
                        return Protocol.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static Protocol valueOf(int i) {
                    return forNumber(i);
                }

                public static Protocol forNumber(int i) {
                    switch (i) {
                        case 1:
                            return VAST_1_0;
                        case 2:
                            return VAST_2_0;
                        case 3:
                            return VAST_3_0;
                        case 4:
                            return VAST_1_0_WRAPPER;
                        case 5:
                            return VAST_2_0_WRAPPER;
                        case 6:
                            return VAST_3_0_WRAPPER;
                        case 7:
                            return VAST_4_0;
                        case 8:
                            return VAST_4_0_WRAPPER;
                        case 9:
                            return DAAST_1_0;
                        case 10:
                            return DAAST_1_0_WRAPPER;
                        case 11:
                            return VAST_4_1;
                        case 12:
                            return VAST_4_1_WRAPPER;
                        case 13:
                            return VAST_4_2;
                        case 14:
                            return VAST_4_2_WRAPPER;
                        default:
                            return null;
                    }
                }

                public static Internal.EnumLiteMap<Protocol> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return ProtocolVerifier.INSTANCE;
                }

                private static final class ProtocolVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new ProtocolVerifier();

                    private ProtocolVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return Protocol.forNumber(i) != null;
                    }
                }

                Protocol(int i) {
                    this.value = i;
                }
            }

            public enum PodSequence implements Internal.EnumLite {
                POD_SEQUENCE_ANY(0),
                POD_SEQUENCE_LAST(-1),
                POD_SEQUENCE_FIRST(1);

                public static final int POD_SEQUENCE_ANY_VALUE = 0;
                public static final int POD_SEQUENCE_FIRST_VALUE = 1;
                public static final int POD_SEQUENCE_LAST_VALUE = -1;
                private static final Internal.EnumLiteMap<PodSequence> internalValueMap = new Internal.EnumLiteMap<PodSequence>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PodSequence.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public PodSequence findValueByNumber(int i) {
                        return PodSequence.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static PodSequence valueOf(int i) {
                    return forNumber(i);
                }

                public static PodSequence forNumber(int i) {
                    if (i == -1) {
                        return POD_SEQUENCE_LAST;
                    }
                    if (i == 0) {
                        return POD_SEQUENCE_ANY;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return POD_SEQUENCE_FIRST;
                }

                public static Internal.EnumLiteMap<PodSequence> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return PodSequenceVerifier.INSTANCE;
                }

                private static final class PodSequenceVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new PodSequenceVerifier();

                    private PodSequenceVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return PodSequence.forNumber(i) != null;
                    }
                }

                PodSequence(int i) {
                    this.value = i;
                }
            }

            public static final class Metric extends GeneratedMessageLite.ExtendableMessage<Metric, Builder> implements MetricOrBuilder {
                private static final Metric DEFAULT_INSTANCE;
                private static volatile Parser<Metric> PARSER = null;
                public static final int TYPE_FIELD_NUMBER = 1;
                public static final int VALUE_FIELD_NUMBER = 2;
                public static final int VENDOR_FIELD_NUMBER = 3;
                private int bitField0_;
                private double value_;
                private byte memoizedIsInitialized = 2;
                private String type_ = "";
                private String vendor_ = "";

                private Metric() {
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public boolean hasType() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public String getType() {
                    return this.type_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public ByteString getTypeBytes() {
                    return ByteString.copyFromUtf8(this.type_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setType(String str) {
                    str.getClass();
                    this.bitField0_ |= 1;
                    this.type_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearType() {
                    this.bitField0_ &= -2;
                    this.type_ = getDefaultInstance().getType();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setTypeBytes(ByteString byteString) {
                    this.type_ = byteString.toStringUtf8();
                    this.bitField0_ |= 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public boolean hasValue() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public double getValue() {
                    return this.value_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setValue(double d) {
                    this.bitField0_ |= 2;
                    this.value_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearValue() {
                    this.bitField0_ &= -3;
                    this.value_ = 0.0d;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public boolean hasVendor() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public String getVendor() {
                    return this.vendor_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                public ByteString getVendorBytes() {
                    return ByteString.copyFromUtf8(this.vendor_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setVendor(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.vendor_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearVendor() {
                    this.bitField0_ &= -5;
                    this.vendor_ = getDefaultInstance().getVendor();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setVendorBytes(ByteString byteString) {
                    this.vendor_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                public static Metric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Metric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Metric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Metric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Metric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Metric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Metric parseFrom(InputStream inputStream) throws IOException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Metric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Metric parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Metric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Metric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Metric parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Metric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Metric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Metric metric) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(metric);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Metric, Builder> implements MetricOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Metric.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public boolean hasType() {
                        return ((Metric) this.instance).hasType();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public String getType() {
                        return ((Metric) this.instance).getType();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public ByteString getTypeBytes() {
                        return ((Metric) this.instance).getTypeBytes();
                    }

                    public Builder setType(String str) {
                        copyOnWrite();
                        ((Metric) this.instance).setType(str);
                        return this;
                    }

                    public Builder clearType() {
                        copyOnWrite();
                        ((Metric) this.instance).clearType();
                        return this;
                    }

                    public Builder setTypeBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Metric) this.instance).setTypeBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public boolean hasValue() {
                        return ((Metric) this.instance).hasValue();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public double getValue() {
                        return ((Metric) this.instance).getValue();
                    }

                    public Builder setValue(double d) {
                        copyOnWrite();
                        ((Metric) this.instance).setValue(d);
                        return this;
                    }

                    public Builder clearValue() {
                        copyOnWrite();
                        ((Metric) this.instance).clearValue();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public boolean hasVendor() {
                        return ((Metric) this.instance).hasVendor();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public String getVendor() {
                        return ((Metric) this.instance).getVendor();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.MetricOrBuilder
                    public ByteString getVendorBytes() {
                        return ((Metric) this.instance).getVendorBytes();
                    }

                    public Builder setVendor(String str) {
                        copyOnWrite();
                        ((Metric) this.instance).setVendor(str);
                        return this;
                    }

                    public Builder clearVendor() {
                        copyOnWrite();
                        ((Metric) this.instance).clearVendor();
                        return this;
                    }

                    public Builder setVendorBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Metric) this.instance).setVendorBytes(byteString);
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Metric();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002က\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "type_", "value_", "vendor_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Metric> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Metric.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                static {
                    Metric metric = new Metric();
                    DEFAULT_INSTANCE = metric;
                    GeneratedMessageLite.registerDefaultInstance(Metric.class, metric);
                }

                public static Metric getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Metric> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            public static final class Banner extends GeneratedMessageLite.ExtendableMessage<Banner, Builder> implements BannerOrBuilder {
                public static final int API_FIELD_NUMBER = 10;
                public static final int BATTR_FIELD_NUMBER = 6;
                public static final int BTYPE_FIELD_NUMBER = 5;
                private static final Banner DEFAULT_INSTANCE;
                public static final int EXPDIR_FIELD_NUMBER = 9;
                public static final int FORMAT_FIELD_NUMBER = 15;
                public static final int HMAX_FIELD_NUMBER = 12;
                public static final int HMIN_FIELD_NUMBER = 14;
                public static final int H_FIELD_NUMBER = 2;
                public static final int ID_FIELD_NUMBER = 3;
                public static final int MIMES_FIELD_NUMBER = 7;
                private static volatile Parser<Banner> PARSER = null;
                public static final int POS_FIELD_NUMBER = 4;
                public static final int TOPFRAME_FIELD_NUMBER = 8;
                public static final int VCM_FIELD_NUMBER = 16;
                public static final int WMAX_FIELD_NUMBER = 11;
                public static final int WMIN_FIELD_NUMBER = 13;
                public static final int W_FIELD_NUMBER = 1;
                private int apiMemoizedSerializedSize;
                private int battrMemoizedSerializedSize;
                private int bitField0_;
                private int btypeMemoizedSerializedSize;
                private int expdirMemoizedSerializedSize;
                private int h_;
                private int hmax_;
                private int hmin_;
                private int pos_;
                private boolean topframe_;
                private boolean vcm_;
                private int w_;
                private int wmax_;
                private int wmin_;
                private static final Internal.ListAdapter.Converter<Integer, BannerAdType> btype_converter_ = new Internal.ListAdapter.Converter<Integer, BannerAdType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.1
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public BannerAdType convert(Integer num) {
                        BannerAdType bannerAdTypeForNumber = BannerAdType.forNumber(num.intValue());
                        return bannerAdTypeForNumber == null ? BannerAdType.XHTML_TEXT_AD : bannerAdTypeForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CreativeAttribute> battr_converter_ = new Internal.ListAdapter.Converter<Integer, CreativeAttribute>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.2
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CreativeAttribute convert(Integer num) {
                        CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(num.intValue());
                        return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, ExpandableDirection> expdir_converter_ = new Internal.ListAdapter.Converter<Integer, ExpandableDirection>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.3
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public ExpandableDirection convert(Integer num) {
                        ExpandableDirection expandableDirectionForNumber = ExpandableDirection.forNumber(num.intValue());
                        return expandableDirectionForNumber == null ? ExpandableDirection.LEFT : expandableDirectionForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, APIFramework> api_converter_ = new Internal.ListAdapter.Converter<Integer, APIFramework>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.4
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public APIFramework convert(Integer num) {
                        APIFramework aPIFrameworkForNumber = APIFramework.forNumber(num.intValue());
                        return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                    }
                };
                private byte memoizedIsInitialized = 2;
                private Internal.ProtobufList<Format> format_ = emptyProtobufList();
                private String id_ = "";
                private Internal.IntList btype_ = emptyIntList();
                private Internal.IntList battr_ = emptyIntList();
                private Internal.ProtobufList<String> mimes_ = GeneratedMessageLite.emptyProtobufList();
                private Internal.IntList expdir_ = emptyIntList();
                private Internal.IntList api_ = emptyIntList();

                public interface FormatOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Format, Format.Builder> {
                    int getH();

                    int getHratio();

                    int getW();

                    int getWmin();

                    int getWratio();

                    boolean hasH();

                    boolean hasHratio();

                    boolean hasW();

                    boolean hasWmin();

                    boolean hasWratio();
                }

                private Banner() {
                }

                public enum BannerAdType implements Internal.EnumLite {
                    XHTML_TEXT_AD(1),
                    XHTML_BANNER_AD(2),
                    JAVASCRIPT_AD(3),
                    IFRAME(4);

                    public static final int IFRAME_VALUE = 4;
                    public static final int JAVASCRIPT_AD_VALUE = 3;
                    public static final int XHTML_BANNER_AD_VALUE = 2;
                    public static final int XHTML_TEXT_AD_VALUE = 1;
                    private static final Internal.EnumLiteMap<BannerAdType> internalValueMap = new Internal.EnumLiteMap<BannerAdType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.BannerAdType.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public BannerAdType findValueByNumber(int i) {
                            return BannerAdType.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static BannerAdType valueOf(int i) {
                        return forNumber(i);
                    }

                    public static BannerAdType forNumber(int i) {
                        if (i == 1) {
                            return XHTML_TEXT_AD;
                        }
                        if (i == 2) {
                            return XHTML_BANNER_AD;
                        }
                        if (i == 3) {
                            return JAVASCRIPT_AD;
                        }
                        if (i != 4) {
                            return null;
                        }
                        return IFRAME;
                    }

                    public static Internal.EnumLiteMap<BannerAdType> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return BannerAdTypeVerifier.INSTANCE;
                    }

                    private static final class BannerAdTypeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new BannerAdTypeVerifier();

                        private BannerAdTypeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return BannerAdType.forNumber(i) != null;
                        }
                    }

                    BannerAdType(int i) {
                        this.value = i;
                    }
                }

                public enum ExpandableDirection implements Internal.EnumLite {
                    LEFT(1),
                    RIGHT(2),
                    UP(3),
                    DOWN(4),
                    EXPANDABLE_FULLSCREEN(5),
                    RESIZE_MINIMIZE(6);

                    public static final int DOWN_VALUE = 4;
                    public static final int EXPANDABLE_FULLSCREEN_VALUE = 5;
                    public static final int LEFT_VALUE = 1;
                    public static final int RESIZE_MINIMIZE_VALUE = 6;
                    public static final int RIGHT_VALUE = 2;
                    public static final int UP_VALUE = 3;
                    private static final Internal.EnumLiteMap<ExpandableDirection> internalValueMap = new Internal.EnumLiteMap<ExpandableDirection>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.ExpandableDirection.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public ExpandableDirection findValueByNumber(int i) {
                            return ExpandableDirection.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static ExpandableDirection valueOf(int i) {
                        return forNumber(i);
                    }

                    public static ExpandableDirection forNumber(int i) {
                        switch (i) {
                            case 1:
                                return LEFT;
                            case 2:
                                return RIGHT;
                            case 3:
                                return UP;
                            case 4:
                                return DOWN;
                            case 5:
                                return EXPANDABLE_FULLSCREEN;
                            case 6:
                                return RESIZE_MINIMIZE;
                            default:
                                return null;
                        }
                    }

                    public static Internal.EnumLiteMap<ExpandableDirection> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return ExpandableDirectionVerifier.INSTANCE;
                    }

                    private static final class ExpandableDirectionVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new ExpandableDirectionVerifier();

                        private ExpandableDirectionVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return ExpandableDirection.forNumber(i) != null;
                        }
                    }

                    ExpandableDirection(int i) {
                        this.value = i;
                    }
                }

                public static final class Format extends GeneratedMessageLite.ExtendableMessage<Format, Builder> implements FormatOrBuilder {
                    private static final Format DEFAULT_INSTANCE;
                    public static final int HRATIO_FIELD_NUMBER = 4;
                    public static final int H_FIELD_NUMBER = 2;
                    private static volatile Parser<Format> PARSER = null;
                    public static final int WMIN_FIELD_NUMBER = 5;
                    public static final int WRATIO_FIELD_NUMBER = 3;
                    public static final int W_FIELD_NUMBER = 1;
                    private int bitField0_;
                    private int h_;
                    private int hratio_;
                    private byte memoizedIsInitialized = 2;
                    private int w_;
                    private int wmin_;
                    private int wratio_;

                    private Format() {
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public boolean hasW() {
                        return (this.bitField0_ & 1) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public int getW() {
                        return this.w_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setW(int i) {
                        this.bitField0_ |= 1;
                        this.w_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearW() {
                        this.bitField0_ &= -2;
                        this.w_ = 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public boolean hasH() {
                        return (this.bitField0_ & 2) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public int getH() {
                        return this.h_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setH(int i) {
                        this.bitField0_ |= 2;
                        this.h_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearH() {
                        this.bitField0_ &= -3;
                        this.h_ = 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public boolean hasWratio() {
                        return (this.bitField0_ & 4) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public int getWratio() {
                        return this.wratio_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setWratio(int i) {
                        this.bitField0_ |= 4;
                        this.wratio_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearWratio() {
                        this.bitField0_ &= -5;
                        this.wratio_ = 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public boolean hasHratio() {
                        return (this.bitField0_ & 8) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public int getHratio() {
                        return this.hratio_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setHratio(int i) {
                        this.bitField0_ |= 8;
                        this.hratio_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearHratio() {
                        this.bitField0_ &= -9;
                        this.hratio_ = 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public boolean hasWmin() {
                        return (this.bitField0_ & 16) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                    public int getWmin() {
                        return this.wmin_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setWmin(int i) {
                        this.bitField0_ |= 16;
                        this.wmin_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearWmin() {
                        this.bitField0_ &= -17;
                        this.wmin_ = 0;
                    }

                    public static Format parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                    }

                    public static Format parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                    }

                    public static Format parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                    }

                    public static Format parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                    }

                    public static Format parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                    }

                    public static Format parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                    }

                    public static Format parseFrom(InputStream inputStream) throws IOException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static Format parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static Format parseDelimitedFrom(InputStream inputStream) throws IOException {
                        return (Format) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static Format parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Format) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static Format parseFrom(CodedInputStream codedInputStream) throws IOException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                    }

                    public static Format parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Format) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder() {
                        return (Builder) DEFAULT_INSTANCE.createBuilder();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder(Format format) {
                        return (Builder) DEFAULT_INSTANCE.createBuilder(format);
                    }

                    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Format, Builder> implements FormatOrBuilder {
                        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                            this();
                        }

                        private Builder() {
                            super(Format.DEFAULT_INSTANCE);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public boolean hasW() {
                            return ((Format) this.instance).hasW();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public int getW() {
                            return ((Format) this.instance).getW();
                        }

                        public Builder setW(int i) {
                            copyOnWrite();
                            ((Format) this.instance).setW(i);
                            return this;
                        }

                        public Builder clearW() {
                            copyOnWrite();
                            ((Format) this.instance).clearW();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public boolean hasH() {
                            return ((Format) this.instance).hasH();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public int getH() {
                            return ((Format) this.instance).getH();
                        }

                        public Builder setH(int i) {
                            copyOnWrite();
                            ((Format) this.instance).setH(i);
                            return this;
                        }

                        public Builder clearH() {
                            copyOnWrite();
                            ((Format) this.instance).clearH();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public boolean hasWratio() {
                            return ((Format) this.instance).hasWratio();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public int getWratio() {
                            return ((Format) this.instance).getWratio();
                        }

                        public Builder setWratio(int i) {
                            copyOnWrite();
                            ((Format) this.instance).setWratio(i);
                            return this;
                        }

                        public Builder clearWratio() {
                            copyOnWrite();
                            ((Format) this.instance).clearWratio();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public boolean hasHratio() {
                            return ((Format) this.instance).hasHratio();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public int getHratio() {
                            return ((Format) this.instance).getHratio();
                        }

                        public Builder setHratio(int i) {
                            copyOnWrite();
                            ((Format) this.instance).setHratio(i);
                            return this;
                        }

                        public Builder clearHratio() {
                            copyOnWrite();
                            ((Format) this.instance).clearHratio();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public boolean hasWmin() {
                            return ((Format) this.instance).hasWmin();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Banner.FormatOrBuilder
                        public int getWmin() {
                            return ((Format) this.instance).getWmin();
                        }

                        public Builder setWmin(int i) {
                            copyOnWrite();
                            ((Format) this.instance).setWmin(i);
                            return this;
                        }

                        public Builder clearWmin() {
                            copyOnWrite();
                            ((Format) this.instance).clearWmin();
                            return this;
                        }
                    }

                    @Override // com.google.protobuf.GeneratedMessageLite
                    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                        AnonymousClass1 anonymousClass1 = null;
                        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                            case 1:
                                return new Format();
                            case 2:
                                return new Builder(anonymousClass1);
                            case 3:
                                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"bitField0_", "w_", "h_", "wratio_", "hratio_", "wmin_"});
                            case 4:
                                return DEFAULT_INSTANCE;
                            case 5:
                                Parser<Format> defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    synchronized (Format.class) {
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
                                return Byte.valueOf(this.memoizedIsInitialized);
                            case 7:
                                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                return null;
                            default:
                                throw new UnsupportedOperationException();
                        }
                    }

                    static {
                        Format format = new Format();
                        DEFAULT_INSTANCE = format;
                        GeneratedMessageLite.registerDefaultInstance(Format.class, format);
                    }

                    public static Format getDefaultInstance() {
                        return DEFAULT_INSTANCE;
                    }

                    public static Parser<Format> parser() {
                        return DEFAULT_INSTANCE.getParserForType();
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasW() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getW() {
                    return this.w_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setW(int i) {
                    this.bitField0_ |= 1;
                    this.w_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearW() {
                    this.bitField0_ &= -2;
                    this.w_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasH() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getH() {
                    return this.h_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setH(int i) {
                    this.bitField0_ |= 2;
                    this.h_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearH() {
                    this.bitField0_ &= -3;
                    this.h_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<Format> getFormatList() {
                    return this.format_;
                }

                public List<? extends FormatOrBuilder> getFormatOrBuilderList() {
                    return this.format_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getFormatCount() {
                    return this.format_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public Format getFormat(int i) {
                    return this.format_.get(i);
                }

                public FormatOrBuilder getFormatOrBuilder(int i) {
                    return this.format_.get(i);
                }

                private void ensureFormatIsMutable() {
                    Internal.ProtobufList<Format> protobufList = this.format_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.format_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setFormat(int i, Format format) {
                    format.getClass();
                    ensureFormatIsMutable();
                    this.format_.set(i, format);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addFormat(Format format) {
                    format.getClass();
                    ensureFormatIsMutable();
                    this.format_.add(format);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addFormat(int i, Format format) {
                    format.getClass();
                    ensureFormatIsMutable();
                    this.format_.add(i, format);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllFormat(Iterable<? extends Format> iterable) {
                    ensureFormatIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.format_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearFormat() {
                    this.format_ = emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void removeFormat(int i) {
                    ensureFormatIsMutable();
                    this.format_.remove(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasId() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public String getId() {
                    return this.id_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public ByteString getIdBytes() {
                    return ByteString.copyFromUtf8(this.id_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setId(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.id_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearId() {
                    this.bitField0_ &= -5;
                    this.id_ = getDefaultInstance().getId();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setIdBytes(ByteString byteString) {
                    this.id_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasPos() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public AdPosition getPos() {
                    AdPosition adPositionForNumber = AdPosition.forNumber(this.pos_);
                    return adPositionForNumber == null ? AdPosition.UNKNOWN : adPositionForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPos(AdPosition adPosition) {
                    this.pos_ = adPosition.getNumber();
                    this.bitField0_ |= 8;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPos() {
                    this.bitField0_ &= -9;
                    this.pos_ = 0;
                }

                static {
                    Banner banner = new Banner();
                    DEFAULT_INSTANCE = banner;
                    GeneratedMessageLite.registerDefaultInstance(Banner.class, banner);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<BannerAdType> getBtypeList() {
                    return new Internal.ListAdapter(this.btype_, btype_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getBtypeCount() {
                    return this.btype_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public BannerAdType getBtype(int i) {
                    BannerAdType bannerAdTypeForNumber = BannerAdType.forNumber(this.btype_.getInt(i));
                    return bannerAdTypeForNumber == null ? BannerAdType.XHTML_TEXT_AD : bannerAdTypeForNumber;
                }

                private void ensureBtypeIsMutable() {
                    Internal.IntList intList = this.btype_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.btype_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBtype(int i, BannerAdType bannerAdType) {
                    bannerAdType.getClass();
                    ensureBtypeIsMutable();
                    this.btype_.setInt(i, bannerAdType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBtype(BannerAdType bannerAdType) {
                    bannerAdType.getClass();
                    ensureBtypeIsMutable();
                    this.btype_.addInt(bannerAdType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBtype(Iterable<? extends BannerAdType> iterable) {
                    ensureBtypeIsMutable();
                    Iterator<? extends BannerAdType> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.btype_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBtype() {
                    this.btype_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<CreativeAttribute> getBattrList() {
                    return new Internal.ListAdapter(this.battr_, battr_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getBattrCount() {
                    return this.battr_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public CreativeAttribute getBattr(int i) {
                    CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(this.battr_.getInt(i));
                    return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                }

                private void ensureBattrIsMutable() {
                    Internal.IntList intList = this.battr_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.battr_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBattr(int i, CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.setInt(i, creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBattr(CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.addInt(creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                    ensureBattrIsMutable();
                    Iterator<? extends CreativeAttribute> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.battr_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBattr() {
                    this.battr_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<String> getMimesList() {
                    return this.mimes_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getMimesCount() {
                    return this.mimes_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public String getMimes(int i) {
                    return this.mimes_.get(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public ByteString getMimesBytes(int i) {
                    return ByteString.copyFromUtf8(this.mimes_.get(i));
                }

                private void ensureMimesIsMutable() {
                    Internal.ProtobufList<String> protobufList = this.mimes_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.mimes_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMimes(int i, String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.set(i, str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimes(String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.add(str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllMimes(Iterable<String> iterable) {
                    ensureMimesIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.mimes_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMimes() {
                    this.mimes_ = GeneratedMessageLite.emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimesBytes(ByteString byteString) {
                    ensureMimesIsMutable();
                    this.mimes_.add(byteString.toStringUtf8());
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasTopframe() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean getTopframe() {
                    return this.topframe_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setTopframe(boolean z) {
                    this.bitField0_ |= 16;
                    this.topframe_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearTopframe() {
                    this.bitField0_ &= -17;
                    this.topframe_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<ExpandableDirection> getExpdirList() {
                    return new Internal.ListAdapter(this.expdir_, expdir_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getExpdirCount() {
                    return this.expdir_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public ExpandableDirection getExpdir(int i) {
                    ExpandableDirection expandableDirectionForNumber = ExpandableDirection.forNumber(this.expdir_.getInt(i));
                    return expandableDirectionForNumber == null ? ExpandableDirection.LEFT : expandableDirectionForNumber;
                }

                private void ensureExpdirIsMutable() {
                    Internal.IntList intList = this.expdir_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.expdir_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setExpdir(int i, ExpandableDirection expandableDirection) {
                    expandableDirection.getClass();
                    ensureExpdirIsMutable();
                    this.expdir_.setInt(i, expandableDirection.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addExpdir(ExpandableDirection expandableDirection) {
                    expandableDirection.getClass();
                    ensureExpdirIsMutable();
                    this.expdir_.addInt(expandableDirection.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllExpdir(Iterable<? extends ExpandableDirection> iterable) {
                    ensureExpdirIsMutable();
                    Iterator<? extends ExpandableDirection> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.expdir_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearExpdir() {
                    this.expdir_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public List<APIFramework> getApiList() {
                    return new Internal.ListAdapter(this.api_, api_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public int getApiCount() {
                    return this.api_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public APIFramework getApi(int i) {
                    APIFramework aPIFrameworkForNumber = APIFramework.forNumber(this.api_.getInt(i));
                    return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                }

                private void ensureApiIsMutable() {
                    Internal.IntList intList = this.api_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.api_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setApi(int i, APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.setInt(i, aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addApi(APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.addInt(aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllApi(Iterable<? extends APIFramework> iterable) {
                    ensureApiIsMutable();
                    Iterator<? extends APIFramework> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.api_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearApi() {
                    this.api_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean hasVcm() {
                    return (this.bitField0_ & 32) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                public boolean getVcm() {
                    return this.vcm_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setVcm(boolean z) {
                    this.bitField0_ |= 32;
                    this.vcm_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearVcm() {
                    this.bitField0_ &= -33;
                    this.vcm_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public boolean hasWmax() {
                    return (this.bitField0_ & 64) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public int getWmax() {
                    return this.wmax_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setWmax(int i) {
                    this.bitField0_ |= 64;
                    this.wmax_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearWmax() {
                    this.bitField0_ &= -65;
                    this.wmax_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public boolean hasHmax() {
                    return (this.bitField0_ & 128) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public int getHmax() {
                    return this.hmax_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setHmax(int i) {
                    this.bitField0_ |= 128;
                    this.hmax_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearHmax() {
                    this.bitField0_ &= -129;
                    this.hmax_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public boolean hasWmin() {
                    return (this.bitField0_ & 256) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public int getWmin() {
                    return this.wmin_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setWmin(int i) {
                    this.bitField0_ |= 256;
                    this.wmin_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearWmin() {
                    this.bitField0_ &= -257;
                    this.wmin_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public boolean hasHmin() {
                    return (this.bitField0_ & 512) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                @Deprecated
                public int getHmin() {
                    return this.hmin_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setHmin(int i) {
                    this.bitField0_ |= 512;
                    this.hmin_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearHmin() {
                    this.bitField0_ &= -513;
                    this.hmin_ = 0;
                }

                public static Banner parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Banner parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Banner parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Banner parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Banner parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Banner parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Banner parseFrom(InputStream inputStream) throws IOException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Banner parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Banner parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Banner) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Banner parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Banner) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Banner parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Banner parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Banner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Banner banner) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(banner);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Banner, Builder> implements BannerOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Banner.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasW() {
                        return ((Banner) this.instance).hasW();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getW() {
                        return ((Banner) this.instance).getW();
                    }

                    public Builder setW(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setW(i);
                        return this;
                    }

                    public Builder clearW() {
                        copyOnWrite();
                        ((Banner) this.instance).clearW();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasH() {
                        return ((Banner) this.instance).hasH();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getH() {
                        return ((Banner) this.instance).getH();
                    }

                    public Builder setH(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setH(i);
                        return this;
                    }

                    public Builder clearH() {
                        copyOnWrite();
                        ((Banner) this.instance).clearH();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<Format> getFormatList() {
                        return Collections.unmodifiableList(((Banner) this.instance).getFormatList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getFormatCount() {
                        return ((Banner) this.instance).getFormatCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public Format getFormat(int i) {
                        return ((Banner) this.instance).getFormat(i);
                    }

                    public Builder setFormat(int i, Format format) {
                        copyOnWrite();
                        ((Banner) this.instance).setFormat(i, format);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder setFormat(int i, Format.Builder builder) {
                        copyOnWrite();
                        ((Banner) this.instance).setFormat(i, (Format) builder.build());
                        return this;
                    }

                    public Builder addFormat(Format format) {
                        copyOnWrite();
                        ((Banner) this.instance).addFormat(format);
                        return this;
                    }

                    public Builder addFormat(int i, Format format) {
                        copyOnWrite();
                        ((Banner) this.instance).addFormat(i, format);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addFormat(Format.Builder builder) {
                        copyOnWrite();
                        ((Banner) this.instance).addFormat((Format) builder.build());
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addFormat(int i, Format.Builder builder) {
                        copyOnWrite();
                        ((Banner) this.instance).addFormat(i, (Format) builder.build());
                        return this;
                    }

                    public Builder addAllFormat(Iterable<? extends Format> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllFormat(iterable);
                        return this;
                    }

                    public Builder clearFormat() {
                        copyOnWrite();
                        ((Banner) this.instance).clearFormat();
                        return this;
                    }

                    public Builder removeFormat(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).removeFormat(i);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasId() {
                        return ((Banner) this.instance).hasId();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public String getId() {
                        return ((Banner) this.instance).getId();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public ByteString getIdBytes() {
                        return ((Banner) this.instance).getIdBytes();
                    }

                    public Builder setId(String str) {
                        copyOnWrite();
                        ((Banner) this.instance).setId(str);
                        return this;
                    }

                    public Builder clearId() {
                        copyOnWrite();
                        ((Banner) this.instance).clearId();
                        return this;
                    }

                    public Builder setIdBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Banner) this.instance).setIdBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasPos() {
                        return ((Banner) this.instance).hasPos();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public AdPosition getPos() {
                        return ((Banner) this.instance).getPos();
                    }

                    public Builder setPos(AdPosition adPosition) {
                        copyOnWrite();
                        ((Banner) this.instance).setPos(adPosition);
                        return this;
                    }

                    public Builder clearPos() {
                        copyOnWrite();
                        ((Banner) this.instance).clearPos();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<BannerAdType> getBtypeList() {
                        return ((Banner) this.instance).getBtypeList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getBtypeCount() {
                        return ((Banner) this.instance).getBtypeCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public BannerAdType getBtype(int i) {
                        return ((Banner) this.instance).getBtype(i);
                    }

                    public Builder setBtype(int i, BannerAdType bannerAdType) {
                        copyOnWrite();
                        ((Banner) this.instance).setBtype(i, bannerAdType);
                        return this;
                    }

                    public Builder addBtype(BannerAdType bannerAdType) {
                        copyOnWrite();
                        ((Banner) this.instance).addBtype(bannerAdType);
                        return this;
                    }

                    public Builder addAllBtype(Iterable<? extends BannerAdType> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllBtype(iterable);
                        return this;
                    }

                    public Builder clearBtype() {
                        copyOnWrite();
                        ((Banner) this.instance).clearBtype();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<CreativeAttribute> getBattrList() {
                        return ((Banner) this.instance).getBattrList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getBattrCount() {
                        return ((Banner) this.instance).getBattrCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public CreativeAttribute getBattr(int i) {
                        return ((Banner) this.instance).getBattr(i);
                    }

                    public Builder setBattr(int i, CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Banner) this.instance).setBattr(i, creativeAttribute);
                        return this;
                    }

                    public Builder addBattr(CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Banner) this.instance).addBattr(creativeAttribute);
                        return this;
                    }

                    public Builder addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllBattr(iterable);
                        return this;
                    }

                    public Builder clearBattr() {
                        copyOnWrite();
                        ((Banner) this.instance).clearBattr();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<String> getMimesList() {
                        return Collections.unmodifiableList(((Banner) this.instance).getMimesList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getMimesCount() {
                        return ((Banner) this.instance).getMimesCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public String getMimes(int i) {
                        return ((Banner) this.instance).getMimes(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public ByteString getMimesBytes(int i) {
                        return ((Banner) this.instance).getMimesBytes(i);
                    }

                    public Builder setMimes(int i, String str) {
                        copyOnWrite();
                        ((Banner) this.instance).setMimes(i, str);
                        return this;
                    }

                    public Builder addMimes(String str) {
                        copyOnWrite();
                        ((Banner) this.instance).addMimes(str);
                        return this;
                    }

                    public Builder addAllMimes(Iterable<String> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllMimes(iterable);
                        return this;
                    }

                    public Builder clearMimes() {
                        copyOnWrite();
                        ((Banner) this.instance).clearMimes();
                        return this;
                    }

                    public Builder addMimesBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Banner) this.instance).addMimesBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasTopframe() {
                        return ((Banner) this.instance).hasTopframe();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean getTopframe() {
                        return ((Banner) this.instance).getTopframe();
                    }

                    public Builder setTopframe(boolean z) {
                        copyOnWrite();
                        ((Banner) this.instance).setTopframe(z);
                        return this;
                    }

                    public Builder clearTopframe() {
                        copyOnWrite();
                        ((Banner) this.instance).clearTopframe();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<ExpandableDirection> getExpdirList() {
                        return ((Banner) this.instance).getExpdirList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getExpdirCount() {
                        return ((Banner) this.instance).getExpdirCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public ExpandableDirection getExpdir(int i) {
                        return ((Banner) this.instance).getExpdir(i);
                    }

                    public Builder setExpdir(int i, ExpandableDirection expandableDirection) {
                        copyOnWrite();
                        ((Banner) this.instance).setExpdir(i, expandableDirection);
                        return this;
                    }

                    public Builder addExpdir(ExpandableDirection expandableDirection) {
                        copyOnWrite();
                        ((Banner) this.instance).addExpdir(expandableDirection);
                        return this;
                    }

                    public Builder addAllExpdir(Iterable<? extends ExpandableDirection> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllExpdir(iterable);
                        return this;
                    }

                    public Builder clearExpdir() {
                        copyOnWrite();
                        ((Banner) this.instance).clearExpdir();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public List<APIFramework> getApiList() {
                        return ((Banner) this.instance).getApiList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public int getApiCount() {
                        return ((Banner) this.instance).getApiCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public APIFramework getApi(int i) {
                        return ((Banner) this.instance).getApi(i);
                    }

                    public Builder setApi(int i, APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Banner) this.instance).setApi(i, aPIFramework);
                        return this;
                    }

                    public Builder addApi(APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Banner) this.instance).addApi(aPIFramework);
                        return this;
                    }

                    public Builder addAllApi(Iterable<? extends APIFramework> iterable) {
                        copyOnWrite();
                        ((Banner) this.instance).addAllApi(iterable);
                        return this;
                    }

                    public Builder clearApi() {
                        copyOnWrite();
                        ((Banner) this.instance).clearApi();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean hasVcm() {
                        return ((Banner) this.instance).hasVcm();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    public boolean getVcm() {
                        return ((Banner) this.instance).getVcm();
                    }

                    public Builder setVcm(boolean z) {
                        copyOnWrite();
                        ((Banner) this.instance).setVcm(z);
                        return this;
                    }

                    public Builder clearVcm() {
                        copyOnWrite();
                        ((Banner) this.instance).clearVcm();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public boolean hasWmax() {
                        return ((Banner) this.instance).hasWmax();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public int getWmax() {
                        return ((Banner) this.instance).getWmax();
                    }

                    @Deprecated
                    public Builder setWmax(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setWmax(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearWmax() {
                        copyOnWrite();
                        ((Banner) this.instance).clearWmax();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public boolean hasHmax() {
                        return ((Banner) this.instance).hasHmax();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public int getHmax() {
                        return ((Banner) this.instance).getHmax();
                    }

                    @Deprecated
                    public Builder setHmax(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setHmax(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearHmax() {
                        copyOnWrite();
                        ((Banner) this.instance).clearHmax();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public boolean hasWmin() {
                        return ((Banner) this.instance).hasWmin();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public int getWmin() {
                        return ((Banner) this.instance).getWmin();
                    }

                    @Deprecated
                    public Builder setWmin(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setWmin(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearWmin() {
                        copyOnWrite();
                        ((Banner) this.instance).clearWmin();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public boolean hasHmin() {
                        return ((Banner) this.instance).hasHmin();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.BannerOrBuilder
                    @Deprecated
                    public int getHmin() {
                        return ((Banner) this.instance).getHmin();
                    }

                    @Deprecated
                    public Builder setHmin(int i) {
                        copyOnWrite();
                        ((Banner) this.instance).setHmin(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearHmin() {
                        copyOnWrite();
                        ((Banner) this.instance).clearHmin();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Banner();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0006\u0001\u0001င\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဌ\u0003\u0005,\u0006,\u0007\u001a\bဇ\u0004\t,\n,\u000bင\u0006\fင\u0007\rင\b\u000eင\t\u000fЛ\u0010ဇ\u0005", new Object[]{"bitField0_", "w_", "h_", "id_", "pos_", AdPosition.internalGetVerifier(), "btype_", BannerAdType.internalGetVerifier(), "battr_", CreativeAttribute.internalGetVerifier(), "mimes_", "topframe_", "expdir_", ExpandableDirection.internalGetVerifier(), "api_", APIFramework.internalGetVerifier(), "wmax_", "hmax_", "wmin_", "hmin_", "format_", Format.class, "vcm_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Banner> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Banner.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                public static Banner getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Banner> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            public static final class Video extends GeneratedMessageLite.ExtendableMessage<Video, Builder> implements VideoOrBuilder {
                public static final int API_FIELD_NUMBER = 19;
                public static final int BATTR_FIELD_NUMBER = 10;
                public static final int BOXINGALLOWED_FIELD_NUMBER = 14;
                public static final int COMPANIONAD_FIELD_NUMBER = 18;
                public static final int COMPANIONTYPE_FIELD_NUMBER = 20;
                private static final Video DEFAULT_INSTANCE;
                public static final int DELIVERY_FIELD_NUMBER = 16;
                public static final int H_FIELD_NUMBER = 7;
                public static final int LINEARITY_FIELD_NUMBER = 2;
                public static final int MAXBITRATE_FIELD_NUMBER = 13;
                public static final int MAXDURATION_FIELD_NUMBER = 4;
                public static final int MAXEXTENDED_FIELD_NUMBER = 11;
                public static final int MAXSEQ_FIELD_NUMBER = 28;
                public static final int MIMES_FIELD_NUMBER = 1;
                public static final int MINBITRATE_FIELD_NUMBER = 12;
                public static final int MINCPMPERSEC_FIELD_NUMBER = 34;
                public static final int MINDURATION_FIELD_NUMBER = 3;
                private static volatile Parser<Video> PARSER = null;
                public static final int PLACEMENT_FIELD_NUMBER = 26;
                public static final int PLAYBACKEND_FIELD_NUMBER = 27;
                public static final int PLAYBACKMETHOD_FIELD_NUMBER = 15;
                public static final int PODDUR_FIELD_NUMBER = 29;
                public static final int PODID_FIELD_NUMBER = 30;
                public static final int PODSEQ_FIELD_NUMBER = 31;
                public static final int POS_FIELD_NUMBER = 17;
                public static final int PROTOCOLS_FIELD_NUMBER = 21;
                public static final int PROTOCOL_FIELD_NUMBER = 5;
                public static final int RQDDURS_FIELD_NUMBER = 32;
                public static final int SEQUENCE_FIELD_NUMBER = 9;
                public static final int SKIPAFTER_FIELD_NUMBER = 25;
                public static final int SKIPMIN_FIELD_NUMBER = 24;
                public static final int SKIP_FIELD_NUMBER = 23;
                public static final int SLOTINPOD_FIELD_NUMBER = 33;
                public static final int STARTDELAY_FIELD_NUMBER = 8;
                public static final int W_FIELD_NUMBER = 6;
                private int apiMemoizedSerializedSize;
                private int battrMemoizedSerializedSize;
                private int bitField0_;
                private int companiontypeMemoizedSerializedSize;
                private int deliveryMemoizedSerializedSize;
                private int h_;
                private int maxbitrate_;
                private int maxduration_;
                private int maxextended_;
                private int maxseq_;
                private int minbitrate_;
                private double mincpmpersec_;
                private int minduration_;
                private int placement_;
                private int playbackmethodMemoizedSerializedSize;
                private int poddur_;
                private int podseq_;
                private int pos_;
                private int protocolsMemoizedSerializedSize;
                private boolean skip_;
                private int skipafter_;
                private int skipmin_;
                private int slotinpod_;
                private int startdelay_;
                private int w_;
                private static final Internal.ListAdapter.Converter<Integer, Protocol> protocols_converter_ = new Internal.ListAdapter.Converter<Integer, Protocol>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.1
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public Protocol convert(Integer num) {
                        Protocol protocolForNumber = Protocol.forNumber(num.intValue());
                        return protocolForNumber == null ? Protocol.VAST_1_0 : protocolForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CreativeAttribute> battr_converter_ = new Internal.ListAdapter.Converter<Integer, CreativeAttribute>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.2
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CreativeAttribute convert(Integer num) {
                        CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(num.intValue());
                        return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, PlaybackMethod> playbackmethod_converter_ = new Internal.ListAdapter.Converter<Integer, PlaybackMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.3
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public PlaybackMethod convert(Integer num) {
                        PlaybackMethod playbackMethodForNumber = PlaybackMethod.forNumber(num.intValue());
                        return playbackMethodForNumber == null ? PlaybackMethod.AUTO_PLAY_SOUND_ON : playbackMethodForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, ContentDeliveryMethod> delivery_converter_ = new Internal.ListAdapter.Converter<Integer, ContentDeliveryMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.4
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public ContentDeliveryMethod convert(Integer num) {
                        ContentDeliveryMethod contentDeliveryMethodForNumber = ContentDeliveryMethod.forNumber(num.intValue());
                        return contentDeliveryMethodForNumber == null ? ContentDeliveryMethod.STREAMING : contentDeliveryMethodForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, APIFramework> api_converter_ = new Internal.ListAdapter.Converter<Integer, APIFramework>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.5
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public APIFramework convert(Integer num) {
                        APIFramework aPIFrameworkForNumber = APIFramework.forNumber(num.intValue());
                        return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CompanionType> companiontype_converter_ = new Internal.ListAdapter.Converter<Integer, CompanionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.6
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CompanionType convert(Integer num) {
                        CompanionType companionTypeForNumber = CompanionType.forNumber(num.intValue());
                        return companionTypeForNumber == null ? CompanionType.STATIC : companionTypeForNumber;
                    }
                };
                private int rqddursMemoizedSerializedSize = -1;
                private byte memoizedIsInitialized = 2;
                private Internal.ProtobufList<String> mimes_ = GeneratedMessageLite.emptyProtobufList();
                private Internal.IntList protocols_ = emptyIntList();
                private String podid_ = "";
                private Internal.IntList rqddurs_ = emptyIntList();
                private int linearity_ = 1;
                private int sequence_ = 1;
                private Internal.IntList battr_ = emptyIntList();
                private boolean boxingallowed_ = true;
                private Internal.IntList playbackmethod_ = emptyIntList();
                private int playbackend_ = 1;
                private Internal.IntList delivery_ = emptyIntList();
                private Internal.ProtobufList<Banner> companionad_ = emptyProtobufList();
                private Internal.IntList api_ = emptyIntList();
                private Internal.IntList companiontype_ = emptyIntList();
                private int protocol_ = 1;

                private Video() {
                }

                public enum VideoPlacementType implements Internal.EnumLite {
                    UNDEFINED_VIDEO_PLACEMENT(0),
                    IN_STREAM_PLACEMENT(1),
                    IN_BANNER_PLACEMENT(2),
                    IN_ARTICLE_PLACEMENT(3),
                    IN_FEED_PLACEMENT(4),
                    FLOATING_PLACEMENT(5);

                    public static final int FLOATING_PLACEMENT_VALUE = 5;
                    public static final int IN_ARTICLE_PLACEMENT_VALUE = 3;
                    public static final int IN_BANNER_PLACEMENT_VALUE = 2;
                    public static final int IN_FEED_PLACEMENT_VALUE = 4;
                    public static final int IN_STREAM_PLACEMENT_VALUE = 1;
                    public static final int UNDEFINED_VIDEO_PLACEMENT_VALUE = 0;
                    private static final Internal.EnumLiteMap<VideoPlacementType> internalValueMap = new Internal.EnumLiteMap<VideoPlacementType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.VideoPlacementType.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public VideoPlacementType findValueByNumber(int i) {
                            return VideoPlacementType.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static VideoPlacementType valueOf(int i) {
                        return forNumber(i);
                    }

                    public static VideoPlacementType forNumber(int i) {
                        if (i == 0) {
                            return UNDEFINED_VIDEO_PLACEMENT;
                        }
                        if (i == 1) {
                            return IN_STREAM_PLACEMENT;
                        }
                        if (i == 2) {
                            return IN_BANNER_PLACEMENT;
                        }
                        if (i == 3) {
                            return IN_ARTICLE_PLACEMENT;
                        }
                        if (i == 4) {
                            return IN_FEED_PLACEMENT;
                        }
                        if (i != 5) {
                            return null;
                        }
                        return FLOATING_PLACEMENT;
                    }

                    public static Internal.EnumLiteMap<VideoPlacementType> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return VideoPlacementTypeVerifier.INSTANCE;
                    }

                    private static final class VideoPlacementTypeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new VideoPlacementTypeVerifier();

                        private VideoPlacementTypeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return VideoPlacementType.forNumber(i) != null;
                        }
                    }

                    VideoPlacementType(int i) {
                        this.value = i;
                    }
                }

                public enum VideoLinearity implements Internal.EnumLite {
                    LINEAR(1),
                    NON_LINEAR(2);

                    public static final int LINEAR_VALUE = 1;
                    public static final int NON_LINEAR_VALUE = 2;
                    private static final Internal.EnumLiteMap<VideoLinearity> internalValueMap = new Internal.EnumLiteMap<VideoLinearity>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.VideoLinearity.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public VideoLinearity findValueByNumber(int i) {
                            return VideoLinearity.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static VideoLinearity valueOf(int i) {
                        return forNumber(i);
                    }

                    public static VideoLinearity forNumber(int i) {
                        if (i == 1) {
                            return LINEAR;
                        }
                        if (i != 2) {
                            return null;
                        }
                        return NON_LINEAR;
                    }

                    public static Internal.EnumLiteMap<VideoLinearity> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return VideoLinearityVerifier.INSTANCE;
                    }

                    private static final class VideoLinearityVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new VideoLinearityVerifier();

                        private VideoLinearityVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return VideoLinearity.forNumber(i) != null;
                        }
                    }

                    VideoLinearity(int i) {
                        this.value = i;
                    }
                }

                public enum PlaybackMethod implements Internal.EnumLite {
                    AUTO_PLAY_SOUND_ON(1),
                    AUTO_PLAY_SOUND_OFF(2),
                    CLICK_TO_PLAY(3),
                    MOUSE_OVER(4),
                    ENTER_SOUND_ON(5),
                    ENTER_SOUND_OFF(6),
                    CONTINUOUS(7);

                    public static final int AUTO_PLAY_SOUND_OFF_VALUE = 2;
                    public static final int AUTO_PLAY_SOUND_ON_VALUE = 1;
                    public static final int CLICK_TO_PLAY_VALUE = 3;
                    public static final int CONTINUOUS_VALUE = 7;
                    public static final int ENTER_SOUND_OFF_VALUE = 6;
                    public static final int ENTER_SOUND_ON_VALUE = 5;
                    public static final int MOUSE_OVER_VALUE = 4;
                    private static final Internal.EnumLiteMap<PlaybackMethod> internalValueMap = new Internal.EnumLiteMap<PlaybackMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.PlaybackMethod.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public PlaybackMethod findValueByNumber(int i) {
                            return PlaybackMethod.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static PlaybackMethod valueOf(int i) {
                        return forNumber(i);
                    }

                    public static PlaybackMethod forNumber(int i) {
                        switch (i) {
                            case 1:
                                return AUTO_PLAY_SOUND_ON;
                            case 2:
                                return AUTO_PLAY_SOUND_OFF;
                            case 3:
                                return CLICK_TO_PLAY;
                            case 4:
                                return MOUSE_OVER;
                            case 5:
                                return ENTER_SOUND_ON;
                            case 6:
                                return ENTER_SOUND_OFF;
                            case 7:
                                return CONTINUOUS;
                            default:
                                return null;
                        }
                    }

                    public static Internal.EnumLiteMap<PlaybackMethod> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return PlaybackMethodVerifier.INSTANCE;
                    }

                    private static final class PlaybackMethodVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new PlaybackMethodVerifier();

                        private PlaybackMethodVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return PlaybackMethod.forNumber(i) != null;
                        }
                    }

                    PlaybackMethod(int i) {
                        this.value = i;
                    }
                }

                public enum PlaybackCessationMode implements Internal.EnumLite {
                    COMPLETION_OR_USER(1),
                    LEAVING_OR_USER(2),
                    LEAVING_CONTINUES_OR_USER(3);

                    public static final int COMPLETION_OR_USER_VALUE = 1;
                    public static final int LEAVING_CONTINUES_OR_USER_VALUE = 3;
                    public static final int LEAVING_OR_USER_VALUE = 2;
                    private static final Internal.EnumLiteMap<PlaybackCessationMode> internalValueMap = new Internal.EnumLiteMap<PlaybackCessationMode>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Video.PlaybackCessationMode.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public PlaybackCessationMode findValueByNumber(int i) {
                            return PlaybackCessationMode.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static PlaybackCessationMode valueOf(int i) {
                        return forNumber(i);
                    }

                    public static PlaybackCessationMode forNumber(int i) {
                        if (i == 1) {
                            return COMPLETION_OR_USER;
                        }
                        if (i == 2) {
                            return LEAVING_OR_USER;
                        }
                        if (i != 3) {
                            return null;
                        }
                        return LEAVING_CONTINUES_OR_USER;
                    }

                    public static Internal.EnumLiteMap<PlaybackCessationMode> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return PlaybackCessationModeVerifier.INSTANCE;
                    }

                    private static final class PlaybackCessationModeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new PlaybackCessationModeVerifier();

                        private PlaybackCessationModeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return PlaybackCessationMode.forNumber(i) != null;
                        }
                    }

                    PlaybackCessationMode(int i) {
                        this.value = i;
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<String> getMimesList() {
                    return this.mimes_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMimesCount() {
                    return this.mimes_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public String getMimes(int i) {
                    return this.mimes_.get(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public ByteString getMimesBytes(int i) {
                    return ByteString.copyFromUtf8(this.mimes_.get(i));
                }

                private void ensureMimesIsMutable() {
                    Internal.ProtobufList<String> protobufList = this.mimes_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.mimes_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMimes(int i, String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.set(i, str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimes(String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.add(str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllMimes(Iterable<String> iterable) {
                    ensureMimesIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.mimes_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMimes() {
                    this.mimes_ = GeneratedMessageLite.emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimesBytes(ByteString byteString) {
                    ensureMimesIsMutable();
                    this.mimes_.add(byteString.toStringUtf8());
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMinduration() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMinduration() {
                    return this.minduration_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMinduration(int i) {
                    this.bitField0_ |= 1;
                    this.minduration_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMinduration() {
                    this.bitField0_ &= -2;
                    this.minduration_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMaxduration() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMaxduration() {
                    return this.maxduration_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxduration(int i) {
                    this.bitField0_ |= 2;
                    this.maxduration_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxduration() {
                    this.bitField0_ &= -3;
                    this.maxduration_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasStartdelay() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getStartdelay() {
                    return this.startdelay_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setStartdelay(int i) {
                    this.bitField0_ |= 4;
                    this.startdelay_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearStartdelay() {
                    this.bitField0_ &= -5;
                    this.startdelay_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMaxseq() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMaxseq() {
                    return this.maxseq_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxseq(int i) {
                    this.bitField0_ |= 8;
                    this.maxseq_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxseq() {
                    this.bitField0_ &= -9;
                    this.maxseq_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPoddur() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getPoddur() {
                    return this.poddur_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPoddur(int i) {
                    this.bitField0_ |= 16;
                    this.poddur_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPoddur() {
                    this.bitField0_ &= -17;
                    this.poddur_ = 0;
                }

                static {
                    Video video = new Video();
                    DEFAULT_INSTANCE = video;
                    GeneratedMessageLite.registerDefaultInstance(Video.class, video);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<Protocol> getProtocolsList() {
                    return new Internal.ListAdapter(this.protocols_, protocols_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getProtocolsCount() {
                    return this.protocols_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public Protocol getProtocols(int i) {
                    Protocol protocolForNumber = Protocol.forNumber(this.protocols_.getInt(i));
                    return protocolForNumber == null ? Protocol.VAST_1_0 : protocolForNumber;
                }

                private void ensureProtocolsIsMutable() {
                    Internal.IntList intList = this.protocols_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.protocols_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setProtocols(int i, Protocol protocol) {
                    protocol.getClass();
                    ensureProtocolsIsMutable();
                    this.protocols_.setInt(i, protocol.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addProtocols(Protocol protocol) {
                    protocol.getClass();
                    ensureProtocolsIsMutable();
                    this.protocols_.addInt(protocol.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllProtocols(Iterable<? extends Protocol> iterable) {
                    ensureProtocolsIsMutable();
                    Iterator<? extends Protocol> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.protocols_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearProtocols() {
                    this.protocols_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasW() {
                    return (this.bitField0_ & 32) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getW() {
                    return this.w_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setW(int i) {
                    this.bitField0_ |= 32;
                    this.w_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearW() {
                    this.bitField0_ &= -33;
                    this.w_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasH() {
                    return (this.bitField0_ & 64) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getH() {
                    return this.h_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setH(int i) {
                    this.bitField0_ |= 64;
                    this.h_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearH() {
                    this.bitField0_ &= -65;
                    this.h_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPodid() {
                    return (this.bitField0_ & 128) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public String getPodid() {
                    return this.podid_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public ByteString getPodidBytes() {
                    return ByteString.copyFromUtf8(this.podid_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodid(String str) {
                    str.getClass();
                    this.bitField0_ |= 128;
                    this.podid_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPodid() {
                    this.bitField0_ &= -129;
                    this.podid_ = getDefaultInstance().getPodid();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodidBytes(ByteString byteString) {
                    this.podid_ = byteString.toStringUtf8();
                    this.bitField0_ |= 128;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPodseq() {
                    return (this.bitField0_ & 256) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public PodSequence getPodseq() {
                    PodSequence podSequenceForNumber = PodSequence.forNumber(this.podseq_);
                    return podSequenceForNumber == null ? PodSequence.POD_SEQUENCE_ANY : podSequenceForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodseq(PodSequence podSequence) {
                    this.podseq_ = podSequence.getNumber();
                    this.bitField0_ |= 256;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPodseq() {
                    this.bitField0_ &= -257;
                    this.podseq_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<Integer> getRqddursList() {
                    return this.rqddurs_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getRqddursCount() {
                    return this.rqddurs_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getRqddurs(int i) {
                    return this.rqddurs_.getInt(i);
                }

                private void ensureRqddursIsMutable() {
                    Internal.IntList intList = this.rqddurs_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.rqddurs_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRqddurs(int i, int i2) {
                    ensureRqddursIsMutable();
                    this.rqddurs_.setInt(i, i2);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addRqddurs(int i) {
                    ensureRqddursIsMutable();
                    this.rqddurs_.addInt(i);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllRqddurs(Iterable<? extends Integer> iterable) {
                    ensureRqddursIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.rqddurs_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRqddurs() {
                    this.rqddurs_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPlacement() {
                    return (this.bitField0_ & 512) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public VideoPlacementType getPlacement() {
                    VideoPlacementType videoPlacementTypeForNumber = VideoPlacementType.forNumber(this.placement_);
                    return videoPlacementTypeForNumber == null ? VideoPlacementType.UNDEFINED_VIDEO_PLACEMENT : videoPlacementTypeForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPlacement(VideoPlacementType videoPlacementType) {
                    this.placement_ = videoPlacementType.getNumber();
                    this.bitField0_ |= 512;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPlacement() {
                    this.bitField0_ &= -513;
                    this.placement_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasLinearity() {
                    return (this.bitField0_ & 1024) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public VideoLinearity getLinearity() {
                    VideoLinearity videoLinearityForNumber = VideoLinearity.forNumber(this.linearity_);
                    return videoLinearityForNumber == null ? VideoLinearity.LINEAR : videoLinearityForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setLinearity(VideoLinearity videoLinearity) {
                    this.linearity_ = videoLinearity.getNumber();
                    this.bitField0_ |= 1024;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearLinearity() {
                    this.bitField0_ &= -1025;
                    this.linearity_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasSkip() {
                    return (this.bitField0_ & 2048) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean getSkip() {
                    return this.skip_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSkip(boolean z) {
                    this.bitField0_ |= 2048;
                    this.skip_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSkip() {
                    this.bitField0_ &= -2049;
                    this.skip_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasSkipmin() {
                    return (this.bitField0_ & 4096) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getSkipmin() {
                    return this.skipmin_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSkipmin(int i) {
                    this.bitField0_ |= 4096;
                    this.skipmin_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSkipmin() {
                    this.bitField0_ &= -4097;
                    this.skipmin_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasSkipafter() {
                    return (this.bitField0_ & 8192) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getSkipafter() {
                    return this.skipafter_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSkipafter(int i) {
                    this.bitField0_ |= 8192;
                    this.skipafter_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSkipafter() {
                    this.bitField0_ &= -8193;
                    this.skipafter_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                @Deprecated
                public boolean hasSequence() {
                    return (this.bitField0_ & 16384) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                @Deprecated
                public int getSequence() {
                    return this.sequence_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSequence(int i) {
                    this.bitField0_ |= 16384;
                    this.sequence_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSequence() {
                    this.bitField0_ &= -16385;
                    this.sequence_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasSlotinpod() {
                    return (this.bitField0_ & 32768) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public SlotPositionInPod getSlotinpod() {
                    SlotPositionInPod slotPositionInPodForNumber = SlotPositionInPod.forNumber(this.slotinpod_);
                    return slotPositionInPodForNumber == null ? SlotPositionInPod.SLOT_POSITION_POD_ANY : slotPositionInPodForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSlotinpod(SlotPositionInPod slotPositionInPod) {
                    this.slotinpod_ = slotPositionInPod.getNumber();
                    this.bitField0_ |= 32768;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSlotinpod() {
                    this.bitField0_ &= -32769;
                    this.slotinpod_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMincpmpersec() {
                    return (this.bitField0_ & 65536) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public double getMincpmpersec() {
                    return this.mincpmpersec_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMincpmpersec(double d) {
                    this.bitField0_ |= 65536;
                    this.mincpmpersec_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMincpmpersec() {
                    this.bitField0_ &= -65537;
                    this.mincpmpersec_ = 0.0d;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<CreativeAttribute> getBattrList() {
                    return new Internal.ListAdapter(this.battr_, battr_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getBattrCount() {
                    return this.battr_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public CreativeAttribute getBattr(int i) {
                    CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(this.battr_.getInt(i));
                    return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                }

                private void ensureBattrIsMutable() {
                    Internal.IntList intList = this.battr_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.battr_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBattr(int i, CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.setInt(i, creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBattr(CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.addInt(creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                    ensureBattrIsMutable();
                    Iterator<? extends CreativeAttribute> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.battr_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBattr() {
                    this.battr_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMaxextended() {
                    return (this.bitField0_ & 131072) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMaxextended() {
                    return this.maxextended_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxextended(int i) {
                    this.bitField0_ |= 131072;
                    this.maxextended_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxextended() {
                    this.bitField0_ &= -131073;
                    this.maxextended_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMinbitrate() {
                    return (this.bitField0_ & 262144) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMinbitrate() {
                    return this.minbitrate_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMinbitrate(int i) {
                    this.bitField0_ |= 262144;
                    this.minbitrate_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMinbitrate() {
                    this.bitField0_ &= -262145;
                    this.minbitrate_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasMaxbitrate() {
                    return (this.bitField0_ & 524288) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getMaxbitrate() {
                    return this.maxbitrate_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxbitrate(int i) {
                    this.bitField0_ |= 524288;
                    this.maxbitrate_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxbitrate() {
                    this.bitField0_ &= -524289;
                    this.maxbitrate_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasBoxingallowed() {
                    return (this.bitField0_ & 1048576) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean getBoxingallowed() {
                    return this.boxingallowed_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBoxingallowed(boolean z) {
                    this.bitField0_ |= 1048576;
                    this.boxingallowed_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBoxingallowed() {
                    this.bitField0_ &= -1048577;
                    this.boxingallowed_ = true;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<PlaybackMethod> getPlaybackmethodList() {
                    return new Internal.ListAdapter(this.playbackmethod_, playbackmethod_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getPlaybackmethodCount() {
                    return this.playbackmethod_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public PlaybackMethod getPlaybackmethod(int i) {
                    PlaybackMethod playbackMethodForNumber = PlaybackMethod.forNumber(this.playbackmethod_.getInt(i));
                    return playbackMethodForNumber == null ? PlaybackMethod.AUTO_PLAY_SOUND_ON : playbackMethodForNumber;
                }

                private void ensurePlaybackmethodIsMutable() {
                    Internal.IntList intList = this.playbackmethod_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.playbackmethod_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPlaybackmethod(int i, PlaybackMethod playbackMethod) {
                    playbackMethod.getClass();
                    ensurePlaybackmethodIsMutable();
                    this.playbackmethod_.setInt(i, playbackMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addPlaybackmethod(PlaybackMethod playbackMethod) {
                    playbackMethod.getClass();
                    ensurePlaybackmethodIsMutable();
                    this.playbackmethod_.addInt(playbackMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllPlaybackmethod(Iterable<? extends PlaybackMethod> iterable) {
                    ensurePlaybackmethodIsMutable();
                    Iterator<? extends PlaybackMethod> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.playbackmethod_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPlaybackmethod() {
                    this.playbackmethod_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPlaybackend() {
                    return (this.bitField0_ & 2097152) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public PlaybackCessationMode getPlaybackend() {
                    PlaybackCessationMode playbackCessationModeForNumber = PlaybackCessationMode.forNumber(this.playbackend_);
                    return playbackCessationModeForNumber == null ? PlaybackCessationMode.COMPLETION_OR_USER : playbackCessationModeForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPlaybackend(PlaybackCessationMode playbackCessationMode) {
                    this.playbackend_ = playbackCessationMode.getNumber();
                    this.bitField0_ |= 2097152;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPlaybackend() {
                    this.bitField0_ &= -2097153;
                    this.playbackend_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<ContentDeliveryMethod> getDeliveryList() {
                    return new Internal.ListAdapter(this.delivery_, delivery_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getDeliveryCount() {
                    return this.delivery_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public ContentDeliveryMethod getDelivery(int i) {
                    ContentDeliveryMethod contentDeliveryMethodForNumber = ContentDeliveryMethod.forNumber(this.delivery_.getInt(i));
                    return contentDeliveryMethodForNumber == null ? ContentDeliveryMethod.STREAMING : contentDeliveryMethodForNumber;
                }

                private void ensureDeliveryIsMutable() {
                    Internal.IntList intList = this.delivery_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.delivery_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setDelivery(int i, ContentDeliveryMethod contentDeliveryMethod) {
                    contentDeliveryMethod.getClass();
                    ensureDeliveryIsMutable();
                    this.delivery_.setInt(i, contentDeliveryMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addDelivery(ContentDeliveryMethod contentDeliveryMethod) {
                    contentDeliveryMethod.getClass();
                    ensureDeliveryIsMutable();
                    this.delivery_.addInt(contentDeliveryMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllDelivery(Iterable<? extends ContentDeliveryMethod> iterable) {
                    ensureDeliveryIsMutable();
                    Iterator<? extends ContentDeliveryMethod> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.delivery_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearDelivery() {
                    this.delivery_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public boolean hasPos() {
                    return (this.bitField0_ & 4194304) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public AdPosition getPos() {
                    AdPosition adPositionForNumber = AdPosition.forNumber(this.pos_);
                    return adPositionForNumber == null ? AdPosition.UNKNOWN : adPositionForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPos(AdPosition adPosition) {
                    this.pos_ = adPosition.getNumber();
                    this.bitField0_ |= 4194304;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPos() {
                    this.bitField0_ &= -4194305;
                    this.pos_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<Banner> getCompanionadList() {
                    return this.companionad_;
                }

                public List<? extends BannerOrBuilder> getCompanionadOrBuilderList() {
                    return this.companionad_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getCompanionadCount() {
                    return this.companionad_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public Banner getCompanionad(int i) {
                    return this.companionad_.get(i);
                }

                public BannerOrBuilder getCompanionadOrBuilder(int i) {
                    return this.companionad_.get(i);
                }

                private void ensureCompanionadIsMutable() {
                    Internal.ProtobufList<Banner> protobufList = this.companionad_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.companionad_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCompanionad(int i, Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.set(i, banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompanionad(Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.add(banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompanionad(int i, Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.add(i, banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllCompanionad(Iterable<? extends Banner> iterable) {
                    ensureCompanionadIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.companionad_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCompanionad() {
                    this.companionad_ = emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void removeCompanionad(int i) {
                    ensureCompanionadIsMutable();
                    this.companionad_.remove(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<APIFramework> getApiList() {
                    return new Internal.ListAdapter(this.api_, api_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getApiCount() {
                    return this.api_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public APIFramework getApi(int i) {
                    APIFramework aPIFrameworkForNumber = APIFramework.forNumber(this.api_.getInt(i));
                    return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                }

                private void ensureApiIsMutable() {
                    Internal.IntList intList = this.api_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.api_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setApi(int i, APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.setInt(i, aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addApi(APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.addInt(aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllApi(Iterable<? extends APIFramework> iterable) {
                    ensureApiIsMutable();
                    Iterator<? extends APIFramework> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.api_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearApi() {
                    this.api_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public List<CompanionType> getCompaniontypeList() {
                    return new Internal.ListAdapter(this.companiontype_, companiontype_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public int getCompaniontypeCount() {
                    return this.companiontype_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                public CompanionType getCompaniontype(int i) {
                    CompanionType companionTypeForNumber = CompanionType.forNumber(this.companiontype_.getInt(i));
                    return companionTypeForNumber == null ? CompanionType.STATIC : companionTypeForNumber;
                }

                private void ensureCompaniontypeIsMutable() {
                    Internal.IntList intList = this.companiontype_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.companiontype_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCompaniontype(int i, CompanionType companionType) {
                    companionType.getClass();
                    ensureCompaniontypeIsMutable();
                    this.companiontype_.setInt(i, companionType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompaniontype(CompanionType companionType) {
                    companionType.getClass();
                    ensureCompaniontypeIsMutable();
                    this.companiontype_.addInt(companionType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllCompaniontype(Iterable<? extends CompanionType> iterable) {
                    ensureCompaniontypeIsMutable();
                    Iterator<? extends CompanionType> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.companiontype_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCompaniontype() {
                    this.companiontype_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                @Deprecated
                public boolean hasProtocol() {
                    return (this.bitField0_ & 8388608) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                @Deprecated
                public Protocol getProtocol() {
                    Protocol protocolForNumber = Protocol.forNumber(this.protocol_);
                    return protocolForNumber == null ? Protocol.VAST_1_0 : protocolForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setProtocol(Protocol protocol) {
                    this.protocol_ = protocol.getNumber();
                    this.bitField0_ |= 8388608;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearProtocol() {
                    this.bitField0_ &= -8388609;
                    this.protocol_ = 1;
                }

                public static Video parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Video parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Video parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Video parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Video parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Video parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Video parseFrom(InputStream inputStream) throws IOException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Video parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Video parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Video) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Video parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Video) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Video parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Video parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Video) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Video video) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(video);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Video, Builder> implements VideoOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Video.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<String> getMimesList() {
                        return Collections.unmodifiableList(((Video) this.instance).getMimesList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMimesCount() {
                        return ((Video) this.instance).getMimesCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public String getMimes(int i) {
                        return ((Video) this.instance).getMimes(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public ByteString getMimesBytes(int i) {
                        return ((Video) this.instance).getMimesBytes(i);
                    }

                    public Builder setMimes(int i, String str) {
                        copyOnWrite();
                        ((Video) this.instance).setMimes(i, str);
                        return this;
                    }

                    public Builder addMimes(String str) {
                        copyOnWrite();
                        ((Video) this.instance).addMimes(str);
                        return this;
                    }

                    public Builder addAllMimes(Iterable<String> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllMimes(iterable);
                        return this;
                    }

                    public Builder clearMimes() {
                        copyOnWrite();
                        ((Video) this.instance).clearMimes();
                        return this;
                    }

                    public Builder addMimesBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Video) this.instance).addMimesBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMinduration() {
                        return ((Video) this.instance).hasMinduration();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMinduration() {
                        return ((Video) this.instance).getMinduration();
                    }

                    public Builder setMinduration(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMinduration(i);
                        return this;
                    }

                    public Builder clearMinduration() {
                        copyOnWrite();
                        ((Video) this.instance).clearMinduration();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMaxduration() {
                        return ((Video) this.instance).hasMaxduration();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMaxduration() {
                        return ((Video) this.instance).getMaxduration();
                    }

                    public Builder setMaxduration(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMaxduration(i);
                        return this;
                    }

                    public Builder clearMaxduration() {
                        copyOnWrite();
                        ((Video) this.instance).clearMaxduration();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasStartdelay() {
                        return ((Video) this.instance).hasStartdelay();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getStartdelay() {
                        return ((Video) this.instance).getStartdelay();
                    }

                    public Builder setStartdelay(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setStartdelay(i);
                        return this;
                    }

                    public Builder clearStartdelay() {
                        copyOnWrite();
                        ((Video) this.instance).clearStartdelay();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMaxseq() {
                        return ((Video) this.instance).hasMaxseq();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMaxseq() {
                        return ((Video) this.instance).getMaxseq();
                    }

                    public Builder setMaxseq(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMaxseq(i);
                        return this;
                    }

                    public Builder clearMaxseq() {
                        copyOnWrite();
                        ((Video) this.instance).clearMaxseq();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPoddur() {
                        return ((Video) this.instance).hasPoddur();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getPoddur() {
                        return ((Video) this.instance).getPoddur();
                    }

                    public Builder setPoddur(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setPoddur(i);
                        return this;
                    }

                    public Builder clearPoddur() {
                        copyOnWrite();
                        ((Video) this.instance).clearPoddur();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<Protocol> getProtocolsList() {
                        return ((Video) this.instance).getProtocolsList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getProtocolsCount() {
                        return ((Video) this.instance).getProtocolsCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public Protocol getProtocols(int i) {
                        return ((Video) this.instance).getProtocols(i);
                    }

                    public Builder setProtocols(int i, Protocol protocol) {
                        copyOnWrite();
                        ((Video) this.instance).setProtocols(i, protocol);
                        return this;
                    }

                    public Builder addProtocols(Protocol protocol) {
                        copyOnWrite();
                        ((Video) this.instance).addProtocols(protocol);
                        return this;
                    }

                    public Builder addAllProtocols(Iterable<? extends Protocol> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllProtocols(iterable);
                        return this;
                    }

                    public Builder clearProtocols() {
                        copyOnWrite();
                        ((Video) this.instance).clearProtocols();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasW() {
                        return ((Video) this.instance).hasW();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getW() {
                        return ((Video) this.instance).getW();
                    }

                    public Builder setW(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setW(i);
                        return this;
                    }

                    public Builder clearW() {
                        copyOnWrite();
                        ((Video) this.instance).clearW();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasH() {
                        return ((Video) this.instance).hasH();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getH() {
                        return ((Video) this.instance).getH();
                    }

                    public Builder setH(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setH(i);
                        return this;
                    }

                    public Builder clearH() {
                        copyOnWrite();
                        ((Video) this.instance).clearH();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPodid() {
                        return ((Video) this.instance).hasPodid();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public String getPodid() {
                        return ((Video) this.instance).getPodid();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public ByteString getPodidBytes() {
                        return ((Video) this.instance).getPodidBytes();
                    }

                    public Builder setPodid(String str) {
                        copyOnWrite();
                        ((Video) this.instance).setPodid(str);
                        return this;
                    }

                    public Builder clearPodid() {
                        copyOnWrite();
                        ((Video) this.instance).clearPodid();
                        return this;
                    }

                    public Builder setPodidBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Video) this.instance).setPodidBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPodseq() {
                        return ((Video) this.instance).hasPodseq();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public PodSequence getPodseq() {
                        return ((Video) this.instance).getPodseq();
                    }

                    public Builder setPodseq(PodSequence podSequence) {
                        copyOnWrite();
                        ((Video) this.instance).setPodseq(podSequence);
                        return this;
                    }

                    public Builder clearPodseq() {
                        copyOnWrite();
                        ((Video) this.instance).clearPodseq();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<Integer> getRqddursList() {
                        return Collections.unmodifiableList(((Video) this.instance).getRqddursList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getRqddursCount() {
                        return ((Video) this.instance).getRqddursCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getRqddurs(int i) {
                        return ((Video) this.instance).getRqddurs(i);
                    }

                    public Builder setRqddurs(int i, int i2) {
                        copyOnWrite();
                        ((Video) this.instance).setRqddurs(i, i2);
                        return this;
                    }

                    public Builder addRqddurs(int i) {
                        copyOnWrite();
                        ((Video) this.instance).addRqddurs(i);
                        return this;
                    }

                    public Builder addAllRqddurs(Iterable<? extends Integer> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllRqddurs(iterable);
                        return this;
                    }

                    public Builder clearRqddurs() {
                        copyOnWrite();
                        ((Video) this.instance).clearRqddurs();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPlacement() {
                        return ((Video) this.instance).hasPlacement();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public VideoPlacementType getPlacement() {
                        return ((Video) this.instance).getPlacement();
                    }

                    public Builder setPlacement(VideoPlacementType videoPlacementType) {
                        copyOnWrite();
                        ((Video) this.instance).setPlacement(videoPlacementType);
                        return this;
                    }

                    public Builder clearPlacement() {
                        copyOnWrite();
                        ((Video) this.instance).clearPlacement();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasLinearity() {
                        return ((Video) this.instance).hasLinearity();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public VideoLinearity getLinearity() {
                        return ((Video) this.instance).getLinearity();
                    }

                    public Builder setLinearity(VideoLinearity videoLinearity) {
                        copyOnWrite();
                        ((Video) this.instance).setLinearity(videoLinearity);
                        return this;
                    }

                    public Builder clearLinearity() {
                        copyOnWrite();
                        ((Video) this.instance).clearLinearity();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasSkip() {
                        return ((Video) this.instance).hasSkip();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean getSkip() {
                        return ((Video) this.instance).getSkip();
                    }

                    public Builder setSkip(boolean z) {
                        copyOnWrite();
                        ((Video) this.instance).setSkip(z);
                        return this;
                    }

                    public Builder clearSkip() {
                        copyOnWrite();
                        ((Video) this.instance).clearSkip();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasSkipmin() {
                        return ((Video) this.instance).hasSkipmin();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getSkipmin() {
                        return ((Video) this.instance).getSkipmin();
                    }

                    public Builder setSkipmin(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setSkipmin(i);
                        return this;
                    }

                    public Builder clearSkipmin() {
                        copyOnWrite();
                        ((Video) this.instance).clearSkipmin();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasSkipafter() {
                        return ((Video) this.instance).hasSkipafter();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getSkipafter() {
                        return ((Video) this.instance).getSkipafter();
                    }

                    public Builder setSkipafter(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setSkipafter(i);
                        return this;
                    }

                    public Builder clearSkipafter() {
                        copyOnWrite();
                        ((Video) this.instance).clearSkipafter();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    @Deprecated
                    public boolean hasSequence() {
                        return ((Video) this.instance).hasSequence();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    @Deprecated
                    public int getSequence() {
                        return ((Video) this.instance).getSequence();
                    }

                    @Deprecated
                    public Builder setSequence(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setSequence(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearSequence() {
                        copyOnWrite();
                        ((Video) this.instance).clearSequence();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasSlotinpod() {
                        return ((Video) this.instance).hasSlotinpod();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public SlotPositionInPod getSlotinpod() {
                        return ((Video) this.instance).getSlotinpod();
                    }

                    public Builder setSlotinpod(SlotPositionInPod slotPositionInPod) {
                        copyOnWrite();
                        ((Video) this.instance).setSlotinpod(slotPositionInPod);
                        return this;
                    }

                    public Builder clearSlotinpod() {
                        copyOnWrite();
                        ((Video) this.instance).clearSlotinpod();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMincpmpersec() {
                        return ((Video) this.instance).hasMincpmpersec();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public double getMincpmpersec() {
                        return ((Video) this.instance).getMincpmpersec();
                    }

                    public Builder setMincpmpersec(double d) {
                        copyOnWrite();
                        ((Video) this.instance).setMincpmpersec(d);
                        return this;
                    }

                    public Builder clearMincpmpersec() {
                        copyOnWrite();
                        ((Video) this.instance).clearMincpmpersec();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<CreativeAttribute> getBattrList() {
                        return ((Video) this.instance).getBattrList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getBattrCount() {
                        return ((Video) this.instance).getBattrCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public CreativeAttribute getBattr(int i) {
                        return ((Video) this.instance).getBattr(i);
                    }

                    public Builder setBattr(int i, CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Video) this.instance).setBattr(i, creativeAttribute);
                        return this;
                    }

                    public Builder addBattr(CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Video) this.instance).addBattr(creativeAttribute);
                        return this;
                    }

                    public Builder addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllBattr(iterable);
                        return this;
                    }

                    public Builder clearBattr() {
                        copyOnWrite();
                        ((Video) this.instance).clearBattr();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMaxextended() {
                        return ((Video) this.instance).hasMaxextended();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMaxextended() {
                        return ((Video) this.instance).getMaxextended();
                    }

                    public Builder setMaxextended(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMaxextended(i);
                        return this;
                    }

                    public Builder clearMaxextended() {
                        copyOnWrite();
                        ((Video) this.instance).clearMaxextended();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMinbitrate() {
                        return ((Video) this.instance).hasMinbitrate();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMinbitrate() {
                        return ((Video) this.instance).getMinbitrate();
                    }

                    public Builder setMinbitrate(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMinbitrate(i);
                        return this;
                    }

                    public Builder clearMinbitrate() {
                        copyOnWrite();
                        ((Video) this.instance).clearMinbitrate();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasMaxbitrate() {
                        return ((Video) this.instance).hasMaxbitrate();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getMaxbitrate() {
                        return ((Video) this.instance).getMaxbitrate();
                    }

                    public Builder setMaxbitrate(int i) {
                        copyOnWrite();
                        ((Video) this.instance).setMaxbitrate(i);
                        return this;
                    }

                    public Builder clearMaxbitrate() {
                        copyOnWrite();
                        ((Video) this.instance).clearMaxbitrate();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasBoxingallowed() {
                        return ((Video) this.instance).hasBoxingallowed();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean getBoxingallowed() {
                        return ((Video) this.instance).getBoxingallowed();
                    }

                    public Builder setBoxingallowed(boolean z) {
                        copyOnWrite();
                        ((Video) this.instance).setBoxingallowed(z);
                        return this;
                    }

                    public Builder clearBoxingallowed() {
                        copyOnWrite();
                        ((Video) this.instance).clearBoxingallowed();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<PlaybackMethod> getPlaybackmethodList() {
                        return ((Video) this.instance).getPlaybackmethodList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getPlaybackmethodCount() {
                        return ((Video) this.instance).getPlaybackmethodCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public PlaybackMethod getPlaybackmethod(int i) {
                        return ((Video) this.instance).getPlaybackmethod(i);
                    }

                    public Builder setPlaybackmethod(int i, PlaybackMethod playbackMethod) {
                        copyOnWrite();
                        ((Video) this.instance).setPlaybackmethod(i, playbackMethod);
                        return this;
                    }

                    public Builder addPlaybackmethod(PlaybackMethod playbackMethod) {
                        copyOnWrite();
                        ((Video) this.instance).addPlaybackmethod(playbackMethod);
                        return this;
                    }

                    public Builder addAllPlaybackmethod(Iterable<? extends PlaybackMethod> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllPlaybackmethod(iterable);
                        return this;
                    }

                    public Builder clearPlaybackmethod() {
                        copyOnWrite();
                        ((Video) this.instance).clearPlaybackmethod();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPlaybackend() {
                        return ((Video) this.instance).hasPlaybackend();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public PlaybackCessationMode getPlaybackend() {
                        return ((Video) this.instance).getPlaybackend();
                    }

                    public Builder setPlaybackend(PlaybackCessationMode playbackCessationMode) {
                        copyOnWrite();
                        ((Video) this.instance).setPlaybackend(playbackCessationMode);
                        return this;
                    }

                    public Builder clearPlaybackend() {
                        copyOnWrite();
                        ((Video) this.instance).clearPlaybackend();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<ContentDeliveryMethod> getDeliveryList() {
                        return ((Video) this.instance).getDeliveryList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getDeliveryCount() {
                        return ((Video) this.instance).getDeliveryCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public ContentDeliveryMethod getDelivery(int i) {
                        return ((Video) this.instance).getDelivery(i);
                    }

                    public Builder setDelivery(int i, ContentDeliveryMethod contentDeliveryMethod) {
                        copyOnWrite();
                        ((Video) this.instance).setDelivery(i, contentDeliveryMethod);
                        return this;
                    }

                    public Builder addDelivery(ContentDeliveryMethod contentDeliveryMethod) {
                        copyOnWrite();
                        ((Video) this.instance).addDelivery(contentDeliveryMethod);
                        return this;
                    }

                    public Builder addAllDelivery(Iterable<? extends ContentDeliveryMethod> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllDelivery(iterable);
                        return this;
                    }

                    public Builder clearDelivery() {
                        copyOnWrite();
                        ((Video) this.instance).clearDelivery();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public boolean hasPos() {
                        return ((Video) this.instance).hasPos();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public AdPosition getPos() {
                        return ((Video) this.instance).getPos();
                    }

                    public Builder setPos(AdPosition adPosition) {
                        copyOnWrite();
                        ((Video) this.instance).setPos(adPosition);
                        return this;
                    }

                    public Builder clearPos() {
                        copyOnWrite();
                        ((Video) this.instance).clearPos();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<Banner> getCompanionadList() {
                        return Collections.unmodifiableList(((Video) this.instance).getCompanionadList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getCompanionadCount() {
                        return ((Video) this.instance).getCompanionadCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public Banner getCompanionad(int i) {
                        return ((Video) this.instance).getCompanionad(i);
                    }

                    public Builder setCompanionad(int i, Banner banner) {
                        copyOnWrite();
                        ((Video) this.instance).setCompanionad(i, banner);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder setCompanionad(int i, Banner.Builder builder) {
                        copyOnWrite();
                        ((Video) this.instance).setCompanionad(i, (Banner) builder.build());
                        return this;
                    }

                    public Builder addCompanionad(Banner banner) {
                        copyOnWrite();
                        ((Video) this.instance).addCompanionad(banner);
                        return this;
                    }

                    public Builder addCompanionad(int i, Banner banner) {
                        copyOnWrite();
                        ((Video) this.instance).addCompanionad(i, banner);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addCompanionad(Banner.Builder builder) {
                        copyOnWrite();
                        ((Video) this.instance).addCompanionad((Banner) builder.build());
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addCompanionad(int i, Banner.Builder builder) {
                        copyOnWrite();
                        ((Video) this.instance).addCompanionad(i, (Banner) builder.build());
                        return this;
                    }

                    public Builder addAllCompanionad(Iterable<? extends Banner> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllCompanionad(iterable);
                        return this;
                    }

                    public Builder clearCompanionad() {
                        copyOnWrite();
                        ((Video) this.instance).clearCompanionad();
                        return this;
                    }

                    public Builder removeCompanionad(int i) {
                        copyOnWrite();
                        ((Video) this.instance).removeCompanionad(i);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<APIFramework> getApiList() {
                        return ((Video) this.instance).getApiList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getApiCount() {
                        return ((Video) this.instance).getApiCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public APIFramework getApi(int i) {
                        return ((Video) this.instance).getApi(i);
                    }

                    public Builder setApi(int i, APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Video) this.instance).setApi(i, aPIFramework);
                        return this;
                    }

                    public Builder addApi(APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Video) this.instance).addApi(aPIFramework);
                        return this;
                    }

                    public Builder addAllApi(Iterable<? extends APIFramework> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllApi(iterable);
                        return this;
                    }

                    public Builder clearApi() {
                        copyOnWrite();
                        ((Video) this.instance).clearApi();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public List<CompanionType> getCompaniontypeList() {
                        return ((Video) this.instance).getCompaniontypeList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public int getCompaniontypeCount() {
                        return ((Video) this.instance).getCompaniontypeCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    public CompanionType getCompaniontype(int i) {
                        return ((Video) this.instance).getCompaniontype(i);
                    }

                    public Builder setCompaniontype(int i, CompanionType companionType) {
                        copyOnWrite();
                        ((Video) this.instance).setCompaniontype(i, companionType);
                        return this;
                    }

                    public Builder addCompaniontype(CompanionType companionType) {
                        copyOnWrite();
                        ((Video) this.instance).addCompaniontype(companionType);
                        return this;
                    }

                    public Builder addAllCompaniontype(Iterable<? extends CompanionType> iterable) {
                        copyOnWrite();
                        ((Video) this.instance).addAllCompaniontype(iterable);
                        return this;
                    }

                    public Builder clearCompaniontype() {
                        copyOnWrite();
                        ((Video) this.instance).clearCompaniontype();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    @Deprecated
                    public boolean hasProtocol() {
                        return ((Video) this.instance).hasProtocol();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.VideoOrBuilder
                    @Deprecated
                    public Protocol getProtocol() {
                        return ((Video) this.instance).getProtocol();
                    }

                    @Deprecated
                    public Builder setProtocol(Protocol protocol) {
                        copyOnWrite();
                        ((Video) this.instance).setProtocol(protocol);
                        return this;
                    }

                    @Deprecated
                    public Builder clearProtocol() {
                        copyOnWrite();
                        ((Video) this.instance).clearProtocol();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Video();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001!\u0000\u0001\u0001\"!\u0000\t\u0001\u0001\u001a\u0002ဌ\n\u0003င\u0000\u0004င\u0001\u0005ဌ\u0017\u0006င\u0005\u0007င\u0006\bင\u0002\tင\u000e\n,\u000bင\u0011\fင\u0012\rင\u0013\u000eဇ\u0014\u000f,\u0010,\u0011ဌ\u0016\u0012Л\u0013,\u0014,\u0015,\u0017ဇ\u000b\u0018င\f\u0019င\r\u001aဌ\t\u001bဌ\u0015\u001cင\u0003\u001dင\u0004\u001eဈ\u0007\u001fဌ\b '!ဌ\u000f\"က\u0010", new Object[]{"bitField0_", "mimes_", "linearity_", VideoLinearity.internalGetVerifier(), "minduration_", "maxduration_", "protocol_", Protocol.internalGetVerifier(), "w_", "h_", "startdelay_", "sequence_", "battr_", CreativeAttribute.internalGetVerifier(), "maxextended_", "minbitrate_", "maxbitrate_", "boxingallowed_", "playbackmethod_", PlaybackMethod.internalGetVerifier(), "delivery_", ContentDeliveryMethod.internalGetVerifier(), "pos_", AdPosition.internalGetVerifier(), "companionad_", Banner.class, "api_", APIFramework.internalGetVerifier(), "companiontype_", CompanionType.internalGetVerifier(), "protocols_", Protocol.internalGetVerifier(), "skip_", "skipmin_", "skipafter_", "placement_", VideoPlacementType.internalGetVerifier(), "playbackend_", PlaybackCessationMode.internalGetVerifier(), "maxseq_", "poddur_", "podid_", "podseq_", PodSequence.internalGetVerifier(), "rqddurs_", "slotinpod_", SlotPositionInPod.internalGetVerifier(), "mincpmpersec_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Video> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Video.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                public static Video getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Video> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            public static final class Audio extends GeneratedMessageLite.ExtendableMessage<Audio, Builder> implements AudioOrBuilder {
                public static final int API_FIELD_NUMBER = 13;
                public static final int BATTR_FIELD_NUMBER = 7;
                public static final int COMPANIONAD_FIELD_NUMBER = 12;
                public static final int COMPANIONTYPE_FIELD_NUMBER = 20;
                private static final Audio DEFAULT_INSTANCE;
                public static final int DELIVERY_FIELD_NUMBER = 11;
                public static final int FEED_FIELD_NUMBER = 22;
                public static final int MAXBITRATE_FIELD_NUMBER = 10;
                public static final int MAXDURATION_FIELD_NUMBER = 3;
                public static final int MAXEXTENDED_FIELD_NUMBER = 8;
                public static final int MAXSEQ_FIELD_NUMBER = 21;
                public static final int MIMES_FIELD_NUMBER = 1;
                public static final int MINBITRATE_FIELD_NUMBER = 9;
                public static final int MINCPMPERSEC_FIELD_NUMBER = 30;
                public static final int MINDURATION_FIELD_NUMBER = 2;
                public static final int NVOL_FIELD_NUMBER = 24;
                private static volatile Parser<Audio> PARSER = null;
                public static final int PODDUR_FIELD_NUMBER = 25;
                public static final int PODID_FIELD_NUMBER = 27;
                public static final int PODSEQ_FIELD_NUMBER = 28;
                public static final int PROTOCOLS_FIELD_NUMBER = 4;
                public static final int RQDDURS_FIELD_NUMBER = 26;
                public static final int SEQUENCE_FIELD_NUMBER = 6;
                public static final int SLOTINPOD_FIELD_NUMBER = 29;
                public static final int STARTDELAY_FIELD_NUMBER = 5;
                public static final int STITCHED_FIELD_NUMBER = 23;
                private int apiMemoizedSerializedSize;
                private int battrMemoizedSerializedSize;
                private int bitField0_;
                private int companiontypeMemoizedSerializedSize;
                private int deliveryMemoizedSerializedSize;
                private int maxbitrate_;
                private int maxduration_;
                private int maxextended_;
                private int maxseq_;
                private int minbitrate_;
                private double mincpmpersec_;
                private int minduration_;
                private int nvol_;
                private int poddur_;
                private int podseq_;
                private int protocolsMemoizedSerializedSize;
                private int slotinpod_;
                private int startdelay_;
                private boolean stitched_;
                private static final Internal.ListAdapter.Converter<Integer, Protocol> protocols_converter_ = new Internal.ListAdapter.Converter<Integer, Protocol>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.1
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public Protocol convert(Integer num) {
                        Protocol protocolForNumber = Protocol.forNumber(num.intValue());
                        return protocolForNumber == null ? Protocol.VAST_1_0 : protocolForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CreativeAttribute> battr_converter_ = new Internal.ListAdapter.Converter<Integer, CreativeAttribute>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.2
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CreativeAttribute convert(Integer num) {
                        CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(num.intValue());
                        return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, ContentDeliveryMethod> delivery_converter_ = new Internal.ListAdapter.Converter<Integer, ContentDeliveryMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.3
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public ContentDeliveryMethod convert(Integer num) {
                        ContentDeliveryMethod contentDeliveryMethodForNumber = ContentDeliveryMethod.forNumber(num.intValue());
                        return contentDeliveryMethodForNumber == null ? ContentDeliveryMethod.STREAMING : contentDeliveryMethodForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, APIFramework> api_converter_ = new Internal.ListAdapter.Converter<Integer, APIFramework>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.4
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public APIFramework convert(Integer num) {
                        APIFramework aPIFrameworkForNumber = APIFramework.forNumber(num.intValue());
                        return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CompanionType> companiontype_converter_ = new Internal.ListAdapter.Converter<Integer, CompanionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.5
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CompanionType convert(Integer num) {
                        CompanionType companionTypeForNumber = CompanionType.forNumber(num.intValue());
                        return companionTypeForNumber == null ? CompanionType.STATIC : companionTypeForNumber;
                    }
                };
                private int rqddursMemoizedSerializedSize = -1;
                private byte memoizedIsInitialized = 2;
                private Internal.ProtobufList<String> mimes_ = GeneratedMessageLite.emptyProtobufList();
                private Internal.IntList protocols_ = emptyIntList();
                private Internal.IntList rqddurs_ = emptyIntList();
                private String podid_ = "";
                private int sequence_ = 1;
                private Internal.IntList battr_ = emptyIntList();
                private Internal.IntList delivery_ = emptyIntList();
                private Internal.ProtobufList<Banner> companionad_ = emptyProtobufList();
                private Internal.IntList api_ = emptyIntList();
                private Internal.IntList companiontype_ = emptyIntList();
                private int feed_ = 1;

                private Audio() {
                }

                public enum FeedType implements Internal.EnumLite {
                    MUSIC_SERVICE(1),
                    BROADCAST(2),
                    PODCAST(3);

                    public static final int BROADCAST_VALUE = 2;
                    public static final int MUSIC_SERVICE_VALUE = 1;
                    public static final int PODCAST_VALUE = 3;
                    private static final Internal.EnumLiteMap<FeedType> internalValueMap = new Internal.EnumLiteMap<FeedType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.FeedType.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public FeedType findValueByNumber(int i) {
                            return FeedType.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static FeedType valueOf(int i) {
                        return forNumber(i);
                    }

                    public static FeedType forNumber(int i) {
                        if (i == 1) {
                            return MUSIC_SERVICE;
                        }
                        if (i == 2) {
                            return BROADCAST;
                        }
                        if (i != 3) {
                            return null;
                        }
                        return PODCAST;
                    }

                    public static Internal.EnumLiteMap<FeedType> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return FeedTypeVerifier.INSTANCE;
                    }

                    private static final class FeedTypeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new FeedTypeVerifier();

                        private FeedTypeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return FeedType.forNumber(i) != null;
                        }
                    }

                    FeedType(int i) {
                        this.value = i;
                    }
                }

                public enum VolumeNormalizationMode implements Internal.EnumLite {
                    NONE(0),
                    AVERAGE_VOLUME(1),
                    PEAK_VOLUME(2),
                    LOUDNESS(3),
                    CUSTOM_VOLUME(4);

                    public static final int AVERAGE_VOLUME_VALUE = 1;
                    public static final int CUSTOM_VOLUME_VALUE = 4;
                    public static final int LOUDNESS_VALUE = 3;
                    public static final int NONE_VALUE = 0;
                    public static final int PEAK_VOLUME_VALUE = 2;
                    private static final Internal.EnumLiteMap<VolumeNormalizationMode> internalValueMap = new Internal.EnumLiteMap<VolumeNormalizationMode>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Audio.VolumeNormalizationMode.1
                        @Override // com.google.protobuf.Internal.EnumLiteMap
                        public VolumeNormalizationMode findValueByNumber(int i) {
                            return VolumeNormalizationMode.forNumber(i);
                        }
                    };
                    private final int value;

                    @Override // com.google.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    @Deprecated
                    public static VolumeNormalizationMode valueOf(int i) {
                        return forNumber(i);
                    }

                    public static VolumeNormalizationMode forNumber(int i) {
                        if (i == 0) {
                            return NONE;
                        }
                        if (i == 1) {
                            return AVERAGE_VOLUME;
                        }
                        if (i == 2) {
                            return PEAK_VOLUME;
                        }
                        if (i == 3) {
                            return LOUDNESS;
                        }
                        if (i != 4) {
                            return null;
                        }
                        return CUSTOM_VOLUME;
                    }

                    public static Internal.EnumLiteMap<VolumeNormalizationMode> internalGetValueMap() {
                        return internalValueMap;
                    }

                    public static Internal.EnumVerifier internalGetVerifier() {
                        return VolumeNormalizationModeVerifier.INSTANCE;
                    }

                    private static final class VolumeNormalizationModeVerifier implements Internal.EnumVerifier {
                        static final Internal.EnumVerifier INSTANCE = new VolumeNormalizationModeVerifier();

                        private VolumeNormalizationModeVerifier() {
                        }

                        @Override // com.google.protobuf.Internal.EnumVerifier
                        public boolean isInRange(int i) {
                            return VolumeNormalizationMode.forNumber(i) != null;
                        }
                    }

                    VolumeNormalizationMode(int i) {
                        this.value = i;
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<String> getMimesList() {
                    return this.mimes_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMimesCount() {
                    return this.mimes_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public String getMimes(int i) {
                    return this.mimes_.get(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public ByteString getMimesBytes(int i) {
                    return ByteString.copyFromUtf8(this.mimes_.get(i));
                }

                private void ensureMimesIsMutable() {
                    Internal.ProtobufList<String> protobufList = this.mimes_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.mimes_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMimes(int i, String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.set(i, str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimes(String str) {
                    str.getClass();
                    ensureMimesIsMutable();
                    this.mimes_.add(str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllMimes(Iterable<String> iterable) {
                    ensureMimesIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.mimes_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMimes() {
                    this.mimes_ = GeneratedMessageLite.emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addMimesBytes(ByteString byteString) {
                    ensureMimesIsMutable();
                    this.mimes_.add(byteString.toStringUtf8());
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMinduration() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMinduration() {
                    return this.minduration_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMinduration(int i) {
                    this.bitField0_ |= 1;
                    this.minduration_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMinduration() {
                    this.bitField0_ &= -2;
                    this.minduration_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMaxduration() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMaxduration() {
                    return this.maxduration_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxduration(int i) {
                    this.bitField0_ |= 2;
                    this.maxduration_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxduration() {
                    this.bitField0_ &= -3;
                    this.maxduration_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasPoddur() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getPoddur() {
                    return this.poddur_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPoddur(int i) {
                    this.bitField0_ |= 4;
                    this.poddur_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPoddur() {
                    this.bitField0_ &= -5;
                    this.poddur_ = 0;
                }

                static {
                    Audio audio = new Audio();
                    DEFAULT_INSTANCE = audio;
                    GeneratedMessageLite.registerDefaultInstance(Audio.class, audio);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<Protocol> getProtocolsList() {
                    return new Internal.ListAdapter(this.protocols_, protocols_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getProtocolsCount() {
                    return this.protocols_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public Protocol getProtocols(int i) {
                    Protocol protocolForNumber = Protocol.forNumber(this.protocols_.getInt(i));
                    return protocolForNumber == null ? Protocol.VAST_1_0 : protocolForNumber;
                }

                private void ensureProtocolsIsMutable() {
                    Internal.IntList intList = this.protocols_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.protocols_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setProtocols(int i, Protocol protocol) {
                    protocol.getClass();
                    ensureProtocolsIsMutable();
                    this.protocols_.setInt(i, protocol.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addProtocols(Protocol protocol) {
                    protocol.getClass();
                    ensureProtocolsIsMutable();
                    this.protocols_.addInt(protocol.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllProtocols(Iterable<? extends Protocol> iterable) {
                    ensureProtocolsIsMutable();
                    Iterator<? extends Protocol> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.protocols_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearProtocols() {
                    this.protocols_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasStartdelay() {
                    return (this.bitField0_ & 8) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getStartdelay() {
                    return this.startdelay_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setStartdelay(int i) {
                    this.bitField0_ |= 8;
                    this.startdelay_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearStartdelay() {
                    this.bitField0_ &= -9;
                    this.startdelay_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<Integer> getRqddursList() {
                    return this.rqddurs_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getRqddursCount() {
                    return this.rqddurs_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getRqddurs(int i) {
                    return this.rqddurs_.getInt(i);
                }

                private void ensureRqddursIsMutable() {
                    Internal.IntList intList = this.rqddurs_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.rqddurs_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRqddurs(int i, int i2) {
                    ensureRqddursIsMutable();
                    this.rqddurs_.setInt(i, i2);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addRqddurs(int i) {
                    ensureRqddursIsMutable();
                    this.rqddurs_.addInt(i);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllRqddurs(Iterable<? extends Integer> iterable) {
                    ensureRqddursIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.rqddurs_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRqddurs() {
                    this.rqddurs_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasPodid() {
                    return (this.bitField0_ & 16) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public String getPodid() {
                    return this.podid_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public ByteString getPodidBytes() {
                    return ByteString.copyFromUtf8(this.podid_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodid(String str) {
                    str.getClass();
                    this.bitField0_ |= 16;
                    this.podid_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPodid() {
                    this.bitField0_ &= -17;
                    this.podid_ = getDefaultInstance().getPodid();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodidBytes(ByteString byteString) {
                    this.podid_ = byteString.toStringUtf8();
                    this.bitField0_ |= 16;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasPodseq() {
                    return (this.bitField0_ & 32) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public PodSequence getPodseq() {
                    PodSequence podSequenceForNumber = PodSequence.forNumber(this.podseq_);
                    return podSequenceForNumber == null ? PodSequence.POD_SEQUENCE_ANY : podSequenceForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPodseq(PodSequence podSequence) {
                    this.podseq_ = podSequence.getNumber();
                    this.bitField0_ |= 32;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPodseq() {
                    this.bitField0_ &= -33;
                    this.podseq_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                @Deprecated
                public boolean hasSequence() {
                    return (this.bitField0_ & 64) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                @Deprecated
                public int getSequence() {
                    return this.sequence_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSequence(int i) {
                    this.bitField0_ |= 64;
                    this.sequence_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSequence() {
                    this.bitField0_ &= -65;
                    this.sequence_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasSlotinpod() {
                    return (this.bitField0_ & 128) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public SlotPositionInPod getSlotinpod() {
                    SlotPositionInPod slotPositionInPodForNumber = SlotPositionInPod.forNumber(this.slotinpod_);
                    return slotPositionInPodForNumber == null ? SlotPositionInPod.SLOT_POSITION_POD_ANY : slotPositionInPodForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setSlotinpod(SlotPositionInPod slotPositionInPod) {
                    this.slotinpod_ = slotPositionInPod.getNumber();
                    this.bitField0_ |= 128;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearSlotinpod() {
                    this.bitField0_ &= -129;
                    this.slotinpod_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMincpmpersec() {
                    return (this.bitField0_ & 256) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public double getMincpmpersec() {
                    return this.mincpmpersec_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMincpmpersec(double d) {
                    this.bitField0_ |= 256;
                    this.mincpmpersec_ = d;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMincpmpersec() {
                    this.bitField0_ &= -257;
                    this.mincpmpersec_ = 0.0d;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<CreativeAttribute> getBattrList() {
                    return new Internal.ListAdapter(this.battr_, battr_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getBattrCount() {
                    return this.battr_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public CreativeAttribute getBattr(int i) {
                    CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(this.battr_.getInt(i));
                    return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                }

                private void ensureBattrIsMutable() {
                    Internal.IntList intList = this.battr_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.battr_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBattr(int i, CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.setInt(i, creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBattr(CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.addInt(creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                    ensureBattrIsMutable();
                    Iterator<? extends CreativeAttribute> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.battr_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBattr() {
                    this.battr_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMaxextended() {
                    return (this.bitField0_ & 512) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMaxextended() {
                    return this.maxextended_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxextended(int i) {
                    this.bitField0_ |= 512;
                    this.maxextended_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxextended() {
                    this.bitField0_ &= -513;
                    this.maxextended_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMinbitrate() {
                    return (this.bitField0_ & 1024) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMinbitrate() {
                    return this.minbitrate_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMinbitrate(int i) {
                    this.bitField0_ |= 1024;
                    this.minbitrate_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMinbitrate() {
                    this.bitField0_ &= -1025;
                    this.minbitrate_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMaxbitrate() {
                    return (this.bitField0_ & 2048) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMaxbitrate() {
                    return this.maxbitrate_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxbitrate(int i) {
                    this.bitField0_ |= 2048;
                    this.maxbitrate_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxbitrate() {
                    this.bitField0_ &= -2049;
                    this.maxbitrate_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<ContentDeliveryMethod> getDeliveryList() {
                    return new Internal.ListAdapter(this.delivery_, delivery_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getDeliveryCount() {
                    return this.delivery_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public ContentDeliveryMethod getDelivery(int i) {
                    ContentDeliveryMethod contentDeliveryMethodForNumber = ContentDeliveryMethod.forNumber(this.delivery_.getInt(i));
                    return contentDeliveryMethodForNumber == null ? ContentDeliveryMethod.STREAMING : contentDeliveryMethodForNumber;
                }

                private void ensureDeliveryIsMutable() {
                    Internal.IntList intList = this.delivery_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.delivery_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setDelivery(int i, ContentDeliveryMethod contentDeliveryMethod) {
                    contentDeliveryMethod.getClass();
                    ensureDeliveryIsMutable();
                    this.delivery_.setInt(i, contentDeliveryMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addDelivery(ContentDeliveryMethod contentDeliveryMethod) {
                    contentDeliveryMethod.getClass();
                    ensureDeliveryIsMutable();
                    this.delivery_.addInt(contentDeliveryMethod.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllDelivery(Iterable<? extends ContentDeliveryMethod> iterable) {
                    ensureDeliveryIsMutable();
                    Iterator<? extends ContentDeliveryMethod> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.delivery_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearDelivery() {
                    this.delivery_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<Banner> getCompanionadList() {
                    return this.companionad_;
                }

                public List<? extends BannerOrBuilder> getCompanionadOrBuilderList() {
                    return this.companionad_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getCompanionadCount() {
                    return this.companionad_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public Banner getCompanionad(int i) {
                    return this.companionad_.get(i);
                }

                public BannerOrBuilder getCompanionadOrBuilder(int i) {
                    return this.companionad_.get(i);
                }

                private void ensureCompanionadIsMutable() {
                    Internal.ProtobufList<Banner> protobufList = this.companionad_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.companionad_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCompanionad(int i, Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.set(i, banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompanionad(Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.add(banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompanionad(int i, Banner banner) {
                    banner.getClass();
                    ensureCompanionadIsMutable();
                    this.companionad_.add(i, banner);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllCompanionad(Iterable<? extends Banner> iterable) {
                    ensureCompanionadIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.companionad_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCompanionad() {
                    this.companionad_ = emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void removeCompanionad(int i) {
                    ensureCompanionadIsMutable();
                    this.companionad_.remove(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<APIFramework> getApiList() {
                    return new Internal.ListAdapter(this.api_, api_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getApiCount() {
                    return this.api_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public APIFramework getApi(int i) {
                    APIFramework aPIFrameworkForNumber = APIFramework.forNumber(this.api_.getInt(i));
                    return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                }

                private void ensureApiIsMutable() {
                    Internal.IntList intList = this.api_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.api_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setApi(int i, APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.setInt(i, aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addApi(APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.addInt(aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllApi(Iterable<? extends APIFramework> iterable) {
                    ensureApiIsMutable();
                    Iterator<? extends APIFramework> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.api_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearApi() {
                    this.api_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public List<CompanionType> getCompaniontypeList() {
                    return new Internal.ListAdapter(this.companiontype_, companiontype_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getCompaniontypeCount() {
                    return this.companiontype_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public CompanionType getCompaniontype(int i) {
                    CompanionType companionTypeForNumber = CompanionType.forNumber(this.companiontype_.getInt(i));
                    return companionTypeForNumber == null ? CompanionType.STATIC : companionTypeForNumber;
                }

                private void ensureCompaniontypeIsMutable() {
                    Internal.IntList intList = this.companiontype_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.companiontype_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCompaniontype(int i, CompanionType companionType) {
                    companionType.getClass();
                    ensureCompaniontypeIsMutable();
                    this.companiontype_.setInt(i, companionType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addCompaniontype(CompanionType companionType) {
                    companionType.getClass();
                    ensureCompaniontypeIsMutable();
                    this.companiontype_.addInt(companionType.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllCompaniontype(Iterable<? extends CompanionType> iterable) {
                    ensureCompaniontypeIsMutable();
                    Iterator<? extends CompanionType> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.companiontype_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCompaniontype() {
                    this.companiontype_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasMaxseq() {
                    return (this.bitField0_ & 4096) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public int getMaxseq() {
                    return this.maxseq_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setMaxseq(int i) {
                    this.bitField0_ |= 4096;
                    this.maxseq_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearMaxseq() {
                    this.bitField0_ &= -4097;
                    this.maxseq_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasFeed() {
                    return (this.bitField0_ & 8192) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public FeedType getFeed() {
                    FeedType feedTypeForNumber = FeedType.forNumber(this.feed_);
                    return feedTypeForNumber == null ? FeedType.MUSIC_SERVICE : feedTypeForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setFeed(FeedType feedType) {
                    this.feed_ = feedType.getNumber();
                    this.bitField0_ |= 8192;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearFeed() {
                    this.bitField0_ &= -8193;
                    this.feed_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasStitched() {
                    return (this.bitField0_ & 16384) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean getStitched() {
                    return this.stitched_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setStitched(boolean z) {
                    this.bitField0_ |= 16384;
                    this.stitched_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearStitched() {
                    this.bitField0_ &= -16385;
                    this.stitched_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public boolean hasNvol() {
                    return (this.bitField0_ & 32768) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                public VolumeNormalizationMode getNvol() {
                    VolumeNormalizationMode volumeNormalizationModeForNumber = VolumeNormalizationMode.forNumber(this.nvol_);
                    return volumeNormalizationModeForNumber == null ? VolumeNormalizationMode.NONE : volumeNormalizationModeForNumber;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setNvol(VolumeNormalizationMode volumeNormalizationMode) {
                    this.nvol_ = volumeNormalizationMode.getNumber();
                    this.bitField0_ |= 32768;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearNvol() {
                    this.bitField0_ &= -32769;
                    this.nvol_ = 0;
                }

                public static Audio parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Audio parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Audio parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Audio parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Audio parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Audio parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Audio parseFrom(InputStream inputStream) throws IOException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Audio parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Audio parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Audio) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Audio parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Audio) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Audio parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Audio parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Audio) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Audio audio) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(audio);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Audio, Builder> implements AudioOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Audio.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<String> getMimesList() {
                        return Collections.unmodifiableList(((Audio) this.instance).getMimesList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMimesCount() {
                        return ((Audio) this.instance).getMimesCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public String getMimes(int i) {
                        return ((Audio) this.instance).getMimes(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public ByteString getMimesBytes(int i) {
                        return ((Audio) this.instance).getMimesBytes(i);
                    }

                    public Builder setMimes(int i, String str) {
                        copyOnWrite();
                        ((Audio) this.instance).setMimes(i, str);
                        return this;
                    }

                    public Builder addMimes(String str) {
                        copyOnWrite();
                        ((Audio) this.instance).addMimes(str);
                        return this;
                    }

                    public Builder addAllMimes(Iterable<String> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllMimes(iterable);
                        return this;
                    }

                    public Builder clearMimes() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMimes();
                        return this;
                    }

                    public Builder addMimesBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Audio) this.instance).addMimesBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMinduration() {
                        return ((Audio) this.instance).hasMinduration();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMinduration() {
                        return ((Audio) this.instance).getMinduration();
                    }

                    public Builder setMinduration(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMinduration(i);
                        return this;
                    }

                    public Builder clearMinduration() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMinduration();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMaxduration() {
                        return ((Audio) this.instance).hasMaxduration();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMaxduration() {
                        return ((Audio) this.instance).getMaxduration();
                    }

                    public Builder setMaxduration(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMaxduration(i);
                        return this;
                    }

                    public Builder clearMaxduration() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMaxduration();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasPoddur() {
                        return ((Audio) this.instance).hasPoddur();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getPoddur() {
                        return ((Audio) this.instance).getPoddur();
                    }

                    public Builder setPoddur(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setPoddur(i);
                        return this;
                    }

                    public Builder clearPoddur() {
                        copyOnWrite();
                        ((Audio) this.instance).clearPoddur();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<Protocol> getProtocolsList() {
                        return ((Audio) this.instance).getProtocolsList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getProtocolsCount() {
                        return ((Audio) this.instance).getProtocolsCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public Protocol getProtocols(int i) {
                        return ((Audio) this.instance).getProtocols(i);
                    }

                    public Builder setProtocols(int i, Protocol protocol) {
                        copyOnWrite();
                        ((Audio) this.instance).setProtocols(i, protocol);
                        return this;
                    }

                    public Builder addProtocols(Protocol protocol) {
                        copyOnWrite();
                        ((Audio) this.instance).addProtocols(protocol);
                        return this;
                    }

                    public Builder addAllProtocols(Iterable<? extends Protocol> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllProtocols(iterable);
                        return this;
                    }

                    public Builder clearProtocols() {
                        copyOnWrite();
                        ((Audio) this.instance).clearProtocols();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasStartdelay() {
                        return ((Audio) this.instance).hasStartdelay();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getStartdelay() {
                        return ((Audio) this.instance).getStartdelay();
                    }

                    public Builder setStartdelay(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setStartdelay(i);
                        return this;
                    }

                    public Builder clearStartdelay() {
                        copyOnWrite();
                        ((Audio) this.instance).clearStartdelay();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<Integer> getRqddursList() {
                        return Collections.unmodifiableList(((Audio) this.instance).getRqddursList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getRqddursCount() {
                        return ((Audio) this.instance).getRqddursCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getRqddurs(int i) {
                        return ((Audio) this.instance).getRqddurs(i);
                    }

                    public Builder setRqddurs(int i, int i2) {
                        copyOnWrite();
                        ((Audio) this.instance).setRqddurs(i, i2);
                        return this;
                    }

                    public Builder addRqddurs(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).addRqddurs(i);
                        return this;
                    }

                    public Builder addAllRqddurs(Iterable<? extends Integer> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllRqddurs(iterable);
                        return this;
                    }

                    public Builder clearRqddurs() {
                        copyOnWrite();
                        ((Audio) this.instance).clearRqddurs();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasPodid() {
                        return ((Audio) this.instance).hasPodid();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public String getPodid() {
                        return ((Audio) this.instance).getPodid();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public ByteString getPodidBytes() {
                        return ((Audio) this.instance).getPodidBytes();
                    }

                    public Builder setPodid(String str) {
                        copyOnWrite();
                        ((Audio) this.instance).setPodid(str);
                        return this;
                    }

                    public Builder clearPodid() {
                        copyOnWrite();
                        ((Audio) this.instance).clearPodid();
                        return this;
                    }

                    public Builder setPodidBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Audio) this.instance).setPodidBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasPodseq() {
                        return ((Audio) this.instance).hasPodseq();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public PodSequence getPodseq() {
                        return ((Audio) this.instance).getPodseq();
                    }

                    public Builder setPodseq(PodSequence podSequence) {
                        copyOnWrite();
                        ((Audio) this.instance).setPodseq(podSequence);
                        return this;
                    }

                    public Builder clearPodseq() {
                        copyOnWrite();
                        ((Audio) this.instance).clearPodseq();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    @Deprecated
                    public boolean hasSequence() {
                        return ((Audio) this.instance).hasSequence();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    @Deprecated
                    public int getSequence() {
                        return ((Audio) this.instance).getSequence();
                    }

                    @Deprecated
                    public Builder setSequence(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setSequence(i);
                        return this;
                    }

                    @Deprecated
                    public Builder clearSequence() {
                        copyOnWrite();
                        ((Audio) this.instance).clearSequence();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasSlotinpod() {
                        return ((Audio) this.instance).hasSlotinpod();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public SlotPositionInPod getSlotinpod() {
                        return ((Audio) this.instance).getSlotinpod();
                    }

                    public Builder setSlotinpod(SlotPositionInPod slotPositionInPod) {
                        copyOnWrite();
                        ((Audio) this.instance).setSlotinpod(slotPositionInPod);
                        return this;
                    }

                    public Builder clearSlotinpod() {
                        copyOnWrite();
                        ((Audio) this.instance).clearSlotinpod();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMincpmpersec() {
                        return ((Audio) this.instance).hasMincpmpersec();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public double getMincpmpersec() {
                        return ((Audio) this.instance).getMincpmpersec();
                    }

                    public Builder setMincpmpersec(double d) {
                        copyOnWrite();
                        ((Audio) this.instance).setMincpmpersec(d);
                        return this;
                    }

                    public Builder clearMincpmpersec() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMincpmpersec();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<CreativeAttribute> getBattrList() {
                        return ((Audio) this.instance).getBattrList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getBattrCount() {
                        return ((Audio) this.instance).getBattrCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public CreativeAttribute getBattr(int i) {
                        return ((Audio) this.instance).getBattr(i);
                    }

                    public Builder setBattr(int i, CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Audio) this.instance).setBattr(i, creativeAttribute);
                        return this;
                    }

                    public Builder addBattr(CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Audio) this.instance).addBattr(creativeAttribute);
                        return this;
                    }

                    public Builder addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllBattr(iterable);
                        return this;
                    }

                    public Builder clearBattr() {
                        copyOnWrite();
                        ((Audio) this.instance).clearBattr();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMaxextended() {
                        return ((Audio) this.instance).hasMaxextended();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMaxextended() {
                        return ((Audio) this.instance).getMaxextended();
                    }

                    public Builder setMaxextended(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMaxextended(i);
                        return this;
                    }

                    public Builder clearMaxextended() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMaxextended();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMinbitrate() {
                        return ((Audio) this.instance).hasMinbitrate();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMinbitrate() {
                        return ((Audio) this.instance).getMinbitrate();
                    }

                    public Builder setMinbitrate(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMinbitrate(i);
                        return this;
                    }

                    public Builder clearMinbitrate() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMinbitrate();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMaxbitrate() {
                        return ((Audio) this.instance).hasMaxbitrate();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMaxbitrate() {
                        return ((Audio) this.instance).getMaxbitrate();
                    }

                    public Builder setMaxbitrate(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMaxbitrate(i);
                        return this;
                    }

                    public Builder clearMaxbitrate() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMaxbitrate();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<ContentDeliveryMethod> getDeliveryList() {
                        return ((Audio) this.instance).getDeliveryList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getDeliveryCount() {
                        return ((Audio) this.instance).getDeliveryCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public ContentDeliveryMethod getDelivery(int i) {
                        return ((Audio) this.instance).getDelivery(i);
                    }

                    public Builder setDelivery(int i, ContentDeliveryMethod contentDeliveryMethod) {
                        copyOnWrite();
                        ((Audio) this.instance).setDelivery(i, contentDeliveryMethod);
                        return this;
                    }

                    public Builder addDelivery(ContentDeliveryMethod contentDeliveryMethod) {
                        copyOnWrite();
                        ((Audio) this.instance).addDelivery(contentDeliveryMethod);
                        return this;
                    }

                    public Builder addAllDelivery(Iterable<? extends ContentDeliveryMethod> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllDelivery(iterable);
                        return this;
                    }

                    public Builder clearDelivery() {
                        copyOnWrite();
                        ((Audio) this.instance).clearDelivery();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<Banner> getCompanionadList() {
                        return Collections.unmodifiableList(((Audio) this.instance).getCompanionadList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getCompanionadCount() {
                        return ((Audio) this.instance).getCompanionadCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public Banner getCompanionad(int i) {
                        return ((Audio) this.instance).getCompanionad(i);
                    }

                    public Builder setCompanionad(int i, Banner banner) {
                        copyOnWrite();
                        ((Audio) this.instance).setCompanionad(i, banner);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder setCompanionad(int i, Banner.Builder builder) {
                        copyOnWrite();
                        ((Audio) this.instance).setCompanionad(i, (Banner) builder.build());
                        return this;
                    }

                    public Builder addCompanionad(Banner banner) {
                        copyOnWrite();
                        ((Audio) this.instance).addCompanionad(banner);
                        return this;
                    }

                    public Builder addCompanionad(int i, Banner banner) {
                        copyOnWrite();
                        ((Audio) this.instance).addCompanionad(i, banner);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addCompanionad(Banner.Builder builder) {
                        copyOnWrite();
                        ((Audio) this.instance).addCompanionad((Banner) builder.build());
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addCompanionad(int i, Banner.Builder builder) {
                        copyOnWrite();
                        ((Audio) this.instance).addCompanionad(i, (Banner) builder.build());
                        return this;
                    }

                    public Builder addAllCompanionad(Iterable<? extends Banner> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllCompanionad(iterable);
                        return this;
                    }

                    public Builder clearCompanionad() {
                        copyOnWrite();
                        ((Audio) this.instance).clearCompanionad();
                        return this;
                    }

                    public Builder removeCompanionad(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).removeCompanionad(i);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<APIFramework> getApiList() {
                        return ((Audio) this.instance).getApiList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getApiCount() {
                        return ((Audio) this.instance).getApiCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public APIFramework getApi(int i) {
                        return ((Audio) this.instance).getApi(i);
                    }

                    public Builder setApi(int i, APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Audio) this.instance).setApi(i, aPIFramework);
                        return this;
                    }

                    public Builder addApi(APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Audio) this.instance).addApi(aPIFramework);
                        return this;
                    }

                    public Builder addAllApi(Iterable<? extends APIFramework> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllApi(iterable);
                        return this;
                    }

                    public Builder clearApi() {
                        copyOnWrite();
                        ((Audio) this.instance).clearApi();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public List<CompanionType> getCompaniontypeList() {
                        return ((Audio) this.instance).getCompaniontypeList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getCompaniontypeCount() {
                        return ((Audio) this.instance).getCompaniontypeCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public CompanionType getCompaniontype(int i) {
                        return ((Audio) this.instance).getCompaniontype(i);
                    }

                    public Builder setCompaniontype(int i, CompanionType companionType) {
                        copyOnWrite();
                        ((Audio) this.instance).setCompaniontype(i, companionType);
                        return this;
                    }

                    public Builder addCompaniontype(CompanionType companionType) {
                        copyOnWrite();
                        ((Audio) this.instance).addCompaniontype(companionType);
                        return this;
                    }

                    public Builder addAllCompaniontype(Iterable<? extends CompanionType> iterable) {
                        copyOnWrite();
                        ((Audio) this.instance).addAllCompaniontype(iterable);
                        return this;
                    }

                    public Builder clearCompaniontype() {
                        copyOnWrite();
                        ((Audio) this.instance).clearCompaniontype();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasMaxseq() {
                        return ((Audio) this.instance).hasMaxseq();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public int getMaxseq() {
                        return ((Audio) this.instance).getMaxseq();
                    }

                    public Builder setMaxseq(int i) {
                        copyOnWrite();
                        ((Audio) this.instance).setMaxseq(i);
                        return this;
                    }

                    public Builder clearMaxseq() {
                        copyOnWrite();
                        ((Audio) this.instance).clearMaxseq();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasFeed() {
                        return ((Audio) this.instance).hasFeed();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public FeedType getFeed() {
                        return ((Audio) this.instance).getFeed();
                    }

                    public Builder setFeed(FeedType feedType) {
                        copyOnWrite();
                        ((Audio) this.instance).setFeed(feedType);
                        return this;
                    }

                    public Builder clearFeed() {
                        copyOnWrite();
                        ((Audio) this.instance).clearFeed();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasStitched() {
                        return ((Audio) this.instance).hasStitched();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean getStitched() {
                        return ((Audio) this.instance).getStitched();
                    }

                    public Builder setStitched(boolean z) {
                        copyOnWrite();
                        ((Audio) this.instance).setStitched(z);
                        return this;
                    }

                    public Builder clearStitched() {
                        copyOnWrite();
                        ((Audio) this.instance).clearStitched();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public boolean hasNvol() {
                        return ((Audio) this.instance).hasNvol();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.AudioOrBuilder
                    public VolumeNormalizationMode getNvol() {
                        return ((Audio) this.instance).getNvol();
                    }

                    public Builder setNvol(VolumeNormalizationMode volumeNormalizationMode) {
                        copyOnWrite();
                        ((Audio) this.instance).setNvol(volumeNormalizationMode);
                        return this;
                    }

                    public Builder clearNvol() {
                        copyOnWrite();
                        ((Audio) this.instance).clearNvol();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Audio();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0018\u0000\u0001\u0001\u001e\u0018\u0000\b\u0001\u0001\u001a\u0002င\u0000\u0003င\u0001\u0004,\u0005င\u0003\u0006င\u0006\u0007,\bင\t\tင\n\nင\u000b\u000b,\fЛ\r,\u0014,\u0015င\f\u0016ဌ\r\u0017ဇ\u000e\u0018ဌ\u000f\u0019င\u0002\u001a'\u001bဈ\u0004\u001cဌ\u0005\u001dဌ\u0007\u001eက\b", new Object[]{"bitField0_", "mimes_", "minduration_", "maxduration_", "protocols_", Protocol.internalGetVerifier(), "startdelay_", "sequence_", "battr_", CreativeAttribute.internalGetVerifier(), "maxextended_", "minbitrate_", "maxbitrate_", "delivery_", ContentDeliveryMethod.internalGetVerifier(), "companionad_", Banner.class, "api_", APIFramework.internalGetVerifier(), "companiontype_", CompanionType.internalGetVerifier(), "maxseq_", "feed_", FeedType.internalGetVerifier(), "stitched_", "nvol_", VolumeNormalizationMode.internalGetVerifier(), "poddur_", "rqddurs_", "podid_", "podseq_", PodSequence.internalGetVerifier(), "slotinpod_", SlotPositionInPod.internalGetVerifier(), "mincpmpersec_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Audio> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Audio.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                public static Audio getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Audio> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            public static final class Native extends GeneratedMessageLite.ExtendableMessage<Native, Builder> implements NativeOrBuilder {
                public static final int API_FIELD_NUMBER = 3;
                public static final int BATTR_FIELD_NUMBER = 4;
                private static final Native DEFAULT_INSTANCE;
                private static volatile Parser<Native> PARSER = null;
                public static final int REQUEST_FIELD_NUMBER = 1;
                public static final int REQUEST_NATIVE_FIELD_NUMBER = 50;
                public static final int VER_FIELD_NUMBER = 2;
                private static final Internal.ListAdapter.Converter<Integer, APIFramework> api_converter_ = new Internal.ListAdapter.Converter<Integer, APIFramework>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.1
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public APIFramework convert(Integer num) {
                        APIFramework aPIFrameworkForNumber = APIFramework.forNumber(num.intValue());
                        return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                    }
                };
                private static final Internal.ListAdapter.Converter<Integer, CreativeAttribute> battr_converter_ = new Internal.ListAdapter.Converter<Integer, CreativeAttribute>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.2
                    @Override // com.google.protobuf.Internal.ListAdapter.Converter
                    public CreativeAttribute convert(Integer num) {
                        CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(num.intValue());
                        return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                    }
                };
                private int apiMemoizedSerializedSize;
                private int battrMemoizedSerializedSize;
                private int bitField0_;
                private Object requestOneof_;
                private int requestOneofCase_ = 0;
                private byte memoizedIsInitialized = 2;
                private String ver_ = "";
                private Internal.IntList api_ = emptyIntList();
                private Internal.IntList battr_ = emptyIntList();

                public interface NativeRequestOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<NativeRequest, NativeRequest.Builder> {
                    NativeRequest.Asset getAssets(int i);

                    int getAssetsCount();

                    List<NativeRequest.Asset> getAssetsList();

                    boolean getAurlsupport();

                    NativeRequest.ContextType getContext();

                    NativeRequest.ContextSubtype getContextsubtype();

                    boolean getDurlsupport();

                    NativeRequest.EventTrackers getEventtrackers(int i);

                    int getEventtrackersCount();

                    List<NativeRequest.EventTrackers> getEventtrackersList();

                    int getPlcmtcnt();

                    NativeRequest.PlacementType getPlcmttype();

                    boolean getPrivacy();

                    int getSeq();

                    String getVer();

                    ByteString getVerBytes();

                    boolean hasAurlsupport();

                    boolean hasContext();

                    boolean hasContextsubtype();

                    boolean hasDurlsupport();

                    boolean hasPlcmtcnt();

                    boolean hasPlcmttype();

                    boolean hasPrivacy();

                    boolean hasSeq();

                    boolean hasVer();
                }

                private Native() {
                }

                public static final class NativeRequest extends GeneratedMessageLite.ExtendableMessage<NativeRequest, Builder> implements NativeRequestOrBuilder {
                    public static final int ASSETS_FIELD_NUMBER = 6;
                    public static final int AURLSUPPORT_FIELD_NUMBER = 11;
                    public static final int CONTEXTSUBTYPE_FIELD_NUMBER = 8;
                    public static final int CONTEXT_FIELD_NUMBER = 7;
                    private static final NativeRequest DEFAULT_INSTANCE;
                    public static final int DURLSUPPORT_FIELD_NUMBER = 12;
                    public static final int EVENTTRACKERS_FIELD_NUMBER = 13;
                    private static volatile Parser<NativeRequest> PARSER = null;
                    public static final int PLCMTCNT_FIELD_NUMBER = 4;
                    public static final int PLCMTTYPE_FIELD_NUMBER = 9;
                    public static final int PRIVACY_FIELD_NUMBER = 14;
                    public static final int SEQ_FIELD_NUMBER = 5;
                    public static final int VER_FIELD_NUMBER = 1;
                    private boolean aurlsupport_;
                    private int bitField0_;
                    private boolean durlsupport_;
                    private boolean privacy_;
                    private int seq_;
                    private byte memoizedIsInitialized = 2;
                    private String ver_ = "";
                    private int context_ = 1;
                    private int contextsubtype_ = 10;
                    private int plcmttype_ = 1;
                    private int plcmtcnt_ = 1;
                    private Internal.ProtobufList<Asset> assets_ = emptyProtobufList();
                    private Internal.ProtobufList<EventTrackers> eventtrackers_ = emptyProtobufList();

                    public interface AssetOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Asset, Asset.Builder> {
                        Asset.AssetOneofCase getAssetOneofCase();

                        Asset.Data getData();

                        int getId();

                        Asset.Image getImg();

                        boolean getRequired();

                        Asset.Title getTitle();

                        Video getVideo();

                        boolean hasData();

                        boolean hasId();

                        boolean hasImg();

                        boolean hasRequired();

                        boolean hasTitle();

                        boolean hasVideo();
                    }

                    public interface EventTrackersOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EventTrackers, EventTrackers.Builder> {
                        EventTrackers.EventType getEvent();

                        EventTrackers.EventTrackingMethod getMethods(int i);

                        int getMethodsCount();

                        List<EventTrackers.EventTrackingMethod> getMethodsList();

                        boolean hasEvent();
                    }

                    private NativeRequest() {
                    }

                    public enum ContextType implements Internal.EnumLite {
                        CONTENT(1),
                        SOCIAL(2),
                        PRODUCT(3);

                        public static final int CONTENT_VALUE = 1;
                        public static final int PRODUCT_VALUE = 3;
                        public static final int SOCIAL_VALUE = 2;
                        private static final Internal.EnumLiteMap<ContextType> internalValueMap = new Internal.EnumLiteMap<ContextType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.ContextType.1
                            @Override // com.google.protobuf.Internal.EnumLiteMap
                            public ContextType findValueByNumber(int i) {
                                return ContextType.forNumber(i);
                            }
                        };
                        private final int value;

                        @Override // com.google.protobuf.Internal.EnumLite
                        public final int getNumber() {
                            return this.value;
                        }

                        @Deprecated
                        public static ContextType valueOf(int i) {
                            return forNumber(i);
                        }

                        public static ContextType forNumber(int i) {
                            if (i == 1) {
                                return CONTENT;
                            }
                            if (i == 2) {
                                return SOCIAL;
                            }
                            if (i != 3) {
                                return null;
                            }
                            return PRODUCT;
                        }

                        public static Internal.EnumLiteMap<ContextType> internalGetValueMap() {
                            return internalValueMap;
                        }

                        public static Internal.EnumVerifier internalGetVerifier() {
                            return ContextTypeVerifier.INSTANCE;
                        }

                        private static final class ContextTypeVerifier implements Internal.EnumVerifier {
                            static final Internal.EnumVerifier INSTANCE = new ContextTypeVerifier();

                            private ContextTypeVerifier() {
                            }

                            @Override // com.google.protobuf.Internal.EnumVerifier
                            public boolean isInRange(int i) {
                                return ContextType.forNumber(i) != null;
                            }
                        }

                        ContextType(int i) {
                            this.value = i;
                        }
                    }

                    public enum ContextSubtype implements Internal.EnumLite {
                        CONTENT_GENERAL_OR_MIXED(10),
                        CONTENT_ARTICLE(11),
                        CONTENT_VIDEO(12),
                        CONTENT_AUDIO(13),
                        CONTENT_IMAGE(14),
                        CONTENT_USER_GENERATED(15),
                        SOCIAL_GENERAL(20),
                        SOCIAL_EMAIL(21),
                        SOCIAL_CHAT_IM(22),
                        PRODUCT_SELLING(30),
                        PRODUCT_MARKETPLACE(31),
                        PRODUCT_REVIEW(32);

                        public static final int CONTENT_ARTICLE_VALUE = 11;
                        public static final int CONTENT_AUDIO_VALUE = 13;
                        public static final int CONTENT_GENERAL_OR_MIXED_VALUE = 10;
                        public static final int CONTENT_IMAGE_VALUE = 14;
                        public static final int CONTENT_USER_GENERATED_VALUE = 15;
                        public static final int CONTENT_VIDEO_VALUE = 12;
                        public static final int PRODUCT_MARKETPLACE_VALUE = 31;
                        public static final int PRODUCT_REVIEW_VALUE = 32;
                        public static final int PRODUCT_SELLING_VALUE = 30;
                        public static final int SOCIAL_CHAT_IM_VALUE = 22;
                        public static final int SOCIAL_EMAIL_VALUE = 21;
                        public static final int SOCIAL_GENERAL_VALUE = 20;
                        private static final Internal.EnumLiteMap<ContextSubtype> internalValueMap = new Internal.EnumLiteMap<ContextSubtype>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.ContextSubtype.1
                            @Override // com.google.protobuf.Internal.EnumLiteMap
                            public ContextSubtype findValueByNumber(int i) {
                                return ContextSubtype.forNumber(i);
                            }
                        };
                        private final int value;

                        @Override // com.google.protobuf.Internal.EnumLite
                        public final int getNumber() {
                            return this.value;
                        }

                        @Deprecated
                        public static ContextSubtype valueOf(int i) {
                            return forNumber(i);
                        }

                        public static ContextSubtype forNumber(int i) {
                            switch (i) {
                                case 10:
                                    return CONTENT_GENERAL_OR_MIXED;
                                case 11:
                                    return CONTENT_ARTICLE;
                                case 12:
                                    return CONTENT_VIDEO;
                                case 13:
                                    return CONTENT_AUDIO;
                                case 14:
                                    return CONTENT_IMAGE;
                                case 15:
                                    return CONTENT_USER_GENERATED;
                                default:
                                    switch (i) {
                                        case 20:
                                            return SOCIAL_GENERAL;
                                        case 21:
                                            return SOCIAL_EMAIL;
                                        case 22:
                                            return SOCIAL_CHAT_IM;
                                        default:
                                            switch (i) {
                                                case 30:
                                                    return PRODUCT_SELLING;
                                                case 31:
                                                    return PRODUCT_MARKETPLACE;
                                                case 32:
                                                    return PRODUCT_REVIEW;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                        }

                        public static Internal.EnumLiteMap<ContextSubtype> internalGetValueMap() {
                            return internalValueMap;
                        }

                        public static Internal.EnumVerifier internalGetVerifier() {
                            return ContextSubtypeVerifier.INSTANCE;
                        }

                        private static final class ContextSubtypeVerifier implements Internal.EnumVerifier {
                            static final Internal.EnumVerifier INSTANCE = new ContextSubtypeVerifier();

                            private ContextSubtypeVerifier() {
                            }

                            @Override // com.google.protobuf.Internal.EnumVerifier
                            public boolean isInRange(int i) {
                                return ContextSubtype.forNumber(i) != null;
                            }
                        }

                        ContextSubtype(int i) {
                            this.value = i;
                        }
                    }

                    public enum PlacementType implements Internal.EnumLite {
                        IN_FEED(1),
                        ATOMIC_UNIT(2),
                        OUTSIDE(3),
                        RECOMMENDATION(4);

                        public static final int ATOMIC_UNIT_VALUE = 2;
                        public static final int IN_FEED_VALUE = 1;
                        public static final int OUTSIDE_VALUE = 3;
                        public static final int RECOMMENDATION_VALUE = 4;
                        private static final Internal.EnumLiteMap<PlacementType> internalValueMap = new Internal.EnumLiteMap<PlacementType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.PlacementType.1
                            @Override // com.google.protobuf.Internal.EnumLiteMap
                            public PlacementType findValueByNumber(int i) {
                                return PlacementType.forNumber(i);
                            }
                        };
                        private final int value;

                        @Override // com.google.protobuf.Internal.EnumLite
                        public final int getNumber() {
                            return this.value;
                        }

                        @Deprecated
                        public static PlacementType valueOf(int i) {
                            return forNumber(i);
                        }

                        public static PlacementType forNumber(int i) {
                            if (i == 1) {
                                return IN_FEED;
                            }
                            if (i == 2) {
                                return ATOMIC_UNIT;
                            }
                            if (i == 3) {
                                return OUTSIDE;
                            }
                            if (i != 4) {
                                return null;
                            }
                            return RECOMMENDATION;
                        }

                        public static Internal.EnumLiteMap<PlacementType> internalGetValueMap() {
                            return internalValueMap;
                        }

                        public static Internal.EnumVerifier internalGetVerifier() {
                            return PlacementTypeVerifier.INSTANCE;
                        }

                        private static final class PlacementTypeVerifier implements Internal.EnumVerifier {
                            static final Internal.EnumVerifier INSTANCE = new PlacementTypeVerifier();

                            private PlacementTypeVerifier() {
                            }

                            @Override // com.google.protobuf.Internal.EnumVerifier
                            public boolean isInRange(int i) {
                                return PlacementType.forNumber(i) != null;
                            }
                        }

                        PlacementType(int i) {
                            this.value = i;
                        }
                    }

                    public static final class Asset extends GeneratedMessageLite.ExtendableMessage<Asset, Builder> implements AssetOrBuilder {
                        public static final int DATA_FIELD_NUMBER = 6;
                        private static final Asset DEFAULT_INSTANCE;
                        public static final int ID_FIELD_NUMBER = 1;
                        public static final int IMG_FIELD_NUMBER = 4;
                        private static volatile Parser<Asset> PARSER = null;
                        public static final int REQUIRED_FIELD_NUMBER = 2;
                        public static final int TITLE_FIELD_NUMBER = 3;
                        public static final int VIDEO_FIELD_NUMBER = 5;
                        private Object assetOneof_;
                        private int bitField0_;
                        private int id_;
                        private boolean required_;
                        private int assetOneofCase_ = 0;
                        private byte memoizedIsInitialized = 2;

                        public interface DataOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Data, Data.Builder> {
                            int getLen();

                            Data.DataAssetType getType();

                            boolean hasLen();

                            boolean hasType();
                        }

                        public interface ImageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Image, Image.Builder> {
                            int getH();

                            int getHmin();

                            String getMimes(int i);

                            ByteString getMimesBytes(int i);

                            int getMimesCount();

                            List<String> getMimesList();

                            Image.ImageAssetType getType();

                            int getW();

                            int getWmin();

                            boolean hasH();

                            boolean hasHmin();

                            boolean hasType();

                            boolean hasW();

                            boolean hasWmin();
                        }

                        public interface TitleOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Title, Title.Builder> {
                            int getLen();

                            boolean hasLen();
                        }

                        private Asset() {
                        }

                        public static final class Title extends GeneratedMessageLite.ExtendableMessage<Title, Builder> implements TitleOrBuilder {
                            private static final Title DEFAULT_INSTANCE;
                            public static final int LEN_FIELD_NUMBER = 1;
                            private static volatile Parser<Title> PARSER;
                            private int bitField0_;
                            private int len_;
                            private byte memoizedIsInitialized = 2;

                            private Title() {
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.TitleOrBuilder
                            public boolean hasLen() {
                                return (this.bitField0_ & 1) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.TitleOrBuilder
                            public int getLen() {
                                return this.len_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setLen(int i) {
                                this.bitField0_ |= 1;
                                this.len_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearLen() {
                                this.bitField0_ &= -2;
                                this.len_ = 0;
                            }

                            public static Title parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                            }

                            public static Title parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                            }

                            public static Title parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                            }

                            public static Title parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                            }

                            public static Title parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                            }

                            public static Title parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                            }

                            public static Title parseFrom(InputStream inputStream) throws IOException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Title parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Title parseDelimitedFrom(InputStream inputStream) throws IOException {
                                return (Title) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Title parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Title) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Title parseFrom(CodedInputStream codedInputStream) throws IOException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                            }

                            public static Title parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Title) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder() {
                                return (Builder) DEFAULT_INSTANCE.createBuilder();
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder(Title title) {
                                return (Builder) DEFAULT_INSTANCE.createBuilder(title);
                            }

                            public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Title, Builder> implements TitleOrBuilder {
                                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                                    this();
                                }

                                private Builder() {
                                    super(Title.DEFAULT_INSTANCE);
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.TitleOrBuilder
                                public boolean hasLen() {
                                    return ((Title) this.instance).hasLen();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.TitleOrBuilder
                                public int getLen() {
                                    return ((Title) this.instance).getLen();
                                }

                                public Builder setLen(int i) {
                                    copyOnWrite();
                                    ((Title) this.instance).setLen(i);
                                    return this;
                                }

                                public Builder clearLen() {
                                    copyOnWrite();
                                    ((Title) this.instance).clearLen();
                                    return this;
                                }
                            }

                            @Override // com.google.protobuf.GeneratedMessageLite
                            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                                AnonymousClass1 anonymousClass1 = null;
                                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                                    case 1:
                                        return new Title();
                                    case 2:
                                        return new Builder(anonymousClass1);
                                    case 3:
                                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔄ\u0000", new Object[]{"bitField0_", "len_"});
                                    case 4:
                                        return DEFAULT_INSTANCE;
                                    case 5:
                                        Parser<Title> defaultInstanceBasedParser = PARSER;
                                        if (defaultInstanceBasedParser == null) {
                                            synchronized (Title.class) {
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
                                        return Byte.valueOf(this.memoizedIsInitialized);
                                    case 7:
                                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                        return null;
                                    default:
                                        throw new UnsupportedOperationException();
                                }
                            }

                            static {
                                Title title = new Title();
                                DEFAULT_INSTANCE = title;
                                GeneratedMessageLite.registerDefaultInstance(Title.class, title);
                            }

                            public static Title getDefaultInstance() {
                                return DEFAULT_INSTANCE;
                            }

                            public static Parser<Title> parser() {
                                return DEFAULT_INSTANCE.getParserForType();
                            }
                        }

                        public static final class Image extends GeneratedMessageLite.ExtendableMessage<Image, Builder> implements ImageOrBuilder {
                            private static final Image DEFAULT_INSTANCE;
                            public static final int HMIN_FIELD_NUMBER = 5;
                            public static final int H_FIELD_NUMBER = 3;
                            public static final int MIMES_FIELD_NUMBER = 6;
                            private static volatile Parser<Image> PARSER = null;
                            public static final int TYPE_FIELD_NUMBER = 1;
                            public static final int WMIN_FIELD_NUMBER = 4;
                            public static final int W_FIELD_NUMBER = 2;
                            private int bitField0_;
                            private int h_;
                            private int hmin_;
                            private int w_;
                            private int wmin_;
                            private byte memoizedIsInitialized = 2;
                            private int type_ = 1;
                            private Internal.ProtobufList<String> mimes_ = GeneratedMessageLite.emptyProtobufList();

                            private Image() {
                            }

                            public enum ImageAssetType implements Internal.EnumLite {
                                ICON(1),
                                LOGO(2),
                                MAIN(3);

                                public static final int ICON_VALUE = 1;

                                @Deprecated
                                public static final int LOGO_VALUE = 2;
                                public static final int MAIN_VALUE = 3;
                                private static final Internal.EnumLiteMap<ImageAssetType> internalValueMap = new Internal.EnumLiteMap<ImageAssetType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.Image.ImageAssetType.1
                                    @Override // com.google.protobuf.Internal.EnumLiteMap
                                    public ImageAssetType findValueByNumber(int i) {
                                        return ImageAssetType.forNumber(i);
                                    }
                                };
                                private final int value;

                                @Override // com.google.protobuf.Internal.EnumLite
                                public final int getNumber() {
                                    return this.value;
                                }

                                @Deprecated
                                public static ImageAssetType valueOf(int i) {
                                    return forNumber(i);
                                }

                                public static ImageAssetType forNumber(int i) {
                                    if (i == 1) {
                                        return ICON;
                                    }
                                    if (i == 2) {
                                        return LOGO;
                                    }
                                    if (i != 3) {
                                        return null;
                                    }
                                    return MAIN;
                                }

                                public static Internal.EnumLiteMap<ImageAssetType> internalGetValueMap() {
                                    return internalValueMap;
                                }

                                public static Internal.EnumVerifier internalGetVerifier() {
                                    return ImageAssetTypeVerifier.INSTANCE;
                                }

                                private static final class ImageAssetTypeVerifier implements Internal.EnumVerifier {
                                    static final Internal.EnumVerifier INSTANCE = new ImageAssetTypeVerifier();

                                    private ImageAssetTypeVerifier() {
                                    }

                                    @Override // com.google.protobuf.Internal.EnumVerifier
                                    public boolean isInRange(int i) {
                                        return ImageAssetType.forNumber(i) != null;
                                    }
                                }

                                ImageAssetType(int i) {
                                    this.value = i;
                                }
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public boolean hasType() {
                                return (this.bitField0_ & 1) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public ImageAssetType getType() {
                                ImageAssetType imageAssetTypeForNumber = ImageAssetType.forNumber(this.type_);
                                return imageAssetTypeForNumber == null ? ImageAssetType.ICON : imageAssetTypeForNumber;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setType(ImageAssetType imageAssetType) {
                                this.type_ = imageAssetType.getNumber();
                                this.bitField0_ |= 1;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearType() {
                                this.bitField0_ &= -2;
                                this.type_ = 1;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public boolean hasW() {
                                return (this.bitField0_ & 2) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public int getW() {
                                return this.w_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setW(int i) {
                                this.bitField0_ |= 2;
                                this.w_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearW() {
                                this.bitField0_ &= -3;
                                this.w_ = 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public boolean hasH() {
                                return (this.bitField0_ & 4) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public int getH() {
                                return this.h_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setH(int i) {
                                this.bitField0_ |= 4;
                                this.h_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearH() {
                                this.bitField0_ &= -5;
                                this.h_ = 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public boolean hasWmin() {
                                return (this.bitField0_ & 8) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public int getWmin() {
                                return this.wmin_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setWmin(int i) {
                                this.bitField0_ |= 8;
                                this.wmin_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearWmin() {
                                this.bitField0_ &= -9;
                                this.wmin_ = 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public boolean hasHmin() {
                                return (this.bitField0_ & 16) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public int getHmin() {
                                return this.hmin_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setHmin(int i) {
                                this.bitField0_ |= 16;
                                this.hmin_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearHmin() {
                                this.bitField0_ &= -17;
                                this.hmin_ = 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public List<String> getMimesList() {
                                return this.mimes_;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public int getMimesCount() {
                                return this.mimes_.size();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public String getMimes(int i) {
                                return this.mimes_.get(i);
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                            public ByteString getMimesBytes(int i) {
                                return ByteString.copyFromUtf8(this.mimes_.get(i));
                            }

                            private void ensureMimesIsMutable() {
                                Internal.ProtobufList<String> protobufList = this.mimes_;
                                if (protobufList.isModifiable()) {
                                    return;
                                }
                                this.mimes_ = GeneratedMessageLite.mutableCopy(protobufList);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setMimes(int i, String str) {
                                str.getClass();
                                ensureMimesIsMutable();
                                this.mimes_.set(i, str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void addMimes(String str) {
                                str.getClass();
                                ensureMimesIsMutable();
                                this.mimes_.add(str);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void addAllMimes(Iterable<String> iterable) {
                                ensureMimesIsMutable();
                                AbstractMessageLite.addAll((Iterable) iterable, (List) this.mimes_);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearMimes() {
                                this.mimes_ = GeneratedMessageLite.emptyProtobufList();
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void addMimesBytes(ByteString byteString) {
                                ensureMimesIsMutable();
                                this.mimes_.add(byteString.toStringUtf8());
                            }

                            public static Image parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                            }

                            public static Image parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                            }

                            public static Image parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                            }

                            public static Image parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                            }

                            public static Image parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                            }

                            public static Image parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                            }

                            public static Image parseFrom(InputStream inputStream) throws IOException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Image parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Image parseDelimitedFrom(InputStream inputStream) throws IOException {
                                return (Image) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Image parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Image) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Image parseFrom(CodedInputStream codedInputStream) throws IOException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                            }

                            public static Image parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Image) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder() {
                                return (Builder) DEFAULT_INSTANCE.createBuilder();
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder(Image image) {
                                return (Builder) DEFAULT_INSTANCE.createBuilder(image);
                            }

                            public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Image, Builder> implements ImageOrBuilder {
                                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                                    this();
                                }

                                private Builder() {
                                    super(Image.DEFAULT_INSTANCE);
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public boolean hasType() {
                                    return ((Image) this.instance).hasType();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public ImageAssetType getType() {
                                    return ((Image) this.instance).getType();
                                }

                                public Builder setType(ImageAssetType imageAssetType) {
                                    copyOnWrite();
                                    ((Image) this.instance).setType(imageAssetType);
                                    return this;
                                }

                                public Builder clearType() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearType();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public boolean hasW() {
                                    return ((Image) this.instance).hasW();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public int getW() {
                                    return ((Image) this.instance).getW();
                                }

                                public Builder setW(int i) {
                                    copyOnWrite();
                                    ((Image) this.instance).setW(i);
                                    return this;
                                }

                                public Builder clearW() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearW();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public boolean hasH() {
                                    return ((Image) this.instance).hasH();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public int getH() {
                                    return ((Image) this.instance).getH();
                                }

                                public Builder setH(int i) {
                                    copyOnWrite();
                                    ((Image) this.instance).setH(i);
                                    return this;
                                }

                                public Builder clearH() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearH();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public boolean hasWmin() {
                                    return ((Image) this.instance).hasWmin();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public int getWmin() {
                                    return ((Image) this.instance).getWmin();
                                }

                                public Builder setWmin(int i) {
                                    copyOnWrite();
                                    ((Image) this.instance).setWmin(i);
                                    return this;
                                }

                                public Builder clearWmin() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearWmin();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public boolean hasHmin() {
                                    return ((Image) this.instance).hasHmin();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public int getHmin() {
                                    return ((Image) this.instance).getHmin();
                                }

                                public Builder setHmin(int i) {
                                    copyOnWrite();
                                    ((Image) this.instance).setHmin(i);
                                    return this;
                                }

                                public Builder clearHmin() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearHmin();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public List<String> getMimesList() {
                                    return Collections.unmodifiableList(((Image) this.instance).getMimesList());
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public int getMimesCount() {
                                    return ((Image) this.instance).getMimesCount();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public String getMimes(int i) {
                                    return ((Image) this.instance).getMimes(i);
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.ImageOrBuilder
                                public ByteString getMimesBytes(int i) {
                                    return ((Image) this.instance).getMimesBytes(i);
                                }

                                public Builder setMimes(int i, String str) {
                                    copyOnWrite();
                                    ((Image) this.instance).setMimes(i, str);
                                    return this;
                                }

                                public Builder addMimes(String str) {
                                    copyOnWrite();
                                    ((Image) this.instance).addMimes(str);
                                    return this;
                                }

                                public Builder addAllMimes(Iterable<String> iterable) {
                                    copyOnWrite();
                                    ((Image) this.instance).addAllMimes(iterable);
                                    return this;
                                }

                                public Builder clearMimes() {
                                    copyOnWrite();
                                    ((Image) this.instance).clearMimes();
                                    return this;
                                }

                                public Builder addMimesBytes(ByteString byteString) {
                                    copyOnWrite();
                                    ((Image) this.instance).addMimesBytes(byteString);
                                    return this;
                                }
                            }

                            @Override // com.google.protobuf.GeneratedMessageLite
                            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                                AnonymousClass1 anonymousClass1 = null;
                                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                                    case 1:
                                        return new Image();
                                    case 2:
                                        return new Builder(anonymousClass1);
                                    case 3:
                                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006\u001a", new Object[]{"bitField0_", "type_", ImageAssetType.internalGetVerifier(), "w_", "h_", "wmin_", "hmin_", "mimes_"});
                                    case 4:
                                        return DEFAULT_INSTANCE;
                                    case 5:
                                        Parser<Image> defaultInstanceBasedParser = PARSER;
                                        if (defaultInstanceBasedParser == null) {
                                            synchronized (Image.class) {
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
                                        return Byte.valueOf(this.memoizedIsInitialized);
                                    case 7:
                                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                        return null;
                                    default:
                                        throw new UnsupportedOperationException();
                                }
                            }

                            static {
                                Image image = new Image();
                                DEFAULT_INSTANCE = image;
                                GeneratedMessageLite.registerDefaultInstance(Image.class, image);
                            }

                            public static Image getDefaultInstance() {
                                return DEFAULT_INSTANCE;
                            }

                            public static Parser<Image> parser() {
                                return DEFAULT_INSTANCE.getParserForType();
                            }
                        }

                        public static final class Data extends GeneratedMessageLite.ExtendableMessage<Data, Builder> implements DataOrBuilder {
                            private static final Data DEFAULT_INSTANCE;
                            public static final int LEN_FIELD_NUMBER = 2;
                            private static volatile Parser<Data> PARSER = null;
                            public static final int TYPE_FIELD_NUMBER = 1;
                            private int bitField0_;
                            private int len_;
                            private byte memoizedIsInitialized = 2;
                            private int type_ = 1;

                            private Data() {
                            }

                            public enum DataAssetType implements Internal.EnumLite {
                                SPONSORED(1),
                                DESC(2),
                                RATING(3),
                                LIKES(4),
                                DOWNLOADS(5),
                                PRICE(6),
                                SALEPRICE(7),
                                PHONE(8),
                                ADDRESS(9),
                                DESC2(10),
                                DISPLAYURL(11),
                                CTATEXT(12),
                                EXCHANGE_SPECIFIC(500);

                                public static final int ADDRESS_VALUE = 9;
                                public static final int CTATEXT_VALUE = 12;
                                public static final int DESC2_VALUE = 10;
                                public static final int DESC_VALUE = 2;
                                public static final int DISPLAYURL_VALUE = 11;
                                public static final int DOWNLOADS_VALUE = 5;
                                public static final int EXCHANGE_SPECIFIC_VALUE = 500;
                                public static final int LIKES_VALUE = 4;
                                public static final int PHONE_VALUE = 8;
                                public static final int PRICE_VALUE = 6;
                                public static final int RATING_VALUE = 3;
                                public static final int SALEPRICE_VALUE = 7;
                                public static final int SPONSORED_VALUE = 1;
                                private static final Internal.EnumLiteMap<DataAssetType> internalValueMap = new Internal.EnumLiteMap<DataAssetType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.Data.DataAssetType.1
                                    @Override // com.google.protobuf.Internal.EnumLiteMap
                                    public DataAssetType findValueByNumber(int i) {
                                        return DataAssetType.forNumber(i);
                                    }
                                };
                                private final int value;

                                @Override // com.google.protobuf.Internal.EnumLite
                                public final int getNumber() {
                                    return this.value;
                                }

                                @Deprecated
                                public static DataAssetType valueOf(int i) {
                                    return forNumber(i);
                                }

                                public static DataAssetType forNumber(int i) {
                                    if (i != 500) {
                                        switch (i) {
                                            case 1:
                                                return SPONSORED;
                                            case 2:
                                                return DESC;
                                            case 3:
                                                return RATING;
                                            case 4:
                                                return LIKES;
                                            case 5:
                                                return DOWNLOADS;
                                            case 6:
                                                return PRICE;
                                            case 7:
                                                return SALEPRICE;
                                            case 8:
                                                return PHONE;
                                            case 9:
                                                return ADDRESS;
                                            case 10:
                                                return DESC2;
                                            case 11:
                                                return DISPLAYURL;
                                            case 12:
                                                return CTATEXT;
                                            default:
                                                return null;
                                        }
                                    }
                                    return EXCHANGE_SPECIFIC;
                                }

                                public static Internal.EnumLiteMap<DataAssetType> internalGetValueMap() {
                                    return internalValueMap;
                                }

                                public static Internal.EnumVerifier internalGetVerifier() {
                                    return DataAssetTypeVerifier.INSTANCE;
                                }

                                private static final class DataAssetTypeVerifier implements Internal.EnumVerifier {
                                    static final Internal.EnumVerifier INSTANCE = new DataAssetTypeVerifier();

                                    private DataAssetTypeVerifier() {
                                    }

                                    @Override // com.google.protobuf.Internal.EnumVerifier
                                    public boolean isInRange(int i) {
                                        return DataAssetType.forNumber(i) != null;
                                    }
                                }

                                DataAssetType(int i) {
                                    this.value = i;
                                }
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                            public boolean hasType() {
                                return (this.bitField0_ & 1) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                            public DataAssetType getType() {
                                DataAssetType dataAssetTypeForNumber = DataAssetType.forNumber(this.type_);
                                return dataAssetTypeForNumber == null ? DataAssetType.SPONSORED : dataAssetTypeForNumber;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setType(DataAssetType dataAssetType) {
                                this.type_ = dataAssetType.getNumber();
                                this.bitField0_ |= 1;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearType() {
                                this.bitField0_ &= -2;
                                this.type_ = 1;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                            public boolean hasLen() {
                                return (this.bitField0_ & 2) != 0;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                            public int getLen() {
                                return this.len_;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void setLen(int i) {
                                this.bitField0_ |= 2;
                                this.len_ = i;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public void clearLen() {
                                this.bitField0_ &= -3;
                                this.len_ = 0;
                            }

                            public static Data parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                            }

                            public static Data parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                            }

                            public static Data parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                            }

                            public static Data parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                            }

                            public static Data parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                            }

                            public static Data parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                            }

                            public static Data parseFrom(InputStream inputStream) throws IOException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Data parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Data parseDelimitedFrom(InputStream inputStream) throws IOException {
                                return (Data) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                            }

                            public static Data parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Data) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                            }

                            public static Data parseFrom(CodedInputStream codedInputStream) throws IOException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                            }

                            public static Data parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                                return (Data) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder() {
                                return (Builder) DEFAULT_INSTANCE.createBuilder();
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public static Builder newBuilder(Data data) {
                                return (Builder) DEFAULT_INSTANCE.createBuilder(data);
                            }

                            public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Data, Builder> implements DataOrBuilder {
                                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                                    this();
                                }

                                private Builder() {
                                    super(Data.DEFAULT_INSTANCE);
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                                public boolean hasType() {
                                    return ((Data) this.instance).hasType();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                                public DataAssetType getType() {
                                    return ((Data) this.instance).getType();
                                }

                                public Builder setType(DataAssetType dataAssetType) {
                                    copyOnWrite();
                                    ((Data) this.instance).setType(dataAssetType);
                                    return this;
                                }

                                public Builder clearType() {
                                    copyOnWrite();
                                    ((Data) this.instance).clearType();
                                    return this;
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                                public boolean hasLen() {
                                    return ((Data) this.instance).hasLen();
                                }

                                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.Asset.DataOrBuilder
                                public int getLen() {
                                    return ((Data) this.instance).getLen();
                                }

                                public Builder setLen(int i) {
                                    copyOnWrite();
                                    ((Data) this.instance).setLen(i);
                                    return this;
                                }

                                public Builder clearLen() {
                                    copyOnWrite();
                                    ((Data) this.instance).clearLen();
                                    return this;
                                }
                            }

                            @Override // com.google.protobuf.GeneratedMessageLite
                            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                                AnonymousClass1 anonymousClass1 = null;
                                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                                    case 1:
                                        return new Data();
                                    case 2:
                                        return new Builder(anonymousClass1);
                                    case 3:
                                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001", new Object[]{"bitField0_", "type_", DataAssetType.internalGetVerifier(), "len_"});
                                    case 4:
                                        return DEFAULT_INSTANCE;
                                    case 5:
                                        Parser<Data> defaultInstanceBasedParser = PARSER;
                                        if (defaultInstanceBasedParser == null) {
                                            synchronized (Data.class) {
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
                                        return Byte.valueOf(this.memoizedIsInitialized);
                                    case 7:
                                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                        return null;
                                    default:
                                        throw new UnsupportedOperationException();
                                }
                            }

                            static {
                                Data data = new Data();
                                DEFAULT_INSTANCE = data;
                                GeneratedMessageLite.registerDefaultInstance(Data.class, data);
                            }

                            public static Data getDefaultInstance() {
                                return DEFAULT_INSTANCE;
                            }

                            public static Parser<Data> parser() {
                                return DEFAULT_INSTANCE.getParserForType();
                            }
                        }

                        public enum AssetOneofCase {
                            TITLE(3),
                            IMG(4),
                            VIDEO(5),
                            DATA(6),
                            ASSETONEOF_NOT_SET(0);

                            private final int value;

                            AssetOneofCase(int i) {
                                this.value = i;
                            }

                            @Deprecated
                            public static AssetOneofCase valueOf(int i) {
                                return forNumber(i);
                            }

                            public static AssetOneofCase forNumber(int i) {
                                if (i == 0) {
                                    return ASSETONEOF_NOT_SET;
                                }
                                if (i == 3) {
                                    return TITLE;
                                }
                                if (i == 4) {
                                    return IMG;
                                }
                                if (i == 5) {
                                    return VIDEO;
                                }
                                if (i != 6) {
                                    return null;
                                }
                                return DATA;
                            }

                            public int getNumber() {
                                return this.value;
                            }
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public AssetOneofCase getAssetOneofCase() {
                            return AssetOneofCase.forNumber(this.assetOneofCase_);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearAssetOneof() {
                            this.assetOneofCase_ = 0;
                            this.assetOneof_ = null;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasId() {
                            return (this.bitField0_ & 1) != 0;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public int getId() {
                            return this.id_;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setId(int i) {
                            this.bitField0_ |= 1;
                            this.id_ = i;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearId() {
                            this.bitField0_ &= -2;
                            this.id_ = 0;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasRequired() {
                            return (this.bitField0_ & 2) != 0;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean getRequired() {
                            return this.required_;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setRequired(boolean z) {
                            this.bitField0_ |= 2;
                            this.required_ = z;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearRequired() {
                            this.bitField0_ &= -3;
                            this.required_ = false;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasTitle() {
                            return this.assetOneofCase_ == 3;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public Title getTitle() {
                            if (this.assetOneofCase_ == 3) {
                                return (Title) this.assetOneof_;
                            }
                            return Title.getDefaultInstance();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setTitle(Title title) {
                            title.getClass();
                            this.assetOneof_ = title;
                            this.assetOneofCase_ = 3;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Multi-variable type inference failed */
                        public void mergeTitle(Title title) {
                            title.getClass();
                            if (this.assetOneofCase_ == 3 && this.assetOneof_ != Title.getDefaultInstance()) {
                                this.assetOneof_ = ((Title.Builder) Title.newBuilder((Title) this.assetOneof_).mergeFrom(title)).buildPartial();
                            } else {
                                this.assetOneof_ = title;
                            }
                            this.assetOneofCase_ = 3;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearTitle() {
                            if (this.assetOneofCase_ == 3) {
                                this.assetOneofCase_ = 0;
                                this.assetOneof_ = null;
                            }
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasImg() {
                            return this.assetOneofCase_ == 4;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public Image getImg() {
                            if (this.assetOneofCase_ == 4) {
                                return (Image) this.assetOneof_;
                            }
                            return Image.getDefaultInstance();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setImg(Image image) {
                            image.getClass();
                            this.assetOneof_ = image;
                            this.assetOneofCase_ = 4;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Multi-variable type inference failed */
                        public void mergeImg(Image image) {
                            image.getClass();
                            if (this.assetOneofCase_ == 4 && this.assetOneof_ != Image.getDefaultInstance()) {
                                this.assetOneof_ = ((Image.Builder) Image.newBuilder((Image) this.assetOneof_).mergeFrom(image)).buildPartial();
                            } else {
                                this.assetOneof_ = image;
                            }
                            this.assetOneofCase_ = 4;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearImg() {
                            if (this.assetOneofCase_ == 4) {
                                this.assetOneofCase_ = 0;
                                this.assetOneof_ = null;
                            }
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasVideo() {
                            return this.assetOneofCase_ == 5;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public Video getVideo() {
                            if (this.assetOneofCase_ == 5) {
                                return (Video) this.assetOneof_;
                            }
                            return Video.getDefaultInstance();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setVideo(Video video) {
                            video.getClass();
                            this.assetOneof_ = video;
                            this.assetOneofCase_ = 5;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Multi-variable type inference failed */
                        public void mergeVideo(Video video) {
                            video.getClass();
                            if (this.assetOneofCase_ == 5 && this.assetOneof_ != Video.getDefaultInstance()) {
                                this.assetOneof_ = ((Video.Builder) Video.newBuilder((Video) this.assetOneof_).mergeFrom(video)).buildPartial();
                            } else {
                                this.assetOneof_ = video;
                            }
                            this.assetOneofCase_ = 5;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearVideo() {
                            if (this.assetOneofCase_ == 5) {
                                this.assetOneofCase_ = 0;
                                this.assetOneof_ = null;
                            }
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public boolean hasData() {
                            return this.assetOneofCase_ == 6;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                        public Data getData() {
                            if (this.assetOneofCase_ == 6) {
                                return (Data) this.assetOneof_;
                            }
                            return Data.getDefaultInstance();
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setData(Data data) {
                            data.getClass();
                            this.assetOneof_ = data;
                            this.assetOneofCase_ = 6;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        /* JADX WARN: Multi-variable type inference failed */
                        public void mergeData(Data data) {
                            data.getClass();
                            if (this.assetOneofCase_ == 6 && this.assetOneof_ != Data.getDefaultInstance()) {
                                this.assetOneof_ = ((Data.Builder) Data.newBuilder((Data) this.assetOneof_).mergeFrom(data)).buildPartial();
                            } else {
                                this.assetOneof_ = data;
                            }
                            this.assetOneofCase_ = 6;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearData() {
                            if (this.assetOneofCase_ == 6) {
                                this.assetOneofCase_ = 0;
                                this.assetOneof_ = null;
                            }
                        }

                        public static Asset parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                        }

                        public static Asset parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                        }

                        public static Asset parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                        }

                        public static Asset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                        }

                        public static Asset parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                        }

                        public static Asset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                        }

                        public static Asset parseFrom(InputStream inputStream) throws IOException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                        }

                        public static Asset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                        }

                        public static Asset parseDelimitedFrom(InputStream inputStream) throws IOException {
                            return (Asset) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                        }

                        public static Asset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (Asset) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                        }

                        public static Asset parseFrom(CodedInputStream codedInputStream) throws IOException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                        }

                        public static Asset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (Asset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public static Builder newBuilder() {
                            return (Builder) DEFAULT_INSTANCE.createBuilder();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public static Builder newBuilder(Asset asset) {
                            return (Builder) DEFAULT_INSTANCE.createBuilder(asset);
                        }

                        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Asset, Builder> implements AssetOrBuilder {
                            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                                this();
                            }

                            private Builder() {
                                super(Asset.DEFAULT_INSTANCE);
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public AssetOneofCase getAssetOneofCase() {
                                return ((Asset) this.instance).getAssetOneofCase();
                            }

                            public Builder clearAssetOneof() {
                                copyOnWrite();
                                ((Asset) this.instance).clearAssetOneof();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasId() {
                                return ((Asset) this.instance).hasId();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public int getId() {
                                return ((Asset) this.instance).getId();
                            }

                            public Builder setId(int i) {
                                copyOnWrite();
                                ((Asset) this.instance).setId(i);
                                return this;
                            }

                            public Builder clearId() {
                                copyOnWrite();
                                ((Asset) this.instance).clearId();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasRequired() {
                                return ((Asset) this.instance).hasRequired();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean getRequired() {
                                return ((Asset) this.instance).getRequired();
                            }

                            public Builder setRequired(boolean z) {
                                copyOnWrite();
                                ((Asset) this.instance).setRequired(z);
                                return this;
                            }

                            public Builder clearRequired() {
                                copyOnWrite();
                                ((Asset) this.instance).clearRequired();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasTitle() {
                                return ((Asset) this.instance).hasTitle();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public Title getTitle() {
                                return ((Asset) this.instance).getTitle();
                            }

                            public Builder setTitle(Title title) {
                                copyOnWrite();
                                ((Asset) this.instance).setTitle(title);
                                return this;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public Builder setTitle(Title.Builder builder) {
                                copyOnWrite();
                                ((Asset) this.instance).setTitle((Title) builder.build());
                                return this;
                            }

                            public Builder mergeTitle(Title title) {
                                copyOnWrite();
                                ((Asset) this.instance).mergeTitle(title);
                                return this;
                            }

                            public Builder clearTitle() {
                                copyOnWrite();
                                ((Asset) this.instance).clearTitle();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasImg() {
                                return ((Asset) this.instance).hasImg();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public Image getImg() {
                                return ((Asset) this.instance).getImg();
                            }

                            public Builder setImg(Image image) {
                                copyOnWrite();
                                ((Asset) this.instance).setImg(image);
                                return this;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public Builder setImg(Image.Builder builder) {
                                copyOnWrite();
                                ((Asset) this.instance).setImg((Image) builder.build());
                                return this;
                            }

                            public Builder mergeImg(Image image) {
                                copyOnWrite();
                                ((Asset) this.instance).mergeImg(image);
                                return this;
                            }

                            public Builder clearImg() {
                                copyOnWrite();
                                ((Asset) this.instance).clearImg();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasVideo() {
                                return ((Asset) this.instance).hasVideo();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public Video getVideo() {
                                return ((Asset) this.instance).getVideo();
                            }

                            public Builder setVideo(Video video) {
                                copyOnWrite();
                                ((Asset) this.instance).setVideo(video);
                                return this;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public Builder setVideo(Video.Builder builder) {
                                copyOnWrite();
                                ((Asset) this.instance).setVideo((Video) builder.build());
                                return this;
                            }

                            public Builder mergeVideo(Video video) {
                                copyOnWrite();
                                ((Asset) this.instance).mergeVideo(video);
                                return this;
                            }

                            public Builder clearVideo() {
                                copyOnWrite();
                                ((Asset) this.instance).clearVideo();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public boolean hasData() {
                                return ((Asset) this.instance).hasData();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.AssetOrBuilder
                            public Data getData() {
                                return ((Asset) this.instance).getData();
                            }

                            public Builder setData(Data data) {
                                copyOnWrite();
                                ((Asset) this.instance).setData(data);
                                return this;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            public Builder setData(Data.Builder builder) {
                                copyOnWrite();
                                ((Asset) this.instance).setData((Data) builder.build());
                                return this;
                            }

                            public Builder mergeData(Data data) {
                                copyOnWrite();
                                ((Asset) this.instance).mergeData(data);
                                return this;
                            }

                            public Builder clearData() {
                                copyOnWrite();
                                ((Asset) this.instance).clearData();
                                return this;
                            }
                        }

                        @Override // com.google.protobuf.GeneratedMessageLite
                        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                            AnonymousClass1 anonymousClass1 = null;
                            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                                case 1:
                                    return new Asset();
                                case 2:
                                    return new Builder(anonymousClass1);
                                case 3:
                                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0005\u0001ᔄ\u0000\u0002ဇ\u0001\u0003ᐼ\u0000\u0004ᐼ\u0000\u0005ᐼ\u0000\u0006ᐼ\u0000", new Object[]{"assetOneof_", "assetOneofCase_", "bitField0_", "id_", "required_", Title.class, Image.class, Video.class, Data.class});
                                case 4:
                                    return DEFAULT_INSTANCE;
                                case 5:
                                    Parser<Asset> defaultInstanceBasedParser = PARSER;
                                    if (defaultInstanceBasedParser == null) {
                                        synchronized (Asset.class) {
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
                                    return Byte.valueOf(this.memoizedIsInitialized);
                                case 7:
                                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                    return null;
                                default:
                                    throw new UnsupportedOperationException();
                            }
                        }

                        static {
                            Asset asset = new Asset();
                            DEFAULT_INSTANCE = asset;
                            GeneratedMessageLite.registerDefaultInstance(Asset.class, asset);
                        }

                        public static Asset getDefaultInstance() {
                            return DEFAULT_INSTANCE;
                        }

                        public static Parser<Asset> parser() {
                            return DEFAULT_INSTANCE.getParserForType();
                        }
                    }

                    public static final class EventTrackers extends GeneratedMessageLite.ExtendableMessage<EventTrackers, Builder> implements EventTrackersOrBuilder {
                        private static final EventTrackers DEFAULT_INSTANCE;
                        public static final int EVENT_FIELD_NUMBER = 1;
                        public static final int METHODS_FIELD_NUMBER = 2;
                        private static volatile Parser<EventTrackers> PARSER;
                        private static final Internal.ListAdapter.Converter<Integer, EventTrackingMethod> methods_converter_ = new Internal.ListAdapter.Converter<Integer, EventTrackingMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackers.1
                            @Override // com.google.protobuf.Internal.ListAdapter.Converter
                            public EventTrackingMethod convert(Integer num) {
                                EventTrackingMethod eventTrackingMethodForNumber = EventTrackingMethod.forNumber(num.intValue());
                                return eventTrackingMethodForNumber == null ? EventTrackingMethod.IMG : eventTrackingMethodForNumber;
                            }
                        };
                        private int bitField0_;
                        private int event_;
                        private byte memoizedIsInitialized = 2;
                        private Internal.IntList methods_ = emptyIntList();

                        private EventTrackers() {
                        }

                        public enum EventType implements Internal.EnumLite {
                            UNKNOWN_EVENT(0),
                            MAKE_BID(6),
                            WIN(1),
                            IMP(2),
                            IMP_EXTRA(14),
                            CLICK(3),
                            POSTBACK(5),
                            INSTALL(4),
                            CUSTOM_ACTION(23),
                            CUSTOM_KPI_ACTION(24),
                            FIRST_PURCHASE(9),
                            PURCHASE(10),
                            LEGACY_FIRST_PURCHASE(11),
                            CALL(12),
                            FIRST_CALL(13),
                            DELIVERY(15),
                            REENGAGE(16),
                            REGISTER(17),
                            AUTHORIZE(20),
                            VAST(7),
                            SPEND(8),
                            OPEN_COMMUNITY(18),
                            INVITE(19),
                            INSTALL_CT(21),
                            INSTALL_VT(22),
                            CUSTOM_ACTION_00(100),
                            CUSTOM_ACTION_01(101),
                            CUSTOM_ACTION_02(102),
                            CUSTOM_ACTION_03(103),
                            CUSTOM_ACTION_04(104),
                            CUSTOM_ACTION_05(105),
                            CUSTOM_ACTION_06(106),
                            CUSTOM_ACTION_07(107),
                            CUSTOM_ACTION_08(108),
                            CUSTOM_ACTION_09(109),
                            CUSTOM_ACTION_10(110),
                            CUSTOM_ACTION_11(111),
                            CUSTOM_ACTION_12(112),
                            CUSTOM_ACTION_13(113),
                            CUSTOM_ACTION_14(114),
                            CUSTOM_ACTION_15(115);

                            public static final int AUTHORIZE_VALUE = 20;
                            public static final int CALL_VALUE = 12;
                            public static final int CLICK_VALUE = 3;
                            public static final int CUSTOM_ACTION_00_VALUE = 100;
                            public static final int CUSTOM_ACTION_01_VALUE = 101;
                            public static final int CUSTOM_ACTION_02_VALUE = 102;
                            public static final int CUSTOM_ACTION_03_VALUE = 103;
                            public static final int CUSTOM_ACTION_04_VALUE = 104;
                            public static final int CUSTOM_ACTION_05_VALUE = 105;
                            public static final int CUSTOM_ACTION_06_VALUE = 106;
                            public static final int CUSTOM_ACTION_07_VALUE = 107;
                            public static final int CUSTOM_ACTION_08_VALUE = 108;
                            public static final int CUSTOM_ACTION_09_VALUE = 109;
                            public static final int CUSTOM_ACTION_10_VALUE = 110;
                            public static final int CUSTOM_ACTION_11_VALUE = 111;
                            public static final int CUSTOM_ACTION_12_VALUE = 112;
                            public static final int CUSTOM_ACTION_13_VALUE = 113;
                            public static final int CUSTOM_ACTION_14_VALUE = 114;
                            public static final int CUSTOM_ACTION_15_VALUE = 115;
                            public static final int CUSTOM_ACTION_VALUE = 23;
                            public static final int CUSTOM_KPI_ACTION_VALUE = 24;
                            public static final int DELIVERY_VALUE = 15;
                            public static final int FIRST_CALL_VALUE = 13;
                            public static final int FIRST_PURCHASE_VALUE = 9;
                            public static final int IMP_EXTRA_VALUE = 14;
                            public static final int IMP_VALUE = 2;
                            public static final int INSTALL_CT_VALUE = 21;
                            public static final int INSTALL_VALUE = 4;
                            public static final int INSTALL_VT_VALUE = 22;
                            public static final int INVITE_VALUE = 19;
                            public static final int LEGACY_FIRST_PURCHASE_VALUE = 11;
                            public static final int MAKE_BID_VALUE = 6;
                            public static final int OPEN_COMMUNITY_VALUE = 18;
                            public static final int POSTBACK_VALUE = 5;
                            public static final int PURCHASE_VALUE = 10;
                            public static final int REENGAGE_VALUE = 16;
                            public static final int REGISTER_VALUE = 17;
                            public static final int SPEND_VALUE = 8;
                            public static final int UNKNOWN_EVENT_VALUE = 0;
                            public static final int VAST_VALUE = 7;
                            public static final int WIN_VALUE = 1;
                            private static final Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap<EventType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackers.EventType.1
                                @Override // com.google.protobuf.Internal.EnumLiteMap
                                public EventType findValueByNumber(int i) {
                                    return EventType.forNumber(i);
                                }
                            };
                            private final int value;

                            @Override // com.google.protobuf.Internal.EnumLite
                            public final int getNumber() {
                                return this.value;
                            }

                            @Deprecated
                            public static EventType valueOf(int i) {
                                return forNumber(i);
                            }

                            public static EventType forNumber(int i) {
                                switch (i) {
                                    case 0:
                                        return UNKNOWN_EVENT;
                                    case 1:
                                        return WIN;
                                    case 2:
                                        return IMP;
                                    case 3:
                                        return CLICK;
                                    case 4:
                                        return INSTALL;
                                    case 5:
                                        return POSTBACK;
                                    case 6:
                                        return MAKE_BID;
                                    case 7:
                                        return VAST;
                                    case 8:
                                        return SPEND;
                                    case 9:
                                        return FIRST_PURCHASE;
                                    case 10:
                                        return PURCHASE;
                                    case 11:
                                        return LEGACY_FIRST_PURCHASE;
                                    case 12:
                                        return CALL;
                                    case 13:
                                        return FIRST_CALL;
                                    case 14:
                                        return IMP_EXTRA;
                                    case 15:
                                        return DELIVERY;
                                    case 16:
                                        return REENGAGE;
                                    case 17:
                                        return REGISTER;
                                    case 18:
                                        return OPEN_COMMUNITY;
                                    case 19:
                                        return INVITE;
                                    case 20:
                                        return AUTHORIZE;
                                    case 21:
                                        return INSTALL_CT;
                                    case 22:
                                        return INSTALL_VT;
                                    case 23:
                                        return CUSTOM_ACTION;
                                    case 24:
                                        return CUSTOM_KPI_ACTION;
                                    default:
                                        switch (i) {
                                            case 100:
                                                return CUSTOM_ACTION_00;
                                            case 101:
                                                return CUSTOM_ACTION_01;
                                            case 102:
                                                return CUSTOM_ACTION_02;
                                            case 103:
                                                return CUSTOM_ACTION_03;
                                            case 104:
                                                return CUSTOM_ACTION_04;
                                            case 105:
                                                return CUSTOM_ACTION_05;
                                            case 106:
                                                return CUSTOM_ACTION_06;
                                            case 107:
                                                return CUSTOM_ACTION_07;
                                            case 108:
                                                return CUSTOM_ACTION_08;
                                            case 109:
                                                return CUSTOM_ACTION_09;
                                            case 110:
                                                return CUSTOM_ACTION_10;
                                            case 111:
                                                return CUSTOM_ACTION_11;
                                            case 112:
                                                return CUSTOM_ACTION_12;
                                            case 113:
                                                return CUSTOM_ACTION_13;
                                            case 114:
                                                return CUSTOM_ACTION_14;
                                            case 115:
                                                return CUSTOM_ACTION_15;
                                            default:
                                                return null;
                                        }
                                }
                            }

                            public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
                                return internalValueMap;
                            }

                            public static Internal.EnumVerifier internalGetVerifier() {
                                return EventTypeVerifier.INSTANCE;
                            }

                            private static final class EventTypeVerifier implements Internal.EnumVerifier {
                                static final Internal.EnumVerifier INSTANCE = new EventTypeVerifier();

                                private EventTypeVerifier() {
                                }

                                @Override // com.google.protobuf.Internal.EnumVerifier
                                public boolean isInRange(int i) {
                                    return EventType.forNumber(i) != null;
                                }
                            }

                            EventType(int i) {
                                this.value = i;
                            }
                        }

                        public enum EventTrackingMethod implements Internal.EnumLite {
                            IMG(1),
                            JS(2);

                            public static final int IMG_VALUE = 1;
                            public static final int JS_VALUE = 2;
                            private static final Internal.EnumLiteMap<EventTrackingMethod> internalValueMap = new Internal.EnumLiteMap<EventTrackingMethod>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackers.EventTrackingMethod.1
                                @Override // com.google.protobuf.Internal.EnumLiteMap
                                public EventTrackingMethod findValueByNumber(int i) {
                                    return EventTrackingMethod.forNumber(i);
                                }
                            };
                            private final int value;

                            @Override // com.google.protobuf.Internal.EnumLite
                            public final int getNumber() {
                                return this.value;
                            }

                            @Deprecated
                            public static EventTrackingMethod valueOf(int i) {
                                return forNumber(i);
                            }

                            public static EventTrackingMethod forNumber(int i) {
                                if (i == 1) {
                                    return IMG;
                                }
                                if (i != 2) {
                                    return null;
                                }
                                return JS;
                            }

                            public static Internal.EnumLiteMap<EventTrackingMethod> internalGetValueMap() {
                                return internalValueMap;
                            }

                            public static Internal.EnumVerifier internalGetVerifier() {
                                return EventTrackingMethodVerifier.INSTANCE;
                            }

                            private static final class EventTrackingMethodVerifier implements Internal.EnumVerifier {
                                static final Internal.EnumVerifier INSTANCE = new EventTrackingMethodVerifier();

                                private EventTrackingMethodVerifier() {
                                }

                                @Override // com.google.protobuf.Internal.EnumVerifier
                                public boolean isInRange(int i) {
                                    return EventTrackingMethod.forNumber(i) != null;
                                }
                            }

                            EventTrackingMethod(int i) {
                                this.value = i;
                            }
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                        public boolean hasEvent() {
                            return (this.bitField0_ & 1) != 0;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                        public EventType getEvent() {
                            EventType eventTypeForNumber = EventType.forNumber(this.event_);
                            return eventTypeForNumber == null ? EventType.UNKNOWN_EVENT : eventTypeForNumber;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setEvent(EventType eventType) {
                            this.event_ = eventType.getNumber();
                            this.bitField0_ |= 1;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearEvent() {
                            this.bitField0_ &= -2;
                            this.event_ = 0;
                        }

                        static {
                            EventTrackers eventTrackers = new EventTrackers();
                            DEFAULT_INSTANCE = eventTrackers;
                            GeneratedMessageLite.registerDefaultInstance(EventTrackers.class, eventTrackers);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                        public List<EventTrackingMethod> getMethodsList() {
                            return new Internal.ListAdapter(this.methods_, methods_converter_);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                        public int getMethodsCount() {
                            return this.methods_.size();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                        public EventTrackingMethod getMethods(int i) {
                            EventTrackingMethod eventTrackingMethodForNumber = EventTrackingMethod.forNumber(this.methods_.getInt(i));
                            return eventTrackingMethodForNumber == null ? EventTrackingMethod.IMG : eventTrackingMethodForNumber;
                        }

                        private void ensureMethodsIsMutable() {
                            Internal.IntList intList = this.methods_;
                            if (intList.isModifiable()) {
                                return;
                            }
                            this.methods_ = GeneratedMessageLite.mutableCopy(intList);
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void setMethods(int i, EventTrackingMethod eventTrackingMethod) {
                            eventTrackingMethod.getClass();
                            ensureMethodsIsMutable();
                            this.methods_.setInt(i, eventTrackingMethod.getNumber());
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void addMethods(EventTrackingMethod eventTrackingMethod) {
                            eventTrackingMethod.getClass();
                            ensureMethodsIsMutable();
                            this.methods_.addInt(eventTrackingMethod.getNumber());
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void addAllMethods(Iterable<? extends EventTrackingMethod> iterable) {
                            ensureMethodsIsMutable();
                            Iterator<? extends EventTrackingMethod> it = iterable.iterator();
                            while (it.hasNext()) {
                                this.methods_.addInt(it.next().getNumber());
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public void clearMethods() {
                            this.methods_ = emptyIntList();
                        }

                        public static EventTrackers parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                        }

                        public static EventTrackers parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                        }

                        public static EventTrackers parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                        }

                        public static EventTrackers parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                        }

                        public static EventTrackers parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                        }

                        public static EventTrackers parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                        }

                        public static EventTrackers parseFrom(InputStream inputStream) throws IOException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                        }

                        public static EventTrackers parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                        }

                        public static EventTrackers parseDelimitedFrom(InputStream inputStream) throws IOException {
                            return (EventTrackers) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                        }

                        public static EventTrackers parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (EventTrackers) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                        }

                        public static EventTrackers parseFrom(CodedInputStream codedInputStream) throws IOException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                        }

                        public static EventTrackers parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                            return (EventTrackers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public static Builder newBuilder() {
                            return (Builder) DEFAULT_INSTANCE.createBuilder();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public static Builder newBuilder(EventTrackers eventTrackers) {
                            return (Builder) DEFAULT_INSTANCE.createBuilder(eventTrackers);
                        }

                        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EventTrackers, Builder> implements EventTrackersOrBuilder {
                            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                                this();
                            }

                            private Builder() {
                                super(EventTrackers.DEFAULT_INSTANCE);
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                            public boolean hasEvent() {
                                return ((EventTrackers) this.instance).hasEvent();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                            public EventType getEvent() {
                                return ((EventTrackers) this.instance).getEvent();
                            }

                            public Builder setEvent(EventType eventType) {
                                copyOnWrite();
                                ((EventTrackers) this.instance).setEvent(eventType);
                                return this;
                            }

                            public Builder clearEvent() {
                                copyOnWrite();
                                ((EventTrackers) this.instance).clearEvent();
                                return this;
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                            public List<EventTrackingMethod> getMethodsList() {
                                return ((EventTrackers) this.instance).getMethodsList();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                            public int getMethodsCount() {
                                return ((EventTrackers) this.instance).getMethodsCount();
                            }

                            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequest.EventTrackersOrBuilder
                            public EventTrackingMethod getMethods(int i) {
                                return ((EventTrackers) this.instance).getMethods(i);
                            }

                            public Builder setMethods(int i, EventTrackingMethod eventTrackingMethod) {
                                copyOnWrite();
                                ((EventTrackers) this.instance).setMethods(i, eventTrackingMethod);
                                return this;
                            }

                            public Builder addMethods(EventTrackingMethod eventTrackingMethod) {
                                copyOnWrite();
                                ((EventTrackers) this.instance).addMethods(eventTrackingMethod);
                                return this;
                            }

                            public Builder addAllMethods(Iterable<? extends EventTrackingMethod> iterable) {
                                copyOnWrite();
                                ((EventTrackers) this.instance).addAllMethods(iterable);
                                return this;
                            }

                            public Builder clearMethods() {
                                copyOnWrite();
                                ((EventTrackers) this.instance).clearMethods();
                                return this;
                            }
                        }

                        @Override // com.google.protobuf.GeneratedMessageLite
                        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                            AnonymousClass1 anonymousClass1 = null;
                            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                                case 1:
                                    return new EventTrackers();
                                case 2:
                                    return new Builder(anonymousClass1);
                                case 3:
                                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ᔌ\u0000\u0002\u001e", new Object[]{"bitField0_", "event_", EventType.internalGetVerifier(), "methods_", EventTrackingMethod.internalGetVerifier()});
                                case 4:
                                    return DEFAULT_INSTANCE;
                                case 5:
                                    Parser<EventTrackers> defaultInstanceBasedParser = PARSER;
                                    if (defaultInstanceBasedParser == null) {
                                        synchronized (EventTrackers.class) {
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
                                    return Byte.valueOf(this.memoizedIsInitialized);
                                case 7:
                                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                    return null;
                                default:
                                    throw new UnsupportedOperationException();
                            }
                        }

                        public static EventTrackers getDefaultInstance() {
                            return DEFAULT_INSTANCE;
                        }

                        public static Parser<EventTrackers> parser() {
                            return DEFAULT_INSTANCE.getParserForType();
                        }
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasVer() {
                        return (this.bitField0_ & 1) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public String getVer() {
                        return this.ver_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public ByteString getVerBytes() {
                        return ByteString.copyFromUtf8(this.ver_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setVer(String str) {
                        str.getClass();
                        this.bitField0_ |= 1;
                        this.ver_ = str;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearVer() {
                        this.bitField0_ &= -2;
                        this.ver_ = getDefaultInstance().getVer();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setVerBytes(ByteString byteString) {
                        this.ver_ = byteString.toStringUtf8();
                        this.bitField0_ |= 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasContext() {
                        return (this.bitField0_ & 2) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public ContextType getContext() {
                        ContextType contextTypeForNumber = ContextType.forNumber(this.context_);
                        return contextTypeForNumber == null ? ContextType.CONTENT : contextTypeForNumber;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setContext(ContextType contextType) {
                        this.context_ = contextType.getNumber();
                        this.bitField0_ |= 2;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearContext() {
                        this.bitField0_ &= -3;
                        this.context_ = 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasContextsubtype() {
                        return (this.bitField0_ & 4) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public ContextSubtype getContextsubtype() {
                        ContextSubtype contextSubtypeForNumber = ContextSubtype.forNumber(this.contextsubtype_);
                        return contextSubtypeForNumber == null ? ContextSubtype.CONTENT_GENERAL_OR_MIXED : contextSubtypeForNumber;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setContextsubtype(ContextSubtype contextSubtype) {
                        this.contextsubtype_ = contextSubtype.getNumber();
                        this.bitField0_ |= 4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearContextsubtype() {
                        this.bitField0_ &= -5;
                        this.contextsubtype_ = 10;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasPlcmttype() {
                        return (this.bitField0_ & 8) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public PlacementType getPlcmttype() {
                        PlacementType placementTypeForNumber = PlacementType.forNumber(this.plcmttype_);
                        return placementTypeForNumber == null ? PlacementType.IN_FEED : placementTypeForNumber;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setPlcmttype(PlacementType placementType) {
                        this.plcmttype_ = placementType.getNumber();
                        this.bitField0_ |= 8;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearPlcmttype() {
                        this.bitField0_ &= -9;
                        this.plcmttype_ = 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasPlcmtcnt() {
                        return (this.bitField0_ & 16) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public int getPlcmtcnt() {
                        return this.plcmtcnt_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setPlcmtcnt(int i) {
                        this.bitField0_ |= 16;
                        this.plcmtcnt_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearPlcmtcnt() {
                        this.bitField0_ &= -17;
                        this.plcmtcnt_ = 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasSeq() {
                        return (this.bitField0_ & 32) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public int getSeq() {
                        return this.seq_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setSeq(int i) {
                        this.bitField0_ |= 32;
                        this.seq_ = i;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearSeq() {
                        this.bitField0_ &= -33;
                        this.seq_ = 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public List<Asset> getAssetsList() {
                        return this.assets_;
                    }

                    public List<? extends AssetOrBuilder> getAssetsOrBuilderList() {
                        return this.assets_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public int getAssetsCount() {
                        return this.assets_.size();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public Asset getAssets(int i) {
                        return this.assets_.get(i);
                    }

                    public AssetOrBuilder getAssetsOrBuilder(int i) {
                        return this.assets_.get(i);
                    }

                    private void ensureAssetsIsMutable() {
                        Internal.ProtobufList<Asset> protobufList = this.assets_;
                        if (protobufList.isModifiable()) {
                            return;
                        }
                        this.assets_ = GeneratedMessageLite.mutableCopy(protobufList);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setAssets(int i, Asset asset) {
                        asset.getClass();
                        ensureAssetsIsMutable();
                        this.assets_.set(i, asset);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAssets(Asset asset) {
                        asset.getClass();
                        ensureAssetsIsMutable();
                        this.assets_.add(asset);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAssets(int i, Asset asset) {
                        asset.getClass();
                        ensureAssetsIsMutable();
                        this.assets_.add(i, asset);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAllAssets(Iterable<? extends Asset> iterable) {
                        ensureAssetsIsMutable();
                        AbstractMessageLite.addAll((Iterable) iterable, (List) this.assets_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearAssets() {
                        this.assets_ = emptyProtobufList();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void removeAssets(int i) {
                        ensureAssetsIsMutable();
                        this.assets_.remove(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasAurlsupport() {
                        return (this.bitField0_ & 64) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean getAurlsupport() {
                        return this.aurlsupport_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setAurlsupport(boolean z) {
                        this.bitField0_ |= 64;
                        this.aurlsupport_ = z;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearAurlsupport() {
                        this.bitField0_ &= -65;
                        this.aurlsupport_ = false;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasDurlsupport() {
                        return (this.bitField0_ & 128) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean getDurlsupport() {
                        return this.durlsupport_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setDurlsupport(boolean z) {
                        this.bitField0_ |= 128;
                        this.durlsupport_ = z;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearDurlsupport() {
                        this.bitField0_ &= -129;
                        this.durlsupport_ = false;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public List<EventTrackers> getEventtrackersList() {
                        return this.eventtrackers_;
                    }

                    public List<? extends EventTrackersOrBuilder> getEventtrackersOrBuilderList() {
                        return this.eventtrackers_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public int getEventtrackersCount() {
                        return this.eventtrackers_.size();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public EventTrackers getEventtrackers(int i) {
                        return this.eventtrackers_.get(i);
                    }

                    public EventTrackersOrBuilder getEventtrackersOrBuilder(int i) {
                        return this.eventtrackers_.get(i);
                    }

                    private void ensureEventtrackersIsMutable() {
                        Internal.ProtobufList<EventTrackers> protobufList = this.eventtrackers_;
                        if (protobufList.isModifiable()) {
                            return;
                        }
                        this.eventtrackers_ = GeneratedMessageLite.mutableCopy(protobufList);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setEventtrackers(int i, EventTrackers eventTrackers) {
                        eventTrackers.getClass();
                        ensureEventtrackersIsMutable();
                        this.eventtrackers_.set(i, eventTrackers);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addEventtrackers(EventTrackers eventTrackers) {
                        eventTrackers.getClass();
                        ensureEventtrackersIsMutable();
                        this.eventtrackers_.add(eventTrackers);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addEventtrackers(int i, EventTrackers eventTrackers) {
                        eventTrackers.getClass();
                        ensureEventtrackersIsMutable();
                        this.eventtrackers_.add(i, eventTrackers);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAllEventtrackers(Iterable<? extends EventTrackers> iterable) {
                        ensureEventtrackersIsMutable();
                        AbstractMessageLite.addAll((Iterable) iterable, (List) this.eventtrackers_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearEventtrackers() {
                        this.eventtrackers_ = emptyProtobufList();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void removeEventtrackers(int i) {
                        ensureEventtrackersIsMutable();
                        this.eventtrackers_.remove(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean hasPrivacy() {
                        return (this.bitField0_ & 256) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                    public boolean getPrivacy() {
                        return this.privacy_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setPrivacy(boolean z) {
                        this.bitField0_ |= 256;
                        this.privacy_ = z;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearPrivacy() {
                        this.bitField0_ &= -257;
                        this.privacy_ = false;
                    }

                    public static NativeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                    }

                    public static NativeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                    }

                    public static NativeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                    }

                    public static NativeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                    }

                    public static NativeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                    }

                    public static NativeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                    }

                    public static NativeRequest parseFrom(InputStream inputStream) throws IOException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static NativeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static NativeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
                        return (NativeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static NativeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (NativeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static NativeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                    }

                    public static NativeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (NativeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder() {
                        return (Builder) DEFAULT_INSTANCE.createBuilder();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder(NativeRequest nativeRequest) {
                        return (Builder) DEFAULT_INSTANCE.createBuilder(nativeRequest);
                    }

                    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<NativeRequest, Builder> implements NativeRequestOrBuilder {
                        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                            this();
                        }

                        private Builder() {
                            super(NativeRequest.DEFAULT_INSTANCE);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasVer() {
                            return ((NativeRequest) this.instance).hasVer();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public String getVer() {
                            return ((NativeRequest) this.instance).getVer();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public ByteString getVerBytes() {
                            return ((NativeRequest) this.instance).getVerBytes();
                        }

                        public Builder setVer(String str) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setVer(str);
                            return this;
                        }

                        public Builder clearVer() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearVer();
                            return this;
                        }

                        public Builder setVerBytes(ByteString byteString) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setVerBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasContext() {
                            return ((NativeRequest) this.instance).hasContext();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public ContextType getContext() {
                            return ((NativeRequest) this.instance).getContext();
                        }

                        public Builder setContext(ContextType contextType) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setContext(contextType);
                            return this;
                        }

                        public Builder clearContext() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearContext();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasContextsubtype() {
                            return ((NativeRequest) this.instance).hasContextsubtype();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public ContextSubtype getContextsubtype() {
                            return ((NativeRequest) this.instance).getContextsubtype();
                        }

                        public Builder setContextsubtype(ContextSubtype contextSubtype) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setContextsubtype(contextSubtype);
                            return this;
                        }

                        public Builder clearContextsubtype() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearContextsubtype();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasPlcmttype() {
                            return ((NativeRequest) this.instance).hasPlcmttype();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public PlacementType getPlcmttype() {
                            return ((NativeRequest) this.instance).getPlcmttype();
                        }

                        public Builder setPlcmttype(PlacementType placementType) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setPlcmttype(placementType);
                            return this;
                        }

                        public Builder clearPlcmttype() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearPlcmttype();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasPlcmtcnt() {
                            return ((NativeRequest) this.instance).hasPlcmtcnt();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public int getPlcmtcnt() {
                            return ((NativeRequest) this.instance).getPlcmtcnt();
                        }

                        public Builder setPlcmtcnt(int i) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setPlcmtcnt(i);
                            return this;
                        }

                        public Builder clearPlcmtcnt() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearPlcmtcnt();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasSeq() {
                            return ((NativeRequest) this.instance).hasSeq();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public int getSeq() {
                            return ((NativeRequest) this.instance).getSeq();
                        }

                        public Builder setSeq(int i) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setSeq(i);
                            return this;
                        }

                        public Builder clearSeq() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearSeq();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public List<Asset> getAssetsList() {
                            return Collections.unmodifiableList(((NativeRequest) this.instance).getAssetsList());
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public int getAssetsCount() {
                            return ((NativeRequest) this.instance).getAssetsCount();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public Asset getAssets(int i) {
                            return ((NativeRequest) this.instance).getAssets(i);
                        }

                        public Builder setAssets(int i, Asset asset) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setAssets(i, asset);
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder setAssets(int i, Asset.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setAssets(i, (Asset) builder.build());
                            return this;
                        }

                        public Builder addAssets(Asset asset) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAssets(asset);
                            return this;
                        }

                        public Builder addAssets(int i, Asset asset) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAssets(i, asset);
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder addAssets(Asset.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAssets((Asset) builder.build());
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder addAssets(int i, Asset.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAssets(i, (Asset) builder.build());
                            return this;
                        }

                        public Builder addAllAssets(Iterable<? extends Asset> iterable) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAllAssets(iterable);
                            return this;
                        }

                        public Builder clearAssets() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearAssets();
                            return this;
                        }

                        public Builder removeAssets(int i) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).removeAssets(i);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasAurlsupport() {
                            return ((NativeRequest) this.instance).hasAurlsupport();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean getAurlsupport() {
                            return ((NativeRequest) this.instance).getAurlsupport();
                        }

                        public Builder setAurlsupport(boolean z) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setAurlsupport(z);
                            return this;
                        }

                        public Builder clearAurlsupport() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearAurlsupport();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasDurlsupport() {
                            return ((NativeRequest) this.instance).hasDurlsupport();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean getDurlsupport() {
                            return ((NativeRequest) this.instance).getDurlsupport();
                        }

                        public Builder setDurlsupport(boolean z) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setDurlsupport(z);
                            return this;
                        }

                        public Builder clearDurlsupport() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearDurlsupport();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public List<EventTrackers> getEventtrackersList() {
                            return Collections.unmodifiableList(((NativeRequest) this.instance).getEventtrackersList());
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public int getEventtrackersCount() {
                            return ((NativeRequest) this.instance).getEventtrackersCount();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public EventTrackers getEventtrackers(int i) {
                            return ((NativeRequest) this.instance).getEventtrackers(i);
                        }

                        public Builder setEventtrackers(int i, EventTrackers eventTrackers) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setEventtrackers(i, eventTrackers);
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder setEventtrackers(int i, EventTrackers.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setEventtrackers(i, (EventTrackers) builder.build());
                            return this;
                        }

                        public Builder addEventtrackers(EventTrackers eventTrackers) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addEventtrackers(eventTrackers);
                            return this;
                        }

                        public Builder addEventtrackers(int i, EventTrackers eventTrackers) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addEventtrackers(i, eventTrackers);
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder addEventtrackers(EventTrackers.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addEventtrackers((EventTrackers) builder.build());
                            return this;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public Builder addEventtrackers(int i, EventTrackers.Builder builder) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addEventtrackers(i, (EventTrackers) builder.build());
                            return this;
                        }

                        public Builder addAllEventtrackers(Iterable<? extends EventTrackers> iterable) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).addAllEventtrackers(iterable);
                            return this;
                        }

                        public Builder clearEventtrackers() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearEventtrackers();
                            return this;
                        }

                        public Builder removeEventtrackers(int i) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).removeEventtrackers(i);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean hasPrivacy() {
                            return ((NativeRequest) this.instance).hasPrivacy();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Native.NativeRequestOrBuilder
                        public boolean getPrivacy() {
                            return ((NativeRequest) this.instance).getPrivacy();
                        }

                        public Builder setPrivacy(boolean z) {
                            copyOnWrite();
                            ((NativeRequest) this.instance).setPrivacy(z);
                            return this;
                        }

                        public Builder clearPrivacy() {
                            copyOnWrite();
                            ((NativeRequest) this.instance).clearPrivacy();
                            return this;
                        }
                    }

                    @Override // com.google.protobuf.GeneratedMessageLite
                    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                        AnonymousClass1 anonymousClass1 = null;
                        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                            case 1:
                                return new NativeRequest();
                            case 2:
                                return new Builder(anonymousClass1);
                            case 3:
                                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u000e\u000b\u0000\u0002\u0002\u0001ဈ\u0000\u0004င\u0004\u0005င\u0005\u0006Л\u0007ဌ\u0001\bဌ\u0002\tဌ\u0003\u000bဇ\u0006\fဇ\u0007\rЛ\u000eဇ\b", new Object[]{"bitField0_", "ver_", "plcmtcnt_", "seq_", "assets_", Asset.class, "context_", ContextType.internalGetVerifier(), "contextsubtype_", ContextSubtype.internalGetVerifier(), "plcmttype_", PlacementType.internalGetVerifier(), "aurlsupport_", "durlsupport_", "eventtrackers_", EventTrackers.class, "privacy_"});
                            case 4:
                                return DEFAULT_INSTANCE;
                            case 5:
                                Parser<NativeRequest> defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    synchronized (NativeRequest.class) {
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
                                return Byte.valueOf(this.memoizedIsInitialized);
                            case 7:
                                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                return null;
                            default:
                                throw new UnsupportedOperationException();
                        }
                    }

                    static {
                        NativeRequest nativeRequest = new NativeRequest();
                        DEFAULT_INSTANCE = nativeRequest;
                        GeneratedMessageLite.registerDefaultInstance(NativeRequest.class, nativeRequest);
                    }

                    public static NativeRequest getDefaultInstance() {
                        return DEFAULT_INSTANCE;
                    }

                    public static Parser<NativeRequest> parser() {
                        return DEFAULT_INSTANCE.getParserForType();
                    }
                }

                public enum RequestOneofCase {
                    REQUEST(1),
                    REQUEST_NATIVE(50),
                    REQUESTONEOF_NOT_SET(0);

                    private final int value;

                    RequestOneofCase(int i) {
                        this.value = i;
                    }

                    @Deprecated
                    public static RequestOneofCase valueOf(int i) {
                        return forNumber(i);
                    }

                    public static RequestOneofCase forNumber(int i) {
                        if (i == 0) {
                            return REQUESTONEOF_NOT_SET;
                        }
                        if (i == 1) {
                            return REQUEST;
                        }
                        if (i != 50) {
                            return null;
                        }
                        return REQUEST_NATIVE;
                    }

                    public int getNumber() {
                        return this.value;
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public RequestOneofCase getRequestOneofCase() {
                    return RequestOneofCase.forNumber(this.requestOneofCase_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRequestOneof() {
                    this.requestOneofCase_ = 0;
                    this.requestOneof_ = null;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public boolean hasRequest() {
                    return this.requestOneofCase_ == 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public String getRequest() {
                    if (this.requestOneofCase_ != 1) {
                        return "";
                    }
                    return (String) this.requestOneof_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public ByteString getRequestBytes() {
                    String str;
                    if (this.requestOneofCase_ != 1) {
                        str = "";
                    } else {
                        str = (String) this.requestOneof_;
                    }
                    return ByteString.copyFromUtf8(str);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRequest(String str) {
                    str.getClass();
                    this.requestOneofCase_ = 1;
                    this.requestOneof_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRequest() {
                    if (this.requestOneofCase_ == 1) {
                        this.requestOneofCase_ = 0;
                        this.requestOneof_ = null;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRequestBytes(ByteString byteString) {
                    this.requestOneof_ = byteString.toStringUtf8();
                    this.requestOneofCase_ = 1;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public boolean hasRequestNative() {
                    return this.requestOneofCase_ == 50;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public NativeRequest getRequestNative() {
                    if (this.requestOneofCase_ == 50) {
                        return (NativeRequest) this.requestOneof_;
                    }
                    return NativeRequest.getDefaultInstance();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setRequestNative(NativeRequest nativeRequest) {
                    nativeRequest.getClass();
                    this.requestOneof_ = nativeRequest;
                    this.requestOneofCase_ = 50;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                public void mergeRequestNative(NativeRequest nativeRequest) {
                    nativeRequest.getClass();
                    if (this.requestOneofCase_ == 50 && this.requestOneof_ != NativeRequest.getDefaultInstance()) {
                        this.requestOneof_ = ((NativeRequest.Builder) NativeRequest.newBuilder((NativeRequest) this.requestOneof_).mergeFrom(nativeRequest)).buildPartial();
                    } else {
                        this.requestOneof_ = nativeRequest;
                    }
                    this.requestOneofCase_ = 50;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearRequestNative() {
                    if (this.requestOneofCase_ == 50) {
                        this.requestOneofCase_ = 0;
                        this.requestOneof_ = null;
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public boolean hasVer() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public String getVer() {
                    return this.ver_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public ByteString getVerBytes() {
                    return ByteString.copyFromUtf8(this.ver_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setVer(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.ver_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearVer() {
                    this.bitField0_ &= -5;
                    this.ver_ = getDefaultInstance().getVer();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setVerBytes(ByteString byteString) {
                    this.ver_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                static {
                    Native r0 = new Native();
                    DEFAULT_INSTANCE = r0;
                    GeneratedMessageLite.registerDefaultInstance(Native.class, r0);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public List<APIFramework> getApiList() {
                    return new Internal.ListAdapter(this.api_, api_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public int getApiCount() {
                    return this.api_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public APIFramework getApi(int i) {
                    APIFramework aPIFrameworkForNumber = APIFramework.forNumber(this.api_.getInt(i));
                    return aPIFrameworkForNumber == null ? APIFramework.VPAID_1 : aPIFrameworkForNumber;
                }

                private void ensureApiIsMutable() {
                    Internal.IntList intList = this.api_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.api_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setApi(int i, APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.setInt(i, aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addApi(APIFramework aPIFramework) {
                    aPIFramework.getClass();
                    ensureApiIsMutable();
                    this.api_.addInt(aPIFramework.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllApi(Iterable<? extends APIFramework> iterable) {
                    ensureApiIsMutable();
                    Iterator<? extends APIFramework> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.api_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearApi() {
                    this.api_ = emptyIntList();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public List<CreativeAttribute> getBattrList() {
                    return new Internal.ListAdapter(this.battr_, battr_converter_);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public int getBattrCount() {
                    return this.battr_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                public CreativeAttribute getBattr(int i) {
                    CreativeAttribute creativeAttributeForNumber = CreativeAttribute.forNumber(this.battr_.getInt(i));
                    return creativeAttributeForNumber == null ? CreativeAttribute.AUDIO_AUTO_PLAY : creativeAttributeForNumber;
                }

                private void ensureBattrIsMutable() {
                    Internal.IntList intList = this.battr_;
                    if (intList.isModifiable()) {
                        return;
                    }
                    this.battr_ = GeneratedMessageLite.mutableCopy(intList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setBattr(int i, CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.setInt(i, creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addBattr(CreativeAttribute creativeAttribute) {
                    creativeAttribute.getClass();
                    ensureBattrIsMutable();
                    this.battr_.addInt(creativeAttribute.getNumber());
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                    ensureBattrIsMutable();
                    Iterator<? extends CreativeAttribute> it = iterable.iterator();
                    while (it.hasNext()) {
                        this.battr_.addInt(it.next().getNumber());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearBattr() {
                    this.battr_ = emptyIntList();
                }

                public static Native parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Native parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Native parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Native parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Native parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Native parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Native parseFrom(InputStream inputStream) throws IOException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Native parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Native parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Native) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Native parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Native) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Native parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Native parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Native) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Native r1) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(r1);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Native, Builder> implements NativeOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Native.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public RequestOneofCase getRequestOneofCase() {
                        return ((Native) this.instance).getRequestOneofCase();
                    }

                    public Builder clearRequestOneof() {
                        copyOnWrite();
                        ((Native) this.instance).clearRequestOneof();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public boolean hasRequest() {
                        return ((Native) this.instance).hasRequest();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public String getRequest() {
                        return ((Native) this.instance).getRequest();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public ByteString getRequestBytes() {
                        return ((Native) this.instance).getRequestBytes();
                    }

                    public Builder setRequest(String str) {
                        copyOnWrite();
                        ((Native) this.instance).setRequest(str);
                        return this;
                    }

                    public Builder clearRequest() {
                        copyOnWrite();
                        ((Native) this.instance).clearRequest();
                        return this;
                    }

                    public Builder setRequestBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Native) this.instance).setRequestBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public boolean hasRequestNative() {
                        return ((Native) this.instance).hasRequestNative();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public NativeRequest getRequestNative() {
                        return ((Native) this.instance).getRequestNative();
                    }

                    public Builder setRequestNative(NativeRequest nativeRequest) {
                        copyOnWrite();
                        ((Native) this.instance).setRequestNative(nativeRequest);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder setRequestNative(NativeRequest.Builder builder) {
                        copyOnWrite();
                        ((Native) this.instance).setRequestNative((NativeRequest) builder.build());
                        return this;
                    }

                    public Builder mergeRequestNative(NativeRequest nativeRequest) {
                        copyOnWrite();
                        ((Native) this.instance).mergeRequestNative(nativeRequest);
                        return this;
                    }

                    public Builder clearRequestNative() {
                        copyOnWrite();
                        ((Native) this.instance).clearRequestNative();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public boolean hasVer() {
                        return ((Native) this.instance).hasVer();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public String getVer() {
                        return ((Native) this.instance).getVer();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public ByteString getVerBytes() {
                        return ((Native) this.instance).getVerBytes();
                    }

                    public Builder setVer(String str) {
                        copyOnWrite();
                        ((Native) this.instance).setVer(str);
                        return this;
                    }

                    public Builder clearVer() {
                        copyOnWrite();
                        ((Native) this.instance).clearVer();
                        return this;
                    }

                    public Builder setVerBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Native) this.instance).setVerBytes(byteString);
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public List<APIFramework> getApiList() {
                        return ((Native) this.instance).getApiList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public int getApiCount() {
                        return ((Native) this.instance).getApiCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public APIFramework getApi(int i) {
                        return ((Native) this.instance).getApi(i);
                    }

                    public Builder setApi(int i, APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Native) this.instance).setApi(i, aPIFramework);
                        return this;
                    }

                    public Builder addApi(APIFramework aPIFramework) {
                        copyOnWrite();
                        ((Native) this.instance).addApi(aPIFramework);
                        return this;
                    }

                    public Builder addAllApi(Iterable<? extends APIFramework> iterable) {
                        copyOnWrite();
                        ((Native) this.instance).addAllApi(iterable);
                        return this;
                    }

                    public Builder clearApi() {
                        copyOnWrite();
                        ((Native) this.instance).clearApi();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public List<CreativeAttribute> getBattrList() {
                        return ((Native) this.instance).getBattrList();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public int getBattrCount() {
                        return ((Native) this.instance).getBattrCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.NativeOrBuilder
                    public CreativeAttribute getBattr(int i) {
                        return ((Native) this.instance).getBattr(i);
                    }

                    public Builder setBattr(int i, CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Native) this.instance).setBattr(i, creativeAttribute);
                        return this;
                    }

                    public Builder addBattr(CreativeAttribute creativeAttribute) {
                        copyOnWrite();
                        ((Native) this.instance).addBattr(creativeAttribute);
                        return this;
                    }

                    public Builder addAllBattr(Iterable<? extends CreativeAttribute> iterable) {
                        copyOnWrite();
                        ((Native) this.instance).addAllBattr(iterable);
                        return this;
                    }

                    public Builder clearBattr() {
                        copyOnWrite();
                        ((Native) this.instance).clearBattr();
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Native();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0001\u0001\u00012\u0005\u0000\u0002\u0001\u0001ျ\u0000\u0002ဈ\u0002\u0003,\u0004,2ᐼ\u0000", new Object[]{"requestOneof_", "requestOneofCase_", "bitField0_", "ver_", "api_", APIFramework.internalGetVerifier(), "battr_", CreativeAttribute.internalGetVerifier(), NativeRequest.class});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Native> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Native.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                public static Native getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Native> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            public static final class Pmp extends GeneratedMessageLite.ExtendableMessage<Pmp, Builder> implements PmpOrBuilder {
                public static final int DEALS_FIELD_NUMBER = 2;
                private static final Pmp DEFAULT_INSTANCE;
                private static volatile Parser<Pmp> PARSER = null;
                public static final int PRIVATE_AUCTION_FIELD_NUMBER = 1;
                private int bitField0_;
                private boolean privateAuction_;
                private byte memoizedIsInitialized = 2;
                private Internal.ProtobufList<Deal> deals_ = emptyProtobufList();

                public interface DealOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<Deal, Deal.Builder> {
                    Deal.AuctionType getAt();

                    double getBidfloor();

                    String getBidfloorcur();

                    ByteString getBidfloorcurBytes();

                    String getId();

                    ByteString getIdBytes();

                    String getWadomain(int i);

                    ByteString getWadomainBytes(int i);

                    int getWadomainCount();

                    List<String> getWadomainList();

                    String getWseat(int i);

                    ByteString getWseatBytes(int i);

                    int getWseatCount();

                    List<String> getWseatList();

                    boolean hasAt();

                    boolean hasBidfloor();

                    boolean hasBidfloorcur();

                    boolean hasId();
                }

                private Pmp() {
                }

                public static final class Deal extends GeneratedMessageLite.ExtendableMessage<Deal, Builder> implements DealOrBuilder {
                    public static final int AT_FIELD_NUMBER = 6;
                    public static final int BIDFLOORCUR_FIELD_NUMBER = 3;
                    public static final int BIDFLOOR_FIELD_NUMBER = 2;
                    private static final Deal DEFAULT_INSTANCE;
                    public static final int ID_FIELD_NUMBER = 1;
                    private static volatile Parser<Deal> PARSER = null;
                    public static final int WADOMAIN_FIELD_NUMBER = 5;
                    public static final int WSEAT_FIELD_NUMBER = 4;
                    private double bidfloor_;
                    private int bitField0_;
                    private byte memoizedIsInitialized = 2;
                    private String id_ = "";
                    private String bidfloorcur_ = "USD";
                    private Internal.ProtobufList<String> wseat_ = GeneratedMessageLite.emptyProtobufList();
                    private Internal.ProtobufList<String> wadomain_ = GeneratedMessageLite.emptyProtobufList();
                    private int at_ = 1;

                    private Deal() {
                    }

                    public enum AuctionType implements Internal.EnumLite {
                        FIRST_PRICE(1),
                        SECOND_PRICE(2),
                        FIXED_PRICE(3);

                        public static final int FIRST_PRICE_VALUE = 1;
                        public static final int FIXED_PRICE_VALUE = 3;
                        public static final int SECOND_PRICE_VALUE = 2;
                        private static final Internal.EnumLiteMap<AuctionType> internalValueMap = new Internal.EnumLiteMap<AuctionType>() { // from class: com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.Deal.AuctionType.1
                            @Override // com.google.protobuf.Internal.EnumLiteMap
                            public AuctionType findValueByNumber(int i) {
                                return AuctionType.forNumber(i);
                            }
                        };
                        private final int value;

                        @Override // com.google.protobuf.Internal.EnumLite
                        public final int getNumber() {
                            return this.value;
                        }

                        @Deprecated
                        public static AuctionType valueOf(int i) {
                            return forNumber(i);
                        }

                        public static AuctionType forNumber(int i) {
                            if (i == 1) {
                                return FIRST_PRICE;
                            }
                            if (i == 2) {
                                return SECOND_PRICE;
                            }
                            if (i != 3) {
                                return null;
                            }
                            return FIXED_PRICE;
                        }

                        public static Internal.EnumLiteMap<AuctionType> internalGetValueMap() {
                            return internalValueMap;
                        }

                        public static Internal.EnumVerifier internalGetVerifier() {
                            return AuctionTypeVerifier.INSTANCE;
                        }

                        private static final class AuctionTypeVerifier implements Internal.EnumVerifier {
                            static final Internal.EnumVerifier INSTANCE = new AuctionTypeVerifier();

                            private AuctionTypeVerifier() {
                            }

                            @Override // com.google.protobuf.Internal.EnumVerifier
                            public boolean isInRange(int i) {
                                return AuctionType.forNumber(i) != null;
                            }
                        }

                        AuctionType(int i) {
                            this.value = i;
                        }
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public boolean hasId() {
                        return (this.bitField0_ & 1) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public String getId() {
                        return this.id_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
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
                        this.id_ = byteString.toStringUtf8();
                        this.bitField0_ |= 1;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public boolean hasBidfloor() {
                        return (this.bitField0_ & 2) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public double getBidfloor() {
                        return this.bidfloor_;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setBidfloor(double d) {
                        this.bitField0_ |= 2;
                        this.bidfloor_ = d;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearBidfloor() {
                        this.bitField0_ &= -3;
                        this.bidfloor_ = 0.0d;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public boolean hasBidfloorcur() {
                        return (this.bitField0_ & 4) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public String getBidfloorcur() {
                        return this.bidfloorcur_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public ByteString getBidfloorcurBytes() {
                        return ByteString.copyFromUtf8(this.bidfloorcur_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setBidfloorcur(String str) {
                        str.getClass();
                        this.bitField0_ |= 4;
                        this.bidfloorcur_ = str;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearBidfloorcur() {
                        this.bitField0_ &= -5;
                        this.bidfloorcur_ = getDefaultInstance().getBidfloorcur();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setBidfloorcurBytes(ByteString byteString) {
                        this.bidfloorcur_ = byteString.toStringUtf8();
                        this.bitField0_ |= 4;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public List<String> getWseatList() {
                        return this.wseat_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public int getWseatCount() {
                        return this.wseat_.size();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public String getWseat(int i) {
                        return this.wseat_.get(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public ByteString getWseatBytes(int i) {
                        return ByteString.copyFromUtf8(this.wseat_.get(i));
                    }

                    private void ensureWseatIsMutable() {
                        Internal.ProtobufList<String> protobufList = this.wseat_;
                        if (protobufList.isModifiable()) {
                            return;
                        }
                        this.wseat_ = GeneratedMessageLite.mutableCopy(protobufList);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setWseat(int i, String str) {
                        str.getClass();
                        ensureWseatIsMutable();
                        this.wseat_.set(i, str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addWseat(String str) {
                        str.getClass();
                        ensureWseatIsMutable();
                        this.wseat_.add(str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAllWseat(Iterable<String> iterable) {
                        ensureWseatIsMutable();
                        AbstractMessageLite.addAll((Iterable) iterable, (List) this.wseat_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearWseat() {
                        this.wseat_ = GeneratedMessageLite.emptyProtobufList();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addWseatBytes(ByteString byteString) {
                        ensureWseatIsMutable();
                        this.wseat_.add(byteString.toStringUtf8());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public List<String> getWadomainList() {
                        return this.wadomain_;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public int getWadomainCount() {
                        return this.wadomain_.size();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public String getWadomain(int i) {
                        return this.wadomain_.get(i);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public ByteString getWadomainBytes(int i) {
                        return ByteString.copyFromUtf8(this.wadomain_.get(i));
                    }

                    private void ensureWadomainIsMutable() {
                        Internal.ProtobufList<String> protobufList = this.wadomain_;
                        if (protobufList.isModifiable()) {
                            return;
                        }
                        this.wadomain_ = GeneratedMessageLite.mutableCopy(protobufList);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setWadomain(int i, String str) {
                        str.getClass();
                        ensureWadomainIsMutable();
                        this.wadomain_.set(i, str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addWadomain(String str) {
                        str.getClass();
                        ensureWadomainIsMutable();
                        this.wadomain_.add(str);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addAllWadomain(Iterable<String> iterable) {
                        ensureWadomainIsMutable();
                        AbstractMessageLite.addAll((Iterable) iterable, (List) this.wadomain_);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearWadomain() {
                        this.wadomain_ = GeneratedMessageLite.emptyProtobufList();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void addWadomainBytes(ByteString byteString) {
                        ensureWadomainIsMutable();
                        this.wadomain_.add(byteString.toStringUtf8());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public boolean hasAt() {
                        return (this.bitField0_ & 8) != 0;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                    public AuctionType getAt() {
                        AuctionType auctionTypeForNumber = AuctionType.forNumber(this.at_);
                        return auctionTypeForNumber == null ? AuctionType.FIRST_PRICE : auctionTypeForNumber;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void setAt(AuctionType auctionType) {
                        this.at_ = auctionType.getNumber();
                        this.bitField0_ |= 8;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public void clearAt() {
                        this.bitField0_ &= -9;
                        this.at_ = 1;
                    }

                    public static Deal parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                    }

                    public static Deal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                    }

                    public static Deal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                    }

                    public static Deal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                    }

                    public static Deal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                    }

                    public static Deal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                    }

                    public static Deal parseFrom(InputStream inputStream) throws IOException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static Deal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static Deal parseDelimitedFrom(InputStream inputStream) throws IOException {
                        return (Deal) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                    }

                    public static Deal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Deal) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                    }

                    public static Deal parseFrom(CodedInputStream codedInputStream) throws IOException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                    }

                    public static Deal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                        return (Deal) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder() {
                        return (Builder) DEFAULT_INSTANCE.createBuilder();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public static Builder newBuilder(Deal deal) {
                        return (Builder) DEFAULT_INSTANCE.createBuilder(deal);
                    }

                    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Deal, Builder> implements DealOrBuilder {
                        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                            this();
                        }

                        private Builder() {
                            super(Deal.DEFAULT_INSTANCE);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public boolean hasId() {
                            return ((Deal) this.instance).hasId();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public String getId() {
                            return ((Deal) this.instance).getId();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public ByteString getIdBytes() {
                            return ((Deal) this.instance).getIdBytes();
                        }

                        public Builder setId(String str) {
                            copyOnWrite();
                            ((Deal) this.instance).setId(str);
                            return this;
                        }

                        public Builder clearId() {
                            copyOnWrite();
                            ((Deal) this.instance).clearId();
                            return this;
                        }

                        public Builder setIdBytes(ByteString byteString) {
                            copyOnWrite();
                            ((Deal) this.instance).setIdBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public boolean hasBidfloor() {
                            return ((Deal) this.instance).hasBidfloor();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public double getBidfloor() {
                            return ((Deal) this.instance).getBidfloor();
                        }

                        public Builder setBidfloor(double d) {
                            copyOnWrite();
                            ((Deal) this.instance).setBidfloor(d);
                            return this;
                        }

                        public Builder clearBidfloor() {
                            copyOnWrite();
                            ((Deal) this.instance).clearBidfloor();
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public boolean hasBidfloorcur() {
                            return ((Deal) this.instance).hasBidfloorcur();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public String getBidfloorcur() {
                            return ((Deal) this.instance).getBidfloorcur();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public ByteString getBidfloorcurBytes() {
                            return ((Deal) this.instance).getBidfloorcurBytes();
                        }

                        public Builder setBidfloorcur(String str) {
                            copyOnWrite();
                            ((Deal) this.instance).setBidfloorcur(str);
                            return this;
                        }

                        public Builder clearBidfloorcur() {
                            copyOnWrite();
                            ((Deal) this.instance).clearBidfloorcur();
                            return this;
                        }

                        public Builder setBidfloorcurBytes(ByteString byteString) {
                            copyOnWrite();
                            ((Deal) this.instance).setBidfloorcurBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public List<String> getWseatList() {
                            return Collections.unmodifiableList(((Deal) this.instance).getWseatList());
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public int getWseatCount() {
                            return ((Deal) this.instance).getWseatCount();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public String getWseat(int i) {
                            return ((Deal) this.instance).getWseat(i);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public ByteString getWseatBytes(int i) {
                            return ((Deal) this.instance).getWseatBytes(i);
                        }

                        public Builder setWseat(int i, String str) {
                            copyOnWrite();
                            ((Deal) this.instance).setWseat(i, str);
                            return this;
                        }

                        public Builder addWseat(String str) {
                            copyOnWrite();
                            ((Deal) this.instance).addWseat(str);
                            return this;
                        }

                        public Builder addAllWseat(Iterable<String> iterable) {
                            copyOnWrite();
                            ((Deal) this.instance).addAllWseat(iterable);
                            return this;
                        }

                        public Builder clearWseat() {
                            copyOnWrite();
                            ((Deal) this.instance).clearWseat();
                            return this;
                        }

                        public Builder addWseatBytes(ByteString byteString) {
                            copyOnWrite();
                            ((Deal) this.instance).addWseatBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public List<String> getWadomainList() {
                            return Collections.unmodifiableList(((Deal) this.instance).getWadomainList());
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public int getWadomainCount() {
                            return ((Deal) this.instance).getWadomainCount();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public String getWadomain(int i) {
                            return ((Deal) this.instance).getWadomain(i);
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public ByteString getWadomainBytes(int i) {
                            return ((Deal) this.instance).getWadomainBytes(i);
                        }

                        public Builder setWadomain(int i, String str) {
                            copyOnWrite();
                            ((Deal) this.instance).setWadomain(i, str);
                            return this;
                        }

                        public Builder addWadomain(String str) {
                            copyOnWrite();
                            ((Deal) this.instance).addWadomain(str);
                            return this;
                        }

                        public Builder addAllWadomain(Iterable<String> iterable) {
                            copyOnWrite();
                            ((Deal) this.instance).addAllWadomain(iterable);
                            return this;
                        }

                        public Builder clearWadomain() {
                            copyOnWrite();
                            ((Deal) this.instance).clearWadomain();
                            return this;
                        }

                        public Builder addWadomainBytes(ByteString byteString) {
                            copyOnWrite();
                            ((Deal) this.instance).addWadomainBytes(byteString);
                            return this;
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public boolean hasAt() {
                            return ((Deal) this.instance).hasAt();
                        }

                        @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.Pmp.DealOrBuilder
                        public AuctionType getAt() {
                            return ((Deal) this.instance).getAt();
                        }

                        public Builder setAt(AuctionType auctionType) {
                            copyOnWrite();
                            ((Deal) this.instance).setAt(auctionType);
                            return this;
                        }

                        public Builder clearAt() {
                            copyOnWrite();
                            ((Deal) this.instance).clearAt();
                            return this;
                        }
                    }

                    @Override // com.google.protobuf.GeneratedMessageLite
                    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                        AnonymousClass1 anonymousClass1 = null;
                        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                            case 1:
                                return new Deal();
                            case 2:
                                return new Builder(anonymousClass1);
                            case 3:
                                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0001\u0001ᔈ\u0000\u0002က\u0001\u0003ဈ\u0002\u0004\u001a\u0005\u001a\u0006ဌ\u0003", new Object[]{"bitField0_", "id_", "bidfloor_", "bidfloorcur_", "wseat_", "wadomain_", "at_", AuctionType.internalGetVerifier()});
                            case 4:
                                return DEFAULT_INSTANCE;
                            case 5:
                                Parser<Deal> defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    synchronized (Deal.class) {
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
                                return Byte.valueOf(this.memoizedIsInitialized);
                            case 7:
                                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                                return null;
                            default:
                                throw new UnsupportedOperationException();
                        }
                    }

                    static {
                        Deal deal = new Deal();
                        DEFAULT_INSTANCE = deal;
                        GeneratedMessageLite.registerDefaultInstance(Deal.class, deal);
                    }

                    public static Deal getDefaultInstance() {
                        return DEFAULT_INSTANCE;
                    }

                    public static Parser<Deal> parser() {
                        return DEFAULT_INSTANCE.getParserForType();
                    }
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                public boolean hasPrivateAuction() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                public boolean getPrivateAuction() {
                    return this.privateAuction_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setPrivateAuction(boolean z) {
                    this.bitField0_ |= 1;
                    this.privateAuction_ = z;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearPrivateAuction() {
                    this.bitField0_ &= -2;
                    this.privateAuction_ = false;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                public List<Deal> getDealsList() {
                    return this.deals_;
                }

                public List<? extends DealOrBuilder> getDealsOrBuilderList() {
                    return this.deals_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                public int getDealsCount() {
                    return this.deals_.size();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                public Deal getDeals(int i) {
                    return this.deals_.get(i);
                }

                public DealOrBuilder getDealsOrBuilder(int i) {
                    return this.deals_.get(i);
                }

                private void ensureDealsIsMutable() {
                    Internal.ProtobufList<Deal> protobufList = this.deals_;
                    if (protobufList.isModifiable()) {
                        return;
                    }
                    this.deals_ = GeneratedMessageLite.mutableCopy(protobufList);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setDeals(int i, Deal deal) {
                    deal.getClass();
                    ensureDealsIsMutable();
                    this.deals_.set(i, deal);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addDeals(Deal deal) {
                    deal.getClass();
                    ensureDealsIsMutable();
                    this.deals_.add(deal);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addDeals(int i, Deal deal) {
                    deal.getClass();
                    ensureDealsIsMutable();
                    this.deals_.add(i, deal);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void addAllDeals(Iterable<? extends Deal> iterable) {
                    ensureDealsIsMutable();
                    AbstractMessageLite.addAll((Iterable) iterable, (List) this.deals_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearDeals() {
                    this.deals_ = emptyProtobufList();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void removeDeals(int i) {
                    ensureDealsIsMutable();
                    this.deals_.remove(i);
                }

                public static Pmp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Pmp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Pmp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Pmp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Pmp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Pmp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Pmp parseFrom(InputStream inputStream) throws IOException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Pmp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Pmp parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Pmp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Pmp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Pmp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Pmp parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Pmp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Pmp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder() {
                    return (Builder) DEFAULT_INSTANCE.createBuilder();
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static Builder newBuilder(Pmp pmp) {
                    return (Builder) DEFAULT_INSTANCE.createBuilder(pmp);
                }

                public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Pmp, Builder> implements PmpOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Pmp.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                    public boolean hasPrivateAuction() {
                        return ((Pmp) this.instance).hasPrivateAuction();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                    public boolean getPrivateAuction() {
                        return ((Pmp) this.instance).getPrivateAuction();
                    }

                    public Builder setPrivateAuction(boolean z) {
                        copyOnWrite();
                        ((Pmp) this.instance).setPrivateAuction(z);
                        return this;
                    }

                    public Builder clearPrivateAuction() {
                        copyOnWrite();
                        ((Pmp) this.instance).clearPrivateAuction();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                    public List<Deal> getDealsList() {
                        return Collections.unmodifiableList(((Pmp) this.instance).getDealsList());
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                    public int getDealsCount() {
                        return ((Pmp) this.instance).getDealsCount();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Imp.PmpOrBuilder
                    public Deal getDeals(int i) {
                        return ((Pmp) this.instance).getDeals(i);
                    }

                    public Builder setDeals(int i, Deal deal) {
                        copyOnWrite();
                        ((Pmp) this.instance).setDeals(i, deal);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder setDeals(int i, Deal.Builder builder) {
                        copyOnWrite();
                        ((Pmp) this.instance).setDeals(i, (Deal) builder.build());
                        return this;
                    }

                    public Builder addDeals(Deal deal) {
                        copyOnWrite();
                        ((Pmp) this.instance).addDeals(deal);
                        return this;
                    }

                    public Builder addDeals(int i, Deal deal) {
                        copyOnWrite();
                        ((Pmp) this.instance).addDeals(i, deal);
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addDeals(Deal.Builder builder) {
                        copyOnWrite();
                        ((Pmp) this.instance).addDeals((Deal) builder.build());
                        return this;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public Builder addDeals(int i, Deal.Builder builder) {
                        copyOnWrite();
                        ((Pmp) this.instance).addDeals(i, (Deal) builder.build());
                        return this;
                    }

                    public Builder addAllDeals(Iterable<? extends Deal> iterable) {
                        copyOnWrite();
                        ((Pmp) this.instance).addAllDeals(iterable);
                        return this;
                    }

                    public Builder clearDeals() {
                        copyOnWrite();
                        ((Pmp) this.instance).clearDeals();
                        return this;
                    }

                    public Builder removeDeals(int i) {
                        copyOnWrite();
                        ((Pmp) this.instance).removeDeals(i);
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Pmp();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ဇ\u0000\u0002Л", new Object[]{"bitField0_", "privateAuction_", "deals_", Deal.class});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Pmp> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Pmp.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                static {
                    Pmp pmp = new Pmp();
                    DEFAULT_INSTANCE = pmp;
                    GeneratedMessageLite.registerDefaultInstance(Pmp.class, pmp);
                }

                public static Pmp getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Pmp> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
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
                this.id_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasBanner() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Banner getBanner() {
                Banner banner = this.banner_;
                return banner == null ? Banner.getDefaultInstance() : banner;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBanner(Banner banner) {
                banner.getClass();
                this.banner_ = banner;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeBanner(Banner banner) {
                banner.getClass();
                Banner banner2 = this.banner_;
                if (banner2 != null && banner2 != Banner.getDefaultInstance()) {
                    this.banner_ = ((Banner.Builder) Banner.newBuilder(this.banner_).mergeFrom(banner)).buildPartial();
                } else {
                    this.banner_ = banner;
                }
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBanner() {
                this.banner_ = null;
                this.bitField0_ &= -3;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasVideo() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Video getVideo() {
                Video video = this.video_;
                return video == null ? Video.getDefaultInstance() : video;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setVideo(Video video) {
                video.getClass();
                this.video_ = video;
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeVideo(Video video) {
                video.getClass();
                Video video2 = this.video_;
                if (video2 != null && video2 != Video.getDefaultInstance()) {
                    this.video_ = ((Video.Builder) Video.newBuilder(this.video_).mergeFrom(video)).buildPartial();
                } else {
                    this.video_ = video;
                }
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearVideo() {
                this.video_ = null;
                this.bitField0_ &= -5;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasAudio() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Audio getAudio() {
                Audio audio = this.audio_;
                return audio == null ? Audio.getDefaultInstance() : audio;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAudio(Audio audio) {
                audio.getClass();
                this.audio_ = audio;
                this.bitField0_ |= 8;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeAudio(Audio audio) {
                audio.getClass();
                Audio audio2 = this.audio_;
                if (audio2 != null && audio2 != Audio.getDefaultInstance()) {
                    this.audio_ = ((Audio.Builder) Audio.newBuilder(this.audio_).mergeFrom(audio)).buildPartial();
                } else {
                    this.audio_ = audio;
                }
                this.bitField0_ |= 8;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAudio() {
                this.audio_ = null;
                this.bitField0_ &= -9;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasDisplaymanager() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getDisplaymanager() {
                return this.displaymanager_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ByteString getDisplaymanagerBytes() {
                return ByteString.copyFromUtf8(this.displaymanager_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplaymanager(String str) {
                str.getClass();
                this.bitField0_ |= 16;
                this.displaymanager_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDisplaymanager() {
                this.bitField0_ &= -17;
                this.displaymanager_ = getDefaultInstance().getDisplaymanager();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplaymanagerBytes(ByteString byteString) {
                this.displaymanager_ = byteString.toStringUtf8();
                this.bitField0_ |= 16;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasDisplaymanagerver() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getDisplaymanagerver() {
                return this.displaymanagerver_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ByteString getDisplaymanagerverBytes() {
                return ByteString.copyFromUtf8(this.displaymanagerver_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplaymanagerver(String str) {
                str.getClass();
                this.bitField0_ |= 32;
                this.displaymanagerver_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearDisplaymanagerver() {
                this.bitField0_ &= -33;
                this.displaymanagerver_ = getDefaultInstance().getDisplaymanagerver();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setDisplaymanagerverBytes(ByteString byteString) {
                this.displaymanagerver_ = byteString.toStringUtf8();
                this.bitField0_ |= 32;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasInstl() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean getInstl() {
                return this.instl_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setInstl(boolean z) {
                this.bitField0_ |= 64;
                this.instl_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearInstl() {
                this.bitField0_ &= -65;
                this.instl_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasTagid() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getTagid() {
                return this.tagid_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ByteString getTagidBytes() {
                return ByteString.copyFromUtf8(this.tagid_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTagid(String str) {
                str.getClass();
                this.bitField0_ |= 128;
                this.tagid_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearTagid() {
                this.bitField0_ &= -129;
                this.tagid_ = getDefaultInstance().getTagid();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTagidBytes(ByteString byteString) {
                this.tagid_ = byteString.toStringUtf8();
                this.bitField0_ |= 128;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasBidfloor() {
                return (this.bitField0_ & 256) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public double getBidfloor() {
                return this.bidfloor_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidfloor(double d) {
                this.bitField0_ |= 256;
                this.bidfloor_ = d;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBidfloor() {
                this.bitField0_ &= -257;
                this.bidfloor_ = 0.0d;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasBidfloorcur() {
                return (this.bitField0_ & 512) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getBidfloorcur() {
                return this.bidfloorcur_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ByteString getBidfloorcurBytes() {
                return ByteString.copyFromUtf8(this.bidfloorcur_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidfloorcur(String str) {
                str.getClass();
                this.bitField0_ |= 512;
                this.bidfloorcur_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBidfloorcur() {
                this.bitField0_ &= -513;
                this.bidfloorcur_ = getDefaultInstance().getBidfloorcur();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidfloorcurBytes(ByteString byteString) {
                this.bidfloorcur_ = byteString.toStringUtf8();
                this.bitField0_ |= 512;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasClickbrowser() {
                return (this.bitField0_ & 1024) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean getClickbrowser() {
                return this.clickbrowser_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setClickbrowser(boolean z) {
                this.bitField0_ |= 1024;
                this.clickbrowser_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearClickbrowser() {
                this.bitField0_ &= -1025;
                this.clickbrowser_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasSecure() {
                return (this.bitField0_ & 2048) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean getSecure() {
                return this.secure_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSecure(boolean z) {
                this.bitField0_ |= 2048;
                this.secure_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSecure() {
                this.bitField0_ &= -2049;
                this.secure_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public List<String> getIframebusterList() {
                return this.iframebuster_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public int getIframebusterCount() {
                return this.iframebuster_.size();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public String getIframebuster(int i) {
                return this.iframebuster_.get(i);
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ByteString getIframebusterBytes(int i) {
                return ByteString.copyFromUtf8(this.iframebuster_.get(i));
            }

            private void ensureIframebusterIsMutable() {
                Internal.ProtobufList<String> protobufList = this.iframebuster_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.iframebuster_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setIframebuster(int i, String str) {
                str.getClass();
                ensureIframebusterIsMutable();
                this.iframebuster_.set(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addIframebuster(String str) {
                str.getClass();
                ensureIframebusterIsMutable();
                this.iframebuster_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllIframebuster(Iterable<String> iterable) {
                ensureIframebusterIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.iframebuster_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearIframebuster() {
                this.iframebuster_ = GeneratedMessageLite.emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addIframebusterBytes(ByteString byteString) {
                ensureIframebusterIsMutable();
                this.iframebuster_.add(byteString.toStringUtf8());
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasRwdd() {
                return (this.bitField0_ & 4096) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean getRwdd() {
                return this.rwdd_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRwdd(boolean z) {
                this.bitField0_ |= 4096;
                this.rwdd_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRwdd() {
                this.bitField0_ &= -4097;
                this.rwdd_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasSsai() {
                return (this.bitField0_ & 8192) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public ServerSideAdInsertionType getSsai() {
                ServerSideAdInsertionType serverSideAdInsertionTypeForNumber = ServerSideAdInsertionType.forNumber(this.ssai_);
                return serverSideAdInsertionTypeForNumber == null ? ServerSideAdInsertionType.SERVER_SIDE_AD_INSERTION_TYPE_UNKNOWN : serverSideAdInsertionTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setSsai(ServerSideAdInsertionType serverSideAdInsertionType) {
                this.ssai_ = serverSideAdInsertionType.getNumber();
                this.bitField0_ |= 8192;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearSsai() {
                this.bitField0_ &= -8193;
                this.ssai_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasPmp() {
                return (this.bitField0_ & 16384) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Pmp getPmp() {
                Pmp pmp = this.pmp_;
                return pmp == null ? Pmp.getDefaultInstance() : pmp;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPmp(Pmp pmp) {
                pmp.getClass();
                this.pmp_ = pmp;
                this.bitField0_ |= 16384;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergePmp(Pmp pmp) {
                pmp.getClass();
                Pmp pmp2 = this.pmp_;
                if (pmp2 != null && pmp2 != Pmp.getDefaultInstance()) {
                    this.pmp_ = ((Pmp.Builder) Pmp.newBuilder(this.pmp_).mergeFrom(pmp)).buildPartial();
                } else {
                    this.pmp_ = pmp;
                }
                this.bitField0_ |= 16384;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPmp() {
                this.pmp_ = null;
                this.bitField0_ &= -16385;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasNative() {
                return (this.bitField0_ & 32768) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Native getNative() {
                Native r0 = this.native_;
                return r0 == null ? Native.getDefaultInstance() : r0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNative(Native r2) {
                r2.getClass();
                this.native_ = r2;
                this.bitField0_ |= 32768;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public void mergeNative(Native r3) {
                r3.getClass();
                Native r0 = this.native_;
                if (r0 != null && r0 != Native.getDefaultInstance()) {
                    this.native_ = ((Native.Builder) Native.newBuilder(this.native_).mergeFrom(r3)).buildPartial();
                } else {
                    this.native_ = r3;
                }
                this.bitField0_ |= 32768;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNative() {
                this.native_ = null;
                this.bitField0_ &= -32769;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public boolean hasExp() {
                return (this.bitField0_ & 65536) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public int getExp() {
                return this.exp_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setExp(int i) {
                this.bitField0_ |= 65536;
                this.exp_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearExp() {
                this.bitField0_ &= -65537;
                this.exp_ = 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public List<Metric> getMetricList() {
                return this.metric_;
            }

            public List<? extends MetricOrBuilder> getMetricOrBuilderList() {
                return this.metric_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public int getMetricCount() {
                return this.metric_.size();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
            public Metric getMetric(int i) {
                return this.metric_.get(i);
            }

            public MetricOrBuilder getMetricOrBuilder(int i) {
                return this.metric_.get(i);
            }

            private void ensureMetricIsMutable() {
                Internal.ProtobufList<Metric> protobufList = this.metric_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.metric_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMetric(int i, Metric metric) {
                metric.getClass();
                ensureMetricIsMutable();
                this.metric_.set(i, metric);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addMetric(Metric metric) {
                metric.getClass();
                ensureMetricIsMutable();
                this.metric_.add(metric);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addMetric(int i, Metric metric) {
                metric.getClass();
                ensureMetricIsMutable();
                this.metric_.add(i, metric);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllMetric(Iterable<? extends Metric> iterable) {
                ensureMetricIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.metric_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMetric() {
                this.metric_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeMetric(int i) {
                ensureMetricIsMutable();
                this.metric_.remove(i);
            }

            public static Imp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Imp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Imp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Imp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Imp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Imp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Imp parseFrom(InputStream inputStream) throws IOException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Imp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Imp parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Imp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Imp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Imp) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Imp parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Imp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Imp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.createBuilder();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Builder newBuilder(Imp imp) {
                return (Builder) DEFAULT_INSTANCE.createBuilder(imp);
            }

            public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Imp, Builder> implements ImpOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Imp.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasId() {
                    return ((Imp) this.instance).hasId();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getId() {
                    return ((Imp) this.instance).getId();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getIdBytes() {
                    return ((Imp) this.instance).getIdBytes();
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setId(str);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((Imp) this.instance).clearId();
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).setIdBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasBanner() {
                    return ((Imp) this.instance).hasBanner();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Banner getBanner() {
                    return ((Imp) this.instance).getBanner();
                }

                public Builder setBanner(Banner banner) {
                    copyOnWrite();
                    ((Imp) this.instance).setBanner(banner);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setBanner(Banner.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setBanner((Banner) builder.build());
                    return this;
                }

                public Builder mergeBanner(Banner banner) {
                    copyOnWrite();
                    ((Imp) this.instance).mergeBanner(banner);
                    return this;
                }

                public Builder clearBanner() {
                    copyOnWrite();
                    ((Imp) this.instance).clearBanner();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasVideo() {
                    return ((Imp) this.instance).hasVideo();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Video getVideo() {
                    return ((Imp) this.instance).getVideo();
                }

                public Builder setVideo(Video video) {
                    copyOnWrite();
                    ((Imp) this.instance).setVideo(video);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setVideo(Video.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setVideo((Video) builder.build());
                    return this;
                }

                public Builder mergeVideo(Video video) {
                    copyOnWrite();
                    ((Imp) this.instance).mergeVideo(video);
                    return this;
                }

                public Builder clearVideo() {
                    copyOnWrite();
                    ((Imp) this.instance).clearVideo();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasAudio() {
                    return ((Imp) this.instance).hasAudio();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Audio getAudio() {
                    return ((Imp) this.instance).getAudio();
                }

                public Builder setAudio(Audio audio) {
                    copyOnWrite();
                    ((Imp) this.instance).setAudio(audio);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setAudio(Audio.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setAudio((Audio) builder.build());
                    return this;
                }

                public Builder mergeAudio(Audio audio) {
                    copyOnWrite();
                    ((Imp) this.instance).mergeAudio(audio);
                    return this;
                }

                public Builder clearAudio() {
                    copyOnWrite();
                    ((Imp) this.instance).clearAudio();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasDisplaymanager() {
                    return ((Imp) this.instance).hasDisplaymanager();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getDisplaymanager() {
                    return ((Imp) this.instance).getDisplaymanager();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getDisplaymanagerBytes() {
                    return ((Imp) this.instance).getDisplaymanagerBytes();
                }

                public Builder setDisplaymanager(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setDisplaymanager(str);
                    return this;
                }

                public Builder clearDisplaymanager() {
                    copyOnWrite();
                    ((Imp) this.instance).clearDisplaymanager();
                    return this;
                }

                public Builder setDisplaymanagerBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).setDisplaymanagerBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasDisplaymanagerver() {
                    return ((Imp) this.instance).hasDisplaymanagerver();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getDisplaymanagerver() {
                    return ((Imp) this.instance).getDisplaymanagerver();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getDisplaymanagerverBytes() {
                    return ((Imp) this.instance).getDisplaymanagerverBytes();
                }

                public Builder setDisplaymanagerver(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setDisplaymanagerver(str);
                    return this;
                }

                public Builder clearDisplaymanagerver() {
                    copyOnWrite();
                    ((Imp) this.instance).clearDisplaymanagerver();
                    return this;
                }

                public Builder setDisplaymanagerverBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).setDisplaymanagerverBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasInstl() {
                    return ((Imp) this.instance).hasInstl();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean getInstl() {
                    return ((Imp) this.instance).getInstl();
                }

                public Builder setInstl(boolean z) {
                    copyOnWrite();
                    ((Imp) this.instance).setInstl(z);
                    return this;
                }

                public Builder clearInstl() {
                    copyOnWrite();
                    ((Imp) this.instance).clearInstl();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasTagid() {
                    return ((Imp) this.instance).hasTagid();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getTagid() {
                    return ((Imp) this.instance).getTagid();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getTagidBytes() {
                    return ((Imp) this.instance).getTagidBytes();
                }

                public Builder setTagid(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setTagid(str);
                    return this;
                }

                public Builder clearTagid() {
                    copyOnWrite();
                    ((Imp) this.instance).clearTagid();
                    return this;
                }

                public Builder setTagidBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).setTagidBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasBidfloor() {
                    return ((Imp) this.instance).hasBidfloor();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public double getBidfloor() {
                    return ((Imp) this.instance).getBidfloor();
                }

                public Builder setBidfloor(double d) {
                    copyOnWrite();
                    ((Imp) this.instance).setBidfloor(d);
                    return this;
                }

                public Builder clearBidfloor() {
                    copyOnWrite();
                    ((Imp) this.instance).clearBidfloor();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasBidfloorcur() {
                    return ((Imp) this.instance).hasBidfloorcur();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getBidfloorcur() {
                    return ((Imp) this.instance).getBidfloorcur();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getBidfloorcurBytes() {
                    return ((Imp) this.instance).getBidfloorcurBytes();
                }

                public Builder setBidfloorcur(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setBidfloorcur(str);
                    return this;
                }

                public Builder clearBidfloorcur() {
                    copyOnWrite();
                    ((Imp) this.instance).clearBidfloorcur();
                    return this;
                }

                public Builder setBidfloorcurBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).setBidfloorcurBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasClickbrowser() {
                    return ((Imp) this.instance).hasClickbrowser();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean getClickbrowser() {
                    return ((Imp) this.instance).getClickbrowser();
                }

                public Builder setClickbrowser(boolean z) {
                    copyOnWrite();
                    ((Imp) this.instance).setClickbrowser(z);
                    return this;
                }

                public Builder clearClickbrowser() {
                    copyOnWrite();
                    ((Imp) this.instance).clearClickbrowser();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasSecure() {
                    return ((Imp) this.instance).hasSecure();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean getSecure() {
                    return ((Imp) this.instance).getSecure();
                }

                public Builder setSecure(boolean z) {
                    copyOnWrite();
                    ((Imp) this.instance).setSecure(z);
                    return this;
                }

                public Builder clearSecure() {
                    copyOnWrite();
                    ((Imp) this.instance).clearSecure();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public List<String> getIframebusterList() {
                    return Collections.unmodifiableList(((Imp) this.instance).getIframebusterList());
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public int getIframebusterCount() {
                    return ((Imp) this.instance).getIframebusterCount();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public String getIframebuster(int i) {
                    return ((Imp) this.instance).getIframebuster(i);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ByteString getIframebusterBytes(int i) {
                    return ((Imp) this.instance).getIframebusterBytes(i);
                }

                public Builder setIframebuster(int i, String str) {
                    copyOnWrite();
                    ((Imp) this.instance).setIframebuster(i, str);
                    return this;
                }

                public Builder addIframebuster(String str) {
                    copyOnWrite();
                    ((Imp) this.instance).addIframebuster(str);
                    return this;
                }

                public Builder addAllIframebuster(Iterable<String> iterable) {
                    copyOnWrite();
                    ((Imp) this.instance).addAllIframebuster(iterable);
                    return this;
                }

                public Builder clearIframebuster() {
                    copyOnWrite();
                    ((Imp) this.instance).clearIframebuster();
                    return this;
                }

                public Builder addIframebusterBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Imp) this.instance).addIframebusterBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasRwdd() {
                    return ((Imp) this.instance).hasRwdd();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean getRwdd() {
                    return ((Imp) this.instance).getRwdd();
                }

                public Builder setRwdd(boolean z) {
                    copyOnWrite();
                    ((Imp) this.instance).setRwdd(z);
                    return this;
                }

                public Builder clearRwdd() {
                    copyOnWrite();
                    ((Imp) this.instance).clearRwdd();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasSsai() {
                    return ((Imp) this.instance).hasSsai();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public ServerSideAdInsertionType getSsai() {
                    return ((Imp) this.instance).getSsai();
                }

                public Builder setSsai(ServerSideAdInsertionType serverSideAdInsertionType) {
                    copyOnWrite();
                    ((Imp) this.instance).setSsai(serverSideAdInsertionType);
                    return this;
                }

                public Builder clearSsai() {
                    copyOnWrite();
                    ((Imp) this.instance).clearSsai();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasPmp() {
                    return ((Imp) this.instance).hasPmp();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Pmp getPmp() {
                    return ((Imp) this.instance).getPmp();
                }

                public Builder setPmp(Pmp pmp) {
                    copyOnWrite();
                    ((Imp) this.instance).setPmp(pmp);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setPmp(Pmp.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setPmp((Pmp) builder.build());
                    return this;
                }

                public Builder mergePmp(Pmp pmp) {
                    copyOnWrite();
                    ((Imp) this.instance).mergePmp(pmp);
                    return this;
                }

                public Builder clearPmp() {
                    copyOnWrite();
                    ((Imp) this.instance).clearPmp();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasNative() {
                    return ((Imp) this.instance).hasNative();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Native getNative() {
                    return ((Imp) this.instance).getNative();
                }

                public Builder setNative(Native r2) {
                    copyOnWrite();
                    ((Imp) this.instance).setNative(r2);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setNative(Native.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setNative((Native) builder.build());
                    return this;
                }

                public Builder mergeNative(Native r2) {
                    copyOnWrite();
                    ((Imp) this.instance).mergeNative(r2);
                    return this;
                }

                public Builder clearNative() {
                    copyOnWrite();
                    ((Imp) this.instance).clearNative();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public boolean hasExp() {
                    return ((Imp) this.instance).hasExp();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public int getExp() {
                    return ((Imp) this.instance).getExp();
                }

                public Builder setExp(int i) {
                    copyOnWrite();
                    ((Imp) this.instance).setExp(i);
                    return this;
                }

                public Builder clearExp() {
                    copyOnWrite();
                    ((Imp) this.instance).clearExp();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public List<Metric> getMetricList() {
                    return Collections.unmodifiableList(((Imp) this.instance).getMetricList());
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public int getMetricCount() {
                    return ((Imp) this.instance).getMetricCount();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.ImpOrBuilder
                public Metric getMetric(int i) {
                    return ((Imp) this.instance).getMetric(i);
                }

                public Builder setMetric(int i, Metric metric) {
                    copyOnWrite();
                    ((Imp) this.instance).setMetric(i, metric);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder setMetric(int i, Metric.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).setMetric(i, (Metric) builder.build());
                    return this;
                }

                public Builder addMetric(Metric metric) {
                    copyOnWrite();
                    ((Imp) this.instance).addMetric(metric);
                    return this;
                }

                public Builder addMetric(int i, Metric metric) {
                    copyOnWrite();
                    ((Imp) this.instance).addMetric(i, metric);
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder addMetric(Metric.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).addMetric((Metric) builder.build());
                    return this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public Builder addMetric(int i, Metric.Builder builder) {
                    copyOnWrite();
                    ((Imp) this.instance).addMetric(i, (Metric) builder.build());
                    return this;
                }

                public Builder addAllMetric(Iterable<? extends Metric> iterable) {
                    copyOnWrite();
                    ((Imp) this.instance).addAllMetric(iterable);
                    return this;
                }

                public Builder clearMetric() {
                    copyOnWrite();
                    ((Imp) this.instance).clearMetric();
                    return this;
                }

                public Builder removeMetric(int i) {
                    copyOnWrite();
                    ((Imp) this.instance).removeMetric(i);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Imp();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0002\u0007\u0001ᔈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ဈ\u0004\u0005ဈ\u0005\u0006ဇ\u0006\u0007ဈ\u0007\bက\b\tဈ\t\n\u001a\u000bᐉ\u000e\fဇ\u000b\rᐉ\u000f\u000eင\u0010\u000fᐉ\u0003\u0010ဇ\n\u0011Л\u0012ဇ\f\u0013ဌ\r", new Object[]{"bitField0_", "id_", "banner_", "video_", "displaymanager_", "displaymanagerver_", "instl_", "tagid_", "bidfloor_", "bidfloorcur_", "iframebuster_", "pmp_", "secure_", "native_", "exp_", "audio_", "clickbrowser_", "metric_", Metric.class, "rwdd_", "ssai_", ServerSideAdInsertionType.internalGetVerifier()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Imp> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Imp.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Imp imp = new Imp();
                DEFAULT_INSTANCE = imp;
                GeneratedMessageLite.registerDefaultInstance(Imp.class, imp);
            }

            public static Imp getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Imp> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Regs extends GeneratedMessageLite<Regs, Builder> implements RegsOrBuilder {
            public static final int COPPA_FIELD_NUMBER = 1;
            private static final Regs DEFAULT_INSTANCE;
            public static final int EXT_FIELD_NUMBER = 2;
            private static volatile Parser<Regs> PARSER;
            private int bitField0_;
            private boolean coppa_;
            private Ext ext_;
            private byte memoizedIsInitialized = 2;

            public interface ExtOrBuilder extends MessageLiteOrBuilder {
                int getCcpa();

                int getGdpr();

                String getUsPrivacy();

                ByteString getUsPrivacyBytes();

                boolean hasCcpa();

                boolean hasGdpr();

                boolean hasUsPrivacy();
            }

            private Regs() {
            }

            public static final class Ext extends GeneratedMessageLite<Ext, Builder> implements ExtOrBuilder {
                public static final int CCPA_FIELD_NUMBER = 1;
                private static final Ext DEFAULT_INSTANCE;
                public static final int GDPR_FIELD_NUMBER = 2;
                private static volatile Parser<Ext> PARSER = null;
                public static final int US_PRIVACY_FIELD_NUMBER = 3;
                private int bitField0_;
                private int ccpa_;
                private int gdpr_;
                private byte memoizedIsInitialized = 2;
                private String usPrivacy_ = "";

                private Ext() {
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public boolean hasCcpa() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public int getCcpa() {
                    return this.ccpa_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setCcpa(int i) {
                    this.bitField0_ |= 1;
                    this.ccpa_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearCcpa() {
                    this.bitField0_ &= -2;
                    this.ccpa_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public boolean hasGdpr() {
                    return (this.bitField0_ & 2) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public int getGdpr() {
                    return this.gdpr_;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setGdpr(int i) {
                    this.bitField0_ |= 2;
                    this.gdpr_ = i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearGdpr() {
                    this.bitField0_ &= -3;
                    this.gdpr_ = 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public boolean hasUsPrivacy() {
                    return (this.bitField0_ & 4) != 0;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public String getUsPrivacy() {
                    return this.usPrivacy_;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                public ByteString getUsPrivacyBytes() {
                    return ByteString.copyFromUtf8(this.usPrivacy_);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setUsPrivacy(String str) {
                    str.getClass();
                    this.bitField0_ |= 4;
                    this.usPrivacy_ = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void clearUsPrivacy() {
                    this.bitField0_ &= -5;
                    this.usPrivacy_ = getDefaultInstance().getUsPrivacy();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void setUsPrivacyBytes(ByteString byteString) {
                    this.usPrivacy_ = byteString.toStringUtf8();
                    this.bitField0_ |= 4;
                }

                public static Ext parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
                }

                public static Ext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
                }

                public static Ext parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
                }

                public static Ext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
                }

                public static Ext parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
                }

                public static Ext parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
                }

                public static Ext parseFrom(InputStream inputStream) throws IOException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Ext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Ext parseDelimitedFrom(InputStream inputStream) throws IOException {
                    return (Ext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
                }

                public static Ext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Ext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
                }

                public static Ext parseFrom(CodedInputStream codedInputStream) throws IOException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
                }

                public static Ext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return (Ext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Builder newBuilder(Ext ext) {
                    return DEFAULT_INSTANCE.createBuilder(ext);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<Ext, Builder> implements ExtOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Ext.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public boolean hasCcpa() {
                        return ((Ext) this.instance).hasCcpa();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public int getCcpa() {
                        return ((Ext) this.instance).getCcpa();
                    }

                    public Builder setCcpa(int i) {
                        copyOnWrite();
                        ((Ext) this.instance).setCcpa(i);
                        return this;
                    }

                    public Builder clearCcpa() {
                        copyOnWrite();
                        ((Ext) this.instance).clearCcpa();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public boolean hasGdpr() {
                        return ((Ext) this.instance).hasGdpr();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public int getGdpr() {
                        return ((Ext) this.instance).getGdpr();
                    }

                    public Builder setGdpr(int i) {
                        copyOnWrite();
                        ((Ext) this.instance).setGdpr(i);
                        return this;
                    }

                    public Builder clearGdpr() {
                        copyOnWrite();
                        ((Ext) this.instance).clearGdpr();
                        return this;
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public boolean hasUsPrivacy() {
                        return ((Ext) this.instance).hasUsPrivacy();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public String getUsPrivacy() {
                        return ((Ext) this.instance).getUsPrivacy();
                    }

                    @Override // com.moloco.sdk.BidRequest.SdkBidRequest.Regs.ExtOrBuilder
                    public ByteString getUsPrivacyBytes() {
                        return ((Ext) this.instance).getUsPrivacyBytes();
                    }

                    public Builder setUsPrivacy(String str) {
                        copyOnWrite();
                        ((Ext) this.instance).setUsPrivacy(str);
                        return this;
                    }

                    public Builder clearUsPrivacy() {
                        copyOnWrite();
                        ((Ext) this.instance).clearUsPrivacy();
                        return this;
                    }

                    public Builder setUsPrivacyBytes(ByteString byteString) {
                        copyOnWrite();
                        ((Ext) this.instance).setUsPrivacyBytes(byteString);
                        return this;
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageLite
                protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                    AnonymousClass1 anonymousClass1 = null;
                    switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                        case 1:
                            return new Ext();
                        case 2:
                            return new Builder(anonymousClass1);
                        case 3:
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔈ\u0002", new Object[]{"bitField0_", "ccpa_", "gdpr_", "usPrivacy_"});
                        case 4:
                            return DEFAULT_INSTANCE;
                        case 5:
                            Parser<Ext> defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                synchronized (Ext.class) {
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
                            return Byte.valueOf(this.memoizedIsInitialized);
                        case 7:
                            this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                static {
                    Ext ext = new Ext();
                    DEFAULT_INSTANCE = ext;
                    GeneratedMessageLite.registerDefaultInstance(Ext.class, ext);
                }

                public static Ext getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Ext> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
            public boolean hasCoppa() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
            public boolean getCoppa() {
                return this.coppa_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCoppa(boolean z) {
                this.bitField0_ |= 1;
                this.coppa_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCoppa() {
                this.bitField0_ &= -2;
                this.coppa_ = false;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
            public boolean hasExt() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
            public Ext getExt() {
                Ext ext = this.ext_;
                return ext == null ? Ext.getDefaultInstance() : ext;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setExt(Ext ext) {
                ext.getClass();
                this.ext_ = ext;
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeExt(Ext ext) {
                ext.getClass();
                Ext ext2 = this.ext_;
                if (ext2 != null && ext2 != Ext.getDefaultInstance()) {
                    this.ext_ = Ext.newBuilder(this.ext_).mergeFrom(ext).buildPartial();
                } else {
                    this.ext_ = ext;
                }
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearExt() {
                this.ext_ = null;
                this.bitField0_ &= -3;
            }

            public static Regs parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Regs parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Regs parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static Regs parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Regs parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static Regs parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Regs parseFrom(InputStream inputStream) throws IOException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Regs parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Regs parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Regs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static Regs parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Regs) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Regs parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Regs parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Regs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(Regs regs) {
                return DEFAULT_INSTANCE.createBuilder(regs);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<Regs, Builder> implements RegsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(Regs.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
                public boolean hasCoppa() {
                    return ((Regs) this.instance).hasCoppa();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
                public boolean getCoppa() {
                    return ((Regs) this.instance).getCoppa();
                }

                public Builder setCoppa(boolean z) {
                    copyOnWrite();
                    ((Regs) this.instance).setCoppa(z);
                    return this;
                }

                public Builder clearCoppa() {
                    copyOnWrite();
                    ((Regs) this.instance).clearCoppa();
                    return this;
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
                public boolean hasExt() {
                    return ((Regs) this.instance).hasExt();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.RegsOrBuilder
                public Ext getExt() {
                    return ((Regs) this.instance).getExt();
                }

                public Builder setExt(Ext ext) {
                    copyOnWrite();
                    ((Regs) this.instance).setExt(ext);
                    return this;
                }

                public Builder setExt(Ext.Builder builder) {
                    copyOnWrite();
                    ((Regs) this.instance).setExt(builder.build());
                    return this;
                }

                public Builder mergeExt(Ext ext) {
                    copyOnWrite();
                    ((Regs) this.instance).mergeExt(ext);
                    return this;
                }

                public Builder clearExt() {
                    copyOnWrite();
                    ((Regs) this.instance).clearExt();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Regs();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဇ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "coppa_", qc.b});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Regs> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (Regs.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                Regs regs = new Regs();
                DEFAULT_INSTANCE = regs;
                GeneratedMessageLite.registerDefaultInstance(Regs.class, regs);
            }

            public static Regs getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Regs> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class User extends GeneratedMessageLite<User, Builder> implements UserOrBuilder {
            private static final User DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 1;
            private static volatile Parser<User> PARSER;
            private int bitField0_;
            private byte memoizedIsInitialized = 2;
            private String id_ = "";

            private User() {
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
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
                this.id_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            public static User parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static User parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static User parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static User parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static User parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static User parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static User parseFrom(InputStream inputStream) throws IOException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static User parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static User parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (User) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static User parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (User) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static User parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static User parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (User) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(User user) {
                return DEFAULT_INSTANCE.createBuilder(user);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<User, Builder> implements UserOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(User.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
                public boolean hasId() {
                    return ((User) this.instance).hasId();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
                public String getId() {
                    return ((User) this.instance).getId();
                }

                @Override // com.moloco.sdk.BidRequest.SdkBidRequest.UserOrBuilder
                public ByteString getIdBytes() {
                    return ((User) this.instance).getIdBytes();
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((User) this.instance).setId(str);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((User) this.instance).clearId();
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((User) this.instance).setIdBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new User();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔈ\u0000", new Object[]{"bitField0_", "id_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<User> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (User.class) {
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
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                User user = new User();
                DEFAULT_INSTANCE = user;
                GeneratedMessageLite.registerDefaultInstance(User.class, user);
            }

            public static User getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<User> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasApp() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public App getApp() {
            App app = this.app_;
            return app == null ? App.getDefaultInstance() : app;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApp(App app) {
            app.getClass();
            this.app_ = app;
            this.bitField0_ |= 1;
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
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApp() {
            this.app_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasDevice() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public Device getDevice() {
            Device device = this.device_;
            return device == null ? Device.getDefaultInstance() : device;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device device) {
            device.getClass();
            this.device_ = device;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeDevice(Device device) {
            device.getClass();
            Device device2 = this.device_;
            if (device2 != null && device2 != Device.getDefaultInstance()) {
                this.device_ = ((Device.Builder) Device.newBuilder(this.device_).mergeFrom(device)).buildPartial();
            } else {
                this.device_ = device;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasImp() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public Imp getImp() {
            Imp imp = this.imp_;
            return imp == null ? Imp.getDefaultInstance() : imp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImp(Imp imp) {
            imp.getClass();
            this.imp_ = imp;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeImp(Imp imp) {
            imp.getClass();
            Imp imp2 = this.imp_;
            if (imp2 != null && imp2 != Imp.getDefaultInstance()) {
                this.imp_ = ((Imp.Builder) Imp.newBuilder(this.imp_).mergeFrom(imp)).buildPartial();
            } else {
                this.imp_ = imp;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImp() {
            this.imp_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasRegs() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public Regs getRegs() {
            Regs regs = this.regs_;
            return regs == null ? Regs.getDefaultInstance() : regs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRegs(Regs regs) {
            regs.getClass();
            this.regs_ = regs;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRegs(Regs regs) {
            regs.getClass();
            Regs regs2 = this.regs_;
            if (regs2 != null && regs2 != Regs.getDefaultInstance()) {
                this.regs_ = Regs.newBuilder(this.regs_).mergeFrom(regs).buildPartial();
            } else {
                this.regs_ = regs;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRegs() {
            this.regs_ = null;
            this.bitField0_ &= -9;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasTmax() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public int getTmax() {
            return this.tmax_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTmax(int i) {
            this.bitField0_ |= 16;
            this.tmax_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTmax() {
            this.bitField0_ &= -17;
            this.tmax_ = 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public boolean hasUser() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
        public User getUser() {
            User user = this.user_;
            return user == null ? User.getDefaultInstance() : user;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUser(User user) {
            user.getClass();
            this.user_ = user;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUser(User user) {
            user.getClass();
            User user2 = this.user_;
            if (user2 != null && user2 != User.getDefaultInstance()) {
                this.user_ = User.newBuilder(this.user_).mergeFrom(user).buildPartial();
            } else {
                this.user_ = user;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUser() {
            this.user_ = null;
            this.bitField0_ &= -33;
        }

        public static SdkBidRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SdkBidRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SdkBidRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SdkBidRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SdkBidRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SdkBidRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SdkBidRequest parseFrom(InputStream inputStream) throws IOException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkBidRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkBidRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SdkBidRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SdkBidRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkBidRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SdkBidRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SdkBidRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SdkBidRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SdkBidRequest sdkBidRequest) {
            return DEFAULT_INSTANCE.createBuilder(sdkBidRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SdkBidRequest, Builder> implements SdkBidRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SdkBidRequest.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasApp() {
                return ((SdkBidRequest) this.instance).hasApp();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public App getApp() {
                return ((SdkBidRequest) this.instance).getApp();
            }

            public Builder setApp(App app) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setApp(app);
                return this;
            }

            public Builder setApp(App.Builder builder) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setApp(builder.build());
                return this;
            }

            public Builder mergeApp(App app) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).mergeApp(app);
                return this;
            }

            public Builder clearApp() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearApp();
                return this;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasDevice() {
                return ((SdkBidRequest) this.instance).hasDevice();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public Device getDevice() {
                return ((SdkBidRequest) this.instance).getDevice();
            }

            public Builder setDevice(Device device) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setDevice(device);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder setDevice(Device.Builder builder) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setDevice((Device) builder.build());
                return this;
            }

            public Builder mergeDevice(Device device) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).mergeDevice(device);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearDevice();
                return this;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasImp() {
                return ((SdkBidRequest) this.instance).hasImp();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public Imp getImp() {
                return ((SdkBidRequest) this.instance).getImp();
            }

            public Builder setImp(Imp imp) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setImp(imp);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder setImp(Imp.Builder builder) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setImp((Imp) builder.build());
                return this;
            }

            public Builder mergeImp(Imp imp) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).mergeImp(imp);
                return this;
            }

            public Builder clearImp() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearImp();
                return this;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasRegs() {
                return ((SdkBidRequest) this.instance).hasRegs();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public Regs getRegs() {
                return ((SdkBidRequest) this.instance).getRegs();
            }

            public Builder setRegs(Regs regs) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setRegs(regs);
                return this;
            }

            public Builder setRegs(Regs.Builder builder) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setRegs(builder.build());
                return this;
            }

            public Builder mergeRegs(Regs regs) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).mergeRegs(regs);
                return this;
            }

            public Builder clearRegs() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearRegs();
                return this;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasTmax() {
                return ((SdkBidRequest) this.instance).hasTmax();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public int getTmax() {
                return ((SdkBidRequest) this.instance).getTmax();
            }

            public Builder setTmax(int i) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setTmax(i);
                return this;
            }

            public Builder clearTmax() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearTmax();
                return this;
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public boolean hasUser() {
                return ((SdkBidRequest) this.instance).hasUser();
            }

            @Override // com.moloco.sdk.BidRequest.SdkBidRequestOrBuilder
            public User getUser() {
                return ((SdkBidRequest) this.instance).getUser();
            }

            public Builder setUser(User user) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setUser(user);
                return this;
            }

            public Builder setUser(User.Builder builder) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).setUser(builder.build());
                return this;
            }

            public Builder mergeUser(User user) {
                copyOnWrite();
                ((SdkBidRequest) this.instance).mergeUser(user);
                return this;
            }

            public Builder clearUser() {
                copyOnWrite();
                ((SdkBidRequest) this.instance).clearUser();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SdkBidRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0005\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᔉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006ᐉ\u0005", new Object[]{"bitField0_", "app_", "device_", "imp_", "regs_", "tmax_", "user_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SdkBidRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SdkBidRequest.class) {
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
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SdkBidRequest sdkBidRequest = new SdkBidRequest();
            DEFAULT_INSTANCE = sdkBidRequest;
            GeneratedMessageLite.registerDefaultInstance(SdkBidRequest.class, sdkBidRequest);
        }

        public static SdkBidRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SdkBidRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.BidRequest$1, reason: invalid class name */
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
