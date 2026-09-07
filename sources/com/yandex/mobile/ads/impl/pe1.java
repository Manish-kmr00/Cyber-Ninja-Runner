package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pe1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b9 f9920a;
    private final zv0 b;
    private final p3 c;

    public pe1(mn2 adSession, zv0 mediaEvents, p3 adEvents) {
        Intrinsics.checkNotNullParameter(adSession, "adSession");
        Intrinsics.checkNotNullParameter(mediaEvents, "mediaEvents");
        Intrinsics.checkNotNullParameter(adEvents, "adEvents");
        this.f9920a = adSession;
        this.b = mediaEvents;
        this.c = adEvents;
    }

    public final b9 b() {
        return this.f9920a;
    }

    public final zv0 c() {
        return this.b;
    }

    public final p3 a() {
        return this.c;
    }
}
