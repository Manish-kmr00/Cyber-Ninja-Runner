package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ID {
    public static byte[] A07;
    public final C2232cL A02;
    public final C1747Lr A04;
    public final String A05;
    public final Map<String, String> A06;
    public final AbstractC2211c0 A03 = new C1711Kg(this);
    public int A01 = 0;
    public int A00 = 0;

    static {
        A04();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{-116, -99, -116, -107, -101, -122, -112, -107, -117, -116, -97, 3, Ascii.SI, -2, 10, 2, -4, 0, Ascii.FF, Ascii.DC2, Ascii.VT, 17, -90, -78, -95, -83, -91, -77};
    }

    public ID(C2232cL c2232cL, String str, Map<String, String> extraParams) {
        this.A05 = str;
        this.A02 = c2232cL;
        this.A06 = extraParams;
        this.A04 = new C1747Lr(this.A05);
        this.A02.getEventBus().A05(this.A03);
    }

    public static /* synthetic */ int A00(ID id) {
        int i = id.A01;
        id.A01 = i + 1;
        return i;
    }

    public final Map<String, String> A05() {
        String strA01 = C1747Lr.A01(this.A04.A03());
        HashMap map = new HashMap();
        if (this.A06 != null) {
            map.putAll(this.A06);
        }
        if (strA01 == null) {
            strA01 = A02(0, 0, 25);
        }
        map.put(A02(22, 6, 33), strA01);
        map.put(A02(11, 11, 126), String.valueOf(this.A01));
        int i = this.A00 + 1;
        this.A00 = i;
        map.put(A02(0, 11, 8), String.valueOf(i));
        return map;
    }

    public final void A06() {
        this.A02.getEventBus().A06(this.A03);
    }
}
