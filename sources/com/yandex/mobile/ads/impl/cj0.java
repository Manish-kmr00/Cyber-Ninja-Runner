package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sj0 f8615a;
    private final rj0 b;

    public final uj0 a(Map<String, Bitmap> imageValues, MediatedNativeAdImage mediatedNativeAdImage) {
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        if (mediatedNativeAdImage == null) {
            return null;
        }
        String url = mediatedNativeAdImage.getUrl();
        int width = mediatedNativeAdImage.getWidth();
        int height = mediatedNativeAdImage.getHeight();
        this.f8615a.getClass();
        if (width > 0 && height > 0) {
            return new uj0(width, height, url, this.b.a(width, height), 112);
        }
        Bitmap bitmap = imageValues.get(url);
        if (bitmap == null) {
            return null;
        }
        int width2 = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        return new uj0(width2, height2, url, this.b.a(width2, height2), 112);
    }

    public /* synthetic */ cj0(Context context, sj0 sj0Var) {
        this(context, sj0Var, new rj0(context));
    }

    public cj0(Context context, sj0 imageSizeValidator, rj0 imageSizeTypeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageSizeValidator, "imageSizeValidator");
        Intrinsics.checkNotNullParameter(imageSizeTypeProvider, "imageSizeTypeProvider");
        this.f8615a = imageSizeValidator;
        this.b = imageSizeTypeProvider;
    }
}
