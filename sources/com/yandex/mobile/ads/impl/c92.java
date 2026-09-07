package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cb2 f8581a;
    private final b92 b;
    private final Context c;
    private final d92 d;

    public /* synthetic */ c92(Context context) {
        this(context, new cb2(), new b92());
    }

    public final void a() {
        cb2 cb2Var = this.f8581a;
        Context context = this.c;
        cb2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (pa.a(context) && this.b.a(this.c)) {
            this.d.getClass();
            d92.b();
        }
    }

    public c92(Context context, cb2 versionValidationNeedChecker, b92 validationErrorLogChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(versionValidationNeedChecker, "versionValidationNeedChecker");
        Intrinsics.checkNotNullParameter(validationErrorLogChecker, "validationErrorLogChecker");
        this.f8581a = versionValidationNeedChecker;
        this.b = validationErrorLogChecker;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
        this.d = new d92();
    }
}
