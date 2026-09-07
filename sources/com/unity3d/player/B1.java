package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class B1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E1 f8206a;

    B1(E1 e1) {
        this.f8206a = e1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8206a.destroyPlayer();
        this.f8206a.a(3);
    }
}
