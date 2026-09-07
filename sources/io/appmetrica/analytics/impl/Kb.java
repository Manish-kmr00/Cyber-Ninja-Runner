package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class Kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2 f11222a;
    public final C4229k2 b;
    public final ArrayList c;

    public Kb(Z2 z2, C4229k2 c4229k2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.f11222a = z2;
        arrayList.add(z2);
        this.b = c4229k2;
        arrayList.add(c4229k2);
    }

    public final synchronized void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((Vj) it.next()).onCreate();
        }
    }

    public final synchronized void a(C4461ta c4461ta) {
        this.c.add(c4461ta);
    }
}
