package com.yandex.mobile.ads.impl;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.div.core.DivConfiguration;
import com.yandex.div2.DivData;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c30 implements be0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DivData f8564a;
    private final o3 b;
    private final y00<ExtendedNativeAdView> c;
    private final j1 d;
    private final i20 e;
    private final int f;
    private final t10 g;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.be0
    public final br0<ExtendedNativeAdView> a(Context context, o8<?> adResponse, m61 nativeAdPrivate, wr contentCloseListener, pt nativeAdEventListener, e1 eventController) {
        y00 i51Var;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        to clickConnector = new to();
        s20 s20Var = new s20(clickConnector);
        DivConfiguration divConfigurationA = this.g.a(context, this.f8564a, nativeAdPrivate, s20Var);
        h20 h20Var = new h20(context, this.b, adResponse, contentCloseListener, this.e, s20Var);
        o01 reporter = this.b.q().c();
        r20 r20Var = new r20(this.f8564a, h20Var, divConfigurationA, reporter, context instanceof LifecycleOwner ? (LifecycleOwner) context : null);
        y00[] y00VarArr = new y00[4];
        y00VarArr[0] = new iq1(this.d, this.f);
        y00VarArr[1] = r20Var;
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        if (nativeAdPrivate instanceof uz1) {
            uz1 uz1Var = (uz1) nativeAdPrivate;
            i51Var = new tz1(uz1Var, contentCloseListener, nativeAdEventListener, clickConnector, reporter, new h41(), new n61(), new dh(n61.b(uz1Var)));
        } else {
            i51Var = new i51(nativeAdPrivate, contentCloseListener, nativeAdEventListener, clickConnector, reporter, new h41(), new n61(), new dh(n61.a(nativeAdPrivate)));
        }
        y00VarArr[2] = new xd0(nativeAdPrivate, contentCloseListener, nativeAdEventListener, clickConnector, reporter, i51Var);
        y00VarArr[3] = this.c;
        return new br0<>(R.layout.monetization_ads_internal_divkit, new yq(y00VarArr), new b30(adResponse));
    }

    public /* synthetic */ c30(DivData divData, o3 o3Var, yq yqVar, j1 j1Var, i20 i20Var, int i) {
        this(divData, o3Var, yqVar, j1Var, i20Var, i, new t10(o3Var.q().c()));
    }

    public c30(DivData divData, o3 adConfiguration, yq adTypeSpecificBinder, j1 adActivityListener, i20 divKitActionHandlerDelegate, int i, t10 divConfigurationCreator) {
        Intrinsics.checkNotNullParameter(divData, "divData");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adTypeSpecificBinder, "adTypeSpecificBinder");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(divKitActionHandlerDelegate, "divKitActionHandlerDelegate");
        Intrinsics.checkNotNullParameter(divConfigurationCreator, "divConfigurationCreator");
        this.f8564a = divData;
        this.b = adConfiguration;
        this.c = adTypeSpecificBinder;
        this.d = adActivityListener;
        this.e = divKitActionHandlerDelegate;
        this.f = i;
        this.g = divConfigurationCreator;
    }
}
