package com.ogury.ad.internal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeZone f7293a;

    public e9() {
        TimeZone utcTimezone = TimeZone.getTimeZone("UTC");
        Intrinsics.checkNotNullExpressionValue(utcTimezone, "getTimeZone(...)");
        Intrinsics.checkNotNullParameter(utcTimezone, "utcTimezone");
        this.f7293a = utcTimezone;
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static String b() {
        try {
            String str = new SimpleDateFormat("Z", Locale.US).format(new Date());
            Intrinsics.checkNotNull(str);
            String strSubstring = str.substring(0, 3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = str.substring(3, str.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return strSubstring + ":" + strSubstring2;
        } catch (Exception unused) {
            u3.f7411a.getClass();
            return "";
        }
    }
}
