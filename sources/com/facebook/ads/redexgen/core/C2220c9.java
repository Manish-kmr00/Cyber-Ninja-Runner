package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2220c9 extends AbstractC12893d {
    public final /* synthetic */ C2219c8 A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2220c9(C2219c8 c2219c8, double d, double d2, double d3, boolean z) {
        super(d, d2, d3, z);
        this.A00 = c2219c8;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC12893d
    public final void A00(boolean z, boolean z2, C12913f c12913f) {
        if ((!C14499m.A0y(this.A00.A0D) || !this.A00.A0A) && z2) {
            this.A00.A0A = true;
            this.A00.A0R(this.A00.A0J, this.A00.A0J(IH.A0B));
        }
    }
}
