package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class sk implements yr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10213a;
    private final ht0 b;
    private final dt0 c;
    private final xr1 d;
    private final CopyOnWriteArrayList<wr1> e;
    private fu f;

    public sk(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, xr1 adItemLoadControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adItemLoadControllerFactory, "adItemLoadControllerFactory");
        this.f10213a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adItemLoadControllerFactory;
        this.e = new CopyOnWriteArrayList<>();
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a() {
        this.b.a();
        this.c.a();
        for (wr1 wr1Var : this.e) {
            wr1Var.a((fu) null);
            wr1Var.e();
        }
        this.e.clear();
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        if (this.f == null) {
            dp0.c("RewardedAdLoader. RewardedAdLoadListener is on loading start. Please, use setAdLoadListener before loading Ad.", new Object[0]);
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.sk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                sk.a(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(sk this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        wr1 wr1VarA = this$0.d.a(this$0.f10213a, this$0, adRequestData, null);
        this$0.e.add(wr1VarA);
        wr1VarA.a(adRequestData.a());
        wr1VarA.a(this$0.f);
        wr1VarA.b(adRequestData);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        wr1 loadController = (wr1) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        if (this.f == null) {
            dp0.c("RewardedAdLoader. RewardedAdLoadListener is null on finished ad loading. Please, keep active listener until ad loading finished or use cancelLoading().", new Object[0]);
        }
        loadController.a((fu) null);
        this.e.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a(vm2 vm2Var) {
        this.b.a();
        this.f = vm2Var;
        Iterator<wr1> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a((fu) vm2Var);
        }
    }
}
