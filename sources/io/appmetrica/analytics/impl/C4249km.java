package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.km, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4249km implements ProtobufConverter {
    public final Yl a(C4224jm c4224jm) {
        Yl yl = new Yl();
        yl.f11441a = c4224jm.f11623a;
        return yl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Yl yl = new Yl();
        yl.f11441a = ((C4224jm) obj).f11623a;
        return yl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C4224jm(((Yl) obj).f11441a);
    }

    public final C4224jm a(Yl yl) {
        return new C4224jm(yl.f11441a);
    }
}
