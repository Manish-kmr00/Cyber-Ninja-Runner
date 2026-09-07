package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes2.dex */
public class e1 implements Runnable {
    public final d1 b;
    public final boolean c;

    public e1(d1 d1Var, boolean z, int i) {
        this.b = d1Var;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.c);
    }
}
