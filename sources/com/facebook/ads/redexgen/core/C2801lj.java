package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2801lj {
    public static byte[] A03;
    public final Object A00;
    public final Object A01;
    public final Object A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{Ascii.EM, 88, 87, 93, Ascii.EM, 85, 73, 113, 104, 112, 109, 116, 104, 97, 36, 97, 106, 112, 118, 109, 97, 119, 36, 115, 109, 112, 108, 36, 119, 101, 105, 97, 36, 111, 97, 125, 62, 36};
    }

    public C2801lj(Object key, Object value1, Object value2) {
        this.A00 = key;
        this.A01 = value1;
        this.A02 = value2;
    }

    public final IllegalArgumentException A02() {
        StringBuilder sbAppend = new StringBuilder().append(A00(6, 32, 74)).append(this.A00);
        String strA00 = A00(5, 1, 38);
        return new IllegalArgumentException(sbAppend.append(strA00).append(this.A01).append(A00(0, 5, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)).append(this.A00).append(strA00).append(this.A02).toString());
    }
}
