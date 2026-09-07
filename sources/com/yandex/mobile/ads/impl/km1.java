package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class km1 implements hd0<uf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9431a;
    private final i5 b;
    private final cg c;
    private ts d;
    private d5 e;

    public km1(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, Handler handler, i5 adLoadingResultReporter, cg appOpenAdShowApiControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adLoadingResultReporter, "adLoadingResultReporter");
        Intrinsics.checkNotNullParameter(appOpenAdShowApiControllerFactory, "appOpenAdShowApiControllerFactory");
        this.f9431a = handler;
        this.b = adLoadingResultReporter;
        this.c = appOpenAdShowApiControllerFactory;
    }

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(final w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(error.c());
        this.f9431a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.km1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                km1.a(this.f$0, error);
            }
        });
    }

    public /* synthetic */ km1(Context context, o3 o3Var, g5 g5Var, jd0 jd0Var) {
        this(context, o3Var, g5Var, new Handler(Looper.getMainLooper()), new i5(context, o3Var, g5Var), new cg(context, jd0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(km1 this$0, w3 error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        ts tsVar = this$0.d;
        if (tsVar != null) {
            tsVar.a(error);
        }
        d5 d5Var = this$0.e;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(uf ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.b.a();
        final bg bgVarA = this.c.a(ad);
        this.f9431a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.km1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                km1.a(this.f$0, bgVarA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(km1 this$0, bg appOpenAdApiController) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appOpenAdApiController, "$appOpenAdApiController");
        ts tsVar = this$0.d;
        if (tsVar != null) {
            tsVar.a(appOpenAdApiController);
        }
        d5 d5Var = this$0.e;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.b.a(new y7(adConfiguration));
    }

    public final void a(ts tsVar) {
        this.d = tsVar;
        this.b.a(tsVar);
    }

    public final void a(d5 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.e = listener;
    }

    public final void a(pg0 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }
}
