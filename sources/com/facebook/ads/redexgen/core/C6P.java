package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6P {
    public C6M A00 = new C6M();
    public final C6N A01;

    public C6P(C6N c6n) {
        this.A01 = c6n;
    }

    public final View A00(int i, int i2, int i3, int i4) {
        int iA8X = this.A01.A8X();
        int next = this.A01.A8W();
        int childEnd = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA77 = this.A01.A77(i);
            int iA7A = this.A01.A7A(viewA77);
            int i5 = this.A01.A79(viewA77);
            this.A00.A03(iA8X, next, iA7A, i5);
            if (i3 != 0) {
                this.A00.A01();
                this.A00.A02(i3);
                if (this.A00.A04()) {
                    return viewA77;
                }
            }
            if (i4 != 0) {
                this.A00.A01();
                this.A00.A02(i4);
                if (this.A00.A04()) {
                    view = viewA77;
                }
            }
            i += childEnd;
        }
        return view;
    }
}
