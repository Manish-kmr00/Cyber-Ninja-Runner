package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f6913a = LazyKt.lazy(a.f6914a);
    public static final Regex b = new Regex("\\[ERRORCODE]");
    public static final Regex c = new Regex("\\[CONTENTPLAYHEAD]");
    public static final Regex d = new Regex("\\[CACHEBUSTING]");
    public static final Regex e = new Regex("\\[ASSETURI]");
    public static final Regex f = new Regex("\\[[^]]*]");
    public static final Regex g = new Regex("\\[MEDIAPLAYHEAD]");
    public static final Regex h = new Regex("\\[ADPLAYHEAD]");

    public static final class a extends Lambda implements Function0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6914a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m invoke() {
            return new m(com.moloco.sdk.service_locator.a.i.f6483a.c());
        }
    }

    public static final String c() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%08d", Arrays.copyOf(new Object[]{Integer.valueOf(Random.INSTANCE.nextInt(1, 99999999))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public static final m d() {
        return (m) f6913a.getValue();
    }

    public static final l a() {
        return d();
    }

    public static final String b(String str, Integer num, Integer num2, String str2, String str3) {
        if (num != null) {
            num.intValue();
            str = b.replace(str, num.toString());
        }
        if (num2 != null) {
            num2.intValue();
            str = g.replace(h.replace(c.replace(str, b(num2.intValue())), a(num2.intValue())), c(num2.intValue()));
        }
        if (str2 != null) {
            str = e.replace(str, a(str2));
        }
        if (str3 != null) {
            str = d.replace(str, str3);
        }
        return f.replace(str, "");
    }

    public static final String c(int i) {
        return "-1";
    }

    public static final String a(int i) {
        return b(i);
    }

    public static final String a(String str) {
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "{\n        URLEncoder.encode(this, \"UTF-8\")\n    }");
            return strEncode;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String b(int i) {
        long j = i;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String str = String.format("%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % ((long) 1000))}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
