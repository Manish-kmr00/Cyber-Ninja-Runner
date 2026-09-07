package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ur1 extends wd0<ur1> {
    private final qm1 t;
    private final qt1 u;
    private final gs1 v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur1(Context context, o8<String> adResponse, o3 adConfiguration, zc0<ur1> fullScreenController, qm1 proxyRewardedListener, hs1 rewardedExecutorProvider, pg0 htmlAdResponseReportManager, sc0 fullScreenAdVisibilityValidator, qt1 sdkAdapterReporter) {
        super(context, adResponse, adConfiguration, fullScreenAdVisibilityValidator, fullScreenController, new w4());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        Intrinsics.checkNotNullParameter(proxyRewardedListener, "proxyRewardedListener");
        Intrinsics.checkNotNullParameter(rewardedExecutorProvider, "rewardedExecutorProvider");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(fullScreenAdVisibilityValidator, "fullScreenAdVisibilityValidator");
        Intrinsics.checkNotNullParameter(sdkAdapterReporter, "sdkAdapterReporter");
        this.t = proxyRewardedListener;
        this.u = sdkAdapterReporter;
        this.v = rewardedExecutorProvider.a(context, adResponse, adConfiguration);
        htmlAdResponseReportManager.a(adResponse);
        htmlAdResponseReportManager.a(adConfiguration);
    }

    @Override // com.yandex.mobile.ads.impl.wd0
    public final wd0 o() {
        return this;
    }

    @Override // com.yandex.mobile.ads.impl.wd0, com.yandex.mobile.ads.impl.a62, com.yandex.mobile.ads.impl.q3
    public final void a(int i, Bundle bundle) {
        if (i == 13) {
            r();
        } else {
            super.a(i, bundle);
        }
    }

    public final void a(pm1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        a((kd0) listener);
        this.t.a(listener);
    }

    public final void r() {
        this.u.b(e(), d());
        gs1 gs1Var = this.v;
        if (gs1Var != null) {
            gs1Var.a();
        }
    }
}
