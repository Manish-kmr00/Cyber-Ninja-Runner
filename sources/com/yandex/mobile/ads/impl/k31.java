package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes10.dex */
public final class k31 {
    public static double a(List imageValues) {
        Object next;
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(imageValues, 10));
        Iterator it = imageValues.iterator();
        while (true) {
            double dG = 0.0d;
            if (!it.hasNext()) {
                break;
            }
            uj0 uj0Var = (uj0) it.next();
            if (uj0Var.a() != 0) {
                dG = ((double) uj0Var.g()) / ((double) uj0Var.a());
            }
            arrayList.add(Double.valueOf(dG));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(MathKt.roundToInt(((Number) it2.next()).doubleValue() * ((double) 1000))));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it3 = arrayList2.iterator();
        while (true) {
            int iIntValue = 1;
            if (!it3.hasNext()) {
                break;
            }
            int iIntValue2 = ((Number) it3.next()).intValue();
            Integer numValueOf = Integer.valueOf(iIntValue2);
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(iIntValue2));
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            linkedHashMap.put(numValueOf, Integer.valueOf(iIntValue));
        }
        Iterator it4 = linkedHashMap.entrySet().iterator();
        if (it4.hasNext()) {
            next = it4.next();
            if (it4.hasNext()) {
                int iIntValue3 = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next2 = it4.next();
                    int iIntValue4 = ((Number) ((Map.Entry) next2).getValue()).intValue();
                    if (iIntValue3 < iIntValue4) {
                        next = next2;
                        iIntValue3 = iIntValue4;
                    }
                } while (it4.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        Integer num2 = entry != null ? (Integer) entry.getValue() : null;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            int iIntValue5 = ((Number) entry2.getValue()).intValue();
            if (num2 != null && iIntValue5 == num2.intValue()) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList3 = new ArrayList(linkedHashMap2.size());
        Iterator it5 = linkedHashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            arrayList3.add(Double.valueOf(((double) ((Number) ((Map.Entry) it5.next()).getKey()).intValue()) / ((double) 1000)));
        }
        List listSorted = CollectionsKt.sorted(arrayList3);
        int size = listSorted.size();
        int i = size / 2;
        if (arrayList3.isEmpty()) {
            return 0.0d;
        }
        int i2 = size % 2;
        if (i2 + ((((i2 ^ 2) & ((-i2) | i2)) >> 31) & 2) == 1) {
            return ((Number) listSorted.get(i)).doubleValue();
        }
        return (((Number) listSorted.get(i - 1)).doubleValue() + ((Number) listSorted.get(i)).doubleValue()) / ((double) 2);
    }
}
