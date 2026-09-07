package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3034v0 extends AbstractC2997c0 {
    public byte[] h;

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        int iB = cVar.b();
        this.h = new byte[iB];
        for (int i = 0; i < (iB + 1) / 2; i++) {
            int iA = h1.a(cVar.a());
            byte[] bArr = this.h;
            int i2 = i * 2;
            bArr[i2] = (byte) (iA >> 4);
            int i3 = i2 + 1;
            if (i3 < iB) {
                bArr[i3] = (byte) (iA & 15);
            }
        }
    }
}
