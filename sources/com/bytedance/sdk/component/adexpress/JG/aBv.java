package com.bytedance.sdk.component.adexpress.JG;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class aBv extends View {
    private int JG;
    private RectF KZx;
    private ValueAnimator ML;
    private Paint Og;
    private boolean SD;
    private float ZZv;
    private Context pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public aBv(Context context) {
        super(context);
        this.JG = 1500;
        this.pA = context;
        Paint paint = new Paint();
        this.Og = paint;
        paint.setAntiAlias(true);
        this.Og.setStyle(Paint.Style.STROKE);
        this.Og.setStrokeWidth(10.0f);
        this.Og.setColor(Color.parseColor("#80FFFFFF"));
        this.KZx = new RectF();
    }

    public void pA() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ML = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.JG);
        this.ML.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.JG.aBv.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                aBv.this.ZZv = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                aBv.this.requestLayout();
            }
        });
        this.ML.start();
    }

    public void Og() {
        ValueAnimator valueAnimator = this.ML;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void KZx() {
        this.SD = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.JG = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.SD) {
            return;
        }
        canvas.drawArc(this.KZx, 270.0f, this.ZZv, false, this.Og);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.KZx.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
