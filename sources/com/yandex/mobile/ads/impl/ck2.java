package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ck2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eb2 f8620a;
    private final gk2 b;

    public final ArrayList a(eb2 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        List<ru> wrapperAdCreatives = this.f8620a.e();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = wrapperAdCreatives.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((ru) it.next()).i());
        }
        List<ru> listE = videoAd.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        for (ru adCreative : listE) {
            this.b.getClass();
            Intrinsics.checkNotNullParameter(adCreative, "adCreative");
            Intrinsics.checkNotNullParameter(wrapperAdCreatives, "wrapperAdCreatives");
            List<ji0> listE2 = adCreative.e();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE2, 10));
            Iterator<T> it2 = listE2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((ji0) it2.next()).a());
            }
            Set mutableSet = CollectionsKt.toMutableSet(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it3 = wrapperAdCreatives.iterator();
            while (it3.hasNext()) {
                CollectionsKt.addAll(arrayList4, ((ru) it3.next()).e());
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : arrayList4) {
                if (mutableSet.add(((ji0) obj).a())) {
                    arrayList5.add(obj);
                }
            }
            arrayList2.add(new ru.a().b(adCreative.f()).b(adCreative.g()).a(adCreative.e()).c(arrayList).a(adCreative.b()).a(adCreative.h()).a(adCreative.d()).a(arrayList5).c(adCreative.i()).a());
        }
        return arrayList2;
    }

    public /* synthetic */ ck2(eb2 eb2Var) {
        this(eb2Var, new gk2());
    }

    public ck2(eb2 wrapperAd, gk2 iconsProvider) {
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(iconsProvider, "iconsProvider");
        this.f8620a = wrapperAd;
        this.b = iconsProvider;
    }
}
