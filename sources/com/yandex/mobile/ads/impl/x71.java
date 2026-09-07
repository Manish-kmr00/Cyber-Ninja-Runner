package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x71 implements pt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zi f10627a;

    public x71(zi adViewController) {
        Intrinsics.checkNotNullParameter(adViewController, "adViewController");
        this.f10627a = adViewController;
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onAdClicked() {
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onLeftApplication() {
        this.f10627a.onLeftApplication();
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onReturnedToApplication() {
        this.f10627a.onReturnedToApplication();
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void a(t4 t4Var) {
        this.f10627a.a(t4Var);
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void closeNativeAd() {
        this.f10627a.A();
    }
}
