package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f8430a;
    private final j3 b;
    private final c71 c;
    private final po1 d;
    private final ec0 e;

    public ap(ig<?> asset, j3 adClickable, c71 nativeAdViewAdapter, po1 renderedTimer, ec0 forceImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adClickable, "adClickable");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
        this.f8430a = asset;
        this.b = adClickable;
        this.c = nativeAdViewAdapter;
        this.d = renderedTimer;
        this.e = forceImpressionTrackingListener;
    }

    public final View.OnClickListener a(rr0 link) {
        Intrinsics.checkNotNullParameter(link, "link");
        return this.c.f().a(this.f8430a, link, this.b, this.c, this.d, this.e);
    }
}
