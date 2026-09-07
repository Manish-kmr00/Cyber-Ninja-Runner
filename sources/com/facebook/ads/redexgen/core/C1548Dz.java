package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1548Dz extends AbstractC2060Yr {
    public static byte[] A01;
    public static final InterfaceC1774Na<C1548Dz> A02;
    public static final String A03;
    public final float A00;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{32, 53, 34, 51, 53, 62, 36, 112, Base64.padSymbol, 37, 35, 36, 112, 50, 53, 112, 57, 62, 112, 36, 56, 53, 112, 34, 49, 62, 55, 53, 112, 63, 54, 112, Ascii.VT, 96, 124, 112, 97, 96, 96, Ascii.CR};
    }

    static {
        A03();
        A03 = AbstractC2471gE.A0h(1);
        A02 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Z8
            @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
            public final InterfaceC1775Nb A6V(Bundle bundle) {
                return C1548Dz.A00(bundle);
            }
        };
    }

    public C1548Dz() {
        this.A00 = -1.0f;
    }

    public C1548Dz(float f) {
        AbstractC2388es.A09(f >= 0.0f && f <= 100.0f, A02(0, 40, 4));
        this.A00 = f;
    }

    public static C1548Dz A00(Bundle bundle) {
        AbstractC2388es.A07(bundle.getInt(AbstractC2060Yr.A02, -1) == 1);
        float f = bundle.getFloat(A03, -1.0f);
        return f == -1.0f ? new C1548Dz() : new C1548Dz(f);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1548Dz) && this.A00 == ((C1548Dz) obj).A00;
    }

    public final int hashCode() {
        return AbstractC1813Or.A00(Float.valueOf(this.A00));
    }
}
