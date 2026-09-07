package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ak2 {
    @JvmStatic
    public static final q10 a(Context context) {
        WindowInsetsCompat windowInsetsCompatB;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            windowInsetsCompatB = b(context);
        } catch (Throwable th) {
            op0.b(th);
            windowInsetsCompatB = null;
        }
        if (windowInsetsCompatB == null) {
            return q10.e;
        }
        Insets insets = windowInsetsCompatB.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        int i = insets.left;
        int i2 = oh2.b;
        return new q10(oh2.b(i, bb0.a(context, "context").density), oh2.b(insets.top, bb0.a(context, "context").density), oh2.b(insets.right, bb0.a(context, "context").density), oh2.b(insets.bottom, bb0.a(context, "context").density));
    }

    private static WindowInsetsCompat b(Context context) {
        Activity activityA;
        if (!pa.a(30)) {
            if (!pa.a(28) || (activityA = p0.a()) == null) {
                return null;
            }
            View decorView = activityA.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            return ViewCompat.getRootWindowInsets(decorView);
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(currentWindowMetrics.getWindowInsets());
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        return windowInsetsCompat;
    }
}
