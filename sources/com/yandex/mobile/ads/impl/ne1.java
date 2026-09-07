package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ne1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f9725a;

    public ne1(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f9725a = localStorage;
    }

    public final String a() {
        return this.f9725a.d("YmadOmSdkJs");
    }

    public final String b() {
        return this.f9725a.d("YmadOmSdkJsUrl");
    }

    public final void a(String str) {
        this.f9725a.a("YmadOmSdkJs", str);
    }

    public final void b(String str) {
        this.f9725a.a("YmadOmSdkJsUrl", str);
    }
}
