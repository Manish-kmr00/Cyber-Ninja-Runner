package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;

/* JADX INFO: loaded from: classes2.dex */
public final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Revenue f11288a;
    public final /* synthetic */ C4278m1 b;

    public P0(C4278m1 c4278m1, Revenue revenue) {
        this.b = c4278m1;
        this.f11288a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportRevenue(this.f11288a);
    }
}
