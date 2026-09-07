package com.smaato.sdk.core.ad;

/* JADX INFO: loaded from: classes9.dex */
final class AutoValue_AdRequestParams extends AdRequestParams {
    private final String UBUniqueId;

    private AutoValue_AdRequestParams(String str) {
        this.UBUniqueId = str;
    }

    @Override // com.smaato.sdk.core.ad.AdRequestParams
    public String getUBUniqueId() {
        return this.UBUniqueId;
    }

    public String toString() {
        return "AdRequestParams{UBUniqueId=" + this.UBUniqueId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdRequestParams)) {
            return false;
        }
        String str = this.UBUniqueId;
        String uBUniqueId = ((AdRequestParams) obj).getUBUniqueId();
        if (str == null) {
            return uBUniqueId == null;
        }
        return str.equals(uBUniqueId);
    }

    public int hashCode() {
        String str = this.UBUniqueId;
        return (str == null ? 0 : str.hashCode()) ^ 1000003;
    }

    static final class Builder extends AdRequestParams.Builder {
        private String UBUniqueId;

        Builder() {
        }

        @Override // com.smaato.sdk.core.ad.AdRequestParams.Builder
        public AdRequestParams.Builder setUBUniqueId(String str) {
            this.UBUniqueId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ad.AdRequestParams.Builder
        public AdRequestParams build() {
            return new AutoValue_AdRequestParams(this.UBUniqueId);
        }
    }
}
