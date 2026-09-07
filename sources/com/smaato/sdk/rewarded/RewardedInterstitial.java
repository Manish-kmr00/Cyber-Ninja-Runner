package com.smaato.sdk.rewarded;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdRequestParams;
import com.smaato.sdk.core.util.LogUtil;
import com.smaato.sdk.interstitial.InterstitialBase;
import com.smaato.sdk.rewarded.view.RewardedAdDelegate;

/* JADX INFO: loaded from: classes13.dex */
public final class RewardedInterstitial extends InterstitialBase {
    public static void loadAd(String str, EventListener eventListener) {
        loadAd(str, eventListener, null);
    }

    public static void loadAd(String str, EventListener eventListener, AdRequestParams adRequestParams) {
        if (!SmaatoSdk.isSmaatoSdkInitialised()) {
            LogUtil.logSmaatoInitMissing();
            if (eventListener != null) {
                eventListener.onAdFailedToLoad(new RewardedRequestError(RewardedError.SDK_INITIALISATION_ERROR, str, SmaatoSdk.getPublisherId()));
                return;
            }
            return;
        }
        new RewardedAdDelegate().loadAd(str, eventListener, InterstitialBase.mediationNetworkName, InterstitialBase.mediationNetworkSDKVersion, InterstitialBase.mediationAdapterVersion, adRequestParams, InterstitialBase.keyValuePairs, InterstitialBase.objectExtras);
    }
}
