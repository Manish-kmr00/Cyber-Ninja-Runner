package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wr1 extends gd0<ur1> {
    private final om1 F;
    private final qr1 G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr1(Context context, uu1 sdkEnvironmentModule, b5 itemsLoadFinishListener, v7 adRequestData, g5 adLoadingPhasesManager, pg0 htmlAdResponseReportManager, vr1 contentControllerFactory, bs1 adApiControllerFactory, o3 adConfiguration, om1 proxyRewardedAdLoadListener, qr1 rewardDataValidator) {
        super(context, adConfiguration, sdkEnvironmentModule, proxyRewardedAdLoadListener, adLoadingPhasesManager, contentControllerFactory, htmlAdResponseReportManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(itemsLoadFinishListener, "itemsLoadFinishListener");
        Intrinsics.checkNotNullParameter(adRequestData, "adRequestData");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(contentControllerFactory, "contentControllerFactory");
        Intrinsics.checkNotNullParameter(adApiControllerFactory, "adApiControllerFactory");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(proxyRewardedAdLoadListener, "proxyRewardedAdLoadListener");
        Intrinsics.checkNotNullParameter(rewardDataValidator, "rewardDataValidator");
        this.F = proxyRewardedAdLoadListener;
        this.G = rewardDataValidator;
        adConfiguration.a(adRequestData);
        proxyRewardedAdLoadListener.a(new a(itemsLoadFinishListener, this));
        proxyRewardedAdLoadListener.a(adConfiguration);
        proxyRewardedAdLoadListener.a(htmlAdResponseReportManager);
    }

    @Override // com.yandex.mobile.ads.impl.gd0
    protected final zc0<ur1> a(ad0 controllerFactory) {
        Intrinsics.checkNotNullParameter(controllerFactory, "controllerFactory");
        return controllerFactory.b(this);
    }

    @Override // com.yandex.mobile.ads.impl.gd0, com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.qq1.b
    public final void a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        nr1 nr1VarJ = adResponse.J();
        this.G.getClass();
        if (nr1VarJ != null && (!nr1VarJ.e() ? nr1VarJ.c() != null : nr1VarJ.d() != null)) {
            super.a(adResponse);
        } else {
            b(w7.k());
        }
    }

    public static final class a implements d5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b5<wr1> f10586a;
        private final wr1 b;

        public a(b5<wr1> itemsFinishListener, wr1 loadController) {
            Intrinsics.checkNotNullParameter(itemsFinishListener, "itemsFinishListener");
            Intrinsics.checkNotNullParameter(loadController, "loadController");
            this.f10586a = itemsFinishListener;
            this.b = loadController;
        }

        @Override // com.yandex.mobile.ads.impl.d5
        public final void a() {
            this.f10586a.a(this.b);
        }
    }

    public final void a(fu fuVar) {
        this.F.a(fuVar);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void a(String str) {
        super.a(str);
        this.F.a(str);
    }
}
