package com.bytedance.adsdk.ugeno.Bzk.ZZv;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends Drawable {
    private final RectF BSW;
    private final Paint Bzk;
    private float DX;
    private final int JG;
    private final RectF KZx;
    private final Paint ML;
    private final int SD;
    private final Matrix SGo;
    private boolean Sn;
    private Shader.TileMode WV;
    private Shader.TileMode Wx;
    private float XT;
    private final Bitmap ZZv;
    private boolean aBv;
    private final boolean[] oX;
    private final RectF omh;
    private ImageView.ScaleType vZF;
    private ColorStateList yFO;
    private final RectF pA = new RectF();
    private final RectF Og = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Og(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.KZx = rectF;
        this.omh = new RectF();
        this.SGo = new Matrix();
        this.BSW = new RectF();
        this.WV = Shader.TileMode.CLAMP;
        this.Wx = Shader.TileMode.CLAMP;
        this.Sn = true;
        this.DX = 0.0f;
        this.oX = new boolean[]{true, true, true, true};
        this.aBv = false;
        this.XT = 0.0f;
        this.yFO = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.vZF = ImageView.ScaleType.FIT_CENTER;
        this.ZZv = bitmap;
        int width = bitmap.getWidth();
        this.JG = width;
        int height = bitmap.getHeight();
        this.SD = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.ML = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.Bzk = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.yFO.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        paint2.setStrokeWidth(this.XT);
    }

    public static Og pA(Bitmap bitmap) {
        if (bitmap != null) {
            return new Og(bitmap);
        }
        return null;
    }

    public static Drawable pA(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof Og) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), pA(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap bitmapOg = Og(drawable);
        return bitmapOg != null ? new Og(bitmapOg) : drawable;
    }

    public static Bitmap Og(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.yFO.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.yFO.getColorForState(iArr, 0);
        if (this.Bzk.getColor() != colorForState) {
            this.Bzk.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Bzk.ZZv.Og$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pA = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                pA[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void pA() {
        float fWidth;
        float fHeight;
        int i = AnonymousClass1.pA[this.vZF.ordinal()];
        if (i == 1) {
            this.omh.set(this.pA);
            RectF rectF = this.omh;
            float f = this.XT;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.SGo.reset();
            this.SGo.setTranslate((int) (((this.omh.width() - this.JG) * 0.5f) + 0.5f), (int) (((this.omh.height() - this.SD) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.omh.set(this.pA);
            RectF rectF2 = this.omh;
            float f2 = this.XT;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.SGo.reset();
            float fWidth2 = 0.0f;
            if (this.JG * this.omh.height() > this.omh.width() * this.SD) {
                fWidth = this.omh.height() / this.SD;
                fHeight = 0.0f;
                fWidth2 = (this.omh.width() - (this.JG * fWidth)) * 0.5f;
            } else {
                fWidth = this.omh.width() / this.JG;
                fHeight = (this.omh.height() - (this.SD * fWidth)) * 0.5f;
            }
            this.SGo.setScale(fWidth, fWidth);
            Matrix matrix = this.SGo;
            float f3 = this.XT;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f3 / 2.0f), ((int) (fHeight + 0.5f)) + (f3 / 2.0f));
        } else if (i == 3) {
            this.SGo.reset();
            float fMin = (((float) this.JG) > this.pA.width() || ((float) this.SD) > this.pA.height()) ? Math.min(this.pA.width() / this.JG, this.pA.height() / this.SD) : 1.0f;
            float fWidth3 = (int) (((this.pA.width() - (this.JG * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.pA.height() - (this.SD * fMin)) * 0.5f) + 0.5f);
            this.SGo.setScale(fMin, fMin);
            this.SGo.postTranslate(fWidth3, fHeight2);
            this.omh.set(this.KZx);
            this.SGo.mapRect(this.omh);
            RectF rectF3 = this.omh;
            float f4 = this.XT;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.SGo.setRectToRect(this.KZx, this.omh, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.omh.set(this.KZx);
            this.SGo.setRectToRect(this.KZx, this.pA, Matrix.ScaleToFit.END);
            this.SGo.mapRect(this.omh);
            RectF rectF4 = this.omh;
            float f5 = this.XT;
            rectF4.inset(f5 / 2.0f, f5 / 2.0f);
            this.SGo.setRectToRect(this.KZx, this.omh, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.omh.set(this.KZx);
            this.SGo.setRectToRect(this.KZx, this.pA, Matrix.ScaleToFit.START);
            this.SGo.mapRect(this.omh);
            RectF rectF5 = this.omh;
            float f6 = this.XT;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.SGo.setRectToRect(this.KZx, this.omh, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.omh.set(this.KZx);
            this.SGo.setRectToRect(this.KZx, this.pA, Matrix.ScaleToFit.CENTER);
            this.SGo.mapRect(this.omh);
            RectF rectF6 = this.omh;
            float f7 = this.XT;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.SGo.setRectToRect(this.KZx, this.omh, Matrix.ScaleToFit.FILL);
        } else {
            this.omh.set(this.pA);
            RectF rectF7 = this.omh;
            float f8 = this.XT;
            rectF7.inset(f8 / 2.0f, f8 / 2.0f);
            this.SGo.reset();
            this.SGo.setRectToRect(this.KZx, this.omh, Matrix.ScaleToFit.FILL);
        }
        this.Og.set(this.omh);
        this.Sn = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.pA.set(rect);
        pA();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.Sn) {
            BitmapShader bitmapShader = new BitmapShader(this.ZZv, this.WV, this.Wx);
            if (this.WV == Shader.TileMode.CLAMP && this.Wx == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.SGo);
            }
            this.ML.setShader(bitmapShader);
            this.Sn = false;
        }
        if (this.aBv) {
            if (this.XT > 0.0f) {
                canvas.drawOval(this.Og, this.ML);
                canvas.drawOval(this.omh, this.Bzk);
                return;
            } else {
                canvas.drawOval(this.Og, this.ML);
                return;
            }
        }
        if (pA(this.oX)) {
            float f = this.DX;
            if (this.XT > 0.0f) {
                canvas.drawRoundRect(this.Og, f, f, this.ML);
                canvas.drawRoundRect(this.omh, f, f, this.Bzk);
                pA(canvas);
                Og(canvas);
                return;
            }
            canvas.drawRoundRect(this.Og, f, f, this.ML);
            pA(canvas);
            return;
        }
        canvas.drawRect(this.Og, this.ML);
        if (this.XT > 0.0f) {
            canvas.drawRect(this.omh, this.Bzk);
        }
    }

    private void pA(Canvas canvas) {
        if (Og(this.oX) || this.DX == 0.0f) {
            return;
        }
        float f = this.Og.left;
        float f2 = this.Og.top;
        float fWidth = this.Og.width() + f;
        float fHeight = this.Og.height() + f2;
        float f3 = this.DX;
        if (!this.oX[0]) {
            this.BSW.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.BSW, this.ML);
        }
        if (!this.oX[1]) {
            this.BSW.set(fWidth - f3, f2, fWidth, f3);
            canvas.drawRect(this.BSW, this.ML);
        }
        if (!this.oX[2]) {
            this.BSW.set(fWidth - f3, fHeight - f3, fWidth, fHeight);
            canvas.drawRect(this.BSW, this.ML);
        }
        if (this.oX[3]) {
            return;
        }
        this.BSW.set(f, fHeight - f3, f3 + f, fHeight);
        canvas.drawRect(this.BSW, this.ML);
    }

    private void Og(Canvas canvas) {
        if (Og(this.oX) || this.DX == 0.0f) {
            return;
        }
        float f = this.Og.left;
        float f2 = this.Og.top;
        float fWidth = f + this.Og.width();
        float fHeight = f2 + this.Og.height();
        float f3 = this.DX;
        float f4 = this.XT / 2.0f;
        if (!this.oX[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.Bzk);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.Bzk);
        }
        if (!this.oX[1]) {
            canvas.drawLine((fWidth - f3) - f4, f2, fWidth, f2, this.Bzk);
            canvas.drawLine(fWidth, f2 - f4, fWidth, f2 + f3, this.Bzk);
        }
        if (!this.oX[2]) {
            canvas.drawLine((fWidth - f3) - f4, fHeight, fWidth + f4, fHeight, this.Bzk);
            canvas.drawLine(fWidth, fHeight - f3, fWidth, fHeight, this.Bzk);
        }
        if (this.oX[3]) {
            return;
        }
        canvas.drawLine(f - f4, fHeight, f + f3, fHeight, this.Bzk);
        canvas.drawLine(f, fHeight - f3, f, fHeight, this.Bzk);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ML.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.ML.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.ML.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ML.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.ML.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.ML.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.JG;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.SD;
    }

    public Og pA(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(fFloatValue)));
            }
            this.DX = fFloatValue;
        } else {
            this.DX = 0.0f;
        }
        boolean[] zArr = this.oX;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public Og pA(float f) {
        this.XT = f;
        this.Bzk.setStrokeWidth(f);
        return this;
    }

    public Og pA(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.yFO = colorStateList;
        this.Bzk.setColor(colorStateList.getColorForState(getState(), ViewCompat.MEASURED_STATE_MASK));
        return this;
    }

    public Og pA(boolean z) {
        this.aBv = z;
        return this;
    }

    public Og pA(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.vZF != scaleType) {
            this.vZF = scaleType;
            pA();
        }
        return this;
    }

    public Og pA(Shader.TileMode tileMode) {
        if (this.WV != tileMode) {
            this.WV = tileMode;
            this.Sn = true;
            invalidateSelf();
        }
        return this;
    }

    public Og Og(Shader.TileMode tileMode) {
        if (this.Wx != tileMode) {
            this.Wx = tileMode;
            this.Sn = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean pA(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean Og(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
