package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import com.yandex.div.core.view2.Div2View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class da0 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rk1 f8675a;
    private final h20 b;
    private final lp1 c;

    public da0(rk1 preloadedDivKitDesign, h20 divKitActionAdapter, lp1 reporter) {
        Intrinsics.checkNotNullParameter(preloadedDivKitDesign, "preloadedDivKitDesign");
        Intrinsics.checkNotNullParameter(divKitActionAdapter, "divKitActionAdapter");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f8675a = preloadedDivKitDesign;
        this.b = divKitActionAdapter;
        this.c = reporter;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView container = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(container, "container");
        try {
            container.removeAllViews();
            Div2View div2ViewD = this.f8675a.d();
            sg2.a(div2ViewD);
            r10.a(div2ViewD).a(this.b);
            container.addView(div2ViewD);
        } catch (Throwable th) {
            op0.b(new Object[0]);
            this.c.reportError("Failed to bind DivKit Feed Preloaded Ad", th);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        Div2View div2ViewD = this.f8675a.d();
        r10.a(div2ViewD).a((h20) null);
        sg2.a(div2ViewD);
    }
}
