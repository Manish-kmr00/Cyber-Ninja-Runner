package com.ogury.ad.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v3 implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f7420a = new Handler(Looper.getMainLooper());

    @Override // com.ogury.ad.internal.h8
    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f7420a.post(runnable);
    }
}
