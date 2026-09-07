package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class js1 implements a10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fs1 f9350a;

    public js1(o3 adConfiguration, j1 adActivityListener, fs1 rewardedDivKitDesignCreatorProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(rewardedDivKitDesignCreatorProvider, "rewardedDivKitDesignCreatorProvider");
        this.f9350a = rewardedDivKitDesignCreatorProvider;
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
        ArrayList arrayList = new ArrayList();
        c30 c30VarA = this.f9350a.a(context, adResponse, nativeAdPrivate, eventController, adCompleteListener, closeVerificationController, timeProviderContainer, divKitActionHandlerDelegate, y20Var, m6Var);
        if (c30VarA != null) {
            arrayList.add(c30VarA);
        }
        return arrayList;
    }
}
