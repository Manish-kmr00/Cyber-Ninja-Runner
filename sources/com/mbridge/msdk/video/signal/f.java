package com.mbridge.msdk.video.signal;

/* JADX INFO: compiled from: IJSContainerModule.java */
/* JADX INFO: loaded from: classes7.dex */
public interface f {
    void configurationChanged(int i, int i2, int i3);

    boolean endCardShowing();

    void hideAlertWebview();

    void ivRewardAdsWithoutVideo(String str);

    boolean miniCardShowing();

    void readyStatus(int i);

    void resizeMiniCard(int i, int i2, int i3);

    boolean showAlertWebView();

    void showEndcard(int i);

    void showMiniCard(int i, int i2, int i3, int i4, int i5);

    void showVideoClickView(int i);

    void showVideoEndCover();
}
