package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9583a;
    private final o8<?> b;
    private final n0 c;
    private final Context d;
    private l0 e;
    private t71 f;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m0(Context context, o3 o3Var, o8 o8Var, n51 n51Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, o8Var, n51Var, applicationContext, new l0(applicationContext, o3Var, o8Var, n51Var, null));
    }

    public m0(Context context, o3 adConfiguration, o8 adResponse, n51 activityInteractionEventListener, Context applicationContext, l0 activityInteractionController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(activityInteractionEventListener, "activityInteractionEventListener");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(activityInteractionController, "activityInteractionController");
        this.f9583a = adConfiguration;
        this.b = adResponse;
        this.c = activityInteractionEventListener;
        this.d = applicationContext;
        this.e = activityInteractionController;
    }

    public final void f() {
        this.e.g();
    }

    public final void e() {
        this.e.f();
    }

    public final void c() {
        this.e.c();
    }

    public final void b() {
        this.e.b();
    }

    public final void d() {
        this.e.e();
    }

    public final void a() {
        this.e.a();
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.f = reportParameterManager;
        this.e.a(reportParameterManager);
    }

    public final void a(j80 j80Var) {
        this.e = new l0(this.d, this.f9583a, this.b, this.c, j80Var);
        t71 reportParameterManager = this.f;
        if (reportParameterManager != null) {
            Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
            this.f = reportParameterManager;
            this.e.a(reportParameterManager);
        }
    }
}
