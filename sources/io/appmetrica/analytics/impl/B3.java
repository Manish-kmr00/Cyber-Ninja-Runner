package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceCartItem;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class B3 extends ECommerceEvent {
    public static final int d = 4;
    public static final int e = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11069a;
    public final E3 b;
    public final InterfaceC4161h8 c;

    public B3(int i, ECommerceCartItem eCommerceCartItem) {
        this(i, new E3(eCommerceCartItem), new C3());
    }

    public final InterfaceC4161h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        int i = this.f11069a;
        if (i != 4) {
            return i != 5 ? "unknown cart action info" : "remove cart item info";
        }
        return "add cart item info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC4566xf
    public final List<C4469ti> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "CartActionInfoEvent{eventType=" + this.f11069a + ", cartItem=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public B3(int i, E3 e3, InterfaceC4161h8 interfaceC4161h8) {
        this.f11069a = i;
        this.b = e3;
        this.c = interfaceC4161h8;
    }
}
