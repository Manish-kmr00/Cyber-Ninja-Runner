package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j3 f10839a;
    private final po1 b;
    private final ec0 c;

    public zo(i3 adClickable, po1 renderedTimer, ec0 forceImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(adClickable, "adClickable");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
        this.f10839a = adClickable;
        this.b = renderedTimer;
        this.c = forceImpressionTrackingListener;
    }

    public final void a(ig<?> asset, rr0 rr0Var, c71 nativeAdViewAdapter, yo clickListenerConfigurable) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(clickListenerConfigurable, "clickListenerConfigurable");
        if (!asset.e() || rr0Var == null) {
            return;
        }
        clickListenerConfigurable.a(rr0Var, new ap(asset, this.f10839a, nativeAdViewAdapter, this.b, this.c));
    }
}
