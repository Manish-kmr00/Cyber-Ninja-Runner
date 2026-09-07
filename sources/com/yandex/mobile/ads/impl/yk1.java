package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes11.dex */
public final class yk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zk f10747a;

    public final Bitmap a(Bitmap bitmap, uj0 imageValue) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || imageValue.g() == 0 || imageValue.a() == 0) {
            return bitmap;
        }
        if (imageValue.a() * bitmap.getWidth() == bitmap.getHeight() * imageValue.g()) {
            return bitmap;
        }
        this.f10747a.getClass();
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        yy1 size = new yy1(bitmap.getWidth(), bitmap.getHeight());
        if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && imageValue.g() != 0 && imageValue.a() != 0) {
            Iterator<Integer> it = new IntRange(bitmap.getWidth(), Math.max(bitmap.getWidth(), Math.min(100, (imageValue.g() * 100) / imageValue.a()))).iterator();
            double d = 1.0d;
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                if ((imageValue.a() * iNextInt) % imageValue.g() == 0) {
                    size = new yy1(iNextInt, (imageValue.a() * iNextInt) / imageValue.g());
                    break;
                }
                double dA = ((double) (imageValue.a() * iNextInt)) / ((double) imageValue.g());
                int iRoundToInt = MathKt.roundToInt(dA);
                double dAbs = Math.abs(((double) iRoundToInt) - dA) / dA;
                if (dAbs < d) {
                    size = new yy1(iNextInt, iRoundToInt);
                    d = dAbs;
                }
            }
        }
        yy1 yy1Var = new yy1(bitmap.getWidth(), bitmap.getHeight());
        Intrinsics.checkNotNullParameter(yy1Var, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        yy1 yy1Var2 = (yy1) ComparisonsKt.maxOf(new yy1(size.b(), (yy1Var.a() * size.b()) / yy1Var.b()), new yy1((yy1Var.b() * size.a()) / yy1Var.a(), size.a()));
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, yy1Var2.b(), yy1Var2.a(), false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap, (bitmapCreateScaledBitmap.getWidth() - size.b()) / 2, (bitmapCreateScaledBitmap.getHeight() - size.a()) / 2, size.b(), size.a(), (Matrix) null, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public /* synthetic */ yk1() {
        this(new zk());
    }

    public yk1(zk bestSizeForScalePreviewCalculator) {
        Intrinsics.checkNotNullParameter(bestSizeForScalePreviewCalculator, "bestSizeForScalePreviewCalculator");
        this.f10747a = bestSizeForScalePreviewCalculator;
    }
}
