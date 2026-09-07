package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z81 implements gj0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10798a;

    public z81(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10798a = Intrinsics.areEqual(adResponse.E(), y81.c.a()) || Intrinsics.areEqual(adResponse.E(), y81.d.a());
    }

    @Override // com.yandex.mobile.ads.impl.gj0.a
    public final boolean a() {
        return this.f10798a;
    }
}
