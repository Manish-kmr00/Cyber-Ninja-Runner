package net.pubnative.lite.sdk.contentinfo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes12.dex */
public class AdFeedbackData implements Serializable {
    private final String adFormat;
    private final String appToken;
    private final String appVersion;
    private final String audioState;
    private final String creative;
    private final String creativeId;
    private final String deviceInfo;
    private final String hasEndCard;
    private final String impressionBeacon;
    private final String integrationType;
    private final String sdkVersion;
    private final String zoneId;

    private AdFeedbackData(Builder builder) {
        this.appToken = builder.appToken;
        this.zoneId = builder.zoneId;
        this.audioState = builder.audioState;
        this.appVersion = builder.appVersion;
        this.deviceInfo = builder.deviceInfo;
        this.creativeId = builder.creativeId;
        this.impressionBeacon = builder.impressionBeacon;
        this.sdkVersion = builder.sdkVersion;
        this.integrationType = builder.integrationType;
        this.adFormat = builder.adFormat;
        this.hasEndCard = builder.hasEndCard;
        this.creative = builder.creative;
    }

    public String getAppToken() {
        return this.appToken;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public String getAudioState() {
        return this.audioState;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDeviceInfo() {
        return this.deviceInfo;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    public String getImpressionBeacon() {
        return this.impressionBeacon;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getIntegrationType() {
        return this.integrationType;
    }

    public String getAdFormat() {
        return this.adFormat;
    }

    public String getHasEndCard() {
        return this.hasEndCard;
    }

    public String getCreative() {
        return this.creative;
    }

    public static class Builder {
        private String adFormat;
        private String appToken;
        private String appVersion;
        private String audioState;
        private String creative;
        private String creativeId;
        private String deviceInfo;
        private String hasEndCard;
        private String impressionBeacon;
        private String integrationType;
        private String sdkVersion;
        private String zoneId;

        public Builder setAppToken(String str) {
            this.appToken = str;
            return this;
        }

        public Builder setZoneId(String str) {
            this.zoneId = str;
            return this;
        }

        public Builder setAudioState(String str) {
            this.audioState = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setDeviceInfo(String str) {
            this.deviceInfo = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.creativeId = str;
            return this;
        }

        public Builder setImpressionBeacon(String str) {
            this.impressionBeacon = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.sdkVersion = str;
            return this;
        }

        public Builder setIntegrationType(String str) {
            this.integrationType = str;
            return this;
        }

        public Builder setAdFormat(String str) {
            this.adFormat = str;
            return this;
        }

        public Builder setHasEndCard(String str) {
            this.hasEndCard = str;
            return this;
        }

        public Builder setCreative(String str) {
            this.creative = str;
            return this;
        }

        public AdFeedbackData build() {
            return new AdFeedbackData(this);
        }
    }
}
