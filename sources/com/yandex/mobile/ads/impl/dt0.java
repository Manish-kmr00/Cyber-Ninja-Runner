package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final et0 f8730a = new et0();
    private final r42 b = new r42();

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.b.getClass();
        if (r42.a()) {
            runnable.run();
        } else {
            this.f8730a.a(runnable);
        }
    }

    public final void a() {
        this.f8730a.a();
    }
}
