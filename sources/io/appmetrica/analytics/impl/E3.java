package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import java.math.BigDecimal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class E3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4491uf f11115a;
    public final BigDecimal b;
    public final C4317nf c;
    public final C4293mg d;

    public E3(ECommerceCartItem eCommerceCartItem) {
        this(new C4491uf(eCommerceCartItem.getProduct()), eCommerceCartItem.getQuantity(), new C4317nf(eCommerceCartItem.getRevenue()), eCommerceCartItem.getReferrer() == null ? null : new C4293mg(eCommerceCartItem.getReferrer()));
    }

    public final String toString() {
        return "CartItemWrapper{product=" + this.f11115a + ", quantity=" + this.b + ", revenue=" + this.c + ", referrer=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public E3(C4491uf c4491uf, BigDecimal bigDecimal, C4317nf c4317nf, C4293mg c4293mg) {
        this.f11115a = c4491uf;
        this.b = bigDecimal;
        this.c = c4317nf;
        this.d = c4293mg;
    }
}
