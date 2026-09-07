package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class C3 implements InterfaceC4161h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D3 f11082a;

    public C3() {
        this(new D3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C4469ti> fromModel(B3 b3) {
        A8 a8 = new A8();
        a8.e = new C4210j8();
        C4469ti c4469tiFromModel = this.f11082a.fromModel(b3.b);
        a8.e.f11614a = (C4235k8) c4469tiFromModel.f11783a;
        a8.f11056a = b3.f11069a;
        return Collections.singletonList(new C4469ti(a8, new C4479u3(C4479u3.b(c4469tiFromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C3(D3 d3) {
        this.f11082a = d3;
    }

    public final B3 a(List<C4469ti> list) {
        throw new UnsupportedOperationException();
    }
}
