package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XK {
    public static byte[] A0B;
    public static String[] A0C = {"Ebptju1OilkgcHQEZEePTW6iT9tKrTtV", "1j5wDbzK8WGMiIKJ", "gfHC9K36xLa4Jl4jLZPZGTBHo0pOkbsp", "Ajx470iGFOyNZS", "Jy0O5FWEFX9zX9wb", "rWAzaVxClPoR0b1fl4kMaMzlm5SsULs6", "ZfnGm0CKKYB1tpiYcBuwkh9R", "FZ6uRnyA"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 92);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0B = new byte[]{-103, -83, -42, -39, -44, -56, -37, -95, Ascii.GS, 40, 37, 35, 42, 41, 33, 42, 48, 48, Base64.padSymbol, 58, 50, -16, -3, 0, -14, -13, 0, 1, 2, 7, -6, -13, -2, 7, 6, Ascii.FF, Ascii.VT, 1, Ascii.DC2, -3, -20, -9, -28, -17, -20, -26, 46, 33, 45, 37, -37, -31, -32, -40, -43, -38, -47, -49, -37, -40, -37, -31, -34, 42, 44, 35, 39, Ascii.ESC, 44, 51, Ascii.GS, 41, 38, 41, 47, 44, 44, 45, 43, 34, 36, Ascii.RS, 40, 46, 45, 41, 34, Ascii.CAN, Ascii.EM, 38, 32, Ascii.GS, 34, Ascii.EM};
    }

    static {
        A02();
    }

    public XK(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.A06 = i;
        this.A00 = i2;
        this.A08 = i3;
        this.A07 = i4;
        this.A03 = i5;
        this.A01 = i6;
        this.A04 = i7;
        this.A0A = i8;
        this.A09 = i9;
        this.A02 = i10;
        this.A05 = i11;
    }

    public static XK A00(String str) {
        int strikeoutIndex = -1;
        int borderStyleIndex = -1;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int nameIndex = A01(1, 7, 11).length();
        String[] strArrSplit = TextUtils.split(str.substring(nameIndex), A01(0, 1, 17));
        int boldIndex = 0;
        while (true) {
            int primaryColorIndex = strArrSplit.length;
            int alignmentIndex = A0C[3].length();
            if (alignmentIndex == 32) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "wrGwHprbPjJcEsvl";
            strArr[4] = "oLGBindF0w9QBe9l";
            int outlineColorIndex = -1;
            if (boldIndex < primaryColorIndex) {
                String strA01 = AbstractC2555hb.A01(strArrSplit[boldIndex].trim());
                int nameIndex2 = strA01.hashCode();
                switch (nameIndex2) {
                    case -1178781136:
                        if (strA01.equals(A01(40, 6, 39))) {
                            outlineColorIndex = 6;
                        }
                        break;
                    case -1026963764:
                        if (strA01.equals(A01(85, 9, 88))) {
                            outlineColorIndex = 7;
                        }
                        break;
                    case -192095652:
                        if (strA01.equals(A01(76, 9, 93))) {
                            outlineColorIndex = 8;
                        }
                        break;
                    case -70925746:
                        if (strA01.equals(A01(63, 13, 94))) {
                            outlineColorIndex = 2;
                        }
                        break;
                    case 3029637:
                        if (strA01.equals(A01(17, 4, 114))) {
                            outlineColorIndex = 5;
                        }
                        break;
                    case 3373707:
                        if (strA01.equals(A01(46, 4, 100))) {
                            outlineColorIndex = 0;
                        }
                        break;
                    case 366554320:
                        if (strA01.equals(A01(32, 8, 60))) {
                            outlineColorIndex = 4;
                        }
                        break;
                    case 767321349:
                        if (strA01.equals(A01(21, 11, 50))) {
                            outlineColorIndex = 9;
                        }
                        break;
                    case 1767875043:
                        if (strA01.equals(A01(8, 9, 96))) {
                            outlineColorIndex = 1;
                        }
                        break;
                    case 1988365454:
                        if (strA01.equals(A01(50, 13, 16))) {
                            outlineColorIndex = 3;
                        }
                        break;
                }
                switch (outlineColorIndex) {
                    case 0:
                        strikeoutIndex = boldIndex;
                        break;
                    case 1:
                        borderStyleIndex = boldIndex;
                        break;
                    case 2:
                        i = boldIndex;
                        break;
                    case 3:
                        i2 = boldIndex;
                        break;
                    case 4:
                        i3 = boldIndex;
                        break;
                    case 5:
                        i4 = boldIndex;
                        break;
                    case 6:
                        i5 = boldIndex;
                        break;
                    case 7:
                        i6 = boldIndex;
                        break;
                    case 8:
                        i7 = boldIndex;
                        break;
                    case 9:
                        i8 = boldIndex;
                        break;
                }
                boldIndex++;
            } else {
                if (strikeoutIndex != -1) {
                    int nameIndex3 = strArrSplit.length;
                    return new XK(strikeoutIndex, borderStyleIndex, i, i2, i3, i4, i5, i6, i7, i8, nameIndex3);
                }
                return null;
            }
        }
    }
}
