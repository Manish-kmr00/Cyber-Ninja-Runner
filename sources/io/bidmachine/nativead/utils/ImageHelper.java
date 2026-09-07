package io.bidmachine.nativead.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class ImageHelper {
    private static final int MAX_IMAGE_HEIGHT = 700;
    private static final int MAX_IMAGE_WIDTH = 1200;

    public interface OnImageHelperListener {
        void onError(String str);

        void onImagePrepared(ImageView imageView, Drawable drawable);
    }

    public static int calculateReqHeight(int i) {
        if (i > 700) {
            return 700;
        }
        return i;
    }

    private static void loadImageByPath(Context context, Uri uri, ImageView imageView, OnImageHelperListener onImageHelperListener) {
        if (onImageHelperListener == null) {
            return;
        }
        if (uri == null || TextUtils.isEmpty(uri.getPath())) {
            onImageHelperListener.onError("ImagePath is invalid");
        } else if (imageView == null) {
            onImageHelperListener.onError("Target ImageView is null");
        } else {
            NativeNetworkExecutor.getInstance().execute(new ImagePreparation(context, uri, imageView, onImageHelperListener));
        }
    }

    public static int calculateReqWidth(Context context) {
        Point screenSize = Utils.getScreenSize(context);
        return Math.min(1200, Math.min(screenSize.x, screenSize.y));
    }

    public static int calculateInSamplesSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int i5 = 1;
        while (true) {
            if (i3 / i5 <= i && i4 / i5 <= i2) {
                return i5;
            }
            i5 *= 2;
        }
    }

    public static void fillImageView(Context context, ImageView imageView, Uri uri, Drawable drawable) {
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        } else {
            loadImageByPath(context, uri, imageView, new OnImageHelperListener() { // from class: io.bidmachine.nativead.utils.ImageHelper.1
                @Override // io.bidmachine.nativead.utils.ImageHelper.OnImageHelperListener
                public void onImagePrepared(ImageView imageView2, Drawable drawable2) {
                    imageView2.setImageDrawable(drawable2);
                }

                @Override // io.bidmachine.nativead.utils.ImageHelper.OnImageHelperListener
                public void onError(String str) {
                    Logger.d(str);
                }
            });
        }
    }

    private static class ImagePreparation implements Runnable {
        private final Context context;
        private Drawable image;
        private final Uri imageUri;
        private final OnImageHelperListener onImageHelperListener;
        private final WeakReference<ImageView> weakTargetImageView;

        ImagePreparation(Context context, Uri uri, ImageView imageView, OnImageHelperListener onImageHelperListener) {
            this.context = context;
            this.imageUri = uri;
            this.weakTargetImageView = new WeakReference<>(imageView);
            this.onImageHelperListener = onImageHelperListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(this.imageUri);
                try {
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    Utils.close(inputStreamOpenInputStream);
                    if (options.outWidth != 0 && options.outHeight != 0) {
                        int iCalculateReqWidth = ImageHelper.calculateReqWidth(this.context);
                        options.inSampleSize = ImageHelper.calculateInSamplesSize(options, iCalculateReqWidth, ImageHelper.calculateReqHeight(iCalculateReqWidth));
                        options.inJustDecodeBounds = false;
                        InputStream inputStreamOpenInputStream2 = this.context.getContentResolver().openInputStream(this.imageUri);
                        try {
                            this.image = new BitmapDrawable(this.context.getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options));
                            Utils.close(inputStreamOpenInputStream2);
                            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.nativead.utils.ImageHelper.ImagePreparation.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView = (ImageView) ImagePreparation.this.weakTargetImageView.get();
                                    if (imageView == null || ImagePreparation.this.image == null) {
                                        ImagePreparation.this.onImageHelperListener.onError("Target ImageView or Bitmap is invalid");
                                    } else {
                                        ImagePreparation.this.onImageHelperListener.onImagePrepared(imageView, ImagePreparation.this.image);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            Utils.close(inputStreamOpenInputStream2);
                            throw th;
                        }
                    }
                    this.onImageHelperListener.onError("Image size is (0;0)");
                } catch (Throwable th2) {
                    Utils.close(inputStreamOpenInputStream);
                    throw th2;
                }
            } catch (Throwable th3) {
                String message = th3.getMessage();
                OnImageHelperListener onImageHelperListener = this.onImageHelperListener;
                if (message == null) {
                    message = "ImagePreparation error";
                }
                onImageHelperListener.onError(message);
            }
        }
    }
}
