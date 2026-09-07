package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2045Yb {
    public static byte[] A00;

    static {
        A05();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static YZ A02(WJ wj) throws IOException {
        byte[] bArr;
        C2447fq c2447fq = new C2447fq(16);
        C2044Ya c2044YaA03 = A03(1718449184, wj, c2447fq);
        AbstractC2388es.A08(c2044YaA03.A01 >= 16);
        wj.AG1(c2447fq.A0l(), 0, 16);
        c2447fq.A0f(0);
        int iA0G = c2447fq.A0G();
        int iA0G2 = c2447fq.A0G();
        int iA0F = c2447fq.A0F();
        int iA0F2 = c2447fq.A0F();
        int iA0G3 = c2447fq.A0G();
        int iA0G4 = c2447fq.A0G();
        int i = ((int) c2044YaA03.A01) - 16;
        if (i > 0) {
            bArr = new byte[i];
            wj.AG1(bArr, 0, i);
        } else {
            bArr = AbstractC2471gE.A07;
        }
        wj.AJ9((int) (wj.A8Y() - wj.A8d()));
        return new YZ(iA0G, iA0G2, iA0F, iA0F2, iA0G3, iA0G4, bArr);
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{5, 42, 55, 48, 45, -30, 43, 53, -30, 54, 49, 49, -30, 46, 35, 52, 41, 39, -30, -22, SignedBytes.MAX_POWER_OF_TWO, -12, 9, 4, -19, -21, -30, 54, 49, -30, 53, 45, 43, 50, -3, -30, 43, 38, -4, -30, -34, -4, 3, 4, 7, -2, 3, -4, -75, 10, 3, 0, 3, 4, Ascii.FF, 3, -75, -20, -42, -21, -75, -8, -3, 10, 3, 0, -49, -75, -37, -12, -7, -5, -10, -10, -11, -8, -6, -21, -22, -90, -20, -11, -8, -13, -90, -6, -1, -10, -21, -64, -90, 56, 66, 87, 41, 70, 66, 69, 70, 83, 51, 70, 66, 69, 70, 83};
    }

    public static long A00(WJ wj) throws IOException {
        C2447fq c2447fq = new C2447fq(8);
        C2044Ya chunkHeader = C2044Ya.A00(wj, c2447fq);
        if (chunkHeader.A00 != 1685272116) {
            wj.AHr();
            return -1L;
        }
        wj.A3x(8);
        c2447fq.A0f(0);
        wj.AG1(c2447fq.A0l(), 0, 8);
        long sampleDataSize = c2447fq.A0N();
        wj.AJ9(((int) chunkHeader.A01) + 8);
        return sampleDataSize;
    }

    public static Pair<Long, Long> A01(WJ wj) throws IOException {
        wj.AHr();
        C2044Ya c2044YaA03 = A03(1684108385, wj, new C2447fq(8));
        wj.AJ9(8);
        return Pair.create(Long.valueOf(wj.A8d()), Long.valueOf(c2044YaA03.A01));
    }

    public static C2044Ya A03(int i, WJ wj, C2447fq c2447fq) throws IOException {
        C2044Ya c2044YaA00 = C2044Ya.A00(wj, c2447fq);
        while (c2044YaA00.A00 != i) {
            AbstractC2432fb.A07(A04(91, 15, 115), A04(40, 28, 39) + c2044YaA00.A00);
            long j = c2044YaA00.A01 + 8;
            if (j <= 2147483647L) {
                wj.AJ9((int) j);
                c2044YaA00 = C2044Ya.A00(wj, c2447fq);
            } else {
                throw Q6.A00(A04(0, 40, 84) + c2044YaA00.A00);
            }
        }
        return c2044YaA00;
    }

    public static boolean A06(WJ wj) throws IOException {
        C2447fq c2447fq = new C2447fq(8);
        C2044Ya c2044YaA00 = C2044Ya.A00(wj, c2447fq);
        if (c2044YaA00.A00 != 1380533830 && c2044YaA00.A00 != 1380333108) {
            return false;
        }
        wj.AG1(c2447fq.A0l(), 0, 4);
        c2447fq.A0f(0);
        int iA0C = c2447fq.A0C();
        if (iA0C != 1463899717) {
            AbstractC2432fb.A05(A04(91, 15, 115), A04(68, 23, 24) + iA0C);
            return false;
        }
        return true;
    }
}
