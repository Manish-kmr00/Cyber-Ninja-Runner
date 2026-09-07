package com.smaato.sdk.rewarded.model.csm;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate;
import com.smaato.sdk.rewarded.csm.SMARewardedNetworkEvent;
import com.smaato.sdk.rewarded.csm.SMARewardedNetworkEventListener;

/* JADX INFO: loaded from: classes12.dex */
public class RewardedCsmDelegate extends InterstitialCsmBaseDelegate implements SMARewardedNetworkEventListener {
    private CsmRewardedListener delegateListener;
    private final SMARewardedNetworkEvent networkEvent;

    public interface CsmRewardedListener extends InterstitialCsmBaseDelegate.CsmBaseDelegateListener {
        void onAdError();

        void onAdReward();

        void onAdStarted();
    }

    public RewardedCsmDelegate(SMARewardedNetworkEvent sMARewardedNetworkEvent, Consumer<InterstitialCsmBaseDelegate> consumer, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        super(consumer, runnable, runnable2, runnable3);
        this.networkEvent = sMARewardedNetworkEvent;
    }

    @Override // com.smaato.sdk.rewarded.csm.SMARewardedNetworkEventListener
    public void onAdError() {
        CsmRewardedListener csmRewardedListener = this.delegateListener;
        if (csmRewardedListener != null) {
            csmRewardedListener.onAdError();
        }
    }

    @Override // com.smaato.sdk.rewarded.csm.SMARewardedNetworkEventListener
    public void onAdStarted() {
        CsmRewardedListener csmRewardedListener = this.delegateListener;
        if (csmRewardedListener != null) {
            csmRewardedListener.onAdStarted();
            this.delegateListener.onAdImpressed();
        }
    }

    @Override // com.smaato.sdk.rewarded.csm.SMARewardedNetworkEventListener
    public void onAdReward() {
        CsmRewardedListener csmRewardedListener = this.delegateListener;
        if (csmRewardedListener != null) {
            csmRewardedListener.onAdReward();
        }
    }

    @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate
    public void showAd() {
        this.networkEvent.showAd();
    }

    public void setDelegateListener(CsmRewardedListener csmRewardedListener) {
        this.delegateListener = csmRewardedListener;
        super.delegateListener = csmRewardedListener;
    }
}
