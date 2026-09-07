package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class BF extends RelativeLayout {
    private int BSW;
    private AnimatorSet Bzk;
    private AnimatorSet JG;
    private ImageView KZx;
    private TextView ML;
    private ImageView Og;
    private AnimatorSet SD;
    private String SGo;
    private TextView ZZv;
    private AnimatorSet omh;
    private ImageView pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public BF(Context context) {
        super(context);
        this.JG = new AnimatorSet();
        this.SD = new AnimatorSet();
        this.omh = new AnimatorSet();
        this.Bzk = new AnimatorSet();
        this.BSW = 100;
        pA(context);
    }

    public BF(Context context, String str) {
        super(context);
        this.JG = new AnimatorSet();
        this.SD = new AnimatorSet();
        this.omh = new AnimatorSet();
        this.Bzk = new AnimatorSet();
        this.BSW = 100;
        setClipChildren(false);
        this.SGo = str;
        pA(context);
    }

    protected void pA(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.ZZv.pA();
        }
        if ("5".equals(this.SGo)) {
            addView(com.bytedance.sdk.component.adexpress.KZx.pA.JG(context));
            this.BSW = (int) (((double) this.BSW) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.KZx.pA.ML(context));
        }
        this.pA = (ImageView) findViewById(2097610734);
        this.Og = (ImageView) findViewById(2097610735);
        this.ZZv = (TextView) findViewById(2097610730);
        this.KZx = (ImageView) findViewById(2097610733);
        this.ML = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.JG;
    }

    public void pA() {
        KZx();
        this.JG.start();
        this.JG.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.JG.BF.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BF.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.BF.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BF.this.JG.start();
                    }
                }, 200L);
            }
        });
    }

    public void KZx() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pA, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pA, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.pA, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), -this.BSW));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), this.BSW));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.JG.BF.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (BF.this.KZx != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BF.this.KZx.getLayoutParams();
                    layoutParams.height = num.intValue();
                    BF.this.KZx.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.KZx, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.KZx, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.Og, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.Og, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.Og, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.Og, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.Og, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), -this.BSW));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.SD.setDuration(50L);
        this.Bzk.setDuration(1500L);
        this.omh.setDuration(50L);
        this.SD.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.omh.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.Bzk.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.JG.playSequentially(this.omh, this.Bzk, this.SD);
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
            AnimatorSet animatorSet3 = this.SD;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.Bzk;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.ZZv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ML != null) {
            if (TextUtils.isEmpty(str)) {
                this.ML.setText("");
            } else {
                this.ML.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Og();
    }
}
