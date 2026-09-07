package com.five_corp.ad;

/* JADX INFO: loaded from: classes6.dex */
public interface FiveAdVideoRewardEventListener {
    default void onClick(FiveAdVideoReward fiveAdVideoReward) {
    }

    default void onFullScreenClose(FiveAdVideoReward fiveAdVideoReward) {
    }

    default void onFullScreenOpen(FiveAdVideoReward fiveAdVideoReward) {
    }

    default void onImpression(FiveAdVideoReward fiveAdVideoReward) {
    }

    default void onPause(FiveAdVideoReward fiveAdVideoReward) {
    }

    default void onPlay(FiveAdVideoReward fiveAdVideoReward) {
    }

    void onReward(FiveAdVideoReward fiveAdVideoReward);

    void onViewError(FiveAdVideoReward fiveAdVideoReward, FiveAdErrorCode fiveAdErrorCode);

    default void onViewThrough(FiveAdVideoReward fiveAdVideoReward) {
    }
}
