package com.smaato.sdk.banner.csm;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public interface SMABannerNetworkEventListener {
    void onAdClicked();

    void onAdFailedToLoad();

    void onAdLoaded(View view);

    void onAdTTLExpired();
}
