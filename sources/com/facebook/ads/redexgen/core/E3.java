package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E3 extends AbstractC2060Yr {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = AbstractC2471gE.A0h(1);
    public static final String A03 = AbstractC2471gE.A0h(2);
    public static final InterfaceC1774Na<E3> A02 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.ZL
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return E3.A00(bundle);
        }
    };

    public E3() {
        this.A01 = false;
        this.A00 = false;
    }

    public E3(boolean z) {
        this.A01 = true;
        this.A00 = z;
    }

    public static E3 A00(Bundle bundle) {
        boolean isRated = bundle.getInt(AbstractC2060Yr.A02, -1) == 0;
        AbstractC2388es.A07(isRated);
        boolean isRated2 = bundle.getBoolean(A04, false);
        if (isRated2) {
            return new E3(bundle.getBoolean(A03, false));
        }
        return new E3();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof E3)) {
            return false;
        }
        E3 e3 = (E3) obj;
        return this.A00 == e3.A00 && this.A01 == e3.A01;
    }

    public final int hashCode() {
        return AbstractC1813Or.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
