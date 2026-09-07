package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class dc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8681a;
    private final g5 b;
    private final wb2 c;
    private final t92 d;
    private final hv1 e;
    private final lb2 f;
    private final Context g;
    private final LinkedHashSet h;

    public /* synthetic */ dc2(Context context, o3 o3Var, g5 g5Var) {
        int i = wb2.d;
        wb2 wb2VarA = wb2.a.a(context);
        t92 t92Var = new t92(o3Var, g5Var);
        hv1 hv1Var = new hv1(context, o3Var.q(), pu.a(), g5Var, null, null, 2097136);
        lb2 lb2Var = new lb2();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, g5Var, wb2VarA, t92Var, hv1Var, lb2Var, applicationContext);
    }

    public dc2(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, wb2 videoAdLoadNetwork, t92 vastDataRequestListenerFactory, hv1 sdkInitializer, lb2 videoAdErrorProvider, Context applicationContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(videoAdLoadNetwork, "videoAdLoadNetwork");
        Intrinsics.checkNotNullParameter(vastDataRequestListenerFactory, "vastDataRequestListenerFactory");
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        Intrinsics.checkNotNullParameter(videoAdErrorProvider, "videoAdErrorProvider");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f8681a = adConfiguration;
        this.b = adLoadingPhasesManager;
        this.c = videoAdLoadNetwork;
        this.d = vastDataRequestListenerFactory;
        this.e = sdkInitializer;
        this.f = videoAdErrorProvider;
        this.g = applicationContext;
        this.h = new LinkedHashSet();
    }

    public static final void a(dc2 dc2Var, jc jcVar, l50 l50Var) {
        dc2Var.f8681a.a(jcVar);
        dc2Var.f8681a.a(l50Var);
    }

    public final void a(z92 configuration, co0 requestConfigurationParametersProvider, Object requestTag, ca2 requestListener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        zb2 zb2Var = new zb2(this, configuration, requestConfigurationParametersProvider, requestListener, requestTag);
        ac2 ac2Var = new ac2(requestListener);
        if (this.h.contains(requestTag)) {
            zb2Var.invoke();
        } else {
            this.e.a(dl0.e, new yb2(this, requestTag, zb2Var, ac2Var));
        }
    }

    public final void a(gi2 configuration, Object requestTag, pm0 requestListener) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        bc2 bc2Var = new bc2(this, requestListener, configuration, requestTag);
        cc2 cc2Var = new cc2(requestListener);
        if (this.h.contains(requestTag)) {
            bc2Var.invoke();
        } else {
            this.e.a(dl0.e, new yb2(this, requestTag, bc2Var, cc2Var));
        }
    }
}
