package com.yandex.mobile.ads.impl;

import com.monetization.ads.mediation.nativeads.MediatedNativeAd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class az0 implements ac1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediatedNativeAd f8460a;
    private final ty0 b;
    private final l7 c;
    private final ac1 d;

    public az0(MediatedNativeAd mediatedNativeAd, ty0 mediatedNativeRenderingTracker, l7 adQualityVerifierController, ac1 sdkAdFactory) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        Intrinsics.checkNotNullParameter(mediatedNativeRenderingTracker, "mediatedNativeRenderingTracker");
        Intrinsics.checkNotNullParameter(adQualityVerifierController, "adQualityVerifierController");
        Intrinsics.checkNotNullParameter(sdkAdFactory, "sdkAdFactory");
        this.f8460a = mediatedNativeAd;
        this.b = mediatedNativeRenderingTracker;
        this.c = adQualityVerifierController;
        this.d = sdkAdFactory;
    }

    @Override // com.yandex.mobile.ads.impl.ac1
    public final zb1 a(c41 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        return new uy0(this.d.a(nativeAd), this.f8460a, this.b, this.c);
    }
}
