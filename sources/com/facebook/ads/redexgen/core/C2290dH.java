package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2290dH {
    public final int A00;
    public final Y4 A01;
    public final Object A02;
    public final C1857Ql[] A03;
    public final QD[] A04;

    public C2290dH(C1857Ql[] c1857QlArr, QD[] qdArr, Y4 y4, Object obj) {
        this.A03 = c1857QlArr;
        this.A04 = (QD[]) qdArr.clone();
        this.A01 = y4;
        this.A02 = obj;
        this.A00 = c1857QlArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(C2290dH c2290dH, int i) {
        return c2290dH != null && AbstractC2471gE.A1E(this.A03[i], c2290dH.A03[i]) && AbstractC2471gE.A1E(this.A04[i], c2290dH.A04[i]);
    }
}
