package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1712Kh extends AbstractC2499gh {
    public final /* synthetic */ C1641Ho A00;

    public C1712Kh(C1641Ho c1641Ho) {
        this.A00 = c1641Ho;
    }

    @Override // com.facebook.ads.redexgen.core.F4
    public final void ACH() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2499gh, com.facebook.ads.redexgen.core.F4
    public final void AD9(int i, String str) {
        this.A00.A0B.set(true);
        if (this.A00.A02 != null) {
            this.A00.A02.ADv();
        }
    }

    @Override // com.facebook.ads.redexgen.core.F4
    public final void ADP() {
        if (!this.A00.A0B.get() && this.A00.A0A.compareAndSet(false, true) && this.A00.A02 != null) {
            this.A00.A02.ADP();
        }
    }

    @Override // com.facebook.ads.redexgen.core.F4
    public final void AFo() {
        if (this.A00.A02 != null) {
            this.A00.A02.AFo();
        }
    }
}
