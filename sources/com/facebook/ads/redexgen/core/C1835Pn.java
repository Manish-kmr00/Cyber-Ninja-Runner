package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1835Pn implements InterfaceC2308dZ {
    public final InterfaceC2357eN A00;

    public C1835Pn() {
        this(null);
    }

    public C1835Pn(InterfaceC2357eN interfaceC2357eN) {
        this.A00 = interfaceC2357eN;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2308dZ
    public final Q7 A58() {
        C12230o c12230o = new C12230o();
        if (this.A00 != null) {
            c12230o.A3t(this.A00);
        }
        return c12230o;
    }
}
