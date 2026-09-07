package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YS {
    public static byte[] A05;
    public static String[] A06 = {"HHf7SoU351EiSnSla0A9kJoDbLtlmLLH", "MAvTUEmW3Qq7zutUsJpSIMoSBa5TROAg", "Iwe1kcnN9nnsnTvLj2pOSpbm1", "uP5SqS945a3YWZY24GGPS8t7JBS2PVpS", "ZgWLINwsPQAkhEb6IfQfZ8RQut", "Ykve2qMsRtNPykrC1", "7D2EcvnsAKqaDDhoj", "OGuVuhXNw7AjqN93jo2ZNhpmPE"};
    public int A00;
    public String A01;
    public final int A02;
    public final int A03;
    public final String A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A06[1].charAt(11) == 's') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[4] = "nvDqYUdZmWYVClK8n80pOPBxZz";
            strArr[7] = "ufBNVaGkwwDnRTydyMt66fBHf2";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 91);
            i4++;
        }
    }

    public static void A02() {
        A05 = new byte[]{8, 48, 50, 57, 50, 37, 54, 35, 50, Ascii.EM, 50, 32, Ascii.RS, 51, 127, 126, 119, 58, 34, 36, 35, 119, 53, 50, 119, 52, 54, 59, 59, 50, 51, 119, 53, 50, 49, 56, 37, 50, 119, 37, 50, 35, 37, 62, 50, 33, 62, 57, 48, 119, 62, 51, 36, 121};
    }

    static {
        A02();
    }

    public YS(int i, int i2) {
        this(Integer.MIN_VALUE, i, i2);
    }

    public YS(int i, int i2, int i3) {
        String strA00 = A00(0, 0, 31);
        this.A04 = i != Integer.MIN_VALUE ? i + A00(0, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) : strA00;
        this.A02 = i2;
        this.A03 = i3;
        this.A00 = Integer.MIN_VALUE;
        this.A01 = strA00;
    }

    private void A01() {
        if (this.A00 != Integer.MIN_VALUE) {
        } else {
            throw new IllegalStateException(A00(1, 53, 12));
        }
    }

    public final int A03() {
        A01();
        return this.A00;
    }

    public final String A04() {
        A01();
        return this.A01;
    }

    public final void A05() {
        this.A00 = this.A00 == Integer.MIN_VALUE ? this.A02 : this.A00 + this.A03;
        this.A01 = this.A04 + this.A00;
    }
}
