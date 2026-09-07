package com.five_corp.ad.internal.movie.partialcache;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class D extends AbstractC2997c0 {
    public final ArrayList h = new ArrayList();

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iB = cVar.b();
        for (int i = 0; i < iB; i++) {
            this.h.add(Integer.valueOf(cVar.b()));
        }
    }
}
