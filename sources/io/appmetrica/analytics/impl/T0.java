package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;

/* JADX INFO: loaded from: classes3.dex */
public final class T0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredDeeplinkListener f11356a;
    public final /* synthetic */ C4278m1 b;

    public T0(C4278m1 c4278m1, DeferredDeeplinkListener deferredDeeplinkListener) {
        this.b = c4278m1;
        this.f11356a = deferredDeeplinkListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f11662a.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        c4352p0.f().a(this.f11356a);
    }
}
