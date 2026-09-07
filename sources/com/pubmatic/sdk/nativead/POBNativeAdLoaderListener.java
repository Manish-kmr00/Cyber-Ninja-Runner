package com.pubmatic.sdk.nativead;

import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes12.dex */
public interface POBNativeAdLoaderListener {
    void onAdReceived(POBNativeAdLoader pOBNativeAdLoader, POBNativeAd pOBNativeAd);

    void onFailedToLoad(POBNativeAdLoader pOBNativeAdLoader, POBError pOBError);
}
