package com.pubmatic.sdk.nativead.response;

/* JADX INFO: loaded from: classes11.dex */
public class POBNativeAdTitleResponseAsset extends POBNativeAdResponseAsset {
    private final String d;
    private final int e;

    public POBNativeAdTitleResponseAsset(int i, boolean z, POBNativeAdLinkResponse pOBNativeAdLinkResponse, String str, int i2) {
        super(i, z, pOBNativeAdLinkResponse);
        this.d = str;
        this.e = i2 == 0 ? str.length() : i2;
    }

    public int getLength() {
        return this.e;
    }

    public String getTitle() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.nativead.response.POBNativeAdResponseAsset
    public String toString() {
        return "Asset-Id: " + getAssetId() + "\nRequired: " + isRequired() + "\nLink: " + getLink() + "\nTitle: " + this.d + "\nLength: " + this.e + "\nType: ";
    }
}
