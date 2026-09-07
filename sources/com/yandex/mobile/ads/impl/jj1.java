package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class jj1 implements be0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y00<ExtendedNativeAdView> f9325a;
    private final lp1 b;
    private final tq c;

    public jj1(dq adTypeSpecificBinder, lp1 reporter, tq commonComponentsBinderProvider) {
        Intrinsics.checkNotNullParameter(adTypeSpecificBinder, "adTypeSpecificBinder");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(commonComponentsBinderProvider, "commonComponentsBinderProvider");
        this.f9325a = adTypeSpecificBinder;
        this.b = reporter;
        this.c = commonComponentsBinderProvider;
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
        tq tqVar = this.c;
        y00<ExtendedNativeAdView> y00Var = this.f9325a;
        lp1 lp1Var = this.b;
        tqVar.getClass();
        return new br0<>(R.layout.monetization_ads_internal_native_interstitial_portrait, new yq(tq.a(nativeAdPrivate, contentCloseListener, nativeAdEventListener, y00Var, lp1Var), new gw0(adAssets, new w41(), new uu0(adAssets)), new bj2(), new rn(nativeAdPrivate, new g41()), new pn(context, new g41(), new on(context))), new if1(1));
    }
}
