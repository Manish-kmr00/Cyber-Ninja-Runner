package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l51 implements u50, nk0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n51 f9479a;
    private final m0 b;

    public /* synthetic */ l51(Context context, o3 o3Var, o8 o8Var) {
        n51 n51Var = new n51();
        this(context, o3Var, o8Var, n51Var, new m0(context, o3Var, o8Var, n51Var));
    }

    public l51(Context context, o3 adConfiguration, o8<?> adResponse, n51 nativeAdEventListenerController, m0 activityInteractionControllerWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdEventListenerController, "nativeAdEventListenerController");
        Intrinsics.checkNotNullParameter(activityInteractionControllerWrapper, "activityInteractionControllerWrapper");
        this.f9479a = nativeAdEventListenerController;
        this.b = activityInteractionControllerWrapper;
    }

    public final void b() {
        op0.a(new Object[0]);
        this.b.a();
    }

    public final void c() {
        this.b.e();
    }

    public final void d() {
        this.f9479a.onLeftApplication();
        this.b.d();
    }

    public final void e() {
        this.f9479a.onLeftApplication();
        this.b.f();
    }

    @Override // com.yandex.mobile.ads.impl.u50
    public final void a() {
        this.f9479a.a();
    }

    public final void g() {
        this.f9479a.onLeftApplication();
        this.b.c();
    }

    public final void f() {
        this.b.b();
    }

    @Override // com.yandex.mobile.ads.impl.nk0.a
    public final void a(t4 t4Var) {
        this.f9479a.a(t4Var);
    }

    public final void a(pt ptVar) {
        this.f9479a.a(ptVar);
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }

    public final void a(rr0 link) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.b.a(link.c());
    }
}
