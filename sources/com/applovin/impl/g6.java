package com.applovin.impl;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class g6 extends g5 {
    private final WeakReference g;
    private final Object h;

    protected g6(q4 q4Var, Object obj, String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
        this.g = new WeakReference(q4Var);
        this.h = obj;
    }

    public static void a(long j, q4 q4Var, Object obj, String str, com.applovin.impl.sdk.k kVar) {
        if (j <= 0) {
            return;
        }
        kVar.r0().a(new g6(q4Var, obj, str, kVar), b6.b.TIMEOUT, j);
    }

    @Override // java.lang.Runnable
    public void run() {
        q4 q4Var = (q4) this.g.get();
        if (q4Var == null || q4Var.c()) {
            return;
        }
        this.f424a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f424a.O().d(this.b, "Attempting to timeout pending task " + q4Var.b() + " with " + this.h);
        }
        q4Var.a(this.h);
    }
}
