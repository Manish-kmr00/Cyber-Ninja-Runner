package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d61 {
    public static c61 a(Context context, uu1 sdkEnvironmentModule, q61 requestData, o3 adConfiguration, l61 nativeAdOnLoadListener, g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdOnLoadListener, "nativeAdOnLoadListener");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(nu.a()));
        w61 w61Var = new w61(sdkEnvironmentModule, adConfiguration);
        z61 z61Var = new z61(adConfiguration);
        int i = c32.d;
        return new c61(context, sdkEnvironmentModule, requestData, adConfiguration, nativeAdOnLoadListener, adLoadingPhasesManager, CoroutineScope, w61Var, z61Var, c32.a.a(), new e51(context, sdkEnvironmentModule, adConfiguration, adLoadingPhasesManager, CoroutineScope));
    }
}
