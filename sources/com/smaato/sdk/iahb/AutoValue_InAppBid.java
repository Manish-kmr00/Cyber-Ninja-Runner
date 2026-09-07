package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes13.dex */
final class AutoValue_InAppBid extends InAppBid {
    private final String json;

    AutoValue_InAppBid(String str) {
        if (str == null) {
            throw new NullPointerException("Null json");
        }
        this.json = str;
    }

    @Override // com.smaato.sdk.iahb.InAppBid
    String getJson() {
        return this.json;
    }

    public String toString() {
        return "InAppBid{json=" + this.json + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InAppBid) {
            return this.json.equals(((InAppBid) obj).getJson());
        }
        return false;
    }

    public int hashCode() {
        return this.json.hashCode() ^ 1000003;
    }
}
