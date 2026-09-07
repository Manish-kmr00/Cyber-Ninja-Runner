package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.C3002f;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class t implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1510a;
    public final /* synthetic */ x b;

    public t(x xVar, boolean z) {
        this.b = xVar;
        this.f1510a = z;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.b;
        if (xVar.o != 13) {
            boolean z = c2994b.f1475a;
            boolean z2 = this.f1510a;
            if (z == z2) {
                return;
            }
            c2994b.f1475a = z2;
            if (z2) {
                com.five_corp.ad.internal.movie.partialcache.audio.c cVar = xVar.i;
                int iA = com.five_corp.ad.e.a(cVar.d);
                if (iA == 6) {
                    cVar.d = 3;
                    return;
                }
                if (iA != 7) {
                    return;
                }
                cVar.d = 5;
                long jB = c2994b.d.b(c2994b.b);
                C3002f c3002f = cVar.c.h;
                c3002f.c = true;
                c3002f.d = jB;
                c3002f.e = 0L;
                c3002f.b = true;
                c2994b.c.a();
                return;
            }
            com.five_corp.ad.internal.movie.partialcache.audio.c cVar2 = xVar.i;
            int iA2 = com.five_corp.ad.e.a(cVar2.d);
            if (iA2 == 2) {
                cVar2.d = 7;
                return;
            }
            if (iA2 == 3) {
                cVar2.d = 8;
                cVar2.c.h.c = false;
                c2994b.c.b();
                x xVar2 = cVar2.c;
                xVar2.getClass();
                xVar2.n.post(new RunnableC2990l(xVar2, new n(xVar2)));
                return;
            }
            if (iA2 == 4) {
                cVar2.d = 8;
                cVar2.c.h.c = false;
                c2994b.c.b();
            } else {
                if (iA2 != 5) {
                    return;
                }
                cVar2.d = 8;
                c2994b.c.b();
            }
        }
    }
}
