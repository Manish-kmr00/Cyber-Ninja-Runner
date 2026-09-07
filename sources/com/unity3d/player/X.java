package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class X implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Z f8256a;

    X(Z z) {
        this.f8256a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8256a.c.requestFocus();
        this.f8256a.e();
    }
}
