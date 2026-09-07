package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class ix1 implements hx1 {
    private final ls0 b;

    public ix1(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.b = localStorage;
    }

    @Override // com.yandex.mobile.ads.impl.hx1
    public final String a() {
        return this.b.d("ServerSideClientIP");
    }

    @Override // com.yandex.mobile.ads.impl.hx1
    public final void a(String str) {
        this.b.a("ServerSideClientIP", str);
    }
}
