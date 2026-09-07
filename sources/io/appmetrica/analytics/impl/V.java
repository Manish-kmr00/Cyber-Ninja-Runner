package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceAmount;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes10.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigDecimal f11385a;
    public final String b;

    public V(ECommerceAmount eCommerceAmount) {
        this(eCommerceAmount.getAmount(), eCommerceAmount.getUnit());
    }

    public final String toString() {
        return "AmountWrapper{amount=" + this.f11385a + ", unit='" + this.b + "'}";
    }

    public V(BigDecimal bigDecimal, String str) {
        this.f11385a = bigDecimal;
        this.b = str;
    }
}
