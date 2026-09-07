package com.five_corp.ad.internal.movie.partialcache;

import java.util.HashMap;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3011j0 extends AbstractC2997c0 {
    public int h;

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        super.a(cVar, aVar);
        byte b = this.f;
        if (b == 1) {
            cVar.c();
            cVar.c();
            this.h = cVar.b();
            cVar.c();
        } else {
            if (b != 0) {
                throw new C3036w0("Invalid version " + ((int) this.f) + " for mdhd");
            }
            cVar.b();
            HashMap map = h1.f1479a;
            cVar.b();
            this.h = cVar.b();
            cVar.b();
        }
        cVar.b();
    }
}
