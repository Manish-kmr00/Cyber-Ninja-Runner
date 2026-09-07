package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2644j8 extends BY {
    public final /* synthetic */ C2642j6 A00;

    public C2644j8(C2642j6 c2642j6) {
        this.A00 = c2642j6;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() throws Exception {
        C2642j6.A00(this.A00);
        if (this.A00.A01 > 0) {
            try {
                Thread.sleep(this.A00.A01);
            } catch (InterruptedException unused) {
            }
        }
        this.A00.A0B();
    }
}
