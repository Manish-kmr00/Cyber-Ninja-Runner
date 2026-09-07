package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes8.dex */
public final class dp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r11 f8719a;
    private static final String b;
    private static boolean c;

    static {
        int i = r11.d;
        f8719a = r11.a.a();
        b = "YandexAds";
        c = true;
    }

    @JvmStatic
    public static final void b(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (c || h11.f9051a.a()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String strA = a(str);
            if (c) {
                Log.i(b, strA);
            }
            if (h11.f9051a.a()) {
                f8719a.a(g11.b, b, strA);
            }
        }
    }

    @JvmStatic
    public static final void c(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (c || h11.f9051a.a()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String strA = a(str);
            if (c) {
                Log.w(b, strA);
            }
            if (h11.f9051a.a()) {
                f8719a.a(g11.c, b, strA);
            }
        }
    }

    private static String a(String str) {
        return "[Integration] " + str;
    }

    @JvmStatic
    public static final void a(boolean z) {
        c = z;
    }

    @JvmStatic
    public static final void a(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (c || h11.f9051a.a()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String strA = a(str);
            if (c) {
                Log.e(b, strA);
            }
            if (h11.f9051a.a()) {
                f8719a.a(g11.d, b, strA);
            }
        }
    }
}
