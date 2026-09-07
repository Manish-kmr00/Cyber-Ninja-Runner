package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;

/* JADX INFO: loaded from: classes13.dex */
public final class D3 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4416rf f11099a;
    public final D7 b;
    public final C4267lf c;
    public final Tf d;

    public D3() {
        this(new C4416rf(), new D7(), new C4267lf(), new Tf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(E3 e3) {
        C4469ti c4469tiA;
        C4235k8 c4235k8 = new C4235k8();
        C4469ti c4469tiA2 = this.f11099a.fromModel(e3.f11115a);
        c4235k8.f11633a = (C4459t8) c4469tiA2.f11783a;
        c4235k8.c = this.b.fromModel(e3.b);
        C4469ti c4469tiA3 = this.c.fromModel(e3.c);
        c4235k8.d = (C4434s8) c4469tiA3.f11783a;
        C4293mg c4293mg = e3.d;
        if (c4293mg != null) {
            c4469tiA = this.d.fromModel(c4293mg);
            c4235k8.b = (C4509v8) c4469tiA.f11783a;
        } else {
            c4469tiA = null;
        }
        return new C4469ti(c4235k8, new C4479u3(C4479u3.b(c4469tiA2, c4469tiA3, c4469tiA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public D3(C4416rf c4416rf, D7 d7, C4267lf c4267lf, Tf tf) {
        this.f11099a = c4416rf;
        this.b = d7;
        this.c = c4267lf;
        this.d = tf;
    }

    public final E3 a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
