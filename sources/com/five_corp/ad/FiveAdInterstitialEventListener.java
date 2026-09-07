package com.five_corp.ad;

/* JADX INFO: loaded from: classes12.dex */
public interface FiveAdInterstitialEventListener {
    default void onClick(FiveAdInterstitial fiveAdInterstitial) {
    }

    default void onFullScreenClose(FiveAdInterstitial fiveAdInterstitial) {
    }

    default void onFullScreenOpen(FiveAdInterstitial fiveAdInterstitial) {
    }

    default void onImpression(FiveAdInterstitial fiveAdInterstitial) {
    }

    default void onPause(FiveAdInterstitial fiveAdInterstitial) {
    }

    default void onPlay(FiveAdInterstitial fiveAdInterstitial) {
    }

    void onViewError(FiveAdInterstitial fiveAdInterstitial, FiveAdErrorCode fiveAdErrorCode);

    default void onViewThrough(FiveAdInterstitial fiveAdInterstitial) {
    }
}
