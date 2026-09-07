package com.pubmatic.sdk.nativead.response;

import com.pubmatic.sdk.openwrap.core.nativead.POBNativeDataAssetType;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeAdDataResponseAsset extends POBNativeAdResponseAsset {
    private final String d;
    private final int e;
    private final POBNativeDataAssetType f;

    public POBNativeAdDataResponseAsset(int i, boolean z, POBNativeAdLinkResponse pOBNativeAdLinkResponse, String str, int i2, POBNativeDataAssetType pOBNativeDataAssetType) {
        super(i, z, pOBNativeAdLinkResponse);
        this.d = str;
        this.e = i2;
        this.f = pOBNativeDataAssetType;
    }

    public int getLength() {
        return this.e;
    }

    public POBNativeDataAssetType getType() {
        return this.f;
    }

    public String getValue() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.nativead.response.POBNativeAdResponseAsset
    public String toString() {
        return "Asset-Id: " + getAssetId() + "\nRequired: " + isRequired() + "\nLink: " + getLink() + "\nValue: " + this.d + "\nLength: " + this.e + "\nType: " + this.f;
    }
}
