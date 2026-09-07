package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* JADX INFO: loaded from: classes5.dex */
public final class Jh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f11210a;
    public final /* synthetic */ Yh b;

    public Jh(Yh yh, ECommerceEvent eCommerceEvent) {
        this.b = yh;
        this.f11210a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportECommerce(this.f11210a);
    }
}
