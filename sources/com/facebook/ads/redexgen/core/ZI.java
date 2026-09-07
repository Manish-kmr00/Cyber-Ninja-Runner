package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZI implements InterfaceC1775Nb {
    public final long A00;
    public final long A01;
    public final boolean A02;
    public final boolean A03;
    public final boolean A04;
    public static String[] A05 = {"WE856I1D7v90M03AtN7u5CUshFII", "YY", "Odx4tx", "C0dXY9C02juTY7PRsP", "Zmbve6ctgzTknKTNVrKNXRfeXIDI6wHO", "sHwtI77mu88Oz2nCT6ek40k6uqvm6RO9", "ZJtM837Qw", "YZpc4uNSb72T74lt4Mfrr5gnRX1"};
    public static final ZI A07 = new PI().A0A();
    public static final InterfaceC1774Na<E1> A06 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZJ
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return new PI().A06(bundle.getLong(ZI.A01(0), 0L)).A05(bundle.getLong(ZI.A01(1), Long.MIN_VALUE)).A08(bundle.getBoolean(ZI.A01(2), false)).A07(bundle.getBoolean(ZI.A01(3), false)).A09(bundle.getBoolean(ZI.A01(4), false)).A0B();
        }
    };

    public ZI(PI pi) {
        this.A01 = pi.A01;
        this.A00 = pi.A00;
        this.A03 = pi.A03;
        this.A02 = pi.A02;
        this.A04 = pi.A04;
    }

    public static String A01(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZI)) {
            return false;
        }
        ZI zi = (ZI) obj;
        if (this.A01 == zi.A01 && this.A00 == zi.A00) {
            boolean z = this.A03;
            if (A05[2].length() != 6) {
                throw new RuntimeException();
            }
            A05[2] = "3urT3G";
            if (z == zi.A03 && this.A02 == zi.A02 && this.A04 == zi.A04) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((int) (this.A01 ^ (this.A01 >>> 32))) * 31) + ((int) (this.A00 ^ (this.A00 >>> 32)))) * 31) + (this.A03 ? 1 : 0)) * 31) + (this.A02 ? 1 : 0)) * 31) + (this.A04 ? 1 : 0);
    }
}
