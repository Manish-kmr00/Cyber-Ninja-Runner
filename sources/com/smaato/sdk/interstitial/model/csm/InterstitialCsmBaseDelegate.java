package com.smaato.sdk.interstitial.model.csm;

import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public abstract class InterstitialCsmBaseDelegate {
    protected CsmBaseDelegateListener delegateListener;
    protected final Runnable onAdFailedToLoad;
    protected final Consumer<InterstitialCsmBaseDelegate> onAdLoaded;
    protected final Runnable onCsmAdClicked;
    protected final Runnable onCsmAdTtlExpired;

    public interface CsmBaseDelegateListener {
        void onAdClosed();

        void onAdImpressed();
    }

    public abstract void showAd();

    public InterstitialCsmBaseDelegate(Consumer<InterstitialCsmBaseDelegate> consumer, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.onAdLoaded = consumer;
        this.onAdFailedToLoad = runnable;
        this.onCsmAdClicked = runnable2;
        this.onCsmAdTtlExpired = runnable3;
    }

    public void onAdLoaded() {
        this.onAdLoaded.accept(this);
    }

    public void onAdFailedToLoad() {
        this.onAdFailedToLoad.run();
    }

    public void onAdClicked() {
        this.onCsmAdClicked.run();
    }

    public void onAdClosed() {
        CsmBaseDelegateListener csmBaseDelegateListener = this.delegateListener;
        if (csmBaseDelegateListener != null) {
            csmBaseDelegateListener.onAdClosed();
        }
    }

    public void onAdTTLExpired() {
        this.onCsmAdTtlExpired.run();
    }
}
