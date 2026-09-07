package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ba2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ha2 f8488a;

    public ba2(ha2 vastUrlConfigurator) {
        Intrinsics.checkNotNullParameter(vastUrlConfigurator, "vastUrlConfigurator");
        this.f8488a = vastUrlConfigurator;
    }

    public final o92 a(Context context, o3 adConfiguration, z92 requestConfiguration, aa2 requestConfigurationParametersProvider, Object requestTag, s92 requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfiguration, "requestConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        a8 a8Var = new a8(requestConfiguration.a());
        da2 da2Var = new da2(a8Var);
        Uri uri = Uri.parse(a8Var.a().a());
        ha2 ha2Var = this.f8488a;
        ha2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        String string = bn1.a.a(uri, new ga2(ha2Var, requestConfigurationParametersProvider, adConfiguration, context)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        o92 o92Var = new o92(context, adConfiguration, string, new ri2(requestListener), requestConfiguration, da2Var, new u92(context, adConfiguration.q().c()));
        o92Var.b(requestTag);
        return o92Var;
    }
}
