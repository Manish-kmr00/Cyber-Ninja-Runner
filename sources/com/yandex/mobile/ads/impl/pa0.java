package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pa0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f9905a;

    public pa0(ot nativeAdAssets, ki availableAssetsProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(availableAssetsProvider, "availableAssetsProvider");
        availableAssetsProvider.getClass();
        this.f9905a = ki.a(nativeAdAssets);
    }

    public final boolean a() {
        return this.f9905a.size() == 2 && this.f9905a.contains("feedback") && this.f9905a.contains("media");
    }
}
