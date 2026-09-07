package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class tx0 implements y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10336a;
    private final mx0<?> b;

    public tx0(o8<?> adResponse, mx0<?> mx0Var) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10336a = adResponse;
        this.b = mx0Var;
    }

    @Override // com.yandex.mobile.ads.impl.y4
    public final w1 a() {
        return new ay0(this.b, new zx0());
    }

    @Override // com.yandex.mobile.ads.impl.y4
    public final s8 b() {
        return new xx0(this.f10336a);
    }
}
