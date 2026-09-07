package com.smaato.sdk.core.network;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_MimeType extends MimeType {
    private final String charset;
    private final String string;
    private final String subtype;
    private final String type;

    AutoValue_MimeType(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("Null string");
        }
        this.string = str;
        if (str2 == null) {
            throw new NullPointerException("Null type");
        }
        this.type = str2;
        if (str3 == null) {
            throw new NullPointerException("Null subtype");
        }
        this.subtype = str3;
        this.charset = str4;
    }

    @Override // com.smaato.sdk.core.network.MimeType
    public String string() {
        return this.string;
    }

    @Override // com.smaato.sdk.core.network.MimeType
    public String type() {
        return this.type;
    }

    @Override // com.smaato.sdk.core.network.MimeType
    public String subtype() {
        return this.subtype;
    }

    @Override // com.smaato.sdk.core.network.MimeType
    public String charset() {
        return this.charset;
    }

    public String toString() {
        return "MimeType{string=" + this.string + ", type=" + this.type + ", subtype=" + this.subtype + ", charset=" + this.charset + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MimeType)) {
            return false;
        }
        MimeType mimeType = (MimeType) obj;
        if (this.string.equals(mimeType.string()) && this.type.equals(mimeType.type()) && this.subtype.equals(mimeType.subtype())) {
            String str = this.charset;
            if (str == null) {
                if (mimeType.charset() == null) {
                    return true;
                }
            } else if (str.equals(mimeType.charset())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.string.hashCode() ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.subtype.hashCode()) * 1000003;
        String str = this.charset;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }
}
