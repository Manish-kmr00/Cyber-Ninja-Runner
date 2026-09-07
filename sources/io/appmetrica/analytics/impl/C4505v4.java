package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.v4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4505v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SystemTimeProvider f11810a;

    public C4505v4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f11810a.elapsedRealtime();
    }

    public C4505v4(SystemTimeProvider systemTimeProvider) {
        this.f11810a = systemTimeProvider;
    }
}
