package com.smaato.sdk.core.ub.cacheerror;

import com.smaato.sdk.core.ad.AdFormat;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_UbCacheErrorReportingParams extends UbCacheErrorReportingParams {
    private final AdFormat adFormat;
    private final String adSpaceId;
    private final String creativeId;
    private final String publisherId;
    private final Long requestTimestamp;
    private final String sessionId;

    private AutoValue_UbCacheErrorReportingParams(String str, String str2, String str3, String str4, AdFormat adFormat, Long l) {
        this.publisherId = str;
        this.adSpaceId = str2;
        this.sessionId = str3;
        this.creativeId = str4;
        this.adFormat = adFormat;
        this.requestTimestamp = l;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public String publisherId() {
        return this.publisherId;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public String adSpaceId() {
        return this.adSpaceId;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public String sessionId() {
        return this.sessionId;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public String creativeId() {
        return this.creativeId;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public AdFormat adFormat() {
        return this.adFormat;
    }

    @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams
    public Long requestTimestamp() {
        return this.requestTimestamp;
    }

    public String toString() {
        return "UbCacheErrorReportingParams{publisherId=" + this.publisherId + ", adSpaceId=" + this.adSpaceId + ", sessionId=" + this.sessionId + ", creativeId=" + this.creativeId + ", adFormat=" + this.adFormat + ", requestTimestamp=" + this.requestTimestamp + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        AdFormat adFormat;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UbCacheErrorReportingParams)) {
            return false;
        }
        UbCacheErrorReportingParams ubCacheErrorReportingParams = (UbCacheErrorReportingParams) obj;
        if (this.publisherId.equals(ubCacheErrorReportingParams.publisherId()) && this.adSpaceId.equals(ubCacheErrorReportingParams.adSpaceId()) && ((str = this.sessionId) != null ? str.equals(ubCacheErrorReportingParams.sessionId()) : ubCacheErrorReportingParams.sessionId() == null) && ((str2 = this.creativeId) != null ? str2.equals(ubCacheErrorReportingParams.creativeId()) : ubCacheErrorReportingParams.creativeId() == null) && ((adFormat = this.adFormat) != null ? adFormat.equals(ubCacheErrorReportingParams.adFormat()) : ubCacheErrorReportingParams.adFormat() == null)) {
            Long l = this.requestTimestamp;
            if (l == null) {
                if (ubCacheErrorReportingParams.requestTimestamp() == null) {
                    return true;
                }
            } else if (l.equals(ubCacheErrorReportingParams.requestTimestamp())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.publisherId.hashCode() ^ 1000003) * 1000003) ^ this.adSpaceId.hashCode()) * 1000003;
        String str = this.sessionId;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.creativeId;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        AdFormat adFormat = this.adFormat;
        int iHashCode4 = (iHashCode3 ^ (adFormat == null ? 0 : adFormat.hashCode())) * 1000003;
        Long l = this.requestTimestamp;
        return iHashCode4 ^ (l != null ? l.hashCode() : 0);
    }

    static final class Builder extends UbCacheErrorReportingParams.Builder {
        private AdFormat adFormat;
        private String adSpaceId;
        private String creativeId;
        private String publisherId;
        private Long requestTimestamp;
        private String sessionId;

        Builder() {
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setPublisherId(String str) {
            if (str == null) {
                throw new NullPointerException("Null publisherId");
            }
            this.publisherId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setAdSpaceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null adSpaceId");
            }
            this.adSpaceId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setSessionId(String str) {
            this.sessionId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setCreativeId(String str) {
            this.creativeId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setAdFormat(AdFormat adFormat) {
            this.adFormat = adFormat;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams.Builder setRequestTimestamp(Long l) {
            this.requestTimestamp = l;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams.Builder
        public UbCacheErrorReportingParams build() {
            String str;
            if (this.publisherId != null) {
                str = "";
            } else {
                str = " publisherId";
            }
            if (this.adSpaceId == null) {
                str = str + " adSpaceId";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_UbCacheErrorReportingParams(this.publisherId, this.adSpaceId, this.sessionId, this.creativeId, this.adFormat, this.requestTimestamp);
        }
    }
}
