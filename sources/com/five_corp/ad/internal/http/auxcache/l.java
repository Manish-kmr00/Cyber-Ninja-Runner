package com.five_corp.ad.internal.http.auxcache;

import com.five_corp.ad.internal.ad.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1391a;
    public final ArrayDeque b = new ArrayDeque();
    public HashSet c = new HashSet();

    public l(long j) {
        this.f1391a = j;
    }

    public final long a() {
        long j;
        int iMin = 10;
        if (this.c.isEmpty()) {
            j = this.f1391a;
        } else {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                iMin = Math.min(iMin, ((k) it.next()).i);
            }
            j = this.f1391a;
        }
        return j << iMin;
    }

    public final void b() {
        for (k kVar : this.c) {
            kVar.i++;
            Iterator it = kVar.f.iterator();
            while (it.hasNext()) {
                kVar.e.addLast((s) it.next());
            }
            kVar.f = new ArrayList();
            this.b.addLast(kVar);
        }
        this.c = new HashSet();
    }
}
