package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class wj0 {
    public static boolean a(uj0 imageValue, Map images) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Intrinsics.checkNotNullParameter(images, "images");
        Bitmap bitmap = (Bitmap) images.get(imageValue.f());
        return (bitmap != null && bitmap.getWidth() > 1 && bitmap.getHeight() > 1) || !imageValue.b();
    }
}
