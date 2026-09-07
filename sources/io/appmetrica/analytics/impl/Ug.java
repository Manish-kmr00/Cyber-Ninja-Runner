package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class Ug extends Gg {
    public Ug(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        C4173hk c4173hkB;
        C4571xk c4571xk;
        C4386q9 c4386q9 = this.f11164a.n;
        C4521vk c4521vk = c4386q9.c;
        if (c4521vk.g == 0) {
            c4173hkB = c4521vk.d.b();
            if (c4173hkB != null && c4173hkB.a(c3984a6.i) && (c4173hkB = c4521vk.e.b()) != null && c4173hkB.a(c3984a6.i)) {
                c4173hkB = null;
            }
        } else {
            c4173hkB = c4521vk.f;
        }
        if (c4173hkB != null) {
            c4571xk = new C4571xk();
            c4571xk.f11847a = c4173hkB.d;
            long andIncrement = c4173hkB.f.getAndIncrement();
            C4596yk c4596yk = c4173hkB.b;
            c4596yk.a(C4596yk.g, Long.valueOf(c4173hkB.f.get()));
            c4596yk.b();
            c4571xk.b = andIncrement;
            c4571xk.c = TimeUnit.MILLISECONDS.toSeconds(c4173hkB.j);
            c4571xk.d = c4173hkB.c.f11639a;
        } else {
            long j = c3984a6.j;
            long jA = c4521vk.b.a();
            S6 s6 = c4521vk.f11819a.e;
            EnumC4621zk enumC4621zk = EnumC4621zk.BACKGROUND;
            s6.a(jA, enumC4621zk, j);
            C4571xk c4571xk2 = new C4571xk();
            c4571xk2.f11847a = jA;
            c4571xk2.d = enumC4621zk;
            c4571xk2.b = 0L;
            c4571xk2.c = 0L;
            c4571xk = c4571xk2;
        }
        c4386q9.a(c3984a6, c4571xk);
        return true;
    }
}
