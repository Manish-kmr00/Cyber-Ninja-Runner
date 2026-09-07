package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class r02 {
    public static ArrayList a(List list, rr0 rr0Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(rr0Var));
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(a(((ig) it.next()).a()));
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private static List a(rr0 rr0Var) {
        List<x> listA;
        if (rr0Var != null && (listA = rr0Var.a()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (obj instanceof p02) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                List<s02> listC = ((p02) it.next()).c();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
                Iterator<T> it2 = listC.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((s02) it2.next()).c().a());
                }
                CollectionsKt.addAll(arrayList2, arrayList3);
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }
}
