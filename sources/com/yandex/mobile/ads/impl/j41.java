package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class j41 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj0 f9286a;
    private final x51 b;
    private final j61 c;
    private final u71 d;
    private final d81 e;

    public final ot a(c41 nativeAd) {
        rp.a aVarB;
        zt.a aVar;
        List<uj0> listA;
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        List<ig<?>> listB = nativeAd.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listB, 10)), 16));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            ig igVar = (ig) it.next();
            Pair pair = TuplesKt.to(igVar.b(), igVar.d());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Object obj = linkedHashMap.get("media");
        zt ztVar = null;
        ax0 ax0Var = obj instanceof ax0 ? (ax0) obj : null;
        Object obj2 = linkedHashMap.get("favicon");
        uj0 uj0Var = obj2 instanceof uj0 ? (uj0) obj2 : null;
        Object obj3 = linkedHashMap.get("icon");
        uj0 uj0Var2 = obj3 instanceof uj0 ? (uj0) obj3 : null;
        Object obj4 = linkedHashMap.get("close_button");
        rp rpVar = obj4 instanceof rp ? (rp) obj4 : null;
        Object obj5 = linkedHashMap.get("age");
        String str = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = linkedHashMap.get("body");
        String str2 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = linkedHashMap.get("call_to_action");
        String str3 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = linkedHashMap.get("domain");
        String str4 = obj8 instanceof String ? (String) obj8 : null;
        Object obj9 = linkedHashMap.get("price");
        String str5 = obj9 instanceof String ? (String) obj9 : null;
        Object obj10 = linkedHashMap.get("rating");
        String str6 = obj10 instanceof String ? (String) obj10 : null;
        Object obj11 = linkedHashMap.get("review_count");
        String str7 = obj11 instanceof String ? (String) obj11 : null;
        Object obj12 = linkedHashMap.get("sponsored");
        String str8 = obj12 instanceof String ? (String) obj12 : null;
        Object obj13 = linkedHashMap.get("title");
        String str9 = obj13 instanceof String ? (String) obj13 : null;
        Object obj14 = linkedHashMap.get("warning");
        String str10 = obj14 instanceof String ? (String) obj14 : null;
        boolean z = linkedHashMap.get("feedback") != null;
        uj0 uj0Var3 = (ax0Var == null || (listA = ax0Var.a()) == null) ? null : (uj0) CollectionsKt.firstOrNull((List) listA);
        x51 x51Var = this.b;
        pj0 imageProvider = this.f9286a;
        x51Var.getClass();
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        qt qtVar = uj0Var3 != null ? new qt(new w51(imageProvider, uj0Var3), uj0Var3.d(), uj0Var3.g(), uj0Var3.a()) : null;
        x51 x51Var2 = this.b;
        pj0 imageProvider2 = this.f9286a;
        x51Var2.getClass();
        Intrinsics.checkNotNullParameter(imageProvider2, "imageProvider");
        qt qtVar2 = uj0Var != null ? new qt(new w51(imageProvider2, uj0Var), uj0Var.d(), uj0Var.g(), uj0Var.a()) : null;
        x51 x51Var3 = this.b;
        pj0 imageProvider3 = this.f9286a;
        x51Var3.getClass();
        Intrinsics.checkNotNullParameter(imageProvider3, "imageProvider");
        qt qtVar3 = uj0Var2 != null ? new qt(new w51(imageProvider3, uj0Var2), uj0Var2.d(), uj0Var2.g(), uj0Var2.a()) : null;
        ut utVarA = this.c.a(ax0Var);
        this.e.getClass();
        if (rpVar != null && (aVarB = rpVar.b()) != null) {
            int iOrdinal = aVarB.ordinal();
            if (iOrdinal == 0) {
                aVar = zt.a.b;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                aVar = zt.a.c;
            }
            ztVar = new zt(aVar, rpVar.a());
        }
        this.d.getClass();
        return new ot(utVarA, qtVar2, qtVar3, qtVar, ztVar, str, str2, str3, str4, str5, u71.a(str6), str7, str8, str9, str10, z);
    }

    public /* synthetic */ j41(pj0 pj0Var) {
        this(pj0Var, new x51(), new j61(), new u71(), new d81());
    }

    public j41(pj0 imageProvider, x51 imageCreator, j61 mediaCreator, u71 assetRatingProvider, d81 closeButtonCreator) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageCreator, "imageCreator");
        Intrinsics.checkNotNullParameter(mediaCreator, "mediaCreator");
        Intrinsics.checkNotNullParameter(assetRatingProvider, "assetRatingProvider");
        Intrinsics.checkNotNullParameter(closeButtonCreator, "closeButtonCreator");
        this.f9286a = imageProvider;
        this.b = imageCreator;
        this.c = mediaCreator;
        this.d = assetRatingProvider;
        this.e = closeButtonCreator;
    }
}
