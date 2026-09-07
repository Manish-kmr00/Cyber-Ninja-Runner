package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class et0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8831a = new Handler(Looper.getMainLooper());

    public final void a() {
        this.f8831a.removeCallbacksAndMessages(null);
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f8831a.post(runnable);
    }

    public final void a(wt1.a runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f8831a.postDelayed(runnable, 50L);
    }
}
