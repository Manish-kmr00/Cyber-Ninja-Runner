package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XO {
    public static byte[] A0A;
    public static String[] A0B = {"Ra1PaCkh1rgi790ufp8e8JsgDkHtaiwn", "XjKtRiBw03jyMrDwhe0OFsIRvq9LMiCW", "PmnysjqZLOgI7TVJzuO99Pn16krx", "hvdEVhgzapQEYk1Pwq7sghpO51NdDPff", "x0pRs1fi7hlUzZqqSt8WTBfGELE5t4G", "KVE5AursVu26pREVdnY1R7nJBPi7CMsp", "3gjQu2LYQHB3CxsZGi5cn9GrIGCdG10", "I1UJ3rdjbYF9W7gJ9858vTrwCI0z"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final Integer A03;
    public final Integer A04;
    public final String A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{-17, 17, 9, -4, 41, 68, 76, 79, 72, 71, 3, 87, 82, 3, 83, 68, 85, 86, 72, 3, 69, 82, 82, 79, 72, 68, 81, 3, 89, 68, 79, 88, 72, Ascii.GS, 3, 10, -34, -7, 1, 4, -3, -4, -72, Ascii.FF, 7, -72, 8, -7, 10, Ascii.VT, -3, -72, -5, 7, 4, 7, 10, -72, -3, Ascii.DLE, 8, 10, -3, Ascii.VT, Ascii.VT, 1, 7, 6, -46, -72, -65, -28, -1, 7, 10, 3, 2, -66, Ascii.DC2, Ascii.CR, -66, Ascii.SO, -1, Ascii.DLE, 17, 3, -66, 4, Ascii.CR, Ascii.FF, Ascii.DC2, -66, 17, 7, Ascii.CAN, 3, -40, -66, -59, Ascii.CR, 43, 50, 51, 54, 45, 50, 43, -28, 57, 50, 47, 50, 51, 59, 50, -28, 6, 51, 54, 40, 41, 54, Ascii.ETB, 56, Base64.padSymbol, 48, 41, -2, -28, -10, Ascii.DC4, Ascii.ESC, Ascii.FS, Ascii.US, Ascii.SYN, Ascii.ESC, Ascii.DC4, -51, 34, Ascii.ESC, Ascii.CAN, Ascii.ESC, Ascii.FS, 36, Ascii.ESC, -51, Ascii.SO, Ascii.EM, Ascii.SYN, Ascii.DC4, Ascii.ESC, Ascii.SUB, Ascii.DC2, Ascii.ESC, 33, -25, -51, -27, -3, -5, 2, 2, -5, 0, -7, -78, -1, -13, -2, -8, 1, 4, -1, -9, -10, -78, -71, -27, 6, Ascii.VT, -2, -9, -52, -71, -78, -2, -5, 0, -9, -78, -70, -9, 10, 2, -9, -11, 6, -9, -10, -78, -73, 5, -78, 8, -13, -2, 7, -9, 5, -66, -78, -8, 1, 7, 0, -10, -78, -73, 5, -69, -52, -78, -71, -73, 5, -71, -25, -1, -3, 4, 4, -3, 2, -5, -76, 1, -11, 0, -6, 3, 6, 1, -7, -8, -76, -69, -25, 8, Ascii.CR, 0, -7, -50, -69, -76, 0, -3, 2, -7, -50, -76, -69, 4, 36, Ascii.DC2, 4, 37, 42, Ascii.GS, Ascii.SYN, 5, 38, 43, Ascii.RS, Ascii.ETB, -20};
    }

    static {
        A07();
    }

    public XO(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.A05 = str;
        this.A01 = i;
        this.A04 = num;
        this.A03 = num2;
        this.A00 = f;
        this.A06 = z;
        this.A07 = z2;
        this.A09 = z3;
        this.A08 = z4;
        this.A02 = i2;
    }

    public static float A00(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            AbstractC2432fb.A0A(A06(261, 8, 75), A06(71, 28, 56) + str + A06(2, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), e);
            return -3.4028235E38f;
        }
    }

    public static int A01(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            if (A08(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC2432fb.A07(A06(261, 8, 75), A06(129, 28, 71) + str);
        return -1;
    }

    public static int A02(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            if (A09(i)) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC2432fb.A07(A06(261, 8, 75), A06(99, 30, 94) + str);
        return -1;
    }

    public static XO A04(String str, XK xk) {
        int iA01;
        Integer numA05;
        Integer numA06;
        float fA00;
        String strA06 = A06(269, 6, 76);
        AbstractC2388es.A07(str.startsWith(strA06));
        String[] strArrSplit = TextUtils.split(str.substring(strA06.length()), A06(3, 1, 106));
        int length = strArrSplit.length;
        int i = xk.A05;
        String strA07 = A06(261, 8, 75);
        if (length != i) {
            AbstractC2432fb.A07(strA07, AbstractC2471gE.A0n(A06(157, 69, 44), Integer.valueOf(xk.A05), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[xk.A06].trim();
            if (xk.A00 != -1) {
                iA01 = A01(strArrSplit[xk.A00].trim());
            } else {
                iA01 = -1;
            }
            if (xk.A08 != -1) {
                numA05 = A05(strArrSplit[xk.A08].trim());
            } else {
                numA05 = null;
            }
            if (xk.A07 != -1) {
                numA06 = A05(strArrSplit[xk.A07].trim());
            } else {
                numA06 = null;
            }
            if (xk.A03 != -1) {
                fA00 = A00(strArrSplit[xk.A03].trim());
            } else {
                fA00 = -3.4028235E38f;
            }
            return new XO(strTrim, iA01, numA05, numA06, fA00, xk.A01 != -1 && A0A(strArrSplit[xk.A01].trim()), xk.A04 != -1 && A0A(strArrSplit[xk.A04].trim()), xk.A0A != -1 && A0A(strArrSplit[xk.A0A].trim()), xk.A09 != -1 && A0A(strArrSplit[xk.A09].trim()), xk.A02 != -1 ? A02(strArrSplit[xk.A02].trim()) : -1);
        } catch (RuntimeException e) {
            AbstractC2432fb.A0A(strA07, A06(226, 35, 46) + str + A06(2, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), e);
            return null;
        }
    }

    public static Integer A05(String str) {
        long j;
        try {
            if (str.startsWith(A06(0, 2, 99))) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            AbstractC2388es.A07(j <= 4294967295L);
            int iA03 = AbstractC1785Nn.A03(((j >> 24) & 255) ^ 255);
            int r = AbstractC1785Nn.A03((j >> 16) & 255);
            int g = AbstractC1785Nn.A03((j >> 8) & 255);
            int iA04 = AbstractC1785Nn.A03(j & 255);
            int b = A0B[5].charAt(6);
            if (b == 112) {
                throw new RuntimeException();
            }
            A0B[1] = "r6xLINEFKHUGTP8iRUGYtPtWO4lkXsfs";
            int a2 = Color.argb(iA03, iA04, g, r);
            return Integer.valueOf(a2);
        } catch (IllegalArgumentException e) {
            AbstractC2432fb.A0A(A06(261, 8, 75), A06(36, 35, 50) + str + A06(2, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), e);
            return null;
        }
    }

    public static boolean A08(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean A09(int i) {
        switch (i) {
            case 1:
            case 3:
                return true;
            case 2:
            default:
                String[] strArr = A0B;
                if (strArr[6].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                A0B[1] = "gBv9lIebqrU56j4K0xEBDyZ3G03KYZRu";
                return false;
        }
    }

    public static boolean A0A(String str) {
        try {
            int value = Integer.parseInt(str);
            return value == 1 || value == -1;
        } catch (NumberFormatException e) {
            AbstractC2432fb.A0A(A06(261, 8, 75), A06(4, 32, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) + str + A06(2, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), e);
            return false;
        }
    }
}
