package sg.bigo.ads.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f13285a = 16908288;
    private static int b = 40;
    private static int c = 128;
    private static int d = 128;

    /* JADX INFO: renamed from: sg.bigo.ads.common.utils.d$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ValueCallback f13288a;
        final /* synthetic */ Bitmap b;

        AnonymousClass2(ValueCallback valueCallback, Bitmap bitmap) {
            this.f13288a = valueCallback;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f13288a.onReceiveValue(this.b);
        }
    }

    public static Bitmap a(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    public static Bitmap a(Context context, float f, int i, int i2, int i3) {
        return a(context, f, i, i2, i3, false);
    }

    public static Bitmap a(Context context, float f, int i, int i2, int i3, boolean z) {
        Drawable drawableA;
        Paint paint;
        Paint paint2;
        Context context2 = context;
        Paint paint3 = null;
        if (f <= 0.0f || (drawableA = a.a(context2, i)) == null) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) a.a(context2, i2)).getBitmap();
        Bitmap bitmapExtractAlpha = z ? bitmap.extractAlpha() : null;
        Bitmap bitmap2 = ((BitmapDrawable) drawableA).getBitmap();
        Bitmap bitmapExtractAlpha2 = z ? bitmap2.extractAlpha() : null;
        int width = bitmap2.getWidth() / 4;
        int i4 = 5;
        Bitmap bitmapA = a((bitmap2.getWidth() * 5) + (width * 4), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapA == null) {
            return null;
        }
        bitmapA.setDensity(bitmap2.getDensity());
        if (z) {
            paint = new Paint();
            paint.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
        } else {
            paint = null;
        }
        Canvas canvas = new Canvas(bitmapA);
        int i5 = 1;
        int width2 = 0;
        while (i5 <= i4) {
            if (i5 <= f) {
                if (paint != null && bitmapExtractAlpha2 != null) {
                    paint.setColor(-12303292);
                    canvas.drawBitmap(bitmapExtractAlpha2, width2, 0.0f, paint);
                }
                canvas.drawBitmap(bitmap2, width2, 0.0f, paint3);
                width2 += bitmap2.getWidth() + width;
                paint2 = paint3;
            } else {
                if (paint != null && bitmapExtractAlpha != null) {
                    paint.setColor(sg.bigo.ads.common.w.b.a(-12303292, 0.15f));
                    canvas.drawBitmap(bitmapExtractAlpha, width2, 0.0f, paint);
                }
                float f2 = width2;
                canvas.drawBitmap(bitmap, f2, 0.0f, paint3);
                if (i5 == ((int) (f + 0.5f))) {
                    Bitmap bitmap3 = ((BitmapDrawable) a.a(context2, i3)).getBitmap();
                    if (paint != null) {
                        Bitmap bitmapExtractAlpha3 = bitmap3.extractAlpha();
                        paint.setColor(-12303292);
                        canvas.drawBitmap(bitmapExtractAlpha3, f2, 0.0f, paint);
                    }
                    paint2 = null;
                    canvas.drawBitmap(bitmap3, f2, 0.0f, (Paint) null);
                } else {
                    paint2 = paint3;
                }
                width2 += bitmap.getWidth() + width;
            }
            i5++;
            paint3 = paint2;
            i4 = 5;
            context2 = context;
        }
        return bitmapA;
    }

    public static Bitmap a(Context context, Bitmap bitmap) {
        Bitmap bitmapA;
        if (bitmap != null && context != null) {
            int iRound = Math.round(bitmap.getWidth() * 0.25f);
            int iRound2 = Math.round(bitmap.getHeight() * 0.25f);
            if (iRound <= 0 || iRound2 <= 0 || (bitmapA = a(bitmap, iRound, iRound2)) == null) {
                return null;
            }
            if (bitmapA.getConfig() != Bitmap.Config.ARGB_8888) {
                bitmapA = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            }
            Bitmap bitmapB = b(bitmapA);
            sg.bigo.ads.common.c.b bVar = new sg.bigo.ads.common.c.b(context);
            if (!bVar.a(10.0f)) {
                return null;
            }
            bVar.a(bitmapA, bitmapB);
            bitmapA.recycle();
            bVar.a();
            return bitmapB;
        }
        return null;
    }

    public static Bitmap a(Resources resources, int i) {
        try {
            return BitmapFactory.decodeResource(resources, i);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmapA;
        LinearGradient linearGradient;
        float f;
        float f2;
        float f3;
        float f4;
        if (bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0 || (bitmapA = a(width, height, Bitmap.Config.ARGB_8888)) == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        int i = b;
        if (width >= height) {
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i, ViewCompat.MEASURED_SIZE_MASK, -1, Shader.TileMode.CLAMP);
            paint.setShader(linearGradient);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            f4 = 0.0f;
            f3 = width;
            canvas.drawRect(0.0f, 0.0f, f3, b, paint);
            f2 = height;
            paint2.setShader(new LinearGradient(0.0f, height - b, 0.0f, f2, -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            f = height - b;
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, i, 0.0f, ViewCompat.MEASURED_SIZE_MASK, -1, Shader.TileMode.CLAMP);
            paint.setShader(linearGradient);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            f = 0.0f;
            f2 = height;
            canvas.drawRect(0.0f, 0.0f, b, f2, paint);
            f3 = width;
            paint2.setShader(new LinearGradient(width - b, 0.0f, f3, 0.0f, -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            f4 = width - b;
        }
        canvas.drawRect(f4, f, f3, f2, paint2);
        return bitmapA;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        try {
            return Bitmap.createScaledBitmap(bitmap, i, i2, false);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    public static Bitmap a(String str) {
        sg.bigo.ads.common.c cVarB = b(str);
        if (cVarB != null) {
            return cVarB.f13132a;
        }
        return null;
    }

    public static Bitmap a(String str, Context context) {
        sg.bigo.ads.common.c cVarB;
        if (context == null || (cVarB = b(str, context)) == null) {
            return null;
        }
        return cVarB.f13132a;
    }

    private static BitmapFactory.Options a(String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return new BitmapFactory.Options();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i4 <= 0 || i5 <= 0) {
            return new BitmapFactory.Options();
        }
        if (i4 > i || i5 > i2) {
            int i6 = i4 / 2;
            int i7 = i5 / 2;
            while (true) {
                if (i6 / i3 < i && i7 / i3 < i2) {
                    break;
                }
                i3 *= 2;
            }
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i3;
        return options;
    }

    public static AnimationDrawable a(ImageView imageView, Bitmap bitmap) {
        if (imageView == null || bitmap == null) {
            return null;
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            animationDrawable.addFrame(drawable, 0);
        }
        animationDrawable.addFrame(new BitmapDrawable(imageView.getResources(), bitmap), 300);
        animationDrawable.setOneShot(true);
        animationDrawable.setEnterFadeDuration(300);
        animationDrawable.start();
        imageView.setImageDrawable(animationDrawable);
        return animationDrawable;
    }

    public static Drawable a(float f, float f2, float f3, float f4, int i, float f5, boolean[] zArr) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f2, f2, f3, f3, f4, f4}, null, null));
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(f5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        if (k.a(zArr)) {
            return shapeDrawable;
        }
        float f6 = 0.0f;
        float f7 = (zArr.length <= 0 || !zArr[0]) ? 0.0f : -f5;
        float f8 = (zArr.length < 2 || !zArr[1]) ? 0.0f : -f5;
        float f9 = (zArr.length < 3 || !zArr[2]) ? 0.0f : -f5;
        if (zArr.length >= 4 && zArr[3]) {
            f6 = -f5;
        }
        return new InsetDrawable((Drawable) shapeDrawable, (int) f7, (int) f8, (int) f9, (int) f6);
    }

    public static Drawable a(float f, float f2, float f3, float f4, int i, int i2, float f5) {
        Drawable drawableA = a(f, f2, f3, f4, (Rect) null, i);
        if (i2 == 0 || f5 <= 0.0f) {
            return drawableA;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableA, a(f, f2, f3, f4, i2, f5, (boolean[]) null)});
        layerDrawable.setId(0, f13285a);
        return layerDrawable;
    }

    public static Drawable a(float f, float f2, float f3, float f4, Rect rect, int i) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f2, f2, f3, f3, f4, f4}, null, null));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return rect == null ? shapeDrawable : new InsetDrawable((Drawable) shapeDrawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    public static void a(final Context context, final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.common.utils.d.1
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapA = d.a(context, bitmap);
                if (valueCallback != null) {
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.common.utils.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            valueCallback.onReceiveValue(bitmapA);
                        }
                    });
                }
            }
        });
    }

    public static void a(final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.common.utils.d.4
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmapA = d.a(bitmap);
                ValueCallback valueCallback2 = valueCallback;
                if (valueCallback2 != null) {
                    if (bitmapA == null) {
                        bitmapA = bitmap;
                    }
                    valueCallback2.onReceiveValue(bitmapA);
                }
            }
        });
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (sg.bigo.ads.common.n.d.b()) {
            t.a(context, "BlurBitmap() should run on Worker Thread!!");
        }
        return a(context, bitmap);
    }

    private static Bitmap b(Bitmap bitmap) {
        try {
            return Bitmap.createBitmap(bitmap);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    public static sg.bigo.ads.common.c b(String str) {
        Bitmap bitmapDecodeFile;
        BitmapFactory.Options optionsA = a(str, c, d);
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, optionsA);
        } catch (OutOfMemoryError unused) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", "decodeIcon OutOfMemoryError:size = " + optionsA.inSampleSize + ",filePath=" + str);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            return new sg.bigo.ads.common.c(bitmapDecodeFile, optionsA.outMimeType, str);
        }
        return null;
    }

    public static sg.bigo.ads.common.c b(String str, Context context) {
        Bitmap bitmapDecodeFile;
        if (context == null) {
            return null;
        }
        BitmapFactory.Options optionsA = a(str, context.getResources().getDisplayMetrics().widthPixels, e.c(context));
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, optionsA);
        } catch (OutOfMemoryError unused) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", "decodeImage OutOfMemoryError:size = " + optionsA.inSampleSize + ",filePath=" + str);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            return new sg.bigo.ads.common.c(bitmapDecodeFile, optionsA.outMimeType, str);
        }
        return null;
    }

    public static void b(final Context context, final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        if (context == null || bitmap == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.utils.d.3
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapB = d.b(context, bitmap);
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.common.utils.d.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        valueCallback.onReceiveValue(bitmapB);
                    }
                });
            }
        });
    }
}
