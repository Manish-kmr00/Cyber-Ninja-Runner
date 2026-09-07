package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cz1 extends lj0 {
    private final ej0 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz1(bq1 queue, ed1.b imageCache, ej0 imageCacheKeyGenerator) {
        super(queue, imageCache);
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(imageCache, "imageCache");
        Intrinsics.checkNotNullParameter(imageCacheKeyGenerator, "imageCacheKeyGenerator");
        this.g = imageCacheKeyGenerator;
    }

    @Override // com.yandex.mobile.ads.impl.lj0
    public final String a(String url, int i, int i2, ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.g.getClass();
        return ej0.b(url, scaleType);
    }
}
