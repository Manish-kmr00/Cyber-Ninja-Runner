package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class KU extends AbstractC2206bv {
    public final /* synthetic */ C2189be A00;

    public KU(C2189be c2189be) {
        this.A00 = c2189be;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2207bw c2207bw) {
        if (!this.A00.A03 || !this.A00.A02) {
            return;
        }
        this.A00.A03 = false;
        if (!this.A00.A0D(EnumC1668Ip.A03) && !this.A00.A04) {
            if (!this.A00.A0D(EnumC1668Ip.A02)) {
                return;
            }
            this.A00.A03();
            this.A00.A06(true, true);
            return;
        }
        this.A00.A04 = false;
        this.A00.A05.postDelayed(new C2192bh(this), this.A00.A00);
    }
}
