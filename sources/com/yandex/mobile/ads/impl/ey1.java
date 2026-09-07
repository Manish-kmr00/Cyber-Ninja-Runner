package com.yandex.mobile.ads.impl;

import android.os.ConditionVariable;

/* JADX INFO: loaded from: classes5.dex */
final class ey1 extends Thread {
    final /* synthetic */ ConditionVariable b;
    final /* synthetic */ fy1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ey1(fy1 fy1Var, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.c = fy1Var;
        this.b = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.c) {
            this.b.open();
            this.c.b();
            this.c.b.getClass();
        }
    }
}
