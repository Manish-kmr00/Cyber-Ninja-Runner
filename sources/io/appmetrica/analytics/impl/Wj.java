package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;

/* JADX INFO: loaded from: classes7.dex */
public final class Wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SystemTimeProvider f11407a;
    public final long b;

    public Wj() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f11407a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
