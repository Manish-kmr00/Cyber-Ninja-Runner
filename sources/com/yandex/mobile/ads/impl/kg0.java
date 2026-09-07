package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kg0 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<String> f9413a;

    public kg0(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9413a = adResponse;
    }

    @Override // com.yandex.mobile.ads.impl.q4
    public final String a() {
        return this.f9413a.d();
    }
}
