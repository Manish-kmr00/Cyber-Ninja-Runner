package com.bytedance.sdk.openadsdk.core.ML;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class JG extends FrameLayout {
    private boolean JG;
    private Drawable KZx;
    private Drawable ML;
    private int Og;
    private ValueAnimator SD;
    private Drawable ZZv;
    private boolean omh;
    private int pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public void setProgress(int i) {
        this.Og = i;
        Drawable drawable = this.KZx;
        if (drawable != null) {
            drawable.setLevel((int) ((i * 10000.0f) / this.pA));
        }
    }

    public void setMax(int i) {
        this.pA = i;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.ZZv = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.ZZv;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                Drawable drawable3 = ((LayerDrawable) this.ZZv).getDrawable(i);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.KZx = drawable3;
                }
            }
        }
        Drawable drawable4 = this.ZZv;
        if (drawable4 instanceof RotateDrawable) {
            this.KZx = drawable4;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.ML = drawable;
        setProgressDrawable(drawable);
        if (this.JG && this.SD == null) {
            pA();
        }
    }

    public JG(Context context) {
        super(context);
        this.pA = 100;
    }

    public JG(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pA = 100;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(Bzk.pA(this, layoutParams));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.JG = true;
        if (this.ML != null) {
            pA();
        }
    }

    private void pA() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 10000);
        this.SD = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(2000L);
        this.SD.setRepeatCount(-1);
        this.SD.setInterpolator(new LinearInterpolator());
        this.SD.setRepeatMode(1);
        this.SD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ML.JG.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                JG.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.SD.start();
        setMax(10000);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.JG = false;
        ValueAnimator valueAnimator = this.SD;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.SD.removeAllUpdateListeners();
            this.SD = null;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.omh) {
                this.omh = false;
                ValueAnimator valueAnimator = this.SD;
                if (valueAnimator != null) {
                    valueAnimator.resume();
                    return;
                } else {
                    pA();
                    return;
                }
            }
            return;
        }
        if (this.SD == null || this.omh) {
            return;
        }
        this.omh = true;
        this.SD.pause();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
