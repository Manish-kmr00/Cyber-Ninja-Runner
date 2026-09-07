package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ku, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1725Ku extends AbstractC2203bs {
    public final /* synthetic */ C1722Kr A00;

    public C1725Ku(C1722Kr c1722Kr) {
        this.A00 = c1722Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(KX kx) {
        this.A00.A0e(kx);
        this.A00.A0Y.ADB((this.A00.A01 * this.A00.A0a.getDuration()) + kx.A00());
    }
}
