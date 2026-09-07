package com.smaato.sdk.nativead;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class AutoValue_NativeAdLink extends NativeAdLink {
    private final List trackers;
    private final String url;

    AutoValue_NativeAdLink(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null url");
        }
        this.url = str;
        if (list == null) {
            throw new NullPointerException("Null trackers");
        }
        this.trackers = list;
    }

    @Override // com.smaato.sdk.nativead.NativeAdLink
    public String url() {
        return this.url;
    }

    @Override // com.smaato.sdk.nativead.NativeAdLink
    public List trackers() {
        return this.trackers;
    }

    public String toString() {
        return "NativeAdLink{url=" + this.url + ", trackers=" + this.trackers + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdLink)) {
            return false;
        }
        NativeAdLink nativeAdLink = (NativeAdLink) obj;
        return this.url.equals(nativeAdLink.url()) && this.trackers.equals(nativeAdLink.trackers());
    }

    public int hashCode() {
        return ((this.url.hashCode() ^ 1000003) * 1000003) ^ this.trackers.hashCode();
    }
}
