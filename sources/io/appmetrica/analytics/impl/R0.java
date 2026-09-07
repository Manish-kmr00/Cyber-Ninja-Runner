package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* JADX INFO: loaded from: classes.dex */
public final class R0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f11320a;
    public final /* synthetic */ C4278m1 b;

    public R0(C4278m1 c4278m1, ECommerceEvent eCommerceEvent) {
        this.b = c4278m1;
        this.f11320a = eCommerceEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportECommerce(this.f11320a);
    }
}
