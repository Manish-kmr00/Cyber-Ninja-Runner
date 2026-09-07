package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TZ implements Uj {
    public final /* synthetic */ TY A00;

    public TZ(TY ty) {
        this.A00 = ty;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A00.A0B.A0C(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        long jA0D = this.A00.A0B.A0D(j);
        long j2 = this.A00.A09;
        long j3 = this.A00.A08;
        long targetGranule = this.A00.A09;
        long j4 = (j3 - targetGranule) * jA0D;
        long targetGranule2 = this.A00.A07;
        long estimatedPosition = AbstractC2471gE.A0T((j2 + (j4 / targetGranule2)) - 30000, this.A00.A09, this.A00.A08 - 1);
        return new C1953Ui(new C1954Uk(j, estimatedPosition));
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }
}
