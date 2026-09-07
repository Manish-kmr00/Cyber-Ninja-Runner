package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
public final class N3 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final R3 fromModel(M3 m3) {
        R3 r3 = new R3();
        r3.f11321a = a(m3.f11253a);
        int size = m3.b.size();
        O3[] o3Arr = new O3[size];
        for (int i = 0; i < size; i++) {
            o3Arr[i] = a((L3) m3.b.get(i));
        }
        r3.b = o3Arr;
        return r3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final M3 toModel(R3 r3) {
        O3 o3 = r3.f11321a;
        if (o3 == null) {
            o3 = new O3();
        }
        L3 l3A = a(o3);
        O3[] o3Arr = r3.b;
        ArrayList arrayList = new ArrayList(o3Arr.length);
        for (O3 o4 : o3Arr) {
            arrayList.add(a(o4));
        }
        return new M3(l3A, arrayList);
    }

    public static O3 a(L3 l3) {
        Q3 q3;
        O3 o3 = new O3();
        Map map = l3.f11236a;
        int i = 0;
        if (map != null) {
            q3 = new Q3();
            int size = map.size();
            P3[] p3Arr = new P3[size];
            for (int i2 = 0; i2 < size; i2++) {
                p3Arr[i2] = new P3();
            }
            q3.f11305a = p3Arr;
            int i3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                P3 p3 = q3.f11305a[i3];
                p3.f11290a = str;
                p3.b = str2;
                i3++;
            }
        } else {
            q3 = null;
        }
        o3.f11276a = q3;
        int iOrdinal = l3.b.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                i = 2;
                if (iOrdinal != 2) {
                    i = 3;
                    if (iOrdinal != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                i = 1;
            }
        }
        o3.b = i;
        return o3;
    }

    public static L3 a(O3 o3) {
        LinkedHashMap linkedHashMap;
        X7 x7;
        Q3 q3 = o3.f11276a;
        if (q3 != null) {
            P3[] p3Arr = q3.f11305a;
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(p3Arr.length), 16));
            for (P3 p3 : p3Arr) {
                Pair pair = TuplesKt.to(p3.f11290a, p3.b);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        int i = o3.b;
        if (i == 0) {
            x7 = X7.b;
        } else if (i == 1) {
            x7 = X7.c;
        } else if (i == 2) {
            x7 = X7.d;
        } else if (i != 3) {
            x7 = X7.b;
        } else {
            x7 = X7.e;
        }
        return new L3(linkedHashMap, x7);
    }
}
