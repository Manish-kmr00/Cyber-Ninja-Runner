package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.rf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4416rf implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4216je f11750a;
    public final C4267lf b;
    public final F3 c;
    public final C4516vf d;
    public final C4611za e;
    public final C4611za f;

    public C4416rf() {
        this(new C4216je(), new C4267lf(), new F3(), new C4516vf(), new C4611za(100), new C4611za(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(C4491uf c4491uf) {
        C4469ti c4469tiFromModel;
        C4469ti c4469tiFromModel2;
        C4469ti c4469tiA;
        C4469ti c4469tiA2;
        C4459t8 c4459t8 = new C4459t8();
        C4225jn c4225jnA = this.e.a(c4491uf.f11802a);
        c4459t8.f11777a = StringUtils.getUTF8Bytes((String) c4225jnA.f11624a);
        C4225jn c4225jnA2 = this.f.a(c4491uf.b);
        c4459t8.b = StringUtils.getUTF8Bytes((String) c4225jnA2.f11624a);
        List<String> list = c4491uf.c;
        C4469ti c4469tiFromModel3 = null;
        if (list != null) {
            c4469tiFromModel = this.c.fromModel(list);
            c4459t8.c = (C4260l8) c4469tiFromModel.f11783a;
        } else {
            c4469tiFromModel = null;
        }
        Map<String, String> map = c4491uf.d;
        if (map != null) {
            c4469tiFromModel2 = this.f11750a.fromModel(map);
            c4459t8.d = (C4409r8) c4469tiFromModel2.f11783a;
        } else {
            c4469tiFromModel2 = null;
        }
        C4317nf c4317nf = c4491uf.e;
        if (c4317nf != null) {
            c4469tiA = this.b.fromModel(c4317nf);
            c4459t8.e = (C4434s8) c4469tiA.f11783a;
        } else {
            c4469tiA = null;
        }
        C4317nf c4317nf2 = c4491uf.f;
        if (c4317nf2 != null) {
            c4469tiA2 = this.b.fromModel(c4317nf2);
            c4459t8.f = (C4434s8) c4469tiA2.f11783a;
        } else {
            c4469tiA2 = null;
        }
        List<String> list2 = c4491uf.g;
        if (list2 != null) {
            c4469tiFromModel3 = this.d.fromModel(list2);
            c4459t8.g = (C4484u8[]) c4469tiFromModel3.f11783a;
        }
        return new C4469ti(c4459t8, new C4479u3(C4479u3.b(c4225jnA, c4225jnA2, c4469tiFromModel, c4469tiFromModel2, c4469tiA, c4469tiA2, c4469tiFromModel3)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4416rf(C4216je c4216je, C4267lf c4267lf, F3 f3, C4516vf c4516vf, C4611za c4611za, C4611za c4611za2) {
        this.f11750a = c4216je;
        this.b = c4267lf;
        this.c = f3;
        this.d = c4516vf;
        this.e = c4611za;
        this.f = c4611za2;
    }

    public final C4491uf a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
