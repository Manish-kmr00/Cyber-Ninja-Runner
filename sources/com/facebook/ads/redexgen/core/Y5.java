package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y5 implements InterfaceC1775Nb {
    public final int A00;
    public final C2046Yc A01;
    public final boolean A02;
    public final int[] A03;
    public final boolean[] A04;
    public static String[] A05 = {"odLreCOpdH007Ch4D5hl3ZS9GvgsNcuI", "H1sbgn4G2B5HARFVJgetvcZga0JJ3ao4", "XGxlN", "BGZcnKEOyelcSbCKkdj3Sc7Y7kH4R3HP", "", "Yq8lI9SkFwkHj", "hIlpZjxbfirodj9cbn6P6dRuHjZ4Y9fZ", ""};
    public static final String A08 = AbstractC2471gE.A0h(0);
    public static final String A0A = AbstractC2471gE.A0h(1);
    public static final String A09 = AbstractC2471gE.A0h(3);
    public static final String A07 = AbstractC2471gE.A0h(4);
    public static final InterfaceC1774Na<Y5> A06 = new InterfaceC1774Na() { // from class: com.facebook.ads.redexgen.X.Y6
        @Override // com.facebook.ads.redexgen.core.InterfaceC1774Na
        public final InterfaceC1775Nb A6V(Bundle bundle) {
            return Y5.A00(bundle);
        }
    };

    public Y5(C2046Yc c2046Yc, boolean z, int[] iArr, boolean[] zArr) {
        this.A00 = c2046Yc.A01;
        boolean z2 = false;
        AbstractC2388es.A07(this.A00 == iArr.length && this.A00 == zArr.length);
        this.A01 = c2046Yc;
        if (z && this.A00 > 1) {
            z2 = true;
        }
        this.A02 = z2;
        this.A03 = (int[]) iArr.clone();
        this.A04 = (boolean[]) zArr.clone();
    }

    public static /* synthetic */ Y5 A00(Bundle bundle) {
        C2046Yc c2046Yc = (C2046Yc) C2046Yc.A07.A6V((Bundle) AbstractC2388es.A01(bundle.getBundle(A08)));
        int[] iArr = (int[]) AbstractC2581i4.A00(bundle.getIntArray(A0A), new int[c2046Yc.A01]);
        boolean[] selected = (boolean[]) AbstractC2581i4.A00(bundle.getBooleanArray(A09), new boolean[c2046Yc.A01]);
        return new Y5(c2046Yc, bundle.getBoolean(A07, false), iArr, selected);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            if (A05[4].length() != 0) {
                throw new RuntimeException();
            }
            A05[0] = "S8rMFuAgWupQyXQFdWfnWOW98udJ6Qun";
            if (cls == cls2) {
                Y5 y5 = (Y5) obj;
                if (this.A02 == y5.A02 && this.A01.equals(y5.A01) && Arrays.equals(this.A03, y5.A03) && Arrays.equals(this.A04, y5.A04)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01.hashCode() * 31) + (this.A02 ? 1 : 0)) * 31) + Arrays.hashCode(this.A03)) * 31) + Arrays.hashCode(this.A04);
    }
}
