package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10279a;
    private final g5 b;

    public t92(o3 adConfiguration, g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f10279a = adConfiguration;
        this.b = adLoadingPhasesManager;
    }

    public final s92 a(Context context, z92 configuration, aa2 requestConfigurationParametersProvider, wp1<r92> requestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        p92 p92Var = new p92(configuration, new a8(configuration.a()));
        o3 o3Var = this.f10279a;
        return new s92(context, o3Var, configuration, requestConfigurationParametersProvider, this.b, p92Var, requestListener, new qd2(context, o3Var, p92Var, requestConfigurationParametersProvider));
    }
}
