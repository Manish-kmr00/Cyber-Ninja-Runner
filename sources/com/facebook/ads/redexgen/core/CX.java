package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class CX implements RW {
    public final C3 A00;
    public final XF A01;
    public final RV[] A02;

    public CX(RV... rvArr) {
        this(rvArr, new C3(), new XF());
    }

    public CX(RV[] rvArr, C3 c3, XF xf) {
        this.A02 = new RV[rvArr.length + 2];
        System.arraycopy(rvArr, 0, this.A02, 0, rvArr.length);
        this.A00 = c3;
        this.A01 = xf;
        this.A02[rvArr.length] = c3;
        this.A02[rvArr.length + 1] = xf;
    }

    @Override // com.facebook.ads.redexgen.core.RW
    public final C2064Yv A45(C2064Yv c2064Yv) {
        this.A01.A02(c2064Yv.A01);
        this.A01.A01(c2064Yv.A00);
        return c2064Yv;
    }

    @Override // com.facebook.ads.redexgen.core.RW
    public final boolean A46(boolean z) {
        this.A00.A0D(z);
        return z;
    }

    @Override // com.facebook.ads.redexgen.core.RW
    public final RV[] A6p() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.RW
    public final long A8K(long j) {
        return this.A01.A00(j);
    }

    @Override // com.facebook.ads.redexgen.core.RW
    public final long A8y() {
        return this.A00.A0C();
    }
}
