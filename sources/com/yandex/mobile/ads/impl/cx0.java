package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cx0 {
    public static Set a(c41 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        List<ig<?>> listB = nativeAd.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((ig) it.next()).d());
        }
        return CollectionsKt.toSet(CollectionsKt.filterIsInstance(arrayList, ax0.class));
    }
}
