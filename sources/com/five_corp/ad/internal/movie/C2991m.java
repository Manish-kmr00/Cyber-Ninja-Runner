package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.C3002f;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C2991m implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1455a;

    public C2991m(x xVar) {
        this.f1455a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.f1455a;
        int i = xVar.o;
        if (i == 4) {
            xVar.k.getClass();
            com.five_corp.ad.internal.movie.partialcache.video.c.a(c2994b);
            x xVar2 = this.f1455a;
            xVar2.o = 5;
            com.five_corp.ad.internal.view.B b = xVar2.e;
            b.e.post(new com.five_corp.ad.internal.view.v(b));
            x xVar3 = this.f1455a;
            xVar3.f1513a.post(new RunnableC2979a(xVar3));
            return;
        }
        if (i == 7) {
            xVar.o = 8;
            com.five_corp.ad.internal.movie.partialcache.audio.c cVar = xVar.i;
            int iA = com.five_corp.ad.e.a(cVar.d);
            if (iA == 0) {
                cVar.d = 2;
                x xVar4 = cVar.c;
                xVar4.getClass();
                xVar4.n.post(new RunnableC2990l(xVar4, new n(xVar4)));
                return;
            }
            if (iA != 2) {
                if (iA != 6) {
                    return;
                }
                cVar.d = 8;
                x xVar5 = cVar.c;
                xVar5.getClass();
                xVar5.n.post(new RunnableC2990l(xVar5, new n(xVar5)));
                return;
            }
            cVar.d = 4;
            long jB = c2994b.d.b(c2994b.b);
            C3002f c3002f = cVar.c.h;
            c3002f.c = true;
            c3002f.d = jB;
            c3002f.e = 0L;
            c3002f.b = true;
            c2994b.c.a();
        }
    }
}
