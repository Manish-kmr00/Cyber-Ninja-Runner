package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class RunnableC3789c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f8270a;
    final /* synthetic */ UnityPlayerForActivityOrService b;

    RunnableC3789c1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        this.b = unityPlayerForActivityOrService;
        this.f8270a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U u = this.b.mSoftInput;
        if (u != null) {
            u.a(this.f8270a);
        }
    }
}
