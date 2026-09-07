package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
public final class yq0 implements be0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y00<ExtendedNativeAdView> f10764a;
    private final lp1 b;
    private final nq1 c;
    private final tq d;

    public yq0(dq adTypeSpecificBinder, lp1 reporter, nq1 resourceUtils, tq commonComponentsBinderProvider) {
        Intrinsics.checkNotNullParameter(adTypeSpecificBinder, "adTypeSpecificBinder");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(resourceUtils, "resourceUtils");
        Intrinsics.checkNotNullParameter(commonComponentsBinderProvider, "commonComponentsBinderProvider");
        this.f10764a = adTypeSpecificBinder;
        this.b = reporter;
        this.c = resourceUtils;
        this.d = commonComponentsBinderProvider;
    }

    @Override // com.yandex.mobile.ads.impl.be0
    public final br0<ExtendedNativeAdView> a(Context context, o8<?> adResponse, m61 nativeAdPrivate, wr contentCloseListener, pt nativeAdEventListener, e1 eventController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        ot adAssets = nativeAdPrivate.getAdAssets();
        nq1 nq1Var = this.c;
        int i = R.dimen.monetization_ads_internal_landscape_vertical_icon_size;
        nq1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        ar arVar = new ar(adAssets, MathKt.roundToInt(context.getResources().getDimension(i)));
        tq tqVar = this.d;
        y00<ExtendedNativeAdView> y00Var = this.f10764a;
        lp1 lp1Var = this.b;
        tqVar.getClass();
        yq yqVar = new yq(arVar, tq.a(nativeAdPrivate, contentCloseListener, nativeAdEventListener, y00Var, lp1Var), new tu0(adAssets, new w41(), new uu0(adAssets)), new jh1(adAssets, new d41(), new g41()), new bj2(), new rn(nativeAdPrivate, new g41()));
        ot adAssets2 = nativeAdPrivate.getAdAssets();
        nq1 nq1Var2 = this.c;
        int i2 = R.dimen.monetization_ads_internal_landscape_vertical_media_content_min_width;
        nq1Var2.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return new br0<>(R.layout.monetization_ads_internal_native_interstitial_landscape_vetrical_media, yqVar, new zq(new if1(2), new av0(adAssets2, MathKt.roundToInt(context.getResources().getDimension(i2)), new uu0(adAssets2))));
    }
}
