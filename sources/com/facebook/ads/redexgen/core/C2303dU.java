package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2303dU implements HU {
    public final /* synthetic */ EC A00;
    public final /* synthetic */ C2302dT A01;
    public final /* synthetic */ C1641Ho A02;

    public C2303dU(C2302dT c2302dT, C1641Ho c1641Ho, EC ec) {
        this.A01 = c2302dT;
        this.A02 = c1641Ho;
        this.A00 = ec;
    }

    @Override // com.facebook.ads.redexgen.core.HU
    public final void AHe() {
        this.A01.A09();
        this.A01.A03 = this.A01.A05(this.A02, this.A00);
        if (this.A01.A01 != null && this.A01.A00 != null) {
            this.A01.A03.AAj(this.A01.A01, this.A01.A02, this.A01.A00);
        }
    }
}
