package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* JADX INFO: loaded from: classes2.dex */
public final class Q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRevenue f11303a;
    public final /* synthetic */ C4278m1 b;

    public Q0(C4278m1 c4278m1, AdRevenue adRevenue) {
        this.b = c4278m1;
        this.f11303a = adRevenue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportAdRevenue(this.f11303a);
    }
}
