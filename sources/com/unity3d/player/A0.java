package com.unity3d.player;

import android.view.SurfaceHolder;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
final class A0 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ B0 f8201a;

    A0(B0 b0) {
        this.f8201a = b0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f8201a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.f8201a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f8201a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        B0 b0 = this.f8201a;
        M m = b0.c;
        FrameLayout frameLayout = b0.b.getFrameLayout();
        L l = m.b;
        if (l == null || l.getParent() != null) {
            return;
        }
        frameLayout.addView(m.b);
        frameLayout.bringChildToFront(m.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        B0 b0 = this.f8201a;
        M m = b0.c;
        C3796f c3796f = b0.f8205a;
        m.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && m.f8233a != null) {
            if (m.b == null) {
                m.b = new L(m, m.f8233a);
            }
            m.b.a(c3796f);
        }
        this.f8201a.b.updateGLDisplay(0, null);
    }
}
