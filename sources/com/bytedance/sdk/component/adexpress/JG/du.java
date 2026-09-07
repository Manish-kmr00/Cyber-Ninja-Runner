package com.bytedance.sdk.component.adexpress.JG;

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
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes8.dex */
public class du extends ImageView {
    private int KZx;
    private int Og;
    private Matrix ZZv;
    private Paint pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public du(Context context) {
        this(context, null);
    }

    public du(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public du(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Og = 25;
        this.KZx = 25;
        Paint paint = new Paint();
        this.pA = paint;
        paint.setAntiAlias(true);
        this.pA.setFilterBitmap(true);
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

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmapPA = pA(drawable);
            if (bitmapPA != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapPA, tileMode, tileMode);
                float fMax = (bitmapPA.getWidth() == getWidth() && bitmapPA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapPA.getWidth(), (getHeight() * 1.0f) / bitmapPA.getHeight());
                this.ZZv.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.ZZv);
                this.pA.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.Og, this.KZx, this.pA);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
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
