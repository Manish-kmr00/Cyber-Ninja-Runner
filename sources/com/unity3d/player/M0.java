package com.unity3d.player;

/* JADX INFO: loaded from: classes9.dex */
final class M0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8234a;

    M0(String str) {
        this.f8234a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer.nativeSetLaunchURL(this.f8234a);
    }
}
