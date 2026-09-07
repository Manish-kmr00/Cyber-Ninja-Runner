package com.bytedance.sdk.component.adexpress.JG;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class yFO extends LinearLayout {
    private int BSW;
    private int Bzk;
    private TextView JG;
    private ImageView KZx;
    private TextView ML;
    private TextView Og;
    private pA SD;
    private int SGo;
    private JSONObject WV;
    private com.bytedance.sdk.component.utils.vZF ZZv;
    private LinearLayout omh;
    private TextView pA;

    public interface pA {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public yFO(Context context, View view, int i, int i2, int i3, JSONObject jSONObject) {
        super(context);
        this.Bzk = i;
        this.SGo = i2;
        this.BSW = i3;
        this.WV = jSONObject;
        pA(context, view);
    }

    protected void pA(Context context, View view) {
        addView(view);
        this.omh = (LinearLayout) findViewById(2097610727);
        this.KZx = (ImageView) findViewById(2097610725);
        this.pA = (TextView) findViewById(2097610724);
        this.Og = (TextView) findViewById(2097610726);
        this.ML = (TextView) findViewById(2097610723);
        this.JG = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.omh.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ML.setVisibility(8);
            this.JG.setVisibility(8);
        } else {
            this.ML.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.omh;
    }

    public void setOnShakeViewListener(pA pAVar) {
        this.SD = pAVar;
    }

    public void pA() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.JG.yFO$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (yFO.this.KZx != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new Og(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.JG.yFO.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        yFO.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.JG.yFO.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                yFO.this.KZx.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                yFO.this.KZx.startAnimation(rotateAnimation);
            }
        }
    }

    private static class Og implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.25f) {
                return (f * (-2.0f)) + 0.5f;
            }
            if (f <= 0.5f) {
                return (f * 4.0f) - 1.0f;
            }
            return f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private Og() {
        }

        /* synthetic */ Og(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.ZZv == null) {
                this.ZZv = new com.bytedance.sdk.component.utils.vZF(getContext().getApplicationContext(), 1);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.JG.yFO.2
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
