package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2840mN implements InterfaceC13987l {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z);

    public AbstractC2840mN(boolean z) {
        this.A00 = z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACa() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACj() {
        A01(true);
    }
}
