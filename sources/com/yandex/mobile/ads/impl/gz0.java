package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nz0 f9046a;
    private final wz0 b;

    public /* synthetic */ gz0() {
        this(new nz0(), new wz0());
    }

    public gz0(nz0 mediationNetworkValidator, wz0 mediationNetworksDataProvider) {
        Intrinsics.checkNotNullParameter(mediationNetworkValidator, "mediationNetworkValidator");
        Intrinsics.checkNotNullParameter(mediationNetworksDataProvider, "mediationNetworksDataProvider");
        this.f9046a = mediationNetworkValidator;
        this.b = mediationNetworksDataProvider;
    }

    public final Map<String, Object> a(boolean z) {
        String str;
        if (z) {
            str = "ads-mediation";
        } else {
            str = "single";
        }
        int i = iz0.d;
        ArrayList arrayListA = this.b.a(iz0.a.a());
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListA) {
            this.f9046a.getClass();
            if (nz0.a((mz0) obj)) {
                arrayList.add(obj);
            }
        }
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("integration_type", str);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(MapsKt.mapOf(TuplesKt.to("name", ((mz0) it.next()).c())));
        }
        pairArr[1] = TuplesKt.to("networks", arrayList2);
        return MapsKt.mapOf(pairArr);
    }
}
