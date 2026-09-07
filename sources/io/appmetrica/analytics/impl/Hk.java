package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.ecommerce.ECommerceScreen;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Hk extends ECommerceEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Si f11180a;
    public final InterfaceC4161h8 b;

    public Hk(ECommerceScreen eCommerceScreen) {
        this(new Si(eCommerceScreen), new Ik());
    }

    public final InterfaceC4161h8 a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent
    public final String getPublicDescription() {
        return "shown screen info";
    }

    @Override // io.appmetrica.analytics.ecommerce.ECommerceEvent, io.appmetrica.analytics.impl.InterfaceC4566xf
    public final List<C4469ti> toProto() {
        return (List) this.b.fromModel(this);
    }

    public final String toString() {
        return "ShownScreenInfoEvent{screen=" + this.f11180a + ", converter=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public Hk(Si si, InterfaceC4161h8 interfaceC4161h8) {
        this.f11180a = si;
        this.b = interfaceC4161h8;
    }
}
