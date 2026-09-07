package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.he, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4167he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11585a;
    public final String b;
    public final List c;
    public final Map d;

    public C4167he(ECommerceOrder eCommerceOrder) {
        this(UUID.randomUUID().toString(), eCommerceOrder.getIdentifier(), a(eCommerceOrder.getCartItems()), CollectionUtils.mapCopyOfNullableMap(eCommerceOrder.getPayload()));
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new E3((ECommerceCartItem) it.next()));
        }
        return arrayList;
    }

    public final String toString() {
        return "OrderWrapper{uuid='" + this.f11585a + "', identifier='" + this.b + "', cartItems=" + this.c + ", payload=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C4167he(String str, String str2, ArrayList arrayList, Map map) {
        this.f11585a = str;
        this.b = str2;
        this.c = arrayList;
        this.d = map;
    }
}
