package com.applovin.mediation.adapters;

import android.os.Bundle;
import com.applovin.impl.k2;
import com.applovin.impl.l2;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.b;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* JADX INFO: loaded from: classes13.dex */
public class AppLovinAdapterAppOpenListener implements l2, AppLovinAdClickListener, k2 {
    private final MaxAppOpenAdapterListener listener;
    private final AppLovinMediationAdapter parentAdapter;

    AppLovinAdapterAppOpenListener(AppLovinMediationAdapter appLovinMediationAdapter, MaxAppOpenAdapterListener maxAppOpenAdapterListener) {
        this.parentAdapter = appLovinMediationAdapter;
        this.listener = maxAppOpenAdapterListener;
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        this.parentAdapter.log("App open ad clicked");
        this.listener.onAppOpenAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        this.parentAdapter.log("App open ad shown");
        Bundle extraInfo = AppLovinMediationAdapter.getExtraInfo(appLovinAd);
        if (appLovinAd instanceof b) {
            extraInfo.putBundle("applovin_ad_view_info", ((b) appLovinAd).h());
        }
        this.listener.onAppOpenAdDisplayed(extraInfo);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        this.parentAdapter.log("App open ad hidden");
        this.listener.onAppOpenAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        this.parentAdapter.log("App open ad loaded");
        this.parentAdapter.loadedAppOpenAd = appLovinAd;
        this.listener.onAppOpenAdLoaded(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        failedToReceiveAdV2(new AppLovinError(i, ""));
    }

    @Override // com.applovin.impl.l2
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        this.parentAdapter.log("App open ad failed to load with error: " + appLovinError);
        this.listener.onAppOpenAdLoadFailed(AppLovinMediationAdapter.toMaxError(appLovinError));
    }

    @Override // com.applovin.impl.k2
    public void onAdDisplayFailed(String str) {
        this.parentAdapter.log("App open ad failed to display with error: " + str);
        this.listener.onAppOpenAdDisplayFailed(new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str), AppLovinMediationAdapter.getExtraInfo(this.parentAdapter.loadedAppOpenAd));
    }
}
