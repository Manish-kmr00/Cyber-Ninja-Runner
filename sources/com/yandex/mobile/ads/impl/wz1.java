package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class wz1 implements zb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f10608a;

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
    }

    @Override // com.yandex.mobile.ads.impl.zb1
    public final void a(c71 nativeAdViewAdapter, zo clickListenerConfigurator) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurator, "clickListenerConfigurator");
        if (this.f10608a != null) {
            ja jaVar = new ja(nativeAdViewAdapter, clickListenerConfigurator);
            for (ig<?> igVar : this.f10608a) {
                jg<?> jgVarA = nativeAdViewAdapter.a(igVar);
                if (!(jgVarA instanceof jg)) {
                    jgVarA = null;
                }
                if (jgVarA != null) {
                    jgVarA.c(igVar.d());
                    Intrinsics.checkNotNull(igVar, "null cannot be cast to non-null type com.monetization.ads.network.model.Asset<kotlin.Any?>");
                    jgVarA.a(igVar, jaVar);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wz1(List<? extends ig<?>> list) {
        this.f10608a = list;
    }
}
