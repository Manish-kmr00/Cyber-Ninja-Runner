package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bt0 {
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r11 f8539a;
    private final j11 b;

    public bt0() {
        this(0);
    }

    public final lx a() {
        lx lxVar;
        synchronized (c) {
            lxVar = !h11.f9051a.a() ? null : new lx(this.f8539a.d(), this.b.d());
        }
        return lxVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ bt0(int i) {
        int i2 = r11.d;
        r11 r11VarA = r11.a.a();
        int i3 = j11.d;
        this(r11VarA, j11.a.a());
    }

    public bt0(r11 sdkLogsCollector, j11 networkLogsCollector) {
        Intrinsics.checkNotNullParameter(sdkLogsCollector, "sdkLogsCollector");
        Intrinsics.checkNotNullParameter(networkLogsCollector, "networkLogsCollector");
        this.f8539a = sdkLogsCollector;
        this.b = networkLogsCollector;
    }
}
