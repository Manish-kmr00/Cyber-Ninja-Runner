package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WP {
    public static byte[] A05;
    public static String[] A06 = {"KHCt4frvDkKshICcUrq132zIrmtDdnSU", "NfmQTohX8ER0xRkghOCuc5NhbIvXt6sK", "", "LQAPDnufH1IbXJuWkKGdMQkSNtCiMLs6", "CYKeElTsYUvzx2jzIwklWkzXtzJ3PGrg", "AraRtnwsGm9vMrJxVcKOamDTh279HA2i", "eMrQ6EyYPQXepM9ear0xYLgK7RlUGwgn", "iGqindczD9XGJAcMytEcInY6pYjypdvq"};
    public int A00;
    public final InterfaceC1957Uo A01;
    public final C1958Up A02;
    public final WZ A03;
    public final C1995Wc A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr = A06;
            if (strArr[4].charAt(22) != strArr[0].charAt(22)) {
                throw new RuntimeException();
            }
            A06[6] = "tMzdqHyqHtX34y6x3xLDF3vxUsqaH2zl";
            bArrCopyOfRange[i4] = (byte) (i5 - 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{127, -109, -126, -121, -115, 77, -110, -112, -109, -125, 75, -122, -126};
    }

    static {
        A01();
    }

    public WP(WZ wz, C1995Wc c1995Wc, InterfaceC1957Uo interfaceC1957Uo) {
        C1958Up c1958Up;
        this.A03 = wz;
        this.A04 = c1995Wc;
        this.A01 = interfaceC1957Uo;
        if (A00(0, 13, 20).equals(wz.A07.A0W)) {
            c1958Up = new C1958Up();
        } else {
            c1958Up = null;
        }
        this.A02 = c1958Up;
    }
}
