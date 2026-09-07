package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.r1;
import com.five_corp.ad.internal.movie.partialcache.s1;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class q implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1507a;

    public q(x xVar) {
        this.f1507a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.f1507a;
        xVar.getClass();
        try {
            c2994b.b = 0L;
            xVar.n.removeCallbacksAndMessages(null);
            xVar.o = 1;
            xVar.h.a();
            com.five_corp.ad.internal.movie.partialcache.audio.c cVar = xVar.i;
            switch (com.five_corp.ad.e.a(cVar.d)) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    c2994b.c.b();
                    c2994b.c = null;
                    cVar.d = 1;
                    break;
            }
            xVar.k.getClass();
            com.five_corp.ad.internal.movie.partialcache.video.e eVar = c2994b.e;
            if (eVar != null) {
                eVar.a();
                c2994b.e = null;
            }
            s1 s1Var = xVar.g;
            if (s1Var.g != null) {
                s1Var.b(new r1(s1Var));
            }
            xVar.j.a();
            xVar.l.a();
        } catch (Throwable th) {
            xVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.w0, null, th, null));
        }
        this.f1507a.prepare();
    }
}
