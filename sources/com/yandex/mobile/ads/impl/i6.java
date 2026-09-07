package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i6 implements ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g6 f9179a;
    private final int b;

    public i6(g6 adPod, int i) {
        Intrinsics.checkNotNullParameter(adPod, "adPod");
        this.f9179a = adPod;
        this.b = i;
    }

    @Override // com.yandex.mobile.ads.impl.ip
    public final boolean a() {
        return this.f9179a.a() <= this.b;
    }
}
