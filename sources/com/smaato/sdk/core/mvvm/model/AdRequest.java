package com.smaato.sdk.core.mvvm.model;

import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.KeyValuePairs;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AdRequest {

    public static abstract class Builder {
        public abstract AdRequest build();

        public abstract Builder setAdFormat(AdFormat adFormat);

        public abstract Builder setAdSpaceId(String str);

        public abstract Builder setKeyValuePairs(KeyValuePairs keyValuePairs);

        public abstract Builder setMediationAdapterVersion(String str);

        public abstract Builder setMediationNetworkName(String str);

        public abstract Builder setMediationNetworkSdkVersion(String str);

        public abstract Builder setObjectExtras(Map<String, Object> map);

        public abstract Builder setOnCsmAdClicked(Runnable runnable);

        public abstract Builder setOnCsmAdExpired(Runnable runnable);

        public abstract Builder setUBUniqueId(String str);
    }

    public abstract AdFormat getAdFormat();

    public abstract String getAdSpaceId();

    public abstract KeyValuePairs getKeyValuePairs();

    public abstract String getMediationAdapterVersion();

    public abstract String getMediationNetworkName();

    public abstract String getMediationNetworkSdkVersion();

    public abstract Map<String, Object> getObjectExtras();

    public abstract Runnable getOnCsmAdClicked();

    public abstract Runnable getOnCsmAdExpired();

    public abstract String getUBUniqueId();

    public static Builder builder() {
        return new AutoValue_AdRequest.Builder();
    }
}
