package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ListConverter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.dl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4074dl implements ListConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4099el f11520a = new C4099el();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4233k6[] fromModel(List<C4124fl> list) {
        C4233k6[] c4233k6Arr = new C4233k6[list.size()];
        Iterator<C4124fl> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            c4233k6Arr[i] = this.f11520a.fromModel(it.next());
            i++;
        }
        return c4233k6Arr;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final List<C4124fl> a(C4233k6[] c4233k6Arr) {
        throw new UnsupportedOperationException();
    }
}
