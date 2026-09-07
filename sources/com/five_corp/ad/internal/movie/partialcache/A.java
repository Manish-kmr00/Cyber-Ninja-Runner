package com.five_corp.ad.internal.movie.partialcache;

import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class A extends C0 {
    public short f;
    public int g;

    @Override // com.five_corp.ad.internal.movie.partialcache.C0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        cVar.b();
        cVar.b();
        this.f = cVar.d();
        if (cVar.d() != 16) {
            HashMap map = h1.f1479a;
        }
        cVar.d();
        cVar.d();
        int iD = cVar.d();
        if (iD < 0) {
            iD += 65536;
        }
        this.g = iD;
        cVar.d();
    }
}
