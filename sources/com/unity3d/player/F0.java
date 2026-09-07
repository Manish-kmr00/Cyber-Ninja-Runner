package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class F0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8216a;

    F0(UnityPlayer unityPlayer) {
        this.f8216a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8216a.setupUnityToBePaused();
        this.f8216a.windowFocusChanged(false);
        this.f8216a.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
