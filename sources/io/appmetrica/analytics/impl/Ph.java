package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* JADX INFO: loaded from: classes.dex */
public final class Ph implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRevenue f11297a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Yh c;

    public Ph(Yh yh, AdRevenue adRevenue, boolean z) {
        this.c = yh;
        this.f11297a = adRevenue;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).reportAdRevenue(this.f11297a, this.b);
    }
}
