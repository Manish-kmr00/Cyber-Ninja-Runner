package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Tf implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oi f11365a;
    public final C4611za b;
    public final C4611za c;

    public Tf() {
        this(new Oi(), new C4611za(100), new C4611za(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(C4293mg c4293mg) {
        C4469ti c4469tiFromModel;
        C4509v8 c4509v8 = new C4509v8();
        C4225jn c4225jnA = this.b.a(c4293mg.f11673a);
        c4509v8.f11813a = StringUtils.getUTF8Bytes((String) c4225jnA.f11624a);
        C4225jn c4225jnA2 = this.c.a(c4293mg.b);
        c4509v8.b = StringUtils.getUTF8Bytes((String) c4225jnA2.f11624a);
        Si si = c4293mg.c;
        if (si != null) {
            c4469tiFromModel = this.f11365a.fromModel(si);
            c4509v8.c = (C4534w8) c4469tiFromModel.f11783a;
        } else {
            c4469tiFromModel = null;
        }
        return new C4469ti(c4509v8, new C4479u3(C4479u3.b(c4225jnA, c4225jnA2, c4469tiFromModel)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Tf(Oi oi, C4611za c4611za, C4611za c4611za2) {
        this.f11365a = oi;
        this.b = c4611za;
        this.c = c4611za2;
    }

    public final C4293mg a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
