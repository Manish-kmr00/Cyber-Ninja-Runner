package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes12.dex */
public abstract class IahbResponse {
    abstract IahbBid bid();

    abstract String bidId();

    static Builder builder() {
        return new AutoValue_IahbResponse.Builder();
    }

    static abstract class Builder {
        abstract Builder bid(IahbBid iahbBid);

        abstract Builder bidId(String str);

        abstract IahbResponse build();

        Builder() {
        }
    }
}
