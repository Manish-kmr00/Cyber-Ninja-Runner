package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.lf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4267lf implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U f11652a;
    public final C4292mf b;

    public C4267lf() {
        this(new U(), new C4292mf(30));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(C4317nf c4317nf) {
        int bytesTruncated;
        C4434s8 c4434s8 = new C4434s8();
        C4469ti c4469tiFromModel = this.f11652a.fromModel(c4317nf.f11685a);
        c4434s8.f11761a = (C4186i8) c4469tiFromModel.f11783a;
        C4225jn c4225jnA = this.b.a(c4317nf.b);
        if (In.a((Collection) c4225jnA.f11624a)) {
            bytesTruncated = 0;
        } else {
            c4434s8.b = new C4186i8[((List) c4225jnA.f11624a).size()];
            bytesTruncated = 0;
            for (int i = 0; i < ((List) c4225jnA.f11624a).size(); i++) {
                C4469ti c4469tiFromModel2 = this.f11652a.fromModel((V) ((List) c4225jnA.f11624a).get(i));
                c4434s8.b[i] = (C4186i8) c4469tiFromModel2.f11783a;
                bytesTruncated += c4469tiFromModel2.b.getBytesTruncated();
            }
        }
        return new C4469ti(c4434s8, new C4479u3(C4479u3.b(c4469tiFromModel, c4225jnA, new C4479u3(bytesTruncated))));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4267lf(U u, C4292mf c4292mf) {
        this.f11652a = u;
        this.b = c4292mf;
    }

    public final C4317nf a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
