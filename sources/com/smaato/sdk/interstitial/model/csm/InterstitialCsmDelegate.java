package com.smaato.sdk.interstitial.model.csm;

import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.csm.SMAInterstitialNetworkEvent;
import com.smaato.sdk.interstitial.csm.SMAInterstitialNetworkEventListener;

/* JADX INFO: loaded from: classes6.dex */
public class InterstitialCsmDelegate extends InterstitialCsmBaseDelegate implements SMAInterstitialNetworkEventListener {
    CsmInterstitialDelegateListener delegateListener;
    private final SMAInterstitialNetworkEvent networkEvent;

    public interface CsmInterstitialDelegateListener extends InterstitialCsmBaseDelegate.CsmBaseDelegateListener {
        void onAdOpened();
    }

    public InterstitialCsmDelegate(SMAInterstitialNetworkEvent sMAInterstitialNetworkEvent, Consumer<InterstitialCsmBaseDelegate> consumer, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        super(consumer, runnable, runnable2, runnable3);
        this.networkEvent = sMAInterstitialNetworkEvent;
    }

    @Override // com.smaato.sdk.interstitial.csm.SMAInterstitialNetworkEventListener
    public void onAdOpened() {
        CsmInterstitialDelegateListener csmInterstitialDelegateListener = this.delegateListener;
        if (csmInterstitialDelegateListener != null) {
            csmInterstitialDelegateListener.onAdOpened();
            this.delegateListener.onAdImpressed();
        }
    }

    @Override // com.smaato.sdk.interstitial.model.csm.InterstitialCsmBaseDelegate
    public void showAd() {
        this.networkEvent.showAd();
    }

    public void setDelegateListener(CsmInterstitialDelegateListener csmInterstitialDelegateListener) {
        this.delegateListener = csmInterstitialDelegateListener;
        super.delegateListener = csmInterstitialDelegateListener;
    }
}
