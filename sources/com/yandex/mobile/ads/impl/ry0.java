package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapter;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ry0 implements h81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> f10153a;
    private final o71 b;

    public ry0(c61 nativeAdLoadManager, o8<u61> adResponse, dz0 mediationData, o3 adConfiguration, hy0 extrasCreator, cy0 mediatedAdapterReporter, vx0<MediatedNativeAdapter> mediatedAdProvider, oy0 mediatedAdCreator, g5 adLoadingPhasesManager, eg1 passbackAdLoader, py0 mediatedNativeAdLoader, nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> mediatedAdController, o71 mediatedNativeAdapterListener) {
        Intrinsics.checkNotNullParameter(nativeAdLoadManager, "nativeAdLoadManager");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(extrasCreator, "extrasCreator");
        Intrinsics.checkNotNullParameter(mediatedAdapterReporter, "mediatedAdapterReporter");
        Intrinsics.checkNotNullParameter(mediatedAdProvider, "mediatedAdProvider");
        Intrinsics.checkNotNullParameter(mediatedAdCreator, "mediatedAdCreator");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(passbackAdLoader, "passbackAdLoader");
        Intrinsics.checkNotNullParameter(mediatedNativeAdLoader, "mediatedNativeAdLoader");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(mediatedNativeAdapterListener, "mediatedNativeAdapterListener");
        this.f10153a = mediatedAdController;
        this.b = mediatedNativeAdapterListener;
    }

    @Override // com.yandex.mobile.ads.impl.h81
    public final void a(Context context, o8<u61> adResponse) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10153a.a(context, this.b);
    }
}
