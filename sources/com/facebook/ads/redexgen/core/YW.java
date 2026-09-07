package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YW implements InterfaceC1775Nb {
    public final C2046Yc A00;
    public final OI<Integer> A01;
    public static String[] A02 = {"OQjHVUnAb3M4yPg73cj2ExQGx1P7QvBk", "BukhetsXYQL7c6JHDJJ5EP3ck6DyGpj0", "aX3Ins7TsVgi5hdMPSLnWMnRhfMbO1Hr", "FTA0xI7mjyBA2ArjxwaA7", "3FKZRHrTFneXliTV5EYrlFkMzlAmVooI", "Djt1WoPbz8ZHZb", "c93Hiz2QWH", "ufUKlqrJ6pUBORQ1Zceq6"};
    public static final String A05 = AbstractC2471gE.A0h(0);
    public static final String A04 = AbstractC2471gE.A0h(1);
    public static final InterfaceC1774Na<YW> A03 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.YY
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return YW.A00(bundle);
        }
    };

    public YW(C2046Yc c2046Yc, List<Integer> trackIndices) {
        if (trackIndices.isEmpty() || (((Integer) Collections.min(trackIndices)).intValue() >= 0 && ((Integer) Collections.max(trackIndices)).intValue() < c2046Yc.A01)) {
            this.A00 = c2046Yc;
            this.A01 = OI.A05(trackIndices);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public static /* synthetic */ YW A00(Bundle bundle) {
        return new YW((C2046Yc) C2046Yc.A07.A6V((Bundle) AbstractC2388es.A01(bundle.getBundle(A05))), AbstractC1785Nn.A0A((int[]) AbstractC2388es.A01(bundle.getIntArray(A04))));
    }

    public final int A01() {
        return this.A00.A02;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        YW yw = (YW) obj;
        if (this.A00.equals(yw.A00)) {
            OI<Integer> oi = this.A01;
            if (A02[5].length() != 14) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "M4ilP49mfqhoydJJxm7FEXBxuMxY2XWm";
            strArr[0] = "DX6ocqz7UD7IMDHaXN2e4CRdPDLsRh3x";
            if (oi.equals(yw.A01)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.A00.hashCode() + (this.A01.hashCode() * 31);
    }
}
