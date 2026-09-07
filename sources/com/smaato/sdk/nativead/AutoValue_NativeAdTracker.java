package com.smaato.sdk.nativead;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_NativeAdTracker extends NativeAdTracker {
    private final NativeAdTracker.Type type;
    private final String url;

    AutoValue_NativeAdTracker(NativeAdTracker.Type type, String str) {
        if (type == null) {
            throw new NullPointerException("Null type");
        }
        this.type = type;
        if (str == null) {
            throw new NullPointerException("Null url");
        }
        this.url = str;
    }

    @Override // com.smaato.sdk.nativead.NativeAdTracker
    public NativeAdTracker.Type type() {
        return this.type;
    }

    @Override // com.smaato.sdk.nativead.NativeAdTracker
    public String url() {
        return this.url;
    }

    public String toString() {
        return "NativeAdTracker{type=" + this.type + ", url=" + this.url + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdTracker)) {
            return false;
        }
        NativeAdTracker nativeAdTracker = (NativeAdTracker) obj;
        return this.type.equals(nativeAdTracker.type()) && this.url.equals(nativeAdTracker.url());
    }

    public int hashCode() {
        return ((this.type.hashCode() ^ 1000003) * 1000003) ^ this.url.hashCode();
    }
}
