package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class wy1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10605a = new Object();
    private boolean b;

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        synchronized (this.f10605a) {
            if (this.b) {
                return;
            }
            this.b = true;
            Unit unit = Unit.INSTANCE;
            runnable.run();
        }
    }
}
