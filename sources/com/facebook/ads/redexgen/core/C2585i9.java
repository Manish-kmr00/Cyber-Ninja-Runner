package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2585i9 implements InterfaceC1506Cj {
    public int A00;
    public final InterfaceC1506Cj A01;

    public C2585i9(InterfaceC1506Cj interfaceC1506Cj, int i) {
        this.A01 = interfaceC1506Cj;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void AGG(String str) {
        if (this.A00 > 0) {
            this.A01.AGG(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1506Cj
    public final void flush() {
        this.A01.flush();
    }
}
