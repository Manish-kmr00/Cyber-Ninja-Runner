package com.five_corp.ad.internal.movie.partialcache;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2999d0 extends AbstractC2997c0 {
    public final byte[] h = new byte[4];

    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        super.a(cVar, aVar);
        if (this.f != 0) {
            throw new C3036w0("Invalid version " + ((int) this.f) + " for hdlr");
        }
        cVar.b();
        cVar.a(this.h);
        cVar.b();
        cVar.b();
        cVar.b();
        byte[] bArr = new byte[(int) a(cVar)];
        cVar.a(bArr);
        try {
            new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new C3036w0("UnsupportedEncodingException for handler name", e);
        }
    }
}
