package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class K0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8229a;

    K0(UnityPlayer unityPlayer) {
        this.f8229a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8229a.getFrameLayout().removeView(this.f8229a.m_SplashScreen);
        this.f8229a.m_SplashScreen = null;
    }
}
