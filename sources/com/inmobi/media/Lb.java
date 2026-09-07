package com.inmobi.media;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Lb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3128a = LazyKt.lazy(Kb.f3118a);

    @JvmStatic
    public static final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ((Handler) f3128a.getValue()).postDelayed(runnable, j);
    }

    @JvmStatic
    public static final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ((Handler) f3128a.getValue()).post(runnable);
    }
}
