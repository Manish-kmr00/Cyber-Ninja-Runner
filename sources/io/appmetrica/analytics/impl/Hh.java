package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* JADX INFO: loaded from: classes4.dex */
public final class Hh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRevenue f11179a;
    public final /* synthetic */ Yh b;

    public Hh(Yh yh, AdRevenue adRevenue) {
        this.b = yh;
        this.f11179a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportAdRevenue(this.f11179a);
    }
}
