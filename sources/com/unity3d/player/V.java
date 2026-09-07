package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ W f8253a;

    V(W w) {
        this.f8253a = w;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U u = this.f8253a.d;
        u.a(u.a(), true);
    }
}
