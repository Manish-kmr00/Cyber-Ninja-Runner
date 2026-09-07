package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0S extends AbstractC12190k {
    public static byte[] A00;
    public static final AbstractC1814Os A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{9, 34, 43, 56, 7, 43, 62, 41, 34, 47, 56, 100, 36, 37, 36, 47, 98, 99};
    }

    static {
        A01();
        A01 = new C0S();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0S() {
        final String strA00 = A00(0, 18, 12);
        new AbstractC13134b(strA00) { // from class: com.facebook.ads.redexgen.X.0k
            public final String A00;

            {
                this.A00 = (String) AbstractC2589iD.A04(strA00);
            }

            public final String toString() {
                return this.A00;
            }
        };
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1814Os
    public final int A08(CharSequence sequence, int start) {
        int length = sequence.length();
        AbstractC2589iD.A01(start, length);
        return -1;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1814Os
    public final boolean A09(char c) {
        return false;
    }
}
