package com.bytedance.sdk.component.adexpress.JG;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends FrameLayout {
    private AnimatorSet JG;
    private ImageView KZx;
    private aBv ML;
    private ImageView Og;
    private TextView ZZv;
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

    public KZx(Context context) {
        super(context);
        this.JG = new AnimatorSet();
        this.pA = context;
        ML();
        JG();
    }

    private void ML() {
        FrameLayout frameLayout = new FrameLayout(this.pA);
        this.ML = new aBv(this.pA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 95.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ML, layoutParams);
        this.Og = new ImageView(this.pA);
        int iPA = com.bytedance.sdk.component.utils.du.pA(this.pA, 60.0f);
        this.Og.setImageDrawable(com.bytedance.sdk.component.adexpress.ZZv.Bzk.pA(1, null, null, new int[]{iPA, iPA}, Integer.valueOf(com.bytedance.sdk.component.utils.du.pA(this.pA, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 75.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.Og, layoutParams2);
        this.KZx = new ImageView(this.pA);
        int iPA2 = com.bytedance.sdk.component.utils.du.pA(this.pA, 50.0f);
        this.KZx.setImageDrawable(com.bytedance.sdk.component.adexpress.ZZv.Bzk.pA(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iPA2, iPA2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 63.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.pA, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.KZx, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.pA);
        this.ZZv = textView;
        textView.setTextColor(-1);
        this.ZZv.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.ZZv, layoutParams4);
    }

    private void JG() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.KZx, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.KZx, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.JG.setDuration(800L);
        this.JG.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.ZZv.setText(str);
    }

    public void pA() {
        this.JG.start();
    }

    public void Og() {
        this.JG.cancel();
    }

    public void KZx() {
        this.ML.pA();
    }

    public void ZZv() {
        this.ML.Og();
        this.ML.KZx();
    }
}
