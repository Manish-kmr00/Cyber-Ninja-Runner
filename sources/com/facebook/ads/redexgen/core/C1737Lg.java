package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1737Lg extends AbstractC2208bx {
    public static byte[] A01;
    public final /* synthetic */ C2537hJ A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{38, 57, 52, 53, 63, Ascii.EM, 62, 36, 53, 34, 35, 36, 57, 36, 49, 60, Ascii.NAK, 38, 53, 62, 36};
    }

    public C1737Lg(C2537hJ c2537hJ) {
        this.A00 = c2537hJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.C9K
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(KY ky) {
        this.A00.A06.A4a(A00(0, 21, 40), ky);
    }
}
