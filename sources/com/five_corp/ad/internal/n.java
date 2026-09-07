package com.five_corp.ad.internal;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.cache.w f1516a;

    public n(com.five_corp.ad.internal.cache.w wVar) {
        this.f1516a = wVar;
    }

    public final void a(com.five_corp.ad.internal.ad.s sVar) {
        com.five_corp.ad.internal.cache.w wVar = this.f1516a;
        com.five_corp.ad.internal.cache.x xVarB = wVar.f1354a.b();
        ArrayList arrayList = new ArrayList();
        for (com.five_corp.ad.internal.ad.a aVar : xVarB.f1355a.f1265a) {
            Iterator it = aVar.D.iterator();
            while (it.hasNext()) {
                if (((com.five_corp.ad.internal.ad.s) it.next()).equals(sVar)) {
                    arrayList.add(aVar.d);
                    break;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        wVar.f1354a.a(new com.five_corp.ad.internal.cache.t(wVar, arrayList2, arrayList));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            wVar.b.a(((com.five_corp.ad.internal.ad.a) it2.next()).b + ".response.json");
        }
    }
}
