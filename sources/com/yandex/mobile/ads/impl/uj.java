package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class uj implements wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10390a;
    private final boolean b;

    public uj(o8 adResponse, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f10390a = z;
        this.b = z2;
    }

    @Override // com.yandex.mobile.ads.impl.wj
    public final boolean b() {
        return this.f10390a;
    }

    @Override // com.yandex.mobile.ads.impl.wj
    public final boolean a() {
        return this.b;
    }
}
