package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class oo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f9843a;

    /* JADX WARN: Multi-variable type inference failed */
    public oo1(List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.f9843a = assets;
    }

    public final ArrayList a(c71 viewAdapter) {
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        List<ig<?>> list = this.f9843a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            jg<?> jgVarA = viewAdapter.a((ig) obj);
            if (jgVarA != null && jgVarA.b()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ig) it.next()).b());
        }
        return arrayList2;
    }
}
