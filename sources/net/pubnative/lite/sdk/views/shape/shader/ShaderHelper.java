package net.pubnative.lite.sdk.views.shape.shader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import net.pubnative.lite.sdk.core.R;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ShaderHelper {
    private static final int ALPHA_MAX = 255;
    protected final Paint borderPaint;
    protected Drawable drawable;
    protected final Paint imagePaint;
    protected BitmapShader shader;
    protected int viewHeight;
    protected int viewWidth;
    protected final Matrix matrix = new Matrix();
    protected int borderColor = ViewCompat.MEASURED_STATE_MASK;
    protected int borderWidth = 0;
    protected float borderAlpha = 1.0f;
    protected boolean square = false;

    public abstract void calculate(int i, int i2, float f, float f2, float f3, float f4, float f5);

    public abstract void draw(Canvas canvas, Paint paint, Paint paint2);

    public abstract void reset();

    public ShaderHelper() {
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.imagePaint = paint2;
        paint2.setAntiAlias(true);
    }

    protected final int dpToPx(DisplayMetrics displayMetrics, int i) {
        return Math.round(i * (displayMetrics.xdpi / 160.0f));
    }

    public void init(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i, 0);
            this.borderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ShaderImageView_siBorderColor, this.borderColor);
            this.borderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ShaderImageView_siBorderWidth, this.borderWidth);
            this.borderAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.ShaderImageView_siBorderAlpha, this.borderAlpha);
            this.square = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ShaderImageView_siSquare, this.square);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.borderPaint.setColor(this.borderColor);
        this.borderPaint.setAlpha(Float.valueOf(this.borderAlpha * 255.0f).intValue());
        this.borderPaint.setStrokeWidth(this.borderWidth);
    }

    public boolean onDraw(Canvas canvas) {
        if (this.shader == null) {
            createShader();
        }
        if (this.shader == null || this.viewWidth <= 0 || this.viewHeight <= 0) {
            return false;
        }
        draw(canvas, this.imagePaint, this.borderPaint);
        return true;
    }

    public void onSizeChanged(int i, int i2) {
        if (this.viewWidth == i && this.viewHeight == i2) {
            return;
        }
        this.viewWidth = i;
        this.viewHeight = i2;
        if (isSquare()) {
            int iMin = Math.min(i, i2);
            this.viewHeight = iMin;
            this.viewWidth = iMin;
        }
        if (this.shader != null) {
            calculateDrawableSizes();
        }
    }

    public Bitmap calculateDrawableSizes() {
        float f;
        float fRound;
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                float fRound2 = Math.round(this.viewWidth - (this.borderWidth * 2.0f));
                float fRound3 = Math.round(this.viewHeight - (this.borderWidth * 2.0f));
                float f2 = width;
                float f3 = height;
                float fRound4 = 0.0f;
                if (f2 * fRound3 > fRound2 * f3) {
                    f = fRound3 / f3;
                    fRound = 0.0f;
                    fRound4 = Math.round(((fRound2 / f) - f2) / 2.0f);
                } else {
                    float f4 = fRound2 / f2;
                    f = f4;
                    fRound = Math.round(((fRound3 / f4) - f3) / 2.0f);
                }
                this.matrix.setScale(f, f);
                this.matrix.preTranslate(fRound4, fRound);
                Matrix matrix = this.matrix;
                int i = this.borderWidth;
                matrix.postTranslate(i, i);
                calculate(width, height, fRound2, fRound3, f, fRound4, fRound);
                return bitmap;
            }
        }
        reset();
        return null;
    }

    public final void onImageDrawableReset(Drawable drawable) {
        this.drawable = drawable;
        this.shader = null;
        this.imagePaint.setShader(null);
    }

    protected void createShader() {
        Bitmap bitmapCalculateDrawableSizes = calculateDrawableSizes();
        if (bitmapCalculateDrawableSizes == null || bitmapCalculateDrawableSizes.getWidth() <= 0 || bitmapCalculateDrawableSizes.getHeight() <= 0) {
            return;
        }
        BitmapShader bitmapShader = new BitmapShader(bitmapCalculateDrawableSizes, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.shader = bitmapShader;
        this.imagePaint.setShader(bitmapShader);
    }

    protected Bitmap getBitmap() {
        Drawable drawable = this.drawable;
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i) {
        this.borderColor = i;
        Paint paint = this.borderPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final void setBorderWidth(int i) {
        this.borderWidth = i;
        Paint paint = this.borderPaint;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
    }

    public final float getBorderAlpha() {
        return this.borderAlpha;
    }

    public final void setBorderAlpha(float f) {
        this.borderAlpha = f;
        Paint paint = this.borderPaint;
        if (paint != null) {
            paint.setAlpha(Float.valueOf(f * 255.0f).intValue());
        }
    }

    public final boolean isSquare() {
        return this.square;
    }

    public final void setSquare(boolean z) {
        this.square = z;
    }
}
