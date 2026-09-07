package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Ek implements InterfaceC4161h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Oi f11126a;
    public final C4416rf b;

    public Ek() {
        this(new Oi(), new C4416rf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C4469ti> fromModel(Dk dk) {
        A8 a8 = new A8();
        a8.f11056a = 2;
        a8.c = new C4559x8();
        C4469ti c4469tiFromModel = this.f11126a.fromModel(dk.b);
        a8.c.b = (C4534w8) c4469tiFromModel.f11783a;
        C4469ti c4469tiFromModel2 = this.b.fromModel(dk.f11110a);
        a8.c.f11842a = (C4459t8) c4469tiFromModel2.f11783a;
        return Collections.singletonList(new C4469ti(a8, new C4479u3(C4479u3.b(c4469tiFromModel, c4469tiFromModel2))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Ek(Oi oi, C4416rf c4416rf) {
        this.f11126a = oi;
        this.b = c4416rf;
    }

    public final Dk a(List<C4469ti> list) {
        throw new UnsupportedOperationException();
    }
}
