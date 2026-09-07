package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class aq0 implements a10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8434a;
    private final zp0 b;
    private final y41 c;

    public aq0(o3 adConfiguration, j1 adActivityListener, zp0 interstitialDivKitDesignCreatorProvider, y41 nativeAdControlViewProviderById) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(interstitialDivKitDesignCreatorProvider, "interstitialDivKitDesignCreatorProvider");
        Intrinsics.checkNotNullParameter(nativeAdControlViewProviderById, "nativeAdControlViewProviderById");
        this.f8434a = adConfiguration;
        this.b = interstitialDivKitDesignCreatorProvider;
        this.c = nativeAdControlViewProviderById;
    }

    @Override // com.yandex.mobile.ads.impl.a10
    public final List<be0> a(Context context, o8<?> adResponse, m61 nativeAdPrivate, wr contentCloseListener, pt nativeAdEventListener, e1 eventController, aw debugEventsReporter, k3 adCompleteListener, ds1 closeVerificationController, y42 timeProviderContainer, i20 divKitActionHandlerDelegate, y20 y20Var, m6 m6Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        dq dqVarA = new yp0(adResponse, eventController, contentCloseListener, new vh2()).a(this.c, debugEventsReporter, timeProviderContainer);
        o01 o01VarC = this.f8434a.q().c();
        return CollectionsKt.filterNotNull(CollectionsKt.plus((Collection) CollectionsKt.listOf(this.b.a(context, adResponse, nativeAdPrivate, eventController, contentCloseListener, adCompleteListener, debugEventsReporter, divKitActionHandlerDelegate, timeProviderContainer, y20Var, m6Var)), (Iterable) CollectionsKt.listOf((Object[]) new be0[]{new jj1(dqVarA, o01VarC, new tq()), new yq0(dqVarA, o01VarC, new nq1(), new tq()), new xq0(dqVarA, o01VarC, new nq1(), new tq())})));
    }
}
