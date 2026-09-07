package com.bytedance.sdk.component.ML.pA;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes10.dex */
public class pA implements ThreadFactory {
    private final AtomicInteger Og = new AtomicInteger(1);
    private final ThreadGroup pA;

    public pA(String str) {
        this.pA = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.pA, runnable, "tt_img_" + this.Og.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
