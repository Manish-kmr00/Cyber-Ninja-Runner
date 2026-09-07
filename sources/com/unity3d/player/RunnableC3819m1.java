package com.unity3d.player;

import android.content.res.Configuration;

/* JADX INFO: renamed from: com.unity3d.player.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
final class RunnableC3819m1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Configuration f8290a;
    final /* synthetic */ UnityPlayerForActivityOrService b;

    RunnableC3819m1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Configuration configuration) {
        this.b = unityPlayerForActivityOrService;
        this.f8290a = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.nativeConfigurationChanged(this.f8290a);
    }
}
