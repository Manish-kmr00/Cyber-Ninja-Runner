package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2588iC implements InterfaceC1506Cj {
    public int A00;
    public final InterfaceC1506Cj A01;
    public final InterfaceC1506Cj A02;

    public C2588iC(InterfaceC1506Cj interfaceC1506Cj, int i, InterfaceC1506Cj interfaceC1506Cj2) {
        this.A01 = interfaceC1506Cj;
        this.A00 = i;
        this.A02 = interfaceC1506Cj2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void AGG(String str) {
        if (this.A00 > 0) {
            this.A01.AGG(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AGG(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void flush() {
        this.A02.flush();
    }
}
