package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1887Rq implements Uj {
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final YZ A04;

    public C1887Rq(YZ yz, int i, long j, long j2) {
        this.A04 = yz;
        this.A00 = i;
        this.A03 = j;
        this.A01 = (j2 - j) / ((long) yz.A02);
        this.A02 = A00(this.A01);
    }

    private long A00(long j) {
        return AbstractC2471gE.A0U(j * ((long) this.A00), 1000000L, this.A04.A04);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        long jA0T = AbstractC2471gE.A0T((((long) this.A04.A04) * j) / (((long) this.A00) * 1000000), 0L, this.A01 - 1);
        long j2 = this.A03 + (((long) this.A04.A02) * jA0T);
        long jA00 = A00(jA0T);
        C1954Uk c1954Uk = new C1954Uk(jA00, j2);
        if (jA00 >= j || jA0T == this.A01 - 1) {
            return new C1953Ui(c1954Uk);
        }
        long j3 = 1 + jA0T;
        return new C1953Ui(c1954Uk, new C1954Uk(A00(j3), this.A03 + (((long) this.A04.A02) * j3)));
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }
}
