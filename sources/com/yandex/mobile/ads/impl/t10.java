package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div2.DivData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class t10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10256a;
    private final yz1 b;

    public final DivConfiguration a(Context context, DivData divData, m61 nativeAdPrivate, s20 clickHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        if (!(nativeAdPrivate instanceof uz1)) {
            DivConfiguration divConfigurationA = new x20(context, clickHandler).a();
            Intrinsics.checkNotNull(divConfigurationA);
            return divConfigurationA;
        }
        xz1 xz1Var = new xz1(this.f10256a);
        xz1Var.a(divData, (uz1) nativeAdPrivate);
        this.b.getClass();
        return yz1.a(context, xz1Var, clickHandler);
    }

    public /* synthetic */ t10(lp1 lp1Var) {
        this(lp1Var, new yz1());
    }

    public t10(lp1 reporter, yz1 sliderDivConfigurationCreator) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(sliderDivConfigurationCreator, "sliderDivConfigurationCreator");
        this.f10256a = reporter;
        this.b = sliderDivConfigurationCreator;
    }
}
