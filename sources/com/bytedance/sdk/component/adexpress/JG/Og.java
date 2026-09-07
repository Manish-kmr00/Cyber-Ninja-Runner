package com.bytedance.sdk.component.adexpress.JG;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class Og extends FrameLayout {
    private int Bzk;
    private View JG;
    private boolean KZx;
    private View ML;
    private ObjectAnimator Og;
    private ImageView SD;
    private Context SGo;
    private View ZZv;
    private int omh;
    private AnimatorSet pA;

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

    public Og(Context context, int i, int i2) {
        super(context);
        this.KZx = false;
        this.pA = new AnimatorSet();
        this.omh = i;
        this.Bzk = i2;
        this.SGo = context;
        KZx();
        ZZv();
    }

    private void KZx() {
        View view = new View(this.SGo);
        this.ZZv = view;
        view.setBackground(pA("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.omh) * 0.45d), (int) (((double) this.Bzk) * 0.45d));
        layoutParams.gravity = 17;
        this.ZZv.setLayoutParams(layoutParams);
        addView(this.ZZv);
        View view2 = new View(this.SGo);
        this.ML = view2;
        view2.setBackground(pA("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.omh) * 0.25d), (int) (((double) this.Bzk) * 0.25d));
        layoutParams2.gravity = 17;
        this.ML.setLayoutParams(layoutParams2);
        addView(this.ML);
        View view3 = new View(this.SGo);
        this.JG = view3;
        view3.setBackground(pA("#807BBEFF", "#FF7BBEFF"));
        int i = this.omh;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.JG.setLayoutParams(layoutParams3);
        addView(this.JG);
        ImageView imageView = new ImageView(this.SGo);
        this.SD = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_blue_hand"));
        this.SD.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.omh) * 0.62d), (int) (((double) this.Bzk) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.SD.setLayoutParams(layoutParams4);
        addView(this.SD);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ZZv, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ZZv, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ML, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ML, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.JG, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.JG, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.SD, Key.ROTATION, 0.0f, -20.0f, 0.0f);
        this.Og = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.pA.setDuration(1500L);
        this.pA.setInterpolator(new AccelerateDecelerateInterpolator());
        this.pA.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.pA.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.JG.Og.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (Og.this.KZx) {
                    return;
                }
                Og.this.Og.start();
                Og.this.pA.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Og.this.KZx = true;
            }
        });
    }

    private GradientDrawable pA(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void pA() {
        this.KZx = false;
        ObjectAnimator objectAnimator = this.Og;
        if (objectAnimator == null || this.pA == null) {
            return;
        }
        objectAnimator.start();
        this.pA.start();
    }

    public void Og() {
        this.KZx = true;
        ObjectAnimator objectAnimator = this.Og;
        if (objectAnimator == null || this.pA == null) {
            return;
        }
        objectAnimator.cancel();
        this.pA.cancel();
    }
}
