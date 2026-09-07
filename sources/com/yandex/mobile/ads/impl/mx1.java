package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class mx1 implements lx1 {
    private final ls0 b;

    public mx1(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.b = localStorage;
    }

    @Override // com.yandex.mobile.ads.impl.lx1
    public final String a() {
        return this.b.d("SessionData");
    }

    @Override // com.yandex.mobile.ads.impl.lx1
    public final void a(String str) {
        this.b.a("SessionData", str);
    }
}
