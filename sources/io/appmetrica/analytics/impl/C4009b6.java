package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4009b6 extends K4 {
    public C4009b6(String str, double d) {
        super(2, str, Double.valueOf(d), new C4512vb(), new J4(new Lb(new D4(100))));
    }

    @Override // io.appmetrica.analytics.impl.K4
    public final void a(Cn cn) {
        En en = cn.d;
        en.c = ((Double) this.f).doubleValue() + en.c;
    }
}
