package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class J1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M1 f8227a;

    J1(M1 m1) {
        this.f8227a = m1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M1 m1 = this.f8227a;
        E1 e1 = m1.f;
        if (e1 != null) {
            m1.f8235a.addViewToPlayer(e1, true);
            M1 m2 = this.f8227a;
            m2.i = true;
            m2.f.requestFocus();
        }
    }
}
