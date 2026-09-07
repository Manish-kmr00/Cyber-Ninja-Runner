package com.facebook.ads.redexgen.core;

import android.text.Layout;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X0 {
    public static final Comparator<X0> A02 = new Comparator() { // from class: com.facebook.ads.redexgen.X.Wz
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((X0) obj2).A00, ((X0) obj).A00);
        }
    };
    public final int A00;
    public final C1853Qh A01;

    public X0(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        C2245cY cueBuilder = new C2245cY().A0G(charSequence).A0F(alignment).A07(f, i).A09(i2).A04(f2).A0A(i3).A06(f3);
        if (z) {
            cueBuilder.A0C(i4);
        }
        this.A01 = cueBuilder.A0H();
        this.A00 = i5;
    }
}
