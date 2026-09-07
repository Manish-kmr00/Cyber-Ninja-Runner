package io.appmetrica.analytics.ecommerce;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public class ECommercePrice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ECommerceAmount f11025a;
    private List b;

    public ECommercePrice(ECommerceAmount eCommerceAmount) {
        this.f11025a = eCommerceAmount;
    }

    public ECommerceAmount getFiat() {
        return this.f11025a;
    }

    public List<ECommerceAmount> getInternalComponents() {
        return this.b;
    }

    public ECommercePrice setInternalComponents(List<ECommerceAmount> list) {
        this.b = list;
        return this;
    }

    public String toString() {
        return "ECommercePrice{fiat=" + this.f11025a + ", internalComponents=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
