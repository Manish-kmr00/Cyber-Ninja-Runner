package com.mbridge.msdk.out;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadListener {
    void onEnd(int i, int i2, String str);

    void onProgressUpdate(int i);

    void onStart();

    void onStatus(int i);
}
