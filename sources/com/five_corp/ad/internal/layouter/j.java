package com.five_corp.ad.internal.layouter;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.util.h f1420a = new com.five_corp.ad.internal.util.h();
    public h b;

    public j(h hVar) {
        this.b = hVar;
    }

    public final void a(h hVar) {
        if (this.b.equals(hVar)) {
            return;
        }
        this.b = hVar;
        com.five_corp.ad.internal.util.h hVar2 = this.f1420a;
        hVar2.getClass();
        ArrayList arrayList = new ArrayList();
        hVar2.a(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(hVar);
        }
    }
}
