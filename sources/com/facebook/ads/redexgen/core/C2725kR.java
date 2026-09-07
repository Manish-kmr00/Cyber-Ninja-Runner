package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2725kR extends BL {
    public final /* synthetic */ C2722kO A00;
    public final /* synthetic */ C1468Ag A01;

    public C2725kR(C2722kO c2722kO, C1468Ag c1468Ag) {
        this.A00 = c2722kO;
        this.A01 = c1468Ag;
    }

    @Override // com.facebook.ads.redexgen.core.BL
    public final void A01() {
        if (this.A00.A00.A00() != null) {
            this.A00.A00.A00().onAdError(C8.A00(this.A01));
        }
    }
}
