package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d32 implements pt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pt f8662a;

    public d32(pt nativeAdEventListener) {
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        this.f8662a = nativeAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void a(t4 t4Var) {
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void closeNativeAd() {
        this.f8662a.closeNativeAd();
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onAdClicked() {
        this.f8662a.onAdClicked();
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onLeftApplication() {
        this.f8662a.onLeftApplication();
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onReturnedToApplication() {
        this.f8662a.onReturnedToApplication();
    }
}
