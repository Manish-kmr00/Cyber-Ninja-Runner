package com.pubmatic.sdk.nativead.response;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeAdResponseAsset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7705a;
    private final boolean b;
    private final POBNativeAdLinkResponse c;

    public POBNativeAdResponseAsset(int i, boolean z, POBNativeAdLinkResponse pOBNativeAdLinkResponse) {
        this.f7705a = i;
        this.b = z;
        this.c = pOBNativeAdLinkResponse;
    }

    public int getAssetId() {
        return this.f7705a;
    }

    public POBNativeAdLinkResponse getLink() {
        return this.c;
    }

    public boolean isRequired() {
        return this.b;
    }

    public String toString() {
        return "Asset-Id: " + getAssetId() + "\nRequired: " + isRequired() + "\nLink: " + getLink();
    }
}
