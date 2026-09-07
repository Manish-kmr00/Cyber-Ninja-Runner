package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4099el implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4233k6 fromModel(C4124fl c4124fl) {
        C4233k6 c4233k6 = new C4233k6();
        c4233k6.f11631a = (String) WrapUtils.getOrDefault(c4124fl.f11556a, c4233k6.f11631a);
        c4233k6.b = (String) WrapUtils.getOrDefault(c4124fl.b, c4233k6.b);
        c4233k6.c = ((Integer) WrapUtils.getOrDefault(c4124fl.c, Integer.valueOf(c4233k6.c))).intValue();
        c4233k6.f = ((Integer) WrapUtils.getOrDefault(c4124fl.d, Integer.valueOf(c4233k6.f))).intValue();
        c4233k6.d = (String) WrapUtils.getOrDefault(c4124fl.e, c4233k6.d);
        c4233k6.e = ((Boolean) WrapUtils.getOrDefault(c4124fl.f, Boolean.valueOf(c4233k6.e))).booleanValue();
        return c4233k6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final C4124fl a(C4233k6 c4233k6) {
        throw new UnsupportedOperationException();
    }
}
