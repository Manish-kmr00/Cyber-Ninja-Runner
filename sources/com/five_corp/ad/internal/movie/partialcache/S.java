package com.five_corp.ad.internal.movie.partialcache;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class S extends AbstractC2997c0 {
    public final ArrayList h = new ArrayList();

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iB = cVar.b();
        for (int i = 0; i < iB; i++) {
            Q q = new Q();
            if (this.f == 1) {
                cVar.c();
                cVar.c();
            } else {
                cVar.b();
                HashMap map = h1.f1479a;
                cVar.b();
            }
            cVar.d();
            cVar.d();
            this.h.add(q);
        }
    }
}
