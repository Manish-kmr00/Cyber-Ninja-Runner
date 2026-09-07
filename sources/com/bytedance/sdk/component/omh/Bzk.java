package com.bytedance.sdk.component.omh;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes12.dex */
public class Bzk implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    protected int KZx;
    protected final String Og;
    private final AtomicInteger ZZv;
    protected final ThreadGroup pA;

    public Bzk(String str) {
        this(5, str);
    }

    public Bzk(int i, String str) {
        this.ZZv = new AtomicInteger(1);
        this.KZx = i;
        this.pA = new ThreadGroup(THREAD_GROUP_NAME_PRE.concat(String.valueOf(str)));
        this.Og = THREAD_NAME_PRE.concat(String.valueOf(str));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadPA = pA(this.pA, runnable, this.Og + this.ZZv.getAndIncrement());
        if (threadPA.isDaemon()) {
            threadPA.setDaemon(false);
        }
        int i = this.KZx;
        if (i > 10 || i <= 0) {
            this.KZx = 5;
        }
        threadPA.setPriority(this.KZx);
        return threadPA;
    }

    protected Thread pA(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }
}
