package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YI {
    public static byte[] A08;
    public static String[] A09 = {"mpBbJCBvGHciFnkDvEw8T6mnuzDTkbmB", "iYd", "MZWKBBob9BnXwXBzhjKhq9Qk0yg67Ty", "2e9qLTwe9mREx31EzTuG8FZvLTdy", "gK4eZ7UfUHrpCdlmAOT688JzKxqyP6W1", "0P9YPWCLtisuLzsdrg8g11tD23xnPb6I", "DQ6di4tCRn7nNrZQo14mKB3iLzpK7dPv", ""};
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final C2461g4 A07 = new C2461g4(0);
    public long A01 = -9223372036854775807L;
    public long A02 = -9223372036854775807L;
    public long A00 = -9223372036854775807L;
    public final C2447fq A06 = new C2447fq();

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A08 = new byte[]{-32, -46, 7, 37, Ascii.ESC, 32, Ascii.EM, -46, 6, -5, -1, -9, 17, 7, 0, 5, -9, 6, -46, Ascii.ESC, 32, 37, 38, Ascii.ETB, 19, Ascii.SYN, -32, -72, -35, -27, -48, -37, -40, -45, -113, -45, -28, -31, -48, -29, -40, -34, -35, -87, -113, -64, -29, -76, -27, -30, -47, -28, -39, -33, -34, -62, -43, -47, -44, -43, -30};
    }

    static {
        A09();
    }

    private int A00(WJ wj) {
        this.A06.A0i(AbstractC2471gE.A07);
        this.A03 = true;
        wj.AHr();
        return 0;
    }

    private int A01(WJ wj, C1952Ug c1952Ug) throws IOException {
        int iMin = (int) Math.min(20000L, wj.A8E());
        if (wj.A8d() != 0) {
            c1952Ug.A00 = 0;
            return 1;
        }
        this.A06.A0d(iMin);
        wj.AHr();
        wj.AG1(this.A06.A0l(), 0, iMin);
        this.A01 = A04(this.A06);
        this.A04 = true;
        return 0;
    }

    private int A02(WJ wj, C1952Ug c1952Ug) throws IOException {
        long jA8E = wj.A8E();
        int iMin = (int) Math.min(20000L, jA8E);
        long j = jA8E - ((long) iMin);
        long searchStartPosition = wj.A8d();
        if (searchStartPosition != j) {
            c1952Ug.A00 = j;
            return 1;
        }
        this.A06.A0d(iMin);
        wj.AHr();
        wj.AG1(this.A06.A0l(), 0, iMin);
        long inputLength = A05(this.A06);
        this.A02 = inputLength;
        this.A05 = true;
        return 0;
    }

    private int A03(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    private long A04(C2447fq c2447fq) {
        int iA0A = c2447fq.A0A();
        for (int iA09 = c2447fq.A09(); iA09 < searchStartPosition; iA09++) {
            int searchEndPosition = A03(c2447fq.A0l(), iA09);
            if (searchEndPosition == 442) {
                int searchStartPosition = iA09 + 4;
                c2447fq.A0f(searchStartPosition);
                long jA06 = A06(c2447fq);
                String[] strArr = A09;
                String str = strArr[7];
                String str2 = strArr[1];
                int searchEndPosition2 = str.length();
                int searchStartPosition2 = str2.length();
                if (searchEndPosition2 == searchStartPosition2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[7] = "";
                strArr2[1] = "I7F";
                if (jA06 != -9223372036854775807L) {
                    return jA06;
                }
            }
        }
        return -9223372036854775807L;
    }

    private long A05(C2447fq c2447fq) {
        int iA09 = c2447fq.A09();
        int searchStartPosition = c2447fq.A0A();
        for (int nextStartCode = searchStartPosition - 4; nextStartCode >= iA09; nextStartCode--) {
            int searchEndPosition = A03(c2447fq.A0l(), nextStartCode);
            if (searchEndPosition == 442) {
                int searchStartPosition2 = nextStartCode + 4;
                c2447fq.A0f(searchStartPosition2);
                long jA06 = A06(c2447fq);
                if (jA06 != -9223372036854775807L) {
                    return jA06;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long A06(C2447fq c2447fq) {
        int iA09 = c2447fq.A09();
        if (c2447fq.A07() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        int originalPosition = bArr.length;
        c2447fq.A0k(bArr, 0, originalPosition);
        c2447fq.A0f(iA09);
        if (A0A(bArr)) {
            return A07(bArr);
        }
        return -9223372036854775807L;
    }

    public static long A07(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public static boolean A0A(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public final int A0B(WJ wj, C1952Ug c1952Ug) throws IOException {
        if (!this.A05) {
            return A02(wj, c1952Ug);
        }
        if (this.A02 == -9223372036854775807L) {
            return A00(wj);
        }
        if (!this.A04) {
            return A01(wj, c1952Ug);
        }
        if (this.A01 == -9223372036854775807L) {
            return A00(wj);
        }
        this.A00 = this.A07.A06(this.A02) - this.A07.A06(this.A01);
        if (this.A00 < 0) {
            AbstractC2432fb.A07(A08(45, 16, 27), A08(27, 18, 26) + this.A00 + A08(0, 27, 93));
            this.A00 = -9223372036854775807L;
        }
        return A00(wj);
    }

    public final long A0C() {
        return this.A00;
    }

    public final C2461g4 A0D() {
        return this.A07;
    }

    public final boolean A0E() {
        return this.A03;
    }
}
