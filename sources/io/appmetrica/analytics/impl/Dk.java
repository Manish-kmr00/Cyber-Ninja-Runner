package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceProduct;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class Dk extends ECommerceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4491uf f11110a;
    public final Si b;
    public final InterfaceC4161h8 c;

    public Dk(ECommerceProduct eCommerceProduct, ECommerceScreen eCommerceScreen) {
        this(new C4491uf(eCommerceProduct), new Si(eCommerceScreen), new Ek());
    }

    public final InterfaceC4161h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown product card info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC4566xf
    public final List<C4469ti> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "ShownProductCardInfoEvent{product=" + this.f11110a + ", screen=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public Dk(C4491uf c4491uf, Si si, InterfaceC4161h8 interfaceC4161h8) {
        this.f11110a = c4491uf;
        this.b = si;
        this.c = interfaceC4161h8;
    }
}
