package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oy1 implements z1 {
    private static final long b = TimeUnit.SECONDS.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9874a;

    public oy1(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9874a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.z1
    public final long a() {
        Long lK = this.f9874a.K();
        return lK != null ? lK.longValue() : b;
    }

    @Override // com.yandex.mobile.ads.impl.z1
    public final long a(long j) {
        Long lK = this.f9874a.K();
        return lK != null ? Math.min(j, lK.longValue()) : j;
    }
}
