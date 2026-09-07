package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mm1 implements hd0<qp0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xp0 f9656a;
    private final Handler b;
    private final i5 c;
    private mt d;
    private d5 e;
    private String f;

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.c.a(error.c());
        final w3 w3Var = new w3(error.b(), error.c(), error.d(), this.f);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.mm1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                mm1.a(this.f$0, w3Var);
            }
        });
    }

    public /* synthetic */ mm1(Context context, o3 o3Var, g5 g5Var, xp0 xp0Var) {
        this(context, o3Var, g5Var, xp0Var, new Handler(Looper.getMainLooper()), new i5(context, o3Var, g5Var));
    }

    public mm1(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, xp0 adShowApiControllerFactory, Handler handler, i5 adLoadingResultReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(adShowApiControllerFactory, "adShowApiControllerFactory");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adLoadingResultReporter, "adLoadingResultReporter");
        this.f9656a = adShowApiControllerFactory;
        this.b = handler;
        this.c = adLoadingResultReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(mm1 this$0, w3 requestError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestError, "$requestError");
        mt mtVar = this$0.d;
        if (mtVar != null) {
            mtVar.a(requestError);
        }
        d5 d5Var = this$0.e;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(qp0 ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.c.a();
        final wp0 wp0VarA = this.f9656a.a(ad);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.mm1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                mm1.a(this.f$0, wp0VarA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(mm1 this$0, wp0 interstitial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interstitial, "$interstitial");
        mt mtVar = this$0.d;
        if (mtVar != null) {
            mtVar.a(interstitial);
        }
        d5 d5Var = this$0.e;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.c.a(new y7(adConfiguration));
    }

    public final void a(String str) {
        this.f = str;
    }

    public final void a(d5 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.e = listener;
    }

    public final void a(mt mtVar) {
        this.d = mtVar;
        this.c.a(mtVar);
    }

    public final void a(pg0 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }
}
