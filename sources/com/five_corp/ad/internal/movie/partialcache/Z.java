package com.five_corp.ad.internal.movie.partialcache;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class Z extends B {
    public final ArrayList f = new ArrayList();

    @Override // com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        cVar.b();
        cVar.b();
        long jA = a(cVar) / 4;
        for (long j = 0; j < jA; j++) {
            this.f.add(Integer.valueOf(cVar.b()));
        }
    }
}
