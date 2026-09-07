package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13957i {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06;
    public final C13967j A00;
    public final C13977k A01;
    public final C2698k0 A02;
    public final InterfaceC1695Jq A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{122, 108, 71, 125, 96, 108, 106, 121, 107};
    }

    static {
        A01();
        A06 = C13957i.class.getSimpleName();
    }

    public C13957i(C2698k0 c2698k0, InterfaceC2107aF interfaceC2107aF, C13967j c13967j, C13977k c13977k) {
        this.A02 = c2698k0;
        this.A03 = interfaceC2107aF.A5K(EnumC1696Jr.A06);
        this.A00 = c13967j;
        this.A01 = c13977k;
        this.A03.A3r(new C2707k9(this));
        A02();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (!this.A03.AAT()) {
                this.A02.A05().AAD();
                return;
            }
            String btExtras = this.A03.A7Y().optString(A00(0, 9, 7));
            if (!TextUtils.isEmpty(btExtras)) {
                this.A00.A04(this.A02, btExtras);
                if (!A04 || C14499m.A0i(this.A02)) {
                    A04 = true;
                    this.A01.A07();
                }
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
