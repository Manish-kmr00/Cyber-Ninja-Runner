package com.unity3d.player;

/* JADX INFO: loaded from: classes12.dex */
final class G1 implements C1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H1 f8219a;

    G1(H1 h1) {
        this.f8219a = h1;
    }

    public final void a(int i) {
        this.f8219a.h.e.lock();
        M1 m1 = this.f8219a.h;
        m1.g = i;
        if (i == 3 && m1.i) {
            m1.runOnUiThread(new F1(this));
        }
        if (i != 0) {
            this.f8219a.h.d.release();
        }
        this.f8219a.h.e.unlock();
    }
}
