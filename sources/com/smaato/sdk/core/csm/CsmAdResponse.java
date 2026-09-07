package com.smaato.sdk.core.csm;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CsmAdResponse {

    public static abstract class Builder {
        public abstract CsmAdResponse build();

        public abstract Builder setNetworks(List<Network> list);

        public abstract Builder setPassback(String str);

        public abstract Builder setSessionId(String str);
    }

    public abstract List<Network> getNetworks();

    public abstract String getPassback();

    public abstract String getSessionId();

    public static Builder builder() {
        return new AutoValue_CsmAdResponse.Builder();
    }
}
