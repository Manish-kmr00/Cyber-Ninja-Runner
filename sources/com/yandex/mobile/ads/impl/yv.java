package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10772a;

    public yv(iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f10772a = sdkSettings;
    }

    public final void a(boolean z) {
        this.f10772a.b(z);
    }

    public final ex a() {
        return new ex(this.f10772a.i());
    }
}
