package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l41 extends t51 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l41(Context context, c41 nativeAd, i61 nativeAdManager, pj0 imageProvider, jl adBinderConfiguration, a51 nativeAdControllers) {
        super(context, nativeAd, nativeAdManager, imageProvider, adBinderConfiguration, nativeAdControllers);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdManager, "nativeAdManager");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adBinderConfiguration, "adBinderConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
    }
}
