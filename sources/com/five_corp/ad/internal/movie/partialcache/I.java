package com.five_corp.ad.internal.movie.partialcache;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes12.dex */
public final class I extends AbstractC2997c0 {
    @Override // com.five_corp.ad.internal.movie.partialcache.AbstractC2997c0, com.five_corp.ad.internal.movie.partialcache.B
    public final void a(com.five_corp.ad.internal.util.c cVar, com.five_corp.ad.internal.logger.a aVar) throws C3036w0 {
        super.a(cVar, aVar);
        cVar.d();
        byte[] bArr = new byte[(int) a(cVar)];
        cVar.a(bArr);
        try {
            new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new C3036w0("UnsupportedEncodingException for copyright notice", e);
        }
    }
}
