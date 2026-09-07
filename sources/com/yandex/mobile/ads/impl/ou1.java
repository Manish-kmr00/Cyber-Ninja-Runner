package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ou1 implements pk.a<cu1>, xp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iu1 f9860a;
    private final gu1.a b;
    private final g5 c;
    private final Context d;
    private final ir e;

    public ou1(Context context, iu1 sdkConfigurationProvider, hu1.a.b sdkConfigurationLoadListener, g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkConfigurationProvider, "sdkConfigurationProvider");
        Intrinsics.checkNotNullParameter(sdkConfigurationLoadListener, "sdkConfigurationLoadListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f9860a = sdkConfigurationProvider;
        this.b = sdkConfigurationLoadListener;
        this.c = adLoadingPhasesManager;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.d = applicationContext;
        this.e = ir.c;
    }

    @Override // com.yandex.mobile.ads.impl.qq1.a
    public final void a(ki2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.c.a(f5.o);
        this.b.a(error, this.e);
    }

    @Override // com.yandex.mobile.ads.impl.xp1
    public final void b() {
        this.c.a(f5.n);
        g5 g5Var = this.c;
        f5 f5Var = f5.o;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
    }

    @Override // com.yandex.mobile.ads.impl.qq1.b
    public final void a(Object obj) {
        cu1 sdkConfiguration = (cu1) obj;
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        this.f9860a.a(this.d, sdkConfiguration);
        this.c.a(f5.o);
        this.b.a(sdkConfiguration, this.e);
    }
}
