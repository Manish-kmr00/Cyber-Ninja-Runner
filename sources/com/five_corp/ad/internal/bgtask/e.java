package com.five_corp.ad.internal.bgtask;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1331a;
    public final com.five_corp.ad.internal.time.a b;
    public final HandlerThread c;
    public final Handler d;
    public Long e;

    public e(int i, a aVar, com.five_corp.ad.internal.time.a aVar2) {
        String str = e.class.getName() + ":" + i;
        this.f1331a = aVar;
        this.b = aVar2;
        HandlerThread handlerThread = new HandlerThread(str);
        this.c = handlerThread;
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
        this.e = null;
    }

    public static void a(e eVar, boolean z) {
        h hVar;
        if (z) {
            eVar.e = null;
        }
        while (true) {
            eVar.b.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar = eVar.f1331a;
            synchronized (aVar.f1327a) {
                if (aVar.b.isEmpty()) {
                    hVar = null;
                } else {
                    g gVar = null;
                    for (g gVar2 : aVar.b) {
                        if (gVar2.c <= jCurrentTimeMillis) {
                            if (gVar != null) {
                                if (l.a(gVar2.f1332a.f1334a) < l.a(gVar.f1332a.f1334a)) {
                                }
                            }
                            gVar = gVar2;
                        }
                    }
                    if (gVar != null) {
                        aVar.b.remove(gVar);
                    }
                    if (gVar != null) {
                        hVar = new h(gVar, 0L);
                    } else {
                        long jMin = ((g) aVar.b.get(0)).c;
                        Iterator it = aVar.b.iterator();
                        while (it.hasNext()) {
                            jMin = Math.min(jMin, ((g) it.next()).c);
                        }
                        hVar = new h(null, jMin);
                    }
                }
            }
            if (hVar == null) {
                eVar.c.getId();
                return;
            }
            g gVar3 = hVar.f1333a;
            if (gVar3 == null) {
                long j = hVar.b;
                eVar.c.getId();
                Long l = eVar.e;
                if (l != null && l.longValue() <= j) {
                    eVar.c.getId();
                    return;
                }
                eVar.c.getId();
                eVar.e = Long.valueOf(j);
                eVar.d.postDelayed(new d(eVar), Math.max(j - jCurrentTimeMillis, 0L));
                return;
            }
            eVar.c.getId();
            if (gVar3.a() == 2) {
                int i = gVar3.d;
                gVar3.c = jCurrentTimeMillis + (60000 << i);
                gVar3.d = i + 1;
                eVar.f1331a.a(gVar3);
            }
        }
    }
}
