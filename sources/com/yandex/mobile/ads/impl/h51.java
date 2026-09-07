package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f9064a;

    public final List<String> a(c41 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        bh bhVar = this.f9064a;
        List<ig<?>> listB = nativeAd.b();
        bhVar.getClass();
        Set setA = bh.a(listB);
        ArrayList arrayList = new ArrayList();
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            String strD = ((uj0) it.next()).d();
            if (strD != null) {
                arrayList.add(strD);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.toList(arrayList2);
    }

    public /* synthetic */ h51() {
        this(new bh());
    }

    public h51(bh assetsImagesProvider) {
        Intrinsics.checkNotNullParameter(assetsImagesProvider, "assetsImagesProvider");
        this.f9064a = assetsImagesProvider;
    }
}
