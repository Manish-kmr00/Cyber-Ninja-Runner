package com.unity3d.player;

/* JADX INFO: loaded from: classes5.dex */
final class p1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForActivityOrService f8295a;

    p1(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8295a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.f8295a;
        if (unityPlayerForActivityOrService.mMainDisplayOverride) {
            unityPlayerForActivityOrService.getFrameLayout().removeView(this.f8295a.getView());
        } else if (unityPlayerForActivityOrService.getView().getParent() == null) {
            this.f8295a.getFrameLayout().addView(this.f8295a.getView());
        } else {
            B.Log(5, "Couldn't add view, because it's already assigned to another parent");
        }
    }
}
