package com.applovin.impl;

/* JADX INFO: loaded from: classes.dex */
public class p6 extends g5 {
    private final Runnable g;

    public p6(com.applovin.impl.sdk.k kVar, String str, Runnable runnable) {
        this(kVar, false, str, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.g.run();
    }

    public p6(com.applovin.impl.sdk.k kVar, boolean z, String str, Runnable runnable) {
        super("TaskRunnable:" + str, kVar, z);
        this.g = runnable;
    }
}
