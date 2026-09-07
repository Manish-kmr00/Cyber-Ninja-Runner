package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z8 f8379a = z8.b;

    public final synchronized z8 a() {
        return this.f8379a;
    }

    public final synchronized void a(z8 z8Var) {
        Intrinsics.checkNotNullParameter(z8Var, "<set-?>");
        this.f8379a = z8Var;
    }
}
