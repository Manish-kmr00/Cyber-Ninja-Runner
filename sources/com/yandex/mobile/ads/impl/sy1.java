package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class sy1 implements jz {
    private static final long b = TimeUnit.SECONDS.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10248a;

    public sy1(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10248a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.jz
    public final long a() {
        Long lK = this.f10248a.K();
        return lK != null ? lK.longValue() : b;
    }
}
