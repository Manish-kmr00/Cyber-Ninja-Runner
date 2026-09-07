package com.yandex.mobile.ads.impl;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qk0 f9934a;
    private boolean b;
    private boolean c;

    public pk0(qk0 impressionReporter) {
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        this.f9934a = impressionReporter;
    }

    public final void a() {
        this.b = false;
        this.c = false;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f9934a.a(hp1.b.x);
    }

    public final void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f9934a.a(hp1.b.y, MapsKt.mapOf(TuplesKt.to("failure_tracked", Boolean.FALSE)));
    }
}
