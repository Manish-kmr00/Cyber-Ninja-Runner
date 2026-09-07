package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xk1 f9733a;
    private final yk1 b;
    private final xl c;

    public final Bitmap a(uj0 imageValue) {
        Object objM7904constructorimpl;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        String strC = imageValue.c();
        if (strC == null) {
            return null;
        }
        this.f9733a.getClass();
        Bitmap bitmapA = xk1.a(strC);
        if (bitmapA != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(this.b.a(bitmapA, imageValue));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            bitmap = (Bitmap) objM7904constructorimpl;
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        this.c.getClass();
        return xl.a(bitmap, 1.0d);
    }

    public /* synthetic */ nj0() {
        this(new xk1(), new yk1(), new xl());
    }

    public nj0(xk1 previewBitmapCreator, yk1 previewBitmapScaler, xl blurredBitmapProvider) {
        Intrinsics.checkNotNullParameter(previewBitmapCreator, "previewBitmapCreator");
        Intrinsics.checkNotNullParameter(previewBitmapScaler, "previewBitmapScaler");
        Intrinsics.checkNotNullParameter(blurredBitmapProvider, "blurredBitmapProvider");
        this.f9733a = previewBitmapCreator;
        this.b = previewBitmapScaler;
        this.c = blurredBitmapProvider;
    }
}
