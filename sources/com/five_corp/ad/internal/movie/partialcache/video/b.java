package com.five_corp.ad.internal.movie.partialcache.video;

import com.five_corp.ad.internal.movie.C2991m;
import com.five_corp.ad.internal.movie.RunnableC2990l;
import com.five_corp.ad.internal.movie.partialcache.u1;
import com.five_corp.ad.internal.movie.x;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1501a;

    public b(c cVar) {
        this.f1501a = cVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        x xVar = this.f1501a.c;
        xVar.getClass();
        xVar.n.post(new RunnableC2990l(xVar, new C2991m(xVar)));
    }
}
