package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bh {
    public static Set a(List assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(assets, 10));
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            arrayList.add(((ig) it.next()).d());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            List<uj0> listListOf = obj instanceof uj0 ? CollectionsKt.listOf(obj) : obj instanceof ax0 ? ((ax0) obj).a() : null;
            if (listListOf != null) {
                arrayList2.add(listListOf);
            }
        }
        return CollectionsKt.toSet(CollectionsKt.flatten(arrayList2));
    }
}
