package com.five_corp.ad.internal.http.auxcache;

import com.five_corp.ad.internal.ad.s;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1385a;
    public final /* synthetic */ i b;

    public f(i iVar, j jVar) {
        this.b = iVar;
        this.f1385a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar;
        for (k kVar : this.f1385a.c) {
            if (kVar.e.isEmpty()) {
                i iVar = this.b;
                int i = kVar.f1390a.c;
                iVar.getClass();
                int iA = com.five_corp.ad.e.a(i);
                if (iA == 0) {
                    lVar = iVar.i;
                } else if (iA == 1) {
                    lVar = iVar.j;
                } else {
                    if (iA != 2) {
                        throw new RuntimeException("Unknown DownloadRequesterPriority: ".concat(com.five_corp.ad.internal.http.b.b(i)));
                    }
                    lVar = iVar.k;
                }
                lVar.b.addFirst(kVar);
            }
            s sVar = this.f1385a.f1389a;
            kVar.g.remove(sVar);
            kVar.e.addLast(sVar);
        }
        this.b.a(this.f1385a);
    }
}
