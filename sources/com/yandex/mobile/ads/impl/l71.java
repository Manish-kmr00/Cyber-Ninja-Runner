package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l71 implements va {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ja1 f9486a;

    public l71(ja1 nativeAdValidator) {
        Intrinsics.checkNotNullParameter(nativeAdValidator, "nativeAdValidator");
        this.f9486a = nativeAdValidator;
    }

    @Override // com.yandex.mobile.ads.impl.va
    public final boolean a() {
        return this.f9486a.c();
    }

    @Override // com.yandex.mobile.ads.impl.va
    public final boolean b() {
        return !this.f9486a.b();
    }
}
