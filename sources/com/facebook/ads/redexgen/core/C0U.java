package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C0U {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{120, 122, 109, 112, 111, 112, 109, 96, 70, 118, 123, 115, 124, 122, 109, 70, 112, 125, SignedBytes.MAX_POWER_OF_TWO, 66, 85, 72, 87, 72, 85, 88, 126, 87, 72, 68, 86, 126, 85, 88, 81, 68, 112, 117, 78, 125, 120, 98, 101, 116, 127, 116, 99, 78, 98, 116, 101, 73, 91, 88, 77, 75, 92, 119, 90, 73, 92, 65, 71, 81, 83, 94, 94, 109, 91, 85, 92, 93, SignedBytes.MAX_POWER_OF_TWO, 87, 86, 75, SignedBytes.MAX_POWER_OF_TWO, 73, 65, 70, 77, 76, 45, 38, 47, 39, 32, 43, 42, 17, 47, 42, 17, 39, 32, 42, 43, 54, Ascii.US, Ascii.DC4, Ascii.GS, Ascii.NAK, Ascii.DC2, Ascii.EM, Ascii.CAN, 35, Ascii.FF, Ascii.GS, Ascii.SO, Ascii.GS, 17, Ascii.SI, 35, Ascii.SYN, Ascii.SI, 19, Ascii.DC2, 118, 97, 97, 124, 97, 76, 112, 124, 119, 118, Ascii.SUB, Ascii.CR, Ascii.CR, Ascii.DLE, Ascii.CR, 32, Ascii.DC2, Ascii.SUB, Ascii.FF, Ascii.FF, Ascii.RS, Ascii.CAN, Ascii.SUB, 97, 124, 103, 97, 116, 112, 109, 107, 106, 124, 117, 103, 75, 118, 125, 112, 48, 57, 43, 7, 59, 55, 54, 44, 42, 55, 52, 52, Base64.padSymbol, 42, Ascii.RS, Ascii.ETB, 5, 41, Ascii.SUB, Ascii.US, 5, 2, 19, Ascii.CAN, 19, 4, 93, 84, 70, 106, 66, 80, 87, 67, 92, 80, 66, 98, 106, 105, 84, 111, 98, 120, 106, 105, 103, 110, 111, 84, 105, 114, 84, 108, 96, 34, 47, Ascii.DC2, 8, 36, Ascii.DC2, Ascii.NAK, Ascii.CR, Ascii.SUB, Ascii.ETB, Ascii.DC2, Ascii.US, Ascii.SUB, Ascii.SI, Ascii.RS, Ascii.US, 108, 118, 90, 105, 96, 99, 113, 90, 113, 106, 117, 90, 109, 100, 105, 99, 9, 19, 63, Ascii.DLE, Ascii.NAK, 2, Ascii.FF, 9, 3, 35, 57, Ascii.NAK, 57, 58, 38, 35, 62, Ascii.NAK, 57, 41, 56, 47, 47, 36, Ascii.NAK, 44, 38, 43, 45, Ascii.NAK, 43, 46, 46, 47, 46, 56, 34, Ascii.SO, 34, 36, 33, 33, 62, 35, 37, 52, 53, Ascii.SO, 56, 63, Ascii.SO, 48, 33, 33, 42, 37, 45, Base64.padSymbol, 62, 48, 53, Ascii.SO, 52, 41, 52, 50, 36, 37, 56, 62, 63, Ascii.SO, 38, 48, 56, 37, Ascii.SO, 37, 56, 60, 52, Ascii.SO, 60, 34, 88, 91, 85, 80, 107, SignedBytes.MAX_POWER_OF_TWO, 93, 89, 81, 107, 89, 71, 39, 36, 42, 47, 34, 37, 44, Ascii.DC4, 42, 47, 42, 59, 63, 46, 57, Ascii.FF, 0, Ascii.SI, 8, 7, 4, Ascii.DC2, Ascii.NAK, 62, Ascii.FF, Ascii.SYN, 62, Ascii.DC2, Ascii.DC4, 17, 17, Ascii.SO, 19, Ascii.NAK, 40, 32, 33, 44, 36, 49, 44, 42, 43, Ascii.SUB, 42, 51, 32, 55, 41, 36, 60, Ascii.SUB, 54, 32, 49, 75, 67, 85, 85, 71, 65, 67, 60, 62, 53, 52, Ascii.DLE, 10, 34, Ascii.DC2, Ascii.SO, 34, Ascii.SO, 8, Ascii.CR, Ascii.CR, Ascii.DC2, Ascii.SI, 9, 7, Ascii.SUB, 1, Ascii.CR, 6, Ascii.FS, 9, Ascii.FS, 1, 7, 6, Ascii.DC4, 8, 5, 7, 1, 9, 1, 10, Ascii.DLE, 59, Ascii.CR, 0, 68, 88, 85, 87, 81, 89, 81, 90, SignedBytes.MAX_POWER_OF_TWO, 107, SignedBytes.MAX_POWER_OF_TWO, 77, 68, 81, Ascii.VT, 9, Ascii.DC4, Ascii.CR, Ascii.DC2, Ascii.US, Ascii.RS, 9, Ascii.SUB, Ascii.CR, 9, Ascii.ESC, 7, 6, 58, 45, 57, Base64.padSymbol, 45, 59, 60, Ascii.ETB, 33, 44, 70, 93, 90, 66, 106, 71, 80, 70, SignedBytes.MAX_POWER_OF_TWO, 89, 65, 98, 122, 120, 97, 78, 99, 116, 112, 98, 126, 127, 10, 9, 38, 10, Ascii.SUB, 38, Ascii.DC4, Ascii.SO, 38, Ascii.SYN, 10, 38, 10, Ascii.FF, 9, 9, Ascii.SYN, Ascii.VT, Ascii.CR, 89, 84, 93, 72, 100, Ascii.RS, 90, 93, 66, 78, 92, 116, 95, 82, 91, 78, 127, 96, 108, 126, 104, 107, 101, 108, 86, 123, 104, 125, 96, 102, 81, 78, 84, 78, 69, 78, 75, 78, 83, 94, 70, 95, 88, 110, 87, 80, 93, 66, 84, 110, 67, 84, 80, 66, 94, 95};
    }
}
