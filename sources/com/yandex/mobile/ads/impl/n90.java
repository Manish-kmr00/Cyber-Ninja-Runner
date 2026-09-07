package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rk1 f9708a;
    private final o3 b;
    private final j20 c;
    private final er0<ExtendedNativeAdView> d;

    public n90(rk1 divKitDesign, o3 adConfiguration, j20 divKitAdBinderFactory, er0<ExtendedNativeAdView> layoutDesignFactory) {
        Intrinsics.checkNotNullParameter(divKitDesign, "divKitDesign");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(divKitAdBinderFactory, "divKitAdBinderFactory");
        Intrinsics.checkNotNullParameter(layoutDesignFactory, "layoutDesignFactory");
        this.f9708a = divKitDesign;
        this.b = adConfiguration;
        this.c = divKitAdBinderFactory;
        this.d = layoutDesignFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
    }

    public final br0 a(Context context, o8 adResponse, uz1 nativeAdPrivate, pt nativeAdEventListener, ie2 videoEventController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        to toVarA = this.f9708a.a();
        s20 s20VarB = this.f9708a.b();
        wr wrVar = new wr() { // from class: com.yandex.mobile.ads.impl.n90$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.wr
            public final void f() {
                n90.a();
            }
        };
        fj fjVar = new fj();
        o01 o01VarC = this.b.q().c();
        this.c.getClass();
        yq designComponentBinder = new yq(new da0(this.f9708a, new h20(context, this.b, adResponse, wrVar, fjVar, s20VarB), o01VarC), j20.a(nativeAdPrivate, wrVar, nativeAdEventListener, toVarA, o01VarC), new y71(nativeAdPrivate.b(), videoEventController));
        b30 designConstraint = new b30(adResponse);
        er0<ExtendedNativeAdView> er0Var = this.d;
        int i = R.layout.monetization_ads_internal_divkit;
        er0Var.getClass();
        Intrinsics.checkNotNullParameter(ExtendedNativeAdView.class, "layoutViewClass");
        Intrinsics.checkNotNullParameter(designComponentBinder, "designComponentBinder");
        Intrinsics.checkNotNullParameter(designConstraint, "designConstraint");
        return new br0(i, designComponentBinder, designConstraint);
    }
}
