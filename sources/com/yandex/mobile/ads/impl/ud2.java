package com.yandex.mobile.ads.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ud2 {
    @JvmStatic
    public static final Long a(String str) {
        if (str == null) {
            return null;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
            return Long.valueOf(simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse("00:00:00").getTime());
        } catch (ParseException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    @JvmStatic
    public static final void a(Object obj) {
        Intrinsics.checkNotNullParameter("AdBreak", "fieldDescription");
        if (obj != null) {
            return;
        }
        a();
        throw null;
    }

    private static void a() {
        throw new IllegalArgumentException("AdBreak not set!");
    }

    @JvmStatic
    public static final Integer b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
