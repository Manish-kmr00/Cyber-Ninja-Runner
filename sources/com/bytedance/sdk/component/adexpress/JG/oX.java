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

/* JADX INFO: loaded from: classes8.dex */
public class oX extends FrameLayout {
    private TextView JG;
    private WQf KZx;
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

    public oX(Context context) {
        super(context);
        this.ML = true;
        this.pA = context;
        this.ZZv = new AnimatorSet();
        KZx();
        ZZv();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.oX.1
            @Override // java.lang.Runnable
            public void run() {
                int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.pA, 50.0f);
                int iPA2 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.pA, 50.0f);
                if (oX.this.KZx.getMeasuredHeight() > 0) {
                    iPA = oX.this.KZx.getMeasuredHeight();
                }
                if (oX.this.KZx.getMeasuredWidth() > 0) {
                    iPA2 = oX.this.KZx.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oX.this.Og.getLayoutParams();
                layoutParams.topMargin = ((int) ((iPA / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.pA, 40.0f));
                layoutParams.leftMargin = ((int) ((iPA2 / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.pA, 20.0f));
                layoutParams.bottomMargin = (int) (((-iPA) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iPA2) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(oX.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                oX.this.Og.setLayoutParams(layoutParams);
            }
        });
    }

    private void KZx() {
        this.KZx = new WQf(this.pA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 50.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 40.0f);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.KZx, layoutParams);
        this.Og = new ImageView(this.pA);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 78.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 78.0f));
        this.Og.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_hand"));
        addView(this.Og, layoutParams2);
        TextView textView = new TextView(this.pA);
        this.JG = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 10.0f);
        addView(this.JG, layoutParams3);
        this.JG.setVisibility(8);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Og, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.JG.oX.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(oX.this.Og, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                oX.this.Og.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (oX.this.ML) {
                    oX.this.KZx.pA();
                }
                oX oXVar = oX.this;
                oXVar.ML = !oXVar.ML;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Og, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.ZZv.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.JG.setVisibility(0);
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
        WQf wQf = this.KZx;
        if (wQf != null) {
            wQf.Og();
        }
        ImageView imageView = this.Og;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}
