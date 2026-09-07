package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NH extends AbstractC2901nN<EnumC12371d> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-56, -49, -58, -58};
    }

    public NH(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2901nN
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final C12451l A04(EnumC12371d enumC12371d) {
        return new C12451l(this, enumC12371d == null ? A00(0, 4, 46) : A00(0, 0, 18) + enumC12371d.A03());
    }
}
