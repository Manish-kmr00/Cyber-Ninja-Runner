package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2584i7 implements InterfaceC1506Cj {
    public final C1505Ci A00;
    public final InterfaceC1506Cj A01;

    public C2584i7(InterfaceC1506Cj interfaceC1506Cj, int i, int i2) {
        this.A01 = interfaceC1506Cj;
        this.A00 = new C1505Ci(i, i2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void AGG(String str) {
        this.A00.A04(str);
        if (this.A00.A02() != null && AbstractC1508Cl.A08(this.A00)) {
            this.A01.AGG(this.A00.A02());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void flush() {
        this.A00.A03();
        while (this.A00.A02() != null) {
            if (AbstractC1508Cl.A08(this.A00)) {
                this.A01.AGG(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
