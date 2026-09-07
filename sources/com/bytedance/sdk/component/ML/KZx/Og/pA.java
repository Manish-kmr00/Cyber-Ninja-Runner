package com.bytedance.sdk.component.ML.KZx.Og;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private final int JG;
    private final Bitmap.Config KZx;
    private int ML;
    private final int SD;
    private int ZZv;
    private final ImageView.ScaleType omh;
    public static final ImageView.ScaleType pA = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config Og = Bitmap.Config.ARGB_4444;
    private final int Bzk = 3840;
    private final int SGo = 104857600;

    public pA(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.KZx = config;
        this.ZZv = i;
        this.ML = i2;
        this.omh = scaleType;
        this.JG = i3;
        this.SD = i4;
        pA(i, i2);
    }

    static int pA(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int pA(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap pA(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.ZZv == 0 && this.ML == 0) {
            options.inPreferredConfig = this.KZx;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iPA = pA(this.ZZv, this.ML, i, i2, this.omh);
            int iPA2 = pA(this.ML, this.ZZv, i2, i, this.omh);
            options.inJustDecodeBounds = false;
            options.inSampleSize = pA(i, i2, iPA, iPA2, this.JG, this.SD);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iPA || bitmapDecodeByteArray.getHeight() > iPA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iPA, iPA2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void pA(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.ZZv = 3840;
                this.ML = (i2 * 3840) / i;
                return;
            } else {
                this.ZZv = (i * 3840) / i2;
                this.ML = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.ZZv = 3840;
            this.ML = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.ZZv = (i * 3840) / i2;
            this.ML = 3840;
        }
    }
}
