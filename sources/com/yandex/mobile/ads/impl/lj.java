package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kj<ExtendedNativeAdView> f9527a;

    public lj(kj<ExtendedNativeAdView> layoutDesignsController) {
        Intrinsics.checkNotNullParameter(layoutDesignsController, "layoutDesignsController");
        this.f9527a = layoutDesignsController;
    }

    public final void a() {
        this.f9527a.a();
    }

    public final void a(zy1 zy1Var, cj attachEventListener) {
        Intrinsics.checkNotNullParameter(attachEventListener, "attachEventListener");
        if (this.f9527a.a(zy1Var)) {
            attachEventListener.a();
        } else {
            attachEventListener.a(w7.i());
        }
    }
}
