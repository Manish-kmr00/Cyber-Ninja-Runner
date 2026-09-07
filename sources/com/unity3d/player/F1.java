package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class F1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ G1 f8217a;

    F1(G1 g1) {
        this.f8217a = g1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M1 m1 = this.f8217a.f8219a.h;
        E1 e1 = m1.f;
        if (e1 != null) {
            m1.f8235a.removeViewFromPlayer(e1);
            m1.i = false;
            m1.f.destroyPlayer();
            m1.f = null;
            L1 l1 = m1.c;
            if (l1 != null) {
                ((N0) l1).a();
            }
        }
        this.f8217a.f8219a.h.f8235a.onResume();
    }
}
