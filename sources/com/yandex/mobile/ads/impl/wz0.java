package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class wz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10607a;

    public final ArrayList a(List networks) {
        com.monetization.ads.mediation.base.a aVar;
        mz0.c cVar;
        Intrinsics.checkNotNullParameter(networks, "networks");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(networks, 10));
        Iterator it = networks.iterator();
        while (it.hasNext()) {
            iz0 iz0Var = (iz0) it.next();
            List<iz0.b> listB = iz0Var.b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
            for (iz0.b bVar : listB) {
                try {
                    aVar = (com.monetization.ads.mediation.base.a) co1.a.a(bVar.a(), new Object[0]);
                } catch (Exception unused) {
                    aVar = null;
                }
                if (aVar == null) {
                    cVar = new mz0.c(bVar.b(), null, false);
                } else {
                    px0 px0Var = new px0(aVar);
                    if (this.f10607a == null) {
                        this.f10607a = px0Var.b().getNetworkSdkVersion();
                    }
                    cVar = new mz0.c(bVar.b(), px0Var.b().getCom.ironsource.bu.b java.lang.String(), true);
                }
                arrayList2.add(cVar);
            }
            String str = this.f10607a;
            this.f10607a = null;
            arrayList.add(new mz0(iz0Var.c(), str, arrayList2));
        }
        return arrayList;
    }
}
