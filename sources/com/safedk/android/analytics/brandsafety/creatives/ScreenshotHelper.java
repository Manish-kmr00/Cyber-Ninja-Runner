package com.safedk.android.analytics.brandsafety.creatives;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.safedk.android.SafeDK;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes10.dex */
public class ScreenshotHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8058a = "ScreenshotHelper";
    private static final ScheduledExecutorService b = Executors.newScheduledThreadPool(1);

    @TargetApi(26)
    public static class DefaultOnPixelCopyFinishedListener implements PixelCopy.OnPixelCopyFinishedListener {
        final Activity activity;
        com.safedk.android.analytics.brandsafety.c adInfo;
        Bitmap bitmap;

        private DefaultOnPixelCopyFinishedListener(Bitmap bitmap, com.safedk.android.analytics.brandsafety.c adInfo, Activity activity) {
            this.bitmap = bitmap;
            this.adInfo = adInfo;
            this.activity = activity;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int copyResult) {
            if (copyResult == 0 && this.adInfo != null) {
                com.safedk.android.analytics.brandsafety.a aVarA = SafeDK.getInstance().a(this.adInfo.p);
                if (aVarA != null) {
                    Logger.d(ScreenshotHelper.f8058a, "PC finished - Calling " + this.adInfo.p + " finder handleScreenshotCompleted");
                    aVarA.a(this.bitmap, this.adInfo);
                    return;
                }
                return;
            }
            Logger.d(ScreenshotHelper.f8058a, "PC finished NOT successfully. result= " + copyResult);
        }
    }

    @TargetApi(26)
    public static class ImprovedOnPixelCopyFinishedListener implements PixelCopy.OnPixelCopyFinishedListener {
        private static int surfaceViewCount;
        private final com.safedk.android.analytics.brandsafety.c adInfo;
        private Bitmap bitmap;
        private final Object onPixelCopyFinishedLock;
        private final float scalingFactor;
        private final Bitmap topViewBitmap;
        private final View view;

        private ImprovedOnPixelCopyFinishedListener(Bitmap bitmap, com.safedk.android.analytics.brandsafety.c adInfo, View view, float scalingFactor, Bitmap topViewBitmap) {
            this.onPixelCopyFinishedLock = new Object();
            this.bitmap = bitmap;
            this.adInfo = adInfo;
            this.view = view;
            this.scalingFactor = scalingFactor;
            this.topViewBitmap = topViewBitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int copyResult) {
            if (this.adInfo == null || this.bitmap == null) {
                Logger.d(ScreenshotHelper.f8058a, "PC finished successfully. adInfo: " + this.adInfo + ", bitmap: " + this.bitmap);
                return;
            }
            synchronized (this.onPixelCopyFinishedLock) {
                try {
                    com.safedk.android.analytics.brandsafety.a aVarA = SafeDK.getInstance().a(this.adInfo.p);
                    if (aVarA != null) {
                        if (copyResult == 0) {
                            if (this.topViewBitmap == null) {
                                surfaceViewCount = handleSurfaceViews(this.view, this.bitmap);
                            } else {
                                surfaceViewCount--;
                                ScreenshotHelper.b.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.creatives.ScreenshotHelper.ImprovedOnPixelCopyFinishedListener.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ImprovedOnPixelCopyFinishedListener.this.combineSurfaceViewAndTopViewBitmaps();
                                    }
                                });
                            }
                            Logger.d(ScreenshotHelper.f8058a, "PC finished successfully. surface view count: " + surfaceViewCount + ", bitmap: " + this.bitmap.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.bitmap.getHeight());
                        } else {
                            surfaceViewCount--;
                            Logger.d(ScreenshotHelper.f8058a, "PC finished NOT successfully. result= " + copyResult + ", surface view count: " + surfaceViewCount);
                        }
                        if (surfaceViewCount <= 0) {
                            surfaceViewCount = 0;
                            scaleBitmap();
                            Logger.d(ScreenshotHelper.f8058a, "PC finished - Calling " + this.adInfo.p + " finder handleScreenshotCompleted");
                            aVarA.a(this.bitmap, this.adInfo);
                        }
                    }
                } catch (Throwable th) {
                    Logger.d(ScreenshotHelper.f8058a, "PC finished - throwable on request: ", th);
                }
            }
        }

        private int handleSurfaceViews(View topView, Bitmap topViewBitmap) {
            if (!(topView instanceof ViewGroup)) {
                return 0;
            }
            ViewGroup viewGroup = (ViewGroup) topView;
            int iHandleSurfaceViews = 0;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof SurfaceView) {
                    Logger.d(ScreenshotHelper.f8058a, "handle SV - found: " + childAt);
                    iHandleSurfaceViews++;
                    ScreenshotHelper.a(this.adInfo, (SurfaceView) childAt, this.scalingFactor, topViewBitmap);
                } else if (childAt instanceof ViewGroup) {
                    iHandleSurfaceViews += handleSurfaceViews(childAt, topViewBitmap);
                }
            }
            return iHandleSurfaceViews;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void combineSurfaceViewAndTopViewBitmaps() {
            Logger.d(ScreenshotHelper.f8058a, "process screenshot, combine bitmap (" + this.bitmap.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.bitmap.getHeight() + ") with bitmap (" + this.topViewBitmap.getWidth() + VastAttributes.HORIZONTAL_POSITION + this.topViewBitmap.getHeight() + ")");
            Canvas canvas = new Canvas(this.topViewBitmap);
            int[] iArr = new int[2];
            this.view.getLocationInWindow(iArr);
            canvas.drawBitmap(this.bitmap, (Rect) null, new Rect(iArr[0], iArr[1], iArr[0] + this.view.getWidth(), iArr[1] + this.view.getHeight()), (Paint) null);
        }

        private void scaleBitmap() {
            Bitmap bitmap = this.topViewBitmap != null ? this.topViewBitmap : this.bitmap;
            Pair<Bitmap, Float> pairA = ScreenshotHelper.a(bitmap.getWidth(), bitmap.getHeight(), this.scalingFactor);
            this.bitmap = (Bitmap) pairA.first;
            float fFloatValue = ((Float) pairA.second).floatValue();
            Canvas canvas = new Canvas(this.bitmap);
            canvas.scale(1.0f / fFloatValue, 1.0f / fFloatValue);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public static Bitmap a(View view, int i, com.safedk.android.analytics.brandsafety.c cVar) {
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            Logger.d(f8058a, "Cannot save view to bitmap! view: " + view);
            return null;
        }
        Pair<Bitmap, Float> pairA = a(view, i);
        Bitmap bitmap = (Bitmap) pairA.first;
        float fFloatValue = ((Float) pairA.second).floatValue();
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            canvas.scale(1.0f / fFloatValue, 1.0f / fFloatValue);
            try {
                view.draw(canvas);
                return bitmap;
            } catch (IllegalArgumentException e) {
                if (cVar != null) {
                    Logger.d(f8058a, "take screenshot - could not draw bit map. ad has hardware rendered view: " + cVar);
                    cVar.d("image=no,husrd");
                    return null;
                }
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Pair<Bitmap, Float> a(float f, float f2, float f3) {
        if (f3 > 0.0f) {
            f /= f3;
            f2 /= f3;
            Logger.d(f8058a, "create bitmap for portrait view: (" + ((int) f) + VastAttributes.HORIZONTAL_POSITION + ((int) f2) + "), scale: " + f3);
        } else {
            Logger.d(f8058a, "create bitmap: " + ((int) f) + VastAttributes.HORIZONTAL_POSITION + ((int) f2) + ", scale: 1.0");
            f3 = 1.0f;
        }
        return new Pair<>(Bitmap.createBitmap((int) f, (int) f2, Bitmap.Config.ARGB_8888), Float.valueOf(f3));
    }

    public static Pair<Bitmap, Float> a(float f, float f2, int i) {
        float f3 = 1.0f;
        if (i <= 0) {
            Logger.d(f8058a, "create bitmap: " + ((int) f) + VastAttributes.HORIZONTAL_POSITION + ((int) f2) + ", scale: 1.0");
        } else if (f > f2) {
            if (f > i) {
                f3 = f / i;
                f2 = (i * f2) / f;
                f = i;
            }
            Logger.d(f8058a, "create bitmap for landscape view: (" + ((int) f) + VastAttributes.HORIZONTAL_POSITION + ((int) f2) + "), scale: " + f3);
        } else {
            if (f2 > i) {
                f3 = f2 / i;
                f = (i * f) / f2;
                f2 = i;
            }
            Logger.d(f8058a, "create bitmap for portrait view: (" + ((int) f) + VastAttributes.HORIZONTAL_POSITION + ((int) f2) + "), scale: " + f3);
        }
        return new Pair<>(Bitmap.createBitmap((int) f, (int) f2, Bitmap.Config.ARGB_8888), Float.valueOf(f3));
    }

    private static Pair<Bitmap, Float> a(View view, int i) {
        Logger.d(f8058a, "create bitmap of view " + view);
        return a(view.getWidth(), view.getHeight(), i);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @TargetApi(26)
    public static void a(Activity activity, com.safedk.android.analytics.brandsafety.c cVar, View view, float f) {
        PixelCopy.OnPixelCopyFinishedListener improvedOnPixelCopyFinishedListener;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            Logger.d(f8058a, "Cannot save view to bitmap! view: " + view);
            return;
        }
        try {
            boolean z = CreativeInfoManager.a(cVar.c(), AdNetworkConfiguration.SHOULD_CAPTURE_SURFACE_VIEW_WHEN_USING_PIXELCOPY, false) && SafeDK.getInstance().O();
            Bitmap bitmap = (Bitmap) a(view.getWidth(), view.getHeight(), z ? -1.0f : f).first;
            if (activity != null && bitmap != null) {
                DefaultOnPixelCopyFinishedListener defaultOnPixelCopyFinishedListener = new DefaultOnPixelCopyFinishedListener(bitmap, cVar, activity);
                if (z) {
                    Logger.d(f8058a, "take screenshot using PC - support improved capturing");
                    improvedOnPixelCopyFinishedListener = new ImprovedOnPixelCopyFinishedListener(bitmap, cVar, view, f, null);
                } else {
                    improvedOnPixelCopyFinishedListener = defaultOnPixelCopyFinishedListener;
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
                Logger.d(f8058a, "take screenshot using PC - window attributes : " + (activity.getWindow() != null ? activity.getWindow().getAttributes() : "") + ", Decor View : " + (activity.getWindow() != null ? activity.getWindow().getDecorView() : "") + ", rect : " + rect + ", bitmap : " + bitmap.getHeight());
                PixelCopy.request(activity.getWindow(), rect, bitmap, improvedOnPixelCopyFinishedListener, new Handler(Looper.getMainLooper()));
                return;
            }
            Logger.d(f8058a, "take screenshot using PC - OS API version too low : " + Build.VERSION.SDK_INT + ", exiting");
        } catch (Throwable th) {
            Logger.d(f8058a, "take screenshot using PC - throwable on request: " + th);
        }
    }

    public static void a(com.safedk.android.analytics.brandsafety.c cVar, SurfaceView surfaceView, float f, Bitmap bitmap) {
        if (surfaceView == null || surfaceView.getWidth() <= 0 || surfaceView.getHeight() <= 0) {
            Logger.d(f8058a, "Cannot save view to bitmap! view: " + surfaceView);
            return;
        }
        try {
            Bitmap bitmap2 = (Bitmap) a(surfaceView, 0).first;
            if (bitmap2 != null) {
                if (a()) {
                    Logger.d(f8058a, "take screenshot using PC - surface view : " + surfaceView + ", bitmap : " + bitmap2.getHeight());
                    PixelCopy.request(surfaceView, bitmap2, new ImprovedOnPixelCopyFinishedListener(bitmap2, cVar, surfaceView, f, bitmap), new Handler(Looper.getMainLooper()));
                } else {
                    Logger.d(f8058a, "take screenshot using PC - OS API version too low : " + Build.VERSION.SDK_INT + ", exiting");
                }
            }
        } catch (Throwable th) {
            Logger.d(f8058a, "take screenshot using PC - throwable on PC request: " + th);
        }
    }
}
