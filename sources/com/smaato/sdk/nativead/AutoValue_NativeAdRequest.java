package com.smaato.sdk.nativead;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_NativeAdRequest extends NativeAdRequest {
    private final String adSpaceId;
    private final String mediationAdapterVersion;
    private final String mediationNetworkName;
    private final String mediationNetworkSdkVersion;
    private final boolean shouldFetchPrivacy;
    private final boolean shouldReturnUrlsForImageAssets;
    private final String uniqueUBId;

    private AutoValue_NativeAdRequest(String str, boolean z, boolean z2, String str2, String str3, String str4, String str5) {
        this.adSpaceId = str;
        this.shouldFetchPrivacy = z;
        this.shouldReturnUrlsForImageAssets = z2;
        this.mediationAdapterVersion = str2;
        this.mediationNetworkName = str3;
        this.mediationNetworkSdkVersion = str4;
        this.uniqueUBId = str5;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public String adSpaceId() {
        return this.adSpaceId;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public boolean shouldFetchPrivacy() {
        return this.shouldFetchPrivacy;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public boolean shouldReturnUrlsForImageAssets() {
        return this.shouldReturnUrlsForImageAssets;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public String mediationAdapterVersion() {
        return this.mediationAdapterVersion;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public String mediationNetworkName() {
        return this.mediationNetworkName;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public String mediationNetworkSdkVersion() {
        return this.mediationNetworkSdkVersion;
    }

    @Override // com.smaato.sdk.nativead.NativeAdRequest
    public String uniqueUBId() {
        return this.uniqueUBId;
    }

    public String toString() {
        return "NativeAdRequest{adSpaceId=" + this.adSpaceId + ", shouldFetchPrivacy=" + this.shouldFetchPrivacy + ", shouldReturnUrlsForImageAssets=" + this.shouldReturnUrlsForImageAssets + ", mediationAdapterVersion=" + this.mediationAdapterVersion + ", mediationNetworkName=" + this.mediationNetworkName + ", mediationNetworkSdkVersion=" + this.mediationNetworkSdkVersion + ", uniqueUBId=" + this.uniqueUBId + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdRequest)) {
            return false;
        }
        NativeAdRequest nativeAdRequest = (NativeAdRequest) obj;
        if (this.adSpaceId.equals(nativeAdRequest.adSpaceId()) && this.shouldFetchPrivacy == nativeAdRequest.shouldFetchPrivacy() && this.shouldReturnUrlsForImageAssets == nativeAdRequest.shouldReturnUrlsForImageAssets() && ((str = this.mediationAdapterVersion) != null ? str.equals(nativeAdRequest.mediationAdapterVersion()) : nativeAdRequest.mediationAdapterVersion() == null) && ((str2 = this.mediationNetworkName) != null ? str2.equals(nativeAdRequest.mediationNetworkName()) : nativeAdRequest.mediationNetworkName() == null) && ((str3 = this.mediationNetworkSdkVersion) != null ? str3.equals(nativeAdRequest.mediationNetworkSdkVersion()) : nativeAdRequest.mediationNetworkSdkVersion() == null)) {
            String str4 = this.uniqueUBId;
            if (str4 == null) {
                if (nativeAdRequest.uniqueUBId() == null) {
                    return true;
                }
            } else if (str4.equals(nativeAdRequest.uniqueUBId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.adSpaceId.hashCode() ^ 1000003) * 1000003) ^ (this.shouldFetchPrivacy ? 1231 : 1237)) * 1000003) ^ (this.shouldReturnUrlsForImageAssets ? 1231 : 1237)) * 1000003;
        String str = this.mediationAdapterVersion;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.mediationNetworkName;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.mediationNetworkSdkVersion;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.uniqueUBId;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    static final class Builder extends NativeAdRequest.Builder {
        private String adSpaceId;
        private String mediationAdapterVersion;
        private String mediationNetworkName;
        private String mediationNetworkSdkVersion;
        private Boolean shouldFetchPrivacy;
        private Boolean shouldReturnUrlsForImageAssets;
        private String uniqueUBId;

        Builder() {
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder adSpaceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null adSpaceId");
            }
            this.adSpaceId = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder shouldFetchPrivacy(boolean z) {
            this.shouldFetchPrivacy = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder shouldReturnUrlsForImageAssets(boolean z) {
            this.shouldReturnUrlsForImageAssets = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder mediationAdapterVersion(String str) {
            this.mediationAdapterVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder mediationNetworkName(String str) {
            this.mediationNetworkName = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder mediationNetworkSdkVersion(String str) {
            this.mediationNetworkSdkVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest.Builder uniqueUBId(String str) {
            this.uniqueUBId = str;
            return this;
        }

        @Override // com.smaato.sdk.nativead.NativeAdRequest.Builder
        public NativeAdRequest build() {
            String str;
            if (this.adSpaceId != null) {
                str = "";
            } else {
                str = " adSpaceId";
            }
            if (this.shouldFetchPrivacy == null) {
                str = str + " shouldFetchPrivacy";
            }
            if (this.shouldReturnUrlsForImageAssets == null) {
                str = str + " shouldReturnUrlsForImageAssets";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_NativeAdRequest(this.adSpaceId, this.shouldFetchPrivacy.booleanValue(), this.shouldReturnUrlsForImageAssets.booleanValue(), this.mediationAdapterVersion, this.mediationNetworkName, this.mediationNetworkSdkVersion, this.uniqueUBId);
        }
    }
}
