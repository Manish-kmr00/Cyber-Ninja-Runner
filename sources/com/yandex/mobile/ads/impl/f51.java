package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f51 implements s81 {
    @Override // com.yandex.mobile.ads.impl.s81
    public final m61 a(Context context, c41 nativeAd, i61 nativeAdManager, pj0 imageProvider, jl binderConfiguration, a51 nativeAdControllers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdManager, "nativeAdManager");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(binderConfiguration, "binderConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        return new l41(context, nativeAd, nativeAdManager, imageProvider, binderConfiguration, nativeAdControllers);
    }
}
