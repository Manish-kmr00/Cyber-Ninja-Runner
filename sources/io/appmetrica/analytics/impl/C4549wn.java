package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.wn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4549wn extends R4 {
    public final L6 b;

    public C4549wn(O4 o4, L6 l6) {
        super(o4);
        this.b = l6;
    }

    @Override // io.appmetrica.analytics.impl.R4
    public final boolean a(C3984a6 c3984a6, L4 l4) {
        F4 f4 = l4.b.d.f11752a;
        this.b.a(f4.i);
        Pb pbL = C4486ua.E.l();
        if (Boolean.TRUE.equals(f4.b)) {
            pbL.a(true);
        } else {
            if (Boolean.FALSE.equals(f4.b)) {
                pbL.a(false);
            }
        }
        pbL.a(f4.c);
        Boolean bool = f4.n;
        C4486ua.E.b().b(bool != null ? bool.booleanValue() : true);
        return false;
    }
}
