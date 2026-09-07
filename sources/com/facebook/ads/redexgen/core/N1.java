package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class N1 extends AbstractC2840mN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ N0 A01;
    public final /* synthetic */ C2853mb A02;
    public final /* synthetic */ C1769Mu A03;
    public final /* synthetic */ C2699k1 A04;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N1(N0 n0, boolean z, C2699k1 c2699k1, C1769Mu c1769Mu, C2853mb c2853mb, int i) {
        super(z);
        this.A01 = n0;
        this.A04 = c2699k1;
        this.A03 = c1769Mu;
        this.A02 = c2853mb;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2840mN
    public final void A00() {
        this.A01.A01.AEz(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2840mN
    public final void A01(boolean z) {
        N0.A0D = null;
        if (z) {
            this.A04.A01().AIK(this.A03.A1g(), this.A02.A1a());
        }
        if (this.A00 == 0) {
            this.A01.A0C.set(true);
            this.A01.A01.AEw(this.A01);
        }
        this.A01.A0C(this.A04, this.A02, this.A00 + 1);
    }
}
