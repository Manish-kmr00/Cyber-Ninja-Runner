package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC4327o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4352p0 f11692a;

    public RunnableC4327o0(C4352p0 c4352p0) {
        this.f11692a = c4352p0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4455t4.i().c.a().executeDelayed(new RunnableC4328o1(this.f11692a.f11709a), TimeUnit.SECONDS.toMillis(5L));
    }
}
