package com.smaato.sdk.core.csm;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
final class AutoValue_CsmAdResponse extends CsmAdResponse {
    private final List networks;
    private final String passback;
    private final String sessionId;

    private AutoValue_CsmAdResponse(List list, String str, String str2) {
        this.networks = list;
        this.sessionId = str;
        this.passback = str2;
    }

    @Override // com.smaato.sdk.core.csm.CsmAdResponse
    public List<Network> getNetworks() {
        return this.networks;
    }

    @Override // com.smaato.sdk.core.csm.CsmAdResponse
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.smaato.sdk.core.csm.CsmAdResponse
    public String getPassback() {
        return this.passback;
    }

    public String toString() {
        return "CsmAdResponse{networks=" + this.networks + ", sessionId=" + this.sessionId + ", passback=" + this.passback + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CsmAdResponse)) {
            return false;
        }
        CsmAdResponse csmAdResponse = (CsmAdResponse) obj;
        return this.networks.equals(csmAdResponse.getNetworks()) && this.sessionId.equals(csmAdResponse.getSessionId()) && this.passback.equals(csmAdResponse.getPassback());
    }

    public int hashCode() {
        return ((((this.networks.hashCode() ^ 1000003) * 1000003) ^ this.sessionId.hashCode()) * 1000003) ^ this.passback.hashCode();
    }

    static final class Builder extends CsmAdResponse.Builder {
        private List networks;
        private String passback;
        private String sessionId;

        Builder() {
        }

        @Override // com.smaato.sdk.core.csm.CsmAdResponse.Builder
        public CsmAdResponse.Builder setNetworks(List<Network> list) {
            if (list == null) {
                throw new NullPointerException("Null networks");
            }
            this.networks = list;
            return this;
        }

        @Override // com.smaato.sdk.core.csm.CsmAdResponse.Builder
        public CsmAdResponse.Builder setSessionId(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionId");
            }
            this.sessionId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.csm.CsmAdResponse.Builder
        public CsmAdResponse.Builder setPassback(String str) {
            if (str == null) {
                throw new NullPointerException("Null passback");
            }
            this.passback = str;
            return this;
        }

        @Override // com.smaato.sdk.core.csm.CsmAdResponse.Builder
        public CsmAdResponse build() {
            String str;
            if (this.networks != null) {
                str = "";
            } else {
                str = " networks";
            }
            if (this.sessionId == null) {
                str = str + " sessionId";
            }
            if (this.passback == null) {
                str = str + " passback";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_CsmAdResponse(this.networks, this.sessionId, this.passback);
        }
    }
}
