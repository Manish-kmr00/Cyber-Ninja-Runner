package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkParametersListener;

/* JADX INFO: loaded from: classes.dex */
public final class S0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkParametersListener f11340a;
    public final /* synthetic */ C4278m1 b;

    public S0(C4278m1 c4278m1, DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.b = c4278m1;
        this.f11340a = deferredDeeplinkParametersListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f11662a.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        c4352p0.f().a(this.f11340a);
    }
}
