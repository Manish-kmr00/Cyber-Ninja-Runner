package com.five_corp.ad.internal.movie.partialcache;

import com.google.common.base.Ascii;
import java.util.HashMap;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C3041z extends B {
    public int f;
    public int g;
    public int h;
    public byte[][] i;
    public byte[][] j;
    public int k;

    @Override // com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        cVar.a();
        HashMap map = h1.f1479a;
        this.f = h1.a(cVar.a());
        cVar.a();
        this.g = h1.a(cVar.a());
        cVar.a();
        int iA = cVar.a() & Ascii.US;
        this.h = iA;
        this.i = new byte[iA][];
        for (int i = 0; i < this.h; i++) {
            byte[] bArr = new byte[cVar.d()];
            this.i[i] = bArr;
            cVar.a(bArr);
        }
        int iA2 = cVar.a();
        this.k = iA2;
        this.j = new byte[iA2][];
        for (int i2 = 0; i2 < this.k; i2++) {
            byte[] bArr2 = new byte[cVar.d()];
            this.j[i2] = bArr2;
            cVar.a(bArr2);
        }
    }
}
