package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4150gm implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Xl fromModel(C4125fm c4125fm) {
        Xl xl = new Xl();
        xl.f11423a = c4125fm.f11557a;
        return xl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C4125fm(((Xl) obj).f11423a);
    }

    public final C4125fm a(Xl xl) {
        return new C4125fm(xl.f11423a);
    }
}
