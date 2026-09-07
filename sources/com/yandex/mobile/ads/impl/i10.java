package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt1 f9162a;
    private final kt1 b;

    public /* synthetic */ i10() {
        this(new bt1());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
    
        if (r8.getCurrentModeType() == 4) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
    
        if (r8.getPackageManager().hasSystemFeature("android.hardware.touchscreen") == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.yandex.mobile.ads.impl.h10 a(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            android.util.DisplayMetrics r1 = com.yandex.mobile.ads.impl.bb0.a(r8, r0)
            com.yandex.mobile.ads.impl.kt1 r2 = r7.b
            android.graphics.Point r2 = r2.a(r8)
            int r3 = r2.x
            int r2 = r2.y
            float r1 = r1.density
            float r3 = (float) r3
            float r4 = r3 / r1
            float r2 = (float) r2
            float r5 = r2 / r1
            float r4 = kotlin.ranges.RangesKt.coerceAtMost(r4, r5)
            r5 = 160(0xa0, float:2.24E-43)
            float r5 = (float) r5
            float r1 = r1 * r5
            float r3 = r3 / r1
            float r2 = r2 / r1
            float r3 = r3 * r3
            float r2 = r2 * r2
            float r2 = r2 + r3
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            r3 = 13
            boolean r3 = com.yandex.mobile.ads.impl.pa.a(r3)
            if (r3 == 0) goto L4a
            java.lang.String r0 = "uimode"
            java.lang.Object r8 = r8.getSystemService(r0)
            boolean r0 = r8 instanceof android.app.UiModeManager
            if (r0 == 0) goto L3f
            android.app.UiModeManager r8 = (android.app.UiModeManager) r8
            goto L40
        L3f:
            r8 = 0
        L40:
            if (r8 == 0) goto L73
            int r8 = r8.getCurrentModeType()
            r0 = 4
            if (r8 != r0) goto L73
            goto L70
        L4a:
            r5 = 4624633867356078080(0x402e000000000000, double:15.0)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L73
            com.yandex.mobile.ads.impl.bt1 r3 = r7.f9162a
            r3.getClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "name"
            java.lang.String r3 = "android.hardware.touchscreen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: java.lang.Throwable -> L6a
            boolean r8 = r8.hasSystemFeature(r3)     // Catch: java.lang.Throwable -> L6a
            if (r8 != 0) goto L73
            goto L70
        L6a:
            r8 = 0
            java.lang.Object[] r8 = new java.lang.Object[r8]
            com.yandex.mobile.ads.impl.op0.c(r8)
        L70:
            com.yandex.mobile.ads.impl.h10 r8 = com.yandex.mobile.ads.impl.h10.d
            return r8
        L73:
            r5 = 4619567317775286272(0x401c000000000000, double:7.0)
            int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r8 >= 0) goto L83
            r8 = 1142292480(0x44160000, float:600.0)
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 < 0) goto L80
            goto L83
        L80:
            com.yandex.mobile.ads.impl.h10 r8 = com.yandex.mobile.ads.impl.h10.b
            goto L85
        L83:
            com.yandex.mobile.ads.impl.h10 r8 = com.yandex.mobile.ads.impl.h10.c
        L85:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.i10.a(android.content.Context):com.yandex.mobile.ads.impl.h10");
    }

    public i10(bt1 safePackageManager) {
        Intrinsics.checkNotNullParameter(safePackageManager, "safePackageManager");
        this.f9162a = safePackageManager;
        this.b = new kt1();
    }
}
