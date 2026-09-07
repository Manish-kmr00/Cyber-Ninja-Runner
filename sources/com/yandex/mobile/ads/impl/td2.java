package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes13.dex */
public final class td2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qd2 f10291a;

    public final Object a(ArrayList arrayList, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.f10291a.a(arrayList, new sd2(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public /* synthetic */ td2(Context context, o3 o3Var, ua1 ua1Var, mf1 mf1Var) {
        this(context, o3Var, ua1Var, mf1Var, new qd2(context, o3Var, ua1Var, mf1Var));
    }

    public td2(Context context, o3 adConfiguration, ua1 reportParametersProvider, mf1 requestConfigurationParametersProvider, qd2 videoAdsResponseHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(reportParametersProvider, "reportParametersProvider");
        Intrinsics.checkNotNullParameter(requestConfigurationParametersProvider, "requestConfigurationParametersProvider");
        Intrinsics.checkNotNullParameter(videoAdsResponseHandler, "videoAdsResponseHandler");
        this.f10291a = videoAdsResponseHandler;
    }
}
