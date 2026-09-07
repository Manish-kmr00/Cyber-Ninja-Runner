package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class T8 implements ProtobufConverter {
    public static A9 a(S8 s8) {
        A9 a9 = new A9();
        a9.d = new int[s8.b.size()];
        Iterator it = s8.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            a9.d[i] = ((Integer) it.next()).intValue();
            i++;
        }
        a9.c = s8.d;
        a9.b = s8.c;
        a9.f11057a = s8.f11346a;
        return a9;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((S8) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        A9 a9 = (A9) obj;
        return new S8(a9.f11057a, a9.b, a9.c, CollectionUtils.hashSetFromIntArray(a9.d));
    }
}
