package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes3.dex */
public final class hn implements xf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9116a;
    private final ht0 b;
    private final dt0 c;
    private final zf d;
    private final ag e;
    private final sk1 f;
    private final CopyOnWriteArrayList<wf> g;
    private ts h;

    public final class b implements ts {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9118a;
        final /* synthetic */ hn b;

        public b(hn hnVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = hnVar;
            this.f9118a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.ts
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.yandex.mobile.ads.impl.ts
        public final void a(rs appOpenAd) {
            Intrinsics.checkNotNullParameter(appOpenAd, "appOpenAd");
            this.b.e.a(this.f9118a, appOpenAd);
        }
    }

    public hn(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, zf adLoadControllerFactory, ag preloadingCache, sk1 preloadingAvailabilityValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adLoadControllerFactory, "adLoadControllerFactory");
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(preloadingAvailabilityValidator, "preloadingAvailabilityValidator");
        this.f9116a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adLoadControllerFactory;
        this.e = preloadingCache;
        this.f = preloadingAvailabilityValidator;
        this.g = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(hn this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData) && this$0.e.c()) {
            this$0.a(adRequestData, new b(this$0, adRequestData), Reporting.EventType.RENDER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(hn this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData)) {
            rs rsVarA = this$0.e.a(adRequestData);
            if (rsVarA != null) {
                ts tsVar = this$0.h;
                if (tsVar != null) {
                    tsVar.a(rsVarA);
                    return;
                }
                return;
            }
            this$0.a(adRequestData, this$0.new c(), "default");
            return;
        }
        this$0.a(adRequestData, this$0.new c(), "default");
    }

    public final class c implements ts {
        @Override // com.yandex.mobile.ads.impl.ts
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            ts tsVar = hn.this.h;
            if (tsVar != null) {
                tsVar.a(error);
            }
        }

        public c() {
        }

        @Override // com.yandex.mobile.ads.impl.ts
        public final void a(rs appOpenAd) {
            Intrinsics.checkNotNullParameter(appOpenAd, "appOpenAd");
            ts tsVar = hn.this.h;
            if (tsVar != null) {
                tsVar.a(appOpenAd);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a() {
        this.b.a();
        this.c.a();
        for (wf wfVar : this.g) {
            wfVar.a((ts) null);
            wfVar.e();
        }
        this.g.clear();
    }

    public final class a implements jd0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9117a;
        final /* synthetic */ hn b;

        public a(hn hnVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = hnVar;
            this.f9117a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.jd0
        public final void onAdShown() {
            this.b.b(this.f9117a);
        }
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        if (this.h == null) {
            dp0.c("AppOpenAdLoader. AppOpenAdLoadListener is null on loading start. Please, use setAdLoadListener before loading Ad.", new Object[0]);
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hn$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                hn.b(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final v7 v7Var) {
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hn$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                hn.c(this.f$0, v7Var);
            }
        });
    }

    private final void a(v7 v7Var, ts tsVar, String str) {
        v7 v7VarA = v7.a(v7Var, null, str, 2047);
        wf wfVarA = this.d.a(this.f9116a, this, v7VarA, new a(this, v7VarA));
        this.g.add(wfVarA);
        wfVarA.a(v7VarA.a());
        wfVarA.a(tsVar);
        wfVarA.b(v7VarA);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        wf loadController = (wf) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        if (this.h == null) {
            dp0.c("AppOpenAdLoader. AppOpenAdLoadListener is null on finished ad loading. Please, keep active listener until ad loading finished or use cancelLoading().", new Object[0]);
        }
        loadController.a((ts) null);
        this.g.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.xf
    public final void a(jl2 jl2Var) {
        this.b.a();
        this.h = jl2Var;
    }
}
