package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
final class wm implements Runnable {
    final /* synthetic */ np1 b;
    final /* synthetic */ xm c;

    wm(xm xmVar, np1 np1Var) {
        this.c = xmVar;
        this.b = np1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.c.put(this.b);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
