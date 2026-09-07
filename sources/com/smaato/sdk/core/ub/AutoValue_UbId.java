package com.smaato.sdk.core.ub;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_UbId extends UbId {
    private final String adSpaceId;
    private final String sessionId;

    private AutoValue_UbId(String str, String str2) {
        this.sessionId = str;
        this.adSpaceId = str2;
    }

    @Override // com.smaato.sdk.core.ub.UbId
    public String sessionId() {
        return this.sessionId;
    }

    @Override // com.smaato.sdk.core.ub.UbId
    public String adSpaceId() {
        return this.adSpaceId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UbId)) {
            return false;
        }
        UbId ubId = (UbId) obj;
        return this.sessionId.equals(ubId.sessionId()) && this.adSpaceId.equals(ubId.adSpaceId());
    }

    public int hashCode() {
        return ((this.sessionId.hashCode() ^ 1000003) * 1000003) ^ this.adSpaceId.hashCode();
    }

    static final class Builder extends UbId.Builder {
        private String adSpaceId;
        private String sessionId;

        Builder() {
        }

        @Override // com.smaato.sdk.core.ub.UbId.Builder
        public UbId.Builder sessionId(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionId");
            }
            this.sessionId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.UbId.Builder
        public UbId.Builder adSpaceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null adSpaceId");
            }
            this.adSpaceId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.UbId.Builder
        public UbId build() {
            String str;
            if (this.sessionId != null) {
                str = "";
            } else {
                str = " sessionId";
            }
            if (this.adSpaceId == null) {
                str = str + " adSpaceId";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_UbId(this.sessionId, this.adSpaceId);
        }
    }
}
