package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WY implements Uj {
    public static byte[] A06;
    public static String[] A07 = {"tLzCF85sC8CJNNz1CEQFy0rj2HSVp1Oi", "PyfBvAMomjDfqe8lJa7tfxQTSch1S9UX", "tYAsERzhHqLbwFAW5NEJ4VAL6e4FPEl2", "Qaj9zxoyQsJje86ya", "6fm4oHtBkwNK", "ivGSqitgF8OzhkmKlqLOXuXY8ZpSGbk2", "bU9F6PJdy1GvJ5gOAbD", "4KFIhfNIEkF6nQq8dUI24MpztR3cSuWl"};
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final long[] A03;
    public final long[] A04;
    public final long A05;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A07[3].length() == 15) {
                throw new RuntimeException();
            }
            A07[5] = "l8o9st1HZJwsgHBfoV3vv9Rj36IEjFbK";
            bArrCopyOfRange[i4] = (byte) ((b ^ i3) ^ 100);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{58, SignedBytes.MAX_POWER_OF_TWO, 76, 8, Ascii.EM, Ascii.RS, Ascii.CR, Ascii.CAN, 5, 3, 2, Ascii.US, 57, Ascii.US, 81, 62, 50, 125, 116, 116, 97, 119, 102, 97, 47, 86, 90, 9, 19, 0, Ascii.US, 9, 71, 41, 37, 113, 108, 104, 96, 80, 118, 56, 48, Ascii.ESC, 6, Ascii.GS, Ascii.CAN, 58, Ascii.GS, Ascii.ETB, Ascii.SYN, Ascii.VT, 91, Ascii.US, Ascii.SYN, Ascii.GS, Ascii.DC4, 7, Ascii.ESC, 78};
    }

    static {
        A02();
    }

    public WY(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.A01 = iArr;
        this.A03 = jArr;
        this.A02 = jArr2;
        this.A04 = jArr3;
        this.A00 = iArr.length;
        if (this.A00 > 0) {
            this.A05 = jArr2[this.A00 - 1] + jArr3[this.A00 - 1];
        } else {
            this.A05 = 0L;
        }
    }

    private final int A00(long j) {
        return AbstractC2471gE.A0L(this.A04, j, true, true);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final long A7j() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final C1953Ui A8r(long j) {
        int iA00 = A00(j);
        C1954Uk c1954Uk = new C1954Uk(this.A04[iA00], this.A03[iA00]);
        if (c1954Uk.A01 < j) {
            int chunkIndex = this.A00;
            if (iA00 != chunkIndex - 1) {
                int chunkIndex2 = iA00 + 1;
                long j2 = this.A04[chunkIndex2];
                int chunkIndex3 = iA00 + 1;
                C1954Uk seekPoint = new C1954Uk(j2, this.A03[chunkIndex3]);
                return new C1953Ui(c1954Uk, seekPoint);
            }
        }
        return new C1953Ui(c1954Uk);
    }

    @Override // com.facebook.ads.redexgen.core.Uj
    public final boolean AAY() {
        return true;
    }

    public final String toString() {
        return A01(42, 18, 23) + this.A00 + A01(25, 8, 30) + Arrays.toString(this.A01) + A01(15, 10, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE) + Arrays.toString(this.A03) + A01(33, 9, 97) + Arrays.toString(this.A04) + A01(1, 14, 8) + Arrays.toString(this.A02) + A01(0, 1, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE);
    }
}
