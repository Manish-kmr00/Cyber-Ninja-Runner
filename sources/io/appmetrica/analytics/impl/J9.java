package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: loaded from: classes4.dex */
public final class J9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Tl fromModel(I9 i9) {
        Tl tl = new Tl();
        if (i9 != null) {
            tl.f11368a = i9.f11192a;
        }
        return tl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new I9(((Tl) obj).f11368a);
    }

    public final I9 a(Tl tl) {
        return new I9(tl.f11368a);
    }
}
