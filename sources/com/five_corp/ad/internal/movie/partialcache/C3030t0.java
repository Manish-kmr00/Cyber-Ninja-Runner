package com.five_corp.ad.internal.movie.partialcache;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3030t0 extends AbstractC2997c0 {
    public int h;
    public long i;

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        super.a(cVar, aVar);
        byte b = this.f;
        if (b == 1) {
            cVar.c();
            cVar.c();
            this.h = cVar.b();
            this.i = cVar.c();
        } else {
            if (b != 0) {
                throw new C3036w0("Invalid version " + ((int) this.f) + " for mvhd");
            }
            cVar.b();
            HashMap map = h1.f1479a;
            cVar.b();
            this.h = cVar.b();
            int iB = cVar.b();
            long j = iB;
            if (iB < 0) {
                j += 4294967296L;
            }
            this.i = j;
        }
        int iB2 = cVar.b();
        short sD = cVar.d();
        cVar.d();
        cVar.b();
        cVar.b();
        int[] iArr = new int[9];
        for (int i = 0; i < 9; i++) {
            iArr[i] = cVar.b();
        }
        cVar.a(new byte[24]);
        cVar.b();
        if (iB2 != 65536) {
            HashMap map2 = h1.f1479a;
        }
        if (sD != 256) {
            HashMap map3 = h1.f1479a;
        }
        if (Arrays.equals(iArr, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824})) {
            return;
        }
        HashMap map4 = h1.f1479a;
        Arrays.toString(iArr);
    }
}
