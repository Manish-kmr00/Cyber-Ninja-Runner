package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
public final class xl {
    public static Bitmap a(Bitmap originalBitmap, double d) {
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        try {
            return b(originalBitmap, d);
        } catch (Throwable unused) {
            return originalBitmap;
        }
    }

    private static Bitmap b(Bitmap bitmap, double d) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, MathKt.roundToInt(((double) bitmap.getWidth()) * d), MathKt.roundToInt(((double) bitmap.getHeight()) * d), false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        int i = 1;
        Bitmap bitmapCopy = bitmapCreateScaledBitmap.copy(bitmapCreateScaledBitmap.getConfig(), true);
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[RangesKt.coerceAtLeast(width, height)];
        int[] iArr6 = new int[1024];
        for (int i5 = 0; i5 < 1024; i5++) {
            iArr6[i5] = i5 / 4;
        }
        int[][] iArr7 = new int[3][];
        for (int i6 = 0; i6 < 3; i6++) {
            iArr7[i6] = new int[3];
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < height) {
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i10 <= i) {
                Bitmap bitmap2 = bitmapCopy;
                int i20 = iArr[RangesKt.coerceAtMost(i3, RangesKt.coerceAtLeast(i10, 0)) + i8];
                int i21 = i10 + 1;
                int[] iArr8 = iArr7[i21];
                iArr8[0] = (i20 & 16711680) >> 16;
                iArr8[1] = (i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i20 & 255;
                int iAbs = 2 - StrictMath.abs(i10);
                int i22 = iArr8[0];
                i11 = (i22 * iAbs) + i11;
                int i23 = iArr8[1];
                i12 = (i23 * iAbs) + i12;
                int i24 = iArr8[2];
                i13 = (iAbs * i24) + i13;
                if (i10 > 0) {
                    i19 += i22;
                    i18 += i23;
                    i17 += i24;
                } else {
                    i16 += i22;
                    i15 += i23;
                    i14 += i24;
                }
                bitmapCopy = bitmap2;
                i10 = i21;
                i = 1;
            }
            Bitmap bitmap3 = bitmapCopy;
            int i25 = 0;
            int i26 = 1;
            while (i25 < width) {
                iArr2[i8] = iArr6[i11];
                iArr3[i8] = iArr6[i12];
                iArr4[i8] = iArr6[i13];
                int i27 = i11 - i16;
                int i28 = i12 - i15;
                int i29 = i13 - i14;
                int[] iArr9 = iArr7[(i26 + 2) % 3];
                int i30 = i16 - iArr9[0];
                int i31 = i15 - iArr9[1];
                int i32 = i14 - iArr9[2];
                if (i7 == 0) {
                    iArr5[i25] = Math.min(i25 + 2, i3);
                }
                int i33 = iArr[i9 + iArr5[i25]];
                int i34 = (i33 & 16711680) >> 16;
                iArr9[0] = i34;
                int i35 = (i33 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i35;
                int i36 = i33 & 255;
                iArr9[2] = i36;
                int i37 = i19 + i34;
                int i38 = i18 + i35;
                int i39 = i17 + i36;
                i11 = i27 + i37;
                i12 = i28 + i38;
                i13 = i29 + i39;
                i26 = (i26 + 1) % 3;
                int[] iArr10 = iArr7[i26 % 3];
                int i40 = iArr10[0];
                i16 = i30 + i40;
                int i41 = iArr10[1];
                i15 = i31 + i41;
                int i42 = iArr10[2];
                i14 = i32 + i42;
                i19 = i37 - i40;
                i18 = i38 - i41;
                i17 = i39 - i42;
                i8++;
                i25++;
                iArr6 = iArr6;
            }
            i9 += width;
            i7++;
            bitmapCopy = bitmap3;
            i = 1;
        }
        Bitmap bitmap4 = bitmapCopy;
        int[] iArr11 = iArr6;
        int i43 = 0;
        while (i43 < width) {
            int[] iArr12 = iArr5;
            int i44 = height;
            int[] iArr13 = iArr;
            int i45 = -1;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = width * (-1);
            int i55 = 0;
            for (int i56 = 1; i45 <= i56; i56 = 1) {
                int iMax = Math.max(0, i54) + i43;
                int i57 = i45 + 1;
                int[] iArr14 = iArr7[i57];
                iArr14[0] = iArr2[iMax];
                iArr14[1] = iArr3[iMax];
                iArr14[2] = iArr4[iMax];
                int iAbs2 = 2 - StrictMath.abs(i45);
                i55 = (iArr2[iMax] * iAbs2) + i55;
                i46 = (iArr3[iMax] * iAbs2) + i46;
                i47 = (iArr4[iMax] * iAbs2) + i47;
                if (i45 > 0) {
                    i53 += iArr14[0];
                    i52 += iArr14[1];
                    i51 += iArr14[2];
                } else {
                    i50 += iArr14[0];
                    i49 += iArr14[1];
                    i48 += iArr14[2];
                }
                if (i45 < i4) {
                    i54 += width;
                }
                i45 = i57;
            }
            int i58 = i43;
            int i59 = i47;
            int i60 = i44;
            int i61 = 0;
            int i62 = 1;
            while (i61 < i60) {
                iArr13[i58] = (iArr13[i58] & ViewCompat.MEASURED_STATE_MASK) | (iArr11[i55] << 16) | (iArr11[i46] << 8) | iArr11[i59];
                int i63 = i55 - i50;
                int i64 = i46 - i49;
                int i65 = i59 - i48;
                int[] iArr15 = iArr7[(i62 + 2) % 3];
                int i66 = i50 - iArr15[0];
                int i67 = i49 - iArr15[1];
                int i68 = i48 - iArr15[2];
                if (i43 == 0) {
                    iArr12[i61] = Math.min(i61 + 2, i4) * width;
                }
                int i69 = iArr12[i61] + i43;
                int i70 = iArr2[i69];
                iArr15[0] = i70;
                int i71 = iArr3[i69];
                iArr15[1] = i71;
                int i72 = iArr4[i69];
                iArr15[2] = i72;
                int i73 = i53 + i70;
                int i74 = i52 + i71;
                int i75 = i51 + i72;
                i55 = i63 + i73;
                i46 = i64 + i74;
                i59 = i65 + i75;
                i62 = (i62 + 1) % 3;
                int[] iArr16 = iArr7[i62];
                int i76 = iArr16[0];
                i50 = i66 + i76;
                int i77 = iArr16[1];
                i49 = i67 + i77;
                int i78 = iArr16[2];
                i48 = i68 + i78;
                i53 = i73 - i76;
                i52 = i74 - i77;
                i51 = i75 - i78;
                i58 += width;
                i61++;
                i60 = i60;
            }
            i43++;
            iArr5 = iArr12;
            iArr = iArr13;
            height = i60;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        Intrinsics.checkNotNull(bitmap4);
        return bitmap4;
    }
}
