package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k51 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig<?> f9381a;
    private final j3 b;
    private final c71 c;
    private final po1 d;
    private final rr0 e;
    private final ec0 f;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        long jB = this.d.b();
        rr0 rr0Var = this.e;
        if (rr0Var == null || jB < rr0Var.b() || !this.f9381a.e() || !this.b.a(view, this.f9381a, this.e, this.c).a()) {
            return;
        }
        this.f.a();
    }

    public k51(ig asset, rr0 rr0Var, j3 adClickable, c71 nativeAdViewAdapter, po1 renderedTimer, ec0 forceImpressionTrackingListener) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adClickable, "adClickable");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(forceImpressionTrackingListener, "forceImpressionTrackingListener");
        this.f9381a = asset;
        this.b = adClickable;
        this.c = nativeAdViewAdapter;
        this.d = renderedTimer;
        this.e = rr0Var;
        this.f = forceImpressionTrackingListener;
    }
}
