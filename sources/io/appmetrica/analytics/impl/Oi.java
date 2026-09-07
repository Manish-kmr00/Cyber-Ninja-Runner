package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Oi implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4216je f11284a;
    public final F3 b;
    public final C4611za c;
    public final C4611za d;

    public Oi() {
        this(new C4216je(), new F3(), new C4611za(100), new C4611za(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(Si si) {
        C4469ti c4469tiFromModel;
        C4534w8 c4534w8 = new C4534w8();
        C4225jn c4225jnA = this.c.a(si.f11350a);
        c4534w8.f11829a = StringUtils.getUTF8Bytes((String) c4225jnA.f11624a);
        List<String> list = si.b;
        C4469ti c4469tiA = null;
        if (list != null) {
            c4469tiFromModel = this.b.fromModel(list);
            c4534w8.b = (C4260l8) c4469tiFromModel.f11783a;
        } else {
            c4469tiFromModel = null;
        }
        C4225jn c4225jnA2 = this.d.a(si.c);
        c4534w8.c = StringUtils.getUTF8Bytes((String) c4225jnA2.f11624a);
        Map<String, String> map = si.d;
        if (map != null) {
            c4469tiA = this.f11284a.fromModel(map);
            c4534w8.d = (C4409r8) c4469tiA.f11783a;
        }
        return new C4469ti(c4534w8, new C4479u3(C4479u3.b(c4225jnA, c4469tiFromModel, c4225jnA2, c4469tiA)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Oi(C4216je c4216je, F3 f3, C4611za c4611za, C4611za c4611za2) {
        this.f11284a = c4216je;
        this.b = f3;
        this.c = c4611za;
        this.d = c4611za2;
    }

    public final Si a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
