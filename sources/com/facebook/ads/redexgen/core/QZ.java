package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QZ implements InterfaceC2252cf {
    public static byte[] A00;
    public static String[] A01 = {"D1Suyh0x2x3nLqP99r2DlMwSIGzo4", "lnnJwj9Jy1Fdr4Eb8hkoGrInOxKcj", "3oZe0oGQfnAsytBs873SU5NVXTXMIY77", "659zOlLFFQHjzSQQvgElgq1430eu7PeT", "b1jMkzPLGG2sk850HnHCO9pUX0fF2HDM", "TwAtDoFnkiHBMlgVzleHOAgo7yQHFuM8", "zCYosnPJocfHfgPSTLfagwzXfAhqCIJE", "fB5R76fFniCS04tIlwYgHC2Prq7khlqC"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 70);
            String[] strArr = A01;
            if (strArr[2].charAt(5) != strArr[5].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "x5ijQLPbskIJZJ0IVxC0NOD6Ba2qaKBu";
            strArr2[6] = "WF0q04PvBOVuoQa7Kr8WUM4mxZtI6c8p";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{38, 19, 19, 2, 10, Ascii.ETB, 19, 2, 3, 71, 19, 8, 71, 4, Ascii.NAK, 2, 6, 19, 2, 71, 3, 2, 4, 8, 3, 2, Ascii.NAK, 71, 1, 8, Ascii.NAK, 71, Ascii.DC2, 9, Ascii.DC4, Ascii.DC2, Ascii.ETB, Ascii.ETB, 8, Ascii.NAK, 19, 2, 3, 71, 42, 46, 42, 34, 71, 19, Ascii.RS, Ascii.ETB, 2, 93, 71, 51, 34, 34, 62, 59, 49, 51, 38, 59, Base64.padSymbol, 60, 125, 49, 55, 51, 127, 100, 98, 106, 126, 111, 111, 115, 118, 124, 126, 107, 118, 112, 113, 48, 124, 122, 126, 50, 40, 47, 39, 115, 98, 98, 126, 123, 113, 115, 102, 123, 125, 124, Base64.padSymbol, 118, 100, 112, 97, 103, 112, 97, 45, 60, 60, 32, 37, 47, 45, 56, 37, 35, 34, 99, 60, 43, 63, 46, 63, 63, 35, 38, 44, 46, 59, 38, 32, 33, 96, 59, 59, 34, 35, 100, 55, 34, 35, 104, 121, 121, 101, 96, 106, 104, 125, 96, 102, 103, 38, 113, 36, 100, 121, Base64.padSymbol, 36, 106, 108, 104, 36, 63, 57, 49, 51, 34, 34, 62, 59, 49, 51, 38, 59, Base64.padSymbol, 60, 125, 42, 127, 63, 34, 102, 127, 36, 38, 38, Ascii.SYN, 7, 7, Ascii.ESC, Ascii.RS, Ascii.DC4, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, 88, Ascii.SI, 90, 6, 2, Ascii.RS, Ascii.DC4, Ascii.FS, 3, Ascii.RS, Ascii.SUB, Ascii.DC2, 90, 3, Ascii.SI, 68, Ascii.DLE, 58, 43, 43, 55, 50, 56, 58, 47, 50, 52, 53, 116, 35, 118, 40, 46, 57, 41, 50, 43, 113, 96, 125, 113, 42, 115, 113, 113, 60, 45, 48, 60, 103, 48, 101, 45, 48, 39, 56, 36, 41, 49, 45, 58, 101, 43, Base64.padSymbol, 45, 59, 85, 68, 89, 85, Ascii.SO, 89, Ascii.FF, 82, 82, SignedBytes.MAX_POWER_OF_TWO};
    }

    static {
        A01();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2252cf
    public final TQ A5A(ZM zm) {
        byte b;
        String str = zm.A0W;
        if (str != null) {
            switch (str.hashCode()) {
                case 1201784583:
                    String mimeType = A00(249, 21, 14);
                    if (str.equals(mimeType)) {
                        b = 0;
                        break;
                    }
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    return new AnonymousClass61();
            }
        }
        StringBuilder sb = new StringBuilder();
        String mimeType2 = A00(0, 55, 33);
        throw new IllegalArgumentException(sb.append(mimeType2).append(str).toString());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2252cf
    public final boolean AJS(ZM zm) {
        String str = zm.A0W;
        String mimeType = A00(241, 8, 67);
        if (!mimeType.equals(str)) {
            String mimeType2 = A00(270, 10, 103);
            if (!mimeType2.equals(str)) {
                String mimeType3 = A00(127, 20, 9);
                if (!mimeType3.equals(str)) {
                    String mimeType4 = A00(172, 21, 20);
                    if (!mimeType4.equals(str)) {
                        String strA00 = A00(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 20, 29);
                        String[] strArr = A01;
                        String str2 = strArr[1];
                        String mimeType5 = strArr[0];
                        if (str2.length() != mimeType5.length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A01;
                        strArr2[1] = "LSWlkh0fDFDNaQVypUMAc4A0e05nv";
                        strArr2[0] = "iASn4GPIF6az2nAPLFcD0qUNWHsfq";
                        if (!strA00.equals(str)) {
                            String mimeType6 = A00(193, 28, 49);
                            if (!mimeType6.equals(str)) {
                                String mimeType7 = A00(55, 19, 20);
                                if (!mimeType7.equals(str)) {
                                    String mimeType8 = A00(147, 25, 79);
                                    if (!mimeType8.equals(str)) {
                                        String mimeType9 = A00(74, 19, 89);
                                        if (!mimeType9.equals(str)) {
                                            String mimeType10 = A00(93, 19, 84);
                                            if (!mimeType10.equals(str)) {
                                                String mimeType11 = A00(112, 15, 10);
                                                if (!mimeType11.equals(str)) {
                                                    String mimeType12 = A00(249, 21, 14);
                                                    if (!mimeType12.equals(str)) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
