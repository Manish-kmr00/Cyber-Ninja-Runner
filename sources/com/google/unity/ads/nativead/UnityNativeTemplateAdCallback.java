package com.google.unity.ads.nativead;

import com.google.android.gms.ads.LoadAdError;
import com.google.unity.ads.UnityFullScreenContentCallback;
import com.google.unity.ads.UnityPaidEventListener;

/* JADX INFO: loaded from: classes8.dex */
public interface UnityNativeTemplateAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onNativeAdFailedToLoad(LoadAdError error);

    void onNativeAdLoaded();
}
