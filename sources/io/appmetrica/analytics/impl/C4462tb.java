package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.SystemClock;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.tb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4462tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11779a;
    public final T2 b;
    public final RunnableC4487ub c;

    public C4462tb(Handler handler, T2 t2) {
        this.f11779a = handler;
        this.b = t2;
        this.c = new RunnableC4487ub(handler, t2);
    }

    public static void a(Handler handler, T2 t2, Runnable runnable) {
        handler.removeCallbacks(runnable, t2.b.b.getApiKey());
        handler.postAtTime(runnable, t2.b.b.getApiKey(), SystemClock.uptimeMillis() + ((long) (((Integer) WrapUtils.getOrDefault(t2.b.b.getSessionTimeout(), 10)).intValue() * 500)));
    }
}
