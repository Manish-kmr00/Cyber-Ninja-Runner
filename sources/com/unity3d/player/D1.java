package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
public final class D1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private E1 f8212a;
    private boolean b = false;

    public D1(E1 e1) {
        this.f8212a = e1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.b) {
            return;
        }
        int i = E1.A;
        this.f8212a.cancelOnPrepare();
    }
}
