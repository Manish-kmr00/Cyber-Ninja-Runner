package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W2 implements Uj {
    public final long A00;
    public final boolean A01;
    public final long[] A02;
    public final long[] A03;

    public W2(long[] jArr, long[] jArr2, long j) {
        AbstractC2388es.A07(jArr.length == jArr2.length);
        int length = jArr2.length;
        this.A01 = length > 0;
        if (this.A01 && jArr2[0] > 0) {
            int length2 = length + 1;
            this.A02 = new long[length2];
            int length3 = length + 1;
            this.A03 = new long[length3];
            System.arraycopy(jArr, 0, this.A02, 1, length);
            System.arraycopy(jArr2, 0, this.A03, 1, length);
        } else {
            this.A02 = jArr;
            this.A03 = jArr2;
        }
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        if (!this.A01) {
            return new C1953Ui(C1954Uk.A03);
        }
        int iA0L = AbstractC2471gE.A0L(this.A03, j, true, true);
        C1954Uk c1954Uk = new C1954Uk(this.A03[iA0L], this.A02[iA0L]);
        if (c1954Uk.A01 != j) {
            int targetIndex = this.A03.length;
            if (iA0L != targetIndex - 1) {
                int targetIndex2 = iA0L + 1;
                long j2 = this.A03[targetIndex2];
                int targetIndex3 = iA0L + 1;
                C1954Uk rightSeekPoint = new C1954Uk(j2, this.A02[targetIndex3]);
                return new C1953Ui(c1954Uk, rightSeekPoint);
            }
        }
        return new C1953Ui(c1954Uk);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return this.A01;
    }
}
