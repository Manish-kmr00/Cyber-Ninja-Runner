package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ja implements qg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c71 f9297a;
    private final zo b;

    public ja(c71 nativeAdViewAdapter, zo clickListenerConfigurator) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurator, "clickListenerConfigurator");
        this.f9297a = nativeAdViewAdapter;
        this.b = clickListenerConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.qg2
    public final void a(ig<?> asset, yo clickListenerConfigurable) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(clickListenerConfigurable, "clickListenerConfigurable");
        this.b.a(asset, asset.a(), this.f9297a, clickListenerConfigurable);
    }

    @Override // com.yandex.mobile.ads.impl.qg2
    public final void a(View view, ig asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
