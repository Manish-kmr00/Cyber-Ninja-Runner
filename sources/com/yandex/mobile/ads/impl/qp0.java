package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qp0 extends wd0<qp0> {
    @Override // com.yandex.mobile.ads.impl.wd0
    public final wd0 o() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qp0(Context context, o8 adResponse, o3 adConfiguration, sc0 fullScreenAdVisibilityValidator, pg0 htmlAdResponseReportManager, zc0 fullScreenController) {
        super(context, adResponse, adConfiguration, fullScreenAdVisibilityValidator, fullScreenController, new w4());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(fullScreenController, "fullScreenController");
        Intrinsics.checkNotNullParameter(htmlAdResponseReportManager, "htmlAdResponseReportManager");
        Intrinsics.checkNotNullParameter(fullScreenAdVisibilityValidator, "fullScreenAdVisibilityValidator");
        htmlAdResponseReportManager.a((o8<String>) adResponse);
        htmlAdResponseReportManager.a(adConfiguration);
    }
}
