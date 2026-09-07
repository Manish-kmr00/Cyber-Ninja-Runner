package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class KW extends AbstractC2208bx {
    public final /* synthetic */ C2189be A00;

    public KW(C2189be c2189be) {
        this.A00 = c2189be;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(KY ky) {
        this.A00.A05.removeCallbacksAndMessages(null);
        if (this.A00.A0D(EnumC1668Ip.A04)) {
            this.A00.A03();
            this.A00.A06(true, false);
        }
        this.A00.A03 = true;
    }
}
