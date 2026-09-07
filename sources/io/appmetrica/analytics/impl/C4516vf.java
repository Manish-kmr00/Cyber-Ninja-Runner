package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4516vf implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4586ya f11817a;

    public C4516vf() {
        this(new C4586ya(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4469ti fromModel(List<String> list) {
        C4225jn c4225jnA = this.f11817a.a((List<Object>) list);
        List list2 = (List) c4225jnA.f11624a;
        C4484u8[] c4484u8Arr = new C4484u8[0];
        if (list2 != null) {
            c4484u8Arr = new C4484u8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C4484u8 c4484u8 = new C4484u8();
                c4484u8Arr[i] = c4484u8;
                c4484u8.f11795a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        c4225jnA.b.getBytesTruncated();
        return new C4469ti(c4484u8Arr, c4225jnA.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4516vf(C4586ya c4586ya) {
        this.f11817a = c4586ya;
    }

    public final List<String> a(C4469ti c4469ti) {
        throw new UnsupportedOperationException();
    }
}
