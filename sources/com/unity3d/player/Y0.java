package com.unity3d.player;

/* JADX INFO: loaded from: classes8.dex */
final class Y0 implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Z0 f8259a;

    Y0(Z0 z0) {
        this.f8259a = z0;
    }

    public final void a() {
        Z0 z0 = this.f8259a;
        z0.f8260a = true;
        if (z0.b) {
            z0.c.release();
        }
    }
}
