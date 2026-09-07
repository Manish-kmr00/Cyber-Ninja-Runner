package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum MI {
    A09(A00(173, 7, 111)),
    A07(A00(145, 11, 71)),
    A0A(A00(180, 16, 94)),
    A06(A00(129, 16, 114)),
    A08(A00(156, 17, 64)),
    A05(A00(120, 9, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)),
    A04(A00(98, 22, 15));

    public static byte[] A01;
    public static String[] A02 = {"3irfHjb1xBggEOYppIC20CVGO", "PvTwVw4l1egAAUgNiEJHpQxcY", "Z83jj4f2UJi7iIzCa97fW954cYyfIvRS", "Pn3ECjM654pG8xNfJs7iPR6nvOfTtg4S", "rnvCizUmlaJkbQ0LWt7EGYvIVwvlRHSU", "Y4v1TwA3VTqRjFpvhM1P5mrv4yN1Kb1i", "iJ3TP1yTdydKb8xTTpNjz5p9ilImmlzt", "3Fyn3bOdC3lEL0zKVakbNgp9AIkAOPYu"};
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            String[] strArr = A02;
            if (strArr[4].charAt(18) != strArr[3].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "9Fh1XlTwmrAkPSBsBt7sR6HEZ4z1EPMB";
            strArr2[3] = "w0XpqxyBnVeSACOsJ07N96wKg89kpHEO";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{71, 80, 67, 67, SignedBytes.MAX_POWER_OF_TWO, 87, 90, 71, SignedBytes.MAX_POWER_OF_TWO, 73, 74, 82, 90, 81, 77, 87, SignedBytes.MAX_POWER_OF_TWO, 86, 77, 74, 73, 65, Ascii.EM, Ascii.DLE, Ascii.CR, Ascii.FS, Ascii.SUB, 0, Ascii.SUB, 17, Ascii.ESC, 33, 32, 48, 32, 58, 59, 63, 58, 59, 48, 45, 58, 41, 41, 42, Base64.padSymbol, 103, 124, 101, 101, 118, 111, 102, 123, 100, 104, 125, 79, 73, 78, 90, 93, 95, 89, 67, 82, 83, 72, 67, 78, 89, 93, 88, 69, 2, Ascii.EM, Ascii.FS, Ascii.EM, Ascii.CAN, 0, Ascii.EM, 127, 105, 97, 124, 97, 102, 111, 119, 110, 103, 122, 119, 99, 109, 113, 123, 86, 65, 82, 82, 81, 70, 107, 86, 81, 88, 91, 67, 107, SignedBytes.MAX_POWER_OF_TWO, 92, 70, 81, 71, 92, 91, 88, 80, 43, 34, 63, 46, 40, Ascii.DC2, 40, 35, 41, 39, 38, Ascii.SYN, 38, 60, Base64.padSymbol, 57, 60, Base64.padSymbol, Ascii.SYN, 43, 60, 47, 47, 44, 59, Ascii.DC2, 9, Ascii.DLE, Ascii.DLE, 35, Ascii.SUB, 19, Ascii.SO, 17, Ascii.GS, 8, 8, Ascii.SO, 9, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.RS, 36, Ascii.NAK, Ascii.DC4, Ascii.SI, 36, 9, Ascii.RS, Ascii.SUB, Ascii.US, 2, 33, 58, 63, 58, 59, 35, 58, Ascii.DC2, 4, Ascii.FF, 17, Ascii.FF, Ascii.VT, 2, 58, 3, 10, Ascii.ETB, 58, Ascii.SO, 0, Ascii.FS, Ascii.SYN};
    }

    static {
        A01();
    }

    MI(String str) {
        this.A00 = str;
    }
}
