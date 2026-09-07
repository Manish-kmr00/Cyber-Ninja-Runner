package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10329a;
    private final Context b;
    private final e61 c;

    public final void b(v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        r61 r61Var = new r61(this.b, this.f10329a.c());
        e61 e61Var = this.c;
        y91 y91Var = y91.c;
        ba1 ba1Var = ba1.c;
        e61Var.b(adRequestData, r61Var);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ tt(Context context, wm2 wm2Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, wm2Var, applicationContext, new e61(applicationContext, wm2Var));
    }

    public tt(Context context, wm2 sdkEnvironmentModule, Context appContext, e61 adLoadingController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(adLoadingController, "adLoadingController");
        this.f10329a = sdkEnvironmentModule;
        this.b = appContext;
        this.c = adLoadingController;
    }

    public final void a() {
        this.c.a();
    }

    public final void a(v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        r61 r61Var = new r61(this.b, this.f10329a.c());
        e61 e61Var = this.c;
        y91 y91Var = y91.c;
        ba1 ba1Var = ba1.c;
        e61Var.a(adRequestData, r61Var);
    }

    public final void a(v7 adRequestData, int i) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        r61 r61Var = new r61(this.b, this.f10329a.c());
        e61 e61Var = this.c;
        y91 y91Var = y91.c;
        ba1 ba1Var = ba1.c;
        e61Var.a(adRequestData, r61Var, i);
    }

    public final void a(st stVar) {
        this.c.a(stVar);
    }

    public final void a(qm2 qm2Var) {
        this.c.a(qm2Var);
    }

    public final void a(zm2 zm2Var) {
        this.c.a(zm2Var);
    }
}
