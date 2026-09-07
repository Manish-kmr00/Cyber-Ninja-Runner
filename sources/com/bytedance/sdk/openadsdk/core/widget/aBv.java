package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes14.dex */
public class aBv extends com.bytedance.sdk.openadsdk.core.ML.ZZv {
    private BitmapShader JG;
    private int KZx;
    private final RectF ML;
    private int Og;
    private final Matrix ZZv;
    private final Paint pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public aBv(Context context) {
        this(context, null);
    }

    public aBv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aBv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Og = 25;
        this.KZx = 25;
        this.ML = new RectF();
        Paint paint = new Paint();
        this.pA = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.ZZv = new Matrix();
    }

    public void setXRound(int i) {
        this.Og = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.KZx = i;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ML.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapPA;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.JG == null && (bitmapPA = pA(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.JG = new BitmapShader(bitmapPA, tileMode, tileMode);
            float fMax = (bitmapPA.getWidth() == getWidth() && bitmapPA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapPA.getWidth(), (getHeight() * 1.0f) / bitmapPA.getHeight());
            this.ZZv.setScale(fMax, fMax);
            this.JG.setLocalMatrix(this.ZZv);
        }
        BitmapShader bitmapShader = this.JG;
        if (bitmapShader != null) {
            this.pA.setShader(bitmapShader);
            canvas.drawRoundRect(this.ML, this.Og, this.KZx, this.pA);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.JG = null;
    }

    private Bitmap pA(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
