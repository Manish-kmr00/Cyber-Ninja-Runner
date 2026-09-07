package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C3844y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayer f8316a;

    public C3844y0(UnityPlayer unityPlayer) {
        this.f8316a = unityPlayer;
    }

    final void a() {
        if (PlatformSupport.OREO_SUPPORT) {
            this.f8316a.runOnUiThread(new RunnableC3842x0(this));
        }
    }

    final void b() {
        if (PlatformSupport.OREO_SUPPORT) {
            this.f8316a.runOnUiThread(new RunnableC3840w0(this));
        }
    }
}
