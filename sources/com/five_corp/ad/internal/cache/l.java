package com.five_corp.ad.internal.cache;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1346a;

    public l(o oVar) {
        this.f1346a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        com.five_corp.ad.internal.storage.o oVar;
        synchronized (this.f1346a.f1347a) {
            o oVar2 = this.f1346a;
            arrayList = oVar2.g;
            oVar2.g = new ArrayList();
            WeakReference weakReference = this.f1346a.i;
            oVar = weakReference != null ? (com.five_corp.ad.internal.storage.o) weakReference.get() : null;
        }
        if (oVar != null) {
            oVar.a();
        }
        com.five_corp.ad.internal.storage.a aVar = this.f1346a.c;
        aVar.f1525a.a(aVar.b);
        com.five_corp.ad.internal.storage.a aVar2 = this.f1346a.d;
        aVar2.f1525a.a(aVar2.b);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.V5, null, null, null));
        }
    }
}
