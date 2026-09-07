package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.google.android.exoplayer2.extractor.metadata.id3.MlltFrame;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14559s implements InterfaceC1935Tn {
    public final long A00;
    public final long[] A01;
    public final long[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, Long> A00(long j, long[] jArr, long[] jArr2) {
        int iA0L = AbstractC2471gE.A0L(jArr, j, true, true);
        long j2 = jArr[iA0L];
        long j3 = jArr2[iA0L];
        int i = iA0L + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr2[i] - j3) * (j4 == j2 ? 0.0d : (j - j2) / (j4 - j2)))) + j3));
    }

    public C14559s(long[] jArr, long[] jArr2, long j) {
        this.A01 = jArr;
        this.A02 = jArr2;
        this.A00 = j == -9223372036854775807L ? AbstractC2471gE.A0O(jArr2[jArr2.length - 1]) : j;
    }

    public static C14559s A01(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.A03.length;
        int referenceCount = length + 1;
        long[] jArr = new long[referenceCount];
        int referenceCount2 = length + 1;
        long[] jArr2 = new long[referenceCount2];
        jArr[0] = j;
        jArr2[0] = 0;
        long j3 = 0;
        for (int i = 1; i <= length; i++) {
            int referenceCount3 = i - 1;
            j += (long) (mlltFrame.A00 + mlltFrame.A03[referenceCount3]);
            int referenceCount4 = i - 1;
            j3 += (long) (mlltFrame.A01 + mlltFrame.A04[referenceCount4]);
            jArr[i] = j;
            jArr2[i] = j3;
        }
        return new C14559s(jArr, jArr2, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1935Tn
    public final long A7Z() {
        return -1L;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        Pair<Long, Long> pairA00 = A00(AbstractC2471gE.A0P(AbstractC2471gE.A0T(j, 0L, this.A00)), this.A02, this.A01);
        return new C1953Ui(new C1954Uk(AbstractC2471gE.A0O(((Long) pairA00.first).longValue()), ((Long) pairA00.second).longValue()));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1935Tn
    public final long A97(long j) {
        Pair<Long, Long> positionAndTimeMs = A00(j, this.A01, this.A02);
        return AbstractC2471gE.A0O(((Long) positionAndTimeMs.second).longValue());
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }
}
