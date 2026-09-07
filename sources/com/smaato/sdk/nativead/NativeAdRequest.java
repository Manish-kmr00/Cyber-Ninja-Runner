package com.smaato.sdk.nativead;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NativeAdRequest {

    public static abstract class Builder {
        public abstract Builder adSpaceId(String str);

        public abstract NativeAdRequest build();

        public abstract Builder mediationAdapterVersion(String str);

        public abstract Builder mediationNetworkName(String str);

        public abstract Builder mediationNetworkSdkVersion(String str);

        public abstract Builder shouldFetchPrivacy(boolean z);

        public abstract Builder shouldReturnUrlsForImageAssets(boolean z);

        public abstract Builder uniqueUBId(String str);
    }

    public abstract String adSpaceId();

    public abstract String mediationAdapterVersion();

    public abstract String mediationNetworkName();

    public abstract String mediationNetworkSdkVersion();

    public abstract boolean shouldFetchPrivacy();

    public abstract boolean shouldReturnUrlsForImageAssets();

    public abstract String uniqueUBId();

    public static Builder builder() {
        return new AutoValue_NativeAdRequest.Builder().shouldFetchPrivacy(true).shouldReturnUrlsForImageAssets(false);
    }
}
