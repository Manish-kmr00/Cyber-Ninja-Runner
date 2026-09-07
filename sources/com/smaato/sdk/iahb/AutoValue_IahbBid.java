package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_IahbBid extends IahbBid {
    private final String adm;
    private final String bundleId;
    private final IahbExt ext;

    private AutoValue_IahbBid(String str, String str2, IahbExt iahbExt) {
        this.adm = str;
        this.bundleId = str2;
        this.ext = iahbExt;
    }

    @Override // com.smaato.sdk.iahb.IahbBid
    String adm() {
        return this.adm;
    }

    @Override // com.smaato.sdk.iahb.IahbBid
    String bundleId() {
        return this.bundleId;
    }

    @Override // com.smaato.sdk.iahb.IahbBid
    IahbExt ext() {
        return this.ext;
    }

    public String toString() {
        return "IahbBid{adm=" + this.adm + ", bundleId=" + this.bundleId + ", ext=" + this.ext + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IahbBid)) {
            return false;
        }
        IahbBid iahbBid = (IahbBid) obj;
        return this.adm.equals(iahbBid.adm()) && ((str = this.bundleId) != null ? str.equals(iahbBid.bundleId()) : iahbBid.bundleId() == null) && this.ext.equals(iahbBid.ext());
    }

    public int hashCode() {
        int iHashCode = (this.adm.hashCode() ^ 1000003) * 1000003;
        String str = this.bundleId;
        return ((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.ext.hashCode();
    }

    static final class Builder extends IahbBid.Builder {
        private String adm;
        private String bundleId;
        private IahbExt ext;

        Builder() {
        }

        @Override // com.smaato.sdk.iahb.IahbBid.Builder
        IahbBid.Builder adm(String str) {
            if (str == null) {
                throw new NullPointerException("Null adm");
            }
            this.adm = str;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbBid.Builder
        IahbBid.Builder bundleId(String str) {
            this.bundleId = str;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbBid.Builder
        IahbBid.Builder ext(IahbExt iahbExt) {
            if (iahbExt == null) {
                throw new NullPointerException("Null ext");
            }
            this.ext = iahbExt;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbBid.Builder
        IahbBid autoBuild() {
            String str;
            if (this.adm != null) {
                str = "";
            } else {
                str = " adm";
            }
            if (this.ext == null) {
                str = str + " ext";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_IahbBid(this.adm, this.bundleId, this.ext);
        }
    }
}
