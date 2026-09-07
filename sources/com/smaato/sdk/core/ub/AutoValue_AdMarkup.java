package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.ad.Expiration;
import com.smaato.sdk.core.api.ImpressionCountingType;

/* JADX INFO: loaded from: classes3.dex */
final class AutoValue_AdMarkup extends AdMarkup {
    private final String adFormat;
    private final String adSpaceId;
    private final String bundleId;
    private final String creativeId;
    private final Expiration expiresAt;
    private final ImpressionCountingType impressionCountingType;
    private final String markup;
    private final String sessionId;

    private AutoValue_AdMarkup(String str, String str2, String str3, String str4, String str5, String str6, Expiration expiration, ImpressionCountingType impressionCountingType) {
        this.markup = str;
        this.adFormat = str2;
        this.sessionId = str3;
        this.bundleId = str4;
        this.creativeId = str5;
        this.adSpaceId = str6;
        this.expiresAt = expiration;
        this.impressionCountingType = impressionCountingType;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String markup() {
        return this.markup;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String adFormat() {
        return this.adFormat;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String sessionId() {
        return this.sessionId;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String bundleId() {
        return this.bundleId;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String creativeId() {
        return this.creativeId;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public String adSpaceId() {
        return this.adSpaceId;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public Expiration expiresAt() {
        return this.expiresAt;
    }

    @Override // com.smaato.sdk.core.ub.AdMarkup
    public ImpressionCountingType impressionCountingType() {
        return this.impressionCountingType;
    }

    public String toString() {
        return "AdMarkup{markup=" + this.markup + ", adFormat=" + this.adFormat + ", sessionId=" + this.sessionId + ", bundleId=" + this.bundleId + ", creativeId=" + this.creativeId + ", adSpaceId=" + this.adSpaceId + ", expiresAt=" + this.expiresAt + ", impressionCountingType=" + this.impressionCountingType + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdMarkup)) {
            return false;
        }
        AdMarkup adMarkup = (AdMarkup) obj;
        return this.markup.equals(adMarkup.markup()) && this.adFormat.equals(adMarkup.adFormat()) && this.sessionId.equals(adMarkup.sessionId()) && ((str = this.bundleId) != null ? str.equals(adMarkup.bundleId()) : adMarkup.bundleId() == null) && ((str2 = this.creativeId) != null ? str2.equals(adMarkup.creativeId()) : adMarkup.creativeId() == null) && this.adSpaceId.equals(adMarkup.adSpaceId()) && this.expiresAt.equals(adMarkup.expiresAt()) && this.impressionCountingType.equals(adMarkup.impressionCountingType());
    }

    public int hashCode() {
        int iHashCode = (((((this.markup.hashCode() ^ 1000003) * 1000003) ^ this.adFormat.hashCode()) * 1000003) ^ this.sessionId.hashCode()) * 1000003;
        String str = this.bundleId;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.creativeId;
        return ((((((iHashCode2 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.adSpaceId.hashCode()) * 1000003) ^ this.expiresAt.hashCode()) * 1000003) ^ this.impressionCountingType.hashCode();
    }

    static final class Builder extends AdMarkup.Builder {
        private String adFormat;
        private String adSpaceId;
        private String bundleId;
        private String creativeId;
        private Expiration expiresAt;
        private ImpressionCountingType impressionCountingType;
        private String markup;
        private String sessionId;

        Builder() {
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder markup(String str) {
            if (str == null) {
                throw new NullPointerException("Null markup");
            }
            this.markup = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder adFormat(String str) {
            if (str == null) {
                throw new NullPointerException("Null adFormat");
            }
            this.adFormat = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder sessionId(String str) {
            if (str == null) {
                throw new NullPointerException("Null sessionId");
            }
            this.sessionId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder bundleId(String str) {
            this.bundleId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder creativeId(String str) {
            this.creativeId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder adSpaceId(String str) {
            if (str == null) {
                throw new NullPointerException("Null adSpaceId");
            }
            this.adSpaceId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder expiresAt(Expiration expiration) {
            if (expiration == null) {
                throw new NullPointerException("Null expiresAt");
            }
            this.expiresAt = expiration;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup.Builder impressionCountingType(ImpressionCountingType impressionCountingType) {
            if (impressionCountingType == null) {
                throw new NullPointerException("Null impressionCountingType");
            }
            this.impressionCountingType = impressionCountingType;
            return this;
        }

        @Override // com.smaato.sdk.core.ub.AdMarkup.Builder
        public AdMarkup build() {
            String str;
            if (this.markup != null) {
                str = "";
            } else {
                str = " markup";
            }
            if (this.adFormat == null) {
                str = str + " adFormat";
            }
            if (this.sessionId == null) {
                str = str + " sessionId";
            }
            if (this.adSpaceId == null) {
                str = str + " adSpaceId";
            }
            if (this.expiresAt == null) {
                str = str + " expiresAt";
            }
            if (this.impressionCountingType == null) {
                str = str + " impressionCountingType";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_AdMarkup(this.markup, this.adFormat, this.sessionId, this.bundleId, this.creativeId, this.adSpaceId, this.expiresAt, this.impressionCountingType);
        }
    }
}
