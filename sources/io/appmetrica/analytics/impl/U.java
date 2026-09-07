package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class U implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D7 f11371a;
    public final C4611za b;

    public U() {
        this(new D7(), new C4611za(20));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(V v) {
        C4186i8 c4186i8 = new C4186i8();
        c4186i8.b = this.f11371a.fromModel(v.f11385a);
        C4225jn c4225jnA = this.b.a(v.b);
        c4186i8.f11598a = StringUtils.getUTF8Bytes((String) c4225jnA.f11624a);
        return new C4469ti(c4186i8, new C4479u3(C4479u3.b(c4225jnA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public U(D7 d7, C4611za c4611za) {
        this.f11371a = d7;
        this.b = c4611za;
    }

    public final V a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
