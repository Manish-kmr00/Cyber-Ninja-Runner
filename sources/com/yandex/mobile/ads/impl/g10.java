package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i10 f8957a;
    private final rs0 b;
    private final ns1 c;

    public g10() {
        this(0);
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String lowerCase = this.f8957a.a(context).name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.b.a(context);
    }

    public /* synthetic */ g10(int i) {
        this(new i10(), new rs0());
    }

    public g10(i10 deviceTypeProvider, rs0 localeProvider) {
        Intrinsics.checkNotNullParameter(deviceTypeProvider, "deviceTypeProvider");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.f8957a = deviceTypeProvider;
        this.b = localeProvider;
        this.c = ns1.f9752a;
    }

    public final boolean c() {
        this.c.getClass();
        return ns1.a();
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String a() {
        return Build.MANUFACTURER;
    }
}
