package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ne, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4316ne implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Wl fromModel(C4291me c4291me) {
        Wl wl = new Wl();
        wl.f11408a = c4291me.f11672a;
        wl.b = c4291me.b;
        return wl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Wl wl = (Wl) obj;
        return new C4291me(wl.f11408a, wl.b);
    }

    public final C4291me a(Wl wl) {
        return new C4291me(wl.f11408a, wl.b);
    }
}
