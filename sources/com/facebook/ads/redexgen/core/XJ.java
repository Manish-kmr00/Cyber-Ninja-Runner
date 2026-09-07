package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XJ {
    public static byte[] A05;
    public static String[] A06 = {"58By1xz9Rh5hryJLIDyh003hjsI0lyIE", "HjtrxM8ilO8Z2FhyLxFPsyBcrsn62jy2", "4dBhv8AxOYr8CGU3ph7faumyuTKAx0Kp", "778pKx87nActyaaewVQmaW5nz6FNYXsy", "gseVCSHD1mFENwOgl8q7q8G1wYU2PWoi", "AtIPg5CtYVFE3mrbL7ZpQzYtC1CxgwKG", "vwPZh3w8Bw5byhp8wA0eqZa2uXs5Fkwp", "RAnITn0AZcJID8b1fAncsOtB2RKhCJQa"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{83, 39, Ascii.SO, 19, Ascii.FF, 0, Ascii.NAK, 91, 103, 108, 102, 43, 44, 57, 42, 44, 43, 44, 33, 52, Base64.padSymbol, 102, 119, 106, 102};
    }

    static {
        A02();
    }

    public XJ(int i, int i2, int i3, int i4, int i5) {
        this.A02 = i;
        this.A00 = i2;
        this.A03 = i3;
        this.A04 = i4;
        this.A01 = i5;
    }

    public static XJ A00(String str) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        String strA01 = A01(1, 7, 98);
        AbstractC2388es.A07(str.startsWith(strA01));
        int startTimeIndex = strA01.length();
        String[] keys = TextUtils.split(str.substring(startTimeIndex), A01(0, 1, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
        int i5 = 0;
        while (true) {
            int startTimeIndex2 = keys.length;
            int textIndex = -1;
            if (i5 < startTimeIndex2) {
                String strA02 = AbstractC2555hb.A01(keys[i5].trim());
                int startTimeIndex3 = strA02.hashCode();
                switch (startTimeIndex3) {
                    case 100571:
                        if (strA02.equals(A01(8, 3, 1))) {
                            textIndex = 1;
                        }
                        break;
                    case 3556653:
                        String strA03 = A01(21, 4, 17);
                        String[] strArr = A06;
                        String str2 = strArr[6];
                        String str3 = strArr[7];
                        int endTimeIndex = str2.charAt(23);
                        int startTimeIndex4 = str3.charAt(23);
                        if (endTimeIndex == startTimeIndex4) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A06;
                        strArr2[6] = "hm9yiOYAKaTdT4AAKs2MzvMODTkeDI71";
                        strArr2[7] = "rkHMaKqyJB66rLyWKGxaX3BTM0hlAx65";
                        if (strA02.equals(strA03)) {
                            textIndex = 3;
                        }
                        break;
                        break;
                    case 109757538:
                        String strA04 = A01(11, 5, 91);
                        String[] strArr3 = A06;
                        String str4 = strArr3[6];
                        String str5 = strArr3[7];
                        int endTimeIndex2 = str4.charAt(23);
                        int startTimeIndex5 = str5.charAt(23);
                        if (endTimeIndex2 == startTimeIndex5) {
                            throw new RuntimeException();
                        }
                        String[] strArr4 = A06;
                        strArr4[0] = "t0Mmc8Epbz1mx1DDeVgK7AGTczF7jz2K";
                        strArr4[4] = "9ZCXatAEgZlVxkwxK9MRCc28dOTrxdqB";
                        if (strA02.equals(strA04)) {
                            textIndex = 0;
                        }
                        break;
                        break;
                    case 109780401:
                        if (strA02.equals(A01(16, 5, 91))) {
                            textIndex = 2;
                        }
                        break;
                }
                switch (textIndex) {
                    case 0:
                        i = i5;
                        break;
                    case 1:
                        i2 = i5;
                        break;
                    case 2:
                        i3 = i5;
                        break;
                    case 3:
                        i4 = i5;
                        break;
                }
                i5++;
            } else {
                if (i != -1 && i2 != -1 && i4 != -1) {
                    return new XJ(i, i2, i3, i4, keys.length);
                }
                return null;
            }
        }
    }
}
