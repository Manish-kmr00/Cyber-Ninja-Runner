package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class XT extends View {
    private Animator.AnimatorListener Bzk;
    private long JG;
    private ValueAnimator KZx;
    private Paint ML;
    private float Og;
    private float SD;
    private int SGo;
    private ValueAnimator ZZv;
    private float omh;
    private float pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public XT(Context context, int i) {
        super(context);
        this.JG = 300L;
        this.SD = 0.0f;
        this.SGo = i;
        pA();
    }

    public void pA() {
        Paint paint = new Paint(1);
        this.ML = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ML.setColor(this.SGo);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pA = i / 2.0f;
        this.Og = i2 / 2.0f;
        this.omh = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.pA, this.Og, this.SD, this.ML);
    }

    public void Og() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.omh);
        this.KZx = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.JG);
        this.KZx.setInterpolator(new LinearInterpolator());
        this.KZx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.JG.XT.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XT.this.SD = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                XT.this.invalidate();
            }
        });
        this.KZx.start();
    }

    public void KZx() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.omh, 0.0f);
        this.ZZv = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.JG);
        this.ZZv.setInterpolator(new LinearInterpolator());
        this.ZZv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.JG.XT.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XT.this.SD = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                XT.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.Bzk;
        if (animatorListener != null) {
            this.ZZv.addListener(animatorListener);
        }
        this.ZZv.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.Bzk = animatorListener;
    }
}
