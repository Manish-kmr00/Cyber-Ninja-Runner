package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;

/* JADX INFO: loaded from: classes4.dex */
public final class Gh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Revenue f11165a;
    public final /* synthetic */ Yh b;

    public Gh(Yh yh, Revenue revenue) {
        this.b = yh;
        this.f11165a = revenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportRevenue(this.f11165a);
    }
}
