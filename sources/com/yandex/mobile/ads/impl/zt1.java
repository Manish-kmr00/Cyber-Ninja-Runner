package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes9.dex */
public final class zt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f10850a;
    private final Context b;
    private final g5 c;
    private final m50 d;
    private final jc e;
    private final pv1 f;
    private final c32 g;
    private final xt1 h;
    private final af1 i;

    public zt1(Context context, wm2 sdkEnvironmentModule, CoroutineScope coroutineScope, Context appContext, g5 adLoadingPhasesManager, m50 environmentController, jc advertisingConfiguration, pv1 sdkInitializerSuspendableWrapper, c32 strongReferenceKeepingManager, xt1 bidderTokenGenerator, af1 resultReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(environmentController, "environmentController");
        Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
        Intrinsics.checkNotNullParameter(sdkInitializerSuspendableWrapper, "sdkInitializerSuspendableWrapper");
        Intrinsics.checkNotNullParameter(strongReferenceKeepingManager, "strongReferenceKeepingManager");
        Intrinsics.checkNotNullParameter(bidderTokenGenerator, "bidderTokenGenerator");
        Intrinsics.checkNotNullParameter(resultReporter, "resultReporter");
        this.f10850a = coroutineScope;
        this.b = appContext;
        this.c = adLoadingPhasesManager;
        this.d = environmentController;
        this.e = advertisingConfiguration;
        this.f = sdkInitializerSuspendableWrapper;
        this.g = strongReferenceKeepingManager;
        this.h = bidderTokenGenerator;
        this.i = resultReporter;
    }

    public final void a(cl clVar, ml2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(this.f10850a, null, null, new yt1(this, clVar, listener, null), 3, null);
    }
}
