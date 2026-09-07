package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class TX extends FrameLayout {
    private AnimatorSet Bzk;
    private AnimatorSet JG;
    private ImageView KZx;
    private TextView ML;
    private ImageView Og;
    private AnimatorSet SD;
    private ImageView ZZv;
    private AnimatorSet omh;
    private Context pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public TX(Context context) {
        super(context);
        this.JG = new AnimatorSet();
        this.SD = new AnimatorSet();
        this.omh = new AnimatorSet();
        this.Bzk = new AnimatorSet();
        this.pA = context;
        KZx();
    }

    private void KZx() {
        ImageView imageView = new ImageView(this.pA);
        this.ZZv = imageView;
        imageView.setBackgroundResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 30.0f);
        addView(this.ZZv, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.pA);
        this.KZx = imageView2;
        imageView2.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 50.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 30.0f);
        addView(this.KZx, layoutParams2);
        ImageView imageView3 = new ImageView(this.pA);
        this.Og = imageView3;
        imageView3.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 30.0f);
        addView(this.Og, layoutParams3);
        TextView textView = new TextView(this.pA);
        this.ML = textView;
        textView.setTextColor(-1);
        this.ML.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ML, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.TX.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) TX.this.Og.getLayoutParams();
                layoutParams5.topMargin = (int) ((TX.this.KZx.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(TX.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-TX.this.KZx.getMeasuredWidth()) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(TX.this.pA, 30.0f));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                TX.this.Og.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) TX.this.ZZv.getLayoutParams();
                layoutParams6.topMargin = (int) ((TX.this.KZx.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(TX.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((TX.this.KZx.getMeasuredWidth() / 2.0f) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(TX.this.pA, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                TX.this.ZZv.setLayoutParams(layoutParams6);
            }
        });
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Og, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.KZx, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.KZx, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ZZv, "alpha", 0.0f, 1.0f);
        this.omh.setDuration(300L);
        this.omh.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.Og, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.JG.TX.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) TX.this.ZZv.getLayoutParams();
                layoutParams.width = num.intValue();
                TX.this.ZZv.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.KZx, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.Bzk.setDuration(1500L);
        this.Bzk.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.Og, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.ZZv, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.KZx, "alpha", 1.0f, 0.0f);
        this.SD.setDuration(50L);
        this.SD.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.JG.playSequentially(this.omh, this.Bzk, this.SD);
    }

    public void pA() {
        ZZv();
        this.JG.start();
        this.JG.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.JG.TX.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                TX.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.TX.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TX.this.JG.start();
                    }
                }, 200L);
            }
        });
    }

    public void Og() {
        try {
            AnimatorSet animatorSet = this.JG;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.omh;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.Bzk;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.SD;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.ML.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
