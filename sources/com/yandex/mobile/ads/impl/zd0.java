package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.ExtendedNativeAdView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class zd0 implements vd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gr0<ExtendedNativeAdView> f10808a;
    private final wr b;

    public zd0(gr0<ExtendedNativeAdView> layoutDesignsController, wr contentCloseListener) {
        Intrinsics.checkNotNullParameter(layoutDesignsController, "layoutDesignsController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        this.f10808a = layoutDesignsController;
        this.b = contentCloseListener;
    }

    @Override // com.yandex.mobile.ads.impl.vd0
    public final void c() {
        if (this.f10808a.a()) {
            return;
        }
        this.b.f();
    }

    @Override // com.yandex.mobile.ads.impl.vd0
    public final void invalidate() {
        this.f10808a.b();
    }
}
