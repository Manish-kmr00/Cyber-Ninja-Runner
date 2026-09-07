package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.unity3d.player.k1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
final class RunnableC3813k1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f8286a;
    final /* synthetic */ UnityPlayerForActivityOrService b;

    RunnableC3813k1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore) {
        this.b = unityPlayerForActivityOrService;
        this.f8286a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.shutdown();
        this.f8286a.release();
    }
}
