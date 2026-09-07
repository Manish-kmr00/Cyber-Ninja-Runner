package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j81 implements c51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v91.b f9294a;

    public j81(v91.b responseCreationListener) {
        Intrinsics.checkNotNullParameter(responseCreationListener, "responseCreationListener");
        this.f9294a = responseCreationListener;
    }

    @Override // com.yandex.mobile.ads.impl.c51
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f9294a.a(error);
    }

    @Override // com.yandex.mobile.ads.impl.c51
    public final void a(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        this.f9294a.a(nativeAd);
    }

    @Override // com.yandex.mobile.ads.impl.c51
    public final void a(ArrayList nativeAds) {
        Intrinsics.checkNotNullParameter(nativeAds, "nativeAds");
        this.f9294a.a(w7.x());
    }

    @Override // com.yandex.mobile.ads.impl.c51
    public final void a(g81 sliderAd) {
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        this.f9294a.a(sliderAd);
    }
}
