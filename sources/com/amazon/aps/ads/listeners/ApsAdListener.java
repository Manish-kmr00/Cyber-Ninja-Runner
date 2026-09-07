package com.amazon.aps.ads.listeners;

import com.amazon.aps.ads.ApsAd;

/* JADX INFO: loaded from: classes7.dex */
public interface ApsAdListener {
    void onAdClicked(ApsAd apsAd);

    default void onAdClosed(ApsAd apsAd) {
    }

    default void onAdError(ApsAd apsAd) {
    }

    void onAdFailedToLoad(ApsAd apsAd);

    void onAdLoaded(ApsAd apsAd);

    default void onAdOpen(ApsAd apsAd) {
    }

    void onImpressionFired(ApsAd apsAd);

    default void onVideoCompleted(ApsAd apsAd) {
    }
}
