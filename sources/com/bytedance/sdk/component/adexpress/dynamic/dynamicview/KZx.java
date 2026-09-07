package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class KZx extends JG {
    ObjectAnimator Og;
    private boolean Sd;
    private Runnable TX;
    ObjectAnimator pA;
    private int vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.vZF = 0;
        this.Sd = false;
        this.TX = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.KZx.1
            @Override // java.lang.Runnable
            public void run() {
                KZx.this.pA();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        final View childAt;
        final View childAt2 = getChildAt(this.vZF);
        if (childAt2 == null) {
            return;
        }
        int i = this.vZF;
        if (i == 0) {
            this.Sd = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.vZF + 1)).getChildCount() <= 0) {
            this.Sd = true;
            childAt = getChildAt(this.vZF - 1);
            this.pA = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.SD + getChildAt(this.vZF).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.vZF + 1);
            this.pA = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.SD + getChildAt(this.vZF).getWidth())) / 2);
        }
        if (childAt == null) {
            return;
        }
        this.pA.setInterpolator(new LinearInterpolator());
        this.pA.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.KZx.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }
        });
        if (this.Sd) {
            this.Og = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.SD + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.Og = ObjectAnimator.ofFloat(childAt, "translationX", (this.SD + childAt.getWidth()) / 2, 0.0f);
        }
        this.Og.setInterpolator(new LinearInterpolator());
        this.Og.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.KZx.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
            }
        });
        this.pA.setDuration(500L);
        this.Og.setDuration(500L);
        this.pA.start();
        this.Og.start();
        if (this.Sd) {
            this.vZF--;
        } else {
            this.vZF++;
        }
        postDelayed(this.TX, 2000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.omh - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.TX, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gbA
    public void Og() {
        removeCallbacks(this.TX);
        ObjectAnimator objectAnimator = this.pA;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.pA.cancel();
        }
        ObjectAnimator objectAnimator2 = this.Og;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.Og.cancel();
        }
        super.Og();
    }
}
