package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes4.dex */
public class Sn extends FrameLayout {
    private TextView JG;
    private ZZv KZx;
    private boolean ML;
    private ImageView Og;
    private AnimatorSet ZZv;
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

    public Sn(Context context) {
        super(context);
        this.ML = true;
        this.pA = context;
        this.ZZv = new AnimatorSet();
        KZx();
        ZZv();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.Sn.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) Sn.this.Og.getLayoutParams();
                layoutParams.topMargin = ((int) ((Sn.this.KZx.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.pA, 20.0f));
                layoutParams.leftMargin = ((int) ((Sn.this.KZx.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.pA, 20.0f));
                layoutParams.bottomMargin = (int) (((-Sn.this.KZx.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-Sn.this.KZx.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(Sn.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                Sn.this.Og.setLayoutParams(layoutParams);
            }
        });
    }

    private void KZx() {
        this.KZx = new ZZv(this.pA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 20.0f);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.KZx, layoutParams);
        this.KZx.pA();
        this.Og = new ImageView(this.pA);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 80.0f));
        this.Og.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_hand"));
        addView(this.Og, layoutParams2);
        TextView textView = new TextView(this.pA);
        this.JG = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 10.0f);
        addView(this.JG, layoutParams3);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Og, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.JG.Sn.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(Sn.this.Og, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                Sn.this.Og.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (Sn.this.ML) {
                    Sn.this.KZx.pA();
                    Sn.this.KZx.setAlpha(1.0f);
                } else {
                    Sn.this.KZx.Og();
                    Sn.this.KZx.setAlpha(0.0f);
                }
                Sn sn = Sn.this;
                sn.ML = !sn.ML;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Og, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.ZZv.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.JG.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.JG.setTextColor(i);
    }

    public void pA() {
        this.ZZv.start();
    }

    public void Og() {
        AnimatorSet animatorSet = this.ZZv;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ZZv zZv = this.KZx;
        if (zZv != null) {
            zZv.Og();
        }
    }
}
