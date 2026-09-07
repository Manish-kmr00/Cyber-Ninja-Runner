package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4207j5 extends AbstractC4183i5 {
    public C4207j5(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4183i5
    public final boolean b(int i) {
        return i < 113;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4183i5
    public final void c() {
        Le le = this.f11595a.c;
        try {
            C4596yk c4596yk = new C4596yk(le, J2.g);
            Long lA = c4596yk.c.a(C4596yk.d);
            if (lA != null) {
                c4596yk.a(C4596yk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(lA.longValue())));
            }
            Long lA2 = c4596yk.c.a(C4596yk.e);
            if (lA2 != null) {
                c4596yk.a(C4596yk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(lA2.longValue())));
            }
        } catch (Throwable unused) {
        }
        try {
            C4596yk c4596yk2 = new C4596yk(le, "foreground");
            Long lA3 = c4596yk2.c.a(C4596yk.d);
            if (lA3 != null) {
                c4596yk2.a(C4596yk.d, Long.valueOf(TimeUnit.SECONDS.toMillis(lA3.longValue())));
            }
            Long lA4 = c4596yk2.c.a(C4596yk.e);
            if (lA4 != null) {
                c4596yk2.a(C4596yk.e, Long.valueOf(TimeUnit.SECONDS.toMillis(lA4.longValue())));
            }
        } catch (Throwable unused2) {
        }
    }
}
