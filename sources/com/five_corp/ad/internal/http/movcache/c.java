package com.five_corp.ad.internal.http.movcache;

import com.five_corp.ad.CreativeType;
import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.movie.partialcache.C3000e;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.context.l f1399a;
    public final /* synthetic */ C3000e b;
    public final /* synthetic */ h c;

    public c(h hVar, com.five_corp.ad.internal.context.l lVar, C3000e c3000e) {
        this.c = hVar;
        this.f1399a = lVar;
        this.b = c3000e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.five_corp.ad.internal.ad.a aVar = this.f1399a.b;
        if (aVar.f1266a != CreativeType.MOVIE) {
            return;
        }
        s sVar = aVar.k;
        com.five_corp.ad.internal.util.f fVarA = this.c.a(sVar, this.c.b.a(sVar), new k(this.f1399a, this.b));
        if (fVarA.f1560a && ((Boolean) fVarA.c).booleanValue()) {
            h.a(this.c);
        }
    }
}
