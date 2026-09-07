package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5K implements InterfaceC2308dZ {
    public InterfaceC2357eN A02;
    public InterfaceC2590iE<String> A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final C2328du A07 = new C2328du();
    public int A00 = 8000;
    public int A01 = 8000;

    public final C5K A00(InterfaceC2357eN interfaceC2357eN) {
        this.A02 = interfaceC2357eN;
        return this;
    }

    public final C5K A01(String str) {
        this.A04 = str;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2308dZ
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C12240p A58() {
        C12240p c12240p = new C12240p(this.A04, this.A00, this.A01, this.A05, this.A07, this.A03, this.A06);
        if (this.A02 != null) {
            c12240p.A3t(this.A02);
        }
        return c12240p;
    }
}
