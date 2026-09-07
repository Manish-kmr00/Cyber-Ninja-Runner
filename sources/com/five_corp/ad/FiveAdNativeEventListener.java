package com.five_corp.ad;

/* JADX INFO: loaded from: classes12.dex */
public interface FiveAdNativeEventListener {
    default void onClick(FiveAdNative fiveAdNative) {
    }

    default void onImpression(FiveAdNative fiveAdNative) {
    }

    default void onPause(FiveAdNative fiveAdNative) {
    }

    default void onPlay(FiveAdNative fiveAdNative) {
    }

    default void onRemove(FiveAdNative fiveAdNative) {
    }

    void onViewError(FiveAdNative fiveAdNative, FiveAdErrorCode fiveAdErrorCode);

    default void onViewThrough(FiveAdNative fiveAdNative) {
    }
}
