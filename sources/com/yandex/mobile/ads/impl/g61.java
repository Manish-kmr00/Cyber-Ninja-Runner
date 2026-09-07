package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g61 implements f61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h61 f8969a;
    private final c61 b;

    public /* synthetic */ g61(Context context, uu1 uu1Var, q61 q61Var, h61 h61Var) {
        this(context, uu1Var, q61Var, h61Var, new g5(), new o3(qs.g, uu1Var), new b61(), new d61());
    }

    public g61(Context context, uu1 sdkEnvironmentModule, q61 requestData, h61 nativeAdLoadingItemFinishedListener, g5 adLoadingPhasesManager, o3 adConfiguration, b61 nativeAdLoadListenerFactory, d61 nativeAdLoadManagerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(nativeAdLoadingItemFinishedListener, "nativeAdLoadingItemFinishedListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdLoadListenerFactory, "nativeAdLoadListenerFactory");
        Intrinsics.checkNotNullParameter(nativeAdLoadManagerFactory, "nativeAdLoadManagerFactory");
        this.f8969a = nativeAdLoadingItemFinishedListener;
        nativeAdLoadListenerFactory.getClass();
        l61 l61VarA = b61.a(context, adConfiguration, adLoadingPhasesManager, this);
        nativeAdLoadManagerFactory.getClass();
        c61 c61VarA = d61.a(context, sdkEnvironmentModule, requestData, adConfiguration, l61VarA, adLoadingPhasesManager);
        this.b = c61VarA;
        l61VarA.a(c61VarA.f());
    }

    @Override // com.yandex.mobile.ads.impl.f61
    public final void a() {
        this.f8969a.a(this);
    }

    public final void c() {
        this.b.z();
    }

    public final void b() {
        this.b.y();
    }

    public final void a(st stVar) {
        this.b.a(stVar);
    }

    public final void a(yt ytVar) {
        this.b.a(ytVar);
    }

    public final void a(hu huVar) {
        this.b.a(huVar);
    }
}
