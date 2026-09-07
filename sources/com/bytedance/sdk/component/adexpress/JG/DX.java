package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes8.dex */
public class DX extends FrameLayout {
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

    public DX(Context context) {
        super(context);
        this.ML = true;
        this.pA = context;
        this.ZZv = new AnimatorSet();
        KZx();
        ZZv();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.DX.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) DX.this.Og.getLayoutParams();
                layoutParams.topMargin = (int) ((DX.this.KZx.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(DX.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((DX.this.KZx.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(DX.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-DX.this.KZx.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(DX.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-DX.this.KZx.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(DX.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                DX.this.Og.setLayoutParams(layoutParams);
            }
        });
    }

    private void KZx() {
        this.KZx = new WQf(this.pA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 40.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.KZx, layoutParams);
        this.Og = new ImageView(this.pA);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 62.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 62.0f));
        layoutParams2.gravity = 16;
        this.Og.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(this.pA, "tt_splash_hand"));
        addView(this.Og, layoutParams2);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Og, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.JG.DX.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(DX.this.Og, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                DX.this.Og.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (DX.this.ML) {
                    DX.this.KZx.pA();
                }
                DX dx = DX.this;
                dx.ML = !dx.ML;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Og, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ZZv.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
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
