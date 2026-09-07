package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_IahbResponse extends IahbResponse {
    private final IahbBid bid;
    private final String bidId;

    private AutoValue_IahbResponse(String str, IahbBid iahbBid) {
        this.bidId = str;
        this.bid = iahbBid;
    }

    @Override // com.smaato.sdk.iahb.IahbResponse
    String bidId() {
        return this.bidId;
    }

    @Override // com.smaato.sdk.iahb.IahbResponse
    IahbBid bid() {
        return this.bid;
    }

    public String toString() {
        return "IahbResponse{bidId=" + this.bidId + ", bid=" + this.bid + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IahbResponse)) {
            return false;
        }
        IahbResponse iahbResponse = (IahbResponse) obj;
        return this.bidId.equals(iahbResponse.bidId()) && this.bid.equals(iahbResponse.bid());
    }

    public int hashCode() {
        return ((this.bidId.hashCode() ^ 1000003) * 1000003) ^ this.bid.hashCode();
    }

    static final class Builder extends IahbResponse.Builder {
        private IahbBid bid;
        private String bidId;

        Builder() {
        }

        @Override // com.smaato.sdk.iahb.IahbResponse.Builder
        IahbResponse.Builder bidId(String str) {
            if (str == null) {
                throw new NullPointerException("Null bidId");
            }
            this.bidId = str;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbResponse.Builder
        IahbResponse.Builder bid(IahbBid iahbBid) {
            if (iahbBid == null) {
                throw new NullPointerException("Null bid");
            }
            this.bid = iahbBid;
            return this;
        }

        @Override // com.smaato.sdk.iahb.IahbResponse.Builder
        IahbResponse build() {
            String str;
            if (this.bidId != null) {
                str = "";
            } else {
                str = " bidId";
            }
            if (this.bid == null) {
                str = str + " bid";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_IahbResponse(this.bidId, this.bid);
        }
    }
}
