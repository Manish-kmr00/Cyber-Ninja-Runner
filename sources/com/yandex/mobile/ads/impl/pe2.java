package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pe2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qf2 f9921a;
    private final boolean b;
    private final boolean c;
    private final Double d;

    public pe2(qf2 qf2Var, boolean z, boolean z2, Double d) {
        this.f9921a = qf2Var;
        this.b = z;
        this.c = z2;
        this.d = d;
    }

    public final qf2 c() {
        return this.f9921a;
    }

    public final boolean d() {
        return this.b;
    }

    public final boolean b() {
        return this.c;
    }

    public final Double a() {
        return this.d;
    }

    public final boolean e() {
        return Intrinsics.areEqual(this.d, 0.0d) || this.d == null;
    }
}
