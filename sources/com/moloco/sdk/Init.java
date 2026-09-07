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

/* JADX INFO: loaded from: classes.dex */
public final class Init {

    public interface SDKInitResponseOrBuilder extends MessageLiteOrBuilder {
        String getAdServerUrl();

        ByteString getAdServerUrlBytes();

        SDKInitResponse.AdUnit getAdUnits(int i);

        int getAdUnitsCount();

        List<SDKInitResponse.AdUnit> getAdUnitsList();

        String getAppId();

        ByteString getAppIdBytes();

        SDKInitResponse.BidTokenConfig getBidTokenConfig();

        ConfigsOuterClass.Configs getConfigs();

        String getCountryIso2Code();

        ByteString getCountryIso2CodeBytes();

        String getCountryIso3Code();

        ByteString getCountryIso3CodeBytes();

        SDKInitResponse.CrashReportingConfig getCrashReportingConfig();

        SDKInitResponse.EventCollectionConfig getEventCollectionConfig();

        SDKInitResponse.ExperimentalFeatureFlag getExperimentalFeatureFlags(int i);

        int getExperimentalFeatureFlagsCount();

        List<SDKInitResponse.ExperimentalFeatureFlag> getExperimentalFeatureFlagsList();

        SDKInitResponse.Geo getGeo();

        SDKInitResponse.OperationalMetricsConfig getOperationalMetricsConfig();

        String getPlatformId();

        ByteString getPlatformIdBytes();

        String getPublisherId();

        ByteString getPublisherIdBytes();

        SDKInitResponse.Region getResolvedRegion();

        int getResolvedRegionValue();

        boolean getVerifyBannerVisible();

        boolean hasBidTokenConfig();

        boolean hasConfigs();

        boolean hasCrashReportingConfig();

        boolean hasEventCollectionConfig();

        boolean hasGeo();

        boolean hasOperationalMetricsConfig();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Init() {
    }

    public static final class SDKInitResponse extends GeneratedMessageLite<SDKInitResponse, Builder> implements SDKInitResponseOrBuilder {
        public static final int AD_SERVER_URL_FIELD_NUMBER = 6;
        public static final int AD_UNITS_FIELD_NUMBER = 4;
        public static final int APP_ID_FIELD_NUMBER = 1;
        public static final int BID_TOKEN_CONFIG_FIELD_NUMBER = 12;
        public static final int CONFIGS_FIELD_NUMBER = 16;
        public static final int COUNTRY_ISO2_CODE_FIELD_NUMBER = 7;
        public static final int COUNTRY_ISO3_CODE_FIELD_NUMBER = 3;
        public static final int CRASH_REPORTING_CONFIG_FIELD_NUMBER = 15;
        private static final SDKInitResponse DEFAULT_INSTANCE;
        public static final int EVENT_COLLECTION_CONFIG_FIELD_NUMBER = 11;
        public static final int EXPERIMENTAL_FEATURE_FLAGS_FIELD_NUMBER = 13;
        public static final int GEO_FIELD_NUMBER = 10;
        public static final int OPERATIONAL_METRICS_CONFIG_FIELD_NUMBER = 14;
        private static volatile Parser<SDKInitResponse> PARSER = null;
        public static final int PLATFORM_ID_FIELD_NUMBER = 8;
        public static final int PUBLISHER_ID_FIELD_NUMBER = 2;
        public static final int RESOLVED_REGION_FIELD_NUMBER = 5;
        public static final int VERIFY_BANNER_VISIBLE_FIELD_NUMBER = 9;
        private BidTokenConfig bidTokenConfig_;
        private ConfigsOuterClass.Configs configs_;
        private CrashReportingConfig crashReportingConfig_;
        private EventCollectionConfig eventCollectionConfig_;
        private Geo geo_;
        private OperationalMetricsConfig operationalMetricsConfig_;
        private int resolvedRegion_;
        private boolean verifyBannerVisible_;
        private String appId_ = "";
        private String publisherId_ = "";
        private String countryIso3Code_ = "";
        private Internal.ProtobufList<AdUnit> adUnits_ = emptyProtobufList();
        private String adServerUrl_ = "";
        private String countryIso2Code_ = "";
        private String platformId_ = "";
        private Internal.ProtobufList<ExperimentalFeatureFlag> experimentalFeatureFlags_ = emptyProtobufList();

        public interface AdUnitOrBuilder extends MessageLiteOrBuilder {
            int getAdFrequency();

            float getBidFloor();

            String getId();

            ByteString getIdBytes();

            String getName();

            ByteString getNameBytes();

            AdUnit.Native getNative();

            AdUnit.InventoryType getType();

            int getTypeValue();

            boolean hasNative();
        }

        public interface BidTokenConfigOrBuilder extends MessageLiteOrBuilder {
            String getBidTokenUrl();

            ByteString getBidTokenUrlBytes();
        }

        public interface CrashReportingConfigOrBuilder extends MessageLiteOrBuilder {
            boolean getEnabled();

            String getUrl();

            ByteString getUrlBytes();
        }

        public interface EventCollectionConfigOrBuilder extends MessageLiteOrBuilder {
            String getAppBackgroundTrackingUrl();

            ByteString getAppBackgroundTrackingUrlBytes();

            String getAppForegroundTrackingUrl();

            ByteString getAppForegroundTrackingUrlBytes();

            boolean getEventCollectionEnabled();

            boolean getMrefCollectionEnabled();
        }

        public interface ExperimentalFeatureFlagOrBuilder extends MessageLiteOrBuilder {
            String getName();

            ByteString getNameBytes();

            String getValue();

            ByteString getValueBytes();
        }

        public interface GeoOrBuilder extends MessageLiteOrBuilder {
            String getCity();

            ByteString getCityBytes();

            String getCountryIso2Code();

            ByteString getCountryIso2CodeBytes();

            String getCountryIso3Code();

            ByteString getCountryIso3CodeBytes();

            float getLatitude();

            float getLongitude();

            String getRegion();

            ByteString getRegionBytes();

            String getZipCode();

            ByteString getZipCodeBytes();
        }

        public interface OperationalMetricsConfigOrBuilder extends MessageLiteOrBuilder {
            boolean getEnabled();

            int getPollingIntervalSeconds();

            String getUrl();

            ByteString getUrlBytes();
        }

        private SDKInitResponse() {
        }

        public enum Region implements Internal.EnumLite {
            UNKNOWN_REGION(0),
            US(1),
            ASIA(2),
            EU(3),
            LOCAL(4),
            UNIT(5),
            INDIA(6),
            UNRECOGNIZED(-1);

            public static final int ASIA_VALUE = 2;
            public static final int EU_VALUE = 3;
            public static final int INDIA_VALUE = 6;
            public static final int LOCAL_VALUE = 4;
            public static final int UNIT_VALUE = 5;
            public static final int UNKNOWN_REGION_VALUE = 0;
            public static final int US_VALUE = 1;
            private static final Internal.EnumLiteMap<Region> internalValueMap = new Internal.EnumLiteMap<Region>() { // from class: com.moloco.sdk.Init.SDKInitResponse.Region.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Region findValueByNumber(int i) {
                    return Region.forNumber(i);
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
            public static Region valueOf(int i) {
                return forNumber(i);
            }

            public static Region forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_REGION;
                    case 1:
                        return US;
                    case 2:
                        return ASIA;
                    case 3:
                        return EU;
                    case 4:
                        return LOCAL;
                    case 5:
                        return UNIT;
                    case 6:
                        return INDIA;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Region> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return RegionVerifier.INSTANCE;
            }

            private static final class RegionVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new RegionVerifier();

                private RegionVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Region.forNumber(i) != null;
                }
            }

            Region(int i) {
                this.value = i;
            }
        }

        public static final class ExperimentalFeatureFlag extends GeneratedMessageLite<ExperimentalFeatureFlag, Builder> implements ExperimentalFeatureFlagOrBuilder {
            private static final ExperimentalFeatureFlag DEFAULT_INSTANCE;
            public static final int NAME_FIELD_NUMBER = 1;
            private static volatile Parser<ExperimentalFeatureFlag> PARSER = null;
            public static final int VALUE_FIELD_NUMBER = 2;
            private String name_ = "";
            private String value_ = "";

            private ExperimentalFeatureFlag() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
            public String getValue() {
                return this.value_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
            public ByteString getValueBytes() {
                return ByteString.copyFromUtf8(this.value_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setValue(String str) {
                str.getClass();
                this.value_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearValue() {
                this.value_ = getDefaultInstance().getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setValueBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.value_ = byteString.toStringUtf8();
            }

            public static ExperimentalFeatureFlag parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static ExperimentalFeatureFlag parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ExperimentalFeatureFlag parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static ExperimentalFeatureFlag parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ExperimentalFeatureFlag parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static ExperimentalFeatureFlag parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ExperimentalFeatureFlag parseFrom(InputStream inputStream) throws IOException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ExperimentalFeatureFlag parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExperimentalFeatureFlag parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExperimentalFeatureFlag) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static ExperimentalFeatureFlag parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExperimentalFeatureFlag) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExperimentalFeatureFlag parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ExperimentalFeatureFlag parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExperimentalFeatureFlag) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ExperimentalFeatureFlag experimentalFeatureFlag) {
                return DEFAULT_INSTANCE.createBuilder(experimentalFeatureFlag);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ExperimentalFeatureFlag, Builder> implements ExperimentalFeatureFlagOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(ExperimentalFeatureFlag.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
                public String getName() {
                    return ((ExperimentalFeatureFlag) this.instance).getName();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
                public ByteString getNameBytes() {
                    return ((ExperimentalFeatureFlag) this.instance).getNameBytes();
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).setName(str);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).setNameBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
                public String getValue() {
                    return ((ExperimentalFeatureFlag) this.instance).getValue();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.ExperimentalFeatureFlagOrBuilder
                public ByteString getValueBytes() {
                    return ((ExperimentalFeatureFlag) this.instance).getValueBytes();
                }

                public Builder setValue(String str) {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).setValue(str);
                    return this;
                }

                public Builder clearValue() {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).clearValue();
                    return this;
                }

                public Builder setValueBytes(ByteString byteString) {
                    copyOnWrite();
                    ((ExperimentalFeatureFlag) this.instance).setValueBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExperimentalFeatureFlag();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "value_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ExperimentalFeatureFlag> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (ExperimentalFeatureFlag.class) {
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
                ExperimentalFeatureFlag experimentalFeatureFlag = new ExperimentalFeatureFlag();
                DEFAULT_INSTANCE = experimentalFeatureFlag;
                GeneratedMessageLite.registerDefaultInstance(ExperimentalFeatureFlag.class, experimentalFeatureFlag);
            }

            public static ExperimentalFeatureFlag getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ExperimentalFeatureFlag> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class EventCollectionConfig extends GeneratedMessageLite<EventCollectionConfig, Builder> implements EventCollectionConfigOrBuilder {
            public static final int APP_BACKGROUND_TRACKING_URL_FIELD_NUMBER = 3;
            public static final int APP_FOREGROUND_TRACKING_URL_FIELD_NUMBER = 4;
            private static final EventCollectionConfig DEFAULT_INSTANCE;
            public static final int EVENT_COLLECTION_ENABLED_FIELD_NUMBER = 1;
            public static final int MREF_COLLECTION_ENABLED_FIELD_NUMBER = 2;
            private static volatile Parser<EventCollectionConfig> PARSER;
            private String appBackgroundTrackingUrl_ = "";
            private String appForegroundTrackingUrl_ = "";
            private boolean eventCollectionEnabled_;
            private boolean mrefCollectionEnabled_;

            private EventCollectionConfig() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public boolean getEventCollectionEnabled() {
                return this.eventCollectionEnabled_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEventCollectionEnabled(boolean z) {
                this.eventCollectionEnabled_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEventCollectionEnabled() {
                this.eventCollectionEnabled_ = false;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public boolean getMrefCollectionEnabled() {
                return this.mrefCollectionEnabled_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setMrefCollectionEnabled(boolean z) {
                this.mrefCollectionEnabled_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearMrefCollectionEnabled() {
                this.mrefCollectionEnabled_ = false;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public String getAppBackgroundTrackingUrl() {
                return this.appBackgroundTrackingUrl_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public ByteString getAppBackgroundTrackingUrlBytes() {
                return ByteString.copyFromUtf8(this.appBackgroundTrackingUrl_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppBackgroundTrackingUrl(String str) {
                str.getClass();
                this.appBackgroundTrackingUrl_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAppBackgroundTrackingUrl() {
                this.appBackgroundTrackingUrl_ = getDefaultInstance().getAppBackgroundTrackingUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppBackgroundTrackingUrlBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.appBackgroundTrackingUrl_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public String getAppForegroundTrackingUrl() {
                return this.appForegroundTrackingUrl_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
            public ByteString getAppForegroundTrackingUrlBytes() {
                return ByteString.copyFromUtf8(this.appForegroundTrackingUrl_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppForegroundTrackingUrl(String str) {
                str.getClass();
                this.appForegroundTrackingUrl_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAppForegroundTrackingUrl() {
                this.appForegroundTrackingUrl_ = getDefaultInstance().getAppForegroundTrackingUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAppForegroundTrackingUrlBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.appForegroundTrackingUrl_ = byteString.toStringUtf8();
            }

            public static EventCollectionConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static EventCollectionConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static EventCollectionConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static EventCollectionConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static EventCollectionConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static EventCollectionConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static EventCollectionConfig parseFrom(InputStream inputStream) throws IOException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EventCollectionConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EventCollectionConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EventCollectionConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static EventCollectionConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventCollectionConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EventCollectionConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static EventCollectionConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EventCollectionConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(EventCollectionConfig eventCollectionConfig) {
                return DEFAULT_INSTANCE.createBuilder(eventCollectionConfig);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<EventCollectionConfig, Builder> implements EventCollectionConfigOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(EventCollectionConfig.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public boolean getEventCollectionEnabled() {
                    return ((EventCollectionConfig) this.instance).getEventCollectionEnabled();
                }

                public Builder setEventCollectionEnabled(boolean z) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setEventCollectionEnabled(z);
                    return this;
                }

                public Builder clearEventCollectionEnabled() {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).clearEventCollectionEnabled();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public boolean getMrefCollectionEnabled() {
                    return ((EventCollectionConfig) this.instance).getMrefCollectionEnabled();
                }

                public Builder setMrefCollectionEnabled(boolean z) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setMrefCollectionEnabled(z);
                    return this;
                }

                public Builder clearMrefCollectionEnabled() {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).clearMrefCollectionEnabled();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public String getAppBackgroundTrackingUrl() {
                    return ((EventCollectionConfig) this.instance).getAppBackgroundTrackingUrl();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public ByteString getAppBackgroundTrackingUrlBytes() {
                    return ((EventCollectionConfig) this.instance).getAppBackgroundTrackingUrlBytes();
                }

                public Builder setAppBackgroundTrackingUrl(String str) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setAppBackgroundTrackingUrl(str);
                    return this;
                }

                public Builder clearAppBackgroundTrackingUrl() {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).clearAppBackgroundTrackingUrl();
                    return this;
                }

                public Builder setAppBackgroundTrackingUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setAppBackgroundTrackingUrlBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public String getAppForegroundTrackingUrl() {
                    return ((EventCollectionConfig) this.instance).getAppForegroundTrackingUrl();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.EventCollectionConfigOrBuilder
                public ByteString getAppForegroundTrackingUrlBytes() {
                    return ((EventCollectionConfig) this.instance).getAppForegroundTrackingUrlBytes();
                }

                public Builder setAppForegroundTrackingUrl(String str) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setAppForegroundTrackingUrl(str);
                    return this;
                }

                public Builder clearAppForegroundTrackingUrl() {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).clearAppForegroundTrackingUrl();
                    return this;
                }

                public Builder setAppForegroundTrackingUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((EventCollectionConfig) this.instance).setAppForegroundTrackingUrlBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EventCollectionConfig();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003Ȉ\u0004Ȉ", new Object[]{"eventCollectionEnabled_", "mrefCollectionEnabled_", "appBackgroundTrackingUrl_", "appForegroundTrackingUrl_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EventCollectionConfig> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (EventCollectionConfig.class) {
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
                EventCollectionConfig eventCollectionConfig = new EventCollectionConfig();
                DEFAULT_INSTANCE = eventCollectionConfig;
                GeneratedMessageLite.registerDefaultInstance(EventCollectionConfig.class, eventCollectionConfig);
            }

            public static EventCollectionConfig getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<EventCollectionConfig> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class AdUnit extends GeneratedMessageLite<AdUnit, Builder> implements AdUnitOrBuilder {
            public static final int AD_FREQUENCY_FIELD_NUMBER = 3;
            public static final int BID_FLOOR_FIELD_NUMBER = 4;
            private static final AdUnit DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 1;
            public static final int NAME_FIELD_NUMBER = 5;
            public static final int NATIVE_FIELD_NUMBER = 6;
            private static volatile Parser<AdUnit> PARSER = null;
            public static final int TYPE_FIELD_NUMBER = 2;
            private int adFrequency_;
            private float bidFloor_;
            private String id_ = "";
            private String name_ = "";
            private Native native_;
            private int type_;

            public interface NativeOrBuilder extends MessageLiteOrBuilder {
                Native.Type getType();

                int getTypeValue();
            }

            private AdUnit() {
            }

            public enum InventoryType implements Internal.EnumLite {
                INVALID(0),
                BANNER(1),
                INTERSTITIAL(2),
                NATIVE(3),
                REWARD_VIDEO(4),
                MREC(6),
                UNRECOGNIZED(-1);

                public static final int BANNER_VALUE = 1;
                public static final int INTERSTITIAL_VALUE = 2;
                public static final int INVALID_VALUE = 0;
                public static final int MREC_VALUE = 6;
                public static final int NATIVE_VALUE = 3;
                public static final int REWARD_VIDEO_VALUE = 4;
                private static final Internal.EnumLiteMap<InventoryType> internalValueMap = new Internal.EnumLiteMap<InventoryType>() { // from class: com.moloco.sdk.Init.SDKInitResponse.AdUnit.InventoryType.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public InventoryType findValueByNumber(int i) {
                        return InventoryType.forNumber(i);
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
                public static InventoryType valueOf(int i) {
                    return forNumber(i);
                }

                public static InventoryType forNumber(int i) {
                    if (i == 0) {
                        return INVALID;
                    }
                    if (i == 1) {
                        return BANNER;
                    }
                    if (i == 2) {
                        return INTERSTITIAL;
                    }
                    if (i == 3) {
                        return NATIVE;
                    }
                    if (i == 4) {
                        return REWARD_VIDEO;
                    }
                    if (i != 6) {
                        return null;
                    }
                    return MREC;
                }

                public static Internal.EnumLiteMap<InventoryType> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return InventoryTypeVerifier.INSTANCE;
                }

                private static final class InventoryTypeVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new InventoryTypeVerifier();

                    private InventoryTypeVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return InventoryType.forNumber(i) != null;
                    }
                }

                InventoryType(int i) {
                    this.value = i;
                }
            }

            public static final class Native extends GeneratedMessageLite<Native, Builder> implements NativeOrBuilder {
                private static final Native DEFAULT_INSTANCE;
                private static volatile Parser<Native> PARSER = null;
                public static final int TYPE_FIELD_NUMBER = 1;
                private int type_;

                private Native() {
                }

                public enum Type implements Internal.EnumLite {
                    UNKNOWN_TYPE(0),
                    LOGO(1),
                    IMAGE(2),
                    VIDEO(3),
                    UNRECOGNIZED(-1);

                    public static final int IMAGE_VALUE = 2;
                    public static final int LOGO_VALUE = 1;
                    public static final int UNKNOWN_TYPE_VALUE = 0;
                    public static final int VIDEO_VALUE = 3;
                    private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.moloco.sdk.Init.SDKInitResponse.AdUnit.Native.Type.1
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
                        if (i == 0) {
                            return UNKNOWN_TYPE;
                        }
                        if (i == 1) {
                            return LOGO;
                        }
                        if (i == 2) {
                            return IMAGE;
                        }
                        if (i != 3) {
                            return null;
                        }
                        return VIDEO;
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

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnit.NativeOrBuilder
                public int getTypeValue() {
                    return this.type_;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnit.NativeOrBuilder
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

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.createBuilder();
                }

                public static Builder newBuilder(Native r1) {
                    return DEFAULT_INSTANCE.createBuilder(r1);
                }

                public static final class Builder extends GeneratedMessageLite.Builder<Native, Builder> implements NativeOrBuilder {
                    /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                        this();
                    }

                    private Builder() {
                        super(Native.DEFAULT_INSTANCE);
                    }

                    @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnit.NativeOrBuilder
                    public int getTypeValue() {
                        return ((Native) this.instance).getTypeValue();
                    }

                    public Builder setTypeValue(int i) {
                        copyOnWrite();
                        ((Native) this.instance).setTypeValue(i);
                        return this;
                    }

                    @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnit.NativeOrBuilder
                    public Type getType() {
                        return ((Native) this.instance).getType();
                    }

                    public Builder setType(Type type) {
                        copyOnWrite();
                        ((Native) this.instance).setType(type);
                        return this;
                    }

                    public Builder clearType() {
                        copyOnWrite();
                        ((Native) this.instance).clearType();
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
                            return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"type_"});
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
                            return (byte) 1;
                        case 7:
                            return null;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }

                static {
                    Native r0 = new Native();
                    DEFAULT_INSTANCE = r0;
                    GeneratedMessageLite.registerDefaultInstance(Native.class, r0);
                }

                public static Native getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<Native> parser() {
                    return DEFAULT_INSTANCE.getParserForType();
                }
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public String getId() {
                return this.id_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
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

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public InventoryType getType() {
                InventoryType inventoryTypeForNumber = InventoryType.forNumber(this.type_);
                return inventoryTypeForNumber == null ? InventoryType.UNRECOGNIZED : inventoryTypeForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setTypeValue(int i) {
                this.type_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setType(InventoryType inventoryType) {
                this.type_ = inventoryType.getNumber();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearType() {
                this.type_ = 0;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public int getAdFrequency() {
                return this.adFrequency_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setAdFrequency(int i) {
                this.adFrequency_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearAdFrequency() {
                this.adFrequency_ = 0;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public float getBidFloor() {
                return this.bidFloor_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidFloor(float f) {
                this.bidFloor_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBidFloor() {
                this.bidFloor_ = 0.0f;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public String getName() {
                return this.name_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public ByteString getNameBytes() {
                return ByteString.copyFromUtf8(this.name_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setName(String str) {
                str.getClass();
                this.name_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearName() {
                this.name_ = getDefaultInstance().getName();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNameBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.name_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public boolean hasNative() {
                return this.native_ != null;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
            public Native getNative() {
                Native r0 = this.native_;
                return r0 == null ? Native.getDefaultInstance() : r0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setNative(Native r1) {
                r1.getClass();
                this.native_ = r1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeNative(Native r3) {
                r3.getClass();
                Native r0 = this.native_;
                if (r0 != null && r0 != Native.getDefaultInstance()) {
                    this.native_ = Native.newBuilder(this.native_).mergeFrom(r3).buildPartial();
                } else {
                    this.native_ = r3;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearNative() {
                this.native_ = null;
            }

            public static AdUnit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static AdUnit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static AdUnit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static AdUnit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static AdUnit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static AdUnit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static AdUnit parseFrom(InputStream inputStream) throws IOException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AdUnit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AdUnit parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AdUnit) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static AdUnit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdUnit) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static AdUnit parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static AdUnit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdUnit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AdUnit adUnit) {
                return DEFAULT_INSTANCE.createBuilder(adUnit);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AdUnit, Builder> implements AdUnitOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(AdUnit.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public String getId() {
                    return ((AdUnit) this.instance).getId();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public ByteString getIdBytes() {
                    return ((AdUnit) this.instance).getIdBytes();
                }

                public Builder setId(String str) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setId(str);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearId();
                    return this;
                }

                public Builder setIdBytes(ByteString byteString) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setIdBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public int getTypeValue() {
                    return ((AdUnit) this.instance).getTypeValue();
                }

                public Builder setTypeValue(int i) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setTypeValue(i);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public InventoryType getType() {
                    return ((AdUnit) this.instance).getType();
                }

                public Builder setType(InventoryType inventoryType) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setType(inventoryType);
                    return this;
                }

                public Builder clearType() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearType();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public int getAdFrequency() {
                    return ((AdUnit) this.instance).getAdFrequency();
                }

                public Builder setAdFrequency(int i) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setAdFrequency(i);
                    return this;
                }

                public Builder clearAdFrequency() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearAdFrequency();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public float getBidFloor() {
                    return ((AdUnit) this.instance).getBidFloor();
                }

                public Builder setBidFloor(float f) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setBidFloor(f);
                    return this;
                }

                public Builder clearBidFloor() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearBidFloor();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public String getName() {
                    return ((AdUnit) this.instance).getName();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public ByteString getNameBytes() {
                    return ((AdUnit) this.instance).getNameBytes();
                }

                public Builder setName(String str) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setName(str);
                    return this;
                }

                public Builder clearName() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearName();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setNameBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public boolean hasNative() {
                    return ((AdUnit) this.instance).hasNative();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.AdUnitOrBuilder
                public Native getNative() {
                    return ((AdUnit) this.instance).getNative();
                }

                public Builder setNative(Native r2) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setNative(r2);
                    return this;
                }

                public Builder setNative(Native.Builder builder) {
                    copyOnWrite();
                    ((AdUnit) this.instance).setNative(builder.build());
                    return this;
                }

                public Builder mergeNative(Native r2) {
                    copyOnWrite();
                    ((AdUnit) this.instance).mergeNative(r2);
                    return this;
                }

                public Builder clearNative() {
                    copyOnWrite();
                    ((AdUnit) this.instance).clearNative();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new AdUnit();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u0004\u0004\u0001\u0005Ȉ\u0006\t", new Object[]{"id_", "type_", "adFrequency_", "bidFloor_", "name_", "native_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AdUnit> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (AdUnit.class) {
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
                AdUnit adUnit = new AdUnit();
                DEFAULT_INSTANCE = adUnit;
                GeneratedMessageLite.registerDefaultInstance(AdUnit.class, adUnit);
            }

            public static AdUnit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AdUnit> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class Geo extends GeneratedMessageLite<Geo, Builder> implements GeoOrBuilder {
            public static final int CITY_FIELD_NUMBER = 6;
            public static final int COUNTRY_ISO2_CODE_FIELD_NUMBER = 2;
            public static final int COUNTRY_ISO3_CODE_FIELD_NUMBER = 1;
            private static final Geo DEFAULT_INSTANCE;
            public static final int LATITUDE_FIELD_NUMBER = 3;
            public static final int LONGITUDE_FIELD_NUMBER = 4;
            private static volatile Parser<Geo> PARSER = null;
            public static final int REGION_FIELD_NUMBER = 7;
            public static final int ZIP_CODE_FIELD_NUMBER = 5;
            private float latitude_;
            private float longitude_;
            private String countryIso3Code_ = "";
            private String countryIso2Code_ = "";
            private String zipCode_ = "";
            private String city_ = "";
            private String region_ = "";

            private Geo() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public String getCountryIso3Code() {
                return this.countryIso3Code_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public ByteString getCountryIso3CodeBytes() {
                return ByteString.copyFromUtf8(this.countryIso3Code_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCountryIso3Code(String str) {
                str.getClass();
                this.countryIso3Code_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCountryIso3Code() {
                this.countryIso3Code_ = getDefaultInstance().getCountryIso3Code();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCountryIso3CodeBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.countryIso3Code_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public String getCountryIso2Code() {
                return this.countryIso2Code_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public ByteString getCountryIso2CodeBytes() {
                return ByteString.copyFromUtf8(this.countryIso2Code_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCountryIso2Code(String str) {
                str.getClass();
                this.countryIso2Code_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCountryIso2Code() {
                this.countryIso2Code_ = getDefaultInstance().getCountryIso2Code();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCountryIso2CodeBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.countryIso2Code_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public float getLatitude() {
                return this.latitude_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLatitude(float f) {
                this.latitude_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLatitude() {
                this.latitude_ = 0.0f;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public float getLongitude() {
                return this.longitude_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setLongitude(float f) {
                this.longitude_ = f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearLongitude() {
                this.longitude_ = 0.0f;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public String getZipCode() {
                return this.zipCode_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public ByteString getZipCodeBytes() {
                return ByteString.copyFromUtf8(this.zipCode_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setZipCode(String str) {
                str.getClass();
                this.zipCode_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearZipCode() {
                this.zipCode_ = getDefaultInstance().getZipCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setZipCodeBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.zipCode_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public String getCity() {
                return this.city_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public ByteString getCityBytes() {
                return ByteString.copyFromUtf8(this.city_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCity(String str) {
                str.getClass();
                this.city_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearCity() {
                this.city_ = getDefaultInstance().getCity();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setCityBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.city_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public String getRegion() {
                return this.region_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
            public ByteString getRegionBytes() {
                return ByteString.copyFromUtf8(this.region_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRegion(String str) {
                str.getClass();
                this.region_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRegion() {
                this.region_ = getDefaultInstance().getRegion();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRegionBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.region_ = byteString.toStringUtf8();
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

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public String getCountryIso3Code() {
                    return ((Geo) this.instance).getCountryIso3Code();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public ByteString getCountryIso3CodeBytes() {
                    return ((Geo) this.instance).getCountryIso3CodeBytes();
                }

                public Builder setCountryIso3Code(String str) {
                    copyOnWrite();
                    ((Geo) this.instance).setCountryIso3Code(str);
                    return this;
                }

                public Builder clearCountryIso3Code() {
                    copyOnWrite();
                    ((Geo) this.instance).clearCountryIso3Code();
                    return this;
                }

                public Builder setCountryIso3CodeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Geo) this.instance).setCountryIso3CodeBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public String getCountryIso2Code() {
                    return ((Geo) this.instance).getCountryIso2Code();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public ByteString getCountryIso2CodeBytes() {
                    return ((Geo) this.instance).getCountryIso2CodeBytes();
                }

                public Builder setCountryIso2Code(String str) {
                    copyOnWrite();
                    ((Geo) this.instance).setCountryIso2Code(str);
                    return this;
                }

                public Builder clearCountryIso2Code() {
                    copyOnWrite();
                    ((Geo) this.instance).clearCountryIso2Code();
                    return this;
                }

                public Builder setCountryIso2CodeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Geo) this.instance).setCountryIso2CodeBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public float getLatitude() {
                    return ((Geo) this.instance).getLatitude();
                }

                public Builder setLatitude(float f) {
                    copyOnWrite();
                    ((Geo) this.instance).setLatitude(f);
                    return this;
                }

                public Builder clearLatitude() {
                    copyOnWrite();
                    ((Geo) this.instance).clearLatitude();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public float getLongitude() {
                    return ((Geo) this.instance).getLongitude();
                }

                public Builder setLongitude(float f) {
                    copyOnWrite();
                    ((Geo) this.instance).setLongitude(f);
                    return this;
                }

                public Builder clearLongitude() {
                    copyOnWrite();
                    ((Geo) this.instance).clearLongitude();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public String getZipCode() {
                    return ((Geo) this.instance).getZipCode();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public ByteString getZipCodeBytes() {
                    return ((Geo) this.instance).getZipCodeBytes();
                }

                public Builder setZipCode(String str) {
                    copyOnWrite();
                    ((Geo) this.instance).setZipCode(str);
                    return this;
                }

                public Builder clearZipCode() {
                    copyOnWrite();
                    ((Geo) this.instance).clearZipCode();
                    return this;
                }

                public Builder setZipCodeBytes(ByteString byteString) {
                    copyOnWrite();
                    ((Geo) this.instance).setZipCodeBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public String getCity() {
                    return ((Geo) this.instance).getCity();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
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

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
                public String getRegion() {
                    return ((Geo) this.instance).getRegion();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.GeoOrBuilder
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
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0001\u0004\u0001\u0005Ȉ\u0006Ȉ\u0007Ȉ", new Object[]{"countryIso3Code_", "countryIso2Code_", "latitude_", "longitude_", "zipCode_", "city_", "region_"});
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

        public static final class BidTokenConfig extends GeneratedMessageLite<BidTokenConfig, Builder> implements BidTokenConfigOrBuilder {
            public static final int BID_TOKEN_URL_FIELD_NUMBER = 2;
            private static final BidTokenConfig DEFAULT_INSTANCE;
            private static volatile Parser<BidTokenConfig> PARSER;
            private String bidTokenUrl_ = "";

            private BidTokenConfig() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.BidTokenConfigOrBuilder
            public String getBidTokenUrl() {
                return this.bidTokenUrl_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.BidTokenConfigOrBuilder
            public ByteString getBidTokenUrlBytes() {
                return ByteString.copyFromUtf8(this.bidTokenUrl_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidTokenUrl(String str) {
                str.getClass();
                this.bidTokenUrl_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearBidTokenUrl() {
                this.bidTokenUrl_ = getDefaultInstance().getBidTokenUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setBidTokenUrlBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.bidTokenUrl_ = byteString.toStringUtf8();
            }

            public static BidTokenConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static BidTokenConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static BidTokenConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static BidTokenConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static BidTokenConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static BidTokenConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static BidTokenConfig parseFrom(InputStream inputStream) throws IOException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BidTokenConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BidTokenConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (BidTokenConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static BidTokenConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BidTokenConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static BidTokenConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BidTokenConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(BidTokenConfig bidTokenConfig) {
                return DEFAULT_INSTANCE.createBuilder(bidTokenConfig);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<BidTokenConfig, Builder> implements BidTokenConfigOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(BidTokenConfig.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.BidTokenConfigOrBuilder
                public String getBidTokenUrl() {
                    return ((BidTokenConfig) this.instance).getBidTokenUrl();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.BidTokenConfigOrBuilder
                public ByteString getBidTokenUrlBytes() {
                    return ((BidTokenConfig) this.instance).getBidTokenUrlBytes();
                }

                public Builder setBidTokenUrl(String str) {
                    copyOnWrite();
                    ((BidTokenConfig) this.instance).setBidTokenUrl(str);
                    return this;
                }

                public Builder clearBidTokenUrl() {
                    copyOnWrite();
                    ((BidTokenConfig) this.instance).clearBidTokenUrl();
                    return this;
                }

                public Builder setBidTokenUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((BidTokenConfig) this.instance).setBidTokenUrlBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new BidTokenConfig();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"bidTokenUrl_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BidTokenConfig> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (BidTokenConfig.class) {
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
                BidTokenConfig bidTokenConfig = new BidTokenConfig();
                DEFAULT_INSTANCE = bidTokenConfig;
                GeneratedMessageLite.registerDefaultInstance(BidTokenConfig.class, bidTokenConfig);
            }

            public static BidTokenConfig getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<BidTokenConfig> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class OperationalMetricsConfig extends GeneratedMessageLite<OperationalMetricsConfig, Builder> implements OperationalMetricsConfigOrBuilder {
            private static final OperationalMetricsConfig DEFAULT_INSTANCE;
            public static final int ENABLED_FIELD_NUMBER = 1;
            private static volatile Parser<OperationalMetricsConfig> PARSER = null;
            public static final int POLLING_INTERVAL_SECONDS_FIELD_NUMBER = 3;
            public static final int URL_FIELD_NUMBER = 2;
            private boolean enabled_;
            private int pollingIntervalSeconds_;
            private String url_ = "";

            private OperationalMetricsConfig() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
            public boolean getEnabled() {
                return this.enabled_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnabled(boolean z) {
                this.enabled_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnabled() {
                this.enabled_ = false;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
            public String getUrl() {
                return this.url_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
            public ByteString getUrlBytes() {
                return ByteString.copyFromUtf8(this.url_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrl(String str) {
                str.getClass();
                this.url_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUrl() {
                this.url_ = getDefaultInstance().getUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrlBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.url_ = byteString.toStringUtf8();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
            public int getPollingIntervalSeconds() {
                return this.pollingIntervalSeconds_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPollingIntervalSeconds(int i) {
                this.pollingIntervalSeconds_ = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPollingIntervalSeconds() {
                this.pollingIntervalSeconds_ = 0;
            }

            public static OperationalMetricsConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static OperationalMetricsConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static OperationalMetricsConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static OperationalMetricsConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static OperationalMetricsConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static OperationalMetricsConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static OperationalMetricsConfig parseFrom(InputStream inputStream) throws IOException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static OperationalMetricsConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static OperationalMetricsConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (OperationalMetricsConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static OperationalMetricsConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (OperationalMetricsConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static OperationalMetricsConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static OperationalMetricsConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (OperationalMetricsConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(OperationalMetricsConfig operationalMetricsConfig) {
                return DEFAULT_INSTANCE.createBuilder(operationalMetricsConfig);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<OperationalMetricsConfig, Builder> implements OperationalMetricsConfigOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(OperationalMetricsConfig.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
                public boolean getEnabled() {
                    return ((OperationalMetricsConfig) this.instance).getEnabled();
                }

                public Builder setEnabled(boolean z) {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).setEnabled(z);
                    return this;
                }

                public Builder clearEnabled() {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).clearEnabled();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
                public String getUrl() {
                    return ((OperationalMetricsConfig) this.instance).getUrl();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
                public ByteString getUrlBytes() {
                    return ((OperationalMetricsConfig) this.instance).getUrlBytes();
                }

                public Builder setUrl(String str) {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).setUrl(str);
                    return this;
                }

                public Builder clearUrl() {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).clearUrl();
                    return this;
                }

                public Builder setUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).setUrlBytes(byteString);
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.OperationalMetricsConfigOrBuilder
                public int getPollingIntervalSeconds() {
                    return ((OperationalMetricsConfig) this.instance).getPollingIntervalSeconds();
                }

                public Builder setPollingIntervalSeconds(int i) {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).setPollingIntervalSeconds(i);
                    return this;
                }

                public Builder clearPollingIntervalSeconds() {
                    copyOnWrite();
                    ((OperationalMetricsConfig) this.instance).clearPollingIntervalSeconds();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new OperationalMetricsConfig();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0004", new Object[]{"enabled_", "url_", "pollingIntervalSeconds_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<OperationalMetricsConfig> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (OperationalMetricsConfig.class) {
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
                OperationalMetricsConfig operationalMetricsConfig = new OperationalMetricsConfig();
                DEFAULT_INSTANCE = operationalMetricsConfig;
                GeneratedMessageLite.registerDefaultInstance(OperationalMetricsConfig.class, operationalMetricsConfig);
            }

            public static OperationalMetricsConfig getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<OperationalMetricsConfig> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class CrashReportingConfig extends GeneratedMessageLite<CrashReportingConfig, Builder> implements CrashReportingConfigOrBuilder {
            private static final CrashReportingConfig DEFAULT_INSTANCE;
            public static final int ENABLED_FIELD_NUMBER = 1;
            private static volatile Parser<CrashReportingConfig> PARSER = null;
            public static final int URL_FIELD_NUMBER = 2;
            private boolean enabled_;
            private String url_ = "";

            private CrashReportingConfig() {
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
            public boolean getEnabled() {
                return this.enabled_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setEnabled(boolean z) {
                this.enabled_ = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearEnabled() {
                this.enabled_ = false;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
            public String getUrl() {
                return this.url_;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
            public ByteString getUrlBytes() {
                return ByteString.copyFromUtf8(this.url_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrl(String str) {
                str.getClass();
                this.url_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearUrl() {
                this.url_ = getDefaultInstance().getUrl();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setUrlBytes(ByteString byteString) {
                checkByteStringIsUtf8(byteString);
                this.url_ = byteString.toStringUtf8();
            }

            public static CrashReportingConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static CrashReportingConfig parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static CrashReportingConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static CrashReportingConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static CrashReportingConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static CrashReportingConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static CrashReportingConfig parseFrom(InputStream inputStream) throws IOException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CrashReportingConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CrashReportingConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (CrashReportingConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static CrashReportingConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CrashReportingConfig) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CrashReportingConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static CrashReportingConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CrashReportingConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(CrashReportingConfig crashReportingConfig) {
                return DEFAULT_INSTANCE.createBuilder(crashReportingConfig);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<CrashReportingConfig, Builder> implements CrashReportingConfigOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(CrashReportingConfig.DEFAULT_INSTANCE);
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
                public boolean getEnabled() {
                    return ((CrashReportingConfig) this.instance).getEnabled();
                }

                public Builder setEnabled(boolean z) {
                    copyOnWrite();
                    ((CrashReportingConfig) this.instance).setEnabled(z);
                    return this;
                }

                public Builder clearEnabled() {
                    copyOnWrite();
                    ((CrashReportingConfig) this.instance).clearEnabled();
                    return this;
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
                public String getUrl() {
                    return ((CrashReportingConfig) this.instance).getUrl();
                }

                @Override // com.moloco.sdk.Init.SDKInitResponse.CrashReportingConfigOrBuilder
                public ByteString getUrlBytes() {
                    return ((CrashReportingConfig) this.instance).getUrlBytes();
                }

                public Builder setUrl(String str) {
                    copyOnWrite();
                    ((CrashReportingConfig) this.instance).setUrl(str);
                    return this;
                }

                public Builder clearUrl() {
                    copyOnWrite();
                    ((CrashReportingConfig) this.instance).clearUrl();
                    return this;
                }

                public Builder setUrlBytes(ByteString byteString) {
                    copyOnWrite();
                    ((CrashReportingConfig) this.instance).setUrlBytes(byteString);
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new CrashReportingConfig();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"enabled_", "url_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<CrashReportingConfig> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (CrashReportingConfig.class) {
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
                CrashReportingConfig crashReportingConfig = new CrashReportingConfig();
                DEFAULT_INSTANCE = crashReportingConfig;
                GeneratedMessageLite.registerDefaultInstance(CrashReportingConfig.class, crashReportingConfig);
            }

            public static CrashReportingConfig getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<CrashReportingConfig> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppId(String str) {
            str.getClass();
            this.appId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.appId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getPublisherId() {
            return this.publisherId_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getPublisherIdBytes() {
            return ByteString.copyFromUtf8(this.publisherId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherId(String str) {
            str.getClass();
            this.publisherId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublisherId() {
            this.publisherId_ = getDefaultInstance().getPublisherId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.publisherId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getCountryIso3Code() {
            return this.countryIso3Code_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getCountryIso3CodeBytes() {
            return ByteString.copyFromUtf8(this.countryIso3Code_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryIso3Code(String str) {
            str.getClass();
            this.countryIso3Code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryIso3Code() {
            this.countryIso3Code_ = getDefaultInstance().getCountryIso3Code();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryIso3CodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.countryIso3Code_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public List<AdUnit> getAdUnitsList() {
            return this.adUnits_;
        }

        public List<? extends AdUnitOrBuilder> getAdUnitsOrBuilderList() {
            return this.adUnits_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public int getAdUnitsCount() {
            return this.adUnits_.size();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public AdUnit getAdUnits(int i) {
            return this.adUnits_.get(i);
        }

        public AdUnitOrBuilder getAdUnitsOrBuilder(int i) {
            return this.adUnits_.get(i);
        }

        private void ensureAdUnitsIsMutable() {
            Internal.ProtobufList<AdUnit> protobufList = this.adUnits_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.adUnits_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdUnits(int i, AdUnit adUnit) {
            adUnit.getClass();
            ensureAdUnitsIsMutable();
            this.adUnits_.set(i, adUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdUnits(AdUnit adUnit) {
            adUnit.getClass();
            ensureAdUnitsIsMutable();
            this.adUnits_.add(adUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAdUnits(int i, AdUnit adUnit) {
            adUnit.getClass();
            ensureAdUnitsIsMutable();
            this.adUnits_.add(i, adUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAdUnits(Iterable<? extends AdUnit> iterable) {
            ensureAdUnitsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.adUnits_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdUnits() {
            this.adUnits_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAdUnits(int i) {
            ensureAdUnitsIsMutable();
            this.adUnits_.remove(i);
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public int getResolvedRegionValue() {
            return this.resolvedRegion_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public Region getResolvedRegion() {
            Region regionForNumber = Region.forNumber(this.resolvedRegion_);
            return regionForNumber == null ? Region.UNRECOGNIZED : regionForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResolvedRegionValue(int i) {
            this.resolvedRegion_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setResolvedRegion(Region region) {
            this.resolvedRegion_ = region.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResolvedRegion() {
            this.resolvedRegion_ = 0;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getAdServerUrl() {
            return this.adServerUrl_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getAdServerUrlBytes() {
            return ByteString.copyFromUtf8(this.adServerUrl_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdServerUrl(String str) {
            str.getClass();
            this.adServerUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdServerUrl() {
            this.adServerUrl_ = getDefaultInstance().getAdServerUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdServerUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.adServerUrl_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getCountryIso2Code() {
            return this.countryIso2Code_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getCountryIso2CodeBytes() {
            return ByteString.copyFromUtf8(this.countryIso2Code_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryIso2Code(String str) {
            str.getClass();
            this.countryIso2Code_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryIso2Code() {
            this.countryIso2Code_ = getDefaultInstance().getCountryIso2Code();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryIso2CodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.countryIso2Code_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public String getPlatformId() {
            return this.platformId_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ByteString getPlatformIdBytes() {
            return ByteString.copyFromUtf8(this.platformId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformId(String str) {
            str.getClass();
            this.platformId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatformId() {
            this.platformId_ = getDefaultInstance().getPlatformId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatformIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.platformId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean getVerifyBannerVisible() {
            return this.verifyBannerVisible_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerifyBannerVisible(boolean z) {
            this.verifyBannerVisible_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerifyBannerVisible() {
            this.verifyBannerVisible_ = false;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasGeo() {
            return this.geo_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public Geo getGeo() {
            Geo geo = this.geo_;
            return geo == null ? Geo.getDefaultInstance() : geo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGeo(Geo geo) {
            geo.getClass();
            this.geo_ = geo;
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
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGeo() {
            this.geo_ = null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasEventCollectionConfig() {
            return this.eventCollectionConfig_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public EventCollectionConfig getEventCollectionConfig() {
            EventCollectionConfig eventCollectionConfig = this.eventCollectionConfig_;
            return eventCollectionConfig == null ? EventCollectionConfig.getDefaultInstance() : eventCollectionConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventCollectionConfig(EventCollectionConfig eventCollectionConfig) {
            eventCollectionConfig.getClass();
            this.eventCollectionConfig_ = eventCollectionConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEventCollectionConfig(EventCollectionConfig eventCollectionConfig) {
            eventCollectionConfig.getClass();
            EventCollectionConfig eventCollectionConfig2 = this.eventCollectionConfig_;
            if (eventCollectionConfig2 != null && eventCollectionConfig2 != EventCollectionConfig.getDefaultInstance()) {
                this.eventCollectionConfig_ = EventCollectionConfig.newBuilder(this.eventCollectionConfig_).mergeFrom(eventCollectionConfig).buildPartial();
            } else {
                this.eventCollectionConfig_ = eventCollectionConfig;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventCollectionConfig() {
            this.eventCollectionConfig_ = null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasBidTokenConfig() {
            return this.bidTokenConfig_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public BidTokenConfig getBidTokenConfig() {
            BidTokenConfig bidTokenConfig = this.bidTokenConfig_;
            return bidTokenConfig == null ? BidTokenConfig.getDefaultInstance() : bidTokenConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBidTokenConfig(BidTokenConfig bidTokenConfig) {
            bidTokenConfig.getClass();
            this.bidTokenConfig_ = bidTokenConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBidTokenConfig(BidTokenConfig bidTokenConfig) {
            bidTokenConfig.getClass();
            BidTokenConfig bidTokenConfig2 = this.bidTokenConfig_;
            if (bidTokenConfig2 != null && bidTokenConfig2 != BidTokenConfig.getDefaultInstance()) {
                this.bidTokenConfig_ = BidTokenConfig.newBuilder(this.bidTokenConfig_).mergeFrom(bidTokenConfig).buildPartial();
            } else {
                this.bidTokenConfig_ = bidTokenConfig;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBidTokenConfig() {
            this.bidTokenConfig_ = null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public List<ExperimentalFeatureFlag> getExperimentalFeatureFlagsList() {
            return this.experimentalFeatureFlags_;
        }

        public List<? extends ExperimentalFeatureFlagOrBuilder> getExperimentalFeatureFlagsOrBuilderList() {
            return this.experimentalFeatureFlags_;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public int getExperimentalFeatureFlagsCount() {
            return this.experimentalFeatureFlags_.size();
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ExperimentalFeatureFlag getExperimentalFeatureFlags(int i) {
            return this.experimentalFeatureFlags_.get(i);
        }

        public ExperimentalFeatureFlagOrBuilder getExperimentalFeatureFlagsOrBuilder(int i) {
            return this.experimentalFeatureFlags_.get(i);
        }

        private void ensureExperimentalFeatureFlagsIsMutable() {
            Internal.ProtobufList<ExperimentalFeatureFlag> protobufList = this.experimentalFeatureFlags_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.experimentalFeatureFlags_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExperimentalFeatureFlags(int i, ExperimentalFeatureFlag experimentalFeatureFlag) {
            experimentalFeatureFlag.getClass();
            ensureExperimentalFeatureFlagsIsMutable();
            this.experimentalFeatureFlags_.set(i, experimentalFeatureFlag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExperimentalFeatureFlags(ExperimentalFeatureFlag experimentalFeatureFlag) {
            experimentalFeatureFlag.getClass();
            ensureExperimentalFeatureFlagsIsMutable();
            this.experimentalFeatureFlags_.add(experimentalFeatureFlag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExperimentalFeatureFlags(int i, ExperimentalFeatureFlag experimentalFeatureFlag) {
            experimentalFeatureFlag.getClass();
            ensureExperimentalFeatureFlagsIsMutable();
            this.experimentalFeatureFlags_.add(i, experimentalFeatureFlag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExperimentalFeatureFlags(Iterable<? extends ExperimentalFeatureFlag> iterable) {
            ensureExperimentalFeatureFlagsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.experimentalFeatureFlags_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExperimentalFeatureFlags() {
            this.experimentalFeatureFlags_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeExperimentalFeatureFlags(int i) {
            ensureExperimentalFeatureFlagsIsMutable();
            this.experimentalFeatureFlags_.remove(i);
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasOperationalMetricsConfig() {
            return this.operationalMetricsConfig_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public OperationalMetricsConfig getOperationalMetricsConfig() {
            OperationalMetricsConfig operationalMetricsConfig = this.operationalMetricsConfig_;
            return operationalMetricsConfig == null ? OperationalMetricsConfig.getDefaultInstance() : operationalMetricsConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperationalMetricsConfig(OperationalMetricsConfig operationalMetricsConfig) {
            operationalMetricsConfig.getClass();
            this.operationalMetricsConfig_ = operationalMetricsConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeOperationalMetricsConfig(OperationalMetricsConfig operationalMetricsConfig) {
            operationalMetricsConfig.getClass();
            OperationalMetricsConfig operationalMetricsConfig2 = this.operationalMetricsConfig_;
            if (operationalMetricsConfig2 != null && operationalMetricsConfig2 != OperationalMetricsConfig.getDefaultInstance()) {
                this.operationalMetricsConfig_ = OperationalMetricsConfig.newBuilder(this.operationalMetricsConfig_).mergeFrom(operationalMetricsConfig).buildPartial();
            } else {
                this.operationalMetricsConfig_ = operationalMetricsConfig;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOperationalMetricsConfig() {
            this.operationalMetricsConfig_ = null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasCrashReportingConfig() {
            return this.crashReportingConfig_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public CrashReportingConfig getCrashReportingConfig() {
            CrashReportingConfig crashReportingConfig = this.crashReportingConfig_;
            return crashReportingConfig == null ? CrashReportingConfig.getDefaultInstance() : crashReportingConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCrashReportingConfig(CrashReportingConfig crashReportingConfig) {
            crashReportingConfig.getClass();
            this.crashReportingConfig_ = crashReportingConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCrashReportingConfig(CrashReportingConfig crashReportingConfig) {
            crashReportingConfig.getClass();
            CrashReportingConfig crashReportingConfig2 = this.crashReportingConfig_;
            if (crashReportingConfig2 != null && crashReportingConfig2 != CrashReportingConfig.getDefaultInstance()) {
                this.crashReportingConfig_ = CrashReportingConfig.newBuilder(this.crashReportingConfig_).mergeFrom(crashReportingConfig).buildPartial();
            } else {
                this.crashReportingConfig_ = crashReportingConfig;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCrashReportingConfig() {
            this.crashReportingConfig_ = null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public boolean hasConfigs() {
            return this.configs_ != null;
        }

        @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
        public ConfigsOuterClass.Configs getConfigs() {
            ConfigsOuterClass.Configs configs = this.configs_;
            return configs == null ? ConfigsOuterClass.Configs.getDefaultInstance() : configs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfigs(ConfigsOuterClass.Configs configs) {
            configs.getClass();
            this.configs_ = configs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConfigs(ConfigsOuterClass.Configs configs) {
            configs.getClass();
            ConfigsOuterClass.Configs configs2 = this.configs_;
            if (configs2 != null && configs2 != ConfigsOuterClass.Configs.getDefaultInstance()) {
                this.configs_ = ConfigsOuterClass.Configs.newBuilder(this.configs_).mergeFrom(configs).buildPartial();
            } else {
                this.configs_ = configs;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfigs() {
            this.configs_ = null;
        }

        public static SDKInitResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SDKInitResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SDKInitResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SDKInitResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SDKInitResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SDKInitResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SDKInitResponse parseFrom(InputStream inputStream) throws IOException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SDKInitResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SDKInitResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SDKInitResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SDKInitResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SDKInitResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SDKInitResponse sDKInitResponse) {
            return DEFAULT_INSTANCE.createBuilder(sDKInitResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SDKInitResponse, Builder> implements SDKInitResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SDKInitResponse.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getAppId() {
                return ((SDKInitResponse) this.instance).getAppId();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getAppIdBytes() {
                return ((SDKInitResponse) this.instance).getAppIdBytes();
            }

            public Builder setAppId(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAppId(str);
                return this;
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearAppId();
                return this;
            }

            public Builder setAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAppIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getPublisherId() {
                return ((SDKInitResponse) this.instance).getPublisherId();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getPublisherIdBytes() {
                return ((SDKInitResponse) this.instance).getPublisherIdBytes();
            }

            public Builder setPublisherId(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setPublisherId(str);
                return this;
            }

            public Builder clearPublisherId() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearPublisherId();
                return this;
            }

            public Builder setPublisherIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setPublisherIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getCountryIso3Code() {
                return ((SDKInitResponse) this.instance).getCountryIso3Code();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getCountryIso3CodeBytes() {
                return ((SDKInitResponse) this.instance).getCountryIso3CodeBytes();
            }

            public Builder setCountryIso3Code(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCountryIso3Code(str);
                return this;
            }

            public Builder clearCountryIso3Code() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearCountryIso3Code();
                return this;
            }

            public Builder setCountryIso3CodeBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCountryIso3CodeBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public List<AdUnit> getAdUnitsList() {
                return Collections.unmodifiableList(((SDKInitResponse) this.instance).getAdUnitsList());
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public int getAdUnitsCount() {
                return ((SDKInitResponse) this.instance).getAdUnitsCount();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public AdUnit getAdUnits(int i) {
                return ((SDKInitResponse) this.instance).getAdUnits(i);
            }

            public Builder setAdUnits(int i, AdUnit adUnit) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAdUnits(i, adUnit);
                return this;
            }

            public Builder setAdUnits(int i, AdUnit.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAdUnits(i, builder.build());
                return this;
            }

            public Builder addAdUnits(AdUnit adUnit) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAdUnits(adUnit);
                return this;
            }

            public Builder addAdUnits(int i, AdUnit adUnit) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAdUnits(i, adUnit);
                return this;
            }

            public Builder addAdUnits(AdUnit.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAdUnits(builder.build());
                return this;
            }

            public Builder addAdUnits(int i, AdUnit.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAdUnits(i, builder.build());
                return this;
            }

            public Builder addAllAdUnits(Iterable<? extends AdUnit> iterable) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAllAdUnits(iterable);
                return this;
            }

            public Builder clearAdUnits() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearAdUnits();
                return this;
            }

            public Builder removeAdUnits(int i) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).removeAdUnits(i);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public int getResolvedRegionValue() {
                return ((SDKInitResponse) this.instance).getResolvedRegionValue();
            }

            public Builder setResolvedRegionValue(int i) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setResolvedRegionValue(i);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public Region getResolvedRegion() {
                return ((SDKInitResponse) this.instance).getResolvedRegion();
            }

            public Builder setResolvedRegion(Region region) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setResolvedRegion(region);
                return this;
            }

            public Builder clearResolvedRegion() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearResolvedRegion();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getAdServerUrl() {
                return ((SDKInitResponse) this.instance).getAdServerUrl();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getAdServerUrlBytes() {
                return ((SDKInitResponse) this.instance).getAdServerUrlBytes();
            }

            public Builder setAdServerUrl(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAdServerUrl(str);
                return this;
            }

            public Builder clearAdServerUrl() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearAdServerUrl();
                return this;
            }

            public Builder setAdServerUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setAdServerUrlBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getCountryIso2Code() {
                return ((SDKInitResponse) this.instance).getCountryIso2Code();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getCountryIso2CodeBytes() {
                return ((SDKInitResponse) this.instance).getCountryIso2CodeBytes();
            }

            public Builder setCountryIso2Code(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCountryIso2Code(str);
                return this;
            }

            public Builder clearCountryIso2Code() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearCountryIso2Code();
                return this;
            }

            public Builder setCountryIso2CodeBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCountryIso2CodeBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public String getPlatformId() {
                return ((SDKInitResponse) this.instance).getPlatformId();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ByteString getPlatformIdBytes() {
                return ((SDKInitResponse) this.instance).getPlatformIdBytes();
            }

            public Builder setPlatformId(String str) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setPlatformId(str);
                return this;
            }

            public Builder clearPlatformId() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearPlatformId();
                return this;
            }

            public Builder setPlatformIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setPlatformIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean getVerifyBannerVisible() {
                return ((SDKInitResponse) this.instance).getVerifyBannerVisible();
            }

            public Builder setVerifyBannerVisible(boolean z) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setVerifyBannerVisible(z);
                return this;
            }

            public Builder clearVerifyBannerVisible() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearVerifyBannerVisible();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasGeo() {
                return ((SDKInitResponse) this.instance).hasGeo();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public Geo getGeo() {
                return ((SDKInitResponse) this.instance).getGeo();
            }

            public Builder setGeo(Geo geo) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setGeo(geo);
                return this;
            }

            public Builder setGeo(Geo.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setGeo(builder.build());
                return this;
            }

            public Builder mergeGeo(Geo geo) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeGeo(geo);
                return this;
            }

            public Builder clearGeo() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearGeo();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasEventCollectionConfig() {
                return ((SDKInitResponse) this.instance).hasEventCollectionConfig();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public EventCollectionConfig getEventCollectionConfig() {
                return ((SDKInitResponse) this.instance).getEventCollectionConfig();
            }

            public Builder setEventCollectionConfig(EventCollectionConfig eventCollectionConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setEventCollectionConfig(eventCollectionConfig);
                return this;
            }

            public Builder setEventCollectionConfig(EventCollectionConfig.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setEventCollectionConfig(builder.build());
                return this;
            }

            public Builder mergeEventCollectionConfig(EventCollectionConfig eventCollectionConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeEventCollectionConfig(eventCollectionConfig);
                return this;
            }

            public Builder clearEventCollectionConfig() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearEventCollectionConfig();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasBidTokenConfig() {
                return ((SDKInitResponse) this.instance).hasBidTokenConfig();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public BidTokenConfig getBidTokenConfig() {
                return ((SDKInitResponse) this.instance).getBidTokenConfig();
            }

            public Builder setBidTokenConfig(BidTokenConfig bidTokenConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setBidTokenConfig(bidTokenConfig);
                return this;
            }

            public Builder setBidTokenConfig(BidTokenConfig.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setBidTokenConfig(builder.build());
                return this;
            }

            public Builder mergeBidTokenConfig(BidTokenConfig bidTokenConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeBidTokenConfig(bidTokenConfig);
                return this;
            }

            public Builder clearBidTokenConfig() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearBidTokenConfig();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public List<ExperimentalFeatureFlag> getExperimentalFeatureFlagsList() {
                return Collections.unmodifiableList(((SDKInitResponse) this.instance).getExperimentalFeatureFlagsList());
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public int getExperimentalFeatureFlagsCount() {
                return ((SDKInitResponse) this.instance).getExperimentalFeatureFlagsCount();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ExperimentalFeatureFlag getExperimentalFeatureFlags(int i) {
                return ((SDKInitResponse) this.instance).getExperimentalFeatureFlags(i);
            }

            public Builder setExperimentalFeatureFlags(int i, ExperimentalFeatureFlag experimentalFeatureFlag) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setExperimentalFeatureFlags(i, experimentalFeatureFlag);
                return this;
            }

            public Builder setExperimentalFeatureFlags(int i, ExperimentalFeatureFlag.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setExperimentalFeatureFlags(i, builder.build());
                return this;
            }

            public Builder addExperimentalFeatureFlags(ExperimentalFeatureFlag experimentalFeatureFlag) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addExperimentalFeatureFlags(experimentalFeatureFlag);
                return this;
            }

            public Builder addExperimentalFeatureFlags(int i, ExperimentalFeatureFlag experimentalFeatureFlag) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addExperimentalFeatureFlags(i, experimentalFeatureFlag);
                return this;
            }

            public Builder addExperimentalFeatureFlags(ExperimentalFeatureFlag.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addExperimentalFeatureFlags(builder.build());
                return this;
            }

            public Builder addExperimentalFeatureFlags(int i, ExperimentalFeatureFlag.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addExperimentalFeatureFlags(i, builder.build());
                return this;
            }

            public Builder addAllExperimentalFeatureFlags(Iterable<? extends ExperimentalFeatureFlag> iterable) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).addAllExperimentalFeatureFlags(iterable);
                return this;
            }

            public Builder clearExperimentalFeatureFlags() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearExperimentalFeatureFlags();
                return this;
            }

            public Builder removeExperimentalFeatureFlags(int i) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).removeExperimentalFeatureFlags(i);
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasOperationalMetricsConfig() {
                return ((SDKInitResponse) this.instance).hasOperationalMetricsConfig();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public OperationalMetricsConfig getOperationalMetricsConfig() {
                return ((SDKInitResponse) this.instance).getOperationalMetricsConfig();
            }

            public Builder setOperationalMetricsConfig(OperationalMetricsConfig operationalMetricsConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setOperationalMetricsConfig(operationalMetricsConfig);
                return this;
            }

            public Builder setOperationalMetricsConfig(OperationalMetricsConfig.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setOperationalMetricsConfig(builder.build());
                return this;
            }

            public Builder mergeOperationalMetricsConfig(OperationalMetricsConfig operationalMetricsConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeOperationalMetricsConfig(operationalMetricsConfig);
                return this;
            }

            public Builder clearOperationalMetricsConfig() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearOperationalMetricsConfig();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasCrashReportingConfig() {
                return ((SDKInitResponse) this.instance).hasCrashReportingConfig();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public CrashReportingConfig getCrashReportingConfig() {
                return ((SDKInitResponse) this.instance).getCrashReportingConfig();
            }

            public Builder setCrashReportingConfig(CrashReportingConfig crashReportingConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCrashReportingConfig(crashReportingConfig);
                return this;
            }

            public Builder setCrashReportingConfig(CrashReportingConfig.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setCrashReportingConfig(builder.build());
                return this;
            }

            public Builder mergeCrashReportingConfig(CrashReportingConfig crashReportingConfig) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeCrashReportingConfig(crashReportingConfig);
                return this;
            }

            public Builder clearCrashReportingConfig() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearCrashReportingConfig();
                return this;
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public boolean hasConfigs() {
                return ((SDKInitResponse) this.instance).hasConfigs();
            }

            @Override // com.moloco.sdk.Init.SDKInitResponseOrBuilder
            public ConfigsOuterClass.Configs getConfigs() {
                return ((SDKInitResponse) this.instance).getConfigs();
            }

            public Builder setConfigs(ConfigsOuterClass.Configs configs) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setConfigs(configs);
                return this;
            }

            public Builder setConfigs(ConfigsOuterClass.Configs.Builder builder) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).setConfigs(builder.build());
                return this;
            }

            public Builder mergeConfigs(ConfigsOuterClass.Configs configs) {
                copyOnWrite();
                ((SDKInitResponse) this.instance).mergeConfigs(configs);
                return this;
            }

            public Builder clearConfigs() {
                copyOnWrite();
                ((SDKInitResponse) this.instance).clearConfigs();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SDKInitResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0010\u0000\u0000\u0001\u0010\u0010\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005\f\u0006Ȉ\u0007Ȉ\bȈ\t\u0007\n\t\u000b\t\f\t\r\u001b\u000e\t\u000f\t\u0010\t", new Object[]{"appId_", "publisherId_", "countryIso3Code_", "adUnits_", AdUnit.class, "resolvedRegion_", "adServerUrl_", "countryIso2Code_", "platformId_", "verifyBannerVisible_", "geo_", "eventCollectionConfig_", "bidTokenConfig_", "experimentalFeatureFlags_", ExperimentalFeatureFlag.class, "operationalMetricsConfig_", "crashReportingConfig_", "configs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SDKInitResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SDKInitResponse.class) {
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
            SDKInitResponse sDKInitResponse = new SDKInitResponse();
            DEFAULT_INSTANCE = sDKInitResponse;
            GeneratedMessageLite.registerDefaultInstance(SDKInitResponse.class, sDKInitResponse);
        }

        public static SDKInitResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SDKInitResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.Init$1, reason: invalid class name */
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
