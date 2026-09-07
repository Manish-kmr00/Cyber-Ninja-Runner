package net.pubnative.lite.sdk;

/* JADX INFO: loaded from: classes9.dex */
public interface CustomEndCardListener {
    void onCustomEndCardClick();

    void onCustomEndCardShow();

    void onDefaultEndCardClick();

    void onDefaultEndCardShow();

    void onEndCardLoadFailure(boolean z);

    void onEndCardLoadSuccess(boolean z);
}
