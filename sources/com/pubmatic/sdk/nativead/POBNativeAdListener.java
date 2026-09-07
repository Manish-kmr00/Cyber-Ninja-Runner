package com.pubmatic.sdk.nativead;

import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes13.dex */
public interface POBNativeAdListener {
    void onNativeAdClicked(POBNativeAd pOBNativeAd);

    void onNativeAdClicked(POBNativeAd pOBNativeAd, String str);

    void onNativeAdClosed(POBNativeAd pOBNativeAd);

    void onNativeAdImpression(POBNativeAd pOBNativeAd);

    void onNativeAdLeavingApplication(POBNativeAd pOBNativeAd);

    void onNativeAdOpened(POBNativeAd pOBNativeAd);

    void onNativeAdRendered(POBNativeAd pOBNativeAd);

    void onNativeAdRenderingFailed(POBNativeAd pOBNativeAd, POBError pOBError);
}
