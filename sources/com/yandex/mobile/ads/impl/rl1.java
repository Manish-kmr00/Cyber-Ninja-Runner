package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10119a;
    private final long b;

    public rl1(String trackingUrl, long j) {
        Intrinsics.checkNotNullParameter(trackingUrl, "trackingUrl");
        this.f10119a = trackingUrl;
        this.b = j;
    }

    public final String b() {
        return this.f10119a;
    }

    public final long a() {
        return this.b;
    }
}
