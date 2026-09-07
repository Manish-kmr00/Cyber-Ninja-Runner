package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class r7 implements Runnable {
    private ah0 b;

    @Override // java.lang.Runnable
    public final void run() {
        ah0 ah0Var = this.b;
        if (ah0Var != null) {
            ah0Var.a(w7.l());
        }
    }

    public final void a(ah0 ah0Var) {
        this.b = ah0Var;
    }
}
