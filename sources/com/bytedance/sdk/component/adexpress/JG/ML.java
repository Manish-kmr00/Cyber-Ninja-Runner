package com.bytedance.sdk.component.adexpress.JG;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class ML extends FrameLayout {
    private AnimatorSet Og;
    private ImageView pA;

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

    public ML(Context context) {
        super(context);
        KZx();
        ZZv();
    }

    private void KZx() {
        ImageView imageView = new ImageView(getContext());
        this.pA = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_white_hand"));
        int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iPA, iPA);
        layoutParams.gravity = 17;
        addView(this.pA, layoutParams);
    }

    private void ZZv() {
        this.Og = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pA, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pA, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.Og.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void pA() {
        AnimatorSet animatorSet = this.Og;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void Og() {
        AnimatorSet animatorSet = this.Og;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
