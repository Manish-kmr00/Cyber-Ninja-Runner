package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.configuration.AdQualityVerifierAdapterConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k7 {
    public static AdQualityVerifierAdapterConfiguration a(b7 sdkAdQualityConfiguration) {
        Intrinsics.checkNotNullParameter(sdkAdQualityConfiguration, "sdkAdQualityConfiguration");
        return new AdQualityVerifierAdapterConfiguration(sdkAdQualityConfiguration.b(), sdkAdQualityConfiguration.h(), sdkAdQualityConfiguration.d());
    }
}
