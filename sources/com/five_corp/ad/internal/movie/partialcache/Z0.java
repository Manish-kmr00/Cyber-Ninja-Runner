package com.five_corp.ad.internal.movie.partialcache;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class Z0 extends AbstractC2997c0 {
    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        super.a(cVar, aVar);
        byte b = this.f;
        if (b == 1) {
            cVar.c();
            cVar.c();
            cVar.b();
            cVar.b();
            cVar.c();
        } else {
            if (b != 0) {
                throw new C3036w0("Invalid version " + ((int) this.f) + " for tkhd");
            }
            cVar.b();
            HashMap map = h1.f1479a;
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
        }
        cVar.b();
        cVar.b();
        if (cVar.d() != 0) {
            HashMap map2 = h1.f1479a;
        }
        if (cVar.d() != 0) {
            HashMap map3 = h1.f1479a;
        }
        short sD = cVar.d();
        if (sD != 256 && sD != 0) {
            HashMap map4 = h1.f1479a;
        }
        cVar.d();
        int[] iArr = new int[9];
        for (int i = 0; i < 9; i++) {
            iArr[i] = cVar.b();
        }
        if (!Arrays.equals(iArr, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824})) {
            HashMap map5 = h1.f1479a;
            Arrays.toString(iArr);
        }
        cVar.b();
        cVar.b();
    }
}
