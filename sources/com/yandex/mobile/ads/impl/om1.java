package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class om1 implements hd0<ur1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bs1 f9835a;
    private final Handler b;
    private final i5 c;
    private String d;
    private fu e;
    private d5 f;

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(final w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.c.a(error.c());
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.om1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                om1.a(error, this);
            }
        });
    }

    public /* synthetic */ om1(Context context, o3 o3Var, g5 g5Var, bs1 bs1Var) {
        this(context, o3Var, g5Var, bs1Var, new Handler(Looper.getMainLooper()), new i5(context, o3Var, g5Var));
    }

    public om1(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, bs1 rewardedAdShowApiControllerFactoryFactory, Handler handler, i5 adLoadingResultReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(rewardedAdShowApiControllerFactoryFactory, "rewardedAdShowApiControllerFactoryFactory");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adLoadingResultReporter, "adLoadingResultReporter");
        this.f9835a = rewardedAdShowApiControllerFactoryFactory;
        this.b = handler;
        this.c = adLoadingResultReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(w3 error, om1 this$0) {
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w3 w3Var = new w3(error.b(), error.c(), error.d(), this$0.d);
        fu fuVar = this$0.e;
        if (fuVar != null) {
            fuVar.a(w3Var);
        }
        d5 d5Var = this$0.f;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.hd0
    public final void a(ur1 ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.c.a();
        final as1 as1VarA = this.f9835a.a(ad);
        this.b.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.om1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                om1.a(this.f$0, as1VarA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(om1 this$0, as1 interstitial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interstitial, "$interstitial");
        fu fuVar = this$0.e;
        if (fuVar != null) {
            fuVar.a(interstitial);
        }
        d5 d5Var = this$0.f;
        if (d5Var != null) {
            d5Var.a();
        }
    }

    public final void a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.c.a(new y7(adConfiguration));
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(d5 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f = listener;
    }

    public final void a(fu fuVar) {
        this.e = fuVar;
        this.c.a(fuVar);
    }

    public final void a(pg0 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.c.a(reportParameterManager);
    }
}
