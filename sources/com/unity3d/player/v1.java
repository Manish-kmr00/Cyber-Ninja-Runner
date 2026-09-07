package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes4.dex */
final class v1 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayerForGameActivity f8311a;

    v1(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f8311a = unityPlayerForGameActivity;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f8311a;
        M m = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        L l = m.b;
        if (l == null || l.getParent() != null) {
            return;
        }
        frameLayout.addView(m.b);
        frameLayout.bringChildToFront(m.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f8311a;
        M m = unityPlayerForGameActivity.m_PersistentUnitySurface;
        SurfaceView surfaceView = unityPlayerForGameActivity.m_SurfaceView;
        m.getClass();
        if (!PlatformSupport.NOUGAT_SUPPORT || m.f8233a == null) {
            return;
        }
        if (m.b == null) {
            m.b = new L(m, m.f8233a);
        }
        m.b.a(surfaceView);
    }
}
