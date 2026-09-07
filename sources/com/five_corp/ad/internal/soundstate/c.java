package com.five_corp.ad.internal.soundstate;

import com.five_corp.ad.internal.util.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class c {
    public a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1522a = new Object();
    public final h c = new h();

    public c(d dVar) {
        this.b = new a(1, 1, 1, dVar);
    }

    public final void a(boolean z) {
        a aVar;
        ArrayList arrayList;
        synchronized (this.f1522a) {
            a aVar2 = this.b;
            aVar = new a(aVar2.f1521a, z ? 2 : 3, aVar2.c, aVar2.d);
            this.b = aVar;
            h hVar = this.c;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.five_corp.ad.f) ((b) it.next())).b(aVar);
        }
    }

    public final a a() {
        a aVar;
        synchronized (this.f1522a) {
            aVar = this.b;
        }
        return aVar;
    }

    public final a a(com.five_corp.ad.f fVar) {
        a aVar;
        synchronized (this.f1522a) {
            this.c.f1561a.add(new WeakReference(fVar));
            aVar = this.b;
        }
        return aVar;
    }
}
