package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2857mf implements FA {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractC2856me A01;
    public final /* synthetic */ C2615ie A02;

    public C2857mf(AbstractC2856me abstractC2856me, int i, C2615ie c2615ie) {
        this.A01 = abstractC2856me;
        this.A00 = i;
        this.A02 = c2615ie;
    }

    @Override // com.facebook.ads.redexgen.core.FA
    public final void ADM(boolean z) {
        if (this.A00 == 0) {
            this.A02.A1c(this.A01.A04);
        }
        this.A02.A1f(z, true);
    }
}
