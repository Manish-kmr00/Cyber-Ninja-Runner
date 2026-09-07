package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nk implements up0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9735a;
    private final ht0 b;
    private final dt0 c;
    private final tp0 d;
    private final CopyOnWriteArrayList<sp0> e;
    private mt f;

    public nk(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, tp0 adItemLoadControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adItemLoadControllerFactory, "adItemLoadControllerFactory");
        this.f9735a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adItemLoadControllerFactory;
        this.e = new CopyOnWriteArrayList<>();
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a() {
        this.b.a();
        this.c.a();
        for (sp0 sp0Var : this.e) {
            sp0Var.a((mt) null);
            sp0Var.e();
        }
        this.e.clear();
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        if (this.f == null) {
            dp0.c("InterstitialAdLoader. InterstitialAdLoadListener is null on loading start. Please, use setAdLoadListener before loading Ad.", new Object[0]);
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.nk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                nk.a(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(nk this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        sp0 sp0VarA = this$0.d.a(this$0.f9735a, this$0, adRequestData, null);
        this$0.e.add(sp0VarA);
        sp0VarA.a(adRequestData.a());
        sp0VarA.a(this$0.f);
        sp0VarA.b(adRequestData);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        sp0 loadController = (sp0) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        if (this.f == null) {
            dp0.c("InterstitialAdLoader. InterstitialAdLoadListener is null on finished ad loading. Please, keep active listener until ad loading finished or use cancelLoading().", new Object[0]);
        }
        loadController.a((mt) null);
        this.e.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a(gm2 gm2Var) {
        this.b.a();
        this.f = gm2Var;
        Iterator<sp0> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a((mt) gm2Var);
        }
    }
}
