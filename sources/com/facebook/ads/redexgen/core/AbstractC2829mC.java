package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2829mC implements C2I {
    public C2615ie A00;

    public final void A00(C2615ie c2615ie) {
        this.A00 = c2615ie;
    }

    @Override // com.facebook.ads.redexgen.core.C2I
    public final void AEA(C2873mv c2873mv) {
        if (this.A00 != null && this.A00.A16() != null) {
            this.A00.A16().AC6();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C2I
    public final void AEC(C2873mv c2873mv) {
    }

    @Override // com.facebook.ads.redexgen.core.C2I
    public final void AEE(C2873mv c2873mv, C1468Ag c1468Ag) {
    }
}
