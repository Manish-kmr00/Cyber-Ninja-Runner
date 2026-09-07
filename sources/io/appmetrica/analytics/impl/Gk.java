package io.appmetrica.analytics.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Gk implements InterfaceC4161h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4416rf f11166a;
    public final Tf b;

    public Gk() {
        this(new C4416rf(), new Tf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final List<C4469ti> fromModel(Fk fk) {
        C4469ti c4469tiFromModel;
        A8 a8 = new A8();
        a8.f11056a = 3;
        a8.d = new C4584y8();
        C4469ti c4469tiFromModel2 = this.f11166a.fromModel(fk.f11145a);
        a8.d.f11856a = (C4459t8) c4469tiFromModel2.f11783a;
        C4293mg c4293mg = fk.b;
        if (c4293mg != null) {
            c4469tiFromModel = this.b.fromModel(c4293mg);
            a8.d.b = (C4509v8) c4469tiFromModel.f11783a;
        } else {
            c4469tiFromModel = null;
        }
        return Collections.singletonList(new C4469ti(a8, new C4479u3(C4479u3.b(c4469tiFromModel2, c4469tiFromModel))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Gk(C4416rf c4416rf, Tf tf) {
        this.f11166a = c4416rf;
        this.b = tf;
    }

    public final Fk a(List<C4469ti> list) {
        throw new UnsupportedOperationException();
    }
}
