package com.unity3d.player;

/* JADX INFO: loaded from: classes9.dex */
public abstract class V0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8254a;

    protected V0(UnityPlayer unityPlayer) {
        this.f8254a = unityPlayer;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f8254a.isFinishing()) {
            return;
        }
        a();
    }
}
