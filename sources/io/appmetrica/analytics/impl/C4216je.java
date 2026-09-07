package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.je, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4216je implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ca f11618a;

    public C4216je() {
        this(new Ca(20480, 100, 1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(Map<String, String> map) {
        C4225jn c4225jnA = this.f11618a.a(map);
        C4409r8 c4409r8 = new C4409r8();
        c4409r8.b = ((E4) c4225jnA.b).b;
        Map map2 = (Map) c4225jnA.f11624a;
        if (map2 != null) {
            c4409r8.f11746a = new C4385q8[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                c4409r8.f11746a[i] = new C4385q8();
                c4409r8.f11746a[i].f11733a = StringUtils.getUTF8Bytes((String) entry.getKey());
                c4409r8.f11746a[i].b = StringUtils.getUTF8Bytes((String) entry.getValue());
                i++;
            }
        }
        InterfaceC4504v3 interfaceC4504v3 = c4225jnA.b;
        int i2 = ((E4) interfaceC4504v3).f11790a;
        return new C4469ti(c4409r8, interfaceC4504v3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4216je(Ca ca) {
        this.f11618a = ca;
    }

    public final Map<String, String> a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
