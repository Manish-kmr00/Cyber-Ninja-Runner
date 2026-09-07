package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes12.dex */
public final class Y extends AbstractC2997c0 {
    public V h;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.five_corp.ad.internal.movie.partialcache.W] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.five_corp.ad.internal.movie.partialcache.V] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.five_corp.ad.internal.movie.partialcache.T] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.five_corp.ad.internal.movie.partialcache.U] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.five_corp.ad.internal.movie.partialcache.X] */
    public static V b(com.five_corp.ad.internal.util.c cVar) {
        int iA;
        ?? w;
        byte bA = cVar.a();
        int i = 0;
        int i2 = 0;
        do {
            iA = h1.a(cVar.a());
            i++;
            i2 = (i2 << 7) | (iA & 127);
            if (i >= 4) {
                break;
            }
        } while ((iA & 128) > 0);
        int i3 = cVar.h;
        if (bA == 3) {
            w = new W();
            cVar.d();
            int iA2 = h1.a(cVar.a());
            boolean z = ((iA2 >> 7) & 1) > 0;
            boolean z2 = ((iA2 >> 6) & 1) > 0;
            boolean z3 = ((iA2 >> 5) & 1) > 0;
            if (z) {
                cVar.d();
            }
            if (z2) {
                cVar.a(new byte[h1.a(cVar.a())]);
            }
            if (z3) {
                cVar.d();
            }
        } else if (bA == 4) {
            w = new T();
            cVar.a();
            cVar.a();
            com.five_corp.ad.internal.util.g gVarA = cVar.a(cVar.d);
            if (!gVarA.f1560a) {
                gVarA.b.b();
            }
            byte[] bArr = cVar.d;
            byte b = bArr[0];
            byte b2 = bArr[1];
            byte b3 = bArr[2];
            cVar.b();
            cVar.b();
        } else if (bA != 5) {
            w = new X();
            cVar.a(new byte[i2]);
        } else {
            w = new U();
            byte[] bArr2 = new byte[i2];
            w.b = bArr2;
            cVar.a(bArr2);
        }
        while (cVar.h < i3 + i2) {
            w.f1462a.add(b(cVar));
        }
        return w;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) {
        super.a(cVar, aVar);
        this.h = b(cVar);
    }
}
