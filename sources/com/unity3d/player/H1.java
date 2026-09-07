package com.unity3d.player;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
final class H1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8220a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ long f;
    final /* synthetic */ long g;
    final /* synthetic */ M1 h;

    H1(M1 m1, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        this.h = m1;
        this.f8220a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = j;
        this.g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M1 m1 = this.h;
        if (m1.f != null) {
            B.Log(5, "Video already playing");
            M1 m2 = this.h;
            m2.g = 2;
            m2.d.release();
            return;
        }
        M1 m3 = this.h;
        m1.f = new E1(m3.b, m3.f8235a, this.f8220a, this.b, this.c, this.d, this.e, this.f, this.g, new G1(this));
        M1 m4 = this.h;
        if (m4.f != null) {
            FrameLayout frameLayout = m4.f8235a.getFrameLayout();
            frameLayout.bringToFront();
            frameLayout.addView(this.h.f);
        }
    }
}
