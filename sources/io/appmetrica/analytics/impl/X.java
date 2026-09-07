package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: loaded from: classes10.dex */
public final class X implements ProtobufConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f11409a;
    public final C4407r6 b;

    public X() {
        this(new T(new Um()), new C4407r6());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4059d6 fromModel(W w) {
        C4059d6 c4059d6 = new C4059d6();
        c4059d6.f11510a = this.f11409a.fromModel(w.f11398a);
        String str = w.b;
        if (str != null) {
            c4059d6.b = str;
        }
        c4059d6.c = this.b.a(w.c);
        return c4059d6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public X(T t, C4407r6 c4407r6) {
        this.f11409a = t;
        this.b = c4407r6;
    }

    public final W a(C4059d6 c4059d6) {
        throw new UnsupportedOperationException();
    }
}
