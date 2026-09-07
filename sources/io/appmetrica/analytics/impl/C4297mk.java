package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4297mk implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4347ok fromModel(Map<String, byte[]> map) {
        C4347ok c4347ok = new C4347ok();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            C4372pk c4372pk = new C4372pk();
            c4372pk.f11726a = entry.getKey().getBytes(Charsets.UTF_8);
            c4372pk.b = entry.getValue();
            arrayList.add(c4372pk);
        }
        Object[] array = arrayList.toArray(new C4372pk[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        c4347ok.f11705a = (C4372pk[]) array;
        return c4347ok;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, byte[]> toModel(C4347ok c4347ok) {
        C4372pk[] c4372pkArr = c4347ok.f11705a;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(c4372pkArr.length), 16));
        for (C4372pk c4372pk : c4372pkArr) {
            Pair pair = TuplesKt.to(new String(c4372pk.f11726a, Charsets.UTF_8), c4372pk.b);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
