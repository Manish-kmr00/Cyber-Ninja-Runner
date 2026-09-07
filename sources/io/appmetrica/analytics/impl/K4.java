package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class K4 extends AbstractC4614zd {
    public final Object f;

    public K4(int i, String str, Object obj, Pn pn, U2 u2) {
        super(i, str, pn, u2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4614zd, io.appmetrica.analytics.impl.Bn
    public final void a(An an) {
        if (f()) {
            U2 u2 = this.d;
            int i = this.b;
            Cn cnA = u2.a(an, (Cn) ((HashMap) an.f11064a.get(i)).get(this.f11875a), this);
            if (cnA != null) {
                a(cnA);
            }
        }
    }

    public abstract void a(Cn cn);

    public final Object g() {
        return this.f;
    }
}
