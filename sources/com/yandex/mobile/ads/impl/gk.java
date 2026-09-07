package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gk implements xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9013a;
    private final ht0 b;
    private final dt0 c;
    private final zf d;
    private final CopyOnWriteArrayList<wf> e;
    private ts f;

    public gk(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, zf adLoadControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adLoadControllerFactory, "adLoadControllerFactory");
        this.f9013a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adLoadControllerFactory;
        this.e = new CopyOnWriteArrayList<>();
        mainThreadUsageValidator.a();
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a() {
        this.b.a();
        this.c.a();
        for (wf wfVar : this.e) {
            wfVar.a((ts) null);
            wfVar.e();
        }
        this.e.clear();
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.gk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                gk.a(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(gk this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        wf wfVarA = this$0.d.a(this$0.f9013a, this$0, adRequestData, null);
        this$0.e.add(wfVarA);
        wfVarA.a(adRequestData.a());
        wfVarA.a(this$0.f);
        wfVarA.b(adRequestData);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        wf loadController = (wf) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        this.b.a();
        loadController.a((ts) null);
        this.e.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a(jl2 jl2Var) {
        this.b.a();
        this.f = jl2Var;
        Iterator<wf> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a((ts) jl2Var);
        }
    }
}
