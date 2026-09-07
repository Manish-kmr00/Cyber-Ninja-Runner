package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes12.dex */
public final class qj0 extends np1<Bitmap> {
    private static final Object y = new Object();
    private final Object s;
    private qq1.b<Bitmap> t;
    private final Bitmap.Config u;
    private final int v;
    private final int w;
    private final ImageView.ScaleType x;

    @Override // com.yandex.mobile.ads.impl.np1
    public final int g() {
        return 1;
    }

    public qj0(String str, qq1.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, qq1.a aVar) {
        super(0, str, aVar);
        this.s = new Object();
        a(new j00(2.0f, 1000, 2));
        this.t = bVar;
        this.u = config;
        this.v = i;
        this.w = i2;
        this.x = scaleType;
    }

    private qq1<Bitmap> b(tc1 tc1Var) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = tc1Var.b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.v == 0 && this.w == 0) {
            options.inPreferredConfig = this.u;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iA = a(this.v, this.w, i, i2, this.x);
            int iA2 = a(this.w, this.v, i2, i, this.x);
            options.inJustDecodeBounds = false;
            float f = 1.0f;
            while (true) {
                float f2 = 2.0f * f;
                if (f2 > Math.min(((double) i) / ((double) iA), ((double) i2) / ((double) iA2))) {
                    break;
                }
                f = f2;
            }
            options.inSampleSize = (int) f;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray == null) {
            return qq1.a(new zf1(tc1Var));
        }
        return qq1.a(bitmapDecodeByteArray, th0.a(tc1Var));
    }

    @Override // com.yandex.mobile.ads.impl.np1
    public final void a() {
        super.a();
        synchronized (this.s) {
            this.t = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final void a(Bitmap bitmap) {
        qq1.b<Bitmap> bVar;
        Bitmap bitmap2 = bitmap;
        synchronized (this.s) {
            bVar = this.t;
        }
        if (bVar != null) {
            bVar.a(bitmap2);
        }
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
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

    @Override // com.yandex.mobile.ads.impl.np1
    protected final qq1<Bitmap> a(tc1 tc1Var) {
        qq1<Bitmap> qq1VarB;
        synchronized (y) {
            try {
                try {
                    qq1VarB = b(tc1Var);
                } catch (OutOfMemoryError e) {
                    Object[] objArr = {Integer.valueOf(tc1Var.b.length), l()};
                    boolean z = li2.f9524a;
                    op0.b(objArr);
                    return qq1.a(new zf1(e));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return qq1VarB;
    }
}
