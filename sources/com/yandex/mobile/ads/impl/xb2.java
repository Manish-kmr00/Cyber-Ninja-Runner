package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10639a;
    private final dc2 b;
    private final Context c;
    private final Object d;

    public final void a(z92 configuration, co0 requestConfigurationParametersProvider, w92 requestListener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Context context = this.c;
        uu1 uu1VarQ = this.f10639a.q();
        dn2 dn2VarA = uu1VarQ.a();
        this.b.a(configuration, requestConfigurationParametersProvider, this.d, new ca2(context, uu1VarQ, requestListener, new ia2(context, dn2VarA, dn2VarA.a(context))));
    }

    public /* synthetic */ xb2(Context context, o3 o3Var, g5 g5Var) {
        dc2 dc2Var = new dc2(context, o3Var, g5Var);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, g5Var, dc2Var, applicationContext);
    }

    public xb2(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, dc2 videoAdLoaderController, Context applicationContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(videoAdLoaderController, "videoAdLoaderController");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f10639a = adConfiguration;
        this.b = videoAdLoaderController;
        this.c = applicationContext;
        this.d = new Object();
    }

    public final void a(gi2 vmapRequestConfig, pm0 requestListener) {
        Intrinsics.checkNotNullParameter(vmapRequestConfig, "vmapRequestConfig");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.b.a(vmapRequestConfig, this.d, requestListener);
    }
}
