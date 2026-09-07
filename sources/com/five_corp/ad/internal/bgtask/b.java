package com.five_corp.ad.internal.bgtask;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1328a;
    public final ArrayList b;

    public b(int i, com.five_corp.ad.internal.time.a aVar, com.five_corp.ad.internal.logger.a aVar2) {
        this.f1328a = new a(aVar2);
        this.b = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.b.add(new e(i2, this.f1328a, aVar));
        }
    }

    public final void a(m mVar) {
        a aVar = this.f1328a;
        aVar.getClass();
        aVar.a(new g(mVar, aVar.c));
        for (e eVar : this.b) {
            eVar.d.post(new c(eVar));
        }
    }

    public final void a() {
        a aVar = this.f1328a;
        synchronized (aVar.f1327a) {
            Iterator it = aVar.b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).c = 0L;
            }
        }
        for (e eVar : this.b) {
            eVar.d.post(new c(eVar));
        }
    }
}
