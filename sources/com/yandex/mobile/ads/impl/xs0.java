package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class xs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10676a;
    private final co1 b;
    private final Context c;

    public /* synthetic */ xs0(Context context, String str) {
        this(context, str, new co1());
    }

    public xs0(Context context, String locationServicesClassName, co1 reflectHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locationServicesClassName, "locationServicesClassName");
        Intrinsics.checkNotNullParameter(reflectHelper, "reflectHelper");
        this.f10676a = locationServicesClassName;
        this.b = reflectHelper;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
    }

    public final ee0 a() {
        Class<?> cls;
        co1 co1Var = this.b;
        String className = this.f10676a;
        co1Var.getClass();
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            cls = Class.forName(className);
        } catch (Throwable unused) {
            op0.c(className);
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        co1 co1Var2 = this.b;
        Object[] objArr = {this.c};
        co1Var2.getClass();
        Object objA = co1.a(cls, "getFusedLocationProviderClient", objArr);
        if (objA != null) {
            return new ee0(objA);
        }
        return null;
    }
}
