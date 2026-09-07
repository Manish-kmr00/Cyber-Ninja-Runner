package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class K1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M1 f8230a;

    K1(M1 m1) {
        this.f8230a = m1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M1 m1 = this.f8230a;
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
        this.f8230a.f8235a.onResume();
    }
}
