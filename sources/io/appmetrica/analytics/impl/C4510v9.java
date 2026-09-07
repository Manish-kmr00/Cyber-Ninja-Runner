package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.v9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4510v9 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4460t9 fromModel(C4485u9 c4485u9) {
        C4460t9 c4460t9 = new C4460t9();
        String str = c4485u9.f11796a;
        if (str != null) {
            c4460t9.f11778a = str.getBytes();
        }
        return c4460t9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4485u9 toModel(C4460t9 c4460t9) {
        return new C4485u9(new String(c4460t9.f11778a));
    }
}
