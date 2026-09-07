package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class cw1 implements h81 {
    static final /* synthetic */ KProperty<Object>[] f = {ta.a(cw1.class, "nativeAdLoadManager", "getNativeAdLoadManager()Lcom/monetization/ads/nativeads/NativeAdLoadManager;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8647a;
    private final zv1 b;
    private final zn1 c;
    private final qt1 d;
    private final p71 e;

    public cw1(uu1 sdkEnvironmentModule, c61 nativeAdLoadManager, o3 adConfiguration, zv1 sdkNativeAdFactoriesProviderCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdLoadManager, "nativeAdLoadManager");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sdkNativeAdFactoriesProviderCreator, "sdkNativeAdFactoriesProviderCreator");
        this.f8647a = adConfiguration;
        this.b = sdkNativeAdFactoriesProviderCreator;
        this.c = ao1.a(nativeAdLoadManager);
        this.d = new qt1(nativeAdLoadManager.f());
        this.e = new p71(nativeAdLoadManager.f());
    }

    @Override // com.yandex.mobile.ads.impl.h81
    public final void a(Context context, o8<u61> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        c61 c61Var = (c61) this.c.getValue(this, f[0]);
        if (c61Var != null) {
            g5 g5VarI = c61Var.i();
            f5 adLoadingPhaseType = f5.c;
            g5VarI.getClass();
            Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
            g5VarI.a(adLoadingPhaseType, null);
            q71 q71Var = new q71(adResponse, adResponse.I(), this.f8647a);
            this.d.a(context, adResponse, this.e);
            this.d.a(context, adResponse, q71Var);
            c61Var.a(adResponse, this.b.a(adResponse));
        }
    }
}
