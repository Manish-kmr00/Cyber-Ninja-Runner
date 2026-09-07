package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes12.dex */
public final class O extends AbstractC2997c0 {
    public short[] h;

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iA = (int) (a(cVar) / 2);
        this.h = new short[iA];
        for (int i = 0; i < iA; i++) {
            this.h[i] = cVar.d();
        }
    }
}
