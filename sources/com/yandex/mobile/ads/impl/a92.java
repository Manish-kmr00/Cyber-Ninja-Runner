package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e92 f8383a;
    private final iw1 b;
    private final cb2 c;
    private final z82 d;
    private final Context e;

    public /* synthetic */ a92(Context context) {
        e92 e92Var = new e92(context);
        int i = iw1.l;
        this(context, e92Var, iw1.a.a(), new cb2(), new z82());
    }

    public final void a() {
        cb2 cb2Var = this.c;
        Context context = this.e;
        cb2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (pa.a(context) && this.b.k() && this.d.a(this.e)) {
            this.f8383a.a();
        }
    }

    public a92(Context context, e92 toastPresenter, iw1 sdkSettings, cb2 versionValidationNeedChecker, z82 validationErrorIndicatorChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toastPresenter, "toastPresenter");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        Intrinsics.checkNotNullParameter(versionValidationNeedChecker, "versionValidationNeedChecker");
        Intrinsics.checkNotNullParameter(validationErrorIndicatorChecker, "validationErrorIndicatorChecker");
        this.f8383a = toastPresenter;
        this.b = sdkSettings;
        this.c = versionValidationNeedChecker;
        this.d = validationErrorIndicatorChecker;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.e = applicationContext;
    }
}
