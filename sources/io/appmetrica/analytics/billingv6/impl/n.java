package io.appmetrica.analytics.billingv6.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f10953a;
    public final /* synthetic */ k b;

    public n(p pVar, k kVar) {
        this.f10953a = pVar;
        this.b = kVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.f10953a.e.a(this.b);
    }
}
