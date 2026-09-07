package com.five_corp.ad;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements com.five_corp.ad.internal.cache.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdNative.LoadImageCallback f1597a;

    public l(FiveAdNative.LoadImageCallback loadImageCallback) {
        this.f1597a = loadImageCallback;
    }

    @Override // com.five_corp.ad.internal.cache.e
    public final void a(com.five_corp.ad.internal.o oVar) {
        this.f1597a.onImageLoad(null);
    }

    @Override // com.five_corp.ad.internal.cache.e
    public final void a(Bitmap bitmap) {
        this.f1597a.onImageLoad(bitmap);
    }
}
