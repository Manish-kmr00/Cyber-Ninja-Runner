package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t51 extends v81 implements m61 {
    private final i61 N;
    private pj0 O;
    private final t71 P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t51(Context context, c41 nativeAd, i61 nativeAdManager, pj0 imageProvider, jl binderConfiguration, a51 nativeAdControllers) {
        super(context, binderConfiguration, nativeAdControllers);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        Intrinsics.checkNotNullParameter(nativeAdManager, "nativeAdManager");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(binderConfiguration, "binderConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        this.N = nativeAdManager;
        this.O = imageProvider;
        t71 t71VarA = a(nativeAd, binderConfiguration.d().a());
        this.P = t71VarA;
        a(t71VarA);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.N.a(listener);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final zq1 getAdType() {
        return this.N.b();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final String getInfo() {
        return this.N.c();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final ot getAdAssets() {
        return this.N.a();
    }

    @Override // com.yandex.mobile.ads.impl.v81, com.yandex.mobile.ads.impl.m61
    public final vt getNativeAdVideoController() {
        return super.getNativeAdVideoController();
    }

    private final t71 a(c41 c41Var, o3 o3Var) {
        zq1 zq1VarG = c41Var.g();
        return new t71(o3Var, zq1VarG.a(), e(), a(), new uy1(c41Var, new xq1(), new c8(), new hr()), null);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void a(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.N.b(listener);
    }

    @Override // com.yandex.mobile.ads.impl.v81, com.yandex.mobile.ads.impl.m61
    public final void loadImages() {
        this.N.d();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider, to clickConnector) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        View viewD = viewProvider.d();
        n71 n71Var = new n71(viewProvider);
        pj0 pj0Var = this.O;
        bp.f8528a.getClass();
        a(viewD, pj0Var, n71Var, bp.a.a(), clickConnector);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        this.P.a(viewProvider.e());
        View viewD = viewProvider.d();
        n71 n71Var = new n71(viewProvider);
        pj0 pj0Var = this.O;
        bp.f8528a.getClass();
        a(viewD, pj0Var, n71Var, bp.a.a());
    }
}
