package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class jy0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b40 f9363a;
    private final sj0 b;
    private final Point c;

    public final LinkedHashSet a(List images) {
        Intrinsics.checkNotNullParameter(images, "images");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = images.iterator();
        while (it.hasNext()) {
            MediatedNativeAdImage mediatedNativeAdImage = (MediatedNativeAdImage) it.next();
            String url = mediatedNativeAdImage.getUrl();
            int width = mediatedNativeAdImage.getWidth();
            int height = mediatedNativeAdImage.getHeight();
            if (url.length() > 0) {
                this.b.getClass();
                if (width <= 0 || height <= 0) {
                    Point point = this.c;
                    linkedHashSet.add(new uj0(point.x, point.y, url, null, 120));
                }
            }
        }
        return linkedHashSet;
    }

    public final LinkedHashMap b(List nativeAdImages) {
        Intrinsics.checkNotNullParameter(nativeAdImages, "nativeAdImages");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = nativeAdImages.iterator();
        while (it.hasNext()) {
            MediatedNativeAdImage mediatedNativeAdImage = (MediatedNativeAdImage) it.next();
            Drawable drawable = mediatedNativeAdImage.getDrawable();
            String url = mediatedNativeAdImage.getUrl();
            if (drawable != null && url.length() > 0) {
                this.f9363a.getClass();
                Bitmap bitmapA = b40.a(drawable);
                if (bitmapA != null) {
                    linkedHashMap.put(url, bitmapA);
                }
            }
        }
        return linkedHashMap;
    }

    public /* synthetic */ jy0(Context context) {
        this(context, new b40(), new sj0());
    }

    public jy0(Context context, b40 drawableConverter, sj0 imageSizeValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(drawableConverter, "drawableConverter");
        Intrinsics.checkNotNullParameter(imageSizeValidator, "imageSizeValidator");
        this.f9363a = drawableConverter;
        this.b = imageSizeValidator;
        this.c = eh1.b(context);
    }
}
