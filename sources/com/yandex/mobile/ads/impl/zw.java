package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class zw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nz0 f10855a;
    private final vz0 b;
    private final tw c;
    private final sz0 d;

    public zw(nz0 networksValidator, vz0 networksMapper, tw alertsMapper, sz0 mediationNetworksStatusMapper) {
        Intrinsics.checkNotNullParameter(networksValidator, "networksValidator");
        Intrinsics.checkNotNullParameter(networksMapper, "networksMapper");
        Intrinsics.checkNotNullParameter(alertsMapper, "alertsMapper");
        Intrinsics.checkNotNullParameter(mediationNetworksStatusMapper, "mediationNetworksStatusMapper");
        this.f10855a = networksValidator;
        this.b = networksMapper;
        this.c = alertsMapper;
        this.d = mediationNetworksStatusMapper;
    }

    public final yw a(kx localData, ox oxVar) {
        List<nx> listEmptyList;
        List<ew> listEmptyList2;
        List listEmptyList3;
        sw.a aVar;
        Object next;
        ow.a bVar;
        Intrinsics.checkNotNullParameter(localData, "localData");
        if (oxVar == null || (listEmptyList = oxVar.f()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        uw uwVarA = localData.a();
        vx vxVarF = localData.f();
        dw dwVar = new dw(oxVar != null ? oxVar.g() : null, oxVar != null ? oxVar.e() : null, oxVar != null ? oxVar.d() : null);
        List<mz0> listE = localData.e();
        ArrayList arrayListA = this.b.a(listEmptyList);
        if (!arrayListA.isEmpty()) {
            listE = arrayListA;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        for (mz0 network : listE) {
            Iterator<T> it = listEmptyList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((nx) next).e(), network.c()));
            nx nxVar = (nx) next;
            this.f10855a.getClass();
            boolean zA = nz0.a(network);
            this.d.getClass();
            Intrinsics.checkNotNullParameter(network, "network");
            List<mz0.c> listB = network.b();
            if ((listB instanceof Collection) && listB.isEmpty()) {
                bVar = ow.a.C0753a.f9866a;
                break;
            }
            Iterator<T> it2 = listB.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bVar = ow.a.C0753a.f9866a;
                    break;
                }
                if (!((mz0.c) it2.next()).c()) {
                    List<mz0.c> listB2 = network.b();
                    if (!(listB2 instanceof Collection) || !listB2.isEmpty()) {
                        Iterator<T> it3 = listB2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                bVar = ow.a.c.f9868a;
                                break;
                            }
                            if (((mz0.c) it3.next()).c()) {
                                oz0 oz0Var = oz0.INVALID_MEDIATION_ADAPTER_VERSION;
                                bVar = new ow.a.b();
                                break;
                            }
                        }
                    } else {
                        bVar = ow.a.c.f9868a;
                        break;
                    }
                }
            }
            ow.a aVar2 = bVar;
            String strC = network.c();
            String strD = nxVar != null ? nxVar.d() : null;
            mz0.c cVar = (mz0.c) CollectionsKt.firstOrNull((List) network.b());
            String strB = cVar != null ? cVar.b() : null;
            String strC2 = nxVar != null ? nxVar.c() : null;
            String strD2 = network.d();
            List<mz0.c> listB3 = network.b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB3, 10));
            Iterator<T> it4 = listB3.iterator();
            while (it4.hasNext()) {
                arrayList2.add(((mz0.c) it4.next()).a());
            }
            arrayList.add(new ow(strC, strD, zA, strB, strC2, strD2, aVar2, arrayList2));
        }
        qw qwVar = new qw(arrayList);
        xw xwVarB = localData.b();
        ex exVarC = localData.c();
        if (oxVar == null || (listEmptyList2 = oxVar.b()) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        List<ew> list = listEmptyList2;
        tw twVar = this.c;
        List<rw> listC = oxVar != null ? oxVar.c() : null;
        twVar.getClass();
        if (listC != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : listC) {
                rw rwVar = (rw) obj;
                if (rwVar.b() != null || rwVar.a() != null) {
                    arrayList3.add(obj);
                }
            }
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                rw rwVar2 = (rw) it5.next();
                String strB2 = rwVar2.b();
                String strA = rwVar2.a();
                sw.a[] aVarArrValues = sw.a.values();
                int length = aVarArrValues.length;
                Iterator it6 = it5;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        aVar = null;
                        break;
                    }
                    aVar = aVarArrValues[i];
                    int i2 = length;
                    sw.a[] aVarArr = aVarArrValues;
                    if (Intrinsics.areEqual(rwVar2.c(), aVar.a())) {
                        break;
                    }
                    i++;
                    aVarArrValues = aVarArr;
                    length = i2;
                }
                if (aVar == null) {
                    aVar = sw.a.c;
                }
                arrayList4.add(new sw(strB2, strA, aVar));
                it5 = it6;
            }
            listEmptyList3 = arrayList4;
        } else {
            listEmptyList3 = CollectionsKt.emptyList();
        }
        return new yw(uwVarA, vxVarF, dwVar, qwVar, xwVarB, exVarC, list, listEmptyList3);
    }
}
