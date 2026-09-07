package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Ik implements InterfaceC4161h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oi f11199a;

    public Ik() {
        this(new Oi());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C4469ti> fromModel(Hk hk) {
        A8 a8 = new A8();
        a8.f11056a = 1;
        a8.b = new C4609z8();
        C4469ti c4469tiFromModel = this.f11199a.fromModel(hk.f11180a);
        a8.b.f11872a = (C4534w8) c4469tiFromModel.f11783a;
        C4479u3 c4479u3 = new C4479u3(C4479u3.b(c4469tiFromModel));
        c4469tiFromModel.b.getBytesTruncated();
        return Collections.singletonList(new C4469ti(a8, c4479u3));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ik(Oi oi) {
        this.f11199a = oi;
    }

    public final Hk a(List<C4469ti> list) {
        throw new UnsupportedOperationException();
    }
}
