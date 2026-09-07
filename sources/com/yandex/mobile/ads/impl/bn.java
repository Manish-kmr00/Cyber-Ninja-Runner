package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8520a;

    public final Bitmap a(uj0 imageValue) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        h82 h82VarC = ed1.c.a(this.f8520a).c();
        String strF = imageValue.f();
        Bitmap bitmapA = h82VarC.a(strF);
        if (bitmapA == null || bitmapA.getWidth() != 1 || bitmapA.getHeight() != 1) {
            return bitmapA;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, imageValue.g(), imageValue.a(), false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        h82VarC.a(strF, bitmapCreateScaledBitmap);
        return bitmapCreateScaledBitmap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ bn(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, applicationContext);
    }

    public bn(Context context, Context appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.f8520a = appContext;
    }
}
