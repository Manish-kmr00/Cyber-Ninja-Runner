package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n61 {
    public static Set a(m61 nativeAdPrivate) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        return a(nativeAdPrivate, null);
    }

    public static Set b(m61 nativeAdPrivate) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        return a(nativeAdPrivate, q20.b);
    }

    public static Set c(m61 nativeAdPrivate) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        return a(nativeAdPrivate, q20.c);
    }

    private static Set a(m61 m61Var, q20 q20Var) {
        List<y20> listC = m61Var.c();
        if (listC != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listC.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((y20) it.next()).a());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                p20 p20Var = (p20) obj;
                if (q20Var == null || p20Var.b() == q20Var) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((p20) it2.next()).a());
            }
            Set set = CollectionsKt.toSet(arrayList3);
            if (set != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }
}
