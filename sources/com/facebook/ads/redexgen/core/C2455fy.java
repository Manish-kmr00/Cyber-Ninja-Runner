package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2455fy extends BY {
    public final /* synthetic */ C2451fu A00;

    public C2455fy(C2451fu c2451fu) {
        this.A00 = c2451fu;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        if (!this.A00.A0d) {
            D3.A0D(1000, this.A00.A0N);
        }
        this.A00.postDelayed(this, 2000L);
    }
}
