package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class Xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f11417a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet linkedHashSet = this.f11417a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Wc) it.next()).a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(Wc... wcArr) {
        CollectionsKt.addAll(this.f11417a, wcArr);
    }
}
