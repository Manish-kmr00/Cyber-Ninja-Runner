package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2345eB extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{117, 111, 56, 3, 8, Ascii.NAK, Ascii.GS, 8, Ascii.SO, Ascii.EM, 8, 9, 77};
    }

    public C2345eB(Throwable th) {
        super(A00(2, 11, 49) + th.getClass().getSimpleName() + A00(0, 2, 19) + th.getMessage(), th);
    }
}
