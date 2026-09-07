package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class iq1 implements y00<ExtendedNativeAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j1 f9253a;
    private final int b;

    public iq1(j1 adActivityListener, int i) {
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        this.f9253a = adActivityListener;
        this.b = i;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(ViewGroup viewGroup) {
        ExtendedNativeAdView container = (ExtendedNativeAdView) viewGroup;
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.b == 1) {
            this.f9253a.a(7);
        } else {
            this.f9253a.a(6);
        }
    }
}
