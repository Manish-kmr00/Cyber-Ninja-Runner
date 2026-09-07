package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.z3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4604z3 implements ProtobufConverter {
    public final Rl a(C4554x3 c4554x3) {
        Rl rl = new Rl();
        rl.f11336a = c4554x3.f11839a;
        return rl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object fromModel(Object obj) {
        Rl rl = new Rl();
        rl.f11336a = ((C4554x3) obj).f11839a;
        return rl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new C4554x3(((Rl) obj).f11336a);
    }

    public final C4554x3 a(Rl rl) {
        return new C4554x3(rl.f11336a);
    }
}
