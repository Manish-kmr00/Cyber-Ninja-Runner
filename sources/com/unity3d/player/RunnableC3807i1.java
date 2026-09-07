package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.i1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class RunnableC3807i1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8281a;

    RunnableC3807i1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8281a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8281a.destroy();
    }
}
