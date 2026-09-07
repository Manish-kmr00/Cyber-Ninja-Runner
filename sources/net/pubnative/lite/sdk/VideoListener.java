package net.pubnative.lite.sdk;

/* JADX INFO: loaded from: classes9.dex */
public interface VideoListener {
    void onVideoDismissed(int i);

    void onVideoError(int i);

    void onVideoFinished();

    void onVideoSkipped();

    void onVideoStarted();
}
