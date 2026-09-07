package com.pubmatic.sdk.nativead.response;

import com.pubmatic.sdk.openwrap.core.nativead.POBNativeImageAssetType;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeAdImageResponseAsset extends POBNativeAdResponseAsset {
    private final String d;
    private final int e;
    private final int f;
    private final POBNativeImageAssetType g;

    public POBNativeAdImageResponseAsset(int i, boolean z, POBNativeAdLinkResponse pOBNativeAdLinkResponse, String str, int i2, int i3, POBNativeImageAssetType pOBNativeImageAssetType) {
        super(i, z, pOBNativeAdLinkResponse);
        this.d = str;
        this.e = i2;
        this.f = i3;
        this.g = pOBNativeImageAssetType;
    }

    public int getHeight() {
        return this.f;
    }

    public String getImageURL() {
        return this.d;
    }

    public POBNativeImageAssetType getType() {
        return this.g;
    }

    public int getWidth() {
        return this.e;
    }

    @Override // com.pubmatic.sdk.nativead.response.POBNativeAdResponseAsset
    public String toString() {
        return "Asset-Id: " + getAssetId() + "\nRequired: " + isRequired() + "\nLink: " + getLink() + "\nImageUrl: " + this.d + "\nWidth: " + this.e + "\nHeight: " + this.f + "\nType: " + this.g;
    }
}
