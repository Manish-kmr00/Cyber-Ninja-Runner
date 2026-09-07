package com.smaato.sdk.core.mvvm.model;

import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.KeyValuePairs;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
final class AutoValue_AdRequest extends AdRequest {
    private final String UBUniqueId;
    private final AdFormat adFormat;
    private final String adSpaceId;
    private final KeyValuePairs keyValuePairs;
    private final String mediationAdapterVersion;
    private final String mediationNetworkName;
    private final String mediationNetworkSdkVersion;
    private final Map<String, Object> objectExtras;
    private final Runnable onCsmAdClicked;
    private final Runnable onCsmAdExpired;

    private AutoValue_AdRequest(AdFormat adFormat, String str, String str2, KeyValuePairs keyValuePairs, Map<String, Object> map, String str3, String str4, String str5, Runnable runnable, Runnable runnable2) {
        this.adFormat = adFormat;
        this.adSpaceId = str;
        this.UBUniqueId = str2;
        this.keyValuePairs = keyValuePairs;
        this.objectExtras = map;
        this.mediationNetworkName = str3;
        this.mediationNetworkSdkVersion = str4;
        this.mediationAdapterVersion = str5;
        this.onCsmAdExpired = runnable;
        this.onCsmAdClicked = runnable2;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public AdFormat getAdFormat() {
        return this.adFormat;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public String getAdSpaceId() {
        return this.adSpaceId;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public String getUBUniqueId() {
        return this.UBUniqueId;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public KeyValuePairs getKeyValuePairs() {
        return this.keyValuePairs;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public Map<String, Object> getObjectExtras() {
        return this.objectExtras;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public String getMediationNetworkName() {
        return this.mediationNetworkName;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public String getMediationNetworkSdkVersion() {
        return this.mediationNetworkSdkVersion;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public String getMediationAdapterVersion() {
        return this.mediationAdapterVersion;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public Runnable getOnCsmAdExpired() {
        return this.onCsmAdExpired;
    }

    @Override // com.smaato.sdk.core.mvvm.model.AdRequest
    public Runnable getOnCsmAdClicked() {
        return this.onCsmAdClicked;
    }

    public String toString() {
        return "AdRequest{adFormat=" + this.adFormat + ", adSpaceId=" + this.adSpaceId + ", UBUniqueId=" + this.UBUniqueId + ", keyValuePairs=" + this.keyValuePairs + ", objectExtras=" + this.objectExtras + ", mediationNetworkName=" + this.mediationNetworkName + ", mediationNetworkSdkVersion=" + this.mediationNetworkSdkVersion + ", mediationAdapterVersion=" + this.mediationAdapterVersion + ", onCsmAdExpired=" + this.onCsmAdExpired + ", onCsmAdClicked=" + this.onCsmAdClicked + "}";
    }

    public boolean equals(Object obj) {
        String str;
        KeyValuePairs keyValuePairs;
        Map<String, Object> map;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdRequest)) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        return this.adFormat.equals(adRequest.getAdFormat()) && this.adSpaceId.equals(adRequest.getAdSpaceId()) && ((str = this.UBUniqueId) != null ? str.equals(adRequest.getUBUniqueId()) : adRequest.getUBUniqueId() == null) && ((keyValuePairs = this.keyValuePairs) != null ? keyValuePairs.equals(adRequest.getKeyValuePairs()) : adRequest.getKeyValuePairs() == null) && ((map = this.objectExtras) != null ? map.equals(adRequest.getObjectExtras()) : adRequest.getObjectExtras() == null) && ((str2 = this.mediationNetworkName) != null ? str2.equals(adRequest.getMediationNetworkName()) : adRequest.getMediationNetworkName() == null) && ((str3 = this.mediationNetworkSdkVersion) != null ? str3.equals(adRequest.getMediationNetworkSdkVersion()) : adRequest.getMediationNetworkSdkVersion() == null) && ((str4 = this.mediationAdapterVersion) != null ? str4.equals(adRequest.getMediationAdapterVersion()) : adRequest.getMediationAdapterVersion() == null) && this.onCsmAdExpired.equals(adRequest.getOnCsmAdExpired()) && this.onCsmAdClicked.equals(adRequest.getOnCsmAdClicked());
    }

    public int hashCode() {
        int iHashCode = (((this.adFormat.hashCode() ^ 1000003) * 1000003) ^ this.adSpaceId.hashCode()) * 1000003;
        String str = this.UBUniqueId;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        KeyValuePairs keyValuePairs = this.keyValuePairs;
        int iHashCode3 = (iHashCode2 ^ (keyValuePairs == null ? 0 : keyValuePairs.hashCode())) * 1000003;
        Map<String, Object> map = this.objectExtras;
        int iHashCode4 = (iHashCode3 ^ (map == null ? 0 : map.hashCode())) * 1000003;
        String str2 = this.mediationNetworkName;
        int iHashCode5 = (iHashCode4 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.mediationNetworkSdkVersion;
        int iHashCode6 = (iHashCode5 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.mediationAdapterVersion;
        return ((((iHashCode6 ^ (str4 != null ? str4.hashCode() : 0)) * 1000003) ^ this.onCsmAdExpired.hashCode()) * 1000003) ^ this.onCsmAdClicked.hashCode();
    }

    static final class Builder extends AdRequest.Builder {
        private String UBUniqueId;
        private AdFormat adFormat;
        private String adSpaceId;
        private KeyValuePairs keyValuePairs;
        private String mediationAdapterVersion;
        private String mediationNetworkName;
        private String mediationNetworkSdkVersion;
        private Map<String, Object> objectExtras;
        private Runnable onCsmAdClicked;
        private Runnable onCsmAdExpired;

        Builder() {
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setAdFormat(AdFormat adFormat) {
            if (adFormat == null) {
                throw new NullPointerException("Null adFormat");
            }
            this.adFormat = adFormat;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setAdSpaceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null adSpaceId");
            }
            this.adSpaceId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setUBUniqueId(String str) {
            this.UBUniqueId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setKeyValuePairs(KeyValuePairs keyValuePairs) {
            this.keyValuePairs = keyValuePairs;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setObjectExtras(Map<String, Object> map) {
            this.objectExtras = map;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setMediationNetworkName(String str) {
            this.mediationNetworkName = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setMediationNetworkSdkVersion(String str) {
            this.mediationNetworkSdkVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setMediationAdapterVersion(String str) {
            this.mediationAdapterVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setOnCsmAdExpired(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Null onCsmAdExpired");
            }
            this.onCsmAdExpired = runnable;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest.Builder setOnCsmAdClicked(Runnable runnable) {
            if (runnable == null) {
                throw new NullPointerException("Null onCsmAdClicked");
            }
            this.onCsmAdClicked = runnable;
            return this;
        }

        @Override // com.smaato.sdk.core.mvvm.model.AdRequest.Builder
        public AdRequest build() {
            String str;
            if (this.adFormat != null) {
                str = "";
            } else {
                str = " adFormat";
            }
            if (this.adSpaceId == null) {
                str = str + " adSpaceId";
            }
            if (this.onCsmAdExpired == null) {
                str = str + " onCsmAdExpired";
            }
            if (this.onCsmAdClicked == null) {
                str = str + " onCsmAdClicked";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_AdRequest(this.adFormat, this.adSpaceId, this.UBUniqueId, this.keyValuePairs, this.objectExtras, this.mediationNetworkName, this.mediationNetworkSdkVersion, this.mediationAdapterVersion, this.onCsmAdExpired, this.onCsmAdClicked);
        }
    }
}
