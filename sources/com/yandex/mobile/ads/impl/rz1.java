package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class rz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10156a;
    private final ha b;

    public final jl a(Context context, o41 nativeAdBlock, f81 nativeCompositeAd, o51 nativeAdFactoriesProvider, dc0 noticeForceTrackingController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(nativeCompositeAd, "nativeCompositeAd");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(noticeForceTrackingController, "noticeForceTrackingController");
        bc1 bc1VarA = this.b.a(nativeAdBlock);
        int i = s71.c;
        s71 s71VarA = s71.a.a();
        qz1 qz1Var = new qz1(bc1VarA.b(), s71VarA);
        int i2 = iw1.l;
        return new jl(nativeAdBlock, new vz1(context, nativeCompositeAd, qz1Var, iw1.a.a(), nativeAdBlock.b()), bc1VarA, new wz1(bc1VarA.b()), nativeAdFactoriesProvider, new ga(noticeForceTrackingController), new i71(context, qz1Var, s71VarA), this.f10156a, null, s9.c);
    }

    public /* synthetic */ rz1(uu1 uu1Var) {
        this(uu1Var, new ha());
    }

    public rz1(uu1 sdkEnvironmentModule, ha adUnitNativeVisualBlockCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adUnitNativeVisualBlockCreator, "adUnitNativeVisualBlockCreator");
        this.f10156a = sdkEnvironmentModule;
        this.b = adUnitNativeVisualBlockCreator;
    }
}
