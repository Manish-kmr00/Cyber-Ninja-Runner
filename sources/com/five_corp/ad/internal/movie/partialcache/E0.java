package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes13.dex */
public final class E0 extends AbstractC2997c0 {
    public int h;
    public int i;
    public int[] j;

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        this.h = cVar.b();
        int iB = cVar.b();
        this.i = iB;
        if (this.h == 0) {
            this.j = new int[iB];
            for (int i = 0; i < this.i; i++) {
                this.j[i] = cVar.b();
            }
        }
    }
}
