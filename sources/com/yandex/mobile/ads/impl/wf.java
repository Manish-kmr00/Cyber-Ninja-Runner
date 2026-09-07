package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wf extends gd0<uf> {
    private final km1 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf(Context context, uu1 sdkEnvironmentModule, b5 itemsLoadFinishListener, v7 adRequestData, g5 adLoadingPhasesManager, pg0 htmlAdResponseReportManager, vf adContentControllerFactory, o3 adConfiguration, km1 proxyAppOpenAdLoadListener) {
        super(context, adConfiguration, sdkEnvironmentModule, proxyAppOpenAdLoadListener, adLoadingPhasesManager, adContentControllerFactory, htmlAdResponseReportManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(itemsLoadFinishListener, "itemsLoadFinishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(adContentControllerFactory, "adContentControllerFactory");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(proxyAppOpenAdLoadListener, "proxyAppOpenAdLoadListener");
        this.F = proxyAppOpenAdLoadListener;
        adConfiguration.a(adRequestData);
        proxyAppOpenAdLoadListener.a(new a(itemsLoadFinishListener, this));
        proxyAppOpenAdLoadListener.a(htmlAdResponseReportManager);
        proxyAppOpenAdLoadListener.a(adConfiguration);
    }

    @Override // com.yandex.mobile.ads.impl.gd0
    protected final zc0<uf> a(ad0 controllerFactory) {
        Intrinsics.checkNotNullParameter(controllerFactory, "controllerFactory");
        return controllerFactory.c(this);
    }

    public static final class a implements d5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b5<wf> f10560a;
        private final wf b;

        public a(b5<wf> itemsFinishListener, wf loadController) {
            Intrinsics.checkNotNullParameter(itemsFinishListener, "itemsFinishListener");
            Intrinsics.checkNotNullParameter(loadController, "loadController");
            this.f10560a = itemsFinishListener;
            this.b = loadController;
        }

        @Override // com.yandex.mobile.ads.impl.d5
        public final void a() {
            this.f10560a.a(this.b);
        }
    }

    public final void a(ts tsVar) {
        this.F.a(tsVar);
    }
}
