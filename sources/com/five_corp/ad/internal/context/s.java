package com.five_corp.ad.internal.context;

import android.os.Handler;
import android.os.HandlerThread;
import com.five_corp.ad.internal.cache.x;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class s implements com.five_corp.ad.internal.hub.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.time.a f1369a;
    public final com.five_corp.ad.internal.tracking_data.b b;
    public final com.five_corp.ad.internal.hub.a c;
    public final long d;
    public final Handler e;
    public ArrayList f;
    public com.five_corp.ad.internal.media_config.a g;

    public s(com.five_corp.ad.internal.time.a aVar, com.five_corp.ad.internal.tracking_data.b bVar, com.five_corp.ad.internal.hub.a aVar2) {
        HandlerThread handlerThread = new HandlerThread("signal collector worker thread");
        handlerThread.start();
        this.f1369a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = 1000L;
        this.e = new Handler(handlerThread.getLooper());
        this.f = new ArrayList();
        this.g = null;
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f) {
            long j = pVar.b;
            this.f1369a.getClass();
            if (j < System.currentTimeMillis()) {
                pVar.d.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.J5, null, null, null));
            } else {
                arrayList.add(pVar);
            }
        }
        this.f = arrayList;
        if (arrayList.isEmpty()) {
            return;
        }
        this.e.postDelayed(new s$$ExternalSyntheticLambda2(this), this.d);
    }

    public final void b(i iVar, long j, q qVar, r rVar) {
        t tVar;
        com.five_corp.ad.internal.tracking_data.a aVarA = this.b.a();
        com.five_corp.ad.internal.media_config.a aVar = this.g;
        if (aVar == null) {
            tVar = null;
            break;
        }
        Iterator it = aVar.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                tVar = null;
                break;
            }
            com.five_corp.ad.internal.media_config.c cVar = (com.five_corp.ad.internal.media_config.c) it.next();
            if (cVar.f1425a.equals(iVar.b)) {
                tVar = new t(iVar, this.g, cVar, aVarA);
                break;
            }
        }
        if (tVar != null) {
            if (tVar.c.b) {
                qVar.a(tVar);
                return;
            } else {
                rVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Q5, null, null, null));
                return;
            }
        }
        if (this.f.isEmpty()) {
            this.e.postDelayed(new s$$ExternalSyntheticLambda2(this), this.d);
        }
        ArrayList arrayList = this.f;
        this.f1369a.getClass();
        arrayList.add(new p(iVar, System.currentTimeMillis() + j, qVar, rVar));
    }

    public final void b(x xVar) {
        t tVar;
        this.g = xVar.b;
        ArrayList arrayList = new ArrayList();
        for (p pVar : this.f) {
            i iVar = pVar.f1368a;
            com.five_corp.ad.internal.tracking_data.a aVarA = this.b.a();
            com.five_corp.ad.internal.media_config.a aVar = this.g;
            if (aVar == null) {
                tVar = null;
                break;
            }
            Iterator it = aVar.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    tVar = null;
                    break;
                }
                com.five_corp.ad.internal.media_config.c cVar = (com.five_corp.ad.internal.media_config.c) it.next();
                if (cVar.f1425a.equals(iVar.b)) {
                    tVar = new t(iVar, this.g, cVar, aVarA);
                    break;
                }
            }
            if (tVar != null && tVar.c.b) {
                pVar.c.a(tVar);
            } else {
                pVar.d.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Q5, null, null, null));
            }
        }
        this.f = arrayList;
    }

    public final void a(final i iVar, final long j, final q qVar, final r rVar) {
        this.e.post(new Runnable() { // from class: com.five_corp.ad.internal.context.s$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(iVar, j, qVar, rVar);
            }
        });
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(final x xVar) {
        this.e.post(new Runnable() { // from class: com.five_corp.ad.internal.context.s$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(xVar);
            }
        });
    }
}
