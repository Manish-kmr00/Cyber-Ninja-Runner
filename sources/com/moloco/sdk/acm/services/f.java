package com.moloco.sdk.acm.services;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f6055a;
    public final AtomicLong b;

    public f(g timeProviderService) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f6055a = timeProviderService;
        this.b = new AtomicLong(0L);
    }

    public final long a() {
        return this.f6055a.invoke() - this.b.get();
    }

    public final AtomicLong b() {
        return this.b;
    }

    public final void c() {
        this.b.set(this.f6055a.invoke());
    }
}
