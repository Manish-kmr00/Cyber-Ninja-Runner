package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.r1;
import com.five_corp.ad.internal.movie.partialcache.s1;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C2989k implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.o f1453a;
    public final /* synthetic */ x b;

    public C2989k(x xVar, com.five_corp.ad.internal.o oVar) {
        this.b = xVar;
        this.f1453a = oVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.b;
        xVar.o = 13;
        xVar.h.a();
        com.five_corp.ad.internal.movie.partialcache.audio.c cVar = this.b.i;
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
        this.b.k.getClass();
        com.five_corp.ad.internal.movie.partialcache.video.e eVar = c2994b.e;
        if (eVar != null) {
            eVar.a();
            c2994b.e = null;
        }
        s1 s1Var = this.b.g;
        if (s1Var.g != null) {
            s1Var.b(new r1(s1Var));
        }
        this.b.j.a();
        this.b.l.a();
        this.b.f1513a.post(new RunnableC2988j(this));
    }
}
