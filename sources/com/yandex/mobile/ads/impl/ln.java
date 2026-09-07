package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes.dex */
public final class ln implements yr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9541a;
    private final ht0 b;
    private final dt0 c;
    private final xr1 d;
    private final ks1 e;
    private final sk1 f;
    private final CopyOnWriteArrayList<wr1> g;
    private fu h;

    public final class a implements fu {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9542a;
        final /* synthetic */ ln b;

        public a(ln lnVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = lnVar;
            this.f9542a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.fu
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.yandex.mobile.ads.impl.fu
        public final void a(du rewardedAd) {
            Intrinsics.checkNotNullParameter(rewardedAd, "rewardedAd");
            this.b.e.a(this.f9542a, rewardedAd);
        }
    }

    public ln(Context context, wm2 sdkEnvironmentModule, ht0 mainThreadUsageValidator, dt0 mainThreadExecutor, xr1 adItemLoadControllerFactory, ks1 preloadingCache, sk1 preloadingAvailabilityValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(mainThreadUsageValidator, "mainThreadUsageValidator");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(adItemLoadControllerFactory, "adItemLoadControllerFactory");
        Intrinsics.checkNotNullParameter(preloadingCache, "preloadingCache");
        Intrinsics.checkNotNullParameter(preloadingAvailabilityValidator, "preloadingAvailabilityValidator");
        this.f9541a = context;
        this.b = mainThreadUsageValidator;
        this.c = mainThreadExecutor;
        this.d = adItemLoadControllerFactory;
        this.e = preloadingCache;
        this.f = preloadingAvailabilityValidator;
        this.g = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ln this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData) && this$0.e.c()) {
            this$0.a(adRequestData, new a(this$0, adRequestData), Reporting.EventType.RENDER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ln this$0, v7 adRequestData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adRequestData, "$adRequestData");
        this$0.f.getClass();
        if (sk1.a(adRequestData)) {
            du duVarA = this$0.e.a(adRequestData);
            if (duVarA != null) {
                fu fuVar = this$0.h;
                if (fuVar != null) {
                    fuVar.a(duVarA);
                    return;
                }
                return;
            }
            this$0.a(adRequestData, this$0.new b(), "default");
            return;
        }
        this$0.a(adRequestData, this$0.new b(), "default");
    }

    public final class b implements fu {
        @Override // com.yandex.mobile.ads.impl.fu
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            fu fuVar = ln.this.h;
            if (fuVar != null) {
                fuVar.a(error);
            }
        }

        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.fu
        public final void a(du rewardedAd) {
            Intrinsics.checkNotNullParameter(rewardedAd, "rewardedAd");
            fu fuVar = ln.this.h;
            if (fuVar != null) {
                fuVar.a(rewardedAd);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a() {
        this.b.a();
        this.c.a();
        for (wr1 wr1Var : this.g) {
            wr1Var.a((fu) null);
            wr1Var.e();
        }
        this.g.clear();
    }

    public final class c implements jd0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7 f9544a;
        final /* synthetic */ ln b;

        public c(ln lnVar, v7 adRequestData) {
            Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
            this.b = lnVar;
            this.f9544a = adRequestData;
        }

        @Override // com.yandex.mobile.ads.impl.jd0
        public final void onAdShown() {
            this.b.b(this.f9544a);
        }
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a(final v7 adRequestData) {
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        this.b.a();
        if (this.h == null) {
            dp0.c("RewardedAdLoader. RewardedAdLoadListener is on loading start. Please, use setAdLoadListener before loading Ad.", new Object[0]);
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.ln$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ln.b(this.f$0, adRequestData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final v7 v7Var) {
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.ln$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ln.c(this.f$0, v7Var);
            }
        });
    }

    private final void a(v7 v7Var, fu fuVar, String str) {
        v7 v7VarA = v7.a(v7Var, null, str, 2047);
        wr1 wr1VarA = this.d.a(this.f9541a, this, v7VarA, new c(this, v7VarA));
        this.g.add(wr1VarA);
        wr1VarA.a(v7VarA.a());
        wr1VarA.a(fuVar);
        wr1VarA.b(v7VarA);
    }

    @Override // com.yandex.mobile.ads.impl.b5
    public final void a(gd0 gd0Var) {
        wr1 loadController = (wr1) gd0Var;
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        if (this.h == null) {
            dp0.c("RewardedAdLoader. RewardedAdLoadListener is null on finished ad loading. Please, keep active listener until ad loading finished or use cancelLoading().", new Object[0]);
        }
        loadController.a((fu) null);
        this.g.remove(loadController);
    }

    @Override // com.yandex.mobile.ads.impl.yr1
    public final void a(vm2 vm2Var) {
        this.b.a();
        this.h = vm2Var;
    }
}
