package com.smaato.sdk.core.ub.cacheerror;

import com.smaato.sdk.core.ad.AdFormat;

/* JADX INFO: loaded from: classes9.dex */
public abstract class UbCacheErrorReportingParams {

    public static abstract class Builder {
        public abstract UbCacheErrorReportingParams build();

        public abstract Builder setAdFormat(AdFormat adFormat);

        public abstract Builder setAdSpaceId(String str);

        public abstract Builder setCreativeId(String str);

        public abstract Builder setPublisherId(String str);

        public abstract Builder setRequestTimestamp(Long l);

        public abstract Builder setSessionId(String str);
    }

    public abstract AdFormat adFormat();

    public abstract String adSpaceId();

    public abstract String creativeId();

    public abstract String publisherId();

    public abstract Long requestTimestamp();

    public abstract String sessionId();

    public static Builder builder() {
        return new AutoValue_UbCacheErrorReportingParams.Builder();
    }
}
