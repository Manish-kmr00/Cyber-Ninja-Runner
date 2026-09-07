package net.pubnative.lite.sdk.views.helpers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes9.dex */
public class ImageHelper {
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmapCreateBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = width;
        float f2 = height;
        float f3 = i2;
        float f4 = i3;
        if (Math.abs((f / f2) - (f3 / f4)) <= 0.2d) {
            Matrix matrix = new Matrix();
            matrix.postScale(f3 / f, f4 / f2);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            bitmap.recycle();
        } else {
            float f5 = f4 / f2;
            Matrix matrix2 = new Matrix();
            matrix2.postScale(f5, f5);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix2, false);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap2, (int) ((bitmapCreateBitmap2.getWidth() / 2.0f) - (f3 / 2.0f)), 0, i2, i3);
            bitmap.recycle();
        }
        return getRoundedCornerBitmap(bitmapCreateBitmap, i);
    }
}
