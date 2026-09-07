package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes.dex */
public final class kn implements up0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9433a;
    private final ht0 b;
    private final dt0 c;
    private final tp0 d;
    private final bq0 e;
    private final sk1 f;
    private final CopyOnWriteArrayList<sp0> g;
    private mt h;

    public final class b implements mt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9435a;
        final /* synthetic */ kn b;

        public b(kn knVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = knVar;
            this.f9435a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.mt
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.yandex.mobile.ads.impl.mt
        public final void a(kt interstitialAd) {
            Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
            this.b.e.a(this.f9435a, interstitialAd);
        }
    }

    public kn(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, tp0 adItemLoadControllerFactory, bq0 preloadingCache, sk1 preloadingAvailabilityValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adItemLoadControllerFactory, "adItemLoadControllerFactory");
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(preloadingAvailabilityValidator, "preloadingAvailabilityValidator");
        this.f9433a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adItemLoadControllerFactory;
        this.e = preloadingCache;
        this.f = preloadingAvailabilityValidator;
        this.g = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(kn this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData) && this$0.e.c()) {
            this$0.a(adRequestData, new b(this$0, adRequestData), Reporting.EventType.RENDER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(kn this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData)) {
            kt ktVarA = this$0.e.a(adRequestData);
            if (ktVarA != null) {
                mt mtVar = this$0.h;
                if (mtVar != null) {
                    mtVar.a(ktVarA);
                    return;
                }
                return;
            }
            this$0.a(adRequestData, this$0.new c(), "default");
            return;
        }
        this$0.a(adRequestData, this$0.new c(), "default");
    }

    public final class c implements mt {
        @Override // com.yandex.mobile.ads.impl.mt
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            mt mtVar = kn.this.h;
            if (mtVar != null) {
                mtVar.a(error);
            }
        }

        public c() {
        }

        @Override // com.yandex.mobile.ads.impl.mt
        public final void a(kt interstitialAd) {
            Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
            mt mtVar = kn.this.h;
            if (mtVar != null) {
                mtVar.a(interstitialAd);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a() {
        this.b.a();
        this.c.a();
        for (sp0 sp0Var : this.g) {
            sp0Var.a((mt) null);
            sp0Var.e();
        }
        this.g.clear();
    }

    public final class a implements jd0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9434a;
        final /* synthetic */ kn b;

        public a(kn knVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = knVar;
            this.f9434a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.jd0
        public final void onAdShown() {
            this.b.b(this.f9434a);
        }
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        if (this.h == null) {
            dp0.c("InterstitialAdLoader. InterstitialAdLoadListener is null on loading start. Please, use setAdLoadListener before loading Ad.", new Object[0]);
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.kn$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                kn.b(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final v7 v7Var) {
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.kn$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                kn.c(this.f$0, v7Var);
            }
        });
    }

    private final void a(v7 v7Var, mt mtVar, String str) {
        v7 v7VarA = v7.a(v7Var, null, str, 2047);
        sp0 sp0VarA = this.d.a(this.f9433a, this, v7VarA, new a(this, v7VarA));
        this.g.add(sp0VarA);
        sp0VarA.a(v7VarA.a());
        sp0VarA.a(mtVar);
        sp0VarA.b(v7VarA);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        sp0 loadController = (sp0) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        if (this.h == null) {
            dp0.c("InterstitialAdLoader. InterstitialAdLoadListener is null on finished ad loading. Please, keep active listener until ad loading finished or use cancelLoading().", new Object[0]);
        }
        loadController.a((mt) null);
        this.g.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.up0
    public final void a(gm2 gm2Var) {
        this.b.a();
        this.h = gm2Var;
    }
}
