package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4h, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4h {
    public static final C13184g A00;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            A00 = new C0A() { // from class: com.facebook.ads.redexgen.X.06
            };
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            A00 = new C0A();
        } else if (Build.VERSION.SDK_INT >= 23) {
            A00 = new C0E();
        } else {
            A00 = new C0I();
        }
    }

    public static int A00(View view) {
        return A00.A02(view);
    }

    public static int A01(View view) {
        return A00.A03(view);
    }

    public static int A02(View view) {
        return A00.A04(view);
    }

    public static int A03(View view) {
        return A00.A05(view);
    }

    public static Display A04(View view) {
        return A00.A06(view);
    }

    public static C13344y A05(View view, C13344y c13344y) {
        return A00.A07(view, c13344y);
    }

    public static C13344y A06(View view, C13344y c13344y) {
        return A00.A08(view, c13344y);
    }

    public static void A07(View view) {
        A00.A09(view);
    }

    public static void A08(View view) {
        A00.A0A(view);
    }

    public static void A09(View view, int i) {
        A00.A0B(view, i);
    }

    public static void A0A(View view, Drawable drawable) {
        A00.A0C(view, drawable);
    }

    public static void A0B(View view, C4L c4l) {
        A00.A0D(view, c4l);
    }

    public static void A0C(View view, C4R c4r) {
        A00.A0E(view, c4r);
    }

    public static void A0D(View view, Runnable runnable) {
        A00.A0F(view, runnable);
    }

    public static void A0E(View view, Runnable runnable, long j) {
        A00.A0G(view, runnable, j);
    }

    public static boolean A0F(View view) {
        return A00.A0H(view);
    }

    public static boolean A0G(View view) {
        return A00.A0I(view);
    }

    public static boolean A0H(View view) {
        return A00.A0J(view);
    }
}
