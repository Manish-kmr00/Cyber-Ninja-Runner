package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.w0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class RunnableC3840w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3844y0 f8313a;

    RunnableC3840w0(C3844y0 c3844y0) {
        this.f8313a = c3844y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8313a.f8316a.getView().requestPointerCapture();
    }
}
