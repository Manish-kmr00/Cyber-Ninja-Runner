package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceReferrer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Fk extends ECommerceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4491uf f11145a;
    public final C4293mg b;
    public final InterfaceC4161h8 c;

    public Fk(ECommerceProduct eCommerceProduct, ECommerceReferrer eCommerceReferrer) {
        this(new C4491uf(eCommerceProduct), eCommerceReferrer == null ? null : new C4293mg(eCommerceReferrer), new Gk());
    }

    public final InterfaceC4161h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product details info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC4566xf
    public final List<C4469ti> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductDetailInfoEvent{product=" + this.f11145a + ", referrer=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Fk(C4491uf c4491uf, C4293mg c4293mg, InterfaceC4161h8 interfaceC4161h8) {
        this.f11145a = c4491uf;
        this.b = c4293mg;
        this.c = interfaceC4161h8;
    }
}
