package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class KM extends AbstractC2206bv {
    public final /* synthetic */ C2182bX A00;

    public KM(C2182bX c2182bX) {
        this.A00 = c2182bX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2207bw c2207bw) {
        if (!this.A00.A03) {
            return;
        }
        if (this.A00.A02 == EnumC1658If.A02 || this.A00.A09) {
            this.A00.A02 = null;
            this.A00.A05();
        } else {
            this.A00.A06(0, 8);
        }
    }
}
