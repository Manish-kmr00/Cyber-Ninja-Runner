package com.five_corp.ad.internal.movie;

import android.os.SystemClock;
import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class u implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1511a;
    public final /* synthetic */ x b;

    public u(x xVar, long j) {
        this.b = xVar;
        this.f1511a = j;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        com.five_corp.ad.internal.movie.partialcache.video.d dVar;
        boolean z;
        com.five_corp.ad.internal.movie.partialcache.video.e eVar;
        C2994b c2994b = (C2994b) obj;
        x xVar = this.b;
        if (xVar.o != 9) {
            return;
        }
        xVar.a(this.f1511a + xVar.c);
        x xVar2 = this.b;
        long j = this.f1511a;
        com.five_corp.ad.internal.movie.partialcache.audio.d dVar2 = xVar2.j;
        boolean z2 = dVar2.c;
        if ((z2 && dVar2.d && j > dVar2.e) || ((z = (dVar = xVar2.l).e) && j > dVar.f)) {
            xVar2.o = 10;
            xVar2.h.a();
            xVar2.i.a(c2994b);
            xVar2.k.getClass();
            com.five_corp.ad.internal.movie.partialcache.video.c.a(c2994b);
            com.five_corp.ad.internal.view.B b = xVar2.e;
            b.e.post(new com.five_corp.ad.internal.view.y(b));
            xVar2.f1513a.post(new RunnableC2980b(xVar2));
            return;
        }
        if ((z2 && !dVar2.d && dVar2.e < j) || (!z && dVar.f < j)) {
            xVar2.o = 11;
            com.five_corp.ad.internal.ad.m mVar = xVar2.d;
            if (mVar != null && mVar.f1306a != null && xVar2.q == null) {
                xVar2.q = new Object();
                xVar2.p = xVar2.d.f1306a.longValue() + SystemClock.uptimeMillis();
                if (xVar2.q != null) {
                    if (SystemClock.uptimeMillis() > xVar2.p) {
                        xVar2.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.B0, null, null, null));
                    } else {
                        xVar2.n.postAtTime(new v(xVar2), xVar2.q, SystemClock.uptimeMillis() + 500);
                    }
                }
            }
            xVar2.h.a();
            xVar2.i.a(c2994b);
            xVar2.k.getClass();
            com.five_corp.ad.internal.movie.partialcache.video.c.a(c2994b);
            com.five_corp.ad.internal.view.B b2 = xVar2.e;
            b2.e.post(new com.five_corp.ad.internal.view.z(b2));
            xVar2.f1513a.post(new RunnableC2981c(xVar2));
            return;
        }
        c2994b.b = j;
        com.five_corp.ad.internal.movie.partialcache.audio.c cVar = xVar2.i;
        if (cVar.d != 1) {
            c2994b.d.a(j);
        }
        if (cVar.d == 6) {
            c2994b.c.a(j);
        }
        com.five_corp.ad.internal.movie.partialcache.video.c cVar2 = this.b.k;
        long j2 = this.f1511a;
        cVar2.getClass();
        com.five_corp.ad.internal.movie.partialcache.video.e eVar2 = c2994b.e;
        if (eVar2 == null) {
            return;
        }
        com.five_corp.ad.internal.movie.partialcache.video.d dVar3 = c2994b.f;
        boolean z3 = dVar3.e && j2 > dVar3.f;
        eVar2.a(j2);
        c2994b.f.a(j2);
        if (!z3 || (eVar = c2994b.e) == null) {
            return;
        }
        eVar.a();
        c2994b.e = null;
    }
}
