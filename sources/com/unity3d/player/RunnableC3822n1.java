package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
final class RunnableC3822n1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8292a;

    RunnableC3822n1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8292a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8292a.nativeSendSurfaceChangedEvent();
    }
}
