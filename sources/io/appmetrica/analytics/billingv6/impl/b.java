package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f10941a;
    public final /* synthetic */ p b;

    public b(d dVar, p pVar) {
        this.f10941a = dVar;
        this.b = pVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.f10941a.d.a(this.b);
    }
}
