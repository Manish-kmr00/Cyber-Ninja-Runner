package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class wm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r11 f10576a;
    public static final /* synthetic */ int b = 0;

    static {
        int i = r11.d;
        f10576a = r11.a.a();
    }

    public static void a(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (op0.a() || h11.f9051a.a()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            if (op0.a()) {
                Log.w("Yandex Mobile Ads", str);
            }
            if (h11.f9051a.a()) {
                f10576a.a(g11.c, "Yandex Mobile Ads", str);
            }
        }
    }
}
