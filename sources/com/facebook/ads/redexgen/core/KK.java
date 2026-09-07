package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class KK extends AbstractC2197bm {
    public final /* synthetic */ C2182bX A00;

    public KK(C2182bX c2182bX) {
        this.A00 = c2182bX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2198bn c2198bn) {
        if (this.A00.A01 == null || c2198bn.A00().getAction() != 0) {
            return;
        }
        this.A00.A04.removeCallbacksAndMessages(null);
        this.A00.A07(new C1656Id(this));
    }
}
