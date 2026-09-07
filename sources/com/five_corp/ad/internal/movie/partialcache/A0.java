package com.five_corp.ad.internal.movie.partialcache;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class A0 extends AbstractC2997c0 {
    public final ArrayList h = new ArrayList();

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iA = (int) a(cVar);
        for (int i = 0; i < iA; i++) {
            this.h.add(new C3040y0(this, h1.a(cVar.a())));
        }
    }
}
