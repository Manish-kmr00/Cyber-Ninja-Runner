package com.smaato.sdk.core.locationaware;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_TxtRecord extends TxtRecord {
    private final String data;
    private final int ttl;

    AutoValue_TxtRecord(String str, int i) {
        if (str == null) {
            throw new NullPointerException("Null data");
        }
        this.data = str;
        this.ttl = i;
    }

    @Override // com.smaato.sdk.core.locationaware.TxtRecord
    public String data() {
        return this.data;
    }

    @Override // com.smaato.sdk.core.locationaware.TxtRecord
    public int ttl() {
        return this.ttl;
    }

    public String toString() {
        return "TxtRecord{data=" + this.data + ", ttl=" + this.ttl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TxtRecord)) {
            return false;
        }
        TxtRecord txtRecord = (TxtRecord) obj;
        return this.data.equals(txtRecord.data()) && this.ttl == txtRecord.ttl();
    }

    public int hashCode() {
        return ((this.data.hashCode() ^ 1000003) * 1000003) ^ this.ttl;
    }
}
