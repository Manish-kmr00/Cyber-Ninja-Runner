package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g81 extends v81 implements uz1 {
    private final f81 N;
    private final pj0 O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g81(Context context, f81 nativeCompositeAd, pj0 imageProvider, jl binderConfiguration, a51 nativeAdControllers) {
        super(context, binderConfiguration, nativeAdControllers);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeCompositeAd, "nativeCompositeAd");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(binderConfiguration, "binderConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        this.N = nativeCompositeAd;
        this.O = imageProvider;
        a(a(binderConfiguration.d().a()));
    }

    @Override // com.yandex.mobile.ads.impl.uz1
    public final void a(g71 viewBinder, to clickConnector) throws a61 {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        View viewD = viewBinder.d();
        n71 n71Var = new n71(viewBinder);
        pj0 pj0Var = this.O;
        bp.f8528a.getClass();
        a(viewD, pj0Var, n71Var, bp.a.a(), clickConnector);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.N.b(listener);
    }

    @Override // com.yandex.mobile.ads.impl.uz1
    public final ArrayList d() {
        return new ArrayList(this.N.e());
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final ot getAdAssets() {
        return this.N.getAdAssets();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final zq1 getAdType() {
        return this.N.getAdType();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final String getInfo() {
        return this.N.getInfo();
    }

    @Override // com.yandex.mobile.ads.impl.v81, com.yandex.mobile.ads.impl.m61
    public final vt getNativeAdVideoController() {
        return super.getNativeAdVideoController();
    }

    @Override // com.yandex.mobile.ads.impl.uz1
    public final void a(g71 viewProvider) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        View viewD = viewProvider.d();
        n71 n71Var = new n71(viewProvider);
        pj0 pj0Var = this.O;
        bp.f8528a.getClass();
        a(viewD, pj0Var, n71Var, bp.a.a());
    }

    @Override // com.yandex.mobile.ads.impl.v81, com.yandex.mobile.ads.impl.m61
    public final void loadImages() {
        this.N.loadImages();
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider, to clickConnector) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        this.N.b(viewProvider, clickConnector);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void a(rt listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.N.a(listener);
    }

    @Override // com.yandex.mobile.ads.impl.m61
    public final void b(g71 viewProvider) throws a61 {
        Intrinsics.checkNotNullParameter(viewProvider, "viewProvider");
        this.N.b(viewProvider);
    }

    @Override // com.yandex.mobile.ads.impl.v81, com.yandex.mobile.ads.impl.m61
    public final void a(pt ptVar) {
        this.N.a(ptVar);
    }

    @Override // com.yandex.mobile.ads.impl.uz1
    public final void b(pt ptVar) {
        super.a(ptVar);
    }

    private final t71 a(o3 o3Var) {
        t71 t71Var = new t71(o3Var, y91.e.a(), e(), a(), new r71(), null);
        t71Var.a(b81.c);
        return t71Var;
    }
}
