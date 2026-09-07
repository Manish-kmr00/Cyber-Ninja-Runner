package com.unity3d.player;

/* JADX INFO: loaded from: classes5.dex */
final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8298a;

    q1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8298a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8298a.nativeResume();
    }
}
