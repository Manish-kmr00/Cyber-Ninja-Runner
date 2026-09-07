package com.five_corp.ad.internal.beacon;

import com.five_corp.ad.internal.cache.t;
import com.five_corp.ad.internal.cache.w;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.f f1323a;

    public f(com.five_corp.ad.f fVar) {
        this.f1323a = fVar;
    }

    @Override // com.five_corp.ad.internal.beacon.c
    public final void a(long j, com.five_corp.ad.internal.ad.beacon.a aVar) {
        int i;
        com.five_corp.ad.f fVar = this.f1323a;
        synchronized (fVar.m) {
            i = fVar.u;
        }
        if (i != 1) {
            fVar.a(0, new o(p.Y3, "CurrentState: ".concat(com.five_corp.ad.d.a(i)), null, null));
            return;
        }
        fVar.o.n(j, fVar.t);
        w wVar = fVar.b.j;
        com.five_corp.ad.internal.ad.a aVar2 = fVar.l.b;
        wVar.getClass();
        List listSingletonList = Collections.singletonList(aVar2.d);
        ArrayList arrayList = new ArrayList();
        wVar.f1354a.a(new t(wVar, arrayList, listSingletonList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            wVar.b.a(((com.five_corp.ad.internal.ad.a) it.next()).b + ".response.json");
        }
        fVar.b.r.a(3);
    }
}
