package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class sp0 extends gd0<qp0> {
    private final mm1 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sp0(Context context, uu1 sdkEnvironmentModule, b5 itemsLoadFinishListener, v7 adRequestData, g5 adLoadingPhasesManager, pg0 htmlAdResponseReportManager, rp0 contentControllerFactory, xp0 adApiControllerFactory, o3 adConfiguration, mm1 proxyInterstitialAdLoadListener) {
        super(context, adConfiguration, sdkEnvironmentModule, proxyInterstitialAdLoadListener, adLoadingPhasesManager, contentControllerFactory, htmlAdResponseReportManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(itemsLoadFinishListener, "itemsLoadFinishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(contentControllerFactory, "contentControllerFactory");
        Intrinsics.checkNotNullParameter(adApiControllerFactory, "adApiControllerFactory");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(proxyInterstitialAdLoadListener, "proxyInterstitialAdLoadListener");
        this.F = proxyInterstitialAdLoadListener;
        adConfiguration.a(adRequestData);
        proxyInterstitialAdLoadListener.a(new a(itemsLoadFinishListener, this));
        proxyInterstitialAdLoadListener.a(adConfiguration);
        proxyInterstitialAdLoadListener.a(htmlAdResponseReportManager);
    }

    @Override // com.yandex.mobile.ads.impl.gd0
    protected final zc0<qp0> a(ad0 controllerFactory) {
        Intrinsics.checkNotNullParameter(controllerFactory, "controllerFactory");
        return controllerFactory.a(this);
    }

    public static final class a implements d5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b5<sp0> f10230a;
        private final sp0 b;

        public a(b5<sp0> itemsFinishListener, sp0 loadController) {
            Intrinsics.checkNotNullParameter(itemsFinishListener, "itemsFinishListener");
            Intrinsics.checkNotNullParameter(loadController, "loadController");
            this.f10230a = itemsFinishListener;
            this.b = loadController;
        }

        @Override // com.yandex.mobile.ads.impl.d5
        public final void a() {
            this.f10230a.a(this.b);
        }
    }

    public final void a(mt mtVar) {
        this.F.a(mtVar);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void a(String str) {
        super.a(str);
        this.F.a(str);
    }
}
