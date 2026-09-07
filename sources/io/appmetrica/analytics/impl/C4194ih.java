package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ih, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4194ih extends Gg {
    public C4194ih(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        ((C4556x5) this.f11164a.p).d();
        C4521vk c4521vk = this.f11164a.j;
        synchronized (c4521vk) {
            C4173hk c4173hkB = c4521vk.b(c3984a6);
            if (c4173hkB.g) {
                c4173hkB.g = false;
                C4596yk c4596yk = c4173hkB.b;
                c4596yk.a(C4596yk.i, Boolean.FALSE);
                c4596yk.b();
            }
            if (c4521vk.g != 1) {
                c4521vk.a(c4521vk.f, c3984a6);
            }
            c4521vk.g = 1;
        }
        return false;
    }
}
