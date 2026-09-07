package net.pubnative.lite.sdk.contentinfo.listeners;

/* JADX INFO: loaded from: classes8.dex */
public interface AdFeedbackLoadListener {
    void onFormClosed();

    void onLoad(String str);

    void onLoadFailed(Throwable th);

    void onLoadFinished();
}
