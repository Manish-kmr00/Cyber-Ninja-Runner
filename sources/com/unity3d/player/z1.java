package com.unity3d.player;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
final class z1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForGameActivity f8319a;

    z1(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f8319a = unityPlayerForGameActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f8319a;
        M m = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        L l = m.b;
        if (l != null && l.getParent() != null) {
            frameLayout.removeView(m.b);
        }
        this.f8319a.m_PersistentUnitySurface.b = null;
    }
}
