package com.smaato.sdk.interstitial;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.util.LogUtil;
import com.smaato.sdk.interstitial.view.InterstitialAdDelegate;

/* JADX INFO: loaded from: classes11.dex */
public final class Interstitial extends InterstitialBase {
    public static void loadAd(String str, EventListener eventListener) {
        loadAd(str, eventListener, null);
    }

    public static void loadAd(String str, EventListener eventListener, AdRequestParams adRequestParams) {
        loadAd(str, eventListener, adRequestParams, false);
    }

    static void loadAd(String str, EventListener eventListener, AdRequestParams adRequestParams, boolean z) {
        if (!SmaatoSdk.isSmaatoSdkInitialised()) {
            LogUtil.logSmaatoInitMissing();
            if (eventListener != null) {
                eventListener.onAdFailedToLoad(new InterstitialRequestError(InterstitialError.SDK_INITIALISATION_ERROR, str, SmaatoSdk.getPublisherId()));
                return;
            }
            return;
        }
        new InterstitialAdDelegate().loadAd(str, eventListener, InterstitialBase.mediationNetworkName, InterstitialBase.mediationNetworkSDKVersion, InterstitialBase.mediationAdapterVersion, adRequestParams, InterstitialBase.keyValuePairs, InterstitialBase.objectExtras, z);
    }
}
