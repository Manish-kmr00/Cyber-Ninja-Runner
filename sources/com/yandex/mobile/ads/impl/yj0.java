package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class yj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj0 f10744a;
    private final tl b;

    public final boolean a(Drawable drawable, uj0 imageValue) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Bitmap bitmapB = this.f10744a.b(imageValue);
        if (bitmapB == null) {
            bitmapB = this.f10744a.a(imageValue);
        }
        if (drawable == null || bitmapB == null) {
            return false;
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return (drawable instanceof BitmapDrawable ? new ul() : new a40(new ft1(), new vl())).a(drawable, bitmapB);
    }

    public /* synthetic */ yj0(pj0 pj0Var) {
        this(pj0Var, new tl());
    }

    public yj0(pj0 imageProvider, tl bitmapComparatorFactory) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(bitmapComparatorFactory, "bitmapComparatorFactory");
        this.f10744a = imageProvider;
        this.b = bitmapComparatorFactory;
    }
}
