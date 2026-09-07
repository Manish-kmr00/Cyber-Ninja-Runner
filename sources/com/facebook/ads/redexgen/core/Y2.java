package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y2 implements InterfaceC1775Nb {
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public static final Y2 A05 = new Y2(0, 0);
    public static final String A09 = AbstractC2471gE.A0h(0);
    public static final String A06 = AbstractC2471gE.A0h(1);
    public static final String A08 = AbstractC2471gE.A0h(2);
    public static final String A07 = AbstractC2471gE.A0h(3);
    public static final InterfaceC1774Na<Y2> A04 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Y3
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return Y2.A00(bundle);
        }
    };

    public Y2(int i, int i2) {
        this(i, i2, 0, 1.0f);
    }

    public Y2(int i, int i2, int i3, float f) {
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A00 = f;
    }

    public static /* synthetic */ Y2 A00(Bundle bundle) {
        int i = bundle.getInt(A09, 0);
        int i2 = bundle.getInt(A06, 0);
        int height = bundle.getInt(A08, 0);
        return new Y2(i, i2, height, bundle.getFloat(A07, 1.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y2)) {
            return false;
        }
        Y2 y2 = (Y2) obj;
        return this.A03 == y2.A03 && this.A01 == y2.A01 && this.A02 == y2.A02 && this.A00 == y2.A00;
    }

    public final int hashCode() {
        int result = this.A03;
        int result2 = ((((7 * 31) + result) * 31) + this.A01) * 31;
        int result3 = this.A02;
        return ((result2 + result3) * 31) + Float.floatToRawIntBits(this.A00);
    }
}
