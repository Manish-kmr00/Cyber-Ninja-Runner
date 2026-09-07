package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d62 f9697a;
    private final u81 b;
    private final rz1 c;

    public final g81 a(Context context, o41 nativeAdBlock, pj0 imageProvider, o51 nativeAdFactoriesProvider, a51 nativeAdControllers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        dc0 dc0Var = new dc0();
        f81 f81Var = new f81(this.b.a(context, nativeAdBlock, imageProvider, nativeAdFactoriesProvider, dc0Var, nativeAdControllers));
        return new g81(context, f81Var, imageProvider, this.c.a(context, nativeAdBlock, f81Var, nativeAdFactoriesProvider, dc0Var), nativeAdControllers);
    }

    public /* synthetic */ n41(uu1 uu1Var) {
        this(uu1Var, new d62(), new u81(uu1Var), new rz1(uu1Var));
    }

    public n41(uu1 sdkEnvironmentModule, d62 trackingDataCreator, u81 nativeGenericAdsCreator, rz1 sliderAdBinderConfigurationCreator) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(trackingDataCreator, "trackingDataCreator");
        Intrinsics.checkNotNullParameter(nativeGenericAdsCreator, "nativeGenericAdsCreator");
        Intrinsics.checkNotNullParameter(sliderAdBinderConfigurationCreator, "sliderAdBinderConfigurationCreator");
        this.f9697a = trackingDataCreator;
        this.b = nativeGenericAdsCreator;
        this.c = sliderAdBinderConfigurationCreator;
    }

    public final bc1 a(o41 nativeAdBlock, c41 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        d62 d62Var = this.f9697a;
        List<xx1> listH = nativeAd.h();
        List<xx1> listI = nativeAdBlock.c().i();
        d62Var.getClass();
        ArrayList arrayListA = d62.a(listH, listI);
        d62 d62Var2 = this.f9697a;
        List<String> listF = nativeAd.f();
        List<String> listG = nativeAdBlock.c().g();
        d62Var2.getClass();
        return new bc1(nativeAd.b(), arrayListA, d62.a(listF, listG), nativeAd.a(), nativeAd.c());
    }
}
