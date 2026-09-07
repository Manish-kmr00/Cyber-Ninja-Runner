package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes5.dex */
public final class r91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f10085a;
    private final m91 b;
    private final la1 c;

    public interface a {
        void a(uk1 uk1Var, o41 o41Var);
    }

    public /* synthetic */ r91(Context context, uu1 uu1Var, g5 g5Var, a51 a51Var, CoroutineScope coroutineScope) {
        this(context, uu1Var, g5Var, a51Var, coroutineScope, new m91(context, g5Var, a51Var), new la1(context, uu1Var.a()));
    }

    public r91(Context context, uu1 sdkEnvironmentModule, g5 adLoadingPhasesManager, a51 controllers, CoroutineScope coroutineScope, m91 nativeMediaLoader, la1 nativeVerificationResourcesLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(controllers, "controllers");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(nativeMediaLoader, "nativeMediaLoader");
        Intrinsics.checkNotNullParameter(nativeVerificationResourcesLoader, "nativeVerificationResourcesLoader");
        this.f10085a = coroutineScope;
        this.b = nativeMediaLoader;
        this.c = nativeVerificationResourcesLoader;
    }

    public final void a() {
        this.b.a();
        this.c.a();
        CoroutineScopeKt.cancel$default(this.f10085a, null, 1, null);
    }

    public final void a(Context context, o3 adConfiguration, o41 nativeAdBlock, e51.a.C0743a listener, bw debugEventReporter, c51 nativeAdCreationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(debugEventReporter, "debugEventReporter");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        BuildersKt__Builders_commonKt.launch$default(this.f10085a, new t91(nativeAdCreationListener), null, new s91(context, nativeAdCreationListener, listener, this, adConfiguration, nativeAdBlock, debugEventReporter, null), 2, null);
    }
}
