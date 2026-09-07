package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes11.dex */
public interface VideoContentListener extends InneractiveContentController.EventsListener {
    void onCompleted();

    @Deprecated
    void onPlayerError();

    void onProgress(int i, int i2);
}
