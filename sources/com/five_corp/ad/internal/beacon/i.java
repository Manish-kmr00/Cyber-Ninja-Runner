package com.five_corp.ad.internal.beacon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1326a;

    public i(com.five_corp.ad.internal.ad.a aVar, com.five_corp.ad.internal.logger.a aVar2, com.five_corp.ad.f fVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(aVar2, aVar.z.b, new f(fVar), aVar.b));
        arrayList.add(new d(aVar2, aVar.A.b, new g(fVar), aVar.b));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = aVar.B;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.five_corp.ad.internal.ad.beacon.a aVar3 = ((com.five_corp.ad.internal.ad.beacon.f) it.next()).b;
                if (aVar3 != null) {
                    hashSet2.add(aVar3);
                }
            }
        }
        List list = aVar.x;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.five_corp.ad.internal.ad.beacon.a aVar4 = ((com.five_corp.ad.internal.ad.beacon.d) it2.next()).c;
                if (aVar4 != null) {
                    hashSet2.add(aVar4);
                }
            }
        }
        hashSet.addAll(hashSet2);
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList.add(new d(aVar2, (com.five_corp.ad.internal.ad.beacon.a) it3.next(), new h(fVar), aVar.b));
        }
        this.f1326a = arrayList;
    }

    public final void a() {
        for (d dVar : this.f1326a) {
            if (!dVar.f) {
                com.five_corp.ad.internal.ad.beacon.a aVar = dVar.b;
                if (aVar.f1268a == 1 && dVar.e) {
                    if (aVar.b == 2) {
                        dVar.d = 0L;
                    }
                    dVar.e = false;
                }
            }
        }
    }
}
