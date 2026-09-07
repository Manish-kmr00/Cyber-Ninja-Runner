package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.uf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4491uf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11802a;
    public final String b;
    public final List c;
    public final Map d;
    public final C4317nf e;
    public final C4317nf f;
    public final List g;

    public C4491uf(ECommerceProduct eCommerceProduct) {
        this(eCommerceProduct.getSku(), eCommerceProduct.getName(), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getCategoriesPath()), CollectionUtils.mapCopyOfNullableMap(eCommerceProduct.getPayload()), eCommerceProduct.getActualPrice() == null ? null : new C4317nf(eCommerceProduct.getActualPrice()), eCommerceProduct.getOriginalPrice() == null ? null : new C4317nf(eCommerceProduct.getOriginalPrice()), CollectionUtils.arrayListCopyOfNullableCollection(eCommerceProduct.getPromocodes()));
    }

    public final String toString() {
        return "ProductWrapper{sku='" + this.f11802a + "', name='" + this.b + "', categoriesPath=" + this.c + ", payload=" + this.d + ", actualPrice=" + this.e + ", originalPrice=" + this.f + ", promocodes=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }

    public C4491uf(String str, String str2, List list, Map map, C4317nf c4317nf, C4317nf c4317nf2, List list2) {
        this.f11802a = str;
        this.b = str2;
        this.c = list;
        this.d = map;
        this.e = c4317nf;
        this.f = c4317nf2;
        this.g = list2;
    }
}
