package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SG {
    public RW A03;
    public boolean A04;
    public boolean A05;
    public RN A02 = RN.A04;
    public int A01 = 0;
    public SF A00 = SF.A00;

    public final SG A05(RN rn) {
        AbstractC2388es.A01(rn);
        this.A02 = rn;
        return this;
    }

    public final SG A06(RW rw) {
        AbstractC2388es.A01(rw);
        this.A03 = rw;
        return this;
    }

    public final SG A07(RV[] rvArr) {
        AbstractC2388es.A01(rvArr);
        return A06(new CX(rvArr));
    }
}
