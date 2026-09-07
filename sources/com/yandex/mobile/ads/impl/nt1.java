package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nt1 implements y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9755a;

    public nt1(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9755a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.y4
    public final w1 a() {
        return new pt1();
    }

    @Override // com.yandex.mobile.ads.impl.y4
    public final s8 b() {
        return new ot1(this.f9755a);
    }
}
