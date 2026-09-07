package io.appmetrica.analytics.ecommerce;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public class ECommerceOrder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11024a;
    private final List b;
    private Map c;

    public ECommerceOrder(String str, List<ECommerceCartItem> list) {
        this.f11024a = str;
        this.b = list;
    }

    public List<ECommerceCartItem> getCartItems() {
        return this.b;
    }

    public String getIdentifier() {
        return this.f11024a;
    }

    public Map<String, String> getPayload() {
        return this.c;
    }

    public ECommerceOrder setPayload(Map<String, String> map) {
        this.c = map;
        return this;
    }

    public String toString() {
        return "ECommerceOrder{identifier='" + this.f11024a + "', cartItems=" + this.b + ", payload=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
