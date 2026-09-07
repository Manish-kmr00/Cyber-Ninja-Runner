package com.bytedance.sdk.component.omh.KZx;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ZZv implements ThreadFactory {
    private final AtomicInteger KZx = new AtomicInteger(1);
    protected final String Og;
    protected final ThreadGroup pA;

    public ZZv(String str) {
        this.pA = new ThreadGroup("pag_g_".concat(String.valueOf(str)));
        this.Og = pA(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadPA = pA(this.pA, runnable, this.Og + "_" + this.KZx.getAndIncrement());
        if (threadPA.isDaemon()) {
            threadPA.setDaemon(false);
        }
        return threadPA;
    }

    protected Thread pA(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    public static String pA(String str) {
        return "pag_".concat(String.valueOf(str));
    }
}
