package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.In;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes8.dex */
public class ECommerceAmount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BigDecimal f11022a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(In.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.f11022a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.f11022a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(In.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.f11022a = bigDecimal;
        this.b = str;
    }
}
