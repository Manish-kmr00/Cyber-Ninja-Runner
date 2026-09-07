package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4365pd implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4023bk f11721a = C4486ua.j().o();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Vl[] fromModel(Map<String, ? extends Object> map) {
        Vl vl;
        Map<String, C4066dd> mapC = this.f11721a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C4066dd c4066dd = mapC.get(key);
            if (c4066dd == null || value == null) {
                vl = null;
            } else {
                vl = new Vl();
                vl.f11395a = key;
                vl.b = (byte[]) c4066dd.c.fromModel(value);
            }
            if (vl != null) {
                arrayList.add(vl);
            }
        }
        Object[] array = arrayList.toArray(new Vl[0]);
        if (array != null) {
            return (Vl[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, Object> toModel(Vl[] vlArr) {
        Map<String, C4066dd> mapC = this.f11721a.c();
        ArrayList arrayList = new ArrayList();
        for (Vl vl : vlArr) {
            C4066dd c4066dd = mapC.get(vl.f11395a);
            Pair pair = c4066dd != null ? TuplesKt.to(vl.f11395a, c4066dd.c.toModel(vl.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
