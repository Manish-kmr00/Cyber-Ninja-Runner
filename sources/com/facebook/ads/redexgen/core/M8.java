package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class M8 extends AbstractC2212c1 {
    public final /* synthetic */ C13826v A00;

    public M8(C13826v c13826v) {
        this.A00 = c13826v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C2213c2 c2213c2) {
        if (this.A00.A08 != null) {
            C2615ie.A0L(this.A00.A08.getInternalNativeAd()).A1f(false, true);
        }
        this.A00.A00.onError();
    }
}
