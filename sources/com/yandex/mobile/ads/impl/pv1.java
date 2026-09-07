package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes11.dex */
public final class pv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hv1 f9952a;

    public /* synthetic */ pv1(Context context, wm2 wm2Var, CoroutineScope coroutineScope, g5 g5Var, m50 m50Var, jc jcVar) {
        this(context, wm2Var, coroutineScope, g5Var, m50Var, jcVar, new hv1(context, wm2Var, coroutineScope, g5Var, m50Var, jcVar, 2097088));
    }

    public pv1(Context context, wm2 sdkEnvironmentModule, CoroutineScope coroutineScope, g5 adLoadingPhasesManager, m50 environmentController, jc advertisingConfiguration, hv1 sdkInitializer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(sdkInitializer, "sdkInitializer");
        this.f9952a = sdkInitializer;
    }

    public final Object a(Continuation continuation) {
        dl0 dl0Var = dl0.f;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new nv1(this));
        this.f9952a.a(dl0Var, new ov1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
