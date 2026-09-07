package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class lb1 implements mf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lg2 f9498a;

    public lb1(yb1 videoViewProvider) {
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        this.f9498a = new lg2(videoViewProvider);
    }

    @Override // com.yandex.mobile.ads.impl.mf2
    public final boolean a() {
        return this.f9498a.a();
    }
}
