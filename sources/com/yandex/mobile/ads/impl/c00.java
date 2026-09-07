package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class c00 implements cv0.b {
    @Override // com.yandex.mobile.ads.impl.cv0.b
    public final cv0 a(cv0.a aVar) throws IOException {
        int i = x82.f10629a;
        if (i < 23 || i < 31) {
            return new q32.a().a(aVar);
        }
        int iC = s01.c(aVar.c.m);
        at0.c("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + x82.d(iC));
        return new gh.a(iC).a(aVar);
    }
}
