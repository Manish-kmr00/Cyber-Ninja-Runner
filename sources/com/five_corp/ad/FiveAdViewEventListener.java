package com.five_corp.ad;

/* JADX INFO: loaded from: classes7.dex */
public interface FiveAdViewEventListener {
    void onFiveAdClick(FiveAdInterface fiveAdInterface);

    void onFiveAdClose(FiveAdInterface fiveAdInterface);

    void onFiveAdImpression(FiveAdInterface fiveAdInterface);

    void onFiveAdPause(FiveAdInterface fiveAdInterface);

    void onFiveAdRecover(FiveAdInterface fiveAdInterface);

    void onFiveAdReplay(FiveAdInterface fiveAdInterface);

    void onFiveAdResume(FiveAdInterface fiveAdInterface);

    void onFiveAdStall(FiveAdInterface fiveAdInterface);

    void onFiveAdStart(FiveAdInterface fiveAdInterface);

    void onFiveAdViewError(FiveAdInterface fiveAdInterface, FiveAdErrorCode fiveAdErrorCode);

    void onFiveAdViewThrough(FiveAdInterface fiveAdInterface);
}
