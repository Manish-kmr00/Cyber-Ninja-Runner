package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f9184a;

    /* JADX WARN: Multi-variable type inference failed */
    public i70(List<? extends ig<?>> assets) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        this.f9184a = assets;
    }

    public final ArrayList a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        List<ig<?>> list = this.f9184a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((ig) obj).f()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            jg<?> jgVarA = nativeAdViewAdapter.a((ig) obj2);
            if (jgVarA == null || !jgVarA.b()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ig) it.next()).b());
        }
        return arrayList3;
    }
}
