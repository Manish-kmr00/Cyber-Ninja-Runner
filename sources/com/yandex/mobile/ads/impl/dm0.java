package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class dm0 implements qm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final em0 f8709a;
    private final c32 b;
    private final g5 c;
    private final rm0 d;
    private final xb2 e;
    private final pm0 f;

    public dm0(Context context, uu1 sdkEnvironmentModule, em0 itemFinishedListener, c32 strongReferenceKeepingManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(itemFinishedListener, "itemFinishedListener");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        this.f8709a = itemFinishedListener;
        this.b = strongReferenceKeepingManager;
        g5 g5Var = new g5();
        this.c = g5Var;
        o3 o3Var = new o3(qs.h, sdkEnvironmentModule);
        rm0 rm0Var = new rm0(context, o3Var, g5Var, this);
        this.d = rm0Var;
        xb2 xb2Var = new xb2(context, o3Var, g5Var);
        this.e = xb2Var;
        this.f = new pm0(context, sdkEnvironmentModule, xb2Var, rm0Var);
    }

    public final void a(gi2 requestConfig) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        this.b.b(tq0.b, this);
        this.d.a(requestConfig);
        g5 g5Var = this.c;
        f5 f5Var = f5.e;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        this.e.a(requestConfig, this.f);
    }

    @Override // com.yandex.mobile.ads.impl.qm0
    public final void a() {
        this.f8709a.a(this);
        this.b.a(tq0.b, this);
    }

    public final void a(ft ftVar) {
        this.d.a(ftVar);
    }
}
