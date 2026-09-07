package com.bytedance.sdk.component.adexpress.JG;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes4.dex */
public class SD extends BF {
    private AnimatorSet KZx;
    private View Og;
    private TextView pA;

    @Override // com.bytedance.sdk.component.adexpress.JG.BF, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    protected void pA(Context context) {
    }

    public SD(Context context) {
        super(context);
        this.KZx = new AnimatorSet();
        Og(context);
    }

    private void Og(Context context) {
        View viewPA = com.bytedance.sdk.component.adexpress.KZx.pA.pA(context);
        this.Og = viewPA;
        addView(viewPA);
        setClipChildren(false);
        this.pA = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.pA == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.pA.setText(str);
    }

    private void ZZv() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Og, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Og, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.KZx.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.KZx.setDuration(1000L);
        this.KZx.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    public void pA() {
        ZZv();
    }

    @Override // com.bytedance.sdk.component.adexpress.JG.BF
    public void Og() {
        this.KZx.cancel();
    }
}
