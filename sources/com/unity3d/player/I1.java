package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class I1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M1 f8224a;

    I1(M1 m1) {
        this.f8224a = m1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8224a.f8235a.onPause();
    }
}
