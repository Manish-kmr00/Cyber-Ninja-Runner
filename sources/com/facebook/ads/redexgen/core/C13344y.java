package com.facebook.ads.redexgen.core;

import android.view.WindowInsets;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13344y {
    public final Object A00;

    public C13344y(Object obj) {
        this.A00 = obj;
    }

    public static C13344y A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C13344y(obj);
    }

    public static Object A01(C13344y c13344y) {
        if (c13344y == null) {
            return null;
        }
        return c13344y.A00;
    }

    public final int A02() {
        return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
    }

    public final int A03() {
        return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
    }

    public final int A04() {
        return ((WindowInsets) this.A00).getSystemWindowInsetRight();
    }

    public final int A05() {
        return ((WindowInsets) this.A00).getSystemWindowInsetTop();
    }

    public final C13344y A06(int i, int i2, int i3, int i4) {
        return new C13344y(((WindowInsets) this.A00).replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public final boolean A07() {
        return ((WindowInsets) this.A00).isConsumed();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C13344y c13344y = (C13344y) obj;
        if (this.A00 == null) {
            return c13344y.A00 == null;
        }
        return this.A00.equals(c13344y.A00);
    }

    public final int hashCode() {
        if (this.A00 == null) {
            return 0;
        }
        return this.A00.hashCode();
    }
}
