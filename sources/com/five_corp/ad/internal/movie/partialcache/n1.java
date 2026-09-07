package com.five_corp.ad.internal.movie.partialcache;

import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public final class n1 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f1492a;

    public n1(s1 s1Var) {
        this.f1492a = s1Var;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        com.five_corp.ad.internal.util.g gVar;
        t1 t1Var = (t1) obj;
        s1 s1Var = this.f1492a;
        t1Var.c = new k1(s1Var.f1497a);
        t1Var.b = new com.five_corp.ad.internal.util.c();
        com.five_corp.ad.internal.cache.o oVar = s1Var.b;
        com.five_corp.ad.internal.context.l lVar = s1Var.c;
        com.five_corp.ad.internal.http.movcache.h hVar = s1Var.d;
        C3000e c3000e = new C3000e(oVar, lVar, s1Var, hVar);
        t1Var.f1498a = c3000e;
        if (oVar.d()) {
            com.five_corp.ad.internal.util.f fVarB = oVar.b();
            if (fVarB.f1560a) {
                Integer num = (Integer) fVarB.c;
                int iIntValue = num.intValue();
                if (iIntValue < 0) {
                    com.five_corp.ad.internal.p pVar = com.five_corp.ad.internal.p.t3;
                    Locale locale = Locale.US;
                    gVar = new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(pVar, "Ots: " + lVar.b.b + ", Requested offset: 0, Downloaded file size: " + num, null, null));
                } else {
                    synchronized (c3000e.f1477a) {
                        c3000e.g = true;
                        c3000e.h = 0;
                        c3000e.i = iIntValue;
                    }
                    s1Var.a(new o1());
                    gVar = new com.five_corp.ad.internal.util.g(true, null);
                }
            } else {
                gVar = new com.five_corp.ad.internal.util.g(false, fVarB.b);
            }
        } else {
            synchronized (c3000e.f1477a) {
                c3000e.h = 0;
            }
            hVar.f1404a.post(new com.five_corp.ad.internal.http.movcache.c(hVar, lVar, c3000e));
            gVar = new com.five_corp.ad.internal.util.g(true, null);
        }
        if (gVar.f1560a) {
            return;
        }
        com.five_corp.ad.internal.o oVar2 = gVar.b;
        if (t1Var.d == 3) {
            return;
        }
        t1Var.d = 3;
        s1Var.e.a(oVar2);
    }
}
