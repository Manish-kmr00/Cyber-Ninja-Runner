package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class F3 implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4586ya f11133a;

    public F3() {
        this(new C4586ya(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(List<String> list) {
        C4225jn c4225jnA = this.f11133a.a((List<Object>) list);
        C4260l8 c4260l8 = new C4260l8();
        c4260l8.f11647a = StringUtils.getUTF8Bytes((List<String>) c4225jnA.f11624a);
        InterfaceC4504v3 interfaceC4504v3 = c4225jnA.b;
        int i = ((E4) interfaceC4504v3).f11790a;
        return new C4469ti(c4260l8, interfaceC4504v3);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public F3(C4586ya c4586ya) {
        this.f11133a = c4586ya;
    }

    public final List<String> a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
