package com.smaato.sdk.core.ad;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AdRequestParams {

    public static abstract class Builder {
        public abstract AdRequestParams build();

        public abstract Builder setUBUniqueId(String str);
    }

    public abstract String getUBUniqueId();

    public static Builder builder() {
        return new AutoValue_AdRequestParams.Builder();
    }

    public Builder newBuilder() {
        return builder().setUBUniqueId(getUBUniqueId());
    }
}
