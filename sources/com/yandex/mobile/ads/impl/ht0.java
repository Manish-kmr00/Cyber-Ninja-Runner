package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ht0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r42 f9133a;
    private final Context b;
    private final AtomicBoolean c;

    public ht0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9133a = new r42();
        this.b = context.getApplicationContext();
        this.c = new AtomicBoolean();
    }

    public final void a() {
        if (pa.a(this.b)) {
            this.f9133a.getClass();
            if (r42.a() || this.c.getAndSet(true)) {
                return;
            }
            dp0.c("SDK API usage from a background thread detected. Please, use SDK API only from the main thread.", new Object[0]);
        }
    }
}
