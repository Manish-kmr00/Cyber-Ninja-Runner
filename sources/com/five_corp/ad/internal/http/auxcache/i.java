package com.five_corp.ad.internal.http.auxcache;

import android.os.Handler;
import android.os.HandlerThread;
import com.five_corp.ad.CreativeType;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1388a;
    public final com.five_corp.ad.internal.logger.a b;
    public final com.five_corp.ad.internal.storage.d c;
    public final com.five_corp.ad.internal.http.connection.b d;
    public final int e;
    public Object f;
    public boolean g;
    public final ArrayList h;
    public final l i;
    public final l j;
    public final l k;

    public i(com.five_corp.ad.internal.logger.a aVar, com.five_corp.ad.internal.storage.d dVar, com.five_corp.ad.internal.http.connection.b bVar) {
        HandlerThread handlerThread = new HandlerThread("AuxiliaryResourceCacheDownloadManager");
        handlerThread.start();
        this.f1388a = new Handler(handlerThread.getLooper());
        this.b = aVar;
        this.c = dVar;
        this.d = bVar;
        this.e = 3;
        this.f = null;
        this.g = false;
        this.h = new ArrayList();
        this.i = new l(30000L);
        this.j = new l(3000L);
        this.k = new l(500L);
    }

    public static k a(i iVar, com.five_corp.ad.internal.http.a aVar) {
        iVar.getClass();
        com.five_corp.ad.internal.context.l lVar = (com.five_corp.ad.internal.context.l) aVar.b.get();
        com.five_corp.ad.internal.ad.a aVar2 = lVar != null ? lVar.b : (com.five_corp.ad.internal.ad.a) aVar.f1379a.get();
        if (aVar2 != null) {
            ArrayList arrayList = new ArrayList();
            for (s sVar : aVar2.D) {
                if (!sVar.equals(aVar2.k) || aVar2.f1266a != CreativeType.MOVIE) {
                    arrayList.add(sVar);
                }
            }
            if (!arrayList.isEmpty()) {
                return new k(aVar2.b, aVar, iVar.c, arrayList, iVar.b);
            }
        }
        return null;
    }

    public static void a(i iVar) {
        iVar.f = null;
        if (iVar.g && !iVar.k.b.isEmpty()) {
            for (j jVar : iVar.h) {
                Iterator it = jVar.c.iterator();
                do {
                    if (!it.hasNext()) {
                        synchronized (jVar.f) {
                            if (!jVar.k) {
                                com.five_corp.ad.internal.http.client.a aVar = jVar.g;
                                jVar.k = true;
                                if (aVar == null) {
                                    break;
                                }
                                aVar.a();
                                break;
                            }
                            break;
                        }
                    }
                } while (((k) it.next()).f1390a.c != 3);
            }
            return;
        }
        if (iVar.g) {
            return;
        }
        iVar.g = true;
        iVar.i.b();
        iVar.j.b();
        iVar.k.b();
        iVar.a((j) null);
    }

    public final void a(j jVar) {
        l lVar;
        s sVar;
        o oVar;
        if (jVar != null) {
            this.h.remove(jVar);
        }
        while (this.h.size() < this.e) {
            if (!this.k.b.isEmpty()) {
                lVar = this.k;
            } else if (this.j.b.isEmpty()) {
                lVar = !this.i.b.isEmpty() ? this.i : null;
            } else {
                lVar = this.j;
            }
            if (lVar == null) {
                if (this.h.size() == 0) {
                    this.g = false;
                    if (!this.k.c.isEmpty()) {
                        long jA = this.k.a();
                        Object obj = new Object();
                        this.f = obj;
                        this.f1388a.postDelayed(new h(this, obj), jA);
                        return;
                    }
                    if (!this.j.c.isEmpty()) {
                        long jA2 = this.j.a();
                        Object obj2 = new Object();
                        this.f = obj2;
                        this.f1388a.postDelayed(new h(this, obj2), jA2);
                        return;
                    }
                    if (this.i.c.isEmpty()) {
                        return;
                    }
                    long jA3 = this.i.a();
                    Object obj3 = new Object();
                    this.f = obj3;
                    this.f1388a.postDelayed(new h(this, obj3), jA3);
                    return;
                }
                return;
            }
            k kVar = (k) lVar.b.peekFirst();
            if (!kVar.f1390a.a()) {
                sVar = null;
                break;
            }
            while (true) {
                if (kVar.e.isEmpty()) {
                    sVar = null;
                    break;
                }
                sVar = (s) kVar.e.pollFirst();
                if (!kVar.d.a(sVar).d()) {
                    kVar.g.add(sVar);
                    break;
                }
            }
            if (sVar != null) {
                Iterator it = this.h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        j jVar2 = (j) it.next();
                        if (jVar2.f1389a.equals(sVar)) {
                            jVar2.c.add(kVar);
                            break;
                        }
                    } else {
                        com.five_corp.ad.internal.cache.o oVarA = this.c.a(sVar);
                        j jVar3 = new j(sVar, oVarA, kVar, this.d, this);
                        synchronized (jVar3.f) {
                            oVar = jVar3.g != null ? new o(p.J2, null, null, null) : null;
                        }
                        if (oVar != null) {
                            jVar3.e(oVar);
                        } else {
                            com.five_corp.ad.internal.util.f fVarB = oVarA.b();
                            if (!fVarB.f1560a) {
                                jVar3.e(fVarB.b);
                            } else {
                                int iIntValue = ((Integer) fVarB.c).intValue();
                                com.five_corp.ad.internal.http.client.a aVar = new com.five_corp.ad.internal.http.client.a(sVar, jVar3, jVar3.d);
                                synchronized (jVar3.f) {
                                    jVar3.g = aVar;
                                    jVar3.i = iIntValue;
                                }
                                aVar.b(iIntValue, 0);
                            }
                        }
                        this.h.add(jVar3);
                        break;
                    }
                }
            } else {
                lVar.b.pollFirst();
            }
        }
    }
}
