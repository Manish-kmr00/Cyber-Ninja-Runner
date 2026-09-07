package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.div2.DivData;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DivData f9008a;
    private final o3 b;
    private final j20 c;
    private final t10 d;
    private final er0<ExtendedNativeAdView> e;

    public gj(DivData divData, o3 adConfiguration, j20 divKitAdBinderFactory, t10 divConfigurationCreator, er0<ExtendedNativeAdView> layoutDesignFactory) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(divKitAdBinderFactory, "divKitAdBinderFactory");
        Intrinsics.checkNotNullParameter(divConfigurationCreator, "divConfigurationCreator");
        Intrinsics.checkNotNullParameter(layoutDesignFactory, "layoutDesignFactory");
        this.f9008a = divData;
        this.b = adConfiguration;
        this.c = divKitAdBinderFactory;
        this.d = divConfigurationCreator;
        this.e = layoutDesignFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
    }

    public final br0 a(Context context, o8 adResponse, m61 nativeAdPrivate, x71 nativeAdEventListener, ie2 videoEventController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        to toVar = new to();
        wr wrVar = new wr() { // from class: com.yandex.mobile.ads.impl.gj$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.wr
            public final void f() {
                gj.a();
            }
        };
        fj fjVar = new fj();
        o01 o01VarC = this.b.q().c();
        this.c.getClass();
        y00 y00VarA = j20.a(nativeAdPrivate, wrVar, nativeAdEventListener, toVar, o01VarC);
        s20 s20Var = new s20(toVar);
        yq designComponentBinder = new yq(new r20(this.f9008a, new h20(context, this.b, adResponse, wrVar, fjVar, s20Var), this.d.a(context, this.f9008a, nativeAdPrivate, s20Var), o01VarC, new pb0()), y00VarA, new y71(nativeAdPrivate.b(), videoEventController));
        b30 designConstraint = new b30(adResponse);
        er0<ExtendedNativeAdView> er0Var = this.e;
        int i = R.layout.monetization_ads_internal_divkit;
        er0Var.getClass();
        Intrinsics.checkNotNullParameter(ExtendedNativeAdView.class, "layoutViewClass");
        Intrinsics.checkNotNullParameter(designComponentBinder, "designComponentBinder");
        Intrinsics.checkNotNullParameter(designConstraint, "designConstraint");
        return new br0(i, designComponentBinder, designConstraint);
    }
}
