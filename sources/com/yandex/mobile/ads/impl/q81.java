package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q81 implements pt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j1 f9995a;
    private final sd0 b;

    public q81(v1 adActivityListener, sd0 fullscreenAdtuneCloseEnabledProvider) {
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(fullscreenAdtuneCloseEnabledProvider, "fullscreenAdtuneCloseEnabledProvider");
        this.f9995a = adActivityListener;
        this.b = fullscreenAdtuneCloseEnabledProvider;
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onAdClicked() {
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onLeftApplication() {
        this.f9995a.a(17, null);
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onReturnedToApplication() {
        this.f9995a.a(18, null);
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void a(t4 t4Var) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("impression_data_key", t4Var);
        this.f9995a.a(16, bundle);
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void closeNativeAd() {
        if (this.b.a()) {
            this.f9995a.a();
        }
    }
}
