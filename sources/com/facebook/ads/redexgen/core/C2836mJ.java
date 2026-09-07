package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2836mJ extends BY {
    public final /* synthetic */ AbstractC2835mI A00;
    public final /* synthetic */ C1468Ag A01;

    public C2836mJ(AbstractC2835mI abstractC2835mI, C1468Ag c1468Ag) {
        this.A00 = abstractC2835mI;
        this.A01 = c1468Ag;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        this.A00.A0B.A0F().A5W(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
