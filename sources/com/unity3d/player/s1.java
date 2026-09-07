package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
final class s1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f8303a;
    final /* synthetic */ UnityPlayerForActivityOrService b;

    s1(UnityPlayerForActivityOrService unityPlayerForActivityOrService, float f) {
        this.b = unityPlayerForActivityOrService;
        this.f8303a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 view = this.b.getView();
        if (view != null) {
            view.a(this.f8303a);
        }
    }
}
