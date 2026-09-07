package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes9.dex */
public interface fx1 {

    public interface a<T extends fx1> {
        void a(T t);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j);
}
