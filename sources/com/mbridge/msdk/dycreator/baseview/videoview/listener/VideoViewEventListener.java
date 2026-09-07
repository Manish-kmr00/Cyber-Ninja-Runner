package com.mbridge.msdk.dycreator.baseview.videoview.listener;

/* JADX INFO: loaded from: classes5.dex */
public interface VideoViewEventListener {
    void onBufferingEnd();

    void onBufferingFail(String str);

    void onBufferingStart();

    void onPlayCompleted();

    void onPlayProgress(int i, int i2);

    void onPlayStart(String str);

    void onPlayerError(int i, String str);
}
