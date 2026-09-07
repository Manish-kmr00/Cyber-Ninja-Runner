package com.five_corp.ad.internal.movie.partialcache.audio;

import com.five_corp.ad.internal.movie.RunnableC2990l;
import com.five_corp.ad.internal.movie.n;
import com.five_corp.ad.internal.movie.partialcache.u1;
import com.five_corp.ad.internal.movie.x;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1466a;

    public b(c cVar) {
        this.f1466a = cVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        int iA = com.five_corp.ad.e.a(this.f1466a.d);
        if (iA != 3) {
            if (iA != 4) {
                return;
            }
            c cVar = this.f1466a;
            cVar.d = 6;
            cVar.c.h.c = false;
            return;
        }
        c cVar2 = this.f1466a;
        cVar2.d = 6;
        x xVar = cVar2.c;
        xVar.h.c = false;
        xVar.getClass();
        xVar.n.post(new RunnableC2990l(xVar, new n(xVar)));
    }
}
