package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2237cQ implements IG {
    public final C2699k1 A00;
    public final A7 A01;
    public final ID A02;
    public final C2232cL A03;
    public final String A06;
    public final AbstractC2208bx A05 = new C1710Kf(this);
    public final AbstractC2214c3 A04 = new C1709Ke(this);

    public C2237cQ(C2699k1 c2699k1, A7 a7, C2232cL c2232cL, String str, C2219c8 c2219c8, Map<String, String> extraParams) {
        this.A00 = c2699k1;
        this.A01 = a7;
        this.A06 = str;
        this.A03 = c2232cL;
        this.A02 = new ID(c2232cL, str, extraParams);
        if (C14499m.A23(this.A00)) {
            this.A00.A0F().AI3();
            c2219c8.A0m(this);
        } else {
            this.A00.A0F().AI4();
            this.A03.getEventBus().A03(this.A05, this.A04);
        }
    }

    public final void A05() {
        C2238cR c2238cR = new C2238cR(this);
        if (this.A03.A0s()) {
            ExecutorC1520Cx.A00(c2238cR);
        } else {
            this.A03.getStateHandler().post(c2238cR);
        }
    }

    public final synchronized void A06() {
        this.A01.ABL(this.A06, this.A02.A05());
    }

    @Override // com.facebook.ads.redexgen.core.IG
    public final void ADy() {
        this.A00.A0F().AI7();
        A06();
    }
}
