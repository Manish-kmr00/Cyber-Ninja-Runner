package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h82 implements ed1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, Bitmap> f9073a;
    private final ej0 b;

    public h82(fd1 bitmapLruCache, ej0 imageCacheKeyGenerator) {
        Intrinsics.checkNotNullParameter(bitmapLruCache, "bitmapLruCache");
        Intrinsics.checkNotNullParameter(imageCacheKeyGenerator, "imageCacheKeyGenerator");
        this.f9073a = bitmapLruCache;
        this.b = imageCacheKeyGenerator;
    }

    public final Bitmap a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.getClass();
        return this.f9073a.get(ej0.a(url));
    }

    @Override // com.yandex.mobile.ads.impl.ed1.c
    public final void a(String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.b.getClass();
        this.f9073a.put(ej0.a(url), bitmap);
    }
}
