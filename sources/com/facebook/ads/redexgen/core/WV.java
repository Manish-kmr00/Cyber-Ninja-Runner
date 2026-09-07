package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class WV implements Uj {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final boolean A06;

    public WV(long j, long j2, int i, int i2, boolean z) {
        this.A05 = j;
        this.A04 = j2;
        this.A01 = i2 == -1 ? 1 : i2;
        this.A00 = i;
        this.A06 = z;
        if (j == -1) {
            this.A02 = -1L;
            this.A03 = -9223372036854775807L;
        } else {
            this.A02 = j - j2;
            this.A03 = A01(j, j2, i);
        }
    }

    private long A00(long j) {
        long j2 = (((long) this.A00) * j) / 8000000;
        long positionOffset = this.A01;
        long j3 = j2 / positionOffset;
        long positionOffset2 = this.A01;
        long positionOffset3 = j3 * positionOffset2;
        if (this.A02 != -1) {
            positionOffset3 = Math.min(positionOffset3, this.A02 - ((long) this.A01));
        }
        long positionOffset4 = Math.max(positionOffset3, 0L);
        long positionOffset5 = this.A04;
        return positionOffset5 + positionOffset4;
    }

    public static long A01(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    public final long A02(long j) {
        return A01(j, this.A04, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        if (this.A02 == -1 && !this.A06) {
            return new C1953Ui(new C1954Uk(0L, this.A04));
        }
        long jA00 = A00(j);
        long jA02 = A02(jA00);
        C1954Uk seekPoint = new C1954Uk(jA02, jA00);
        if (this.A02 == -1 || jA02 >= j || ((long) this.A01) + jA00 >= this.A05) {
            return new C1953Ui(seekPoint);
        }
        long seekTimeUs = ((long) this.A01) + jA00;
        long secondSeekPosition = A02(seekTimeUs);
        return new C1953Ui(seekPoint, new C1954Uk(secondSeekPosition, seekTimeUs));
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return this.A02 != -1 || this.A06;
    }
}
