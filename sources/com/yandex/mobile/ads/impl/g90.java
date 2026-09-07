package com.yandex.mobile.ads.impl;

import android.view.ContextThemeWrapper;
import com.yandex.div.core.Div2Context;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div2.DivData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g90 extends Div2Context {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xz1 f8979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g90(ContextThemeWrapper baseContext, DivConfiguration configuration, xz1 sliderAdsBindingExtensionHandler) {
        super(baseContext, configuration, 0, new pb0(), 4, null);
        Intrinsics.checkNotNullParameter(baseContext, "baseContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(sliderAdsBindingExtensionHandler, "sliderAdsBindingExtensionHandler");
        this.f8979a = sliderAdsBindingExtensionHandler;
    }

    public final void a(DivData divData, uz1 nativeAdPrivate) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        this.f8979a.a(divData, nativeAdPrivate);
    }
}
