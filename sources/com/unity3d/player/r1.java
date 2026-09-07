package com.unity3d.player;

/* JADX INFO: loaded from: classes5.dex */
final class r1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8300a;

    r1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8300a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 view = this.f8300a.getView();
        if (view != null) {
            view.b();
        }
    }
}
