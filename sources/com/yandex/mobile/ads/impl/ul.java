package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ul implements sl<BitmapDrawable> {
    @Override // com.yandex.mobile.ads.impl.sl
    public final boolean a(Drawable drawable, Bitmap bitmap) {
        BitmapDrawable drawable2 = (BitmapDrawable) drawable;
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return Intrinsics.areEqual(bitmap, drawable2.getBitmap());
    }
}
