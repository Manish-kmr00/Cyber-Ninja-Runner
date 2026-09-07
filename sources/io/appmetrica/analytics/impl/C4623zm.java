package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4623zm extends K4 {
    public final InterfaceC4200in g;

    public C4623zm(String str, String str2, InterfaceC4200in interfaceC4200in, Pn pn, U2 u2) {
        super(0, str, str2, pn, u2);
        this.g = interfaceC4200in;
    }

    @Override // io.appmetrica.analytics.impl.K4
    public final void a(Cn cn) {
        String str = (String) this.g.a((String) this.f);
        cn.d.f11129a = str == null ? new byte[0] : str.getBytes();
    }

    public final InterfaceC4200in h() {
        return this.g;
    }
}
