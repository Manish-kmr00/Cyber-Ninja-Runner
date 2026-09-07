package com.five_corp.ad.internal.beacon;

import com.five_corp.ad.internal.B;
import com.five_corp.ad.internal.bgtask.k;
import com.five_corp.ad.internal.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.f f1325a;

    public h(com.five_corp.ad.f fVar) {
        this.f1325a = fVar;
    }

    @Override // com.five_corp.ad.internal.beacon.c
    public final void a(long j, com.five_corp.ad.internal.ad.beacon.a aVar) {
        com.five_corp.ad.internal.ad.beacon.f fVar;
        List<com.five_corp.ad.internal.ad.beacon.d> listEmptyList;
        com.five_corp.ad.f fVar2 = this.f1325a;
        w wVar = fVar2.o;
        double d = fVar2.t;
        ArrayList arrayList = wVar.g.b.B;
        if (arrayList == null) {
            fVar = null;
            break;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            fVar = (com.five_corp.ad.internal.ad.beacon.f) it.next();
        } while (!aVar.equals(fVar.b));
        if (fVar != null) {
            wVar.a(fVar.f1271a, j, d, aVar, null);
        }
        com.five_corp.ad.internal.ad.a aVar2 = wVar.g.b;
        if (aVar2.x == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (com.five_corp.ad.internal.ad.beacon.d dVar : aVar2.x) {
                if (aVar.equals(dVar.c)) {
                    arrayList2.add(dVar);
                }
            }
            listEmptyList = arrayList2;
        }
        for (com.five_corp.ad.internal.ad.beacon.d dVar2 : listEmptyList) {
            B b = wVar.c;
            b.d.a(new k(dVar2.b, b.b));
        }
    }
}
