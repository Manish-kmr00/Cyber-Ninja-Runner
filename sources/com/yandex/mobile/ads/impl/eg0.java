package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class eg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zs f8795a;
    private final iw1 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ eg0(zs zsVar) {
        this(zsVar, iw1.a.a());
        int i = iw1.l;
    }

    public eg0(zs defaultHostAccessChecker, iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(defaultHostAccessChecker, "defaultHostAccessChecker");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f8795a = defaultHostAccessChecker;
        this.b = sdkSettings;
    }

    public final zs a() {
        this.b.getClass();
        iw1.c();
        return this.f8795a;
    }
}
