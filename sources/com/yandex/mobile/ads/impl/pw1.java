package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes11.dex */
public final class pw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s11 f9954a;

    public /* synthetic */ pw1() {
        this(new s11());
    }

    public pw1(s11 mobileAdsVersionInfoProvider) {
        Intrinsics.checkNotNullParameter(mobileAdsVersionInfoProvider, "mobileAdsVersionInfoProvider");
        this.f9954a = mobileAdsVersionInfoProvider;
    }

    public final String a() {
        this.f9954a.getClass();
        ya2 ya2VarA = s11.a();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%d.%d%d", Arrays.copyOf(new Object[]{Integer.valueOf(ya2VarA.a()), Integer.valueOf(ya2VarA.b()), Integer.valueOf(ya2VarA.c())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String b() {
        this.f9954a.getClass();
        ya2 ya2VarA = s11.a();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%d.%d.%d", Arrays.copyOf(new Object[]{Integer.valueOf(ya2VarA.a()), Integer.valueOf(ya2VarA.b()), Integer.valueOf(ya2VarA.c())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
