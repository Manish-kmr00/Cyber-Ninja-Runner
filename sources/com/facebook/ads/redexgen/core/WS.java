package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class WS {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-58, -23, -23, -34, -73, -22, -27, -29, -53, -22, -33, -30, -72, -47, -42, -40, -45, -45, -46, -43, -41, -56, -57, -125, -45, -42, -42, -53, -125, -39, -56, -43, -42, -52, -46, -47, -99, -125};
    }

    public static WR A00(byte[] bArr) {
        C2447fq c2447fq = new C2447fq(bArr);
        if (c2447fq.A0A() < 32) {
            return null;
        }
        c2447fq.A0f(0);
        if (c2447fq.A0C() != c2447fq.A07() + 4 || c2447fq.A0C() != 1886614376) {
            return null;
        }
        int dataSize = W5.A03(c2447fq.A0C());
        if (dataSize > 1) {
            AbstractC2432fb.A07(A01(0, 12, 22), A01(12, 26, 3) + dataSize);
            return null;
        }
        UUID uuid = new UUID(c2447fq.A0P(), c2447fq.A0P());
        if (dataSize == 1) {
            c2447fq.A0g(c2447fq.A0L() * 16);
        }
        int atomSize = c2447fq.A0L();
        if (atomSize != c2447fq.A07()) {
            return null;
        }
        byte[] bArr2 = new byte[atomSize];
        c2447fq.A0k(bArr2, 0, atomSize);
        return new WR(uuid, dataSize, bArr2);
    }

    public static UUID A02(byte[] bArr) {
        WR parsedAtom = A00(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A01;
        }
        return null;
    }
}
