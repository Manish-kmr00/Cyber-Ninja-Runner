package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ST implements UC {
    public final int A00;
    public final int A01;
    public final C2447fq A02 = new C2447fq();
    public final C2461g4 A03;

    public ST(int i, C2461g4 c2461g4, int i2) {
        this.A00 = i;
        this.A03 = c2461g4;
        this.A01 = i2;
    }

    private UA A00(C2447fq c2447fq, long j, long j2) {
        int iA00;
        int iA01;
        int iA0A = c2447fq.A0A();
        long j3 = -1;
        long j4 = -1;
        long lastPcrTimeUsInRange = -9223372036854775807L;
        while (c2447fq.A07() >= 188 && (iA01 = (iA00 = YU.A00(c2447fq.A0l(), c2447fq.A09(), iA0A)) + 188) <= iA0A) {
            long jA01 = YU.A01(c2447fq, iA00, this.A00);
            if (jA01 != -9223372036854775807L) {
                long jA06 = this.A03.A06(jA01);
                if (jA06 > j) {
                    if (lastPcrTimeUsInRange == -9223372036854775807L) {
                        return UA.A04(jA06, j2);
                    }
                    return UA.A03(j2 + j3);
                }
                long endOfLastPacketPositionInStream = jA06 + 100000;
                if (endOfLastPacketPositionInStream > j) {
                    return UA.A03(((long) iA00) + j2);
                }
                j3 = iA00;
                lastPcrTimeUsInRange = jA06;
            }
            c2447fq.A0f(iA01);
            j4 = iA01;
        }
        if (lastPcrTimeUsInRange != -9223372036854775807L) {
            return UA.A05(lastPcrTimeUsInRange, j2 + j4);
        }
        return UA.A03;
    }

    @Override // com.facebook.ads.redexgen.core.UC
    public final void AF2() {
        this.A02.A0i(AbstractC2471gE.A07);
    }

    @Override // com.facebook.ads.redexgen.core.UC
    public final UA AI2(WJ wj, long j) throws IOException {
        long jA8d = wj.A8d();
        int iMin = (int) Math.min(this.A01, wj.A8E() - jA8d);
        this.A02.A0d(iMin);
        wj.AG1(this.A02.A0l(), 0, iMin);
        return A00(this.A02, j, jA8d);
    }
}
