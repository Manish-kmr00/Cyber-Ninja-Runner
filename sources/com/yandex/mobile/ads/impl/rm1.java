package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rm1 implements k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y1 f10122a;

    public rm1(y1 adBlockCompleteListener) {
        Intrinsics.checkNotNullParameter(adBlockCompleteListener, "adBlockCompleteListener");
        this.f10122a = adBlockCompleteListener;
    }

    @Override // com.yandex.mobile.ads.impl.k3
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.k3
    public final void b() {
        this.f10122a.b();
    }
}
