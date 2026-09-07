package com.five_corp.ad.internal.cache;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1350a = new Object();
    public x b;
    public final com.five_corp.ad.internal.util.h c;
    public final com.five_corp.ad.internal.util.h d;
    public final com.five_corp.ad.internal.hub.a e;

    public s(x xVar, com.five_corp.ad.internal.hub.a aVar) {
        this.b = xVar;
        com.five_corp.ad.internal.util.h hVar = new com.five_corp.ad.internal.util.h();
        this.c = hVar;
        hVar.f1561a.add(new WeakReference(xVar));
        this.d = new com.five_corp.ad.internal.util.h();
        this.e = aVar;
    }

    public final ArrayList a() {
        ArrayList arrayList;
        synchronized (this.f1350a) {
            com.five_corp.ad.internal.util.h hVar = this.c;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        return arrayList;
    }

    public final x b() {
        x xVar;
        synchronized (this.f1350a) {
            xVar = this.b;
        }
        return xVar;
    }

    public final void a(r rVar) {
        x xVar;
        x xVarA;
        ArrayList arrayList;
        synchronized (this.f1350a) {
            xVar = this.b;
            xVarA = rVar.a(xVar);
            this.b = xVarA;
            this.c.f1561a.add(new WeakReference(xVarA));
            com.five_corp.ad.internal.util.h hVar = this.d;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        com.five_corp.ad.internal.media_config.a aVar = xVar.b;
        com.five_corp.ad.internal.media_config.a aVar2 = xVarA.b;
        if (aVar == aVar2 || aVar2 == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            Iterator it2 = this.e.f1409a.a().iterator();
            while (it2.hasNext()) {
                ((com.five_corp.ad.internal.hub.c) it2.next()).a(xVarA);
            }
            return;
        }
        it.next().getClass();
        throw new ClassCastException();
    }
}
