package com.facebook.ads.redexgen.core;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2172bN {
    public static String[] A07 = {"K4xrGqafDQDRAhZSdWhuk587fTAY7MFb", "i1IysyxujImbAMMJpoCKgo8tfO0bOyoC", "rwWqJPEt5zHE5awNJTD09hJhTdsjiq1J", "kApBPijEbT2iCyiztTt35QXvkWAJXahs", "Th8C", "HcngvQofEhe8UbYnWIZRdwufCrY", "hzopP5tPacE7lb1riREOzi3", "Ox0o8AmhRhpBtQfkCDQ1Dk"};
    public long A00;
    public C1869Qy A01;
    public C1869Qy A02;
    public C1869Qy A03;
    public final int A04;
    public final InterfaceC2295dM A05;
    public final C2447fq A06 = new C2447fq(32);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1869Qy A04(C1869Qy c1869Qy, C2014Ww c2014Ww, C2174bP c2174bP, C2447fq c2447fq) {
        int iA0M;
        long j = c2174bP.A01;
        c2447fq.A0d(1);
        C1869Qy c1869QyA03 = A03(c1869Qy, j, c2447fq.A0l(), 1);
        long j2 = j + 1;
        byte b = c2447fq.A0l()[0];
        boolean z = (b & 128) != 0;
        int i = b & 127;
        C1907Sk c1907Sk = c2014Ww.A05;
        if (c1907Sk.A04 == null) {
            c1907Sk.A04 = new byte[16];
        } else {
            Arrays.fill(c1907Sk.A04, (byte) 0);
        }
        C1869Qy c1869QyA04 = A03(c1869QyA03, j2, c1907Sk.A04, i);
        long j3 = j2 + ((long) i);
        if (z) {
            c2447fq.A0d(2);
            c1869QyA04 = A03(c1869QyA04, j3, c2447fq.A0l(), 2);
            j3 += 2;
            iA0M = c2447fq.A0M();
        } else {
            iA0M = 1;
        }
        int[] iArr = c1907Sk.A06;
        if (iArr == null || iArr.length < iA0M) {
            iArr = new int[iA0M];
        }
        int[] iArr2 = c1907Sk.A07;
        if (iArr2 == null || iArr2.length < iA0M) {
            iArr2 = new int[iA0M];
        }
        if (z) {
            int i2 = iA0M * 6;
            c2447fq.A0d(i2);
            c1869QyA04 = A03(c1869QyA04, j3, c2447fq.A0l(), i2);
            j3 += (long) i2;
            c2447fq.A0f(0);
            for (int i3 = 0; i3 < iA0M; i3++) {
                iArr[i3] = c2447fq.A0M();
                iArr2[i3] = c2447fq.A0L();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = c2174bP.A00 - ((int) (j3 - c2174bP.A01));
        }
        C1956Um c1956Um = (C1956Um) AbstractC2471gE.A0f(c2174bP.A02);
        c1907Sk.A02(iA0M, iArr, iArr2, c1956Um.A03, c1907Sk.A04, c1956Um.A01, c1956Um.A02, c1956Um.A00);
        int i4 = (int) (j3 - c2174bP.A01);
        c2174bP.A01 += (long) i4;
        c2174bP.A00 -= i4;
        return c1869QyA04;
    }

    public C2172bN(InterfaceC2295dM interfaceC2295dM) {
        this.A05 = interfaceC2295dM;
        this.A04 = interfaceC2295dM.A88();
        this.A01 = new C1869Qy(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
    }

    private int A00(int i) {
        if (this.A03.A03 == null) {
            this.A03.A03(this.A05.A3z(), new C1869Qy(this.A03.A00, this.A04));
        }
        return Math.min(i, (int) (this.A03.A00 - this.A00));
    }

    public static C1869Qy A01(C1869Qy c1869Qy, long j) {
        while (j >= c1869Qy.A00) {
            c1869Qy = c1869Qy.A02;
        }
        return c1869Qy;
    }

    public static C1869Qy A02(C1869Qy c1869Qy, long j, ByteBuffer byteBuffer, int i) {
        C1869Qy c1869QyA01 = A01(c1869Qy, j);
        while (i > 0) {
            int remaining = (int) (c1869QyA01.A00 - j);
            int iMin = Math.min(i, remaining);
            byte[] bArr = c1869QyA01.A03.A01;
            int remaining2 = c1869QyA01.A00(j);
            byteBuffer.put(bArr, remaining2, iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == c1869QyA01.A00) {
                c1869QyA01 = c1869QyA01.A02;
            }
        }
        return c1869QyA01;
    }

    public static C1869Qy A03(C1869Qy c1869Qy, long j, byte[] bArr, int i) {
        C1869Qy c1869QyA01 = A01(c1869Qy, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (c1869QyA01.A00 - j));
            byte[] bArr2 = c1869QyA01.A03.A01;
            int toCopy = c1869QyA01.A00(j);
            int remaining = i - i2;
            System.arraycopy(bArr2, toCopy, bArr, remaining, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == c1869QyA01.A00) {
                c1869QyA01 = c1869QyA01.A02;
            }
        }
        return c1869QyA01;
    }

    public static C1869Qy A05(C1869Qy c1869Qy, C2014Ww c2014Ww, C2174bP c2174bP, C2447fq c2447fq) {
        if (c2014Ww.A0E()) {
            c1869Qy = A04(c1869Qy, c2014Ww, c2174bP, c2447fq);
        }
        if (c2014Ww.A03()) {
            c2447fq.A0d(4);
            C1869Qy c1869QyA03 = A03(c1869Qy, c2174bP.A01, c2447fq.A0l(), 4);
            int iA0L = c2447fq.A0L();
            c2174bP.A01 += 4;
            c2174bP.A00 -= 4;
            c2014Ww.A0C(iA0L);
            C1869Qy c1869QyA02 = A02(c1869QyA03, c2174bP.A01, c2014Ww.A02, iA0L);
            c2174bP.A01 += (long) iA0L;
            c2174bP.A00 -= iA0L;
            String[] strArr = A07;
            String str = strArr[7];
            String str2 = strArr[4];
            int sampleSize = str.length();
            if (sampleSize == str2.length()) {
                throw new RuntimeException();
            }
            A07[3] = "FBV6Hh7qKs7coCG2tPdPGbZ4jODJmT0u";
            c2014Ww.A0D(c2174bP.A00);
            return A02(c1869QyA02, c2174bP.A01, c2014Ww.A03, c2174bP.A00);
        }
        c2014Ww.A0C(c2174bP.A00);
        return A02(c1869Qy, c2174bP.A01, c2014Ww.A02, c2174bP.A00);
    }

    private void A06(int i) {
        this.A00 += (long) i;
        if (this.A00 == this.A03.A00) {
            this.A03 = this.A03.A02;
        }
    }

    private void A07(C1869Qy c1869Qy) {
        if (c1869Qy.A03 == null) {
            return;
        }
        this.A05.AGm(c1869Qy);
        c1869Qy.A01();
    }

    public final int A08(O9 o9, int i, boolean z) throws IOException {
        int i2 = o9.read(this.A03.A03.A01, this.A03.A00(this.A00), A00(i));
        if (i2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        A06(i2);
        return i2;
    }

    public final long A09() {
        return this.A00;
    }

    public final void A0A() {
        A07(this.A01);
        this.A01.A02(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
        this.A00 = 0L;
        this.A05.AJY();
    }

    public final void A0B() {
        this.A02 = this.A01;
    }

    public final void A0C(long j) {
        if (j == -1) {
            return;
        }
        while (true) {
            long j2 = this.A01.A00;
            String[] strArr = A07;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A07[6] = "Y0CaqHQLZ7PmbtNCYm";
            if (j < j2) {
                if (this.A02.A01 < this.A01.A01) {
                    C1869Qy c1869Qy = this.A01;
                    if (A07[6].length() != 31) {
                        String[] strArr2 = A07;
                        strArr2[1] = "dP6aAoHkUL99AaxS6PgiDBg5BTNZmNNt";
                        strArr2[0] = "grmUak7ijGAaApnjW1yWZUsAKbuAYPVj";
                        this.A02 = c1869Qy;
                        return;
                    }
                    this.A02 = c1869Qy;
                    return;
                }
                return;
            }
            this.A05.AGl(this.A01.A03);
            this.A01 = this.A01.A01();
        }
    }

    public final void A0D(C2014Ww c2014Ww, C2174bP c2174bP) {
        A05(this.A02, c2014Ww, c2174bP, this.A06);
    }

    public final void A0E(C2014Ww c2014Ww, C2174bP c2174bP) {
        this.A02 = A05(this.A02, c2014Ww, c2174bP, this.A06);
    }

    public final void A0F(C2447fq c2447fq, int i) {
        while (i > 0) {
            int iA00 = A00(i);
            byte[] bArr = this.A03.A03.A01;
            int bytesAppended = this.A03.A00(this.A00);
            c2447fq.A0k(bArr, bytesAppended, iA00);
            i -= iA00;
            A06(iA00);
        }
    }
}
