package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QH implements InterfaceC1775Nb {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int[] A03;
    public static String[] A04 = {"xqrYX07Yw0YG5qAsDab", "0rIEtnrE6Ma11c7eLX5c1FWXrp8MXQc3", "rKWy8YezKmAuAof7V1NQelqCVUaH4lYg", "EjNPrbpZrwjpdeSvZcUyw1WIiKXdEIcx", "L0z", "fA8sWuPWKN1xsfjOGQsaZmA5F9zmEnLv", "ZcJUZ38SxuUX2NaxWUUIMchKENNrgGSy", "8eP"};
    public static final String A06 = AbstractC2471gE.A0h(0);
    public static final String A07 = AbstractC2471gE.A0h(1);
    public static final String A08 = AbstractC2471gE.A0h(2);
    public static final InterfaceC1774Na<QH> A05 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.QK
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return QH.A00(bundle);
        }
    };

    public QH(int i, int[] iArr, int i2) {
        this.A00 = i;
        this.A03 = Arrays.copyOf(iArr, iArr.length);
        this.A01 = iArr.length;
        this.A02 = i2;
        Arrays.sort(this.A03);
    }

    public static /* synthetic */ QH A00(Bundle bundle) {
        int i = bundle.getInt(A06, -1);
        int[] tracks = bundle.getIntArray(A07);
        int trackType = bundle.getInt(A08, -1);
        AbstractC2388es.A07(i >= 0 && trackType >= 0);
        AbstractC2388es.A01(tracks);
        return new QH(i, tracks, trackType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QH qh = (QH) obj;
        if (this.A00 == qh.A00) {
            int[] iArr = this.A03;
            if (A04[5].charAt(20) == '5') {
                throw new RuntimeException();
            }
            A04[1] = "1dK1IzNV07Adx89cAZ40Td0wFrgNdd6v";
            if (Arrays.equals(iArr, qh.A03) && this.A02 == qh.A02) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.A00 * 31) + Arrays.hashCode(this.A03)) * 31;
        int hash = this.A02;
        return iHashCode + hash;
    }
}
