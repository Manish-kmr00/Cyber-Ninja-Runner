package com.unity3d.player;

import android.app.Activity;

/* JADX INFO: loaded from: classes9.dex */
final class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f8239a;

    O0(UnityPlayer unityPlayer) {
        this.f8239a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        Activity activity;
        if (!this.f8239a.nativeIsAutorotationOn() || (activity = (unityPlayer = this.f8239a).mActivity) == null) {
            return;
        }
        activity.setRequestedOrientation(unityPlayer.mInitialScreenOrientation);
    }
}
