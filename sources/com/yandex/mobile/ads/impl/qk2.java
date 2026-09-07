package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ha2 f10030a;
    private final on0 b;

    public qk2(ha2 vastUrlConfigurator, on0 instreamHostChecker) {
        Intrinsics.checkNotNullParameter(vastUrlConfigurator, "vastUrlConfigurator");
        Intrinsics.checkNotNullParameter(instreamHostChecker, "instreamHostChecker");
        this.f10030a = vastUrlConfigurator;
        this.b = instreamHostChecker;
    }

    public final la2 a(Context context, o3 adConfiguration, aa2 requestConfigurationParametersProvider, eb2 wrapperAd, fd2 reportParametersProvider, ik2 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        String strK = wrapperAd.k();
        if (strK == null) {
            strK = "";
        }
        Uri uri = Uri.parse(strK);
        this.b.getClass();
        if (on0.a(uri)) {
            ha2 ha2Var = this.f10030a;
            ha2Var.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
            Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
            String string = bn1.a.a(uri, new ga2(ha2Var, requestConfigurationParametersProvider, adConfiguration, context)).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            strK = string;
        }
        return new la2(context, adConfiguration, strK, new ri2(requestListener), wrapperAd, new rk2(reportParametersProvider), new u92(context, adConfiguration.q().c()));
    }
}
