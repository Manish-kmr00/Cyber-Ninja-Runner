package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private xf2 f10732a = xf2.b;

    public final synchronized xf2 a() {
        return this.f10732a;
    }

    public final synchronized void a(xf2 xf2Var) {
        Intrinsics.checkNotNullParameter(xf2Var, "<set-?>");
        this.f10732a = xf2Var;
    }
}
