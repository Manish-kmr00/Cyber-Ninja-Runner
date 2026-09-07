package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class st1 implements dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zi f10236a;
    private final cv1<ut1> b;
    private final qt1 c;
    private o8<String> d;

    public st1(zi adLoadController, uu1 sdkEnvironmentModule, o3 adConfiguration, bj bannerAdSizeValidator, vt1 sdkBannerHtmlAdCreator, cv1<ut1> adCreationHandler, qt1 sdkAdapterReporter) {
        Intrinsics.checkNotNullParameter(adLoadController, "adLoadController");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(bannerAdSizeValidator, "bannerAdSizeValidator");
        Intrinsics.checkNotNullParameter(sdkBannerHtmlAdCreator, "sdkBannerHtmlAdCreator");
        Intrinsics.checkNotNullParameter(adCreationHandler, "adCreationHandler");
        Intrinsics.checkNotNullParameter(sdkAdapterReporter, "sdkAdapterReporter");
        this.f10236a = adLoadController;
        this.b = adCreationHandler;
        this.c = sdkAdapterReporter;
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        op0.d(new Object[0]);
        this.b.a();
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final String getAdInfo() {
        o8<String> o8Var = this.d;
        if (o8Var != null) {
            return o8Var.e();
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.dj
    public final void a(Context context, o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.d = adResponse;
        g5 g5VarI = this.f10236a.i();
        f5 f5Var = f5.c;
        ak.a(g5VarI, f5Var, "adLoadingPhaseType", f5Var, null);
        this.c.a(context, adResponse, (p71) null);
        this.c.a(context, adResponse);
        this.b.a(context, adResponse, new a(this.f10236a));
    }

    public static final class a implements dv1<ut1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zi f10237a;

        public a(zi adViewController) {
            Intrinsics.checkNotNullParameter(adViewController, "adViewController");
            this.f10237a = adViewController;
        }

        @Override // com.yandex.mobile.ads.impl.dv1
        public final void a(ut1 ut1Var) {
            ut1 ad = ut1Var;
            Intrinsics.checkNotNullParameter(ad, "ad");
            ad.a(new rt1(this));
        }

        @Override // com.yandex.mobile.ads.impl.dv1
        public final void a(w3 adFetchRequestError) {
            Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
            this.f10237a.b(adFetchRequestError);
        }
    }
}
