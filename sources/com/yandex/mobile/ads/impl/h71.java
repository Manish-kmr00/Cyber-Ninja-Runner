package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h71 implements zb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c41 f9068a;
    private c71 b;

    public h71(c41 nativeAd, c71 c71Var) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        this.f9068a = nativeAd;
        this.b = c71Var;
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        nativeAdViewAdapter.a();
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter, zo clickListenerConfigurator) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurator, "clickListenerConfigurator");
        this.b = nativeAdViewAdapter;
        ra raVar = new ra(nativeAdViewAdapter, clickListenerConfigurator, this.f9068a.e(), new mh2());
        for (ig<?> igVar : this.f9068a.b()) {
            jg<?> jgVarA = nativeAdViewAdapter.a(igVar);
            if (!(jgVarA instanceof jg)) {
                jgVarA = null;
            }
            if (jgVarA != null) {
                jgVarA.c(igVar.d());
                Intrinsics.checkNotNull(igVar, "null cannot be cast to non-null type com.monetization.ads.network.model.Asset<kotlin.Any?>");
                jgVarA.a(igVar, raVar);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a() {
        c71 c71Var = this.b;
        if (c71Var != null) {
            for (ig<?> igVar : this.f9068a.b()) {
                jg<?> jgVarA = c71Var.a(igVar);
                if (jgVarA instanceof v00) {
                    ((v00) jgVarA).b(igVar.d());
                }
            }
        }
    }
}
