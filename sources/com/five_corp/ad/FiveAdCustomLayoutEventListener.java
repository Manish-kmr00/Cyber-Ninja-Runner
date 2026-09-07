package com.five_corp.ad;

/* JADX INFO: loaded from: classes9.dex */
public interface FiveAdCustomLayoutEventListener {
    default void onClick(FiveAdCustomLayout fiveAdCustomLayout) {
    }

    default void onImpression(FiveAdCustomLayout fiveAdCustomLayout) {
    }

    default void onPause(FiveAdCustomLayout fiveAdCustomLayout) {
    }

    default void onPlay(FiveAdCustomLayout fiveAdCustomLayout) {
    }

    default void onRemove(FiveAdCustomLayout fiveAdCustomLayout) {
    }

    void onViewError(FiveAdCustomLayout fiveAdCustomLayout, FiveAdErrorCode fiveAdErrorCode);

    default void onViewThrough(FiveAdCustomLayout fiveAdCustomLayout) {
    }
}
