package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2348eE implements DP {
    public final /* synthetic */ AbstractC2347eD A00;

    public C2348eE(AbstractC2347eD abstractC2347eD) {
        this.A00 = abstractC2347eD;
    }

    @Override // com.facebook.ads.redexgen.core.DP
    public final void AC5(DQ dq) {
        if (dq.getToolbarActionMode() == 8) {
            this.A00.A0b();
            return;
        }
        this.A00.A06.A04(AE.A07, null);
        if (this.A00.A0f()) {
            return;
        }
        this.A00.A09.A4Z(this.A00.A0A.A7m());
    }
}
