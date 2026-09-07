package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class x01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y01 f10611a;

    public x01(y01 mobileAdsExecutorProvider) {
        Intrinsics.checkNotNullParameter(mobileAdsExecutorProvider, "mobileAdsExecutorProvider");
        this.f10611a = mobileAdsExecutorProvider;
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f10611a.a().execute(runnable);
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f10611a.b().execute(runnable);
    }
}
