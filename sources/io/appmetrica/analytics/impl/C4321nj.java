package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4321nj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECommerceEvent f11688a;

    public C4321nj(ECommerceEvent eCommerceEvent) {
        this.f11688a = eCommerceEvent;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportECommerce(this.f11688a);
    }
}
