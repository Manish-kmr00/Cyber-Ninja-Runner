package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2845mT implements InterfaceC13987l {
    public final /* synthetic */ AbstractC2855md A00;
    public final /* synthetic */ InterfaceC12802u A01;
    public final /* synthetic */ C12812v A02;
    public final /* synthetic */ C2699k1 A03;
    public final /* synthetic */ boolean A04;

    public C2845mT(C12812v c12812v, C2699k1 c2699k1, boolean z, AbstractC2855md abstractC2855md, InterfaceC12802u interfaceC12802u) {
        this.A02 = c12812v;
        this.A03 = c2699k1;
        this.A04 = z;
        this.A00 = abstractC2855md;
        this.A01 = interfaceC12802u;
    }

    private void A00(boolean z) {
        if (z) {
            if (C14499m.A1j(this.A03) && this.A04) {
                this.A02.A02.add(AbstractC1619Gs.A01(this.A03, this.A00, 1, new C2846mU(this)));
                return;
            } else {
                this.A01.AC9();
                return;
            }
        }
        this.A01.AC8(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACa() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACj() {
        A00(true);
    }
}
