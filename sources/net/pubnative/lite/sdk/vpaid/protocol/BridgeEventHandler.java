package net.pubnative.lite.sdk.vpaid.protocol;

/* JADX INFO: loaded from: classes3.dex */
public interface BridgeEventHandler {
    void callJsMethod(String str);

    void onAdImpression();

    void onAdLinearChange();

    void onAdSkipped();

    void onAdStopped();

    void onAdVolumeChange();

    void onDurationChanged();

    void onPrepared();

    void openUrl(String str);

    void postEvent(String str, int i, boolean z);

    void postEvent(String str, boolean z);

    void runOnUiThread(Runnable runnable);

    void setSkippableState(boolean z);

    void trackError(String str);
}
