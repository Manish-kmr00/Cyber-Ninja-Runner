package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class pg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9924a;

    public pg1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f9924a = applicationContext;
    }

    public final boolean a() {
        try {
            return this.f9924a.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
        } catch (Throwable unused) {
        }
    }

    public final boolean b() {
        try {
            return this.f9924a.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        } catch (Throwable unused) {
        }
    }
}
