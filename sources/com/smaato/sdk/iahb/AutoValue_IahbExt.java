package com.smaato.sdk.iahb;

import com.smaato.sdk.core.api.ImpressionCountingType;

/* JADX INFO: loaded from: classes11.dex */
final class AutoValue_IahbExt extends IahbExt {
    private final String adspaceid;
    private final String adtype;
    private final long expiresAt;
    private final ImpressionCountingType impressionMeasurement;

    private AutoValue_IahbExt(String str, String str2, long j, ImpressionCountingType impressionCountingType) {
        this.adspaceid = str;
        this.adtype = str2;
        this.expiresAt = j;
        this.impressionMeasurement = impressionCountingType;
    }

    @Override // com.smaato.sdk.iahb.IahbExt
    String adspaceid() {
        return this.adspaceid;
    }

    @Override // com.smaato.sdk.iahb.IahbExt
    String adtype() {
        return this.adtype;
    }

    @Override // com.smaato.sdk.iahb.IahbExt
    long expiresAt() {
        return this.expiresAt;
    }

    @Override // com.smaato.sdk.iahb.IahbExt
    ImpressionCountingType impressionMeasurement() {
        return this.impressionMeasurement;
    }

    public String toString() {
        return "IahbExt{adspaceid=" + this.adspaceid + ", adtype=" + this.adtype + ", expiresAt=" + this.expiresAt + ", impressionMeasurement=" + this.impressionMeasurement + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IahbExt)) {
            return false;
        }
        IahbExt iahbExt = (IahbExt) obj;
        return this.adspaceid.equals(iahbExt.adspaceid()) && this.adtype.equals(iahbExt.adtype()) && this.expiresAt == iahbExt.expiresAt() && this.impressionMeasurement.equals(iahbExt.impressionMeasurement());
    }

    public int hashCode() {
        int iHashCode = (((this.adspaceid.hashCode() ^ 1000003) * 1000003) ^ this.adtype.hashCode()) * 1000003;
        long j = this.expiresAt;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.impressionMeasurement.hashCode();
    }

    static final class Builder extends IahbExt.Builder {
        private String adspaceid;
        private String adtype;
        private Long expiresAt;
        private ImpressionCountingType impressionMeasurement;

        Builder() {
        }

        @Override // com.smaato.sdk.iahb.IahbExt.Builder
        IahbExt.Builder adspaceid(String str) {
            if (str == null) {
                throw new NullPointerException("Null adspaceid");
            }
            this.adspaceid = str;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbExt.Builder
        IahbExt.Builder adtype(String str) {
            if (str == null) {
                throw new NullPointerException("Null adtype");
            }
            this.adtype = str;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbExt.Builder
        IahbExt.Builder expiresAt(long j) {
            this.expiresAt = Long.valueOf(j);
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbExt.Builder
        IahbExt.Builder impressionMeasurement(ImpressionCountingType impressionCountingType) {
            if (impressionCountingType == null) {
                throw new NullPointerException("Null impressionMeasurement");
            }
            this.impressionMeasurement = impressionCountingType;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbExt.Builder
        IahbExt autoBuild() {
            String str;
            if (this.adspaceid != null) {
                str = "";
            } else {
                str = " adspaceid";
            }
            if (this.adtype == null) {
                str = str + " adtype";
            }
            if (this.expiresAt == null) {
                str = str + " expiresAt";
            }
            if (this.impressionMeasurement == null) {
                str = str + " impressionMeasurement";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_IahbExt(this.adspaceid, this.adtype, this.expiresAt.longValue(), this.impressionMeasurement);
        }
    }
}
