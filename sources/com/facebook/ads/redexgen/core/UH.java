package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UH {
    public static byte[] A03;
    public static String[] A04 = {"uj3rHjsom0sJClJ0NXL20owYfKPkbjbH", "eUqJ", "Cr1o4bci3gKjAr", "zzOT1RDfG2NUKwUsy3v3W2TxBy4r4F5a", "acUgPngQbh7WcTiokqWVXKccQqVBnFri", "ylF8RDD69hYXHC0qztLOI9QQaaChlSMT", "00hAog7y3YSBpL", "cixT0iQJ8DilItVUY2IBeJ30KLQw1TrP"};
    public final int A00;
    public final int A01;
    public final String A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 46);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{101, 88, 70, 90, 77, 88, 8, 103, 117, 107, 102, 66, 79, 92, Ascii.ESC};
    }

    static {
        A02();
    }

    public UH(int i, int i2, String str) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = str;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    public static UH A00(C2447fq c2447fq) {
        String strA01;
        c2447fq.A0g(2);
        int profileData = c2447fq.A0I();
        int i = profileData >> 1;
        int iA0I = ((profileData & 1) << 5) | ((c2447fq.A0I() >> 3) & 31);
        if (i == 4 || i == 5) {
            strA01 = A01(7, 4, 45);
        } else {
            int dvProfile = A04[5].charAt(23);
            if (dvProfile == 49) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[2] = "UTwr8Gfi5u0Bqf";
            strArr[6] = "U5TU0pSnz8KYfM";
            if (i == 7) {
                strA01 = A01(7, 4, 45);
            } else if (i == 8) {
                strA01 = A01(11, 4, 4);
            } else if (i == 9) {
                strA01 = A01(3, 4, 21);
            } else {
                return null;
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(strA01);
        String strA02 = A01(1, 2, 88);
        StringBuilder sbAppend2 = sbAppend.append(strA02).append(i);
        if (iA0I >= 10) {
            int dvProfile2 = A04[5].charAt(23);
            if (dvProfile2 != 49) {
                A04[5] = "ikQXJXH3uRpZp9SzhVRDDJFpVDX0aXzw";
                strA02 = A01(0, 1, 101);
            } else {
                A04[0] = "9ape7dLSpMxDqEWlarqBNaR68otbSAt9";
                strA02 = A01(0, 1, 101);
            }
        }
        return new UH(i, iA0I, sbAppend2.append(strA02).append(iA0I).toString());
    }
}
