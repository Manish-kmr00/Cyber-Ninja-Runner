package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4287ma implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC4092ee f11669a;

    public C4287ma() {
        this(new C4497ul());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ul fromModel(C4 c4) {
        Ul ul = new Ul();
        ul.b = c4.b;
        ul.f11382a = c4.f11083a;
        ul.c = c4.c;
        ul.d = c4.d;
        ul.e = c4.e;
        ul.f = this.f11669a.a(c4.f);
        return ul;
    }

    public C4287ma(C4497ul c4497ul) {
        this.f11669a = c4497ul;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4 toModel(Ul ul) {
        A4 a4 = new A4();
        a4.d = ul.d;
        a4.c = ul.c;
        a4.b = ul.b;
        a4.f11052a = ul.f11382a;
        a4.e = ul.e;
        a4.f = this.f11669a.a(ul.f);
        return new C4(a4);
    }
}
