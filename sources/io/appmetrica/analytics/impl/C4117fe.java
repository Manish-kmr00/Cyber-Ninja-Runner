package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceOrder;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4117fe extends ECommerceEvent {
    public static final int d = 6;
    public static final int e = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11550a;
    public final C4167he b;
    public final InterfaceC4161h8 c;

    public C4117fe(int i, ECommerceOrder eCommerceOrder) {
        this(i, new C4167he(eCommerceOrder), new C4142ge());
    }

    public final InterfaceC4161h8 a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "order info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC4566xf
    public final List<C4469ti> toProto() {
        return (List) this.c.fromModel(this);
    }

    public final String toString() {
        return "OrderInfoEvent{eventType=" + this.f11550a + ", order=" + this.b + ", converter=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public C4117fe(int i, C4167he c4167he, InterfaceC4161h8 interfaceC4161h8) {
        this.f11550a = i;
        this.b = c4167he;
        this.c = interfaceC4161h8;
    }
}
