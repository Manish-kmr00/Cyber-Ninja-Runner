package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class G0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8218a;
    final /* synthetic */ UnityPlayer b;

    G0(UnityPlayer unityPlayer, int i) {
        this.b = unityPlayer;
        this.f8218a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityPlayer unityPlayer = this.b;
            AbstractC3787c.a(unityPlayer.mActivity, unityPlayer.getFrameLayout(), this.f8218a);
        } catch (Exception e) {
            B.Log(6, "Exception when opening Activity Indicator " + e);
        }
    }
}
