package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9595a;

    public m41(uu1 mSdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(mSdkEnvironmentModule, "mSdkEnvironmentModule");
        this.f9595a = mSdkEnvironmentModule;
    }

    public final jl a(Context context, o41 nativeAdBlock, bc1 nativeVisualBlock, zb1 viewRenderer, o51 nativeAdFactoriesProvider, dc0 noticeForceTrackingController, c41 nativeAd, s9 adStructureType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
        Intrinsics.checkNotNullParameter(viewRenderer, "viewRenderer");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(noticeForceTrackingController, "noticeForceTrackingController");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        int i = s71.c;
        s71 s71VarA = s71.a.a();
        k41 k41Var = new k41(nativeVisualBlock.b(), s71VarA);
        return new jl(nativeAdBlock, new b71(context, k41Var, nativeAdBlock.b()), nativeVisualBlock, viewRenderer, nativeAdFactoriesProvider, new k5(noticeForceTrackingController), new i71(context, k41Var, s71VarA), this.f9595a, nativeAd, adStructureType);
    }
}
