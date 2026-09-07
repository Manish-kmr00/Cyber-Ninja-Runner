package com.yandex.mobile.ads.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10679a = new a();

    static {
        String[] strArr = new String[15];
        DateFormat[] dateFormatArr = new DateFormat[15];
    }

    public static final String a(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String str = f10679a.get().format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(y82.d);
            return simpleDateFormat;
        }

        a() {
        }
    }
}
