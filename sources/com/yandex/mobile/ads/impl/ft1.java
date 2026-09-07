package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ft1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vl f8925a;

    public final Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            vl vlVar = this.f8925a;
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            vlVar.getClass();
            Intrinsics.checkNotNullParameter(config, "config");
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, config);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        } else {
            vl vlVar2 = this.f8925a;
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            vlVar2.getClass();
            Intrinsics.checkNotNullParameter(config2, "config");
            bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config2);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public /* synthetic */ ft1() {
        this(new vl());
    }

    public ft1(vl bitmapProvider) {
        Intrinsics.checkNotNullParameter(bitmapProvider, "bitmapProvider");
        this.f8925a = bitmapProvider;
    }
}
