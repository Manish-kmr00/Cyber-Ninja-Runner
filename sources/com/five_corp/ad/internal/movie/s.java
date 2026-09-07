package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class s implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1509a;

    public s(x xVar) {
        this.f1509a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        int iA = com.five_corp.ad.e.a(this.f1509a.o);
        if (iA == 5 || iA == 6 || iA == 7 || iA == 8) {
            x xVar = this.f1509a;
            xVar.f1513a.post(new RunnableC2984f(xVar));
            x xVar2 = this.f1509a;
            xVar2.o = 5;
            xVar2.h.a();
            com.five_corp.ad.internal.view.B b = this.f1509a.e;
            b.e.post(new com.five_corp.ad.internal.view.x(b));
            this.f1509a.i.a(c2994b);
            this.f1509a.k.getClass();
            com.five_corp.ad.internal.movie.partialcache.video.c.a(c2994b);
            return;
        }
        if (iA != 10) {
            return;
        }
        x xVar3 = this.f1509a;
        xVar3.f1513a.post(new RunnableC2984f(xVar3));
        x xVar4 = this.f1509a;
        xVar4.o = 12;
        Object obj2 = xVar4.q;
        if (obj2 != null) {
            xVar4.n.removeCallbacksAndMessages(obj2);
            xVar4.q = null;
        }
    }
}
