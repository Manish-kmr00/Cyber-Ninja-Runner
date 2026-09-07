package com.five_corp.ad.internal.movie.partialcache;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class S0 extends AbstractC2997c0 {
    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iB = cVar.b();
        for (int i = 0; i < iB; i++) {
            Q0 q0 = new Q0();
            cVar.b();
            int iD = cVar.d();
            if (iD < 0) {
                iD += 65536;
            }
            if (iD > 0) {
                for (int i2 = 0; i2 < iD; i2++) {
                    R0 r0 = new R0();
                    if (this.f == 1) {
                        cVar.b();
                    } else {
                        cVar.d();
                        HashMap map = h1.f1479a;
                    }
                    cVar.a();
                    cVar.a();
                    cVar.b();
                    q0.f1461a.add(r0);
                }
            }
        }
    }
}
