package net.pubnative.lite.sdk.vpaid.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes11.dex */
public class ImageUtils {
    private static final String TAG = "ImageUtils";

    public static void setScaledImage(final ImageView imageView, final String str) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: net.pubnative.lite.sdk.vpaid.utils.ImageUtils.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                Bitmap bitmapDecodeSampledBitmap = ImageUtils.decodeSampledBitmap(str, imageView.getMeasuredWidth(), measuredHeight);
                if (bitmapDecodeSampledBitmap == null) {
                    return true;
                }
                imageView.setImageBitmap(bitmapDecodeSampledBitmap);
                return true;
            }
        });
    }

    public static void setScaledImage(final ImageView imageView, final Bitmap bitmap) {
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: net.pubnative.lite.sdk.vpaid.utils.ImageUtils.2
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = imageView.getMeasuredHeight();
                Bitmap bitmapDecodeSampledBitmap = ImageUtils.decodeSampledBitmap(bitmap, imageView.getMeasuredWidth(), measuredHeight);
                if (bitmapDecodeSampledBitmap == null) {
                    return true;
                }
                imageView.setImageBitmap(bitmapDecodeSampledBitmap);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap decodeSampledBitmap(String str, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateInSampleSize(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError | RuntimeException e) {
            HyBid.reportException(e);
            return decodeFile(new File(str), i, i2);
        }
    }

    public static Bitmap decodeFile(File file, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            options.inDither = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            if (options.outWidth != 0 && options.outHeight != 0) {
                while ((options.outWidth / i3) / 2 >= i && (options.outHeight / i3) / 2 >= i2) {
                    i3 *= 2;
                }
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i3;
            return BitmapFactory.decodeStream(new FileInputStream(file), null, options2);
        } catch (FileNotFoundException e) {
            HyBid.reportException((Exception) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap decodeSampledBitmap(Bitmap bitmap, int i, int i2) {
        try {
            int iCalculateInSampleSize = calculateInSampleSize(bitmap.getWidth(), bitmap.getHeight(), i, i2);
            return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / iCalculateInSampleSize, bitmap.getHeight() / iCalculateInSampleSize, false);
        } catch (RuntimeException e) {
            HyBid.reportException((Exception) e);
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        return calculateInSampleSize(options.outWidth, options.outHeight, i, i2);
    }

    private static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
